/**
 */
package eu.scasefp7.eclipse.storyboards;

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.scasefp7.eclipse.storyboards.Node#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 *
 * @see eu.scasefp7.eclipse.storyboards.StoryboardsPackage#getNode()
 * @model abstract="true"
 * @generated
 */
public interface Node extends EObject {

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' attribute.
	 * @see #setAnnotations(String)
	 * @see eu.scasefp7.eclipse.storyboards.StoryboardsPackage#getNode_Annotations()
	 * @model
	 * @generated
	 */
	String getAnnotations();

	/**
	 * Sets the value of the '{@link eu.scasefp7.eclipse.storyboards.Node#getAnnotations <em>Annotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotations</em>' attribute.
	 * @see #getAnnotations()
	 * @generated
	 */
	void setAnnotations(String value);

	/**
	 * @generated NOT
	 */
	void addPreviousNode(Node node);

	/**
	 * @generated NOT
	 */
	void removePreviousNode(Node node);

	/**
	 * @generated NOT
	 */
	HashSet<Node> getPreviousNodes();

} // Node
