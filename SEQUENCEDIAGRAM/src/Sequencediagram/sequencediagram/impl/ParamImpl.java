/**
 */
package Sequencediagram.sequencediagram.impl;

import Sequencediagram.sequencediagram.LifeLine;
import Sequencediagram.sequencediagram.Param;
import Sequencediagram.sequencediagram.SequencediagramPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Param</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Sequencediagram.sequencediagram.impl.ParamImpl#getArgName <em>Arg Name</em>}</li>
 *   <li>{@link Sequencediagram.sequencediagram.impl.ParamImpl#getArgType <em>Arg Type</em>}</li>
 *   <li>{@link Sequencediagram.sequencediagram.impl.ParamImpl#getLifeline <em>Lifeline</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParamImpl extends MinimalEObjectImpl.Container implements Param {
	/**
	 * The default value of the '{@link #getArgName() <em>Arg Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgName()
	 * @generated
	 * @ordered
	 */
	protected static final String ARG_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArgName() <em>Arg Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgName()
	 * @generated
	 * @ordered
	 */
	protected String argName = ARG_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getArgType() <em>Arg Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgType()
	 * @generated
	 * @ordered
	 */
	protected static final String ARG_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArgType() <em>Arg Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgType()
	 * @generated
	 * @ordered
	 */
	protected String argType = ARG_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLifeline() <em>Lifeline</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLifeline()
	 * @generated
	 * @ordered
	 */
	protected LifeLine lifeline;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SequencediagramPackage.Literals.PARAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getArgName() {
		return argName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArgName(String newArgName) {
		String oldArgName = argName;
		argName = newArgName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencediagramPackage.PARAM__ARG_NAME, oldArgName, argName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getArgType() {
		return argType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArgType(String newArgType) {
		String oldArgType = argType;
		argType = newArgType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencediagramPackage.PARAM__ARG_TYPE, oldArgType, argType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LifeLine getLifeline() {
		if (lifeline != null && lifeline.eIsProxy()) {
			InternalEObject oldLifeline = (InternalEObject)lifeline;
			lifeline = (LifeLine)eResolveProxy(oldLifeline);
			if (lifeline != oldLifeline) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SequencediagramPackage.PARAM__LIFELINE, oldLifeline, lifeline));
			}
		}
		return lifeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifeLine basicGetLifeline() {
		return lifeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLifeline(LifeLine newLifeline) {
		LifeLine oldLifeline = lifeline;
		lifeline = newLifeline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequencediagramPackage.PARAM__LIFELINE, oldLifeline, lifeline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SequencediagramPackage.PARAM__ARG_NAME:
				return getArgName();
			case SequencediagramPackage.PARAM__ARG_TYPE:
				return getArgType();
			case SequencediagramPackage.PARAM__LIFELINE:
				if (resolve) return getLifeline();
				return basicGetLifeline();
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
			case SequencediagramPackage.PARAM__ARG_NAME:
				setArgName((String)newValue);
				return;
			case SequencediagramPackage.PARAM__ARG_TYPE:
				setArgType((String)newValue);
				return;
			case SequencediagramPackage.PARAM__LIFELINE:
				setLifeline((LifeLine)newValue);
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
			case SequencediagramPackage.PARAM__ARG_NAME:
				setArgName(ARG_NAME_EDEFAULT);
				return;
			case SequencediagramPackage.PARAM__ARG_TYPE:
				setArgType(ARG_TYPE_EDEFAULT);
				return;
			case SequencediagramPackage.PARAM__LIFELINE:
				setLifeline((LifeLine)null);
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
			case SequencediagramPackage.PARAM__ARG_NAME:
				return ARG_NAME_EDEFAULT == null ? argName != null : !ARG_NAME_EDEFAULT.equals(argName);
			case SequencediagramPackage.PARAM__ARG_TYPE:
				return ARG_TYPE_EDEFAULT == null ? argType != null : !ARG_TYPE_EDEFAULT.equals(argType);
			case SequencediagramPackage.PARAM__LIFELINE:
				return lifeline != null;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (argName: ");
		result.append(argName);
		result.append(", argType: ");
		result.append(argType);
		result.append(')');
		return result.toString();
	}

} //ParamImpl
