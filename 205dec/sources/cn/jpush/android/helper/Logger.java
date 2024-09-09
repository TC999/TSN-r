package cn.jpush.android.helper;

import cn.jiguang.api.JCoreManager;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class Logger {

    /* renamed from: a  reason: collision with root package name */
    private static String f4208a = "[key-step]";

    private static void a(int i4, boolean z3, String str, String str2, Throwable th) {
        JCoreManager.onEvent(null, "JPush", 18, str, null, Integer.valueOf(i4), Boolean.valueOf(z3), str2, th);
    }

    public static void d(String str, String str2) {
        a(3, true, str, str2, null);
    }

    public static void dd(String str, String str2) {
        a(3, false, str, str2, null);
    }

    public static void e(String str, String str2) {
        a(6, true, str, str2, null);
    }

    public static void e(String str, String str2, Throwable th) {
        a(6, true, str, str2, th);
    }

    public static void ee(String str, String str2) {
        a(6, false, str, str2, null);
    }

    public static void ee(String str, String str2, Throwable th) {
        a(6, false, str, str2, th);
    }

    public static void i(String str, String str2) {
        a(4, true, str, str2, null);
    }

    public static void ii(String str, String str2) {
        a(4, false, str, str2, null);
    }

    public static void kd(String str, String str2) {
        a(3, false, str, f4208a + str2, null);
    }

    public static void ke(String str, String str2) {
        a(6, false, str, f4208a + str2, null);
    }

    public static void ke(String str, String str2, Throwable th) {
        a(6, false, str, f4208a + str2, th);
    }

    public static void ki(String str, String str2) {
        a(4, false, str, f4208a + str2, null);
    }

    public static void kv(String str, String str2) {
        a(2, false, str, f4208a + str2, null);
    }

    public static void kw(String str, String str2) {
        a(5, false, str, f4208a + str2, null);
    }

    public static void kw(String str, String str2, Throwable th) {
        a(5, false, str, f4208a + str2, th);
    }

    public static void v(String str, String str2) {
        a(2, true, str, str2, null);
    }

    public static void vv(String str, String str2) {
        a(2, false, str, str2, null);
    }

    public static void w(String str, String str2) {
        a(5, true, str, str2, null);
    }

    public static void ww(String str, String str2) {
        a(5, false, str, str2, null);
    }

    public static void ww(String str, String str2, Throwable th) {
        a(5, false, str, str2, th);
    }
}
