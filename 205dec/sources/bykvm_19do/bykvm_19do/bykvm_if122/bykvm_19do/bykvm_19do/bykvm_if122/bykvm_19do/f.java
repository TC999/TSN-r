package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* compiled from: ByteString.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class f implements Serializable, Comparable<f> {

    /* renamed from: d  reason: collision with root package name */
    static final char[] f799d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: e  reason: collision with root package name */
    public static final f f800e = a(new byte[0]);

    /* renamed from: a  reason: collision with root package name */
    final byte[] f801a;

    /* renamed from: b  reason: collision with root package name */
    transient int f802b;

    /* renamed from: c  reason: collision with root package name */
    transient String f803c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(byte[] bArr) {
        this.f801a = bArr;
    }

    public static f a(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    private f b(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.f801a));
        } catch (NoSuchAlgorithmException e4) {
            throw new AssertionError(e4);
        }
    }

    public static f c(String str) {
        if (str != null) {
            f fVar = new f(str.getBytes(u.f843a));
            fVar.f803c = str;
            return fVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public f d() {
        return b("SHA-256");
    }

    public int e() {
        return this.f801a.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            int e4 = fVar.e();
            byte[] bArr = this.f801a;
            if (e4 == bArr.length && fVar.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public f f() {
        int i4 = 0;
        while (true) {
            byte[] bArr = this.f801a;
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

    public byte[] g() {
        return (byte[]) this.f801a.clone();
    }

    public String h() {
        String str = this.f803c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f801a, u.f843a);
        this.f803c = str2;
        return str2;
    }

    public int hashCode() {
        int i4 = this.f802b;
        if (i4 != 0) {
            return i4;
        }
        int hashCode = Arrays.hashCode(this.f801a);
        this.f802b = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb;
        if (this.f801a.length == 0) {
            return "[size=0]";
        }
        String h4 = h();
        int a4 = a(h4, 64);
        if (a4 == -1) {
            if (this.f801a.length <= 64) {
                return "[hex=" + b() + "]";
            }
            return "[size=" + this.f801a.length + " hex=" + a(0, 64).b() + "\u2026]";
        }
        String replace = h4.substring(0, a4).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (a4 < h4.length()) {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(this.f801a.length);
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

    public String a() {
        return b.a(this.f801a);
    }

    public String b() {
        byte[] bArr = this.f801a;
        char[] cArr = new char[bArr.length * 2];
        int i4 = 0;
        for (byte b4 : bArr) {
            int i5 = i4 + 1;
            char[] cArr2 = f799d;
            cArr[i4] = cArr2[(b4 >> 4) & 15];
            i4 = i5 + 1;
            cArr[i5] = cArr2[b4 & 15];
        }
        return new String(cArr);
    }

    public static f a(String str) {
        if (str != null) {
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = i4 * 2;
                    bArr[i4] = (byte) ((a(str.charAt(i5)) << 4) + a(str.charAt(i5 + 1)));
                }
                return a(bArr);
            }
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        throw new IllegalArgumentException("hex == null");
    }

    public f c() {
        return b("SHA-1");
    }

    public final boolean b(f fVar) {
        return a(0, fVar, 0, fVar.e());
    }

    private static int a(char c4) {
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

    public f a(int i4, int i5) {
        if (i4 >= 0) {
            byte[] bArr = this.f801a;
            if (i5 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.f801a.length + ")");
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

    public byte a(int i4) {
        return this.f801a[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar) {
        byte[] bArr = this.f801a;
        cVar.write(bArr, 0, bArr.length);
    }

    public boolean a(int i4, f fVar, int i5, int i6) {
        return fVar.a(i5, this.f801a, i4, i6);
    }

    public boolean a(int i4, byte[] bArr, int i5, int i6) {
        if (i4 >= 0) {
            byte[] bArr2 = this.f801a;
            if (i4 <= bArr2.length - i6 && i5 >= 0 && i5 <= bArr.length - i6 && u.a(bArr2, i4, bArr, i5, i6)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        int e4 = e();
        int e5 = fVar.e();
        int min = Math.min(e4, e5);
        for (int i4 = 0; i4 < min; i4++) {
            int a4 = a(i4) & 255;
            int a5 = fVar.a(i4) & 255;
            if (a4 != a5) {
                return a4 < a5 ? -1 : 1;
            }
        }
        if (e4 == e5) {
            return 0;
        }
        return e4 < e5 ? -1 : 1;
    }

    static int a(String str, int i4) {
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
