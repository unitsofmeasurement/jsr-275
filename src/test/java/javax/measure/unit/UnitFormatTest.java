/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.unit;

import static javax.measure.unit.MetricSystem.*;
import static javax.measure.unit.USCustomarySystem.*;

import static javax.measure.util.TestUtil.*;
import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Locale;

import javax.measure.quantity.Length;

import org.junit.Before;
import org.junit.Test;

/**
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version $Revision: 223 $, $Date: 2010-03-14 15:44:36 +0100 (So, 14 Mär 2010) $
 */
public class UnitFormatTest {
  private static final String COMPARISON_FOOT = "ft";
    private static final String COMPARISON_KM = "km";
    private static final Locale COMPARISON_LOCALE = Locale.UK;

    UnitFormat format;
    Unit<Length> cm;
    Unit<Length> mm;
    Unit<Length> foot;
    
    @Before
    public void setUp() throws Exception {
        //setName(UCUMFormatTest.class.getSimpleName());

        cm = CENTI(METRE);
        mm = MILLI(METRE);
        foot = FOOT;

//        print("Running " + getClass().getSimpleName() + "...");
    }

    protected void tearDown() throws Exception {
//        super.tearDown();
    }

    @Test
    public void testDefault() {
        format = UnitFormat.getInstance();
        //format.format(unit, appendable);
        String formattedText = format.format(cm);
        print(formattedText);
        //System.out.println(unit2);
        formattedText = format.format(mm);
        print(formattedText);
        formattedText = format.format(foot);
        print(formattedText);
    }

    @Test
    public void testGetInstanceLocale() {
        format = UnitFormat.getInstance(COMPARISON_LOCALE);
        String formattedText = format.format(cm);
        print(formattedText);
        //System.out.println(unit2);
        formattedText = format.format(mm);
        print(formattedText);
        formattedText = format.format(foot);
        print(formattedText);
        assertEquals(COMPARISON_FOOT, formattedText);
    }

    @Test
    public void testUSVolt() {
        print(ELECTRON_VOLT.getDimension().toString());
        print(ELECTRON_VOLT.toString());
    }
    
    @Test
    public void testSubMultiples() {
    	Unit<Length> u = CENTI(METRE);
    	print(u.toString());
    }

    /**
     * Tests the {@link Unit#toString()} method, which is backed by {@link UnitFormat}.
     *
     * @see http://kenai.com/jira/browse/JSR_275-43
     */
    @Test
    public void testToString() {
        assertEquals("m", METRE.toString());
        // Multiples
        assertEquals(COMPARISON_KM, KILO(METRE).toString());
        assertEquals(COMPARISON_KM, METRE.multiply(1000).toString());
        assertEquals(COMPARISON_KM, METRE.multiply(1000d).toString());
        assertEquals("Tm", METRE.multiply(BigInteger.TEN.pow(12).longValue()).toString());
        // Submultiples
        assertEquals("cm", METRE.divide(100d).toString());
        assertEquals("mm", METRE.divide(1000d).toString());
        assertEquals("fm", METRE.divide(BigInteger.TEN.pow(15).longValue()).toString());
    }
}
