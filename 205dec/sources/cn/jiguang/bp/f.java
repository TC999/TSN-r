package cn.jiguang.bp;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static String f2821a = "cn.jiguang.joperate.jcore_report";

    public static String a(Context context) {
        return a(context, "report_cache.l", null);
    }

    private static synchronized String a(Context context, String str, String str2) {
        String a4;
        boolean isEmpty;
        synchronized (f.class) {
            a4 = cn.jiguang.bm.f.a(h(context, str));
            isEmpty = TextUtils.isEmpty(a4);
        }
        return isEmpty ? str2 : a4;
    }

    public static void a(Context context, String str) {
        b(context, "report_cache.l", str);
    }

    public static String b(Context context) {
        return a(context, "old_report_cache.l", null);
    }

    public static void b(Context context, String str) {
        c(context, "report_cache.l", str);
    }

    private static synchronized void b(Context context, String str, String str2) {
        synchronized (f.class) {
            File h4 = h(context, str);
            if (str2 == null) {
                str2 = "";
            }
            cn.jiguang.bm.f.a(h4, str2);
        }
    }

    public static String c(Context context) {
        return a(context, "reserved_events_cache.l", null);
    }

    public static void c(Context context, String str) {
        b(context, "old_report_cache.l", str);
    }

    private static synchronized void c(Context context, String str, String str2) {
        synchronized (f.class) {
            File h4 = h(context, str);
            if (str2 == null) {
                return;
            }
            cn.jiguang.bm.f.b(h4, str2);
        }
    }

    public static String d(Context context) {
        return a(context, "user_properties_cache.l", null);
    }

    public static void d(Context context, String str) {
        c(context, "old_report_cache.l", str);
    }

    public static String e(Context context) {
        String a4 = a(context, "old_app_active_cache.l", null);
        if (TextUtils.isEmpty(a4)) {
            a4 = g.k(context);
            if (!TextUtils.isEmpty(a4)) {
                g(context, a4);
                g.e(context, (String) null);
            }
        }
        return a4;
    }

    public static void e(Context context, String str) {
        b(context, "reserved_events_cache.l", str);
    }

    public static void f(Context context, String str) {
        b(context, "user_properties_cache.l", str);
    }

    public static void g(Context context, String str) {
        b(context, "old_app_active_cache.l", str);
        g.e(context, (String) null);
    }

    private static File h(Context context, String str) {
        File file = new File(context.getFilesDir().getPath() + TTPathConst.sSeparator + f2821a, str);
        if (file.getParentFile().exists()) {
            if (file.getParentFile().isFile()) {
                file.getParentFile().delete();
            } else if (file.isDirectory()) {
                file.delete();
            }
        }
        return file;
    }
}
