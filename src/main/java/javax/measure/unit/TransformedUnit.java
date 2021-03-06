/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.unit;

import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;
import javax.measure.unit.UnitConverter;

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
 * @version 1.0.1 ($Revision: 223 $), $Date: 2010-03-14 15:44:36 +0100 (So, 14 Mär 2010) $
 */
public final class TransformedUnit<Q extends Quantity<Q>> extends Unit<Q> {
  
    /**
	 * For cross-version compatibility.
	 */
	private static final long serialVersionUID = -442449068482939939L;

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
    public Unit<Q> toMetric() {
        return parentUnit.toMetric();
    }

    @Override
    public UnitConverter getConverterToMetric() {
        return parentUnit.getConverterToMetric().concatenate(toParentUnit);
    }
}
