/**
 *
 * $Id$
 */
package Sequencediagram.sequencediagram.validation;

import Sequencediagram.sequencediagram.LifeLine;
import Sequencediagram.sequencediagram.MessageKind;
import Sequencediagram.sequencediagram.Operation;

/**
 * A sample validator interface for {@link Sequencediagram.sequencediagram.Message}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface MessageValidator {
	boolean validate();

	boolean validateName(String value);
	boolean validateType(MessageKind value);
	boolean validateTarget(LifeLine value);
	boolean validateSource(LifeLine value);
	boolean validateOperation(Operation value);
}