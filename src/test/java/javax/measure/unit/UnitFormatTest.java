/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.unit;

import static javax.measure.unit.MetricSystem.*;
import static javax.measure.util.TestUtil.*;

import java.util.Locale;

import javax.measure.quantity.Length;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version $Revision: 206 $, $Date: 2010-02-25 02:40:17 +0100 (Do, 25 Feb 2010) $
 */
public class UnitFormatTest extends TestCase {
//  private static final String COMPARISON_POINT = "pt";
    private static final String COMPARISON_TEXT = "km";
    private static final Locale COMPARISON_LOCALE = Locale.UK;

    UnitFormat format;
    Unit<Length> l1;
    Unit<Length> l2;

    protected void setUp() throws Exception {
        super.setUp();
        //setName(UCUMFormatTest.class.getSimpleName());

        l1 = CENTI(METRE);
        l2 = MILLI(METRE);

        print("Running " + getName()+
                " [" + getClass().getSimpleName() + "]");
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testDefault() {
        format = UnitFormat.getInstance();
        //format.format(unit, appendable);
        String result = format.format(l1);
        print(result);
        //System.out.println(unit2);
        result = format.format(l2);
        print(result);
    }

    @Test
    public void testGetInstanceLocale() {
        format = UnitFormat.getInstance(COMPARISON_LOCALE);
        String formattedText = format.format(l1);
        print(formattedText);
        //System.out.println(unit2);
        formattedText = format.format(l2);
        print(formattedText);
 //       assertEquals(formattedText, COMPARISON_TEXT); // @test hardcoded string here to verify English locale used
    }

    @Test
    public void testGetStandard() {
        format = UnitFormat.getInstance();
        String formattedText = format.format(l1);
        print(formattedText);
        //System.out.println(unit2);
        formattedText = format.format(l2);
        print(formattedText);
        print(USCustomarySystem.ELECTRON_VOLT.getDimension().toString());
        print(USCustomarySystem.ELECTRON_VOLT.toString());
    }
    
//    @Test
//    public void testMultiples() {
//    	Unit u = CENTI(METRE);
//    	print(u.toString());
//    }

//    private void applyTest(UnitFormat uf, Unit u, Appendable a) {
//        try {
//            uf.format(u, a);
//        } catch (Exception ex) {
//            fail(ex.getMessage());
//        }
//    }

    /**
     * Tests the {@link Unit#toString()} method, which is backed by {@link UnitFormat}.
     *
     * @see http://kenai.com/jira/browse/JSR_275-43
     */
//    @Ignore
//    public void testToString() {
//        assertEquals("m", METRE.toString());
//        assertEquals(COMPARISON_TEXT, KILO(METRE).toString());
//        assertEquals(COMPARISON_TEXT, METRE.multiply(1000).toString());
//        assertEquals(COMPARISON_TEXT, METRE.multiply(1000d).toString());
//    }
}
