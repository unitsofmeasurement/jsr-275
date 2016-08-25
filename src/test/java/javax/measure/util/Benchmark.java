package javax.measure.util;

import java.util.Random;
import javax.measure.quantity.Mass;
import javax.measure.quantity.QuantityFactory;
import javax.measure.unit.Unit;
import javax.measure.unit.UnitConverter;
import static javax.measure.unit.MetricSystem.*;

public class Benchmark {
    private static final int N = 100000;

    @SuppressWarnings({"unchecked","rawtypes"}) // Because of generic array creation.
    private static final Unit<Mass>[] UNITS = new Unit[] {
        MEGA(GRAM),
        KILOGRAM,
        GRAM,
        CENTI(GRAM),
        MILLI(GRAM),
        MICRO(GRAM)
    };

    private static long usingQuantities(final long seed) {
        long time = System.currentTimeMillis();
        final Random r = new Random(seed);
        final QuantityFactory<Mass> factory = QuantityFactory.getInstance(Mass.class);
        final Mass[] m = new Mass[N];
        for (int i=0; i<N; i++) {
            m[i] = factory.create(r.nextGaussian(), KILOGRAM);
        }
        // Now perform some computation in a random unit.
        final Unit<Mass> targetUnit = UNITS[r.nextInt(UNITS.length)];
        double sum = 0;
        for (int i=0; i<N; i++) {
            sum += m[i].doubleValue(targetUnit);
        }
        time = System.currentTimeMillis() - time;
        System.out.println("Using quantities: ellapsed time=" + (time / 1000f) + " s., result=" + sum);
        return time;
    }

    private static long usingDouble(final long seed) {
        long time = System.currentTimeMillis();
        final Random r = new Random(seed);
        final double[] m = new double[N];
        for (int i=0; i<N; i++) {
            m[i] = r.nextGaussian();
        }
        // Now perform some computation in a random unit.
        final Unit<Mass> sourceUnit = KILOGRAM;
        final Unit<Mass> targetUnit = UNITS[r.nextInt(UNITS.length)];
        final UnitConverter cv = sourceUnit.getConverterTo(targetUnit);
        double sum = 0;
        for (int i=0; i<N; i++) {
            sum += cv.convert(m[i]);
        }
        time = System.currentTimeMillis() - time;
        System.out.println("Using primitives: ellapsed time=" + (time / 1000f) + " s., result=" + sum);
        return time;
    }

    public static void main(String[] args) throws InterruptedException {
        // Execute the loop many time for letting Hotspot to "warn up".
        final Random r = new Random();
        for (int i=0; i<20; i++) {
            final long seed = r.nextLong();
            long t1 = usingQuantities(seed);
            long t2 = usingDouble(seed);
            System.out.println("Ratio: " + (float) t1 / (float) t2);
            Thread.sleep(100);
        }
    }
}
