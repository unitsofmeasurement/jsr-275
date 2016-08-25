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

import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import javax.measure.converter.UnitConverter;
import javax.measure.unit.Unit;

/**
 * <p> The SymbolMap class provides a set of mappings between
 *     {@link javax.measure.unit.Unit Units} and symbols (both ways),
 *     between {@link Prefix Prefix}es and symbols
 *     (both ways), and from {@link javax.measure.converter.UnitConverter
 *     UnitConverter}s to {@link Prefix Prefix}es (one way).
 *     No attempt is made to verify the uniqueness of the mappings.</p>
 *
 * <p> Mappings are read from a <code>ResourceBundle</code>, the keys
 *     of which should consist of a fully-qualified class name, followed
 *     by a dot ('.'), and then the name of a static field belonging
 *     to that class, followed optionally by another dot and a number.
 *     If the trailing dot and number are not present, the value
 *     associated with the key is treated as a
 *     {@link SymbolMap#label(javax.measure.unit.Unit, String) label},
 *     otherwise if the trailing dot and number are present, the value
 *     is treated as an {@link SymbolMap#alias(javax.measure.unit.Unit,String) alias}.
 *     Aliases map from String to Unit only, whereas labels map in both
 *     directions. A given unit may have any number of aliases, but may
 *     have only one label.</p>
 * 
 * @author <a href="mailto:eric-r@northwestern.edu">Eric Russell</a>
 * @version 1.0.1 ($Revision: 76 $), $Date: 2009-12-03 23:53:52 +0100 (Do, 03 Dez 2009) $
 */
public class SymbolMap {
    
    private Map<String, Unit<?>> _symbolToUnit;
    private Map<Unit<?>, String> _unitToSymbol;
    private Map<String, Object> _symbolToPrefix;
    private Map<Object, String> _prefixToSymbol;
    private Map<UnitConverter, Prefix> _converterToPrefix;
    
    /**
     * Creates an empty mapping.
     */
    public SymbolMap () {
        _symbolToUnit = new HashMap<String, Unit<?>>();
        _unitToSymbol = new HashMap<Unit<?>, String>();
        _symbolToPrefix = new HashMap<String, Object>();
        _prefixToSymbol = new HashMap<Object, String>();
        _converterToPrefix = new HashMap<UnitConverter, Prefix>();
    }

    /** 
     * Creates a symbol map from the specified resource bundle,
     *
     * @param rb the resource bundle.
     */
    public SymbolMap (ResourceBundle rb) {
        this();
        for (Enumeration<String> i = rb.getKeys(); i.hasMoreElements();) {
            String fqn = i.nextElement();
            String symbol = rb.getString(fqn);
            boolean isAlias = false;
            int lastDot = fqn.lastIndexOf('.');
            String className = fqn.substring(0, lastDot);
            String fieldName = fqn.substring(lastDot+1, fqn.length());
            if (Character.isDigit(fieldName.charAt(0))) {
                isAlias = true;
                fqn = className;
                lastDot = fqn.lastIndexOf('.');
                className = fqn.substring(0, lastDot);
                fieldName = fqn.substring(lastDot+1, fqn.length());
            }
            try {
                Class<?> c = Class.forName(className);
                Field field = c.getField(fieldName);
                Object value = field.get(null);
                if (value instanceof Unit<?>) {
                    if (isAlias) {
                        alias((Unit<?>)value, symbol);
                    } else {
                        label((Unit<?>)value, symbol);
                    }
                } else if (value instanceof Prefix) {
                    label((Prefix)value, symbol);
                } else {
                    throw new ClassCastException("unable to cast "+value+" to Unit or Prefix");
                }
            } catch (Exception e) {
                System.err.println("ERROR reading Unit names: " + e.toString());
            }
        }
    }

    /**
     * Attaches a label to the specified unit. For example:[code]
     *    symbolMap.label(DAY.multiply(365), "year");
     *    symbolMap.label(NonSI.FOOT, "ft");
     * [/code]
     *
     * @param unit the unit to label.
     * @param symbol the new symbol for the unit.
     */
    public void label (Unit<?> unit, String symbol) {
        _symbolToUnit.put(symbol, unit);
        _unitToSymbol.put(unit, symbol);
    }
    
    /**
     * Attaches an alias to the specified unit. Multiple aliases may be
     * attached to the same unit. Aliases are used during parsing to
     * recognize different variants of the same unit.[code]
     *     symbolMap.alias(NonSI.FOOT, "foot");
     *     symbolMap.alias(NonSI.FOOT, "feet");
     *     symbolMap.alias(SI.METER, "meter");
     *     symbolMap.alias(SI.METER, "metre");
     * [/code]
     *
     * @param unit the unit to label.
     * @param symbol the new symbol for the unit.
     */
    public void alias (Unit<?> unit, String symbol) { 
        _symbolToUnit.put(symbol, unit);
    }
    
    /**
     * Attaches a label to the specified prefix. For example:[code]
     *    symbolMap.label(Prefix.GIGA, "G");
     *    symbolMap.label(Prefix.MICRO, "µ");
     * [/code]
     */
    public void label(Prefix prefix, String symbol) {
        _symbolToPrefix.put(symbol, prefix);
        _prefixToSymbol.put(prefix, symbol);
        _converterToPrefix.put(prefix.getConverter(), prefix);
    }
    
    /**
     * Returns the unit for the specified symbol.
     * 
     * @param symbol the symbol.
     * @return the corresponding unit or <code>null</code> if none.
     */
    public Unit<?> getUnit (String symbol) {
        return _symbolToUnit.get(symbol);
    }
    
    /**
     * Returns the symbol (label) for the specified unit.
     *
     * @param unit the corresponding symbol.
     * @return the corresponding symbol or <code>null</code> if none.
     */
    public String getSymbol (Unit<?> unit) {
        return _unitToSymbol.get(unit);
    }
    
    /**
     * Returns the prefix (if any) for the specified symbol.
     *
     * @param symbol the unit symbol.
     * @return the corresponding prefix or <code>null</code> if none.
     */
    public Prefix getPrefix (String symbol) {
        for (Iterator<String> i = _symbolToPrefix.keySet().iterator(); i.hasNext(); ) {
            String pfSymbol = i.next();
            if (symbol.startsWith(pfSymbol)) {
                return (Prefix)_symbolToPrefix.get(pfSymbol);
            }
        }
        return null;
    }
    
    /**
     * Returns the prefix for the specified converter.
     *
     * @param converter the unit converter.
     * @return the corresponding prefix or <code>null</code> if none.
     */
    public Prefix getPrefix (UnitConverter converter) {
        return (Prefix)_converterToPrefix.get(converter);
    }
    
    /**
     * Returns the symbol for the specified prefix.
     *
     * @param prefix the prefix.
     * @return the corresponding symbol or <code>null</code> if none.
     */
    public String getSymbol (Prefix prefix) {
        return _prefixToSymbol.get(prefix);
    }
}
