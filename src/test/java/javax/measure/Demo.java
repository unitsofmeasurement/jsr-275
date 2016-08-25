/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure;

import javax.measure.quantity.*;
import javax.measure.unit.MetricSystem;
import javax.measure.util.QuantityFactory;

/**
 * @author <a href="mailto:desruisseaux@users.sourceforge.net">Martin Desruisseaux</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 0.1 ($Revision: 134 $), $Date: 2010-02-17 21:55:53 +0100 (Mi, 17 Feb 2010) $
 */
public class Demo {

  private static Length getSomeLength() {
    return QuantityFactory.getInstance().create(Length.class, 20, MetricSystem.METRE);
  }

  private static Mass getSomeMass() {
    return QuantityFactory.getInstance().create(Mass.class, 30, MetricSystem.KILOGRAM);
  }

  public static void main(String[] args) {
    Length someLength = getSomeLength();
    System.out.println("value    = " + someLength.getValue());
    System.out.println("unit     = " + someLength.getUnit()  +
                       getDisplayName(someLength.getUnit()));
    System.out.println("toString = " + someLength);
    System.out.println();

    Mass someMass = getSomeMass();
    System.out.println("value    = " + someMass.getValue());
    System.out.println("unit     = " + someMass.getUnit() +
               getDisplayName(someMass.getUnit()));
    System.out.println("toString = " + someMass);

    UnitConverter converter = someMass.getUnit().getConverterTo(MetricSystem.GRAM);

    System.out.println(converter.convert(someMass.getValue().doubleValue()));

    System.out.println(converter.convert(someLength.getValue().doubleValue()));

    System.out.println("This isn't typesafe: " +
      String.valueOf(someMass.getValue().doubleValue() + someLength.getValue().doubleValue()));
  }

  private static final String getDisplayName(Unit<?> unit) {
        return ((unit.getName() != null) ? " (" +
                unit.getName() +")" : "");
  }
}
