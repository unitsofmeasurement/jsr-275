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
 * Holds Electric quantities
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.0, $Date: 2010-02-17 09:41:38 +0100 (Mi, 17 Feb 2010) $
 */
public interface Electric extends Quantity {
    /**
     * This interface represents an electric capacitance. The system unit for this
     * quantity is "F" (Farad).
     *
     * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
     * @version 1.0, April 15, 2009
     */
    public interface Capacitance extends Electric {

        /**
         * Holds the SI unit (Système International d'Unités) for this quantity.
         */
        Unit<Capacitance> getUnit();
    }

    /**
     * This interface represents an electric charge. The system unit for this
     * quantity is "C" (Coulomb).
     *
     * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
     * @version 1.0, April 15, 2009
     */
    public interface Charge extends Electric {

        /**
         * Holds the SI unit (Système International d'Unités) for this quantity.
         */
        Unit<Charge> getUnit();
    }

    /**
     * This interface represents an electric conductance. The system unit for this
     * quantity "S" (Siemens).
     *
     * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
     * @version 1.0, April 15, 2009
     */
    public interface Conductance extends Electric {
        /**
         * Holds the SI unit (Système International d'Unités) for this quantity.
         */
        Unit<Conductance> getUnit();
    }

    /**
     * This interface represents the amount of electric charge flowing past
     * a specified circuit point per unit time. The system unit for
     * this quantity is "A" (Ampere).
     *
     * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
     * @version 1.0, April 15, 2009
     */
    public interface Current extends Electric {

        /**
         * Holds the SI unit (Système International d'Unités) for this quantity.
         */
        Unit<Current> getUnit();
    }

    /**
     * This interface represents an electric inductance. The system unit for this
     * quantity is "H" (Henry).
     *
     * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
     * @version 1.0, April 15, 2009
     */
    public interface Inductance extends Electric {

        /**
         * Holds the SI unit (Système International d'Unités) for this quantity.
         */
        Unit<Inductance> getUnit();
    }

    /**
     * This interface represents an electric potential or electromotive force.
     * The system unit for this quantity is "V" (Volt).
     *
     * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
     * @version 1.0, April 15, 2009
     */
    public interface Potential extends Quantity {

        /**
         * Holds the SI unit (Système International d'Unités) for this quantity.
         */
        Unit<Potential> getUnit();
    }

    /**
     * This interface represents an electric resistance.
     * The system unit for this quantity is "Ohm" (Ω).
     *
     * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
     * @version 1.0, April 15, 2009
     */
    public interface Resistance extends Quantity {

        /**
         * Holds the SI unit (Système International d'Unités) for this quantity.
         */
        Unit<Resistance> getUnit();

    }
}
