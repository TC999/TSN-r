package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.TimeZone;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class JSONScanner extends JSONLexerBase {
    private final int len;
    private final String text;

    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    static boolean charArrayCompare(String str, int i, char[] cArr) {
        int length = cArr.length;
        if (length + i > str.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (cArr[i2] != str.charAt(i + i2)) {
                return false;
            }
        }
        return true;
    }

    static boolean checkDate(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if ((c == '1' || c == '2') && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9') {
            if (c5 == '0') {
                if (c6 < '1' || c6 > '9') {
                    return false;
                }
            } else if (c5 != '1' || (c6 != '0' && c6 != '1' && c6 != '2')) {
                return false;
            }
            if (i == 48) {
                return i2 >= 49 && i2 <= 57;
            } else if (i != 49 && i != 50) {
                return i == 51 && (i2 == 48 || i2 == 49);
            } else if (i2 >= 48 && i2 <= 57) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001d, code lost:
        if (r6 <= '4') goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean checkTime(char r5, char r6, char r7, char r8, char r9, char r10) {
        /*
            r4 = this;
            r0 = 57
            r1 = 0
            r2 = 48
            if (r5 != r2) goto Lc
            if (r6 < r2) goto Lb
            if (r6 <= r0) goto L20
        Lb:
            return r1
        Lc:
            r3 = 49
            if (r5 != r3) goto L15
            if (r6 < r2) goto L14
            if (r6 <= r0) goto L20
        L14:
            return r1
        L15:
            r3 = 50
            if (r5 != r3) goto L42
            if (r6 < r2) goto L42
            r5 = 52
            if (r6 <= r5) goto L20
            goto L42
        L20:
            r5 = 53
            r6 = 54
            if (r7 < r2) goto L2d
            if (r7 > r5) goto L2d
            if (r8 < r2) goto L2c
            if (r8 <= r0) goto L32
        L2c:
            return r1
        L2d:
            if (r7 != r6) goto L42
            if (r8 == r2) goto L32
            return r1
        L32:
            if (r9 < r2) goto L3b
            if (r9 > r5) goto L3b
            if (r10 < r2) goto L3a
            if (r10 <= r0) goto L40
        L3a:
            return r1
        L3b:
            if (r9 != r6) goto L42
            if (r10 == r2) goto L40
            return r1
        L40:
            r5 = 1
            return r5
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.checkTime(char, char, char, char, char, char):boolean");
    }

    private void setCalendar(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = calendar;
        calendar.set(1, ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(2, (((c5 - '0') * 10) + (c6 - '0')) - 1);
        this.calendar.set(5, ((c7 - '0') * 10) + (c8 - '0'));
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i, int i2, int i3, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        this.text.getChars(i, i3 + i, cArr, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token == 26) {
            int i = this.f3442np + 1;
            int i2 = this.f3443sp;
            if (i2 % 2 == 0) {
                int i3 = i2 / 2;
                byte[] bArr = new byte[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = (i4 * 2) + i;
                    char charAt = this.text.charAt(i5);
                    char charAt2 = this.text.charAt(i5 + 1);
                    char c = '0';
                    int i6 = charAt - (charAt <= '9' ? '0' : '7');
                    if (charAt2 > '9') {
                        c = '7';
                    }
                    bArr[i4] = (byte) ((i6 << 4) | (charAt2 - c));
                }
                return bArr;
            }
            throw new JSONException("illegal state. " + i2);
        }
        return IOUtils.decodeBase64(this.text, this.f3442np + 1, this.f3443sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i) {
        return i >= this.len ? JSONLexer.EOI : this.text.charAt(i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void copyTo(int i, int i2, char[] cArr) {
        this.text.getChars(i, i2 + i, cArr, 0);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        char charAt = charAt((this.f3442np + this.f3443sp) - 1);
        int i = this.f3443sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        int i2 = this.f3442np;
        char[] cArr = this.sbuf;
        if (i < cArr.length) {
            this.text.getChars(i2, i2 + i, cArr, 0);
            return new BigDecimal(this.sbuf, 0, i);
        }
        char[] cArr2 = new char[i];
        this.text.getChars(i2, i + i2, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c, int i) {
        return this.text.indexOf(c, i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("pos ");
        sb.append(this.f3440bp);
        sb.append(", json : ");
        sb.append(this.text.length() < 65536 ? this.text : this.text.substring(0, 65536));
        return sb.toString();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        int i = this.f3440bp;
        int i2 = this.len;
        if (i != i2) {
            return this.f3441ch == 26 && i + 1 == i2;
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
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

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i = this.f3440bp + 1;
        this.f3440bp = i;
        char charAt = i >= this.len ? JSONLexer.EOI : this.text.charAt(i);
        this.f3441ch = charAt;
        return charAt;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        char charAt = charAt((this.f3442np + this.f3443sp) - 1);
        int i = this.f3443sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        return subString(this.f3442np, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f2, code lost:
        return r1;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean scanFieldBoolean(char[] r9) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldBoolean(char[]):boolean");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int scanFieldInt(char[] cArr) {
        boolean z;
        int i;
        char charAt;
        this.matchStat = 0;
        int i2 = this.f3440bp;
        char c = this.f3441ch;
        if (!charArrayCompare(this.text, i2, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.f3440bp + cArr.length;
        int i3 = length + 1;
        char charAt2 = charAt(length);
        if (charAt2 == '-') {
            z = true;
            charAt2 = charAt(i3);
            i3++;
        } else {
            z = false;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i4 = charAt2 - '0';
        while (true) {
            i = i3 + 1;
            charAt = charAt(i3);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i4 = (i4 * 10) + (charAt - '0');
            i3 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if (i4 < 0) {
            this.matchStat = -1;
            return 0;
        } else {
            while (charAt != ',' && charAt != '}') {
                if (JSONLexerBase.isWhitespace(charAt)) {
                    char charAt3 = charAt(i);
                    i++;
                    charAt = charAt3;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            }
            int i5 = i - 1;
            this.f3440bp = i5;
            if (charAt == ',') {
                int i6 = i5 + 1;
                this.f3440bp = i6;
                this.f3441ch = charAt(i6);
                this.matchStat = 3;
                this.token = 16;
                return z ? -i4 : i4;
            }
            if (charAt == '}') {
                int i7 = i5 + 1;
                this.f3440bp = i7;
                char charAt4 = charAt(i7);
                while (true) {
                    if (charAt4 == ',') {
                        this.token = 16;
                        int i8 = this.f3440bp + 1;
                        this.f3440bp = i8;
                        this.f3441ch = charAt(i8);
                        break;
                    } else if (charAt4 == ']') {
                        this.token = 15;
                        int i9 = this.f3440bp + 1;
                        this.f3440bp = i9;
                        this.f3441ch = charAt(i9);
                        break;
                    } else if (charAt4 == '}') {
                        this.token = 13;
                        int i10 = this.f3440bp + 1;
                        this.f3440bp = i10;
                        this.f3441ch = charAt(i10);
                        break;
                    } else if (charAt4 == 26) {
                        this.token = 20;
                        break;
                    } else if (JSONLexerBase.isWhitespace(charAt4)) {
                        int i11 = this.f3440bp + 1;
                        this.f3440bp = i11;
                        charAt4 = charAt(i11);
                    } else {
                        this.f3440bp = i2;
                        this.f3441ch = c;
                        this.matchStat = -1;
                        return 0;
                    }
                }
                this.matchStat = 4;
            }
            return z ? -i4 : i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ce, code lost:
        r17.matchStat = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d1, code lost:
        if (r2 == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d4, code lost:
        return -r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
        return r12;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long scanFieldLong(char[] r18) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldLong(char[]):long");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        int i = this.f3440bp;
        char c = this.f3441ch;
        if (!charArrayCompare(this.text, i, cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = this.f3440bp + cArr.length;
        int i2 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', i2);
        if (indexOf != -1) {
            String subString = subString(i2, indexOf - i2);
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
                int i5 = this.f3440bp;
                int length2 = indexOf - ((cArr.length + i5) + 1);
                subString = JSONLexerBase.readString(sub_chars(i5 + cArr.length + 1, length2), length2);
            }
            char charAt = charAt(indexOf + 1);
            while (charAt != ',' && charAt != '}') {
                if (JSONLexerBase.isWhitespace(charAt)) {
                    indexOf++;
                    charAt = charAt(indexOf + 1);
                } else {
                    this.matchStat = -1;
                    return stringDefaultValue();
                }
            }
            int i6 = indexOf + 1;
            this.f3440bp = i6;
            this.f3441ch = charAt;
            if (charAt == ',') {
                int i7 = i6 + 1;
                this.f3440bp = i7;
                this.f3441ch = charAt(i7);
                this.matchStat = 3;
                return subString;
            }
            int i8 = i6 + 1;
            this.f3440bp = i8;
            char charAt2 = charAt(i8);
            if (charAt2 == ',') {
                this.token = 16;
                int i9 = this.f3440bp + 1;
                this.f3440bp = i9;
                this.f3441ch = charAt(i9);
            } else if (charAt2 == ']') {
                this.token = 15;
                int i10 = this.f3440bp + 1;
                this.f3440bp = i10;
                this.f3441ch = charAt(i10);
            } else if (charAt2 == '}') {
                this.token = 13;
                int i11 = this.f3440bp + 1;
                this.f3440bp = i11;
                this.f3441ch = charAt(i11);
            } else if (charAt2 == 26) {
                this.token = 20;
            } else {
                this.f3440bp = i;
                this.f3441ch = c;
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.matchStat = 4;
            return subString;
        }
        throw new JSONException("unclosed str");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ca, code lost:
        if (r1 != ']') goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d0, code lost:
        if (r3.size() != 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d2, code lost:
        r1 = r5 + 1;
        r2 = charAt(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d9, code lost:
        r17.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00db, code lost:
        return null;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r18, java.lang.Class<?> r19) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.f3440bp, cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = this.f3440bp + cArr.length;
        int i = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j = -2128831035;
        while (true) {
            int i2 = i + 1;
            char charAt = charAt(i);
            if (charAt == '\"') {
                this.f3440bp = i2;
                char charAt2 = charAt(i2);
                this.f3441ch = charAt2;
                while (charAt2 != ',') {
                    if (charAt2 == '}') {
                        next();
                        skipWhitespace();
                        char current = getCurrent();
                        if (current == ',') {
                            this.token = 16;
                            int i3 = this.f3440bp + 1;
                            this.f3440bp = i3;
                            this.f3441ch = charAt(i3);
                        } else if (current == ']') {
                            this.token = 15;
                            int i4 = this.f3440bp + 1;
                            this.f3440bp = i4;
                            this.f3441ch = charAt(i4);
                        } else if (current == '}') {
                            this.token = 13;
                            int i5 = this.f3440bp + 1;
                            this.f3440bp = i5;
                            this.f3441ch = charAt(i5);
                        } else if (current == 26) {
                            this.token = 20;
                        } else {
                            this.matchStat = -1;
                            return 0L;
                        }
                        this.matchStat = 4;
                        return j;
                    } else if (JSONLexerBase.isWhitespace(charAt2)) {
                        int i6 = this.f3440bp + 1;
                        this.f3440bp = i6;
                        charAt2 = charAt(i6);
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                }
                int i7 = this.f3440bp + 1;
                this.f3440bp = i7;
                this.f3441ch = charAt(i7);
                this.matchStat = 3;
                return j;
            } else if (i2 > this.len) {
                this.matchStat = -1;
                return 0L;
            } else {
                j = (j ^ charAt) * 16777619;
                i = i2;
            }
        }
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final int scanInt(char c) {
        int i;
        char charAt;
        this.matchStat = 0;
        int i2 = this.f3440bp;
        int i3 = i2 + 1;
        char charAt2 = charAt(i2);
        boolean z = charAt2 == '-';
        if (z) {
            int i4 = i3 + 1;
            char charAt3 = charAt(i3);
            i3 = i4;
            charAt2 = charAt3;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i5 = charAt2 - '0';
        while (true) {
            i = i3 + 1;
            charAt = charAt(i3);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i5 = (i5 * 10) + (charAt - '0');
            i3 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if (i5 < 0) {
            this.matchStat = -1;
            return 0;
        } else {
            while (charAt != c) {
                if (JSONLexerBase.isWhitespace(charAt)) {
                    charAt = charAt(i);
                    i++;
                } else {
                    this.matchStat = -1;
                    return z ? -i5 : i5;
                }
            }
            this.f3440bp = i;
            this.f3441ch = charAt(i);
            this.matchStat = 3;
            this.token = 16;
            return z ? -i5 : i5;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c) {
        int i;
        char charAt;
        this.matchStat = 0;
        int i2 = this.f3440bp;
        int i3 = i2 + 1;
        char charAt2 = charAt(i2);
        boolean z = charAt2 == '-';
        if (z) {
            int i4 = i3 + 1;
            char charAt3 = charAt(i3);
            i3 = i4;
            charAt2 = charAt3;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j = charAt2 - '0';
        while (true) {
            i = i3 + 1;
            charAt = charAt(i3);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j = (j * 10) + (charAt - '0');
            i3 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        } else if (j < 0) {
            this.matchStat = -1;
            return 0L;
        } else {
            while (charAt != c) {
                if (JSONLexerBase.isWhitespace(charAt)) {
                    charAt = charAt(i);
                    i++;
                } else {
                    this.matchStat = -1;
                    return j;
                }
            }
            this.f3440bp = i;
            this.f3441ch = charAt(i);
            this.matchStat = 3;
            this.token = 16;
            return z ? -j : j;
        }
    }

    protected void setTime(char c, char c2, char c3, char c4, char c5, char c6) {
        this.calendar.set(11, ((c - '0') * 10) + (c2 - '0'));
        this.calendar.set(12, ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(13, ((c5 - '0') * 10) + (c6 - '0'));
    }

    protected void setTimeZone(char c, char c2, char c3) {
        int i = (((c2 - '0') * 10) + (c3 - '0')) * SdkConfigData.DEFAULT_REQUEST_INTERVAL * 1000;
        if (c == '-') {
            i = -i;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i) {
            String[] availableIDs = TimeZone.getAvailableIDs(i);
            if (availableIDs.length > 0) {
                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        if (!this.hasSpecial) {
            return subString(this.f3442np + 1, this.f3443sp);
        }
        return new String(this.sbuf, 0, this.f3443sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i, int i2) {
        if (ASMUtils.IS_ANDROID) {
            char[] cArr = this.sbuf;
            if (i2 < cArr.length) {
                this.text.getChars(i, i + i2, cArr, 0);
                return new String(this.sbuf, 0, i2);
            }
            char[] cArr2 = new char[i2];
            this.text.getChars(i, i2 + i, cArr2, 0);
            return new String(cArr2);
        }
        return this.text.substring(i, i2 + i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i, int i2) {
        if (ASMUtils.IS_ANDROID) {
            char[] cArr = this.sbuf;
            if (i2 < cArr.length) {
                this.text.getChars(i, i2 + i, cArr, 0);
                return this.sbuf;
            }
        }
        char[] cArr2 = new char[i2];
        this.text.getChars(i, i2 + i, cArr2, 0);
        return cArr2;
    }

    public JSONScanner(String str, int i) {
        super(i);
        this.text = str;
        this.len = str.length();
        this.f3440bp = -1;
        next();
        if (this.f3441ch == 65279) {
            next();
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        char c;
        int i5;
        char charAt;
        int i6;
        char charAt2;
        int i7;
        int i8;
        char charAt3;
        char charAt4;
        int i9 = this.len;
        int i10 = this.f3440bp;
        int i11 = i9 - i10;
        if (!z && i11 > 13) {
            char charAt5 = charAt(i10);
            char charAt6 = charAt(this.f3440bp + 1);
            char charAt7 = charAt(this.f3440bp + 2);
            char charAt8 = charAt(this.f3440bp + 3);
            char charAt9 = charAt(this.f3440bp + 4);
            char charAt10 = charAt(this.f3440bp + 5);
            char charAt11 = charAt((this.f3440bp + i11) - 1);
            char charAt12 = charAt((this.f3440bp + i11) - 2);
            if (charAt5 == '/' && charAt6 == 'D' && charAt7 == 'a' && charAt8 == 't' && charAt9 == 'e' && charAt10 == '(' && charAt11 == '/' && charAt12 == ')') {
                int i12 = -1;
                for (int i13 = 6; i13 < i11; i13++) {
                    char charAt13 = charAt(this.f3440bp + i13);
                    if (charAt13 != '+') {
                        if (charAt13 < '0' || charAt13 > '9') {
                            break;
                        }
                    } else {
                        i12 = i13;
                    }
                }
                if (i12 == -1) {
                    return false;
                }
                int i14 = this.f3440bp + 6;
                long parseLong = Long.parseLong(subString(i14, i12 - i14));
                Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
                this.calendar = calendar;
                calendar.setTimeInMillis(parseLong);
                this.token = 5;
                return true;
            }
        }
        if (i11 == 8 || i11 == 14 || (i11 == 17 && charAt(this.f3440bp + 6) != '-')) {
            int i15 = 0;
            if (z) {
                return false;
            }
            char charAt14 = charAt(this.f3440bp);
            char charAt15 = charAt(this.f3440bp + 1);
            char charAt16 = charAt(this.f3440bp + 2);
            char charAt17 = charAt(this.f3440bp + 3);
            char charAt18 = charAt(this.f3440bp + 4);
            char charAt19 = charAt(this.f3440bp + 5);
            char charAt20 = charAt(this.f3440bp + 6);
            char charAt21 = charAt(this.f3440bp + 7);
            if (checkDate(charAt14, charAt15, charAt16, charAt17, charAt18, charAt19, charAt20, charAt21)) {
                setCalendar(charAt14, charAt15, charAt16, charAt17, charAt18, charAt19, charAt20, charAt21);
                if (i11 != 8) {
                    char charAt22 = charAt(this.f3440bp + 8);
                    char charAt23 = charAt(this.f3440bp + 9);
                    char charAt24 = charAt(this.f3440bp + 10);
                    char charAt25 = charAt(this.f3440bp + 11);
                    char charAt26 = charAt(this.f3440bp + 12);
                    char charAt27 = charAt(this.f3440bp + 13);
                    if (!checkTime(charAt22, charAt23, charAt24, charAt25, charAt26, charAt27)) {
                        return false;
                    }
                    if (i11 == 17) {
                        char charAt28 = charAt(this.f3440bp + 14);
                        char charAt29 = charAt(this.f3440bp + 15);
                        char charAt30 = charAt(this.f3440bp + 16);
                        if (charAt28 < '0' || charAt28 > '9' || charAt29 < '0' || charAt29 > '9' || charAt30 < '0' || charAt30 > '9') {
                            return false;
                        }
                        i4 = ((charAt28 - '0') * 100) + ((charAt29 - '0') * 10) + (charAt30 - '0');
                    } else {
                        i4 = 0;
                    }
                    i = ((charAt24 - '0') * 10) + (charAt25 - '0');
                    i2 = ((charAt26 - '0') * 10) + (charAt27 - '0');
                    i15 = i4;
                    i3 = ((charAt22 - '0') * 10) + (charAt23 - '0');
                } else {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                }
                this.calendar.set(11, i3);
                this.calendar.set(12, i);
                this.calendar.set(13, i2);
                this.calendar.set(14, i15);
                this.token = 5;
                return true;
            }
            return false;
        } else if (i11 < 9) {
            return false;
        } else {
            char charAt31 = charAt(this.f3440bp);
            char charAt32 = charAt(this.f3440bp + 1);
            char charAt33 = charAt(this.f3440bp + 2);
            char charAt34 = charAt(this.f3440bp + 3);
            char charAt35 = charAt(this.f3440bp + 4);
            char charAt36 = charAt(this.f3440bp + 5);
            char charAt37 = charAt(this.f3440bp + 6);
            char charAt38 = charAt(this.f3440bp + 7);
            char charAt39 = charAt(this.f3440bp + 8);
            char charAt40 = charAt(this.f3440bp + 9);
            if ((charAt35 == '-' && charAt38 == '-') || (charAt35 == '/' && charAt38 == '/')) {
                charAt38 = charAt40;
                c = charAt36;
                charAt36 = charAt37;
                i5 = 10;
            } else if (charAt35 == '-' && charAt37 == '-') {
                if (charAt39 == ' ') {
                    c = '0';
                    i5 = 8;
                    charAt39 = '0';
                } else {
                    c = '0';
                    i5 = 9;
                    charAt39 = charAt38;
                    charAt38 = charAt39;
                }
            } else if ((charAt33 == '.' && charAt36 == '.') || (charAt33 == '-' && charAt36 == '-')) {
                charAt36 = charAt35;
                charAt33 = charAt39;
                charAt39 = charAt31;
                charAt31 = charAt37;
                i5 = 10;
                charAt38 = charAt32;
                charAt32 = charAt38;
                charAt34 = charAt40;
                c = charAt34;
            } else if (charAt35 != 24180 && charAt35 != 45380) {
                return false;
            } else {
                if (charAt38 == 26376 || charAt38 == 50900) {
                    if (charAt40 == 26085 || charAt40 == 51068) {
                        c = charAt36;
                        charAt36 = charAt37;
                        charAt38 = charAt39;
                    } else if (charAt(this.f3440bp + 10) != 26085 && charAt(this.f3440bp + 10) != 51068) {
                        return false;
                    } else {
                        charAt38 = charAt40;
                        c = charAt36;
                        charAt36 = charAt37;
                        i5 = 11;
                    }
                } else if (charAt37 != 26376 && charAt37 != 50900) {
                    return false;
                } else {
                    if (charAt39 == 26085 || charAt39 == 51068) {
                        c = '0';
                    } else if (charAt40 != 26085 && charAt40 != 51068) {
                        return false;
                    } else {
                        c = '0';
                        i5 = 10;
                        charAt39 = charAt38;
                        charAt38 = charAt39;
                    }
                }
                i5 = 10;
                charAt39 = '0';
            }
            if (checkDate(charAt31, charAt32, charAt33, charAt34, c, charAt36, charAt39, charAt38)) {
                setCalendar(charAt31, charAt32, charAt33, charAt34, c, charAt36, charAt39, charAt38);
                char charAt41 = charAt(this.f3440bp + i5);
                if (charAt41 != 'T' && (charAt41 != ' ' || z)) {
                    if (charAt41 != '\"' && charAt41 != 26 && charAt41 != 26085 && charAt41 != 51068) {
                        if ((charAt41 == '+' || charAt41 == '-') && this.len == i5 + 6 && charAt(this.f3440bp + i5 + 3) == ':' && charAt(this.f3440bp + i5 + 4) == '0' && charAt(this.f3440bp + i5 + 5) == '0') {
                            setTime('0', '0', '0', '0', '0', '0');
                            this.calendar.set(14, 0);
                            setTimeZone(charAt41, charAt(this.f3440bp + i5 + 1), charAt(this.f3440bp + i5 + 2));
                            return true;
                        }
                        return false;
                    }
                    this.calendar.set(11, 0);
                    this.calendar.set(12, 0);
                    this.calendar.set(13, 0);
                    this.calendar.set(14, 0);
                    int i16 = this.f3440bp + i5;
                    this.f3440bp = i16;
                    this.f3441ch = charAt(i16);
                    this.token = 5;
                    return true;
                }
                int i17 = i5 + 9;
                if (i11 >= i17 && charAt(this.f3440bp + i5 + 3) == ':' && charAt(this.f3440bp + i5 + 6) == ':') {
                    char charAt42 = charAt(this.f3440bp + i5 + 1);
                    char charAt43 = charAt(this.f3440bp + i5 + 2);
                    char charAt44 = charAt(this.f3440bp + i5 + 4);
                    char charAt45 = charAt(this.f3440bp + i5 + 5);
                    char charAt46 = charAt(this.f3440bp + i5 + 7);
                    char charAt47 = charAt(this.f3440bp + i5 + 8);
                    if (checkTime(charAt42, charAt43, charAt44, charAt45, charAt46, charAt47)) {
                        setTime(charAt42, charAt43, charAt44, charAt45, charAt46, charAt47);
                        char charAt48 = charAt(this.f3440bp + i5 + 9);
                        if (charAt48 != '.') {
                            this.calendar.set(14, 0);
                            int i18 = this.f3440bp + i17;
                            this.f3440bp = i18;
                            this.f3441ch = charAt(i18);
                            this.token = 5;
                            if (charAt48 == 'Z' && this.calendar.getTimeZone().getRawOffset() != 0) {
                                String[] availableIDs = TimeZone.getAvailableIDs(0);
                                if (availableIDs.length > 0) {
                                    this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                                }
                            }
                            return true;
                        }
                        int i19 = i5 + 11;
                        if (i11 >= i19 && (charAt = charAt(this.f3440bp + i5 + 10)) >= '0' && charAt <= '9') {
                            int i20 = charAt - '0';
                            if (i11 <= i19 || (charAt4 = charAt(this.f3440bp + i5 + 11)) < '0' || charAt4 > '9') {
                                i6 = 1;
                            } else {
                                i20 = (i20 * 10) + (charAt4 - '0');
                                i6 = 2;
                            }
                            if (i6 == 2 && (charAt3 = charAt(this.f3440bp + i5 + 12)) >= '0' && charAt3 <= '9') {
                                i20 = (i20 * 10) + (charAt3 - '0');
                                i6 = 3;
                            }
                            this.calendar.set(14, i20);
                            char charAt49 = charAt(this.f3440bp + i5 + 10 + i6);
                            if (charAt49 == '+' || charAt49 == '-') {
                                char charAt50 = charAt(this.f3440bp + i5 + 10 + i6 + 1);
                                if (charAt50 >= '0' && charAt50 <= '1' && (charAt2 = charAt(this.f3440bp + i5 + 10 + i6 + 2)) >= '0' && charAt2 <= '9') {
                                    char charAt51 = charAt(this.f3440bp + i5 + 10 + i6 + 3);
                                    if (charAt51 == ':') {
                                        if (charAt(this.f3440bp + i5 + 10 + i6 + 4) != '0' || charAt(this.f3440bp + i5 + 10 + i6 + 5) != '0') {
                                            return false;
                                        }
                                        i7 = 6;
                                    } else if (charAt51 != '0') {
                                        i7 = 3;
                                    } else if (charAt(this.f3440bp + i5 + 10 + i6 + 4) != '0') {
                                        return false;
                                    } else {
                                        i7 = 5;
                                    }
                                    setTimeZone(charAt49, charAt50, charAt2);
                                    i8 = i7;
                                }
                            } else if (charAt49 == 'Z') {
                                if (this.calendar.getTimeZone().getRawOffset() != 0) {
                                    String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                                    if (availableIDs2.length > 0) {
                                        this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                                    }
                                }
                                i8 = 1;
                            } else {
                                i8 = 0;
                            }
                            int i21 = i5 + 10 + i6 + i8;
                            char charAt52 = charAt(this.f3440bp + i21);
                            if (charAt52 == 26 || charAt52 == '\"') {
                                int i22 = this.f3440bp + i21;
                                this.f3440bp = i22;
                                this.f3441ch = charAt(i22);
                                this.token = 5;
                                return true;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        return charArrayCompare(this.text, this.f3440bp, cArr);
    }

    public JSONScanner(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }
}
