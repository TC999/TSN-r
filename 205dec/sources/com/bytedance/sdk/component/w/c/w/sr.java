package com.bytedance.sdk.component.w.c.w;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements Serializable, Comparable<sr> {

    /* renamed from: c  reason: collision with root package name */
    static final char[] f30446c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: w  reason: collision with root package name */
    public static final Charset f30447w = Charset.forName("UTF-8");
    public static final sr xv = c(new byte[0]);

    /* renamed from: f  reason: collision with root package name */
    transient String f30448f;
    final byte[] sr;
    transient int ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public sr(byte[] bArr) {
        this.sr = bArr;
    }

    public static sr c(byte... bArr) {
        if (bArr != null) {
            return new sr((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof sr) {
            sr srVar = (sr) obj;
            int xv2 = srVar.xv();
            byte[] bArr = this.sr;
            if (xv2 == bArr.length && srVar.c(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i4 = this.ux;
        if (i4 != 0) {
            return i4;
        }
        int hashCode = Arrays.hashCode(this.sr);
        this.ux = hashCode;
        return hashCode;
    }

    public byte[] sr() {
        return (byte[]) this.sr.clone();
    }

    public String toString() {
        StringBuilder sb;
        if (this.sr.length == 0) {
            return "[size=0]";
        }
        String c4 = c();
        int c5 = c(c4, 64);
        if (c5 == -1) {
            if (this.sr.length <= 64) {
                return "[hex=" + w() + "]";
            }
            return "[size=" + this.sr.length + " hex=" + c(0, 64).w() + "\u2026]";
        }
        String replace = c4.substring(0, c5).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (c5 < c4.length()) {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(this.sr.length);
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

    public String w() {
        byte[] bArr = this.sr;
        char[] cArr = new char[bArr.length * 2];
        int i4 = 0;
        for (byte b4 : bArr) {
            int i5 = i4 + 1;
            char[] cArr2 = f30446c;
            cArr[i4] = cArr2[(b4 >> 4) & 15];
            i4 = i5 + 1;
            cArr[i5] = cArr2[b4 & 15];
        }
        return new String(cArr);
    }

    public int xv() {
        return this.sr.length;
    }

    public String c() {
        String str = this.f30448f;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.sr, f30447w);
        this.f30448f = str2;
        return str2;
    }

    public static sr c(String str) {
        if (str != null) {
            sr srVar = new sr(str.getBytes(p.f30443c));
            srVar.f30448f = str;
            return srVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public sr c(int i4, int i5) {
        if (i4 >= 0) {
            byte[] bArr = this.sr;
            if (i5 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.sr.length + ")");
            }
            int i6 = i5 - i4;
            if (i6 >= 0) {
                if (i4 == 0 && i5 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, i4, bArr2, 0, i6);
                return new sr(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public byte c(int i4) {
        return this.sr[i4];
    }

    public boolean c(int i4, sr srVar, int i5, int i6) {
        return srVar.c(i5, this.sr, i4, i6);
    }

    public boolean c(int i4, byte[] bArr, int i5, int i6) {
        if (i4 >= 0) {
            byte[] bArr2 = this.sr;
            if (i4 <= bArr2.length - i6 && i5 >= 0 && i5 <= bArr.length - i6 && p.c(bArr2, i4, bArr, i5, i6)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(sr srVar) {
        int xv2 = xv();
        int xv3 = srVar.xv();
        int min = Math.min(xv2, xv3);
        for (int i4 = 0; i4 < min; i4++) {
            int c4 = c(i4) & 255;
            int c5 = srVar.c(i4) & 255;
            if (c4 != c5) {
                return c4 < c5 ? -1 : 1;
            }
        }
        if (xv2 == xv3) {
            return 0;
        }
        return xv2 < xv3 ? -1 : 1;
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
