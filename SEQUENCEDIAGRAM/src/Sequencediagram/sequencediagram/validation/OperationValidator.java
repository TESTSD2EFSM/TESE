/**
 *
 * $Id$
 */
package Sequencediagram.sequencediagram.validation;

import Sequencediagram.sequencediagram.Param;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link Sequencediagram.sequencediagram.Operation}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface OperationValidator {
	boolean validate();

	boolean validateReturnVariable(String value);
	boolean validateReturnType(String value);
	boolean validateArgs(EList<Param> value);
	boolean validateGuard(String value);
}
