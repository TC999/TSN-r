package cn.jiguang.bm;

import android.content.Context;
import android.os.Bundle;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {
    public static Object a(Context context, String str, Bundle bundle) {
        return b.a(context, str, bundle);
    }

    public static void a(Context context) {
        b.a(context, "exit_app", null);
    }

    public static void a(Context context, int i4) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", i4);
        b.a(context, "start_app", bundle);
    }

    public static void a(Context context, long j4, String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j4);
        bundle.putString("rid", str);
        b.a(context, "jcore_login", bundle);
    }

    public static void b(Context context) {
        cn.jiguang.bq.d.c("JOperateJCoreChannel", "initinit");
        b.a(context, "init", null);
    }

    public static void b(Context context, long j4, String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j4);
        bundle.putString("rid", str);
        b.a(context, "jcore_register", bundle);
    }

    public static void c(Context context) {
        b.a(context, "period_task", null);
    }
}
