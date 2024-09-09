package cn.jiguang.bv;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    final g f2934a;

    /* renamed from: b  reason: collision with root package name */
    int f2935b;

    /* renamed from: c  reason: collision with root package name */
    long f2936c;

    /* renamed from: d  reason: collision with root package name */
    long f2937d;

    /* renamed from: e  reason: collision with root package name */
    int f2938e;

    public d(g gVar) {
        this.f2934a = gVar;
    }

    public static d a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d(new g(jSONObject.getString("ip"), jSONObject.getInt("port")));
            dVar.f2935b = jSONObject.optInt("status");
            dVar.f2936c = jSONObject.optLong("fetch_time");
            dVar.f2937d = jSONObject.optLong("cost");
            dVar.f2938e = jSONObject.optInt("prefer");
            return dVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    public String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ip", this.f2934a.f2943a);
            jSONObject.put("port", this.f2934a.f2944b);
            jSONObject.put("status", this.f2935b);
            jSONObject.put("fetch_time", this.f2936c);
            jSONObject.put("cost", this.f2937d);
            jSONObject.put("prefer", this.f2938e);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f2935b == dVar.f2935b && this.f2936c == dVar.f2936c && this.f2937d == dVar.f2937d && this.f2938e == dVar.f2938e) {
                g gVar = this.f2934a;
                g gVar2 = dVar.f2934a;
                return gVar != null ? gVar.equals(gVar2) : gVar2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        g gVar = this.f2934a;
        int hashCode = gVar != null ? gVar.hashCode() : 0;
        long j4 = this.f2936c;
        long j5 = this.f2937d;
        return (((((((hashCode * 31) + this.f2935b) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.f2938e;
    }

    public String toString() {
        return "IpInfo{ipPort=" + this.f2934a + ", status=" + this.f2935b + ", fetchTime=" + this.f2936c + ", cost=" + this.f2937d + ", prefer=" + this.f2938e + '}';
    }
}
