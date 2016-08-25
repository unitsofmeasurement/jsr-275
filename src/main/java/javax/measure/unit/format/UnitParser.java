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
/* Generated By:JavaCC: Do not edit this line. UnitParser.java */
package javax.measure.unit.format;

/** */
class UnitParser implements UnitParserConstants {

    private static class Exponent {
        public final int pow;
        public final int root;
        public Exponent (int pow, int root) {
            this.pow = pow;
            this.root = root;
        }
    }

    private SymbolMap _symbols;

    public UnitParser (SymbolMap symbols, java.io.Reader in) {
        this(in);
        _symbols = symbols;
    }

//
// Parser productions
//
  final public javax.measure.unit.Unit parseUnit() throws ParseException {
        javax.measure.unit.Unit result;
    result = CompoundExpr();
    jj_consume_token(0);
        {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public javax.measure.unit.Unit CompoundExpr() throws ParseException {
        javax.measure.unit.Unit result = javax.measure.unit.Unit.ONE;
        javax.measure.unit.Unit temp = javax.measure.unit.Unit.ONE;
    result = AddExpr();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COLON:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      jj_consume_token(COLON);
      temp = AddExpr();
                               result=result.compound(temp);
    }
      {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public javax.measure.unit.Unit AddExpr() throws ParseException {
        javax.measure.unit.Unit result = javax.measure.unit.Unit.ONE;
        Number n1 = null;
        Token sign1 = null;
        Number n2 = null;
        Token sign2 = null;
    if (jj_2_1(2147483647)) {
      n1 = NumberExpr();
      sign1 = Sign();
    } else {
      ;
    }
    result = MulExpr();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
    case MINUS:
      sign2 = Sign();
      n2 = NumberExpr();
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
        if (n1 != null) {
            if (sign1.image.equals("-")) {
                result = result.times(-1);
            }
            result = result.plus(n1.doubleValue());
        }
        if (n2 != null) {
            double offset = n2.doubleValue();
            if (sign2.image.equals("-")) {
                offset = -offset;
            }
            result = result.plus(offset);
        }
        {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public javax.measure.unit.Unit MulExpr() throws ParseException {
        javax.measure.unit.Unit result = javax.measure.unit.Unit.ONE;
        javax.measure.unit.Unit temp = javax.measure.unit.Unit.ONE;
    result = ExponentExpr();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ASTERISK:
      case MIDDLE_DOT:
      case SOLIDUS:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ASTERISK:
      case MIDDLE_DOT:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ASTERISK:
          jj_consume_token(ASTERISK);
          break;
        case MIDDLE_DOT:
          jj_consume_token(MIDDLE_DOT);
          break;
        default:
          jj_la1[3] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        temp = ExponentExpr();
                                                          result=result.times(temp);
        break;
      case SOLIDUS:
        jj_consume_token(SOLIDUS);
        temp = ExponentExpr();
                                        result=result.divide(temp);
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
      {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public javax.measure.unit.Unit ExponentExpr() throws ParseException {
        javax.measure.unit.Unit result = javax.measure.unit.Unit.ONE;
        javax.measure.unit.Unit temp = javax.measure.unit.Unit.ONE;
        Exponent exponent = null;
        Token token = null;
    if (jj_2_2(2147483647)) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER:
        token = jj_consume_token(INTEGER);
        break;
      case E:
        token = jj_consume_token(E);
        break;
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(CARET);
      result = AtomicExpr();
        double base;
        if (token.kind == INTEGER) {
            base = Integer.parseInt(token.image);
        } else {
            base = StrictMath.E;
        }
        {if (true) return result.transform(new javax.measure.converter.LogConverter(base).inverse());}
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OPEN_PAREN:
      case INTEGER:
      case FLOATING_POINT:
      case UNIT_IDENTIFIER:
        result = AtomicExpr();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case CARET:
        case SUPERSCRIPT_INTEGER:
          exponent = Exp();
          break;
        default:
          jj_la1[6] = jj_gen;
          ;
        }
        if (exponent != null) {
            if (exponent.pow != 1) {
                result = result.pow(exponent.pow);
            }
            if (exponent.root != 1) {
                result = result.root(exponent.root);
            }
        }
        {if (true) return result;}
        break;
      case LOG:
      case NAT_LOG:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LOG:
          jj_consume_token(LOG);
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case INTEGER:
            token = jj_consume_token(INTEGER);
            break;
          default:
            jj_la1[7] = jj_gen;
            ;
          }
          break;
        case NAT_LOG:
          token = jj_consume_token(NAT_LOG);
          break;
        default:
          jj_la1[8] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        jj_consume_token(OPEN_PAREN);
        result = AddExpr();
        jj_consume_token(CLOSE_PAREN);
        double base = 10;
        if (token != null) {
            if (token.kind == INTEGER) {
                base = Integer.parseInt(token.image);
            } else if (token.kind == NAT_LOG) {
                base = StrictMath.E;
            }
        }
        {if (true) return result.transform(new javax.measure.converter.LogConverter(base));}
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public javax.measure.unit.Unit AtomicExpr() throws ParseException {
        javax.measure.unit.Unit result = javax.measure.unit.Unit.ONE;
        javax.measure.unit.Unit temp = javax.measure.unit.Unit.ONE;
        Number n = null;
        Token token = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER:
    case FLOATING_POINT:
      n = NumberExpr();
        if (n instanceof Integer) {
            {if (true) return result.times(n.intValue());}
        } else {
            {if (true) return result.times(n.doubleValue());}
        }
      break;
    case UNIT_IDENTIFIER:
      token = jj_consume_token(UNIT_IDENTIFIER);
        javax.measure.unit.Unit unit = _symbols.getUnit(token.image);
        if (unit == null) {
            Prefix prefix = _symbols.getPrefix(token.image);
            if (prefix != null) {
                String prefixSymbol = _symbols.getSymbol(prefix);
                unit = _symbols.getUnit(token.image.substring(prefixSymbol.length()));
                if (unit != null) {
                    {if (true) return unit.transform(prefix.getConverter());}
                }
            }
            {if (true) throw new ParseException();}
        } else {
            {if (true) return unit;}
        }
      break;
    case OPEN_PAREN:
      jj_consume_token(OPEN_PAREN);
      result = AddExpr();
      jj_consume_token(CLOSE_PAREN);
        {if (true) return result;}
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Token Sign() throws ParseException {
        Token result = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      result = jj_consume_token(PLUS);
      break;
    case MINUS:
      result = jj_consume_token(MINUS);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
        {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  final public Number NumberExpr() throws ParseException {
        Token token = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER:
      token = jj_consume_token(INTEGER);
        {if (true) return Long.valueOf(token.image);}
      break;
    case FLOATING_POINT:
      token = jj_consume_token(FLOATING_POINT);
        {if (true) return Double.valueOf(token.image);}
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Exponent Exp() throws ParseException {
        Token powSign = null;
        Token powToken = null;
        Token rootSign = null;
        Token rootToken = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CARET:
      jj_consume_token(CARET);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
      case INTEGER:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PLUS:
        case MINUS:
          powSign = Sign();
          break;
        default:
          jj_la1[13] = jj_gen;
          ;
        }
        powToken = jj_consume_token(INTEGER);
            int pow = Integer.parseInt(powToken.image);
            if ((powSign != null) && powSign.image.equals("-")) {
                pow = -pow;
            }
            {if (true) return new Exponent(pow, 1);}
        break;
      case OPEN_PAREN:
        jj_consume_token(OPEN_PAREN);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PLUS:
        case MINUS:
          powSign = Sign();
          break;
        default:
          jj_la1[14] = jj_gen;
          ;
        }
        powToken = jj_consume_token(INTEGER);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SOLIDUS:
          jj_consume_token(SOLIDUS);
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case PLUS:
          case MINUS:
            rootSign = Sign();
            break;
          default:
            jj_la1[15] = jj_gen;
            ;
          }
          rootToken = jj_consume_token(INTEGER);
          break;
        default:
          jj_la1[16] = jj_gen;
          ;
        }
        jj_consume_token(CLOSE_PAREN);
            pow = Integer.parseInt(powToken.image);
            if ((powSign != null) && powSign.image.equals("-")) {
                pow = -pow;
            }
            int root = 1;
            if (rootToken != null) {
                root = Integer.parseInt(rootToken.image);
                if ((rootSign != null) && rootSign.image.equals("-")) {
                    root = -root;
                }
            }
            {if (true) return new Exponent(pow, root);}
        break;
      default:
        jj_la1[17] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case SUPERSCRIPT_INTEGER:
      powToken = jj_consume_token(SUPERSCRIPT_INTEGER);
        int pow = 0;
        for (int i = 0; i < powToken.image.length(); i += 1) {
            pow *= 10;
            switch (powToken.image.charAt(i)) {
                case '\u00b9': pow += 1; break;
                case '\u00b2': pow += 2; break;
                case '\u00b3': pow += 3; break;
                case '\u2074': pow += 4; break;
                case '\u2075': pow += 5; break;
                case '\u2076': pow += 6; break;
                case '\u2077': pow += 7; break;
                case '\u2078': pow += 8; break;
                case '\u2079': pow += 9; break;
            }
        }
        {if (true) return new Exponent(pow, 1);}
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_3R_3() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_5()) {
    jj_scanpos = xsp;
    if (jj_3R_6()) return true;
    }
    return false;
  }

  private boolean jj_3R_6() {
    if (jj_scan_token(FLOATING_POINT)) return true;
    return false;
  }

  private boolean jj_3_2() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(14)) {
    jj_scanpos = xsp;
    if (jj_scan_token(19)) return true;
    }
    if (jj_scan_token(CARET)) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_3R_3()) return true;
    if (jj_3R_4()) return true;
    return false;
  }

  private boolean jj_3R_4() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(5)) {
    jj_scanpos = xsp;
    if (jj_scan_token(6)) return true;
    }
    return false;
  }

  private boolean jj_3R_5() {
    if (jj_scan_token(INTEGER)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public UnitParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[19];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x800,0x60,0x380,0x180,0x380,0x84000,0x8400,0x4000,0x60000,0x175000,0x115000,0x60,0x14000,0x60,0x60,0x60,0x200,0x5060,0x8400,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[2];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public UnitParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public UnitParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new UnitParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public UnitParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new UnitParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public UnitParser(UnitParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(UnitParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 19; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[21];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 19; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 21; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 2; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
