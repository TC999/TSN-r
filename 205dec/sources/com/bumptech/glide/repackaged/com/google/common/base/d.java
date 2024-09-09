package com.bumptech.glide.repackaged.com.google.common.base;

/* compiled from: Preconditions.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class d {
    private static String a(int i4, int i5, String str) {
        if (i4 < 0) {
            return p("%s (%s) must not be negative", str, Integer.valueOf(i4));
        }
        if (i5 >= 0) {
            return p("%s (%s) must be less than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
        }
        throw new IllegalArgumentException("negative size: " + i5);
    }

    private static String b(int i4, int i5, String str) {
        if (i4 < 0) {
            return p("%s (%s) must not be negative", str, Integer.valueOf(i4));
        }
        if (i5 >= 0) {
            return p("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
        }
        throw new IllegalArgumentException("negative size: " + i5);
    }

    private static String c(int i4, int i5, int i6) {
        if (i4 < 0 || i4 > i6) {
            return b(i4, i6, "start index");
        }
        return (i5 < 0 || i5 > i6) ? b(i5, i6, "end index") : p("end index (%s) must not be less than start index (%s)", Integer.valueOf(i5), Integer.valueOf(i4));
    }

    public static void d(boolean z3) {
        if (!z3) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z3, Object obj) {
        if (!z3) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z3, String str, Object... objArr) {
        if (!z3) {
            throw new IllegalArgumentException(p(str, objArr));
        }
    }

    public static int g(int i4, int i5) {
        return h(i4, i5, "index");
    }

    public static int h(int i4, int i5, String str) {
        if (i4 < 0 || i4 >= i5) {
            throw new IndexOutOfBoundsException(a(i4, i5, str));
        }
        return i4;
    }

    public static <T> T i(T t3) {
        t3.getClass();
        return t3;
    }

    public static <T> T j(T t3, Object obj) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int k(int i4, int i5) {
        return l(i4, i5, "index");
    }

    public static int l(int i4, int i5, String str) {
        if (i4 < 0 || i4 > i5) {
            throw new IndexOutOfBoundsException(b(i4, i5, str));
        }
        return i4;
    }

    public static void m(int i4, int i5, int i6) {
        if (i4 < 0 || i5 < i4 || i5 > i6) {
            throw new IndexOutOfBoundsException(c(i4, i5, i6));
        }
    }

    public static void n(boolean z3) {
        if (!z3) {
            throw new IllegalStateException();
        }
    }

    public static void o(boolean z3, Object obj) {
        if (!z3) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    static String p(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i4 = 0;
        int i5 = 0;
        while (i4 < objArr.length && (indexOf = valueOf.indexOf("%s", i5)) != -1) {
            sb.append(valueOf.substring(i5, indexOf));
            sb.append(objArr[i4]);
            i5 = indexOf + 2;
            i4++;
        }
        sb.append(valueOf.substring(i5));
        if (i4 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i4]);
            for (int i6 = i4 + 1; i6 < objArr.length; i6++) {
                sb.append(", ");
                sb.append(objArr[i6]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
