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
package javax.measure;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;

import java.text.ParsePosition;
import javax.measure.converter.UnitConverter;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

/**
 * <p> This class represents the immutable result of a scalar measurement stated
 *     in a known unit.</p>
 * 
 * <p> To avoid any lost of precision, known exact measure (e.g. physical 
 *     constants) should not be created from <code>double</code> constants but
 *     from their decimal representation.[code]
 *         public static final Measure<Velocity> C = Measure.valueOf("299792458 m/s").asType(Velocity.class);
 *         // Speed of Light (exact).
 *    [/code]</p>
 * 
 * <p> Measures can be converted to different units, the conversion precision is
 *     determined by the specified {@link MathContext}.[code]
 *         Measure<Velocity> milesPerHour = C.to(MILES_PER_HOUR, MathContext.DECIMAL128); // Use BigDecimal implementation.
 *         System.out.println(milesPerHour);
 * 
 *         > 670616629.3843951324266284896206156 [mi_i]/h
 *     [/code]
 *     If no precision is specified <code>double</code> precision is assumed.[code]
 *         Measure<Velocity> milesPerHour = C.to(MILES_PER_HOUR); // Use double implementation (fast).
 *         System.out.println(milesPerHour);
 * 
 *         > 670616629.3843951 [mi_i]/h
 *     [/code]</p>
 * 
 * <p> Applications may sub-class {@link Measure} for particular measurements
 *     types.[code]
 *         // Measurement of type Mass based on <code>double</code> primitive types.
 *         public class Weight extends Measure<Mass> { 
 *             private final double _kilograms; // Internal SI representation. 
 *             private Weight(double kilograms) { _kilograms = kilograms; }
 *             public static Weight valueOf(double value, Unit<Mass> unit) {
 *                 return new Weight(unit.getConverterTo(SI.KILOGRAM).convert(value));
 *             } 
 *             public Unit<Mass> getUnit() { return SI.KILOGRAM; } 
 *             public Double getValue() { return _kilograms; } 
 *             ...
 *         }
 * 
 *         // Complex numbers measurements.
 *         public class ComplexMeasure<Q extends Quantity> extends Measure<Q> {
 *             public Complex getValue() { ... } // Assuming Complex is a Number.
 *             ... 
 *         }
 * 
 *         // Specializations of complex numbers measurements.
 *         public class Current extends ComplexMeasure<ElectricCurrent> {...} 
 *         public class Tension extends ComplexMeasure<ElectricPotential> {...}
 *         [/code]</p>
 * 
 * <p> All instances of this class shall be immutable.</p>
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.0.4 ($Revision: 76 $), $Date: 2009-12-03 23:53:52 +0100 (Do, 03 Dez 2009) $
 */
public abstract class Measure<Q extends Quantity> implements Measurable<Q>,
        Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7811331952128203481L;

	/**
     * Default constructor.
     */
    protected Measure() {
    }

    /**
     * Returns the measurement numeric value.
     *
     * @return the measurement value.
     */
    public abstract Number getValue();

    /**
     * Returns the measurement unit.
     *
     * @return the measurement unit.
     */
    public abstract Unit<Q> getUnit();

    /**
     * Convenient method equivalent to <code>Math.round(doubleValue(unit))</code>.
     *
     * @return unit the unit in which the integer value is stated.
     * @throws ArithmeticException if this measure cannot be represented
     *         by a <code>long</code> number in the specified unit.
     */
    public long round(Unit<Q> unit) {
        return Math.round(doubleValue(unit));
    }

    /**
     * Convenient method equivalent to {@link #to(javax.measure.unit.Unit)
     * to(this.getUnit().toSI())}.
     *
     * @return this measure or a new measure equivalent to this measure but
     *         stated in SI units.
     * @throws ArithmeticException if the result is inexact and the quotient
     *         has a non-terminating decimal expansion.
     */
    public Measure<Q> toSI() {
        return to(this.getUnit().toSI());
    }

    /**
     * Returns this measure after conversion to specified unit. The default
     * implementation returns
     * <code>Measure.valueOf(doubleValue(unit), unit)</code>. If this measure is
     * already stated in the specified unit, then this measure is returned and
     * no conversion is performed.
     *
     * @param unit the unit in which the returned measure is stated.
     * @return this measure or a new measure equivalent to this measure but
     *         stated in the specified unit.
     * @throws ArithmeticException if the result is inexact and the quotient has
     *         a non-terminating decimal expansion.
     */
    public Measure<Q> to(Unit<Q> unit) {
        if (unit.equals(this.getUnit())) {
            return this;
        }
        return Measure.valueOf(doubleValue(unit), unit);
    }

    /**
     * Returns this measure after conversion to specified unit. The default
     * implementation returns
     * <code>Measure.valueOf(decimalValue(unit, ctx), unit)</code>. If this
     * measure is already stated in the specified unit, then this measure is
     * returned and no conversion is performed.
     *
     * @param unit the unit in which the returned measure is stated.
     * @param ctx the math context to use for conversion.
     * @return this measure or a new measure equivalent to this measure but
     *         stated in the specified unit.
     * @throws ArithmeticException if the result is inexact but the rounding
     *         mode is <code>UNNECESSARY</code> or
     *         <code>mathContext.precision == 0</code> and the quotient has
     *         a non-terminating decimal expansion.
     */
    public Measure<Q> to(Unit<Q> unit, MathContext ctx) {
        if (unit.equals(this.getUnit())) {
            return this;
        }
        return Measure.valueOf(decimalValue(unit, ctx), unit);
    }

    /**
     * Compares this measure to the specified measurable quantity. The default
     * implementation compares the {@link Measurable#doubleValue(Unit)} of both
     * this measure and the specified measurable stated in the same unit (this
     * measure's {@link #getUnit() unit}).
     *
     * @return a negative integer, zero, or a positive integer as this measure
     *         is less than, equal to, or greater than the specified measurable
     *         quantity.
     * @return <code>Double.compare(this.doubleValue(getUnit()),
     *         that.doubleValue(getUnit()))</code>
     */
    public int compareTo(Measurable<Q> that) {
        Unit<Q> unit = getUnit();
        return Double.compare(doubleValue(unit), that.doubleValue(unit));
    }

    /**
     * Compares this measure against the specified object for <b>strict</b>
     * equality (same unit and same amount).
     *
     * <p> Similarly to the {@link BigDecimal#equals} method which consider 2.0
     *     and 2.00 as different objects because of different internal scales,
     *     measurements such as <code>Measure.valueOf(3.0, KILOGRAM)</code>
     *     <code>Measure.valueOf(3, KILOGRAM)</code> and
     *     <code>Measure.valueOf("3 kg")</code> might not be considered equals
     *     because of possible differences in their implementations.</p>
     *
     * <p> To compare measures stated using different units or using different
     *     amount implementations the {@link #compareTo compareTo} or
     *     {@link #equals(javax.measure.Measurable, double, javax.measure.unit.Unit)
     *      equals(measurable, epsilon, epsilonUnit)} methods should be used.</p>
     *
     * @param obj the object to compare with.
     * @return <code>this.getUnit.equals(obj.getUnit())
     *         && this.getValue().equals(obj.getValue())</code>
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Measure<?>)) {
            return false;
        }
        Measure<?> that = (Measure<?>) obj;
        return this.getUnit().equals(that.getUnit()) && this.getValue().equals(that.getValue());
    }

    /**
     * Compares this measure and the specified measurable to the given accuracy.
     * Measurements are considered approximately equals if their absolute
     * differences when stated in the same specified unit is less than the
     * specified epsilon.
     *
     * @param that the measurable to compare with.
     * @param epsilon the absolute error stated in epsilonUnit.
     * @param epsilonUnit the epsilon unit.
     * @return <code>abs(this.doubleValue(epsilonUnit) - that.doubleValue(epsilonUnit)) &lt;= epsilon</code>
     */
    public boolean equals(Measurable<Q> that, double epsilon, Unit<Q> epsilonUnit) {
        return Math.abs(this.doubleValue(epsilonUnit) - that.doubleValue(epsilonUnit)) <= epsilon;
    }

    /**
     * Returns the hash code for this measure.
     *
     * @return the hash code value.
     */
    @Override
    public int hashCode() {
        return getUnit().hashCode() + getValue().hashCode();
    }

    /**
     * Returns the <code>String</code> representation of this measure. The
     * string produced for a given measure is always the same; it is not
     * affected by locale. This means that it can be used as a canonical string
     * representation for exchanging measure, or as a key for a Hashtable, etc.
     * Locale-sensitive measure formatting and parsing is handled by the
     * {@link MeasureFormat} class and its subclasses.
     *
     * @return <code>UnitFormat.getInternational().format(this)</code>
     */
    @Override
    public String toString() {
        return MeasureFormat.getStandard().format(this);
    }

    // Implements Measurable
    public final int intValue(Unit<Q> unit) throws ArithmeticException {
        long longValue = longValue(unit);
        if ((longValue < Integer.MIN_VALUE) || (longValue > Integer.MAX_VALUE)) {
            throw new ArithmeticException("Cannot convert " + longValue + " to int (overflow)");
        }
        return (int) longValue;
    }

    // Implements Measurable
    public long longValue(Unit<Q> unit) throws ArithmeticException {
        double result = doubleValue(unit);
        if ((result < Long.MIN_VALUE) || (result > Long.MAX_VALUE)) {
            throw new ArithmeticException("Overflow (" + result + ")");
        }
        return (long) result;
    }

    // Implements Measurable
    public final float floatValue(Unit<Q> unit) {
        return (float) doubleValue(unit);
    }

    /**
     * Casts this measure to a parameterized unit of specified nature or throw a
     * <code>ClassCastException</code> if the dimension of the specified
     * quantity and this measure unit's dimension do not match. For
     * example:[code]
     *     Measure<Length> length = Measure.valueOf("2 km").asType(Length.class);
     * [/code]
     *
     * @param type the quantity class identifying the nature of the measure.
     * @return this measure parameterized with the specified type.
     * @throws ClassCastException if the dimension of this unit is different
     *         from the specified quantity dimension.
     * @throws UnsupportedOperationException
     *             if the specified quantity class does not have a public static
     *             field named "UNIT" holding the SI unit for the quantity.
     * @see Unit#asType(Class)
     */
    @SuppressWarnings("unchecked")
    public <T extends Quantity> Measure<T> asType(Class<T> type)
            throws ClassCastException {
        this.getUnit().asType(type); // Raises ClassCastException is dimension
        // mismatches.
        return (Measure<T>) this;
    }

    /**
     * Returns the
     * {@link #valueOf(java.math.BigDecimal, javax.measure.unit.Unit) decimal}
     * measure of unknown type corresponding to the specified representation.
     * This method can be used to parse dimensionless quantities.[code]
     *     Measure<Dimensionless> proportion = Measure.valueOf("0.234").asType(Dimensionless.class);
     * [/code]
     *
     * <p> Note: This method handles only
     * {@link javax.measure.unit.UnitFormat#getStandard standard} unit format
     * (<a href="http://unitsofmeasure.org/">UCUM</a> based). Locale-sensitive
     * measure formatting and parsing are handled by the {@link MeasureFormat}
     * class and its subclasses.</p>
     *
     * @param csq the decimal value and its unit (if any) separated by space(s).
     * @return <code>MeasureFormat.getStandard().parse(csq, new ParsePosition(0))</code>
     */
    public static Measure<?> valueOf(CharSequence csq) {
        return MeasureFormat.getStandard().parse(csq, new ParsePosition(0));
    }

    /**
     * Returns the scalar measure for the specified <code>int</code> stated in
     * the specified unit.
     *
     * @param intValue the measurement value.
     * @param unit the measurement unit.
     * @return the corresponding <code>int</code> measure.
     */
    public static <Q extends Quantity> Measure<Q> valueOf(int intValue,
            Unit<Q> unit) {
        return new IntegerMeasure<Q>(intValue, unit);
    }

    private static class IntegerMeasure<T extends Quantity> extends Measure<T> {
        /**
		 * 
		 */
		private static final long serialVersionUID = 5355395476874521709L;

		int _value;

        Unit<T> _unit;

        public IntegerMeasure(int value, Unit<T> unit) {
            _value = value;
            _unit = unit;
        }

        @Override
        public Integer getValue() {
            return _value;
        }

        @Override
        public Unit<T> getUnit() {
            return _unit;
        }

        // Implements Measurable
        public double doubleValue(Unit<T> unit) {
            return (_unit.equals(unit)) ? _value : _unit.getConverterTo(unit).convert(_value);
        }

        // Implements Measurable
        public BigDecimal decimalValue(Unit<T> unit, MathContext ctx)
                throws ArithmeticException {
            BigDecimal decimal = BigDecimal.valueOf(_value);
            return (_unit.equals(unit)) ? decimal : _unit.getConverterTo(unit).convert(decimal, ctx);
        }
    }

    /**
     * Returns the scalar measure for the specified <code>long</code> stated in
     * the specified unit.
     *
     * @param longValue the measurement value.
     * @param unit the measurement unit.
     * @return the corresponding <code>long</code> measure.
     */
    public static <Q extends Quantity> Measure<Q> valueOf(long longValue,
            Unit<Q> unit) {
        return new LongMeasure<Q>(longValue, unit);
    }

    private static class LongMeasure<T extends Quantity> extends Measure<T> {
        /**
		 * 
		 */
		private static final long serialVersionUID = -7465490977335120477L;

		long value;

        Unit<T> unit;

        public LongMeasure(long value, Unit<T> unit) {
            this.value = value;
            this.unit = unit;
        }

        @Override
        public Long getValue() {
            return value;
        }

        @Override
        public Unit<T> getUnit() {
            return unit;
        }

        @Override
        // Avoid loss of precision if no conversion.
        public long longValue(Unit<T> unit) {
            return ((this.unit.equals(unit)) || (this.unit.getConverterTo(unit) == UnitConverter.IDENTITY)) ? value
                    : super.longValue(unit);
        }

        // Implements Measurable
        public double doubleValue(Unit<T> unit) {
            return (this.unit.equals(unit)) ? this.value : this.unit.getConverterTo(unit).convert(value);
        }

        // Implements Measurable
        public BigDecimal decimalValue(Unit<T> unit, MathContext ctx)
                throws ArithmeticException {
            BigDecimal decimal = BigDecimal.valueOf(value);
            return (this.unit.equals(unit)) ? decimal : this.unit.getConverterTo(unit).convert(decimal, ctx);
        }
    }

    /**
     * Returns the scalar measure for the specified <code>float</code> stated in
     * the specified unit.
     *
     * @param floatValue the measurement value.
     * @param unit the measurement unit.
     * @return the corresponding <code>float</code> measure.
     */
    public static <Q extends Quantity> Measure<Q> valueOf(float floatValue,
            Unit<Q> unit) {
        return new FloatMeasure<Q>(floatValue, unit);
    }

    private static class FloatMeasure<T extends Quantity> extends Measure<T> {

        /**
		 * 
		 */
		private static final long serialVersionUID = 3589409874473192311L;

		float value;

        Unit<T> unit;

        public FloatMeasure(float value, Unit<T> unit) {
            this.value = value;
            this.unit = unit;
        }

        @Override
        public Float getValue() {
            return value;
        }

        @Override
        public Unit<T> getUnit() {
            return unit;
        }

        // Implements Measurable
        public double doubleValue(Unit<T> unit) {
            return (this.unit.equals(unit)) ? value : this.unit.getConverterTo(unit).convert(value);
        }

        // Implements Measurable
        public BigDecimal decimalValue(Unit<T> unit, MathContext ctx)
                throws ArithmeticException {
            BigDecimal decimal = BigDecimal.valueOf(value);
            return (this.unit.equals(unit)) ? decimal : this.unit.getConverterTo(unit).convert(decimal, ctx);
        }
    }

    /**
     * Returns the scalar measure for the specified <code>double</code> stated
     * in the specified unit.
     *
     * @param doubleValue the measurement value.
     * @param unit the measurement unit.
     * @return the corresponding <code>double</code> measure.
     */
    public static <Q extends Quantity> Measure<Q> valueOf(double doubleValue,
            Unit<Q> unit) {
        return new DoubleMeasure<Q>(doubleValue, unit);
    }

    private static class DoubleMeasure<T extends Quantity> extends Measure<T> {

        /**
		 * 
		 */
		private static final long serialVersionUID = -2812680146443477460L;

		double value;

        Unit<T> unit;

        public DoubleMeasure(double value, Unit<T> unit) {
            this.value = value;
            this.unit = unit;
        }

        @Override
        public Double getValue() {
            return value;
        }

        @Override
        public Unit<T> getUnit() {
            return unit;
        }

        // Implements Measurable
        public double doubleValue(Unit<T> unit) {
            return (this.unit.equals(unit)) ? value : this.unit.getConverterTo(unit).convert(value);
        }

        // Implements Measurable
        public BigDecimal decimalValue(Unit<T> unit, MathContext ctx)
                throws ArithmeticException {
            BigDecimal decimal = BigDecimal.valueOf(value);
            return (this.unit.equals(unit)) ? decimal : this.unit.getConverterTo(unit).convert(decimal, ctx);
        }
    }

    /**
     * Returns the scalar measure for the specified <code>BigDecimal</code>
     * stated in the specified unit.
     *
     * @param decimalValue the measurement value.
     * @param unit the measurement unit.
     * @return the corresponding <code>BigDecimal</code> measure.
     */
    public static <Q extends Quantity> Measure<Q> valueOf(
            BigDecimal decimalValue, Unit<Q> unit) {
        return new DecimalMeasure<Q>(decimalValue, unit);
    }

    private static class DecimalMeasure<T extends Quantity> extends Measure<T> {
        /**
		 * 
		 */
		private static final long serialVersionUID = 6504081836032983882L;

		BigDecimal value;

        Unit<T> unit;

        public DecimalMeasure(BigDecimal value, Unit<T> unit) {
            this.value = value;
            this.unit = unit;
        }

        @Override
        public BigDecimal getValue() {
            return value;
        }

        @Override
        public Unit<T> getUnit() {
            return unit;
        }

        // Implements Measurable
        public double doubleValue(Unit<T> unit) {
            return (this.unit.equals(unit)) ? value.doubleValue() : this.unit.getConverterTo(unit).convert(value.doubleValue());
        }

        // Implements Measurable
        public BigDecimal decimalValue(Unit<T> unit, MathContext ctx)
                throws ArithmeticException {
            return (this.unit.equals(unit)) ? value : this.unit.getConverterTo(unit).convert(value, ctx);
        }
    }
}