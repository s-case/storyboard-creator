package eu.scasefp7.eclipse.storyboards.diagram.providers;

import eu.scasefp7.eclipse.storyboards.diagram.part.StoryboardsDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = StoryboardsDiagramEditorPlugin.getInstance().getElementInitializers();
		if (cached == null) {
			StoryboardsDiagramEditorPlugin.getInstance().setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
