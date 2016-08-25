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
 * Holds Magnetic quantities
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.0, $Date: 2010-02-17 09:41:38 +0100 (Mi, 17 Feb 2010) $
 */
public interface Magnetic extends Quantity {
    /**
     * This interface represents a magnetic field strength. The system unit for this
     * quantity is "A/m" (ampere per meter).
     *
     * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
     * @version 1.0.1 ($Revision: 126 $), $Date: 2010-02-17 09:41:38 +0100 (Mi, 17 Feb 2010) $
     */
    public interface FieldStrength extends Magnetic {

        /**
         * Holds the SI unit (Système International d'Unités) for this quantity.
         */
        Unit<FieldStrength> getUnit();
    }

    /**
     * This interface represents a magnetic flux. The system unit for this quantity
     * is "Wb" (Weber).
     *
     * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
     * @version 1.0, April 15, 2009
     */
    public interface Flux extends Magnetic {

        /**
         * Holds the SI unit (Système International d'Unités) for this quantity.
         */
        Unit<Flux> getUnit();
    }

    /**
     * This interface represents a magnetic flux density. The system unit for this
     * quantity is "T" (Tesla).
     *
     * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
     * @version 1.0, April 15, 2009
     */
    public interface FluxDensity extends Magnetic {

        /**
         * Holds the SI unit (Système International d'Unités) for this quantity.
         */
        Unit<FluxDensity> getUnit();
    }
}
