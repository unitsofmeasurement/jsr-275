/**
 * JEAN-MARIE DAUTELLE, WERNER KEIL ARE WILLING TO LICENSE THIS SPECIFICATION TO YOU ONLY UPON THE CONDITION THAT YOU ACCEPT ALL OF THE TERMS CONTAINED IN THIS LICENSE AGREEMENT ("AGREEMENT"). PLEASE READ THE TERMS AND CONDITIONS OF THIS AGREEMENT CAREFULLY. BY DOWNLOADING THIS SPECIFICATION, YOU ACCEPT THE TERMS AND CONDITIONS OF THIS AGREEMENT. IF YOU ARE NOT WILLING TO BE BOUND BY THEM, SELECT THE "DECLINE" BUTTON AT THE BOTTOM OF THIS PAGE AND THE DOWNLOADING PROCESS WILL NOT CONTINUE.
 *
 *
 *
 * Specification: JSR 275 - Units Specification ("Specification")
 *
 *
 * Version: 0.9.2
 *
 *
 * Status: Pre-FCS Public Release
 *
 *
 * Release: November 18, 2009
 *
 *
 * Copyright 2005-2009 Jean-Marie Dautelle, Werner Keil
 *
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
 *
 * "This is an implementation of an early-draft specification developed under the Java Community Process (JCP) and is made available for testing and evaluation purposes only. The code is not compatible with any specification of the JCP."
 *
 *    3. Distribute applications written to the Specification to third parties for their testing and evaluation use, provided that any such application includes the following notice:
 *
 *       "This is an application written to interoperate with an early-draft specification developed under the Java Community Process (JCP) and is made available for testing and evaluation purposes only. The code is not compatible with any specification of the JCP."
 *
 * The grant set forth above concerning your distribution of implementations of the Specification is contingent upon your agreement to terminate development and distribution of your implementation of early draft upon final completion of the Specification.  If you fail to do so, the foregoing grant shall be considered null and void.
 * Other than this limited license, you acquire no right, title or interest in or to the Specification or any other Jean-Marie Dautelle and Werner Keil intellectual property, and the Specification may only be used in accordance with the license terms set forth herein. This license will expire on the earlier of:  (a) two (2) years from the date of Release listed above; (b) the date on which the final version of the Specification is publicly released; or (c) the date on which the Java Specification Request (JSR) to which the Specification corresponds is withdrawn.  In addition, this license will terminate immediately without notice from Jean-Marie Dautelle, Werner Keil if you fail to comply with any provision of this license.  Upon termination, you must cease use of or destroy the Specification.
 *
 * "Licensor Name Space" means the public class or interface declarations whose names begin with "java", "javax", "org.jscience" or their equivalents in any subsequent naming convention adopted through the Java Community Process, or any recognized successors or replacements thereof
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
 *
 * THE SPECIFICATION COULD INCLUDE TECHNICAL INACCURACIES OR TYPOGRAPHICAL ERRORS. CHANGES ARE PERIODICALLY ADDED TO THE INFORMATION THEREIN; THESE CHANGES WILL BE INCORPORATED INTO NEW VERSIONS OF THE SPECIFICATION, IF ANY. JEAN-MARIE DAUTELL AND WERNER KEIL MAY MAKE IMPROVEMENTS AND/OR CHANGES TO THE PRODUCT(S) AND/OR THE PROGRAM(S) DESCRIBED IN THE SPECIFICATION AT ANY TIME. Any use of such changes in the Specification will be governed by the then-current license for the applicable version of the Specification.
 *
 *
 * LIMITATION OF LIABILITY
 *
 * TO THE EXTENT NOT PROHIBITED BY LAW, IN NO EVENT WILL JEAN-MARIE DAUTELLE, WERNER KEIL OR THEIR LICENSORS BE LIABLE FOR ANY DAMAGES, INCLUDING WITHOUT LIMITATION, LOST REVENUE, PROFITS OR DATA, OR FOR SPECIAL, INDIRECT, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF OR RELATED TO ANY FURNISHING, PRACTICING, MODIFYING OR ANY USE OF THE SPECIFICATION, EVEN IF JEAN-MARIE DAUTELLE, WERNER KEIL AND/OR ITS LICENSORS HAVE BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
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
 *
 * The Specification is subject to U.S. export control laws and may be subject to export or import regulations in other countries. Licensee agrees to comply strictly with all such laws and regulations and acknowledges that it has the responsibility to obtain such licenses to export, re-export or import as may be required after delivery to Licensee.
 *
 *
 * This Agreement is the parties' entire agreement relating to its subject matter. It supersedes all prior or contemporaneous oral or written communications, proposals, conditions, representations and warranties and prevails over any conflicting or additional terms of any quote, order, acknowledgment, or other communication between the parties relating to its subject matter during the term of this Agreement. No modification to this Agreement will be binding, unless in writing and signed by an authorized representative of each party.
 *
 *
 *
 * Rev. January 2006
 *
 * Non-Sun/Spec/Public/EarlyAccess
 */
/**
 * Provides support for programatic unit handling.
 *
 * <h3> Standard/NonStandard Units</h3>
 *      Standard units and prefixes are provided by the
 *      {@link javax.measure.unit.SI SI} class (Système International d'Unités) and
 *      about 50 non-standard units are available through the
 *      {@link javax.measure.unit.NonSI NonSI} class.
 *
 * <h3>Usage examples:</h3>
 * [code]
 * import javax.measure.Scalar;
 * import javax.measure.Measure;
 * import javax.measure.unit.*;
 * import javax.measure.quantity.*;
 * import static javax.measure.unit.SI.*;
 * import static javax.measure.unit.NonSI.*;
 * import static javax.measure.unit.Dimension.*;
 * public class Main {
 *     public void main(String[] args) {
 *
 *         // Conversion between units.
 *         System.out.println(KILO(METRE).getConverterTo(MILE).convert(10));
 *
 *         // Retrieval of the system unit (identifies the measurement type).
 *         System.out.println(REVOLUTION.divide(MINUTE).getSystemUnit());
 *
 *         // Dimension checking (allows/disallows conversions)
 *         System.out.println(ELECTRON_VOLT.isCompatible(WATT.times(HOUR)));
 *
 *         // Retrieval of the unit dimension (depends upon the current model).
 *         System.out.println(ELECTRON_VOLT.getDimension());
 *     }
 * }
 *
 * > 6.2137119223733395
 * > rad/s
 * > true
 * > [L]2.[M]/[T]2
 * [/code]
 *
 * <h3>Unit Parameterization</h3>
 *
 *     Units are parameterized (&lt;Q extends {@link javax.measure.quantity.Quantity Quantity}>) to
 *     enforce compile-time checks of units/measures consistency, for example:[code]
 *
 *     Unit<Duration> MINUTE = SECOND.times(60); // Ok.
 *     Unit<Duration> MINUTE = METRE.times(60); // Compile error.
 *
 *     Unit<Pressure> HECTOPASCAL = HECTO(PASCAL); // Ok.
 *     Unit<Pressure> HECTOPASCAL = HECTO(NEWTON); // Compile error.
 *
 *     Measurable<Duration> duration = Measure.valueOf(2, MINUTE); // Ok.
 *     Measurable<Duration> duration = Measure.valueOf(2, CELSIUS); // Compile error.
 *
 *     long milliseconds = duration.longValue(MILLI(SECOND)); // Ok.
 *     long milliseconds = duration.longValue(POUND); // Compile error.
 *     [/code]
 *
 *     Runtime checks of dimension consistency can be done for more complex cases.
 *
 *     [code]
 *     Unit<Area> SQUARE_FOOT = FOOT.times(FOOT).asType(Area.class); // Ok.
 *     Unit<Area> SQUARE_FOOT = FOOT.times(KELVIN).asType(Area.class); // Runtime error.
 *
 *     Unit<Temperature> KELVIN = Unit.valueOf("K").asType(Temperature.class); // Ok.
 *     Unit<Temperature> KELVIN = Unit.valueOf("kg").asType(Temperature.class); // Runtime error.
 *     [/code]
 *     </p>
 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.0, April 15, 2009
 */
package javax.measure.unit;
