package io.netty.util.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class StringUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final char CARRIAGE_RETURN = '\r';
    public static final char COMMA = ',';
    private static final int CSV_NUMBER_ESCAPE_CHARACTERS = 7;
    public static final char DOUBLE_QUOTE = '\"';
    public static final String EMPTY_STRING = "";
    public static final char LINE_FEED = '\n';
    private static final char PACKAGE_SEPARATOR_CHAR = '.';
    public static final char SPACE = ' ';
    public static final char TAB = '\t';
    public static final String NEWLINE = SystemPropertyUtil.get("line.separator", "\n");
    private static final String[] BYTE2HEX_PAD = new String[256];
    private static final String[] BYTE2HEX_NOPAD = new String[256];

    static {
        String str;
        int i4 = 0;
        while (true) {
            String[] strArr = BYTE2HEX_PAD;
            if (i4 >= strArr.length) {
                return;
            }
            String hexString = Integer.toHexString(i4);
            if (i4 > 15) {
                str = hexString;
            } else {
                str = '0' + hexString;
            }
            strArr[i4] = str;
            BYTE2HEX_NOPAD[i4] = hexString;
            i4++;
        }
    }

    private StringUtil() {
    }

    public static String byteToHexString(int i4) {
        return BYTE2HEX_NOPAD[i4 & 255];
    }

    public static String byteToHexStringPadded(int i4) {
        return BYTE2HEX_PAD[i4 & 255];
    }

    public static boolean commonSuffixOfLength(String str, String str2, int i4) {
        return str != null && str2 != null && i4 >= 0 && str.regionMatches(str.length() - i4, str2, str2.length() - i4, i4);
    }

    public static byte decodeHexByte(CharSequence charSequence, int i4) {
        int decodeHexNibble = decodeHexNibble(charSequence.charAt(i4));
        int decodeHexNibble2 = decodeHexNibble(charSequence.charAt(i4 + 1));
        if (decodeHexNibble == -1 || decodeHexNibble2 == -1) {
            throw new IllegalArgumentException(String.format("invalid hex byte '%s' at index %d of '%s'", charSequence.subSequence(i4, i4 + 2), Integer.valueOf(i4), charSequence));
        }
        return (byte) ((decodeHexNibble << 4) + decodeHexNibble2);
    }

    public static byte[] decodeHexDump(CharSequence charSequence, int i4, int i5) {
        if (i5 < 0 || (i5 & 1) != 0) {
            throw new IllegalArgumentException("length: " + i5);
        } else if (i5 == 0) {
            return EmptyArrays.EMPTY_BYTES;
        } else {
            byte[] bArr = new byte[i5 >>> 1];
            for (int i6 = 0; i6 < i5; i6 += 2) {
                bArr[i6 >>> 1] = decodeHexByte(charSequence, i4 + i6);
            }
            return bArr;
        }
    }

    public static int decodeHexNibble(char c4) {
        if (c4 < '0' || c4 > '9') {
            if (c4 < 'A' || c4 > 'F') {
                if (c4 < 'a' || c4 > 'f') {
                    return -1;
                }
                return c4 - 'W';
            }
            return c4 - '7';
        }
        return c4 - '0';
    }

    public static boolean endsWith(CharSequence charSequence, char c4) {
        int length = charSequence.length();
        return length > 0 && charSequence.charAt(length - 1) == c4;
    }

    public static CharSequence escapeCsv(CharSequence charSequence) {
        return escapeCsv(charSequence, false);
    }

    private static int indexOfFirstNonOwsChar(CharSequence charSequence, int i4) {
        int i5 = 0;
        while (i5 < i4 && isOws(charSequence.charAt(i5))) {
            i5++;
        }
        return i5;
    }

    private static int indexOfLastNonOwsChar(CharSequence charSequence, int i4, int i5) {
        int i6 = i5 - 1;
        while (i6 > i4 && isOws(charSequence.charAt(i6))) {
            i6--;
        }
        return i6;
    }

    public static int indexOfNonWhiteSpace(CharSequence charSequence, int i4) {
        while (i4 < charSequence.length()) {
            if (!Character.isWhitespace(charSequence.charAt(i4))) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    private static boolean isDoubleQuote(char c4) {
        return c4 == '\"';
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private static boolean isOws(char c4) {
        return c4 == ' ' || c4 == '\t';
    }

    public static boolean isSurrogate(char c4) {
        return c4 >= '\ud800' && c4 <= '\udfff';
    }

    public static int length(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    private static IllegalArgumentException newInvalidEscapedCsvFieldException(CharSequence charSequence, int i4) {
        return new IllegalArgumentException("invalid escaped CSV field: " + ((Object) charSequence) + " index: " + i4);
    }

    public static String simpleClassName(Object obj) {
        return obj == null ? "null_object" : simpleClassName(obj.getClass());
    }

    public static String substringAfter(String str, char c4) {
        int indexOf = str.indexOf(c4);
        if (indexOf >= 0) {
            return str.substring(indexOf + 1);
        }
        return null;
    }

    public static String toHexString(byte[] bArr) {
        return toHexString(bArr, 0, bArr.length);
    }

    public static String toHexStringPadded(byte[] bArr) {
        return toHexStringPadded(bArr, 0, bArr.length);
    }

    public static CharSequence trimOws(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return charSequence;
        }
        int indexOfFirstNonOwsChar = indexOfFirstNonOwsChar(charSequence, length);
        int indexOfLastNonOwsChar = indexOfLastNonOwsChar(charSequence, indexOfFirstNonOwsChar, length);
        return (indexOfFirstNonOwsChar == 0 && indexOfLastNonOwsChar == length + (-1)) ? charSequence : charSequence.subSequence(indexOfFirstNonOwsChar, indexOfLastNonOwsChar + 1);
    }

    public static CharSequence unescapeCsv(CharSequence charSequence) {
        int length = ((CharSequence) ObjectUtil.checkNotNull(charSequence, "value")).length();
        if (length == 0) {
            return charSequence;
        }
        int i4 = length - 1;
        boolean z3 = false;
        if (isDoubleQuote(charSequence.charAt(0)) && isDoubleQuote(charSequence.charAt(i4)) && length != 1) {
            z3 = true;
        }
        if (!z3) {
            validateCsvFormat(charSequence);
            return charSequence;
        }
        StringBuilder stringBuilder = InternalThreadLocalMap.get().stringBuilder();
        int i5 = 1;
        while (i5 < i4) {
            char charAt = charSequence.charAt(i5);
            if (charAt == '\"') {
                int i6 = i5 + 1;
                if (!isDoubleQuote(charSequence.charAt(i6)) || i6 == i4) {
                    throw newInvalidEscapedCsvFieldException(charSequence, i5);
                }
                i5 = i6;
            }
            stringBuilder.append(charAt);
            i5++;
        }
        return stringBuilder.toString();
    }

    public static List<CharSequence> unescapeCsvFields(CharSequence charSequence) {
        ArrayList arrayList = new ArrayList(2);
        StringBuilder stringBuilder = InternalThreadLocalMap.get().stringBuilder();
        int length = charSequence.length() - 1;
        int i4 = 0;
        boolean z3 = false;
        while (i4 <= length) {
            char charAt = charSequence.charAt(i4);
            if (!z3) {
                if (charAt != '\n' && charAt != '\r') {
                    if (charAt != '\"') {
                        if (charAt != ',') {
                            stringBuilder.append(charAt);
                        } else {
                            arrayList.add(stringBuilder.toString());
                            stringBuilder.setLength(0);
                        }
                    } else if (stringBuilder.length() == 0) {
                        z3 = true;
                    }
                }
                throw newInvalidEscapedCsvFieldException(charSequence, i4);
            } else if (charAt != '\"') {
                stringBuilder.append(charAt);
            } else if (i4 == length) {
                arrayList.add(stringBuilder.toString());
                return arrayList;
            } else {
                i4++;
                char charAt2 = charSequence.charAt(i4);
                if (charAt2 == '\"') {
                    stringBuilder.append('\"');
                } else if (charAt2 == ',') {
                    arrayList.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                    z3 = false;
                } else {
                    throw newInvalidEscapedCsvFieldException(charSequence, i4 - 1);
                }
            }
            i4++;
        }
        if (!z3) {
            arrayList.add(stringBuilder.toString());
            return arrayList;
        }
        throw newInvalidEscapedCsvFieldException(charSequence, length);
    }

    private static void validateCsvFormat(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = charSequence.charAt(i4);
            if (charAt == '\n' || charAt == '\r' || charAt == '\"' || charAt == ',') {
                throw newInvalidEscapedCsvFieldException(charSequence, i4);
            }
        }
    }

    public static <T extends Appendable> T byteToHexString(T t3, int i4) {
        try {
            t3.append(byteToHexString(i4));
        } catch (IOException e4) {
            PlatformDependent.throwException(e4);
        }
        return t3;
    }

    public static <T extends Appendable> T byteToHexStringPadded(T t3, int i4) {
        try {
            t3.append(byteToHexStringPadded(i4));
        } catch (IOException e4) {
            PlatformDependent.throwException(e4);
        }
        return t3;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.CharSequence escapeCsv(java.lang.CharSequence r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.StringUtil.escapeCsv(java.lang.CharSequence, boolean):java.lang.CharSequence");
    }

    public static String simpleClassName(Class<?> cls) {
        String name = ((Class) ObjectUtil.checkNotNull(cls, "clazz")).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf > -1 ? name.substring(lastIndexOf + 1) : name;
    }

    public static String toHexString(byte[] bArr, int i4, int i5) {
        return ((StringBuilder) toHexString(new StringBuilder(i5 << 1), bArr, i4, i5)).toString();
    }

    public static String toHexStringPadded(byte[] bArr, int i4, int i5) {
        return ((StringBuilder) toHexStringPadded(new StringBuilder(i5 << 1), bArr, i4, i5)).toString();
    }

    public static <T extends Appendable> T toHexString(T t3, byte[] bArr) {
        return (T) toHexString(t3, bArr, 0, bArr.length);
    }

    public static <T extends Appendable> T toHexStringPadded(T t3, byte[] bArr) {
        return (T) toHexStringPadded(t3, bArr, 0, bArr.length);
    }

    public static <T extends Appendable> T toHexString(T t3, byte[] bArr, int i4, int i5) {
        if (i5 == 0) {
            return t3;
        }
        int i6 = i5 + i4;
        int i7 = i6 - 1;
        while (i4 < i7 && bArr[i4] == 0) {
            i4++;
        }
        int i8 = i4 + 1;
        byteToHexString(t3, bArr[i4]);
        toHexStringPadded(t3, bArr, i8, i6 - i8);
        return t3;
    }

    public static <T extends Appendable> T toHexStringPadded(T t3, byte[] bArr, int i4, int i5) {
        int i6 = i5 + i4;
        while (i4 < i6) {
            byteToHexStringPadded(t3, bArr[i4]);
            i4++;
        }
        return t3;
    }

    public static byte[] decodeHexDump(CharSequence charSequence) {
        return decodeHexDump(charSequence, 0, charSequence.length());
    }
}
