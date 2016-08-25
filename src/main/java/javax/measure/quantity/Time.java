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
 * This interface represents a period of existence or persistence. The system
 * unit for this quantity is "s" (second).
 *
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.0, $Date: 2010-02-17 21:55:53 +0100 (Mi, 17 Feb 2010) $
 */
public interface Time extends Quantity {

    /**
     * Holds the SI unit (Système International d'Unités) for this quantity.
     */
    Unit<Time> getUnit();

}
