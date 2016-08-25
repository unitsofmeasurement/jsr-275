/**
 *   Copyright (c) 2005-2010, Jean-Marie Dautelle, Werner Keil
 *   All rights reserved.
 *
 *   See LICENSE.txt for the Specification License
 */
package javax.measure.util;

/**
 * A static helper class, checking e.g. if some tests require optional console output
 * XXX this could be done using a logging framework eventually
 *
 * @version $Revision: 126 $, $Date: 2010-02-17 09:41:38 +0100 (Mi, 17 Feb 2010) $
 * @author $Author: martdesruisseaux $
 */
public abstract class TestUtil {
    private static final String TEST_CONSOLE_OUTPUT = "testConsoleOutput";

    public static final boolean isTestOutput() {
        return ("true".equals(System.getProperty(TEST_CONSOLE_OUTPUT)));
    }
    public static final void print(String message) {
        if (isTestOutput()) {
            System.out.println(message);
        }
    }
}
