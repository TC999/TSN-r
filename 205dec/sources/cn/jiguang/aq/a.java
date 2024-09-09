package cn.jiguang.aq;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.ah.d;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bm.b;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static long f2351a;

    public static void a(Context context, int i4) {
        cn.jiguang.w.a.b("JAnalytics", "sendStartAPP:" + i4);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f2351a < 2000) {
            cn.jiguang.w.a.b("JAnalytics", "sendStartAPP return:" + i4);
            return;
        }
        f2351a = currentTimeMillis;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i4);
        } catch (Throwable unused) {
        }
        a(context, 2021, "Start the APP", jSONObject);
    }

    public static void a(Context context, int i4, String str, JSONObject jSONObject) {
        b(context, i4, str, jSONObject);
    }

    public static void b(Context context, int i4, String str, JSONObject jSONObject) {
        if (context == null) {
            cn.jiguang.w.a.h("JAnalytics", "reportPushAnylysis NULL context");
        } else if (d.c()) {
            JCoreManager.onEvent(context, null, 89, "start_app", new Bundle(), new Object[0]);
        } else {
            b.a(context, "start_app_wake_save", new Bundle());
        }
    }
}
