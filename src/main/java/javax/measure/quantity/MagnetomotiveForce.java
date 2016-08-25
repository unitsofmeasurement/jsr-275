/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.quantity;

import javax.measure.Unit;

/**
 * This interface represents a force that produces magnetic flux.
 *
 * The system unit for this quantity is "At" (ampere-turn).
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.1 ($Revision: 126 $), $Date: 2010-02-17 09:41:38 +0100 (Mi, 17 Feb 2010) $
 * @see     <a href="http://en.wikipedia.org/wiki/Magnetomotive_force">Wikipedia's Magnetomotive Force</a>
 *
 */
public interface MagnetomotiveForce extends Magnetic {

    /**
     * Holds the SI unit (Système International d'Unités) for this quantity.
     */
    Unit<MagnetomotiveForce> getUnit();
}
