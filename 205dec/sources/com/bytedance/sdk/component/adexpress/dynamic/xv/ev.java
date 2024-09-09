package com.bytedance.sdk.component.adexpress.dynamic.xv;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev {

    /* renamed from: a  reason: collision with root package name */
    private List<List<ev>> f29336a;
    private String bk;

    /* renamed from: c  reason: collision with root package name */
    private String f29337c;
    private float ev;

    /* renamed from: f  reason: collision with root package name */
    private float f29338f;
    private ux gd;

    /* renamed from: k  reason: collision with root package name */
    private ev f29339k;

    /* renamed from: p  reason: collision with root package name */
    private List<ev> f29340p;

    /* renamed from: r  reason: collision with root package name */
    private float f29341r;
    private float sr;

    /* renamed from: t  reason: collision with root package name */
    private boolean f29342t;
    private float ux;

    /* renamed from: w  reason: collision with root package name */
    private float f29343w;
    private float xv;
    private Map<String, String> ys = new HashMap();
    private Map<Integer, String> fp = new HashMap();

    public ev a() {
        return this.f29339k;
    }

    public int bk() {
        f sr = this.gd.sr();
        return sr.oo() + sr.au();
    }

    public String c() {
        return this.bk;
    }

    public float ev() {
        return this.f29338f;
    }

    public float f() {
        return this.f29343w;
    }

    public float fp() {
        f sr = this.gd.sr();
        return t() + sr.ia() + sr.t() + (sr.a() * 2.0f);
    }

    public boolean fz() {
        return this.f29342t;
    }

    public float gd() {
        return this.f29341r;
    }

    public void i() {
        List<List<ev>> list = this.f29336a;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<ev> list2 : this.f29336a) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.f29336a = arrayList;
    }

    public List<List<ev>> ia() {
        return this.f29336a;
    }

    public String j() {
        return this.gd.sr().j();
    }

    public List<ev> k() {
        return this.f29340p;
    }

    public boolean ls() {
        return this.gd.sr().xg() < 0 || this.gd.sr().mu() < 0 || this.gd.sr().bs() < 0 || this.gd.sr().lf() < 0;
    }

    public ux p() {
        return this.gd;
    }

    public boolean q() {
        return TextUtils.equals(this.gd.sr().z(), "flex");
    }

    public float r() {
        return this.xv;
    }

    public boolean s() {
        List<ev> list = this.f29340p;
        return list == null || list.size() <= 0;
    }

    public float sr() {
        return this.sr;
    }

    public int t() {
        f sr = this.gd.sr();
        return sr.up() + sr.mt();
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.f29337c + "', x=" + this.f29343w + ", y=" + this.xv + ", width=" + this.f29338f + ", height=" + this.f29341r + ", remainWidth=" + this.ev + ", rootBrick=" + this.gd + ", childrenBrickUnits=" + this.f29340p + '}';
    }

    public Map<String, String> u() {
        return this.ys;
    }

    public float ux() {
        return this.ux;
    }

    public Map<Integer, String> w() {
        return this.fp;
    }

    public String xv() {
        return this.f29337c;
    }

    public float ys() {
        f sr = this.gd.sr();
        return bk() + sr.ys() + sr.fp() + (sr.a() * 2.0f);
    }

    public void c(String str) {
        this.bk = str;
    }

    public void f(float f4) {
        this.f29341r = f4;
    }

    public void r(float f4) {
        this.ev = f4;
    }

    public void sr(float f4) {
        this.xv = f4;
    }

    public void ux(float f4) {
        this.f29338f = f4;
    }

    public void w(String str) {
        this.f29337c = str;
    }

    public void xv(float f4) {
        this.f29343w = f4;
    }

    public void c(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                    this.fp.put(Integer.valueOf(optJSONObject.optInt("id")), optJSONObject.optString("value"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void w(float f4) {
        this.ux = f4;
    }

    public void xv(String str) {
        this.gd.sr().f(str);
    }

    public void w(List<List<ev>> list) {
        this.f29336a = list;
    }

    public void c(float f4) {
        this.sr = f4;
    }

    public void c(ux uxVar) {
        this.gd = uxVar;
    }

    public void c(List<ev> list) {
        this.f29340p = list;
    }

    public void c(ev evVar) {
        this.f29339k = evVar;
    }

    public void c(boolean z3) {
        this.f29342t = z3;
    }

    public void c(String str, String str2) {
        this.ys.put(str, str2);
    }

    public String c(int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.gd.getType());
        sb.append(":");
        sb.append(this.f29337c);
        if (this.gd.sr() != null) {
            sb.append(":");
            sb.append(this.gd.sr().mk());
        }
        sb.append(":");
        sb.append(i4);
        return sb.toString();
    }
}
