package io.netty.util.internal;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class StringUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final char CARRIAGE_RETURN = '\r';
    public static final char COMMA = ',';
    private static final int CSV_NUMBER_ESCAPE_CHARACTERS = 7;
    public static final char DOUBLE_QUOTE = '\"';
    public static final String EMPTY_STRING = "";
    public static final char LINE_FEED = '\n';
    private static final char PACKAGE_SEPARATOR_CHAR = '.';
    public static final char TAB = '\t';
    public static final String NEWLINE = System.getProperty("line.separator");
    private static final String[] BYTE2HEX_PAD = new String[256];
    private static final String[] BYTE2HEX_NOPAD = new String[256];

    static {
        int i = 0;
        while (i < 10) {
            BYTE2HEX_PAD[i] = "0" + i;
            BYTE2HEX_NOPAD[i] = String.valueOf(i);
            i++;
        }
        while (i < 16) {
            char c = (char) ((i + 97) - 10);
            BYTE2HEX_PAD[i] = "0" + c;
            BYTE2HEX_NOPAD[i] = String.valueOf(c);
            i++;
        }
        while (true) {
            String[] strArr = BYTE2HEX_PAD;
            if (i >= strArr.length) {
                return;
            }
            String hexString = Integer.toHexString(i);
            strArr[i] = hexString;
            BYTE2HEX_NOPAD[i] = hexString;
            i++;
        }
    }

    private StringUtil() {
    }

    public static String byteToHexString(int i) {
        return BYTE2HEX_NOPAD[i & 255];
    }

    public static String byteToHexStringPadded(int i) {
        return BYTE2HEX_PAD[i & 255];
    }

    public static boolean commonSuffixOfLength(String str, String str2, int i) {
        return str != null && str2 != null && i >= 0 && str.regionMatches(str.length() - i, str2, str2.length() - i, i);
    }

    public static boolean endsWith(CharSequence charSequence, char c) {
        int length = charSequence.length();
        return length > 0 && charSequence.charAt(length - 1) == c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
        if (r9 != ',') goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.CharSequence escapeCsv(java.lang.CharSequence r13) {
        /*
            java.lang.String r0 = "value"
            java.lang.Object r0 = io.netty.util.internal.ObjectUtil.checkNotNull(r13, r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto Lf
            return r13
        Lf:
            int r1 = r0 + (-1)
            r2 = 0
            char r3 = r13.charAt(r2)
            boolean r3 = isDoubleQuote(r3)
            r4 = 1
            if (r3 == 0) goto L2b
            char r3 = r13.charAt(r1)
            boolean r3 = isDoubleQuote(r3)
            if (r3 == 0) goto L2b
            if (r0 == r4) goto L2b
            r3 = 1
            goto L2c
        L2b:
            r3 = 0
        L2c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r6 = r0 + 7
            r5.<init>(r6)
            r6 = 34
            r5.append(r6)
            r7 = 0
            r8 = 0
        L3a:
            if (r2 >= r0) goto L7f
            char r9 = r13.charAt(r2)
            r10 = 10
            if (r9 == r10) goto L78
            r10 = 13
            if (r9 == r10) goto L78
            if (r9 == r6) goto L4f
            r10 = 44
            if (r9 == r10) goto L78
            goto L79
        L4f:
            if (r2 == 0) goto L73
            if (r2 != r1) goto L54
            goto L73
        L54:
            int r10 = r2 + 1
            char r11 = r13.charAt(r10)
            boolean r11 = isDoubleQuote(r11)
            int r12 = r2 + (-1)
            char r12 = r13.charAt(r12)
            boolean r12 = isDoubleQuote(r12)
            if (r12 != 0) goto L79
            if (r11 == 0) goto L6e
            if (r10 != r1) goto L79
        L6e:
            r5.append(r6)
            r7 = 1
            goto L79
        L73:
            if (r3 != 0) goto L7c
            r5.append(r6)
        L78:
            r8 = 1
        L79:
            r5.append(r9)
        L7c:
            int r2 = r2 + 1
            goto L3a
        L7f:
            if (r7 != 0) goto L85
            if (r8 == 0) goto L89
            if (r3 != 0) goto L89
        L85:
            r5.append(r6)
            r13 = r5
        L89:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.StringUtil.escapeCsv(java.lang.CharSequence):java.lang.CharSequence");
    }

    private static boolean isDoubleQuote(char c) {
        return c == '\"';
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isSurrogate(char c) {
        return c >= 55296 && c <= 57343;
    }

    public static int length(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    private static IllegalArgumentException newInvalidEscapedCsvFieldException(CharSequence charSequence, int i) {
        return new IllegalArgumentException("invalid escaped CSV field: " + ((Object) charSequence) + " index: " + i);
    }

    public static String simpleClassName(Object obj) {
        return obj == null ? "null_object" : simpleClassName(obj.getClass());
    }

    public static String substringAfter(String str, char c) {
        int indexOf = str.indexOf(c);
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

    public static CharSequence unescapeCsv(CharSequence charSequence) {
        int length = ((CharSequence) ObjectUtil.checkNotNull(charSequence, DomainCampaignEx.LOOPBACK_VALUE)).length();
        if (length == 0) {
            return charSequence;
        }
        int i = length - 1;
        boolean z = false;
        if (isDoubleQuote(charSequence.charAt(0)) && isDoubleQuote(charSequence.charAt(i)) && length != 1) {
            z = true;
        }
        if (!z) {
            validateCsvFormat(charSequence);
            return charSequence;
        }
        StringBuilder stringBuilder = InternalThreadLocalMap.get().stringBuilder();
        int i2 = 1;
        while (i2 < i) {
            char charAt = charSequence.charAt(i2);
            if (charAt == '\"') {
                int i3 = i2 + 1;
                if (!isDoubleQuote(charSequence.charAt(i3)) || i3 == i) {
                    throw newInvalidEscapedCsvFieldException(charSequence, i2);
                }
                i2 = i3;
            }
            stringBuilder.append(charAt);
            i2++;
        }
        return stringBuilder.toString();
    }

    public static List<CharSequence> unescapeCsvFields(CharSequence charSequence) {
        ArrayList arrayList = new ArrayList(2);
        StringBuilder stringBuilder = InternalThreadLocalMap.get().stringBuilder();
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            char charAt = charSequence.charAt(i);
            if (!z) {
                if (charAt != '\n' && charAt != '\r') {
                    if (charAt != '\"') {
                        if (charAt != ',') {
                            stringBuilder.append(charAt);
                        } else {
                            arrayList.add(stringBuilder.toString());
                            stringBuilder.setLength(0);
                        }
                    } else if (stringBuilder.length() == 0) {
                        z = true;
                    }
                }
                throw newInvalidEscapedCsvFieldException(charSequence, i);
            } else if (charAt != '\"') {
                stringBuilder.append(charAt);
            } else if (i == length) {
                arrayList.add(stringBuilder.toString());
                return arrayList;
            } else {
                i++;
                char charAt2 = charSequence.charAt(i);
                if (charAt2 == '\"') {
                    stringBuilder.append('\"');
                } else if (charAt2 == ',') {
                    arrayList.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                    z = false;
                } else {
                    throw newInvalidEscapedCsvFieldException(charSequence, i - 1);
                }
            }
            i++;
        }
        if (!z) {
            arrayList.add(stringBuilder.toString());
            return arrayList;
        }
        throw newInvalidEscapedCsvFieldException(charSequence, length);
    }

    private static void validateCsvFormat(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (charAt == '\n' || charAt == '\r' || charAt == '\"' || charAt == ',') {
                throw newInvalidEscapedCsvFieldException(charSequence, i);
            }
        }
    }

    public static <T extends Appendable> T byteToHexString(T t, int i) {
        try {
            t.append(byteToHexString(i));
        } catch (IOException e) {
            PlatformDependent.throwException(e);
        }
        return t;
    }

    public static <T extends Appendable> T byteToHexStringPadded(T t, int i) {
        try {
            t.append(byteToHexStringPadded(i));
        } catch (IOException e) {
            PlatformDependent.throwException(e);
        }
        return t;
    }

    public static String simpleClassName(Class<?> cls) {
        String name = ((Class) ObjectUtil.checkNotNull(cls, "clazz")).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf > -1 ? name.substring(lastIndexOf + 1) : name;
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        return ((StringBuilder) toHexString(new StringBuilder(i2 << 1), bArr, i, i2)).toString();
    }

    public static String toHexStringPadded(byte[] bArr, int i, int i2) {
        return ((StringBuilder) toHexStringPadded(new StringBuilder(i2 << 1), bArr, i, i2)).toString();
    }

    public static <T extends Appendable> T toHexString(T t, byte[] bArr) {
        return (T) toHexString(t, bArr, 0, bArr.length);
    }

    public static <T extends Appendable> T toHexStringPadded(T t, byte[] bArr) {
        return (T) toHexStringPadded(t, bArr, 0, bArr.length);
    }

    public static <T extends Appendable> T toHexString(T t, byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return t;
        }
        int i3 = i2 + i;
        int i4 = i3 - 1;
        while (i < i4 && bArr[i] == 0) {
            i++;
        }
        int i5 = i + 1;
        byteToHexString(t, bArr[i]);
        toHexStringPadded(t, bArr, i5, i3 - i5);
        return t;
    }

    public static <T extends Appendable> T toHexStringPadded(T t, byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            byteToHexStringPadded(t, bArr[i]);
            i++;
        }
        return t;
    }
}
