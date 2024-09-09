package com.mbridge.msdk.thrid.okhttp.internal.tls;

import javax.security.auth.x500.X500Principal;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length;
    private int pos;

    DistinguishedNameParser(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.dn = name;
        this.length = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a1, code lost:
        return new java.lang.String(r1, r2, r8.cur - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String escapedAV() {
        /*
            r8 = this;
            int r0 = r8.pos
            r8.beg = r0
            r8.end = r0
        L6:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r3 = r8.end
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.chars
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
            int r2 = r8.end
            int r3 = r2 + 1
            r8.end = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.pos = r0
            goto L6
        L40:
            int r0 = r8.end
            int r2 = r0 + 1
            r8.end = r2
            char r2 = r8.getEscaped()
            r1[r0] = r2
            int r0 = r8.pos
            int r0 = r0 + 1
            r8.pos = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.beg
            int r3 = r8.end
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5e:
            int r2 = r8.end
            r8.cur = r2
            int r0 = r0 + 1
            r8.pos = r0
            int r0 = r2 + 1
            r8.end = r0
            r1[r2] = r6
        L6c:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 >= r1) goto L85
            char[] r2 = r8.chars
            char r7 = r2[r0]
            if (r7 != r6) goto L85
            int r1 = r8.end
            int r7 = r1 + 1
            r8.end = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.pos = r0
            goto L6c
        L85:
            if (r0 == r1) goto L95
            char[] r1 = r8.chars
            char r2 = r1[r0]
            if (r2 == r3) goto L95
            char r2 = r1[r0]
            if (r2 == r4) goto L95
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L95:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.chars
            int r2 = r8.beg
            int r3 = r8.cur
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.tls.DistinguishedNameParser.escapedAV():java.lang.String");
    }

    private int getByte(int i4) {
        int i5;
        int i6;
        int i7 = i4 + 1;
        if (i7 < this.length) {
            char[] cArr = this.chars;
            char c4 = cArr[i4];
            if (c4 >= '0' && c4 <= '9') {
                i5 = c4 - '0';
            } else if (c4 >= 'a' && c4 <= 'f') {
                i5 = c4 - 'W';
            } else if (c4 < 'A' || c4 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            } else {
                i5 = c4 - '7';
            }
            char c5 = cArr[i7];
            if (c5 >= '0' && c5 <= '9') {
                i6 = c5 - '0';
            } else if (c5 >= 'a' && c5 <= 'f') {
                i6 = c5 - 'W';
            } else if (c5 < 'A' || c5 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            } else {
                i6 = c5 - '7';
            }
            return (i5 << 4) + i6;
        }
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }

    private char getEscaped() {
        int i4 = this.pos + 1;
        this.pos = i4;
        if (i4 != this.length) {
            char[] cArr = this.chars;
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
                                return getUTF8();
                        }
                }
            }
            return cArr[i4];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    private char getUTF8() {
        int i4;
        int i5;
        int i6 = getByte(this.pos);
        this.pos++;
        if (i6 < 128) {
            return (char) i6;
        }
        if (i6 < 192 || i6 > 247) {
            return '?';
        }
        if (i6 <= 223) {
            i5 = i6 & 31;
            i4 = 1;
        } else if (i6 <= 239) {
            i4 = 2;
            i5 = i6 & 15;
        } else {
            i4 = 3;
            i5 = i6 & 7;
        }
        for (int i7 = 0; i7 < i4; i7++) {
            int i8 = this.pos + 1;
            this.pos = i8;
            if (i8 == this.length || this.chars[i8] != '\\') {
                return '?';
            }
            int i9 = i8 + 1;
            this.pos = i9;
            int i10 = getByte(i9);
            this.pos++;
            if ((i10 & 192) != 128) {
                return '?';
            }
            i5 = (i5 << 6) + (i10 & 63);
        }
        return (char) i5;
    }

    private String hexAV() {
        int i4;
        int i5 = this.pos;
        if (i5 + 4 < this.length) {
            this.beg = i5;
            this.pos = i5 + 1;
            while (true) {
                i4 = this.pos;
                if (i4 == this.length) {
                    break;
                }
                char[] cArr = this.chars;
                if (cArr[i4] == '+' || cArr[i4] == ',' || cArr[i4] == ';') {
                    break;
                } else if (cArr[i4] == ' ') {
                    this.end = i4;
                    this.pos = i4 + 1;
                    while (true) {
                        int i6 = this.pos;
                        if (i6 >= this.length || this.chars[i6] != ' ') {
                            break;
                        }
                        this.pos = i6 + 1;
                    }
                } else {
                    if (cArr[i4] >= 'A' && cArr[i4] <= 'F') {
                        cArr[i4] = (char) (cArr[i4] + ' ');
                    }
                    this.pos = i4 + 1;
                }
            }
            this.end = i4;
            int i7 = this.end;
            int i8 = this.beg;
            int i9 = i7 - i8;
            if (i9 >= 5 && (i9 & 1) != 0) {
                int i10 = i9 / 2;
                byte[] bArr = new byte[i10];
                int i11 = i8 + 1;
                for (int i12 = 0; i12 < i10; i12++) {
                    bArr[i12] = (byte) getByte(i11);
                    i11 += 2;
                }
                return new String(this.chars, this.beg, i9);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.dn);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    private String nextAT() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        while (true) {
            i4 = this.pos;
            i5 = this.length;
            if (i4 >= i5 || this.chars[i4] != ' ') {
                break;
            }
            this.pos = i4 + 1;
        }
        if (i4 == i5) {
            return null;
        }
        this.beg = i4;
        this.pos = i4 + 1;
        while (true) {
            i6 = this.pos;
            i7 = this.length;
            if (i6 >= i7) {
                break;
            }
            char[] cArr = this.chars;
            if (cArr[i6] == '=' || cArr[i6] == ' ') {
                break;
            }
            this.pos = i6 + 1;
        }
        if (i6 < i7) {
            this.end = i6;
            if (this.chars[i6] == ' ') {
                while (true) {
                    i8 = this.pos;
                    i9 = this.length;
                    if (i8 >= i9) {
                        break;
                    }
                    char[] cArr2 = this.chars;
                    if (cArr2[i8] == '=' || cArr2[i8] != ' ') {
                        break;
                    }
                    this.pos = i8 + 1;
                }
                if (this.chars[i8] != '=' || i8 == i9) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.dn);
                }
            }
            this.pos++;
            while (true) {
                int i10 = this.pos;
                if (i10 >= this.length || this.chars[i10] != ' ') {
                    break;
                }
                this.pos = i10 + 1;
            }
            int i11 = this.end;
            int i12 = this.beg;
            if (i11 - i12 > 4) {
                char[] cArr3 = this.chars;
                if (cArr3[i12 + 3] == '.' && ((cArr3[i12] == 'O' || cArr3[i12] == 'o') && ((cArr3[i12 + 1] == 'I' || cArr3[i12 + 1] == 'i') && (cArr3[i12 + 2] == 'D' || cArr3[i12 + 2] == 'd')))) {
                    this.beg = i12 + 4;
                }
            }
            char[] cArr4 = this.chars;
            int i13 = this.beg;
            return new String(cArr4, i13, i11 - i13);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.dn);
    }

    private String quotedAV() {
        int i4 = this.pos + 1;
        this.pos = i4;
        this.beg = i4;
        this.end = i4;
        while (true) {
            int i5 = this.pos;
            if (i5 != this.length) {
                char[] cArr = this.chars;
                if (cArr[i5] == '\"') {
                    this.pos = i5 + 1;
                    while (true) {
                        int i6 = this.pos;
                        if (i6 >= this.length || this.chars[i6] != ' ') {
                            break;
                        }
                        this.pos = i6 + 1;
                    }
                    char[] cArr2 = this.chars;
                    int i7 = this.beg;
                    return new String(cArr2, i7, this.end - i7);
                }
                if (cArr[i5] == '\\') {
                    cArr[this.end] = getEscaped();
                } else {
                    cArr[this.end] = cArr[i5];
                }
                this.pos++;
                this.end++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.dn);
            }
        }
    }

    public String findMostSpecific(String str) {
        String quotedAV;
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String nextAT = nextAT();
        if (nextAT == null) {
            return null;
        }
        do {
            int i4 = this.pos;
            if (i4 == this.length) {
                return null;
            }
            char c4 = this.chars[i4];
            if (c4 == '\"') {
                quotedAV = quotedAV();
            } else if (c4 != '#') {
                quotedAV = (c4 == '+' || c4 == ',' || c4 == ';') ? "" : escapedAV();
            } else {
                quotedAV = hexAV();
            }
            if (str.equalsIgnoreCase(nextAT)) {
                return quotedAV;
            }
            int i5 = this.pos;
            if (i5 >= this.length) {
                return null;
            }
            char[] cArr = this.chars;
            if (cArr[i5] != ',' && cArr[i5] != ';' && cArr[i5] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.dn);
            }
            this.pos = i5 + 1;
            nextAT = nextAT();
        } while (nextAT != null);
        throw new IllegalStateException("Malformed DN: " + this.dn);
    }
}
