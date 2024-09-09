package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Response.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class g {

    /* renamed from: g  reason: collision with root package name */
    private static final int f50286g = 100;

    /* renamed from: h  reason: collision with root package name */
    public static final int f50287h = 3;

    /* renamed from: i  reason: collision with root package name */
    public static final int f50288i = 1;

    /* renamed from: j  reason: collision with root package name */
    public static final int f50289j = 2;

    /* renamed from: k  reason: collision with root package name */
    public static final int f50290k = 3;

    /* renamed from: l  reason: collision with root package name */
    public static final int f50291l = 28;

    /* renamed from: m  reason: collision with root package name */
    public static final int f50292m = 4;

    /* renamed from: n  reason: collision with root package name */
    public static final int f50293n = 8;

    /* renamed from: o  reason: collision with root package name */
    public static final int f50294o = 12;

    /* renamed from: p  reason: collision with root package name */
    public static final int f50295p = 16;

    /* renamed from: q  reason: collision with root package name */
    public static final int f50296q = 32;

    /* renamed from: a  reason: collision with root package name */
    protected int f50297a;

    /* renamed from: b  reason: collision with root package name */
    protected int f50298b;

    /* renamed from: c  reason: collision with root package name */
    protected int f50299c;

    /* renamed from: d  reason: collision with root package name */
    protected byte[] f50300d;

    /* renamed from: e  reason: collision with root package name */
    protected int f50301e;

    /* renamed from: f  reason: collision with root package name */
    protected String f50302f;

    public g(String str) {
        this.f50300d = null;
        this.f50301e = 0;
        this.f50302f = null;
        byte[] bytes = ASCIIUtility.getBytes(str);
        this.f50300d = bytes;
        this.f50299c = bytes.length;
        l();
    }

    public static g a(Exception exc) {
        g gVar = new g(("* BYE JavaMail Exception: " + exc.toString()).replace('\r', ' ').replace('\n', ' '));
        gVar.f50301e = gVar.f50301e | 32;
        return gVar;
    }

    private void l() {
        this.f50297a = 0;
        byte[] bArr = this.f50300d;
        if (bArr[0] == 43) {
            this.f50301e |= 1;
            this.f50297a = 0 + 1;
            return;
        }
        if (bArr[0] == 42) {
            this.f50301e |= 3;
            this.f50297a = 0 + 1;
        } else {
            this.f50301e |= 2;
            this.f50302f = o();
        }
        int i4 = this.f50297a;
        String o4 = o();
        if (o4 == null) {
            o4 = "";
        }
        if (o4.equalsIgnoreCase("OK")) {
            this.f50301e |= 4;
        } else if (o4.equalsIgnoreCase("NO")) {
            this.f50301e |= 8;
        } else if (o4.equalsIgnoreCase("BAD")) {
            this.f50301e |= 12;
        } else if (o4.equalsIgnoreCase("BYE")) {
            this.f50301e |= 16;
        } else {
            this.f50297a = i4;
        }
        this.f50298b = this.f50297a;
    }

    private Object m(boolean z3, boolean z4) {
        byte[] bArr;
        int i4;
        byte[] bArr2;
        int i5;
        B();
        byte[] bArr3 = this.f50300d;
        int i6 = this.f50297a;
        byte b4 = bArr3[i6];
        if (b4 == 34) {
            int i7 = i6 + 1;
            this.f50297a = i7;
            int i8 = i7;
            while (true) {
                bArr2 = this.f50300d;
                i5 = this.f50297a;
                byte b5 = bArr2[i5];
                if (b5 == 34) {
                    break;
                }
                if (b5 == 92) {
                    this.f50297a = i5 + 1;
                }
                int i9 = this.f50297a;
                if (i9 != i8) {
                    bArr2[i8] = bArr2[i9];
                }
                i8++;
                this.f50297a = i9 + 1;
            }
            this.f50297a = i5 + 1;
            if (z4) {
                return ASCIIUtility.toString(bArr2, i7, i8);
            }
            return new d(bArr2, i7, i8 - i7);
        } else if (b4 != 123) {
            if (z3) {
                return z4 ? o() : new d(this.f50300d, i6, this.f50297a);
            } else if (b4 == 78 || b4 == 110) {
                this.f50297a = i6 + 3;
                return null;
            } else {
                return null;
            }
        } else {
            int i10 = i6 + 1;
            this.f50297a = i10;
            while (true) {
                bArr = this.f50300d;
                i4 = this.f50297a;
                if (bArr[i4] == 125) {
                    try {
                        break;
                    } catch (NumberFormatException unused) {
                        return null;
                    }
                }
                this.f50297a = i4 + 1;
            }
            int parseInt = ASCIIUtility.parseInt(bArr, i10, i4);
            int i11 = this.f50297a + 3;
            int i12 = i11 + parseInt;
            this.f50297a = i12;
            if (z4) {
                return ASCIIUtility.toString(this.f50300d, i11, i12);
            }
            return new d(this.f50300d, i11, parseInt);
        }
    }

    public void A(int i4) {
        this.f50297a += i4;
    }

    public void B() {
        while (true) {
            int i4 = this.f50297a;
            if (i4 >= this.f50299c || this.f50300d[i4] != 32) {
                return;
            }
            this.f50297a = i4 + 1;
        }
    }

    public void C() {
        while (true) {
            int i4 = this.f50297a;
            if (i4 >= this.f50299c || this.f50300d[i4] == 32) {
                return;
            }
            this.f50297a = i4 + 1;
        }
    }

    public String b() {
        B();
        return ASCIIUtility.toString(this.f50300d, this.f50297a, this.f50299c);
    }

    public String c() {
        return this.f50302f;
    }

    public boolean d() {
        return (this.f50301e & 28) == 12;
    }

    public boolean e() {
        return (this.f50301e & 28) == 16;
    }

    public boolean f() {
        return (this.f50301e & 3) == 1;
    }

    public boolean g() {
        return (this.f50301e & 28) == 8;
    }

    public int getType() {
        return this.f50301e;
    }

    public boolean h() {
        return (this.f50301e & 28) == 4;
    }

    public boolean i() {
        return (this.f50301e & 32) == 32;
    }

    public boolean j() {
        return (this.f50301e & 3) == 2;
    }

    public boolean k() {
        return (this.f50301e & 3) == 3;
    }

    public byte n() {
        int i4 = this.f50297a;
        if (i4 < this.f50299c) {
            return this.f50300d[i4];
        }
        return (byte) 0;
    }

    public String o() {
        return p((char) 0);
    }

    public String p(char c4) {
        int i4;
        byte b4;
        B();
        int i5 = this.f50297a;
        if (i5 >= this.f50299c) {
            return null;
        }
        while (true) {
            i4 = this.f50297a;
            if (i4 >= this.f50299c || (b4 = this.f50300d[i4]) <= 32 || b4 == 40 || b4 == 41 || b4 == 37 || b4 == 42 || b4 == 34 || b4 == 92 || b4 == Byte.MAX_VALUE || (c4 != 0 && b4 == c4)) {
                break;
            }
            this.f50297a = i4 + 1;
        }
        return ASCIIUtility.toString(this.f50300d, i5, i4);
    }

    public String q() {
        return (String) m(true, true);
    }

    public byte r() {
        int i4 = this.f50297a;
        if (i4 < this.f50299c) {
            byte[] bArr = this.f50300d;
            this.f50297a = i4 + 1;
            return bArr[i4];
        }
        return (byte) 0;
    }

    public d s() {
        if (f()) {
            B();
            byte[] bArr = this.f50300d;
            int i4 = this.f50297a;
            return new d(bArr, i4, this.f50299c - i4);
        }
        return (d) m(false, false);
    }

    public ByteArrayInputStream t() {
        d s3 = s();
        if (s3 != null) {
            return s3.g();
        }
        return null;
    }

    public String toString() {
        return ASCIIUtility.toString(this.f50300d, 0, this.f50299c);
    }

    public long u() {
        B();
        int i4 = this.f50297a;
        while (true) {
            int i5 = this.f50297a;
            if (i5 >= this.f50299c || !Character.isDigit((char) this.f50300d[i5])) {
                break;
            }
            this.f50297a++;
        }
        int i6 = this.f50297a;
        if (i6 > i4) {
            try {
                return ASCIIUtility.parseLong(this.f50300d, i4, i6);
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }
        return -1L;
    }

    public int v() {
        B();
        int i4 = this.f50297a;
        while (true) {
            int i5 = this.f50297a;
            if (i5 >= this.f50299c || !Character.isDigit((char) this.f50300d[i5])) {
                break;
            }
            this.f50297a++;
        }
        int i6 = this.f50297a;
        if (i6 > i4) {
            try {
                return ASCIIUtility.parseInt(this.f50300d, i4, i6);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
        return -1;
    }

    public String w() {
        return (String) m(false, true);
    }

    public String x(char c4) {
        int i4;
        B();
        int i5 = this.f50297a;
        if (i5 >= this.f50299c) {
            return null;
        }
        while (true) {
            i4 = this.f50297a;
            if (i4 >= this.f50299c || this.f50300d[i4] == c4) {
                break;
            }
            this.f50297a = i4 + 1;
        }
        return ASCIIUtility.toString(this.f50300d, i5, i4);
    }

    public String[] y() {
        byte[] bArr;
        int i4;
        B();
        byte[] bArr2 = this.f50300d;
        int i5 = this.f50297a;
        if (bArr2[i5] != 40) {
            return null;
        }
        this.f50297a = i5 + 1;
        Vector vector = new Vector();
        do {
            vector.addElement(w());
            bArr = this.f50300d;
            i4 = this.f50297a;
            this.f50297a = i4 + 1;
        } while (bArr[i4] != 41);
        int size = vector.size();
        if (size > 0) {
            String[] strArr = new String[size];
            vector.copyInto(strArr);
            return strArr;
        }
        return null;
    }

    public void z() {
        this.f50297a = this.f50298b;
    }

    public g(f fVar) throws IOException, ProtocolException {
        this.f50300d = null;
        this.f50301e = 0;
        this.f50302f = null;
        d b4 = fVar.d().b(fVar.f());
        this.f50300d = b4.a();
        this.f50299c = b4.b() - 2;
        l();
    }

    public g(g gVar) {
        this.f50300d = null;
        this.f50301e = 0;
        this.f50302f = null;
        this.f50297a = gVar.f50297a;
        this.f50299c = gVar.f50299c;
        this.f50300d = gVar.f50300d;
        this.f50301e = gVar.f50301e;
        this.f50302f = gVar.f50302f;
    }
}
