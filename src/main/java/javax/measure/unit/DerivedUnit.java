/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.unit;

import javax.measure.Quantity;
import javax.measure.Unit;

/**
 * <p> This class identifies the units created by combining or transforming
 *     other units.</p>
 *
 * @param <Q> The type of the quantity measured by this unit.
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.1, ($Revision: 127 $) $Date: 2010-02-17 10:13:47 +0100 (Mi, 17 Feb 2010) $
 */
public abstract class DerivedUnit<Q extends Quantity> extends Unit<Q> {
    /**
     * The name of the unit, not null.
     */
    private transient final String name;

    /**
     * Holds the symbol.
     */
    protected final String symbol;

    /** The serialVersionUID */
    private static final long serialVersionUID = 1237893765472362641L;

    /**
     * Default constructor.
     * Creates the derived unit setting an empty symbol.
     */
    protected DerivedUnit() {
        this("");
    }

    /**
     * Creates a derived unit having the specified name symbol.
     *
     * @param name the name of this derived unit.
     * @param symbol the symbol of this derived unit.
     * @throws IllegalArgumentException if the specified name/symbol combination is
     *         associated to a different unit.
     */
    public DerivedUnit(String name, String symbol) {
        super();
        this.name = name;
        this.symbol = symbol;
    }

    /**
     * Creates a derived unit having the specified symbol.
     *
     * @param symbol the symbol of this derived unit.
     * @throws IllegalArgumentException if the specified symbol is
     *         associated to a different unit.
     */
    public DerivedUnit(String symbol) {
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
     * Returns the symbol for this unit.
     *
     * @return this unit symbol.
     */
    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public int hashCode() {
        return symbol.hashCode();
    }
}
