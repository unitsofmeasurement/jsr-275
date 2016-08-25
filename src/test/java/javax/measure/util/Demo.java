/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.util;

import static javax.measure.unit.MetricSystem.KILOGRAM;
import static javax.measure.unit.MetricSystem.METRE;

import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.QuantityFactory;

/**
 * @author <a href="mailto:desruisseaux@users.sourceforge.net">Martin Desruisseaux</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 0.2 ($Revision: 210 $), $Date: 2010-02-25 23:34:46 +0100 (Do, 25 Feb 2010) $
 */
public class Demo {

    private static Length getSomeLength() {
        return QuantityFactory.getInstance(Length.class).create(20, METRE);
    }

    private static Mass getSomeMass() {
        return QuantityFactory.getInstance(Mass.class).create(30, KILOGRAM);
    }

    public static void main(String[] args) {
        Length someLength = getSomeLength();
        System.out.println("toString = " + someLength);
        System.out.println();

        Mass someMass = getSomeMass();
        System.out.println("toString = " + someMass);
    }
}
