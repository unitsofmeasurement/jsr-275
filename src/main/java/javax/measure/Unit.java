/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.ParsePosition;
import java.util.HashMap;

import javax.measure.quantity.Dimensionless;
import javax.measure.unit.AddConverter;
import javax.measure.unit.AlternateUnit;
import javax.measure.unit.AnnotatedUnit;
import javax.measure.unit.BaseUnit;
import javax.measure.unit.CompoundUnit;
import javax.measure.unit.DerivedUnit;
import javax.measure.unit.MultiplyConverter;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.RationalConverter;
import javax.measure.unit.TransformedUnit;
import javax.measure.unit.UnitFormat;

/**
 * <p> This class represents a determinate {@linkplain javax.measure.quantity.Quantity
 * quantity} (as of length, time, heat, or value) adopted as a standard of
 * measurement.</p>
 *
 * <p> It is helpful to think of instances of this class as recording the history by
 * which they are created. Thus, for example, the string "g/kg" (which is a
 * dimensionless unit) would result from invoking the method toString() on a
 * unit that was created by dividing a gram unit by a kilogram unit. Yet, "kg"
 * divided by "kg" returns {@link #ONE} and not "kg/kg" due to automatic unit
 * factorization.</p>
 *
 * <p> This class supports the multiplication of offsets units. The result is
 * usually a unit not convertible to its {@linkplain #toSI standard unit}. Such units
 * may appear in derivative quantities. For example Celsius per meter is an unit of gradient,
 * which is common in atmospheric and oceanographic research.</p>
 *
 * <p> Units raised at rational powers are also supported. For example the cubic
 * root of liter is a unit compatible with meter.</p>
 *
 * <p> Units specializations can only be defined by sub-classing either
 * {@link BaseUnit}, {@link DerivedUnit} or {@link AnnotatedUnit} (the unit
 * constructor is package private).For example:[code]
 *     public LengthUnit extends AnnotatedUnit<Length> {
 *         public static LengthUnit METER = new LengthUnit(SI.METER, "myOwnUnitType"); // Equivalent to SI.METER
 *         LengthUnit(Unit<Length> realUnit, String annotation) { super(realUnit, annotation); }
 *     }[/code]</p>
 *
 * <p> Instances of this class and sub-classes are immutable.</p>
 *
 * @param <Q> The type of the quantity measured by this unit.
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:steve@unidata.ucar.edu">Steve Emmerson</a>
 * @author Martin Desruisseaux
 * @version 1.2 ($Revision: 127 $), $Date: 2010-02-17 10:13:47 +0100 (Mi, 17 Feb 2010) $
 * @see <a href="http://en.wikipedia.org/wiki/Units_of_measurement"> Wikipedia:
 * Units of measurement</a>
 */
public abstract class Unit<Q extends Quantity> implements Serializable {

    /**
     * For cross-version compatibility.
     */
    private static final long serialVersionUID = 417699567364322109L;

   /**
     * Holds the dimensionless unit <code>ONE</code>.
     */
    public static final Unit<Dimensionless> ONE = new ProductUnit<Dimensionless>();

    /**
     * Holds the unique symbols collection (base unit or alternate units).
     */
    protected static final HashMap<String, Unit<?>> SYMBOL_TO_UNIT = new HashMap<String, Unit<?>>();

    /**
     * Default constructor. Protected visibility. Subclasses should derive
     * from either BaseUnit, DerivedUnit or AnnotatedUnit.
     */
    protected Unit() {
    }

    /**
     * Gets the name of the unit, used as an identifier for the unit.
     * <p>
     * Implementations should use the name that best represents themselves.
     * The name is not localized.
     *
     * @return the name of the unit, never null
     */
    public abstract String getName();

    /**
     * Returns a unique symbol for the unit.
     *
     * @return this unit symbol.
     */
    public abstract String getSymbol();

    // ////////////////////////////////////////////////////
    // Contract methods (for sub-classes to implement). //
    // ////////////////////////////////////////////////////

    /**
     * Returns the standard unit from which this unit is derived. The SI unit
     * identifies the "type" of {@linkplain javax.measure.quantity.Quantity quantity}
     * for which this unit is employed. For example:[code]
     *     boolean isAngularVelocity(Unit<?> u) {
     *         return u.toSI().equals(RADIAN.divide(SECOND));
     *     }
     *     assert(REVOLUTION.divide(MINUTE).isAngularVelocity());
     * [/code]
     *
     * @return the system unit this unit is derived from.
     */
    public abstract Unit<Q> toSI();

    /**
     * Returns the converter to the standard unit.
     *
     * <p><i> Note: Having the same SI unit is not sufficient to ensure that a
     * converter exists between the two units (e.g. °C/m and K/m).</i></p>
     *
     * @return the unit converter from this unit to its standard unit.
     */
    public abstract UnitConverter getConverterToSI();

    /**
     * Returns the hash code for this unit.
     *
     * @return this unit hashcode value.
     */
    @Override
    public abstract int hashCode();

    /**
     * Indicates if the specified unit can be considered equals to the one
     * specified.
     *
     * @param that the object to compare to.
     * @return <code>true</code> if this unit is considered equal to that unit;
     * <code>false</code> otherwise.
     */
    @Override
    public abstract boolean equals(Object that);

    /**
     * Indicates if this unit is a standard unit (base units and alternate units
     * are standard units). The standard unit identifies the "type" of
     * {@linkplain javax.measure.quantity.Quantity quantity} for which the unit is
     * employed.
     *
     * @return <code>this.toSI().equals(this)</code>
     */
    public boolean isSI() {
        return toSI().equals(this);
    }

    /**
     * Indicates if this unit is compatible with the unit specified. Units don't
     * need to be equals to be compatible. For example:[code]
     *     RADIAN.equals(ONE) == false
     *     RADIAN.isCompatible(ONE) == true
     * [/code]
     *
     * @param that the other unit.
     * @return <code>this.getDimension().equals(that.getDimension())</code>
     * @see #getDimension()
     */
    public final boolean isCompatible(Unit<?> that) {
        return (this == that) || this.toSI().equals(that.toSI()) || this.getDimension().equals(that.getDimension());
    }

    /**
     * Casts this unit to a parameterized unit of specified nature or throw a
     * <code>ClassCastException</code> if the dimension of the specified
     * quantity and this unit's dimension do not match. For example:[code]
     *      Unit<Length> LIGHT_YEAR = NonSI.C.times(NonSI.YEAR).asType(Length.class);
     * [/code]
     *
     * @param type the quantity class identifying the nature of the unit.
     * @return this unit parameterized with the specified type.
     * @throws ClassCastException if the dimension of this unit is different
     * from the specified quantity dimension.
     * @throws UnsupportedOperationException if the specified quantity class
     * does not have a public static field named "UNIT" holding the SI unit for
     * the quantity.
     */
//    @SuppressWarnings("unchecked")
//    public final <T extends Quantity> Unit<T> asType(Class<T> type)
//            throws ClassCastException {
//        Dimension thisDimension = this.getDimension();
//        Unit<T> quantityUnit = null;
//        try {
//            //quantityUnit = (Unit<T>) type.getMethod("unit").getGenericReturnType();
//          quantityUnit = QuantityFactory.create(type, 0, unit)
//        } catch (Exception e) {
//            throw new UnsupportedOperationException(
//                    "The quantity class " + type + " does not have a public method UNIT holding the SI unit " + " for the quantity.");
//        }
//        Dimension quantityDimension = quantityUnit.getDimension();
//        if (!thisDimension.equals(quantityDimension))
//            throw new ClassCastException("Dimension of " + this + " is " + thisDimension + ", but the dimension of quantity of type " + type.getName() + " is " + quantityDimension);
//        return (Unit<T>) this;
//    }

    /**
     * Returns the dimension of this unit (depends upon the current dimensional
     * {@linkplain Dimension.Model model}). Custom system units should override
     * this method.
     *
     * @return the dimension of this unit for the current model.
     * @throws UnsupportedOperationException if this unit is a SI unit
     *         and does not override this method.
     */
    public Dimension getDimension() {
        if (!isSI())
            return this.toSI().getDimension();
        throw new UnsupportedOperationException(
                "Custom unit of type " + this.getClass() + " should override Unit.getDimension()");
    }

    /**
     * Returns the intrinsic dimensional transform of this unit
     * (depends upon the current {@linkplain Dimension.Model model} for
     * {@link BaseUnit} instance). Custom system units should override this
     * method.
     *
     * @return the intrinsic transformation of this unit relatively to its
     *         dimension.
     * @throws UnsupportedOperationException if this unit is a SI unit
     *         and does not override this method.
     */
    public UnitConverter getDimensionalTransform() {
        if (!isSI())
            return this.getConverterToSI().concatenate(this.toSI().getDimensionalTransform());
        throw new UnsupportedOperationException(
                "Custom unit of type " + this.getClass() + " should override Unit.getDimensionalTransform()");
    }

    /**
     * Returns a converter of numeric values from this unit to another unit of
     * same type (convenience method not raising checked exception).
     *
     * @param that the unit of same type to which to convert the numeric values.
     * @return the converter from this unit to <code>that</code> unit.
     * @throws UnsupportedOperationException if the converter cannot be
     *         constructed.
     */
    public final UnitConverter getConverterTo(Unit<Q> that) throws UnsupportedOperationException {
        try {
            return getConverterToAny(that);
        } catch (ConversionException e) { // Should not happen.
            throw new UnsupportedOperationException(e);
        }
    }

    /**
     * Returns a converter form this unit to the specified unit of type unknown.
     * This method can be used when the dimension of the specified unit
     * is unknown at compile-time or when the {@linkplain Dimension.Model
     * dimensional model} allows for conversion between units of
     * different type. To convert to a unit having the same parameterized type,
     * {@link #getConverterTo(javax.measure.Unit)} is preferred
     * (no checked exception raised).
     *
     * @param that the unit to which to convert the numeric values.
     * @return the converter from this unit to <code>that</code> unit.
     * @throws ConversionException if the units are not compatible (e.g.
     *         <code>!this.isCompatible(that)</code>).
     * @throws UnsupportedOperationException if the converter cannot be
     *         constructed.
     */
    protected UnitConverter getConverterToAny(Unit<?> that)
            throws ConversionException, UnsupportedOperationException {
        return ((this == that) || this.equals(that)) ? UnitConverter.IDENTITY
                : searchConverterTo(that);
    }

    private UnitConverter searchConverterTo(Unit<?> that)
            throws ConversionException {
        // First we have find a common dimension to convert to.

        // Try the SI unit.
        Unit<Q> thisSI = this.toSI();
        Unit<?> thatSI = that.toSI();
        if (thisSI.equals(thatSI))
            return that.getConverterToSI().inverse().concatenate(
                    this.getConverterToSI());

        // Use dimensional unit.
        if (!thisSI.getDimension().equals(thatSI.getDimension()))
            throw new ConversionException(this + " is not compatible with " + that);
        UnitConverter thisTransform = thisSI.getDimensionalTransform().concatenate(this.getConverterToSI());
        UnitConverter thatTransform = thatSI.getDimensionalTransform().concatenate(that.getConverterToSI());
        return thatTransform.inverse().concatenate(thisTransform);
    }

    /**
     * Returns a unit equivalent to this unit but used in expressions to
     * distinguish between quantities of a different nature but of the same
     * dimensions.
     *
     * <p> Examples of alternate units:[code]
     *     Unit<Angle> RADIAN = ONE.alternate("rad");
     *     Unit<Force> NEWTON = METRE.times(KILOGRAM).divide(SECOND.pow(2)).alternate("N");
     *     Unit<Pressure> PASCAL = NEWTON.divide(METRE.pow(2)).alternate("Pa");
     * [/code]
     * </p>
     *
     * @param <A> The type of the quantity measured by the new alternate unit.
     *
     * @param symbol the new symbol for the alternate unit.
     * @return the alternate unit.
     * @throws UnsupportedOperationException if this unit is not a standard
     * unit.
     * @throws IllegalArgumentException if the specified symbol is already
     * associated to a different unit.
     */
    public final <A extends Quantity> AlternateUnit<A> alternate(String symbol) {
        return new AlternateUnit<A>(symbol, this);
    }

    /**
     * Returns the combination of this unit with the specified sub-unit.
     * Compound units are typically used for formatting purpose. Examples of
     * compound units:[code]
     *     Unit<Length> FOOT_INCH = FOOT.compound(INCH);
     *     Unit<Duration> HOUR_MINUTE_SECOND = HOUR.compound(MINUTE).compound(SECOND);
     * [/code]
     *
     * @param that the least significant unit to combine with this unit.
     * @return the corresponding compound unit.
     */
    public final CompoundUnit<Q> compound(Unit<Q> that) {
        return new CompoundUnit<Q>(this, that);
    }

    /**
     * Returns the unit derived from this unit using the specified converter.
     * The converter does not need to be linear. For example:[code]
     *     Unit<Dimensionless> DECIBEL = Unit.ONE.transform(
     *         new LogConverter(10).inverse().concatenate(
     *             new RationalConverter(1, 10)));
     * [/code]
     *
     * @param operation the converter from the transformed unit to this unit.
     * @return the unit after the specified transformation.
     */
    public final Unit<Q> transform(UnitConverter operation) {
        if (this instanceof TransformedUnit<?>) {
            TransformedUnit<Q> tf = (TransformedUnit<Q>) this;
            Unit<Q> parent = tf.getParentUnit();
            UnitConverter toParent = tf.toParentUnit().concatenate(operation);
            if (toParent == UnitConverter.IDENTITY)
                return parent;
            return new TransformedUnit<Q>(parent, toParent);
        }
        if (operation == UnitConverter.IDENTITY)
            return this;
        return new TransformedUnit<Q>(this, operation);
    }

    /**
     * Returns the result of adding an offset to this unit. The returned unit is
     * convertible with all units that are convertible with this unit.
     *
     * @param offset the offset added (expressed in this unit, e.g.
     * <code>CELSIUS = KELVIN.plus(273.15)</code>).
     * @return <code>this.transform(new AddConverter(offset))</code>
     */
    public final Unit<Q> add(double offset) {
        if (offset == 0)
            return this;
        return transform(new AddConverter(offset));
    }

    /**
     * Returns the result of multiplying this unit by an exact factor.
     *
     * @param factor the exact scale factor (e.g.
     * <code>KILOMETRE = METRE.times(1000)</code>).
     * @return <code>this.transform(new RationalConverter(factor, 1))</code>
     */
    public final Unit<Q> multiply(long factor) {
        if (factor == 1)
            return this;
        return transform(new RationalConverter(BigInteger.valueOf(factor),
                BigInteger.ONE));
    }

    /**
     * Returns the result of multiplying this unit by a an approximate factor.
     *
     * @param factor the approximate factor (e.g.
     * <code>ELECTRON_MASS = KILOGRAM.times(9.10938188e-31)</code>).
     * @return <code>this.transform(new MultiplyConverter(factor))</code>
     */
    public final Unit<Q> multiply(double factor) {
        if (factor == 1)
            return this;
        return transform(new MultiplyConverter(factor));
    }

    /**
     * Returns the product of this unit with the one specified.
     *
     * @param that the unit multiplicand.
     * @return <code>this * that</code>
     */
    @SuppressWarnings({"unchecked","rawtypes"})
    public final Unit<?> multiply(Unit<?> that) {
        if (this.equals(ONE))
            return that;
        if (that.equals(ONE))
            return this;
        if (this.isRationalFactor())
            return that.transform(this.getConverterTo((Unit) ONE));
        if (that.isRationalFactor())
            return this.transform(that.getConverterTo((Unit) ONE));
        return ProductUnit.getProductInstance(this, that);
    }

    private boolean isRationalFactor() {
        if (!(this instanceof TransformedUnit<?>))
            return false;
        TransformedUnit<Q> tu = (TransformedUnit<Q>) this;
        return tu.getParentUnit().equals(ONE) && (tu.getConverterTo(tu.toSI()) instanceof RationalConverter);
    }

    /**
     * Returns the inverse of this unit.
     *
     * @return <code>1 / this</code>
     */
    @SuppressWarnings({"unchecked","rawtypes"})
    public final Unit<?> inverse() {
        if (this.equals(ONE))
            return this;
        if (this.isRationalFactor())
            return this.transform(this.getConverterTo((Unit) ONE).inverse());
        return ProductUnit.getQuotientInstance(ONE, this);
    }

    /**
     * Returns the result of dividing this unit by an exact divisor.
     *
     * @param divisor the exact divisor. (e.g.
     * <code>QUART = GALLON_LIQUID_US.divide(4)</code>).
     * @return <code>this.transform(new RationalConverter(1 , divisor))</code>
     */
    public final Unit<Q> divide(long divisor) {
        if (divisor == 1)
            return this;
        return transform(new RationalConverter(BigInteger.ONE, BigInteger.valueOf(divisor)));
    }

    /**
     * Returns the result of dividing this unit by an approximate divisor.
     *
     * @param divisor the approximate divisor.
     * @return <code>this.transform(new MultiplyConverter(1.0 / divisor))</code>
     */
    public final Unit<Q> divide(double divisor) {
        if (divisor == 1)
            return this;
        return transform(new MultiplyConverter(1.0 / divisor));
    }

    /**
     * Returns the quotient of this unit with the one specified.
     *
     * @param that the unit divisor.
     * @return <code>this / that</code>
     */
    public final Unit<?> divide(Unit<?> that) {
        return this.multiply(that.inverse());
    }

    /**
     * Returns a unit equals to the given root of this unit.
     *
     * @param n the root's order.
     * @return the result of taking the given root of this unit.
     * @throws ArithmeticException if <code>n == 0</code>.
     */
    public final Unit<?> root(int n) {
        if (n > 0)
            return ProductUnit.getRootInstance(this, n);
        else if (n == 0)
            throw new ArithmeticException("Root's order of zero");
        else
            // n < 0
            return ONE.divide(this.root(-n));
    }

    /**
     * Returns a unit equals to this unit raised to an exponent.
     *
     * @param n the exponent.
     * @return the result of raising this unit to the exponent.
     */
    public final Unit<?> pow(int n) {
        if (n > 0)
            return this.multiply(this.pow(n - 1));
        else if (n == 0)
            return ONE;
        else
            // n < 0
            return ONE.divide(this.pow(-n));
    }

    /**
     * Returns a unit instance that is defined from the specified character
     * sequence (text) using the {@linkplain UnitFormat#getStandard standard} unit format
     * (<a href="http://unitsofmeasure.org/">UCUM</a> based). This method is
     * capable of parsing any units representations produced by
     * {@link #toString()}. Locale-sensitive unit formatting and parsing are
     * handled by the {@link UnitFormat} class and its subclasses.
     *
     * <p>
     * This method can be used to parse dimensionless units.[code]
     * Unit<Dimensionless> PERCENT = Unit.valueOf("100").inverse().asType(Dimensionless.class); [/code]
     *
     * @param charSequence the character sequence to parse.
     * @return
     * <code>UnitFormat.getStandard().parse(csq, new ParsePosition(0))</code>
     * @throws IllegalArgumentException if the specified character sequence
     * cannot be correctly parsed (e.g. not UCUM compliant).
     */
    public static Unit<?> valueOf(CharSequence charSequence) {
        return UnitFormat.getInstance().parse(charSequence, new ParsePosition(0));
    }

    // ////////////////////
    // GENERAL CONTRACT //
    // ////////////////////
    /**
     * Returns the international <code>String</code> representation of this unit
     * (<a href="http://unitsofmeasure.org/">UCUM</a> based). The string
     * produced for a given unit is always the same; it is not affected by the
     * locale. This means that it can be used as a canonical string
     * representation for exchanging units, or as a key for a Hashtable, etc.
     * Locale-sensitive unit formatting and parsing is handled by
     * {@link UnitFormat} class and its subclasses.
     *
     * @return <code>UnitFormat.getStandard().format(this)</code>
     */
    @Override
    public String toString() {
        return UnitFormat.getInstance().format(this);
    }

    /**
     * Returns the locale representation of this unit.
     *
     * @return <code>UnitFormat.getInstance().format(this)</code>
     */
    protected String toLocalString() {
        // TODO needed?
        return UnitFormat.getInstance().format(this);
    }
}
