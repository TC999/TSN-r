package cn.jiguang.cn;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.InAppSlotParams;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f3470a = true;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f3471b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f3472c;

    public static void a(final Context context) {
        cn.jiguang.bq.d.c("AuthUtils", " sync status");
        cn.jiguang.cm.d.a("DELAY_TASK", new cn.jiguang.cm.b() { // from class: cn.jiguang.cn.a.1
            @Override // cn.jiguang.cm.b
            public void a() {
                try {
                    if (Math.abs(System.currentTimeMillis() - ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.F())).longValue()) < 432000000) {
                        cn.jiguang.bq.d.c("AuthUtils", "sync status no need report");
                        return;
                    }
                    cn.jiguang.bq.d.c("AuthUtils", "start sync status");
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(System.currentTimeMillis());
                    jSONArray2.put(System.currentTimeMillis());
                    jSONObject2.put("duration", jSONArray2);
                    jSONObject2.put("c_type", "set_auth");
                    JSONArray jSONArray3 = new JSONArray();
                    JSONObject jSONObject3 = new JSONObject();
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(a.f3472c ? 0 : 1);
                    jSONObject3.put("result", sb.toString());
                    jSONObject3.put("s_type", "set_auth");
                    jSONArray3.put(jSONObject3);
                    jSONObject2.put("statistics", jSONArray3);
                    jSONArray.put(jSONObject2);
                    jSONObject.put("slice_index", 1);
                    jSONObject.put("slice_count", 1);
                    jSONObject.put("data", jSONArray);
                    jSONObject.put(InAppSlotParams.SLOT_KEY.SEQ, UUID.randomUUID().toString());
                    cn.jiguang.d.a.a(context, jSONObject, "collect_statistic");
                    cn.jiguang.bq.d.c("AuthUtils", "reportJSON=" + jSONObject);
                    cn.jiguang.g.b.a(context, cn.jiguang.g.a.F().a((cn.jiguang.g.a<Long>) Long.valueOf(System.currentTimeMillis())));
                    JCoreManager.onEvent(context, JConstants.SDK_TYPE, 39, null, null, jSONObject);
                } catch (Throwable th) {
                    cn.jiguang.bq.d.c("AuthUtils", "sync status  throwable=" + th);
                }
            }
        }, (int) AVMDLDataLoader.KeyIsLiveSetLoaderType);
    }

    public static void a(Context context, boolean z3) {
        cn.jiguang.bq.d.c("AuthUtils", "enableAutoWakeup status: " + z3);
        d(context, z3);
        cn.jiguang.bx.a.a(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("enable_auto_wakeup", z3);
        cn.jiguang.a.a.a(context, "a8", bundle);
    }

    public static void a(boolean z3, boolean z4) {
        f3472c = z4;
        f3470a = z3;
    }

    public static boolean a() {
        return f3470a;
    }

    public static void b(Context context, boolean z3) {
        cn.jiguang.bq.d.c("AuthUtils", "enableipv6 priority status: " + z3);
        f(context, z3);
        Bundle bundle = new Bundle();
        bundle.putBoolean("enable_ci_priority", z3);
        cn.jiguang.a.a.a(context, "a11", bundle);
    }

    public static boolean b() {
        return f3472c;
    }

    public static boolean b(Context context) {
        try {
            return ((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.e())).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void c(Context context, boolean z3) {
    }

    public static boolean c(Context context) {
        try {
            return ((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.g())).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void d(Context context, boolean z3) {
        cn.jiguang.bq.d.c("AuthUtils", "enableAutoWakeup config status: " + z3);
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.e().a((cn.jiguang.g.a<Boolean>) Boolean.valueOf(z3)));
    }

    public static boolean d(Context context) {
        try {
            return ((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.h())).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void e(Context context, boolean z3) {
        cn.jiguang.bq.d.c("AuthUtils", "setDynamicLoad config enable: " + z3);
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.g().a((cn.jiguang.g.a<Boolean>) Boolean.valueOf(z3)));
    }

    public static boolean e(Context context) {
        try {
            if (f3471b == null) {
                f3471b = (Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.f());
            }
            return f3471b.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void f(Context context, boolean z3) {
        cn.jiguang.bq.d.c("AuthUtils", "IPV6First config enable: " + z3);
        f3471b = Boolean.valueOf(z3);
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.f().a((cn.jiguang.g.a<Boolean>) Boolean.valueOf(z3)));
    }

    public static void g(Context context, boolean z3) {
        cn.jiguang.bq.d.c("AuthUtils", "setAppTerminate config enable: " + z3);
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.h().a((cn.jiguang.g.a<Boolean>) Boolean.valueOf(z3)));
    }
}
