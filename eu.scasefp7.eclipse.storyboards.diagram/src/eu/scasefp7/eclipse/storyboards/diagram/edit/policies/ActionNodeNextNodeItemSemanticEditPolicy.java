package eu.scasefp7.eclipse.storyboards.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import eu.scasefp7.eclipse.storyboards.diagram.providers.StoryboardsElementTypes;

/**
 * @generated
 */
public class ActionNodeNextNodeItemSemanticEditPolicy extends StoryboardsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ActionNodeNextNodeItemSemanticEditPolicy() {
		super(StoryboardsElementTypes.ActionNodeNextNode_4006);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
