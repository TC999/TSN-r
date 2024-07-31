package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1;

import com.alibaba.fastjson.asm.Opcodes;
import io.netty.handler.codec.http.HttpConstants;
import javax.security.auth.x500.X500Principal;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
final class DistinguishedNameParser {

    /* renamed from: a */
    private final String f922a;

    /* renamed from: b */
    private final int f923b;

    /* renamed from: c */
    private int f924c;

    /* renamed from: d */
    private int f925d;

    /* renamed from: e */
    private int f926e;

    /* renamed from: f */
    private int f927f;

    /* renamed from: g */
    private char[] f928g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DistinguishedNameParser(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f922a = name;
        this.f923b = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
        return new java.lang.String(r1, r2, r8.f927f - r2);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m58788a() {
        /*
            r8 = this;
            int r0 = r8.f924c
            r8.f925d = r0
            r8.f926e = r0
        L6:
            int r0 = r8.f924c
            int r1 = r8.f923b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f928g
            int r2 = r8.f925d
            int r3 = r8.f926e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f928g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L5e
            if (r2 == r5) goto L53
            r5 = 92
            if (r2 == r5) goto L40
            if (r2 == r4) goto L53
            if (r2 == r3) goto L53
            int r2 = r8.f926e
            int r3 = r2 + 1
            r8.f926e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f924c = r0
            goto L6
        L40:
            int r0 = r8.f926e
            int r2 = r0 + 1
            r8.f926e = r2
            char r2 = r8.m58785b()
            r1[r0] = r2
            int r0 = r8.f924c
            int r0 = r0 + 1
            r8.f924c = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f925d
            int r3 = r8.f926e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5e:
            int r2 = r8.f926e
            r8.f927f = r2
            int r0 = r0 + 1
            r8.f924c = r0
            int r0 = r2 + 1
            r8.f926e = r0
            r1[r2] = r6
        L6c:
            int r0 = r8.f924c
            int r1 = r8.f923b
            if (r0 >= r1) goto L85
            char[] r2 = r8.f928g
            char r7 = r2[r0]
            if (r7 != r6) goto L85
            int r1 = r8.f926e
            int r7 = r1 + 1
            r8.f926e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f924c = r0
            goto L6c
        L85:
            if (r0 == r1) goto L95
            char[] r1 = r8.f928g
            char r2 = r1[r0]
            if (r2 == r3) goto L95
            char r2 = r1[r0]
            if (r2 == r4) goto L95
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L95:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f928g
            int r2 = r8.f925d
            int r3 = r8.f927f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.DistinguishedNameParser.m58788a():java.lang.String");
    }

    /* renamed from: b */
    private char m58785b() {
        int i = this.f924c + 1;
        this.f924c = i;
        if (i != this.f923b) {
            char[] cArr = this.f928g;
            char c = cArr[i];
            if (c != ' ' && c != '%' && c != '\\' && c != '_' && c != '\"' && c != '#') {
                switch (c) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return m58784c();
                        }
                }
            }
            return cArr[i];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f922a);
    }

    /* renamed from: c */
    private char m58784c() {
        int i;
        int i2;
        int m58787a = m58787a(this.f924c);
        this.f924c++;
        if (m58787a < 128) {
            return (char) m58787a;
        }
        if (m58787a < 192 || m58787a > 247) {
            return '?';
        }
        if (m58787a <= 223) {
            i2 = m58787a & 31;
            i = 1;
        } else if (m58787a <= 239) {
            i = 2;
            i2 = m58787a & 15;
        } else {
            i = 3;
            i2 = m58787a & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = this.f924c + 1;
            this.f924c = i4;
            if (i4 == this.f923b || this.f928g[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.f924c = i5;
            int m58787a2 = m58787a(i5);
            this.f924c++;
            if ((m58787a2 & Opcodes.CHECKCAST) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (m58787a2 & 63);
        }
        return (char) i2;
    }

    /* renamed from: d */
    private String m58783d() {
        int i;
        int i2 = this.f924c;
        if (i2 + 4 < this.f923b) {
            this.f925d = i2;
            this.f924c = i2 + 1;
            while (true) {
                i = this.f924c;
                if (i == this.f923b) {
                    break;
                }
                char[] cArr = this.f928g;
                if (cArr[i] == '+' || cArr[i] == ',' || cArr[i] == ';') {
                    break;
                } else if (cArr[i] == ' ') {
                    this.f926e = i;
                    this.f924c = i + 1;
                    while (true) {
                        int i3 = this.f924c;
                        if (i3 >= this.f923b || this.f928g[i3] != ' ') {
                            break;
                        }
                        this.f924c = i3 + 1;
                    }
                } else {
                    if (cArr[i] >= 'A' && cArr[i] <= 'F') {
                        cArr[i] = (char) (cArr[i] + HttpConstants.SP_CHAR);
                    }
                    this.f924c = i + 1;
                }
            }
            this.f926e = i;
            int i4 = this.f926e;
            int i5 = this.f925d;
            int i6 = i4 - i5;
            if (i6 >= 5 && (i6 & 1) != 0) {
                int i7 = i6 / 2;
                byte[] bArr = new byte[i7];
                int i8 = i5 + 1;
                for (int i9 = 0; i9 < i7; i9++) {
                    bArr[i9] = (byte) m58787a(i8);
                    i8 += 2;
                }
                return new String(this.f928g, this.f925d, i6);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.f922a);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f922a);
    }

    /* renamed from: e */
    private String m58782e() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        while (true) {
            i = this.f924c;
            i2 = this.f923b;
            if (i >= i2 || this.f928g[i] != ' ') {
                break;
            }
            this.f924c = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.f925d = i;
        this.f924c = i + 1;
        while (true) {
            i3 = this.f924c;
            i4 = this.f923b;
            if (i3 >= i4) {
                break;
            }
            char[] cArr = this.f928g;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.f924c = i3 + 1;
        }
        if (i3 < i4) {
            this.f926e = i3;
            if (this.f928g[i3] == ' ') {
                while (true) {
                    i5 = this.f924c;
                    i6 = this.f923b;
                    if (i5 >= i6) {
                        break;
                    }
                    char[] cArr2 = this.f928g;
                    if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                        break;
                    }
                    this.f924c = i5 + 1;
                }
                if (this.f928g[i5] != '=' || i5 == i6) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f922a);
                }
            }
            this.f924c++;
            while (true) {
                int i7 = this.f924c;
                if (i7 >= this.f923b || this.f928g[i7] != ' ') {
                    break;
                }
                this.f924c = i7 + 1;
            }
            int i8 = this.f926e;
            int i9 = this.f925d;
            if (i8 - i9 > 4) {
                char[] cArr3 = this.f928g;
                if (cArr3[i9 + 3] == '.' && (cArr3[i9] == 'O' || cArr3[i9] == 'o')) {
                    int i10 = i9 + 1;
                    if (cArr3[i10] == 'I' || cArr3[i10] == 'i') {
                        int i11 = i9 + 2;
                        if (cArr3[i11] == 'D' || cArr3[i11] == 'd') {
                            this.f925d = i9 + 4;
                        }
                    }
                }
            }
            char[] cArr4 = this.f928g;
            int i12 = this.f925d;
            return new String(cArr4, i12, i8 - i12);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f922a);
    }

    /* renamed from: f */
    private String m58781f() {
        int i = this.f924c + 1;
        this.f924c = i;
        this.f925d = i;
        this.f926e = i;
        while (true) {
            int i2 = this.f924c;
            if (i2 != this.f923b) {
                char[] cArr = this.f928g;
                if (cArr[i2] == '\"') {
                    this.f924c = i2 + 1;
                    while (true) {
                        int i3 = this.f924c;
                        if (i3 >= this.f923b || this.f928g[i3] != ' ') {
                            break;
                        }
                        this.f924c = i3 + 1;
                    }
                    char[] cArr2 = this.f928g;
                    int i4 = this.f925d;
                    return new String(cArr2, i4, this.f926e - i4);
                }
                if (cArr[i2] == '\\') {
                    cArr[this.f926e] = m58785b();
                } else {
                    cArr[this.f926e] = cArr[i2];
                }
                this.f924c++;
                this.f926e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f922a);
            }
        }
    }

    /* renamed from: a */
    private int m58787a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.f923b) {
            char[] cArr = this.f928g;
            char c = cArr[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f922a);
            } else {
                i2 = c - '7';
            }
            char c2 = cArr[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f922a);
            } else {
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.f922a);
    }

    /* renamed from: a */
    public String m58786a(String str) {
        String m58781f;
        this.f924c = 0;
        this.f925d = 0;
        this.f926e = 0;
        this.f927f = 0;
        this.f928g = this.f922a.toCharArray();
        String m58782e = m58782e();
        if (m58782e == null) {
            return null;
        }
        do {
            int i = this.f924c;
            if (i == this.f923b) {
                return null;
            }
            char c = this.f928g[i];
            if (c == '\"') {
                m58781f = m58781f();
            } else if (c != '#') {
                m58781f = (c == '+' || c == ',' || c == ';') ? "" : m58788a();
            } else {
                m58781f = m58783d();
            }
            if (str.equalsIgnoreCase(m58782e)) {
                return m58781f;
            }
            int i2 = this.f924c;
            if (i2 >= this.f923b) {
                return null;
            }
            char[] cArr = this.f928g;
            if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f922a);
            }
            this.f924c = i2 + 1;
            m58782e = m58782e();
        } while (m58782e != null);
        throw new IllegalStateException("Malformed DN: " + this.f922a);
    }
}
