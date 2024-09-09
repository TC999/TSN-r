package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class JsonReader implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final Reader in;
    private int[] pathIndices;
    private String[] pathNames;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int[] stack;
    private boolean lenient = false;
    private final char[] buffer = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    int peeked = 0;
    private int stackSize = 0 + 1;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() { // from class: com.google.gson.stream.JsonReader.1
            @Override // com.google.gson.internal.JsonReaderInternalAccess
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).promoteNameToValue();
                    return;
                }
                int i4 = jsonReader.peeked;
                if (i4 == 0) {
                    i4 = jsonReader.doPeek();
                }
                if (i4 == 13) {
                    jsonReader.peeked = 9;
                } else if (i4 == 12) {
                    jsonReader.peeked = 8;
                } else if (i4 == 14) {
                    jsonReader.peeked = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + jsonReader.locationString());
                }
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        if (reader != null) {
            this.in = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int i4 = this.pos - 1;
        this.pos = i4;
        char[] cArr = NON_EXECUTE_PREFIX;
        if (i4 + cArr.length > this.limit && !fillBuffer(cArr.length)) {
            return;
        }
        int i5 = 0;
        while (true) {
            char[] cArr2 = NON_EXECUTE_PREFIX;
            if (i5 < cArr2.length) {
                if (this.buffer[this.pos + i5] != cArr2[i5]) {
                    return;
                }
                i5++;
            } else {
                this.pos += cArr2.length;
                return;
            }
        }
    }

    private boolean fillBuffer(int i4) throws IOException {
        int i5;
        int i6;
        char[] cArr = this.buffer;
        int i7 = this.lineStart;
        int i8 = this.pos;
        this.lineStart = i7 - i8;
        int i9 = this.limit;
        if (i9 != i8) {
            int i10 = i9 - i8;
            this.limit = i10;
            System.arraycopy(cArr, i8, cArr, 0, i10);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i11 = this.limit;
            int read = reader.read(cArr, i11, cArr.length - i11);
            if (read == -1) {
                return false;
            }
            i5 = this.limit + read;
            this.limit = i5;
            if (this.lineNumber == 0 && (i6 = this.lineStart) == 0 && i5 > 0 && cArr[0] == '\ufeff') {
                this.pos++;
                this.lineStart = i6 + 1;
                i4++;
                continue;
            }
        } while (i5 < i4);
        return true;
    }

    private boolean isLiteral(char c4) throws IOException {
        if (c4 == '\t' || c4 == '\n' || c4 == '\f' || c4 == '\r' || c4 == ' ') {
            return false;
        }
        if (c4 != '#') {
            if (c4 == ',') {
                return false;
            }
            if (c4 != '/' && c4 != '=') {
                if (c4 == '{' || c4 == '}' || c4 == ':') {
                    return false;
                }
                if (c4 != ';') {
                    switch (c4) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    private int nextNonWhitespace(boolean z3) throws IOException {
        char[] cArr = this.buffer;
        int i4 = this.pos;
        int i5 = this.limit;
        while (true) {
            if (i4 == i5) {
                this.pos = i4;
                if (!fillBuffer(1)) {
                    if (z3) {
                        throw new EOFException("End of input" + locationString());
                    }
                    return -1;
                }
                i4 = this.pos;
                i5 = this.limit;
            }
            int i6 = i4 + 1;
            char c4 = cArr[i4];
            if (c4 == '\n') {
                this.lineNumber++;
                this.lineStart = i6;
            } else if (c4 != ' ' && c4 != '\r' && c4 != '\t') {
                if (c4 == '/') {
                    this.pos = i6;
                    if (i6 == i5) {
                        this.pos = i6 - 1;
                        boolean fillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!fillBuffer) {
                            return c4;
                        }
                    }
                    checkLenient();
                    int i7 = this.pos;
                    char c5 = cArr[i7];
                    if (c5 == '*') {
                        this.pos = i7 + 1;
                        if (skipTo("*/")) {
                            i4 = this.pos + 2;
                            i5 = this.limit;
                        } else {
                            throw syntaxError("Unterminated comment");
                        }
                    } else if (c5 != '/') {
                        return c4;
                    } else {
                        this.pos = i7 + 1;
                        skipToEndOfLine();
                        i4 = this.pos;
                        i5 = this.limit;
                    }
                } else if (c4 == '#') {
                    this.pos = i6;
                    checkLenient();
                    skipToEndOfLine();
                    i4 = this.pos;
                    i5 = this.limit;
                } else {
                    this.pos = i6;
                    return c4;
                }
            }
            i4 = i6;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (r1 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        r1.append(r0, r3, r2 - r3);
        r9.pos = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String nextQuotedValue(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.buffer
            r1 = 0
        L3:
            int r2 = r9.pos
            int r3 = r9.limit
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L5c
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L28
            r9.pos = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L20
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L20:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L28:
            r8 = 92
            if (r2 != r8) goto L4f
            r9.pos = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L40
            int r1 = r7 + 1
            int r1 = r1 * 2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r2.<init>(r1)
            r1 = r2
        L40:
            r1.append(r0, r3, r7)
            char r2 = r9.readEscapeCharacter()
            r1.append(r2)
            int r2 = r9.pos
            int r3 = r9.limit
            goto L7
        L4f:
            r5 = 10
            if (r2 != r5) goto L5a
            int r2 = r9.lineNumber
            int r2 = r2 + r6
            r9.lineNumber = r2
            r9.lineStart = r7
        L5a:
            r2 = r7
            goto L9
        L5c:
            if (r1 != 0) goto L6c
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L6c:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.pos = r2
            boolean r2 = r9.fillBuffer(r6)
            if (r2 == 0) goto L7a
            goto L3
        L7a:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.syntaxError(r10)
            goto L82
        L81:
            throw r10
        L82:
            goto L81
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextQuotedValue(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        checkLenient();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String nextUnquotedValue() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r6.pos
            int r4 = r3 + r2
            int r5 = r6.limit
            if (r4 >= r5) goto L4e
            char[] r4 = r6.buffer
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.checkLenient()
            goto L5c
        L4e:
            char[] r3 = r6.buffer
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.fillBuffer(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r0 = r2
            goto L7e
        L5e:
            if (r1 != 0) goto L6b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L6b:
            char[] r3 = r6.buffer
            int r4 = r6.pos
            r1.append(r3, r4, r2)
            int r3 = r6.pos
            int r3 = r3 + r2
            r6.pos = r3
            r2 = 1
            boolean r2 = r6.fillBuffer(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r1 != 0) goto L8a
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r1.<init>(r2, r3, r0)
            goto L95
        L8a:
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L95:
            int r2 = r6.pos
            int r2 = r2 + r0
            r6.pos = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextUnquotedValue():java.lang.String");
    }

    private int peekKeyword() throws IOException {
        int i4;
        String str;
        String str2;
        char c4 = this.buffer[this.pos];
        if (c4 == 't' || c4 == 'T') {
            i4 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c4 == 'f' || c4 == 'F') {
            i4 = 6;
            str = "false";
            str2 = "FALSE";
        } else if (c4 != 'n' && c4 != 'N') {
            return 0;
        } else {
            i4 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i5 = 1; i5 < length; i5++) {
            if (this.pos + i5 >= this.limit && !fillBuffer(i5 + 1)) {
                return 0;
            }
            char c5 = this.buffer[this.pos + i5];
            if (c5 != str.charAt(i5) && c5 != str2.charAt(i5)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.peeked = i4;
        return i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
        if (isLiteral(r14) != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0099, code lost:
        if (r9 != 2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009b, code lost:
        if (r10 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a1, code lost:
        if (r11 != Long.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a3, code lost:
        if (r13 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a9, code lost:
        if (r11 != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ab, code lost:
        if (r13 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ad, code lost:
        if (r13 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b0, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b1, code lost:
        r18.peekedLong = r11;
        r18.pos += r8;
        r18.peeked = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00bc, code lost:
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00bd, code lost:
        if (r9 == 2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c0, code lost:
        if (r9 == 4) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c3, code lost:
        if (r9 != 7) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c6, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00c8, code lost:
        r18.peekedNumberLength = r8;
        r18.peeked = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00ce, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00cf, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int peekNumber() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.peekNumber():int");
    }

    private void push(int i4) {
        int i5 = this.stackSize;
        int[] iArr = this.stack;
        if (i5 == iArr.length) {
            int[] iArr2 = new int[i5 * 2];
            int[] iArr3 = new int[i5 * 2];
            String[] strArr = new String[i5 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            System.arraycopy(this.pathIndices, 0, iArr3, 0, this.stackSize);
            System.arraycopy(this.pathNames, 0, strArr, 0, this.stackSize);
            this.stack = iArr2;
            this.pathIndices = iArr3;
            this.pathNames = strArr;
        }
        int[] iArr4 = this.stack;
        int i6 = this.stackSize;
        this.stackSize = i6 + 1;
        iArr4[i6] = i4;
    }

    private char readEscapeCharacter() throws IOException {
        int i4;
        int i5;
        if (this.pos == this.limit && !fillBuffer(1)) {
            throw syntaxError("Unterminated escape sequence");
        }
        char[] cArr = this.buffer;
        int i6 = this.pos;
        int i7 = i6 + 1;
        this.pos = i7;
        char c4 = cArr[i6];
        if (c4 == '\n') {
            this.lineNumber++;
            this.lineStart = i7;
        } else if (c4 != '\"' && c4 != '\'' && c4 != '/' && c4 != '\\') {
            if (c4 != 'b') {
                if (c4 != 'f') {
                    if (c4 != 'n') {
                        if (c4 != 'r') {
                            if (c4 != 't') {
                                if (c4 == 'u') {
                                    if (i7 + 4 > this.limit && !fillBuffer(4)) {
                                        throw syntaxError("Unterminated escape sequence");
                                    }
                                    char c5 = 0;
                                    int i8 = this.pos;
                                    int i9 = i8 + 4;
                                    while (i8 < i9) {
                                        char c6 = this.buffer[i8];
                                        char c7 = (char) (c5 << 4);
                                        if (c6 < '0' || c6 > '9') {
                                            if (c6 >= 'a' && c6 <= 'f') {
                                                i4 = c6 - 'a';
                                            } else if (c6 < 'A' || c6 > 'F') {
                                                throw new NumberFormatException("\\u" + new String(this.buffer, this.pos, 4));
                                            } else {
                                                i4 = c6 - 'A';
                                            }
                                            i5 = i4 + 10;
                                        } else {
                                            i5 = c6 - '0';
                                        }
                                        c5 = (char) (c7 + i5);
                                        i8++;
                                    }
                                    this.pos += 4;
                                    return c5;
                                }
                                throw syntaxError("Invalid escape sequence");
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\n';
                }
                return '\f';
            }
            return '\b';
        }
        return c4;
    }

    private void skipQuotedValue(char c4) throws IOException {
        char[] cArr = this.buffer;
        do {
            int i4 = this.pos;
            int i5 = this.limit;
            while (i4 < i5) {
                int i6 = i4 + 1;
                char c5 = cArr[i4];
                if (c5 == c4) {
                    this.pos = i6;
                    return;
                } else if (c5 == '\\') {
                    this.pos = i6;
                    readEscapeCharacter();
                    i4 = this.pos;
                    i5 = this.limit;
                } else {
                    if (c5 == '\n') {
                        this.lineNumber++;
                        this.lineStart = i6;
                    }
                    i4 = i6;
                }
            }
            this.pos = i4;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    private boolean skipTo(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.pos + length > this.limit && !fillBuffer(length)) {
                return false;
            }
            char[] cArr = this.buffer;
            int i4 = this.pos;
            if (cArr[i4] != '\n') {
                for (int i5 = 0; i5 < length; i5++) {
                    if (this.buffer[this.pos + i5] != str.charAt(i5)) {
                        break;
                    }
                }
                return true;
            }
            this.lineNumber++;
            this.lineStart = i4 + 1;
            this.pos++;
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c4;
        do {
            if (this.pos >= this.limit && !fillBuffer(1)) {
                return;
            }
            char[] cArr = this.buffer;
            int i4 = this.pos;
            int i5 = i4 + 1;
            this.pos = i5;
            c4 = cArr[i4];
            if (c4 == '\n') {
                this.lineNumber++;
                this.lineStart = i5;
                return;
            }
        } while (c4 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        checkLenient();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void skipUnquotedValue() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.pos
            int r2 = r1 + r0
            int r3 = r4.limit
            if (r2 >= r3) goto L51
            char[] r2 = r4.buffer
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.checkLenient()
        L4b:
            int r1 = r4.pos
            int r1 = r1 + r0
            r4.pos = r1
            return
        L51:
            int r1 = r1 + r0
            r4.pos = r1
            r0 = 1
            boolean r0 = r4.fillBuffer(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.skipUnquotedValue():void");
    }

    private IOException syntaxError(String str) throws IOException {
        throw new MalformedJsonException(str + locationString());
    }

    public void beginArray() throws IOException {
        int i4 = this.peeked;
        if (i4 == 0) {
            i4 = doPeek();
        }
        if (i4 == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
    }

    public void beginObject() throws IOException {
        int i4 = this.peeked;
        if (i4 == 0) {
            i4 = doPeek();
        }
        if (i4 == 1) {
            push(3);
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    int doPeek() throws IOException {
        int nextNonWhitespace;
        int[] iArr = this.stack;
        int i4 = this.stackSize;
        int i5 = iArr[i4 - 1];
        if (i5 == 1) {
            iArr[i4 - 1] = 2;
        } else if (i5 == 2) {
            int nextNonWhitespace2 = nextNonWhitespace(true);
            if (nextNonWhitespace2 != 44) {
                if (nextNonWhitespace2 != 59) {
                    if (nextNonWhitespace2 == 93) {
                        this.peeked = 4;
                        return 4;
                    }
                    throw syntaxError("Unterminated array");
                }
                checkLenient();
            }
        } else if (i5 == 3 || i5 == 5) {
            iArr[i4 - 1] = 4;
            if (i5 == 5 && (nextNonWhitespace = nextNonWhitespace(true)) != 44) {
                if (nextNonWhitespace != 59) {
                    if (nextNonWhitespace == 125) {
                        this.peeked = 2;
                        return 2;
                    }
                    throw syntaxError("Unterminated object");
                }
                checkLenient();
            }
            int nextNonWhitespace3 = nextNonWhitespace(true);
            if (nextNonWhitespace3 == 34) {
                this.peeked = 13;
                return 13;
            } else if (nextNonWhitespace3 == 39) {
                checkLenient();
                this.peeked = 12;
                return 12;
            } else if (nextNonWhitespace3 == 125) {
                if (i5 != 5) {
                    this.peeked = 2;
                    return 2;
                }
                throw syntaxError("Expected name");
            } else {
                checkLenient();
                this.pos--;
                if (isLiteral((char) nextNonWhitespace3)) {
                    this.peeked = 14;
                    return 14;
                }
                throw syntaxError("Expected name");
            }
        } else if (i5 == 4) {
            iArr[i4 - 1] = 5;
            int nextNonWhitespace4 = nextNonWhitespace(true);
            if (nextNonWhitespace4 != 58) {
                if (nextNonWhitespace4 == 61) {
                    checkLenient();
                    if (this.pos < this.limit || fillBuffer(1)) {
                        char[] cArr = this.buffer;
                        int i6 = this.pos;
                        if (cArr[i6] == '>') {
                            this.pos = i6 + 1;
                        }
                    }
                } else {
                    throw syntaxError("Expected ':'");
                }
            }
        } else if (i5 == 6) {
            if (this.lenient) {
                consumeNonExecutePrefix();
            }
            this.stack[this.stackSize - 1] = 7;
        } else if (i5 == 7) {
            if (nextNonWhitespace(false) == -1) {
                this.peeked = 17;
                return 17;
            }
            checkLenient();
            this.pos--;
        } else if (i5 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 == 34) {
            this.peeked = 9;
            return 9;
        } else if (nextNonWhitespace5 == 39) {
            checkLenient();
            this.peeked = 8;
            return 8;
        } else {
            if (nextNonWhitespace5 != 44 && nextNonWhitespace5 != 59) {
                if (nextNonWhitespace5 == 91) {
                    this.peeked = 3;
                    return 3;
                } else if (nextNonWhitespace5 != 93) {
                    if (nextNonWhitespace5 != 123) {
                        this.pos--;
                        int peekKeyword = peekKeyword();
                        if (peekKeyword != 0) {
                            return peekKeyword;
                        }
                        int peekNumber = peekNumber();
                        if (peekNumber != 0) {
                            return peekNumber;
                        }
                        if (isLiteral(this.buffer[this.pos])) {
                            checkLenient();
                            this.peeked = 10;
                            return 10;
                        }
                        throw syntaxError("Expected value");
                    }
                    this.peeked = 1;
                    return 1;
                } else if (i5 == 1) {
                    this.peeked = 4;
                    return 4;
                }
            }
            if (i5 != 1 && i5 != 2) {
                throw syntaxError("Unexpected value");
            }
            checkLenient();
            this.pos--;
            this.peeked = 7;
            return 7;
        }
    }

    public void endArray() throws IOException {
        int i4 = this.peeked;
        if (i4 == 0) {
            i4 = doPeek();
        }
        if (i4 == 4) {
            int i5 = this.stackSize - 1;
            this.stackSize = i5;
            int[] iArr = this.pathIndices;
            int i6 = i5 - 1;
            iArr[i6] = iArr[i6] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
    }

    public void endObject() throws IOException {
        int i4 = this.peeked;
        if (i4 == 0) {
            i4 = doPeek();
        }
        if (i4 == 2) {
            int i5 = this.stackSize - 1;
            this.stackSize = i5;
            this.pathNames[i5] = null;
            int[] iArr = this.pathIndices;
            int i6 = i5 - 1;
            iArr[i6] = iArr[i6] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i4 = this.stackSize;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = this.stack[i5];
            if (i6 == 1 || i6 == 2) {
                sb.append('[');
                sb.append(this.pathIndices[i5]);
                sb.append(']');
            } else if (i6 == 3 || i6 == 4 || i6 == 5) {
                sb.append('.');
                String[] strArr = this.pathNames;
                if (strArr[i5] != null) {
                    sb.append(strArr[i5]);
                }
            }
        }
        return sb.toString();
    }

    public boolean hasNext() throws IOException {
        int i4 = this.peeked;
        if (i4 == 0) {
            i4 = doPeek();
        }
        return (i4 == 2 || i4 == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    public boolean nextBoolean() throws IOException {
        int i4 = this.peeked;
        if (i4 == 0) {
            i4 = doPeek();
        }
        if (i4 == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i5 = this.stackSize - 1;
            iArr[i5] = iArr[i5] + 1;
            return true;
        } else if (i4 == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i6 = this.stackSize - 1;
            iArr2[i6] = iArr2[i6] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
        }
    }

    public double nextDouble() throws IOException {
        int i4 = this.peeked;
        if (i4 == 0) {
            i4 = doPeek();
        }
        if (i4 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i5 = this.stackSize - 1;
            iArr[i5] = iArr[i5] + 1;
            return this.peekedLong;
        }
        if (i4 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i4 == 8 || i4 == 9) {
            this.peekedString = nextQuotedValue(i4 == 8 ? '\'' : '\"');
        } else if (i4 == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (i4 != 11) {
            throw new IllegalStateException("Expected a double but was " + peek() + locationString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr2 = this.pathIndices;
        int i6 = this.stackSize - 1;
        iArr2[i6] = iArr2[i6] + 1;
        return parseDouble;
    }

    public int nextInt() throws IOException {
        int i4 = this.peeked;
        if (i4 == 0) {
            i4 = doPeek();
        }
        if (i4 == 15) {
            long j4 = this.peekedLong;
            int i5 = (int) j4;
            if (j4 == i5) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i6 = this.stackSize - 1;
                iArr[i6] = iArr[i6] + 1;
                return i5;
            }
            throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
        }
        if (i4 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i4 != 8 && i4 != 9 && i4 != 10) {
            throw new IllegalStateException("Expected an int but was " + peek() + locationString());
        } else {
            if (i4 == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(i4 == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i7 = this.stackSize - 1;
                iArr2[i7] = iArr2[i7] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i8 = (int) parseDouble;
        if (i8 == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i9 = this.stackSize - 1;
            iArr3[i9] = iArr3[i9] + 1;
            return i8;
        }
        throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
    }

    public long nextLong() throws IOException {
        int i4 = this.peeked;
        if (i4 == 0) {
            i4 = doPeek();
        }
        if (i4 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i5 = this.stackSize - 1;
            iArr[i5] = iArr[i5] + 1;
            return this.peekedLong;
        }
        if (i4 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i4 != 8 && i4 != 9 && i4 != 10) {
            throw new IllegalStateException("Expected a long but was " + peek() + locationString());
        } else {
            if (i4 == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(i4 == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i6 = this.stackSize - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j4 = (long) parseDouble;
        if (j4 == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i7 = this.stackSize - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return j4;
        }
        throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
    }

    public String nextName() throws IOException {
        String nextQuotedValue;
        int i4 = this.peeked;
        if (i4 == 0) {
            i4 = doPeek();
        }
        if (i4 == 14) {
            nextQuotedValue = nextUnquotedValue();
        } else if (i4 == 12) {
            nextQuotedValue = nextQuotedValue('\'');
        } else if (i4 == 13) {
            nextQuotedValue = nextQuotedValue('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + peek() + locationString());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = nextQuotedValue;
        return nextQuotedValue;
    }

    public void nextNull() throws IOException {
        int i4 = this.peeked;
        if (i4 == 0) {
            i4 = doPeek();
        }
        if (i4 == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i5 = this.stackSize - 1;
            iArr[i5] = iArr[i5] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + locationString());
    }

    public String nextString() throws IOException {
        String str;
        int i4 = this.peeked;
        if (i4 == 0) {
            i4 = doPeek();
        }
        if (i4 == 10) {
            str = nextUnquotedValue();
        } else if (i4 == 8) {
            str = nextQuotedValue('\'');
        } else if (i4 == 9) {
            str = nextQuotedValue('\"');
        } else if (i4 == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (i4 == 15) {
            str = Long.toString(this.peekedLong);
        } else if (i4 == 16) {
            str = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            throw new IllegalStateException("Expected a string but was " + peek() + locationString());
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i5 = this.stackSize - 1;
        iArr[i5] = iArr[i5] + 1;
        return str;
    }

    public JsonToken peek() throws IOException {
        int i4 = this.peeked;
        if (i4 == 0) {
            i4 = doPeek();
        }
        switch (i4) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void setLenient(boolean z3) {
        this.lenient = z3;
    }

    public void skipValue() throws IOException {
        int i4 = 0;
        do {
            int i5 = this.peeked;
            if (i5 == 0) {
                i5 = doPeek();
            }
            if (i5 == 3) {
                push(1);
            } else if (i5 == 1) {
                push(3);
            } else {
                if (i5 == 4) {
                    this.stackSize--;
                } else if (i5 == 2) {
                    this.stackSize--;
                } else {
                    if (i5 == 14 || i5 == 10) {
                        skipUnquotedValue();
                    } else if (i5 == 8 || i5 == 12) {
                        skipQuotedValue('\'');
                    } else if (i5 == 9 || i5 == 13) {
                        skipQuotedValue('\"');
                    } else if (i5 == 16) {
                        this.pos += this.peekedNumberLength;
                    }
                    this.peeked = 0;
                }
                i4--;
                this.peeked = 0;
            }
            i4++;
            this.peeked = 0;
        } while (i4 != 0);
        int[] iArr = this.pathIndices;
        int i6 = this.stackSize;
        int i7 = i6 - 1;
        iArr[i7] = iArr[i7] + 1;
        this.pathNames[i6 - 1] = "null";
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }
}
