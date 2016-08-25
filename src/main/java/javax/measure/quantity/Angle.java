/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.quantity;
import javax.measure.Unit;
import javax.measure.unit.MetricSystem;

/**
 * This interface represents the figure formed by two lines diverging from a
 * common point. The system unit for this quantity is "rad" (radian).
 * This quantity is dimensionless.
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.0, April 15, 2009
 */
public interface Angle extends Dimensionless {

    /**
     * Holds the SI unit (Système International d'Unités) for this quantity.
     */
    Unit<Angle> getUnit();

}
