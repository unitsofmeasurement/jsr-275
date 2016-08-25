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

import static javax.measure.unit.SI.MetricPrefix.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.measure.quantity.*;

/**
 * <p> This class contains the units ({@link SI} and {@link NonSI}) as defined
 *     in the <a href="http://unitsofmeasure.org/">
 *     Uniform Code for Units of Measure</a>.</p>
 *
 * <p> Compatibility with existing {@link javax.measure.unit.SI SI}/
 *     {@link javax.measure.unit.NonSI NonSI} units has been given
 *     priority over strict adherence to the standard. We have attempted to note
 *     every place where the definitions in this class deviate from the
 *     UCUM standard, but such notes are likely to be incomplete.</p>
 * 
 * @author  <a href="mailto:eric-r@northwestern.edu">Eric Russell</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.4.2, ($Revision: 76 $) $Date: 2009-12-03 23:53:52 +0100 (Do, 03 Dez 2009) $
 * @see <a href="http://aurora.regenstrief.org/UCUM/ucum.html">UCUM</a>
 */
public final class UCUM extends SystemOfUnits {

    /** Holds collection of all UCUM units. */
    private static HashSet<Unit<?>> UNITS = new HashSet<Unit<?>>();

    /**
     * Returns the unique instance of this class.
     *
     * @return the UCUM instance.
     */
    public static UCUM getInstance() {
        return INSTANCE;
    }
    private static final UCUM INSTANCE = new UCUM();

    /**
     * Adds a new unit to the collection.
     * @param  unit the unit being added.
     * @return <code>unit</code>.
     */
    private static <U extends Unit> U ucum(U unit) {
        UNITS.add(unit);
        return unit;
    }

    /**
     * Default constructor (prevents this class from being instantiated).
     */
    private UCUM() {
    }

    /**
     * Returns a read only view over the units defined in this class.
     * @return the collection of SI units.
     */
    public Set<Unit<?>> getUnits() {
        return Collections.unmodifiableSet(UNITS);
    }
    //////////////////////////////
    // BASE UNITS: UCUM 4.2 §25 //
    //////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final BaseUnit<Length> METER = ucum(SI.METRE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final BaseUnit<Duration> SECOND = ucum(SI.SECOND);
    /**
     * We deviate slightly from the standard here, to maintain compatibility
     * with the existing SI units. In UCUM, the gram is the base unit of mass,
     * rather than the kilogram. This doesn't have much effect on the units
     * themselves, but it does make formatting the units a challenge.
     */
    public static final Unit<Mass> GRAM = ucum(SI.GRAM);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AlternateUnit<Angle> RADIAN = ucum(SI.RADIAN);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final BaseUnit<Temperature> KELVIN = ucum(SI.KELVIN);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final AlternateUnit<ElectricCharge> COULOMB = ucum(SI.COULOMB);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final BaseUnit<LuminousIntensity> CANDELA = ucum(SI.CANDELA);
    ///////////////////////////////////////////////
    // DIMENSIONLESS DERIVED UNITS: UCUM 4.3 §26 //
    ///////////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Dimensionless> TRIILLIONS = ucum(Unit.ONE.times(1000000000000L));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Dimensionless> BILLIONS = ucum(Unit.ONE.times(1000000000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Dimensionless> MILLIONS = ucum(Unit.ONE.times(1000000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Dimensionless> THOUSANDS = ucum(Unit.ONE.times(1000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Dimensionless> HUNDREDS = ucum(Unit.ONE.times(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Dimensionless> PI = ucum(Unit.ONE.times(StrictMath.PI));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Dimensionless> PERCENT = ucum(Unit.ONE.divide(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Dimensionless> PER_THOUSAND = ucum(Unit.ONE.divide(1000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Dimensionless> PER_MILLION = ucum(Unit.ONE.divide(1000000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Dimensionless> PER_BILLION = ucum(Unit.ONE.divide(1000000000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Dimensionless> PER_TRILLION = ucum(Unit.ONE.divide(1000000000000L));
    ////////////////////////////
    // SI UNITS: UCUM 4.3 §27 //
    ////////////////////////////
    /**
     * We deviate slightly from the standard here, to maintain compatibility
     * with the existing SI units. In UCUM, the mole is no longer a base unit,
     * but is defined as <code>Unit.ONE.times(6.0221367E23)</code>.
     */
    public static final Unit<AmountOfSubstance> MOLE = ucum(SI.MOLE);
    /**
     * We deviate slightly from the standard here, to maintain compatibility
     * with the existing SI units. In UCUM, the steradian is defined as 
     * <code>RADIAN.pow(2)</code>.
     */
    public static final Unit<SolidAngle> STERADIAN = ucum(SI.STERADIAN);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Frequency> HERTZ = (Unit<Frequency>) ucum(SI.HERTZ);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Force> NEWTON = ucum(SI.NEWTON);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Pressure> PASCAL = ucum(SI.PASCAL);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> JOULE = ucum(SI.JOULE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Power> WATT = ucum(SI.WATT);
    /** 
     * We deviate slightly from the standard here, to maintain compatability
     * with the existing SI units. In UCUM, the ampere is defined as 
     * <code>COULOMB.divide(SECOND)</code>.
     */
    public static final Unit<ElectricCurrent> AMPERE = ucum(SI.AMPERE);
    public static final Unit<MagnetomotiveForce> AMPERE_TURN = ucum(SI.AMPERE_TURN);
    /** 
     * We deviate slightly from the standard here, to maintain compatibility
     * with the existing SI units. In UCUM, the volt is defined as 
     * <code>JOULE.divide(COULOMB)</code>.
     */
    public static final Unit<ElectricPotential> VOLT = ucum(SI.VOLT);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<ElectricCapacitance> FARAD = ucum(SI.FARAD);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<ElectricResistance> OHM = ucum(SI.OHM);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<ElectricConductance> SIEMENS = ucum(SI.SIEMENS);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<MagneticFlux> WEBER = ucum(SI.WEBER);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Temperature> CELSIUS = ucum(SI.CELSIUS);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<MagneticFluxDensity> TESLA = ucum(SI.TESLA);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<ElectricInductance> HENRY = ucum(SI.HENRY);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<LuminousFlux> LUMEN = ucum(SI.LUMEN);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Illuminance> LUX = ucum(SI.LUX);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<RadioactiveActivity> BECQUEREL = ucum(SI.BECQUEREL);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<RadiationDoseAbsorbed> GRAY = ucum(SI.GRAY);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<RadiationDoseEffective> SIEVERT = ucum(SI.SIEVERT);
    ///////////////////////////////////////////////////////////////////////
    // OTHER UNITS FROM ISO 1000, ISO 2955, AND ANSI X3.50: UCUM 4.3 §28 //
    ///////////////////////////////////////////////////////////////////////
    // The order of GON and DEGREE has been inverted because GON is defined in terms of DEGREE
    /** 
     * We deviate slightly from the standard here, to maintain compatibility
     * with the existing NonSI units. In UCUM, the degree is defined as 
     * <code>PI.times(RADIAN.divide(180))</code>.
     */
    public static final Unit<Angle> DEGREE = ucum(NonSI.DEGREE_ANGLE);
    /** 
     * We deviate slightly from the standard here, to maintain compatibility
     * with the existing NonSI units. In UCUM, the grade is defined as 
     * <code>DEGREE.times(0.9)</code>.
     */
    public static final Unit<Angle> GRADE = ucum(NonSI.GRADE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Angle> GON = GRADE;
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Angle> MINUTE_ANGLE = ucum(NonSI.MINUTE_ANGLE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Angle> SECOND_ANGLE = ucum(NonSI.SECOND_ANGLE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> LITER = ucum(NonSI.LITRE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Area> ARE = ucum(NonSI.ARE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Duration> MINUTE = ucum(NonSI.MINUTE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Duration> HOUR = ucum(NonSI.HOUR);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Duration> DAY = ucum(NonSI.DAY);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Duration> YEAR_TROPICAL = ucum(DAY.times(365.24219));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Duration> YEAR_JULIAN = ucum(DAY.times(365.25));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Duration> YEAR_GREGORIAN = ucum(DAY.times(365.2425));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Duration> YEAR = ucum(DAY.times(365.25));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Duration> MONTH_SYNODAL = ucum(DAY.times(29.53059));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Duration> MONTH_JULIAN = ucum(YEAR_JULIAN.divide(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Duration> MONTH_GREGORIAN = ucum(YEAR_GREGORIAN.divide(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Duration> MONTH = ucum(YEAR_JULIAN.divide(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> TONNE = ucum(NonSI.METRIC_TON);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Pressure> BAR = ucum(NonSI.BAR);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> ATOMIC_MASS_UNIT = ucum(NonSI.ATOMIC_MASS);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> ELECTRON_VOLT = ucum(NonSI.ELECTRON_VOLT);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> ASTRONOMIC_UNIT = ucum(NonSI.ASTRONOMICAL_UNIT);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> PARSEC = ucum(NonSI.PARSEC);
    /////////////////////////////////
    // NATURAL UNITS: UCUM 4.3 §29 //
    /////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Velocity> C = ucum(NonSI.C);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Action> PLANCK = (Unit<Action>) ucum(JOULE.times(SECOND).times(6.6260755E-24));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Dimensionless> BOLTZMAN = (Unit<Dimensionless>) ucum(JOULE.divide(KELVIN).times(1.380658E-23));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<ElectricPermittivity> PERMITTIVITY_OF_VACUUM = (Unit<ElectricPermittivity>) ucum(FARAD.divide(METER).times(8.854187817E-12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<MagneticPermeability> PERMEABILITY_OF_VACUUM = (Unit<MagneticPermeability>) ucum(NEWTON.times(4E-7 * StrictMath.PI).divide(AMPERE.pow(2)));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<ElectricCharge> ELEMENTARY_CHARGE = ucum(NonSI.E);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> ELECTRON_MASS = ucum(NonSI.ELECTRON_MASS);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> PROTON_MASS = ucum(GRAM.times(1.6726231E-24));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Dimensionless> NEWTON_CONSTANT_OF_GRAVITY = (Unit<Dimensionless>) ucum(METER.pow(3).times(SI.KILOGRAM.pow(-1)).times(SECOND.pow(-2)).times(6.67259E-11));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Acceleration> ACCELLERATION_OF_FREEFALL = ucum(NonSI.G);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Pressure> ATMOSPHERE = ucum(NonSI.ATMOSPHERE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> LIGHT_YEAR = (Unit<Length>) ucum(NonSI.LIGHT_YEAR);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Force> GRAM_FORCE = (Unit<Force>) ucum(GRAM.times(ACCELLERATION_OF_FREEFALL));
    // POUND_FORCE contains a forward reference to avoirdupois pound weight, so it has been moved after section §36 below
    /////////////////////////////
    // CGS UNITS: UCUM 4.3 §30 //
    /////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Wavenumber> KAYSER = (Unit<Wavenumber>) ucum(Unit.ONE.divide(CENTI(METER)));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Acceleration> GAL = (Unit<Acceleration>) ucum(CENTI(METER).divide(SECOND.pow(2)));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Force> DYNE = ucum(NonSI.DYNE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> ERG = ucum(NonSI.ERG);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<DynamicViscosity> POISE = ucum(NonSI.POISE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<ElectricCurrent> BIOT = ucum(AMPERE.times(10));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<KinematicViscosity> STOKES = ucum(NonSI.STOKE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<MagneticFlux> MAXWELL = ucum(NonSI.MAXWELL);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<MagneticFluxDensity> GAUSS = ucum(NonSI.GAUSS);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<MagneticFieldStrength> OERSTED = (Unit<MagneticFieldStrength>) ucum(Unit.ONE.divide(PI).times(AMPERE).divide(METER).times(250));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<MagnetomotiveForce> GILBERT = (Unit<MagnetomotiveForce>) ucum(OERSTED.times(CENTI(METER)));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Luminance> STILB = (Unit<Luminance>) ucum(CANDELA.divide(CENTI(METER).pow(2)));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Illuminance> LAMBERT = ucum(NonSI.LAMBERT);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Illuminance> PHOT = ucum(LUX.divide(10000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<RadioactiveActivity> CURIE = ucum(NonSI.CURIE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<IonizingRadiation> ROENTGEN = (Unit<IonizingRadiation>) ucum(NonSI.ROENTGEN);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<RadiationDoseAbsorbed> RAD = ucum(NonSI.RAD);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<RadiationDoseEffective> REM = ucum(NonSI.REM);
    /////////////////////////////////////////////////
    // INTERNATIONAL CUSTOMARY UNITS: UCUM 4.4 §31 //
    /////////////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> INCH_INTERNATIONAL = ucum(CENTI(METER).times(254).divide(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> FOOT_INTERNATIONAL = ucum(INCH_INTERNATIONAL.times(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> YARD_INTERNATIONAL = ucum(FOOT_INTERNATIONAL.times(3));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> MILE_INTERNATIONAL = ucum(FOOT_INTERNATIONAL.times(5280));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> FATHOM_INTERNATIONAL = ucum(FOOT_INTERNATIONAL.times(6));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> NAUTICAL_MILE_INTERNATIONAL = ucum(METER.times(1852));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Velocity> KNOT_INTERNATIONAL = (Unit<Velocity>) ucum(NAUTICAL_MILE_INTERNATIONAL.divide(HOUR));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Area> SQUARE_INCH_INTERNATIONAL = (Unit<Area>) ucum(INCH_INTERNATIONAL.pow(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Area> SQUARE_FOOT_INTERNATIONAL = (Unit<Area>) ucum(FOOT_INTERNATIONAL.pow(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Area> SQUARE_YARD_INTERNATIONAL = (Unit<Area>) ucum(YARD_INTERNATIONAL.pow(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> CUBIC_INCH_INTERNATIONAL = (Unit<Volume>) ucum(INCH_INTERNATIONAL.pow(3));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> CUBIC_FOOT_INTERNATIONAL = (Unit<Volume>) ucum(FOOT_INTERNATIONAL.pow(3));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> CUBIC_YARD_INTERNATIONAL = (Unit<Volume>) ucum(YARD_INTERNATIONAL.pow(3));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> BOARD_FOOT_INTERNATIONAL = ucum(CUBIC_INCH_INTERNATIONAL.times(144));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> CORD_INTERNATIONAL = ucum(CUBIC_FOOT_INTERNATIONAL.times(128));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> MIL_INTERNATIONAL = ucum(INCH_INTERNATIONAL.divide(1000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Area> CIRCULAR_MIL_INTERNATIONAL = (Unit<Area>) ucum(MIL_INTERNATIONAL.times(PI).divide(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> HAND_INTERNATIONAL = ucum(INCH_INTERNATIONAL.times(4));
    //////////////////////////////////////////
    // US SURVEY LENGTH UNITS: UCUM 4.4 §32 //
    //////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> FOOT_US_SURVEY = ucum(METER.times(1200).divide(3937));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> YARD_US_SURVEY = ucum(FOOT_US_SURVEY.times(3));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> INCH_US_SURVEY = ucum(FOOT_US_SURVEY.divide(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> ROD_US_SURVEY = ucum(FOOT_US_SURVEY.times(33).divide(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> CHAIN_US_SURVEY = ucum(ROD_US_SURVEY.times(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> LINK_US_SURVEY = ucum(CHAIN_US_SURVEY.divide(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> RAMDEN_CHAIN_US_SURVEY = ucum(FOOT_US_SURVEY.times(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> RAMDEN_LINK_US_SURVEY = ucum(CHAIN_US_SURVEY.divide(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> FATHOM_US_SURVEY = ucum(FOOT_US_SURVEY.times(6));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> FURLONG_US_SURVEY = ucum(ROD_US_SURVEY.times(40));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> MILE_US_SURVEY = ucum(FURLONG_US_SURVEY.times(8));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Area> ACRE_US_SURVEY = (Unit<Area>) ucum(ROD_US_SURVEY.pow(2).times(160));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Area> SQUARE_ROD_US_SURVEY = (Unit<Area>) ucum(ROD_US_SURVEY.pow(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Area> SQUARE_MILE_US_SURVEY = (Unit<Area>) ucum(MILE_US_SURVEY.pow(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Area> SECTION_US_SURVEY = (Unit<Area>) ucum(MILE_US_SURVEY.pow(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Area> TOWNSHP_US_SURVEY = (Unit<Area>) ucum(SECTION_US_SURVEY.times(36));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> MIL_US_SURVEY = ucum(INCH_US_SURVEY.divide(1000));
    /////////////////////////////////////////////////
    // BRITISH IMPERIAL LENGTH UNITS: UCUM 4.4 §33 //
    /////////////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> INCH_BRITISH = ucum(CENTI(METER).times(2539998).divide(1000000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> FOOT_BRITISH = ucum(INCH_BRITISH.times(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> ROD_BRITISH = ucum(FOOT_BRITISH.times(33).divide(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> CHAIN_BRITISH = ucum(ROD_BRITISH.times(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> LINK_BRITISH = ucum(CHAIN_BRITISH.divide(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> FATHOM_BRITISH = ucum(FOOT_BRITISH.times(6));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> PACE_BRITISH = ucum(FOOT_BRITISH.times(5).divide(20));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> YARD_BRITISH = ucum(FOOT_BRITISH.times(3));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> MILE_BRITISH = ucum(FOOT_BRITISH.times(5280));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> NAUTICAL_MILE_BRITISH = ucum(FOOT_BRITISH.times(6080));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> KNOT_BRITISH = (Unit<Length>) ucum(NAUTICAL_MILE_BRITISH.divide(HOUR));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Area> ACRE_BRITISH = (Unit<Area>) ucum(YARD_BRITISH.pow(2).times(4840));
    ///////////////////////////////////
    // US VOLUME UNITS: UCUM 4.4 §34 //
    ///////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> GALLON_US = ucum(CUBIC_INCH_INTERNATIONAL.times(231));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> BARREL_US = ucum(GALLON_US.times(42));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> QUART_US = ucum(GALLON_US.divide(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> PINT_US = ucum(QUART_US.divide(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> GILL_US = ucum(PINT_US.divide(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> FLUID_OUNCE_US = ucum(GILL_US.divide(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> FLUID_DRAM_US = ucum(FLUID_OUNCE_US.divide(8));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> MINIM_US = ucum(FLUID_DRAM_US.divide(60));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> CORD_US = ucum(CUBIC_FOOT_INTERNATIONAL.times(128));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> BUSHEL_US = ucum(CUBIC_INCH_INTERNATIONAL.times(215042).divide(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> GALLON_WINCHESTER = ucum(BUSHEL_US.divide(8));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> PECK_US = ucum(BUSHEL_US.divide(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> DRY_QUART_US = ucum(PECK_US.divide(8));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> DRY_PINT_US = ucum(DRY_QUART_US.divide(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> TABLESPOON_US = ucum(FLUID_OUNCE_US.divide(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> TEASPOON_US = ucum(TABLESPOON_US.divide(3));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> CUP_US = ucum(TABLESPOON_US.times(16));
    /////////////////////////////////////////////////
    // BRITISH IMPERIAL VOLUME UNITS: UCUM 4.4 §35 //
    /////////////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> GALLON_BRITISH = ucum(LITER.times(454609).divide(100000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> PECK_BRITISH = ucum(GALLON_BRITISH.times(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> BUSHEL_BRITISH = ucum(PECK_BRITISH.times(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> QUART_BRITISH = ucum(GALLON_BRITISH.divide(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> PINT_BRITISH = ucum(QUART_BRITISH.divide(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> GILL_BRITISH = ucum(PINT_BRITISH.divide(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> FLUID_OUNCE_BRITISH = ucum(GILL_BRITISH.divide(5));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> FLUID_DRAM_BRITISH = ucum(FLUID_OUNCE_BRITISH.divide(8));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> MINIM_BRITISH = ucum(FLUID_DRAM_BRITISH.divide(60));
    ////////////////////////////////////////////
    // AVOIRDUPOIS WIEGHT UNITS: UCUM 4.4 §36 //
    ////////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> GRAIN = ucum(MILLI(GRAM).times(6479891).divide(100000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> POUND = ucum(GRAIN.times(7000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> OUNCE = ucum(POUND.divide(16));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> DRAM = ucum(OUNCE.divide(16));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> SHORT_HUNDREDWEIGHT = ucum(POUND.times(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> LONG_HUNDREDWEIGHT = ucum(POUND.times(112));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> SHORT_TON = ucum(SHORT_HUNDREDWEIGHT.times(20));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> LONG_TON = ucum(LONG_HUNDREDWEIGHT.times(20));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> STONE = ucum(POUND.times(14));
    // CONTINUED FROM SECTION §29
    // contains a forward reference to POUND, so we had to move it here, below section §36
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Force> POUND_FORCE = (Unit<Force>) ucum(POUND.times(ACCELLERATION_OF_FREEFALL));
    /////////////////////////////////////
    // TROY WIEGHT UNITS: UCUM 4.4 §37 //
    /////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> PENNYWEIGHT_TROY = ucum(GRAIN.times(24));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> OUNCE_TROY = ucum(PENNYWEIGHT_TROY.times(24));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> POUND_TROY = ucum(OUNCE_TROY.times(12));
    /////////////////////////////////////////////
    // APOTECARIES' WEIGHT UNITS: UCUM 4.4 §38 //
    /////////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> SCRUPLE_APOTHECARY = ucum(GRAIN.times(20));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> DRAM_APOTHECARY = ucum(SCRUPLE_APOTHECARY.times(3));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> OUNCE_APOTHECARY = ucum(DRAM_APOTHECARY.times(8));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> POUND_APOTHECARY = ucum(OUNCE_APOTHECARY.times(12));
    /////////////////////////////////////////////
    // TYPESETTER'S LENGTH UNITS: UCUM 4.4 §39 //
    /////////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> LINE = ucum(INCH_INTERNATIONAL.divide(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> POINT = ucum(LINE.divide(6));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> PICA = ucum(POINT.times(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> POINT_PRINTER = ucum(INCH_INTERNATIONAL.times(13837).divide(1000000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> PICA_PRINTER = ucum(POINT_PRINTER.times(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> PIED = ucum(CENTI(METER).times(3248).divide(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> POUCE = ucum(PIED.divide(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> LINGE = ucum(POUCE.divide(12));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> DIDOT = ucum(LINGE.divide(6));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> CICERO = ucum(DIDOT.times(12));
    //////////////////////////////////////
    // OTHER LEGACY UNITS: UCUM 4.5 §40 //
    //////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Temperature> FAHRENHEIT = ucum(KELVIN.times(5).divide(9).plus(459.67));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> CALORIE_AT_15C = ucum(JOULE.times(41858).divide(10000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> CALORIE_AT_20C = ucum(JOULE.times(41819).divide(10000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> CALORIE_MEAN = ucum(JOULE.times(419002).divide(100000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> CALORIE_INTERNATIONAL_TABLE = ucum(JOULE.times(41868).divide(10000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> CALORIE_THERMOCHEMICAL = ucum(JOULE.times(4184).divide(1000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> CALORIE = ucum(CALORIE_THERMOCHEMICAL);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> CALORIE_FOOD = ucum(KILO(CALORIE_THERMOCHEMICAL));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> BTU_AT_39F = ucum(KILO(JOULE).times(105967).divide(100000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> BTU_AT_59F = ucum(KILO(JOULE).times(105480).divide(100000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> BTU_AT_60F = ucum(KILO(JOULE).times(105468).divide(100000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> BTU_MEAN = ucum(KILO(JOULE).times(105587).divide(100000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> BTU_INTERNATIONAL_TABLE = ucum(KILO(JOULE).times(105505585262L).divide(100000000000L));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> BTU_THERMOCHEMICAL = ucum(KILO(JOULE).times(105735).divide(100000));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Energy> BTU = ucum(BTU_THERMOCHEMICAL);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Power> HORSEPOWER = (Unit<Power>) ucum(FOOT_INTERNATIONAL.times(POUND_FORCE).divide(SECOND));
    /////////////////////////////////////////////////////////
    // SECTIONS §41-§43 skipped; implement later if needed //
    /////////////////////////////////////////////////////////
    ///////////////////////////////////////
    // MISCELLANEOUS UNITS: UCUM 4.5 §44 //
    ///////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Volume> STERE = (Unit<Volume>) ucum(METER.pow(3));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Length> ANGSTROM = ucum(NANO(METER).divide(10));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Area> BARN = (Unit<Area>) ucum(FEMTO(METER).pow(2).times(100));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Pressure> ATMOSPHERE_TECHNICAL = (Unit<Pressure>) ucum(KILO(GRAM_FORCE).divide(CENTI(METER).pow(2)));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<ElectricConductance> MHO = ucum(SIEMENS.alternate("mho").asType(ElectricConductance.class));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Pressure> POUND_PER_SQUARE_INCH = (Unit<Pressure>) ucum(POUND_FORCE.divide(INCH_INTERNATIONAL.pow(2)));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Pressure> CIRCLE = (Unit<Pressure>) ucum(PI.times(RADIAN).times(2));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Pressure> SPHERE = (Unit<Pressure>) ucum(PI.times(STERADIAN).times(4));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Mass> CARAT_METRIC = ucum(GRAM.divide(5));
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Dimensionless> CARAT_GOLD = ucum(Unit.ONE.divide(24));
    ////////////////////////////////////////////////
    // INFORMATION TECHNOLOGY UNITS: UCUM 4.6 §45 //
    ////////////////////////////////////////////////
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<DataAmount> BIT = ucum(SI.BIT);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<DataAmount> BYTE = ucum(NonSI.BYTE);
    /** As per <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<DataRate> BAUD = ucum(Unit.ONE.divide(SECOND)).asType(DataRate.class);

    ///////////////////////
    // MISSING FROM UCUM //
    ///////////////////////

    /** To be added to the <a href="http://unitsofmeasure.org/">UCUM</a> standard. */
    public static final Unit<Frequency> FRAMES_PER_SECOND = ucum(Unit.ONE.divide(SECOND)).asType(Frequency.class);

}
