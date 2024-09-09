package cn.jiguang.bt;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bq.d;
import cn.jiguang.bx.g;
import cn.jiguang.bx.h;
import cn.jiguang.internal.JConstants;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2890a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.StringBuilder] */
    private static synchronized void a(Context context) {
        synchronized (a.class) {
            if (f2890a) {
                return;
            }
            if (context == null) {
                return;
            }
            d.c("JCoreActionImpl", "init jcore impl ,version:" + cn.jiguang.a.a.f2010b + ",local version:" + JConstants.SDK_VERSION_INT);
            f2890a = true;
            d.c("JCoreActionImpl", "hb:" + h.a().f() + ",google:false,google pure : false,internal:false");
            int i4 = !TextUtils.isEmpty(JConstants.SDK_NAME) ? 2 : 0;
            ?? r5 = cn.jiguang.a.a.a();
            if (cn.jiguang.a.a.f2011c != JConstants.SDK_VERSION_INT) {
                r5 = 2;
            }
            d.c("JCoreActionImpl", "custom:" + i4 + ",dynamic:" + r5);
            JCoreManager.onEvent(context, JConstants.SDK_TYPE, 72, true, null, null, "core", Integer.valueOf(i4), Integer.valueOf((int) r5), Integer.valueOf(cn.jiguang.a.a.f2011c));
            cn.jiguang.bx.c.b(context);
            cn.jiguang.bx.c.a(context);
        }
    }

    public static void a(Context context, String str, Bundle bundle) {
        StringBuilder sb;
        a(context);
        if (TextUtils.isEmpty(str)) {
            d.j("JCoreActionImpl", "handleAction Failed,action is empty");
            return;
        }
        d.c("JCoreActionImpl", "handleAction action:" + str);
        String string = bundle != null ? bundle.getString("sdk_type") : "";
        String str2 = null;
        if (str.equals("a1")) {
            if (bundle != null) {
                try {
                    str2 = bundle.getString("report_data");
                } catch (Throwable th) {
                    th = th;
                    sb = new StringBuilder();
                }
            }
            b.a(context, (Object) str2);
            return;
        } else if (str.equals("a12")) {
            if (bundle != null) {
                try {
                    str2 = bundle.getString("save_data");
                } catch (Throwable th2) {
                    th = th2;
                    sb = new StringBuilder();
                }
            }
            cn.jiguang.cf.b.a().a(str2);
            return;
        } else if (str.startsWith("tcp_")) {
            h.a().a(context, str, bundle);
            return;
        } else if (str.equals("a2")) {
            g.a().a(context, true);
            return;
        } else if (str.equals("a3")) {
            cn.jiguang.bx.b.a().a(context, string, bundle);
            return;
        } else if (str.equals("a4")) {
            b.a(context, bundle);
            return;
        } else {
            return;
        }
        sb.append("report failed:");
        sb.append(th.getMessage());
        d.i("JCoreActionImpl", sb.toString());
    }
}
