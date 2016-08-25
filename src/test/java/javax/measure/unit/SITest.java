/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.unit;

import static javax.measure.util.TestUtil.print;
import static javax.measure.unit.MetricSystem.METRE;
import static javax.measure.unit.USCustomarySystem.METER;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Unit test for class javax.measure.unit.SI
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.1 ($Revision: 172 $), $Date: 2010-02-21 20:02:14 +0100 (So, 21 Feb 2010) $
 */
public class SITest extends TestCase {

    public SITest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public static void main(String[] args) {
        new SITest("").testGetInstance();
    }
    /**
     * Test of getInstance method, of class SI.
     */
    @Test
    public void testGetInstance() {

//        print("getInstance: " + NonSI.GALLON_UK.divide(8) + " (" +
//              NonSI.GALLON_UK.divide(8).getDimension().toString() + ")");
        MetricSystem result = MetricSystem.getInstance();

        // Checks SI contains the 7 SI base units.
        assertTrue(result.getUnits().contains(Unit.valueOf("m")));
        assertTrue(result.getUnits().contains(Unit.valueOf("kg")));
        assertTrue(result.getUnits().contains(Unit.valueOf("s")));
        assertTrue(result.getUnits().contains(Unit.valueOf("mol")));
        assertTrue(result.getUnits().contains(Unit.valueOf("K")));
        assertTrue(result.getUnits().contains(Unit.valueOf("cd")));
        assertTrue(result.getUnits().contains(Unit.valueOf("A")));

        print(Unit.valueOf("m").getDimension().toString());
    }

    @Test
    public void testSIvsUS() {
    	assertEquals(METRE, METER);
    }
}
