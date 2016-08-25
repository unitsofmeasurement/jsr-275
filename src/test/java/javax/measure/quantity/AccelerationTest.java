/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
/**
 *
 */
package javax.measure.quantity;

import static javax.measure.unit.MetricSystem.*;
import static javax.measure.util.TestUtil.*;

import javax.measure.QuantityProvider;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Length;
import javax.measure.quantity.Velocity;
import javax.measure.unit.MetricSystem;
import javax.measure.util.QuantityFactory;

import org.junit.Test;


/**
 * @author Werner Keil
 *
 */
public class AccelerationTest {

    @Test
    public void testFallSpeed() {
        QuantityProvider provider = QuantityFactory.getInstance();
        Acceleration gravityOnEarth = provider.create(Acceleration.class, 9.808, METRES_PER_SQUARE_SECOND);
        Length heightOfBuilding = provider.create(Length.class, 40.0, METRE);

        Velocity speedOfImpact = provider.create(Velocity.class, Math.sqrt(
         2 * gravityOnEarth.getValue().doubleValue() *
         heightOfBuilding.getValue().doubleValue()),
         MetricSystem.METRES_PER_SECOND);

        print(speedOfImpact.toString());

//      Quantity temp = QuantityFactory.create(gravityOnEarth.getValue().doubleValue() *
//              heightOfBuilding.getValue().doubleValue(),
//              gravityOnEarth.getUnit().multiply(heightOfBuilding.getUnit()));
//      print (temp.toString());
    }
}
