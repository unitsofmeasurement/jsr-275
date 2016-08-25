/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.quantity;

import javax.measure.Unit;

/**
 * This interface represents the angle formed by three or more planes intersecting
 * at a common point. The system unit for this quantity is "sr" (steradian).
 * This quantity is dimensionless.
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.1, $Date: 2010-02-17 09:41:38 +0100 (Mi, 17 Feb 2010) $
 */
public interface SolidAngle extends Dimensionless {

    /**
     * Holds the SI unit (Système International d'Unités) for this quantity.
     */
    Unit<SolidAngle> getUnit();

}
