package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.github.mikephil.charting.utils.Utils;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.StringUtil;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class JSONLexerBase implements JSONLexer, Closeable {
    protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
    protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;

    /* renamed from: bp */
    protected int f3440bp;

    /* renamed from: ch */
    protected char f3441ch;
    protected int eofPos;
    protected int features;
    protected boolean hasSpecial;

    /* renamed from: np */
    protected int f3442np;
    protected int pos;
    protected char[] sbuf;

    /* renamed from: sp */
    protected int f3443sp;
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
        for (int i = 48; i <= 57; i++) {
            digits[i] = i - 48;
        }
        for (int i2 = 97; i2 <= 102; i2++) {
            digits[i2] = (i2 - 97) + 10;
        }
        for (int i3 = 65; i3 <= 70; i3++) {
            digits[i3] = (i3 - 65) + 10;
        }
    }

    public JSONLexerBase(int i) {
        this.stringDefaultValue = null;
        this.features = i;
        if ((i & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
        char[] cArr = SBUF_LOCAL.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
    }

    public static boolean isWhitespace(char c) {
        return c <= ' ' && (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b');
    }

    public static String readString(char[] cArr, int i) {
        int i2;
        char[] cArr2 = new char[i];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            char c = cArr[i3];
            if (c != '\\') {
                cArr2[i4] = c;
                i4++;
            } else {
                i3++;
                char c2 = cArr[i3];
                if (c2 == '\"') {
                    i2 = i4 + 1;
                    cArr2[i4] = '\"';
                } else if (c2 != '\'') {
                    if (c2 != 'F') {
                        if (c2 == '\\') {
                            i2 = i4 + 1;
                            cArr2[i4] = '\\';
                        } else if (c2 == 'b') {
                            i2 = i4 + 1;
                            cArr2[i4] = '\b';
                        } else if (c2 != 'f') {
                            if (c2 == 'n') {
                                i2 = i4 + 1;
                                cArr2[i4] = '\n';
                            } else if (c2 == 'r') {
                                i2 = i4 + 1;
                                cArr2[i4] = StringUtil.CARRIAGE_RETURN;
                            } else if (c2 != 'x') {
                                switch (c2) {
                                    case '/':
                                        i2 = i4 + 1;
                                        cArr2[i4] = '/';
                                        break;
                                    case '0':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 0;
                                        break;
                                    case '1':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 1;
                                        break;
                                    case '2':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 2;
                                        break;
                                    case '3':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 3;
                                        break;
                                    case '4':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 4;
                                        break;
                                    case '5':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 5;
                                        break;
                                    case '6':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 6;
                                        break;
                                    case '7':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 7;
                                        break;
                                    default:
                                        switch (c2) {
                                            case 't':
                                                i2 = i4 + 1;
                                                cArr2[i4] = '\t';
                                                break;
                                            case 'u':
                                                i2 = i4 + 1;
                                                int i5 = i3 + 1;
                                                int i6 = i5 + 1;
                                                int i7 = i6 + 1;
                                                i3 = i7 + 1;
                                                cArr2[i4] = (char) Integer.parseInt(new String(new char[]{cArr[i5], cArr[i6], cArr[i7], cArr[i3]}), 16);
                                                break;
                                            case 'v':
                                                i2 = i4 + 1;
                                                cArr2[i4] = 11;
                                                break;
                                            default:
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                i2 = i4 + 1;
                                int[] iArr = digits;
                                int i8 = i3 + 1;
                                i3 = i8 + 1;
                                cArr2[i4] = (char) ((iArr[cArr[i8]] * 16) + iArr[cArr[i3]]);
                            }
                        }
                    }
                    i2 = i4 + 1;
                    cArr2[i4] = '\f';
                } else {
                    i2 = i4 + 1;
                    cArr2[i4] = '\'';
                }
                i4 = i2;
            }
            i3++;
        }
        return new String(cArr2, 0, i4);
    }

    private void scanStringSingleQuote() {
        this.f3442np = this.f3440bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\'') {
                this.token = 4;
                next();
                return;
            } else if (next == 26) {
                if (!isEOF()) {
                    putChar(JSONLexer.EOI);
                } else {
                    throw new JSONException("unclosed single-quote string");
                }
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i = this.f3443sp;
                    char[] cArr = this.sbuf;
                    if (i > cArr.length) {
                        char[] cArr2 = new char[i * 2];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.f3442np + 1, this.f3443sp, this.sbuf);
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
                                putChar(StringUtil.CARRIAGE_RETURN);
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
                                                this.f3441ch = next2;
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
                this.f3443sp++;
            } else {
                int i2 = this.f3443sp;
                char[] cArr3 = this.sbuf;
                if (i2 == cArr3.length) {
                    putChar(next);
                } else {
                    this.f3443sp = i2 + 1;
                    cArr3[i2] = next;
                }
            }
        }
    }

    public abstract String addSymbol(int i, int i2, int i3, SymbolTable symbolTable);

    protected abstract void arrayCopy(int i, char[] cArr, int i2, int i3);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract byte[] bytesValue();

    protected abstract boolean charArrayCompare(char[] cArr);

    public abstract char charAt(int i);

    @Override // com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8192) {
            SBUF_LOCAL.set(cArr);
        }
        this.sbuf = null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public void config(Feature feature, boolean z) {
        int config = Feature.config(this.features, feature, z);
        this.features = config;
        if ((config & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.stringDefaultValue = "";
        }
    }

    protected abstract void copyTo(int i, int i2, char[] cArr);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number decimalValue(boolean z) {
        char charAt = charAt((this.f3442np + this.f3443sp) - 1);
        try {
            if (charAt == 'F') {
                return Float.valueOf(Float.parseFloat(numberString()));
            }
            if (charAt == 'D') {
                return Double.valueOf(Double.parseDouble(numberString()));
            }
            if (z) {
                return decimalValue();
            }
            return Double.valueOf(doubleValue());
        } catch (NumberFormatException e) {
            throw new JSONException(e.getMessage() + ", " + info());
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
        return this.f3441ch;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Locale getLocale() {
        return this.locale;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public abstract int indexOf(char c, int i);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        return "";
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int intValue() {
        int i;
        boolean z;
        int i2 = 0;
        if (this.f3442np == -1) {
            this.f3442np = 0;
        }
        int i3 = this.f3442np;
        int i4 = this.f3443sp + i3;
        if (charAt(i3) == '-') {
            i = Integer.MIN_VALUE;
            i3++;
            z = true;
        } else {
            i = -2147483647;
            z = false;
        }
        if (i3 < i4) {
            i2 = -(charAt(i3) - '0');
            i3++;
        }
        while (i3 < i4) {
            int i5 = i3 + 1;
            char charAt = charAt(i3);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                i3 = i5;
                break;
            }
            int i6 = charAt - '0';
            if (i2 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i7 = i2 * 10;
            if (i7 < i + i6) {
                throw new NumberFormatException(numberString());
            }
            i2 = i7 - i6;
            i3 = i5;
        }
        if (z) {
            if (i3 > this.f3442np + 1) {
                return i2;
            }
            throw new NumberFormatException(numberString());
        }
        return -i2;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final Number integerValue() throws NumberFormatException {
        long j;
        long j2;
        boolean z = false;
        if (this.f3442np == -1) {
            this.f3442np = 0;
        }
        int i = this.f3442np;
        int i2 = this.f3443sp + i;
        char c = HttpConstants.SP_CHAR;
        char charAt = charAt(i2 - 1);
        if (charAt == 'B') {
            i2--;
            c = 'B';
        } else if (charAt == 'L') {
            i2--;
            c = 'L';
        } else if (charAt == 'S') {
            i2--;
            c = 'S';
        }
        if (charAt(this.f3442np) == '-') {
            j = Long.MIN_VALUE;
            i++;
            z = true;
        } else {
            j = -9223372036854775807L;
        }
        long j3 = -922337203685477580L;
        if (i < i2) {
            j2 = -(charAt(i) - '0');
            i++;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            int i3 = i + 1;
            int charAt2 = charAt(i) - '0';
            if (j2 < j3) {
                return new BigInteger(numberString());
            }
            long j4 = j2 * 10;
            long j5 = charAt2;
            if (j4 < j + j5) {
                return new BigInteger(numberString());
            }
            j2 = j4 - j5;
            i = i3;
            j3 = -922337203685477580L;
        }
        if (!z) {
            long j6 = -j2;
            if (j6 > 2147483647L || c == 'L') {
                return Long.valueOf(j6);
            }
            if (c == 'S') {
                return Short.valueOf((short) j6);
            }
            if (c == 'B') {
                return Byte.valueOf((byte) j6);
            }
            return Integer.valueOf((int) j6);
        } else if (i > this.f3442np + 1) {
            if (j2 < -2147483648L || c == 'L') {
                return Long.valueOf(j2);
            }
            if (c == 'S') {
                return Short.valueOf((short) j2);
            }
            if (c == 'B') {
                return Byte.valueOf((byte) j2);
            }
            return Integer.valueOf((int) j2);
        } else {
            throw new NumberFormatException(numberString());
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean isBlankInput() {
        int i = 0;
        while (true) {
            char charAt = charAt(i);
            if (charAt == 26) {
                this.token = 20;
                return true;
            } else if (!isWhitespace(charAt)) {
                return false;
            } else {
                i++;
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
        return this.f3443sp == 4 && charAt(this.f3442np + 1) == '$' && charAt(this.f3442np + 2) == 'r' && charAt(this.f3442np + 3) == 'e' && charAt(this.f3442np + 4) == 'f';
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
            int r0 = r15.f3442np
            r1 = 0
            r2 = -1
            if (r0 != r2) goto L8
            r15.f3442np = r1
        L8:
            int r0 = r15.f3442np
            int r2 = r15.f3443sp
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
            int r1 = r15.f3442np
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
            int length = this.f3440bp + cArr.length;
            this.f3440bp = length;
            char charAt = charAt(length);
            this.f3441ch = charAt;
            if (charAt == '{') {
                next();
                this.token = 12;
            } else if (charAt == '[') {
                next();
                this.token = 14;
            } else if (charAt == 'S' && charAt(this.f3440bp + 1) == 'e' && charAt(this.f3440bp + 2) == 't' && charAt(this.f3440bp + 3) == '[') {
                int i = this.f3440bp + 3;
                this.f3440bp = i;
                this.f3441ch = charAt(i);
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
        } catch (Exception e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public abstract char next();

    public final void nextIdent() {
        while (isWhitespace(this.f3441ch)) {
            next();
        }
        char c = this.f3441ch;
        if (c != '_' && !Character.isLetter(c)) {
            nextToken();
        } else {
            scanIdent();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken() {
        this.f3443sp = 0;
        while (true) {
            this.pos = this.f3440bp;
            char c = this.f3441ch;
            if (c == '/') {
                skipComment();
            } else if (c == '\"') {
                scanString();
                return;
            } else if (c == ',') {
                next();
                this.token = 16;
                return;
            } else if (c >= '0' && c <= '9') {
                scanNumber();
                return;
            } else if (c == '-') {
                scanNumber();
                return;
            } else {
                switch (c) {
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
                    case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_WIFI /* 125 */:
                        next();
                        this.token = 13;
                        return;
                    default:
                        if (isEOF()) {
                            if (this.token != 20) {
                                this.token = 20;
                                int i = this.eofPos;
                                this.f3440bp = i;
                                this.pos = i;
                                return;
                            }
                            throw new JSONException("EOF error");
                        }
                        char c2 = this.f3441ch;
                        if (c2 > 31 && c2 != 127) {
                            lexError("illegal.char", String.valueOf((int) c2));
                            next();
                            return;
                        }
                        next();
                        continue;
                }
            }
        }
    }

    public final void nextTokenWithChar(char c) {
        this.f3443sp = 0;
        while (true) {
            char c2 = this.f3441ch;
            if (c2 == c) {
                next();
                nextToken();
                return;
            } else if (c2 != ' ' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != '\f' && c2 != '\b') {
                throw new JSONException("not match " + c + " - " + this.f3441ch + ", info : " + info());
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

    protected final void putChar(char c) {
        int i = this.f3443sp;
        char[] cArr = this.sbuf;
        if (i == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
            this.sbuf = cArr2;
        }
        char[] cArr3 = this.sbuf;
        int i2 = this.f3443sp;
        this.f3443sp = i2 + 1;
        cArr3[i2] = c;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void resetStringPosition() {
        this.f3443sp = 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public boolean scanBoolean(char c) {
        boolean z = false;
        this.matchStat = 0;
        char charAt = charAt(this.f3440bp + 0);
        int i = 5;
        if (charAt == 't') {
            if (charAt(this.f3440bp + 1) == 'r' && charAt(this.f3440bp + 1 + 1) == 'u' && charAt(this.f3440bp + 1 + 2) == 'e') {
                charAt = charAt(this.f3440bp + 4);
                z = true;
            } else {
                this.matchStat = -1;
                return false;
            }
        } else if (charAt != 'f') {
            if (charAt == '1') {
                charAt = charAt(this.f3440bp + 1);
                z = true;
            } else if (charAt == '0') {
                charAt = charAt(this.f3440bp + 1);
            } else {
                i = 1;
            }
            i = 2;
        } else if (charAt(this.f3440bp + 1) == 'a' && charAt(this.f3440bp + 1 + 1) == 'l' && charAt(this.f3440bp + 1 + 2) == 's' && charAt(this.f3440bp + 1 + 3) == 'e') {
            charAt = charAt(this.f3440bp + 5);
            i = 6;
        } else {
            this.matchStat = -1;
            return false;
        }
        while (charAt != c) {
            if (isWhitespace(charAt)) {
                charAt = charAt(this.f3440bp + i);
                i++;
            } else {
                this.matchStat = -1;
                return z;
            }
        }
        int i2 = this.f3440bp + i;
        this.f3440bp = i2;
        this.f3441ch = charAt(i2);
        this.matchStat = 3;
        return z;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final double scanDouble(char c) {
        int i;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.f3440bp + 0);
        if (charAt2 >= '0' && charAt2 <= '9') {
            int i2 = 1;
            while (true) {
                i = i2 + 1;
                charAt = charAt(this.f3440bp + i2);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i2 = i;
            }
            if (charAt == '.') {
                int i3 = i + 1;
                char charAt3 = charAt(this.f3440bp + i);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    while (true) {
                        i = i3 + 1;
                        charAt = charAt(this.f3440bp + i3);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i3 = i;
                    }
                } else {
                    this.matchStat = -1;
                    return Utils.DOUBLE_EPSILON;
                }
            }
            int i4 = this.f3440bp;
            double parseDouble = Double.parseDouble(subString(i4, ((i4 + i) - i4) - 1));
            if (charAt == c) {
                int i5 = this.f3440bp + i;
                this.f3440bp = i5;
                this.f3441ch = charAt(i5);
                this.matchStat = 3;
                this.token = 16;
                return parseDouble;
            }
            this.matchStat = -1;
            return parseDouble;
        }
        this.matchStat = -1;
        return Utils.DOUBLE_EPSILON;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public Enum<?> scanEnum(Class<?> cls, SymbolTable symbolTable, char c) {
        String scanSymbolWithSeperator = scanSymbolWithSeperator(symbolTable, c);
        if (scanSymbolWithSeperator == null) {
            return null;
        }
        return Enum.valueOf(cls, scanSymbolWithSeperator);
    }

    public final void scanFalse() {
        if (this.f3441ch == 'f') {
            next();
            if (this.f3441ch == 'a') {
                next();
                if (this.f3441ch == 'l') {
                    next();
                    if (this.f3441ch == 's') {
                        next();
                        if (this.f3441ch == 'e') {
                            next();
                            char c = this.f3441ch;
                            if (c != ' ' && c != ',' && c != '}' && c != ']' && c != '\n' && c != '\r' && c != '\t' && c != 26 && c != '\f' && c != '\b' && c != ':' && c != '/') {
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
        int i;
        boolean z;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt = charAt(this.f3440bp + length);
        if (charAt == 't') {
            int i3 = i2 + 1;
            if (charAt(this.f3440bp + i2) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i4 = i3 + 1;
            if (charAt(this.f3440bp + i3) != 'u') {
                this.matchStat = -1;
                return false;
            }
            i = i4 + 1;
            if (charAt(this.f3440bp + i4) != 'e') {
                this.matchStat = -1;
                return false;
            }
            z = true;
        } else if (charAt == 'f') {
            int i5 = i2 + 1;
            if (charAt(this.f3440bp + i2) != 'a') {
                this.matchStat = -1;
                return false;
            }
            int i6 = i5 + 1;
            if (charAt(this.f3440bp + i5) != 'l') {
                this.matchStat = -1;
                return false;
            }
            int i7 = i6 + 1;
            if (charAt(this.f3440bp + i6) != 's') {
                this.matchStat = -1;
                return false;
            }
            int i8 = i7 + 1;
            if (charAt(this.f3440bp + i7) != 'e') {
                this.matchStat = -1;
                return false;
            }
            i = i8;
            z = false;
        } else {
            this.matchStat = -1;
            return false;
        }
        int i9 = i + 1;
        char charAt2 = charAt(this.f3440bp + i);
        if (charAt2 == ',') {
            int i10 = this.f3440bp + i9;
            this.f3440bp = i10;
            this.f3441ch = charAt(i10);
            this.matchStat = 3;
            this.token = 16;
            return z;
        } else if (charAt2 == '}') {
            int i11 = i9 + 1;
            char charAt3 = charAt(this.f3440bp + i9);
            if (charAt3 == ',') {
                this.token = 16;
                int i12 = this.f3440bp + i11;
                this.f3440bp = i12;
                this.f3441ch = charAt(i12);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i13 = this.f3440bp + i11;
                this.f3440bp = i13;
                this.f3441ch = charAt(i13);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i14 = this.f3440bp + i11;
                this.f3440bp = i14;
                this.f3441ch = charAt(i14);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.f3440bp += i11 - 1;
                this.f3441ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return false;
            }
            this.matchStat = 4;
            return z;
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
        int i;
        char charAt;
        int i2;
        int length;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0.0f;
        }
        int length2 = cArr.length;
        int i3 = length2 + 1;
        char charAt2 = charAt(this.f3440bp + length2);
        if (charAt2 >= '0' && charAt2 <= '9') {
            while (true) {
                i = i3 + 1;
                charAt = charAt(this.f3440bp + i3);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i3 = i;
            }
            if (charAt == '.') {
                int i4 = i + 1;
                char charAt3 = charAt(this.f3440bp + i);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    while (true) {
                        i = i4 + 1;
                        charAt = charAt(this.f3440bp + i4);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i4 = i;
                    }
                } else {
                    this.matchStat = -1;
                    return 0.0f;
                }
            }
            float parseFloat = Float.parseFloat(subString(cArr.length + this.f3440bp, ((i2 + i) - length) - 1));
            if (charAt == ',') {
                int i5 = this.f3440bp + i;
                this.f3440bp = i5;
                this.f3441ch = charAt(i5);
                this.matchStat = 3;
                this.token = 16;
                return parseFloat;
            } else if (charAt == '}') {
                int i6 = i + 1;
                char charAt4 = charAt(this.f3440bp + i);
                if (charAt4 == ',') {
                    this.token = 16;
                    int i7 = this.f3440bp + i6;
                    this.f3440bp = i7;
                    this.f3441ch = charAt(i7);
                } else if (charAt4 == ']') {
                    this.token = 15;
                    int i8 = this.f3440bp + i6;
                    this.f3440bp = i8;
                    this.f3441ch = charAt(i8);
                } else if (charAt4 == '}') {
                    this.token = 13;
                    int i9 = this.f3440bp + i6;
                    this.f3440bp = i9;
                    this.f3441ch = charAt(i9);
                } else if (charAt4 == 26) {
                    this.f3440bp += i6 - 1;
                    this.token = 20;
                    this.f3441ch = JSONLexer.EOI;
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
        int i;
        char charAt;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.f3440bp + length);
        boolean z = charAt2 == '-';
        if (z) {
            charAt2 = charAt(this.f3440bp + i2);
            i2++;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i3 = charAt2 - '0';
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.f3440bp + i2);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i3 = (i3 * 10) + (charAt - '0');
            i2 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if ((i3 < 0 || i > cArr.length + 14) && !(i3 == Integer.MIN_VALUE && i == 17 && z)) {
            this.matchStat = -1;
            return 0;
        } else if (charAt == ',') {
            int i4 = this.f3440bp + i;
            this.f3440bp = i4;
            this.f3441ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return z ? -i3 : i3;
        } else if (charAt == '}') {
            int i5 = i + 1;
            char charAt3 = charAt(this.f3440bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i6 = this.f3440bp + i5;
                this.f3440bp = i6;
                this.f3441ch = charAt(i6);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i7 = this.f3440bp + i5;
                this.f3440bp = i7;
                this.f3441ch = charAt(i7);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i8 = this.f3440bp + i5;
                this.f3440bp = i8;
                this.f3441ch = charAt(i8);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.f3440bp += i5 - 1;
                this.f3441ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return 0;
            }
            this.matchStat = 4;
            return z ? -i3 : i3;
        } else {
            this.matchStat = -1;
            return 0;
        }
    }

    public final int[] scanFieldIntArray(char[] cArr) {
        boolean z;
        int i;
        char charAt;
        int i2;
        int i3;
        char charAt2;
        this.matchStat = 0;
        int[] iArr = null;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = cArr.length;
        int i4 = length + 1;
        if (charAt(this.f3440bp + length) != '[') {
            this.matchStat = -2;
            return null;
        }
        int i5 = i4 + 1;
        char charAt3 = charAt(this.f3440bp + i4);
        int[] iArr2 = new int[16];
        if (charAt3 == ']') {
            i3 = i5 + 1;
            charAt2 = charAt(this.f3440bp + i5);
            i2 = 0;
        } else {
            int i6 = 0;
            while (true) {
                if (charAt3 == '-') {
                    charAt3 = charAt(this.f3440bp + i5);
                    i5++;
                    z = true;
                } else {
                    z = false;
                }
                if (charAt3 < '0' || charAt3 > '9') {
                    break;
                }
                int i7 = charAt3 - '0';
                while (true) {
                    i = i5 + 1;
                    charAt = charAt(this.f3440bp + i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i7 = (i7 * 10) + (charAt - '0');
                    i5 = i;
                }
                if (i6 >= iArr2.length) {
                    int[] iArr3 = new int[(iArr2.length * 3) / 2];
                    System.arraycopy(iArr2, 0, iArr3, 0, i6);
                    iArr2 = iArr3;
                }
                i2 = i6 + 1;
                if (z) {
                    i7 = -i7;
                }
                iArr2[i6] = i7;
                if (charAt == ',') {
                    i++;
                    charAt = charAt(this.f3440bp + i);
                } else if (charAt == ']') {
                    i3 = i + 1;
                    charAt2 = charAt(this.f3440bp + i);
                    break;
                }
                i6 = i2;
                iArr = null;
                charAt3 = charAt;
                i5 = i;
            }
            int[] iArr4 = iArr;
            this.matchStat = -1;
            return iArr4;
        }
        if (i2 != iArr2.length) {
            int[] iArr5 = new int[i2];
            System.arraycopy(iArr2, 0, iArr5, 0, i2);
            iArr2 = iArr5;
        }
        if (charAt2 == ',') {
            this.f3440bp += i3 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr2;
        } else if (charAt2 == '}') {
            int i8 = i3 + 1;
            char charAt4 = charAt(this.f3440bp + i3);
            if (charAt4 == ',') {
                this.token = 16;
                this.f3440bp += i8 - 1;
                next();
            } else if (charAt4 == ']') {
                this.token = 15;
                this.f3440bp += i8 - 1;
                next();
            } else if (charAt4 == '}') {
                this.token = 13;
                this.f3440bp += i8 - 1;
                next();
            } else if (charAt4 == 26) {
                this.f3440bp += i8 - 1;
                this.token = 20;
                this.f3441ch = JSONLexer.EOI;
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
        int i;
        char charAt;
        boolean z = false;
        this.matchStat = 0;
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = cArr.length;
        int i2 = length + 1;
        char charAt2 = charAt(this.f3440bp + length);
        if (charAt2 == '-') {
            charAt2 = charAt(this.f3440bp + i2);
            i2++;
            z = true;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j = charAt2 - '0';
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.f3440bp + i2);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j = (j * 10) + (charAt - '0');
            i2 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        } else if (j < 0 || i > 21) {
            this.matchStat = -1;
            return 0L;
        } else if (charAt == ',') {
            int i3 = this.f3440bp + i;
            this.f3440bp = i3;
            this.f3441ch = charAt(i3);
            this.matchStat = 3;
            this.token = 16;
            return z ? -j : j;
        } else if (charAt == '}') {
            int i4 = i + 1;
            char charAt3 = charAt(this.f3440bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i5 = this.f3440bp + i4;
                this.f3440bp = i5;
                this.f3441ch = charAt(i5);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i6 = this.f3440bp + i4;
                this.f3440bp = i6;
                this.f3441ch = charAt(i6);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i7 = this.f3440bp + i4;
                this.f3440bp = i7;
                this.f3441ch = charAt(i7);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.f3440bp += i4 - 1;
                this.f3441ch = JSONLexer.EOI;
            } else {
                this.matchStat = -1;
                return 0L;
            }
            this.matchStat = 4;
            return z ? -j : j;
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
        int i = length + 1;
        if (charAt(this.f3440bp + length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', this.f3440bp + cArr.length + 1);
        if (indexOf != -1) {
            int length2 = this.f3440bp + cArr.length + 1;
            String subString = subString(length2, indexOf - length2);
            if (subString.indexOf(92) != -1) {
                while (true) {
                    int i2 = 0;
                    for (int i3 = indexOf - 1; i3 >= 0 && charAt(i3) == '\\'; i3--) {
                        i2++;
                    }
                    if (i2 % 2 == 0) {
                        break;
                    }
                    indexOf = indexOf('\"', indexOf + 1);
                }
                int i4 = this.f3440bp;
                int length3 = indexOf - ((cArr.length + i4) + 1);
                subString = readString(sub_chars(i4 + cArr.length + 1, length3), length3);
            }
            int i5 = this.f3440bp;
            int length4 = i + (indexOf - ((cArr.length + i5) + 1)) + 1;
            int i6 = length4 + 1;
            char charAt = charAt(i5 + length4);
            if (charAt == ',') {
                int i7 = this.f3440bp + i6;
                this.f3440bp = i7;
                this.f3441ch = charAt(i7);
                this.matchStat = 3;
                return subString;
            } else if (charAt == '}') {
                int i8 = i6 + 1;
                char charAt2 = charAt(this.f3440bp + i6);
                if (charAt2 == ',') {
                    this.token = 16;
                    int i9 = this.f3440bp + i8;
                    this.f3440bp = i9;
                    this.f3441ch = charAt(i9);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    int i10 = this.f3440bp + i8;
                    this.f3440bp = i10;
                    this.f3441ch = charAt(i10);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    int i11 = this.f3440bp + i8;
                    this.f3440bp = i11;
                    this.f3441ch = charAt(i11);
                } else if (charAt2 == 26) {
                    this.token = 20;
                    this.f3440bp += i8 - 1;
                    this.f3441ch = JSONLexer.EOI;
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

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ee, code lost:
        if (r13.size() != 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f0, code lost:
        r12 = charAt(r11.f3440bp + r1);
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fa, code lost:
        if (r12 != ',') goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fc, code lost:
        r12 = r11.f3440bp + r1;
        r11.f3440bp = r12;
        r11.f3441ch = charAt(r12);
        r11.matchStat = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x010a, code lost:
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x010d, code lost:
        if (r12 != '}') goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x010f, code lost:
        r6 = r1 + 1;
        r12 = charAt(r11.f3440bp + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0118, code lost:
        if (r12 != ',') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x011a, code lost:
        r11.token = 16;
        r12 = r11.f3440bp + r6;
        r11.f3440bp = r12;
        r11.f3441ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012a, code lost:
        if (r12 != ']') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x012c, code lost:
        r11.token = 15;
        r12 = r11.f3440bp + r6;
        r11.f3440bp = r12;
        r11.f3441ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013c, code lost:
        if (r12 != '}') goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x013e, code lost:
        r11.token = 13;
        r12 = r11.f3440bp + r6;
        r11.f3440bp = r12;
        r11.f3441ch = charAt(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0150, code lost:
        if (r12 != 26) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0152, code lost:
        r11.f3440bp += r6 - 1;
        r11.token = 20;
        r11.f3441ch = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x015f, code lost:
        r11.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0162, code lost:
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0163, code lost:
        r11.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0165, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0166, code lost:
        r11.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0168, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0171, code lost:
        throw new com.alibaba.fastjson.JSONException("illega str");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r12, java.lang.Class<?> r13) {
        /*
            Method dump skipped, instructions count: 371
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
        int i = length + 1;
        if (charAt(this.f3440bp + length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j = -2128831035;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(this.f3440bp + i);
            if (charAt == '\"') {
                int i3 = i2 + 1;
                char charAt2 = charAt(this.f3440bp + i2);
                if (charAt2 == ',') {
                    int i4 = this.f3440bp + i3;
                    this.f3440bp = i4;
                    this.f3441ch = charAt(i4);
                    this.matchStat = 3;
                    return j;
                } else if (charAt2 == '}') {
                    int i5 = i3 + 1;
                    char charAt3 = charAt(this.f3440bp + i3);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i6 = this.f3440bp + i5;
                        this.f3440bp = i6;
                        this.f3441ch = charAt(i6);
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i7 = this.f3440bp + i5;
                        this.f3440bp = i7;
                        this.f3441ch = charAt(i7);
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i8 = this.f3440bp + i5;
                        this.f3440bp = i8;
                        this.f3441ch = charAt(i8);
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.f3440bp += i5 - 1;
                        this.f3441ch = JSONLexer.EOI;
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.matchStat = 4;
                    return j;
                } else {
                    this.matchStat = -1;
                    return 0L;
                }
            }
            j = (j ^ charAt) * 16777619;
            if (charAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i = i2;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final float scanFloat(char c) {
        int i;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.f3440bp + 0);
        if (charAt2 >= '0' && charAt2 <= '9') {
            int i2 = 1;
            while (true) {
                i = i2 + 1;
                charAt = charAt(this.f3440bp + i2);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i2 = i;
            }
            if (charAt == '.') {
                int i3 = i + 1;
                char charAt3 = charAt(this.f3440bp + i);
                if (charAt3 >= '0' && charAt3 <= '9') {
                    while (true) {
                        i = i3 + 1;
                        charAt = charAt(this.f3440bp + i3);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i3 = i;
                    }
                } else {
                    this.matchStat = -1;
                    return 0.0f;
                }
            }
            int i4 = this.f3440bp;
            float parseFloat = Float.parseFloat(subString(i4, ((i4 + i) - i4) - 1));
            if (charAt == c) {
                int i5 = this.f3440bp + i;
                this.f3440bp = i5;
                this.f3441ch = charAt(i5);
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
        if (this.f3441ch == 'x') {
            next();
            if (this.f3441ch == '\'') {
                this.f3442np = this.f3440bp;
                next();
                while (true) {
                    next = next();
                    if ((next < '0' || next > '9') && (next < 'A' || next > 'F')) {
                        break;
                    }
                    this.f3443sp++;
                }
                if (next == '\'') {
                    this.f3443sp++;
                    next();
                    this.token = 26;
                    return;
                }
                throw new JSONException("illegal state. " + next);
            }
            throw new JSONException("illegal state. " + this.f3441ch);
        }
        throw new JSONException("illegal state. " + this.f3441ch);
    }

    public final void scanIdent() {
        this.f3442np = this.f3440bp - 1;
        this.hasSpecial = false;
        do {
            this.f3443sp++;
            next();
        } while (Character.isLetterOrDigit(this.f3441ch));
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
    public int scanInt(char c) {
        int i;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.f3440bp + 0);
        int i2 = 1;
        boolean z = charAt2 == '-';
        if (z) {
            charAt2 = charAt(this.f3440bp + 1);
            i2 = 2;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i3 = charAt2 - '0';
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.f3440bp + i2);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i3 = (i3 * 10) + (charAt - '0');
            i2 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if (i3 < 0) {
            this.matchStat = -1;
            return 0;
        } else {
            while (charAt != c) {
                if (isWhitespace(charAt)) {
                    i++;
                    charAt = charAt(this.f3440bp + i);
                } else {
                    this.matchStat = -1;
                    return z ? -i3 : i3;
                }
            }
            int i4 = this.f3440bp + i;
            this.f3440bp = i4;
            this.f3441ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return z ? -i3 : i3;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c) {
        int i;
        char charAt;
        this.matchStat = 0;
        char charAt2 = charAt(this.f3440bp + 0);
        int i2 = 1;
        boolean z = charAt2 == '-';
        if (z) {
            charAt2 = charAt(this.f3440bp + 1);
            i2 = 2;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j = charAt2 - '0';
        while (true) {
            i = i2 + 1;
            charAt = charAt(this.f3440bp + i2);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j = (j * 10) + (charAt - '0');
            i2 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        } else if (j < 0) {
            this.matchStat = -1;
            return 0L;
        } else {
            while (charAt != c) {
                if (isWhitespace(charAt)) {
                    charAt = charAt(this.f3440bp + i);
                    i++;
                } else {
                    this.matchStat = -1;
                    return j;
                }
            }
            int i3 = this.f3440bp + i;
            this.f3440bp = i3;
            this.f3441ch = charAt(i3);
            this.matchStat = 3;
            this.token = 16;
            return z ? -j : j;
        }
    }

    public final void scanNullOrNew() {
        if (this.f3441ch == 'n') {
            next();
            char c = this.f3441ch;
            if (c != 'u') {
                if (c == 'e') {
                    next();
                    if (this.f3441ch == 'w') {
                        next();
                        char c2 = this.f3441ch;
                        if (c2 != ' ' && c2 != ',' && c2 != '}' && c2 != ']' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != 26 && c2 != '\f' && c2 != '\b') {
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
            if (this.f3441ch == 'l') {
                next();
                if (this.f3441ch == 'l') {
                    next();
                    char c3 = this.f3441ch;
                    if (c3 != ' ' && c3 != ',' && c3 != '}' && c3 != ']' && c3 != '\n' && c3 != '\r' && c3 != '\t' && c3 != 26 && c3 != '\f' && c3 != '\b') {
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
        this.f3442np = this.f3440bp;
        this.hasSpecial = false;
        while (true) {
            char next = next();
            if (next == '\"') {
                this.token = 4;
                this.f3441ch = next();
                return;
            } else if (next == 26) {
                if (!isEOF()) {
                    putChar(JSONLexer.EOI);
                } else {
                    throw new JSONException("unclosed string : " + next);
                }
            } else if (next == '\\') {
                if (!this.hasSpecial) {
                    this.hasSpecial = true;
                    int i = this.f3443sp;
                    char[] cArr = this.sbuf;
                    if (i >= cArr.length) {
                        int length = cArr.length * 2;
                        if (i <= length) {
                            i = length;
                        }
                        char[] cArr2 = new char[i];
                        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                        this.sbuf = cArr2;
                    }
                    copyTo(this.f3442np + 1, this.f3443sp, this.sbuf);
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
                                putChar(StringUtil.CARRIAGE_RETURN);
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
                                                this.f3441ch = next2;
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
                this.f3443sp++;
            } else {
                int i2 = this.f3443sp;
                char[] cArr3 = this.sbuf;
                if (i2 == cArr3.length) {
                    putChar(next);
                } else {
                    this.f3443sp = i2 + 1;
                    cArr3[i2] = next;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x012b, code lost:
        if (r1 != r18) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012d, code lost:
        r1 = r16.f3440bp + r3;
        r16.f3440bp = r1;
        r16.f3441ch = charAt(r1);
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
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexerBase.scanStringArray(java.util.Collection, char):void");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable) {
        skipWhitespace();
        char c = this.f3441ch;
        if (c == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c == '\'') {
            if (isEnabled(Feature.AllowSingleQuotes)) {
                return scanSymbol(symbolTable, '\'');
            }
            throw new JSONException("syntax error");
        } else if (c == '}') {
            next();
            this.token = 13;
            return null;
        } else if (c == ',') {
            next();
            this.token = 16;
            return null;
        } else if (c == 26) {
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
        boolean z = false;
        if (this.token == 1 && this.pos == 0 && this.f3440bp == 1) {
            this.f3440bp = 0;
        }
        boolean[] zArr = IOUtils.firstIdentifierFlags;
        int i = this.f3441ch;
        if ((i >= zArr.length || zArr[i]) ? true : true) {
            boolean[] zArr2 = IOUtils.identifierFlags;
            this.f3442np = this.f3440bp;
            this.f3443sp = 1;
            while (true) {
                char next = next();
                if (next < zArr2.length && !zArr2[next]) {
                    break;
                }
                i = (i * 31) + next;
                this.f3443sp++;
            }
            this.f3441ch = charAt(this.f3440bp);
            this.token = 18;
            if (this.f3443sp == 4 && i == 3392903 && charAt(this.f3442np) == 'n' && charAt(this.f3442np + 1) == 'u' && charAt(this.f3442np + 2) == 'l' && charAt(this.f3442np + 3) == 'l') {
                return null;
            }
            if (symbolTable == null) {
                return subString(this.f3442np, this.f3443sp);
            }
            return addSymbol(this.f3442np, this.f3443sp, i, symbolTable);
        }
        throw new JSONException("illegal identifier : " + this.f3441ch + info());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanSymbolWithSeperator(SymbolTable symbolTable, char c) {
        int i = 0;
        this.matchStat = 0;
        char charAt = charAt(this.f3440bp + 0);
        if (charAt == 'n') {
            if (charAt(this.f3440bp + 1) == 'u' && charAt(this.f3440bp + 1 + 1) == 'l' && charAt(this.f3440bp + 1 + 2) == 'l') {
                if (charAt(this.f3440bp + 4) == c) {
                    int i2 = this.f3440bp + 5;
                    this.f3440bp = i2;
                    this.f3441ch = charAt(i2);
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
            int i3 = 1;
            while (true) {
                int i4 = i3 + 1;
                char charAt2 = charAt(this.f3440bp + i3);
                if (charAt2 == '\"') {
                    int i5 = this.f3440bp;
                    int i6 = i5 + 0 + 1;
                    String addSymbol = addSymbol(i6, ((i5 + i4) - i6) - 1, i, symbolTable);
                    int i7 = i4 + 1;
                    char charAt3 = charAt(this.f3440bp + i4);
                    while (charAt3 != c) {
                        if (isWhitespace(charAt3)) {
                            charAt3 = charAt(this.f3440bp + i7);
                            i7++;
                        } else {
                            this.matchStat = -1;
                            return addSymbol;
                        }
                    }
                    int i8 = this.f3440bp + i7;
                    this.f3440bp = i8;
                    this.f3441ch = charAt(i8);
                    this.matchStat = 3;
                    return addSymbol;
                }
                i = (i * 31) + charAt2;
                if (charAt2 == '\\') {
                    this.matchStat = -1;
                    return null;
                }
                i3 = i4;
            }
        }
    }

    public final void scanTrue() {
        if (this.f3441ch == 't') {
            next();
            if (this.f3441ch == 'r') {
                next();
                if (this.f3441ch == 'u') {
                    next();
                    if (this.f3441ch == 'e') {
                        next();
                        char c = this.f3441ch;
                        if (c != ' ' && c != ',' && c != '}' && c != ']' && c != '\n' && c != '\r' && c != '\t' && c != 26 && c != '\f' && c != '\b' && c != ':' && c != '/') {
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
            int length = this.f3440bp + cArr.length;
            int length2 = str.length();
            for (int i = 0; i < length2; i++) {
                if (str.charAt(i) != charAt(length + i)) {
                    return -1;
                }
            }
            int i2 = length + length2;
            if (charAt(i2) != '\"') {
                return -1;
            }
            int i3 = i2 + 1;
            char charAt = charAt(i3);
            this.f3441ch = charAt;
            if (charAt == ',') {
                int i4 = i3 + 1;
                this.f3441ch = charAt(i4);
                this.f3440bp = i4;
                this.token = 16;
                return 3;
            }
            if (charAt == '}') {
                i3++;
                char charAt2 = charAt(i3);
                this.f3441ch = charAt2;
                if (charAt2 == ',') {
                    this.token = 16;
                    i3++;
                    this.f3441ch = charAt(i3);
                } else if (charAt2 == ']') {
                    this.token = 15;
                    i3++;
                    this.f3441ch = charAt(i3);
                } else if (charAt2 == '}') {
                    this.token = 13;
                    i3++;
                    this.f3441ch = charAt(i3);
                } else if (charAt2 != 26) {
                    return -1;
                } else {
                    this.token = 20;
                }
                this.matchStat = 4;
            }
            this.f3440bp = i3;
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

    public void setToken(int i) {
        this.token = i;
    }

    protected void skipComment() {
        char c;
        next();
        char c2 = this.f3441ch;
        if (c2 == '/') {
            do {
                next();
                c = this.f3441ch;
                if (c == '\n') {
                    next();
                    return;
                }
            } while (c != 26);
        } else if (c2 == '*') {
            next();
            while (true) {
                char c3 = this.f3441ch;
                if (c3 == 26) {
                    return;
                }
                if (c3 == '*') {
                    next();
                    if (this.f3441ch == '/') {
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
            char c = this.f3441ch;
            if (c > '/') {
                return;
            }
            if (c == ' ' || c == '\r' || c == '\n' || c == '\t' || c == '\f' || c == '\b') {
                next();
            } else if (c != '/') {
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

    public abstract String subString(int i, int i2);

    protected abstract char[] sub_chars(int i, int i2);

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final int token() {
        return this.token;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String tokenName() {
        return JSONToken.name(this.token);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final boolean isEnabled(int i) {
        return (i & this.features) != 0;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextTokenWithColon(int i) {
        nextTokenWithChar(':');
    }

    public final boolean isEnabled(int i, int i2) {
        return ((this.features & i2) == 0 && (i & i2) == 0) ? false : true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final String scanSymbol(SymbolTable symbolTable, char c) {
        String addSymbol;
        this.f3442np = this.f3440bp;
        this.f3443sp = 0;
        boolean z = false;
        int i = 0;
        while (true) {
            char next = next();
            if (next == c) {
                this.token = 4;
                if (!z) {
                    int i2 = this.f3442np;
                    addSymbol = addSymbol(i2 == -1 ? 0 : i2 + 1, this.f3443sp, i, symbolTable);
                } else {
                    addSymbol = symbolTable.addSymbol(this.sbuf, 0, this.f3443sp, i);
                }
                this.f3443sp = 0;
                next();
                return addSymbol;
            } else if (next == 26) {
                throw new JSONException("unclosed.str");
            } else {
                if (next == '\\') {
                    if (!z) {
                        int i3 = this.f3443sp;
                        char[] cArr = this.sbuf;
                        if (i3 >= cArr.length) {
                            int length = cArr.length * 2;
                            if (i3 <= length) {
                                i3 = length;
                            }
                            char[] cArr2 = new char[i3];
                            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                            this.sbuf = cArr2;
                        }
                        arrayCopy(this.f3442np + 1, this.sbuf, 0, this.f3443sp);
                        z = true;
                    }
                    char next2 = next();
                    if (next2 == '\"') {
                        i = (i * 31) + 34;
                        putChar('\"');
                    } else if (next2 != '\'') {
                        if (next2 != 'F') {
                            if (next2 == '\\') {
                                i = (i * 31) + 92;
                                putChar('\\');
                            } else if (next2 == 'b') {
                                i = (i * 31) + 8;
                                putChar('\b');
                            } else if (next2 != 'f') {
                                if (next2 == 'n') {
                                    i = (i * 31) + 10;
                                    putChar('\n');
                                } else if (next2 == 'r') {
                                    i = (i * 31) + 13;
                                    putChar(StringUtil.CARRIAGE_RETURN);
                                } else if (next2 != 'x') {
                                    switch (next2) {
                                        case '/':
                                            i = (i * 31) + 47;
                                            putChar('/');
                                            continue;
                                        case '0':
                                            i = (i * 31) + next2;
                                            putChar((char) 0);
                                            continue;
                                        case '1':
                                            i = (i * 31) + next2;
                                            putChar((char) 1);
                                            continue;
                                        case '2':
                                            i = (i * 31) + next2;
                                            putChar((char) 2);
                                            continue;
                                        case '3':
                                            i = (i * 31) + next2;
                                            putChar((char) 3);
                                            continue;
                                        case '4':
                                            i = (i * 31) + next2;
                                            putChar((char) 4);
                                            continue;
                                        case '5':
                                            i = (i * 31) + next2;
                                            putChar((char) 5);
                                            continue;
                                        case '6':
                                            i = (i * 31) + next2;
                                            putChar((char) 6);
                                            continue;
                                        case '7':
                                            i = (i * 31) + next2;
                                            putChar((char) 7);
                                            continue;
                                        default:
                                            switch (next2) {
                                                case 't':
                                                    i = (i * 31) + 9;
                                                    putChar('\t');
                                                    continue;
                                                case 'u':
                                                    int parseInt = Integer.parseInt(new String(new char[]{next(), next(), next(), next()}), 16);
                                                    i = (i * 31) + parseInt;
                                                    putChar((char) parseInt);
                                                    continue;
                                                    continue;
                                                case 'v':
                                                    i = (i * 31) + 11;
                                                    putChar((char) 11);
                                                    continue;
                                                default:
                                                    this.f3441ch = next2;
                                                    throw new JSONException("unclosed.str.lit");
                                            }
                                    }
                                } else {
                                    char next3 = next();
                                    this.f3441ch = next3;
                                    char next4 = next();
                                    this.f3441ch = next4;
                                    int[] iArr = digits;
                                    char c2 = (char) ((iArr[next3] * 16) + iArr[next4]);
                                    i = (i * 31) + c2;
                                    putChar(c2);
                                }
                            }
                        }
                        i = (i * 31) + 12;
                        putChar('\f');
                    } else {
                        i = (i * 31) + 39;
                        putChar('\'');
                    }
                } else {
                    i = (i * 31) + next;
                    if (!z) {
                        this.f3443sp++;
                    } else {
                        int i4 = this.f3443sp;
                        char[] cArr3 = this.sbuf;
                        if (i4 == cArr3.length) {
                            putChar(next);
                        } else {
                            this.f3443sp = i4 + 1;
                            cArr3[i4] = next;
                        }
                    }
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public final void nextToken(int i) {
        this.f3443sp = 0;
        while (true) {
            if (i == 2) {
                char c = this.f3441ch;
                if (c >= '0' && c <= '9') {
                    this.pos = this.f3440bp;
                    scanNumber();
                    return;
                } else if (c == '\"') {
                    this.pos = this.f3440bp;
                    scanString();
                    return;
                } else if (c == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i == 4) {
                char c2 = this.f3441ch;
                if (c2 == '\"') {
                    this.pos = this.f3440bp;
                    scanString();
                    return;
                } else if (c2 >= '0' && c2 <= '9') {
                    this.pos = this.f3440bp;
                    scanNumber();
                    return;
                } else if (c2 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c2 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            } else if (i == 12) {
                char c3 = this.f3441ch;
                if (c3 == '{') {
                    this.token = 12;
                    next();
                    return;
                } else if (c3 == '[') {
                    this.token = 14;
                    next();
                    return;
                }
            } else if (i != 18) {
                if (i != 20) {
                    switch (i) {
                        case 14:
                            char c4 = this.f3441ch;
                            if (c4 == '[') {
                                this.token = 14;
                                next();
                                return;
                            } else if (c4 == '{') {
                                this.token = 12;
                                next();
                                return;
                            }
                            break;
                        case 15:
                            if (this.f3441ch == ']') {
                                this.token = 15;
                                next();
                                return;
                            }
                            break;
                        case 16:
                            char c5 = this.f3441ch;
                            if (c5 == ',') {
                                this.token = 16;
                                next();
                                return;
                            } else if (c5 == '}') {
                                this.token = 13;
                                next();
                                return;
                            } else if (c5 == ']') {
                                this.token = 15;
                                next();
                                return;
                            } else if (c5 == 26) {
                                this.token = 20;
                                return;
                            }
                            break;
                    }
                }
                if (this.f3441ch == 26) {
                    this.token = 20;
                    return;
                }
            } else {
                nextIdent();
                return;
            }
            char c6 = this.f3441ch;
            if (c6 != ' ' && c6 != '\n' && c6 != '\r' && c6 != '\t' && c6 != '\f' && c6 != '\b') {
                nextToken();
                return;
            }
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexer
    public String scanString(char c) {
        this.matchStat = 0;
        char charAt = charAt(this.f3440bp + 0);
        if (charAt == 'n') {
            if (charAt(this.f3440bp + 1) == 'u' && charAt(this.f3440bp + 1 + 1) == 'l' && charAt(this.f3440bp + 1 + 2) == 'l') {
                if (charAt(this.f3440bp + 4) == c) {
                    int i = this.f3440bp + 5;
                    this.f3440bp = i;
                    this.f3441ch = charAt(i);
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
            int i2 = this.f3440bp + 1;
            int indexOf = indexOf('\"', i2);
            if (indexOf != -1) {
                String subString = subString(this.f3440bp + 1, indexOf - i2);
                if (subString.indexOf(92) != -1) {
                    while (true) {
                        int i3 = 0;
                        for (int i4 = indexOf - 1; i4 >= 0 && charAt(i4) == '\\'; i4--) {
                            i3++;
                        }
                        if (i3 % 2 == 0) {
                            break;
                        }
                        indexOf = indexOf('\"', indexOf + 1);
                    }
                    int i5 = indexOf - i2;
                    subString = readString(sub_chars(this.f3440bp + 1, i5), i5);
                }
                int i6 = this.f3440bp;
                int i7 = 1 + (indexOf - (i6 + 1)) + 1;
                int i8 = i7 + 1;
                if (charAt(i6 + i7) == c) {
                    int i9 = this.f3440bp + i8;
                    this.f3440bp = i9;
                    this.f3441ch = charAt(i9);
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
