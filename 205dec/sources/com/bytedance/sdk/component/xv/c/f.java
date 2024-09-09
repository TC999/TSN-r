package com.bytedance.sdk.component.xv.c;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements Serializable, Comparable<f> {

    /* renamed from: c  reason: collision with root package name */
    static final char[] f30680c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: w  reason: collision with root package name */
    public static final f f30681w = c(new byte[0]);
    transient int sr;
    transient String ux;
    final byte[] xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(byte[] bArr) {
        this.xv = bArr;
    }

    public static f c(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            int r3 = fVar.r();
            byte[] bArr = this.xv;
            if (r3 == bArr.length && fVar.c(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public byte[] ev() {
        return (byte[]) this.xv.clone();
    }

    public f f() {
        int i4 = 0;
        while (true) {
            byte[] bArr = this.xv;
            if (i4 >= bArr.length) {
                return this;
            }
            byte b4 = bArr[i4];
            if (b4 >= 65 && b4 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i4] = (byte) (b4 + 32);
                for (int i5 = i4 + 1; i5 < bArr2.length; i5++) {
                    byte b5 = bArr2[i5];
                    if (b5 >= 65 && b5 <= 90) {
                        bArr2[i5] = (byte) (b5 + 32);
                    }
                }
                return new f(bArr2);
            }
            i4++;
        }
    }

    public int hashCode() {
        int i4 = this.sr;
        if (i4 != 0) {
            return i4;
        }
        int hashCode = Arrays.hashCode(this.xv);
        this.sr = hashCode;
        return hashCode;
    }

    public int r() {
        return this.xv.length;
    }

    public f sr() {
        return xv("SHA-256");
    }

    public String toString() {
        StringBuilder sb;
        if (this.xv.length == 0) {
            return "[size=0]";
        }
        String c4 = c();
        int c5 = c(c4, 64);
        if (c5 == -1) {
            if (this.xv.length <= 64) {
                return "[hex=" + ux() + "]";
            }
            return "[size=" + this.xv.length + " hex=" + c(0, 64).ux() + "\u2026]";
        }
        String replace = c4.substring(0, c5).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (c5 < c4.length()) {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(this.xv.length);
            sb.append(" text=");
            sb.append(replace);
            sb.append("\u2026]");
        } else {
            sb = new StringBuilder();
            sb.append("[text=");
            sb.append(replace);
            sb.append("]");
        }
        return sb.toString();
    }

    public String ux() {
        byte[] bArr = this.xv;
        char[] cArr = new char[bArr.length * 2];
        int i4 = 0;
        for (byte b4 : bArr) {
            int i5 = i4 + 1;
            char[] cArr2 = f30680c;
            cArr[i4] = cArr2[(b4 >> 4) & 15];
            i4 = i5 + 1;
            cArr[i5] = cArr2[b4 & 15];
        }
        return new String(cArr);
    }

    public String w() {
        return w.c(this.xv);
    }

    public f xv() {
        return xv("SHA-1");
    }

    public static f w(String str) {
        if (str != null) {
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = i4 * 2;
                    bArr[i4] = (byte) ((c(str.charAt(i5)) << 4) + c(str.charAt(i5 + 1)));
                }
                return c(bArr);
            }
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        throw new IllegalArgumentException("hex == null");
    }

    private f xv(String str) {
        try {
            return c(MessageDigest.getInstance(str).digest(this.xv));
        } catch (NoSuchAlgorithmException e4) {
            throw new AssertionError(e4);
        }
    }

    public static f c(String str) {
        if (str != null) {
            f fVar = new f(str.getBytes(i.f30685c));
            fVar.ux = str;
            return fVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public String c() {
        String str = this.ux;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.xv, i.f30685c);
        this.ux = str2;
        return str2;
    }

    private static int c(char c4) {
        if (c4 < '0' || c4 > '9') {
            char c5 = 'a';
            if (c4 < 'a' || c4 > 'f') {
                c5 = 'A';
                if (c4 < 'A' || c4 > 'F') {
                    throw new IllegalArgumentException("Unexpected hex digit: " + c4);
                }
            }
            return (c4 - c5) + 10;
        }
        return c4 - '0';
    }

    public f c(int i4, int i5) {
        if (i4 >= 0) {
            byte[] bArr = this.xv;
            if (i5 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.xv.length + ")");
            }
            int i6 = i5 - i4;
            if (i6 >= 0) {
                if (i4 == 0 && i5 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, i4, bArr2, 0, i6);
                return new f(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    @Override // java.lang.Comparable
    /* renamed from: w */
    public int compareTo(f fVar) {
        int r3 = r();
        int r4 = fVar.r();
        int min = Math.min(r3, r4);
        for (int i4 = 0; i4 < min; i4++) {
            int c4 = c(i4) & 255;
            int c5 = fVar.c(i4) & 255;
            if (c4 != c5) {
                return c4 < c5 ? -1 : 1;
            }
        }
        if (r3 == r4) {
            return 0;
        }
        return r3 < r4 ? -1 : 1;
    }

    public byte c(int i4) {
        return this.xv[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(xv xvVar) {
        byte[] bArr = this.xv;
        xvVar.xv(bArr, 0, bArr.length);
    }

    public boolean c(int i4, f fVar, int i5, int i6) {
        return fVar.c(i5, this.xv, i4, i6);
    }

    public boolean c(int i4, byte[] bArr, int i5, int i6) {
        if (i4 >= 0) {
            byte[] bArr2 = this.xv;
            if (i4 <= bArr2.length - i6 && i5 >= 0 && i5 <= bArr.length - i6 && i.c(bArr2, i4, bArr, i5, i6)) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(f fVar) {
        return c(0, fVar, 0, fVar.r());
    }

    static int c(String str, int i4) {
        int length = str.length();
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            if (i6 == i4) {
                return i5;
            }
            int codePointAt = str.codePointAt(i5);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i6++;
            i5 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
