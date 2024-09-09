package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class JSONLexerBase implements JSONLexer, Closeable {
    protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
    protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
    protected int bp;
    protected char ch;
    protected int eofPos;
    protected int features;
    protected boolean hasSpecial;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    protected int sp;
    protected String stringDefaultValue;
    protected int token;
    private static final ThreadLocal<char[]> SBUF_LOCAL = new ThreadLocal<>();
    protected static final char[] typeFieldName = ("\"" + JSON.DEFAULT_TYPE_KEY + "\":\"").toCharArray();
    protected static final int[] digits = new int[103];
    protected Calendar calendar = null;
    protected TimeZone timeZone = JSON.defaultTimeZone;
    protected Locale locale = JSON.defaultLocale;
    public int matchStat = 0;

    static {
        for (int i4 = 48; i4 <= 57; i4++) {
            digits[i4] = i4 - 48;
        }
        for (int i5 = 97; i5 <= 102; i5++) {
            digits[i5] = (i5 - 97) + 10;
        }
        for (int i6 = 65; i6 <= 70; i6++) {
            digits[i6] = (i6 - 65) + 10;
        }
    }

    public JSONLexerBase(int i4) {
        this.stringDefaultValue = null;
        this.features = i4;
        if ((i4 & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
        char[] cArr = SBUF_LOCAL.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
    }

    public static boolean isWhitespace(char c4) {
        return c4 <= ' ' && (c4 == ' ' || c4 == '\n' || c4 == '\r' || c4 == '\t' || c4 == '\f' || c4 == '\b');
    }

    public static String readString(char[] cArr, int i4) {
        int i5;
        char[] cArr2 = new char[i4];
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            char c4 = cArr[i6];
            if (c4 != '\\') {
                cArr2[i7] = c4;
                i7++;
            } else {
                i6++;
                char c5 = cArr[i6];
                if (c5 == '\"') {
                    i5 = i7 + 1;
                    cArr2[i7] = '\"';
                } else if (c5 != '\'') {
                    if (c5 != 'F') {
                        if (c5 == '\\') {
                            i5 = i7 + 1;
                            cArr2[i7] = '\\';
                        } else if (c5 == 'b') {
                            i5 = i7 + 1;
                            cArr2[i7] = '\b';
                        } else if (c5 != 'f') {
                            if (c5 == 'n') {
                                i5 = i7 + 1;
                                cArr2[i7] = '\n';
                            } else if (c5 == 'r') {
                                i5 = i7 + 1;
                                cArr2[i7] = '\r';
                            } else if (c5 != 'x') {
                                switch (c5) {
                                    case '/':
                                        i5 = i7 + 1;
                                        cArr2[i7] = '/';
                                        break;
                                    case '0':
                                        i5 = i7 + 1;
                                        cArr2[i7] = 0;
                                        break;
                                    case '1':
                                        i5 = i7 + 1;
                                        cArr2[i7] = 1;
                                        break;
                                    case '2':
                                        i5 = i7 + 1;
                                        cArr2[i7] = 2;
                                        break;
                                    case '3':
                                        i5 = i7 + 1;
                                        cArr2[i7] = 3;
                                        break;
                                    case '4':
                                        i5 = i7 + 1;
                                        cArr2[i7] = 4;
                                        break;
                                    case '5':
                                        i5 = i7 + 1;
                                        cArr2[i7] = 5;
                                        break;
                                    case '6':
                                        i5 = i7 + 1;
                                        cArr2[i7] = 6;
                                        break;
                                    case '7':
                                        i5 = i7 + 1;
                                        cArr2[i7] = 7;
                                        break;
                                    default:
                                        switch (c5) {
                                            case 't':
                                                i5 = i7 + 1;
                                                cArr2[i7] = '\t';
                                                break;
                                            case 'u':
                                                i5 = i7 + 1;
                                                int i8 = i6 + 1;
                                                int i9 = i8 + 1;
                                                int i10 = i9 + 1;
                                                i6 = i10 + 1;
                                                cArr2[i7] = (char) Integer.parseInt(new String(new char[]{cArr[i8], cArr[i9], cArr[i10], cArr[i6]}), 16);
                                                break;
                                            case 'v':
                                                i5 = i7 + 1;
                                                cArr2[i7] = 11;
                                                break;
                                            default:
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                i5 = i7 + 1;
                                int[] iArr = digits;
                                int i11 = i6 + 1;
                                i6 = i11 + 1;
                                cArr2[i7] = (char) ((iArr[cArr[i11]] * 16) + iArr[cArr[i6]]);
                            }
                        }
                    }
                    i5 = i7 + 1;
                    cArr2[i7] = '\f';
                } else {
                    i5 = i7 + 1;
                    cArr2[i7] = '\'';
                }
                i7 = i5;
            }
            i6++;
        }
        return new String(cArr2, 0, i7);
    }

    private void scanStringSingleQuote() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\'') {
                this.token = 4;
                next();
                return;
            } else if (next == 26) {
                if (!isEOF()) {
                    putChar((char) 26);
                } else {
                    throw new JSONException("unclosed single-quote string");
                }
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i4 = this.sp;
                    char[] cArr = this.sbuf;
                    if (i4 > cArr.length) {
                        char[] cArr2 = new char[i4 * 2];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.np + 1, this.sp, this.sbuf);
                }
                char next2 = next();
                if (next2 == '\"') {
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            putChar('\\');
                        } else if (next2 == 'b') {
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                putChar('\n');
                            } else if (next2 == 'r') {
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        putChar('/');
                                        continue;
                                    case '0':
                                        putChar((char) 0);
                                        continue;
                                    case '1':
                                        putChar((char) 1);
                                        continue;
                                    case '2':
                                        putChar((char) 2);
                                        continue;
                                    case '3':
                                        putChar((char) 3);
                                        continue;
                                    case '4':
                                        putChar((char) 4);
                                        continue;
                                    case '5':
                                        putChar((char) 5);
                                        continue;
                                    case '6':
                                        putChar((char) 6);
                                        continue;
                                    case '7':
                                        putChar((char) 7);
                                        continue;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                putChar('\t');
                                                continue;
                                            case 'u':
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                continue;
                                                continue;
                                            case 'v':
                                                putChar((char) 11);
                                                continue;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed single-quote string");
                                        }
                                }
                            } else {
                                int[] iArr = digits;
                                putChar((char) ((iArr[next()] * 16) + iArr[next()]));
                            }
                        }
                    }
                    putChar('\f');
                } else {
                    putChar('\'');
                }
            } else if (!this.hasSpecial) {
                this.sp++;
            } else {
                int i5 = this.sp;
                char[] cArr3 = this.sbuf;
                if (i5 == cArr3.length) {
                    putChar(next);
                } else {
                    this.sp = i5 + 1;
                    cArr3[i5] = next;
                }
            }
        }
    }

    public abstract String addSymbol(int i4, int i5, int i6, SymbolTable symbolTable);

    protected abstract void arrayCopy(int i4, char[] cArr, int i5, int i6);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract byte[] bytesValue();

    protected abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i4);

    @Override // com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8192) {
            SBUF_LOCAL.set(cArr);
        }
        this.sbuf = null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void config(Feature feature, boolean z3) {
        int config = Feature.config(this.features, feature, z3);
        this.features = config;
        if ((config & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
    }

    protected abstract void copyTo(int i4, int i5, char[] cArr);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number decimalValue(boolean z3) {
        char charAt = charAt((this.np + this.sp) - 1);
        try {
            if (charAt == 'F') {
                return Float.valueOf(Float.parseFloat(numberString()));
            }
            if (charAt == 'D') {
                return Double.valueOf(Double.parseDouble(numberString()));
            }
            if (z3) {
                return decimalValue();
            }
            return Double.valueOf(doubleValue());
        } catch (NumberFormatException e4) {
            throw new JSONException(e4.getMessage() + ", " + info());
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract BigDecimal decimalValue();

    public double doubleValue() {
        return Double.parseDouble(numberString());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public float floatValue() {
        char charAt;
        String numberString = numberString();
        float parseFloat = Float.parseFloat(numberString);
        if ((parseFloat == 0.0f || parseFloat == Float.POSITIVE_INFINITY) && (charAt = numberString.charAt(0)) > '0' && charAt <= '9') {
            throw new JSONException("float overflow : " + numberString);
        }
        return parseFloat;
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final char getCurrent() {
        return this.ch;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Locale getLocale() {
        return this.locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public abstract int indexOf(char c4, int i4);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        return "";
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int intValue() {
        int i4;
        boolean z3;
        int i5 = 0;
        if (this.np == -1) {
            this.np = 0;
        }
        int i6 = this.np;
        int i7 = this.sp + i6;
        if (charAt(i6) == '-') {
            i4 = Integer.MIN_VALUE;
            i6++;
            z3 = true;
        } else {
            i4 = -2147483647;
            z3 = false;
        }
        if (i6 < i7) {
            i5 = -(charAt(i6) - '0');
            i6++;
        }
        while (i6 < i7) {
            int i8 = i6 + 1;
            char charAt = charAt(i6);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                i6 = i8;
                break;
            }
            int i9 = charAt - '0';
            if (i5 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i10 = i5 * 10;
            if (i10 < i4 + i9) {
                throw new NumberFormatException(numberString());
            }
            i5 = i10 - i9;
            i6 = i8;
        }
        if (z3) {
            if (i6 > this.np + 1) {
                return i5;
            }
            throw new NumberFormatException(numberString());
        }
        return -i5;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number integerValue() throws NumberFormatException {
        long j4;
        long j5;
        boolean z3 = false;
        if (this.np == -1) {
            this.np = 0;
        }
        int i4 = this.np;
        int i5 = this.sp + i4;
        char c4 = ' ';
        char charAt = charAt(i5 - 1);
        if (charAt == 'B') {
            i5--;
            c4 = 'B';
        } else if (charAt == 'L') {
            i5--;
            c4 = 'L';
        } else if (charAt == 'S') {
            i5--;
            c4 = 'S';
        }
        if (charAt(this.np) == '-') {
            j4 = Long.MIN_VALUE;
            i4++;
            z3 = true;
        } else {
            j4 = -9223372036854775807L;
        }
        long j6 = -922337203685477580L;
        if (i4 < i5) {
            j5 = -(charAt(i4) - '0');
            i4++;
        } else {
            j5 = 0;
        }
        while (i4 < i5) {
            int i6 = i4 + 1;
            int charAt2 = charAt(i4) - '0';
            if (j5 < j6) {
                return new BigInteger(numberString());
            }
            long j7 = j5 * 10;
            long j8 = charAt2;
            if (j7 < j4 + j8) {
                return new BigInteger(numberString());
            }
            j5 = j7 - j8;
            i4 = i6;
            j6 = -922337203685477580L;
        }
        if (!z3) {
            long j9 = -j5;
            if (j9 > 2147483647L || c4 == 'L') {
                return Long.valueOf(j9);
            }
            if (c4 == 'S') {
                return Short.valueOf((short) j9);
            }
            if (c4 == 'B') {
                return Byte.valueOf((byte) j9);
            }
            return Integer.valueOf((int) j9);
        } else if (i4 > this.np + 1) {
            if (j5 < -2147483648L || c4 == 'L') {
                return Long.valueOf(j5);
            }
            if (c4 == 'S') {
                return Short.valueOf((short) j5);
            }
            if (c4 == 'B') {
                return Byte.valueOf((byte) j5);
            }
            return Integer.valueOf((int) j5);
        } else {
            throw new NumberFormatException(numberString());
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean isBlankInput() {
        int i4 = 0;
        while (true) {
            char charAt = charAt(i4);
            if (charAt == 26) {
                this.token = 20;
                return true;
            } else if (!isWhitespace(charAt)) {
                return false;
            } else {
                i4++;
            }
        }
    }

    public abstract boolean isEOF();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(Feature feature) {
        return isEnabled(feature.mask);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isRef() {
        return this.sp == 4 && charAt(this.np + 1) == '$' && charAt(this.np + 2) == 'r' && charAt(this.np + 3) == 'e' && charAt(this.np + 4) == 'f';
    }

    protected void lexError(String str, Object... objArr) {
        this.token = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0085  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005c -> B:12:0x0032). Please submit an issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long longValue() throws java.lang.NumberFormatException {
        /*
            r15 = this;
            int r0 = r15.np
            r1 = 0
            r2 = -1
            if (r0 != r2) goto L8
            r15.np = r1
        L8:
            int r0 = r15.np
            int r2 = r15.sp
            int r2 = r2 + r0
            char r3 = r15.charAt(r0)
            r4 = 45
            r5 = 1
            if (r3 != r4) goto L1c
            r3 = -9223372036854775808
            int r0 = r0 + 1
            r1 = 1
            goto L21
        L1c:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L21:
            r6 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            if (r0 >= r2) goto L34
            int r8 = r0 + 1
            char r0 = r15.charAt(r0)
            int r0 = r0 + (-48)
            int r0 = -r0
            long r9 = (long) r0
        L32:
            r0 = r8
            goto L36
        L34:
            r9 = 0
        L36:
            if (r0 >= r2) goto L73
            int r8 = r0 + 1
            char r0 = r15.charAt(r0)
            r11 = 76
            if (r0 == r11) goto L72
            r11 = 83
            if (r0 == r11) goto L72
            r11 = 66
            if (r0 != r11) goto L4b
            goto L72
        L4b:
            int r0 = r0 + (-48)
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 < 0) goto L68
            r11 = 10
            long r9 = r9 * r11
            long r11 = (long) r0
            long r13 = r3 + r11
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 < 0) goto L5e
            long r9 = r9 - r11
            goto L32
        L5e:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.numberString()
            r0.<init>(r1)
            throw r0
        L68:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.numberString()
            r0.<init>(r1)
            throw r0
        L72:
            r0 = r8
        L73:
            if (r1 == 0) goto L85
            int r1 = r15.np
            int r1 = r1 + r5
            if (r0 <= r1) goto L7b
            return r9
        L7b:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r15.numberString()
            r0.<init>(r1)
            throw r0
        L85:
            long r0 = -r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.longValue():long");
    }

    public final boolean matchField(char[] cArr) {
        if (charArrayCompare(cArr)) {
            int length = this.bp + cArr.length;
            this.bp = length;
            char charAt = charAt(length);
            this.ch = charAt;
            if (charAt == '{') {
                next();
                this.token = 12;
            } else if (charAt == '[') {
                next();
                this.token = 14;
            } else if (charAt == 'S' && charAt(this.bp + 1) == 'e' && charAt(this.bp + 2) == 't' && charAt(this.bp + 3) == '[') {
                int i4 = this.bp + 3;
                this.bp = i4;
                this.ch = charAt(i4);
                this.token = 21;
            } else {
                nextToken();
            }
            return true;
        }
        return false;
    }

    public final int matchStat() {
        return this.matchStat;
    }

    public Collection<String> newCollectionByType(Class<?> cls) {
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception e4) {
            throw new JSONException(e4.getMessage(), e4);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract char next();

    public final void nextIdent() {
        while (isWhitespace(this.ch)) {
            next();
        }
        char c4 = this.ch;
        if (c4 != '_' && !Character.isLetter(c4)) {
            nextToken();
        } else {
            scanIdent();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken() {
        this.sp = 0;
        while (true) {
            this.pos = this.bp;
            char c4 = this.ch;
            if (c4 == '/') {
                skipComment();
            } else if (c4 == '\"') {
                scanString();
                return;
            } else if (c4 == ',') {
                next();
                this.token = 16;
                return;
            } else if (c4 >= '0' && c4 <= '9') {
                scanNumber();
                return;
            } else if (c4 == '-') {
                scanNumber();
                return;
            } else {
                switch (c4) {
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                        next();
                        continue;
                    case '\'':
                        if (isEnabled(Feature.AllowSingleQuotes)) {
                            scanStringSingleQuote();
                            return;
                        }
                        throw new JSONException("Feature.AllowSingleQuotes is false");
                    case '(':
                        next();
                        this.token = 10;
                        return;
                    case ')':
                        next();
                        this.token = 11;
                        return;
                    case '+':
                        next();
                        scanNumber();
                        return;
                    case '.':
                        next();
                        this.token = 25;
                        return;
                    case ':':
                        next();
                        this.token = 17;
                        return;
                    case ';':
                        next();
                        this.token = 24;
                        return;
                    case 'N':
                    case 'S':
                    case 'T':
                    case 'u':
                        scanIdent();
                        return;
                    case '[':
                        next();
                        this.token = 14;
                        return;
                    case ']':
                        next();
                        this.token = 15;
                        return;
                    case 'f':
                        scanFalse();
                        return;
                    case 'n':
                        scanNullOrNew();
                        return;
                    case 't':
                        scanTrue();
                        return;
                    case 'x':
                        scanHex();
                        return;
                    case '{':
                        next();
                        this.token = 12;
                        return;
                    case '}':
                        next();
                        this.token = 13;
                        return;
                    default:
                        if (isEOF()) {
                            if (this.token != 20) {
                                this.token = 20;
                                int i4 = this.eofPos;
                                this.bp = i4;
                                this.pos = i4;
                                return;
                            }
                            throw new JSONException("EOF error");
                        }
                        char c5 = this.ch;
                        if (c5 > 31 && c5 != '\u007f') {
                            lexError("illegal.char", String.valueOf((int) c5));
                            next();
                            return;
                        }
                        next();
                        continue;
                }
            }
        }
    }

    public final void nextTokenWithChar(char c4) {
        this.sp = 0;
        while (true) {
            char c5 = this.ch;
            if (c5 == c4) {
                next();
                nextToken();
                return;
            } else if (c5 != ' ' && c5 != '\n' && c5 != '\r' && c5 != '\t' && c5 != '\f' && c5 != '\b') {
                throw new JSONException("not match " + c4 + " - " + this.ch + ", info : " + info());
            } else {
                next();
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon() {
        nextTokenWithChar(':');
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String numberString();

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int pos() {
        return this.pos;
    }

    protected final void putChar(char c4) {
        int i4 = this.sp;
        char[] cArr = this.sbuf;
        if (i4 == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.sbuf = cArr2;
        }
        char[] cArr3 = this.sbuf;
        int i5 = this.sp;
        this.sp = i5 + 1;
        cArr3[i5] = c4;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void resetStringPosition() {
        this.sp = 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean scanBoolean(char c4) {
        boolean z3 = false;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        int i4 = 5;
        if (charAt == 't') {
            if (charAt(this.bp + 1) == 'r' && charAt(this.bp + 1 + 1) == 'u' && charAt(this.bp + 1 + 2) == 'e') {
                charAt = charAt(this.bp + 4);
                z3 = true;
            } else {
                this.matchStat = -1;
                return false;
            }
        } else if (charAt != 'f') {
            if (charAt == '1') {
                charAt = charAt(this.bp + 1);
                z3 = true;
            } else if (charAt == '0') {
                charAt = charAt(this.bp + 1);
            } else {
                i4 = 1;
            }
            i4 = 2;
        } else if (charAt(this.bp + 1) == 'a' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 's' && charAt(this.bp + 1 + 3) == 'e') {
            charAt = charAt(this.bp + 5);
            i4 = 6;
        } else {
            this.matchStat = -1;
            return false;
        }
        while (charAt != c4) {
            if (isWhitespace(charAt)) {
                charAt = charAt(this.bp + i4);
                i4++;
            } else {
                this.matchStat = -1;
                return z3;
            }
        }
        int i5 = this.bp + i4;
        this.bp = i5;
        this.ch = charAt(i5);
        this.matchStat = 3;
        return z3;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final double scanDouble(char c4) {
        int i4;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        if (charAt2 >= '0' && charAt2 <= '9') {
            int i5 = 1;
            while (true) {
                i4 = i5 + 1;
                charAt = charAt(this.bp + i5);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i5 = i4;
            }
            if (charAt == '.') {
                int i6 = i4 + 1;
                char charAt3 = charAt(this.bp + i4);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    while (true) {
                        i4 = i6 + 1;
                        charAt = charAt(this.bp + i6);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i6 = i4;
                    }
                } else {
                    this.matchStat = -1;
                    return 0.0d;
                }
            }
            int i7 = this.bp;
            double parseDouble = Double.parseDouble(subString(i7, ((i7 + i4) - i7) - 1));
            if (charAt == c4) {
                int i8 = this.bp + i4;
                this.bp = i8;
                this.ch = charAt(i8);
                this.matchStat = 3;
                this.token = 16;
                return parseDouble;
            }
            this.matchStat = -1;
            return parseDouble;
        }
        this.matchStat = -1;
        return 0.0d;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c4) {
        String scanSymbolWithSeperator = scanSymbolWithSeperator(symbolTable, c4);
        if (scanSymbolWithSeperator == null) {
            return null;
        }
        return Enum.valueOf(cls, scanSymbolWithSeperator);
    }

    public final void scanFalse() {
        if (this.ch == 'f') {
            next();
            if (this.ch == 'a') {
                next();
                if (this.ch == 'l') {
                    next();
                    if (this.ch == 's') {
                        next();
                        if (this.ch == 'e') {
                            next();
                            char c4 = this.ch;
                            if (c4 != ' ' && c4 != ',' && c4 != '}' && c4 != ']' && c4 != '\n' && c4 != '\r' && c4 != '\t' && c4 != 26 && c4 != '\f' && c4 != '\b' && c4 != ':' && c4 != '/') {
                                throw new JSONException("scan false error");
                            }
                            this.token = 7;
                            return;
                        }
                        throw new JSONException("error parse false");
                    }
                    throw new JSONException("error parse false");
                }
                throw new JSONException("error parse false");
            }
            throw new JSONException("error parse false");
        }
        throw new JSONException("error parse false");
    }

    public boolean scanFieldBoolean(char[] cArr) {
        int i4;
        boolean z3;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = cArr.length;
        int i5 = length + 1;
        char charAt = charAt(this.bp + length);
        if (charAt == 't') {
            int i6 = i5 + 1;
            if (charAt(this.bp + i5) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i7 = i6 + 1;
            if (charAt(this.bp + i6) != 'u') {
                this.matchStat = -1;
                return false;
            }
            i4 = i7 + 1;
            if (charAt(this.bp + i7) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z3 = true;
        } else if (charAt == 'f') {
            int i8 = i5 + 1;
            if (charAt(this.bp + i5) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i9 = i8 + 1;
            if (charAt(this.bp + i8) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i10 = i9 + 1;
            if (charAt(this.bp + i9) != 's') {
                this.matchStat = -1;
                return false;
            }
            int i11 = i10 + 1;
            if (charAt(this.bp + i10) != 'e') {
                this.matchStat = -1;
                return false;
            }
            i4 = i11;
            z3 = false;
        } else {
            this.matchStat = -1;
            return false;
        }
        int i12 = i4 + 1;
        char charAt2 = charAt(this.bp + i4);
        if (charAt2 == ',') {
            int i13 = this.bp + i12;
            this.bp = i13;
            this.ch = charAt(i13);
            this.matchStat = 3;
            this.token = 16;
            return z3;
        } else if (charAt2 == '}') {
            int i14 = i12 + 1;
            char charAt3 = charAt(this.bp + i12);
            if (charAt3 == ',') {
                this.token = 16;
                int i15 = this.bp + i14;
                this.bp = i15;
                this.ch = charAt(i15);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i16 = this.bp + i14;
                this.bp = i16;
                this.ch = charAt(i16);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i17 = this.bp + i14;
                this.bp = i17;
                this.ch = charAt(i17);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i14 - 1;
                this.ch = (char) 26;
            } else {
                this.matchStat = -1;
                return false;
            }
            this.matchStat = 4;
            return z3;
        } else {
            this.matchStat = -1;
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007b A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x007d -> B:34:0x006e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final double scanFieldDouble(char[] r11) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldDouble(char[]):double");
    }

    public final float scanFieldFloat(char[] cArr) {
        int i4;
        char charAt;
        int i5;
        int length;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0f;
        }
        int length2 = cArr.length;
        int i6 = length2 + 1;
        char charAt2 = charAt(this.bp + length2);
        if (charAt2 >= '0' && charAt2 <= '9') {
            while (true) {
                i4 = i6 + 1;
                charAt = charAt(this.bp + i6);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i6 = i4;
            }
            if (charAt == '.') {
                int i7 = i4 + 1;
                char charAt3 = charAt(this.bp + i4);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    while (true) {
                        i4 = i7 + 1;
                        charAt = charAt(this.bp + i7);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i7 = i4;
                    }
                } else {
                    this.matchStat = -1;
                    return 0.0f;
                }
            }
            float parseFloat = Float.parseFloat(subString(cArr.length + this.bp, ((i5 + i4) - length) - 1));
            if (charAt == ',') {
                int i8 = this.bp + i4;
                this.bp = i8;
                this.ch = charAt(i8);
                this.matchStat = 3;
                this.token = 16;
                return parseFloat;
            } else if (charAt == '}') {
                int i9 = i4 + 1;
                char charAt4 = charAt(this.bp + i4);
                if (charAt4 == ',') {
                    this.token = 16;
                    int i10 = this.bp + i9;
                    this.bp = i10;
                    this.ch = charAt(i10);
                } else if (charAt4 == ']') {
                    this.token = 15;
                    int i11 = this.bp + i9;
                    this.bp = i11;
                    this.ch = charAt(i11);
                } else if (charAt4 == '}') {
                    this.token = 13;
                    int i12 = this.bp + i9;
                    this.bp = i12;
                    this.ch = charAt(i12);
                } else if (charAt4 == 26) {
                    this.bp += i9 - 1;
                    this.token = 20;
                    this.ch = (char) 26;
                } else {
                    this.matchStat = -1;
                    return 0.0f;
                }
                this.matchStat = 4;
                return parseFloat;
            } else {
                this.matchStat = -1;
                return 0.0f;
            }
        }
        this.matchStat = -1;
        return 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a9, code lost:
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ab, code lost:
        return r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00dd A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x00d9 -> B:59:0x00db). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float[] scanFieldFloatArray(char[] r20) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray(char[]):float[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x0218, code lost:
        r6 = r4;
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x021b, code lost:
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b1, code lost:
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b3, code lost:
        return r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00e1 -> B:58:0x00e3). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float[][] scanFieldFloatArray2(char[] r20) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldFloatArray2(char[]):float[][]");
    }

    public int scanFieldInt(char[] cArr) {
        int i4;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i5 = length + 1;
        char charAt2 = charAt(this.bp + length);
        boolean z3 = charAt2 == '-';
        if (z3) {
            charAt2 = charAt(this.bp + i5);
            i5++;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i6 = charAt2 - '0';
        while (true) {
            i4 = i5 + 1;
            charAt = charAt(this.bp + i5);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i6 = (i6 * 10) + (charAt - '0');
            i5 = i4;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if ((i6 < 0 || i4 > cArr.length + 14) && !(i6 == Integer.MIN_VALUE && i4 == 17 && z3)) {
            this.matchStat = -1;
            return 0;
        } else if (charAt == ',') {
            int i7 = this.bp + i4;
            this.bp = i7;
            this.ch = charAt(i7);
            this.matchStat = 3;
            this.token = 16;
            return z3 ? -i6 : i6;
        } else if (charAt == '}') {
            int i8 = i4 + 1;
            char charAt3 = charAt(this.bp + i4);
            if (charAt3 == ',') {
                this.token = 16;
                int i9 = this.bp + i8;
                this.bp = i9;
                this.ch = charAt(i9);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i10 = this.bp + i8;
                this.bp = i10;
                this.ch = charAt(i10);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i11 = this.bp + i8;
                this.bp = i11;
                this.ch = charAt(i11);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i8 - 1;
                this.ch = (char) 26;
            } else {
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = 4;
            return z3 ? -i6 : i6;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    public final int[] scanFieldIntArray(char[] cArr) {
        boolean z3;
        int i4;
        char charAt;
        int i5;
        int i6;
        char charAt2;
        this.matchStat = 0;
        int[] iArr = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i7 = length + 1;
        if (charAt(this.bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i8 = i7 + 1;
        char charAt3 = charAt(this.bp + i7);
        int[] iArr2 = new int[16];
        if (charAt3 == ']') {
            i6 = i8 + 1;
            charAt2 = charAt(this.bp + i8);
            i5 = 0;
        } else {
            int i9 = 0;
            while (true) {
                if (charAt3 == '-') {
                    charAt3 = charAt(this.bp + i8);
                    i8++;
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (charAt3 < '0' || charAt3 > '9') {
                    break;
                }
                int i10 = charAt3 - '0';
                while (true) {
                    i4 = i8 + 1;
                    charAt = charAt(this.bp + i8);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i10 = (i10 * 10) + (charAt - '0');
                    i8 = i4;
                }
                if (i9 >= iArr2.length) {
                    int[] iArr3 = new int[(iArr2.length * 3) / 2];
                    System.arraycopy(iArr2, 0, iArr3, 0, i9);
                    iArr2 = iArr3;
                }
                i5 = i9 + 1;
                if (z3) {
                    i10 = -i10;
                }
                iArr2[i9] = i10;
                if (charAt == ',') {
                    i4++;
                    charAt = charAt(this.bp + i4);
                } else if (charAt == ']') {
                    i6 = i4 + 1;
                    charAt2 = charAt(this.bp + i4);
                    break;
                }
                i9 = i5;
                iArr = null;
                charAt3 = charAt;
                i8 = i4;
            }
            int[] iArr4 = iArr;
            this.matchStat = -1;
            return iArr4;
        }
        if (i5 != iArr2.length) {
            int[] iArr5 = new int[i5];
            System.arraycopy(iArr2, 0, iArr5, 0, i5);
            iArr2 = iArr5;
        }
        if (charAt2 == ',') {
            this.bp += i6 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr2;
        } else if (charAt2 == '}') {
            int i11 = i6 + 1;
            char charAt4 = charAt(this.bp + i6);
            if (charAt4 == ',') {
                this.token = 16;
                this.bp += i11 - 1;
                next();
            } else if (charAt4 == ']') {
                this.token = 15;
                this.bp += i11 - 1;
                next();
            } else if (charAt4 == '}') {
                this.token = 13;
                this.bp += i11 - 1;
                next();
            } else if (charAt4 == 26) {
                this.bp += i11 - 1;
                this.token = 20;
                this.ch = (char) 26;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return iArr2;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public long scanFieldLong(char[] cArr) {
        int i4;
        char charAt;
        boolean z3 = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i5 = length + 1;
        char charAt2 = charAt(this.bp + length);
        if (charAt2 == '-') {
            charAt2 = charAt(this.bp + i5);
            i5++;
            z3 = true;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j4 = charAt2 - '0';
        while (true) {
            i4 = i5 + 1;
            charAt = charAt(this.bp + i5);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j4 = (j4 * 10) + (charAt - '0');
            i5 = i4;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        } else if (j4 < 0 || i4 > 21) {
            this.matchStat = -1;
            return 0L;
        } else if (charAt == ',') {
            int i6 = this.bp + i4;
            this.bp = i6;
            this.ch = charAt(i6);
            this.matchStat = 3;
            this.token = 16;
            return z3 ? -j4 : j4;
        } else if (charAt == '}') {
            int i7 = i4 + 1;
            char charAt3 = charAt(this.bp + i4);
            if (charAt3 == ',') {
                this.token = 16;
                int i8 = this.bp + i7;
                this.bp = i8;
                this.ch = charAt(i8);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i9 = this.bp + i7;
                this.bp = i9;
                this.ch = charAt(i9);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i10 = this.bp + i7;
                this.bp = i10;
                this.ch = charAt(i10);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i7 - 1;
                this.ch = (char) 26;
            } else {
                this.matchStat = -1;
                return 0L;
            }
            this.matchStat = 4;
            return z3 ? -j4 : j4;
        } else {
            this.matchStat = -1;
            return 0L;
        }
    }

    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = cArr.length;
        int i4 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', this.bp + cArr.length + 1);
        if (indexOf != -1) {
            int length2 = this.bp + cArr.length + 1;
            String subString = subString(length2, indexOf - length2);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i5 = 0;
                    for (int i6 = indexOf - 1; i6 >= 0 && charAt(i6) == '\\'; i6--) {
                        i5++;
                    }
                    if (i5 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int i7 = this.bp;
                int length3 = indexOf - ((cArr.length + i7) + 1);
                subString = readString(sub_chars(i7 + cArr.length + 1, length3), length3);
            }
            int i8 = this.bp;
            int length4 = i4 + (indexOf - ((cArr.length + i8) + 1)) + 1;
            int i9 = length4 + 1;
            char charAt = charAt(i8 + length4);
            if (charAt == ',') {
                int i10 = this.bp + i9;
                this.bp = i10;
                this.ch = charAt(i10);
                this.matchStat = 3;
                return subString;
            } else if (charAt == '}') {
                int i11 = i9 + 1;
                char charAt2 = charAt(this.bp + i9);
                if (charAt2 == ',') {
                    this.token = 16;
                    int i12 = this.bp + i11;
                    this.bp = i12;
                    this.ch = charAt(i12);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    int i13 = this.bp + i11;
                    this.bp = i13;
                    this.ch = charAt(i13);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    int i14 = this.bp + i11;
                    this.bp = i14;
                    this.ch = charAt(i14);
                } else if (charAt2 == 26) {
                    this.token = 20;
                    this.bp += i11 - 1;
                    this.ch = (char) 26;
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
                this.matchStat = 4;
                return subString;
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        throw new JSONException("unclosed str");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ef, code lost:
        if (r13.size() != 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f1, code lost:
        r12 = charAt(r11.bp + r1);
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fb, code lost:
        if (r12 != ',') goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fd, code lost:
        r12 = r11.bp + r1;
        r11.bp = r12;
        r11.ch = charAt(r12);
        r11.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x010b, code lost:
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x010e, code lost:
        if (r12 != '}') goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0110, code lost:
        r6 = r1 + 1;
        r12 = charAt(r11.bp + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0119, code lost:
        if (r12 != ',') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x011b, code lost:
        r11.token = 16;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012b, code lost:
        if (r12 != ']') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x012d, code lost:
        r11.token = 15;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013d, code lost:
        if (r12 != '}') goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x013f, code lost:
        r11.token = 13;
        r12 = r11.bp + r6;
        r11.bp = r12;
        r11.ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0151, code lost:
        if (r12 != 26) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0153, code lost:
        r11.bp += r6 - 1;
        r11.token = 20;
        r11.ch = 26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0160, code lost:
        r11.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0163, code lost:
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0164, code lost:
        r11.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0166, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0167, code lost:
        r11.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0169, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0172, code lost:
        throw new com.alibaba.fastjson.JSONException("illega str");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r12, java.lang.Class<?> r13) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i4 = length + 1;
        if (charAt(this.bp + length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j4 = -2128831035;
        while (true) {
            int i5 = i4 + 1;
            char charAt = charAt(this.bp + i4);
            if (charAt == '\"') {
                int i6 = i5 + 1;
                char charAt2 = charAt(this.bp + i5);
                if (charAt2 == ',') {
                    int i7 = this.bp + i6;
                    this.bp = i7;
                    this.ch = charAt(i7);
                    this.matchStat = 3;
                    return j4;
                } else if (charAt2 == '}') {
                    int i8 = i6 + 1;
                    char charAt3 = charAt(this.bp + i6);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i9 = this.bp + i8;
                        this.bp = i9;
                        this.ch = charAt(i9);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i10 = this.bp + i8;
                        this.bp = i10;
                        this.ch = charAt(i10);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i11 = this.bp + i8;
                        this.bp = i11;
                        this.ch = charAt(i11);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i8 - 1;
                        this.ch = (char) 26;
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.matchStat = 4;
                    return j4;
                } else {
                    this.matchStat = -1;
                    return 0L;
                }
            }
            j4 = (j4 ^ charAt) * 16777619;
            if (charAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i4 = i5;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final float scanFloat(char c4) {
        int i4;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        if (charAt2 >= '0' && charAt2 <= '9') {
            int i5 = 1;
            while (true) {
                i4 = i5 + 1;
                charAt = charAt(this.bp + i5);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i5 = i4;
            }
            if (charAt == '.') {
                int i6 = i4 + 1;
                char charAt3 = charAt(this.bp + i4);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    while (true) {
                        i4 = i6 + 1;
                        charAt = charAt(this.bp + i6);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i6 = i4;
                    }
                } else {
                    this.matchStat = -1;
                    return 0.0f;
                }
            }
            int i7 = this.bp;
            float parseFloat = Float.parseFloat(subString(i7, ((i7 + i4) - i7) - 1));
            if (charAt == c4) {
                int i8 = this.bp + i4;
                this.bp = i8;
                this.ch = charAt(i8);
                this.matchStat = 3;
                this.token = 16;
                return parseFloat;
            }
            this.matchStat = -1;
            return parseFloat;
        }
        this.matchStat = -1;
        return 0.0f;
    }

    public final void scanHex() {
        char next;
        if (this.ch == 'x') {
            next();
            if (this.ch == '\'') {
                this.np = this.bp;
                next();
                while (true) {
                    next = next();
                    if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                        break;
                    }
                    this.sp++;
                }
                if (next == '\'') {
                    this.sp++;
                    next();
                    this.token = 26;
                    return;
                }
                throw new JSONException("illegal state. " + next);
            }
            throw new JSONException("illegal state. " + this.ch);
        }
        throw new JSONException("illegal state. " + this.ch);
    }

    public final void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String stringVal = stringVal();
        if ("null".equalsIgnoreCase(stringVal)) {
            this.token = 8;
        } else if ("new".equals(stringVal)) {
            this.token = 9;
        } else if ("true".equals(stringVal)) {
            this.token = 6;
        } else if ("false".equals(stringVal)) {
            this.token = 7;
        } else if ("undefined".equals(stringVal)) {
            this.token = 23;
        } else if ("Set".equals(stringVal)) {
            this.token = 21;
        } else if ("TreeSet".equals(stringVal)) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public int scanInt(char c4) {
        int i4;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        int i5 = 1;
        boolean z3 = charAt2 == '-';
        if (z3) {
            charAt2 = charAt(this.bp + 1);
            i5 = 2;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i6 = charAt2 - '0';
        while (true) {
            i4 = i5 + 1;
            charAt = charAt(this.bp + i5);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i6 = (i6 * 10) + (charAt - '0');
            i5 = i4;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if (i6 < 0) {
            this.matchStat = -1;
            return 0;
        } else {
            while (charAt != c4) {
                if (isWhitespace(charAt)) {
                    i4++;
                    charAt = charAt(this.bp + i4);
                } else {
                    this.matchStat = -1;
                    return z3 ? -i6 : i6;
                }
            }
            int i7 = this.bp + i4;
            this.bp = i7;
            this.ch = charAt(i7);
            this.matchStat = 3;
            this.token = 16;
            return z3 ? -i6 : i6;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c4) {
        int i4;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.bp + 0);
        int i5 = 1;
        boolean z3 = charAt2 == '-';
        if (z3) {
            charAt2 = charAt(this.bp + 1);
            i5 = 2;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j4 = charAt2 - '0';
        while (true) {
            i4 = i5 + 1;
            charAt = charAt(this.bp + i5);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j4 = (j4 * 10) + (charAt - '0');
            i5 = i4;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        } else if (j4 < 0) {
            this.matchStat = -1;
            return 0L;
        } else {
            while (charAt != c4) {
                if (isWhitespace(charAt)) {
                    charAt = charAt(this.bp + i4);
                    i4++;
                } else {
                    this.matchStat = -1;
                    return j4;
                }
            }
            int i6 = this.bp + i4;
            this.bp = i6;
            this.ch = charAt(i6);
            this.matchStat = 3;
            this.token = 16;
            return z3 ? -j4 : j4;
        }
    }

    public final void scanNullOrNew() {
        if (this.ch == 'n') {
            next();
            char c4 = this.ch;
            if (c4 != 'u') {
                if (c4 == 'e') {
                    next();
                    if (this.ch == 'w') {
                        next();
                        char c5 = this.ch;
                        if (c5 != ' ' && c5 != ',' && c5 != '}' && c5 != ']' && c5 != '\n' && c5 != '\r' && c5 != '\t' && c5 != 26 && c5 != '\f' && c5 != '\b') {
                            throw new JSONException("scan new error");
                        }
                        this.token = 9;
                        return;
                    }
                    throw new JSONException("error parse new");
                }
                throw new JSONException("error parse new");
            }
            next();
            if (this.ch == 'l') {
                next();
                if (this.ch == 'l') {
                    next();
                    char c6 = this.ch;
                    if (c6 != ' ' && c6 != ',' && c6 != '}' && c6 != ']' && c6 != '\n' && c6 != '\r' && c6 != '\t' && c6 != 26 && c6 != '\f' && c6 != '\b') {
                        throw new JSONException("scan null error");
                    }
                    this.token = 8;
                    return;
                }
                throw new JSONException("error parse null");
            }
            throw new JSONException("error parse null");
        }
        throw new JSONException("error parse null or new");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ca  */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void scanNumber() {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanNumber():void");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void scanString() {
        this.np = this.bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\"') {
                this.token = 4;
                this.ch = next();
                return;
            } else if (next == 26) {
                if (!isEOF()) {
                    putChar((char) 26);
                } else {
                    throw new JSONException("unclosed string : " + next);
                }
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i4 = this.sp;
                    char[] cArr = this.sbuf;
                    if (i4 >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i4 <= length) {
                            i4 = length;
                        }
                        char[] cArr2 = new char[i4];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.np + 1, this.sp, this.sbuf);
                }
                char next2 = next();
                if (next2 == '\"') {
                    putChar('\"');
                } else if (next2 != '\'') {
                    if (next2 != 'F') {
                        if (next2 == '\\') {
                            putChar('\\');
                        } else if (next2 == 'b') {
                            putChar('\b');
                        } else if (next2 != 'f') {
                            if (next2 == 'n') {
                                putChar('\n');
                            } else if (next2 == 'r') {
                                putChar('\r');
                            } else if (next2 != 'x') {
                                switch (next2) {
                                    case '/':
                                        putChar('/');
                                        continue;
                                    case '0':
                                        putChar((char) 0);
                                        continue;
                                    case '1':
                                        putChar((char) 1);
                                        continue;
                                    case '2':
                                        putChar((char) 2);
                                        continue;
                                    case '3':
                                        putChar((char) 3);
                                        continue;
                                    case '4':
                                        putChar((char) 4);
                                        continue;
                                    case '5':
                                        putChar((char) 5);
                                        continue;
                                    case '6':
                                        putChar((char) 6);
                                        continue;
                                    case '7':
                                        putChar((char) 7);
                                        continue;
                                    default:
                                        switch (next2) {
                                            case 't':
                                                putChar('\t');
                                                continue;
                                            case 'u':
                                                putChar((char) Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16));
                                                continue;
                                                continue;
                                            case 'v':
                                                putChar((char) 11);
                                                continue;
                                            default:
                                                this.ch = next2;
                                                throw new JSONException("unclosed string : " + next2);
                                        }
                                }
                            } else {
                                char next3 = next();
                                char next4 = next();
                                int[] iArr = digits;
                                putChar((char) ((iArr[next3] * 16) + iArr[next4]));
                            }
                        }
                    }
                    putChar('\f');
                } else {
                    putChar('\'');
                }
            } else if (!this.hasSpecial) {
                this.sp++;
            } else {
                int i5 = this.sp;
                char[] cArr3 = this.sbuf;
                if (i5 == cArr3.length) {
                    putChar(next);
                } else {
                    this.sp = i5 + 1;
                    cArr3[i5] = next;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x012b, code lost:
        if (r1 != r18) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012d, code lost:
        r1 = r16.bp + r3;
        r16.bp = r1;
        r16.ch = charAt(r1);
        r16.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x013a, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013b, code lost:
        r16.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x013d, code lost:
        return;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void scanStringArray(java.util.Collection<java.lang.String> r17, char r18) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanStringArray(java.util.Collection, char):void");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable) {
        skipWhitespace();
        char c4 = this.ch;
        if (c4 == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c4 == '\'') {
            if (isEnabled(Feature.AllowSingleQuotes)) {
                return scanSymbol(symbolTable, '\'');
            }
            throw new JSONException("syntax error");
        } else if (c4 == '}') {
            next();
            this.token = 13;
            return null;
        } else if (c4 == ',') {
            next();
            this.token = 16;
            return null;
        } else if (c4 == 26) {
            this.token = 20;
            return null;
        } else if (isEnabled(Feature.AllowUnQuotedFieldNames)) {
            return scanSymbolUnQuoted(symbolTable);
        } else {
            throw new JSONException("syntax error");
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        boolean z3 = false;
        if (this.token == 1 && this.pos == 0 && this.bp == 1) {
            this.bp = 0;
        }
        boolean[] zArr = IOUtils.firstIdentifierFlags;
        int i4 = this.ch;
        if ((i4 >= zArr.length || zArr[i4]) ? true : true) {
            boolean[] zArr2 = IOUtils.identifierFlags;
            this.np = this.bp;
            this.sp = 1;
            while (true) {
                char next = next();
                if (next < zArr2.length && !zArr2[next]) {
                    break;
                }
                i4 = (i4 * 31) + next;
                this.sp++;
            }
            this.ch = charAt(this.bp);
            this.token = 18;
            if (this.sp == 4 && i4 == 3392903 && charAt(this.np) == 'n' && charAt(this.np + 1) == 'u' && charAt(this.np + 2) == 'l' && charAt(this.np + 3) == 'l') {
                return null;
            }
            if (symbolTable == null) {
                return subString(this.np, this.sp);
            }
            return addSymbol(this.np, this.sp, i4, symbolTable);
        }
        throw new JSONException("illegal identifier : " + this.ch + info());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c4) {
        int i4 = 0;
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
                if (charAt(this.bp + 4) == c4) {
                    int i5 = this.bp + 5;
                    this.bp = i5;
                    this.ch = charAt(i5);
                    this.matchStat = 3;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            this.matchStat = -1;
            return null;
        } else if (charAt != '\"') {
            this.matchStat = -1;
            return null;
        } else {
            int i6 = 1;
            while (true) {
                int i7 = i6 + 1;
                char charAt2 = charAt(this.bp + i6);
                if (charAt2 == '\"') {
                    int i8 = this.bp;
                    int i9 = i8 + 0 + 1;
                    String addSymbol = addSymbol(i9, ((i8 + i7) - i9) - 1, i4, symbolTable);
                    int i10 = i7 + 1;
                    char charAt3 = charAt(this.bp + i7);
                    while (charAt3 != c4) {
                        if (isWhitespace(charAt3)) {
                            charAt3 = charAt(this.bp + i10);
                            i10++;
                        } else {
                            this.matchStat = -1;
                            return addSymbol;
                        }
                    }
                    int i11 = this.bp + i10;
                    this.bp = i11;
                    this.ch = charAt(i11);
                    this.matchStat = 3;
                    return addSymbol;
                }
                i4 = (i4 * 31) + charAt2;
                if (charAt2 == '\\') {
                    this.matchStat = -1;
                    return null;
                }
                i6 = i7;
            }
        }
    }

    public final void scanTrue() {
        if (this.ch == 't') {
            next();
            if (this.ch == 'r') {
                next();
                if (this.ch == 'u') {
                    next();
                    if (this.ch == 'e') {
                        next();
                        char c4 = this.ch;
                        if (c4 != ' ' && c4 != ',' && c4 != '}' && c4 != ']' && c4 != '\n' && c4 != '\r' && c4 != '\t' && c4 != 26 && c4 != '\f' && c4 != '\b' && c4 != ':' && c4 != '/') {
                            throw new JSONException("scan true error");
                        }
                        this.token = 6;
                        return;
                    }
                    throw new JSONException("error parse true");
                }
                throw new JSONException("error parse true");
            }
            throw new JSONException("error parse true");
        }
        throw new JSONException("error parse true");
    }

    public final int scanType(String str) {
        this.matchStat = 0;
        char[] cArr = typeFieldName;
        if (charArrayCompare(cArr)) {
            int length = this.bp + cArr.length;
            int length2 = str.length();
            for (int i4 = 0; i4 < length2; i4++) {
                if (str.charAt(i4) != charAt(length + i4)) {
                    return -1;
                }
            }
            int i5 = length + length2;
            if (charAt(i5) != '\"') {
                return -1;
            }
            int i6 = i5 + 1;
            char charAt = charAt(i6);
            this.ch = charAt;
            if (charAt == ',') {
                int i7 = i6 + 1;
                this.ch = charAt(i7);
                this.bp = i7;
                this.token = 16;
                return 3;
            }
            if (charAt == '}') {
                i6++;
                char charAt2 = charAt(i6);
                this.ch = charAt2;
                if (charAt2 == ',') {
                    this.token = 16;
                    i6++;
                    this.ch = charAt(i6);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    i6++;
                    this.ch = charAt(i6);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    i6++;
                    this.ch = charAt(i6);
                } else if (charAt2 != 26) {
                    return -1;
                } else {
                    this.token = 20;
                }
                this.matchStat = 4;
            }
            this.bp = i6;
            return this.matchStat;
        }
        return -2;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setToken(int i4) {
        this.token = i4;
    }

    protected void skipComment() {
        char c4;
        next();
        char c5 = this.ch;
        if (c5 == '/') {
            do {
                next();
                c4 = this.ch;
                if (c4 == '\n') {
                    next();
                    return;
                }
            } while (c4 != 26);
        } else if (c5 == '*') {
            next();
            while (true) {
                char c6 = this.ch;
                if (c6 == 26) {
                    return;
                }
                if (c6 == '*') {
                    next();
                    if (this.ch == '/') {
                        next();
                        return;
                    }
                } else {
                    next();
                }
            }
        } else {
            throw new JSONException("invalid comment");
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void skipWhitespace() {
        while (true) {
            char c4 = this.ch;
            if (c4 > '/') {
                return;
            }
            if (c4 == ' ' || c4 == '\r' || c4 == '\n' || c4 == '\t' || c4 == '\f' || c4 == '\b') {
                next();
            } else if (c4 != '/') {
                return;
            } else {
                skipComment();
            }
        }
    }

    public final String stringDefaultValue() {
        return this.stringDefaultValue;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract String stringVal();

    public abstract String subString(int i4, int i5);

    protected abstract char[] sub_chars(int i4, int i5);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int token() {
        return this.token;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(int i4) {
        return (i4 & this.features) != 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon(int i4) {
        nextTokenWithChar(':');
    }

    public final boolean isEnabled(int i4, int i5) {
        return ((this.features & i5) == 0 && (i4 & i5) == 0) ? false : true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable, char c4) {
        String addSymbol;
        this.np = this.bp;
        this.sp = 0;
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            char next = next();
            if (next == c4) {
                this.token = 4;
                if (!z3) {
                    int i5 = this.np;
                    addSymbol = addSymbol(i5 == -1 ? 0 : i5 + 1, this.sp, i4, symbolTable);
                } else {
                    addSymbol = symbolTable.addSymbol(this.sbuf, 0, this.sp, i4);
                }
                this.sp = 0;
                next();
                return addSymbol;
            } else if (next == 26) {
                throw new JSONException("unclosed.str");
            } else {
                if (next == '\\') {
                    if (!z3) {
                        int i6 = this.sp;
                        char[] cArr = this.sbuf;
                        if (i6 >= cArr.length) {
                            int length = cArr.length * 2;
                            if (i6 <= length) {
                                i6 = length;
                            }
                            char[] cArr2 = new char[i6];
                            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                            this.sbuf = cArr2;
                        }
                        arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
                        z3 = true;
                    }
                    char next2 = next();
                    if (next2 == '\"') {
                        i4 = (i4 * 31) + 34;
                        putChar('\"');
                    } else if (next2 != '\'') {
                        if (next2 != 'F') {
                            if (next2 == '\\') {
                                i4 = (i4 * 31) + 92;
                                putChar('\\');
                            } else if (next2 == 'b') {
                                i4 = (i4 * 31) + 8;
                                putChar('\b');
                            } else if (next2 != 'f') {
                                if (next2 == 'n') {
                                    i4 = (i4 * 31) + 10;
                                    putChar('\n');
                                } else if (next2 == 'r') {
                                    i4 = (i4 * 31) + 13;
                                    putChar('\r');
                                } else if (next2 != 'x') {
                                    switch (next2) {
                                        case '/':
                                            i4 = (i4 * 31) + 47;
                                            putChar('/');
                                            continue;
                                        case '0':
                                            i4 = (i4 * 31) + next2;
                                            putChar((char) 0);
                                            continue;
                                        case '1':
                                            i4 = (i4 * 31) + next2;
                                            putChar((char) 1);
                                            continue;
                                        case '2':
                                            i4 = (i4 * 31) + next2;
                                            putChar((char) 2);
                                            continue;
                                        case '3':
                                            i4 = (i4 * 31) + next2;
                                            putChar((char) 3);
                                            continue;
                                        case '4':
                                            i4 = (i4 * 31) + next2;
                                            putChar((char) 4);
                                            continue;
                                        case '5':
                                            i4 = (i4 * 31) + next2;
                                            putChar((char) 5);
                                            continue;
                                        case '6':
                                            i4 = (i4 * 31) + next2;
                                            putChar((char) 6);
                                            continue;
                                        case '7':
                                            i4 = (i4 * 31) + next2;
                                            putChar((char) 7);
                                            continue;
                                        default:
                                            switch (next2) {
                                                case 't':
                                                    i4 = (i4 * 31) + 9;
                                                    putChar('\t');
                                                    continue;
                                                case 'u':
                                                    int parseInt = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                    i4 = (i4 * 31) + parseInt;
                                                    putChar((char) parseInt);
                                                    continue;
                                                    continue;
                                                case 'v':
                                                    i4 = (i4 * 31) + 11;
                                                    putChar((char) 11);
                                                    continue;
                                                default:
                                                    this.ch = next2;
                                                    throw new JSONException("unclosed.str.lit");
                                            }
                                    }
                                } else {
                                    char next3 = next();
                                    this.ch = next3;
                                    char next4 = next();
                                    this.ch = next4;
                                    int[] iArr = digits;
                                    char c5 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                    i4 = (i4 * 31) + c5;
                                    putChar(c5);
                                }
                            }
                        }
                        i4 = (i4 * 31) + 12;
                        putChar('\f');
                    } else {
                        i4 = (i4 * 31) + 39;
                        putChar('\'');
                    }
                } else {
                    i4 = (i4 * 31) + next;
                    if (!z3) {
                        this.sp++;
                    } else {
                        int i7 = this.sp;
                        char[] cArr3 = this.sbuf;
                        if (i7 == cArr3.length) {
                            putChar(next);
                        } else {
                            this.sp = i7 + 1;
                            cArr3[i7] = next;
                        }
                    }
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken(int i4) {
        this.sp = 0;
        while (true) {
            if (i4 == 2) {
                char c4 = this.ch;
                if (c4 >= '0' && c4 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c4 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c4 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c4 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i4 == 4) {
                char c5 = this.ch;
                if (c5 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c5 >= '0' && c5 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c5 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c5 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i4 == 12) {
                char c6 = this.ch;
                if (c6 == '{') {
                    this.token = 12;
                    next();
                    return;
                } else if (c6 == '[') {
                    this.token = 14;
                    next();
                    return;
                }
            } else if (i4 != 18) {
                if (i4 != 20) {
                    switch (i4) {
                        case 14:
                            char c7 = this.ch;
                            if (c7 == '[') {
                                this.token = 14;
                                next();
                                return;
                            } else if (c7 == '{') {
                                this.token = 12;
                                next();
                                return;
                            }
                            break;
                        case 15:
                            if (this.ch == ']') {
                                this.token = 15;
                                next();
                                return;
                            }
                            break;
                        case 16:
                            char c8 = this.ch;
                            if (c8 == ',') {
                                this.token = 16;
                                next();
                                return;
                            } else if (c8 == '}') {
                                this.token = 13;
                                next();
                                return;
                            } else if (c8 == ']') {
                                this.token = 15;
                                next();
                                return;
                            } else if (c8 == 26) {
                                this.token = 20;
                                return;
                            }
                            break;
                    }
                }
                if (this.ch == 26) {
                    this.token = 20;
                    return;
                }
            } else {
                nextIdent();
                return;
            }
            char c9 = this.ch;
            if (c9 != ' ' && c9 != '\n' && c9 != '\r' && c9 != '\t' && c9 != '\f' && c9 != '\b') {
                nextToken();
                return;
            }
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanString(char c4) {
        this.matchStat = 0;
        char charAt = charAt(this.bp + 0);
        if (charAt == 'n') {
            if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
                if (charAt(this.bp + 4) == c4) {
                    int i4 = this.bp + 5;
                    this.bp = i4;
                    this.ch = charAt(i4);
                    this.matchStat = 3;
                    return null;
                }
                this.matchStat = -1;
                return null;
            }
            this.matchStat = -1;
            return null;
        } else if (charAt != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        } else {
            int i5 = this.bp + 1;
            int indexOf = indexOf('\"', i5);
            if (indexOf != -1) {
                String subString = subString(this.bp + 1, indexOf - i5);
                if (subString.indexOf(92) != -1) {
                    while (true) {
                        int i6 = 0;
                        for (int i7 = indexOf - 1; i7 >= 0 && charAt(i7) == '\\'; i7--) {
                            i6++;
                        }
                        if (i6 % 2 == 0) {
                            break;
                        }
                        indexOf = indexOf('\"', indexOf + 1);
                    }
                    int i8 = indexOf - i5;
                    subString = readString(sub_chars(this.bp + 1, i8), i8);
                }
                int i9 = this.bp;
                int i10 = 1 + (indexOf - (i9 + 1)) + 1;
                int i11 = i10 + 1;
                if (charAt(i9 + i10) == c4) {
                    int i12 = this.bp + i11;
                    this.bp = i12;
                    this.ch = charAt(i12);
                    this.matchStat = 3;
                    return subString;
                }
                this.matchStat = -1;
                return subString;
            }
            throw new JSONException("unclosed str");
        }
    }
}
