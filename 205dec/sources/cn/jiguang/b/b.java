package cn.jiguang.b;

import android.content.Context;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.bq.d;
import cn.jiguang.bs.f;
import cn.jiguang.internal.JConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b extends cn.jiguang.cm.b implements ReportCallBack {
    public b() {
        this.f3462h = "ReportCrashLogDirect";
    }

    private JSONObject a(Context context) {
        JSONArray c4 = a.c(context);
        if (c4 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crashlogs", c4);
            jSONObject.put("network_type", cn.jiguang.f.a.m(context));
            cn.jiguang.d.a.a(context, jSONObject, "crash_log");
            Object a4 = cn.jiguang.c.b.a(context);
            JSONObject jSONObject2 = a4 instanceof JSONObject ? (JSONObject) a4 : null;
            if (jSONObject2 != null && jSONObject2.length() > 0) {
                jSONObject.put("device_info", jSONObject2);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // cn.jiguang.cm.b
    public void a() {
        try {
            Context appContext = JConstants.getAppContext(null);
            if (appContext == null) {
                d.i("ReportCrashLogDirect", "ReportDirect context is null");
                return;
            }
            JSONObject a4 = a(appContext);
            if (a4 != null) {
                f.a(appContext, a4, this);
            }
        } catch (Throwable th) {
            d.l("ReportCrashLogDirect", "run report crash e:" + th);
        }
    }

    @Override // cn.jiguang.api.ReportCallBack
    public void onFinish(int i4) {
        d.i("ReportCrashLogDirect", "ReportDirect finish : " + i4);
        if (i4 == 0) {
            a.d(JConstants.getAppContext(null));
        }
    }
}
