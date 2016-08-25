/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure;

import java.util.HashSet;
import java.util.Set;

/**
 * <p> This class represents a system of units, it groups units together
 *     for historical or cultural reasons. Nothing prevents a unit from
 *     belonging to several system of units at the same time
 *     (for example an imperial system would have many of the units
 *     held by {@link NonSI}).</p>
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.1 ($Revision: 134 $), $Date: 2010-02-17 21:55:53 +0100 (Mi, 17 Feb 2010) $
 */
public abstract class SystemOfUnits {

    /**
     * Restrictive constructor.
     */
    protected SystemOfUnits() {
    }

    /**
     * Gets the name of the system of units.
     * <p>
     * For example, the name of {@link MetricSystem} is 'SI'.
     *
     * @return the name of the unit system, never null
     */
    public abstract String getName();

    /**
     * Returns a textual description of the system of units.
     *
     * @return a string form for debugging, never null
     */
    @Override
    public String toString() {
        return getName();
    }

    /**
     * Returns a read only view over the units defined in this system.
     *
     * @return the collection of units.
     */
    public abstract Set<Unit<?>> getUnits();

    /**
     * Returns the the units defined in this system of specified type
     * (convenience method). This method returns all the units in this
     * system of units having the same standard unit as the one defined
     * by the specified quantity class. This method is more selective than
     * the {@link #getUnits(javax.measure.Dimension)} since units may
     * have the same dimension and still be used to measure quantities
     * of different kinds.
     *
     * @param type the type of the units to be returned.
     * @return the collection of units of specified type.
     */
//    @SuppressWarnings("unchecked")
//    public <Q extends Quantity> Set<Unit<Q>> getUnits(Class<Q> type) {
//         final Set<Unit<Q>> units = new HashSet();
//         Unit<Q> standardUnit = null;
//         try {
//            standardUnit = (Unit<Q>) type.getField("UNIT").get(null);
//         } catch (Exception e) {
//            throw new UnsupportedOperationException(
//                    "The quantity class " + type + " does not have a public static field UNIT holding the SI unit " + " for the quantity.");
//         }
//         for (Unit<?> unit : getUnits()) {
//             if (unit.toSI().equals(standardUnit)) {
//                 units.add((Unit<Q>)unit);
//             }
//         }
//        return units;
//    }

    /**
     * Returns the units defined in this system having the specified
     * dimension (convenience method). This method returns all the units
     * in this system of units having the specified dimension.
     * This method is less selective than  {@link #getUnits(java.lang.Class)}
     * since units may have the same dimension and still be used to measure
     * quantities of different kinds.
     *
     * @param dimension the dimension of the units to be returned.
     * @return the collection of units of specified dimension.
     */
    public Set<Unit<?>> getUnits(Dimension dimension) {
         final Set<Unit<?>> units = new HashSet<Unit<?>>();
         for (Unit<?> unit : getUnits()) {
             if (unit.getDimension().equals(dimension)) {
                 units.add(unit);
             }
         }
        return units;
    }
}
