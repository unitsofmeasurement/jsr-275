/**
 * 
 */
package javax.measure.unit;

import static javax.measure.util.TestUtil.print;

import org.junit.Test;


/**
 * @author Werner Keil
 *
 */
public class Planetarium {

	@Test
	public void testPlanets() {
		Planet[] solarSystem = Planet.values();
		
		for (Planet planet : solarSystem) {
			print(planet);
		}
	}
}
