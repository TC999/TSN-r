package com.mbridge.msdk.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UnitSetting.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f38757a;
    private long A;
    private long B;
    private int D;
    private int E;
    private int F;
    private int O;
    private int P;
    private String Q;
    private String R;

    /* renamed from: b  reason: collision with root package name */
    private int f38759b;

    /* renamed from: c  reason: collision with root package name */
    private int f38760c;

    /* renamed from: d  reason: collision with root package name */
    private int f38761d;

    /* renamed from: f  reason: collision with root package name */
    private String f38763f;

    /* renamed from: g  reason: collision with root package name */
    private String f38764g;

    /* renamed from: h  reason: collision with root package name */
    private List<Integer> f38765h;

    /* renamed from: i  reason: collision with root package name */
    private long f38766i;

    /* renamed from: k  reason: collision with root package name */
    private int f38768k;

    /* renamed from: l  reason: collision with root package name */
    private List<Integer> f38769l;

    /* renamed from: m  reason: collision with root package name */
    private int f38770m;

    /* renamed from: n  reason: collision with root package name */
    private int f38771n;

    /* renamed from: o  reason: collision with root package name */
    private int f38772o;

    /* renamed from: p  reason: collision with root package name */
    private int f38773p;

    /* renamed from: r  reason: collision with root package name */
    private String f38775r;

    /* renamed from: s  reason: collision with root package name */
    private int f38776s;

    /* renamed from: v  reason: collision with root package name */
    private int f38779v;

    /* renamed from: w  reason: collision with root package name */
    private int f38780w;

    /* renamed from: x  reason: collision with root package name */
    private long f38781x;

    /* renamed from: y  reason: collision with root package name */
    private String f38782y;

    /* renamed from: z  reason: collision with root package name */
    private int f38783z;

    /* renamed from: e  reason: collision with root package name */
    private int f38762e = 30;

    /* renamed from: j  reason: collision with root package name */
    private int f38767j = 1;

    /* renamed from: q  reason: collision with root package name */
    private double f38774q = 1.0d;

    /* renamed from: t  reason: collision with root package name */
    private int f38777t = 1;

    /* renamed from: u  reason: collision with root package name */
    private int f38778u = 5000;
    private int C = 60;
    private String G = "";
    private int H = 10;
    private int I = 60;
    private String J = "";
    private String K = "";

    /* renamed from: L  reason: collision with root package name */
    private int f38758L = 1;
    private int M = 100;
    private int N = 0;

    public static d l() {
        return new d();
    }

    public final String a() {
        return this.J;
    }

    public final void b(int i4) {
        this.F = i4;
    }

    public final int c() {
        return this.D;
    }

    public final int d() {
        return this.P;
    }

    public final double e() {
        return this.f38774q;
    }

    public final int f() {
        return this.M;
    }

    public final int g() {
        return this.N;
    }

    public final int h() {
        return this.O;
    }

    public final long i() {
        return this.f38781x;
    }

    public final int j() {
        return this.f38779v;
    }

    public final int k() {
        return this.f38780w;
    }

    public final int m() {
        return this.f38773p;
    }

    public final int n() {
        return this.f38777t;
    }

    public final int o() {
        return this.f38778u;
    }

    public final int p() {
        return this.f38771n;
    }

    public final int q() {
        return this.f38772o;
    }

    public final List<Integer> r() {
        return this.f38765h;
    }

    public final List<Integer> s() {
        return this.f38769l;
    }

    public final JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        try {
            List<Integer> list = this.f38765h;
            if (list != null && list.size() > 0) {
                int size = this.f38765h.size();
                JSONArray jSONArray = new JSONArray();
                for (int i4 = 0; i4 < size; i4++) {
                    jSONArray.put(this.f38765h.get(i4));
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            List<Integer> list2 = this.f38769l;
            if (list2 != null && list2.size() > 0) {
                int size2 = this.f38769l.size();
                JSONArray jSONArray2 = new JSONArray();
                for (int i5 = 0; i5 < size2; i5++) {
                    jSONArray2.put(this.f38769l.get(i5));
                }
                jSONObject.put("ad_source_timeout", jSONArray2);
            }
            jSONObject.put("tpqn", this.f38770m);
            jSONObject.put("aqn", this.f38771n);
            jSONObject.put("acn", this.f38772o);
            jSONObject.put("wt", this.f38773p);
            jSONObject.put(DomainCampaignEx.JSON_KEY_TTC_TYPE, this.f38768k);
            jSONObject.put("fbPlacementId", this.f38764g);
            jSONObject.put("current_time", this.f38766i);
            jSONObject.put("offset", this.f38767j);
            jSONObject.put("admobUnitId", this.Q);
            jSONObject.put("myTargetSlotId", this.R);
            jSONObject.put("dlct", this.f38781x);
            jSONObject.put("autoplay", this.f38779v);
            jSONObject.put("dlnet", this.f38780w);
            jSONObject.put("no_offer", this.f38782y);
            jSONObject.put("cb_type", this.f38783z);
            jSONObject.put("clct", this.A);
            jSONObject.put("clcq", this.B);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.M);
            jSONObject.put("content", this.O);
            jSONObject.put("impt", this.P);
            jSONObject.put("cbp", this.f38774q);
            jSONObject.put("icon_type", this.f38776s);
            jSONObject.put("no_ads_url", this.f38775r);
            jSONObject.put("playclosebtn_tm", this.f38759b);
            jSONObject.put("play_ctdown", this.f38760c);
            jSONObject.put("close_alert", this.f38761d);
            jSONObject.put("closeBtn", this.D);
            jSONObject.put("refreshFq", this.C);
            jSONObject.put("countdown", this.F);
            jSONObject.put("allowSkip", this.E);
            jSONObject.put("tmorl", this.f38758L);
            jSONObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.f38763f);
            jSONObject.put("placementid", this.G);
            jSONObject.put("ltafemty", this.H);
            jSONObject.put("ltorwc", this.I);
            jSONObject.put("vtag", this.K);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    public final String toString() {
        Iterator<Integer> it;
        List<Integer> list = this.f38765h;
        String str = "";
        if (list != null && list.size() > 0) {
            while (this.f38765h.iterator().hasNext()) {
                str = str + it.next() + ",";
            }
        }
        return "offset = " + this.f38767j + " unitId = " + this.f38763f + " fbPlacementId = " + this.f38764g + str;
    }

    public final long u() {
        return this.f38766i;
    }

    public final int v() {
        return this.f38767j;
    }

    public final int w() {
        return this.H;
    }

    public final int x() {
        return this.I;
    }

    public final String y() {
        return this.K;
    }

    public static d d(String str) {
        d dVar = new d();
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(8);
        arrayList2.add(8);
        dVar.f38768k = 2;
        dVar.f38767j = 1;
        dVar.f38763f = str;
        dVar.f38765h = arrayList;
        dVar.f38769l = arrayList2;
        dVar.f38770m = 1;
        dVar.f38772o = -2;
        dVar.f38771n = -2;
        dVar.f38773p = 5;
        dVar.f38781x = 3600L;
        dVar.f38780w = 2;
        dVar.f38779v = 1;
        dVar.M = 100;
        dVar.N = 0;
        dVar.O = 1;
        dVar.P = 0;
        dVar.C = 60;
        dVar.H = 10;
        dVar.I = 60;
        return dVar;
    }

    public static d e(String str) {
        d dVar = new d();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(1);
            dVar.f38765h = arrayList;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(30);
            dVar.f38769l = arrayList2;
            dVar.f38763f = str;
            dVar.f38768k = 2;
            dVar.f38767j = 1;
            dVar.f38770m = 1;
            dVar.f38772o = -2;
            dVar.f38771n = -2;
            dVar.f38773p = 5;
            dVar.f38781x = 3600L;
            dVar.f38780w = 2;
            dVar.f38779v = 3;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return dVar;
    }

    public static d f(String str) {
        d dVar = new d();
        try {
            dVar.f38763f = str;
            dVar.f38767j = 1;
            dVar.f38770m = 1;
            dVar.f38773p = 5;
            dVar.f38768k = 2;
            dVar.f38772o = 1;
            dVar.f38771n = 1;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return dVar;
    }

    public final void a(int i4) {
        this.E = i4;
    }

    public final int b() {
        return this.C;
    }

    public final void c(int i4) {
        this.f38779v = i4;
    }

    public final void g(String str) {
        this.G = str;
    }

    public static d b(String str) {
        d dVar = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            d dVar2 = new d();
            try {
                JSONObject jSONObject = new JSONObject(str);
                dVar2.f38763f = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                f38757a = jSONObject.optString("atzu");
                String optString = jSONObject.optString("ab_id");
                dVar2.J = optString;
                com.mbridge.msdk.foundation.controller.a.f39078b.put(dVar2.f38763f, optString);
                JSONArray optJSONArray = jSONObject.optJSONArray("adSourceList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        arrayList.add(Integer.valueOf(optJSONArray.optInt(i4)));
                    }
                    dVar2.f38765h = arrayList;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("ad_source_timeout");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                        arrayList2.add(Integer.valueOf(optJSONArray2.optInt(i5)));
                    }
                    dVar2.f38769l = arrayList2;
                }
                dVar2.f38770m = jSONObject.optInt("tpqn");
                dVar2.f38771n = jSONObject.optInt("aqn");
                dVar2.f38772o = jSONObject.optInt("acn");
                dVar2.f38773p = jSONObject.optInt("wt");
                int i6 = 1;
                dVar2.f38777t = jSONObject.optInt("iscasf", 1);
                dVar2.f38778u = jSONObject.optInt("spmxrt", 5000);
                dVar2.f38768k = jSONObject.optInt(DomainCampaignEx.JSON_KEY_TTC_TYPE);
                dVar2.f38764g = jSONObject.optString("fbPlacementId");
                dVar2.f38766i = jSONObject.optLong("current_time");
                dVar2.f38767j = jSONObject.optInt("offset");
                dVar2.Q = jSONObject.optString("admobUnitId");
                dVar2.R = jSONObject.optString("myTargetSlotId");
                dVar2.f38781x = jSONObject.optLong("dlct", 3600L);
                dVar2.f38779v = jSONObject.optInt("autoplay", 0);
                dVar2.f38780w = jSONObject.optInt("dlnet", 2);
                dVar2.f38782y = jSONObject.optString("no_offer");
                dVar2.f38783z = jSONObject.optInt("cb_type");
                dVar2.A = jSONObject.optLong("clct", 86400L);
                dVar2.B = jSONObject.optLong("clcq", 300L);
                dVar2.M = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                dVar2.N = jSONObject.optInt("cd_rate", 0);
                dVar2.O = jSONObject.optInt("content", 1);
                dVar2.P = jSONObject.optInt("impt", 0);
                dVar2.f38774q = jSONObject.optDouble("cbp", 1.0d);
                dVar2.f38776s = jSONObject.optInt("icon_type", 1);
                dVar2.f38775r = jSONObject.optString("no_ads_url", "");
                dVar2.f38759b = jSONObject.optInt("playclosebtn_tm", -1);
                dVar2.f38760c = jSONObject.optInt("play_ctdown", 0);
                dVar2.f38761d = jSONObject.optInt("close_alert", 0);
                dVar2.f38762e = jSONObject.optInt("intershowlimit", 30);
                dVar2.C = jSONObject.optInt("refreshFq", 60);
                dVar2.D = jSONObject.optInt("closeBtn", 0);
                int optInt = jSONObject.optInt("tmorl", 1);
                if (optInt <= 2 && optInt > 0) {
                    i6 = optInt;
                }
                dVar2.f38758L = i6;
                dVar2.G = jSONObject.optString("placementid", "");
                dVar2.H = jSONObject.optInt("ltafemty", 10);
                dVar2.I = jSONObject.optInt("ltorwc", 60);
                dVar2.K = jSONObject.optString("vtag", "");
                return dVar2;
            } catch (Exception e4) {
                e = e4;
                dVar = dVar2;
                e.printStackTrace();
                return dVar;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    public static d c(String str) {
        d l4 = l();
        l4.f38779v = 0;
        return l4;
    }

    public final void a(String str) {
        this.f38763f = str;
    }
}
