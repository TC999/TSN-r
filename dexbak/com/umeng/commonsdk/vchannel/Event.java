package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.umeng.commonsdk.vchannel.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Event {

    /* renamed from: b */
    private String f39238b;

    /* renamed from: a */
    private String f39237a = "_$unknown";

    /* renamed from: c */
    private long f39239c = 0;

    /* renamed from: d */
    private long f39240d = 0;

    /* renamed from: e */
    private String f39241e = Constant.f39236j;

    /* renamed from: f */
    private Map<String, Object> f39242f = null;

    public Event(Context context) {
        this.f39238b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    /* renamed from: a */
    public String m13454a() {
        return this.f39237a;
    }

    /* renamed from: b */
    public long m13450b() {
        return this.f39239c;
    }

    /* renamed from: c */
    public Map<String, Object> m13449c() {
        return this.f39242f;
    }

    /* renamed from: d */
    public JSONObject m13448d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f39237a);
            jSONObject.put("pn", this.f39238b);
            jSONObject.put("ds", this.f39240d);
            jSONObject.put("ts", this.f39239c);
            Map<String, Object> map = this.f39242f;
            if (map != null && map.size() > 0) {
                for (String str : this.f39242f.keySet()) {
                    jSONObject.put(str, this.f39242f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f39241e, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ekv", jSONArray2);
            return jSONObject3;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("[");
        sb.append("id:" + this.f39237a + ",");
        sb.append("pn:" + this.f39238b + ",");
        sb.append("ts:" + this.f39239c + ",");
        Map<String, Object> map = this.f39242f;
        if (map != null && map.size() > 0) {
            for (String str : this.f39242f.keySet()) {
                sb.append(this.f39242f.get(str) == null ? str + ": null," : str + ": " + obj.toString() + ",");
            }
        }
        sb.append("ds:" + this.f39240d + "]");
        return sb.toString();
    }

    /* renamed from: a */
    public void m13452a(String str) {
        this.f39237a = str;
    }

    /* renamed from: a */
    public void m13453a(long j) {
        this.f39239c = j;
    }

    /* renamed from: a */
    public void m13451a(Map<String, Object> map) {
        this.f39242f = map;
    }
}
