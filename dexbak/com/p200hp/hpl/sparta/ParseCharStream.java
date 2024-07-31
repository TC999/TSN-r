package com.p200hp.hpl.sparta;

import com.baidu.idl.face.platform.common.ConstantHelper;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;
import kotlin.text.Typography;

/* renamed from: com.hp.hpl.sparta.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
class ParseCharStream implements InterfaceC7048o {

    /* renamed from: A */
    private static final char[] f23896A;

    /* renamed from: B */
    private static final char[] f23897B;

    /* renamed from: C */
    private static final char[] f23898C;

    /* renamed from: D */
    private static final char[] f23899D;

    /* renamed from: E */
    private static final char[] f23900E;

    /* renamed from: F */
    private static final char[] f23901F;

    /* renamed from: G */
    private static final char[] f23902G;

    /* renamed from: H */
    private static final char[] f23903H;

    /* renamed from: I */
    private static final char[] f23904I;

    /* renamed from: J */
    private static final char[] f23905J;

    /* renamed from: K */
    private static final char[] f23906K;

    /* renamed from: L */
    private static final char[] f23907L;

    /* renamed from: M */
    private static final char[] f23908M;

    /* renamed from: N */
    private static final char[] f23909N;

    /* renamed from: O */
    private static final char[] f23910O;

    /* renamed from: P */
    private static final char[] f23911P;

    /* renamed from: Q */
    private static final char[] f23912Q;

    /* renamed from: R */
    private static final char[] f23913R;

    /* renamed from: S */
    private static final int f23914S = 255;

    /* renamed from: T */
    public static final int f23915T = 100;

    /* renamed from: u */
    private static final boolean f23916u = true;

    /* renamed from: v */
    private static final boolean f23917v = false;

    /* renamed from: x */
    private static final int f23919x = 128;

    /* renamed from: z */
    private static final char[] f23921z;

    /* renamed from: c */
    private String f23922c;

    /* renamed from: d */
    private String f23923d;

    /* renamed from: e */
    private final Reader f23924e;

    /* renamed from: f */
    private final Hashtable f23925f;

    /* renamed from: g */
    private final Hashtable f23926g;

    /* renamed from: h */
    private final ParseLog f23927h;

    /* renamed from: i */
    private final String f23928i;

    /* renamed from: j */
    private int f23929j;

    /* renamed from: k */
    private boolean f23930k;

    /* renamed from: l */
    private final int f23931l;

    /* renamed from: m */
    private final char[] f23932m;

    /* renamed from: n */
    private int f23933n;

    /* renamed from: o */
    private int f23934o;

    /* renamed from: p */
    private boolean f23935p;

    /* renamed from: q */
    private final char[] f23936q;

    /* renamed from: r */
    private int f23937r;

    /* renamed from: s */
    private final CharCircBuffer f23938s;

    /* renamed from: t */
    private final ParseHandler f23939t;

    /* renamed from: w */
    private static final char[] f23918w = {'.', '-', '_', ':'};

    /* renamed from: y */
    private static final boolean[] f23920y = new boolean[128];

    static {
        for (char c = 0; c < 128; c = (char) (c + 1)) {
            f23920y[c] = m35155z(c);
        }
        f23921z = "<!--".toCharArray();
        f23896A = "-->".toCharArray();
        f23897B = "<?".toCharArray();
        f23898C = "?>".toCharArray();
        f23899D = "<!DOCTYPE".toCharArray();
        f23900E = "<?xml".toCharArray();
        f23901F = "encoding".toCharArray();
        f23902G = ConstantHelper.LOG_VS.toCharArray();
        f23903H = new char[]{'_', '.', ':', '-'};
        f23904I = "<!".toCharArray();
        f23905J = "&#".toCharArray();
        f23906K = "<!ENTITY".toCharArray();
        f23907L = "NDATA".toCharArray();
        f23908M = "SYSTEM".toCharArray();
        f23909N = "PUBLIC".toCharArray();
        f23910O = "<![CDATA[".toCharArray();
        f23911P = "]]>".toCharArray();
        f23912Q = "/>".toCharArray();
        f23913R = "</".toCharArray();
    }

    public ParseCharStream(String str, char[] cArr, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        this(str, null, cArr, parseLog, str2, parseHandler);
    }

    /* renamed from: A */
    private boolean m35222A() throws ParseException, IOException {
        return m35181j('%');
    }

    /* renamed from: B */
    private final boolean m35221B() throws ParseException, IOException {
        return m35218E(f23897B);
    }

    /* renamed from: C */
    private final boolean m35220C() throws ParseException, IOException {
        return m35181j(Typography.f41567c);
    }

    /* renamed from: D */
    private final boolean m35219D() throws ParseException, IOException {
        return m35177l(HttpConstants.SP_CHAR, '\t', StringUtil.CARRIAGE_RETURN, '\n');
    }

    /* renamed from: E */
    private final boolean m35218E(char[] cArr) throws ParseException, IOException {
        int length = cArr.length;
        if (this.f23934o - this.f23933n < length && m35193c(length) <= 0) {
            this.f23929j = -1;
            return false;
        }
        char[] cArr2 = this.f23932m;
        int i = this.f23934o;
        this.f23929j = cArr2[i - 1];
        if (i - this.f23933n < length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (this.f23932m[this.f23933n + i2] != cArr[i2]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: F */
    private boolean m35217F() throws ParseException, IOException {
        char m35215H = m35215H();
        return Character.isDigit(m35215H) || ('a' <= m35215H && m35215H <= 'z') || (('Z' <= m35215H && m35215H <= 'Z') || m35159v(m35215H, f23903H));
    }

    /* renamed from: G */
    private boolean m35216G() throws ParseException, IOException {
        return m35218E(f23900E);
    }

    /* renamed from: H */
    private final char m35215H() throws ParseException, IOException {
        if (this.f23933n < this.f23934o || m35195b() != -1) {
            return this.f23932m[this.f23933n];
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    /* renamed from: I */
    private String m35214I() throws ParseException, IOException {
        char m35210M = m35210M('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!m35181j(m35210M)) {
            if (m35220C()) {
                stringBuffer.append(m35174m0());
            } else {
                stringBuffer.append(m35211L());
            }
        }
        m35208O(m35210M);
        return stringBuffer.toString();
    }

    /* renamed from: J */
    private void m35213J(Element element) throws ParseException, IOException {
        String m35188f0 = m35188f0();
        m35194b0();
        String m35214I = m35214I();
        if (element.m35267D(m35188f0) != null) {
            ParseLog parseLog = this.f23927h;
            parseLog.mo35145c("Element " + this + " contains attribute " + m35188f0 + "more than once", this.f23922c, mo35143d());
        }
        element.m35256O(m35188f0, m35214I);
    }

    /* renamed from: K */
    private void m35212K() throws ParseException, IOException {
        char[] cArr;
        m35170o0(f23910O);
        StringBuffer stringBuffer = null;
        int i = 0;
        while (true) {
            cArr = f23911P;
            if (m35218E(cArr)) {
                break;
            }
            if (i >= 255) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(i);
                    stringBuffer.append(this.f23936q, 0, i);
                } else {
                    stringBuffer.append(this.f23936q, 0, i);
                }
                i = 0;
            }
            this.f23936q[i] = m35211L();
            i++;
        }
        m35170o0(cArr);
        if (stringBuffer != null) {
            stringBuffer.append(this.f23936q, 0, i);
            char[] charArray = stringBuffer.toString().toCharArray();
            this.f23939t.mo35149i(charArray, 0, charArray.length);
            return;
        }
        this.f23939t.mo35149i(this.f23936q, 0, i);
    }

    /* renamed from: L */
    private final char m35211L() throws ParseException, IOException {
        if (this.f23933n < this.f23934o || m35195b() != -1) {
            char[] cArr = this.f23932m;
            int i = this.f23933n;
            if (cArr[i] == '\n') {
                this.f23937r++;
            }
            this.f23933n = i + 1;
            return cArr[i];
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    /* renamed from: M */
    private final char m35210M(char c, char c2) throws ParseException, IOException {
        char m35211L = m35211L();
        if (m35211L == c || m35211L == c2) {
            return m35211L;
        }
        throw new ParseException(this, m35211L, new char[]{c, c2});
    }

    /* renamed from: N */
    private final char m35209N(char c, char c2, char c3, char c4) throws ParseException, IOException {
        char m35211L = m35211L();
        if (m35211L == c || m35211L == c2 || m35211L == c3 || m35211L == c4) {
            return m35211L;
        }
        throw new ParseException(this, m35211L, new char[]{c, c2, c3, c4});
    }

    /* renamed from: O */
    private final void m35208O(char c) throws ParseException, IOException {
        char m35211L = m35211L();
        if (m35211L != c) {
            throw new ParseException(this, m35211L, c);
        }
    }

    /* renamed from: P */
    private char m35207P() throws ParseException, IOException {
        int i;
        m35170o0(f23905J);
        if (m35181j('x')) {
            m35211L();
            i = 16;
        } else {
            i = 10;
        }
        int i2 = 0;
        while (!m35181j(';')) {
            int i3 = i2 + 1;
            this.f23936q[i2] = m35211L();
            if (i3 >= 255) {
                this.f23927h.mo35145c("Tmp buffer overflow on readCharRef", this.f23922c, mo35143d());
                return HttpConstants.SP_CHAR;
            }
            i2 = i3;
        }
        m35208O(';');
        String str = new String(this.f23936q, 0, i2);
        try {
            return (char) Integer.parseInt(str, i);
        } catch (NumberFormatException unused) {
            ParseLog parseLog = this.f23927h;
            StringBuilder sb = new StringBuilder();
            sb.append("\"");
            sb.append(str);
            sb.append("\" is not a valid ");
            sb.append(i == 16 ? "hexadecimal" : "decimal");
            sb.append(" number");
            parseLog.mo35145c(sb.toString(), this.f23922c, mo35143d());
            return HttpConstants.SP_CHAR;
        }
    }

    /* renamed from: Q */
    private final void m35206Q() throws ParseException, IOException {
        m35170o0(f23921z);
        while (true) {
            char[] cArr = f23896A;
            if (!m35218E(cArr)) {
                m35211L();
            } else {
                m35170o0(cArr);
                return;
            }
        }
    }

    /* renamed from: R */
    private void m35205R() throws ParseException, IOException {
        m35180j0();
        boolean z = true;
        while (z) {
            if (!m35169p()) {
                if (m35220C()) {
                    char[] m35174m0 = m35174m0();
                    this.f23939t.mo35149i(m35174m0, 0, m35174m0.length);
                } else if (m35183i()) {
                    m35212K();
                } else if (m35221B()) {
                    m35182i0();
                } else if (m35175m()) {
                    m35206Q();
                } else if (m35181j(Typography.f41568d)) {
                    m35201V();
                }
                m35180j0();
            }
            z = false;
            m35180j0();
        }
    }

    /* renamed from: S */
    private void m35204S() throws ParseException, IOException {
        if (m35222A()) {
            m35184h0();
        } else {
            m35172n0();
        }
    }

    /* renamed from: T */
    private void m35203T() throws ParseException, IOException {
        m35170o0(f23899D);
        m35172n0();
        this.f23923d = m35188f0();
        if (m35219D()) {
            m35172n0();
            if (!m35181j(Typography.f41569e) && !m35181j('[')) {
                this.f23930k = true;
                m35192c0();
                if (m35219D()) {
                    m35172n0();
                }
            }
        }
        if (m35181j('[')) {
            m35211L();
            while (!m35181j(']')) {
                if (m35173n()) {
                    m35204S();
                } else {
                    m35191d0();
                }
            }
            m35208O(']');
            if (m35219D()) {
                m35172n0();
            }
        }
        m35208O(Typography.f41569e);
    }

    /* renamed from: U */
    private void m35202U(Element element) throws ParseException, IOException {
        m35170o0(f23913R);
        String m35188f0 = m35188f0();
        if (!m35188f0.equals(element.m35263H())) {
            ParseLog parseLog = this.f23927h;
            parseLog.mo35145c("end tag (" + m35188f0 + ") does not match begin tag (" + element.m35263H() + ")", this.f23922c, mo35143d());
        }
        if (m35219D()) {
            m35172n0();
        }
        m35208O(Typography.f41569e);
    }

    /* renamed from: V */
    private final Element m35201V() throws ParseException, IOException {
        Element element = new Element();
        boolean m35200W = m35200W(element);
        this.f23939t.mo35148j(element);
        if (m35200W) {
            m35205R();
            m35202U(element);
        }
        this.f23939t.mo35152e(element);
        return element;
    }

    /* renamed from: W */
    private boolean m35200W(Element element) throws ParseException, IOException {
        m35208O(Typography.f41568d);
        element.m35255P(m35188f0());
        while (m35219D()) {
            m35172n0();
            if (!m35179k('/', Typography.f41569e)) {
                m35213J(element);
            }
        }
        if (m35219D()) {
            m35172n0();
        }
        boolean m35181j = m35181j(Typography.f41569e);
        if (m35181j) {
            m35208O(Typography.f41569e);
        } else {
            m35170o0(f23912Q);
        }
        return m35181j;
    }

    /* renamed from: X */
    private String m35199X() throws ParseException, IOException {
        m35170o0(f23901F);
        m35194b0();
        char m35210M = m35210M('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!m35181j(m35210M)) {
            stringBuffer.append(m35211L());
        }
        m35208O(m35210M);
        return stringBuffer.toString();
    }

    /* renamed from: Y */
    private void m35198Y() throws ParseException, IOException {
        String m35192c0;
        String m35192c02;
        m35170o0(f23906K);
        m35172n0();
        if (m35181j('%')) {
            m35208O('%');
            m35172n0();
            String m35188f0 = m35188f0();
            m35172n0();
            if (m35163s()) {
                m35192c02 = m35196a0();
            } else {
                m35192c02 = m35192c0();
            }
            this.f23926g.put(m35188f0, m35192c02);
        } else {
            String m35188f02 = m35188f0();
            m35172n0();
            if (m35163s()) {
                m35192c0 = m35196a0();
            } else if (m35160u()) {
                m35192c0 = m35192c0();
                if (m35219D()) {
                    m35172n0();
                }
                char[] cArr = f23907L;
                if (m35218E(cArr)) {
                    m35170o0(cArr);
                    m35172n0();
                    m35188f0();
                }
            } else {
                throw new ParseException(this, "expecting double-quote, \"PUBLIC\" or \"SYSTEM\" while reading entity declaration");
            }
            this.f23925f.put(m35188f02, m35192c0);
        }
        if (m35219D()) {
            m35172n0();
        }
        m35208O(Typography.f41569e);
    }

    /* renamed from: Z */
    private String m35197Z() throws ParseException, IOException {
        m35208O(Typography.f41567c);
        String m35188f0 = m35188f0();
        String str = (String) this.f23925f.get(m35188f0);
        if (str == null) {
            if (this.f23930k) {
                ParseLog parseLog = this.f23927h;
                parseLog.mo35145c("&" + m35188f0 + "; not found -- possibly defined in external DTD)", this.f23922c, mo35143d());
            } else {
                ParseLog parseLog2 = this.f23927h;
                parseLog2.mo35145c("No declaration of &" + m35188f0 + ";", this.f23922c, mo35143d());
            }
            str = "";
        }
        m35208O(';');
        return str;
    }

    /* renamed from: a0 */
    private final String m35196a0() throws ParseException, IOException {
        char m35210M = m35210M('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!m35181j(m35210M)) {
            if (m35222A()) {
                stringBuffer.append(m35184h0());
            } else if (m35220C()) {
                stringBuffer.append(m35174m0());
            } else {
                stringBuffer.append(m35211L());
            }
        }
        m35208O(m35210M);
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private int m35195b() throws IOException {
        if (this.f23935p) {
            return -1;
        }
        int i = this.f23934o;
        char[] cArr = this.f23932m;
        if (i == cArr.length) {
            this.f23934o = 0;
            this.f23933n = 0;
        }
        Reader reader = this.f23924e;
        int i2 = this.f23934o;
        int read = reader.read(cArr, i2, cArr.length - i2);
        if (read <= 0) {
            this.f23935p = true;
            return -1;
        }
        this.f23934o += read;
        return read;
    }

    /* renamed from: b0 */
    private final void m35194b0() throws ParseException, IOException {
        if (m35219D()) {
            m35172n0();
        }
        m35208O('=');
        if (m35219D()) {
            m35172n0();
        }
    }

    /* renamed from: c */
    private int m35193c(int i) throws IOException {
        int i2;
        int i3;
        if (this.f23935p) {
            return -1;
        }
        int i4 = 0;
        if (this.f23932m.length - this.f23933n < i) {
            int i5 = 0;
            while (true) {
                i2 = this.f23933n;
                int i6 = i2 + i5;
                i3 = this.f23934o;
                if (i6 >= i3) {
                    break;
                }
                char[] cArr = this.f23932m;
                cArr[i5] = cArr[i2 + i5];
                i5++;
            }
            int i7 = i3 - i2;
            this.f23934o = i7;
            this.f23933n = 0;
            i4 = i7;
        }
        int m35195b = m35195b();
        if (m35195b == -1) {
            if (i4 == 0) {
                return -1;
            }
            return i4;
        }
        return i4 + m35195b;
    }

    /* renamed from: c0 */
    private String m35192c0() throws ParseException, IOException {
        char[] cArr = f23908M;
        if (m35218E(cArr)) {
            m35170o0(cArr);
        } else {
            char[] cArr2 = f23909N;
            if (m35218E(cArr2)) {
                m35170o0(cArr2);
                m35172n0();
                m35176l0();
            } else {
                throw new ParseException(this, "expecting \"SYSTEM\" or \"PUBLIC\" while reading external ID");
            }
        }
        m35172n0();
        m35168p0();
        return "(WARNING: external ID not read)";
    }

    /* renamed from: d0 */
    private void m35191d0() throws ParseException, IOException {
        if (m35221B()) {
            m35182i0();
        } else if (m35175m()) {
            m35206Q();
        } else if (m35165r()) {
            m35198Y();
        } else if (m35218E(f23904I)) {
            while (!m35181j(Typography.f41569e)) {
                if (m35179k('\'', '\"')) {
                    char m35211L = m35211L();
                    while (!m35181j(m35211L)) {
                        m35211L();
                    }
                    m35208O(m35211L);
                } else {
                    m35211L();
                }
            }
            m35208O(Typography.f41569e);
        } else {
            throw new ParseException(this, "expecting processing instruction, comment, or \"<!\"");
        }
    }

    /* renamed from: e0 */
    private void m35189e0() throws ParseException, IOException {
        if (m35175m()) {
            m35206Q();
        } else if (m35221B()) {
            m35182i0();
        } else if (m35219D()) {
            m35172n0();
        } else {
            throw new ParseException(this, "expecting comment or processing instruction or space");
        }
    }

    /* renamed from: f0 */
    private final String m35188f0() throws ParseException, IOException {
        this.f23936q[0] = m35186g0();
        int i = 1;
        StringBuffer stringBuffer = null;
        while (m35156y()) {
            if (i >= 255) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(i);
                    stringBuffer.append(this.f23936q, 0, i);
                } else {
                    stringBuffer.append(this.f23936q, 0, i);
                }
                i = 0;
            }
            this.f23936q[i] = m35211L();
            i++;
        }
        if (stringBuffer == null) {
            return Sparta.m35124a(new String(this.f23936q, 0, i));
        }
        stringBuffer.append(this.f23936q, 0, i);
        return stringBuffer.toString();
    }

    /* renamed from: g0 */
    private char m35186g0() throws ParseException, IOException {
        char m35211L = m35211L();
        if (m35158w(m35211L) || m35211L == '_' || m35211L == ':') {
            return m35211L;
        }
        throw new ParseException(this, m35211L, "letter, underscore, colon");
    }

    /* renamed from: h0 */
    private String m35184h0() throws ParseException, IOException {
        m35208O('%');
        String m35188f0 = m35188f0();
        String str = (String) this.f23926g.get(m35188f0);
        if (str == null) {
            ParseLog parseLog = this.f23927h;
            parseLog.mo35145c("No declaration of %" + m35188f0 + ";", this.f23922c, mo35143d());
            str = "";
        }
        m35208O(';');
        return str;
    }

    /* renamed from: i */
    private boolean m35183i() throws ParseException, IOException {
        return m35218E(f23910O);
    }

    /* renamed from: i0 */
    private final void m35182i0() throws ParseException, IOException {
        m35170o0(f23897B);
        while (true) {
            char[] cArr = f23898C;
            if (!m35218E(cArr)) {
                m35211L();
            } else {
                m35170o0(cArr);
                return;
            }
        }
    }

    /* renamed from: j */
    private final boolean m35181j(char c) throws ParseException, IOException {
        if (this.f23933n < this.f23934o || m35195b() != -1) {
            return this.f23932m[this.f23933n] == c;
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
        r4.f23939t.mo35149i(r4.f23936q, 0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        return;
     */
    /* renamed from: j0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m35180j0() throws com.p200hp.hpl.sparta.ParseException, java.io.IOException {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            r2 = 60
            boolean r2 = r4.m35181j(r2)
            if (r2 != 0) goto L48
            r2 = 38
            boolean r2 = r4.m35181j(r2)
            if (r2 != 0) goto L48
            char[] r2 = com.p200hp.hpl.sparta.ParseCharStream.f23911P
            boolean r2 = r4.m35218E(r2)
            if (r2 != 0) goto L48
            char[] r2 = r4.f23936q
            char r3 = r4.m35211L()
            r2[r1] = r3
            char[] r2 = r4.f23936q
            char r2 = r2[r1]
            r3 = 13
            if (r2 != r3) goto L3a
            char r2 = r4.m35215H()
            r3 = 10
            if (r2 != r3) goto L3a
            char[] r2 = r4.f23936q
            char r3 = r4.m35211L()
            r2[r1] = r3
        L3a:
            int r1 = r1 + 1
            r2 = 255(0xff, float:3.57E-43)
            if (r1 != r2) goto L2
            com.hp.hpl.sparta.m r1 = r4.f23939t
            char[] r3 = r4.f23936q
            r1.mo35149i(r3, r0, r2)
            goto L1
        L48:
            if (r1 <= 0) goto L51
            com.hp.hpl.sparta.m r2 = r4.f23939t
            char[] r3 = r4.f23936q
            r2.mo35149i(r3, r0, r1)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p200hp.hpl.sparta.ParseCharStream.m35180j0():void");
    }

    /* renamed from: k */
    private final boolean m35179k(char c, char c2) throws ParseException, IOException {
        if (this.f23933n < this.f23934o || m35195b() != -1) {
            char c3 = this.f23932m[this.f23933n];
            return c3 == c || c3 == c2;
        }
        return false;
    }

    /* renamed from: k0 */
    private void m35178k0() throws ParseException, EncodingMismatchException, IOException {
        if (m35216G()) {
            m35162s0();
        }
        while (m35157x()) {
            m35189e0();
        }
        if (m35171o()) {
            m35203T();
            while (m35157x()) {
                m35189e0();
            }
        }
    }

    /* renamed from: l */
    private final boolean m35177l(char c, char c2, char c3, char c4) throws ParseException, IOException {
        if (this.f23933n < this.f23934o || m35195b() != -1) {
            char c5 = this.f23932m[this.f23933n];
            return c5 == c || c5 == c2 || c5 == c3 || c5 == c4;
        }
        return false;
    }

    /* renamed from: l0 */
    private final void m35176l0() throws ParseException, IOException {
        m35168p0();
    }

    /* renamed from: m */
    private final boolean m35175m() throws ParseException, IOException {
        return m35218E(f23921z);
    }

    /* renamed from: m0 */
    private final char[] m35174m0() throws ParseException, IOException {
        return m35218E(f23905J) ? new char[]{m35207P()} : m35197Z().toCharArray();
    }

    /* renamed from: n */
    private boolean m35173n() throws ParseException, IOException {
        return m35222A() || m35219D();
    }

    /* renamed from: n0 */
    private final void m35172n0() throws ParseException, IOException {
        m35209N(HttpConstants.SP_CHAR, '\t', StringUtil.CARRIAGE_RETURN, '\n');
        while (m35177l(HttpConstants.SP_CHAR, '\t', StringUtil.CARRIAGE_RETURN, '\n')) {
            m35211L();
        }
    }

    /* renamed from: o */
    private boolean m35171o() throws ParseException, IOException {
        return m35218E(f23899D);
    }

    /* renamed from: o0 */
    private final void m35170o0(char[] cArr) throws ParseException, IOException {
        int length = cArr.length;
        if (this.f23934o - this.f23933n < length && m35193c(length) <= 0) {
            this.f23929j = -1;
            throw new ParseException(this, "end of XML file", cArr);
        }
        char[] cArr2 = this.f23932m;
        int i = this.f23934o;
        this.f23929j = cArr2[i - 1];
        if (i - this.f23933n >= length) {
            for (int i2 = 0; i2 < length; i2++) {
                if (this.f23932m[this.f23933n + i2] != cArr[i2]) {
                    throw new ParseException(this, new String(this.f23932m, this.f23933n, length), cArr);
                }
            }
            this.f23933n += length;
            return;
        }
        throw new ParseException(this, "end of XML file", cArr);
    }

    /* renamed from: p */
    private boolean m35169p() throws ParseException, IOException {
        return m35218E(f23913R);
    }

    /* renamed from: p0 */
    private final void m35168p0() throws ParseException, IOException {
        char m35211L = m35211L();
        while (m35215H() != m35211L) {
            m35211L();
        }
        m35208O(m35211L);
    }

    /* renamed from: q */
    private boolean m35167q() throws ParseException, IOException {
        return m35218E(f23901F);
    }

    /* renamed from: q0 */
    private void m35166q0() throws ParseException, IOException {
        m35172n0();
        m35170o0(f23902G);
        m35194b0();
        char m35210M = m35210M('\'', '\"');
        m35164r0();
        m35208O(m35210M);
    }

    /* renamed from: r */
    private boolean m35165r() throws ParseException, IOException {
        return m35218E(f23906K);
    }

    /* renamed from: r0 */
    private void m35164r0() throws ParseException, IOException {
        m35211L();
        while (m35217F()) {
            m35211L();
        }
    }

    /* renamed from: s */
    private final boolean m35163s() throws ParseException, IOException {
        return m35179k('\'', '\"');
    }

    /* renamed from: s0 */
    private void m35162s0() throws ParseException, EncodingMismatchException, IOException {
        m35170o0(f23900E);
        m35166q0();
        if (m35219D()) {
            m35172n0();
        }
        if (m35167q()) {
            String m35199X = m35199X();
            if (this.f23928i != null && !m35199X.toLowerCase().equals(this.f23928i)) {
                throw new EncodingMismatchException(this.f23922c, m35199X, this.f23928i);
            }
        }
        while (true) {
            char[] cArr = f23898C;
            if (!m35218E(cArr)) {
                m35211L();
            } else {
                m35170o0(cArr);
                return;
            }
        }
    }

    /* renamed from: t */
    private static boolean m35161t(char c) {
        if (c == 183 || c == 903 || c == 1600 || c == 3654 || c == 3782 || c == 12293 || c == 720 || c == 721 || c == 12445 || c == 12446) {
            return true;
        }
        switch (c) {
            case 12337:
            case 12338:
            case 12339:
            case 12340:
            case 12341:
                return true;
            default:
                switch (c) {
                    case 12540:
                    case 12541:
                    case 12542:
                        return true;
                    default:
                        return false;
                }
        }
    }

    /* renamed from: u */
    private boolean m35160u() throws ParseException, IOException {
        return m35218E(f23908M) || m35218E(f23909N);
    }

    /* renamed from: v */
    private static final boolean m35159v(char c, char[] cArr) {
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: w */
    private static boolean m35158w(char c) {
        return "abcdefghijklmnopqrstuvwxyz".indexOf(Character.toLowerCase(c)) != -1;
    }

    /* renamed from: x */
    private boolean m35157x() throws ParseException, IOException {
        return m35175m() || m35221B() || m35219D();
    }

    /* renamed from: y */
    private boolean m35156y() throws ParseException, IOException {
        char m35215H = m35215H();
        return m35215H < 128 ? f23920y[m35215H] : m35155z(m35215H);
    }

    /* renamed from: z */
    private static boolean m35155z(char c) {
        return Character.isDigit(c) || m35158w(c) || m35159v(c, f23918w) || m35161t(c);
    }

    @Override // com.p200hp.hpl.sparta.InterfaceC7048o
    /* renamed from: a */
    public String mo35144a() {
        return this.f23922c;
    }

    @Override // com.p200hp.hpl.sparta.InterfaceC7048o
    /* renamed from: d */
    public int mo35143d() {
        return this.f23937r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final String m35190e() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public int m35187g() {
        return this.f23929j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public ParseLog m35185h() {
        return this.f23927h;
    }

    @Override // com.p200hp.hpl.sparta.InterfaceC7048o
    public String toString() {
        return this.f23922c;
    }

    public ParseCharStream(String str, Reader reader, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        this(str, reader, null, parseLog, str2, parseHandler);
    }

    public ParseCharStream(String str, Reader reader, char[] cArr, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        this.f23923d = null;
        Hashtable hashtable = new Hashtable();
        this.f23925f = hashtable;
        this.f23926g = new Hashtable();
        this.f23929j = -2;
        this.f23930k = false;
        this.f23931l = 1024;
        this.f23933n = 0;
        this.f23934o = 0;
        this.f23935p = false;
        this.f23936q = new char[255];
        this.f23937r = 1;
        this.f23938s = null;
        parseLog = parseLog == null ? InterfaceC7048o.f23940a : parseLog;
        this.f23927h = parseLog;
        this.f23928i = str2 == null ? null : str2.toLowerCase();
        hashtable.put("lt", "<");
        hashtable.put("gt", ">");
        hashtable.put("amp", "&");
        hashtable.put("apos", "'");
        hashtable.put("quot", "\"");
        if (cArr != null) {
            this.f23932m = cArr;
            this.f23933n = 0;
            this.f23934o = cArr.length;
            this.f23935p = true;
            this.f23924e = null;
        } else {
            this.f23924e = reader;
            this.f23932m = new char[1024];
            m35195b();
        }
        this.f23922c = str;
        this.f23939t = parseHandler;
        parseHandler.mo35150h(this);
        m35178k0();
        parseHandler.mo35153c();
        Element m35201V = m35201V();
        String str3 = this.f23923d;
        if (str3 != null && !str3.equals(m35201V.m35263H())) {
            parseLog.mo35145c("DOCTYPE name \"" + this.f23923d + "\" not same as tag name, \"" + m35201V.m35263H() + "\" of root element", this.f23922c, mo35143d());
        }
        while (m35157x()) {
            m35189e0();
        }
        Reader reader2 = this.f23924e;
        if (reader2 != null) {
            reader2.close();
        }
        this.f23939t.mo35151g();
    }
}
