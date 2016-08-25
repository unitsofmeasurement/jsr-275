/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure;

/**
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.1 ($Revision: 126 $), $Date: 2010-02-17 09:41:38 +0100 (Mi, 17 Feb 2010) $
 */
public interface Quantity {

    /**
     * Returns the numeric value.
     *
     * @return the measurement value.
     */
    Number getValue();

    /**
     * Returns the unit of measure.
     *
     * @return the measurement unit.
     */
    Unit<?> getUnit();

    /**
     * Returns this quantity after conversion to specified unit.
     *
     * @param unit the unit in which the returned quantity is stated.
     * @return this quantity or a new quantity equivalent to this quantity but
     *         stated in the specified unit.
     * @throws ArithmeticException if the result is inexact and the quotient has
     *         a non-terminating decimal expansion.
     */
    Quantity to(Unit<?> unit);
}
