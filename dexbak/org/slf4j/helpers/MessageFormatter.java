package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;

/* renamed from: org.slf4j.helpers.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class MessageFormatter {

    /* renamed from: a */
    static final char f44349a = '{';

    /* renamed from: b */
    static final char f44350b = '}';

    /* renamed from: c */
    static final String f44351c = "{}";

    /* renamed from: d */
    private static final char f44352d = '\\';

    /* renamed from: a */
    public static final FormattingTuple m2602a(String str, Object[] objArr) {
        Throwable m2592k = m2592k(objArr);
        if (m2592k != null) {
            objArr = m2584s(objArr);
        }
        return m2601b(str, objArr, m2592k);
    }

    /* renamed from: b */
    public static final FormattingTuple m2601b(String str, Object[] objArr, Throwable th) {
        int i;
        if (str == null) {
            return new FormattingTuple(null, objArr, th);
        }
        if (objArr == null) {
            return new FormattingTuple(str);
        }
        StringBuilder sb = new StringBuilder(str.length() + 50);
        int i2 = 0;
        int i3 = 0;
        while (i2 < objArr.length) {
            int indexOf = str.indexOf(f44351c, i3);
            if (indexOf == -1) {
                if (i3 == 0) {
                    return new FormattingTuple(str, objArr, th);
                }
                sb.append((CharSequence) str, i3, str.length());
                return new FormattingTuple(sb.toString(), objArr, th);
            }
            if (m2589n(str, indexOf)) {
                if (!m2590m(str, indexOf)) {
                    i2--;
                    sb.append((CharSequence) str, i3, indexOf - 1);
                    sb.append(f44349a);
                    i = indexOf + 1;
                    i3 = i;
                    i2++;
                } else {
                    sb.append((CharSequence) str, i3, indexOf - 1);
                    m2597f(sb, objArr[i2], new HashMap());
                }
            } else {
                sb.append((CharSequence) str, i3, indexOf);
                m2597f(sb, objArr[i2], new HashMap());
            }
            i = indexOf + 2;
            i3 = i;
            i2++;
        }
        sb.append((CharSequence) str, i3, str.length());
        return new FormattingTuple(sb.toString(), objArr, th);
    }

    /* renamed from: c */
    private static void m2600c(StringBuilder sb, boolean[] zArr) {
        sb.append('[');
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(zArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: d */
    private static void m2599d(StringBuilder sb, byte[] bArr) {
        sb.append('[');
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append((int) bArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: e */
    private static void m2598e(StringBuilder sb, char[] cArr) {
        sb.append('[');
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(cArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: f */
    private static void m2597f(StringBuilder sb, Object obj, Map<Object[], Object> map) {
        if (obj == null) {
            sb.append("null");
        } else if (!obj.getClass().isArray()) {
            m2586q(sb, obj);
        } else if (obj instanceof boolean[]) {
            m2600c(sb, (boolean[]) obj);
        } else if (obj instanceof byte[]) {
            m2599d(sb, (byte[]) obj);
        } else if (obj instanceof char[]) {
            m2598e(sb, (char[]) obj);
        } else if (obj instanceof short[]) {
            m2585r(sb, (short[]) obj);
        } else if (obj instanceof int[]) {
            m2591l(sb, (int[]) obj);
        } else if (obj instanceof long[]) {
            m2588o(sb, (long[]) obj);
        } else if (obj instanceof float[]) {
            m2595h(sb, (float[]) obj);
        } else if (obj instanceof double[]) {
            m2596g(sb, (double[]) obj);
        } else {
            m2587p(sb, (Object[]) obj, map);
        }
    }

    /* renamed from: g */
    private static void m2596g(StringBuilder sb, double[] dArr) {
        sb.append('[');
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(dArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: h */
    private static void m2595h(StringBuilder sb, float[] fArr) {
        sb.append('[');
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(fArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: i */
    public static final FormattingTuple m2594i(String str, Object obj) {
        return m2602a(str, new Object[]{obj});
    }

    /* renamed from: j */
    public static final FormattingTuple m2593j(String str, Object obj, Object obj2) {
        return m2602a(str, new Object[]{obj, obj2});
    }

    /* renamed from: k */
    static final Throwable m2592k(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                return (Throwable) obj;
            }
        }
        return null;
    }

    /* renamed from: l */
    private static void m2591l(StringBuilder sb, int[] iArr) {
        sb.append('[');
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(iArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: m */
    static final boolean m2590m(String str, int i) {
        return i >= 2 && str.charAt(i - 2) == '\\';
    }

    /* renamed from: n */
    static final boolean m2589n(String str, int i) {
        return i != 0 && str.charAt(i - 1) == '\\';
    }

    /* renamed from: o */
    private static void m2588o(StringBuilder sb, long[] jArr) {
        sb.append('[');
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(jArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: p */
    private static void m2587p(StringBuilder sb, Object[] objArr, Map<Object[], Object> map) {
        sb.append('[');
        if (!map.containsKey(objArr)) {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                m2597f(sb, objArr[i], map);
                if (i != length - 1) {
                    sb.append(", ");
                }
            }
            map.remove(objArr);
        } else {
            sb.append("...");
        }
        sb.append(']');
    }

    /* renamed from: q */
    private static void m2586q(StringBuilder sb, Object obj) {
        try {
            sb.append(obj.toString());
        } catch (Throwable th) {
            C15428j.m2565d("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]", th);
            sb.append("[FAILED toString()]");
        }
    }

    /* renamed from: r */
    private static void m2585r(StringBuilder sb, short[] sArr) {
        sb.append('[');
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            sb.append((int) sArr[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    /* renamed from: s */
    private static Object[] m2584s(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            int length = objArr.length - 1;
            Object[] objArr2 = new Object[length];
            System.arraycopy(objArr, 0, objArr2, 0, length);
            return objArr2;
        }
        throw new IllegalStateException("non-sensical empty or null argument array");
    }
}
