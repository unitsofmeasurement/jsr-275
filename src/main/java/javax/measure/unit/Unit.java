/**
 * JEAN-MARIE DAUTELLE, WERNER KEIL ARE WILLING TO LICENSE THIS SPECIFICATION TO YOU ONLY UPON THE CONDITION THAT YOU ACCEPT ALL OF THE TERMS CONTAINED IN THIS LICENSE AGREEMENT ("AGREEMENT"). PLEASE READ THE TERMS AND CONDITIONS OF THIS AGREEMENT CAREFULLY. BY DOWNLOADING THIS SPECIFICATION, YOU ACCEPT THE TERMS AND CONDITIONS OF THIS AGREEMENT. IF YOU ARE NOT WILLING TO BE BOUND BY THEM, SELECT THE "DECLINE" BUTTON AT THE BOTTOM OF THIS PAGE AND THE DOWNLOADING PROCESS WILL NOT CONTINUE.
 *
 * Specification: JSR 275 - Units Specification ("Specification")
 *
 * Version: 0.9.4
 * Status: Pre-FCS Public Release
 * Release: December 4, 2009
 *
 * Copyright 2005-2009 Jean-Marie Dautelle, Werner Keil
 * All rights reserved.
 *
 *
 * NOTICE
 *
 * The Specification is protected by copyright and the information described therein may be protected by one or more U.S. patents, foreign patents, or pending applications. Except as provided under the following license, no part of the Specification may be reproduced in any form by any means without the prior written authorization of Jean-Marie Dautelle, Werner Keil and its
 * licensors, if any. Any use of the Specification and the information described therein will be governed by the terms and conditions of this Agreement.
 *
 *
 * Subject to the terms and conditions of this license, including your compliance with Paragraphs 1, 2 and 3 below, Jean-Marie Dautelle and Werner Keil hereby grant you a fully-paid, non-exclusive, non-transferable, limited license (without the right to sublicense) under Jean-Marie Dautelle and Werner Keil's intellectual property rights to:
 *
 *    1. Review the Specification for the purposes of evaluation. This includes: (i) developing implementations of the Specification for your internal, non-commercial use; (ii) discussing the Specification with any third party; and (iii) excerpting brief portions of the Specification in oral or written communications which discuss the Specification provided that such excerpts do not in the aggregate constitute a significant portion of the Specification.
 *
 *    2. Distribute implementations of the Specification to third parties for their testing and evaluation use, provided that any such implementation:
 *
 * (i) does not modify, subset, superset or otherwise extend the Licensor Name Space, or include any public or protected packages, classes, Java interfaces, fields or methods within the Licensor Name Space other than those required/authorized by the Specification or Specifications being implemented;
 *
 * (ii) is clearly and prominently marked with the word "UNTESTED" or "EARLY ACCESS" or "INCOMPATIBLE" or "UNSTABLE" or "BETA" in any list of available builds and in proximity to every link initiating its download, where the list or link is under Licensee's control; and
 *
 * (iii) includes the following notice:
 * "This is an implementation of an early-draft specification developed under the Java Community Process (JCP) and is made available for testing and evaluation purposes only. The code is not compatible with any specification of the JCP."
 *
 *    3. Distribute applications written to the Specification to third parties for their testing and evaluation use, provided that any such application includes the following notice:
 *       "This is an application written to interoperate with an early-draft specification developed under the Java Community Process (JCP) and is made available for testing and evaluation purposes only. The code is not compatible with any specification of the JCP."
 *
 * The grant set forth above concerning your distribution of implementations of the Specification is contingent upon your agreement to terminate development and distribution of your implementation of early draft upon final completion of the Specification.  If you fail to do so, the foregoing grant shall be considered null and void.
 *
 * Other than this limited license, you acquire no right, title or interest in or to the Specification or any other Jean-Marie Dautelle and Werner Keil intellectual property, and the Specification may only be used in accordance with the license terms set forth herein. This license will expire on the earlier of:  (a) two (2) years from the date of Release listed above; (b) the date on which the final version of the Specification is publicly released; or (c) the date on which the Java Specification Request (JSR) to which the Specification corresponds is withdrawn.  In addition, this license will terminate immediately without notice from Jean-Marie Dautelle, Werner Keil if you fail to comply with any provision of this license.  Upon termination, you must cease use of or destroy the Specification.
 *
 * "Licensor Name Space" means the public class or interface declarations whose names begin with "java", "javax", "org.jscience" or their equivalents in any subsequent naming convention adopted through the Java Community Process, or any recognized successors or replacements thereof
 *
 *
 * TRADEMARKS
 *
 * No right, title, or interest in or to any trademarks, service marks, or trade names of Jean-Marie Dautelle, Werner Keil or Jean-Marie Dautelle and Werner Keil's licensors is granted hereunder. Java and Java-related logos, marks and names are trademarks or registered trademarks of Sun Microsystems, Inc. in the U.S. and other countries.
 *
 *
 * DISCLAIMER OF WARRANTIES
 *
 * THE SPECIFICATION IS PROVIDED "AS IS" AND IS EXPERIMENTAL AND MAY CONTAIN DEFECTS OR DEFICIENCIES WHICH CANNOT OR WILL NOT BE CORRECTED BY JEAN-MARIE DAUTELLE, WERNER KEIL. JEAN-MARIE DAUTELLE AND WERNER KEIL MAKE NO REPRESENTATIONS OR WARRANTIES, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO, WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT THAT THE CONTENTS OF THE SPECIFICATION ARE SUITABLE FOR ANY PURPOSE OR THAT ANY PRACTICE OR IMPLEMENTATION OF SUCH CONTENTS WILL NOT INFRINGE ANY THIRD PARTY PATENTS, COPYRIGHTS, TRADE SECRETS OR OTHER RIGHTS. This document does not represent any commitment to release or implement any portion of the Specification in any product.
 *
 * THE SPECIFICATION COULD INCLUDE TECHNICAL INACCURACIES OR TYPOGRAPHICAL ERRORS. CHANGES ARE PERIODICALLY ADDED TO THE INFORMATION THEREIN; THESE CHANGES WILL BE INCORPORATED INTO NEW VERSIONS OF THE SPECIFICATION, IF ANY. JEAN-MARIE DAUTELL AND WERNER KEIL MAY MAKE IMPROVEMENTS AND/OR CHANGES TO THE PRODUCT(S) AND/OR THE PROGRAM(S) DESCRIBED IN THE SPECIFICATION AT ANY TIME. Any use of such changes in the Specification will be governed by the then-current license for the applicable version of the Specification.
 *
 *
 * LIMITATION OF LIABILITY
 *
 * TO THE EXTENT NOT PROHIBITED BY LAW, IN NO EVENT WILL JEAN-MARIE DAUTELLE, WERNER KEIL OR THEIR LICENSORS BE LIABLE FOR ANY DAMAGES, INCLUDING WITHOUT LIMITATION, LOST REVENUE, PROFITS OR DATA, OR FOR SPECIAL, INDIRECT, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF OR RELATED TO ANY FURNISHING, PRACTICING, MODIFYING OR ANY USE OF THE SPECIFICATION, EVEN IF JEAN-MARIE DAUTELLE, WERNER KEIL AND/OR ITS LICENSORS HAVE BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * You will hold Jean-Marie Dautelle, Werner Keil (and its licensors) harmless from any claims based on your use of the Specification for any purposes other than the limited right of evaluation as described above, and from any claims that later versions or releases of any Specification furnished to you are incompatible with the Specification provided to you under this license.
 *
 *
 * RESTRICTED RIGHTS LEGEND
 *
 * If this Software is being acquired by or on behalf of the U.S. Government or by a U.S. Government prime contractor or subcontractor (at any tier), then the Government's rights in the Software and accompanying documentation shall be only as set forth in this license; this is in
 * accordance with 48 C.F.R. 227.7201 through 227.7202-4 (for Department of Defense (DoD) acquisitions) and with 48 C.F.R. 2.101 and 12.212 (for non-DoD acquisitions).
 *
 *
 * REPORT
 *
 * You may wish to report any ambiguities, inconsistencies or inaccuracies you may find in connection with your evaluation of the Specification ("Feedback"). To the extent that you provide Jean-Marie Dautelle, Werner Keil with any Feedback, you hereby: (i) agree that such Feedback is provided on a non-proprietary and non-confidential basis, and (ii) grant Jean-Marie Dautelle, Werner Keil a perpetual, non-exclusive, worldwide, fully paid-up, irrevocable license, with the right to sublicense through multiple levels of sublicensees, to incorporate, disclose, and use without limitation the Feedback for any purpose related to the Specification and future versions, implementations, and test suites thereof.
 *
 *
 * GENERAL TERMS
 *
 * Any action related to this Agreement will be governed by California law and controlling U.S. federal law. The U.N. Convention for the International Sale of Goods and the choice of law rules of any jurisdiction will not apply.
 *
 * The Specification is subject to U.S. export control laws and may be subject to export or import regulations in other countries. Licensee agrees to comply strictly with all such laws and regulations and acknowledges that it has the responsibility to obtain such licenses to export, re-export or import as may be required after delivery to Licensee.
 *
 * This Agreement is the parties' entire agreement relating to its subject matter. It supersedes all prior or contemporaneous oral or written communications, proposals, conditions, representations and warranties and prevails over any conflicting or additional terms of any quote, order, acknowledgment, or other communication between the parties relating to its subject matter during the term of this Agreement. No modification to this Agreement will be binding, unless in writing and signed by an authorized representative of each party.
 */
package javax.measure.unit;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.ParsePosition;
import java.util.HashMap;

import javax.measure.converter.AddConverter;
import javax.measure.converter.ConversionException;
import javax.measure.converter.LinearConverter;
import javax.measure.converter.MultiplyConverter;
import javax.measure.converter.RationalConverter;
import javax.measure.converter.UnitConverter;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Quantity;

/**
 * <p> This class represents a determinate {@link javax.measure.quantity.Quantity
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
 * usually a unit not convertible to its {@link #toSI standard unit}. Such units
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
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:steve@unidata.ucar.edu">Steve Emmerson</a>
 * @author Martin Desruisseaux
 * @version 1.0, April 15, 2009
 * @see <a href="http://en.wikipedia.org/wiki/Units_of_measurement"> Wikipedia:
 * Units of measurement</a>
 */
public abstract class Unit<Q extends Quantity> implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 417699567364322109L;

	/**
     * Holds the dimensionless unit <code>ONE</code>.
     */
    public static final Unit<Dimensionless> ONE = new ProductUnit<Dimensionless>();

    /**
     * Holds the unique symbols collection (base unit or alternate units).
     */
    static final HashMap<String, Unit<?>> SYMBOL_TO_UNIT = new HashMap<String, Unit<?>>();

    /**
     * Default constructor. Package private visibility. Subclasses should derive
     * from either BaseUnit, DerivedUnit or AnnotatedUnit.
     */
    Unit() {
    }

    // ////////////////////////////////////////////////////
    // Contract methods (for sub-classes to implement). //
    // ////////////////////////////////////////////////////

    /**
     * Returns the standard unit from which this unit is derived. The SI unit
     * identifies the "type" of {@link javax.measure.quantity.Quantity quantity}
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
     * {@link javax.measure.quantity.Quantity quantity} for which the unit is
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
    @SuppressWarnings("unchecked")
    public final <T extends Quantity> Unit<T> asType(Class<T> type)
            throws ClassCastException {
        Dimension thisDimension = this.getDimension();
        Unit<T> quantityUnit = null;
        try {
            quantityUnit = (Unit<T>) type.getField("UNIT").get(null);
        } catch (Exception e) {
            throw new UnsupportedOperationException(
                    "The quantity class " + type + " does not have a public static field UNIT holding the SI unit " + " for the quantity.");
        }
        Dimension quantityDimension = quantityUnit.getDimension();
        if (!thisDimension.equals(quantityDimension))
            throw new ClassCastException("Dimension of " + this + " is " + thisDimension + ", but the dimension of quantity of type " + type.getName() + " is " + quantityDimension);
        return (Unit<T>) this;
    }

    /**
     * Returns the dimension of this unit (depends upon the current dimensional
     * {@link Dimension.Model model}).
     *
     * @return the dimension of this unit for the current model.
     */
    public final Dimension getDimension() {
        Unit<?> systemUnit = this.toSI();
        if (systemUnit instanceof BaseUnit<?>)
            return Dimension.Model.STANDARD.getDimension((BaseUnit<?>) systemUnit);
        if (systemUnit instanceof AlternateUnit<?>)
            return ((AlternateUnit<?>) systemUnit).getParent().getDimension();
        // Product of units.
        ProductUnit<?> productUnit = (ProductUnit<?>) systemUnit;
        Dimension dimension = Dimension.NONE;
        for (int i = 0; i < productUnit.getUnitCount(); i++) {
            Unit<?> unit = productUnit.getUnit(i);
            Dimension d = unit.getDimension().pow(productUnit.getUnitPow(i)).root(productUnit.getUnitRoot(i));
            dimension = dimension.times(d);
        }
        return dimension;
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
     * is unknown at compile-time or when the {@link Dimension.Model 
     * dimensional model} allows for conversion between units of
     * different type. To convert to a unit having the same parameterized type,
     * {@link #getConverterTo(javax.measure.unit.Unit)} is preferred
     * (no checked exception raised).
     *
     * @param that the unit to which to convert the numeric values.
     * @return the converter from this unit to <code>that</code> unit.
     * @throws ConversionException if the unis are not compatible (e.g.
     *         <code>!this.isCompatible(that)</code>).
     * @throws UnsupportedOperationException if the converter cannot be
     *         constructed.
     */
    public final UnitConverter getConverterToAny(Unit<?> that)
            throws ConversionException, UnsupportedOperationException {
        return ((this == that) || this.equals(that)) ? UnitConverter.IDENTITY
                : searchConverterTo(that);
    }

    private UnitConverter searchConverterTo(Unit<?> that)
            throws ConversionException {
        Unit<Q> thisSI = this.toSI();
        Unit<?> thatSI = that.toSI();
        if (thisSI.equals(thatSI))
            return that.getConverterToSI().inverse().concatenate(
                    this.getConverterToSI());
        // Use dimensional transforms.
        if (!thisSI.getDimension().equals(thatSI.getDimension()))
            throw new ConversionException(this + " is not compatible with " + that);
        // Transform between SystemUnit and BaseUnits is Identity.
        UnitConverter thisTransform = this.getConverterToSI().concatenate(
                transformOf(this.toBaseUnits()));
        UnitConverter thatTransform = that.getConverterToSI().concatenate(
                transformOf(that.toBaseUnits()));
        return thatTransform.inverse().concatenate(thisTransform);
    }

    private Unit<?> toBaseUnits() {
        Unit<?> systemUnit = this.toSI();
        if (systemUnit instanceof BaseUnit<?>)
            return systemUnit;
        if (systemUnit instanceof AlternateUnit<?>)
            return ((AlternateUnit<?>) systemUnit).getParent().toBaseUnits();
        if (systemUnit instanceof ProductUnit<?>) {
            ProductUnit<?> productUnit = (ProductUnit<?>) systemUnit;
            Unit<?> baseUnits = ONE;
            for (int i = 0; i < productUnit.getUnitCount(); i++) {
                Unit<?> unit = productUnit.getUnit(i).toBaseUnits();
                unit = unit.pow(productUnit.getUnitPow(i));
                unit = unit.root(productUnit.getUnitRoot(i));
                baseUnits = baseUnits.times(unit);
            }
            return baseUnits;
        } else
            throw new UnsupportedOperationException("System Unit cannot be an instance of " + this.getClass());
    }

    private static UnitConverter transformOf(Unit<?> baseUnits) throws UnsupportedOperationException {
        if (baseUnits instanceof BaseUnit<?>)
            return Dimension.Model.STANDARD.getTransform((BaseUnit<?>) baseUnits);
        // Product of units.
        ProductUnit<?> productUnit = (ProductUnit<?>) baseUnits;
        UnitConverter converter = UnitConverter.IDENTITY;
        for (int i = 0; i < productUnit.getUnitCount(); i++) {
            Unit<?> unit = productUnit.getUnit(i);
            UnitConverter cvtr = transformOf(unit);
            if (!(cvtr instanceof LinearConverter))
                throw new UnsupportedOperationException(baseUnits + " is non-linear, cannot convert");
            if (productUnit.getUnitRoot(i) != 1)
                throw new UnsupportedOperationException(productUnit + " holds a base unit with fractional exponent");
            int pow = productUnit.getUnitPow(i);
            if (pow < 0) { // Negative power.
                pow = -pow;
                cvtr = cvtr.inverse();
            }
            for (int j = 0; j < pow; j++) {
                converter = converter.concatenate(cvtr);
            }
        }
        return converter;
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
    public final Unit<Q> plus(double offset) {
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
    public final Unit<Q> times(long factor) {
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
    public final Unit<Q> times(double factor) {
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
    @SuppressWarnings("unchecked")
    public final Unit<?> times(Unit<?> that) {
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
    @SuppressWarnings("unchecked")
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
        return this.times(that.inverse());
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
            return this.times(this.pow(n - 1));
        else if (n == 0)
            return ONE;
        else
            // n < 0
            return ONE.divide(this.pow(-n));
    }

    /**
     * Returns a unit instance that is defined from the specified character
     * sequence using the {@link UnitFormat#getStandard standard} unit format
     * (<a href="http://unitsofmeasure.org/">UCUM</a> based). This method is
     * capable of parsing any units representations produced by
     * {@link #toString()}. Locale-sensitive unit formatting and parsing are
     * handled by the {@link UnitFormat} class and its subclasses.
     *
     * <p>
     * This method can be used to parse dimensionless units.[code]
     * Unit<Dimensionless> PERCENT = Unit.valueOf("100").inverse().asType(Dimensionless.class); [/code]
     *
     * @param csq the character sequence to parse.
     * @return
     * <code>UnitFormat.getStandard().parse(csq, new ParsePosition(0))</code>
     * @throws IllegalArgumentException if the specified character sequence
     * cannot be correctly parsed (e.g. not UCUM compliant).
     */
    public static Unit<?> valueOf(CharSequence csq) {
        return UnitFormat.getStandard().parse(csq, new ParsePosition(0));
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
     * Locale-sensitive unit formatting and parsing is handled by the
     * {@link UnitFormat} class and its subclasses.
     *
     * <p>Custom units types should override this method as they will not be
     * recognized by the UCUM format.</p>
     *
     *
     * @return <code>UnitFormat.getStandard().format(this)</code>
     */
    @Override
    public String toString() {
        return UnitFormat.getStandard().format(this);
    }
}
