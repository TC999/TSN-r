package cn.jiguang.bn;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f2804a;

    /* renamed from: b  reason: collision with root package name */
    private Object f2805b;

    /* renamed from: c  reason: collision with root package name */
    private String f2806c;

    public a(JSONObject jSONObject) {
        this.f2804a = jSONObject.optString(DomainCampaignEx.LOOPBACK_KEY);
        this.f2805b = jSONObject.opt("value");
        this.f2806c = jSONObject.optString("datatype");
    }

    public String a() {
        return this.f2804a;
    }

    public Object b() {
        return this.f2805b;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DomainCampaignEx.LOOPBACK_KEY, this.f2804a);
            jSONObject.put("value", this.f2805b);
            jSONObject.put("datatype", this.f2806c);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "UserPropertiesBean{key='" + this.f2804a + "', value='" + this.f2805b + "', type='" + this.f2806c + "'}";
    }
}
