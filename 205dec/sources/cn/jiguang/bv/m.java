package cn.jiguang.bv;

import android.text.TextUtils;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public String f2975a;

    /* renamed from: b  reason: collision with root package name */
    public int f2976b;

    /* renamed from: c  reason: collision with root package name */
    public g f2977c;

    /* renamed from: d  reason: collision with root package name */
    public long f2978d;

    /* renamed from: e  reason: collision with root package name */
    public long f2979e;

    /* renamed from: f  reason: collision with root package name */
    public long f2980f;

    /* renamed from: g  reason: collision with root package name */
    public int f2981g;

    /* renamed from: h  reason: collision with root package name */
    public double f2982h;

    /* renamed from: i  reason: collision with root package name */
    public double f2983i;

    /* renamed from: j  reason: collision with root package name */
    public long f2984j;

    /* renamed from: k  reason: collision with root package name */
    public int f2985k;

    public static m a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                m mVar = new m();
                mVar.f2975a = jSONObject.optString("appkey");
                mVar.f2976b = jSONObject.getInt("type");
                mVar.f2977c = g.a(jSONObject.getString("addr"));
                mVar.f2979e = jSONObject.getLong("rtime");
                mVar.f2980f = jSONObject.getLong("interval");
                mVar.f2981g = jSONObject.getInt("net");
                mVar.f2985k = jSONObject.getInt("code");
                mVar.f2978d = jSONObject.optLong("uid");
                mVar.f2982h = jSONObject.optDouble("lat");
                mVar.f2983i = jSONObject.optDouble("lng");
                mVar.f2984j = jSONObject.optLong("ltime");
                return mVar;
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static LinkedList<m> a(String str) {
        LinkedList<m> linkedList = new LinkedList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    linkedList.add(a(jSONArray.getJSONObject(i4)));
                }
            } catch (JSONException unused) {
            }
        }
        return linkedList;
    }

    private static boolean a(double d4, double d5) {
        return d4 > -90.0d && d4 < 90.0d && d5 > -180.0d && d5 < 180.0d;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f2975a)) {
                jSONObject.put("appkey", this.f2975a);
            }
            jSONObject.put("type", this.f2976b);
            jSONObject.put("addr", this.f2977c.toString());
            jSONObject.put("rtime", this.f2979e);
            jSONObject.put("interval", this.f2980f);
            jSONObject.put("net", this.f2981g);
            jSONObject.put("code", this.f2985k);
            long j4 = this.f2978d;
            if (j4 != 0) {
                jSONObject.put("uid", j4);
            }
            if (a(this.f2982h, this.f2983i)) {
                jSONObject.put("lat", this.f2982h);
                jSONObject.put("lng", this.f2983i);
                jSONObject.put("ltime", this.f2984j);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
