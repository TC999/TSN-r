package cn.jiguang.cl;

import cn.jiguang.api.JCoreManager;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {
    private static void a(int i4, boolean z3, String str, String str2, Throwable th) {
        JCoreManager.onEvent(null, "JSupport", 18, str, null, Integer.valueOf(i4), Boolean.valueOf(z3), str2, th);
    }

    public static void a(String str, String str2) {
        a(2, true, str, str2, null);
    }

    public static void b(String str, String str2) {
        a(3, true, str, str2, null);
    }

    public static void c(String str, String str2) {
        a(5, true, str, str2, null);
    }

    public static void d(String str, String str2) {
        a(5, false, str, str2, null);
    }

    public static void e(String str, String str2) {
        a(6, true, str, str2, null);
    }

    public static void f(String str, String str2) {
        a(6, false, str, str2, null);
    }
}
