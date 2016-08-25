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
 * <p> This class represents the units derived from other units using
 *     {@linkplain UnitConverter converters}.</p>
 *
 * <p> Examples of transformed units:[code]
 *         CELSIUS = KELVIN.add(273.15);
 *         FOOT = METRE.times(3048).divide(10000);
 *         MILLISECOND = MILLI(SECOND);
 *     [/code]</p>
 *
 * <p> Transformed units have no label. But like any other units,
 *     they may have labels attached to them (see {@link javax.measure.unit.SymbolMap
 *     SymbolMap}</p>
 *
 * <p> Instances of this class are created through the {@link Unit#transform} method.</p>
 *
 * @param <Q> The type of the quantity measured by this unit.
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.0.1 ($Revision: 127 $), $Date: 2010-02-17 10:13:47 +0100 (Mi, 17 Feb 2010) $
 */
public final class TransformedUnit<Q extends Quantity> extends DerivedUnit<Q> {
    /** The serialVersionUID */
    private static final long serialVersionUID = -1846401910180377008L;

    /**
     * Holds the parent unit (not a transformed unit).
     */
    private final Unit<Q> parentUnit;

    /**
     * Holds the converter to the parent unit.
     */
    private final UnitConverter toParentUnit;

    /**
     * Creates a transformed unit from the specified parent unit.
     *
     * @param parentUnit the untransformed unit from which this unit is
     *        derived.
     * @param  toParentUnit the converter to the parent units.
     * @throws IllegalArgumentException if <code>toParentUnit ==
     *         {@link UnitConverter#IDENTITY UnitConverter.IDENTITY}</code>
     */
    public TransformedUnit(Unit<Q> parentUnit, UnitConverter toParentUnit) {
        if (toParentUnit == UnitConverter.IDENTITY)
            throw new IllegalArgumentException("Identity not allowed");
        this.parentUnit = parentUnit;
        this.toParentUnit = toParentUnit;
    }

    /**
     * Returns the parent unit for this unit. The parent unit is the
     * untransformed unit from which this unit is derived.
     *
     * @return the untransformed unit from which this unit is derived.
     */
    public Unit<Q> getParentUnit() {
        return parentUnit;
    }

    /**
     * Returns the converter to the parent unit.
     *
     * @return the converter to the parent unit.
     */
    public UnitConverter toParentUnit() {
        return toParentUnit;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that)
            return true;
        if (!(that instanceof TransformedUnit<?>))
            return false;
        TransformedUnit<?> thatUnit = (TransformedUnit<?>) that;
        return this.parentUnit.equals(thatUnit.parentUnit) &&
                this.toParentUnit.equals(thatUnit.toParentUnit);
    }

    @Override
    public int hashCode() {
        return parentUnit.hashCode() + toParentUnit.hashCode();
    }

    @Override
    public Unit<Q> toSI() {
        return parentUnit.toSI();
    }

    @Override
    public UnitConverter getConverterToSI() {
        return parentUnit.getConverterToSI().concatenate(toParentUnit);
    }
}
