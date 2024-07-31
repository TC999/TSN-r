package com.sun.mail.iap;

import com.baidu.mobads.sdk.internal.C2640by;
import com.sun.mail.util.ASCIIUtility;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.StringUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Vector;

/* compiled from: Response.java */
/* renamed from: com.sun.mail.iap.g */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12728g {

    /* renamed from: g */
    private static final int f35865g = 100;

    /* renamed from: h */
    public static final int f35866h = 3;

    /* renamed from: i */
    public static final int f35867i = 1;

    /* renamed from: j */
    public static final int f35868j = 2;

    /* renamed from: k */
    public static final int f35869k = 3;

    /* renamed from: l */
    public static final int f35870l = 28;

    /* renamed from: m */
    public static final int f35871m = 4;

    /* renamed from: n */
    public static final int f35872n = 8;

    /* renamed from: o */
    public static final int f35873o = 12;

    /* renamed from: p */
    public static final int f35874p = 16;

    /* renamed from: q */
    public static final int f35875q = 32;

    /* renamed from: a */
    protected int f35876a;

    /* renamed from: b */
    protected int f35877b;

    /* renamed from: c */
    protected int f35878c;

    /* renamed from: d */
    protected byte[] f35879d;

    /* renamed from: e */
    protected int f35880e;

    /* renamed from: f */
    protected String f35881f;

    public C12728g(String str) {
        this.f35879d = null;
        this.f35880e = 0;
        this.f35881f = null;
        byte[] bytes = ASCIIUtility.getBytes(str);
        this.f35879d = bytes;
        this.f35878c = bytes.length;
        m16395l();
    }

    /* renamed from: a */
    public static C12728g m16406a(Exception exc) {
        C12728g c12728g = new C12728g(("* BYE JavaMail Exception: " + exc.toString()).replace(StringUtil.CARRIAGE_RETURN, HttpConstants.SP_CHAR).replace('\n', HttpConstants.SP_CHAR));
        c12728g.f35880e = c12728g.f35880e | 32;
        return c12728g;
    }

    /* renamed from: l */
    private void m16395l() {
        this.f35876a = 0;
        byte[] bArr = this.f35879d;
        if (bArr[0] == 43) {
            this.f35880e |= 1;
            this.f35876a = 0 + 1;
            return;
        }
        if (bArr[0] == 42) {
            this.f35880e |= 3;
            this.f35876a = 0 + 1;
        } else {
            this.f35880e |= 2;
            this.f35881f = m16392o();
        }
        int i = this.f35876a;
        String m16392o = m16392o();
        if (m16392o == null) {
            m16392o = "";
        }
        if (m16392o.equalsIgnoreCase(C2640by.f8773k)) {
            this.f35880e |= 4;
        } else if (m16392o.equalsIgnoreCase("NO")) {
            this.f35880e |= 8;
        } else if (m16392o.equalsIgnoreCase("BAD")) {
            this.f35880e |= 12;
        } else if (m16392o.equalsIgnoreCase("BYE")) {
            this.f35880e |= 16;
        } else {
            this.f35876a = i;
        }
        this.f35877b = this.f35876a;
    }

    /* renamed from: m */
    private Object m16394m(boolean z, boolean z2) {
        byte[] bArr;
        int i;
        byte[] bArr2;
        int i2;
        m16408B();
        byte[] bArr3 = this.f35879d;
        int i3 = this.f35876a;
        byte b = bArr3[i3];
        if (b == 34) {
            int i4 = i3 + 1;
            this.f35876a = i4;
            int i5 = i4;
            while (true) {
                bArr2 = this.f35879d;
                i2 = this.f35876a;
                byte b2 = bArr2[i2];
                if (b2 == 34) {
                    break;
                }
                if (b2 == 92) {
                    this.f35876a = i2 + 1;
                }
                int i6 = this.f35876a;
                if (i6 != i5) {
                    bArr2[i5] = bArr2[i6];
                }
                i5++;
                this.f35876a = i6 + 1;
            }
            this.f35876a = i2 + 1;
            if (z2) {
                return ASCIIUtility.toString(bArr2, i4, i5);
            }
            return new ByteArray(bArr2, i4, i5 - i4);
        } else if (b != 123) {
            if (z) {
                return z2 ? m16392o() : new ByteArray(this.f35879d, i3, this.f35876a);
            } else if (b == 78 || b == 110) {
                this.f35876a = i3 + 3;
                return null;
            } else {
                return null;
            }
        } else {
            int i7 = i3 + 1;
            this.f35876a = i7;
            while (true) {
                bArr = this.f35879d;
                i = this.f35876a;
                if (bArr[i] == 125) {
                    try {
                        break;
                    } catch (NumberFormatException unused) {
                        return null;
                    }
                }
                this.f35876a = i + 1;
            }
            int parseInt = ASCIIUtility.parseInt(bArr, i7, i);
            int i8 = this.f35876a + 3;
            int i9 = i8 + parseInt;
            this.f35876a = i9;
            if (z2) {
                return ASCIIUtility.toString(this.f35879d, i8, i9);
            }
            return new ByteArray(this.f35879d, i8, parseInt);
        }
    }

    /* renamed from: A */
    public void m16409A(int i) {
        this.f35876a += i;
    }

    /* renamed from: B */
    public void m16408B() {
        while (true) {
            int i = this.f35876a;
            if (i >= this.f35878c || this.f35879d[i] != 32) {
                return;
            }
            this.f35876a = i + 1;
        }
    }

    /* renamed from: C */
    public void m16407C() {
        while (true) {
            int i = this.f35876a;
            if (i >= this.f35878c || this.f35879d[i] == 32) {
                return;
            }
            this.f35876a = i + 1;
        }
    }

    /* renamed from: b */
    public String m16405b() {
        m16408B();
        return ASCIIUtility.toString(this.f35879d, this.f35876a, this.f35878c);
    }

    /* renamed from: c */
    public String m16404c() {
        return this.f35881f;
    }

    /* renamed from: d */
    public boolean m16403d() {
        return (this.f35880e & 28) == 12;
    }

    /* renamed from: e */
    public boolean m16402e() {
        return (this.f35880e & 28) == 16;
    }

    /* renamed from: f */
    public boolean m16401f() {
        return (this.f35880e & 3) == 1;
    }

    /* renamed from: g */
    public boolean m16400g() {
        return (this.f35880e & 28) == 8;
    }

    public int getType() {
        return this.f35880e;
    }

    /* renamed from: h */
    public boolean m16399h() {
        return (this.f35880e & 28) == 4;
    }

    /* renamed from: i */
    public boolean m16398i() {
        return (this.f35880e & 32) == 32;
    }

    /* renamed from: j */
    public boolean m16397j() {
        return (this.f35880e & 3) == 2;
    }

    /* renamed from: k */
    public boolean m16396k() {
        return (this.f35880e & 3) == 3;
    }

    /* renamed from: n */
    public byte m16393n() {
        int i = this.f35876a;
        if (i < this.f35878c) {
            return this.f35879d[i];
        }
        return (byte) 0;
    }

    /* renamed from: o */
    public String m16392o() {
        return m16391p((char) 0);
    }

    /* renamed from: p */
    public String m16391p(char c) {
        int i;
        byte b;
        m16408B();
        int i2 = this.f35876a;
        if (i2 >= this.f35878c) {
            return null;
        }
        while (true) {
            i = this.f35876a;
            if (i >= this.f35878c || (b = this.f35879d[i]) <= 32 || b == 40 || b == 41 || b == 37 || b == 42 || b == 34 || b == 92 || b == Byte.MAX_VALUE || (c != 0 && b == c)) {
                break;
            }
            this.f35876a = i + 1;
        }
        return ASCIIUtility.toString(this.f35879d, i2, i);
    }

    /* renamed from: q */
    public String m16390q() {
        return (String) m16394m(true, true);
    }

    /* renamed from: r */
    public byte m16389r() {
        int i = this.f35876a;
        if (i < this.f35878c) {
            byte[] bArr = this.f35879d;
            this.f35876a = i + 1;
            return bArr[i];
        }
        return (byte) 0;
    }

    /* renamed from: s */
    public ByteArray m16388s() {
        if (m16401f()) {
            m16408B();
            byte[] bArr = this.f35879d;
            int i = this.f35876a;
            return new ByteArray(bArr, i, this.f35878c - i);
        }
        return (ByteArray) m16394m(false, false);
    }

    /* renamed from: t */
    public ByteArrayInputStream m16387t() {
        ByteArray m16388s = m16388s();
        if (m16388s != null) {
            return m16388s.m16422g();
        }
        return null;
    }

    public String toString() {
        return ASCIIUtility.toString(this.f35879d, 0, this.f35878c);
    }

    /* renamed from: u */
    public long m16386u() {
        m16408B();
        int i = this.f35876a;
        while (true) {
            int i2 = this.f35876a;
            if (i2 >= this.f35878c || !Character.isDigit((char) this.f35879d[i2])) {
                break;
            }
            this.f35876a++;
        }
        int i3 = this.f35876a;
        if (i3 > i) {
            try {
                return ASCIIUtility.parseLong(this.f35879d, i, i3);
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }
        return -1L;
    }

    /* renamed from: v */
    public int m16385v() {
        m16408B();
        int i = this.f35876a;
        while (true) {
            int i2 = this.f35876a;
            if (i2 >= this.f35878c || !Character.isDigit((char) this.f35879d[i2])) {
                break;
            }
            this.f35876a++;
        }
        int i3 = this.f35876a;
        if (i3 > i) {
            try {
                return ASCIIUtility.parseInt(this.f35879d, i, i3);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
        return -1;
    }

    /* renamed from: w */
    public String m16384w() {
        return (String) m16394m(false, true);
    }

    /* renamed from: x */
    public String m16383x(char c) {
        int i;
        m16408B();
        int i2 = this.f35876a;
        if (i2 >= this.f35878c) {
            return null;
        }
        while (true) {
            i = this.f35876a;
            if (i >= this.f35878c || this.f35879d[i] == c) {
                break;
            }
            this.f35876a = i + 1;
        }
        return ASCIIUtility.toString(this.f35879d, i2, i);
    }

    /* renamed from: y */
    public String[] m16382y() {
        byte[] bArr;
        int i;
        m16408B();
        byte[] bArr2 = this.f35879d;
        int i2 = this.f35876a;
        if (bArr2[i2] != 40) {
            return null;
        }
        this.f35876a = i2 + 1;
        Vector vector = new Vector();
        do {
            vector.addElement(m16384w());
            bArr = this.f35879d;
            i = this.f35876a;
            this.f35876a = i + 1;
        } while (bArr[i] != 41);
        int size = vector.size();
        if (size > 0) {
            String[] strArr = new String[size];
            vector.copyInto(strArr);
            return strArr;
        }
        return null;
    }

    /* renamed from: z */
    public void m16381z() {
        this.f35876a = this.f35877b;
    }

    public C12728g(C12727f c12727f) throws IOException, ProtocolException {
        this.f35879d = null;
        this.f35880e = 0;
        this.f35881f = null;
        ByteArray m16379b = c12727f.m16419d().m16379b(c12727f.mo16156f());
        this.f35879d = m16379b.m16428a();
        this.f35878c = m16379b.m16427b() - 2;
        m16395l();
    }

    public C12728g(C12728g c12728g) {
        this.f35879d = null;
        this.f35880e = 0;
        this.f35881f = null;
        this.f35876a = c12728g.f35876a;
        this.f35878c = c12728g.f35878c;
        this.f35879d = c12728g.f35879d;
        this.f35880e = c12728g.f35880e;
        this.f35881f = c12728g.f35881f;
    }
}
