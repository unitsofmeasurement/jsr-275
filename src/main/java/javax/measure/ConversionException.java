/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure;

/**
 * Signals that a problem of some sort has occurred either when creating a
 * converter between two units or during the conversion itself.
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.3 ($Revision: 126 $), $Date: 2010-02-17 09:41:38 +0100 (Mi, 17 Feb 2010) $
 */
public class ConversionException extends Exception {

    /** The serialVersionUID */
    private static final long serialVersionUID = -2846245619420930853L;

    /**
     * Constructs a <code>ConversionException</code> with the specified detail
     * message.
     *
     * @param  message the detail message.
     */
    public ConversionException(String message) {
        super(message);
    }
}
