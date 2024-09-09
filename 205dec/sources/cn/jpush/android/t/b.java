package cn.jpush.android.t;

import cn.jpush.android.helper.Logger;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f4368a;

    /* renamed from: b  reason: collision with root package name */
    public String f4369b;

    /* renamed from: c  reason: collision with root package name */
    public long f4370c;

    public static b a(String str, String str2, long j4) {
        b bVar = new b();
        bVar.f4368a = str;
        bVar.f4369b = str2;
        bVar.f4370c = j4;
        return bVar;
    }

    public static b a(JSONObject jSONObject) {
        if (jSONObject != null) {
            b bVar = new b();
            bVar.f4368a = jSONObject.optString("tpl_id");
            bVar.f4369b = jSONObject.optString("tpl_file_name");
            bVar.f4370c = jSONObject.optLong("tpl_recent_use_time");
            return bVar;
        }
        return null;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tpl_id", this.f4368a);
            jSONObject.put("tpl_file_name", this.f4369b);
            jSONObject.put("tpl_recent_use_time", this.f4370c);
            return jSONObject;
        } catch (Throwable th) {
            Logger.w("InAppTemplate", "notify inapp toJSON failed. " + th.getMessage());
            return null;
        }
    }
}
