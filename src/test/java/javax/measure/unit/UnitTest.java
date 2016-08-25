/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.unit;

import static org.junit.Assert.*;
import static javax.measure.util.TestUtil.*;

import javax.measure.quantity.Quantity;
import javax.measure.quantity.Dimensionless;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version $Revision: 195 $, $LastChangedDate: 2010-02-24 18:40:34 +0100 (Mi, 24 Feb 2010) $
 */
public class UnitTest {
    Unit<Dimensionless> one;

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    @Before
    public void setUp() throws Exception {
//      super.setUp();

        one = Unit.ONE;
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#tearDown()
     */
    @After
    public void tearDown() throws Exception {
//      super.tearDown();

        one = null;
    }

    /**
     * Test method for {@link javax.measure.unit.Unit#toMetric()}.
     */
    @Test
    public void testToMetric() {
        Unit<? extends Quantity> su = one.toMetric();
        assertTrue(su.isUnscaledMetric());
    }

    /**
     * Test method for {@link javax.measure.unit.Unit#getConverterTo}.
     */
    @Test
    public void testConverterToSI() {
        Double factor = new Double(10);
        UnitConverter converter = one.getConverterTo(one);
        Double result = converter.convert(factor.doubleValue());
        assertEquals(result, factor);
        print(result.toString());
    }

    /**
     * Test method for {@link javax.measure.unit.Unit#isMetric()}.
     */
    @Test
    public void testIsMetric() {
        boolean standard = one.isUnscaledMetric();
        assertTrue(standard);
    }

    /**
     * Test method for {@link javax.measure.unit.Unit#asType(java.lang.Class)}.
     */
  @Test
  public void testAsType() {
      one.asType(Dimensionless.class);
      try {
          MetricSystem.METRE.asType(Dimensionless.class);
          fail("Should have raised ClassCastException");
      } catch (ClassCastException e) {
          assertTrue(true);
      }
  }

    /**
     * Test method for {@link javax.measure.unit.Unit#getDimension()}.
     */
    @Test
    public void testGetDimension() {
        one.getDimension();
    }

    /**
     * Test method for {@link javax.measure.unit.Unit#alternate(java.lang.String)}.
     */
    @Test
    public void testAlternate() {
        Unit<? extends Quantity> alternate = one.alternate(null);
        assertNotNull(alternate);
    }

    /**
     * Test method for {@link javax.measure.unit.Unit#compound(javax.measure.unit.Unit)}.
     */
    /*public void testCompound() {
        Unit<? extends Quantity> compound = one.compound(one);
        assertNotNull(compound);
    }*/

    /**
     * Test method for {@link javax.measure.unit.Unit#transform}.
     */
    @Test
    public void testTransform() {
        Unit<? extends Quantity> result = one.transform(UnitConverter.IDENTITY);
        assertEquals(result, one);
    }

    /**
     * Test method for {@link javax.measure.unit.Unit#add(double)}.
     */
    @Test
    public void testAdd() {
        Unit<? extends Quantity> result = one.add(10);
        assertNotSame(result, one);
    }

    /**
     * Test method for {@link javax.measure.unit.Unit#multiply(long)}.
     */
    @SuppressWarnings("unchecked")
	@Test
    public void testMultiplyLong() {
        Unit<? extends Quantity> result = one.multiply(2L);
        assertNotSame(result, one);
    }

    /**
     * Test method for {@link javax.measure.unit.Unit#multiply(double)}.
     */
    @Test
    public void testMultiplyDouble() {
        Unit<? extends Quantity> result = one.multiply(2.1);
        assertNotSame(result, one);
    }

    /**
     * Test method for {@link javax.measure.unit.Unit#multiply(javax.measure.unit.Unit)}.
     */
    @Test
    public void testMultiplyUnitOfQ() {
        Unit<? extends Quantity> result = one.multiply(one);
        assertEquals(result, one);
    }

    /**
     * Test method for {@link javax.measure.unit.Unit#inverse()}.
     */
    @Test
    public void testInverse() {
        Unit<? extends Quantity> result = one.inverse();
        assertEquals(result, one);
    }

    /**
     * Test method for {@link javax.measure.unit.Unit#divide(long)}.
     */
    @Test
    public void testDivideLong() {
        Unit<? extends Quantity> result = one.divide(2L);
        assertNotSame(result, one);
    }

    /**
     * Test method for {@link javax.measure.unit.Unit#divide(double)}.
     */
    @Test
    public void testDivideDouble() {
        Unit<? extends Quantity> result = one.divide(3.2);
        assertNotSame(result, one);
    }

    /**
     * Test method for {@link javax.measure.unit.Unit#divide(javax.measure.unit.Unit)}.
     */
    @Test
    public void testDivideUnitOfQ() {
        Unit<? extends Quantity> result = one.divide(one);
        assertEquals(result, one);
    }

    /**
     * Test method for {@link javax.measure.unit.Unit#root(int)}.
     */
    @Test
    public void testRoot() {
        Unit<? extends Quantity> root = one.root(2);
        assertEquals(root, one);
    }

    /**
     * Test method for {@link javax.measure.unit.Unit#pow(int)}.
     */
    @Test
    public void testPow() {
        Unit<? extends Quantity> result = one.pow(10);
        assertEquals(result, one);
    }
}
