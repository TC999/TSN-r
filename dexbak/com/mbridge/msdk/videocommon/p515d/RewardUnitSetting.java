package com.mbridge.msdk.videocommon.p515d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.videocommon.p513b.AdUnitInfo;
import com.mbridge.msdk.videocommon.p513b.Cbprule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: com.mbridge.msdk.videocommon.d.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class RewardUnitSetting {

    /* renamed from: O */
    private static CommonSDKDBHelper f32226O;

    /* renamed from: a */
    public static String f32227a;

    /* renamed from: M */
    private int f32240M;

    /* renamed from: P */
    private int f32242P;

    /* renamed from: b */
    private String f32254b;

    /* renamed from: c */
    private String f32255c;

    /* renamed from: d */
    private List<AdUnitInfo> f32256d;

    /* renamed from: e */
    private long f32257e;

    /* renamed from: u */
    private Cbprule f32273u;

    /* renamed from: z */
    private ArrayList<Integer> f32278z;

    /* renamed from: f */
    private int f32258f = -1;

    /* renamed from: g */
    private int f32259g = 0;

    /* renamed from: h */
    private int f32260h = 0;

    /* renamed from: i */
    private int f32261i = 1;

    /* renamed from: j */
    private int f32262j = 1;

    /* renamed from: k */
    private int f32263k = 1;

    /* renamed from: l */
    private int f32264l = 1;

    /* renamed from: m */
    private double f32265m = 1.0d;

    /* renamed from: n */
    private int f32266n = 2;

    /* renamed from: o */
    private int f32267o = 5;

    /* renamed from: p */
    private int f32268p = 1;

    /* renamed from: q */
    private int f32269q = 3;

    /* renamed from: r */
    private int f32270r = 80;

    /* renamed from: s */
    private int f32271s = 100;

    /* renamed from: t */
    private int f32272t = 0;

    /* renamed from: v */
    private double f32274v = 1.0d;

    /* renamed from: w */
    private int f32275w = -1;

    /* renamed from: x */
    private int f32276x = 2;

    /* renamed from: y */
    private double f32277y = 1.0d;

    /* renamed from: A */
    private int f32228A = 3;

    /* renamed from: B */
    private int f32229B = 1;

    /* renamed from: C */
    private int f32230C = 0;

    /* renamed from: D */
    private int f32231D = 10;

    /* renamed from: E */
    private int f32232E = 60;

    /* renamed from: F */
    private String f32233F = "";

    /* renamed from: G */
    private int f32234G = 0;

    /* renamed from: H */
    private int f32235H = 70;

    /* renamed from: I */
    private int f32236I = 0;

    /* renamed from: J */
    private int f32237J = -1;

    /* renamed from: K */
    private int f32238K = -1;

    /* renamed from: L */
    private int f32239L = -1;

    /* renamed from: N */
    private int f32241N = 20;

    /* renamed from: Q */
    private int f32243Q = 0;

    /* renamed from: R */
    private int f32244R = 1;

    /* renamed from: S */
    private String f32245S = "";

    /* renamed from: T */
    private int f32246T = 1;

    /* renamed from: U */
    private String f32247U = "";

    /* renamed from: V */
    private int f32248V = 1;

    /* renamed from: W */
    private String f32249W = "Virtual Item";

    /* renamed from: X */
    private int f32250X = 0;

    /* renamed from: Y */
    private int f32251Y = 1;

    /* renamed from: Z */
    private int f32252Z = 60;

    /* renamed from: aa */
    private String f32253aa = "";

    /* renamed from: B */
    private void m20816B(int i) {
        if (i <= 0) {
            this.f32246T = 1;
        } else {
            this.f32246T = i;
        }
    }

    /* renamed from: d */
    private void m20791d(String str) {
        this.f32233F = str;
        MBSDKContext.f30251b.put(this.f32254b, str);
    }

    /* renamed from: A */
    public final int m20819A() {
        return this.f32276x;
    }

    /* renamed from: C */
    public final int m20815C() {
        return this.f32229B;
    }

    /* renamed from: D */
    public final String m20814D() {
        return this.f32255c;
    }

    /* renamed from: E */
    public final int m20813E() {
        return this.f32228A;
    }

    /* renamed from: F */
    public final Queue<Integer> m20812F() {
        LinkedList linkedList;
        Exception e;
        List<AdUnitInfo> list;
        try {
            list = this.f32256d;
        } catch (Exception e2) {
            linkedList = null;
            e = e2;
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        linkedList = new LinkedList();
        for (int i = 0; i < this.f32256d.size(); i++) {
            try {
                linkedList.add(Integer.valueOf(this.f32256d.get(i).m20876b()));
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return linkedList;
            }
        }
        return linkedList;
    }

    /* renamed from: G */
    public final JSONObject m20811G() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.f32254b);
            jSONObject.put("callbackType", this.f32261i);
            List<AdUnitInfo> list = this.f32256d;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (AdUnitInfo adUnitInfo : this.f32256d) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", adUnitInfo.m20878a());
                    jSONObject2.put("timeout", adUnitInfo.m20876b());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            jSONObject.put("aqn", this.f32262j);
            jSONObject.put("acn", this.f32263k);
            jSONObject.put("vcn", this.f32264l);
            jSONObject.put("cbp", this.f32265m);
            jSONObject.put(DomainCampaignEx.JSON_KEY_TTC_TYPE, this.f32266n);
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET, this.f32267o);
            jSONObject.put("dlnet", this.f32268p);
            jSONObject.put("tv_start", this.f32269q);
            jSONObject.put("tv_end", this.f32270r);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.f32271s);
            jSONObject.put("endscreen_type", this.f32242P);
            jSONObject.put("daily_play_cap", this.f32236I);
            jSONObject.put("video_skip_time", this.f32237J);
            jSONObject.put("video_skip_result", this.f32238K);
            jSONObject.put("video_interactive_type", this.f32239L);
            jSONObject.put("orientation", this.f32234G);
            jSONObject.put("close_button_delay", this.f32240M);
            jSONObject.put("playclosebtn_tm", this.f32258f);
            jSONObject.put("play_ctdown", this.f32259g);
            jSONObject.put("close_alert", this.f32260h);
            jSONObject.put("rfpv", this.f32275w);
            jSONObject.put("vdcmp", this.f32274v);
            if (this.f32273u != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("type", this.f32273u.m20875a());
                JSONArray jSONArray2 = new JSONArray();
                for (Integer num : this.f32273u.m20873b()) {
                    jSONArray2.put(num);
                }
                jSONObject3.put(DomainCampaignEx.LOOPBACK_VALUE, jSONArray2);
                jSONObject.put("cbprule", jSONObject3);
            }
            jSONObject.put("ccbprule", this.f32276x);
            jSONObject.put("ccbp", this.f32277y);
            JSONArray jSONArray3 = new JSONArray();
            ArrayList<Integer> arrayList = this.f32278z;
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                    Iterator<Integer> it = this.f32278z.iterator();
                    while (it.hasNext()) {
                        jSONArray3.put(it.next());
                    }
                }
                jSONObject.put("atl_type", jSONArray3);
            }
            jSONObject.put("atl_dyt", this.f32228A);
            jSONObject.put("tmorl", this.f32229B);
            jSONObject.put("hitcbp", this.f32230C);
            jSONObject.put("placementid", this.f32255c);
            jSONObject.put("ltafemty", this.f32231D);
            jSONObject.put("ltorwc", this.f32232E);
            jSONObject.put(RewardPlus.AMOUNT_MAX, this.f32243Q);
            jSONObject.put(RewardPlus.CALLBACK_RULE, this.f32244R);
            jSONObject.put(RewardPlus.VIRTUAL_CURRENCY, this.f32245S);
            jSONObject.put(RewardPlus.AMOUNT, this.f32246T);
            jSONObject.put(RewardPlus.ICON, this.f32247U);
            jSONObject.put(RewardPlus.CURRENCY_ID, this.f32248V);
            jSONObject.put("name", this.f32249W);
            jSONObject.put("isDefault", this.f32250X);
            jSONObject.put("video_error_rule", this.f32251Y);
            jSONObject.put("loadtmo", this.f32252Z);
            jSONObject.put("vtag", this.f32253aa);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: H */
    public final int m20810H() {
        return this.f32235H;
    }

    /* renamed from: I */
    public final int m20809I() {
        return this.f32251Y;
    }

    /* renamed from: J */
    public final int m20808J() {
        return this.f32252Z;
    }

    /* renamed from: a */
    public final String m20807a() {
        return this.f32233F;
    }

    /* renamed from: b */
    public final int m20800b() {
        return this.f32231D;
    }

    /* renamed from: c */
    public final int m20796c() {
        return this.f32232E;
    }

    /* renamed from: e */
    public final int m20790e() {
        return this.f32234G;
    }

    /* renamed from: f */
    public final int m20787f() {
        return this.f32236I;
    }

    /* renamed from: g */
    public final int m20785g() {
        return this.f32237J;
    }

    /* renamed from: h */
    public final int m20783h() {
        return this.f32238K;
    }

    /* renamed from: i */
    public final int m20781i() {
        return this.f32239L;
    }

    /* renamed from: j */
    public final int m20779j() {
        return this.f32258f;
    }

    /* renamed from: k */
    public final int m20777k() {
        return this.f32260h;
    }

    /* renamed from: l */
    public final String m20775l() {
        return this.f32253aa;
    }

    /* renamed from: m */
    public final int m20773m() {
        return this.f32246T;
    }

    /* renamed from: n */
    public final String m20771n() {
        return this.f32249W;
    }

    /* renamed from: o */
    public final int m20769o() {
        return this.f32241N;
    }

    /* renamed from: p */
    public final int m20767p() {
        return this.f32240M;
    }

    /* renamed from: q */
    public final int m20765q() {
        return this.f32242P;
    }

    /* renamed from: r */
    public final int m20763r() {
        return this.f32271s;
    }

    /* renamed from: s */
    public final int m20761s() {
        return this.f32272t;
    }

    /* renamed from: t */
    public final int m20759t() {
        return this.f32262j;
    }

    /* renamed from: u */
    public final int m20757u() {
        return this.f32263k;
    }

    /* renamed from: v */
    public final int m20755v() {
        return this.f32267o;
    }

    /* renamed from: w */
    public final int m20753w() {
        return this.f32268p;
    }

    /* renamed from: x */
    public final long m20751x() {
        return this.f32257e;
    }

    /* renamed from: y */
    public final List<AdUnitInfo> m20749y() {
        return this.f32256d;
    }

    /* renamed from: z */
    public final Cbprule m20747z() {
        return this.f32273u;
    }

    /* renamed from: A */
    public final void m20818A(int i) {
        this.f32252Z = i;
    }

    /* renamed from: a */
    public final void m20805a(int i) {
        this.f32230C = i;
    }

    /* renamed from: b */
    public final void m20798b(int i) {
        this.f32234G = i;
    }

    /* renamed from: c */
    public final void m20795c(int i) {
        this.f32236I = i;
    }

    /* renamed from: e */
    public final void m20789e(int i) {
        this.f32238K = i;
    }

    /* renamed from: f */
    public final void m20786f(int i) {
        this.f32239L = i;
    }

    /* renamed from: g */
    public final void m20784g(int i) {
        this.f32240M = i;
    }

    /* renamed from: h */
    public final void m20782h(int i) {
        this.f32242P = i;
    }

    /* renamed from: i */
    public final void m20780i(int i) {
        this.f32269q = i;
    }

    /* renamed from: j */
    public final void m20778j(int i) {
        this.f32270r = i;
    }

    /* renamed from: k */
    public final void m20776k(int i) {
        this.f32271s = i;
    }

    /* renamed from: l */
    public final void m20774l(int i) {
        this.f32272t = i;
    }

    /* renamed from: m */
    public final void m20772m(int i) {
        this.f32262j = i;
    }

    /* renamed from: n */
    public final void m20770n(int i) {
        this.f32263k = i;
    }

    /* renamed from: o */
    public final void m20768o(int i) {
        this.f32264l = i;
    }

    /* renamed from: p */
    public final void m20766p(int i) {
        this.f32266n = i;
    }

    /* renamed from: q */
    public final void m20764q(int i) {
        this.f32267o = i;
    }

    /* renamed from: r */
    public final void m20762r(int i) {
        this.f32268p = i;
    }

    /* renamed from: s */
    public final void m20760s(int i) {
        this.f32261i = i;
    }

    /* renamed from: t */
    public final void m20758t(int i) {
        this.f32276x = i;
    }

    /* renamed from: u */
    public final void m20756u(int i) {
        this.f32229B = i;
    }

    /* renamed from: v */
    public final boolean m20754v(int i) {
        ArrayList<Integer> arrayList = this.f32278z;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return this.f32278z.contains(Integer.valueOf(i));
    }

    /* renamed from: w */
    public final void m20752w(int i) {
        this.f32228A = i;
    }

    /* renamed from: x */
    public final void m20750x(int i) {
        this.f32235H = i;
    }

    /* renamed from: y */
    public final void m20748y(int i) {
        this.f32250X = i;
    }

    /* renamed from: z */
    public final void m20746z(int i) {
        this.f32251Y = i;
    }

    /* renamed from: c */
    public static RewardUnitSetting m20794c(String str) {
        JSONObject optJSONObject;
        int i;
        if (f32226O == null) {
            f32226O = CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j());
        }
        RewardUnitSetting rewardUnitSetting = null;
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
                RewardUnitSetting rewardUnitSetting2 = new RewardUnitSetting();
                try {
                    rewardUnitSetting2.f32253aa = optString;
                    List<AdUnitInfo> m20877a = AdUnitInfo.m20877a(optJSONObject.optJSONArray("adSourceList"));
                    rewardUnitSetting2.f32254b = optString2;
                    rewardUnitSetting2.f32256d = m20877a;
                    rewardUnitSetting2.f32261i = optJSONObject.optInt("callbackType");
                    int optInt = optJSONObject.optInt("aqn", 1);
                    if (optInt <= 0) {
                        optInt = 1;
                    }
                    rewardUnitSetting2.f32262j = optInt;
                    int optInt2 = optJSONObject.optInt("acn", 1);
                    if (optInt2 < 0) {
                        optInt2 = 1;
                    }
                    rewardUnitSetting2.f32263k = optInt2;
                    rewardUnitSetting2.f32264l = optJSONObject.optInt("vcn", 5);
                    rewardUnitSetting2.f32265m = optJSONObject.optDouble("cbp", 1.0d);
                    rewardUnitSetting2.f32266n = optJSONObject.optInt(DomainCampaignEx.JSON_KEY_TTC_TYPE, 2);
                    rewardUnitSetting2.f32267o = optJSONObject.optInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET, 5);
                    rewardUnitSetting2.f32268p = optJSONObject.optInt("dlnet", 1);
                    rewardUnitSetting2.f32242P = optJSONObject.optInt("endscreen_type", 2);
                    rewardUnitSetting2.f32269q = optJSONObject.optInt("tv_start", 3);
                    rewardUnitSetting2.f32270r = optJSONObject.optInt("tv_end", 80);
                    rewardUnitSetting2.f32271s = optJSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                    rewardUnitSetting2.f32272t = optJSONObject.optInt("cd_rate", 0);
                    rewardUnitSetting2.f32257e = jSONObject.optLong("current_time");
                    rewardUnitSetting2.f32234G = optJSONObject.optInt("orientation", 0);
                    rewardUnitSetting2.f32236I = optJSONObject.optInt("daily_play_cap", 0);
                    rewardUnitSetting2.f32237J = optJSONObject.optInt("video_skip_time", -1);
                    rewardUnitSetting2.f32238K = optJSONObject.optInt("video_skip_result", 2);
                    rewardUnitSetting2.f32239L = optJSONObject.optInt("video_interactive_type", -1);
                    rewardUnitSetting2.f32240M = optJSONObject.optInt("close_button_delay", 1);
                    rewardUnitSetting2.f32258f = optJSONObject.optInt("playclosebtn_tm", -1);
                    rewardUnitSetting2.f32259g = optJSONObject.optInt("play_ctdown", 0);
                    rewardUnitSetting2.f32260h = optJSONObject.optInt("close_alert", 0);
                    rewardUnitSetting2.f32241N = optJSONObject.optInt("rdrct", 20);
                    rewardUnitSetting2.f32235H = optJSONObject.optInt("load_global_timeout", 70);
                    rewardUnitSetting2.f32275w = optJSONObject.optInt("rfpv", -1);
                    rewardUnitSetting2.f32274v = optJSONObject.optDouble("vdcmp", 1.0d);
                    rewardUnitSetting2.f32273u = Cbprule.m20874a(optJSONObject.optJSONObject("cbprule"));
                    rewardUnitSetting2.f32276x = optJSONObject.optInt("ccbprule", 2);
                    rewardUnitSetting2.f32277y = optJSONObject.optDouble("ccbp", 1.0d);
                    f32227a = optJSONObject.optString("atzu");
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("atl_type");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    try {
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                arrayList.add(Integer.valueOf(optJSONArray2.getInt(i2)));
                            }
                        } else {
                            arrayList.add(4);
                            arrayList.add(6);
                        }
                        rewardUnitSetting2.f32278z = arrayList;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int optInt3 = optJSONObject.optInt("atl_dyt", 0);
                    rewardUnitSetting2.f32228A = optInt3 > 0 ? optInt3 : 3;
                    int optInt4 = optJSONObject.optInt("tmorl", 1);
                    rewardUnitSetting2.f32229B = (optInt4 > 2 || optInt4 <= 0) ? 1 : 1;
                    if (rewardUnitSetting2.f32265m != 1.0d && new Random().nextDouble() > rewardUnitSetting2.f32265m) {
                        i = 1;
                        rewardUnitSetting2.f32230C = i;
                        rewardUnitSetting2.f32255c = optJSONObject.optString("placementid");
                        rewardUnitSetting2.f32231D = optJSONObject.optInt("ltafemty", 10);
                        rewardUnitSetting2.f32232E = optJSONObject.optInt("ltorwc", 60);
                        rewardUnitSetting2.m20791d(optJSONObject.optString("ab_id"));
                        rewardUnitSetting2.f32243Q = optJSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                        rewardUnitSetting2.f32244R = optJSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                        rewardUnitSetting2.f32245S = optJSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                        rewardUnitSetting2.m20816B(optJSONObject.optInt(RewardPlus.AMOUNT, 1));
                        rewardUnitSetting2.f32247U = optJSONObject.optString(RewardPlus.ICON, "");
                        rewardUnitSetting2.f32248V = optJSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                        rewardUnitSetting2.m20788e(optJSONObject.optString("name", "Virtual Item"));
                        rewardUnitSetting2.f32251Y = optJSONObject.optInt("video_error_rule", 1);
                        rewardUnitSetting2.f32252Z = optJSONObject.optInt("loadtmo", 60);
                        return rewardUnitSetting2;
                    }
                    i = 0;
                    rewardUnitSetting2.f32230C = i;
                    rewardUnitSetting2.f32255c = optJSONObject.optString("placementid");
                    rewardUnitSetting2.f32231D = optJSONObject.optInt("ltafemty", 10);
                    rewardUnitSetting2.f32232E = optJSONObject.optInt("ltorwc", 60);
                    rewardUnitSetting2.m20791d(optJSONObject.optString("ab_id"));
                    rewardUnitSetting2.f32243Q = optJSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                    rewardUnitSetting2.f32244R = optJSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                    rewardUnitSetting2.f32245S = optJSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                    rewardUnitSetting2.m20816B(optJSONObject.optInt(RewardPlus.AMOUNT, 1));
                    rewardUnitSetting2.f32247U = optJSONObject.optString(RewardPlus.ICON, "");
                    rewardUnitSetting2.f32248V = optJSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                    rewardUnitSetting2.m20788e(optJSONObject.optString("name", "Virtual Item"));
                    rewardUnitSetting2.f32251Y = optJSONObject.optInt("video_error_rule", 1);
                    rewardUnitSetting2.f32252Z = optJSONObject.optInt("loadtmo", 60);
                    return rewardUnitSetting2;
                } catch (Exception e2) {
                    e = e2;
                    rewardUnitSetting = rewardUnitSetting2;
                    e.printStackTrace();
                    return rewardUnitSetting;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        return rewardUnitSetting;
    }

    /* renamed from: e */
    private void m20788e(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f32249W = this.f32245S;
        } else {
            this.f32249W = str;
        }
    }

    /* renamed from: B */
    public final double m20817B() {
        return this.f32277y;
    }

    /* renamed from: a */
    public final void m20803a(ArrayList<Integer> arrayList) {
        this.f32278z = arrayList;
    }

    /* renamed from: b */
    public final void m20799b(double d) {
        this.f32277y = d;
    }

    /* renamed from: d */
    public final int m20793d() {
        return this.f32230C;
    }

    /* renamed from: a */
    public final void m20806a(double d) {
        this.f32265m = d;
    }

    /* renamed from: b */
    public final void m20797b(String str) {
        this.f32255c = str;
    }

    /* renamed from: d */
    public final void m20792d(int i) {
        this.f32237J = i;
    }

    /* renamed from: a */
    public final void m20804a(String str) {
        this.f32254b = str;
    }

    /* renamed from: a */
    public final void m20802a(List<AdUnitInfo> list) {
        this.f32256d = list;
    }

    /* renamed from: a */
    public static RewardUnitSetting m20801a(JSONObject jSONObject) {
        int i;
        RewardUnitSetting rewardUnitSetting = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            RewardUnitSetting rewardUnitSetting2 = new RewardUnitSetting();
            try {
                rewardUnitSetting2.f32256d = AdUnitInfo.m20877a(jSONObject.optJSONArray("adSourceList"));
                rewardUnitSetting2.f32261i = jSONObject.optInt("callbackType");
                int optInt = jSONObject.optInt("aqn", 1);
                if (optInt <= 0) {
                    optInt = 1;
                }
                rewardUnitSetting2.f32262j = optInt;
                int optInt2 = jSONObject.optInt("acn", 1);
                if (optInt2 < 0) {
                    optInt2 = 1;
                }
                rewardUnitSetting2.f32263k = optInt2;
                rewardUnitSetting2.f32264l = jSONObject.optInt("vcn", 5);
                rewardUnitSetting2.f32265m = jSONObject.optDouble("cbp", 1.0d);
                rewardUnitSetting2.f32266n = jSONObject.optInt(DomainCampaignEx.JSON_KEY_TTC_TYPE, 2);
                rewardUnitSetting2.f32267o = jSONObject.optInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET, 5);
                rewardUnitSetting2.f32268p = jSONObject.optInt("dlnet", 2);
                rewardUnitSetting2.f32242P = jSONObject.optInt("endscreen_type", 2);
                rewardUnitSetting2.f32269q = jSONObject.optInt("tv_start", 3);
                rewardUnitSetting2.f32270r = jSONObject.optInt("tv_end", 80);
                rewardUnitSetting2.f32271s = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                rewardUnitSetting2.f32257e = jSONObject.optLong("current_time");
                rewardUnitSetting2.f32234G = jSONObject.optInt("orientation", 0);
                rewardUnitSetting2.f32236I = jSONObject.optInt("daily_play_cap", 0);
                rewardUnitSetting2.f32237J = jSONObject.optInt("video_skip_time", -1);
                rewardUnitSetting2.f32238K = jSONObject.optInt("video_skip_result", 2);
                rewardUnitSetting2.f32239L = jSONObject.optInt("video_interactive_type", -1);
                rewardUnitSetting2.f32240M = jSONObject.optInt("close_button_delay", 1);
                rewardUnitSetting2.f32258f = jSONObject.optInt("playclosebtn_tm", -1);
                rewardUnitSetting2.f32259g = jSONObject.optInt("play_ctdown", 0);
                rewardUnitSetting2.f32260h = jSONObject.optInt("close_alert", 0);
                rewardUnitSetting2.f32241N = jSONObject.optInt("rdrct", 20);
                rewardUnitSetting2.f32275w = jSONObject.optInt("rfpv", -1);
                rewardUnitSetting2.f32274v = jSONObject.optDouble("vdcmp", 1.0d);
                rewardUnitSetting2.f32273u = Cbprule.m20874a(jSONObject.optJSONObject("cbprule"));
                rewardUnitSetting2.f32276x = jSONObject.optInt("ccbprule", 2);
                rewardUnitSetting2.f32277y = jSONObject.optDouble("ccbp", 1.0d);
                rewardUnitSetting2.f32235H = jSONObject.optInt("load_global_timeout", 70);
                JSONArray optJSONArray = jSONObject.optJSONArray("atl_type");
                ArrayList<Integer> arrayList = new ArrayList<>();
                try {
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            arrayList.add(Integer.valueOf(optJSONArray.getInt(i2)));
                        }
                    } else {
                        arrayList.add(4);
                        arrayList.add(6);
                    }
                    rewardUnitSetting2.f32278z = arrayList;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                rewardUnitSetting2.f32228A = jSONObject.optInt("atl_dyt", 3);
                int optInt3 = jSONObject.optInt("tmorl", 1);
                rewardUnitSetting2.f32229B = (optInt3 > 2 || optInt3 <= 0) ? 1 : 1;
                if (rewardUnitSetting2.f32265m != 1.0d && new Random().nextDouble() > rewardUnitSetting2.f32265m) {
                    i = 1;
                    rewardUnitSetting2.f32230C = i;
                    rewardUnitSetting2.f32255c = jSONObject.optString("placementid");
                    rewardUnitSetting2.f32231D = jSONObject.optInt("ltafemty", 10);
                    rewardUnitSetting2.f32232E = jSONObject.optInt("ltorwc", 60);
                    rewardUnitSetting2.m20791d(jSONObject.optString("ab_id"));
                    rewardUnitSetting2.f32243Q = jSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                    rewardUnitSetting2.f32244R = jSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                    rewardUnitSetting2.f32245S = jSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                    rewardUnitSetting2.m20816B(jSONObject.optInt(RewardPlus.AMOUNT, 1));
                    rewardUnitSetting2.f32247U = jSONObject.optString(RewardPlus.ICON, "");
                    rewardUnitSetting2.f32248V = jSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                    rewardUnitSetting2.m20788e(jSONObject.optString("name", "Virtual Item"));
                    rewardUnitSetting2.f32251Y = jSONObject.optInt("video_error_rule", 1);
                    rewardUnitSetting2.f32252Z = jSONObject.optInt("loadtmo", 60);
                    rewardUnitSetting2.f32253aa = jSONObject.optString("vtag", "");
                    return rewardUnitSetting2;
                }
                i = 0;
                rewardUnitSetting2.f32230C = i;
                rewardUnitSetting2.f32255c = jSONObject.optString("placementid");
                rewardUnitSetting2.f32231D = jSONObject.optInt("ltafemty", 10);
                rewardUnitSetting2.f32232E = jSONObject.optInt("ltorwc", 60);
                rewardUnitSetting2.m20791d(jSONObject.optString("ab_id"));
                rewardUnitSetting2.f32243Q = jSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                rewardUnitSetting2.f32244R = jSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                rewardUnitSetting2.f32245S = jSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                rewardUnitSetting2.m20816B(jSONObject.optInt(RewardPlus.AMOUNT, 1));
                rewardUnitSetting2.f32247U = jSONObject.optString(RewardPlus.ICON, "");
                rewardUnitSetting2.f32248V = jSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                rewardUnitSetting2.m20788e(jSONObject.optString("name", "Virtual Item"));
                rewardUnitSetting2.f32251Y = jSONObject.optInt("video_error_rule", 1);
                rewardUnitSetting2.f32252Z = jSONObject.optInt("loadtmo", 60);
                rewardUnitSetting2.f32253aa = jSONObject.optString("vtag", "");
                return rewardUnitSetting2;
            } catch (Exception e2) {
                e = e2;
                rewardUnitSetting = rewardUnitSetting2;
                e.printStackTrace();
                return rewardUnitSetting;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }
}
