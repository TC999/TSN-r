package javax.mail.internet;

/* compiled from: MailDateFormat.java */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class MailDateParser {
    int index = 0;
    char[] orig;

    public MailDateParser(char[] cArr) {
        this.orig = cArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getIndex() {
        return this.index;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a7 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int parseAlphaTimeZone() throws java.text.ParseException {
        /*
            r8 = this;
            java.lang.String r0 = "Bad Alpha TimeZone"
            char[] r1 = r8.orig     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            int r2 = r8.index     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            int r3 = r2 + 1
            r8.index = r3     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            char r2 = r1[r2]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            r4 = 0
            r5 = 116(0x74, float:1.63E-43)
            r6 = 84
            r7 = 1
            switch(r2) {
                case 67: goto L5e;
                case 69: goto L59;
                case 71: goto L38;
                case 77: goto L33;
                case 80: goto L2e;
                case 85: goto L19;
                case 99: goto L5e;
                case 101: goto L59;
                case 103: goto L38;
                case 109: goto L33;
                case 112: goto L2e;
                case 117: goto L19;
                default: goto L15;
            }     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
        L15:
            java.text.ParseException r1 = new java.text.ParseException     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            goto La8
        L19:
            int r2 = r3 + 1
            r8.index = r2     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            char r2 = r1[r3]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            if (r2 == r6) goto L2c
            if (r2 != r5) goto L24
            goto L2c
        L24:
            java.text.ParseException r1 = new java.text.ParseException     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            int r2 = r8.index     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            r1.<init>(r0, r2)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            throw r1     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
        L2c:
            r2 = 0
            goto L63
        L2e:
            r4 = 480(0x1e0, float:6.73E-43)
            r2 = 480(0x1e0, float:6.73E-43)
            goto L62
        L33:
            r4 = 420(0x1a4, float:5.89E-43)
            r2 = 420(0x1a4, float:5.89E-43)
            goto L62
        L38:
            int r2 = r3 + 1
            r8.index = r2     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            char r3 = r1[r3]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            r7 = 77
            if (r3 == r7) goto L46
            r7 = 109(0x6d, float:1.53E-43)
            if (r3 != r7) goto L51
        L46:
            int r3 = r2 + 1
            r8.index = r3     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            char r2 = r1[r2]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            if (r2 == r6) goto L2c
            if (r2 != r5) goto L51
            goto L2c
        L51:
            java.text.ParseException r1 = new java.text.ParseException     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            int r2 = r8.index     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            r1.<init>(r0, r2)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            throw r1     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
        L59:
            r4 = 300(0x12c, float:4.2E-43)
            r2 = 300(0x12c, float:4.2E-43)
            goto L62
        L5e:
            r4 = 360(0x168, float:5.04E-43)
            r2 = 360(0x168, float:5.04E-43)
        L62:
            r4 = 1
        L63:
            if (r4 == 0) goto La7
            int r3 = r8.index
            int r4 = r3 + 1
            r8.index = r4
            char r3 = r1[r3]
            r7 = 83
            if (r3 == r7) goto L94
            r7 = 115(0x73, float:1.61E-43)
            if (r3 != r7) goto L76
            goto L94
        L76:
            r7 = 68
            if (r3 == r7) goto L7e
            r7 = 100
            if (r3 != r7) goto La7
        L7e:
            int r3 = r4 + 1
            r8.index = r3
            char r1 = r1[r4]
            if (r1 == r6) goto L91
            if (r1 == r5) goto L89
            goto L91
        L89:
            java.text.ParseException r1 = new java.text.ParseException
            int r2 = r8.index
            r1.<init>(r0, r2)
            throw r1
        L91:
            int r2 = r2 + (-60)
            goto La7
        L94:
            int r3 = r4 + 1
            r8.index = r3
            char r1 = r1[r4]
            if (r1 == r6) goto La7
            if (r1 != r5) goto L9f
            goto La7
        L9f:
            java.text.ParseException r1 = new java.text.ParseException
            int r2 = r8.index
            r1.<init>(r0, r2)
            throw r1
        La7:
            return r2
        La8:
            int r2 = r8.index     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            r1.<init>(r0, r2)     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
            throw r1     // Catch: java.lang.ArrayIndexOutOfBoundsException -> Lae
        Lae:
            java.text.ParseException r1 = new java.text.ParseException
            int r2 = r8.index
            r1.<init>(r0, r2)
            goto Lb7
        Lb6:
            throw r1
        Lb7:
            goto Lb6
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MailDateParser.parseAlphaTimeZone():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x00d2, code lost:
        if (r3 == 'u') goto L78;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069 A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0088 A[Catch: ArrayIndexOutOfBoundsException -> 0x0155, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x0155, blocks: (B:3:0x0002, B:22:0x0046, B:23:0x0049, B:25:0x004e, B:28:0x0058, B:34:0x0069, B:38:0x0077, B:44:0x0088, B:47:0x0092, B:59:0x00a9, B:62:0x00b3, B:67:0x00c0, B:73:0x00d4, B:85:0x00eb, B:90:0x00f7, B:93:0x0101, B:99:0x0111, B:102:0x011b, B:107:0x0128, B:114:0x0139, B:120:0x0149), top: B:129:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int parseMonth() throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MailDateParser.parseMonth():int");
    }

    public int parseNumber() throws java.text.ParseException {
        int length = this.orig.length;
        boolean z = false;
        int i = 0;
        while (true) {
            int i2 = this.index;
            if (i2 >= length) {
                if (z) {
                    return i;
                }
                throw new java.text.ParseException("No Number found", this.index);
            }
            switch (this.orig[i2]) {
                case '0':
                    i *= 10;
                    break;
                case '1':
                    i = (i * 10) + 1;
                    break;
                case '2':
                    i = (i * 10) + 2;
                    break;
                case '3':
                    i = (i * 10) + 3;
                    break;
                case '4':
                    i = (i * 10) + 4;
                    break;
                case '5':
                    i = (i * 10) + 5;
                    break;
                case '6':
                    i = (i * 10) + 6;
                    break;
                case '7':
                    i = (i * 10) + 7;
                    break;
                case '8':
                    i = (i * 10) + 8;
                    break;
                case '9':
                    i = (i * 10) + 9;
                    break;
                default:
                    if (z) {
                        return i;
                    }
                    throw new java.text.ParseException("No Number found", this.index);
            }
            this.index = i2 + 1;
            z = true;
        }
    }

    public int parseNumericTimeZone() throws java.text.ParseException {
        boolean z;
        char[] cArr = this.orig;
        int i = this.index;
        this.index = i + 1;
        char c = cArr[i];
        if (c == '+') {
            z = true;
        } else if (c != '-') {
            throw new java.text.ParseException("Bad Numeric TimeZone", this.index);
        } else {
            z = false;
        }
        int parseNumber = parseNumber();
        int i2 = ((parseNumber / 100) * 60) + (parseNumber % 100);
        return z ? -i2 : i2;
    }

    public int parseTimeZone() throws java.text.ParseException {
        int i = this.index;
        char[] cArr = this.orig;
        if (i < cArr.length) {
            char c = cArr[i];
            if (c != '+' && c != '-') {
                return parseAlphaTimeZone();
            }
            return parseNumericTimeZone();
        }
        throw new java.text.ParseException("No more characters", this.index);
    }

    public int peekChar() throws java.text.ParseException {
        int i = this.index;
        char[] cArr = this.orig;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw new java.text.ParseException("No more characters", this.index);
    }

    public void skipChar(char c) throws java.text.ParseException {
        int i = this.index;
        char[] cArr = this.orig;
        if (i < cArr.length) {
            if (cArr[i] == c) {
                this.index = i + 1;
                return;
            }
            throw new java.text.ParseException("Wrong char", this.index);
        }
        throw new java.text.ParseException("No more characters", this.index);
    }

    public boolean skipIfChar(char c) throws java.text.ParseException {
        int i = this.index;
        char[] cArr = this.orig;
        if (i < cArr.length) {
            if (cArr[i] == c) {
                this.index = i + 1;
                return true;
            }
            return false;
        }
        throw new java.text.ParseException("No more characters", this.index);
    }

    public void skipUntilNumber() throws java.text.ParseException {
        while (true) {
            try {
                char[] cArr = this.orig;
                int i = this.index;
                switch (cArr[i]) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        return;
                    default:
                        this.index = i + 1;
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new java.text.ParseException("No Number Found", this.index);
            }
        }
    }

    public void skipWhiteSpace() {
        int length = this.orig.length;
        while (true) {
            int i = this.index;
            if (i >= length) {
                return;
            }
            char c = this.orig[i];
            if (c != '\t' && c != '\n' && c != '\r' && c != ' ') {
                return;
            }
            this.index = i + 1;
        }
    }
}
