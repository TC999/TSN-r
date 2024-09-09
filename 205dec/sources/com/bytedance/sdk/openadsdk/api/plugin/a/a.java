package com.bytedance.sdk.openadsdk.api.plugin.a;

import javax.security.auth.x500.X500Principal;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f31441a;
    private int bl;

    /* renamed from: h  reason: collision with root package name */
    private char[] f31442h;
    private int kf;

    /* renamed from: n  reason: collision with root package name */
    private int f31443n;
    private final String ok;

    /* renamed from: s  reason: collision with root package name */
    private int f31444s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.ok = name;
        this.f31441a = name.length();
    }

    private String a() {
        int i4 = this.bl + 1;
        this.bl = i4;
        this.f31444s = i4;
        this.f31443n = i4;
        while (true) {
            int i5 = this.bl;
            if (i5 != this.f31441a) {
                char[] cArr = this.f31442h;
                if (cArr[i5] == '\"') {
                    this.bl = i5 + 1;
                    while (true) {
                        int i6 = this.bl;
                        if (i6 >= this.f31441a || this.f31442h[i6] != ' ') {
                            break;
                        }
                        this.bl = i6 + 1;
                    }
                    char[] cArr2 = this.f31442h;
                    int i7 = this.f31444s;
                    return new String(cArr2, i7, this.f31443n - i7);
                }
                if (cArr[i5] == '\\') {
                    cArr[this.f31443n] = n();
                } else {
                    cArr[this.f31443n] = cArr[i5];
                }
                this.bl++;
                this.f31443n++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.ok);
            }
        }
    }

    private String bl() {
        int i4;
        int i5 = this.bl;
        if (i5 + 4 < this.f31441a) {
            this.f31444s = i5;
            this.bl = i5 + 1;
            while (true) {
                i4 = this.bl;
                if (i4 == this.f31441a) {
                    break;
                }
                char[] cArr = this.f31442h;
                if (cArr[i4] == '+' || cArr[i4] == ',' || cArr[i4] == ';') {
                    break;
                } else if (cArr[i4] == ' ') {
                    this.f31443n = i4;
                    this.bl = i4 + 1;
                    while (true) {
                        int i6 = this.bl;
                        if (i6 >= this.f31441a || this.f31442h[i6] != ' ') {
                            break;
                        }
                        this.bl = i6 + 1;
                    }
                } else {
                    if (cArr[i4] >= 'A' && cArr[i4] <= 'F') {
                        cArr[i4] = (char) (cArr[i4] + ' ');
                    }
                    this.bl = i4 + 1;
                }
            }
            this.f31443n = i4;
            int i7 = this.f31443n;
            int i8 = this.f31444s;
            int i9 = i7 - i8;
            if (i9 >= 5 && (i9 & 1) != 0) {
                int i10 = i9 / 2;
                byte[] bArr = new byte[i10];
                int i11 = i8 + 1;
                for (int i12 = 0; i12 < i10; i12++) {
                    bArr[i12] = (byte) ok(i11);
                    i11 += 2;
                }
                return new String(this.f31442h, this.f31444s, i9);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.ok);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.ok);
    }

    private char kf() {
        int i4;
        int i5;
        int ok = ok(this.bl);
        this.bl++;
        if (ok < 128) {
            return (char) ok;
        }
        if (ok < 192 || ok > 247) {
            return '?';
        }
        if (ok <= 223) {
            i5 = ok & 31;
            i4 = 1;
        } else if (ok <= 239) {
            i4 = 2;
            i5 = ok & 15;
        } else {
            i4 = 3;
            i5 = ok & 7;
        }
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = this.bl + 1;
            this.bl = i7;
            if (i7 == this.f31441a || this.f31442h[i7] != '\\') {
                return '?';
            }
            int i8 = i7 + 1;
            this.bl = i8;
            int ok2 = ok(i8);
            this.bl++;
            if ((ok2 & 192) != 128) {
                return '?';
            }
            i5 = (i5 << 6) + (ok2 & 63);
        }
        return (char) i5;
    }

    private char n() {
        int i4 = this.bl + 1;
        this.bl = i4;
        if (i4 != this.f31441a) {
            char[] cArr = this.f31442h;
            char c4 = cArr[i4];
            if (c4 != ' ' && c4 != '%' && c4 != '\\' && c4 != '_' && c4 != '\"' && c4 != '#') {
                switch (c4) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c4) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return kf();
                        }
                }
            }
            return cArr[i4];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.ok);
    }

    private String ok() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        while (true) {
            i4 = this.bl;
            i5 = this.f31441a;
            if (i4 >= i5 || this.f31442h[i4] != ' ') {
                break;
            }
            this.bl = i4 + 1;
        }
        if (i4 == i5) {
            return null;
        }
        this.f31444s = i4;
        this.bl = i4 + 1;
        while (true) {
            i6 = this.bl;
            i7 = this.f31441a;
            if (i6 >= i7) {
                break;
            }
            char[] cArr = this.f31442h;
            if (cArr[i6] == '=' || cArr[i6] == ' ') {
                break;
            }
            this.bl = i6 + 1;
        }
        if (i6 < i7) {
            this.f31443n = i6;
            if (this.f31442h[i6] == ' ') {
                while (true) {
                    i8 = this.bl;
                    i9 = this.f31441a;
                    if (i8 >= i9) {
                        break;
                    }
                    char[] cArr2 = this.f31442h;
                    if (cArr2[i8] == '=' || cArr2[i8] != ' ') {
                        break;
                    }
                    this.bl = i8 + 1;
                }
                if (this.f31442h[i8] != '=' || i8 == i9) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.ok);
                }
            }
            this.bl++;
            while (true) {
                int i10 = this.bl;
                if (i10 >= this.f31441a || this.f31442h[i10] != ' ') {
                    break;
                }
                this.bl = i10 + 1;
            }
            int i11 = this.f31443n;
            int i12 = this.f31444s;
            if (i11 - i12 > 4) {
                char[] cArr3 = this.f31442h;
                if (cArr3[i12 + 3] == '.' && ((cArr3[i12] == 'O' || cArr3[i12] == 'o') && ((cArr3[i12 + 1] == 'I' || cArr3[i12 + 1] == 'i') && (cArr3[i12 + 2] == 'D' || cArr3[i12 + 2] == 'd')))) {
                    this.f31444s = i12 + 4;
                }
            }
            char[] cArr4 = this.f31442h;
            int i13 = this.f31444s;
            return new String(cArr4, i13, i11 - i13);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.ok);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
        return new java.lang.String(r1, r2, r8.kf - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String s() {
        /*
            r8 = this;
            int r0 = r8.bl
            r8.f31444s = r0
            r8.f31443n = r0
        L6:
            int r0 = r8.bl
            int r1 = r8.f31441a
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f31442h
            int r2 = r8.f31444s
            int r3 = r8.f31443n
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f31442h
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
            int r2 = r8.f31443n
            int r3 = r2 + 1
            r8.f31443n = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.bl = r0
            goto L6
        L40:
            int r0 = r8.f31443n
            int r2 = r0 + 1
            r8.f31443n = r2
            char r2 = r8.n()
            r1[r0] = r2
            int r0 = r8.bl
            int r0 = r0 + 1
            r8.bl = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f31444s
            int r3 = r8.f31443n
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5e:
            int r2 = r8.f31443n
            r8.kf = r2
            int r0 = r0 + 1
            r8.bl = r0
            int r0 = r2 + 1
            r8.f31443n = r0
            r1[r2] = r6
        L6c:
            int r0 = r8.bl
            int r1 = r8.f31441a
            if (r0 >= r1) goto L85
            char[] r2 = r8.f31442h
            char r7 = r2[r0]
            if (r7 != r6) goto L85
            int r1 = r8.f31443n
            int r7 = r1 + 1
            r8.f31443n = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.bl = r0
            goto L6c
        L85:
            if (r0 == r1) goto L95
            char[] r1 = r8.f31442h
            char r2 = r1[r0]
            if (r2 == r3) goto L95
            char r2 = r1[r0]
            if (r2 == r4) goto L95
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L95:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f31442h
            int r2 = r8.f31444s
            int r3 = r8.kf
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.a.a.s():java.lang.String");
    }

    private int ok(int i4) {
        int i5;
        int i6;
        int i7 = i4 + 1;
        if (i7 < this.f31441a) {
            char[] cArr = this.f31442h;
            char c4 = cArr[i4];
            if (c4 >= '0' && c4 <= '9') {
                i5 = c4 - '0';
            } else if (c4 >= 'a' && c4 <= 'f') {
                i5 = c4 - 'W';
            } else if (c4 < 'A' || c4 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.ok);
            } else {
                i5 = c4 - '7';
            }
            char c5 = cArr[i7];
            if (c5 >= '0' && c5 <= '9') {
                i6 = c5 - '0';
            } else if (c5 >= 'a' && c5 <= 'f') {
                i6 = c5 - 'W';
            } else if (c5 < 'A' || c5 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.ok);
            } else {
                i6 = c5 - '7';
            }
            return (i5 << 4) + i6;
        }
        throw new IllegalStateException("Malformed DN: " + this.ok);
    }

    public String ok(String str) {
        String a4;
        this.bl = 0;
        this.f31444s = 0;
        this.f31443n = 0;
        this.kf = 0;
        this.f31442h = this.ok.toCharArray();
        String ok = ok();
        if (ok == null) {
            return null;
        }
        do {
            int i4 = this.bl;
            if (i4 == this.f31441a) {
                return null;
            }
            char c4 = this.f31442h[i4];
            if (c4 == '\"') {
                a4 = a();
            } else if (c4 != '#') {
                a4 = (c4 == '+' || c4 == ',' || c4 == ';') ? "" : s();
            } else {
                a4 = bl();
            }
            if (str.equalsIgnoreCase(ok)) {
                return a4;
            }
            int i5 = this.bl;
            if (i5 >= this.f31441a) {
                return null;
            }
            char[] cArr = this.f31442h;
            if (cArr[i5] != ',' && cArr[i5] != ';' && cArr[i5] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.ok);
            }
            this.bl = i5 + 1;
            ok = ok();
        } while (ok != null);
        throw new IllegalStateException("Malformed DN: " + this.ok);
    }
}
