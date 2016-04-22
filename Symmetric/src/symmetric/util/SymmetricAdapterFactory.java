/**
 */
package symmetric.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import symmetric.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see symmetric.SymmetricPackage
 * @generated
 */
public class SymmetricAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SymmetricPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymmetricAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SymmetricPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SymmetricSwitch<Adapter> modelSwitch =
		new SymmetricSwitch<Adapter>() {
			@Override
			public Adapter caseSymmetricDifference(SymmetricDifference object) {
				return createSymmetricDifferenceAdapter();
			}
			@Override
			public Adapter caseAddObject(AddObject object) {
				return createAddObjectAdapter();
			}
			@Override
			public Adapter caseRemoveObject(RemoveObject object) {
				return createRemoveObjectAdapter();
			}
			@Override
			public Adapter caseAddReference(AddReference object) {
				return createAddReferenceAdapter();
			}
			@Override
			public Adapter caseRemoveReference(RemoveReference object) {
				return createRemoveReferenceAdapter();
			}
			@Override
			public Adapter caseChange(Change object) {
				return createChangeAdapter();
			}
			@Override
			public Adapter caseSemanticChangeSet(SemanticChangeSet object) {
				return createSemanticChangeSetAdapter();
			}
			@Override
			public Adapter caseCorrespondence(Correspondence object) {
				return createCorrespondenceAdapter();
			}
			@Override
			public Adapter caseAttributeValueChange(AttributeValueChange object) {
				return createAttributeValueChangeAdapter();
			}
			@Override
			public Adapter caseEString2EObjectSetMap(Map.Entry<String, EObjectSet> object) {
				return createEString2EObjectSetMapAdapter();
			}
			@Override
			public Adapter caseEditRuleMatch(EditRuleMatch object) {
				return createEditRuleMatchAdapter();
			}
			@Override
			public Adapter caseEObjectSet(EObjectSet object) {
				return createEObjectSetAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link symmetric.SymmetricDifference <em>Difference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see symmetric.SymmetricDifference
	 * @generated
	 */
	public Adapter createSymmetricDifferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link symmetric.AddObject <em>Add Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see symmetric.AddObject
	 * @generated
	 */
	public Adapter createAddObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link symmetric.RemoveObject <em>Remove Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see symmetric.RemoveObject
	 * @generated
	 */
	public Adapter createRemoveObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link symmetric.AddReference <em>Add Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see symmetric.AddReference
	 * @generated
	 */
	public Adapter createAddReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link symmetric.RemoveReference <em>Remove Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see symmetric.RemoveReference
	 * @generated
	 */
	public Adapter createRemoveReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link symmetric.Change <em>Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see symmetric.Change
	 * @generated
	 */
	public Adapter createChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link symmetric.SemanticChangeSet <em>Semantic Change Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see symmetric.SemanticChangeSet
	 * @generated
	 */
	public Adapter createSemanticChangeSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link symmetric.Correspondence <em>Correspondence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see symmetric.Correspondence
	 * @generated
	 */
	public Adapter createCorrespondenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link symmetric.AttributeValueChange <em>Attribute Value Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see symmetric.AttributeValueChange
	 * @generated
	 */
	public Adapter createAttributeValueChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EString2 EObject Set Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createEString2EObjectSetMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link symmetric.EditRuleMatch <em>Edit Rule Match</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see symmetric.EditRuleMatch
	 * @generated
	 */
	public Adapter createEditRuleMatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link symmetric.EObjectSet <em>EObject Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see symmetric.EObjectSet
	 * @generated
	 */
	public Adapter createEObjectSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SymmetricAdapterFactory
