/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */

package javax.measure.unit;

import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import static javax.measure.unit.USCustomarySystem.METER;
import static javax.measure.unit.MetricSystem.KILOGRAM;

/**
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @author Josh Bloch
 * 
 * This <type>enum</type> is based on Josh Bloch's example in "Effective Java Second Edition"
 * 
 * <p>
 * Suppose you want to add data and behavior to an enum. 
 * For example consider the planets of the solar system. 
 * Each planet knows its mass and radius, and can calculate its surface gravity and the weight of an object on the planet. 
 * Here is how it looks:
 * </p>
 */
public enum Planet {
	 	MERCURY (KILOGRAM.multiply(3.303e+23), METER.multiply(2.4397e6)),
	    VENUS   (KILOGRAM.multiply(4.869e+24), METER.multiply(6.0518e6)),
	    EARTH   (KILOGRAM.multiply(5.976e+24), METER.multiply(6.37814e6)),
	    MARS    (KILOGRAM.multiply(6.421e+23), METER.multiply(3.3972e6)),
	    JUPITER (KILOGRAM.multiply(1.9e+27),   METER.multiply(7.1492e7)),
	    SATURN  (KILOGRAM.multiply(5.688e+26), METER.multiply(6.0268e7)),
	    URANUS  (KILOGRAM.multiply(8.686e+25), METER.multiply(2.5559e7)),
	    NEPTUNE (KILOGRAM.multiply(1.024e+26), METER.multiply(2.4746e7)),
	    PLUTO   (KILOGRAM.multiply(1.27e+22),  METER.multiply(1.137e6));

	    private final Unit<Mass> mass;   // in kilograms
	    private final Unit<Length> radius; // in meters
	    Planet(Unit<Mass> mass, Unit<Length> radius) {
	        this.mass = mass;
	        this.radius = radius;
	    }
	    public Unit<Mass> mass()   { return mass; }
	    public Unit<Length> radius() { return radius; }

	    // universal gravitational constant  (m3 kg-1 s-2)
//	    public static Unit<Dimensionless> G = Unit.valueOf(6.67300E-11);
	    private static double G = 6.67300E-11;
	    
	    public Unit<?> surfaceGravity() {
	        return mass.divide(radius.multiply(radius)).multiply(G);
	    }
	    public Unit<?> surfaceWeight(Unit<Mass> otherMass) {
	        return otherMass.multiply(surfaceGravity());
	    }
}
