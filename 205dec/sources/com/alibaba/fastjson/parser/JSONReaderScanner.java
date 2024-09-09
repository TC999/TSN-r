package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class JSONReaderScanner extends JSONLexerBase {
    private static final ThreadLocal<char[]> BUF_LOCAL = new ThreadLocal<>();
    private char[] buf;
    private int bufLength;
    private Reader reader;

    public JSONReaderScanner(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int i4, int i5, int i6, SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.buf, i4, i5, i6);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void arrayCopy(int i4, char[] cArr, int i5, int i6) {
        System.arraycopy(this.buf, i4, cArr, i5, i6);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token != 26) {
            return IOUtils.decodeBase64(this.buf, this.np + 1, this.sp);
        }
        throw new JSONException("TODO");
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        for (int i4 = 0; i4 < cArr.length; i4++) {
            if (charAt(this.bp + i4) != cArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i4) {
        int i5 = this.bufLength;
        if (i4 >= i5) {
            if (i5 == -1) {
                if (i4 < this.sp) {
                    return this.buf[i4];
                }
                return (char) 26;
            }
            int i6 = this.bp;
            if (i6 == 0) {
                char[] cArr = this.buf;
                int length = (cArr.length * 3) / 2;
                char[] cArr2 = new char[length];
                System.arraycopy(cArr, i6, cArr2, 0, i5);
                int i7 = this.bufLength;
                try {
                    this.bufLength += this.reader.read(cArr2, i7, length - i7);
                    this.buf = cArr2;
                } catch (IOException e4) {
                    throw new JSONException(e4.getMessage(), e4);
                }
            } else {
                int i8 = i5 - i6;
                if (i8 > 0) {
                    char[] cArr3 = this.buf;
                    System.arraycopy(cArr3, i6, cArr3, 0, i8);
                }
                try {
                    Reader reader = this.reader;
                    char[] cArr4 = this.buf;
                    int read = reader.read(cArr4, i8, cArr4.length - i8);
                    this.bufLength = read;
                    if (read == 0) {
                        throw new JSONException("illegal state, textLength is zero");
                    }
                    if (read == -1) {
                        return (char) 26;
                    }
                    this.bufLength = read + i8;
                    int i9 = this.bp;
                    i4 -= i9;
                    this.np -= i9;
                    this.bp = 0;
                } catch (IOException e5) {
                    throw new JSONException(e5.getMessage(), e5);
                }
            }
        }
        return this.buf[i4];
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        char[] cArr = this.buf;
        if (cArr.length <= 65536) {
            BUF_LOCAL.set(cArr);
        }
        this.buf = null;
        IOUtils.close(this.reader);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void copyTo(int i4, int i5, char[] cArr) {
        System.arraycopy(this.buf, i4, cArr, 0, i5);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        int i4 = this.np;
        if (i4 == -1) {
            i4 = 0;
        }
        char charAt = charAt((this.sp + i4) - 1);
        int i5 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i5--;
        }
        return new BigDecimal(this.buf, i4, i5);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c4, int i4) {
        int i5 = i4 - this.bp;
        while (true) {
            char charAt = charAt(this.bp + i5);
            if (c4 == charAt) {
                return i5 + this.bp;
            }
            if (charAt == 26) {
                return -1;
            }
            i5++;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final boolean isBlankInput() {
        int i4 = 0;
        while (true) {
            char c4 = this.buf[i4];
            if (c4 == 26) {
                this.token = 20;
                return true;
            } else if (!JSONLexerBase.isWhitespace(c4)) {
                return false;
            } else {
                i4++;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        if (this.bufLength != -1) {
            int i4 = this.bp;
            char[] cArr = this.buf;
            if (i4 != cArr.length) {
                return this.ch == 26 && i4 + 1 == cArr.length;
            }
            return true;
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i4 = this.bp + 1;
        this.bp = i4;
        int i5 = this.bufLength;
        if (i4 >= i5) {
            if (i5 == -1) {
                return (char) 26;
            }
            int i6 = this.sp;
            if (i6 > 0) {
                int i7 = i5 - i6;
                if (this.ch == '\"' && i7 > 0) {
                    i7--;
                }
                char[] cArr = this.buf;
                System.arraycopy(cArr, i7, cArr, 0, i6);
            }
            this.np = -1;
            int i8 = this.sp;
            this.bp = i8;
            try {
                char[] cArr2 = this.buf;
                int length = cArr2.length - i8;
                if (length == 0) {
                    char[] cArr3 = new char[cArr2.length * 2];
                    System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
                    this.buf = cArr3;
                    length = cArr3.length - i8;
                }
                int read = this.reader.read(this.buf, this.bp, length);
                this.bufLength = read;
                if (read == 0) {
                    throw new JSONException("illegal stat, textLength is zero");
                }
                if (read == -1) {
                    this.ch = (char) 26;
                    return (char) 26;
                }
                this.bufLength = read + this.bp;
                i4 = i8;
            } catch (IOException e4) {
                throw new JSONException(e4.getMessage(), e4);
            }
        }
        char c4 = this.buf[i4];
        this.ch = c4;
        return c4;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        int i4 = this.np;
        if (i4 == -1) {
            i4 = 0;
        }
        char charAt = charAt((this.sp + i4) - 1);
        int i5 = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i5--;
        }
        return new String(this.buf, i4, i5);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        if (!this.hasSpecial) {
            int i4 = this.np + 1;
            if (i4 >= 0) {
                char[] cArr = this.buf;
                int length = cArr.length;
                int i5 = this.sp;
                if (i4 <= length - i5) {
                    return new String(cArr, i4, i5);
                }
                throw new IllegalStateException();
            }
            throw new IllegalStateException();
        }
        return new String(this.sbuf, 0, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int i4, int i5) {
        if (i5 >= 0) {
            return new String(this.buf, i4, i5);
        }
        throw new StringIndexOutOfBoundsException(i5);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i4, int i5) {
        if (i5 >= 0) {
            if (i4 == 0) {
                return this.buf;
            }
            char[] cArr = new char[i5];
            System.arraycopy(this.buf, i4, cArr, 0, i5);
            return cArr;
        }
        throw new StringIndexOutOfBoundsException(i5);
    }

    public JSONReaderScanner(String str, int i4) {
        this(new StringReader(str), i4);
    }

    public JSONReaderScanner(char[] cArr, int i4) {
        this(cArr, i4, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(Reader reader) {
        this(reader, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(Reader reader, int i4) {
        super(i4);
        this.reader = reader;
        ThreadLocal<char[]> threadLocal = BUF_LOCAL;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[16384];
        }
        try {
            this.bufLength = reader.read(this.buf);
            this.bp = -1;
            next();
            if (this.ch == '\ufeff') {
                next();
            }
        } catch (IOException e4) {
            throw new JSONException(e4.getMessage(), e4);
        }
    }

    public JSONReaderScanner(char[] cArr, int i4, int i5) {
        this(new CharArrayReader(cArr, 0, i4), i5);
    }
}
