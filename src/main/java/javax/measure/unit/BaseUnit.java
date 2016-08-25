/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.unit;

import javax.measure.Dimension;
import javax.measure.Quantity;
import javax.measure.SystemOfUnits;
import javax.measure.Unit;
import javax.measure.UnitConverter;

/**
 * <p> This class represents the building blocks on top of which all others
 *     units are created. Base units are typically dimensionally independent.
 *     Although, the actual unit dimension is determinate by the current
 *     {@linkplain Dimension.Model model}. Using the {@linkplain
 *     Dimension.Model#STANDARD standard} model, all seven SI base units
 *     are dimensionally independent.</p>
 *
 * <p> This class defines the "standard base units" which includes SI base
 *     units and possibly others user-defined base units. It does not represent
 *     the base units of a specific {@link SystemOfUnits}.</p>
 *
 * @param <Q> The type of the quantity measured by this unit.
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.8 ($Revision: 127 $), $Date: 2010-02-17 10:13:47 +0100 (Mi, 17 Feb 2010) $
 * @see <a href="http://en.wikipedia.org/wiki/SI_base_unit">
 *       Wikipedia: SI base unit</a>
 */
public class BaseUnit<Q extends Quantity> extends Unit<Q> {
    /**
     * The name of the unit, not null.
     */
    private transient final String name;

    /**
     * Holds the symbol.
     */
    private transient final String symbol;

    /** The serialVersionUID */
    private static final long serialVersionUID = 1234567654321265167L;

    /**
     * Creates a base unit having the specified symbol.
     *
     * @param name the name of this base unit.
     * @param symbol the symbol of this base unit.
     * @throws IllegalArgumentException if the specified symbol is
     *         associated to a different unit.
     */
    public BaseUnit(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
        // Checks if the symbol is associated to a different unit.
        synchronized (Unit.SYMBOL_TO_UNIT) {
            Unit<?> unit = Unit.SYMBOL_TO_UNIT.get(symbol);
            if (unit == null) {
                Unit.SYMBOL_TO_UNIT.put(symbol, this);
                return;
            }
            if (!(unit instanceof BaseUnit<?>))
                throw new IllegalArgumentException("Symbol " + symbol + " is associated to a different unit");
        }
    }

    /**
     * Creates a base unit having the specified symbol.
     *
     * @param symbol the symbol of this base unit.
     * @throws IllegalArgumentException if the specified symbol is
     *         associated to a different unit.
     */
    public BaseUnit(String symbol) {
        this(symbol, symbol);
    }

    /**
     * Gets the name of the unit, used as an identifier for the unit.
     * <p>
     * Implementations should use the name that best represents themselves.
     * The name is not localized.
     *
     * @return the name of the unit, never null
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the unique symbol for this unit.
     *
     * @return this unit symbol.
     */
    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that)
            return true;
        if (!(that instanceof BaseUnit<?>))
            return false;
        BaseUnit<?> thatUnit = (BaseUnit<?>) that;
        return this.symbol.equals(thatUnit.symbol);
    }

    @Override
    public int hashCode() {
        return symbol.hashCode();
    }

    @Override
    public Unit<Q> toSI() {
        return this;
    }

    @Override
    public UnitConverter getConverterToSI() {
        return UnitConverter.IDENTITY;
    }

    @Override
    public Dimension getDimension() {
        return Dimension.getModel().getDimension(this);
    }

    @Override
    public UnitConverter getDimensionalTransform() {
        return Dimension.getModel().getTransform(this);
    }
}
