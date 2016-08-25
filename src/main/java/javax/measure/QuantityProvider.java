/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure;


/**
 * @see <a href="http://en.wikipedia.org/wiki/Factory_method_pattern"/>
 * @see <a href="http://en.wikipedia.org/wiki/Creational_pattern"/>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.1 ($Revision: 128 $), $Date: 2010-02-17 20:19:16 +0100 (Mi, 17 Feb 2010) $
 */
public interface QuantityProvider {

    // TODO: the last argument should be Unit<Q>. rename?
    /**
     * @param <Q> the Quantity
     * @param type the quantity type
     * @param value numeric value
     * @param unit the desired unit of measure
     * @return a quantity
     */
    <Q extends Quantity> Q create(final Class<Q> type,
            final Number value, final Unit<?> unit);

}
