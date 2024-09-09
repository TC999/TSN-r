package cn.jiguang.bw;

import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g implements Serializable, Comparable {

    /* renamed from: a  reason: collision with root package name */
    public static final g f3042a;

    /* renamed from: b  reason: collision with root package name */
    public static final g f3043b;

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f3044f = {0};

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f3045g = {1, 42};

    /* renamed from: h  reason: collision with root package name */
    private static final DecimalFormat f3046h;

    /* renamed from: i  reason: collision with root package name */
    private static final byte[] f3047i;

    /* renamed from: j  reason: collision with root package name */
    private static final g f3048j;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f3049c;

    /* renamed from: d  reason: collision with root package name */
    private long f3050d;

    /* renamed from: e  reason: collision with root package name */
    private int f3051e;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        f3046h = decimalFormat;
        f3047i = new byte[256];
        decimalFormat.setMinimumIntegerDigits(3);
        int i4 = 0;
        while (true) {
            byte[] bArr = f3047i;
            if (i4 >= bArr.length) {
                g gVar = new g();
                f3042a = gVar;
                gVar.b(f3044f, 0, 1);
                g gVar2 = new g();
                f3043b = gVar2;
                gVar2.f3049c = new byte[0];
                g gVar3 = new g();
                f3048j = gVar3;
                gVar3.b(f3045g, 0, 1);
                return;
            }
            if (i4 < 65 || i4 > 90) {
                bArr[i4] = (byte) i4;
            } else {
                bArr[i4] = (byte) ((i4 - 65) + 97);
            }
            i4++;
        }
    }

    private g() {
    }

    public g(b bVar) {
        byte[] bArr = new byte[64];
        boolean z3 = false;
        boolean z4 = false;
        while (!z3) {
            int f4 = bVar.f();
            int i4 = f4 & 192;
            if (i4 != 0) {
                if (i4 != 192) {
                    throw new IOException("bad label type");
                }
                int f5 = bVar.f() + ((f4 & (-193)) << 8);
                if (f5 >= bVar.a() - 2) {
                    throw new IOException("bad compression");
                }
                if (!z4) {
                    bVar.d();
                    z4 = true;
                }
                bVar.b(f5);
            } else if (d() >= 128) {
                throw new IOException("too many labels");
            } else {
                if (f4 == 0) {
                    a(f3044f, 0, 1);
                    z3 = true;
                } else {
                    bArr[0] = (byte) f4;
                    bVar.a(bArr, 1, f4);
                    a(bArr, 0, 1);
                }
            }
        }
        if (z4) {
            bVar.e();
        }
    }

    public g(g gVar, int i4) {
        int b4 = gVar.b();
        if (i4 > b4) {
            throw new IllegalArgumentException("attempted to remove too many labels");
        }
        this.f3049c = gVar.f3049c;
        int i5 = b4 - i4;
        b(i5);
        for (int i6 = 0; i6 < 7 && i6 < i5; i6++) {
            a(i6, gVar.a(i6 + i4));
        }
    }

    public g(String str, g gVar) {
        int i4;
        boolean z3;
        int i5;
        if (str.equals("")) {
            throw a(str, "empty name");
        }
        if (str.equals("@")) {
            if (gVar == null) {
                b(f3043b, this);
            } else {
                b(gVar, this);
            }
        } else if (str.equals(".")) {
            b(f3042a, this);
        } else {
            byte[] bArr = new byte[64];
            int i6 = 0;
            boolean z4 = false;
            int i7 = -1;
            int i8 = 1;
            int i9 = 0;
            for (int i10 = 0; i10 < str.length(); i10++) {
                byte charAt = (byte) str.charAt(i10);
                if (z4) {
                    if (charAt >= 48 && charAt <= 57 && i6 < 3) {
                        i6++;
                        i9 = (i9 * 10) + (charAt - 48);
                        if (i9 > 255) {
                            throw a(str, "bad escape");
                        }
                        if (i6 < 3) {
                            continue;
                        } else {
                            charAt = (byte) i9;
                        }
                    } else if (i6 > 0 && i6 < 3) {
                        throw a(str, "bad escape");
                    }
                    if (i8 > 63) {
                        throw a(str, "label too long");
                    }
                    i5 = i8 + 1;
                    bArr[i8] = charAt;
                    i7 = i8;
                    z4 = false;
                    i8 = i5;
                } else {
                    if (charAt == 92) {
                        i6 = 0;
                        z4 = true;
                        i9 = 0;
                    } else if (charAt != 46) {
                        i7 = i7 == -1 ? i10 : i7;
                        if (i8 > 63) {
                            throw a(str, "label too long");
                        }
                        i5 = i8 + 1;
                        bArr[i8] = charAt;
                        i8 = i5;
                    } else if (i7 == -1) {
                        throw a(str, "invalid empty label");
                    } else {
                        bArr[0] = (byte) (i8 - 1);
                        a(str, bArr, 0, 1);
                        i7 = -1;
                        i8 = 1;
                    }
                }
            }
            if (i6 > 0 && i6 < 3) {
                throw a(str, "bad escape");
            }
            if (z4) {
                throw a(str, "bad escape");
            }
            if (i7 == -1) {
                z3 = true;
                i4 = 0;
                a(str, f3044f, 0, 1);
            } else {
                i4 = 0;
                bArr[0] = (byte) (i8 - 1);
                a(str, bArr, 0, 1);
                z3 = false;
            }
            if (gVar == null || z3) {
                return;
            }
            a(str, gVar.f3049c, gVar.a(i4), gVar.d());
        }
    }

    private final int a(int i4) {
        if (i4 == 0 && d() == 0) {
            return 0;
        }
        if (i4 < 0 || i4 >= d()) {
            throw new IllegalArgumentException("label out of range");
        }
        if (i4 < 7) {
            return ((int) (this.f3050d >>> ((7 - i4) * 8))) & 255;
        }
        int a4 = a(6);
        for (int i5 = 6; i5 < i4; i5++) {
            a4 += this.f3049c[a4] + 1;
        }
        return a4;
    }

    public static g a(g gVar, g gVar2) {
        if (gVar.a()) {
            return gVar;
        }
        g gVar3 = new g();
        b(gVar, gVar3);
        gVar3.a(gVar2.f3049c, gVar2.a(0), gVar2.d());
        return gVar3;
    }

    public static g a(String str) {
        return a(str, (g) null);
    }

    public static g a(String str, g gVar) {
        return (!str.equals("@") || gVar == null) ? str.equals(".") ? f3042a : new g(str, gVar) : gVar;
    }

    private static IOException a(String str, String str2) {
        return new IOException("'" + str + "': " + str2);
    }

    private String a(byte[] bArr, int i4) {
        StringBuffer stringBuffer = new StringBuffer();
        int i5 = i4 + 1;
        int i6 = bArr[i4];
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            int i8 = bArr[i7] & 255;
            if (i8 <= 32 || i8 >= 127) {
                stringBuffer.append('\\');
                stringBuffer.append(f3046h.format(i8));
            } else {
                if (i8 == 34 || i8 == 40 || i8 == 41 || i8 == 46 || i8 == 59 || i8 == 92 || i8 == 64 || i8 == 36) {
                    stringBuffer.append('\\');
                }
                stringBuffer.append((char) i8);
            }
        }
        return stringBuffer.toString();
    }

    private final void a(int i4, int i5) {
        if (i4 >= 7) {
            return;
        }
        int i6 = (7 - i4) * 8;
        this.f3050d = (i5 << i6) | (this.f3050d & ((255 << i6) ^ (-1)));
    }

    private final void a(String str, byte[] bArr, int i4, int i5) {
        try {
            a(bArr, i4, i5);
        } catch (Exception unused) {
            throw a(str, "Name too long");
        }
    }

    private final void a(byte[] bArr, int i4, int i5) {
        byte[] bArr2 = this.f3049c;
        int length = bArr2 == null ? 0 : bArr2.length - a(0);
        int i6 = i4;
        int i7 = 0;
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = bArr[i6];
            if (i9 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i10 = i9 + 1;
            i6 += i10;
            i7 += i10;
        }
        int i11 = length + i7;
        if (i11 > 255) {
            throw new IOException();
        }
        int d4 = d();
        int i12 = d4 + i5;
        if (i12 > 128) {
            throw new IllegalStateException("too many labels");
        }
        byte[] bArr3 = new byte[i11];
        if (length != 0) {
            System.arraycopy(this.f3049c, a(0), bArr3, 0, length);
        }
        System.arraycopy(bArr, i4, bArr3, length, i7);
        this.f3049c = bArr3;
        for (int i13 = 0; i13 < i5; i13++) {
            a(d4 + i13, length);
            length += bArr3[length] + 1;
        }
        b(i12);
    }

    private final void b(int i4) {
        this.f3050d = (this.f3050d & (-256)) | i4;
    }

    private static final void b(g gVar, g gVar2) {
        if (gVar.a(0) == 0) {
            gVar2.f3049c = gVar.f3049c;
            gVar2.f3050d = gVar.f3050d;
            return;
        }
        int a4 = gVar.a(0);
        int length = gVar.f3049c.length - a4;
        int b4 = gVar.b();
        byte[] bArr = new byte[length];
        gVar2.f3049c = bArr;
        System.arraycopy(gVar.f3049c, a4, bArr, 0, length);
        for (int i4 = 0; i4 < b4 && i4 < 7; i4++) {
            gVar2.a(i4, gVar.a(i4) - a4);
        }
        gVar2.b(b4);
    }

    private final void b(byte[] bArr, int i4, int i5) {
        try {
            a(bArr, i4, i5);
        } catch (Exception unused) {
        }
    }

    private final boolean b(byte[] bArr, int i4) {
        int b4 = b();
        int a4 = a(0);
        int i5 = 0;
        while (i5 < b4) {
            byte[] bArr2 = this.f3049c;
            if (bArr2[a4] != bArr[i4]) {
                return false;
            }
            int i6 = a4 + 1;
            byte b5 = bArr2[a4];
            i4++;
            if (b5 > 63) {
                throw new IllegalStateException("invalid label");
            }
            int i7 = 0;
            while (i7 < b5) {
                byte[] bArr3 = f3047i;
                int i8 = i6 + 1;
                int i9 = i4 + 1;
                if (bArr3[this.f3049c[i6] & 255] != bArr3[bArr[i4] & 255]) {
                    return false;
                }
                i7++;
                i4 = i9;
                i6 = i8;
            }
            i5++;
            a4 = i6;
        }
        return true;
    }

    private final int d() {
        return (int) (this.f3050d & 255);
    }

    public String a(boolean z3) {
        int b4 = b();
        if (b4 == 0) {
            return "@";
        }
        int i4 = 0;
        if (b4 == 1 && this.f3049c[a(0)] == 0) {
            return ".";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int a4 = a(0);
        while (true) {
            if (i4 >= b4) {
                break;
            }
            byte b5 = this.f3049c[a4];
            if (b5 > 63) {
                throw new IllegalStateException("invalid label");
            }
            if (b5 != 0) {
                if (i4 > 0) {
                    stringBuffer.append('.');
                }
                stringBuffer.append(a(this.f3049c, a4));
                a4 += b5 + 1;
                i4++;
            } else if (!z3) {
                stringBuffer.append('.');
            }
        }
        return stringBuffer.toString();
    }

    public void a(c cVar) {
        cVar.a(c());
    }

    public void a(c cVar, a aVar) {
        int b4 = b();
        int i4 = 0;
        while (i4 < b4 - 1) {
            g gVar = i4 == 0 ? this : new g(this, i4);
            int a4 = aVar != null ? aVar.a(gVar) : -1;
            if (a4 >= 0) {
                cVar.c(49152 | a4);
                return;
            }
            if (aVar != null) {
                aVar.a(cVar.a(), gVar);
            }
            int a5 = a(i4);
            byte[] bArr = this.f3049c;
            cVar.a(bArr, a5, bArr[a5] + 1);
            i4++;
        }
        cVar.b(0);
    }

    public void a(c cVar, a aVar, boolean z3) {
        if (z3) {
            a(cVar);
        } else {
            a(cVar, aVar);
        }
    }

    public boolean a() {
        int b4 = b();
        return b4 != 0 && this.f3049c[a(b4 - 1)] == 0;
    }

    public int b() {
        return d();
    }

    public byte[] c() {
        int b4 = b();
        if (b4 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[this.f3049c.length - a(0)];
        int a4 = a(0);
        int i4 = 0;
        for (int i5 = 0; i5 < b4; i5++) {
            byte[] bArr2 = this.f3049c;
            byte b5 = bArr2[a4];
            if (b5 > 63) {
                throw new IllegalStateException("invalid label");
            }
            bArr[i4] = bArr2[a4];
            i4++;
            a4++;
            int i6 = 0;
            while (i6 < b5) {
                bArr[i4] = f3047i[this.f3049c[a4] & 255];
                i6++;
                i4++;
                a4++;
            }
        }
        return bArr;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        g gVar = (g) obj;
        if (this == gVar) {
            return 0;
        }
        int b4 = b();
        int b5 = gVar.b();
        int i4 = b4 > b5 ? b5 : b4;
        for (int i5 = 1; i5 <= i4; i5++) {
            int a4 = a(b4 - i5);
            int a5 = gVar.a(b5 - i5);
            byte b6 = this.f3049c[a4];
            byte b7 = gVar.f3049c[a5];
            for (int i6 = 0; i6 < b6 && i6 < b7; i6++) {
                byte[] bArr = f3047i;
                int i7 = bArr[this.f3049c[(i6 + a4) + 1] & 255] - bArr[gVar.f3049c[(i6 + a5) + 1] & 255];
                if (i7 != 0) {
                    return i7;
                }
            }
            if (b6 != b7) {
                return b6 - b7;
            }
        }
        return b4 - b5;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (gVar.f3051e == 0) {
            gVar.hashCode();
        }
        if (this.f3051e == 0) {
            hashCode();
        }
        if (gVar.f3051e == this.f3051e && gVar.b() == b()) {
            return b(gVar.f3049c, gVar.a(0));
        }
        return false;
    }

    public int hashCode() {
        int i4 = this.f3051e;
        if (i4 != 0) {
            return i4;
        }
        int i5 = 0;
        int a4 = a(0);
        while (true) {
            byte[] bArr = this.f3049c;
            if (a4 >= bArr.length) {
                this.f3051e = i5;
                return i5;
            }
            i5 += (i5 << 3) + f3047i[bArr[a4] & 255];
            a4++;
        }
    }

    public String toString() {
        return a(false);
    }
}
