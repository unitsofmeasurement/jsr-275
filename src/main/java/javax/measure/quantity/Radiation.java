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
 * This interface wraps up Radiation quantities.
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.0, $Date: 2010-02-17 21:55:53 +0100 (Mi, 17 Feb 2010) $
 */
public interface Radiation extends Quantity {

    /**
     * This interface represents the amount of energy deposited per unit of
     * mass. The system unit for this quantity is "Gy" (Gray).
     *
     * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
     * @version 1.0, April 15, 2009
     */
    public interface DoseAbsorbed extends Radiation {
        /**
         * Holds the SI unit (Système International d'Unités) for this quantity.
         */
        Unit<DoseAbsorbed> getUnit();
    }

    /**
     * This interface represents the effective (or "equivalent") dose of radiation
     * received by a human or some other living organism. The system unit for
     * this quantity is "Sv" (Sievert).
     *
     * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
     * @version 1.0, April 15, 2009
     */
    public interface DoseEffective extends Radiation {

        /**
         * Holds the SI unit (Système International d'Unités) for this quantity.
         */
        Unit<DoseEffective> getUnit();
    }

    /**
     * This interface represents a radioactive activity. The system unit for
     * this quantity is "Bq" (Becquerel).
     *
     * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
     * @version 1.0, April 15, 2009
     */
    public interface RadioactiveActivity extends Radiation {

        /**
         * Holds the SI unit (Système International d'Unités) for this quantity.
         */
        Unit<RadioactiveActivity> getUnit();

    }
}
