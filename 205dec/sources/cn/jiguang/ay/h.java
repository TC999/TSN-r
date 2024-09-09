package cn.jiguang.ay;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.ah.a;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h extends cn.jiguang.ah.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f2507a;

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2507a = context;
        return "JDeviceUid";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean a(Context context, String str) {
        long c4 = cn.jiguang.ah.d.c(context);
        String d4 = cn.jiguang.ah.d.d(context);
        if (c4 <= 0 || TextUtils.isEmpty(d4)) {
            cn.jiguang.w.a.f("JDeviceUid", "jid is invalid, uid is " + c4 + ", rid is " + d4);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        try {
            long c4 = cn.jiguang.ah.d.c(context);
            String d4 = cn.jiguang.ah.d.d(context);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rid", d4);
            jSONObject.put("uid", c4);
            String a4 = cn.jiguang.ap.b.a(jSONObject.toString(), a.C0049a.f2224m);
            cn.jiguang.w.a.b("JDeviceUid", "start to report jid, o_data: " + jSONObject.toString() + ", e_data: " + a4);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("itime", cn.jiguang.ah.d.i(context));
            jSONObject2.put("type", "sdk_jid");
            jSONObject2.put("data", a4);
            cn.jiguang.ah.d.a(context, (Object) jSONObject2);
            super.c(context, str);
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JDeviceUid", "jid encode failed, " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean d(Context context, String str) {
        return true;
    }
}
