package eu.scasefp7.eclipse.storyboards.handlers;

import java.util.ArrayList;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Class that holds any element of a storyboard diagram.
 * 
 * @author themis
 */
public class SBDNode {

	/**
	 * The xmi id of the element.
	 */
	String id;

	/**
	 * The name of the element.
	 */
	String name;

	/**
	 * The xml node of this element.
	 */
	Node node;

	/**
	 * The type of this element.
	 */
	String type;

	/**
	 * The children of this element, valid only for the "condition" type, that has paths as children.
	 */
	ArrayList<SBDNode> children;

	/**
	 * The annotations of the element.
	 */
	String annotations;

	/**
	 * Initializes this object, extracting its name, its type, and its children.
	 * 
	 * @param node the XML node to initialize this object.
	 */
	public SBDNode(Node node) {
		this.node = node;
		id = getValue("xmi:id");
		children = null;
		name = null;
		type = null;
		if (node != null) {
			if (node.getNodeName().equals("storyboardactions"))
				type = "action";
			else if (node.getNodeName().equals("storyboardstoryboards"))
				type = "storyboard";
			else if (node.getNodeName().equals("storyboardproperties"))
				type = "property";
			else if (node.getNodeName().equals("storyboardconditions"))
				type = "condition";
			else if (node.getNodeName().equals("storyboardstartnode"))
				type = "startnode";
			else if (node.getNodeName().equals("storyboardendnode"))
				type = "endnode";
		}
		if (type != null) {
			if (type.equals("startnode"))
				this.name = "StartNode";
			else if (type.equals("endnode"))
				this.name = "EndNode";
			else if (node != null && node.getAttributes() != null && node.getAttributes().getNamedItem("name") != null)
				this.name = node.getAttributes().getNamedItem("name").getNodeValue();
		}
		if (type != null && type.equals("condition")) {
			NodeList conditionPaths = node.getChildNodes();
			Node conditionPath1 = null;
			Node conditionPath2 = null;
			for (int i = 0; i < conditionPaths.getLength(); i++) {
				if (conditionPath1 == null) {
					if (conditionPaths.item(i).getAttributes() != null)
						conditionPath1 = conditionPaths.item(i);
				} else {
					if (conditionPaths.item(i).getAttributes() != null)
						conditionPath2 = conditionPaths.item(i);
				}
			}
			NamedNodeMap conditionPath1Attributes = conditionPath1.getAttributes();
			NamedNodeMap conditionPath2Attributes = conditionPath2.getAttributes();

			String conditionPath1Name = name + "__PATH__"
					+ conditionPath1Attributes.getNamedItem("name").getNodeValue();
			String conditionPath2Name = name + "__PATH__"
					+ conditionPath2Attributes.getNamedItem("name").getNodeValue();

			children = new ArrayList<SBDNode>();
			children.add(new SBDNode(conditionPath1, conditionPath1Name, "conditionpath"));
			children.add(new SBDNode(conditionPath2, conditionPath2Name, "conditionpath"));
		}
		if (node.getAttributes() != null && node.getAttributes().getNamedItem("annotations") != null)
			annotations = node.getAttributes().getNamedItem("name").getNodeValue();
		else
			annotations = null;
	}

	/**
	 * Initializes this object, extracting its name, its type, and its children.
	 * 
	 * @param node the XML node to intialize this object.
	 * @param name the name of this object.
	 * @param type the type of this object.
	 */
	public SBDNode(Node node, String name, String type) {
		children = null;
		this.node = node;
		this.name = name;
		this.type = type;
		this.id = getValue("xmi:id");
	}

	/**
	 * Returns the xmi id of this object.
	 * 
	 * @return the xmi id of this object.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns the type of this object.
	 * 
	 * @return the type of this object.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Returns the name of this object.
	 * 
	 * @return the name of this object.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the next node of this object.
	 * 
	 * @return the next node of this object.
	 */
	public String getNextNode() {
		if (type != null) {
			if (type.equals("startnode"))
				return getValue("firstNode");
			else if (type.equals("conditionpath"))
				return getValue("nextConditionNode");
			else
				return getValue("nextNode");
		}
		return null;
	}

	/**
	 * Returns the precondition of this object.
	 * 
	 * @return the precondition of this object.
	 */
	public String getPrecondition() {
		return getValue("Precondition");
	}

	/**
	 * Returns the annotations of this object.
	 * 
	 * @return the annotations of this object.
	 */
	public String getAnnotations() {
		return getValue("annotations");
	}

	/**
	 * Returns an xml value for the item that is given as a parameter.
	 * 
	 * @param namedItem the name of the item of which the value is returned.
	 * @return an xml value.
	 */
	private String getValue(String namedItem) {
		if (namedItem.equals("name") && name != null)
			return name;
		else {
			if (node != null && node.getAttributes() != null && node.getAttributes().getNamedItem(namedItem) != null)
				return node.getAttributes().getNamedItem(namedItem).getNodeValue();
		}
		return null;
	}

	/**
	 * Returns a list of xml values for the item that is given as a parameter.
	 * 
	 * @param namedItem the name of the item of which the list of values is returned.
	 * @return a list of xml values.
	 */
	private ArrayList<String> getListOfValues(String namedItem) {
		ArrayList<String> itemNames = new ArrayList<String>();
		if (node.getAttributes().getNamedItem(namedItem) != null) {
			String[] items = node.getAttributes().getNamedItem(namedItem).getNodeValue().split(" ");
			for (int i = 0; i < items.length; i++) {
				itemNames.add(items[i]);
			}
		}
		return itemNames;
	}

	/**
	 * Returns the properties of this object if it is an action.
	 * 
	 * @return the properties of this object.
	 */
	public ArrayList<String> getProperties() {
		return getListOfValues("properties");
	}

	/**
	 * Returns the condition paths of this object, if it is a condition.
	 * 
	 * @return the condition paths of this object.
	 */
	public ArrayList<SBDNode> getChildren() {
		return children;
	}
}
