package eu.scasefp7.eclipse.storyboards.diagram.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

import eu.scasefp7.eclipse.storyboards.diagram.edit.parts.StoryboardDiagramEditPart;
import eu.scasefp7.eclipse.storyboards.diagram.edit.parts.StoryboardsEditPartFactory;
import eu.scasefp7.eclipse.storyboards.diagram.part.StoryboardsVisualIDRegistry;

/**
 * @generated
 */
public class StoryboardsEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public StoryboardsEditPartProvider() {
		super(new StoryboardsEditPartFactory(), StoryboardsVisualIDRegistry.TYPED_INSTANCE,
				StoryboardDiagramEditPart.MODEL_ID);
	}

}
