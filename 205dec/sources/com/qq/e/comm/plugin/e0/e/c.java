package com.qq.e.comm.plugin.e0.e;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f42904a;

    /* renamed from: b  reason: collision with root package name */
    private String f42905b;

    /* renamed from: c  reason: collision with root package name */
    private int f42906c;

    /* renamed from: d  reason: collision with root package name */
    private List<a> f42907d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, String> f42908e;

    public c(JSONObject jSONObject) {
        this.f42906c = 30000;
        if (jSONObject != null) {
            this.f42904a = jSONObject.optString("version");
            this.f42905b = jSONObject.optString("suid");
            this.f42906c = jSONObject.optInt("update_interval");
            this.f42908e = new HashMap<>();
            this.f42907d = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("mediation_list");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                a aVar = new a(optJSONArray.optJSONObject(i4));
                this.f42907d.add(aVar);
                this.f42908e.putAll(aVar.k());
            }
        }
    }

    public String a() {
        return this.f42904a;
    }

    public List<a> b() {
        return this.f42907d;
    }

    public String c() {
        return this.f42905b;
    }

    public int d() {
        return this.f42906c;
    }

    public HashMap<String, String> e() {
        return this.f42908e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("version: " + this.f42904a + ", updateInterval: " + this.f42906c + ", mediation_list:");
        for (a aVar : this.f42907d) {
            sb.append("\n");
            sb.append(aVar);
        }
        return sb.toString();
    }
}
