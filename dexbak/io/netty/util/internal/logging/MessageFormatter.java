package io.netty.util.internal.logging;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class MessageFormatter {
    static final char DELIM_START = '{';
    static final char DELIM_STOP = '}';
    static final String DELIM_STR = "{}";
    private static final char ESCAPE_CHAR = '\\';

    private MessageFormatter() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FormattingTuple arrayFormat(String str, Object[] objArr) {
        int i;
        Throwable throwableCandidate = getThrowableCandidate(objArr);
        if (str == null) {
            return new FormattingTuple(null, objArr, throwableCandidate);
        }
        if (objArr == null) {
            return new FormattingTuple(str);
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + 50);
        int i2 = 0;
        int i3 = 0;
        while (i2 < objArr.length) {
            int indexOf = str.indexOf(DELIM_STR, i3);
            if (indexOf == -1) {
                if (i3 == 0) {
                    return new FormattingTuple(str, objArr, throwableCandidate);
                }
                stringBuffer.append(str.substring(i3, str.length()));
                return new FormattingTuple(stringBuffer.toString(), objArr, throwableCandidate);
            }
            if (isEscapedDelimeter(str, indexOf)) {
                if (!isDoubleEscaped(str, indexOf)) {
                    i2--;
                    stringBuffer.append(str.substring(i3, indexOf - 1));
                    stringBuffer.append(DELIM_START);
                    i = indexOf + 1;
                    i3 = i;
                    i2++;
                } else {
                    stringBuffer.append(str.substring(i3, indexOf - 1));
                    deeplyAppendParameter(stringBuffer, objArr[i2], new HashMap());
                }
            } else {
                stringBuffer.append(str.substring(i3, indexOf));
                deeplyAppendParameter(stringBuffer, objArr[i2], new HashMap());
            }
            i = indexOf + 2;
            i3 = i;
            i2++;
        }
        stringBuffer.append(str.substring(i3, str.length()));
        if (i2 < objArr.length - 1) {
            return new FormattingTuple(stringBuffer.toString(), objArr, throwableCandidate);
        }
        return new FormattingTuple(stringBuffer.toString(), objArr, null);
    }

    private static void booleanArrayAppend(StringBuffer stringBuffer, boolean[] zArr) {
        stringBuffer.append('[');
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(zArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void byteArrayAppend(StringBuffer stringBuffer, byte[] bArr) {
        stringBuffer.append('[');
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append((int) bArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void charArrayAppend(StringBuffer stringBuffer, char[] cArr) {
        stringBuffer.append('[');
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(cArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void deeplyAppendParameter(StringBuffer stringBuffer, Object obj, Map<Object[], Void> map) {
        if (obj == null) {
            stringBuffer.append("null");
        } else if (!obj.getClass().isArray()) {
            safeObjectAppend(stringBuffer, obj);
        } else if (obj instanceof boolean[]) {
            booleanArrayAppend(stringBuffer, (boolean[]) obj);
        } else if (obj instanceof byte[]) {
            byteArrayAppend(stringBuffer, (byte[]) obj);
        } else if (obj instanceof char[]) {
            charArrayAppend(stringBuffer, (char[]) obj);
        } else if (obj instanceof short[]) {
            shortArrayAppend(stringBuffer, (short[]) obj);
        } else if (obj instanceof int[]) {
            intArrayAppend(stringBuffer, (int[]) obj);
        } else if (obj instanceof long[]) {
            longArrayAppend(stringBuffer, (long[]) obj);
        } else if (obj instanceof float[]) {
            floatArrayAppend(stringBuffer, (float[]) obj);
        } else if (obj instanceof double[]) {
            doubleArrayAppend(stringBuffer, (double[]) obj);
        } else {
            objectArrayAppend(stringBuffer, (Object[]) obj, map);
        }
    }

    private static void doubleArrayAppend(StringBuffer stringBuffer, double[] dArr) {
        stringBuffer.append('[');
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(dArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void floatArrayAppend(StringBuffer stringBuffer, float[] fArr) {
        stringBuffer.append('[');
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(fArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FormattingTuple format(String str, Object obj) {
        return arrayFormat(str, new Object[]{obj});
    }

    static Throwable getThrowableCandidate(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                return (Throwable) obj;
            }
        }
        return null;
    }

    private static void intArrayAppend(StringBuffer stringBuffer, int[] iArr) {
        stringBuffer.append('[');
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(iArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    static boolean isDoubleEscaped(String str, int i) {
        return i >= 2 && str.charAt(i - 2) == '\\';
    }

    static boolean isEscapedDelimeter(String str, int i) {
        return i != 0 && str.charAt(i - 1) == '\\';
    }

    private static void longArrayAppend(StringBuffer stringBuffer, long[] jArr) {
        stringBuffer.append('[');
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(jArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void objectArrayAppend(StringBuffer stringBuffer, Object[] objArr, Map<Object[], Void> map) {
        stringBuffer.append('[');
        if (!map.containsKey(objArr)) {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                deeplyAppendParameter(stringBuffer, objArr[i], map);
                if (i != length - 1) {
                    stringBuffer.append(", ");
                }
            }
            map.remove(objArr);
        } else {
            stringBuffer.append("...");
        }
        stringBuffer.append(']');
    }

    private static void safeObjectAppend(StringBuffer stringBuffer, Object obj) {
        try {
            stringBuffer.append(obj.toString());
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            printStream.println("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + ']');
            th.printStackTrace();
            stringBuffer.append("[FAILED toString()]");
        }
    }

    private static void shortArrayAppend(StringBuffer stringBuffer, short[] sArr) {
        stringBuffer.append('[');
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append((int) sArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FormattingTuple format(String str, Object obj, Object obj2) {
        return arrayFormat(str, new Object[]{obj, obj2});
    }
}
