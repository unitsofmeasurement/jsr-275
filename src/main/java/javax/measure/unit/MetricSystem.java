/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.unit;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.measure.SystemOfUnits;
import javax.measure.Unit;
import javax.measure.quantity.*;

/**
 * <p> This class contains SI (Système International d'Unités) base units,
 *     and derived units.</p>
 *
 * <p> It also defines an inner class for the 20 SI prefixes used to form decimal multiples and
 *     submultiples of SI units. For example:[code]
 *     import static javax.measure.unit.SI.*; // Static import.
 *     import static javax.measure.unit.Prefix.Metric.*; // Static import.
 *     ...
 *     Unit<Pressure> HECTOPASCAL = HECTO(PASCAL);
 *     Unit<Length> KILOMETRE = KILO(METRE);
 *     [/code]</p>
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.0 ($Revision: 134 $), $Date: 2010-02-17 21:55:53 +0100 (Mi, 17 Feb 2010) $
 * @see <a href="http://en.wikipedia.org/wiki/Metric_System">Wikipedia: Metric System</a>
 * @see <a href="http://en.wikipedia.org/wiki/International_System_of_Units">Wikipedia: International System of Units</a>
 */
public final class MetricSystem extends SystemOfUnits {

    /**
     * Holds collection of SI units.
     */
    private static final HashSet<Unit<?>> UNITS = new HashSet<Unit<?>>();

    /**
     * The singleton instance of {@code SI}.
     */
    private static final MetricSystem INSTANCE = new MetricSystem();

    @Override
    public String getName() {
        return MetricSystem.class.getSimpleName();
    }

    /**
     * Returns the singleton instance of this class.
     *
     * @return the SI instance.
     */
    public static final MetricSystem getInstance() {
        return INSTANCE;
    }

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
    public static final BaseUnit<Electric.Current> AMPERE = si(new BaseUnit<Electric.Current>(
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
    public static final BaseUnit<Luminous.Intensity> CANDELA = si(new BaseUnit<Luminous.Intensity>(
            "cd"));

    /**
     * The base unit for thermodynamic temperature quantities (<code>K</code>).
     * The kelvin is the 1/273.16th of the thermodynamic temperature of the
     * triple point of water. It is named after the Scottish mathematician and
     * physicist William Thomson 1st Lord Kelvin (1824-1907)
     */
    public static final BaseUnit<Temperature> KELVIN = si(new BaseUnit<Temperature>(
            "Kelvin", "K"));

    /**
     * The base unit for mass quantities (<code>kg</code>).
     * It is the only SI unit with a prefix as part of its name and symbol.
     * The kilogram is equal to the mass of an international prototype in the
     * form of a platinum-iridium cylinder kept at Sevres in France.
     * @see   #GRAM
     */
    public static final BaseUnit<Mass> KILOGRAM = si(new BaseUnit<Mass>("Kilogram", "kg"));

    /**
     * The base unit for length quantities (<code>m</code>).
     * One metre was redefined in 1983 as the distance traveled by light in
     * a vacuum in 1/299,792,458 of a second.
     */
    public static final BaseUnit<Length> METRE = si(new BaseUnit<Length>("Metre", "m"));

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
    public static final BaseUnit<Time> SECOND = si(new BaseUnit<Time>(
            "s"));
    ////////////////////////////////
    // SI DERIVED ALTERNATE UNITS //
    ////////////////////////////////

    /**
     * The unit for magnetomotive force (<code>At</code>).
     */
    public static final Unit<MagnetomotiveForce> AMPERE_TURN = si(new AlternateUnit<MagnetomotiveForce>("ampere-turn", "At", MetricSystem.AMPERE));

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
            "radian", "rad", Unit.ONE));

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
            "hertz", "Hz", Unit.ONE.divide(SECOND)));

    /**
     * The derived unit for force (<code>N</code>).
     * One newton is the force required to give a mass of 1 kilogram an Force
     * of 1 metre per second per second. It is named after the English
     * mathematician and physicist Sir Isaac Newton (1642-1727).
     */
    public static final AlternateUnit<Force> NEWTON = si(new AlternateUnit<Force>(
            "Newton", "N", METRE.multiply(KILOGRAM).divide(SECOND.pow(2))));

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
            "J", NEWTON.multiply(METRE)));

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
    public static final AlternateUnit<Electric.Charge> COULOMB = si(new AlternateUnit<Electric.Charge>(
            "C", SECOND.multiply(AMPERE)));

    /**
     * The derived unit for electric potential difference, electromotive force
     * (<code>V</code>).
     * One Volt is equal to the difference of electric potential between two
     * points on a conducting wire carrying a constant current of one ampere
     * when the power dissipated between the points is one watt. It is named
     * after the Italian physicist Count Alessandro Volta (1745-1827).
     */
    public static final AlternateUnit<Electric.Potential> VOLT = si(new AlternateUnit<Electric.Potential>(
            "Volt", "V", WATT.divide(AMPERE)));

    /**
     * The derived unit for capacitance (<code>F</code>).
     * One Farad is equal to the capacitance of a capacitor having an equal
     * and opposite charge of 1 coulomb on each plate and a potential difference
     * of 1 volt between the plates. It is named after the British physicist
     * and chemist Michael Faraday (1791-1867).
     */
    public static final AlternateUnit<Electric.Capacitance> FARAD = si(new AlternateUnit<Electric.Capacitance>(
            "F", COULOMB.divide(VOLT)));

    /**
     * The derived unit for electric resistance (<code>Ohm</code>).
     * One Ohm is equal to the resistance of a conductor in which a current of
     * one ampere is produced by a potential of one volt across its terminals.
     * It is named after the German physicist Georg Simon Ohm (1789-1854).
     */
    public static final AlternateUnit<Electric.Resistance> OHM = si(new AlternateUnit<Electric.Resistance>(
            "Ohm", "Ω", VOLT.divide(AMPERE)));

    /**
     * The derived unit for electric conductance (<code>S</code>).
     * One Siemens is equal to one ampere per volt. It is named after
     * the German engineer Ernst Werner von Siemens (1816-1892).
     */
    public static final AlternateUnit<Electric.Conductance> SIEMENS = si(new AlternateUnit<Electric.Conductance>(
            "S", AMPERE.divide(VOLT)));

    /**
     * The derived unit for magnetic flux (<code>Wb</code>).
     * One Weber is equal to the magnetic flux that in linking a circuit of one
     * turn produces in it an electromotive force of one volt as it is uniformly
     * reduced to zero within one second. It is named after the German physicist
     * Wilhelm Eduard Weber (1804-1891).
     */
    public static final AlternateUnit<Magnetic.Flux> WEBER = si(new AlternateUnit<Magnetic.Flux>(
            "Wb", VOLT.multiply(SECOND)));

    /**
     * The derived unit for magnetic flux density (<code>T</code>).
     * One Tesla is equal equal to one weber per square metre. It is named
     * after the Serbian-born American electrical engineer and physicist
     * Nikola Tesla (1856-1943).
     */
    public static final AlternateUnit<Magnetic.FluxDensity> TESLA = si(new AlternateUnit<Magnetic.FluxDensity>(
            "T", WEBER.divide(METRE.pow(2))));

    /**
     * The derived unit for inductance (<code>H</code>).
     * One Henry is equal to the inductance for which an induced electromotive
     * force of one volt is produced when the current is varied at the rate of
     * one ampere per second. It is named after the American physicist
     * Joseph Henry (1791-1878).
     */
    public static final AlternateUnit<Electric.Inductance> HENRY = si(new AlternateUnit<Electric.Inductance>(
            "H", WEBER.divide(AMPERE)));

    /**
     * The derived unit for Celsius temperature (<code>Cel</code>).
     * This is a unit of temperature such as the freezing point of water
     * (at one atmosphere of pressure) is 0 Cel, while the boiling point is
     * 100 Cel.
     */
    public static final Unit<Temperature> CELSIUS = si(KELVIN.add(273.15));

    /**
     * The derived unit for luminous flux (<code>lm</code>).
     * One Lumen is equal to the amount of light given out through a solid angle
     * by a source of one candela intensity radiating equally in all directions.
     */
    public static final AlternateUnit<Luminous.Flux> LUMEN = si(new AlternateUnit<Luminous.Flux>(
            "lm", CANDELA.multiply(STERADIAN)));

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
    public static final AlternateUnit<Radiation.RadioactiveActivity> BECQUEREL = si(new AlternateUnit<Radiation.RadioactiveActivity>(
            "Bq", Unit.ONE.divide(SECOND)));

    /**
     * The derived unit for absorbed dose, specific energy (imparted), kerma
     * (<code>Gy</code>).
     * One gray is equal to the dose of one joule of energy absorbed per one
     * kilogram of matter. It is named after the British physician
     * L. H. Gray (1905-1965).
     */
    public static final AlternateUnit<Radiation.DoseAbsorbed> GRAY = si(new AlternateUnit<Radiation.DoseAbsorbed>(
            "Gy", JOULE.divide(KILOGRAM)));

    /**
     * The derived unit for dose equivalent (<code>Sv</code>).
     * One Sievert is equal  is equal to the actual dose, in grays, multiplied
     * by a "quality factor" which is larger for more dangerous forms of
     * radiation. It is named after the Swedish physicist Rolf Sievert
     * (1898-1966).
     */
    public static final AlternateUnit<Radiation.DoseEffective> SIEVERT = si(new AlternateUnit<Radiation.DoseEffective>(
            "Sievert", "Sv", JOULE.divide(KILOGRAM)));

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
            METRE.multiply(METRE)));

    /**
     * The metric unit for volume quantities (<code>m3</code>).
     */
    public static final Unit<Volume> CUBIC_METRE = si(new ProductUnit<Volume>(
            SQUARE_METRE.multiply(METRE)));

    /**
     * Equivalent to <code>KILO(METRE)</code>.
     */
    public static final Unit<Length> KILOMETRE = METRE.multiply(1000);

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
}
