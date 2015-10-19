/**
 */
package eu.scasefp7.eclipse.storyboards;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.scasefp7.eclipse.storyboards.Action#getProperties <em>Properties</em>}</li>
 *   <li>{@link eu.scasefp7.eclipse.storyboards.Action#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see eu.scasefp7.eclipse.storyboards.StoryboardsPackage#getAction()
 * @model
 * @generated
 */
public interface Action extends ActionNode {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' reference list.
	 * The list contents are of type {@link eu.scasefp7.eclipse.storyboards.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' reference list.
	 * @see eu.scasefp7.eclipse.storyboards.StoryboardsPackage#getAction_Properties()
	 * @model
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.scasefp7.eclipse.storyboards.ActionEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see eu.scasefp7.eclipse.storyboards.ActionEnum
	 * @see #setType(ActionEnum)
	 * @see eu.scasefp7.eclipse.storyboards.StoryboardsPackage#getAction_Type()
	 * @model
	 * @generated
	 */
	ActionEnum getType();

	/**
	 * Sets the value of the '{@link eu.scasefp7.eclipse.storyboards.Action#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see eu.scasefp7.eclipse.storyboards.ActionEnum
	 * @see #getType()
	 * @generated
	 */
	void setType(ActionEnum value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean validate(DiagnosticChain diagnostic, Map<Object, Object> context);

} // Action
