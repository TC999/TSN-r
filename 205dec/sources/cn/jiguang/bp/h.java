package cn.jiguang.bp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static String f2824a = "[key-step]";

    private static void a(int i4, boolean z3, String str, String str2, Throwable th) {
        cn.jiguang.bm.f.a(i4, z3, str, str2, th);
    }

    public static void a(String str, String str2) {
        a(3, true, str, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        a(6, true, str, str2, th);
    }

    public static void b(String str, String str2) {
        a(3, false, str, str2, null);
    }

    public static void b(String str, String str2, Throwable th) {
        a(6, false, str, str2, th);
    }

    public static void c(String str, String str2) {
        a(3, false, str, f2824a + str2, null);
    }

    public static void d(String str, String str2) {
        a(5, true, str, str2, null);
    }

    public static void e(String str, String str2) {
        a(5, false, str, str2, null);
    }

    public static void f(String str, String str2) {
        a(6, true, str, str2, null);
    }

    public static void g(String str, String str2) {
        a(6, false, str, str2, null);
    }
}
