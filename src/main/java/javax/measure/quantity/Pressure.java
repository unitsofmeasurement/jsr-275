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
 * This interface represents a force applied uniformly over a surface.
 * The system unit for this quantity is "Pa" (Pascal).
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.0, April 15, 2009
 */
public interface Pressure extends Quantity {

    /**
     * Holds the SI unit (Système International d'Unités) for this quantity.
     */
    Unit<Pressure> getUnit();

}
