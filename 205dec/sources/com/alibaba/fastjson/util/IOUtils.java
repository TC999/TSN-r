package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.MalformedInputException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Properties;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class IOUtils {
    public static final char[] ASCII_CHARS;
    public static final char[] CA;
    static final char[] DigitOnes;
    static final char[] DigitTens;
    public static final String FASTJSON_COMPATIBLEWITHFIELDNAME = "fastjson.compatibleWithFieldName";
    public static final String FASTJSON_COMPATIBLEWITHJAVABEAN = "fastjson.compatibleWithJavaBean";
    public static final String FASTJSON_PROPERTIES = "fastjson.properties";
    public static final int[] IA;
    static final char[] digits;
    public static final boolean[] identifierFlags;
    public static final char[] replaceChars;
    static final int[] sizeTable;
    public static final byte[] specicalFlags_doubleQuotes;
    public static final boolean[] specicalFlags_doubleQuotesFlags;
    public static final byte[] specicalFlags_singleQuotes;
    public static final boolean[] specicalFlags_singleQuotesFlags;
    public static final Properties DEFAULT_PROPERTIES = new Properties();
    public static final Charset UTF8 = Charset.forName("UTF-8");
    public static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final boolean[] firstIdentifierFlags = new boolean[256];

    static {
        char c4 = 0;
        while (true) {
            boolean[] zArr = firstIdentifierFlags;
            if (c4 >= zArr.length) {
                break;
            }
            if (c4 >= 'A' && c4 <= 'Z') {
                zArr[c4] = true;
            } else if (c4 >= 'a' && c4 <= 'z') {
                zArr[c4] = true;
            } else if (c4 == '_') {
                zArr[c4] = true;
            }
            c4 = (char) (c4 + 1);
        }
        identifierFlags = new boolean[256];
        char c5 = 0;
        while (true) {
            boolean[] zArr2 = identifierFlags;
            if (c5 < zArr2.length) {
                if (c5 >= 'A' && c5 <= 'Z') {
                    zArr2[c5] = true;
                } else if (c5 >= 'a' && c5 <= 'z') {
                    zArr2[c5] = true;
                } else if (c5 == '_') {
                    zArr2[c5] = true;
                } else if (c5 >= '0' && c5 <= '9') {
                    zArr2[c5] = true;
                }
                c5 = (char) (c5 + 1);
            } else {
                try {
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        loadPropertiesFromFile();
        byte[] bArr = new byte[161];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[161];
        specicalFlags_singleQuotes = bArr2;
        specicalFlags_doubleQuotesFlags = new boolean[161];
        specicalFlags_singleQuotesFlags = new boolean[161];
        replaceChars = new char[93];
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i4 = 14; i4 <= 31; i4++) {
            specicalFlags_doubleQuotes[i4] = 4;
            specicalFlags_singleQuotes[i4] = 4;
        }
        for (int i5 = 127; i5 < 160; i5++) {
            specicalFlags_doubleQuotes[i5] = 4;
            specicalFlags_singleQuotes[i5] = 4;
        }
        for (int i6 = 0; i6 < 161; i6++) {
            specicalFlags_doubleQuotesFlags[i6] = specicalFlags_doubleQuotes[i6] != 0;
            specicalFlags_singleQuotesFlags[i6] = specicalFlags_singleQuotes[i6] != 0;
        }
        char[] cArr = replaceChars;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
        ASCII_CHARS = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        DigitTens = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        DigitOnes = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        sizeTable = new int[]{9, 99, 999, AVMDLDataLoader.KeyIsEnableEventInfo, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i7 = 0; i7 < length; i7++) {
            IA[CA[i7]] = i7;
        }
        IA[61] = 0;
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void decode(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) {
        try {
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!decode.isUnderflow()) {
                decode.throwException();
            }
            CoderResult flush = charsetDecoder.flush(charBuffer);
            if (flush.isUnderflow()) {
                return;
            }
            flush.throwException();
        } catch (CharacterCodingException e4) {
            throw new JSONException("utf8 decode error, " + e4.getMessage(), e4);
        }
    }

    public static byte[] decodeBase64(char[] cArr, int i4, int i5) {
        int i6;
        int i7 = 0;
        if (i5 == 0) {
            return new byte[0];
        }
        int i8 = (i4 + i5) - 1;
        while (i4 < i8 && IA[cArr[i4]] < 0) {
            i4++;
        }
        while (i8 > 0 && IA[cArr[i8]] < 0) {
            i8--;
        }
        int i9 = cArr[i8] == '=' ? cArr[i8 + (-1)] == '=' ? 2 : 1 : 0;
        int i10 = (i8 - i4) + 1;
        if (i5 > 76) {
            i6 = (cArr[76] == '\r' ? i10 / 78 : 0) << 1;
        } else {
            i6 = 0;
        }
        int i11 = (((i10 - i6) * 6) >> 3) - i9;
        byte[] bArr = new byte[i11];
        int i12 = (i11 / 3) * 3;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i12) {
            int[] iArr = IA;
            int i15 = i4 + 1;
            int i16 = i15 + 1;
            int i17 = (iArr[cArr[i4]] << 18) | (iArr[cArr[i15]] << 12);
            int i18 = i16 + 1;
            int i19 = i17 | (iArr[cArr[i16]] << 6);
            int i20 = i18 + 1;
            int i21 = i19 | iArr[cArr[i18]];
            int i22 = i13 + 1;
            bArr[i13] = (byte) (i21 >> 16);
            int i23 = i22 + 1;
            bArr[i22] = (byte) (i21 >> 8);
            int i24 = i23 + 1;
            bArr[i23] = (byte) i21;
            if (i6 <= 0 || (i14 = i14 + 1) != 19) {
                i4 = i20;
            } else {
                i4 = i20 + 2;
                i14 = 0;
            }
            i13 = i24;
        }
        if (i13 < i11) {
            int i25 = 0;
            while (i4 <= i8 - i9) {
                i7 |= IA[cArr[i4]] << (18 - (i25 * 6));
                i25++;
                i4++;
            }
            int i26 = 16;
            while (i13 < i11) {
                bArr[i13] = (byte) (i7 >> i26);
                i26 -= 8;
                i13++;
            }
        }
        return bArr;
    }

    public static int decodeUTF8(byte[] bArr, int i4, int i5, char[] cArr) {
        int i6 = i4 + i5;
        int min = Math.min(i5, cArr.length);
        int i7 = 0;
        while (i7 < min && bArr[i4] >= 0) {
            cArr[i7] = (char) bArr[i4];
            i7++;
            i4++;
        }
        while (i4 < i6) {
            int i8 = i4 + 1;
            byte b4 = bArr[i4];
            if (b4 >= 0) {
                cArr[i7] = (char) b4;
                i4 = i8;
                i7++;
            } else if ((b4 >> 5) != -2 || (b4 & 30) == 0) {
                if ((b4 >> 4) == -2) {
                    int i9 = i8 + 1;
                    if (i9 < i6) {
                        byte b5 = bArr[i8];
                        int i10 = i9 + 1;
                        byte b6 = bArr[i9];
                        if ((b4 != -32 || (b5 & 224) != 128) && (b5 & 192) == 128 && (b6 & 192) == 128) {
                            char c4 = (char) (((b4 << 12) ^ (b5 << 6)) ^ ((-123008) ^ b6));
                            if (c4 >= '\ud800' && c4 < '\ue000') {
                                return -1;
                            }
                            cArr[i7] = c4;
                            i7++;
                            i4 = i10;
                        }
                    }
                    return -1;
                }
                if ((b4 >> 3) == -2 && i8 + 2 < i6) {
                    int i11 = i8 + 1;
                    byte b7 = bArr[i8];
                    int i12 = i11 + 1;
                    byte b8 = bArr[i11];
                    int i13 = i12 + 1;
                    byte b9 = bArr[i12];
                    int i14 = (((b4 << 18) ^ (b7 << 12)) ^ (b8 << 6)) ^ (3678080 ^ b9);
                    if ((b7 & 192) == 128 && (b8 & 192) == 128 && (b9 & 192) == 128 && Character.isSupplementaryCodePoint(i14)) {
                        int i15 = i7 + 1;
                        cArr[i7] = (char) ((i14 >>> 10) + 55232);
                        i7 = i15 + 1;
                        cArr[i15] = (char) ((i14 & 1023) + 56320);
                        i4 = i13;
                    }
                }
                return -1;
            } else if (i8 >= i6) {
                return -1;
            } else {
                int i16 = i8 + 1;
                byte b10 = bArr[i8];
                if ((b10 & 192) != 128) {
                    return -1;
                }
                cArr[i7] = (char) (((b4 << 6) ^ b10) ^ 3968);
                i4 = i16;
                i7++;
            }
        }
        return i7;
    }

    public static int encodeUTF8(char[] cArr, int i4, int i5, byte[] bArr) {
        int i6;
        int i7;
        int i8;
        int i9 = i4 + i5;
        int i10 = 0;
        int min = Math.min(i5, bArr.length) + 0;
        while (i10 < min && cArr[i4] < '\u0080') {
            bArr[i10] = (byte) cArr[i4];
            i10++;
            i4++;
        }
        while (i4 < i9) {
            int i11 = i4 + 1;
            char c4 = cArr[i4];
            if (c4 < '\u0080') {
                i6 = i10 + 1;
                bArr[i10] = (byte) c4;
            } else {
                if (c4 < '\u0800') {
                    int i12 = i10 + 1;
                    bArr[i10] = (byte) ((c4 >> 6) | 192);
                    i10 = i12 + 1;
                    bArr[i12] = (byte) ((c4 & '?') | 128);
                } else if (c4 >= '\ud800' && c4 < '\ue000') {
                    int i13 = i11 - 1;
                    if (!Character.isHighSurrogate(c4)) {
                        boolean isLowSurrogate = Character.isLowSurrogate(c4);
                        i7 = c4;
                        if (isLowSurrogate) {
                            throw new JSONException("encodeUTF8 error", new MalformedInputException(1));
                        }
                    } else if (i9 - i13 < 2) {
                        i7 = -1;
                    } else {
                        char c5 = cArr[i13 + 1];
                        if (Character.isLowSurrogate(c5)) {
                            i7 = Character.toCodePoint(c4, c5);
                        } else {
                            throw new JSONException("encodeUTF8 error", new MalformedInputException(1));
                        }
                    }
                    if (i7 < 0) {
                        i8 = i10 + 1;
                        bArr[i10] = 63;
                    } else {
                        int i14 = i10 + 1;
                        bArr[i10] = (byte) ((i7 >> 18) | 240);
                        int i15 = i14 + 1;
                        bArr[i14] = (byte) (((i7 >> 12) & 63) | 128);
                        int i16 = i15 + 1;
                        bArr[i15] = (byte) ((63 & (i7 >> 6)) | 128);
                        bArr[i16] = (byte) ((i7 & 63) | 128);
                        i11++;
                        i8 = i16 + 1;
                    }
                    i10 = i8;
                } else {
                    int i17 = i10 + 1;
                    bArr[i10] = (byte) ((c4 >> '\f') | 224);
                    int i18 = i17 + 1;
                    bArr[i17] = (byte) ((63 & (c4 >> 6)) | 128);
                    i6 = i18 + 1;
                    bArr[i18] = (byte) ((c4 & '?') | 128);
                }
                i4 = i11;
            }
            i4 = i11;
            i10 = i6;
        }
        return i10;
    }

    public static boolean firstIdentifier(char c4) {
        boolean[] zArr = firstIdentifierFlags;
        return c4 < zArr.length && zArr[c4];
    }

    public static void getChars(long j4, int i4, char[] cArr) {
        char c4;
        if (j4 < 0) {
            c4 = '-';
            j4 = -j4;
        } else {
            c4 = 0;
        }
        while (j4 > 2147483647L) {
            long j5 = j4 / 100;
            int i5 = (int) (j4 - (((j5 << 6) + (j5 << 5)) + (j5 << 2)));
            int i6 = i4 - 1;
            cArr[i6] = DigitOnes[i5];
            i4 = i6 - 1;
            cArr[i4] = DigitTens[i5];
            j4 = j5;
        }
        int i7 = (int) j4;
        while (i7 >= 65536) {
            int i8 = i7 / 100;
            int i9 = i7 - (((i8 << 6) + (i8 << 5)) + (i8 << 2));
            int i10 = i4 - 1;
            cArr[i10] = DigitOnes[i9];
            i4 = i10 - 1;
            cArr[i4] = DigitTens[i9];
            i7 = i8;
        }
        while (true) {
            int i11 = (52429 * i7) >>> 19;
            i4--;
            cArr[i4] = digits[i7 - ((i11 << 3) + (i11 << 1))];
            if (i11 == 0) {
                break;
            }
            i7 = i11;
        }
        if (c4 != 0) {
            cArr[i4 - 1] = c4;
        }
    }

    public static String getStringProperty(String str) {
        String str2;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException unused) {
            str2 = null;
        }
        return str2 == null ? DEFAULT_PROPERTIES.getProperty(str) : str2;
    }

    public static boolean isIdent(char c4) {
        boolean[] zArr = identifierFlags;
        return c4 < zArr.length && zArr[c4];
    }

    public static void loadPropertiesFromFile() {
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() { // from class: com.alibaba.fastjson.util.IOUtils.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public InputStream run() {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                if (contextClassLoader != null) {
                    return contextClassLoader.getResourceAsStream("fastjson.properties");
                }
                return ClassLoader.getSystemResourceAsStream("fastjson.properties");
            }
        });
        if (inputStream != null) {
            try {
                DEFAULT_PROPERTIES.load(inputStream);
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String readAll(Reader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            char[] cArr = new char[2048];
            while (true) {
                int read = reader.read(cArr, 0, 2048);
                if (read < 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } catch (Exception e4) {
            throw new JSONException("read string from reader error", e4);
        }
    }

    public static int stringSize(int i4) {
        int i5 = 0;
        while (i4 > sizeTable[i5]) {
            i5++;
        }
        return i5 + 1;
    }

    public static int stringSize(long j4) {
        long j5 = 10;
        for (int i4 = 1; i4 < 19; i4++) {
            if (j4 < j5) {
                return i4;
            }
            j5 *= 10;
        }
        return 19;
    }

    public static void getChars(int i4, int i5, char[] cArr) {
        char c4;
        if (i4 < 0) {
            c4 = '-';
            i4 = -i4;
        } else {
            c4 = 0;
        }
        while (i4 >= 65536) {
            int i6 = i4 / 100;
            int i7 = i4 - (((i6 << 6) + (i6 << 5)) + (i6 << 2));
            int i8 = i5 - 1;
            cArr[i8] = DigitOnes[i7];
            i5 = i8 - 1;
            cArr[i5] = DigitTens[i7];
            i4 = i6;
        }
        while (true) {
            int i9 = (52429 * i4) >>> 19;
            i5--;
            cArr[i5] = digits[i4 - ((i9 << 3) + (i9 << 1))];
            if (i9 == 0) {
                break;
            }
            i4 = i9;
        }
        if (c4 != 0) {
            cArr[i5 - 1] = c4;
        }
    }

    public static byte[] decodeBase64(String str, int i4, int i5) {
        int i6;
        int i7 = 0;
        if (i5 == 0) {
            return new byte[0];
        }
        int i8 = (i4 + i5) - 1;
        while (i4 < i8 && IA[str.charAt(i4)] < 0) {
            i4++;
        }
        while (i8 > 0 && IA[str.charAt(i8)] < 0) {
            i8--;
        }
        int i9 = str.charAt(i8) == '=' ? str.charAt(i8 + (-1)) == '=' ? 2 : 1 : 0;
        int i10 = (i8 - i4) + 1;
        if (i5 > 76) {
            i6 = (str.charAt(76) == '\r' ? i10 / 78 : 0) << 1;
        } else {
            i6 = 0;
        }
        int i11 = (((i10 - i6) * 6) >> 3) - i9;
        byte[] bArr = new byte[i11];
        int i12 = (i11 / 3) * 3;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i12) {
            int[] iArr = IA;
            int i15 = i4 + 1;
            int i16 = i15 + 1;
            int i17 = (iArr[str.charAt(i4)] << 18) | (iArr[str.charAt(i15)] << 12);
            int i18 = i16 + 1;
            int i19 = i17 | (iArr[str.charAt(i16)] << 6);
            int i20 = i18 + 1;
            int i21 = i19 | iArr[str.charAt(i18)];
            int i22 = i13 + 1;
            bArr[i13] = (byte) (i21 >> 16);
            int i23 = i22 + 1;
            bArr[i22] = (byte) (i21 >> 8);
            int i24 = i23 + 1;
            bArr[i23] = (byte) i21;
            if (i6 <= 0 || (i14 = i14 + 1) != 19) {
                i4 = i20;
            } else {
                i4 = i20 + 2;
                i14 = 0;
            }
            i13 = i24;
        }
        if (i13 < i11) {
            int i25 = 0;
            while (i4 <= i8 - i9) {
                i7 |= IA[str.charAt(i4)] << (18 - (i25 * 6));
                i25++;
                i4++;
            }
            int i26 = 16;
            while (i13 < i11) {
                bArr[i13] = (byte) (i7 >> i26);
                i26 -= 8;
                i13++;
            }
        }
        return bArr;
    }

    public static void getChars(byte b4, int i4, char[] cArr) {
        char c4;
        int i5;
        if (b4 < 0) {
            c4 = '-';
            i5 = -b4;
        } else {
            c4 = 0;
            i5 = b4;
        }
        while (true) {
            int i6 = (52429 * i5) >>> 19;
            i4--;
            cArr[i4] = digits[i5 - ((i6 << 3) + (i6 << 1))];
            if (i6 == 0) {
                break;
            }
            i5 = i6;
        }
        if (c4 != 0) {
            cArr[i4 - 1] = c4;
        }
    }

    public static byte[] decodeBase64(String str) {
        int i4;
        int length = str.length();
        int i5 = 0;
        if (length == 0) {
            return new byte[0];
        }
        int i6 = length - 1;
        int i7 = 0;
        while (i7 < i6 && IA[str.charAt(i7) & '\u00ff'] < 0) {
            i7++;
        }
        while (i6 > 0 && IA[str.charAt(i6) & '\u00ff'] < 0) {
            i6--;
        }
        int i8 = str.charAt(i6) == '=' ? str.charAt(i6 + (-1)) == '=' ? 2 : 1 : 0;
        int i9 = (i6 - i7) + 1;
        if (length > 76) {
            i4 = (str.charAt(76) == '\r' ? i9 / 78 : 0) << 1;
        } else {
            i4 = 0;
        }
        int i10 = (((i9 - i4) * 6) >> 3) - i8;
        byte[] bArr = new byte[i10];
        int i11 = (i10 / 3) * 3;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int[] iArr = IA;
            int i14 = i7 + 1;
            int i15 = i14 + 1;
            int i16 = (iArr[str.charAt(i7)] << 18) | (iArr[str.charAt(i14)] << 12);
            int i17 = i15 + 1;
            int i18 = i16 | (iArr[str.charAt(i15)] << 6);
            int i19 = i17 + 1;
            int i20 = i18 | iArr[str.charAt(i17)];
            int i21 = i12 + 1;
            bArr[i12] = (byte) (i20 >> 16);
            int i22 = i21 + 1;
            bArr[i21] = (byte) (i20 >> 8);
            int i23 = i22 + 1;
            bArr[i22] = (byte) i20;
            if (i4 <= 0 || (i13 = i13 + 1) != 19) {
                i7 = i19;
            } else {
                i7 = i19 + 2;
                i13 = 0;
            }
            i12 = i23;
        }
        if (i12 < i10) {
            int i24 = 0;
            while (i7 <= i6 - i8) {
                i5 |= IA[str.charAt(i7)] << (18 - (i24 * 6));
                i24++;
                i7++;
            }
            int i25 = 16;
            while (i12 < i10) {
                bArr[i12] = (byte) (i5 >> i25);
                i25 -= 8;
                i12++;
            }
        }
        return bArr;
    }
}
