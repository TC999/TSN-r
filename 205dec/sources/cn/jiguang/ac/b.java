package cn.jiguang.ac;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import cn.jiguang.af.f;
import cn.jiguang.ah.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a extends e {

        /* renamed from: a  reason: collision with root package name */
        private Context f2061a;

        /* renamed from: b  reason: collision with root package name */
        private JSONObject f2062b;

        a(Context context, JSONObject jSONObject) {
            this.f2061a = context;
            this.f2062b = jSONObject;
            this.f2244d = "JWakeCmd#WakeAction";
        }

        @Override // cn.jiguang.ah.e
        public void a() {
            try {
                long f4 = cn.jiguang.ah.c.f(this.f2061a, "JWakeCmdcmd");
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = this.f2062b;
                if (jSONObject == null && currentTimeMillis - f4 < 3600000) {
                    cn.jiguang.w.a.f("JWakeCmd", "is not cmd wake time");
                }
                b.c(this.f2061a, jSONObject);
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JWakeCmd", "WakeAction failed:" + th.getMessage());
            }
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            cn.jiguang.w.a.b("JWakeCmd", jSONObject == null ? "executeWakeAction: [JWakeCmd] from heartBeat" : "executeWakeAction: [JWakeCmd] from cmd");
            boolean booleanValue = ((Boolean) cn.jiguang.ac.a.b(context)).booleanValue();
            cn.jiguang.w.a.b("JWakeCmd", "JWakeCmd isActionUserEnable:" + booleanValue);
            if (booleanValue) {
                cn.jiguang.ah.d.a(new a(context, jSONObject));
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.g("JWakeCmd", "[executeWakeAction] failed:" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, JSONObject jSONObject) {
        List<cn.jiguang.ad.c> a4;
        ApplicationInfo applicationInfo;
        try {
            cn.jiguang.ah.c.e(context, "JWakeCmdcmd");
            String c4 = cn.jiguang.ao.e.c(context, "bwct.catch.v2");
            cn.jiguang.w.a.b("JWakeCmd", "read cmd wakeTarget:" + c4);
            if (jSONObject != null) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                int optInt = jSONObject2.optInt("type", 1);
                String optString = jSONObject2.optString("pkgName", "");
                String optString2 = jSONObject2.optString("serviceName", "");
                int optInt2 = jSONObject2.optInt("delay_time");
                a4 = null;
                if (optInt == 1 && (applicationInfo = context.getPackageManager().getApplicationInfo(optString, 128)) != null) {
                    a4 = new ArrayList<>();
                    cn.jiguang.ad.c cVar = new cn.jiguang.ad.c();
                    cVar.f2094a = optString;
                    cVar.f2095b = optString2;
                    cVar.f2096c = applicationInfo.targetSdkVersion;
                    cVar.f2103j = 1;
                    cVar.f2104k = optInt2;
                    cVar.f2100g = 4;
                    a4.add(cVar);
                }
                String a5 = cn.jiguang.af.c.a(cn.jiguang.af.d.a(c4, optString, optString2, optInt));
                cn.jiguang.w.a.b("JWakeCmd", "write cmd wakeTarget:" + a5);
                cn.jiguang.ao.e.a(context, "bwct.catch.v2", a5);
            } else if (c4 == null || TextUtils.isEmpty(c4)) {
                cn.jiguang.w.a.f("JWakeCmd", "there are no cache cmd wakeTarget");
                return;
            } else {
                a4 = cn.jiguang.af.c.a(context, cn.jiguang.af.c.a(c4));
            }
            if (a4 != null) {
                f.a().a(context, new cn.jiguang.ad.a(), a4);
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JWakeCmd", "parse throwable:" + th.getMessage());
        }
    }
}
