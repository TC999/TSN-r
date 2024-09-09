package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MessageFormatter.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    static final char f61749a = '{';

    /* renamed from: b  reason: collision with root package name */
    static final char f61750b = '}';

    /* renamed from: c  reason: collision with root package name */
    static final String f61751c = "{}";

    /* renamed from: d  reason: collision with root package name */
    private static final char f61752d = '\\';

    public static final c a(String str, Object[] objArr) {
        Throwable k4 = k(objArr);
        if (k4 != null) {
            objArr = s(objArr);
        }
        return b(str, objArr, k4);
    }

    public static final c b(String str, Object[] objArr, Throwable th) {
        int i4;
        if (str == null) {
            return new c(null, objArr, th);
        }
        if (objArr == null) {
            return new c(str);
        }
        StringBuilder sb = new StringBuilder(str.length() + 50);
        int i5 = 0;
        int i6 = 0;
        while (i5 < objArr.length) {
            int indexOf = str.indexOf("{}", i6);
            if (indexOf == -1) {
                if (i6 == 0) {
                    return new c(str, objArr, th);
                }
                sb.append((CharSequence) str, i6, str.length());
                return new c(sb.toString(), objArr, th);
            }
            if (n(str, indexOf)) {
                if (!m(str, indexOf)) {
                    i5--;
                    sb.append((CharSequence) str, i6, indexOf - 1);
                    sb.append('{');
                    i4 = indexOf + 1;
                    i6 = i4;
                    i5++;
                } else {
                    sb.append((CharSequence) str, i6, indexOf - 1);
                    f(sb, objArr[i5], new HashMap());
                }
            } else {
                sb.append((CharSequence) str, i6, indexOf);
                f(sb, objArr[i5], new HashMap());
            }
            i4 = indexOf + 2;
            i6 = i4;
            i5++;
        }
        sb.append((CharSequence) str, i6, str.length());
        return new c(sb.toString(), objArr, th);
    }

    private static void c(StringBuilder sb, boolean[] zArr) {
        sb.append('[');
        int length = zArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            sb.append(zArr[i4]);
            if (i4 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void d(StringBuilder sb, byte[] bArr) {
        sb.append('[');
        int length = bArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            sb.append((int) bArr[i4]);
            if (i4 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void e(StringBuilder sb, char[] cArr) {
        sb.append('[');
        int length = cArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            sb.append(cArr[i4]);
            if (i4 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void f(StringBuilder sb, Object obj, Map<Object[], Object> map) {
        if (obj == null) {
            sb.append("null");
        } else if (!obj.getClass().isArray()) {
            q(sb, obj);
        } else if (obj instanceof boolean[]) {
            c(sb, (boolean[]) obj);
        } else if (obj instanceof byte[]) {
            d(sb, (byte[]) obj);
        } else if (obj instanceof char[]) {
            e(sb, (char[]) obj);
        } else if (obj instanceof short[]) {
            r(sb, (short[]) obj);
        } else if (obj instanceof int[]) {
            l(sb, (int[]) obj);
        } else if (obj instanceof long[]) {
            o(sb, (long[]) obj);
        } else if (obj instanceof float[]) {
            h(sb, (float[]) obj);
        } else if (obj instanceof double[]) {
            g(sb, (double[]) obj);
        } else {
            p(sb, (Object[]) obj, map);
        }
    }

    private static void g(StringBuilder sb, double[] dArr) {
        sb.append('[');
        int length = dArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            sb.append(dArr[i4]);
            if (i4 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void h(StringBuilder sb, float[] fArr) {
        sb.append('[');
        int length = fArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            sb.append(fArr[i4]);
            if (i4 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    public static final c i(String str, Object obj) {
        return a(str, new Object[]{obj});
    }

    public static final c j(String str, Object obj, Object obj2) {
        return a(str, new Object[]{obj, obj2});
    }

    static final Throwable k(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                return (Throwable) obj;
            }
        }
        return null;
    }

    private static void l(StringBuilder sb, int[] iArr) {
        sb.append('[');
        int length = iArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            sb.append(iArr[i4]);
            if (i4 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    static final boolean m(String str, int i4) {
        return i4 >= 2 && str.charAt(i4 - 2) == '\\';
    }

    static final boolean n(String str, int i4) {
        return i4 != 0 && str.charAt(i4 - 1) == '\\';
    }

    private static void o(StringBuilder sb, long[] jArr) {
        sb.append('[');
        int length = jArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            sb.append(jArr[i4]);
            if (i4 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void p(StringBuilder sb, Object[] objArr, Map<Object[], Object> map) {
        sb.append('[');
        if (!map.containsKey(objArr)) {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i4 = 0; i4 < length; i4++) {
                f(sb, objArr[i4], map);
                if (i4 != length - 1) {
                    sb.append(", ");
                }
            }
            map.remove(objArr);
        } else {
            sb.append("...");
        }
        sb.append(']');
    }

    private static void q(StringBuilder sb, Object obj) {
        try {
            sb.append(obj.toString());
        } catch (Throwable th) {
            j.d("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]", th);
            sb.append("[FAILED toString()]");
        }
    }

    private static void r(StringBuilder sb, short[] sArr) {
        sb.append('[');
        int length = sArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            sb.append((int) sArr[i4]);
            if (i4 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static Object[] s(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            int length = objArr.length - 1;
            Object[] objArr2 = new Object[length];
            System.arraycopy(objArr, 0, objArr2, 0, length);
            return objArr2;
        }
        throw new IllegalStateException("non-sensical empty or null argument array");
    }
}
