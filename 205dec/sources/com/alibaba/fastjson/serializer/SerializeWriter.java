package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class SerializeWriter extends Writer {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    private static final ThreadLocal<byte[]> bytesBufLocal = new ThreadLocal<>();
    static final int nonDirectFeautres = (((((((((SerializerFeature.UseSingleQuotes.mask | 0) | SerializerFeature.BrowserSecure.mask) | SerializerFeature.BrowserCompatible.mask) | SerializerFeature.PrettyFormat.mask) | SerializerFeature.WriteEnumUsingToString.mask) | SerializerFeature.WriteNonStringValueAsString.mask) | SerializerFeature.WriteSlashAsSpecial.mask) | SerializerFeature.IgnoreErrorGetter.mask) | SerializerFeature.WriteClassName.mask) | SerializerFeature.NotWriteDefaultValue.mask;
    protected boolean beanToArray;
    protected char[] buf;
    protected int count;
    protected boolean disableCircularReferenceDetect;
    protected int features;
    protected char keySeperator;
    protected int maxBufSize;
    protected boolean notWriteDefaultValue;
    protected boolean quoteFieldNames;
    protected boolean sortField;
    protected boolean useSingleQuotes;
    protected boolean writeDirect;
    protected boolean writeEnumUsingName;
    protected boolean writeEnumUsingToString;
    protected boolean writeNonStringValueAsString;
    private final Writer writer;

    public SerializeWriter() {
        this((Writer) null);
    }

    private int encodeToUTF8(OutputStream outputStream) throws IOException {
        double d4 = this.count;
        Double.isNaN(d4);
        int i4 = (int) (d4 * 3.0d);
        ThreadLocal<byte[]> threadLocal = bytesBufLocal;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        if (bArr.length < i4) {
            bArr = new byte[i4];
        }
        int encodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr);
        outputStream.write(bArr, 0, encodeUTF8);
        return encodeUTF8;
    }

    private byte[] encodeToUTF8Bytes() {
        double d4 = this.count;
        Double.isNaN(d4);
        int i4 = (int) (d4 * 3.0d);
        ThreadLocal<byte[]> threadLocal = bytesBufLocal;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        if (bArr.length < i4) {
            bArr = new byte[i4];
        }
        int encodeUTF8 = IOUtils.encodeUTF8(this.buf, 0, this.count, bArr);
        byte[] bArr2 = new byte[encodeUTF8];
        System.arraycopy(bArr, 0, bArr2, 0, encodeUTF8);
        return bArr2;
    }

    static boolean isSpecial(char c4, int i4) {
        if (c4 == ' ') {
            return false;
        }
        if (c4 == '/') {
            return (SerializerFeature.WriteSlashAsSpecial.mask & i4) != 0;
        } else if (c4 <= '#' || c4 == '\\') {
            return c4 <= 31 || c4 == '\\' || c4 == '\"';
        } else {
            return false;
        }
    }

    private void writeEnumFieldValue(char c4, String str, String str2) {
        if (this.useSingleQuotes) {
            writeFieldValue(c4, str, str2);
        } else {
            writeFieldValueStringWithDoubleQuote(c4, str, str2);
        }
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        byte[] bArr = IOUtils.specicalFlags_singleQuotes;
        int length = str.length();
        boolean z3 = true;
        int i4 = this.count + length + 1;
        int i5 = 0;
        if (i4 > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i6 = 0;
                while (true) {
                    if (i6 < length) {
                        char charAt = str.charAt(i6);
                        if (charAt < bArr.length && bArr[charAt] != 0) {
                            break;
                        }
                        i6++;
                    } else {
                        z3 = false;
                        break;
                    }
                }
                if (z3) {
                    write(39);
                }
                while (i5 < length) {
                    char charAt2 = str.charAt(i5);
                    if (charAt2 < bArr.length && bArr[charAt2] != 0) {
                        write(92);
                        write(IOUtils.replaceChars[charAt2]);
                    } else {
                        write(charAt2);
                    }
                    i5++;
                }
                if (z3) {
                    write(39);
                }
                write(58);
                return;
            }
            expandCapacity(i4);
        }
        if (length == 0) {
            int i7 = this.count;
            if (i7 + 3 > this.buf.length) {
                expandCapacity(i7 + 3);
            }
            char[] cArr = this.buf;
            int i8 = this.count;
            int i9 = i8 + 1;
            this.count = i9;
            cArr[i8] = '\'';
            int i10 = i9 + 1;
            this.count = i10;
            cArr[i9] = '\'';
            this.count = i10 + 1;
            cArr[i10] = ':';
            return;
        }
        int i11 = this.count;
        int i12 = i11 + length;
        str.getChars(0, length, this.buf, i11);
        this.count = i4;
        int i13 = i11;
        boolean z4 = false;
        while (i13 < i12) {
            char[] cArr2 = this.buf;
            char c4 = cArr2[i13];
            if (c4 < bArr.length && bArr[c4] != 0) {
                if (!z4) {
                    i4 += 3;
                    if (i4 > cArr2.length) {
                        expandCapacity(i4);
                    }
                    this.count = i4;
                    char[] cArr3 = this.buf;
                    int i14 = i13 + 1;
                    System.arraycopy(cArr3, i14, cArr3, i13 + 3, (i12 - i13) - 1);
                    char[] cArr4 = this.buf;
                    System.arraycopy(cArr4, i5, cArr4, 1, i13);
                    char[] cArr5 = this.buf;
                    cArr5[i11] = '\'';
                    cArr5[i14] = '\\';
                    int i15 = i14 + 1;
                    cArr5[i15] = IOUtils.replaceChars[c4];
                    i12 += 2;
                    cArr5[this.count - 2] = '\'';
                    i13 = i15;
                    z4 = true;
                } else {
                    i4++;
                    if (i4 > cArr2.length) {
                        expandCapacity(i4);
                    }
                    this.count = i4;
                    char[] cArr6 = this.buf;
                    int i16 = i13 + 1;
                    System.arraycopy(cArr6, i16, cArr6, i13 + 2, i12 - i13);
                    char[] cArr7 = this.buf;
                    cArr7[i13] = '\\';
                    cArr7[i16] = IOUtils.replaceChars[c4];
                    i12++;
                    i13 = i16;
                }
            }
            i13++;
            i5 = 0;
        }
        this.buf[i4 - 1] = ':';
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= 65536) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    protected void computeFeatures() {
        int i4 = this.features;
        boolean z3 = true;
        boolean z4 = (SerializerFeature.QuoteFieldNames.mask & i4) != 0;
        this.quoteFieldNames = z4;
        boolean z5 = (SerializerFeature.UseSingleQuotes.mask & i4) != 0;
        this.useSingleQuotes = z5;
        this.sortField = (SerializerFeature.SortField.mask & i4) != 0;
        this.disableCircularReferenceDetect = (SerializerFeature.DisableCircularReferenceDetect.mask & i4) != 0;
        boolean z6 = (SerializerFeature.BeanToArray.mask & i4) != 0;
        this.beanToArray = z6;
        this.writeNonStringValueAsString = (SerializerFeature.WriteNonStringValueAsString.mask & i4) != 0;
        this.notWriteDefaultValue = (SerializerFeature.NotWriteDefaultValue.mask & i4) != 0;
        boolean z7 = (SerializerFeature.WriteEnumUsingName.mask & i4) != 0;
        this.writeEnumUsingName = z7;
        this.writeEnumUsingToString = (SerializerFeature.WriteEnumUsingToString.mask & i4) != 0;
        if (!z4 || (i4 & nonDirectFeautres) != 0 || (!z6 && !z7)) {
            z3 = false;
        }
        this.writeDirect = z3;
        this.keySeperator = z5 ? '\'' : '\"';
    }

    public void config(SerializerFeature serializerFeature, boolean z3) {
        if (z3) {
            int mask = this.features | serializerFeature.getMask();
            this.features = mask;
            SerializerFeature serializerFeature2 = SerializerFeature.WriteEnumUsingToString;
            if (serializerFeature == serializerFeature2) {
                this.features = (SerializerFeature.WriteEnumUsingName.getMask() ^ (-1)) & mask;
            } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                this.features = (serializerFeature2.getMask() ^ (-1)) & mask;
            }
        } else {
            this.features = (serializerFeature.getMask() ^ (-1)) & this.features;
        }
        computeFeatures();
    }

    public void expandCapacity(int i4) {
        int i5 = this.maxBufSize;
        if (i5 != -1 && i4 >= i5) {
            throw new JSONException("serialize exceeded MAX_OUTPUT_LENGTH=" + this.maxBufSize + ", minimumCapacity=" + i4);
        }
        char[] cArr = this.buf;
        int length = ((cArr.length * 3) / 2) + 1;
        if (length >= i4) {
            i4 = length;
        }
        char[] cArr2 = new char[i4];
        System.arraycopy(cArr, 0, cArr2, 0, this.count);
        this.buf = cArr2;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer = this.writer;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.buf, 0, this.count);
            this.writer.flush();
            this.count = 0;
        } catch (IOException e4) {
            throw new JSONException(e4.getMessage(), e4);
        }
    }

    public int getBufferLength() {
        return this.buf.length;
    }

    public int getMaxBufSize() {
        return this.maxBufSize;
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public boolean isNotWriteDefaultValue() {
        return this.notWriteDefaultValue;
    }

    public boolean isSortField() {
        return this.sortField;
    }

    public void setMaxBufSize(int i4) {
        if (i4 >= this.buf.length) {
            this.maxBufSize = i4;
            return;
        }
        throw new JSONException("must > " + this.buf.length);
    }

    public int size() {
        return this.count;
    }

    public byte[] toBytes(String str) {
        Charset charset;
        if (str != null && !"UTF-8".equals(str)) {
            charset = Charset.forName(str);
        } else {
            charset = UTF8;
        }
        return toBytes(charset);
    }

    public char[] toCharArray() {
        if (this.writer == null) {
            int i4 = this.count;
            char[] cArr = new char[i4];
            System.arraycopy(this.buf, 0, cArr, 0, i4);
            return cArr;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public char[] toCharArrayForSpringWebSocket() {
        if (this.writer == null) {
            int i4 = this.count;
            char[] cArr = new char[i4 - 2];
            System.arraycopy(this.buf, 1, cArr, 0, i4 - 2);
            return cArr;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Override // java.io.Writer
    public void write(int i4) {
        int i5 = 1;
        int i6 = this.count + 1;
        if (i6 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i6);
            } else {
                flush();
                this.buf[this.count] = (char) i4;
                this.count = i5;
            }
        }
        i5 = i6;
        this.buf[this.count] = (char) i4;
        this.count = i5;
    }

    public void writeByteArray(byte[] bArr) {
        if (isEnabled(SerializerFeature.WriteClassName.mask)) {
            writeHex(bArr);
            return;
        }
        int length = bArr.length;
        boolean z3 = this.useSingleQuotes;
        char c4 = z3 ? '\'' : '\"';
        if (length == 0) {
            write(z3 ? "''" : "\"\"");
            return;
        }
        char[] cArr = IOUtils.CA;
        int i4 = (length / 3) * 3;
        int i5 = length - 1;
        int i6 = this.count;
        int i7 = (((i5 / 3) + 1) << 2) + i6 + 2;
        if (i7 > this.buf.length) {
            if (this.writer != null) {
                write(c4);
                int i8 = 0;
                while (i8 < i4) {
                    int i9 = i8 + 1;
                    int i10 = i9 + 1;
                    int i11 = ((bArr[i8] & 255) << 16) | ((bArr[i9] & 255) << 8) | (bArr[i10] & 255);
                    write(cArr[(i11 >>> 18) & 63]);
                    write(cArr[(i11 >>> 12) & 63]);
                    write(cArr[(i11 >>> 6) & 63]);
                    write(cArr[i11 & 63]);
                    i8 = i10 + 1;
                }
                int i12 = length - i4;
                if (i12 > 0) {
                    int i13 = ((bArr[i4] & 255) << 10) | (i12 == 2 ? (bArr[i5] & 255) << 2 : 0);
                    write(cArr[i13 >> 12]);
                    write(cArr[(i13 >>> 6) & 63]);
                    write(i12 == 2 ? cArr[i13 & 63] : '=');
                    write(61);
                }
                write(c4);
                return;
            }
            expandCapacity(i7);
        }
        this.count = i7;
        int i14 = i6 + 1;
        this.buf[i6] = c4;
        int i15 = 0;
        while (i15 < i4) {
            int i16 = i15 + 1;
            int i17 = i16 + 1;
            int i18 = ((bArr[i15] & 255) << 16) | ((bArr[i16] & 255) << 8);
            int i19 = i17 + 1;
            int i20 = i18 | (bArr[i17] & 255);
            char[] cArr2 = this.buf;
            int i21 = i14 + 1;
            cArr2[i14] = cArr[(i20 >>> 18) & 63];
            int i22 = i21 + 1;
            cArr2[i21] = cArr[(i20 >>> 12) & 63];
            int i23 = i22 + 1;
            cArr2[i22] = cArr[(i20 >>> 6) & 63];
            i14 = i23 + 1;
            cArr2[i23] = cArr[i20 & 63];
            i15 = i19;
        }
        int i24 = length - i4;
        if (i24 > 0) {
            int i25 = ((bArr[i4] & 255) << 10) | (i24 == 2 ? (bArr[i5] & 255) << 2 : 0);
            char[] cArr3 = this.buf;
            cArr3[i7 - 5] = cArr[i25 >> 12];
            cArr3[i7 - 4] = cArr[(i25 >>> 6) & 63];
            cArr3[i7 - 3] = i24 == 2 ? cArr[i25 & 63] : '=';
            cArr3[i7 - 2] = '=';
        }
        this.buf[i7 - 1] = c4;
    }

    public void writeDouble(double d4, boolean z3) {
        if (!Double.isNaN(d4) && !Double.isInfinite(d4)) {
            String d5 = Double.toString(d4);
            if (isEnabled(SerializerFeature.WriteNullNumberAsZero) && d5.endsWith(".0")) {
                d5 = d5.substring(0, d5.length() - 2);
            }
            write(d5);
            if (z3 && isEnabled(SerializerFeature.WriteClassName)) {
                write(68);
                return;
            }
            return;
        }
        writeNull();
    }

    public void writeEnum(Enum<?> r3) {
        if (r3 == null) {
            writeNull();
            return;
        }
        String str = null;
        if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            str = r3.name();
        } else if (this.writeEnumUsingToString) {
            str = r3.toString();
        }
        if (str != null) {
            int i4 = isEnabled(SerializerFeature.UseSingleQuotes) ? 39 : 34;
            write(i4);
            write(str);
            write(i4);
            return;
        }
        writeInt(r3.ordinal());
    }

    public void writeFieldName(String str) {
        writeFieldName(str, false);
    }

    public void writeFieldNameDirect(String str) {
        int length = str.length();
        int i4 = this.count + length + 3;
        if (i4 > this.buf.length) {
            expandCapacity(i4);
        }
        int i5 = this.count;
        char[] cArr = this.buf;
        cArr[i5] = '\"';
        str.getChars(0, length, cArr, i5 + 1);
        this.count = i4;
        char[] cArr2 = this.buf;
        cArr2[i4 - 2] = '\"';
        cArr2[i4 - 1] = ':';
    }

    public void writeFieldValue(char c4, String str, char c5) {
        write(c4);
        writeFieldName(str);
        if (c5 == 0) {
            writeString("\u0000");
        } else {
            writeString(Character.toString(c5));
        }
    }

    public void writeFieldValueStringWithDoubleQuote(char c4, String str, String str2) {
        int length = str.length();
        int i4 = this.count;
        int length2 = str2.length();
        int i5 = i4 + length + length2 + 6;
        if (i5 > this.buf.length) {
            if (this.writer != null) {
                write(c4);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            expandCapacity(i5);
        }
        char[] cArr = this.buf;
        int i6 = this.count;
        cArr[i6] = c4;
        int i7 = i6 + 2;
        int i8 = i7 + length;
        cArr[i6 + 1] = '\"';
        str.getChars(0, length, cArr, i7);
        this.count = i5;
        char[] cArr2 = this.buf;
        cArr2[i8] = '\"';
        int i9 = i8 + 1;
        int i10 = i9 + 1;
        cArr2[i9] = ':';
        cArr2[i10] = '\"';
        str2.getChars(0, length2, cArr2, i10 + 1);
        this.buf[this.count - 1] = '\"';
    }

    public void writeFieldValueStringWithDoubleQuoteCheck(char c4, String str, String str2) {
        int length;
        int i4;
        int i5;
        int length2 = str.length();
        int i6 = this.count;
        if (str2 == null) {
            i4 = i6 + length2 + 8;
            length = 4;
        } else {
            length = str2.length();
            i4 = i6 + length2 + length + 6;
        }
        int i7 = 0;
        if (i4 > this.buf.length) {
            if (this.writer != null) {
                write(c4);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            }
            expandCapacity(i4);
        }
        char[] cArr = this.buf;
        int i8 = this.count;
        cArr[i8] = c4;
        int i9 = i8 + 2;
        int i10 = i9 + length2;
        cArr[i8 + 1] = '\"';
        str.getChars(0, length2, cArr, i9);
        this.count = i4;
        char[] cArr2 = this.buf;
        cArr2[i10] = '\"';
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        cArr2[i11] = ':';
        if (str2 == null) {
            int i13 = i12 + 1;
            cArr2[i12] = 'n';
            int i14 = i13 + 1;
            cArr2[i13] = 'u';
            cArr2[i14] = 'l';
            cArr2[i14 + 1] = 'l';
            return;
        }
        int i15 = i12 + 1;
        cArr2[i12] = '\"';
        int i16 = i15 + length;
        str2.getChars(0, length, cArr2, i15);
        char c5 = 0;
        int i17 = -1;
        int i18 = -1;
        for (int i19 = i15; i19 < i16; i19++) {
            char c6 = this.buf[i19];
            if (c6 >= ']') {
                if (c6 >= '\u007f' && (c6 == '\u2028' || c6 == '\u2029' || c6 < '\u00a0')) {
                    if (i17 == -1) {
                        i17 = i19;
                    }
                    i7++;
                    i4 += 4;
                    c5 = c6;
                    i18 = i19;
                }
            } else if (isSpecial(c6, this.features)) {
                i7++;
                byte[] bArr = IOUtils.specicalFlags_doubleQuotes;
                if (c6 < bArr.length && bArr[c6] == 4) {
                    i4 += 4;
                }
                c5 = c6;
                if (i17 == -1) {
                    i17 = i19;
                    i18 = i17;
                }
                i18 = i19;
            }
        }
        if (i7 > 0) {
            int i20 = i4 + i7;
            if (i20 > this.buf.length) {
                expandCapacity(i20);
            }
            this.count = i20;
            if (i7 == 1) {
                if (c5 == '\u2028') {
                    int i21 = i18 + 1;
                    char[] cArr3 = this.buf;
                    System.arraycopy(cArr3, i21, cArr3, i18 + 6, (i16 - i18) - 1);
                    char[] cArr4 = this.buf;
                    cArr4[i18] = '\\';
                    cArr4[i21] = 'u';
                    int i22 = i21 + 1;
                    cArr4[i22] = '2';
                    int i23 = i22 + 1;
                    cArr4[i23] = '0';
                    int i24 = i23 + 1;
                    cArr4[i24] = '2';
                    cArr4[i24 + 1] = '8';
                } else if (c5 == '\u2029') {
                    int i25 = i18 + 1;
                    char[] cArr5 = this.buf;
                    System.arraycopy(cArr5, i25, cArr5, i18 + 6, (i16 - i18) - 1);
                    char[] cArr6 = this.buf;
                    cArr6[i18] = '\\';
                    cArr6[i25] = 'u';
                    int i26 = i25 + 1;
                    cArr6[i26] = '2';
                    int i27 = i26 + 1;
                    cArr6[i27] = '0';
                    int i28 = i27 + 1;
                    cArr6[i28] = '2';
                    cArr6[i28 + 1] = '9';
                } else {
                    byte[] bArr2 = IOUtils.specicalFlags_doubleQuotes;
                    if (c5 < bArr2.length && bArr2[c5] == 4) {
                        int i29 = i18 + 1;
                        char[] cArr7 = this.buf;
                        System.arraycopy(cArr7, i29, cArr7, i18 + 6, (i16 - i18) - 1);
                        char[] cArr8 = this.buf;
                        cArr8[i18] = '\\';
                        int i30 = i29 + 1;
                        cArr8[i29] = 'u';
                        int i31 = i30 + 1;
                        char[] cArr9 = IOUtils.DIGITS;
                        cArr8[i30] = cArr9[(c5 >>> '\f') & 15];
                        int i32 = i31 + 1;
                        cArr8[i31] = cArr9[(c5 >>> '\b') & 15];
                        cArr8[i32] = cArr9[(c5 >>> 4) & 15];
                        cArr8[i32 + 1] = cArr9[c5 & 15];
                    } else {
                        int i33 = i18 + 1;
                        char[] cArr10 = this.buf;
                        System.arraycopy(cArr10, i33, cArr10, i18 + 2, (i16 - i18) - 1);
                        char[] cArr11 = this.buf;
                        cArr11[i18] = '\\';
                        cArr11[i33] = IOUtils.replaceChars[c5];
                    }
                }
            } else if (i7 > 1) {
                for (int i34 = i17 - i15; i34 < str2.length(); i34++) {
                    char charAt = str2.charAt(i34);
                    byte[] bArr3 = IOUtils.specicalFlags_doubleQuotes;
                    if ((charAt < bArr3.length && bArr3[charAt] != 0) || (charAt == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        char[] cArr12 = this.buf;
                        int i35 = i17 + 1;
                        cArr12[i17] = '\\';
                        if (bArr3[charAt] == 4) {
                            int i36 = i35 + 1;
                            cArr12[i35] = 'u';
                            int i37 = i36 + 1;
                            char[] cArr13 = IOUtils.DIGITS;
                            cArr12[i36] = cArr13[(charAt >>> '\f') & 15];
                            int i38 = i37 + 1;
                            cArr12[i37] = cArr13[(charAt >>> '\b') & 15];
                            int i39 = i38 + 1;
                            cArr12[i38] = cArr13[(charAt >>> 4) & 15];
                            i5 = i39 + 1;
                            cArr12[i39] = cArr13[charAt & 15];
                        } else {
                            i5 = i35 + 1;
                            cArr12[i35] = IOUtils.replaceChars[charAt];
                        }
                        i17 = i5;
                    } else if (charAt != '\u2028' && charAt != '\u2029') {
                        this.buf[i17] = charAt;
                        i17++;
                    } else {
                        char[] cArr14 = this.buf;
                        int i40 = i17 + 1;
                        cArr14[i17] = '\\';
                        int i41 = i40 + 1;
                        cArr14[i40] = 'u';
                        int i42 = i41 + 1;
                        char[] cArr15 = IOUtils.DIGITS;
                        cArr14[i41] = cArr15[(charAt >>> '\f') & 15];
                        int i43 = i42 + 1;
                        cArr14[i42] = cArr15[(charAt >>> '\b') & 15];
                        int i44 = i43 + 1;
                        cArr14[i43] = cArr15[(charAt >>> 4) & 15];
                        cArr14[i44] = cArr15[charAt & 15];
                        i17 = i44 + 1;
                    }
                }
            }
        }
        this.buf[this.count - 1] = '\"';
    }

    public void writeFloat(float f4, boolean z3) {
        if (!Float.isNaN(f4) && !Float.isInfinite(f4)) {
            String f5 = Float.toString(f4);
            if (isEnabled(SerializerFeature.WriteNullNumberAsZero) && f5.endsWith(".0")) {
                f5 = f5.substring(0, f5.length() - 2);
            }
            write(f5);
            if (z3 && isEnabled(SerializerFeature.WriteClassName)) {
                write(70);
                return;
            }
            return;
        }
        writeNull();
    }

    public void writeHex(byte[] bArr) {
        int i4 = 2;
        int length = this.count + (bArr.length * 2) + 3;
        int i5 = 0;
        if (length > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[bArr.length + 3];
                cArr[0] = 'x';
                cArr[1] = '\'';
                while (i5 < bArr.length) {
                    int i6 = bArr[i5] & 255;
                    int i7 = i6 >> 4;
                    int i8 = i6 & 15;
                    int i9 = i4 + 1;
                    cArr[i4] = (char) (i7 + (i7 < 10 ? 48 : 55));
                    i4 = i9 + 1;
                    cArr[i9] = (char) (i8 + (i8 < 10 ? 48 : 55));
                    i5++;
                }
                cArr[i4] = '\'';
                try {
                    this.writer.write(cArr);
                    return;
                } catch (IOException e4) {
                    throw new JSONException("writeBytes error.", e4);
                }
            }
            expandCapacity(length);
        }
        char[] cArr2 = this.buf;
        int i10 = this.count;
        int i11 = i10 + 1;
        this.count = i11;
        cArr2[i10] = 'x';
        this.count = i11 + 1;
        cArr2[i11] = '\'';
        while (i5 < bArr.length) {
            int i12 = bArr[i5] & 255;
            int i13 = i12 >> 4;
            int i14 = i12 & 15;
            char[] cArr3 = this.buf;
            int i15 = this.count;
            int i16 = i15 + 1;
            this.count = i16;
            cArr3[i15] = (char) (i13 + (i13 < 10 ? 48 : 55));
            this.count = i16 + 1;
            cArr3[i16] = (char) (i14 + (i14 < 10 ? 48 : 55));
            i5++;
        }
        char[] cArr4 = this.buf;
        int i17 = this.count;
        this.count = i17 + 1;
        cArr4[i17] = '\'';
    }

    public void writeInt(int i4) {
        if (i4 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int stringSize = i4 < 0 ? IOUtils.stringSize(-i4) + 1 : IOUtils.stringSize(i4);
        int i5 = this.count + stringSize;
        if (i5 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i5);
            } else {
                char[] cArr = new char[stringSize];
                IOUtils.getChars(i4, stringSize, cArr);
                write(cArr, 0, stringSize);
                return;
            }
        }
        IOUtils.getChars(i4, i5, this.buf);
        this.count = i5;
    }

    public void writeLong(long j4) {
        boolean z3 = isEnabled(SerializerFeature.BrowserCompatible) && !isEnabled(SerializerFeature.WriteClassName) && (j4 > 9007199254740991L || j4 < -9007199254740991L);
        if (j4 == Long.MIN_VALUE) {
            if (z3) {
                write("\"-9223372036854775808\"");
                return;
            } else {
                write("-9223372036854775808");
                return;
            }
        }
        int stringSize = j4 < 0 ? IOUtils.stringSize(-j4) + 1 : IOUtils.stringSize(j4);
        int i4 = this.count + stringSize;
        if (z3) {
            i4 += 2;
        }
        if (i4 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i4);
            } else {
                char[] cArr = new char[stringSize];
                IOUtils.getChars(j4, stringSize, cArr);
                if (z3) {
                    write(34);
                    write(cArr, 0, stringSize);
                    write(34);
                    return;
                }
                write(cArr, 0, stringSize);
                return;
            }
        }
        if (z3) {
            char[] cArr2 = this.buf;
            cArr2[this.count] = '\"';
            int i5 = i4 - 1;
            IOUtils.getChars(j4, i5, cArr2);
            this.buf[i5] = '\"';
        } else {
            IOUtils.getChars(j4, i4, this.buf);
        }
        this.count = i4;
    }

    public void writeNull() {
        write("null");
    }

    public void writeString(String str, char c4) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
            write(c4);
            return;
        }
        writeStringWithDoubleQuote(str, c4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:213:0x039b, code lost:
        if (r10 == (-1)) goto L248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x03a4, code lost:
        if (r10 == (-1)) goto L248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x03a6, code lost:
        r10 = r7;
        r18 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeStringWithDoubleQuote(java.lang.String r20, char r21) {
        /*
            Method dump skipped, instructions count: 1346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeStringWithDoubleQuote(java.lang.String, char):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeStringWithSingleQuote(String str) {
        int i4 = 0;
        if (str == null) {
            int i5 = this.count + 4;
            if (i5 > this.buf.length) {
                expandCapacity(i5);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i5;
            return;
        }
        int length = str.length();
        int i6 = this.count + length + 2;
        if (i6 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i4 < str.length()) {
                    char charAt = str.charAt(i4);
                    if (charAt > '\r' && charAt != '\\' && charAt != '\'' && (charAt != '/' || !isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                        write(charAt);
                    } else {
                        write(92);
                        write(IOUtils.replaceChars[charAt]);
                    }
                    i4++;
                }
                write(39);
                return;
            }
            expandCapacity(i6);
        }
        int i7 = this.count;
        int i8 = i7 + 1;
        int i9 = i8 + length;
        char[] cArr = this.buf;
        cArr[i7] = '\'';
        str.getChars(0, length, cArr, i8);
        this.count = i6;
        int i10 = -1;
        char c4 = 0;
        for (int i11 = i8; i11 < i9; i11++) {
            char c5 = this.buf[i11];
            if (c5 <= '\r' || c5 == '\\' || c5 == '\'' || (c5 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                i4++;
                i10 = i11;
                c4 = c5;
            }
        }
        int i12 = i6 + i4;
        if (i12 > this.buf.length) {
            expandCapacity(i12);
        }
        this.count = i12;
        if (i4 == 1) {
            char[] cArr2 = this.buf;
            int i13 = i10 + 1;
            System.arraycopy(cArr2, i13, cArr2, i10 + 2, (i9 - i10) - 1);
            char[] cArr3 = this.buf;
            cArr3[i10] = '\\';
            cArr3[i13] = IOUtils.replaceChars[c4];
        } else if (i4 > 1) {
            char[] cArr4 = this.buf;
            int i14 = i10 + 1;
            System.arraycopy(cArr4, i14, cArr4, i10 + 2, (i9 - i10) - 1);
            char[] cArr5 = this.buf;
            cArr5[i10] = '\\';
            cArr5[i14] = IOUtils.replaceChars[c4];
            int i15 = i9 + 1;
            for (int i16 = i14 - 2; i16 >= i8; i16--) {
                char c6 = this.buf[i16];
                if (c6 <= '\r' || c6 == '\\' || c6 == '\'' || (c6 == '/' && isEnabled(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.buf;
                    int i17 = i16 + 1;
                    System.arraycopy(cArr6, i17, cArr6, i16 + 2, (i15 - i16) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i16] = '\\';
                    cArr7[i17] = IOUtils.replaceChars[c6];
                    i15++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.writer == null) {
            writer.write(this.buf, 0, this.count);
            return;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public int writeToEx(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer == null) {
            if (charset == UTF8) {
                return encodeToUTF8(outputStream);
            }
            byte[] bytes = new String(this.buf, 0, this.count).getBytes(charset);
            outputStream.write(bytes);
            return bytes.length;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public SerializeWriter(Writer writer) {
        this(writer, JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    }

    public boolean isEnabled(int i4) {
        return (i4 & this.features) != 0;
    }

    public void writeFieldName(String str, boolean z3) {
        if (str == null) {
            write("null:");
        } else if (this.useSingleQuotes) {
            if (this.quoteFieldNames) {
                writeStringWithSingleQuote(str);
                write(58);
                return;
            }
            writeKeyWithSingleQuoteIfHasSpecial(str);
        } else if (this.quoteFieldNames) {
            writeStringWithDoubleQuote(str, ':');
        } else {
            boolean z4 = true;
            boolean z5 = str.length() == 0;
            int i4 = 0;
            while (true) {
                if (i4 >= str.length()) {
                    z4 = z5;
                    break;
                } else if (isSpecial(str.charAt(i4), 0)) {
                    break;
                } else {
                    i4++;
                }
            }
            if (z4) {
                writeStringWithDoubleQuote(str, ':');
                return;
            }
            write(str);
            write(58);
        }
    }

    public void writeNull(SerializerFeature serializerFeature) {
        writeNull(0, serializerFeature.mask);
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this((Writer) null, serializerFeatureArr);
    }

    public void writeNull(int i4, int i5) {
        if ((i4 & i5) == 0 && (this.features & i5) == 0) {
            writeNull();
        } else if (i5 == SerializerFeature.WriteNullListAsEmpty.mask) {
            write("[]");
        } else if (i5 == SerializerFeature.WriteNullStringAsEmpty.mask) {
            writeString("");
        } else if (i5 == SerializerFeature.WriteNullBooleanAsFalse.mask) {
            write("false");
        } else if (i5 == SerializerFeature.WriteNullNumberAsZero.mask) {
            write(48);
        } else {
            writeNull();
        }
    }

    public SerializeWriter(Writer writer, SerializerFeature... serializerFeatureArr) {
        this(writer, 0, serializerFeatureArr);
    }

    public byte[] toBytes(Charset charset) {
        if (this.writer == null) {
            if (charset == UTF8) {
                return encodeToUTF8Bytes();
            }
            return new String(this.buf, 0, this.count).getBytes(charset);
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public SerializeWriter(Writer writer, int i4, SerializerFeature... serializerFeatureArr) {
        this.maxBufSize = -1;
        this.writer = writer;
        ThreadLocal<char[]> threadLocal = bufLocal;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        } else {
            this.buf = new char[2048];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i4 |= serializerFeature.getMask();
        }
        this.features = i4;
        computeFeatures();
    }

    public void writeFieldValue(char c4, String str, boolean z3) {
        if (!this.quoteFieldNames) {
            write(c4);
            writeFieldName(str);
            write(z3);
            return;
        }
        int i4 = z3 ? 4 : 5;
        int length = str.length();
        int i5 = this.count + length + 4 + i4;
        if (i5 > this.buf.length) {
            if (this.writer != null) {
                write(c4);
                writeString(str);
                write(58);
                write(z3);
                return;
            }
            expandCapacity(i5);
        }
        int i6 = this.count;
        this.count = i5;
        char[] cArr = this.buf;
        cArr[i6] = c4;
        int i7 = i6 + length + 1;
        cArr[i6 + 1] = this.keySeperator;
        str.getChars(0, length, cArr, i6 + 2);
        this.buf[i7 + 1] = this.keySeperator;
        if (z3) {
            System.arraycopy(":true".toCharArray(), 0, this.buf, i7 + 2, 5);
        } else {
            System.arraycopy(":false".toCharArray(), 0, this.buf, i7 + 2, 6);
        }
    }

    public void writeString(String str) {
        if (this.useSingleQuotes) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, (char) 0);
        }
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        writeToEx(outputStream, charset);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i4, int i5) {
        int i6;
        if (i4 < 0 || i4 > cArr.length || i5 < 0 || (i6 = i4 + i5) > cArr.length || i6 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i5 == 0) {
            return;
        }
        int i7 = this.count + i5;
        if (i7 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i7);
            } else {
                do {
                    char[] cArr2 = this.buf;
                    int length = cArr2.length;
                    int i8 = this.count;
                    int i9 = length - i8;
                    System.arraycopy(cArr, i4, cArr2, i8, i9);
                    this.count = this.buf.length;
                    flush();
                    i5 -= i9;
                    i4 += i9;
                } while (i5 > this.buf.length);
                i7 = i5;
            }
        }
        System.arraycopy(cArr, i4, this.buf, this.count, i5);
        this.count = i7;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence, int i4, int i5) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i4, i5).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c4) {
        write(c4);
        return this;
    }

    public SerializeWriter(int i4) {
        this((Writer) null, i4);
    }

    public SerializeWriter(Writer writer, int i4) {
        this.maxBufSize = -1;
        this.writer = writer;
        if (i4 > 0) {
            this.buf = new char[i4];
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i4);
    }

    @Override // java.io.Writer
    public void write(String str, int i4, int i5) {
        int i6;
        int i7 = this.count + i5;
        if (i7 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i7);
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i8 = this.count;
                    int i9 = length - i8;
                    i6 = i4 + i9;
                    str.getChars(i4, i6, cArr, i8);
                    this.count = this.buf.length;
                    flush();
                    i5 -= i9;
                    if (i5 <= this.buf.length) {
                        break;
                    }
                    i4 = i6;
                }
                i7 = i5;
                i4 = i6;
            }
        }
        str.getChars(i4, i5 + i4, this.buf, this.count);
        this.count = i7;
    }

    public void writeFieldValue(char c4, String str, int i4) {
        if (i4 != Integer.MIN_VALUE && this.quoteFieldNames) {
            int stringSize = i4 < 0 ? IOUtils.stringSize(-i4) + 1 : IOUtils.stringSize(i4);
            int length = str.length();
            int i5 = this.count + length + 4 + stringSize;
            if (i5 > this.buf.length) {
                if (this.writer != null) {
                    write(c4);
                    writeFieldName(str);
                    writeInt(i4);
                    return;
                }
                expandCapacity(i5);
            }
            int i6 = this.count;
            this.count = i5;
            char[] cArr = this.buf;
            cArr[i6] = c4;
            int i7 = i6 + length + 1;
            cArr[i6 + 1] = this.keySeperator;
            str.getChars(0, length, cArr, i6 + 2);
            char[] cArr2 = this.buf;
            cArr2[i7 + 1] = this.keySeperator;
            cArr2[i7 + 2] = ':';
            IOUtils.getChars(i4, this.count, cArr2);
            return;
        }
        write(c4);
        writeFieldName(str);
        writeInt(i4);
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void write(List<String> list) {
        boolean z3;
        int i4;
        if (list.isEmpty()) {
            write("[]");
            return;
        }
        int i5 = this.count;
        int size = list.size();
        int i6 = i5;
        int i7 = 0;
        while (i7 < size) {
            String str = list.get(i7);
            if (str == null) {
                z3 = true;
            } else {
                int length = str.length();
                z3 = false;
                for (int i8 = 0; i8 < length; i8++) {
                    char charAt = str.charAt(i8);
                    z3 = charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\\';
                    if (z3) {
                        break;
                    }
                }
            }
            if (z3) {
                this.count = i5;
                write(91);
                for (int i9 = 0; i9 < list.size(); i9++) {
                    String str2 = list.get(i9);
                    if (i9 != 0) {
                        write(44);
                    }
                    if (str2 == null) {
                        write("null");
                    } else {
                        writeStringWithDoubleQuote(str2, (char) 0);
                    }
                }
                write(93);
                return;
            }
            int length2 = str.length() + i6 + 3;
            if (i7 == list.size() - 1) {
                length2++;
            }
            if (length2 > this.buf.length) {
                this.count = i6;
                expandCapacity(length2);
            }
            if (i7 == 0) {
                i4 = i6 + 1;
                this.buf[i6] = '[';
            } else {
                i4 = i6 + 1;
                this.buf[i6] = ',';
            }
            int i10 = i4 + 1;
            this.buf[i4] = '\"';
            str.getChars(0, str.length(), this.buf, i10);
            int length3 = i10 + str.length();
            this.buf[length3] = '\"';
            i7++;
            i6 = length3 + 1;
        }
        this.buf[i6] = ']';
        this.count = i6 + 1;
    }

    public void writeFieldValue(char c4, String str, long j4) {
        if (j4 != Long.MIN_VALUE && this.quoteFieldNames) {
            int stringSize = j4 < 0 ? IOUtils.stringSize(-j4) + 1 : IOUtils.stringSize(j4);
            int length = str.length();
            int i4 = this.count + length + 4 + stringSize;
            if (i4 > this.buf.length) {
                if (this.writer != null) {
                    write(c4);
                    writeFieldName(str);
                    writeLong(j4);
                    return;
                }
                expandCapacity(i4);
            }
            int i5 = this.count;
            this.count = i4;
            char[] cArr = this.buf;
            cArr[i5] = c4;
            int i6 = i5 + length + 1;
            cArr[i5 + 1] = this.keySeperator;
            str.getChars(0, length, cArr, i5 + 2);
            char[] cArr2 = this.buf;
            cArr2[i6 + 1] = this.keySeperator;
            cArr2[i6 + 2] = ':';
            IOUtils.getChars(j4, this.count, cArr2);
            return;
        }
        write(c4);
        writeFieldName(str);
        writeLong(j4);
    }

    public void write(boolean z3) {
        if (z3) {
            write("true");
        } else {
            write("false");
        }
    }

    public void writeFieldValue(char c4, String str, float f4) {
        write(c4);
        writeFieldName(str);
        writeFloat(f4, false);
    }

    public void writeFieldValue(char c4, String str, double d4) {
        write(c4);
        writeFieldName(str);
        writeDouble(d4, false);
    }

    public void writeFieldValue(char c4, String str, String str2) {
        if (this.quoteFieldNames) {
            if (this.useSingleQuotes) {
                write(c4);
                writeFieldName(str);
                if (str2 == null) {
                    writeNull();
                    return;
                } else {
                    writeString(str2);
                    return;
                }
            } else if (isEnabled(SerializerFeature.BrowserSecure)) {
                write(c4);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            } else if (isEnabled(SerializerFeature.BrowserCompatible)) {
                write(c4);
                writeStringWithDoubleQuote(str, ':');
                writeStringWithDoubleQuote(str2, (char) 0);
                return;
            } else {
                writeFieldValueStringWithDoubleQuoteCheck(c4, str, str2);
                return;
            }
        }
        write(c4);
        writeFieldName(str);
        if (str2 == null) {
            writeNull();
        } else {
            writeString(str2);
        }
    }

    public void writeFieldValue(char c4, String str, Enum<?> r4) {
        if (r4 == null) {
            write(c4);
            writeFieldName(str);
            writeNull();
        } else if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
            writeEnumFieldValue(c4, str, r4.name());
        } else if (this.writeEnumUsingToString) {
            writeEnumFieldValue(c4, str, r4.toString());
        } else {
            writeFieldValue(c4, str, r4.ordinal());
        }
    }

    public void writeFieldValue(char c4, String str, BigDecimal bigDecimal) {
        write(c4);
        writeFieldName(str);
        if (bigDecimal == null) {
            writeNull();
        } else {
            write(bigDecimal.toString());
        }
    }
}
