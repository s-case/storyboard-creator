package eu.scasefp7.eclipse.storyboards.diagram.part;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
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
			IStructuredSelection ssel = (IStructuredSelection) selection;
			if (ssel.size() > 1)
				return;
			Object obj = ssel.getFirstElement();
			if (obj instanceof IResource) {
				IProject project;
				if (obj instanceof IContainer)
					project = ((IContainer) obj).getProject();
				else
					project = (((IResource) obj).getParent()).getProject();
				IContainer container = fileExtension.equals("scd") ? project.getFolder("compositions") : project
						.getFolder("requirements");
				if (!container.exists())
					container = project;
				setContainerFullPath(container.getFullPath());
			}
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
