/**
 */
package Sequencediagram.sequencediagram;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Sequencediagram.sequencediagram.Param#getArgName <em>Arg Name</em>}</li>
 *   <li>{@link Sequencediagram.sequencediagram.Param#getArgType <em>Arg Type</em>}</li>
 *   <li>{@link Sequencediagram.sequencediagram.Param#getLifeline <em>Lifeline</em>}</li>
 * </ul>
 *
 * @see Sequencediagram.sequencediagram.SequencediagramPackage#getParam()
 * @model
 * @generated
 */
public interface Param extends EObject {
	/**
	 * Returns the value of the '<em><b>Arg Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arg Name</em>' attribute.
	 * @see #setArgName(String)
	 * @see Sequencediagram.sequencediagram.SequencediagramPackage#getParam_ArgName()
	 * @model
	 * @generated
	 */
	String getArgName();

	/**
	 * Sets the value of the '{@link Sequencediagram.sequencediagram.Param#getArgName <em>Arg Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arg Name</em>' attribute.
	 * @see #getArgName()
	 * @generated
	 */
	void setArgName(String value);

	/**
	 * Returns the value of the '<em><b>Arg Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arg Type</em>' attribute.
	 * @see #setArgType(String)
	 * @see Sequencediagram.sequencediagram.SequencediagramPackage#getParam_ArgType()
	 * @model
	 * @generated
	 */
	String getArgType();

	/**
	 * Sets the value of the '{@link Sequencediagram.sequencediagram.Param#getArgType <em>Arg Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arg Type</em>' attribute.
	 * @see #getArgType()
	 * @generated
	 */
	void setArgType(String value);

	/**
	 * Returns the value of the '<em><b>Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lifeline</em>' reference.
	 * @see #setLifeline(LifeLine)
	 * @see Sequencediagram.sequencediagram.SequencediagramPackage#getParam_Lifeline()
	 * @model
	 * @generated
	 */
	LifeLine getLifeline();

	/**
	 * Sets the value of the '{@link Sequencediagram.sequencediagram.Param#getLifeline <em>Lifeline</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lifeline</em>' reference.
	 * @see #getLifeline()
	 * @generated
	 */
	void setLifeline(LifeLine value);

} // Param
