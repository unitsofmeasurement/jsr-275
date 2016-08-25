/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.unit;

import javax.measure.Dimension;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;

/**
 * <p> This class represents the units used in expressions to distinguish
 *     between quantities of a different nature but of the same dimensions.</p>
 *
 * <p> Instances of this class are created through the
 *     {@link Unit#alternate(String)} method.</p>
 *
 * @param <Q> The type of the quantity measured by this unit.
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.1, $Date: 2010-02-17 10:13:47 +0100 (Mi, 17 Feb 2010) $
 */
public final class AlternateUnit<Q extends Quantity> extends DerivedUnit<Q> {
    /**
     *
     */
    private static final long serialVersionUID = 1946401910180377890L;

    /**
     * Holds the parent unit (a system unit).
     */
    private final Unit<?> parent;

    /**
     * Creates an alternate unit for the specified unit identified by the
     * specified name and symbol.
     *
     * @param name the name for this alternate unit.
     * @param symbol the symbol for this alternate unit.
     * @param parent the system unit from which this alternate unit is
     *        derived.
     * @throws UnsupportedOperationException if the source is not
     *         a standard unit.
     * @throws IllegalArgumentException if the specified symbol is
     *         associated to a different unit.
     */
    AlternateUnit(String name, String symbol, Unit<?> parent) {
        super(name, symbol);
        if (!parent.isSI())
            throw new UnsupportedOperationException(this + " is not a standard unit");
        this.parent = parent;
        // Checks if the symbol is associated to a different unit.
        synchronized (Unit.SYMBOL_TO_UNIT) {
            Unit<?> unit = Unit.SYMBOL_TO_UNIT.get(symbol);
            if (unit == null) {
                Unit.SYMBOL_TO_UNIT.put(symbol, this);
                return;
            }
            if (unit instanceof AlternateUnit<?>) {
                AlternateUnit<?> existingUnit = (AlternateUnit<?>) unit;
                if (symbol.equals(existingUnit.symbol) && this.parent.equals(existingUnit.parent))
                    return; // OK, same unit.
            }
            throw new IllegalArgumentException("Symbol " + symbol + " is associated to a different unit");
        }
    }

    /**
     * Creates an alternate unit for the specified unit identified by the
     * specified symbol.
     *
     * @param symbol the symbol for this alternate unit.
     * @param parent the system unit from which this alternate unit is
     *        derived.
     * @throws UnsupportedOperationException if the source is not
     *         a standard unit.
     * @throws IllegalArgumentException if the specified symbol is
     *         associated to a different unit.
     */
    public AlternateUnit(String symbol, Unit<?> parent) {
        this(symbol, symbol, parent);
    }

    /**
     * Returns the parent unit from which this alternate unit is derived
     * (a system unit itself).
     *
     * @return the parent of the alternate unit.
     */
    public final Unit<?> getParent() {
        return parent;
    }

    @Override
    public final Unit<Q> toSI() {
        return this;
    }

    @Override
    public final UnitConverter getConverterToSI() {
        return UnitConverter.IDENTITY;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that)
            return true;
        if (!(that instanceof AlternateUnit<?>))
            return false;
        AlternateUnit<?> thatUnit = (AlternateUnit<?>) that;
        return this.symbol.equals(thatUnit.symbol); // Symbols are unique.
    }

    @Override
    public Dimension getDimension() {
        return parent.getDimension();
    }

    @Override
    public UnitConverter getDimensionalTransform() {
        return parent.getDimensionalTransform();
    }
}
