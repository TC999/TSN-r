package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.TimeZone;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class JSONScanner extends JSONLexerBase {
    private final int len;
    private final String text;

    public JSONScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    static boolean charArrayCompare(String str, int i4, char[] cArr) {
        int length = cArr.length;
        if (length + i4 > str.length()) {
            return false;
        }
        for (int i5 = 0; i5 < length; i5++) {
            if (cArr[i5] != str.charAt(i4 + i5)) {
                return false;
            }
        }
        return true;
    }

    static boolean checkDate(char c4, char c5, char c6, char c7, char c8, char c9, int i4, int i5) {
        if ((c4 == '1' || c4 == '2') && c5 >= '0' && c5 <= '9' && c6 >= '0' && c6 <= '9' && c7 >= '0' && c7 <= '9') {
            if (c8 == '0') {
                if (c9 < '1' || c9 > '9') {
                    return false;
                }
            } else if (c8 != '1' || (c9 != '0' && c9 != '1' && c9 != '2')) {
                return false;
            }
            if (i4 == 48) {
                return i5 >= 49 && i5 <= 57;
            } else if (i4 != 49 && i4 != 50) {
                return i4 == 51 && (i5 == 48 || i5 == 49);
            } else if (i5 >= 48 && i5 <= 57) {
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

    private void setCalendar(char c4, char c5, char c6, char c7, char c8, char c9, char c10, char c11) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = calendar;
        calendar.set(1, ((c4 - '0') * 1000) + ((c5 - '0') * 100) + ((c6 - '0') * 10) + (c7 - '0'));
        this.calendar.set(2, (((c8 - '0') * 10) + (c9 - '0')) - 1);
        this.calendar.set(5, ((c10 - '0') * 10) + (c11 - '0'));
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i4, int i5, int i6, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i4, i5, i6);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void arrayCopy(int i4, char[] cArr, int i5, int i6) {
        this.text.getChars(i4, i6 + i4, cArr, i5);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token == 26) {
            int i4 = this.np + 1;
            int i5 = this.sp;
            if (i5 % 2 == 0) {
                int i6 = i5 / 2;
                byte[] bArr = new byte[i6];
                for (int i7 = 0; i7 < i6; i7++) {
                    int i8 = (i7 * 2) + i4;
                    char charAt = this.text.charAt(i8);
                    char charAt2 = this.text.charAt(i8 + 1);
                    char c4 = '0';
                    int i9 = charAt - (charAt <= '9' ? '0' : '7');
                    if (charAt2 > '9') {
                        c4 = '7';
                    }
                    bArr[i7] = (byte) ((i9 << 4) | (charAt2 - c4));
                }
                return bArr;
            }
            throw new JSONException("illegal state. " + i5);
        }
        return IOUtils.decodeBase64(this.text, this.np + 1, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i4) {
        if (i4 >= this.len) {
            return (char) 26;
        }
        return this.text.charAt(i4);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void copyTo(int i4, int i5, char[] cArr) {
        this.text.getChars(i4, i5 + i4, cArr, 0);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        char charAt = charAt((this.np + this.sp) - 1);
        int i4 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i4--;
        }
        int i5 = this.np;
        char[] cArr = this.sbuf;
        if (i4 < cArr.length) {
            this.text.getChars(i5, i5 + i4, cArr, 0);
            return new BigDecimal(this.sbuf, 0, i4);
        }
        char[] cArr2 = new char[i4];
        this.text.getChars(i5, i4 + i5, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c4, int i4) {
        return this.text.indexOf(c4, i4);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("pos ");
        sb.append(this.bp);
        sb.append(", json : ");
        sb.append(this.text.length() < 65536 ? this.text : this.text.substring(0, 65536));
        return sb.toString();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        int i4 = this.bp;
        int i5 = this.len;
        if (i4 != i5) {
            return this.ch == 26 && i4 + 1 == i5;
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
        } catch (Exception e4) {
            throw new JSONException(e4.getMessage(), e4);
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i4 = this.bp + 1;
        this.bp = i4;
        char charAt = i4 >= this.len ? (char) 26 : this.text.charAt(i4);
        this.ch = charAt;
        return charAt;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        char charAt = charAt((this.np + this.sp) - 1);
        int i4 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i4--;
        }
        return subString(this.np, i4);
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
        boolean z3;
        int i4;
        char charAt;
        this.matchStat = 0;
        int i5 = this.bp;
        char c4 = this.ch;
        if (!charArrayCompare(this.text, i5, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.bp + cArr.length;
        int i6 = length + 1;
        char charAt2 = charAt(length);
        if (charAt2 == '-') {
            z3 = true;
            charAt2 = charAt(i6);
            i6++;
        } else {
            z3 = false;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i7 = charAt2 - '0';
        while (true) {
            i4 = i6 + 1;
            charAt = charAt(i6);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i7 = (i7 * 10) + (charAt - '0');
            i6 = i4;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if (i7 < 0) {
            this.matchStat = -1;
            return 0;
        } else {
            while (charAt != ',' && charAt != '}') {
                if (JSONLexerBase.isWhitespace(charAt)) {
                    char charAt3 = charAt(i4);
                    i4++;
                    charAt = charAt3;
                } else {
                    this.matchStat = -1;
                    return 0;
                }
            }
            int i8 = i4 - 1;
            this.bp = i8;
            if (charAt == ',') {
                int i9 = i8 + 1;
                this.bp = i9;
                this.ch = charAt(i9);
                this.matchStat = 3;
                this.token = 16;
                return z3 ? -i7 : i7;
            }
            if (charAt == '}') {
                int i10 = i8 + 1;
                this.bp = i10;
                char charAt4 = charAt(i10);
                while (true) {
                    if (charAt4 == ',') {
                        this.token = 16;
                        int i11 = this.bp + 1;
                        this.bp = i11;
                        this.ch = charAt(i11);
                        break;
                    } else if (charAt4 == ']') {
                        this.token = 15;
                        int i12 = this.bp + 1;
                        this.bp = i12;
                        this.ch = charAt(i12);
                        break;
                    } else if (charAt4 == '}') {
                        this.token = 13;
                        int i13 = this.bp + 1;
                        this.bp = i13;
                        this.ch = charAt(i13);
                        break;
                    } else if (charAt4 == 26) {
                        this.token = 20;
                        break;
                    } else if (JSONLexerBase.isWhitespace(charAt4)) {
                        int i14 = this.bp + 1;
                        this.bp = i14;
                        charAt4 = charAt(i14);
                    } else {
                        this.bp = i5;
                        this.ch = c4;
                        this.matchStat = -1;
                        return 0;
                    }
                }
                this.matchStat = 4;
            }
            return z3 ? -i7 : i7;
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
        int i4 = this.bp;
        char c4 = this.ch;
        if (!charArrayCompare(this.text, i4, cArr)) {
            this.matchStat = -2;
            return stringDefaultValue();
        }
        int length = this.bp + cArr.length;
        int i5 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return stringDefaultValue();
        }
        int indexOf = indexOf('\"', i5);
        if (indexOf != -1) {
            String subString = subString(i5, indexOf - i5);
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
                int i8 = this.bp;
                int length2 = indexOf - ((cArr.length + i8) + 1);
                subString = JSONLexerBase.readString(sub_chars(i8 + cArr.length + 1, length2), length2);
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
            int i9 = indexOf + 1;
            this.bp = i9;
            this.ch = charAt;
            if (charAt == ',') {
                int i10 = i9 + 1;
                this.bp = i10;
                this.ch = charAt(i10);
                this.matchStat = 3;
                return subString;
            }
            int i11 = i9 + 1;
            this.bp = i11;
            char charAt2 = charAt(i11);
            if (charAt2 == ',') {
                this.token = 16;
                int i12 = this.bp + 1;
                this.bp = i12;
                this.ch = charAt(i12);
            } else if (charAt2 == ']') {
                this.token = 15;
                int i13 = this.bp + 1;
                this.bp = i13;
                this.ch = charAt(i13);
            } else if (charAt2 == '}') {
                this.token = 13;
                int i14 = this.bp + 1;
                this.bp = i14;
                this.ch = charAt(i14);
            } else if (charAt2 == 26) {
                this.token = 20;
            } else {
                this.bp = i4;
                this.ch = c4;
                this.matchStat = -1;
                return stringDefaultValue();
            }
            this.matchStat = 4;
            return subString;
        }
        throw new JSONException("unclosed str");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00cc, code lost:
        if (r1 != ']') goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d2, code lost:
        if (r3.size() != 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d4, code lost:
        r1 = r5 + 1;
        r2 = charAt(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00db, code lost:
        r17.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00dd, code lost:
        return null;
     */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] r18, java.lang.Class<?> r19) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanFieldStringArray(char[], java.lang.Class):java.util.Collection");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = this.bp + cArr.length;
        int i4 = length + 1;
        if (charAt(length) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j4 = -2128831035;
        while (true) {
            int i5 = i4 + 1;
            char charAt = charAt(i4);
            if (charAt == '\"') {
                this.bp = i5;
                char charAt2 = charAt(i5);
                this.ch = charAt2;
                while (charAt2 != ',') {
                    if (charAt2 == '}') {
                        next();
                        skipWhitespace();
                        char current = getCurrent();
                        if (current == ',') {
                            this.token = 16;
                            int i6 = this.bp + 1;
                            this.bp = i6;
                            this.ch = charAt(i6);
                        } else if (current == ']') {
                            this.token = 15;
                            int i7 = this.bp + 1;
                            this.bp = i7;
                            this.ch = charAt(i7);
                        } else if (current == '}') {
                            this.token = 13;
                            int i8 = this.bp + 1;
                            this.bp = i8;
                            this.ch = charAt(i8);
                        } else if (current == 26) {
                            this.token = 20;
                        } else {
                            this.matchStat = -1;
                            return 0L;
                        }
                        this.matchStat = 4;
                        return j4;
                    } else if (JSONLexerBase.isWhitespace(charAt2)) {
                        int i9 = this.bp + 1;
                        this.bp = i9;
                        charAt2 = charAt(i9);
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                }
                int i10 = this.bp + 1;
                this.bp = i10;
                this.ch = charAt(i10);
                this.matchStat = 3;
                return j4;
            } else if (i5 > this.len) {
                this.matchStat = -1;
                return 0L;
            } else {
                j4 = (j4 ^ charAt) * 16777619;
                i4 = i5;
            }
        }
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final int scanInt(char c4) {
        int i4;
        char charAt;
        this.matchStat = 0;
        int i5 = this.bp;
        int i6 = i5 + 1;
        char charAt2 = charAt(i5);
        boolean z3 = charAt2 == '-';
        if (z3) {
            int i7 = i6 + 1;
            char charAt3 = charAt(i6);
            i6 = i7;
            charAt2 = charAt3;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i8 = charAt2 - '0';
        while (true) {
            i4 = i6 + 1;
            charAt = charAt(i6);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i8 = (i8 * 10) + (charAt - '0');
            i6 = i4;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        } else if (i8 < 0) {
            this.matchStat = -1;
            return 0;
        } else {
            while (charAt != c4) {
                if (JSONLexerBase.isWhitespace(charAt)) {
                    charAt = charAt(i4);
                    i4++;
                } else {
                    this.matchStat = -1;
                    return z3 ? -i8 : i8;
                }
            }
            this.bp = i4;
            this.ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return z3 ? -i8 : i8;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c4) {
        int i4;
        char charAt;
        this.matchStat = 0;
        int i5 = this.bp;
        int i6 = i5 + 1;
        char charAt2 = charAt(i5);
        boolean z3 = charAt2 == '-';
        if (z3) {
            int i7 = i6 + 1;
            char charAt3 = charAt(i6);
            i6 = i7;
            charAt2 = charAt3;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j4 = charAt2 - '0';
        while (true) {
            i4 = i6 + 1;
            charAt = charAt(i6);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j4 = (j4 * 10) + (charAt - '0');
            i6 = i4;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        } else if (j4 < 0) {
            this.matchStat = -1;
            return 0L;
        } else {
            while (charAt != c4) {
                if (JSONLexerBase.isWhitespace(charAt)) {
                    charAt = charAt(i4);
                    i4++;
                } else {
                    this.matchStat = -1;
                    return j4;
                }
            }
            this.bp = i4;
            this.ch = charAt(i4);
            this.matchStat = 3;
            this.token = 16;
            return z3 ? -j4 : j4;
        }
    }

    protected void setTime(char c4, char c5, char c6, char c7, char c8, char c9) {
        this.calendar.set(11, ((c4 - '0') * 10) + (c5 - '0'));
        this.calendar.set(12, ((c6 - '0') * 10) + (c7 - '0'));
        this.calendar.set(13, ((c8 - '0') * 10) + (c9 - '0'));
    }

    protected void setTimeZone(char c4, char c5, char c6) {
        int i4 = (((c5 - '0') * 10) + (c6 - '0')) * 3600 * 1000;
        if (c4 == '-') {
            i4 = -i4;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i4) {
            String[] availableIDs = TimeZone.getAvailableIDs(i4);
            if (availableIDs.length > 0) {
                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        if (!this.hasSpecial) {
            return subString(this.np + 1, this.sp);
        }
        return new String(this.sbuf, 0, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i4, int i5) {
        if (ASMUtils.IS_ANDROID) {
            char[] cArr = this.sbuf;
            if (i5 < cArr.length) {
                this.text.getChars(i4, i4 + i5, cArr, 0);
                return new String(this.sbuf, 0, i5);
            }
            char[] cArr2 = new char[i5];
            this.text.getChars(i4, i5 + i4, cArr2, 0);
            return new String(cArr2);
        }
        return this.text.substring(i4, i5 + i4);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i4, int i5) {
        if (ASMUtils.IS_ANDROID) {
            char[] cArr = this.sbuf;
            if (i5 < cArr.length) {
                this.text.getChars(i4, i5 + i4, cArr, 0);
                return this.sbuf;
            }
        }
        char[] cArr2 = new char[i5];
        this.text.getChars(i4, i5 + i4, cArr2, 0);
        return cArr2;
    }

    public JSONScanner(String str, int i4) {
        super(i4);
        this.text = str;
        this.len = str.length();
        this.bp = -1;
        next();
        if (this.ch == '\ufeff') {
            next();
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z3) {
        int i4;
        int i5;
        int i6;
        int i7;
        char c4;
        int i8;
        char charAt;
        int i9;
        char charAt2;
        int i10;
        int i11;
        char charAt3;
        char charAt4;
        int i12 = this.len;
        int i13 = this.bp;
        int i14 = i12 - i13;
        if (!z3 && i14 > 13) {
            char charAt5 = charAt(i13);
            char charAt6 = charAt(this.bp + 1);
            char charAt7 = charAt(this.bp + 2);
            char charAt8 = charAt(this.bp + 3);
            char charAt9 = charAt(this.bp + 4);
            char charAt10 = charAt(this.bp + 5);
            char charAt11 = charAt((this.bp + i14) - 1);
            char charAt12 = charAt((this.bp + i14) - 2);
            if (charAt5 == '/' && charAt6 == 'D' && charAt7 == 'a' && charAt8 == 't' && charAt9 == 'e' && charAt10 == '(' && charAt11 == '/' && charAt12 == ')') {
                int i15 = -1;
                for (int i16 = 6; i16 < i14; i16++) {
                    char charAt13 = charAt(this.bp + i16);
                    if (charAt13 != '+') {
                        if (charAt13 < '0' || charAt13 > '9') {
                            break;
                        }
                    } else {
                        i15 = i16;
                    }
                }
                if (i15 == -1) {
                    return false;
                }
                int i17 = this.bp + 6;
                long parseLong = Long.parseLong(subString(i17, i15 - i17));
                Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
                this.calendar = calendar;
                calendar.setTimeInMillis(parseLong);
                this.token = 5;
                return true;
            }
        }
        if (i14 == 8 || i14 == 14 || (i14 == 17 && charAt(this.bp + 6) != '-')) {
            int i18 = 0;
            if (z3) {
                return false;
            }
            char charAt14 = charAt(this.bp);
            char charAt15 = charAt(this.bp + 1);
            char charAt16 = charAt(this.bp + 2);
            char charAt17 = charAt(this.bp + 3);
            char charAt18 = charAt(this.bp + 4);
            char charAt19 = charAt(this.bp + 5);
            char charAt20 = charAt(this.bp + 6);
            char charAt21 = charAt(this.bp + 7);
            if (checkDate(charAt14, charAt15, charAt16, charAt17, charAt18, charAt19, charAt20, charAt21)) {
                setCalendar(charAt14, charAt15, charAt16, charAt17, charAt18, charAt19, charAt20, charAt21);
                if (i14 != 8) {
                    char charAt22 = charAt(this.bp + 8);
                    char charAt23 = charAt(this.bp + 9);
                    char charAt24 = charAt(this.bp + 10);
                    char charAt25 = charAt(this.bp + 11);
                    char charAt26 = charAt(this.bp + 12);
                    char charAt27 = charAt(this.bp + 13);
                    if (!checkTime(charAt22, charAt23, charAt24, charAt25, charAt26, charAt27)) {
                        return false;
                    }
                    if (i14 == 17) {
                        char charAt28 = charAt(this.bp + 14);
                        char charAt29 = charAt(this.bp + 15);
                        char charAt30 = charAt(this.bp + 16);
                        if (charAt28 < '0' || charAt28 > '9' || charAt29 < '0' || charAt29 > '9' || charAt30 < '0' || charAt30 > '9') {
                            return false;
                        }
                        i7 = ((charAt28 - '0') * 100) + ((charAt29 - '0') * 10) + (charAt30 - '0');
                    } else {
                        i7 = 0;
                    }
                    i4 = ((charAt24 - '0') * 10) + (charAt25 - '0');
                    i5 = ((charAt26 - '0') * 10) + (charAt27 - '0');
                    i18 = i7;
                    i6 = ((charAt22 - '0') * 10) + (charAt23 - '0');
                } else {
                    i4 = 0;
                    i5 = 0;
                    i6 = 0;
                }
                this.calendar.set(11, i6);
                this.calendar.set(12, i4);
                this.calendar.set(13, i5);
                this.calendar.set(14, i18);
                this.token = 5;
                return true;
            }
            return false;
        } else if (i14 < 9) {
            return false;
        } else {
            char charAt31 = charAt(this.bp);
            char charAt32 = charAt(this.bp + 1);
            char charAt33 = charAt(this.bp + 2);
            char charAt34 = charAt(this.bp + 3);
            char charAt35 = charAt(this.bp + 4);
            char charAt36 = charAt(this.bp + 5);
            char charAt37 = charAt(this.bp + 6);
            char charAt38 = charAt(this.bp + 7);
            char charAt39 = charAt(this.bp + 8);
            char charAt40 = charAt(this.bp + 9);
            if ((charAt35 == '-' && charAt38 == '-') || (charAt35 == '/' && charAt38 == '/')) {
                charAt38 = charAt40;
                c4 = charAt36;
                charAt36 = charAt37;
                i8 = 10;
            } else if (charAt35 == '-' && charAt37 == '-') {
                if (charAt39 == ' ') {
                    c4 = '0';
                    i8 = 8;
                    charAt39 = '0';
                } else {
                    c4 = '0';
                    i8 = 9;
                    charAt39 = charAt38;
                    charAt38 = charAt39;
                }
            } else if ((charAt33 == '.' && charAt36 == '.') || (charAt33 == '-' && charAt36 == '-')) {
                charAt36 = charAt35;
                charAt33 = charAt39;
                charAt39 = charAt31;
                charAt31 = charAt37;
                i8 = 10;
                charAt38 = charAt32;
                charAt32 = charAt38;
                charAt34 = charAt40;
                c4 = charAt34;
            } else if (charAt35 != '\u5e74' && charAt35 != '\ub144') {
                return false;
            } else {
                if (charAt38 == '\u6708' || charAt38 == '\uc6d4') {
                    if (charAt40 == '\u65e5' || charAt40 == '\uc77c') {
                        c4 = charAt36;
                        charAt36 = charAt37;
                        charAt38 = charAt39;
                    } else if (charAt(this.bp + 10) != '\u65e5' && charAt(this.bp + 10) != '\uc77c') {
                        return false;
                    } else {
                        charAt38 = charAt40;
                        c4 = charAt36;
                        charAt36 = charAt37;
                        i8 = 11;
                    }
                } else if (charAt37 != '\u6708' && charAt37 != '\uc6d4') {
                    return false;
                } else {
                    if (charAt39 == '\u65e5' || charAt39 == '\uc77c') {
                        c4 = '0';
                    } else if (charAt40 != '\u65e5' && charAt40 != '\uc77c') {
                        return false;
                    } else {
                        c4 = '0';
                        i8 = 10;
                        charAt39 = charAt38;
                        charAt38 = charAt39;
                    }
                }
                i8 = 10;
                charAt39 = '0';
            }
            if (checkDate(charAt31, charAt32, charAt33, charAt34, c4, charAt36, charAt39, charAt38)) {
                setCalendar(charAt31, charAt32, charAt33, charAt34, c4, charAt36, charAt39, charAt38);
                char charAt41 = charAt(this.bp + i8);
                if (charAt41 != 'T' && (charAt41 != ' ' || z3)) {
                    if (charAt41 != '\"' && charAt41 != 26 && charAt41 != '\u65e5' && charAt41 != '\uc77c') {
                        if ((charAt41 == '+' || charAt41 == '-') && this.len == i8 + 6 && charAt(this.bp + i8 + 3) == ':' && charAt(this.bp + i8 + 4) == '0' && charAt(this.bp + i8 + 5) == '0') {
                            setTime('0', '0', '0', '0', '0', '0');
                            this.calendar.set(14, 0);
                            setTimeZone(charAt41, charAt(this.bp + i8 + 1), charAt(this.bp + i8 + 2));
                            return true;
                        }
                        return false;
                    }
                    this.calendar.set(11, 0);
                    this.calendar.set(12, 0);
                    this.calendar.set(13, 0);
                    this.calendar.set(14, 0);
                    int i19 = this.bp + i8;
                    this.bp = i19;
                    this.ch = charAt(i19);
                    this.token = 5;
                    return true;
                }
                int i20 = i8 + 9;
                if (i14 >= i20 && charAt(this.bp + i8 + 3) == ':' && charAt(this.bp + i8 + 6) == ':') {
                    char charAt42 = charAt(this.bp + i8 + 1);
                    char charAt43 = charAt(this.bp + i8 + 2);
                    char charAt44 = charAt(this.bp + i8 + 4);
                    char charAt45 = charAt(this.bp + i8 + 5);
                    char charAt46 = charAt(this.bp + i8 + 7);
                    char charAt47 = charAt(this.bp + i8 + 8);
                    if (checkTime(charAt42, charAt43, charAt44, charAt45, charAt46, charAt47)) {
                        setTime(charAt42, charAt43, charAt44, charAt45, charAt46, charAt47);
                        char charAt48 = charAt(this.bp + i8 + 9);
                        if (charAt48 != '.') {
                            this.calendar.set(14, 0);
                            int i21 = this.bp + i20;
                            this.bp = i21;
                            this.ch = charAt(i21);
                            this.token = 5;
                            if (charAt48 == 'Z' && this.calendar.getTimeZone().getRawOffset() != 0) {
                                String[] availableIDs = TimeZone.getAvailableIDs(0);
                                if (availableIDs.length > 0) {
                                    this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                                }
                            }
                            return true;
                        }
                        int i22 = i8 + 11;
                        if (i14 >= i22 && (charAt = charAt(this.bp + i8 + 10)) >= '0' && charAt <= '9') {
                            int i23 = charAt - '0';
                            if (i14 <= i22 || (charAt4 = charAt(this.bp + i8 + 11)) < '0' || charAt4 > '9') {
                                i9 = 1;
                            } else {
                                i23 = (i23 * 10) + (charAt4 - '0');
                                i9 = 2;
                            }
                            if (i9 == 2 && (charAt3 = charAt(this.bp + i8 + 12)) >= '0' && charAt3 <= '9') {
                                i23 = (i23 * 10) + (charAt3 - '0');
                                i9 = 3;
                            }
                            this.calendar.set(14, i23);
                            char charAt49 = charAt(this.bp + i8 + 10 + i9);
                            if (charAt49 == '+' || charAt49 == '-') {
                                char charAt50 = charAt(this.bp + i8 + 10 + i9 + 1);
                                if (charAt50 >= '0' && charAt50 <= '1' && (charAt2 = charAt(this.bp + i8 + 10 + i9 + 2)) >= '0' && charAt2 <= '9') {
                                    char charAt51 = charAt(this.bp + i8 + 10 + i9 + 3);
                                    if (charAt51 == ':') {
                                        if (charAt(this.bp + i8 + 10 + i9 + 4) != '0' || charAt(this.bp + i8 + 10 + i9 + 5) != '0') {
                                            return false;
                                        }
                                        i10 = 6;
                                    } else if (charAt51 != '0') {
                                        i10 = 3;
                                    } else if (charAt(this.bp + i8 + 10 + i9 + 4) != '0') {
                                        return false;
                                    } else {
                                        i10 = 5;
                                    }
                                    setTimeZone(charAt49, charAt50, charAt2);
                                    i11 = i10;
                                }
                            } else if (charAt49 == 'Z') {
                                if (this.calendar.getTimeZone().getRawOffset() != 0) {
                                    String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                                    if (availableIDs2.length > 0) {
                                        this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                                    }
                                }
                                i11 = 1;
                            } else {
                                i11 = 0;
                            }
                            int i24 = i8 + 10 + i9 + i11;
                            char charAt52 = charAt(this.bp + i24);
                            if (charAt52 == 26 || charAt52 == '\"') {
                                int i25 = this.bp + i24;
                                this.bp = i25;
                                this.ch = charAt(i25);
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
        return charArrayCompare(this.text, this.bp, cArr);
    }

    public JSONScanner(char[] cArr, int i4) {
        this(cArr, i4, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i4, int i5) {
        this(new String(cArr, 0, i4), i5);
    }
}
