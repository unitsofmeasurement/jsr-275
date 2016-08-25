/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
/**
 * Provides strongly typed measurements to enforce compile-time
 * check of parameters consistency and avoid interface errors.
 *
 * <p> Let's take the following example:[code]
 *         class Person {
 *             void setMass(double weight);
 *         }[/code]
 *     Should the mass be in pound, kilogram ??<br>
 *     Using quantities there is no room for error:[code]
 *         class Person {
 *             void setMass(Mass mass);
 *         }[/code]
 *     Not only the interface is cleaner (the value has to be of mass type);
 *     but also there is no confusion on the measurement unit:[code]
 *         double massInKg = mass.doubleValue(KILOGRAM);
 *         double massInLb = mass.doubleValue(POUND);[/code]
 *     Quantity types work hand-in-hand with units (also parameterized).
 *     For example, the following would result in compile-time error:[code]
 *         double massInLiter = mass.doubleValue(LITRE); // Compile error, Unit<Mass> required.
 *         [/code]</p>
 *
 * <p> Users may create their own {@link javax.measure.Quantity
 *     Quantity} implementation:[code]
 *
 *          public class Period implements Time {
 *               long nanoseconds;
 *               ...
 *          }
 *
 *          public class Distance implements Length {
 *               double meters;
 *               ...
 *          }
 *
 *          public class Velocity3D implements Velocity {
 *               double x, y, z; // In meters.
 *               public double doubleValue(Unit<Velocity> unit) { ... } // Returns vector norm.
 *               ...
 *          }
 *
 *
 * [/code]</p>
 *
 * <p> Users may also combine a definite amount (a number)
 *     with a unit and make it a {@link javax.measure.Quantity Quantity} (and
 *     a {@link javax.measure.QuantityProvider QuantityProvider} instance).[code]
 *          QuantityProvider provider;
 *          ...
 *          person.setMass(provider.create(Mass.class, 180.0, POUND)); // Unit<Mass>
 *          timer.setPeriod(provider.create(Time.class, 20, MILLI(SECOND)); // Unit<Duration>
 *          bottle.setPression(provider.create("23.4 kg/(m.s2)").to(PASCAL)); // Unit<Pressure>
 *          // or bottle.setPression(provider.create("23.4 kg/(m.s2)").asType(Pressure.class);
 *      [/code]</p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.1, $Date: 2010-02-16 22:35:17 +0100 (Di, 16 Feb 2010) $
 */
package javax.measure;
