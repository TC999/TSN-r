package com.beizi.p051ad.internal;

import android.content.Context;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.StringUtil;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.beizi.ad.internal.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdParameters {

    /* renamed from: a */
    static HashSet<String> f10092a;

    /* renamed from: c */
    private String f10094c;

    /* renamed from: j */
    private String f10101j;

    /* renamed from: n */
    private WeakReference<Context> f10105n;

    /* renamed from: o */
    private String f10106o;

    /* renamed from: b */
    private EnumC2888k f10093b = EnumC2888k.PREFETCH;

    /* renamed from: d */
    private int f10095d = 3;

    /* renamed from: e */
    private boolean f10096e = false;

    /* renamed from: f */
    private int f10097f = -1;

    /* renamed from: g */
    private int f10098g = -1;

    /* renamed from: h */
    private int f10099h = -1;

    /* renamed from: i */
    private int f10100i = -1;

    /* renamed from: k */
    private boolean f10102k = false;

    /* renamed from: l */
    private boolean f10103l = false;

    /* renamed from: m */
    private boolean f10104m = false;

    public AdParameters(Context context, String str) {
        this.f10106o = "";
        this.f10105n = new WeakReference<>(context);
        this.f10106o = str;
    }

    /* renamed from: a */
    public void m49515a(boolean z) {
        this.f10102k = z;
    }

    /* renamed from: b */
    public Context m49514b() {
        if (this.f10105n.get() != null) {
            return this.f10105n.get();
        }
        return null;
    }

    /* renamed from: c */
    public String m49511c() {
        return this.f10094c;
    }

    /* renamed from: d */
    public int m49508d() {
        if (this.f10093b == EnumC2888k.BANNER) {
            return this.f10097f;
        }
        return -1;
    }

    /* renamed from: e */
    public int m49506e() {
        if (this.f10093b == EnumC2888k.BANNER) {
            return this.f10098g;
        }
        return -1;
    }

    /* renamed from: f */
    public int m49504f() {
        return this.f10099h;
    }

    /* renamed from: g */
    public int m49503g() {
        return this.f10100i;
    }

    /* renamed from: h */
    public boolean m49502h() {
        return this.f10096e;
    }

    /* renamed from: i */
    public EnumC2888k m49501i() {
        return this.f10093b;
    }

    /* renamed from: j */
    public boolean m49500j() {
        if (StringUtil.isEmpty(BeiZiImpl.m49492a().m49475d()) || StringUtil.isEmpty(this.f10094c)) {
            HaoboLog.m49290e(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.no_identification));
            return false;
        }
        return true;
    }

    /* renamed from: k */
    public String m49499k() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = m49514b().getResources().getConfiguration().orientation == 2 ? "h" : "v";
            this.f10101j = str;
            if (!StringUtil.isEmpty(str)) {
                jSONObject.put("mOrientation", this.f10101j);
            }
            if (this.f10097f > 0 && this.f10098g > 0) {
                jSONObject.put("size", this.f10097f + "x" + this.f10098g);
            }
            int m49503g = m49503g();
            int m49504f = m49504f();
            if (m49503g > 0 && m49504f > 0) {
                EnumC2888k enumC2888k = this.f10093b;
                EnumC2888k enumC2888k2 = EnumC2888k.INTERSTITIAL;
                if (!enumC2888k.equals(enumC2888k2) && (this.f10097f < 0 || this.f10098g < 0)) {
                    jSONObject.put("max_size", m49504f + "x" + m49503g);
                } else if (this.f10093b.equals(enumC2888k2)) {
                    jSONObject.put("size", m49504f + "x" + m49503g);
                }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            String str2 = HaoboLog.jsonLogTag;
            HaoboLog.m49290e(str2, "Failed to encode adUnitParams, err = " + e.getMessage());
            return "";
        }
    }

    /* renamed from: l */
    public boolean m49498l() {
        return this.f10104m;
    }

    /* renamed from: a */
    public String m49519a() {
        return this.f10106o;
    }

    /* renamed from: c */
    public void m49510c(int i) {
        this.f10098g = i;
    }

    /* renamed from: a */
    public void m49516a(String str) {
        this.f10094c = str;
    }

    /* renamed from: b */
    public void m49513b(int i) {
        this.f10097f = i;
    }

    /* renamed from: c */
    public void m49509c(boolean z) {
        this.f10104m = z;
    }

    /* renamed from: d */
    public void m49507d(int i) {
        this.f10099h = i;
    }

    /* renamed from: e */
    public void m49505e(int i) {
        this.f10100i = i;
    }

    /* renamed from: a */
    public void m49518a(int i) {
        this.f10095d = i;
    }

    /* renamed from: b */
    public void m49512b(boolean z) {
        this.f10096e = z;
    }

    /* renamed from: a */
    public void m49517a(EnumC2888k enumC2888k) {
        this.f10093b = enumC2888k;
    }
}
