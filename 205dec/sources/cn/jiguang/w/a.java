package cn.jiguang.w;

import android.util.Log;
import cn.jiguang.api.JCoreManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Integer, Set<String>> f3889a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static long f3890b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static String f3891c = "[key-step]";

    public static void a(int i4, String str, String str2) {
        try {
            if (f3890b > 102400) {
                Log.d("debug_internal", "log cache over =102400 , clean it");
                f3889a.clear();
                f3890b = 0L;
            }
            if (!f3889a.containsKey(Integer.valueOf(i4))) {
                f3889a.put(Integer.valueOf(i4), new HashSet());
            }
            Set<String> set = f3889a.get(Integer.valueOf(i4));
            if (set.contains(str2)) {
                return;
            }
            b(str, str2);
            long length = f3890b + str2.length();
            f3890b = length;
            f3890b = length + String.valueOf(i4).length();
            set.add(str2);
        } catch (Throwable unused) {
        }
    }

    private static void a(int i4, boolean z3, String str, String str2, Throwable th) {
        if (th != null) {
            str2 = str2 + ":" + th;
        }
        JCoreManager.onEvent(null, "JCommon", 18, str, null, Integer.valueOf(i4), Boolean.valueOf(z3), str2, th);
    }

    public static void a(String str, String str2) {
        a(2, true, str, str2, null);
    }

    public static void a(String str, String str2, Throwable th) {
        a(3, true, str, str2, th);
    }

    public static void b(String str, String str2) {
        a(3, true, str, str2, null);
    }

    public static void b(String str, String str2, Throwable th) {
        a(5, true, str, str2, th);
    }

    public static void c(String str, String str2) {
        a(3, false, str, str2, null);
    }

    public static void c(String str, String str2, Throwable th) {
        a(6, true, str, str2, th);
    }

    public static void d(String str, String str2) {
        a(3, false, str, f3891c + str2, null);
    }

    public static void e(String str, String str2) {
        a(4, true, str, str2, null);
    }

    public static void f(String str, String str2) {
        a(5, true, str, str2, null);
    }

    public static void g(String str, String str2) {
        a(5, false, str, str2, null);
    }

    public static void h(String str, String str2) {
        a(6, true, str, str2, null);
    }

    public static void i(String str, String str2) {
        a(6, false, str, str2, null);
    }
}
