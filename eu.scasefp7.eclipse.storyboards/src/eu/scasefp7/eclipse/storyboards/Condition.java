/**
 */
package eu.scasefp7.eclipse.storyboards;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.scasefp7.eclipse.storyboards.Condition#getName <em>Name</em>}</li>
 *   <li>{@link eu.scasefp7.eclipse.storyboards.Condition#getConditionPaths <em>Condition Paths</em>}</li>
 * </ul>
 *
 * @see eu.scasefp7.eclipse.storyboards.StoryboardsPackage#getCondition()
 * @model
 * @generated
 */
public interface Condition extends Node {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see eu.scasefp7.eclipse.storyboards.StoryboardsPackage#getCondition_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link eu.scasefp7.eclipse.storyboards.Condition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Condition Paths</b></em>' containment reference list.
	 * The list contents are of type {@link eu.scasefp7.eclipse.storyboards.ConditionPath}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Paths</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition Paths</em>' containment reference list.
	 * @see eu.scasefp7.eclipse.storyboards.StoryboardsPackage#getCondition_ConditionPaths()
	 * @model containment="true" lower="2" upper="2"
	 * @generated
	 */
	EList<ConditionPath> getConditionPaths();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean validate(DiagnosticChain diagnostic, Map<Object, Object> context);

} // Condition
