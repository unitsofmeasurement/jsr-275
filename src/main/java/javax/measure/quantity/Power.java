/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.quantity;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.unit.MetricSystem;

/**
 * This interface represents the rate at which work is done. The system unit
 * for this quantity is "W" (Watt).
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.0, April 15, 2009
 */
public interface Power extends Quantity {

    /**
     * Holds the SI unit (Système International d'Unités) for this quantity.
     */
    Unit<Power> getUnit();

}
