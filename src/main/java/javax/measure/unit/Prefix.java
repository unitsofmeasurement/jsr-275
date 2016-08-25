/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.unit;

import static javax.measure.unit.Prefix.Metric.*;

import java.math.BigInteger;

import javax.measure.Quantity;
import javax.measure.Unit;

/**
 * Holder for built-in prefixes.
 * Prefix definitions of custom Systems of Units should implement this interface.
 *
 * @author <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.0 ($Revision: 134 $), $Date: 2010-02-17 21:55:53 +0100 (Mi, 17 Feb 2010) $
 *
 */
public interface Prefix {

    // ///////////////////
    // BINARY PREFIXES //
    // ///////////////////
    /**
     * Inner class holding binary prefixes.
     * @author <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
     * @version 1.0
     */
    public static class Binary implements Prefix {

        private Binary() {
            // Singleton: hide constructor.
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>2<sup>10</sup></code> (binary prefix).
         *
         * @param unit any unit.
         * @return <code>unit.times(1024)</code>.
         */
        public static <Q extends Quantity> Unit<Q> KIBI(Unit<Q> unit) {
            return unit.multiply(1024);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>2<sup>20</sup></code> (binary prefix).
         *
         * @param unit any unit.
         * @return <code>unit.times(1048576)</code>.
         */
        public static <Q extends Quantity> Unit<Q> MEBI(Unit<Q> unit) {
            return unit.multiply(1048576);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>2<sup>30</sup></code> (binary prefix).
         *
         * @param unit any unit.
         * @return <code>unit.times(1073741824)</code>.
         */
        public static final <Q extends Quantity> Unit<Q> GIBI(Unit<Q> unit) {
            return unit.multiply(1073741824);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>2<sup>40</sup></code> (binary prefix).
         *
         * @param unit any unit.
         * @return <code>unit.times(1099511627776L)</code>.
         */
        public static <Q extends Quantity> Unit<Q> TEBI(Unit<Q> unit) {
            return unit.multiply(1099511627776L);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>2<sup>50</sup></code> (binary prefix).
         *
         * @param unit any unit.
         * @return <code>unit.times(1125899906842624L)</code>.
         */
        public static <Q extends Quantity> Unit<Q> PEBI(Unit<Q> unit) {
            return unit.multiply(1125899906842624L);
        }

        /**
         * Returns the specified unit multiplied by the factor
         * <code>2<sup>60</sup></code> (binary prefix).
         *
         * @param unit any unit.
         * @return <code>unit.times(1152921504606846976L)</code>.
         */
        public static <Q extends Quantity> Unit<Q> EXBI(Unit<Q> unit) {
            return unit.multiply(1152921504606846976L);
        }
    }

    /**
     * Inner class holding prefixes used today in India, Pakistan, Bangladesh,
     * Nepal and Myanmar (Burma); based on grouping by two decimal places,
     * rather than the three decimal places common in most parts of the world.
     * [code]
     *     import static javax.measure.unit.NonSI.IndianPrefix.*; // Static import.
     *     ...
     *     Unit<Pressure> LAKH_PASCAL = LAKH(PASCAL);
     *     Unit<Length> CRORE_METER = CRORE(METER);
     * [/code]
     *
     * @author <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
     * @version 1.1 ($Revision: 134 $), $Date: 2010-02-17 21:55:53 +0100 (Mi, 17 Feb 2010) $
     * @see <a
     * href="http://en.wikipedia.org/wiki/Indian_numbering_system">Wikipedia:
     * Indian numbering system</a>
     */
    public static class Indian implements Prefix {

        private Indian() {
            // Singleton: hide constructor.
        }


        /**
         * <p>एक (Ek)</p>
         * Returns the specified unit multiplied by the factor <code>1</code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1)</code>.
         */
        public static <Q extends Quantity> Unit<Q> EK(Unit<Q> unit) {
            return unit;
        }

        /**
         * <p>दस (Das)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>1</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(10)</code>.
         */
        public static <Q extends Quantity> Unit<Q> DAS(Unit<Q> unit) {
            return unit.transform(E1);
        }

        /**
         * <p>सौ (Sau)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>2</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(100)</code>.
         */
        public static <Q extends Quantity> Unit<Q> SAU(Unit<Q> unit) {
            return unit.transform(E2);
        }

        /**
         * <p>सहस्र (Sahasr)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>3</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e3)</code>.
         */
        public static <Q extends Quantity> Unit<Q> SAHASR(Unit<Q> unit) {
            return unit.transform(E3);
        }

        /**
         * <p>हजार (Hazaar)</p>
         * Equivalent to {@link #SAHASR}.
         */
        public static <Q extends Quantity> Unit<Q> HAZAAR(Unit<Q> unit) {
            return SAHASR(unit);
        }

        /**
         * <p>लाख (Lakh)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>5</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e5)</code>.
         */
        public static <Q extends Quantity> Unit<Q> LAKH(Unit<Q> unit) {
            return unit.transform(E5);
        }
        private static final RationalConverter E5 = new RationalConverter(
                BigInteger.TEN.pow(5), BigInteger.ONE);

        /**
         * <p>करोड़ (Crore)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>7</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e7)</code>.
         */
        public static <Q extends Quantity> Unit<Q> CRORE(Unit<Q> unit) {
            return unit.transform(E7);
        }
        private static final RationalConverter E7 = new RationalConverter(
                BigInteger.TEN.pow(7), BigInteger.ONE);

        /**
         * <p>अरब (Arawb)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>9</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e9)</code>.
         */
        public static <Q extends Quantity> Unit<Q> ARAWB(Unit<Q> unit) {
            return unit.transform(E9);
        }

        /**
         * <p>खरब (Kharawb)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>11</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e11)</code>.
         */
        public static <Q extends Quantity> Unit<Q> KHARAWB(Unit<Q> unit) {
            return unit.transform(E11);
        }
        private static final RationalConverter E11 = new RationalConverter(
                BigInteger.TEN.pow(11), BigInteger.ONE);

        /**
         * <p>नील (Neel)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>13</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e13)</code>.
         */
        public static <Q extends Quantity> Unit<Q> NEEL(Unit<Q> unit) {
            return unit.transform(E13);
        }
        private static final RationalConverter E13 = new RationalConverter(
                BigInteger.TEN.pow(13), BigInteger.ONE);

        /**
         * <p>पद्म (Padma)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>15</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e15)</code>.
         */
        public static <Q extends Quantity> Unit<Q> PADMA(Unit<Q> unit) {
            return unit.transform(E15);
        }

        /**
         * <p>शंख (Shankh)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>17</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e17)</code>.
         */
        public static <Q extends Quantity> Unit<Q> SHANKH(Unit<Q> unit) {
            return unit.transform(E17);
        }
        private static final RationalConverter E17 = new RationalConverter(
                BigInteger.TEN.pow(17), BigInteger.ONE);

        /**
         * <p>महाशंख (Mahashankh)</p>
         * Returns the specified unit multiplied by the factor
         * <code>10<sup>19</sup></code>
         *
         * @param unit any unit.
         * @return <code>unit.times(1e19)</code>.
         */
        public static <Q extends Quantity> Unit<Q> MAHASHANKH(Unit<Q> unit) {
            return unit.transform(E19);
        }
        private static final RationalConverter E19 = new RationalConverter(
                BigInteger.TEN.pow(19), BigInteger.ONE);
    }

	// ///////////////
	// SI PREFIXES //
	// ///////////////
	/**
	 * Inner class holding prefixes used by the SI system.
	 * It defines the 20 SI prefixes used to form decimal multiples and
	 * submultiples of SI units. For example:[code]
	 *     import static javax.measure.unit.SI.*; // Static import.
	 *     import static javax.measure.unit.Prefix.Metric.*; // Static import.
	 *     ...
	 *     Unit<Pressure> HECTOPASCAL = HECTO(PASCAL);
	 *     Unit<Length> KILOMETRE = KILO(METRE);
	 *     [/code]</p>
	 *
	 * @author <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
	 * @version 1.0.2 ($Revision: 134 $), $Date: 2010-02-17 21:55:53 +0100 (Mi, 17 Feb 2010) $
	 * @see <a href="http://http://en.wikipedia.org/wiki/SI_prefix">Wikipedia:
	 *      SI Prefix</a>
	 */
	public static class Metric implements Prefix {
	
	    /**
	     * Singleton: hide constructor.
	     */
	    private Metric() {
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>24</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e24)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> YOTTA(Unit<Q> unit) {
	        return unit.transform(E24);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>21</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e21)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> ZETTA(Unit<Q> unit) {
	        return unit.transform(E21);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>18</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e18)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> EXA(Unit<Q> unit) {
	        return unit.transform(E18);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>15</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e15)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> PETA(Unit<Q> unit) {
	        return unit.transform(E15);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>12</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e12)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> TERA(Unit<Q> unit) {
	        return unit.transform(E12);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>9</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e9)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> GIGA(Unit<Q> unit) {
	        return unit.transform(E9);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>6</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e6)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> MEGA(Unit<Q> unit) {
	        return unit.transform(E6);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>3</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e3)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> KILO(Unit<Q> unit) {
	        return unit.transform(E3);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>2</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e2)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> HECTO(Unit<Q> unit) {
	        return unit.transform(E2);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>1</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e1)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> DEKA(Unit<Q> unit) {
	        return unit.transform(E1);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>-1</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e-1)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> DECI(Unit<Q> unit) {
	        return unit.transform(Em1);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>-2</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e-2)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> CENTI(Unit<Q> unit) {
	        return unit.transform(Em2);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>-3</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e-3)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> MILLI(Unit<Q> unit) {
	        return unit.transform(Em3);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>-6</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e-6)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> MICRO(Unit<Q> unit) {
	        return unit.transform(Em6);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>-9</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e-9)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> NANO(Unit<Q> unit) {
	        return unit.transform(Em9);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>-12</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e-12)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> PICO(Unit<Q> unit) {
	        return unit.transform(Em12);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>-15</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e-15)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> FEMTO(Unit<Q> unit) {
	        return unit.transform(Em15);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>-18</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e-18)</code>.
	     */
	    public static final <Q extends Quantity> Unit<Q> ATTO(Unit<Q> unit) {
	        return unit.transform(Em18);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>-21</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e-21)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> ZEPTO(Unit<Q> unit) {
	        return unit.transform(Em21);
	    }
	
	    /**
	     * Returns the specified unit multiplied by the factor
	     * <code>10<sup>-24</sup></code>
	     *
	     * @param unit any unit.
	     * @return <code>unit.times(1e-24)</code>.
	     */
	    public static <Q extends Quantity> Unit<Q> YOCTO(Unit<Q> unit) {
	        return unit.transform(Em24);
	    }
	
	    // Holds prefix converters (optimization).
	    private static final RationalConverter E24 = new RationalConverter(
	            BigInteger.TEN.pow(24), BigInteger.ONE);
	
	    private static final RationalConverter E21 = new RationalConverter(
	            BigInteger.TEN.pow(21), BigInteger.ONE);
	
	    private static final RationalConverter E18 = new RationalConverter(
	            BigInteger.TEN.pow(18), BigInteger.ONE);
	
	    private static final RationalConverter E15 = new RationalConverter(
	            BigInteger.TEN.pow(15), BigInteger.ONE);
	
	    private static final RationalConverter E12 = new RationalConverter(
	            BigInteger.TEN.pow(12), BigInteger.ONE);
	
	    private static final RationalConverter E9 = new RationalConverter(
	            BigInteger.TEN.pow(9), BigInteger.ONE);
	
	    private static final RationalConverter E6 = new RationalConverter(
	            BigInteger.TEN.pow(6), BigInteger.ONE);
	
	    private static final RationalConverter E3 = new RationalConverter(
	            BigInteger.TEN.pow(3), BigInteger.ONE);
	
	    private static final RationalConverter E2 = new RationalConverter(
	            BigInteger.TEN.pow(2), BigInteger.ONE);
	
	    private static final RationalConverter E1 = new RationalConverter(
	            BigInteger.TEN.pow(1), BigInteger.ONE);
	
	    private static final RationalConverter Em1 = new RationalConverter(
	            BigInteger.ONE, BigInteger.TEN.pow(1));
	
	    private static final RationalConverter Em2 = new RationalConverter(
	            BigInteger.ONE, BigInteger.TEN.pow(2));
	
	    private static final RationalConverter Em3 = new RationalConverter(
	            BigInteger.ONE, BigInteger.TEN.pow(3));
	
	    private static final RationalConverter Em6 = new RationalConverter(
	            BigInteger.ONE, BigInteger.TEN.pow(6));
	
	    private static final RationalConverter Em9 = new RationalConverter(
	            BigInteger.ONE, BigInteger.TEN.pow(9));
	
	    private static final RationalConverter Em12 = new RationalConverter(
	            BigInteger.ONE, BigInteger.TEN.pow(12));
	
	    private static final RationalConverter Em15 = new RationalConverter(
	            BigInteger.ONE, BigInteger.TEN.pow(15));
	
	    private static final RationalConverter Em18 = new RationalConverter(
	            BigInteger.ONE, BigInteger.TEN.pow(18));
	
	    private static final RationalConverter Em21 = new RationalConverter(
	            BigInteger.ONE, BigInteger.TEN.pow(21));
	
	    private static final RationalConverter Em24 = new RationalConverter(
	            BigInteger.ONE, BigInteger.TEN.pow(24));
	
	}
}
