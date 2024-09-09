package cn.jiguang.ba;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f2519a;

    /* renamed from: b  reason: collision with root package name */
    public String f2520b;

    /* renamed from: c  reason: collision with root package name */
    public String f2521c;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = "";
            if (cn.jiguang.ar.a.a().e(1024)) {
                jSONObject.put("imei", TextUtils.isEmpty(this.f2519a) ? "" : this.f2519a);
            }
            cn.jiguang.ar.a.a().e(1023);
            if (cn.jiguang.ar.a.a().e(1025)) {
                if (!TextUtils.isEmpty(this.f2520b)) {
                    str = this.f2520b;
                }
                jSONObject.put("imsi", str);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean b() {
        return TextUtils.isEmpty(this.f2519a) && TextUtils.isEmpty(this.f2520b);
    }

    public String toString() {
        return "JDeviceSimInfo{imei='" + this.f2519a + "', imsi='" + this.f2520b + "'}";
    }
}
