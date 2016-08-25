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

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.measure.converter.RationalConverter;
import javax.measure.quantity.*;

/**
 * <p> This class contains SI (Système International d'Unités) base units,
 *     and derived units.</p>
 *     
 * <p> It also defines an inner class for the 20 SI prefixes used to form decimal multiples and
 *     submultiples of SI units. For example:[code]
 *     import static javax.measure.unit.SI.*; // Static import.
 *     import static javax.measure.unit.SI.MetricPrefix.*; // Static import.
 *     ...
 *     Unit<Pressure> HECTOPASCAL = HECTO(PASCAL);
 *     Unit<Length> KILOMETRE = KILO(METRE);
 *     [/code]</p>
 *     
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.8 ($Revision: 76 $), $Date: 2009-12-03 23:53:52 +0100 (Do, 03 Dez 2009) $
 * @see <a href="http://en.wikipedia.org/wiki/International_System_of_Units">Wikipedia: International System of Units</a>
 */
public final class SI extends SystemOfUnits {

    /**
     * Holds collection of SI units.
     */
    private static final HashSet<Unit<?>> UNITS = new HashSet<Unit<?>>();

    /**
     * Default constructor (prevents this class from being instantiated).
     */
    private SI() {
    }

    /**
     * Returns the unique instance of this class.
     *
     * @return the SI instance.
     */
    public static final SI getInstance() {
        return INSTANCE;
    }
    private static final SI INSTANCE = new SI();
    ////////////////
    // BASE UNITS //
    ////////////////

    /**
     * The base unit for electric current quantities (<code>A</code>).
     * The Ampere is that constant current which, if maintained in two straight
     * parallel conductors of infinite length, of negligible circular
     * cross-section, and placed 1 meter apart in vacuum, would produce between
     * these conductors a force equal to 2 * 10-7 newton per meter of length.
     * It is named after the French physicist Andre Ampere (1775-1836).
     */
    public static final BaseUnit<ElectricCurrent> AMPERE = si(new BaseUnit<ElectricCurrent>(
            "A"));

    /**
     * The base unit for luminous intensity quantities (<code>cd</code>).
     * The candela is the luminous intensity, in a given direction,
     * of a source that emits monochromatic radiation of frequency
     * 540 * 1012 hertz and that has a radiant intensity in that
     * direction of 1/683 watt per steradian
     * @see <a href="http://en.wikipedia.org/wiki/Candela"> 
     *      Wikipedia: Candela</a>
     */
    public static final BaseUnit<LuminousIntensity> CANDELA = si(new BaseUnit<LuminousIntensity>(
            "cd"));

    /**
     * The base unit for thermodynamic temperature quantities (<code>K</code>).
     * The kelvin is the 1/273.16th of the thermodynamic temperature of the
     * triple point of water. It is named after the Scottish mathematician and
     * physicist William Thomson 1st Lord Kelvin (1824-1907)
     */
    public static final BaseUnit<Temperature> KELVIN = si(new BaseUnit<Temperature>(
            "K"));

    /**
     * The base unit for mass quantities (<code>kg</code>).
     * It is the only SI unit with a prefix as part of its name and symbol.
     * The kilogram is equal to the mass of an international prototype in the
     * form of a platinum-iridium cylinder kept at Sevres in France.
     * @see   #GRAM
     */
    public static final BaseUnit<Mass> KILOGRAM = si(new BaseUnit<Mass>("kg"));

    /**
     * The base unit for length quantities (<code>m</code>).
     * One metre was redefined in 1983 as the distance traveled by light in
     * a vacuum in 1/299,792,458 of a second.
     */
    public static final BaseUnit<Length> METRE = si(new BaseUnit<Length>("m"));

    /**
     * The base unit for amount of substance quantities (<code>mol</code>).
     * The mole is the amount of substance of a system which contains as many
     * elementary entities as there are atoms in 0.012 kilogram of carbon 12.
     */
    public static final BaseUnit<AmountOfSubstance> MOLE = si(new BaseUnit<AmountOfSubstance>(
            "mol"));

    /**
     * The base unit for duration quantities (<code>s</code>).
     * It is defined as the duration of 9,192,631,770 cycles of radiation
     * corresponding to the transition between two hyperfine levels of
     * the ground state of cesium (1967 Standard).
     */
    public static final BaseUnit<Duration> SECOND = si(new BaseUnit<Duration>(
            "s"));
    ////////////////////////////////
    // SI DERIVED ALTERNATE UNITS //
    ////////////////////////////////

    /**
     * The unit for magnetomotive force (<code>At</code>).
     */
    public static final Unit<MagnetomotiveForce> AMPERE_TURN = si(new AlternateUnit<MagnetomotiveForce>("At", SI.AMPERE));

    /**
     * The derived unit for mass quantities (<code>g</code>).
     * The base unit for mass quantity is {@link #KILOGRAM}.
     */
    public static final Unit<Mass> GRAM = KILOGRAM.divide(1000);

    /**
     * The unit for plane angle quantities (<code>rad</code>).
     * One radian is the angle between two radii of a circle such that the
     * length of the arc between them is equal to the radius.
     */
    public static final AlternateUnit<Angle> RADIAN = si(new AlternateUnit<Angle>(
            "rad", Unit.ONE));

    /**
     * The unit for solid angle quantities (<code>sr</code>).
     * One steradian is the solid angle subtended at the center of a sphere by
     * an area on the surface of the sphere that is equal to the radius squared.
     * The total solid angle of a sphere is 4*Pi steradians.
     */
    public static final AlternateUnit<SolidAngle> STERADIAN = si(new AlternateUnit<SolidAngle>(
            "sr", Unit.ONE));

    /**
     * The unit for binary information (<code>bit</code>).
     */
    public static final AlternateUnit<DataAmount> BIT = si(new AlternateUnit<DataAmount>(
            "bit", Unit.ONE));

    /**
     * The derived unit for frequency (<code>Hz</code>).
     * A unit of frequency equal to one cycle per second.
     * After Heinrich Rudolf Hertz (1857-1894), German physicist who was the
     * first to produce radio waves artificially.
     */
    public static final AlternateUnit<Frequency> HERTZ = si(new AlternateUnit<Frequency>(
            "Hz", Unit.ONE.divide(SECOND)));

    /**
     * The derived unit for force (<code>N</code>).
     * One newton is the force required to give a mass of 1 kilogram an Force
     * of 1 metre per second per second. It is named after the English
     * mathematician and physicist Sir Isaac Newton (1642-1727).
     */
    public static final AlternateUnit<Force> NEWTON = si(new AlternateUnit<Force>(
            "N", METRE.times(KILOGRAM).divide(SECOND.pow(2))));

    /**
     * The derived unit for pressure, stress (<code>Pa</code>).
     * One pascal is equal to one newton per square meter. It is named after
     * the French philosopher and mathematician Blaise Pascal (1623-1662).
     */
    public static final AlternateUnit<Pressure> PASCAL = si(new AlternateUnit<Pressure>(
            "Pa", NEWTON.divide(METRE.pow(2))));

    /**
     * The derived unit for energy, work, quantity of heat (<code>J</code>).
     * One joule is the amount of work done when an applied force of 1 newton
     * moves through a distance of 1 metre in the direction of the force.
     * It is named after the English physicist James Prescott Joule (1818-1889).
     */
    public static final AlternateUnit<Energy> JOULE = si(new AlternateUnit<Energy>(
            "J", NEWTON.times(METRE)));

    /**
     * The derived unit for power, radiant, flux (<code>W</code>).
     * One watt is equal to one joule per second. It is named after the British
     * scientist James Watt (1736-1819).
     */
    public static final AlternateUnit<Power> WATT = si(new AlternateUnit<Power>(
            "W", JOULE.divide(SECOND)));

    /**
     * The derived unit for electric charge, quantity of electricity
     * (<code>C</code>).
     * One Coulomb is equal to the quantity of charge transferred in one second
     * by a steady current of one ampere. It is named after the French physicist
     * Charles Augustin de Coulomb (1736-1806).
     */
    public static final AlternateUnit<ElectricCharge> COULOMB = si(new AlternateUnit<ElectricCharge>(
            "C", SECOND.times(AMPERE)));

    /**
     * The derived unit for electric potential difference, electromotive force
     * (<code>V</code>).
     * One Volt is equal to the difference of electric potential between two
     * points on a conducting wire carrying a constant current of one ampere
     * when the power dissipated between the points is one watt. It is named
     * after the Italian physicist Count Alessandro Volta (1745-1827).
     */
    public static final AlternateUnit<ElectricPotential> VOLT = si(new AlternateUnit<ElectricPotential>(
            "V", WATT.divide(AMPERE)));

    /**
     * The derived unit for capacitance (<code>F</code>).
     * One Farad is equal to the capacitance of a capacitor having an equal
     * and opposite charge of 1 coulomb on each plate and a potential difference
     * of 1 volt between the plates. It is named after the British physicist
     * and chemist Michael Faraday (1791-1867).
     */
    public static final AlternateUnit<ElectricCapacitance> FARAD = si(new AlternateUnit<ElectricCapacitance>(
            "F", COULOMB.divide(VOLT)));

    /**
     * The derived unit for electric resistance (<code>Ohm</code>).
     * One Ohm is equal to the resistance of a conductor in which a current of
     * one ampere is produced by a potential of one volt across its terminals.
     * It is named after the German physicist Georg Simon Ohm (1789-1854).
     */
    public static final AlternateUnit<ElectricResistance> OHM = si(new AlternateUnit<ElectricResistance>(
            "Ω", VOLT.divide(AMPERE)));

    /**
     * The derived unit for electric conductance (<code>S</code>).
     * One Siemens is equal to one ampere per volt. It is named after
     * the German engineer Ernst Werner von Siemens (1816-1892).
     */
    public static final AlternateUnit<ElectricConductance> SIEMENS = si(new AlternateUnit<ElectricConductance>(
            "S", AMPERE.divide(VOLT)));

    /**
     * The derived unit for magnetic flux (<code>Wb</code>).
     * One Weber is equal to the magnetic flux that in linking a circuit of one
     * turn produces in it an electromotive force of one volt as it is uniformly
     * reduced to zero within one second. It is named after the German physicist
     * Wilhelm Eduard Weber (1804-1891).
     */
    public static final AlternateUnit<MagneticFlux> WEBER = si(new AlternateUnit<MagneticFlux>(
            "Wb", VOLT.times(SECOND)));

    /**
     * The derived unit for magnetic flux density (<code>T</code>).
     * One Tesla is equal equal to one weber per square metre. It is named
     * after the Serbian-born American electrical engineer and physicist
     * Nikola Tesla (1856-1943).
     */
    public static final AlternateUnit<MagneticFluxDensity> TESLA = si(new AlternateUnit<MagneticFluxDensity>(
            "T", WEBER.divide(METRE.pow(2))));

    /**
     * The derived unit for inductance (<code>H</code>).
     * One Henry is equal to the inductance for which an induced electromotive
     * force of one volt is produced when the current is varied at the rate of
     * one ampere per second. It is named after the American physicist
     * Joseph Henry (1791-1878).
     */
    public static final AlternateUnit<ElectricInductance> HENRY = si(new AlternateUnit<ElectricInductance>(
            "H", WEBER.divide(AMPERE)));

    /**
     * The derived unit for Celsius temperature (<code>Cel</code>).
     * This is a unit of temperature such as the freezing point of water
     * (at one atmosphere of pressure) is 0 Cel, while the boiling point is
     * 100 Cel.
     */
    public static final Unit<Temperature> CELSIUS = si(KELVIN.plus(273.15));

    /**
     * The derived unit for luminous flux (<code>lm</code>).
     * One Lumen is equal to the amount of light given out through a solid angle
     * by a source of one candela intensity radiating equally in all directions.
     */
    public static final AlternateUnit<LuminousFlux> LUMEN = si(new AlternateUnit<LuminousFlux>(
            "lm", CANDELA.times(STERADIAN)));

    /**
     * The derived unit for illuminance (<code>lx</code>).
     * One Lux is equal to one lumen per square metre.
     */
    public static final AlternateUnit<Illuminance> LUX = si(new AlternateUnit<Illuminance>(
            "lx", LUMEN.divide(METRE.pow(2))));

    /**
     * The derived unit for activity of a radionuclide (<code>Bq</code>).
     * One becquerel is the radiation caused by one disintegration per second.
     * It is named after the French physicist, Antoine-Henri Becquerel
     * (1852-1908).
     */
    public static final AlternateUnit<RadioactiveActivity> BECQUEREL = si(new AlternateUnit<RadioactiveActivity>(
            "Bq", Unit.ONE.divide(SECOND)));

    /**
     * The derived unit for absorbed dose, specific energy (imparted), kerma
     * (<code>Gy</code>).
     * One gray is equal to the dose of one joule of energy absorbed per one
     * kilogram of matter. It is named after the British physician
     * L. H. Gray (1905-1965).
     */
    public static final AlternateUnit<RadiationDoseAbsorbed> GRAY = si(new AlternateUnit<RadiationDoseAbsorbed>(
            "Gy", JOULE.divide(KILOGRAM)));

    /**
     * The derived unit for dose equivalent (<code>Sv</code>).
     * One Sievert is equal  is equal to the actual dose, in grays, multiplied
     * by a "quality factor" which is larger for more dangerous forms of
     * radiation. It is named after the Swedish physicist Rolf Sievert
     * (1898-1966).
     */
    public static final AlternateUnit<RadiationDoseEffective> SIEVERT = si(new AlternateUnit<RadiationDoseEffective>(
            "Sv", JOULE.divide(KILOGRAM)));

    /**
     * The derived unit for catalytic activity (<code>kat</code>).
     */
    public static final AlternateUnit<CatalyticActivity> KATAL = si(new AlternateUnit<CatalyticActivity>(
            "kat", MOLE.divide(SECOND)));
    //////////////////////////////
    // SI DERIVED PRODUCT UNITS //
    //////////////////////////////

    /**
     * The metric unit for velocity quantities (<code>m/s</code>).
     * 
     */
    public static final Unit<Velocity> METRES_PER_SECOND = si(new ProductUnit<Velocity>(
            METRE.divide(SECOND)));

    /**
     * The metric unit for acceleration quantities (<code>m/s2</code>).
     */
    public static final Unit<Acceleration> METRES_PER_SQUARE_SECOND = si(new ProductUnit<Acceleration>(
            METRES_PER_SECOND.divide(SECOND)));

    /**
     * The metric unit for area quantities (<code>m2</code>).
     */
    public static final Unit<Area> SQUARE_METRE = si(new ProductUnit<Area>(
            METRE.times(METRE)));

    /**
     * The metric unit for volume quantities (<code>m3</code>).
     */
    public static final Unit<Volume> CUBIC_METRE = si(new ProductUnit<Volume>(
            SQUARE_METRE.times(METRE)));

    /**
     * Equivalent to <code>KILO(METRE)</code>.
     */
    public static final Unit<Length> KILOMETRE = METRE.times(1000);

    /**
     * Equivalent to <code>CENTI(METRE)</code>.
     */
    public static final Unit<Length> CENTIMETRE = METRE.divide(100);

    /**
     * Equivalent to <code>MILLI(METRE)</code>.
     */
    public static final Unit<Length> MILLIMETRE = METRE.divide(1000);

    /////////////////////
    // Collection View //
    /////////////////////
    /**
     * Returns a read only view over theunits defined in this class.
     *
     * @return the collection of SI units.
     */
    public Set<Unit<?>> getUnits() {
        return Collections.unmodifiableSet(UNITS);
    }

    /**
     * Adds a new unit to the collection.
     *
     * @param  unit the unit being added.
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U si(U unit) {
        UNITS.add(unit);
        return unit;
    }

    /////////////////
    // SI PREFIXES //
    /////////////////
    /**
     * Inner class holding prefixes used by the SI system.
     *
     * @author <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
     * @version 1.0
     * @see <a
     * href="http://http://en.wikipedia.org/wiki/SI_prefix">Wikipedia:
     * SI Prefix</a>
     */
    public static class MetricPrefix {

        private MetricPrefix() {
            // Utility class no visible constructor.
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>24</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e24)</code>.
         */
        public static <Q extends Quantity> Unit<Q> YOTTA(Unit<Q> unit) {
            return unit.transform(E24);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>21</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e21)</code>.
         */
        public static <Q extends Quantity> Unit<Q> ZETTA(Unit<Q> unit) {
            return unit.transform(E21);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>18</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e18)</code>.
         */
        public static <Q extends Quantity> Unit<Q> EXA(Unit<Q> unit) {
            return unit.transform(E18);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>15</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e15)</code>.
         */
        public static <Q extends Quantity> Unit<Q> PETA(Unit<Q> unit) {
            return unit.transform(E15);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>12</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e12)</code>.
         */
        public static <Q extends Quantity> Unit<Q> TERA(Unit<Q> unit) {
            return unit.transform(E12);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>9</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e9)</code>.
         */
        public static <Q extends Quantity> Unit<Q> GIGA(Unit<Q> unit) {
            return unit.transform(E9);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>6</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e6)</code>.
         */
        public static <Q extends Quantity> Unit<Q> MEGA(Unit<Q> unit) {
            return unit.transform(E6);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>3</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e3)</code>.
         */
        public static <Q extends Quantity> Unit<Q> KILO(Unit<Q> unit) {
            return unit.transform(E3);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>2</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e2)</code>.
         */
        public static <Q extends Quantity> Unit<Q> HECTO(Unit<Q> unit) {
            return unit.transform(E2);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>1</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e1)</code>.
         */
        public static <Q extends Quantity> Unit<Q> DEKA(Unit<Q> unit) {
            return unit.transform(E1);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>-1</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e-1)</code>.
         */
        public static <Q extends Quantity> Unit<Q> DECI(Unit<Q> unit) {
            return unit.transform(Em1);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>-2</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e-2)</code>.
         */
        public static <Q extends Quantity> Unit<Q> CENTI(Unit<Q> unit) {
            return unit.transform(Em2);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>-3</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e-3)</code>.
         */
        public static <Q extends Quantity> Unit<Q> MILLI(Unit<Q> unit) {
            return unit.transform(Em3);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>-6</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e-6)</code>.
         */
        public static <Q extends Quantity> Unit<Q> MICRO(Unit<Q> unit) {
            return unit.transform(Em6);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>-9</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e-9)</code>.
         */
        public static <Q extends Quantity> Unit<Q> NANO(Unit<Q> unit) {
            return unit.transform(Em9);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>-12</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e-12)</code>.
         */
        public static <Q extends Quantity> Unit<Q> PICO(Unit<Q> unit) {
            return unit.transform(Em12);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>-15</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e-15)</code>.
         */
        public static <Q extends Quantity> Unit<Q> FEMTO(Unit<Q> unit) {
            return unit.transform(Em15);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>-18</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e-18)</code>.
         */
        public static final <Q extends Quantity> Unit<Q> ATTO(Unit<Q> unit) {
            return unit.transform(Em18);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>-21</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e-21)</code>.
         */
        public static <Q extends Quantity> Unit<Q> ZEPTO(Unit<Q> unit) {
            return unit.transform(Em21);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>-24</sup></code>
         *
         * @param  unit any unit.
         * @return <code>unit.times(1e-24)</code>.
         */
        public static <Q extends Quantity> Unit<Q> YOCTO(Unit<Q> unit) {
            return unit.transform(Em24);
        }
        // Holds prefix converters (optimization).
        static final RationalConverter E24 = new RationalConverter(
                BigInteger.TEN.pow(24), BigInteger.ONE);

        static final RationalConverter E21 = new RationalConverter(
                BigInteger.TEN.pow(21), BigInteger.ONE);

        static final RationalConverter E18 = new RationalConverter(
                BigInteger.TEN.pow(18), BigInteger.ONE);

        static final RationalConverter E15 = new RationalConverter(
                BigInteger.TEN.pow(15), BigInteger.ONE);

        static final RationalConverter E12 = new RationalConverter(
                BigInteger.TEN.pow(12), BigInteger.ONE);

        static final RationalConverter E9 = new RationalConverter(
                BigInteger.TEN.pow(9), BigInteger.ONE);

        static final RationalConverter E6 = new RationalConverter(
                BigInteger.TEN.pow(6), BigInteger.ONE);

        static final RationalConverter E3 = new RationalConverter(
                BigInteger.TEN.pow(3), BigInteger.ONE);

        static final RationalConverter E2 = new RationalConverter(
                BigInteger.TEN.pow(2), BigInteger.ONE);

        static final RationalConverter E1 = new RationalConverter(
                BigInteger.TEN.pow(1), BigInteger.ONE);

        static final RationalConverter Em1 = new RationalConverter(
                BigInteger.ONE, BigInteger.TEN.pow(1));

        static final RationalConverter Em2 = new RationalConverter(
                BigInteger.ONE, BigInteger.TEN.pow(2));

        static final RationalConverter Em3 = new RationalConverter(
                BigInteger.ONE, BigInteger.TEN.pow(3));

        static final RationalConverter Em6 = new RationalConverter(
                BigInteger.ONE, BigInteger.TEN.pow(6));

        static final RationalConverter Em9 = new RationalConverter(
                BigInteger.ONE, BigInteger.TEN.pow(9));

        static final RationalConverter Em12 = new RationalConverter(
                BigInteger.ONE, BigInteger.TEN.pow(12));

        static final RationalConverter Em15 = new RationalConverter(
                BigInteger.ONE, BigInteger.TEN.pow(15));

        static final RationalConverter Em18 = new RationalConverter(
                BigInteger.ONE, BigInteger.TEN.pow(18));

        static final RationalConverter Em21 = new RationalConverter(
                BigInteger.ONE, BigInteger.TEN.pow(21));

        static final RationalConverter Em24 = new RationalConverter(
                BigInteger.ONE, BigInteger.TEN.pow(24));

    }
}
