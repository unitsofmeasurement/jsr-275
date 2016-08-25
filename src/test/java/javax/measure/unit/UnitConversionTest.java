/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.unit;

import static javax.measure.util.TestUtil.*;
import static org.junit.Assert.*;

import javax.measure.quantity.Length;
import javax.measure.quantity.QuantityFactory;
import static javax.measure.unit.MetricSystem.*;

import org.junit.Test;

/**
 * @version $Revision: 223 $, $Date: 2010-03-14 15:44:36 +0100 (So, 14 Mär 2010) $
 * @author $Author: keilw $
 */
public class UnitConversionTest {
    static final Unit<Length> unit1 = MetricSystem.METRE;
    static final Unit<Length> unit2 = MetricSystem.CENTI(METRE);
    static final Unit<Length> unit3 = USCustomarySystem.FOOT;
    
    protected void setUp() throws Exception {
//        super.setUp();
    }

    protected void tearDown() throws Exception {
//        super.tearDown();
    }

    @Test
    public void testConvert() {
        try {
            //unitConverter = unit1.getConverterTo(unit2);
            Length m1 = QuantityFactory.getInstance(Length.class).create(23, unit1);
            //reset = true;

            UnitConverter converter = unit1.getConverterTo(unit2);
//            Length m2 = m1.to(unit2, MathContext.DECIMAL32);
            Length m2 = QuantityFactory.getInstance(Length.class).create(converter.convert(23), unit2);
      //      assertEquals(2300d, m2.doubleValue(unit2));
            String operation;
            if (isTestOutput()) {
                operation = m1 + " -> " + unit2;
                String number = m2.toString();
                StringBuilder build = new StringBuilder(operation);
                build.append(": ");
                build.append(number);
                print(build.toString());
            }
            
            converter = unit2.getConverterTo(unit3);
            if (isTestOutput()) {
                operation = unit2 + " -> " + unit3;
                print(operation);
            }
            double foot1 = converter.convert(m2.getValue().doubleValue());
            double foot2 = m2.doubleValue(unit3);
            assertEquals(Double.valueOf(foot1), Double.valueOf(foot2));
            print(foot2);
        } catch (Exception e) {
            //reset = true;
            fail(e.getMessage());
        }
    }
}
