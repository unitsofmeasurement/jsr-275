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
//import javax.measure.unit.NonSI;
import javax.measure.unit.MetricSystem;
import javax.measure.util.QuantityFactory;
import javax.measure.Unit;
import javax.measure.UnitConverter;

import org.junit.Test;

/**
 * @version $Revision: 134 $, $Date: 2010-02-17 21:55:53 +0100 (Mi, 17 Feb 2010) $
 * @author $Author: keilw $
 */
public class UnitConversionTest {
    static final Unit<Length> unit1 = MetricSystem.METRE;
    static final Unit<Length> unit2 = MetricSystem.CENTIMETRE;

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
            Length m1 = QuantityFactory.getInstance().create(Length.class, 23, unit1);
            //reset = true;

            UnitConverter converter = m1.getUnit().getConverterTo(unit2);
//            Length m2 = m1.to(unit2, MathContext.DECIMAL32);
            Length m2 = QuantityFactory.getInstance().create(Length.class, converter.convert(23), unit2);
            assertEquals(2300d, m2.getValue());
            if (isTestOutput()) {
                String operation = m1 + " -> " + unit2;
                String number = m2.toString();
                StringBuilder build = new StringBuilder(operation);
                build.append(": ");
                build.append(number);
                print(build.toString());
            }

        } catch (Exception e) {
            //reset = true;
            //number = UI_ERR;
            fail(e.getMessage());
        }
    }
}
