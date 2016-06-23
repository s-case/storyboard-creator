package eu.scasefp7.eclipse.storyboards.diagram.part;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * @generated
 */
public class StoryboardsCreationWizardPage extends WizardNewFileCreationPage {

	/**
	 * @generated
	 */
	private final String fileExtension;

	/**
	 * The current selection.
	 * 
	 * @generated NOT
	 */
	private ISelection selection;

	/**
	 * @generated
	 */
	public StoryboardsCreationWizardPage(String pageName, IStructuredSelection selection, String fileExtension) {
		super(pageName, selection);
		this.fileExtension = fileExtension;
		this.selection = selection;
	}

	/**
	 * Override to create files with this extension.
	 * 
	 * @generated
	 */
	protected String getExtension() {
		return fileExtension;
	}

	/**
	 * @generated
	 */
	public URI getURI() {
		return URI.createPlatformResourceURI(getFilePath().toString(), false);
	}

	/**
	 * @generated
	 */
	protected IPath getFilePath() {
		IPath path = getContainerFullPath();
		if (path == null) {
			path = new Path(""); //$NON-NLS-1$
		}
		String fileName = getFileName();
		if (fileName != null) {
			path = path.append(fileName);
		}
		return path;
	}

	/**
	 * @generated NOT
	 */
	public void createControl(Composite parent) {
		super.createControl(parent);
		initialize();
		setFileName(StoryboardsDiagramEditorUtil.getUniqueFileName(getContainerFullPath(), getFileName(),
				getExtension()));
		setPageComplete(validatePage());
	}

	/**
	 * Tests if the current workbench selection is a suitable container to use.
	 * 
	 * @generated NOT
	 */
	private void initialize() {
		if (selection != null && selection.isEmpty() == false && selection instanceof IStructuredSelection) {
			IProject project = ProjectLocator.getProjectOfSelectionList((IStructuredSelection) selection);
			String requirementsFolderLocation = null;
			try {
				requirementsFolderLocation = project.getPersistentProperty(new QualifiedName("",
						"eu.scasefp7.eclipse.core.ui.rqsFolder"));
			} catch (CoreException e) {
				StoryboardsDiagramEditorPlugin.log("Error retrieving project property (requirements folder location)",
						e);
			}
			String compositionsFolderLocation = null;
			try {
				compositionsFolderLocation = project.getPersistentProperty(new QualifiedName("",
						"eu.scasefp7.eclipse.core.ui.compFolder"));
			} catch (CoreException e) {
				StoryboardsDiagramEditorPlugin.log("Error retrieving project property (compositions folder location)",
						e);
			}
			IContainer container = project;
			if (fileExtension.equals("scd") && compositionsFolderLocation != null) {
				IResource compositionsFolder = project.findMember(new Path(compositionsFolderLocation));
				if (compositionsFolder != null && compositionsFolder.exists())
					container = (IContainer) compositionsFolder;
			} else if (fileExtension.equals("sbd") && requirementsFolderLocation != null) {
				IResource requirementsFolder = project.findMember(new Path(requirementsFolderLocation));
				if (requirementsFolder != null && requirementsFolder.exists())
					container = (IContainer) requirementsFolder;
			}
			setContainerFullPath(container.getFullPath());
		}
	}

	/**
	 * @generated
	 */
	protected boolean validatePage() {
		if (!super.validatePage()) {
			return false;
		}
		String extension = getExtension();
		if (extension != null && !getFilePath().toString().endsWith("." + extension)) {
			setErrorMessage(NLS.bind(Messages.StoryboardsCreationWizardPageExtensionError, extension));
			return false;
		}
		return true;
	}
}
