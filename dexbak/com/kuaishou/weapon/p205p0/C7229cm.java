package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.cm */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7229cm {

    /* renamed from: a */
    private String f24698a;

    /* renamed from: b */
    private String f24699b;

    /* renamed from: c */
    private String f24700c;

    /* renamed from: d */
    private String f24701d;

    /* renamed from: e */
    private String f24702e;

    /* renamed from: f */
    private String f24703f;

    /* renamed from: g */
    private String f24704g;

    /* renamed from: h */
    private String f24705h;

    /* renamed from: i */
    private String f24706i;

    /* renamed from: j */
    private String f24707j;

    /* renamed from: k */
    private String f24708k;

    /* renamed from: l */
    private String f24709l;

    public C7229cm(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        this.f24706i = sb.toString();
        this.f24700c = str;
        this.f24704g = str2;
    }

    /* renamed from: m */
    public static String m34056m() {
        try {
            return !TextUtils.isEmpty(WeaponHI.skProductName) ? WeaponHI.skProductName : "UNKNOWN_PRODUCT";
        } catch (Exception unused) {
            return "UNKNOWN_PRODUCT";
        }
    }

    /* renamed from: n */
    private JSONObject m34055n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", this.f24698a);
            jSONObject.put("2", this.f24699b);
            jSONObject.put("3", this.f24700c);
            jSONObject.put("4", this.f24701d);
            jSONObject.put("5", this.f24702e);
            jSONObject.put("6", this.f24703f);
            jSONObject.put("7", this.f24704g);
            jSONObject.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, this.f24705h);
            jSONObject.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, this.f24706i);
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, this.f24707j);
            jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, this.f24709l);
            jSONObject.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, "com.kuaishou.weapon");
            jSONObject.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, WeaponHI.sKSSdkver);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public String m34082a() {
        return this.f24698a;
    }

    /* renamed from: b */
    public String m34079b() {
        return this.f24699b;
    }

    /* renamed from: c */
    public String m34076c() {
        return this.f24700c;
    }

    /* renamed from: d */
    public String m34074d() {
        return this.f24701d;
    }

    /* renamed from: e */
    public String m34072e() {
        return this.f24702e;
    }

    /* renamed from: f */
    public String m34070f() {
        return this.f24703f;
    }

    /* renamed from: g */
    public String m34068g() {
        return this.f24704g;
    }

    /* renamed from: h */
    public String m34066h() {
        return this.f24705h;
    }

    /* renamed from: i */
    public String m34064i() {
        return this.f24706i;
    }

    /* renamed from: j */
    public String m34062j() {
        return this.f24707j;
    }

    /* renamed from: k */
    public String m34060k() {
        return this.f24708k;
    }

    /* renamed from: l */
    public String m34058l() {
        return this.f24709l;
    }

    /* renamed from: a */
    public void m34080a(String str) {
        this.f24698a = str;
    }

    /* renamed from: b */
    public void m34077b(String str) {
        this.f24699b = str;
    }

    /* renamed from: c */
    public void m34075c(String str) {
        this.f24700c = str;
    }

    /* renamed from: d */
    public void m34073d(String str) {
        this.f24701d = str;
    }

    /* renamed from: e */
    public void m34071e(String str) {
        this.f24702e = str;
    }

    /* renamed from: f */
    public void m34069f(String str) {
        this.f24703f = str;
    }

    /* renamed from: g */
    public void m34067g(String str) {
        this.f24704g = str;
    }

    /* renamed from: h */
    public void m34065h(String str) {
        this.f24705h = str;
    }

    /* renamed from: i */
    public void m34063i(String str) {
        this.f24706i = str;
    }

    /* renamed from: j */
    public void m34061j(String str) {
        this.f24707j = str;
    }

    /* renamed from: k */
    public void m34059k(String str) {
        this.f24708k = str;
    }

    /* renamed from: l */
    public void m34057l(String str) {
        this.f24709l = str;
    }

    /* renamed from: b */
    public static String m34078b(Context context) {
        try {
            String str = WeaponHI.sKDeviceId;
            if (!TextUtils.isEmpty(str)) {
                C7193bi.f24587v = 1;
                return str;
            }
        } catch (Exception unused) {
        }
        try {
            C7283h m33888a = C7283h.m33888a(context, "re_po_rt");
            boolean m33867e = m33888a.m33867e("a1_p_s_p_s");
            boolean m33867e2 = m33888a.m33867e("a1_p_s_p_s_c_b");
            if (m33867e || m33867e2) {
                String str2 = "ANDROID_" + Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
                if (!TextUtils.isEmpty(str2)) {
                    C7193bi.f24587v = 3;
                    return str2;
                }
            }
        } catch (Exception unused2) {
        }
        C7193bi.f24587v = 4;
        return "";
    }

    /* renamed from: a */
    public JSONObject m34081a(Context context) {
        try {
            m34080a(m34078b(context));
            m34077b(m34056m());
            m34073d(C7191bh.m34230q(context));
            m34071e(C7191bh.m34229r(context));
            m34069f(C7191bh.m34228s(context));
            m34065h("5.3.0");
            m34061j(C7205bt.m34131a(context));
            m34057l(WeaponHI.sKSAppkey);
            return m34055n();
        } catch (Throwable unused) {
            return null;
        }
    }
}
