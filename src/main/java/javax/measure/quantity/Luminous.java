/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
/*
 *
 */
package javax.measure.quantity;

import javax.measure.Quantity;
import javax.measure.Unit;

/**
 * Holds <code>Luminous</code> quantities
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.0, $Date: 2010-02-17 20:19:16 +0100 (Mi, 17 Feb 2010) $
 */
public interface Luminous extends Quantity {
    /**
     * This interface represents a luminous flux. The system unit for this quantity
     * is "lm" (lumen).
     *
     * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
     * @version 1.1, $Date: 2010-02-17 20:19:16 +0100 (Mi, 17 Feb 2010) $
     */
    public interface Flux extends Quantity {

        /**
         * Holds the SI unit (Système International d'Unités) for this quantity.
         */
        Unit<Flux> getUnit();
    }

    /**
     * This interface represents the luminous density per solid angle as
     * measured in a given direction relative to the emitting source.
     * The system unit for this quantity is "cd" (candela).
     *
     * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
     * @version 1.1, $Date: 2010-02-17 20:19:16 +0100 (Mi, 17 Feb 2010) $
     */
    public interface Intensity extends Luminous {
        // XXX (Flux) Density instead?
        /**
         * Holds the SI unit (Système International d'Unités) for this quantity.
         */
        Unit<Intensity> getUnit();
    }
}
