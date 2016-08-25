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

import static javax.measure.unit.UCUM.GRAM;

import javax.measure.unit.UnitFormat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.text.*;
import java.util.ResourceBundle;
import javax.measure.converter.MultiplyConverter;
import javax.measure.converter.RationalConverter;
import javax.measure.converter.UnitConverter;
import javax.measure.unit.*;
import javax.measure.quantity.Quantity;

/**
 * <p>
 * This class provides the interface for formatting and parsing
 * {@link javax.measure.unit.Unit units} according to the <a
 * href="http://unitsofmeasure.org/">Uniform Code for Units of Measure</a>
 * (UCUM).
 * </p>
 * 
 * <p>
 * For a technical/historical overview of this format please read <a
 * href="http://www.pubmedcentral.nih.gov/articlerender.fcgi?artid=61354"> Units
 * of Measure in Clinical Information Systems</a>.
 * </p>
 * 
 * <p>
 * As of revision 1.16, the BNF in the UCUM standard contains an <a
 * href="http://unitsofmeasure.org/ticket/4">error</a>. I've attempted to work
 * around the problem by modifying the BNF productions for &lt;Term&gt;. Once
 * the error in the standard is corrected, it may be necessary to modify the
 * productions in the UCUMParser.jj file to conform to the standard.
 * </p>
 * 
 * @author <a href="mailto:eric-r@northwestern.edu">Eric Russell</a>
 * @author  <a href="mailto:jsr275@catmedia.us">Werner Keil</a>
 * @version 1.2.2 ($Revision: 76 $), $Date: 2009-12-03 23:53:52 +0100 (Do, 03 Dez 2009) $
 */
public abstract class UCUMFormat extends UnitFormat {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7753687108842507677L;
	
	// A helper to declare bundle names for all instances
	private static final String BUNDLE_BASE = UCUMFormat.class.getName();
	
	// /////////////////
	// Class methods //
	// /////////////////
	/** Returns the instance for formatting using "print" symbols */
	public static UCUMFormat getPrintInstance() {
		return Print.DEFAULT;
	}

	/** Returns the instance for formatting using user defined symbols */
	public static UCUMFormat getPrintInstance(SymbolMap symbolMap) {
		return new Print(symbolMap);
	}

	/**
	 * Returns the instance for formatting and parsing using case sensitive
	 * symbols
	 */
	public static UCUMFormat getCaseSensitiveInstance() {
		return Parsing.DEFAULT_CS;
	}

	/**
	 * Returns a case sensitive instance for formatting and parsing using user
	 * defined symbols
	 */
	public static UCUMFormat getCaseSensitiveInstance(SymbolMap symbolMap) {
		return new Parsing(symbolMap, true);
	}

	/**
	 * Returns the instance for formatting and parsing using case insensitive
	 * symbols
	 */
	public static UCUMFormat getCaseInsensitiveInstance() {
		return Parsing.DEFAULT_CI;
	}

	/**
	 * Returns a case insensitive instance for formatting and parsing using user
	 * defined symbols
	 */
	public static UCUMFormat getCaseInsensitiveInstance(SymbolMap symbolMap) {
		return new Parsing(symbolMap, false);
	}

	/**
	 * The symbol map used by this instance to map between
	 * {@link javax.measure.unit.Unit Unit}s and <code>String</code>s.
	 */
	final SymbolMap _symbolMap;

	// ////////////////
	// Constructors //
	// ////////////////
	/**
	 * Base constructor.
	 */
	UCUMFormat(SymbolMap symbolMap) {
		_symbolMap = symbolMap;
	}

	// //////////////
	// Formatting //
	// //////////////
	public Appendable format(Unit<?> unit, Appendable appendable)
			throws IOException {
		CharSequence symbol;
		CharSequence annotation = null;
		if (unit instanceof AnnotatedUnit<?>) {
                     AnnotatedUnit<?> annotatedUnit = (AnnotatedUnit<?>) unit;
                     unit = annotatedUnit.getRealUnit();
                     annotation = annotatedUnit.getAnnotation();
		}
		String mapSymbol = _symbolMap.getSymbol(unit);
		if (mapSymbol != null) {
			symbol = mapSymbol;
		} else if (unit instanceof ProductUnit<?>) {
			ProductUnit<?> productUnit = (ProductUnit<?>) unit;
			StringBuffer app = new StringBuffer();
			for (int i = 0; i < productUnit.getUnitCount(); i++) {
				if (productUnit.getUnitRoot(i) != 1) {
					throw new IllegalArgumentException(
							"Unable to format units in UCUM (fractional powers not supported)");
				}
				StringBuffer temp = new StringBuffer();
				temp = (StringBuffer) format(productUnit.getUnit(i), temp);
				if ((temp.indexOf(".") >= 0) || (temp.indexOf("/") >= 0)) {
					temp.insert(0, '(');
					temp.append(')');
				}
				int pow = productUnit.getUnitPow(i);
				if (i > 0) {
					if (pow >= 0) {
						app.append('.');
					} else if (i < (productUnit.getUnitCount() - 1)) {
						app.append('.');
					} else {
						app.append('/');
						pow = -pow;
					}
				} else if (pow < 0) {
					app.append('/');
					pow = -pow;
				}
				app.append(temp);
				if (pow != 1) {
					app.append(Integer.toString(pow));
				}
			}
			symbol = app;
		} else if ((unit instanceof TransformedUnit<?>)
				|| unit.equals(SI.KILOGRAM)) {
			StringBuffer temp = new StringBuffer();
			UnitConverter converter;
			boolean printSeparator;
			if (unit.equals(SI.KILOGRAM)) {
				// A special case because KILOGRAM is a BaseUnit instead of
				// a transformed unit, for compatability with existing SI
				// unit system.
				temp = format(UCUM.GRAM, temp, new FieldPosition(0));
				converter = Prefix.KILO.getConverter();
				printSeparator = true;
			} else {
				TransformedUnit<?> transformedUnit = (TransformedUnit<?>) unit;
				Unit<?> parentUnits = transformedUnit.getParentUnit();
				converter = transformedUnit.toParentUnit();
				if (parentUnits.equals(SI.KILOGRAM)) {
					// More special-case hackery to work around gram/kilogram
					// incosistency
					parentUnits = GRAM;
					converter = converter.concatenate(Prefix.KILO
							.getConverter());
				}
				temp = format(parentUnits, temp, new FieldPosition(0));
				printSeparator = !parentUnits.equals(Unit.ONE);
			}
			formatConverter(converter, printSeparator, temp);
			symbol = temp;
		} else if (unit instanceof BaseUnit<?>) {
			symbol = ((BaseUnit<?>) unit).getSymbol();
		} else if (unit instanceof AlternateUnit<?>) {
			symbol = ((AlternateUnit<?>) unit).getSymbol();
		} else {
			throw new IllegalArgumentException(
					"Cannot format the given Object as UCUM units (unsupported unit "
							+ unit.getClass().getName()
							+ "). "
							+ "Custom units types should override the toString() method as the default implementation uses the UCUM format.");
		}

		appendable.append(symbol);
		if (annotation != null && annotation.length() > 0) {
			appendAnnotation(unit, symbol, annotation, appendable);
		}

		return appendable;
	}

	void appendAnnotation(Unit<?> unit, CharSequence symbol,
			CharSequence annotation, Appendable appendable) throws IOException {
		appendable.append('{');
		appendable.append(annotation);
		appendable.append('}');
	}

	/**
	 * Formats the given converter to the given StringBuffer. This is similar to
	 * what {@link ConverterFormat} does, but there's no need to worry about
	 * operator precedence here, since UCUM only supports multiplication,
	 * division, and exponentiation and expressions are always evaluated left-
	 * to-right.
	 * 
	 * @param converter
	 *            the converter to be formatted
	 * @param continued
	 *            <code>true</code> if the converter expression should begin
	 *            with an operator, otherwise <code>false</code>. This will
	 *            always be true unless the unit being modified is equal to
	 *            Unit.ONE.
	 * @param buffer
	 *            the <code>StringBuffer</code> to append to. Contains the
	 *            already-formatted unit being modified by the given converter.
	 */
	void formatConverter(UnitConverter converter, boolean continued,
			StringBuffer buffer) {
		boolean unitIsExpression = ((buffer.indexOf(".") >= 0) || (buffer
				.indexOf("/") >= 0));
		Prefix prefix = _symbolMap.getPrefix(converter);
		if ((prefix != null) && (!unitIsExpression)) {
			buffer.insert(0, _symbolMap.getSymbol(prefix));
		} else if (converter == UnitConverter.IDENTITY) {
			// do nothing
		} else if (converter instanceof MultiplyConverter) {
			if (unitIsExpression) {
				buffer.insert(0, '(');
				buffer.append(')');
			}
			MultiplyConverter multiplyConverter = (MultiplyConverter) converter;
			double factor = multiplyConverter.getFactor();
			long lFactor = (long) factor;
			if ((lFactor != factor) || (lFactor < -9007199254740992L)
					|| (lFactor > 9007199254740992L)) {
				throw new IllegalArgumentException(
						"Only integer factors are supported in UCUM");
			}
			if (continued) {
				buffer.append('.');
			}
			buffer.append(lFactor);
		} else if (converter instanceof RationalConverter) {
			if (unitIsExpression) {
				buffer.insert(0, '(');
				buffer.append(')');
			}
			RationalConverter rationalConverter = (RationalConverter) converter;
			if (!rationalConverter.getDividend().equals(BigInteger.ONE)) {
				if (continued) {
					buffer.append('.');
				}
				buffer.append(rationalConverter.getDividend());
			}
			if (!rationalConverter.getDivisor().equals(BigInteger.ONE)) {
				buffer.append('/');
				buffer.append(rationalConverter.getDivisor());
			}
		} else {
			throw new IllegalArgumentException(
					"Unable to format units in UCUM (unsupported UnitConverter "
							+ converter + ")");
		}
	}

	// /////////////////
	// Inner classes //
	// /////////////////
	/**
	 * The Print format is used to output units according to the "print" column
	 * in the UCUM standard. Because "print" symbols in UCUM are not unique,
	 * this class of UCUMFormat may not be used for parsing, only for
	 * formatting.
	 */
	private static class Print extends UCUMFormat {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2990875526976721414L;
		
		private static final SymbolMap PRINT_SYMBOLS = new SymbolMap(
				ResourceBundle
						.getBundle(BUNDLE_BASE + "_Print"));
		private static final Print DEFAULT = new Print(PRINT_SYMBOLS);

		public Print(SymbolMap symbols) {
			super(symbols);
		}

		@Override
		public Unit<? extends Quantity> parse(CharSequence csq,
				ParsePosition pos) throws IllegalArgumentException {
			throw new UnsupportedOperationException(
					"The print format is for pretty-printing of units only. Parsing is not supported.");
		}

		@Override
		void appendAnnotation(Unit<?> unit, CharSequence symbol,
				CharSequence annotation, Appendable appendable)
				throws IOException {
			if (symbol != null && symbol.length() > 0) {
				appendable.append('(');
				appendable.append(annotation);
				appendable.append(')');
			} else {
				appendable.append(annotation);
			}
		}
	}

	/**
	 * The Parsing format outputs formats and parses units according to the
	 * "c/s" or "c/i" column in the UCUM standard, depending on which SymbolMap
	 * is passed to its constructor.
	 */
	private static class Parsing extends UCUMFormat {

		/**
		 * 
		 */
		private static final long serialVersionUID = -922531801940132715L;
		
		private static final SymbolMap CASE_SENSITIVE_SYMBOLS = new SymbolMap(
				ResourceBundle.getBundle(BUNDLE_BASE + "_CS"));
		private static final SymbolMap CASE_INSENSITIVE_SYMBOLS = new SymbolMap(
				ResourceBundle.getBundle(BUNDLE_BASE + "_CI"));
		private static final Parsing DEFAULT_CS = new Parsing(
				CASE_SENSITIVE_SYMBOLS, true);
		private static final Parsing DEFAULT_CI = new Parsing(
				CASE_INSENSITIVE_SYMBOLS, false);
		private final boolean _caseSensitive;

		public Parsing(SymbolMap symbols, boolean caseSensitive) {
			super(symbols);
			_caseSensitive = caseSensitive;
		}

		@Override
		public Unit<? extends Quantity> parse(CharSequence csq,
				ParsePosition cursor) throws IllegalArgumentException {
			// Parsing reads the whole character sequence from the parse
			// position.
			int start = cursor.getIndex();
			int end = csq.length();
			if (end <= start)
				return Unit.ONE;
			String source = csq.subSequence(start, end).toString().trim();
			if (source.length() == 0)
				return Unit.ONE;
			if (!_caseSensitive) {
				source = source.toUpperCase();
			}
			UCUMParser parser = new UCUMParser(_symbolMap,
					new ByteArrayInputStream(source.getBytes()));
			try {
				Unit<?> result = parser.parseUnit();
				cursor.setIndex(end);
				return result;
			} catch (javax.measure.unit.format.ParseException e) {
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

	}

}
