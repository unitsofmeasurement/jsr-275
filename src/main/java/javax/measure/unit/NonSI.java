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

import static javax.measure.unit.SI.*;
import static javax.measure.unit.SI.MetricPrefix.*;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.measure.converter.LogConverter;
import javax.measure.converter.RationalConverter;
import javax.measure.quantity.*;

/**
 * <p> This class contains units that are not part of the International System 
 *     of Units, that is, they are outside the SI, but are important and widely
 *     used.</p>
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.8 ($Revision: 76 $), $Date: 2009-12-03 23:53:52 +0100 (Do, 03 Dez 2009) $
 */
public final class NonSI extends SystemOfUnits {

    /**
     * Holds collection of NonSI units.
     */
    private static final Set<Unit<?>> UNITS = new HashSet<Unit<?>>();

    /**
     * Holds the standard gravity constant: 9.80665 m/sÂ² exact.
     */
    private static final int STANDARD_GRAVITY_DIVIDEND = 980665;

    private static final int STANDARD_GRAVITY_DIVISOR = 100000;

    /**
     * Holds the international foot: 0.3048 m exact.
     */
    private static final int INTERNATIONAL_FOOT_DIVIDEND = 3048;

    private static final int INTERNATIONAL_FOOT_DIViSOR = 10000;

    /**
     * Holds the avoirdupois pound: 0.45359237 kg exact
     */
    private static final int AVOIRDUPOIS_POUND_DIVIDEND = 45359237;

    private static final int AVOIRDUPOIS_POUND_DIVISOR = 100000000;

    /**
     * Holds the Avogadro constant.
     */
    private static final double AVOGADRO_CONSTANT = 6.02214199e23; // (1/mol).

    /**
     * Holds the electric charge of one electron.
     */
    private static final double ELEMENTARY_CHARGE = 1.602176462e-19; // (C).

    /**
     * Default constructor (prevents this class from being instantiated).
     */
    private NonSI() {
    }

    /**
     * Returns the unique instance of this class.
     *
     * @return the NonSI instance.
     */
    public static NonSI getInstance() {
        return INSTANCE;
    }
    private static final NonSI INSTANCE = new NonSI();

    // /////////////////
    // Dimensionless //
    // /////////////////
    /**
     * A dimensionless unit equals to <code>pi</code> (standard name
     * <code>Ï€</code>).
     */
    public static final Unit<Dimensionless> PI = nonSI(Unit.ONE.times(StrictMath.PI));

    /**
     * A dimensionless unit equals to <code>0.01</code> (standard name
     * <code>%</code>).
     */
    public static final Unit<Dimensionless> PERCENT = nonSI(Unit.ONE.divide(100));

    /**
     * A logarithmic unit used to describe a ratio (standard name
     * <code>dB</code>).
     */
    public static final Unit<Dimensionless> DECIBEL = nonSI(Unit.ONE.transform(new LogConverter(10).inverse().concatenate(
            new RationalConverter(BigInteger.ONE, BigInteger.TEN))));

    // ///////////////////////
    // Amount of substance //
    // ///////////////////////
    /**
     * A unit of amount of substance equals to one atom (standard name
     * <code>atom</code>).
     */
    public static final Unit<AmountOfSubstance> ATOM = nonSI(MOLE.divide(AVOGADRO_CONSTANT));

    // //////////
    // Length //
    // //////////
    /**
     * A unit of length equal to <code>0.3048 m</code> (standard name
     * <code>ft</code>).
     */
    public static final Unit<Length> FOOT = nonSI(METRE.times(
            INTERNATIONAL_FOOT_DIVIDEND).divide(INTERNATIONAL_FOOT_DIViSOR));

    /**
     * A unit of length equal to <code>1200/3937 m</code> (standard name
     * <code>foot_survey_us</code>). See also: <a
     * href="http://www.sizes.com/units/foot.htm">foot</a>
     */
    public static final Unit<Length> FOOT_SURVEY_US = nonSI(METRE.times(1200).divide(3937));

    /**
     * A unit of length equal to <code>0.9144 m</code> (standard name
     * <code>yd</code>).
     */
    public static final Unit<Length> YARD = nonSI(FOOT.times(3));

    /**
     * A unit of length equal to <code>0.0254 m</code> (standard name
     * <code>in</code>).
     */
    public static final Unit<Length> INCH = nonSI(FOOT.divide(12));

    /**
     * A unit of length equal to <code>1609.344 m</code> (standard name
     * <code>mi</code>).
     */
    public static final Unit<Length> MILE = nonSI(METRE.times(1609344).divide(
            1000));

    /**
     * A unit of length equal to <code>1852.0 m</code> (standard name
     * <code>nmi</code>).
     */
    public static final Unit<Length> NAUTICAL_MILE = nonSI(METRE.times(1852));

    /**
     * A unit of length equal to <code>1E-10 m</code> (standard name
     * <code>Ã…</code>).
     */
    public static final Unit<Length> ANGSTROM = nonSI(METRE.divide(10000000000L));

    /**
     * A unit of length equal to the average distance from the center of the
     * Earth to the center of the Sun (standard name <code>ua</code>).
     */
    public static final Unit<Length> ASTRONOMICAL_UNIT = nonSI(METRE.times(149597870691.0));

    /**
     * A unit of length equal to the distance that light travels in one year
     * through a vacuum (standard name <code>ly</code>).
     */
    public static final Unit<Length> LIGHT_YEAR = nonSI(METRE.times(9.460528405e15));

    /**
     * A unit of length equal to the distance at which a star would appear to
     * shift its position by one arcsecond over the course the time (about 3
     * months) in which the Earth moves a distance of {@link #ASTRONOMICAL_UNIT}
     * in the direction perpendicular to the direction to the star (standard
     * name <code>pc</code>).
     */
    public static final Unit<Length> PARSEC = nonSI(METRE.times(30856770e9));

    /**
     * A unit of length equal to <code>0.013837 {@link #INCH}</code> exactly (standard name
     * <code>pt</code>).
     *
     * @see #PIXEL
     */
    public static final Unit<Length> POINT = nonSI(INCH.times(13837).divide(
            1000000));

    /**
     * A unit of length equal to <code>1/72 {@link #INCH}</code> (standard name <code>pixel</code>). It is
     * the American point rounded to an even 1/72 inch.
     *
     * @see #POINT
     */
    public static final Unit<Length> PIXEL = nonSI(INCH.divide(72));

    /**
     * Equivalent {@link #PIXEL}
     */
    public static final Unit<Length> COMPUTER_POINT = PIXEL;

    // ////////////
    // Duration //
    // ////////////
    /**
     * A unit of duration equal to <code>60 s</code> (standard name
     * <code>min</code>).
     */
    public static final Unit<Duration> MINUTE = nonSI(SI.SECOND.times(60));

    /**
     * A unit of duration equal to <code>60 {@link #MINUTE}</code> (standard name <code>h</code>).
     */
    public static final Unit<Duration> HOUR = nonSI(MINUTE.times(60));

    /**
     * A unit of duration equal to <code>24 {@link #HOUR}</code> (standard name <code>d</code>).
     */
    public static final Unit<Duration> DAY = nonSI(HOUR.times(24));

    /**
     * A unit of duration equal to the time required for a complete rotation of
     * the earth in reference to any star or to the vernal equinox at the
     * meridian, equal to 23 hours, 56 minutes, 4.09 seconds (standard name
     * <code>day_sidereal</code>).
     */
    public static final Unit<Duration> DAY_SIDEREAL = nonSI(SECOND.times(86164.09));

    /**
     * A unit of duration equal to 7 {@link #DAY} (standard name
     * <code>week</code>).
     */
    public static final Unit<Duration> WEEK = nonSI(DAY.times(7));

    /**
     * A unit of duration equal to 365 {@link #DAY} (standard name
     * <code>year</code>).
     */
    public static final Unit<Duration> YEAR_CALENDAR = nonSI(DAY.times(365));

    /**
     * A unit of duration equal to one complete revolution of the earth about
     * the sun, relative to the fixed stars, or 365 days, 6 hours, 9 minutes,
     * 9.54 seconds (standard name <code>year_sidereal</code>).
     */
    public static final Unit<Duration> YEAR_SIDEREAL = nonSI(SECOND.times(31558149.54));

    /**
     * The Julian year, as used in astronomy and other sciences, is a time unit
     * defined as exactly 365.25 days. This is the normal meaning of the unit
     * "year" (symbol "a" from the Latin annus, annata) used in various
     * scientific contexts.
     */
    public static final Unit<Duration> YEAR_JULIEN = nonSI(SECOND.times(31557600));

    // ////////
    // Mass //
    // ////////
    /**
     * A unit of mass equal to 1/12 the mass of the carbon-12 atom (standard
     * name <code>u</code>).
     */
    public static final Unit<Mass> ATOMIC_MASS = nonSI(KILOGRAM.times(1e-3 / AVOGADRO_CONSTANT));

    /**
     * A unit of mass equal to the mass of the electron (standard name
     * <code>me</code>).
     */
    public static final Unit<Mass> ELECTRON_MASS = nonSI(KILOGRAM.times(9.10938188e-31));

    /**
     * A unit of mass equal to <code>453.59237 grams</code> (avoirdupois pound,
     * standard name <code>lb</code>).
     */
    public static final Unit<Mass> POUND = nonSI(KILOGRAM.times(
            AVOIRDUPOIS_POUND_DIVIDEND).divide(AVOIRDUPOIS_POUND_DIVISOR));

    /**
     * A unit of mass equal to <code>1 / 16 {@link #POUND}</code> (standard name <code>oz</code>).
     */
    public static final Unit<Mass> OUNCE = nonSI(POUND.divide(16));

    /**
     * A unit of mass equal to <code>2000 {@link #POUND}</code> (short ton, standard name
     * <code>ton_us</code>).
     */
    public static final Unit<Mass> TON_US = nonSI(POUND.times(2000));

    /**
     * A unit of mass equal to <code>2240 {@link #POUND}</code> (long ton, standard name
     * <code>ton_uk</code>).
     */
    public static final Unit<Mass> TON_UK = nonSI(POUND.times(2240));

    /**
     * A unit of mass equal to <code>1000 kg</code> (metric ton, standard name
     * <code>t</code>).
     */
    public static final Unit<Mass> METRIC_TON = nonSI(KILOGRAM.times(1000));

    // ///////////////////
    // Electric charge //
    // ///////////////////
    /**
     * A unit of electric charge equal to the charge on one electron (standard
     * name <code>e</code>).
     */
    public static final Unit<ElectricCharge> E = nonSI(COULOMB.times(ELEMENTARY_CHARGE));

    /**
     * A unit of electric charge equal to equal to the product of Avogadro's
     * number (see {@link SI#MOLE}) and the charge (1 e) on a single electron
     * (standard name <code>Fd</code>).
     */
    public static final Unit<ElectricCharge> FARADAY = nonSI(COULOMB.times(ELEMENTARY_CHARGE * AVOGADRO_CONSTANT)); // e/mol

    /**
     * A unit of electric charge which exerts a force of one dyne on an equal
     * charge at a distance of one centimeter (standard name <code>Fr</code>).
     */
    public static final Unit<ElectricCharge> FRANKLIN = nonSI(COULOMB.times(3.3356e-10));

    // ///////////////
    // Temperature //
    // ///////////////
    /**
     * A unit of temperature equal to <code>5/9 Â°K</code> (standard name
     * <code>Â°R</code>).
     */
    public static final Unit<Temperature> RANKINE = nonSI(KELVIN.times(5).divide(9));

    /**
     * A unit of temperature equal to degree Rankine minus
     * <code>459.67 Â°R</code> (standard name <code>Â°F</code>).
     *
     * @see #RANKINE
     */
    public static final Unit<Temperature> FAHRENHEIT = nonSI(RANKINE.plus(459.67));

    // /////////
    // Angle //
    // /////////
    /**
     * A unit of angle equal to a full circle or <code>2<i>&pi;</i>
     * {@link SI#RADIAN}</code> (standard name <code>rev</code>).
     */
    public static final Unit<Angle> REVOLUTION = nonSI(RADIAN.times(2).times(PI).asType(Angle.class));

    /**
     * A unit of angle equal to <code>1/360 {@link #REVOLUTION}</code> (standard name <code>deg</code>).
     */
    public static final Unit<Angle> DEGREE_ANGLE = nonSI(REVOLUTION.divide(360));

    /**
     * A unit of angle equal to <code>1/60 {@link #DEGREE_ANGLE}</code> (standard name <code>'</code>).
     */
    public static final Unit<Angle> MINUTE_ANGLE = nonSI(DEGREE_ANGLE.divide(60));

    /**
     * A unit of angle equal to <code>1/60 {@link #MINUTE_ANGLE}</code> (standard name <code>"</code>).
     */
    public static final Unit<Angle> SECOND_ANGLE = nonSI(MINUTE_ANGLE.divide(60));

    /**
     * A unit of angle equal to <code>0.01 {@link SI#RADIAN}</code> (standard name
     * <code>centiradian</code>).
     */
    public static final Unit<Angle> CENTIRADIAN = nonSI(RADIAN.divide(100));

    /**
     * A unit of angle measure equal to <code>1/400 {@link #REVOLUTION}</code> (standard name <code>grade</code>
     * ).
     */
    public static final Unit<Angle> GRADE = nonSI(REVOLUTION.divide(400));

    // ////////////
    // Velocity //
    // ////////////
    /**
     * A unit of velocity expressing the number of {@link NonSI#FOOT feet} per
     * {@link SI#SECOND second}.
     */
    public static final Unit<Velocity> FEET_PER_SECOND = nonSI(
            NonSI.FOOT.divide(SI.SECOND)).asType(Velocity.class);

    /**
     * A unit of velocity expressing the number of international {@link #MILE
     * miles} per {@link #HOUR hour} (abbreviation <code>mph</code>).
     */
    public static final Unit<Velocity> MILES_PER_HOUR = nonSI(
            NonSI.MILE.divide(NonSI.HOUR)).asType(Velocity.class);

    /**
     * A unit of velocity expressing the number of {@link SI#KILOMETRE} per
     * {@link #HOUR hour}.
     */
    public static final Unit<Velocity> KILOMETRES_PER_HOUR = nonSI(
            SI.KILOMETRE.divide(NonSI.HOUR)).asType(Velocity.class);

    /**
     * A unit of velocity expressing the number of {@link #NAUTICAL_MILE
     * nautical miles} per {@link #HOUR hour} (abbreviation <code>kn</code>).
     */
    public static final Unit<Velocity> KNOT = nonSI(
            NonSI.NAUTICAL_MILE.divide(NonSI.HOUR)).asType(Velocity.class);

    /**
     * A unit of velocity relative to the speed of light (standard name
     * <code>c</code>).
     */
    public static final Unit<Velocity> C = nonSI(METRES_PER_SECOND.times(299792458));

    // ////////////////
    // Acceleration //
    // ////////////////
    /**
     * A unit of acceleration equal to the gravity at the earth's surface
     * (standard name <code>grav</code>).
     */
    public static final Unit<Acceleration> G = nonSI(METRES_PER_SQUARE_SECOND.times(STANDARD_GRAVITY_DIVIDEND).divide(STANDARD_GRAVITY_DIVISOR));

    // ////////
    // Area //
    // ////////
    /**
     * A unit of area equal to <code>100 mÂ²</code> (standard name <code>a</code>
     * ).
     */
    public static final Unit<Area> ARE = nonSI(SQUARE_METRE.times(100));

    /**
     * A unit of area equal to <code>100 {@link #ARE}</code> (standard name <code>ha</code>).
     */
    public static final Unit<Area> HECTARE = nonSI(ARE.times(100)); // Exact.

    // ///////////////
    // Data Amount //
    // ///////////////
    /**
     * A unit of data amount equal to <code>8 {@link SI#BIT}</code> (BinarY TErm, standard name
     * <code>byte</code>).
     */
    public static final Unit<DataAmount> BYTE = nonSI(BIT.times(8));

    /**
     * Equivalent {@link #BYTE}
     */
    public static final Unit<DataAmount> OCTET = BYTE;

    // ////////////////////
    // Electric current //
    // ////////////////////
    /**
     * A unit of electric charge equal to the centimeter-gram-second
     * electromagnetic unit of magnetomotive force, equal to <code>10/4
     * &pi;ampere-turn</code> (standard name <code>Gi</code>).
     */
    public static final Unit<ElectricCurrent> GILBERT = nonSI(SI.AMPERE.times(
            10).divide(4).times(PI).asType(ElectricCurrent.class));

    // //////////
    // Energy //
    // //////////
    /**
     * A unit of energy equal to <code>1E-7 J</code> (standard name
     * <code>erg</code>).
     */
    public static final Unit<Energy> ERG = nonSI(JOULE.divide(10000000));

    /**
     * A unit of energy equal to one electron-volt (standard name
     * <code>eV</code>, also recognized <code>keV, MeV, GeV</code>).
     */
    public static final Unit<Energy> ELECTRON_VOLT = nonSI(JOULE.times(ELEMENTARY_CHARGE));

    // ///////////////
    // Illuminance //
    // ///////////////
    /**
     * A unit of illuminance equal to <code>1E4 Lx</code> (standard name
     * <code>La</code>).
     */
    public static final Unit<Illuminance> LAMBERT = nonSI(LUX.times(10000));

    // /////////////////
    // Magnetic Flux //
    // /////////////////
    /**
     * A unit of magnetic flux equal <code>1E-8 Wb</code> (standard name
     * <code>Mx</code>).
     */
    public static final Unit<MagneticFlux> MAXWELL = nonSI(WEBER.divide(100000000));

    // /////////////////////////
    // Magnetic Flux Density //
    // /////////////////////////
    /**
     * A unit of magnetic flux density equal <code>1000 A/m</code> (standard
     * name <code>G</code>).
     */
    public static final Unit<MagneticFluxDensity> GAUSS = nonSI(TESLA.divide(10000));

    // /////////
    // Force //
    // /////////
    /**
     * A unit of force equal to <code>1E-5 N</code> (standard name
     * <code>dyn</code>).
     */
    public static final Unit<Force> DYNE = nonSI(NEWTON.divide(100000));

    /**
     * A unit of force equal to <code>9.80665 N</code> (standard name
     * <code>kgf</code>).
     */
    public static final Unit<Force> KILOGRAM_FORCE = nonSI(NEWTON.times(
            STANDARD_GRAVITY_DIVIDEND).divide(STANDARD_GRAVITY_DIVISOR));

    /**
     * A unit of force equal to <code>{@link #POUND}Â·{@link #G}</code> (standard name <code>lbf</code>).
     */
    public static final Unit<Force> POUND_FORCE = nonSI(NEWTON.times(
            1L * AVOIRDUPOIS_POUND_DIVIDEND * STANDARD_GRAVITY_DIVIDEND).divide(1L * AVOIRDUPOIS_POUND_DIVISOR * STANDARD_GRAVITY_DIVISOR));

    // /////////
    // Power //
    // /////////
    /**
     * A unit of power equal to the power required to raise a mass of 75
     * kilograms at a velocity of 1 meter per second (metric, standard name
     * <code>hp</code>).
     */
    public static final Unit<Power> HORSEPOWER = nonSI(WATT.times(735.499));

    // ////////////
    // Pressure //
    // ////////////
    /**
     * A unit of pressure equal to the average pressure of the Earth's
     * atmosphere at sea level (standard name <code>atm</code>).
     */
    public static final Unit<Pressure> ATMOSPHERE = nonSI(PASCAL.times(101325));

    /**
     * A unit of pressure equal to <code>100 kPa</code> (standard name
     * <code>bar</code>).
     */
    public static final Unit<Pressure> BAR = nonSI(PASCAL.times(100000));

    /**
     * A unit of pressure equal to the pressure exerted at the Earth's surface
     * by a column of mercury 1 millimeter high (standard name <code>mmHg</code>
     * ).
     */
    public static final Unit<Pressure> MILLIMETRE_OF_MERCURY = nonSI(PASCAL.times(133.322));

    /**
     * A unit of pressure equal to the pressure exerted at the Earth's surface
     * by a column of mercury 1 inch high (standard name <code>inHg</code>).
     */
    public static final Unit<Pressure> INCH_OF_MERCURY = nonSI(PASCAL.times(3386.388));

    // ///////////////////////////
    // Radiation dose absorbed //
    // ///////////////////////////
    /**
     * A unit of radiation dose absorbed equal to a dose of 0.01 joule of energy
     * per kilogram of mass (J/kg) (standard name <code>rd</code>).
     */
    public static final Unit<RadiationDoseAbsorbed> RAD = nonSI(GRAY.divide(100));

    /**
     * A unit of radiation dose effective equal to <code>0.01 Sv</code>
     * (standard name <code>rem</code>).
     */
    public static final Unit<RadiationDoseEffective> REM = nonSI(SIEVERT.divide(100));

    // ////////////////////////
    // Radioactive activity //
    // ////////////////////////
    /**
     * A unit of radioctive activity equal to the activity of a gram of radium
     * (standard name <code>Ci</code>).
     */
    public static final Unit<RadioactiveActivity> CURIE = nonSI(BECQUEREL.times(37000000000L));

    /**
     * A unit of radioctive activity equal to 1 million radioactive
     * disintegrations per second (standard name <code>Rd</code>).
     */
    public static final Unit<RadioactiveActivity> RUTHERFORD = nonSI(SI.BECQUEREL.times(1000000));

    // ///////////////
    // Solid angle //
    // ///////////////
    /**
     * A unit of solid angle equal to <code>4 <i>&pi;</i> steradians</code>
     * (standard name <code>sphere</code>).
     */
    public static final Unit<SolidAngle> SPHERE = nonSI(STERADIAN.times(4).times(PI).asType(SolidAngle.class));

    // //////////
    // Volume //
    // //////////
    /**
     * A unit of volume equal to one cubic decimeter (default label
     * <code>L</code>, also recognized <code>ÂµL, mL, cL, dL</code>).
     */
    public static final Unit<Volume> LITRE = nonSI(CUBIC_METRE.divide(1000));

    /**
     * A unit of volume equal to one cubic inch (<code>inÂ³</code>).
     */
    public static final Unit<Volume> CUBIC_INCH = nonSI(INCH.pow(3).asType(
            Volume.class));

    /**
     * A unit of volume equal to one US gallon, Liquid Unit. The U.S. liquid
     * gallon is based on the Queen Anne or Wine gallon occupying 231 cubic
     * inches (standard name <code>gal</code>).
     */
    public static final Unit<Volume> GALLON_LIQUID_US = nonSI(CUBIC_INCH.times(231));

    /**
     * A unit of volume equal to <code>1 / 128 {@link #GALLON_LIQUID_US}</code> (standard name
     * <code>oz_fl</code>).
     */
    public static final Unit<Volume> OUNCE_LIQUID_US = nonSI(GALLON_LIQUID_US.divide(128));

    /**
     * A unit of volume equal to one US dry gallon. (standard name
     * <code>gallon_dry_us</code>).
     */
    public static final Unit<Volume> GALLON_DRY_US = nonSI(CUBIC_INCH.times(
            2688025).divide(10000));

    /**
     * A unit of volume equal to <code>4.546 09 {@link #LITRE}</code> (standard name <code>gal_uk</code>).
     */
    public static final Unit<Volume> GALLON_UK = nonSI(LITRE.times(454609).divide(100000));

    /**
     * A unit of volume equal to <code>1 / 160 {@link #GALLON_UK}</code> (standard name
     * <code>oz_fl_uk</code>).
     */
    public static final Unit<Volume> OUNCE_LIQUID_UK = nonSI(GALLON_UK.divide(160));

    // /////////////
    // Viscosity //
    // /////////////
    /**
     * A unit of dynamic viscosity equal to <code>1 g/(cmÂ·s)</code> (cgs unit).
     */
    public static final Unit<DynamicViscosity> POISE = nonSI(GRAM.divide(CENTI(METRE).times(SECOND))).asType(DynamicViscosity.class);

    /**
     * A unit of kinematic viscosity equal to <code>1 cm²/s</code> (cgs unit).
     */
    public static final Unit<KinematicViscosity> STOKE = nonSI(CENTI(METRE).pow(2).divide(SECOND)).asType(KinematicViscosity.class);

    ///////////////
    // Frequency //
    ///////////////
    /**
     * A unit used to measure the frequency (rate) at which an imaging device
     * produces unique consecutive images (standard name <code>fps</code>).
     */
    public static final Unit<Frequency> FRAMES_PER_SECOND = nonSI(Unit.ONE.divide(SECOND)).asType(Frequency.class);

    // //////////
    // Others //
    // //////////
    /**
     * A unit used to measure the ionizing ability of radiation (standard name
     * <code>Roentgen</code>).
     */
    public static final Unit<?> ROENTGEN = nonSI(COULOMB.divide(KILOGRAM).times(2.58e-4));

    // ///////////////////
    // Collection View //
    // ///////////////////
    /**
     * Returns a read only view over the units defined in this class.
     *
     * @return the collection of NonSI units.
     */
    public Set<Unit<?>> getUnits() {
        return Collections.unmodifiableSet(UNITS);
    }

    /**
     * Adds a new unit to the collection.
     *
     * @param unit the unit being added.
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U nonSI(U unit) {
        UNITS.add(unit);
        return unit;
    }

    // ///////////////////
    // NON-SI PREFIXES //
    // ///////////////////
    /**
     * Inner class holding binary prefixes.
     */
    public static class BinaryPrefix {

        private BinaryPrefix() {
            // Utility class no visible constructor.
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>2<sup>10</sup></code> (binary prefix).
         *
         * @param unit any unit.
         * @return <code>unit.times(1024)</code>.
         */
        public static <Q extends Quantity> Unit<Q> KIBI(Unit<Q> unit) {
            return unit.times(1024);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>2<sup>20</sup></code> (binary prefix).
         *
         * @param unit any unit.
         * @return <code>unit.times(1048576)</code>.
         */
        public static <Q extends Quantity> Unit<Q> MEBI(Unit<Q> unit) {
            return unit.times(1048576);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>2<sup>30</sup></code> (binary prefix).
         *
         * @param unit any unit.
         * @return <code>unit.times(1073741824)</code>.
         */
        public static final <Q extends Quantity> Unit<Q> GIBI(Unit<Q> unit) {
            return unit.times(1073741824);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>2<sup>40</sup></code> (binary prefix).
         *
         * @param unit any unit.
         * @return <code>unit.times(1099511627776L)</code>.
         */
        public static <Q extends Quantity> Unit<Q> TEBI(Unit<Q> unit) {
            return unit.times(1099511627776L);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>2<sup>50</sup></code> (binary prefix).
         *
         * @param unit any unit.
         * @return <code>unit.times(1125899906842624L)</code>.
         */
        public static <Q extends Quantity> Unit<Q> PEBI(Unit<Q> unit) {
            return unit.times(1125899906842624L);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>2<sup>60</sup></code> (binary prefix).
         *
         * @param unit any unit.
         * @return <code>unit.times(1152921504606846976L)</code>.
         */
        public static <Q extends Quantity> Unit<Q> EXBI(Unit<Q> unit) {
            return unit.times(1152921504606846976L);
        }
    }

    /**
     * Inner class holding prefixes used today in India, Pakistan, Bangladesh,
     * Nepal and Myanmar (Burma); based on grouping by two decimal places,
     * rather than the three decimal places common in most parts of the world.
     * [code]
     *     import static javax.measure.unit.NonSI.IndianPrefix.*; // Static import.
     *     ...
     *     Unit<Pressure> LAKH_PASCAL = LAKH(PASCAL);
     *     Unit<Length> CRORE_METER = CRORE(METER);
     * [/code]
     *
     * @author <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
     * @version 1.0
     * @see <a
     * href="http://en.wikipedia.org/wiki/Indian_numbering_system">Wikipedia:
     * Indian numbering system</a>
     */
    public static class IndianPrefix {

        private IndianPrefix() {
            // Utility class no visible constructor.
        }

        /**
         * <p>एक (Ek)</p>
         * Returns the specified unit multiplied by the factor <code>1</code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1)</code>.
         */
        public static <Q extends Quantity> Unit<Q> EK(Unit<Q> unit) {
            return unit;
        }

        /**
         * <p>दस (Das)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>1</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(10)</code>.
         */
        public static <Q extends Quantity> Unit<Q> DAS(Unit<Q> unit) {
            return unit.transform(E1);
        }

        /**
         * <p>सौ (Sau)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>2</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(100)</code>.
         */
        public static <Q extends Quantity> Unit<Q> SAU(Unit<Q> unit) {
            return unit.transform(E2);
        }

        /**
         * <p>सहस्र (Sahasr)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>3</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e3)</code>.
         */
        public static <Q extends Quantity> Unit<Q> SAHASR(Unit<Q> unit) {
            return unit.transform(E3);
        }

        /**
         * <p>हजार (Hazaar)</p>
         * Equivalent to {@link #SAHASR}.
         */
        public static <Q extends Quantity> Unit<Q> HAZAAR(Unit<Q> unit) {
            return SAHASR(unit);
        }

        /**
         * <p>लाख (Lakh)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>5</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e5)</code>.
         */
        public static <Q extends Quantity> Unit<Q> LAKH(Unit<Q> unit) {
            return unit.transform(E5);
        }
        static final RationalConverter E5 = new RationalConverter(
                BigInteger.TEN.pow(5), BigInteger.ONE);

        /**
         * <p>करोड़ (Crore)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>7</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e7)</code>.
         */
        public static <Q extends Quantity> Unit<Q> CRORE(Unit<Q> unit) {
            return unit.transform(E7);
        }
        static final RationalConverter E7 = new RationalConverter(
                BigInteger.TEN.pow(7), BigInteger.ONE);

        /**
         * <p>अरब (Arawb)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>9</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e9)</code>.
         */
        public static <Q extends Quantity> Unit<Q> ARAWB(Unit<Q> unit) {
            return unit.transform(E9);
        }

        /**
         * <p>खरब (Kharawb)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>11</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e11)</code>.
         */
        public static <Q extends Quantity> Unit<Q> KHARAWB(Unit<Q> unit) {
            return unit.transform(E11);
        }
        static final RationalConverter E11 = new RationalConverter(
                BigInteger.TEN.pow(11), BigInteger.ONE);

        /**
         * <p>नील (Neel)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>13</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e13)</code>.
         */
        public static <Q extends Quantity> Unit<Q> NEEL(Unit<Q> unit) {
            return unit.transform(E13);
        }
        static final RationalConverter E13 = new RationalConverter(
                BigInteger.TEN.pow(13), BigInteger.ONE);

        /**
         * <p>पद्म (Padma)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>15</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e15)</code>.
         */
        public static <Q extends Quantity> Unit<Q> PADMA(Unit<Q> unit) {
            return unit.transform(E15);
        }

        /**
         * <p>शंख (Shankh)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>17</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e17)</code>.
         */
        public static <Q extends Quantity> Unit<Q> SHANKH(Unit<Q> unit) {
            return unit.transform(E17);
        }
        static final RationalConverter E17 = new RationalConverter(
                BigInteger.TEN.pow(17), BigInteger.ONE);

        /**
         * <p>महाशंख (Mahashankh)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>19</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e19)</code>.
         */
        public static <Q extends Quantity> Unit<Q> MAHASHANKH(Unit<Q> unit) {
            return unit.transform(E19);
        }
        static final RationalConverter E19 = new RationalConverter(
                BigInteger.TEN.pow(19), BigInteger.ONE);
    }
}
