package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.UByte;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: d */
    static final char[] f806d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: e */
    public static final ByteString f807e = m58940a(new byte[0]);

    /* renamed from: a */
    final byte[] f808a;

    /* renamed from: b */
    transient int f809b;

    /* renamed from: c */
    transient String f810c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteString(byte[] bArr) {
        this.f808a = bArr;
    }

    /* renamed from: a */
    public static ByteString m58940a(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    /* renamed from: b */
    private ByteString m58938b(String str) {
        try {
            return m58940a(MessageDigest.getInstance(str).digest(this.f808a));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: c */
    public static ByteString m58937c(String str) {
        if (str != null) {
            ByteString byteString = new ByteString(str.getBytes(Util.f850a));
            byteString.f810c = str;
            return byteString;
        }
        throw new IllegalArgumentException("s == null");
    }

    /* renamed from: d */
    public ByteString mo58882d() {
        return m58938b("SHA-256");
    }

    /* renamed from: e */
    public int mo58881e() {
        return this.f808a.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int mo58881e = byteString.mo58881e();
            byte[] bArr = this.f808a;
            if (mo58881e == bArr.length && byteString.mo58887a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public ByteString mo58880f() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f808a;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArr2);
            }
            i++;
        }
    }

    /* renamed from: g */
    public byte[] mo58879g() {
        return (byte[]) this.f808a.clone();
    }

    /* renamed from: h */
    public String mo58878h() {
        String str = this.f810c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f808a, Util.f850a);
        this.f810c = str2;
        return str2;
    }

    public int hashCode() {
        int i = this.f809b;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f808a);
        this.f809b = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb;
        if (this.f808a.length == 0) {
            return "[size=0]";
        }
        String mo58878h = mo58878h();
        int m58941a = m58941a(mo58878h, 64);
        if (m58941a == -1) {
            if (this.f808a.length <= 64) {
                return "[hex=" + mo58885b() + "]";
            }
            return "[size=" + this.f808a.length + " hex=" + mo58889a(0, 64).mo58885b() + "…]";
        }
        String replace = mo58878h.substring(0, m58941a).replace("\\", "\\\\").replace(ShellAdbUtils.f33810d, "\\n").replace("\r", "\\r");
        if (m58941a < mo58878h.length()) {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(this.f808a.length);
            sb.append(" text=");
            sb.append(replace);
            sb.append("…]");
        } else {
            sb = new StringBuilder();
            sb.append("[text=");
            sb.append(replace);
            sb.append("]");
        }
        return sb.toString();
    }

    /* renamed from: a */
    public String mo58891a() {
        return Base64.m58968a(this.f808a);
    }

    /* renamed from: b */
    public String mo58885b() {
        byte[] bArr = this.f808a;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f806d;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static ByteString m58942a(String str) {
        if (str != null) {
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    bArr[i] = (byte) ((m58944a(str.charAt(i2)) << 4) + m58944a(str.charAt(i2 + 1)));
                }
                return m58940a(bArr);
            }
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        throw new IllegalArgumentException("hex == null");
    }

    /* renamed from: c */
    public ByteString mo58883c() {
        return m58938b("SHA-1");
    }

    /* renamed from: b */
    public final boolean m58939b(ByteString byteString) {
        return mo58888a(0, byteString, 0, byteString.mo58881e());
    }

    /* renamed from: a */
    private static int m58944a(char c) {
        if (c < '0' || c > '9') {
            char c2 = 'a';
            if (c < 'a' || c > 'f') {
                c2 = 'A';
                if (c < 'A' || c > 'F') {
                    throw new IllegalArgumentException("Unexpected hex digit: " + c);
                }
            }
            return (c - c2) + 10;
        }
        return c - '0';
    }

    /* renamed from: a */
    public ByteString mo58889a(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.f808a;
            if (i2 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.f808a.length + ")");
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, i3);
                return new ByteString(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    /* renamed from: a */
    public byte mo58890a(int i) {
        return this.f808a[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo58886a(Buffer buffer) {
        byte[] bArr = this.f808a;
        buffer.write(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public boolean mo58888a(int i, ByteString byteString, int i2, int i3) {
        return byteString.mo58887a(i2, this.f808a, i, i3);
    }

    /* renamed from: a */
    public boolean mo58887a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.f808a;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && Util.m58864a(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ByteString byteString) {
        int mo58881e = mo58881e();
        int mo58881e2 = byteString.mo58881e();
        int min = Math.min(mo58881e, mo58881e2);
        for (int i = 0; i < min; i++) {
            int mo58890a = mo58890a(i) & UByte.f41242c;
            int mo58890a2 = byteString.mo58890a(i) & UByte.f41242c;
            if (mo58890a != mo58890a2) {
                return mo58890a < mo58890a2 ? -1 : 1;
            }
        }
        if (mo58881e == mo58881e2) {
            return 0;
        }
        return mo58881e < mo58881e2 ? -1 : 1;
    }

    /* renamed from: a */
    static int m58941a(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
