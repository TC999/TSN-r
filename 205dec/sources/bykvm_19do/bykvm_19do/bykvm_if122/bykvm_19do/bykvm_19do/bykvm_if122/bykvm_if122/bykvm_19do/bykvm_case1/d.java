package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1;

import javax.security.auth.x500.X500Principal;

/* compiled from: DistinguishedNameParser.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
final class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f915a;

    /* renamed from: b  reason: collision with root package name */
    private final int f916b;

    /* renamed from: c  reason: collision with root package name */
    private int f917c;

    /* renamed from: d  reason: collision with root package name */
    private int f918d;

    /* renamed from: e  reason: collision with root package name */
    private int f919e;

    /* renamed from: f  reason: collision with root package name */
    private int f920f;

    /* renamed from: g  reason: collision with root package name */
    private char[] f921g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f915a = name;
        this.f916b = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
        return new java.lang.String(r1, r2, r8.f920f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.f917c
            r8.f918d = r0
            r8.f919e = r0
        L6:
            int r0 = r8.f917c
            int r1 = r8.f916b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f921g
            int r2 = r8.f918d
            int r3 = r8.f919e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f921g
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
            int r2 = r8.f919e
            int r3 = r2 + 1
            r8.f919e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f917c = r0
            goto L6
        L40:
            int r0 = r8.f919e
            int r2 = r0 + 1
            r8.f919e = r2
            char r2 = r8.b()
            r1[r0] = r2
            int r0 = r8.f917c
            int r0 = r0 + 1
            r8.f917c = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f918d
            int r3 = r8.f919e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5e:
            int r2 = r8.f919e
            r8.f920f = r2
            int r0 = r0 + 1
            r8.f917c = r0
            int r0 = r2 + 1
            r8.f919e = r0
            r1[r2] = r6
        L6c:
            int r0 = r8.f917c
            int r1 = r8.f916b
            if (r0 >= r1) goto L85
            char[] r2 = r8.f921g
            char r7 = r2[r0]
            if (r7 != r6) goto L85
            int r1 = r8.f919e
            int r7 = r1 + 1
            r8.f919e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f917c = r0
            goto L6c
        L85:
            if (r0 == r1) goto L95
            char[] r1 = r8.f921g
            char r2 = r1[r0]
            if (r2 == r3) goto L95
            char r2 = r1[r0]
            if (r2 == r4) goto L95
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L95:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f921g
            int r2 = r8.f918d
            int r3 = r8.f920f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.d.a():java.lang.String");
    }

    private char b() {
        int i4 = this.f917c + 1;
        this.f917c = i4;
        if (i4 != this.f916b) {
            char[] cArr = this.f921g;
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
                                return c();
                        }
                }
            }
            return cArr[i4];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f915a);
    }

    private char c() {
        int i4;
        int i5;
        int a4 = a(this.f917c);
        this.f917c++;
        if (a4 < 128) {
            return (char) a4;
        }
        if (a4 < 192 || a4 > 247) {
            return '?';
        }
        if (a4 <= 223) {
            i5 = a4 & 31;
            i4 = 1;
        } else if (a4 <= 239) {
            i4 = 2;
            i5 = a4 & 15;
        } else {
            i4 = 3;
            i5 = a4 & 7;
        }
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = this.f917c + 1;
            this.f917c = i7;
            if (i7 == this.f916b || this.f921g[i7] != '\\') {
                return '?';
            }
            int i8 = i7 + 1;
            this.f917c = i8;
            int a5 = a(i8);
            this.f917c++;
            if ((a5 & 192) != 128) {
                return '?';
            }
            i5 = (i5 << 6) + (a5 & 63);
        }
        return (char) i5;
    }

    private String d() {
        int i4;
        int i5 = this.f917c;
        if (i5 + 4 < this.f916b) {
            this.f918d = i5;
            this.f917c = i5 + 1;
            while (true) {
                i4 = this.f917c;
                if (i4 == this.f916b) {
                    break;
                }
                char[] cArr = this.f921g;
                if (cArr[i4] == '+' || cArr[i4] == ',' || cArr[i4] == ';') {
                    break;
                } else if (cArr[i4] == ' ') {
                    this.f919e = i4;
                    this.f917c = i4 + 1;
                    while (true) {
                        int i6 = this.f917c;
                        if (i6 >= this.f916b || this.f921g[i6] != ' ') {
                            break;
                        }
                        this.f917c = i6 + 1;
                    }
                } else {
                    if (cArr[i4] >= 'A' && cArr[i4] <= 'F') {
                        cArr[i4] = (char) (cArr[i4] + ' ');
                    }
                    this.f917c = i4 + 1;
                }
            }
            this.f919e = i4;
            int i7 = this.f919e;
            int i8 = this.f918d;
            int i9 = i7 - i8;
            if (i9 >= 5 && (i9 & 1) != 0) {
                int i10 = i9 / 2;
                byte[] bArr = new byte[i10];
                int i11 = i8 + 1;
                for (int i12 = 0; i12 < i10; i12++) {
                    bArr[i12] = (byte) a(i11);
                    i11 += 2;
                }
                return new String(this.f921g, this.f918d, i9);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.f915a);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f915a);
    }

    private String e() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        while (true) {
            i4 = this.f917c;
            i5 = this.f916b;
            if (i4 >= i5 || this.f921g[i4] != ' ') {
                break;
            }
            this.f917c = i4 + 1;
        }
        if (i4 == i5) {
            return null;
        }
        this.f918d = i4;
        this.f917c = i4 + 1;
        while (true) {
            i6 = this.f917c;
            i7 = this.f916b;
            if (i6 >= i7) {
                break;
            }
            char[] cArr = this.f921g;
            if (cArr[i6] == '=' || cArr[i6] == ' ') {
                break;
            }
            this.f917c = i6 + 1;
        }
        if (i6 < i7) {
            this.f919e = i6;
            if (this.f921g[i6] == ' ') {
                while (true) {
                    i8 = this.f917c;
                    i9 = this.f916b;
                    if (i8 >= i9) {
                        break;
                    }
                    char[] cArr2 = this.f921g;
                    if (cArr2[i8] == '=' || cArr2[i8] != ' ') {
                        break;
                    }
                    this.f917c = i8 + 1;
                }
                if (this.f921g[i8] != '=' || i8 == i9) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f915a);
                }
            }
            this.f917c++;
            while (true) {
                int i10 = this.f917c;
                if (i10 >= this.f916b || this.f921g[i10] != ' ') {
                    break;
                }
                this.f917c = i10 + 1;
            }
            int i11 = this.f919e;
            int i12 = this.f918d;
            if (i11 - i12 > 4) {
                char[] cArr3 = this.f921g;
                if (cArr3[i12 + 3] == '.' && (cArr3[i12] == 'O' || cArr3[i12] == 'o')) {
                    int i13 = i12 + 1;
                    if (cArr3[i13] == 'I' || cArr3[i13] == 'i') {
                        int i14 = i12 + 2;
                        if (cArr3[i14] == 'D' || cArr3[i14] == 'd') {
                            this.f918d = i12 + 4;
                        }
                    }
                }
            }
            char[] cArr4 = this.f921g;
            int i15 = this.f918d;
            return new String(cArr4, i15, i11 - i15);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f915a);
    }

    private String f() {
        int i4 = this.f917c + 1;
        this.f917c = i4;
        this.f918d = i4;
        this.f919e = i4;
        while (true) {
            int i5 = this.f917c;
            if (i5 != this.f916b) {
                char[] cArr = this.f921g;
                if (cArr[i5] == '\"') {
                    this.f917c = i5 + 1;
                    while (true) {
                        int i6 = this.f917c;
                        if (i6 >= this.f916b || this.f921g[i6] != ' ') {
                            break;
                        }
                        this.f917c = i6 + 1;
                    }
                    char[] cArr2 = this.f921g;
                    int i7 = this.f918d;
                    return new String(cArr2, i7, this.f919e - i7);
                }
                if (cArr[i5] == '\\') {
                    cArr[this.f919e] = b();
                } else {
                    cArr[this.f919e] = cArr[i5];
                }
                this.f917c++;
                this.f919e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f915a);
            }
        }
    }

    private int a(int i4) {
        int i5;
        int i6;
        int i7 = i4 + 1;
        if (i7 < this.f916b) {
            char[] cArr = this.f921g;
            char c4 = cArr[i4];
            if (c4 >= '0' && c4 <= '9') {
                i5 = c4 - '0';
            } else if (c4 >= 'a' && c4 <= 'f') {
                i5 = c4 - 'W';
            } else if (c4 < 'A' || c4 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f915a);
            } else {
                i5 = c4 - '7';
            }
            char c5 = cArr[i7];
            if (c5 >= '0' && c5 <= '9') {
                i6 = c5 - '0';
            } else if (c5 >= 'a' && c5 <= 'f') {
                i6 = c5 - 'W';
            } else if (c5 < 'A' || c5 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f915a);
            } else {
                i6 = c5 - '7';
            }
            return (i5 << 4) + i6;
        }
        throw new IllegalStateException("Malformed DN: " + this.f915a);
    }

    public String a(String str) {
        String f4;
        this.f917c = 0;
        this.f918d = 0;
        this.f919e = 0;
        this.f920f = 0;
        this.f921g = this.f915a.toCharArray();
        String e4 = e();
        if (e4 == null) {
            return null;
        }
        do {
            int i4 = this.f917c;
            if (i4 == this.f916b) {
                return null;
            }
            char c4 = this.f921g[i4];
            if (c4 == '\"') {
                f4 = f();
            } else if (c4 != '#') {
                f4 = (c4 == '+' || c4 == ',' || c4 == ';') ? "" : a();
            } else {
                f4 = d();
            }
            if (str.equalsIgnoreCase(e4)) {
                return f4;
            }
            int i5 = this.f917c;
            if (i5 >= this.f916b) {
                return null;
            }
            char[] cArr = this.f921g;
            if (cArr[i5] != ',' && cArr[i5] != ';' && cArr[i5] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f915a);
            }
            this.f917c = i5 + 1;
            e4 = e();
        } while (e4 != null);
        throw new IllegalStateException("Malformed DN: " + this.f915a);
    }
}
