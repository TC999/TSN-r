package com.hp.hpl.sparta;

import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: ParseCharStream.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
class l implements o {
    private static final char[] A;
    private static final char[] B;
    private static final char[] C;
    private static final char[] D;
    private static final char[] E;
    private static final char[] F;
    private static final char[] G;
    private static final char[] H;
    private static final char[] I;
    private static final char[] J;
    private static final char[] K;

    /* renamed from: L  reason: collision with root package name */
    private static final char[] f37398L;
    private static final char[] M;
    private static final char[] N;
    private static final char[] O;
    private static final char[] P;
    private static final char[] Q;
    private static final char[] R;
    private static final int S = 255;
    public static final int T = 100;

    /* renamed from: u  reason: collision with root package name */
    private static final boolean f37399u = true;

    /* renamed from: v  reason: collision with root package name */
    private static final boolean f37400v = false;

    /* renamed from: x  reason: collision with root package name */
    private static final int f37402x = 128;

    /* renamed from: z  reason: collision with root package name */
    private static final char[] f37404z;

    /* renamed from: c  reason: collision with root package name */
    private String f37405c;

    /* renamed from: d  reason: collision with root package name */
    private String f37406d;

    /* renamed from: e  reason: collision with root package name */
    private final Reader f37407e;

    /* renamed from: f  reason: collision with root package name */
    private final Hashtable f37408f;

    /* renamed from: g  reason: collision with root package name */
    private final Hashtable f37409g;

    /* renamed from: h  reason: collision with root package name */
    private final n f37410h;

    /* renamed from: i  reason: collision with root package name */
    private final String f37411i;

    /* renamed from: j  reason: collision with root package name */
    private int f37412j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f37413k;

    /* renamed from: l  reason: collision with root package name */
    private final int f37414l;

    /* renamed from: m  reason: collision with root package name */
    private final char[] f37415m;

    /* renamed from: n  reason: collision with root package name */
    private int f37416n;

    /* renamed from: o  reason: collision with root package name */
    private int f37417o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f37418p;

    /* renamed from: q  reason: collision with root package name */
    private final char[] f37419q;

    /* renamed from: r  reason: collision with root package name */
    private int f37420r;

    /* renamed from: s  reason: collision with root package name */
    private final b f37421s;

    /* renamed from: t  reason: collision with root package name */
    private final m f37422t;

    /* renamed from: w  reason: collision with root package name */
    private static final char[] f37401w = {'.', '-', '_', ':'};

    /* renamed from: y  reason: collision with root package name */
    private static final boolean[] f37403y = new boolean[128];

    static {
        for (char c4 = 0; c4 < '\u0080'; c4 = (char) (c4 + 1)) {
            f37403y[c4] = z(c4);
        }
        f37404z = "<!--".toCharArray();
        A = "-->".toCharArray();
        B = "<?".toCharArray();
        C = "?>".toCharArray();
        D = "<!DOCTYPE".toCharArray();
        E = "<?xml".toCharArray();
        F = "encoding".toCharArray();
        G = "version".toCharArray();
        H = new char[]{'_', '.', ':', '-'};
        I = "<!".toCharArray();
        J = "&#".toCharArray();
        K = "<!ENTITY".toCharArray();
        f37398L = "NDATA".toCharArray();
        M = "SYSTEM".toCharArray();
        N = "PUBLIC".toCharArray();
        O = "<![CDATA[".toCharArray();
        P = "]]>".toCharArray();
        Q = "/>".toCharArray();
        R = "</".toCharArray();
    }

    public l(String str, char[] cArr, n nVar, String str2, m mVar) throws ParseException, EncodingMismatchException, IOException {
        this(str, null, cArr, nVar, str2, mVar);
    }

    private boolean A() throws ParseException, IOException {
        return j('%');
    }

    private final boolean B() throws ParseException, IOException {
        return E(B);
    }

    private final boolean C() throws ParseException, IOException {
        return j('&');
    }

    private final boolean D() throws ParseException, IOException {
        return l(' ', '\t', '\r', '\n');
    }

    private final boolean E(char[] cArr) throws ParseException, IOException {
        int length = cArr.length;
        if (this.f37417o - this.f37416n < length && c(length) <= 0) {
            this.f37412j = -1;
            return false;
        }
        char[] cArr2 = this.f37415m;
        int i4 = this.f37417o;
        this.f37412j = cArr2[i4 - 1];
        if (i4 - this.f37416n < length) {
            return false;
        }
        for (int i5 = 0; i5 < length; i5++) {
            if (this.f37415m[this.f37416n + i5] != cArr[i5]) {
                return false;
            }
        }
        return true;
    }

    private boolean F() throws ParseException, IOException {
        char H2 = H();
        return Character.isDigit(H2) || ('a' <= H2 && H2 <= 'z') || (('Z' <= H2 && H2 <= 'Z') || v(H2, H));
    }

    private boolean G() throws ParseException, IOException {
        return E(E);
    }

    private final char H() throws ParseException, IOException {
        if (this.f37416n < this.f37417o || b() != -1) {
            return this.f37415m[this.f37416n];
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    private String I() throws ParseException, IOException {
        char M2 = M('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!j(M2)) {
            if (C()) {
                stringBuffer.append(m0());
            } else {
                stringBuffer.append(L());
            }
        }
        O(M2);
        return stringBuffer.toString();
    }

    private void J(g gVar) throws ParseException, IOException {
        String f02 = f0();
        b0();
        String I2 = I();
        if (gVar.D(f02) != null) {
            n nVar = this.f37410h;
            nVar.c("Element " + this + " contains attribute " + f02 + "more than once", this.f37405c, d());
        }
        gVar.O(f02, I2);
    }

    private void K() throws ParseException, IOException {
        char[] cArr;
        o0(O);
        StringBuffer stringBuffer = null;
        int i4 = 0;
        while (true) {
            cArr = P;
            if (E(cArr)) {
                break;
            }
            if (i4 >= 255) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(i4);
                    stringBuffer.append(this.f37419q, 0, i4);
                } else {
                    stringBuffer.append(this.f37419q, 0, i4);
                }
                i4 = 0;
            }
            this.f37419q[i4] = L();
            i4++;
        }
        o0(cArr);
        if (stringBuffer != null) {
            stringBuffer.append(this.f37419q, 0, i4);
            char[] charArray = stringBuffer.toString().toCharArray();
            this.f37422t.i(charArray, 0, charArray.length);
            return;
        }
        this.f37422t.i(this.f37419q, 0, i4);
    }

    private final char L() throws ParseException, IOException {
        if (this.f37416n < this.f37417o || b() != -1) {
            char[] cArr = this.f37415m;
            int i4 = this.f37416n;
            if (cArr[i4] == '\n') {
                this.f37420r++;
            }
            this.f37416n = i4 + 1;
            return cArr[i4];
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    private final char M(char c4, char c5) throws ParseException, IOException {
        char L2 = L();
        if (L2 == c4 || L2 == c5) {
            return L2;
        }
        throw new ParseException(this, L2, new char[]{c4, c5});
    }

    private final char N(char c4, char c5, char c6, char c7) throws ParseException, IOException {
        char L2 = L();
        if (L2 == c4 || L2 == c5 || L2 == c6 || L2 == c7) {
            return L2;
        }
        throw new ParseException(this, L2, new char[]{c4, c5, c6, c7});
    }

    private final void O(char c4) throws ParseException, IOException {
        char L2 = L();
        if (L2 != c4) {
            throw new ParseException(this, L2, c4);
        }
    }

    private char P() throws ParseException, IOException {
        int i4;
        o0(J);
        if (j('x')) {
            L();
            i4 = 16;
        } else {
            i4 = 10;
        }
        int i5 = 0;
        while (!j(';')) {
            int i6 = i5 + 1;
            this.f37419q[i5] = L();
            if (i6 >= 255) {
                this.f37410h.c("Tmp buffer overflow on readCharRef", this.f37405c, d());
                return ' ';
            }
            i5 = i6;
        }
        O(';');
        String str = new String(this.f37419q, 0, i5);
        try {
            return (char) Integer.parseInt(str, i4);
        } catch (NumberFormatException unused) {
            n nVar = this.f37410h;
            StringBuilder sb = new StringBuilder();
            sb.append("\"");
            sb.append(str);
            sb.append("\" is not a valid ");
            sb.append(i4 == 16 ? "hexadecimal" : "decimal");
            sb.append(" number");
            nVar.c(sb.toString(), this.f37405c, d());
            return ' ';
        }
    }

    private final void Q() throws ParseException, IOException {
        o0(f37404z);
        while (true) {
            char[] cArr = A;
            if (!E(cArr)) {
                L();
            } else {
                o0(cArr);
                return;
            }
        }
    }

    private void R() throws ParseException, IOException {
        j0();
        boolean z3 = true;
        while (z3) {
            if (!p()) {
                if (C()) {
                    char[] m02 = m0();
                    this.f37422t.i(m02, 0, m02.length);
                } else if (i()) {
                    K();
                } else if (B()) {
                    i0();
                } else if (m()) {
                    Q();
                } else if (j('<')) {
                    V();
                }
                j0();
            }
            z3 = false;
            j0();
        }
    }

    private void S() throws ParseException, IOException {
        if (A()) {
            h0();
        } else {
            n0();
        }
    }

    private void T() throws ParseException, IOException {
        o0(D);
        n0();
        this.f37406d = f0();
        if (D()) {
            n0();
            if (!j('>') && !j('[')) {
                this.f37413k = true;
                c0();
                if (D()) {
                    n0();
                }
            }
        }
        if (j('[')) {
            L();
            while (!j(']')) {
                if (n()) {
                    S();
                } else {
                    d0();
                }
            }
            O(']');
            if (D()) {
                n0();
            }
        }
        O('>');
    }

    private void U(g gVar) throws ParseException, IOException {
        o0(R);
        String f02 = f0();
        if (!f02.equals(gVar.H())) {
            n nVar = this.f37410h;
            nVar.c("end tag (" + f02 + ") does not match begin tag (" + gVar.H() + ")", this.f37405c, d());
        }
        if (D()) {
            n0();
        }
        O('>');
    }

    private final g V() throws ParseException, IOException {
        g gVar = new g();
        boolean W = W(gVar);
        this.f37422t.j(gVar);
        if (W) {
            R();
            U(gVar);
        }
        this.f37422t.e(gVar);
        return gVar;
    }

    private boolean W(g gVar) throws ParseException, IOException {
        O('<');
        gVar.P(f0());
        while (D()) {
            n0();
            if (!k('/', '>')) {
                J(gVar);
            }
        }
        if (D()) {
            n0();
        }
        boolean j4 = j('>');
        if (j4) {
            O('>');
        } else {
            o0(Q);
        }
        return j4;
    }

    private String X() throws ParseException, IOException {
        o0(F);
        b0();
        char M2 = M('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!j(M2)) {
            stringBuffer.append(L());
        }
        O(M2);
        return stringBuffer.toString();
    }

    private void Y() throws ParseException, IOException {
        String c02;
        String c03;
        o0(K);
        n0();
        if (j('%')) {
            O('%');
            n0();
            String f02 = f0();
            n0();
            if (s()) {
                c03 = a0();
            } else {
                c03 = c0();
            }
            this.f37409g.put(f02, c03);
        } else {
            String f03 = f0();
            n0();
            if (s()) {
                c02 = a0();
            } else if (u()) {
                c02 = c0();
                if (D()) {
                    n0();
                }
                char[] cArr = f37398L;
                if (E(cArr)) {
                    o0(cArr);
                    n0();
                    f0();
                }
            } else {
                throw new ParseException(this, "expecting double-quote, \"PUBLIC\" or \"SYSTEM\" while reading entity declaration");
            }
            this.f37408f.put(f03, c02);
        }
        if (D()) {
            n0();
        }
        O('>');
    }

    private String Z() throws ParseException, IOException {
        O('&');
        String f02 = f0();
        String str = (String) this.f37408f.get(f02);
        if (str == null) {
            if (this.f37413k) {
                n nVar = this.f37410h;
                nVar.c("&" + f02 + "; not found -- possibly defined in external DTD)", this.f37405c, d());
            } else {
                n nVar2 = this.f37410h;
                nVar2.c("No declaration of &" + f02 + ";", this.f37405c, d());
            }
            str = "";
        }
        O(';');
        return str;
    }

    private final String a0() throws ParseException, IOException {
        char M2 = M('\'', '\"');
        StringBuffer stringBuffer = new StringBuffer();
        while (!j(M2)) {
            if (A()) {
                stringBuffer.append(h0());
            } else if (C()) {
                stringBuffer.append(m0());
            } else {
                stringBuffer.append(L());
            }
        }
        O(M2);
        return stringBuffer.toString();
    }

    private int b() throws IOException {
        if (this.f37418p) {
            return -1;
        }
        int i4 = this.f37417o;
        char[] cArr = this.f37415m;
        if (i4 == cArr.length) {
            this.f37417o = 0;
            this.f37416n = 0;
        }
        Reader reader = this.f37407e;
        int i5 = this.f37417o;
        int read = reader.read(cArr, i5, cArr.length - i5);
        if (read <= 0) {
            this.f37418p = true;
            return -1;
        }
        this.f37417o += read;
        return read;
    }

    private final void b0() throws ParseException, IOException {
        if (D()) {
            n0();
        }
        O('=');
        if (D()) {
            n0();
        }
    }

    private int c(int i4) throws IOException {
        int i5;
        int i6;
        if (this.f37418p) {
            return -1;
        }
        int i7 = 0;
        if (this.f37415m.length - this.f37416n < i4) {
            int i8 = 0;
            while (true) {
                i5 = this.f37416n;
                int i9 = i5 + i8;
                i6 = this.f37417o;
                if (i9 >= i6) {
                    break;
                }
                char[] cArr = this.f37415m;
                cArr[i8] = cArr[i5 + i8];
                i8++;
            }
            int i10 = i6 - i5;
            this.f37417o = i10;
            this.f37416n = 0;
            i7 = i10;
        }
        int b4 = b();
        if (b4 == -1) {
            if (i7 == 0) {
                return -1;
            }
            return i7;
        }
        return i7 + b4;
    }

    private String c0() throws ParseException, IOException {
        char[] cArr = M;
        if (E(cArr)) {
            o0(cArr);
        } else {
            char[] cArr2 = N;
            if (E(cArr2)) {
                o0(cArr2);
                n0();
                l0();
            } else {
                throw new ParseException(this, "expecting \"SYSTEM\" or \"PUBLIC\" while reading external ID");
            }
        }
        n0();
        p0();
        return "(WARNING: external ID not read)";
    }

    private void d0() throws ParseException, IOException {
        if (B()) {
            i0();
        } else if (m()) {
            Q();
        } else if (r()) {
            Y();
        } else if (E(I)) {
            while (!j('>')) {
                if (k('\'', '\"')) {
                    char L2 = L();
                    while (!j(L2)) {
                        L();
                    }
                    O(L2);
                } else {
                    L();
                }
            }
            O('>');
        } else {
            throw new ParseException(this, "expecting processing instruction, comment, or \"<!\"");
        }
    }

    private void e0() throws ParseException, IOException {
        if (m()) {
            Q();
        } else if (B()) {
            i0();
        } else if (D()) {
            n0();
        } else {
            throw new ParseException(this, "expecting comment or processing instruction or space");
        }
    }

    private final String f0() throws ParseException, IOException {
        this.f37419q[0] = g0();
        int i4 = 1;
        StringBuffer stringBuffer = null;
        while (y()) {
            if (i4 >= 255) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(i4);
                    stringBuffer.append(this.f37419q, 0, i4);
                } else {
                    stringBuffer.append(this.f37419q, 0, i4);
                }
                i4 = 0;
            }
            this.f37419q[i4] = L();
            i4++;
        }
        if (stringBuffer == null) {
            return q.a(new String(this.f37419q, 0, i4));
        }
        stringBuffer.append(this.f37419q, 0, i4);
        return stringBuffer.toString();
    }

    private char g0() throws ParseException, IOException {
        char L2 = L();
        if (w(L2) || L2 == '_' || L2 == ':') {
            return L2;
        }
        throw new ParseException(this, L2, "letter, underscore, colon");
    }

    private String h0() throws ParseException, IOException {
        O('%');
        String f02 = f0();
        String str = (String) this.f37409g.get(f02);
        if (str == null) {
            n nVar = this.f37410h;
            nVar.c("No declaration of %" + f02 + ";", this.f37405c, d());
            str = "";
        }
        O(';');
        return str;
    }

    private boolean i() throws ParseException, IOException {
        return E(O);
    }

    private final void i0() throws ParseException, IOException {
        o0(B);
        while (true) {
            char[] cArr = C;
            if (!E(cArr)) {
                L();
            } else {
                o0(cArr);
                return;
            }
        }
    }

    private final boolean j(char c4) throws ParseException, IOException {
        if (this.f37416n < this.f37417o || b() != -1) {
            return this.f37415m[this.f37416n] == c4;
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
        r4.f37422t.i(r4.f37419q, 0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j0() throws com.hp.hpl.sparta.ParseException, java.io.IOException {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            r2 = 60
            boolean r2 = r4.j(r2)
            if (r2 != 0) goto L48
            r2 = 38
            boolean r2 = r4.j(r2)
            if (r2 != 0) goto L48
            char[] r2 = com.hp.hpl.sparta.l.P
            boolean r2 = r4.E(r2)
            if (r2 != 0) goto L48
            char[] r2 = r4.f37419q
            char r3 = r4.L()
            r2[r1] = r3
            char[] r2 = r4.f37419q
            char r2 = r2[r1]
            r3 = 13
            if (r2 != r3) goto L3a
            char r2 = r4.H()
            r3 = 10
            if (r2 != r3) goto L3a
            char[] r2 = r4.f37419q
            char r3 = r4.L()
            r2[r1] = r3
        L3a:
            int r1 = r1 + 1
            r2 = 255(0xff, float:3.57E-43)
            if (r1 != r2) goto L2
            com.hp.hpl.sparta.m r1 = r4.f37422t
            char[] r3 = r4.f37419q
            r1.i(r3, r0, r2)
            goto L1
        L48:
            if (r1 <= 0) goto L51
            com.hp.hpl.sparta.m r2 = r4.f37422t
            char[] r3 = r4.f37419q
            r2.i(r3, r0, r1)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hp.hpl.sparta.l.j0():void");
    }

    private final boolean k(char c4, char c5) throws ParseException, IOException {
        if (this.f37416n < this.f37417o || b() != -1) {
            char c6 = this.f37415m[this.f37416n];
            return c6 == c4 || c6 == c5;
        }
        return false;
    }

    private void k0() throws ParseException, EncodingMismatchException, IOException {
        if (G()) {
            s0();
        }
        while (x()) {
            e0();
        }
        if (o()) {
            T();
            while (x()) {
                e0();
            }
        }
    }

    private final boolean l(char c4, char c5, char c6, char c7) throws ParseException, IOException {
        if (this.f37416n < this.f37417o || b() != -1) {
            char c8 = this.f37415m[this.f37416n];
            return c8 == c4 || c8 == c5 || c8 == c6 || c8 == c7;
        }
        return false;
    }

    private final void l0() throws ParseException, IOException {
        p0();
    }

    private final boolean m() throws ParseException, IOException {
        return E(f37404z);
    }

    private final char[] m0() throws ParseException, IOException {
        return E(J) ? new char[]{P()} : Z().toCharArray();
    }

    private boolean n() throws ParseException, IOException {
        return A() || D();
    }

    private final void n0() throws ParseException, IOException {
        N(' ', '\t', '\r', '\n');
        while (l(' ', '\t', '\r', '\n')) {
            L();
        }
    }

    private boolean o() throws ParseException, IOException {
        return E(D);
    }

    private final void o0(char[] cArr) throws ParseException, IOException {
        int length = cArr.length;
        if (this.f37417o - this.f37416n < length && c(length) <= 0) {
            this.f37412j = -1;
            throw new ParseException(this, "end of XML file", cArr);
        }
        char[] cArr2 = this.f37415m;
        int i4 = this.f37417o;
        this.f37412j = cArr2[i4 - 1];
        if (i4 - this.f37416n >= length) {
            for (int i5 = 0; i5 < length; i5++) {
                if (this.f37415m[this.f37416n + i5] != cArr[i5]) {
                    throw new ParseException(this, new String(this.f37415m, this.f37416n, length), cArr);
                }
            }
            this.f37416n += length;
            return;
        }
        throw new ParseException(this, "end of XML file", cArr);
    }

    private boolean p() throws ParseException, IOException {
        return E(R);
    }

    private final void p0() throws ParseException, IOException {
        char L2 = L();
        while (H() != L2) {
            L();
        }
        O(L2);
    }

    private boolean q() throws ParseException, IOException {
        return E(F);
    }

    private void q0() throws ParseException, IOException {
        n0();
        o0(G);
        b0();
        char M2 = M('\'', '\"');
        r0();
        O(M2);
    }

    private boolean r() throws ParseException, IOException {
        return E(K);
    }

    private void r0() throws ParseException, IOException {
        L();
        while (F()) {
            L();
        }
    }

    private final boolean s() throws ParseException, IOException {
        return k('\'', '\"');
    }

    private void s0() throws ParseException, EncodingMismatchException, IOException {
        o0(E);
        q0();
        if (D()) {
            n0();
        }
        if (q()) {
            String X = X();
            if (this.f37411i != null && !X.toLowerCase().equals(this.f37411i)) {
                throw new EncodingMismatchException(this.f37405c, X, this.f37411i);
            }
        }
        while (true) {
            char[] cArr = C;
            if (!E(cArr)) {
                L();
            } else {
                o0(cArr);
                return;
            }
        }
    }

    private static boolean t(char c4) {
        if (c4 == '\u00b7' || c4 == '\u0387' || c4 == '\u0640' || c4 == '\u0e46' || c4 == '\u0ec6' || c4 == '\u3005' || c4 == '\u02d0' || c4 == '\u02d1' || c4 == '\u309d' || c4 == '\u309e') {
            return true;
        }
        switch (c4) {
            case '\u3031':
            case '\u3032':
            case '\u3033':
            case '\u3034':
            case '\u3035':
                return true;
            default:
                switch (c4) {
                    case '\u30fc':
                    case '\u30fd':
                    case '\u30fe':
                        return true;
                    default:
                        return false;
                }
        }
    }

    private boolean u() throws ParseException, IOException {
        return E(M) || E(N);
    }

    private static final boolean v(char c4, char[] cArr) {
        for (char c5 : cArr) {
            if (c4 == c5) {
                return true;
            }
        }
        return false;
    }

    private static boolean w(char c4) {
        return "abcdefghijklmnopqrstuvwxyz".indexOf(Character.toLowerCase(c4)) != -1;
    }

    private boolean x() throws ParseException, IOException {
        return m() || B() || D();
    }

    private boolean y() throws ParseException, IOException {
        char H2 = H();
        return H2 < '\u0080' ? f37403y[H2] : z(H2);
    }

    private static boolean z(char c4) {
        return Character.isDigit(c4) || w(c4) || v(c4, f37401w) || t(c4);
    }

    @Override // com.hp.hpl.sparta.o
    public String a() {
        return this.f37405c;
    }

    @Override // com.hp.hpl.sparta.o
    public int d() {
        return this.f37420r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String e() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f37412j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n h() {
        return this.f37410h;
    }

    @Override // com.hp.hpl.sparta.o
    public String toString() {
        return this.f37405c;
    }

    public l(String str, Reader reader, n nVar, String str2, m mVar) throws ParseException, EncodingMismatchException, IOException {
        this(str, reader, null, nVar, str2, mVar);
    }

    public l(String str, Reader reader, char[] cArr, n nVar, String str2, m mVar) throws ParseException, EncodingMismatchException, IOException {
        this.f37406d = null;
        Hashtable hashtable = new Hashtable();
        this.f37408f = hashtable;
        this.f37409g = new Hashtable();
        this.f37412j = -2;
        this.f37413k = false;
        this.f37414l = 1024;
        this.f37416n = 0;
        this.f37417o = 0;
        this.f37418p = false;
        this.f37419q = new char[255];
        this.f37420r = 1;
        this.f37421s = null;
        nVar = nVar == null ? o.f37423a : nVar;
        this.f37410h = nVar;
        this.f37411i = str2 == null ? null : str2.toLowerCase();
        hashtable.put("lt", "<");
        hashtable.put("gt", ">");
        hashtable.put("amp", "&");
        hashtable.put("apos", "'");
        hashtable.put("quot", "\"");
        if (cArr != null) {
            this.f37415m = cArr;
            this.f37416n = 0;
            this.f37417o = cArr.length;
            this.f37418p = true;
            this.f37407e = null;
        } else {
            this.f37407e = reader;
            this.f37415m = new char[1024];
            b();
        }
        this.f37405c = str;
        this.f37422t = mVar;
        mVar.h(this);
        k0();
        mVar.c();
        g V = V();
        String str3 = this.f37406d;
        if (str3 != null && !str3.equals(V.H())) {
            nVar.c("DOCTYPE name \"" + this.f37406d + "\" not same as tag name, \"" + V.H() + "\" of root element", this.f37405c, d());
        }
        while (x()) {
            e0();
        }
        Reader reader2 = this.f37407e;
        if (reader2 != null) {
            reader2.close();
        }
        this.f37422t.g();
    }
}
