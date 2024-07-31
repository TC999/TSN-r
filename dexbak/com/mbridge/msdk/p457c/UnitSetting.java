package com.mbridge.msdk.p457c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* renamed from: com.mbridge.msdk.c.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class UnitSetting {

    /* renamed from: a */
    public static String f29913a;

    /* renamed from: A */
    private long f29914A;

    /* renamed from: B */
    private long f29915B;

    /* renamed from: D */
    private int f29917D;

    /* renamed from: E */
    private int f29918E;

    /* renamed from: F */
    private int f29919F;

    /* renamed from: O */
    private int f29928O;

    /* renamed from: P */
    private int f29929P;

    /* renamed from: Q */
    private String f29930Q;

    /* renamed from: R */
    private String f29931R;

    /* renamed from: b */
    private int f29932b;

    /* renamed from: c */
    private int f29933c;

    /* renamed from: d */
    private int f29934d;

    /* renamed from: f */
    private String f29936f;

    /* renamed from: g */
    private String f29937g;

    /* renamed from: h */
    private List<Integer> f29938h;

    /* renamed from: i */
    private long f29939i;

    /* renamed from: k */
    private int f29941k;

    /* renamed from: l */
    private List<Integer> f29942l;

    /* renamed from: m */
    private int f29943m;

    /* renamed from: n */
    private int f29944n;

    /* renamed from: o */
    private int f29945o;

    /* renamed from: p */
    private int f29946p;

    /* renamed from: r */
    private String f29948r;

    /* renamed from: s */
    private int f29949s;

    /* renamed from: v */
    private int f29952v;

    /* renamed from: w */
    private int f29953w;

    /* renamed from: x */
    private long f29954x;

    /* renamed from: y */
    private String f29955y;

    /* renamed from: z */
    private int f29956z;

    /* renamed from: e */
    private int f29935e = 30;

    /* renamed from: j */
    private int f29940j = 1;

    /* renamed from: q */
    private double f29947q = 1.0d;

    /* renamed from: t */
    private int f29950t = 1;

    /* renamed from: u */
    private int f29951u = 5000;

    /* renamed from: C */
    private int f29916C = 60;

    /* renamed from: G */
    private String f29920G = "";

    /* renamed from: H */
    private int f29921H = 10;

    /* renamed from: I */
    private int f29922I = 60;

    /* renamed from: J */
    private String f29923J = "";

    /* renamed from: K */
    private String f29924K = "";

    /* renamed from: L */
    private int f29925L = 1;

    /* renamed from: M */
    private int f29926M = 100;

    /* renamed from: N */
    private int f29927N = 0;

    /* renamed from: l */
    public static UnitSetting m23185l() {
        return new UnitSetting();
    }

    /* renamed from: a */
    public final String m23206a() {
        return this.f29923J;
    }

    /* renamed from: b */
    public final void m23202b(int i) {
        this.f29919F = i;
    }

    /* renamed from: c */
    public final int m23200c() {
        return this.f29917D;
    }

    /* renamed from: d */
    public final int m23197d() {
        return this.f29929P;
    }

    /* renamed from: e */
    public final double m23195e() {
        return this.f29947q;
    }

    /* renamed from: f */
    public final int m23193f() {
        return this.f29926M;
    }

    /* renamed from: g */
    public final int m23191g() {
        return this.f29927N;
    }

    /* renamed from: h */
    public final int m23189h() {
        return this.f29928O;
    }

    /* renamed from: i */
    public final long m23188i() {
        return this.f29954x;
    }

    /* renamed from: j */
    public final int m23187j() {
        return this.f29952v;
    }

    /* renamed from: k */
    public final int m23186k() {
        return this.f29953w;
    }

    /* renamed from: m */
    public final int m23184m() {
        return this.f29946p;
    }

    /* renamed from: n */
    public final int m23183n() {
        return this.f29950t;
    }

    /* renamed from: o */
    public final int m23182o() {
        return this.f29951u;
    }

    /* renamed from: p */
    public final int m23181p() {
        return this.f29944n;
    }

    /* renamed from: q */
    public final int m23180q() {
        return this.f29945o;
    }

    /* renamed from: r */
    public final List<Integer> m23179r() {
        return this.f29938h;
    }

    /* renamed from: s */
    public final List<Integer> m23178s() {
        return this.f29942l;
    }

    /* renamed from: t */
    public final JSONObject m23177t() {
        JSONObject jSONObject = new JSONObject();
        try {
            List<Integer> list = this.f29938h;
            if (list != null && list.size() > 0) {
                int size = this.f29938h.size();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.f29938h.get(i));
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            List<Integer> list2 = this.f29942l;
            if (list2 != null && list2.size() > 0) {
                int size2 = this.f29942l.size();
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < size2; i2++) {
                    jSONArray2.put(this.f29942l.get(i2));
                }
                jSONObject.put("ad_source_timeout", jSONArray2);
            }
            jSONObject.put("tpqn", this.f29943m);
            jSONObject.put("aqn", this.f29944n);
            jSONObject.put("acn", this.f29945o);
            jSONObject.put("wt", this.f29946p);
            jSONObject.put(DomainCampaignEx.JSON_KEY_TTC_TYPE, this.f29941k);
            jSONObject.put("fbPlacementId", this.f29937g);
            jSONObject.put("current_time", this.f29939i);
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET, this.f29940j);
            jSONObject.put("admobUnitId", this.f29930Q);
            jSONObject.put("myTargetSlotId", this.f29931R);
            jSONObject.put("dlct", this.f29954x);
            jSONObject.put("autoplay", this.f29952v);
            jSONObject.put("dlnet", this.f29953w);
            jSONObject.put("no_offer", this.f29955y);
            jSONObject.put("cb_type", this.f29956z);
            jSONObject.put("clct", this.f29914A);
            jSONObject.put("clcq", this.f29915B);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.f29926M);
            jSONObject.put("content", this.f29928O);
            jSONObject.put("impt", this.f29929P);
            jSONObject.put("cbp", this.f29947q);
            jSONObject.put("icon_type", this.f29949s);
            jSONObject.put("no_ads_url", this.f29948r);
            jSONObject.put("playclosebtn_tm", this.f29932b);
            jSONObject.put("play_ctdown", this.f29933c);
            jSONObject.put("close_alert", this.f29934d);
            jSONObject.put("closeBtn", this.f29917D);
            jSONObject.put("refreshFq", this.f29916C);
            jSONObject.put("countdown", this.f29919F);
            jSONObject.put("allowSkip", this.f29918E);
            jSONObject.put("tmorl", this.f29925L);
            jSONObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.f29936f);
            jSONObject.put("placementid", this.f29920G);
            jSONObject.put("ltafemty", this.f29921H);
            jSONObject.put("ltorwc", this.f29922I);
            jSONObject.put("vtag", this.f29924K);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final String toString() {
        Iterator<Integer> it;
        List<Integer> list = this.f29938h;
        String str = "";
        if (list != null && list.size() > 0) {
            while (this.f29938h.iterator().hasNext()) {
                str = str + it.next() + ",";
            }
        }
        return "offset = " + this.f29940j + " unitId = " + this.f29936f + " fbPlacementId = " + this.f29937g + str;
    }

    /* renamed from: u */
    public final long m23176u() {
        return this.f29939i;
    }

    /* renamed from: v */
    public final int m23175v() {
        return this.f29940j;
    }

    /* renamed from: w */
    public final int m23174w() {
        return this.f29921H;
    }

    /* renamed from: x */
    public final int m23173x() {
        return this.f29922I;
    }

    /* renamed from: y */
    public final String m23172y() {
        return this.f29924K;
    }

    /* renamed from: d */
    public static UnitSetting m23196d(String str) {
        UnitSetting unitSetting = new UnitSetting();
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(8);
        arrayList2.add(8);
        unitSetting.f29941k = 2;
        unitSetting.f29940j = 1;
        unitSetting.f29936f = str;
        unitSetting.f29938h = arrayList;
        unitSetting.f29942l = arrayList2;
        unitSetting.f29943m = 1;
        unitSetting.f29945o = -2;
        unitSetting.f29944n = -2;
        unitSetting.f29946p = 5;
        unitSetting.f29954x = 3600L;
        unitSetting.f29953w = 2;
        unitSetting.f29952v = 1;
        unitSetting.f29926M = 100;
        unitSetting.f29927N = 0;
        unitSetting.f29928O = 1;
        unitSetting.f29929P = 0;
        unitSetting.f29916C = 60;
        unitSetting.f29921H = 10;
        unitSetting.f29922I = 60;
        return unitSetting;
    }

    /* renamed from: e */
    public static UnitSetting m23194e(String str) {
        UnitSetting unitSetting = new UnitSetting();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(1);
            unitSetting.f29938h = arrayList;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(30);
            unitSetting.f29942l = arrayList2;
            unitSetting.f29936f = str;
            unitSetting.f29941k = 2;
            unitSetting.f29940j = 1;
            unitSetting.f29943m = 1;
            unitSetting.f29945o = -2;
            unitSetting.f29944n = -2;
            unitSetting.f29946p = 5;
            unitSetting.f29954x = 3600L;
            unitSetting.f29953w = 2;
            unitSetting.f29952v = 3;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unitSetting;
    }

    /* renamed from: f */
    public static UnitSetting m23192f(String str) {
        UnitSetting unitSetting = new UnitSetting();
        try {
            unitSetting.f29936f = str;
            unitSetting.f29940j = 1;
            unitSetting.f29943m = 1;
            unitSetting.f29946p = 5;
            unitSetting.f29941k = 2;
            unitSetting.f29945o = 1;
            unitSetting.f29944n = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unitSetting;
    }

    /* renamed from: a */
    public final void m23205a(int i) {
        this.f29918E = i;
    }

    /* renamed from: b */
    public final int m23203b() {
        return this.f29916C;
    }

    /* renamed from: c */
    public final void m23199c(int i) {
        this.f29952v = i;
    }

    /* renamed from: g */
    public final void m23190g(String str) {
        this.f29920G = str;
    }

    /* renamed from: b */
    public static UnitSetting m23201b(String str) {
        UnitSetting unitSetting = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            UnitSetting unitSetting2 = new UnitSetting();
            try {
                JSONObject jSONObject = new JSONObject(str);
                unitSetting2.f29936f = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                f29913a = jSONObject.optString("atzu");
                String optString = jSONObject.optString("ab_id");
                unitSetting2.f29923J = optString;
                MBSDKContext.f30251b.put(unitSetting2.f29936f, optString);
                JSONArray optJSONArray = jSONObject.optJSONArray("adSourceList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(Integer.valueOf(optJSONArray.optInt(i)));
                    }
                    unitSetting2.f29938h = arrayList;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("ad_source_timeout");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        arrayList2.add(Integer.valueOf(optJSONArray2.optInt(i2)));
                    }
                    unitSetting2.f29942l = arrayList2;
                }
                unitSetting2.f29943m = jSONObject.optInt("tpqn");
                unitSetting2.f29944n = jSONObject.optInt("aqn");
                unitSetting2.f29945o = jSONObject.optInt("acn");
                unitSetting2.f29946p = jSONObject.optInt("wt");
                int i3 = 1;
                unitSetting2.f29950t = jSONObject.optInt("iscasf", 1);
                unitSetting2.f29951u = jSONObject.optInt("spmxrt", 5000);
                unitSetting2.f29941k = jSONObject.optInt(DomainCampaignEx.JSON_KEY_TTC_TYPE);
                unitSetting2.f29937g = jSONObject.optString("fbPlacementId");
                unitSetting2.f29939i = jSONObject.optLong("current_time");
                unitSetting2.f29940j = jSONObject.optInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET);
                unitSetting2.f29930Q = jSONObject.optString("admobUnitId");
                unitSetting2.f29931R = jSONObject.optString("myTargetSlotId");
                unitSetting2.f29954x = jSONObject.optLong("dlct", 3600L);
                unitSetting2.f29952v = jSONObject.optInt("autoplay", 0);
                unitSetting2.f29953w = jSONObject.optInt("dlnet", 2);
                unitSetting2.f29955y = jSONObject.optString("no_offer");
                unitSetting2.f29956z = jSONObject.optInt("cb_type");
                unitSetting2.f29914A = jSONObject.optLong("clct", 86400L);
                unitSetting2.f29915B = jSONObject.optLong("clcq", 300L);
                unitSetting2.f29926M = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                unitSetting2.f29927N = jSONObject.optInt("cd_rate", 0);
                unitSetting2.f29928O = jSONObject.optInt("content", 1);
                unitSetting2.f29929P = jSONObject.optInt("impt", 0);
                unitSetting2.f29947q = jSONObject.optDouble("cbp", 1.0d);
                unitSetting2.f29949s = jSONObject.optInt("icon_type", 1);
                unitSetting2.f29948r = jSONObject.optString("no_ads_url", "");
                unitSetting2.f29932b = jSONObject.optInt("playclosebtn_tm", -1);
                unitSetting2.f29933c = jSONObject.optInt("play_ctdown", 0);
                unitSetting2.f29934d = jSONObject.optInt("close_alert", 0);
                unitSetting2.f29935e = jSONObject.optInt("intershowlimit", 30);
                unitSetting2.f29916C = jSONObject.optInt("refreshFq", 60);
                unitSetting2.f29917D = jSONObject.optInt("closeBtn", 0);
                int optInt = jSONObject.optInt("tmorl", 1);
                if (optInt <= 2 && optInt > 0) {
                    i3 = optInt;
                }
                unitSetting2.f29925L = i3;
                unitSetting2.f29920G = jSONObject.optString("placementid", "");
                unitSetting2.f29921H = jSONObject.optInt("ltafemty", 10);
                unitSetting2.f29922I = jSONObject.optInt("ltorwc", 60);
                unitSetting2.f29924K = jSONObject.optString("vtag", "");
                return unitSetting2;
            } catch (Exception e) {
                e = e;
                unitSetting = unitSetting2;
                e.printStackTrace();
                return unitSetting;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* renamed from: c */
    public static UnitSetting m23198c(String str) {
        UnitSetting m23185l = m23185l();
        m23185l.f29952v = 0;
        return m23185l;
    }

    /* renamed from: a */
    public final void m23204a(String str) {
        this.f29936f = str;
    }
}
