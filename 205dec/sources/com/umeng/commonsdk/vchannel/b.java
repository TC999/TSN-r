package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Event.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private String f53828b;

    /* renamed from: a  reason: collision with root package name */
    private String f53827a = "_$unknown";

    /* renamed from: c  reason: collision with root package name */
    private long f53829c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f53830d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f53831e = a.f53826j;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, Object> f53832f = null;

    public b(Context context) {
        this.f53828b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    public String a() {
        return this.f53827a;
    }

    public long b() {
        return this.f53829c;
    }

    public Map<String, Object> c() {
        return this.f53832f;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f53827a);
            jSONObject.put("pn", this.f53828b);
            jSONObject.put("ds", this.f53830d);
            jSONObject.put("ts", this.f53829c);
            Map<String, Object> map = this.f53832f;
            if (map != null && map.size() > 0) {
                for (String str : this.f53832f.keySet()) {
                    jSONObject.put(str, this.f53832f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f53831e, jSONArray);
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
        sb.append("id:" + this.f53827a + ",");
        sb.append("pn:" + this.f53828b + ",");
        sb.append("ts:" + this.f53829c + ",");
        Map<String, Object> map = this.f53832f;
        if (map != null && map.size() > 0) {
            for (String str : this.f53832f.keySet()) {
                sb.append(this.f53832f.get(str) == null ? str + ": null," : str + ": " + obj.toString() + ",");
            }
        }
        sb.append("ds:" + this.f53830d + "]");
        return sb.toString();
    }

    public void a(String str) {
        this.f53827a = str;
    }

    public void a(long j4) {
        this.f53829c = j4;
    }

    public void a(Map<String, Object> map) {
        this.f53832f = map;
    }
}
