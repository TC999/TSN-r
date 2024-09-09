package com.qq.e.comm.plugin.g0;

import android.text.TextUtils;
import cn.jpush.android.api.InAppSlotParams;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c0 extends e {

    /* renamed from: g1  reason: collision with root package name */
    int f43494g1;

    /* renamed from: h1  reason: collision with root package name */
    boolean f43495h1;

    /* renamed from: i1  reason: collision with root package name */
    boolean f43496i1;

    /* renamed from: j1  reason: collision with root package name */
    String f43497j1;

    /* renamed from: k1  reason: collision with root package name */
    int f43498k1;

    /* renamed from: l1  reason: collision with root package name */
    int f43499l1;

    /* renamed from: m1  reason: collision with root package name */
    private List<h0> f43500m1;

    /* renamed from: n1  reason: collision with root package name */
    String f43501n1;

    /* renamed from: o1  reason: collision with root package name */
    String f43502o1;

    /* renamed from: p1  reason: collision with root package name */
    String f43503p1;

    /* renamed from: q1  reason: collision with root package name */
    private c0 f43504q1;

    /* renamed from: r1  reason: collision with root package name */
    private boolean f43505r1;

    public c0(String str, String str2, String str3, String str4, JSONObject jSONObject, com.qq.e.comm.plugin.b.l lVar) {
        super(str, str2, str3, str4, com.qq.e.comm.plugin.b.g.SPLASH, jSONObject, lVar);
        d0.a(this, jSONObject);
        a(h0.a(jSONObject.optJSONArray(InAppSlotParams.SLOT_KEY.SLOT)));
        JSONObject optJSONObject = jSONObject.optJSONObject("open_mini_program");
        if (optJSONObject != null) {
            optJSONObject.optInt("enable");
        }
    }

    public final void a(List<h0> list) {
        this.f43500m1 = list;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("apurl");
                if (!TextUtils.isEmpty(optString)) {
                    this.f43531j = optString;
                    this.f43506L.put("apurl", optString);
                }
                String optString2 = jSONObject.optString("rl");
                if (!TextUtils.isEmpty(optString2)) {
                    this.f43535l = optString2;
                    this.f43506L.put("rl", optString2);
                }
                this.f43498k1 = jSONObject.optInt("rot_index", -1);
                List<String> b4 = a0.b(jSONObject.optJSONArray("click_mo_url"));
                if (b4 != null && b4.size() > 0) {
                    this.W = b4;
                }
                List<String> b5 = a0.b(jSONObject.optJSONArray("click_mo_url_sdk"));
                if (b5 == null || b5.size() <= 0) {
                    return;
                }
                this.X = b5;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public void c(boolean z3) {
        this.f43505r1 = z3;
    }

    @Override // com.qq.e.comm.plugin.g0.e
    public boolean e1() {
        return !TextUtils.isEmpty(this.f43497j1);
    }

    public final int o1() {
        return this.f43494g1;
    }

    public final String p1() {
        return this.f43503p1;
    }

    public final c0 q1() {
        return this.f43504q1;
    }

    public final String r1() {
        return this.f43502o1;
    }

    public final List<h0> s1() {
        return this.f43500m1;
    }

    public final int t1() {
        return this.f43499l1;
    }

    public final String u1() {
        return this.f43497j1;
    }

    public final String v1() {
        return this.f43501n1;
    }

    public final boolean w1() {
        return this.f43496i1;
    }

    public final boolean x1() {
        return this.f43495h1;
    }

    public boolean y1() {
        return this.f43505r1;
    }

    public void z1() {
        List<h0> s12 = s1();
        String str = null;
        if (s12 != null && s12.size() > 0) {
            for (h0 h0Var : s12) {
                str = h0Var.a(Integer.valueOf(this.f43498k1));
                if (!TextUtils.isEmpty(str)) {
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.isEmpty(this.f43531j)) {
            this.f43531j = this.f43531j.replace("__SERVER_DATA__", str);
        }
        List<e0> v02 = v0();
        if (v02 != null && v02.size() > 0) {
            for (e0 e0Var : v02) {
                if (e0Var != null) {
                    String a4 = e0Var.a();
                    if (!TextUtils.isEmpty(a4)) {
                        e0Var.a(a4.replace("__SERVER_DATA__", str));
                    }
                }
            }
        }
        List<e0> w02 = w0();
        if (w02 != null && w02.size() > 0) {
            for (e0 e0Var2 : w02) {
                if (e0Var2 != null) {
                    String a5 = e0Var2.a();
                    if (!TextUtils.isEmpty(a5)) {
                        e0Var2.a(a5.replace("__SERVER_DATA__", str));
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(this.f43535l)) {
            this.f43535l = this.f43535l.replace("__SERVER_DATA__", str);
        }
        List<String> list = this.W;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : this.W) {
                arrayList.add(str2.replace("__SERVER_DATA__", str));
            }
            this.W = arrayList;
        }
        List<String> list2 = this.X;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str3 : this.X) {
            arrayList2.add(str3.replace("__SERVER_DATA__", str));
        }
        this.X = arrayList2;
    }

    public final void a(c0 c0Var) {
        this.f43504q1 = c0Var;
    }
}
