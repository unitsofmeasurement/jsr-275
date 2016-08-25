/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.unit;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;

/**
 * <p> This class represents an annotated unit. It  allows for unit specialization
 *     and annotation without changing the unit semantic. For example:[code]
 *        public class Size implements Length {
 *             private double meters;
 *             ...
 *             public static class Unit extends AnnotatedUnit<Length> {
 *                  private Unit(javax.measure.Unit<Length> realUnit, String annotation) {
 *                      super(actualUnit, annotation);
 *                  }
 *                  public static Size.Unit METER = new Size.Unit(SI.METRE, "size"); // Equivalent to SI.METRE
 *                  public static Size.Unit INCH = new Size.Unit(NonSI.INCH, "size"); // Equivalent to NonSI.INCH
 *             }
 *        }[/code]</p>
 * <p> Annotation are often written between curly braces behind units
 *     but they do not change, for example "%{vol}", "kg{total}", or
 *     "{RBC}" (for "red blood cells") are equivalent to "%", "kg", and "1"
 *      respectively.</p>
 *
 * @param <Q> The type of the quantity measured by this unit.
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.0.1 ($Revision: 127 $), $Date: 2010-02-17 10:13:47 +0100 (Mi, 17 Feb 2010) $
 */
public class AnnotatedUnit<Q extends Quantity> extends DerivedUnit<Q> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Holds the annotation.
     */
    private final String annotation;

    /**
     * Holds the actual unit.
     */
    private final Unit<Q> actualUnit;

    /**
     * Creates an annotated unit for the specified unit.
     *
     * @param actualUnit the real unit.
     * @param annotation the annotation.
     */
    public AnnotatedUnit(Unit<Q> actualUnit, String annotation) {
        this.actualUnit = (actualUnit instanceof AnnotatedUnit<?>)
                ? ((AnnotatedUnit<Q>) actualUnit).getActualUnit() : actualUnit;
        this.annotation = annotation;
    }

    /**
     * Returns the annotation of this unit.
     *
     * @return the annotation of this unit.
     */
    public String getAnnotation() {
        return annotation;
    }

    /**
     * Returns the equivalent non-annotated unit.
     *
     * @return the real unit.
     */
    public final Unit<Q> getActualUnit() {
        return actualUnit;
    }

    @Override
    public Unit<Q> toSI() {
        return actualUnit.toSI();
    }

    @Override
    public UnitConverter getConverterToSI() {
        return actualUnit.getConverterToSI();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that)
            return true;
        if (!(that instanceof AnnotatedUnit<?>))
            return false;
        AnnotatedUnit<?> thatUnit = (AnnotatedUnit<?>) that;
        return this.actualUnit.equals(thatUnit.actualUnit) &&
                this.annotation.equals(thatUnit.annotation);
    }

    @Override
    public int hashCode() {
        return actualUnit.hashCode() + annotation.hashCode();
    }
}
