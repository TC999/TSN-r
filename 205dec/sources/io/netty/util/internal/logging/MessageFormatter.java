package io.netty.util.internal.logging;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class MessageFormatter {
    private static final String DELIM_STR = "{}";
    private static final char ESCAPE_CHAR = '\\';

    private MessageFormatter() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FormattingTuple arrayFormat(String str, Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            int length = objArr.length - 1;
            Object obj = objArr[length];
            Throwable th = obj instanceof Throwable ? (Throwable) obj : null;
            if (str == null) {
                return new FormattingTuple(null, th);
            }
            int indexOf = str.indexOf("{}");
            if (indexOf == -1) {
                return new FormattingTuple(str, th);
            }
            StringBuilder sb = new StringBuilder(str.length() + 50);
            int i4 = 0;
            int i5 = 0;
            do {
                boolean z3 = indexOf == 0 || str.charAt(indexOf + (-1)) != '\\';
                if (z3) {
                    sb.append((CharSequence) str, i4, indexOf);
                } else {
                    sb.append((CharSequence) str, i4, indexOf - 1);
                    z3 = indexOf >= 2 && str.charAt(indexOf + (-2)) == '\\';
                }
                i4 = indexOf + 2;
                if (z3) {
                    deeplyAppendParameter(sb, objArr[i5], null);
                    i5++;
                    if (i5 > length) {
                        break;
                    }
                } else {
                    sb.append("{}");
                }
                indexOf = str.indexOf("{}", i4);
            } while (indexOf != -1);
            sb.append((CharSequence) str, i4, str.length());
            return new FormattingTuple(sb.toString(), i5 <= length ? th : null);
        }
        return new FormattingTuple(str, null);
    }

    private static void booleanArrayAppend(StringBuilder sb, boolean[] zArr) {
        if (zArr.length == 0) {
            return;
        }
        sb.append(zArr[0]);
        for (int i4 = 1; i4 < zArr.length; i4++) {
            sb.append(", ");
            sb.append(zArr[i4]);
        }
    }

    private static void byteArrayAppend(StringBuilder sb, byte[] bArr) {
        if (bArr.length == 0) {
            return;
        }
        sb.append((int) bArr[0]);
        for (int i4 = 1; i4 < bArr.length; i4++) {
            sb.append(", ");
            sb.append((int) bArr[i4]);
        }
    }

    private static void charArrayAppend(StringBuilder sb, char[] cArr) {
        if (cArr.length == 0) {
            return;
        }
        sb.append(cArr[0]);
        for (int i4 = 1; i4 < cArr.length; i4++) {
            sb.append(", ");
            sb.append(cArr[i4]);
        }
    }

    private static void deeplyAppendParameter(StringBuilder sb, Object obj, Set<Object[]> set) {
        if (obj == null) {
            sb.append("null");
            return;
        }
        Class<?> cls = obj.getClass();
        if (!cls.isArray()) {
            if (Number.class.isAssignableFrom(cls)) {
                if (cls == Long.class) {
                    sb.append(((Long) obj).longValue());
                    return;
                } else if (cls != Integer.class && cls != Short.class && cls != Byte.class) {
                    if (cls == Double.class) {
                        sb.append(((Double) obj).doubleValue());
                        return;
                    } else if (cls == Float.class) {
                        sb.append(((Float) obj).floatValue());
                        return;
                    } else {
                        safeObjectAppend(sb, obj);
                        return;
                    }
                } else {
                    sb.append(((Number) obj).intValue());
                    return;
                }
            }
            safeObjectAppend(sb, obj);
            return;
        }
        sb.append('[');
        if (cls == boolean[].class) {
            booleanArrayAppend(sb, (boolean[]) obj);
        } else if (cls == byte[].class) {
            byteArrayAppend(sb, (byte[]) obj);
        } else if (cls == char[].class) {
            charArrayAppend(sb, (char[]) obj);
        } else if (cls == short[].class) {
            shortArrayAppend(sb, (short[]) obj);
        } else if (cls == int[].class) {
            intArrayAppend(sb, (int[]) obj);
        } else if (cls == long[].class) {
            longArrayAppend(sb, (long[]) obj);
        } else if (cls == float[].class) {
            floatArrayAppend(sb, (float[]) obj);
        } else if (cls == double[].class) {
            doubleArrayAppend(sb, (double[]) obj);
        } else {
            objectArrayAppend(sb, (Object[]) obj, set);
        }
        sb.append(']');
    }

    private static void doubleArrayAppend(StringBuilder sb, double[] dArr) {
        if (dArr.length == 0) {
            return;
        }
        sb.append(dArr[0]);
        for (int i4 = 1; i4 < dArr.length; i4++) {
            sb.append(", ");
            sb.append(dArr[i4]);
        }
    }

    private static void floatArrayAppend(StringBuilder sb, float[] fArr) {
        if (fArr.length == 0) {
            return;
        }
        sb.append(fArr[0]);
        for (int i4 = 1; i4 < fArr.length; i4++) {
            sb.append(", ");
            sb.append(fArr[i4]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FormattingTuple format(String str, Object obj) {
        return arrayFormat(str, new Object[]{obj});
    }

    private static void intArrayAppend(StringBuilder sb, int[] iArr) {
        if (iArr.length == 0) {
            return;
        }
        sb.append(iArr[0]);
        for (int i4 = 1; i4 < iArr.length; i4++) {
            sb.append(", ");
            sb.append(iArr[i4]);
        }
    }

    private static void longArrayAppend(StringBuilder sb, long[] jArr) {
        if (jArr.length == 0) {
            return;
        }
        sb.append(jArr[0]);
        for (int i4 = 1; i4 < jArr.length; i4++) {
            sb.append(", ");
            sb.append(jArr[i4]);
        }
    }

    private static void objectArrayAppend(StringBuilder sb, Object[] objArr, Set<Object[]> set) {
        if (objArr.length == 0) {
            return;
        }
        if (set == null) {
            set = new HashSet<>(objArr.length);
        }
        if (set.add(objArr)) {
            deeplyAppendParameter(sb, objArr[0], set);
            for (int i4 = 1; i4 < objArr.length; i4++) {
                sb.append(", ");
                deeplyAppendParameter(sb, objArr[i4], set);
            }
            set.remove(objArr);
            return;
        }
        sb.append("...");
    }

    private static void safeObjectAppend(StringBuilder sb, Object obj) {
        try {
            sb.append(obj.toString());
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            printStream.println("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + ']');
            th.printStackTrace();
            sb.append("[FAILED toString()]");
        }
    }

    private static void shortArrayAppend(StringBuilder sb, short[] sArr) {
        if (sArr.length == 0) {
            return;
        }
        sb.append((int) sArr[0]);
        for (int i4 = 1; i4 < sArr.length; i4++) {
            sb.append(", ");
            sb.append((int) sArr[i4]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FormattingTuple format(String str, Object obj, Object obj2) {
        return arrayFormat(str, new Object[]{obj, obj2});
    }
}
