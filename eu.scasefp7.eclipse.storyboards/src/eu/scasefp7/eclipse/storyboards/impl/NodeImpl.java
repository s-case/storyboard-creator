/**
 */
package eu.scasefp7.eclipse.storyboards.impl;

import java.util.HashSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import eu.scasefp7.eclipse.storyboards.Node;
import eu.scasefp7.eclipse.storyboards.StoryboardsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.scasefp7.eclipse.storyboards.impl.NodeImpl#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NodeImpl extends MinimalEObjectImpl.Container implements Node {

	/**
	 * The default value of the '{@link #getAnnotations() <em>Annotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected static final String ANNOTATIONS_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected String annotations = ANNOTATIONS_EDEFAULT;
	/**
	 * @generated NOT
	 */
	protected HashSet<Node> previousNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoryboardsPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAnnotations() {
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotations(String newAnnotations) {
		String oldAnnotations = annotations;
		annotations = newAnnotations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoryboardsPackage.NODE__ANNOTATIONS, oldAnnotations, annotations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StoryboardsPackage.NODE__ANNOTATIONS:
				return getAnnotations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StoryboardsPackage.NODE__ANNOTATIONS:
				setAnnotations((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StoryboardsPackage.NODE__ANNOTATIONS:
				setAnnotations(ANNOTATIONS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StoryboardsPackage.NODE__ANNOTATIONS:
				return ANNOTATIONS_EDEFAULT == null ? annotations != null : !ANNOTATIONS_EDEFAULT.equals(annotations);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (annotations: ");
		result.append(annotations);
		result.append(')');
		return result.toString();
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void addPreviousNode(Node node) {
		if (previousNodes == null)
			previousNodes = new HashSet<Node>();
		previousNodes.add(node);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void removePreviousNode(Node node) {
		if (previousNodes == null)
			previousNodes = new HashSet<Node>();
		if (previousNodes.contains(node))
			previousNodes.remove(node);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public HashSet<Node> getPreviousNodes() {
		if (previousNodes == null)
			previousNodes = new HashSet<Node>();
		return previousNodes;
	}

} // NodeImpl
