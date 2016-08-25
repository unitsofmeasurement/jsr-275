/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.quantity;

import javax.measure.Quantity;
import javax.measure.Unit;

/**
 * This interface represents the number of elementary entities (molecules, for
 * example) of a substance. The system unit for this quantity is "mol" (mole).
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.0, April 15, 2009
 */
public interface AmountOfSubstance extends Quantity {

    /**
     * Holds the SI unit (Système International d'Unités) for this quantity.
     */
   Unit<AmountOfSubstance> getUnit();

}
