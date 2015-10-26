package eu.scasefp7.eclipse.storyboards.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import eu.scasefp7.eclipse.core.ontology.DynamicOntologyAPI;

/**
 * A command handler for exporting all the storyboard diagrams to the dynamic ontology.
 * 
 * @author themis
 */
public class ExportAllStoryboardsToOntologyHandler extends ProjectAwareHandler {

	/**
	 * This function is called when the user selects the menu item. It reads the selected resource(s) and populates the
	 * dynamic ontology.
	 * 
	 * @param event the event containing the information about which file was selected.
	 * @return the result of the execution which must be {@code null}.
	 */
	@SuppressWarnings("unchecked")
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			List<Object> selectionList = structuredSelection.toList();
			IProject project = getProjectOfSelectionList(selectionList);
			ArrayList<IFile> files = getFilesOfProject(project, "sbd");
			DynamicOntologyAPI ontology = new DynamicOntologyAPI(project, true);
			// Iterate over the selected files
			for (IFile file : files) {
				if (file != null) {
					instantiateOntology(file, ontology);
				}
			}
		}
		return null;
	}

	/**
	 * Instantiates the dynamic ontology given the file of a storyboard diagram.
	 * 
	 * @param file an {@link IFile} instance of a storyboard diagram.
	 * @param ontology the ontology to be instantiated.
	 */
	private void instantiateOntology(IFile file, DynamicOntologyAPI ontology) {
		try {
			String filename = file.getName();
			String diagramName = filename.substring(0, filename.lastIndexOf('.'));
			diagramName = diagramName.substring(diagramName.lastIndexOf('\\') + 1) + "_diagram";
			ontology.addActivityDiagram(diagramName);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse(file.getContents());
			Element doc = dom.getDocumentElement();
			doc.normalize();
			Node root = doc.getElementsByTagName("auth.storyboards:StoryboardDiagram").item(0);
			sbdToOwl(diagramName, ontology, root);
			ontology.close();
		} catch (ParserConfigurationException | SAXException | IOException | CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Transfers an sbd file in the dynamic ontology.
	 * 
	 * @param diagramName the name of the diagram.
	 * @param ontology the ontology instance.
	 * @param root the root node of the sbd diagram model.
	 */
	private void sbdToOwl(String diagramName, DynamicOntologyAPI ontology, Node root) {

		HashMap<String, SBDNode> ids = new HashMap<String, SBDNode>();

		NodeList nodes = root.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			SBDNode sbdnode = new SBDNode(node);

			if (sbdnode.getType() != null) {
				// Iterate over all nodes
				if (sbdnode.getType().equals("action")) {
					// Add an action node as an activity
					ontology.addActivity(sbdnode.getName());
					ontology.connectActivityDiagramToElement(diagramName, sbdnode.getName());
					String[] actionAndObject = getActionAndObject(sbdnode.getName());
					String action = actionAndObject[0];
					String object1 = actionAndObject[1];
					ontology.addActionToActivity(sbdnode.getName(), action);
					ontology.addObjectToActivity(sbdnode.getName(), object1);
					// String actiontype = sbdnode.get("type") == null ? "create" : sbdnode.get("type");
					// ontology.addActivityTypeToActivity(sbdnode.getName(), actiontype);
				} else if (sbdnode.getType().equals("startnode")) {
					// Add the start node
					ontology.addInitialActivity("StartNode");
					ontology.connectActivityDiagramToElement(diagramName, "StartNode");
					if (sbdnode.getPrecondition() != null) {
						ontology.addPreconditionToDiagram(diagramName, sbdnode.getPrecondition());
					}
				} else if (sbdnode.getType().equals("endnode")) {
					// Add the end node
					ontology.addFinalActivity("EndNode");
					ontology.connectActivityDiagramToElement(diagramName, "EndNode");
				} else if (sbdnode.getType().equals("storyboard")) {
					// Add a storyboard node as an activity
					ontology.addActivity(sbdnode.getName());
					ontology.connectActivityDiagramToElement(diagramName, sbdnode.getName());
				}
				ids.put(sbdnode.getId(), sbdnode);
			}
		}

		for (SBDNode sbdnode : ids.values()) {
			if (sbdnode.getType().equals("action")) {
				// Add the properties of the action
				ArrayList<String> propertyIds = sbdnode.getProperties();
				for (String propertyId : propertyIds) {
					SBDNode property = ids.get(propertyId);
					ontology.addPropertyToActivity(sbdnode.getName(), property.getName());
				}
			}
			if (sbdnode.getType().equals("action") || sbdnode.getType().equals("storyboard")
					|| sbdnode.getType().equals("startnode")) {
				// Add the transitions in the case of conditions
				String nextNodeId = sbdnode.getNextNode();
				String from = sbdnode.getName();
				SBDNode nextNode = ids.get(nextNodeId);
				if (nextNode.getType().equals("condition")) {
					ArrayList<SBDNode> conditionPaths = nextNode.getChildren();

					SBDNode actionOfConditionPath0 = ids.get(conditionPaths.get(0).getNextNode());
					SBDNode actionOfConditionPath1 = ids.get(conditionPaths.get(1).getNextNode());

					ontology.addTransition(from, actionOfConditionPath0.getName());
					ontology.connectActivityDiagramToTransition(diagramName, from, actionOfConditionPath0.getName());
					ontology.addConditionToTransition(conditionPaths.get(0).getName(), from,
							actionOfConditionPath0.getName());

					ontology.addTransition(from, actionOfConditionPath1.getName());
					ontology.connectActivityDiagramToTransition(diagramName, from, actionOfConditionPath1.getName());
					ontology.addConditionToTransition(conditionPaths.get(1).getName(), from,
							actionOfConditionPath1.getName());
				} else {
					// Add the transitions
					ontology.addTransition(from, nextNode.getName());
					ontology.connectActivityDiagramToTransition(diagramName, from, nextNode.getName());
				}
			}
		}
	}

	/**
	 * Extracts the action and the object of an activity.
	 * 
	 * @param activity the activity to be split.
	 * @return a string array including the action in the first position and the object in the second.
	 */
	private static String[] getActionAndObject(String activity) {
		String[] actobj = new String[2];
		String[] tempactobj = activity.split("\\s+");
		actobj[0] = tempactobj[0];
		actobj[1] = tempactobj[tempactobj.length - 1];
		return actobj;
	}

}
