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
 * @version $Revision: 223 $, $Date: 2010-03-14 15:44:36 +0100 (So, 14 Mär 2010) $
 * @author $Author: keilw $
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
    public static final void print(Object object) {
    	print(String.valueOf(object));
    }
}
