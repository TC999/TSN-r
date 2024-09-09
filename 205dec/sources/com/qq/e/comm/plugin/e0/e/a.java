package com.qq.e.comm.plugin.e0.e;

import com.qq.e.comm.plugin.util.t0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f42884a;

    /* renamed from: b  reason: collision with root package name */
    private final int f42885b;

    /* renamed from: c  reason: collision with root package name */
    private final int f42886c;

    /* renamed from: d  reason: collision with root package name */
    private final int f42887d;

    /* renamed from: e  reason: collision with root package name */
    private final int f42888e;

    /* renamed from: f  reason: collision with root package name */
    private final int f42889f;

    /* renamed from: g  reason: collision with root package name */
    private final int f42890g;

    /* renamed from: h  reason: collision with root package name */
    private final int f42891h;

    /* renamed from: i  reason: collision with root package name */
    private final int f42892i;

    /* renamed from: j  reason: collision with root package name */
    private final List<d> f42893j;

    /* renamed from: k  reason: collision with root package name */
    private final List<d> f42894k;

    /* renamed from: l  reason: collision with root package name */
    private final List<d> f42895l;

    /* renamed from: m  reason: collision with root package name */
    private final HashMap<String, String> f42896m = new HashMap<>();

    public a(JSONObject jSONObject) {
        this.f42884a = jSONObject.optString("mediation_id");
        this.f42885b = jSONObject.optInt("total_timeout");
        this.f42886c = jSONObject.optInt("layer_timeout");
        this.f42887d = jSONObject.optInt("bidding_timeout");
        this.f42888e = jSONObject.optInt("s2s_load_ad_timeout");
        this.f42889f = Math.max(jSONObject.optInt("parallel_count", 1), 1);
        this.f42892i = jSONObject.optInt("is_parallel");
        this.f42890g = jSONObject.optInt("exp_group_id");
        this.f42891h = jSONObject.optInt("flow_group_id");
        this.f42893j = a(jSONObject, false, "waterfall_config");
        this.f42894k = a(jSONObject, true, "bidding_config");
        this.f42895l = a(jSONObject, true, "s2s_bidding_config");
    }

    private List<d> a(JSONObject jSONObject, boolean z3, String str) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                d dVar = new d(optJSONArray.optJSONObject(i4), this.f42884a, z3, this.f42890g, this.f42891h);
                arrayList.add(dVar);
                a(dVar);
            }
        }
        return arrayList;
    }

    public List<d> b() {
        return this.f42894k;
    }

    public int c() {
        return this.f42890g;
    }

    public int d() {
        return this.f42886c;
    }

    public String e() {
        return this.f42884a;
    }

    public int f() {
        return this.f42889f;
    }

    public List<d> g() {
        return this.f42895l;
    }

    public int h() {
        return this.f42888e;
    }

    public int i() {
        return this.f42885b;
    }

    public List<d> j() {
        return this.f42893j;
    }

    public HashMap<String, String> k() {
        return this.f42896m;
    }

    public boolean l() {
        return this.f42892i == 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("mediationId: " + this.f42884a + ", timeout: " + this.f42885b + ", configs: ");
        for (d dVar : this.f42893j) {
            sb.append("\n   ");
            sb.append(dVar);
        }
        return sb.toString();
    }

    private void a(d dVar) {
        if (t0.a(dVar)) {
            this.f42896m.put(dVar.p(), dVar.n());
        }
    }

    public int a() {
        return this.f42887d;
    }
}
