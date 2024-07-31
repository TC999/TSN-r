package com.bytedance.sdk.openadsdk.api.plugin.p135a;

import com.alibaba.fastjson.asm.Opcodes;
import io.netty.handler.codec.http.HttpConstants;
import javax.security.auth.x500.X500Principal;

/* renamed from: com.bytedance.sdk.openadsdk.api.plugin.a.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
final class C6316a {

    /* renamed from: a */
    private final int f22432a;

    /* renamed from: bl */
    private int f22433bl;

    /* renamed from: h */
    private char[] f22434h;

    /* renamed from: kf */
    private int f22435kf;

    /* renamed from: n */
    private int f22436n;

    /* renamed from: ok */
    private final String f22437ok;

    /* renamed from: s */
    private int f22438s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6316a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f22437ok = name;
        this.f22432a = name.length();
    }

    /* renamed from: a */
    private String m36628a() {
        int i = this.f22433bl + 1;
        this.f22433bl = i;
        this.f22438s = i;
        this.f22436n = i;
        while (true) {
            int i2 = this.f22433bl;
            if (i2 != this.f22432a) {
                char[] cArr = this.f22434h;
                if (cArr[i2] == '\"') {
                    this.f22433bl = i2 + 1;
                    while (true) {
                        int i3 = this.f22433bl;
                        if (i3 >= this.f22432a || this.f22434h[i3] != ' ') {
                            break;
                        }
                        this.f22433bl = i3 + 1;
                    }
                    char[] cArr2 = this.f22434h;
                    int i4 = this.f22438s;
                    return new String(cArr2, i4, this.f22436n - i4);
                }
                if (cArr[i2] == '\\') {
                    cArr[this.f22436n] = m36625n();
                } else {
                    cArr[this.f22436n] = cArr[i2];
                }
                this.f22433bl++;
                this.f22436n++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f22437ok);
            }
        }
    }

    /* renamed from: bl */
    private String m36627bl() {
        int i;
        int i2 = this.f22433bl;
        if (i2 + 4 < this.f22432a) {
            this.f22438s = i2;
            this.f22433bl = i2 + 1;
            while (true) {
                i = this.f22433bl;
                if (i == this.f22432a) {
                    break;
                }
                char[] cArr = this.f22434h;
                if (cArr[i] == '+' || cArr[i] == ',' || cArr[i] == ';') {
                    break;
                } else if (cArr[i] == ' ') {
                    this.f22436n = i;
                    this.f22433bl = i + 1;
                    while (true) {
                        int i3 = this.f22433bl;
                        if (i3 >= this.f22432a || this.f22434h[i3] != ' ') {
                            break;
                        }
                        this.f22433bl = i3 + 1;
                    }
                } else {
                    if (cArr[i] >= 'A' && cArr[i] <= 'F') {
                        cArr[i] = (char) (cArr[i] + HttpConstants.SP_CHAR);
                    }
                    this.f22433bl = i + 1;
                }
            }
            this.f22436n = i;
            int i4 = this.f22436n;
            int i5 = this.f22438s;
            int i6 = i4 - i5;
            if (i6 >= 5 && (i6 & 1) != 0) {
                int i7 = i6 / 2;
                byte[] bArr = new byte[i7];
                int i8 = i5 + 1;
                for (int i9 = 0; i9 < i7; i9++) {
                    bArr[i9] = (byte) m36623ok(i8);
                    i8 += 2;
                }
                return new String(this.f22434h, this.f22438s, i6);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.f22437ok);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f22437ok);
    }

    /* renamed from: kf */
    private char m36626kf() {
        int i;
        int i2;
        int m36623ok = m36623ok(this.f22433bl);
        this.f22433bl++;
        if (m36623ok < 128) {
            return (char) m36623ok;
        }
        if (m36623ok < 192 || m36623ok > 247) {
            return '?';
        }
        if (m36623ok <= 223) {
            i2 = m36623ok & 31;
            i = 1;
        } else if (m36623ok <= 239) {
            i = 2;
            i2 = m36623ok & 15;
        } else {
            i = 3;
            i2 = m36623ok & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = this.f22433bl + 1;
            this.f22433bl = i4;
            if (i4 == this.f22432a || this.f22434h[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.f22433bl = i5;
            int m36623ok2 = m36623ok(i5);
            this.f22433bl++;
            if ((m36623ok2 & Opcodes.CHECKCAST) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (m36623ok2 & 63);
        }
        return (char) i2;
    }

    /* renamed from: n */
    private char m36625n() {
        int i = this.f22433bl + 1;
        this.f22433bl = i;
        if (i != this.f22432a) {
            char[] cArr = this.f22434h;
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
                                return m36626kf();
                        }
                }
            }
            return cArr[i];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f22437ok);
    }

    /* renamed from: ok */
    private String m36624ok() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        while (true) {
            i = this.f22433bl;
            i2 = this.f22432a;
            if (i >= i2 || this.f22434h[i] != ' ') {
                break;
            }
            this.f22433bl = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.f22438s = i;
        this.f22433bl = i + 1;
        while (true) {
            i3 = this.f22433bl;
            i4 = this.f22432a;
            if (i3 >= i4) {
                break;
            }
            char[] cArr = this.f22434h;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.f22433bl = i3 + 1;
        }
        if (i3 < i4) {
            this.f22436n = i3;
            if (this.f22434h[i3] == ' ') {
                while (true) {
                    i5 = this.f22433bl;
                    i6 = this.f22432a;
                    if (i5 >= i6) {
                        break;
                    }
                    char[] cArr2 = this.f22434h;
                    if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                        break;
                    }
                    this.f22433bl = i5 + 1;
                }
                if (this.f22434h[i5] != '=' || i5 == i6) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f22437ok);
                }
            }
            this.f22433bl++;
            while (true) {
                int i7 = this.f22433bl;
                if (i7 >= this.f22432a || this.f22434h[i7] != ' ') {
                    break;
                }
                this.f22433bl = i7 + 1;
            }
            int i8 = this.f22436n;
            int i9 = this.f22438s;
            if (i8 - i9 > 4) {
                char[] cArr3 = this.f22434h;
                if (cArr3[i9 + 3] == '.' && ((cArr3[i9] == 'O' || cArr3[i9] == 'o') && ((cArr3[i9 + 1] == 'I' || cArr3[i9 + 1] == 'i') && (cArr3[i9 + 2] == 'D' || cArr3[i9 + 2] == 'd')))) {
                    this.f22438s = i9 + 4;
                }
            }
            char[] cArr4 = this.f22434h;
            int i10 = this.f22438s;
            return new String(cArr4, i10, i8 - i10);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f22437ok);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
        return new java.lang.String(r1, r2, r8.f22435kf - r2);
     */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m36621s() {
        /*
            r8 = this;
            int r0 = r8.f22433bl
            r8.f22438s = r0
            r8.f22436n = r0
        L6:
            int r0 = r8.f22433bl
            int r1 = r8.f22432a
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f22434h
            int r2 = r8.f22438s
            int r3 = r8.f22436n
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f22434h
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
            int r2 = r8.f22436n
            int r3 = r2 + 1
            r8.f22436n = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f22433bl = r0
            goto L6
        L40:
            int r0 = r8.f22436n
            int r2 = r0 + 1
            r8.f22436n = r2
            char r2 = r8.m36625n()
            r1[r0] = r2
            int r0 = r8.f22433bl
            int r0 = r0 + 1
            r8.f22433bl = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f22438s
            int r3 = r8.f22436n
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5e:
            int r2 = r8.f22436n
            r8.f22435kf = r2
            int r0 = r0 + 1
            r8.f22433bl = r0
            int r0 = r2 + 1
            r8.f22436n = r0
            r1[r2] = r6
        L6c:
            int r0 = r8.f22433bl
            int r1 = r8.f22432a
            if (r0 >= r1) goto L85
            char[] r2 = r8.f22434h
            char r7 = r2[r0]
            if (r7 != r6) goto L85
            int r1 = r8.f22436n
            int r7 = r1 + 1
            r8.f22436n = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f22433bl = r0
            goto L6c
        L85:
            if (r0 == r1) goto L95
            char[] r1 = r8.f22434h
            char r2 = r1[r0]
            if (r2 == r3) goto L95
            char r2 = r1[r0]
            if (r2 == r4) goto L95
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L95:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f22434h
            int r2 = r8.f22438s
            int r3 = r8.f22435kf
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.p135a.C6316a.m36621s():java.lang.String");
    }

    /* renamed from: ok */
    private int m36623ok(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.f22432a) {
            char[] cArr = this.f22434h;
            char c = cArr[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f22437ok);
            } else {
                i2 = c - '7';
            }
            char c2 = cArr[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f22437ok);
            } else {
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.f22437ok);
    }

    /* renamed from: ok */
    public String m36622ok(String str) {
        String m36628a;
        this.f22433bl = 0;
        this.f22438s = 0;
        this.f22436n = 0;
        this.f22435kf = 0;
        this.f22434h = this.f22437ok.toCharArray();
        String m36624ok = m36624ok();
        if (m36624ok == null) {
            return null;
        }
        do {
            int i = this.f22433bl;
            if (i == this.f22432a) {
                return null;
            }
            char c = this.f22434h[i];
            if (c == '\"') {
                m36628a = m36628a();
            } else if (c != '#') {
                m36628a = (c == '+' || c == ',' || c == ';') ? "" : m36621s();
            } else {
                m36628a = m36627bl();
            }
            if (str.equalsIgnoreCase(m36624ok)) {
                return m36628a;
            }
            int i2 = this.f22433bl;
            if (i2 >= this.f22432a) {
                return null;
            }
            char[] cArr = this.f22434h;
            if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f22437ok);
            }
            this.f22433bl = i2 + 1;
            m36624ok = m36624ok();
        } while (m36624ok != null);
        throw new IllegalStateException("Malformed DN: " + this.f22437ok);
    }
}
