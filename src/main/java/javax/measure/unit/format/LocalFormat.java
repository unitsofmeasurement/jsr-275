/**
 * JEAN-MARIE DAUTELLE, WERNER KEIL ARE WILLING TO LICENSE THIS SPECIFICATION TO YOU ONLY UPON THE CONDITION THAT YOU ACCEPT ALL OF THE TERMS CONTAINED IN THIS LICENSE AGREEMENT ("AGREEMENT"). PLEASE READ THE TERMS AND CONDITIONS OF THIS AGREEMENT CAREFULLY. BY DOWNLOADING THIS SPECIFICATION, YOU ACCEPT THE TERMS AND CONDITIONS OF THIS AGREEMENT. IF YOU ARE NOT WILLING TO BE BOUND BY THEM, SELECT THE "DECLINE" BUTTON AT THE BOTTOM OF THIS PAGE AND THE DOWNLOADING PROCESS WILL NOT CONTINUE.
 *
 * Specification: JSR 275 - Units Specification ("Specification")
 *
 * Version: 0.9.4
 * Status: Pre-FCS Public Release
 * Release: December 4, 2009
 *
 * Copyright 2005-2009 Jean-Marie Dautelle, Werner Keil
 * All rights reserved.
 *
 *
 * NOTICE
 *
 * The Specification is protected by copyright and the information described therein may be protected by one or more U.S. patents, foreign patents, or pending applications. Except as provided under the following license, no part of the Specification may be reproduced in any form by any means without the prior written authorization of Jean-Marie Dautelle, Werner Keil and its
 * licensors, if any. Any use of the Specification and the information described therein will be governed by the terms and conditions of this Agreement.
 *
 *
 * Subject to the terms and conditions of this license, including your compliance with Paragraphs 1, 2 and 3 below, Jean-Marie Dautelle and Werner Keil hereby grant you a fully-paid, non-exclusive, non-transferable, limited license (without the right to sublicense) under Jean-Marie Dautelle and Werner Keil's intellectual property rights to:
 *
 *    1. Review the Specification for the purposes of evaluation. This includes: (i) developing implementations of the Specification for your internal, non-commercial use; (ii) discussing the Specification with any third party; and (iii) excerpting brief portions of the Specification in oral or written communications which discuss the Specification provided that such excerpts do not in the aggregate constitute a significant portion of the Specification.
 *
 *    2. Distribute implementations of the Specification to third parties for their testing and evaluation use, provided that any such implementation:
 *
 * (i) does not modify, subset, superset or otherwise extend the Licensor Name Space, or include any public or protected packages, classes, Java interfaces, fields or methods within the Licensor Name Space other than those required/authorized by the Specification or Specifications being implemented;
 *
 * (ii) is clearly and prominently marked with the word "UNTESTED" or "EARLY ACCESS" or "INCOMPATIBLE" or "UNSTABLE" or "BETA" in any list of available builds and in proximity to every link initiating its download, where the list or link is under Licensee's control; and
 *
 * (iii) includes the following notice:
 * "This is an implementation of an early-draft specification developed under the Java Community Process (JCP) and is made available for testing and evaluation purposes only. The code is not compatible with any specification of the JCP."
 *
 *    3. Distribute applications written to the Specification to third parties for their testing and evaluation use, provided that any such application includes the following notice:
 *       "This is an application written to interoperate with an early-draft specification developed under the Java Community Process (JCP) and is made available for testing and evaluation purposes only. The code is not compatible with any specification of the JCP."
 *
 * The grant set forth above concerning your distribution of implementations of the Specification is contingent upon your agreement to terminate development and distribution of your implementation of early draft upon final completion of the Specification.  If you fail to do so, the foregoing grant shall be considered null and void.
 *
 * Other than this limited license, you acquire no right, title or interest in or to the Specification or any other Jean-Marie Dautelle and Werner Keil intellectual property, and the Specification may only be used in accordance with the license terms set forth herein. This license will expire on the earlier of:  (a) two (2) years from the date of Release listed above; (b) the date on which the final version of the Specification is publicly released; or (c) the date on which the Java Specification Request (JSR) to which the Specification corresponds is withdrawn.  In addition, this license will terminate immediately without notice from Jean-Marie Dautelle, Werner Keil if you fail to comply with any provision of this license.  Upon termination, you must cease use of or destroy the Specification.
 *
 * "Licensor Name Space" means the public class or interface declarations whose names begin with "java", "javax", "org.jscience" or their equivalents in any subsequent naming convention adopted through the Java Community Process, or any recognized successors or replacements thereof
 *
 *
 * TRADEMARKS
 *
 * No right, title, or interest in or to any trademarks, service marks, or trade names of Jean-Marie Dautelle, Werner Keil or Jean-Marie Dautelle and Werner Keil's licensors is granted hereunder. Java and Java-related logos, marks and names are trademarks or registered trademarks of Sun Microsystems, Inc. in the U.S. and other countries.
 *
 *
 * DISCLAIMER OF WARRANTIES
 *
 * THE SPECIFICATION IS PROVIDED "AS IS" AND IS EXPERIMENTAL AND MAY CONTAIN DEFECTS OR DEFICIENCIES WHICH CANNOT OR WILL NOT BE CORRECTED BY JEAN-MARIE DAUTELLE, WERNER KEIL. JEAN-MARIE DAUTELLE AND WERNER KEIL MAKE NO REPRESENTATIONS OR WARRANTIES, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO, WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT THAT THE CONTENTS OF THE SPECIFICATION ARE SUITABLE FOR ANY PURPOSE OR THAT ANY PRACTICE OR IMPLEMENTATION OF SUCH CONTENTS WILL NOT INFRINGE ANY THIRD PARTY PATENTS, COPYRIGHTS, TRADE SECRETS OR OTHER RIGHTS. This document does not represent any commitment to release or implement any portion of the Specification in any product.
 *
 * THE SPECIFICATION COULD INCLUDE TECHNICAL INACCURACIES OR TYPOGRAPHICAL ERRORS. CHANGES ARE PERIODICALLY ADDED TO THE INFORMATION THEREIN; THESE CHANGES WILL BE INCORPORATED INTO NEW VERSIONS OF THE SPECIFICATION, IF ANY. JEAN-MARIE DAUTELL AND WERNER KEIL MAY MAKE IMPROVEMENTS AND/OR CHANGES TO THE PRODUCT(S) AND/OR THE PROGRAM(S) DESCRIBED IN THE SPECIFICATION AT ANY TIME. Any use of such changes in the Specification will be governed by the then-current license for the applicable version of the Specification.
 *
 *
 * LIMITATION OF LIABILITY
 *
 * TO THE EXTENT NOT PROHIBITED BY LAW, IN NO EVENT WILL JEAN-MARIE DAUTELLE, WERNER KEIL OR THEIR LICENSORS BE LIABLE FOR ANY DAMAGES, INCLUDING WITHOUT LIMITATION, LOST REVENUE, PROFITS OR DATA, OR FOR SPECIAL, INDIRECT, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF OR RELATED TO ANY FURNISHING, PRACTICING, MODIFYING OR ANY USE OF THE SPECIFICATION, EVEN IF JEAN-MARIE DAUTELLE, WERNER KEIL AND/OR ITS LICENSORS HAVE BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * You will hold Jean-Marie Dautelle, Werner Keil (and its licensors) harmless from any claims based on your use of the Specification for any purposes other than the limited right of evaluation as described above, and from any claims that later versions or releases of any Specification furnished to you are incompatible with the Specification provided to you under this license.
 *
 *
 * RESTRICTED RIGHTS LEGEND
 *
 * If this Software is being acquired by or on behalf of the U.S. Government or by a U.S. Government prime contractor or subcontractor (at any tier), then the Government's rights in the Software and accompanying documentation shall be only as set forth in this license; this is in
 * accordance with 48 C.F.R. 227.7201 through 227.7202-4 (for Department of Defense (DoD) acquisitions) and with 48 C.F.R. 2.101 and 12.212 (for non-DoD acquisitions).
 *
 *
 * REPORT
 *
 * You may wish to report any ambiguities, inconsistencies or inaccuracies you may find in connection with your evaluation of the Specification ("Feedback"). To the extent that you provide Jean-Marie Dautelle, Werner Keil with any Feedback, you hereby: (i) agree that such Feedback is provided on a non-proprietary and non-confidential basis, and (ii) grant Jean-Marie Dautelle, Werner Keil a perpetual, non-exclusive, worldwide, fully paid-up, irrevocable license, with the right to sublicense through multiple levels of sublicensees, to incorporate, disclose, and use without limitation the Feedback for any purpose related to the Specification and future versions, implementations, and test suites thereof.
 *
 *
 * GENERAL TERMS
 *
 * Any action related to this Agreement will be governed by California law and controlling U.S. federal law. The U.N. Convention for the International Sale of Goods and the choice of law rules of any jurisdiction will not apply.
 *
 * The Specification is subject to U.S. export control laws and may be subject to export or import regulations in other countries. Licensee agrees to comply strictly with all such laws and regulations and acknowledges that it has the responsibility to obtain such licenses to export, re-export or import as may be required after delivery to Licensee.
 *
 * This Agreement is the parties' entire agreement relating to its subject matter. It supersedes all prior or contemporaneous oral or written communications, proposals, conditions, representations and warranties and prevails over any conflicting or additional terms of any quote, order, acknowledgment, or other communication between the parties relating to its subject matter during the term of this Agreement. No modification to this Agreement will be binding, unless in writing and signed by an authorized representative of each party.
 */
package javax.measure.unit.format;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.text.ParsePosition;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.measure.converter.*;
import javax.measure.unit.*;

/**
 * <p> This class represents the local sensitive format.</p>
 *
 * <h3>Here is the grammar for Units in Extended Backus-Naur Form (EBNF)</h3>
 * <p>
 *   Note that the grammar has been left-factored to be suitable for use by a top-down 
 *   parser generator such as <a href="https://javacc.dev.java.net/">JavaCC</a>
 * </p>
 * <table width="90%" align="center">
 *   <tr>
 *     <th colspan="3" align="left">Lexical Entities:</th>
 *   </tr>
 *   <tr valign="top">
 *     <td>&lt;sign&gt;</td>
 *     <td>:=</td>
 *     <td>"+" | "-"</td>
 *   </tr>
 *   <tr valign="top">
 *     <td>&lt;digit&gt;</td>
 *     <td>:=</td>
 *     <td>"0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"</td>
 *   </tr>
 *   <tr valign="top">
 *     <td>&lt;superscript_digit&gt;</td>
 *     <td>:=</td>
 *     <td>"⁰" | "¹" | "²" | "³" | "⁴" | "⁵" | "⁶" | "⁷" | "⁸" | "⁹"</td>
 *   </tr>
 *   <tr valign="top">
 *     <td>&lt;integer&gt;</td>
 *     <td>:=</td>
 *     <td>(&lt;digit&gt;)+</td>
 *   </tr>
 *   <tr valign="top">
 *     <td>&lt;number&gt;</td>
 *     <td>:=</td>
 *     <td>(&lt;sign&gt;)? (&lt;digit&gt;)* (".")? (&lt;digit&gt;)+ (("e" | "E") (&lt;sign&gt;)? (&lt;digit&gt;)+)? </td>
 *   </tr>
 *   <tr valign="top">
 *     <td>&lt;exponent&gt;</td>
 *     <td>:=</td>
 *     <td>( "^" ( &lt;sign&gt; )? &lt;integer&gt; ) <br>| ( "^(" (&lt;sign&gt;)? &lt;integer&gt; ( "/" (&lt;sign&gt;)? &lt;integer&gt; )? ")" ) <br>| ( &lt;superscript_digit&gt; )+</td>
 *   </tr>
 *   <tr valign="top">
 *     <td>&lt;initial_char&gt;</td>
 *     <td>:=</td>
 *     <td>? Any Unicode character excluding the following: ASCII control & whitespace (&#92;u0000 - &#92;u0020), decimal digits '0'-'9', '(' (&#92;u0028), ')' (&#92;u0029), '*' (&#92;u002A), '+' (&#92;u002B), '-' (&#92;u002D), '.' (&#92;u002E), '/' (&#92;u005C), ':' (&#92;u003A), '^' (&#92;u005E), '²' (&#92;u00B2), '³' (&#92;u00B3), '·' (&#92;u00B7), '¹' (&#92;u00B9), '⁰' (&#92;u2070), '⁴' (&#92;u2074), '⁵' (&#92;u2075), '⁶' (&#92;u2076), '⁷' (&#92;u2077), '⁸' (&#92;u2078), '⁹' (&#92;u2079) ?</td>
 *   </tr>
 *   <tr valign="top">
 *     <td>&lt;unit_identifier&gt;</td>
 *     <td>:=</td>
 *     <td>&lt;initial_char&gt; ( &lt;initial_char&gt; | &lt;digit&gt; )*</td>
 *   </tr>
 *   <tr>
 *     <th colspan="3" align="left">Non-Terminals:</th>
 *   </tr>
 *   <tr valign="top">
 *     <td>&lt;unit_expr&gt;</td>
 *     <td>:=</td>
 *     <td>&lt;compound_expr&gt;</td>
 *   </tr>
 *   <tr valign="top">
 *     <td>&lt;compound_expr&gt;</td>
 *     <td>:=</td>
 *     <td>&lt;add_expr&gt; ( ":" &lt;add_expr&gt; )*</td>
 *   </tr>
 *   <tr valign="top">
 *     <td>&lt;add_expr&gt;</td>
 *     <td>:=</td>
 *     <td>( &lt;number&gt; &lt;sign&gt; )? &lt;mul_expr&gt; ( &lt;sign&gt; &lt;number&gt; )?</td>
 *   </tr>
 *   <tr valign="top">
 *     <td>&lt;mul_expr&gt;</td>
 *     <td>:=</td>
 *     <td>&lt;exponent_expr&gt; ( ( ( "*" | "·" ) &lt;exponent_expr&gt; ) | ( "/" &lt;exponent_expr&gt; ) )*</td>
 *   </tr>
 *   <tr valign="top">
 *     <td>&lt;exponent_expr&gt;</td>
 *     <td>:=</td>
 *     <td>( &lt;atomic_expr&gt; ( &lt;exponent&gt; )? ) <br>| (&lt;integer&gt; "^" &lt;atomic_expr&gt;) <br>| ( ( "log" ( &lt;integer&gt; )? ) | "ln" ) "(" &lt;add_expr&gt; ")" )</td>
 *   </tr>
 *   <tr valign="top">
 *     <td>&lt;atomic_expr&gt;</td>
 *     <td>:=</td>
 *     <td>&lt;number&gt; <br>| &lt;unit_identifier&gt; <br>| ( "(" &lt;add_expr&gt; ")" )</td>
 *   </tr>
 * </table>
 * 
 * @author <a href="mailto:eric-r@northwestern.edu">Eric Russell</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version $Revision: 76 $, $Date: 2009-12-03 23:53:52 +0100 (Do, 03 Dez 2009) $
 */
public class LocalFormat extends UnitFormat {
	
	//////////////////////////////////////////////////////
    // Class variables                                  //
    //////////////////////////////////////////////////////
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2046025264383639924L;
    /** Default locale instance. If the default locale is changed after the class is
    initialized, this instance will no longer be used. */
    private static LocalFormat DEFAULT_INSTANCE = new LocalFormat(new SymbolMap(ResourceBundle.getBundle(LocalFormat.class.getName())));
    /** Multiplicand character */
    private static final char MIDDLE_DOT = '\u00b7';
    /** Operator precedence for the addition and subtraction operations */
    private static final int ADDITION_PRECEDENCE = 0;
    /** Operator precedence for the multiplication and division operations */
    private static final int PRODUCT_PRECEDENCE = ADDITION_PRECEDENCE + 2;
    /** Operator precedence for the exponentiation and logarithm operations */
    private static final int EXPONENT_PRECEDENCE = PRODUCT_PRECEDENCE + 2;
    /**
     * Operator precedence for a unit identifier containing no mathematical
     * operations (i.e., consisting exclusively of an identifier and possibly
     * a prefix). Defined to be <code>Integer.MAX_VALUE</code> so that no
     * operator can have a higher precedence.
     */
    private static final int NOOP_PRECEDENCE = Integer.MAX_VALUE;

    ///////////////////
    // Class methods //
    ///////////////////
    /** Returns the instance for the current default locale (non-ascii characters are allowed) */
    public static LocalFormat getInstance() {
        return DEFAULT_INSTANCE;
    }

    /** 
     * Returns an instance for the given locale.
     * @param locale
     */
    public static LocalFormat getInstance(Locale locale) {
        return new LocalFormat(new SymbolMap(ResourceBundle.getBundle(LocalFormat.class.getName(), locale)));
    }

    /** Returns an instance for the given symbol map. */
    public static LocalFormat getInstance(SymbolMap symbols) {
        return new LocalFormat(symbols);
    }
    ////////////////////////
    // Instance variables //
    ////////////////////////
    /** 
     * The symbol map used by this instance to map between 
     * {@link javax.measure.unit.Unit Unit}s and <code>String</code>s, etc... 
     */
    private transient SymbolMap symbolMap;

    //////////////////
    // Constructors //
    //////////////////
    /**
     * Base constructor.
     *
     * @param symbols the symbol mapping.
     */
    private LocalFormat(SymbolMap symbols) {
        symbolMap = symbols;
    }

    ////////////////////////
    // Instance methods //
    ////////////////////////
    /** 
     * Get the symbol map used by this instance to map between 
     * {@link javax.measure.unit.Unit Unit}s and <code>String</code>s, etc... 
     * @return SymbolMap the current symbol map
     */
    public SymbolMap getSymbols() {
        return symbolMap;
    }

    ////////////////
    // Formatting //
    ////////////////
    @Override
    public Appendable format(Unit<?> unit, Appendable appendable) throws IOException {
        formatInternal(unit, appendable);
        return appendable;
    }

    @Override
    public Unit<?> parse(CharSequence csq, ParsePosition cursor) throws IllegalArgumentException {
        // Parsing reads the whole character sequence from the parse position.
        int start = cursor.getIndex();
        int end = csq.length();
        if (end <= start) {
            return Unit.ONE;
        }
        String source = csq.subSequence(start, end).toString().trim();
        if (source.length() == 0) {
            return Unit.ONE;
        }
        try {
            UnitParser parser = new UnitParser(symbolMap, new StringReader(source));
            Unit<?> result = parser.parseUnit();
            cursor.setIndex(end);
            return result;
        } catch (ParseException e) {
            if (e.currentToken != null) {
                cursor.setErrorIndex(start + e.currentToken.endColumn);
            } else {
                cursor.setErrorIndex(start);
            }
            throw new IllegalArgumentException(e.getMessage());
        } catch (TokenMgrError e) {
            cursor.setErrorIndex(start);
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * Format the given unit to the given StringBuffer, then return the operator
     * precedence of the outermost operator in the unit expression that was 
     * formatted. See {@link ConverterFormat} for the constants that define the
     * various precedence values.
     * @param unit the unit to be formatted
     * @param buffer the <code>StringBuffer</code> to be written to
     * @return the operator precedence of the outermost operator in the unit 
     *   expression that was output
     */
    private int formatInternal(Unit<?> unit, Appendable buffer) throws IOException {
        if (unit instanceof AnnotatedUnit<?>) {
            unit = ((AnnotatedUnit<?>) unit).getRealUnit();
        }
        String symbol = symbolMap.getSymbol(unit);
        if (symbol != null) {
            buffer.append(symbol);
            return NOOP_PRECEDENCE;
        } else if (unit instanceof ProductUnit<?>) {
            ProductUnit<?> productUnit = (ProductUnit<?>) unit;
            int negativeExponentCount = 0;
            // Write positive exponents first...
            boolean start = true;
            for (int i = 0; i < productUnit.getUnitCount(); i += 1) {
                int pow = productUnit.getUnitPow(i);
                if (pow >= 0) {
                    formatExponent(productUnit.getUnit(i), pow, productUnit.getUnitRoot(i), !start, buffer);
                    start = false;
                } else {
                    negativeExponentCount += 1;
                }
            }
            // ..then write negative exponents.
            if (negativeExponentCount > 0) {
                if (start) {
                    buffer.append('1');
                }
                buffer.append('/');
                if (negativeExponentCount > 1) {
                    buffer.append('(');
                }
                start = true;
                for (int i = 0; i < productUnit.getUnitCount(); i += 1) {
                    int pow = productUnit.getUnitPow(i);
                    if (pow < 0) {
                        formatExponent(productUnit.getUnit(i), -pow, productUnit.getUnitRoot(i), !start, buffer);
                        start = false;
                    }
                }
                if (negativeExponentCount > 1) {
                    buffer.append(')');
                }
            }
            return PRODUCT_PRECEDENCE;
        } else if ((unit instanceof TransformedUnit<?>) || unit.equals(SI.KILOGRAM)) {
            UnitConverter converter = null;
            boolean printSeparator = false;
            StringBuffer temp = new StringBuffer();
            int unitPrecedence = NOOP_PRECEDENCE;
            if (unit.equals(SI.KILOGRAM)) {
                // A special case because KILOGRAM is a BaseUnit instead of 
                // a transformed unit, even though it has a prefix.
                converter = Prefix.KILO.getConverter();
                unitPrecedence = formatInternal(SI.GRAM, temp);
                printSeparator = true;
            } else {
                TransformedUnit<?> transformedUnit = (TransformedUnit<?>) unit;
                Unit<?> parentUnits = transformedUnit.getParentUnit();
                converter = transformedUnit.toParentUnit();
                if (parentUnits.equals(SI.KILOGRAM)) {
                    // More special-case hackery to work around gram/kilogram 
                    // incosistency
                    parentUnits = SI.GRAM;
                    converter = converter.concatenate(Prefix.KILO.getConverter());
                }
                unitPrecedence = formatInternal(parentUnits, temp);
                printSeparator = !parentUnits.equals(Unit.ONE);
            }
            int result = formatConverter(converter, printSeparator, unitPrecedence, temp);
            buffer.append(temp);
            return result;
        } else if (unit instanceof AlternateUnit<?>) {
            buffer.append(((AlternateUnit<?>) unit).getSymbol());
            return NOOP_PRECEDENCE;
        } else if (unit instanceof BaseUnit<?>) {
            buffer.append(((BaseUnit<?>) unit).getSymbol());
            return NOOP_PRECEDENCE;
        } else {
            throw new IllegalArgumentException("Cannot format the given Object as a Unit (unsupported unit type " + unit.getClass().getName() + ")");
        }
    }

    /**
     * Format the given unit raised to the given fractional power to the
     * given <code>StringBuffer</code>.
     * @param unit Unit the unit to be formatted
     * @param pow int the numerator of the fractional power
     * @param root int the denominator of the fractional power
     * @param continued boolean <code>true</code> if the converter expression 
     *    should begin with an operator, otherwise <code>false</code>. This will 
     *    always be true unless the unit being modified is equal to Unit.ONE.
     * @param buffer StringBuffer the buffer to append to. No assumptions should
     *    be made about its content.
     */
    private void formatExponent(Unit<?> unit, int pow, int root, boolean continued, Appendable buffer) throws IOException {
        if (continued) {
            buffer.append(MIDDLE_DOT);
        }
        StringBuffer temp = new StringBuffer();
        int unitPrecedence = formatInternal(unit, temp);
        if (unitPrecedence < PRODUCT_PRECEDENCE) {
            temp.insert(0, '(');
            temp.append(')');
        }
        buffer.append(temp);
        if ((root == 1) && (pow == 1)) {
            // do nothing
        } else if ((root == 1) && (pow > 1)) {
            String powStr = Integer.toString(pow);
            for (int i = 0; i < powStr.length(); i += 1) {
                char c = powStr.charAt(i);
                switch (c) {
                    case '0':
                        buffer.append('\u2070');
                        break;
                    case '1':
                        buffer.append('\u00b9');
                        break;
                    case '2':
                        buffer.append('\u00b2');
                        break;
                    case '3':
                        buffer.append('\u00b3');
                        break;
                    case '4':
                        buffer.append('\u2074');
                        break;
                    case '5':
                        buffer.append('\u2075');
                        break;
                    case '6':
                        buffer.append('\u2076');
                        break;
                    case '7':
                        buffer.append('\u2077');
                        break;
                    case '8':
                        buffer.append('\u2078');
                        break;
                    case '9':
                        buffer.append('\u2079');
                        break;
                }
            }
        } else if (root == 1) {
            buffer.append("^");
            buffer.append(String.valueOf(pow));
        } else {
            buffer.append("^(");
            buffer.append(String.valueOf(pow));
            buffer.append('/');
            buffer.append(String.valueOf(root));
            buffer.append(')');
        }
    }

    /**
     * Formats the given converter to the given StringBuffer and returns the
     * operator precedence of the converter's mathematical operation. This is
     * the default implementation, which supports all built-in UnitConverter
     * implementations. Note that it recursively calls itself in the case of 
     * a {@link javax.measure.converter.UnitConverter.Compound Compound} 
     * converter.
     * @param converter the converter to be formatted
     * @param continued <code>true</code> if the converter expression should 
     *    begin with an operator, otherwise <code>false</code>.
     * @param unitPrecedence the operator precedence of the operation expressed
     *    by the unit being modified by the given converter.
     * @param buffer the <code>StringBuffer</code> to append to.
     * @return the operator precedence of the given UnitConverter
     */
    private int formatConverter(UnitConverter converter,
            boolean continued,
            int unitPrecedence,
            StringBuffer buffer) {
        Prefix prefix = symbolMap.getPrefix(converter);
        if ((prefix != null) && (unitPrecedence == NOOP_PRECEDENCE)) {
            buffer.insert(0, symbolMap.getSymbol(prefix));
            return NOOP_PRECEDENCE;
        } else if (converter instanceof AddConverter) {
            if (unitPrecedence < ADDITION_PRECEDENCE) {
                buffer.insert(0, '(');
                buffer.append(')');
            }
            double offset = ((AddConverter) converter).getOffset();
            if (offset < 0) {
                buffer.append("-");
                offset = -offset;
            } else if (continued) {
                buffer.append("+");
            }
            long lOffset = (long) offset;
            if (lOffset == offset) {
                buffer.append(lOffset);
            } else {
                buffer.append(offset);
            }
            return ADDITION_PRECEDENCE;
        } else if (converter instanceof LogConverter) {
            double base = ((LogConverter) converter).getBase();
            StringBuffer expr = new StringBuffer();
            if (base == StrictMath.E) {
                expr.append("ln");
            } else {
                expr.append("log");
                if (base != 10) {
                    expr.append((int) base);
                }
            }
            expr.append("(");
            buffer.insert(0, expr);
            buffer.append(")");
            return EXPONENT_PRECEDENCE;
        } else if (converter instanceof ExpConverter) {
            if (unitPrecedence < EXPONENT_PRECEDENCE) {
                buffer.insert(0, '(');
                buffer.append(')');
            }
            StringBuffer expr = new StringBuffer();
            double base = ((ExpConverter) converter).getBase();
            if (base == StrictMath.E) {
                expr.append('e');
            } else {
                expr.append((int) base);
            }
            expr.append('^');
            buffer.insert(0, expr);
            return EXPONENT_PRECEDENCE;
        } else if (converter instanceof MultiplyConverter) {
            if (unitPrecedence < PRODUCT_PRECEDENCE) {
                buffer.insert(0, '(');
                buffer.append(')');
            }
            if (continued) {
                buffer.append(MIDDLE_DOT);
            }
            double factor = ((MultiplyConverter) converter).getFactor();
            long lFactor = (long) factor;
            if (lFactor == factor) {
                buffer.append(lFactor);
            } else {
                buffer.append(factor);
            }
            return PRODUCT_PRECEDENCE;
        } else if (converter instanceof RationalConverter) {
            if (unitPrecedence < PRODUCT_PRECEDENCE) {
                buffer.insert(0, '(');
                buffer.append(')');
            }
            RationalConverter rationalConverter = (RationalConverter) converter;
            if (!rationalConverter.getDividend().equals(BigInteger.ONE)) {
                if (continued) {
                    buffer.append(MIDDLE_DOT);
                }
                buffer.append(rationalConverter.getDividend());
            }
            if (!rationalConverter.getDivisor().equals(BigInteger.ONE)) {
                buffer.append('/');
                buffer.append(rationalConverter.getDivisor());
            }
            return PRODUCT_PRECEDENCE;
        } else {
            throw new IllegalArgumentException("Unable to format the given UnitConverter: " + converter.getClass());
        }
    }
}
