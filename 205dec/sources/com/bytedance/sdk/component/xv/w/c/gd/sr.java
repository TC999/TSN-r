package com.bytedance.sdk.component.xv.w.c.gd;

import javax.security.auth.x500.X500Principal;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class sr {

    /* renamed from: c  reason: collision with root package name */
    private final String f30778c;

    /* renamed from: f  reason: collision with root package name */
    private int f30779f;

    /* renamed from: r  reason: collision with root package name */
    private char[] f30780r;
    private int sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private final int f30781w;
    private int xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public sr(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f30778c = name;
        this.f30781w = name.length();
    }

    private String c() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        while (true) {
            i4 = this.xv;
            i5 = this.f30781w;
            if (i4 >= i5 || this.f30780r[i4] != ' ') {
                break;
            }
            this.xv = i4 + 1;
        }
        if (i4 == i5) {
            return null;
        }
        this.sr = i4;
        this.xv = i4 + 1;
        while (true) {
            i6 = this.xv;
            i7 = this.f30781w;
            if (i6 >= i7) {
                break;
            }
            char[] cArr = this.f30780r;
            if (cArr[i6] == '=' || cArr[i6] == ' ') {
                break;
            }
            this.xv = i6 + 1;
        }
        if (i6 < i7) {
            this.ux = i6;
            if (this.f30780r[i6] == ' ') {
                while (true) {
                    i8 = this.xv;
                    i9 = this.f30781w;
                    if (i8 >= i9) {
                        break;
                    }
                    char[] cArr2 = this.f30780r;
                    if (cArr2[i8] == '=' || cArr2[i8] != ' ') {
                        break;
                    }
                    this.xv = i8 + 1;
                }
                if (this.f30780r[i8] != '=' || i8 == i9) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f30778c);
                }
            }
            this.xv++;
            while (true) {
                int i10 = this.xv;
                if (i10 >= this.f30781w || this.f30780r[i10] != ' ') {
                    break;
                }
                this.xv = i10 + 1;
            }
            int i11 = this.ux;
            int i12 = this.sr;
            if (i11 - i12 > 4) {
                char[] cArr3 = this.f30780r;
                if (cArr3[i12 + 3] == '.' && ((cArr3[i12] == 'O' || cArr3[i12] == 'o') && ((cArr3[i12 + 1] == 'I' || cArr3[i12 + 1] == 'i') && (cArr3[i12 + 2] == 'D' || cArr3[i12 + 2] == 'd')))) {
                    this.sr = i12 + 4;
                }
            }
            char[] cArr4 = this.f30780r;
            int i13 = this.sr;
            return new String(cArr4, i13, i11 - i13);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f30778c);
    }

    private char f() {
        int i4;
        int i5;
        int c4 = c(this.xv);
        this.xv++;
        if (c4 < 128) {
            return (char) c4;
        }
        if (c4 < 192 || c4 > 247) {
            return '?';
        }
        if (c4 <= 223) {
            i5 = c4 & 31;
            i4 = 1;
        } else if (c4 <= 239) {
            i4 = 2;
            i5 = c4 & 15;
        } else {
            i4 = 3;
            i5 = c4 & 7;
        }
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = this.xv + 1;
            this.xv = i7;
            if (i7 == this.f30781w || this.f30780r[i7] != '\\') {
                return '?';
            }
            int i8 = i7 + 1;
            this.xv = i8;
            int c5 = c(i8);
            this.xv++;
            if ((c5 & 192) != 128) {
                return '?';
            }
            i5 = (i5 << 6) + (c5 & 63);
        }
        return (char) i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
        return new java.lang.String(r1, r2, r8.f30779f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String sr() {
        /*
            r8 = this;
            int r0 = r8.xv
            r8.sr = r0
            r8.ux = r0
        L6:
            int r0 = r8.xv
            int r1 = r8.f30781w
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f30780r
            int r2 = r8.sr
            int r3 = r8.ux
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f30780r
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
            int r2 = r8.ux
            int r3 = r2 + 1
            r8.ux = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.xv = r0
            goto L6
        L40:
            int r0 = r8.ux
            int r2 = r0 + 1
            r8.ux = r2
            char r2 = r8.ux()
            r1[r0] = r2
            int r0 = r8.xv
            int r0 = r0 + 1
            r8.xv = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.sr
            int r3 = r8.ux
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5e:
            int r2 = r8.ux
            r8.f30779f = r2
            int r0 = r0 + 1
            r8.xv = r0
            int r0 = r2 + 1
            r8.ux = r0
            r1[r2] = r6
        L6c:
            int r0 = r8.xv
            int r1 = r8.f30781w
            if (r0 >= r1) goto L85
            char[] r2 = r8.f30780r
            char r7 = r2[r0]
            if (r7 != r6) goto L85
            int r1 = r8.ux
            int r7 = r1 + 1
            r8.ux = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.xv = r0
            goto L6c
        L85:
            if (r0 == r1) goto L95
            char[] r1 = r8.f30780r
            char r2 = r1[r0]
            if (r2 == r3) goto L95
            char r2 = r1[r0]
            if (r2 == r4) goto L95
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L95:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f30780r
            int r2 = r8.sr
            int r3 = r8.f30779f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.xv.w.c.gd.sr.sr():java.lang.String");
    }

    private char ux() {
        int i4 = this.xv + 1;
        this.xv = i4;
        if (i4 != this.f30781w) {
            char[] cArr = this.f30780r;
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
                                return f();
                        }
                }
            }
            return cArr[i4];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f30778c);
    }

    private String w() {
        int i4 = this.xv + 1;
        this.xv = i4;
        this.sr = i4;
        this.ux = i4;
        while (true) {
            int i5 = this.xv;
            if (i5 != this.f30781w) {
                char[] cArr = this.f30780r;
                if (cArr[i5] == '\"') {
                    this.xv = i5 + 1;
                    while (true) {
                        int i6 = this.xv;
                        if (i6 >= this.f30781w || this.f30780r[i6] != ' ') {
                            break;
                        }
                        this.xv = i6 + 1;
                    }
                    char[] cArr2 = this.f30780r;
                    int i7 = this.sr;
                    return new String(cArr2, i7, this.ux - i7);
                }
                if (cArr[i5] == '\\') {
                    cArr[this.ux] = ux();
                } else {
                    cArr[this.ux] = cArr[i5];
                }
                this.xv++;
                this.ux++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f30778c);
            }
        }
    }

    private String xv() {
        int i4;
        int i5 = this.xv;
        if (i5 + 4 < this.f30781w) {
            this.sr = i5;
            this.xv = i5 + 1;
            while (true) {
                i4 = this.xv;
                if (i4 == this.f30781w) {
                    break;
                }
                char[] cArr = this.f30780r;
                if (cArr[i4] == '+' || cArr[i4] == ',' || cArr[i4] == ';') {
                    break;
                } else if (cArr[i4] == ' ') {
                    this.ux = i4;
                    this.xv = i4 + 1;
                    while (true) {
                        int i6 = this.xv;
                        if (i6 >= this.f30781w || this.f30780r[i6] != ' ') {
                            break;
                        }
                        this.xv = i6 + 1;
                    }
                } else {
                    if (cArr[i4] >= 'A' && cArr[i4] <= 'F') {
                        cArr[i4] = (char) (cArr[i4] + ' ');
                    }
                    this.xv = i4 + 1;
                }
            }
            this.ux = i4;
            int i7 = this.ux;
            int i8 = this.sr;
            int i9 = i7 - i8;
            if (i9 >= 5 && (i9 & 1) != 0) {
                int i10 = i9 / 2;
                byte[] bArr = new byte[i10];
                int i11 = i8 + 1;
                for (int i12 = 0; i12 < i10; i12++) {
                    bArr[i12] = (byte) c(i11);
                    i11 += 2;
                }
                return new String(this.f30780r, this.sr, i9);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.f30778c);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f30778c);
    }

    private int c(int i4) {
        int i5;
        int i6;
        int i7 = i4 + 1;
        if (i7 < this.f30781w) {
            char[] cArr = this.f30780r;
            char c4 = cArr[i4];
            if (c4 >= '0' && c4 <= '9') {
                i5 = c4 - '0';
            } else if (c4 >= 'a' && c4 <= 'f') {
                i5 = c4 - 'W';
            } else if (c4 < 'A' || c4 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f30778c);
            } else {
                i5 = c4 - '7';
            }
            char c5 = cArr[i7];
            if (c5 >= '0' && c5 <= '9') {
                i6 = c5 - '0';
            } else if (c5 >= 'a' && c5 <= 'f') {
                i6 = c5 - 'W';
            } else if (c5 < 'A' || c5 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f30778c);
            } else {
                i6 = c5 - '7';
            }
            return (i5 << 4) + i6;
        }
        throw new IllegalStateException("Malformed DN: " + this.f30778c);
    }

    public String c(String str) {
        String w3;
        this.xv = 0;
        this.sr = 0;
        this.ux = 0;
        this.f30779f = 0;
        this.f30780r = this.f30778c.toCharArray();
        String c4 = c();
        if (c4 == null) {
            return null;
        }
        do {
            int i4 = this.xv;
            if (i4 == this.f30781w) {
                return null;
            }
            char c5 = this.f30780r[i4];
            if (c5 == '\"') {
                w3 = w();
            } else if (c5 != '#') {
                w3 = (c5 == '+' || c5 == ',' || c5 == ';') ? "" : sr();
            } else {
                w3 = xv();
            }
            if (str.equalsIgnoreCase(c4)) {
                return w3;
            }
            int i5 = this.xv;
            if (i5 >= this.f30781w) {
                return null;
            }
            char[] cArr = this.f30780r;
            if (cArr[i5] != ',' && cArr[i5] != ';' && cArr[i5] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f30778c);
            }
            this.xv = i5 + 1;
            c4 = c();
        } while (c4 != null);
        throw new IllegalStateException("Malformed DN: " + this.f30778c);
    }
}
