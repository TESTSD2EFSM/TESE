/**
 */
package Efsm.efsm;

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
 *   <li>{@link Efsm.efsm.Param#getArgName <em>Arg Name</em>}</li>
 *   <li>{@link Efsm.efsm.Param#getArgType <em>Arg Type</em>}</li>
 * </ul>
 *
 * @see Efsm.efsm.EfsmPackage#getParam()
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
	 * @see Efsm.efsm.EfsmPackage#getParam_ArgName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getArgName();

	/**
	 * Sets the value of the '{@link Efsm.efsm.Param#getArgName <em>Arg Name</em>}' attribute.
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
	 * @see Efsm.efsm.EfsmPackage#getParam_ArgType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getArgType();

	/**
	 * Sets the value of the '{@link Efsm.efsm.Param#getArgType <em>Arg Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arg Type</em>' attribute.
	 * @see #getArgType()
	 * @generated
	 */
	void setArgType(String value);

} // Param
