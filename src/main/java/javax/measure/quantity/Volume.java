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
 * This interface represents the amount of space occupied by a three-dimensional
 * object or region of space, expressed in cubic units. The system unit for
 * this quantity is "m3" (cubic metre).
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.0, April 15, 2009
 */
public interface Volume extends Quantity {

    /**
     * Holds the SI unit (Système International d'Unités) for this quantity.
     */
    Unit<Volume> getUnit();

}
