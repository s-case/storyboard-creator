/**
 */
package eu.scasefp7.eclipse.storyboards.provider;

import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import eu.scasefp7.eclipse.storyboards.StoryboardDiagram;
import eu.scasefp7.eclipse.storyboards.StoryboardsFactory;
import eu.scasefp7.eclipse.storyboards.StoryboardsPackage;

/**
 * This is the item provider adapter for a {@link eu.scasefp7.eclipse.storyboards.StoryboardDiagram} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StoryboardDiagramItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoryboardDiagramItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(StoryboardsPackage.Literals.STORYBOARD_DIAGRAM__STORYBOARDACTIONS);
			childrenFeatures.add(StoryboardsPackage.Literals.STORYBOARD_DIAGRAM__STORYBOARDPROPERTIES);
			childrenFeatures.add(StoryboardsPackage.Literals.STORYBOARD_DIAGRAM__STORYBOARDCONDITIONS);
			childrenFeatures.add(StoryboardsPackage.Literals.STORYBOARD_DIAGRAM__STORYBOARDSTARTNODE);
			childrenFeatures.add(StoryboardsPackage.Literals.STORYBOARD_DIAGRAM__STORYBOARDENDNODE);
			childrenFeatures.add(StoryboardsPackage.Literals.STORYBOARD_DIAGRAM__STORYBOARDSTORYBOARDS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns StoryboardDiagram.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/StoryboardDiagram"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_StoryboardDiagram_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(StoryboardDiagram.class)) {
			case StoryboardsPackage.STORYBOARD_DIAGRAM__STORYBOARDACTIONS:
			case StoryboardsPackage.STORYBOARD_DIAGRAM__STORYBOARDPROPERTIES:
			case StoryboardsPackage.STORYBOARD_DIAGRAM__STORYBOARDCONDITIONS:
			case StoryboardsPackage.STORYBOARD_DIAGRAM__STORYBOARDSTARTNODE:
			case StoryboardsPackage.STORYBOARD_DIAGRAM__STORYBOARDENDNODE:
			case StoryboardsPackage.STORYBOARD_DIAGRAM__STORYBOARDSTORYBOARDS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(StoryboardsPackage.Literals.STORYBOARD_DIAGRAM__STORYBOARDACTIONS,
				 StoryboardsFactory.eINSTANCE.createAction()));

		newChildDescriptors.add
			(createChildParameter
				(StoryboardsPackage.Literals.STORYBOARD_DIAGRAM__STORYBOARDPROPERTIES,
				 StoryboardsFactory.eINSTANCE.createProperty()));

		newChildDescriptors.add
			(createChildParameter
				(StoryboardsPackage.Literals.STORYBOARD_DIAGRAM__STORYBOARDCONDITIONS,
				 StoryboardsFactory.eINSTANCE.createCondition()));

		newChildDescriptors.add
			(createChildParameter
				(StoryboardsPackage.Literals.STORYBOARD_DIAGRAM__STORYBOARDSTARTNODE,
				 StoryboardsFactory.eINSTANCE.createStartNode()));

		newChildDescriptors.add
			(createChildParameter
				(StoryboardsPackage.Literals.STORYBOARD_DIAGRAM__STORYBOARDENDNODE,
				 StoryboardsFactory.eINSTANCE.createEndNode()));

		newChildDescriptors.add
			(createChildParameter
				(StoryboardsPackage.Literals.STORYBOARD_DIAGRAM__STORYBOARDSTORYBOARDS,
				 StoryboardsFactory.eINSTANCE.createStoryboard()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return StoryboardsEditPlugin.INSTANCE;
	}

}
