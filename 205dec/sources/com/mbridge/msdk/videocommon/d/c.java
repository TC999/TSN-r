package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RewardUnitSetting.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class c {
    private static i O;

    /* renamed from: a  reason: collision with root package name */
    public static String f40974a;
    private int M;
    private int P;

    /* renamed from: b  reason: collision with root package name */
    private String f40976b;

    /* renamed from: c  reason: collision with root package name */
    private String f40977c;

    /* renamed from: d  reason: collision with root package name */
    private List<com.mbridge.msdk.videocommon.b.b> f40978d;

    /* renamed from: e  reason: collision with root package name */
    private long f40979e;

    /* renamed from: u  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.b.c f40995u;

    /* renamed from: z  reason: collision with root package name */
    private ArrayList<Integer> f41000z;

    /* renamed from: f  reason: collision with root package name */
    private int f40980f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f40981g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f40982h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f40983i = 1;

    /* renamed from: j  reason: collision with root package name */
    private int f40984j = 1;

    /* renamed from: k  reason: collision with root package name */
    private int f40985k = 1;

    /* renamed from: l  reason: collision with root package name */
    private int f40986l = 1;

    /* renamed from: m  reason: collision with root package name */
    private double f40987m = 1.0d;

    /* renamed from: n  reason: collision with root package name */
    private int f40988n = 2;

    /* renamed from: o  reason: collision with root package name */
    private int f40989o = 5;

    /* renamed from: p  reason: collision with root package name */
    private int f40990p = 1;

    /* renamed from: q  reason: collision with root package name */
    private int f40991q = 3;

    /* renamed from: r  reason: collision with root package name */
    private int f40992r = 80;

    /* renamed from: s  reason: collision with root package name */
    private int f40993s = 100;

    /* renamed from: t  reason: collision with root package name */
    private int f40994t = 0;

    /* renamed from: v  reason: collision with root package name */
    private double f40996v = 1.0d;

    /* renamed from: w  reason: collision with root package name */
    private int f40997w = -1;

    /* renamed from: x  reason: collision with root package name */
    private int f40998x = 2;

    /* renamed from: y  reason: collision with root package name */
    private double f40999y = 1.0d;
    private int A = 3;
    private int B = 1;
    private int C = 0;
    private int D = 10;
    private int E = 60;
    private String F = "";
    private int G = 0;
    private int H = 70;
    private int I = 0;
    private int J = -1;
    private int K = -1;

    /* renamed from: L  reason: collision with root package name */
    private int f40975L = -1;
    private int N = 20;
    private int Q = 0;
    private int R = 1;
    private String S = "";
    private int T = 1;
    private String U = "";
    private int V = 1;
    private String W = "Virtual Item";
    private int X = 0;
    private int Y = 1;
    private int Z = 60;
    private String aa = "";

    private void B(int i4) {
        if (i4 <= 0) {
            this.T = 1;
        } else {
            this.T = i4;
        }
    }

    private void d(String str) {
        this.F = str;
        com.mbridge.msdk.foundation.controller.a.f39078b.put(this.f40976b, str);
    }

    public final int A() {
        return this.f40998x;
    }

    public final int C() {
        return this.B;
    }

    public final String D() {
        return this.f40977c;
    }

    public final int E() {
        return this.A;
    }

    public final Queue<Integer> F() {
        LinkedList linkedList;
        Exception e4;
        List<com.mbridge.msdk.videocommon.b.b> list;
        try {
            list = this.f40978d;
        } catch (Exception e5) {
            linkedList = null;
            e4 = e5;
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        linkedList = new LinkedList();
        for (int i4 = 0; i4 < this.f40978d.size(); i4++) {
            try {
                linkedList.add(Integer.valueOf(this.f40978d.get(i4).b()));
            } catch (Exception e6) {
                e4 = e6;
                e4.printStackTrace();
                return linkedList;
            }
        }
        return linkedList;
    }

    public final JSONObject G() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.f40976b);
            jSONObject.put("callbackType", this.f40983i);
            List<com.mbridge.msdk.videocommon.b.b> list = this.f40978d;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.mbridge.msdk.videocommon.b.b bVar : this.f40978d) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", bVar.a());
                    jSONObject2.put("timeout", bVar.b());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            jSONObject.put("aqn", this.f40984j);
            jSONObject.put("acn", this.f40985k);
            jSONObject.put("vcn", this.f40986l);
            jSONObject.put("cbp", this.f40987m);
            jSONObject.put(DomainCampaignEx.JSON_KEY_TTC_TYPE, this.f40988n);
            jSONObject.put("offset", this.f40989o);
            jSONObject.put("dlnet", this.f40990p);
            jSONObject.put("tv_start", this.f40991q);
            jSONObject.put("tv_end", this.f40992r);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.f40993s);
            jSONObject.put("endscreen_type", this.P);
            jSONObject.put("daily_play_cap", this.I);
            jSONObject.put("video_skip_time", this.J);
            jSONObject.put("video_skip_result", this.K);
            jSONObject.put("video_interactive_type", this.f40975L);
            jSONObject.put("orientation", this.G);
            jSONObject.put("close_button_delay", this.M);
            jSONObject.put("playclosebtn_tm", this.f40980f);
            jSONObject.put("play_ctdown", this.f40981g);
            jSONObject.put("close_alert", this.f40982h);
            jSONObject.put("rfpv", this.f40997w);
            jSONObject.put("vdcmp", this.f40996v);
            if (this.f40995u != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("type", this.f40995u.a());
                JSONArray jSONArray2 = new JSONArray();
                for (Integer num : this.f40995u.b()) {
                    jSONArray2.put(num);
                }
                jSONObject3.put("value", jSONArray2);
                jSONObject.put("cbprule", jSONObject3);
            }
            jSONObject.put("ccbprule", this.f40998x);
            jSONObject.put("ccbp", this.f40999y);
            JSONArray jSONArray3 = new JSONArray();
            ArrayList<Integer> arrayList = this.f41000z;
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    Iterator<Integer> it = this.f41000z.iterator();
                    while (it.hasNext()) {
                        jSONArray3.put(it.next());
                    }
                }
                jSONObject.put("atl_type", jSONArray3);
            }
            jSONObject.put("atl_dyt", this.A);
            jSONObject.put("tmorl", this.B);
            jSONObject.put("hitcbp", this.C);
            jSONObject.put("placementid", this.f40977c);
            jSONObject.put("ltafemty", this.D);
            jSONObject.put("ltorwc", this.E);
            jSONObject.put(RewardPlus.AMOUNT_MAX, this.Q);
            jSONObject.put(RewardPlus.CALLBACK_RULE, this.R);
            jSONObject.put(RewardPlus.VIRTUAL_CURRENCY, this.S);
            jSONObject.put(RewardPlus.AMOUNT, this.T);
            jSONObject.put(RewardPlus.ICON, this.U);
            jSONObject.put(RewardPlus.CURRENCY_ID, this.V);
            jSONObject.put("name", this.W);
            jSONObject.put("isDefault", this.X);
            jSONObject.put("video_error_rule", this.Y);
            jSONObject.put("loadtmo", this.Z);
            jSONObject.put("vtag", this.aa);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    public final int H() {
        return this.H;
    }

    public final int I() {
        return this.Y;
    }

    public final int J() {
        return this.Z;
    }

    public final String a() {
        return this.F;
    }

    public final int b() {
        return this.D;
    }

    public final int c() {
        return this.E;
    }

    public final int e() {
        return this.G;
    }

    public final int f() {
        return this.I;
    }

    public final int g() {
        return this.J;
    }

    public final int h() {
        return this.K;
    }

    public final int i() {
        return this.f40975L;
    }

    public final int j() {
        return this.f40980f;
    }

    public final int k() {
        return this.f40982h;
    }

    public final String l() {
        return this.aa;
    }

    public final int m() {
        return this.T;
    }

    public final String n() {
        return this.W;
    }

    public final int o() {
        return this.N;
    }

    public final int p() {
        return this.M;
    }

    public final int q() {
        return this.P;
    }

    public final int r() {
        return this.f40993s;
    }

    public final int s() {
        return this.f40994t;
    }

    public final int t() {
        return this.f40984j;
    }

    public final int u() {
        return this.f40985k;
    }

    public final int v() {
        return this.f40989o;
    }

    public final int w() {
        return this.f40990p;
    }

    public final long x() {
        return this.f40979e;
    }

    public final List<com.mbridge.msdk.videocommon.b.b> y() {
        return this.f40978d;
    }

    public final com.mbridge.msdk.videocommon.b.c z() {
        return this.f40995u;
    }

    public final void A(int i4) {
        this.Z = i4;
    }

    public final void a(int i4) {
        this.C = i4;
    }

    public final void b(int i4) {
        this.G = i4;
    }

    public final void c(int i4) {
        this.I = i4;
    }

    public final void e(int i4) {
        this.K = i4;
    }

    public final void f(int i4) {
        this.f40975L = i4;
    }

    public final void g(int i4) {
        this.M = i4;
    }

    public final void h(int i4) {
        this.P = i4;
    }

    public final void i(int i4) {
        this.f40991q = i4;
    }

    public final void j(int i4) {
        this.f40992r = i4;
    }

    public final void k(int i4) {
        this.f40993s = i4;
    }

    public final void l(int i4) {
        this.f40994t = i4;
    }

    public final void m(int i4) {
        this.f40984j = i4;
    }

    public final void n(int i4) {
        this.f40985k = i4;
    }

    public final void o(int i4) {
        this.f40986l = i4;
    }

    public final void p(int i4) {
        this.f40988n = i4;
    }

    public final void q(int i4) {
        this.f40989o = i4;
    }

    public final void r(int i4) {
        this.f40990p = i4;
    }

    public final void s(int i4) {
        this.f40983i = i4;
    }

    public final void t(int i4) {
        this.f40998x = i4;
    }

    public final void u(int i4) {
        this.B = i4;
    }

    public final boolean v(int i4) {
        ArrayList<Integer> arrayList = this.f41000z;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return this.f41000z.contains(Integer.valueOf(i4));
    }

    public final void w(int i4) {
        this.A = i4;
    }

    public final void x(int i4) {
        this.H = i4;
    }

    public final void y(int i4) {
        this.X = i4;
    }

    public final void z(int i4) {
        this.Y = i4;
    }

    public static c c(String str) {
        JSONObject optJSONObject;
        int i4;
        if (O == null) {
            O = i.a(com.mbridge.msdk.foundation.controller.a.f().j());
        }
        c cVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("vtag", "");
                JSONArray optJSONArray = jSONObject.optJSONArray("unitSetting");
                if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                    return null;
                }
                String optString2 = optJSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                if (TextUtils.isEmpty(optString2)) {
                    return null;
                }
                c cVar2 = new c();
                try {
                    cVar2.aa = optString;
                    List<com.mbridge.msdk.videocommon.b.b> a4 = com.mbridge.msdk.videocommon.b.b.a(optJSONObject.optJSONArray("adSourceList"));
                    cVar2.f40976b = optString2;
                    cVar2.f40978d = a4;
                    cVar2.f40983i = optJSONObject.optInt("callbackType");
                    int optInt = optJSONObject.optInt("aqn", 1);
                    if (optInt <= 0) {
                        optInt = 1;
                    }
                    cVar2.f40984j = optInt;
                    int optInt2 = optJSONObject.optInt("acn", 1);
                    if (optInt2 < 0) {
                        optInt2 = 1;
                    }
                    cVar2.f40985k = optInt2;
                    cVar2.f40986l = optJSONObject.optInt("vcn", 5);
                    cVar2.f40987m = optJSONObject.optDouble("cbp", 1.0d);
                    cVar2.f40988n = optJSONObject.optInt(DomainCampaignEx.JSON_KEY_TTC_TYPE, 2);
                    cVar2.f40989o = optJSONObject.optInt("offset", 5);
                    cVar2.f40990p = optJSONObject.optInt("dlnet", 1);
                    cVar2.P = optJSONObject.optInt("endscreen_type", 2);
                    cVar2.f40991q = optJSONObject.optInt("tv_start", 3);
                    cVar2.f40992r = optJSONObject.optInt("tv_end", 80);
                    cVar2.f40993s = optJSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                    cVar2.f40994t = optJSONObject.optInt("cd_rate", 0);
                    cVar2.f40979e = jSONObject.optLong("current_time");
                    cVar2.G = optJSONObject.optInt("orientation", 0);
                    cVar2.I = optJSONObject.optInt("daily_play_cap", 0);
                    cVar2.J = optJSONObject.optInt("video_skip_time", -1);
                    cVar2.K = optJSONObject.optInt("video_skip_result", 2);
                    cVar2.f40975L = optJSONObject.optInt("video_interactive_type", -1);
                    cVar2.M = optJSONObject.optInt("close_button_delay", 1);
                    cVar2.f40980f = optJSONObject.optInt("playclosebtn_tm", -1);
                    cVar2.f40981g = optJSONObject.optInt("play_ctdown", 0);
                    cVar2.f40982h = optJSONObject.optInt("close_alert", 0);
                    cVar2.N = optJSONObject.optInt("rdrct", 20);
                    cVar2.H = optJSONObject.optInt("load_global_timeout", 70);
                    cVar2.f40997w = optJSONObject.optInt("rfpv", -1);
                    cVar2.f40996v = optJSONObject.optDouble("vdcmp", 1.0d);
                    cVar2.f40995u = com.mbridge.msdk.videocommon.b.c.a(optJSONObject.optJSONObject("cbprule"));
                    cVar2.f40998x = optJSONObject.optInt("ccbprule", 2);
                    cVar2.f40999y = optJSONObject.optDouble("ccbp", 1.0d);
                    f40974a = optJSONObject.optString("atzu");
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("atl_type");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    try {
                        if (optJSONArray2 != null) {
                            for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                                arrayList.add(Integer.valueOf(optJSONArray2.getInt(i5)));
                            }
                        } else {
                            arrayList.add(4);
                            arrayList.add(6);
                        }
                        cVar2.f41000z = arrayList;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    int optInt3 = optJSONObject.optInt("atl_dyt", 0);
                    cVar2.A = optInt3 > 0 ? optInt3 : 3;
                    int optInt4 = optJSONObject.optInt("tmorl", 1);
                    cVar2.B = (optInt4 > 2 || optInt4 <= 0) ? 1 : 1;
                    if (cVar2.f40987m != 1.0d && new Random().nextDouble() > cVar2.f40987m) {
                        i4 = 1;
                        cVar2.C = i4;
                        cVar2.f40977c = optJSONObject.optString("placementid");
                        cVar2.D = optJSONObject.optInt("ltafemty", 10);
                        cVar2.E = optJSONObject.optInt("ltorwc", 60);
                        cVar2.d(optJSONObject.optString("ab_id"));
                        cVar2.Q = optJSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                        cVar2.R = optJSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                        cVar2.S = optJSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                        cVar2.B(optJSONObject.optInt(RewardPlus.AMOUNT, 1));
                        cVar2.U = optJSONObject.optString(RewardPlus.ICON, "");
                        cVar2.V = optJSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                        cVar2.e(optJSONObject.optString("name", "Virtual Item"));
                        cVar2.Y = optJSONObject.optInt("video_error_rule", 1);
                        cVar2.Z = optJSONObject.optInt("loadtmo", 60);
                        return cVar2;
                    }
                    i4 = 0;
                    cVar2.C = i4;
                    cVar2.f40977c = optJSONObject.optString("placementid");
                    cVar2.D = optJSONObject.optInt("ltafemty", 10);
                    cVar2.E = optJSONObject.optInt("ltorwc", 60);
                    cVar2.d(optJSONObject.optString("ab_id"));
                    cVar2.Q = optJSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                    cVar2.R = optJSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                    cVar2.S = optJSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                    cVar2.B(optJSONObject.optInt(RewardPlus.AMOUNT, 1));
                    cVar2.U = optJSONObject.optString(RewardPlus.ICON, "");
                    cVar2.V = optJSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                    cVar2.e(optJSONObject.optString("name", "Virtual Item"));
                    cVar2.Y = optJSONObject.optInt("video_error_rule", 1);
                    cVar2.Z = optJSONObject.optInt("loadtmo", 60);
                    return cVar2;
                } catch (Exception e5) {
                    e = e5;
                    cVar = cVar2;
                    e.printStackTrace();
                    return cVar;
                }
            } catch (Exception e6) {
                e = e6;
            }
        }
        return cVar;
    }

    private void e(String str) {
        if (TextUtils.isEmpty(str)) {
            this.W = this.S;
        } else {
            this.W = str;
        }
    }

    public final double B() {
        return this.f40999y;
    }

    public final void a(ArrayList<Integer> arrayList) {
        this.f41000z = arrayList;
    }

    public final void b(double d4) {
        this.f40999y = d4;
    }

    public final int d() {
        return this.C;
    }

    public final void a(double d4) {
        this.f40987m = d4;
    }

    public final void b(String str) {
        this.f40977c = str;
    }

    public final void d(int i4) {
        this.J = i4;
    }

    public final void a(String str) {
        this.f40976b = str;
    }

    public final void a(List<com.mbridge.msdk.videocommon.b.b> list) {
        this.f40978d = list;
    }

    public static c a(JSONObject jSONObject) {
        int i4;
        c cVar = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            c cVar2 = new c();
            try {
                cVar2.f40978d = com.mbridge.msdk.videocommon.b.b.a(jSONObject.optJSONArray("adSourceList"));
                cVar2.f40983i = jSONObject.optInt("callbackType");
                int optInt = jSONObject.optInt("aqn", 1);
                if (optInt <= 0) {
                    optInt = 1;
                }
                cVar2.f40984j = optInt;
                int optInt2 = jSONObject.optInt("acn", 1);
                if (optInt2 < 0) {
                    optInt2 = 1;
                }
                cVar2.f40985k = optInt2;
                cVar2.f40986l = jSONObject.optInt("vcn", 5);
                cVar2.f40987m = jSONObject.optDouble("cbp", 1.0d);
                cVar2.f40988n = jSONObject.optInt(DomainCampaignEx.JSON_KEY_TTC_TYPE, 2);
                cVar2.f40989o = jSONObject.optInt("offset", 5);
                cVar2.f40990p = jSONObject.optInt("dlnet", 2);
                cVar2.P = jSONObject.optInt("endscreen_type", 2);
                cVar2.f40991q = jSONObject.optInt("tv_start", 3);
                cVar2.f40992r = jSONObject.optInt("tv_end", 80);
                cVar2.f40993s = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                cVar2.f40979e = jSONObject.optLong("current_time");
                cVar2.G = jSONObject.optInt("orientation", 0);
                cVar2.I = jSONObject.optInt("daily_play_cap", 0);
                cVar2.J = jSONObject.optInt("video_skip_time", -1);
                cVar2.K = jSONObject.optInt("video_skip_result", 2);
                cVar2.f40975L = jSONObject.optInt("video_interactive_type", -1);
                cVar2.M = jSONObject.optInt("close_button_delay", 1);
                cVar2.f40980f = jSONObject.optInt("playclosebtn_tm", -1);
                cVar2.f40981g = jSONObject.optInt("play_ctdown", 0);
                cVar2.f40982h = jSONObject.optInt("close_alert", 0);
                cVar2.N = jSONObject.optInt("rdrct", 20);
                cVar2.f40997w = jSONObject.optInt("rfpv", -1);
                cVar2.f40996v = jSONObject.optDouble("vdcmp", 1.0d);
                cVar2.f40995u = com.mbridge.msdk.videocommon.b.c.a(jSONObject.optJSONObject("cbprule"));
                cVar2.f40998x = jSONObject.optInt("ccbprule", 2);
                cVar2.f40999y = jSONObject.optDouble("ccbp", 1.0d);
                cVar2.H = jSONObject.optInt("load_global_timeout", 70);
                JSONArray optJSONArray = jSONObject.optJSONArray("atl_type");
                ArrayList<Integer> arrayList = new ArrayList<>();
                try {
                    if (optJSONArray != null) {
                        for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                            arrayList.add(Integer.valueOf(optJSONArray.getInt(i5)));
                        }
                    } else {
                        arrayList.add(4);
                        arrayList.add(6);
                    }
                    cVar2.f41000z = arrayList;
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                cVar2.A = jSONObject.optInt("atl_dyt", 3);
                int optInt3 = jSONObject.optInt("tmorl", 1);
                cVar2.B = (optInt3 > 2 || optInt3 <= 0) ? 1 : 1;
                if (cVar2.f40987m != 1.0d && new Random().nextDouble() > cVar2.f40987m) {
                    i4 = 1;
                    cVar2.C = i4;
                    cVar2.f40977c = jSONObject.optString("placementid");
                    cVar2.D = jSONObject.optInt("ltafemty", 10);
                    cVar2.E = jSONObject.optInt("ltorwc", 60);
                    cVar2.d(jSONObject.optString("ab_id"));
                    cVar2.Q = jSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                    cVar2.R = jSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                    cVar2.S = jSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                    cVar2.B(jSONObject.optInt(RewardPlus.AMOUNT, 1));
                    cVar2.U = jSONObject.optString(RewardPlus.ICON, "");
                    cVar2.V = jSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                    cVar2.e(jSONObject.optString("name", "Virtual Item"));
                    cVar2.Y = jSONObject.optInt("video_error_rule", 1);
                    cVar2.Z = jSONObject.optInt("loadtmo", 60);
                    cVar2.aa = jSONObject.optString("vtag", "");
                    return cVar2;
                }
                i4 = 0;
                cVar2.C = i4;
                cVar2.f40977c = jSONObject.optString("placementid");
                cVar2.D = jSONObject.optInt("ltafemty", 10);
                cVar2.E = jSONObject.optInt("ltorwc", 60);
                cVar2.d(jSONObject.optString("ab_id"));
                cVar2.Q = jSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                cVar2.R = jSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                cVar2.S = jSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                cVar2.B(jSONObject.optInt(RewardPlus.AMOUNT, 1));
                cVar2.U = jSONObject.optString(RewardPlus.ICON, "");
                cVar2.V = jSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                cVar2.e(jSONObject.optString("name", "Virtual Item"));
                cVar2.Y = jSONObject.optInt("video_error_rule", 1);
                cVar2.Z = jSONObject.optInt("loadtmo", 60);
                cVar2.aa = jSONObject.optString("vtag", "");
                return cVar2;
            } catch (Exception e5) {
                e = e5;
                cVar = cVar2;
                e.printStackTrace();
                return cVar;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }
}
