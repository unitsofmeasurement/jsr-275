/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.unit;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;

/**
 * <p> This class represents the multi-radix units (such as "hour:min:sec").
 *     Instances of this class are created using the {@link Unit#compound
 *     Unit.compound} method. Instances of this class are used mostly for
 *     {@linkplain javax.measure.MeasureFormat formatting} purpose.</p>
 *
 * <p> Examples of compound units:[code]
 *     Unit<Duration> HOUR_MINUTE_SECOND = HOUR.compound(MINUTE).compound(SECOND);
 *     Unit<Angle> DEGREE_MINUTE_ANGLE = DEGREE_ANGLE.compound(MINUTE_ANGLE);
 *     Unit<Length> FOOT_INCH = FOOT.compound(INCH);
 *     [/code]</p>
 *
 * @param <Q> The type of the quantity measured by this unit.
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.0.2 ($Revision: 127 $), $Date: 2010-02-17 10:13:47 +0100 (Mi, 17 Feb 2010) $
 */
public final class CompoundUnit<Q extends Quantity> extends DerivedUnit<Q> {

    /** The serialVersionUID */
    private static final long serialVersionUID = 1237893765437626411L;

    /**
     * Holds the lowest (main) unit.
     */
    private final Unit<Q> low;

    /**
     * Holds the highest unit(s).
     */
    private final Unit<Q> high;

    /**
     * Creates a compound unit from the specified units.
     *
     * @param  high the highest unit(s).
     * @param  low the lowest unit(s).
     * @throws IllegalArgumentException if both units are not of same type
     *         (<code>!high.toSI().equals(low.toSI())</code>).
     */
    public CompoundUnit(Unit<Q> high, Unit<Q> low) {
        if (!high.toSI().equals(low.toSI()))
            throw new IllegalArgumentException(
                    "Cannot compound " + high + " with " + low);
        if (low instanceof CompoundUnit<?>) {
            this.high = high.compound(((CompoundUnit<Q>) low).getHigh());
            this.low = ((CompoundUnit<Q>) low).getLow();
        } else {
            this.high = high;
            this.low = low;
        }
    }

    /**
     * Returns the lowest unit or main unit of this compound unit
     * (never a {@link CompoundUnit}).
     *
     * @return the lower unit.
     */
    public Unit<Q> getLow() {
        return low;
    }

    /**
     * Returns the high unit(s) of this compound unit (can be a
     * {@link CompoundUnit} itself).
     *
     * @return the high unit(s).
     */
    public Unit<Q> getHigh() {
        return high;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that)
            return true;
        if (!(that instanceof CompoundUnit<?>))
            return false;
        CompoundUnit<?> thatUnit = (CompoundUnit<?>) that;
        return this.low.equals(thatUnit.low) && this.high.equals(thatUnit.high);
    }

    @Override
    public int hashCode() {
        return high.hashCode() ^ low.hashCode();
    }

    /**
     * Overrides the {@linkplain Unit#toString() default implementation} as
     * compound units are not recognized by the standard UCUM format.
     *
     * @return the textual representation of this compound unit.
     */
    @Override
    public String toString() {
        return high + ":" + low;
    }

    @Override
    public Unit<Q> toSI() {
        return low.toSI();
    }

    @Override
    public final UnitConverter getConverterToSI() {
        return low.getConverterToSI();
    }
}
