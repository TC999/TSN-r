package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import androidx.room.RoomMasterTable;
import com.kuaishou.weapon.p205p0.jni.Engine;
import com.kwad.sdk.p433f.C10758b;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.cj */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7226cj {

    /* renamed from: a */
    private Context f24665a;

    public C7226cj(Context context) {
        this.f24665a = context;
    }

    /* renamed from: a */
    public JSONObject m34086a() {
        int i;
        int i2;
        try {
            JSONObject jSONObject = new JSONObject();
            C7283h m33888a = C7283h.m33888a(this.f24665a, "re_po_rt");
            boolean m33867e = m33888a.m33867e("a1_p_s_p_s");
            boolean m33867e2 = m33888a.m33867e("a1_p_s_p_s_c_b");
            if (m33888a.m33878b(C7262df.f24795G, 1) == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (m33888a.m33878b(C7262df.f24799K, 0) == 1 && Engine.loadSuccess) {
                    C7172ap c7172ap = new C7172ap(this.f24665a);
                    jSONObject.put("0", c7172ap.m34344b("0"));
                    jSONObject.put("1", c7172ap.m34344b("1"));
                    jSONObject.put("2", c7172ap.m34344b("2"));
                    jSONObject.put("4", c7172ap.m34344b("4"));
                    jSONObject.put("5", c7172ap.m34344b("5"));
                    jSONObject.put("6", c7172ap.m34344b("6"));
                    jSONObject.put("7", c7172ap.m34344b("7"));
                    jSONObject.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, c7172ap.m34344b(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO));
                    jSONObject.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, c7172ap.m34344b(Constants.VIA_SHARE_TYPE_MINI_PROGRAM));
                    jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, c7172ap.m34344b(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                    jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, c7172ap.m34344b(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE));
                    jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, c7172ap.m34344b(Constants.VIA_REPORT_TYPE_SET_AVATAR));
                    jSONObject.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, c7172ap.m34344b(Constants.VIA_REPORT_TYPE_JOININ_GROUP));
                    jSONObject.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, c7172ap.m34344b(Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                    jSONObject.put(Constants.VIA_REPORT_TYPE_WPA_STATE, c7172ap.m34344b(Constants.VIA_REPORT_TYPE_WPA_STATE));
                    jSONObject.put(Constants.VIA_REPORT_TYPE_START_WAP, c7172ap.m34344b(Constants.VIA_REPORT_TYPE_START_WAP));
                    jSONObject.put(Constants.VIA_REPORT_TYPE_START_GROUP, c7172ap.m34344b(Constants.VIA_REPORT_TYPE_START_GROUP));
                    jSONObject.put("18", c7172ap.m34344b("18"));
                    jSONObject.put(Constants.VIA_ACT_TYPE_NINETEEN, c7172ap.m34344b(Constants.VIA_ACT_TYPE_NINETEEN));
                    jSONObject.put("20", c7172ap.m34344b("20"));
                    jSONObject.put("21", c7172ap.m34344b("21"));
                    jSONObject.put(Constants.VIA_REPORT_TYPE_DATALINE, c7172ap.m34344b(Constants.VIA_REPORT_TYPE_DATALINE));
                    jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, c7172ap.m34344b(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR));
                    jSONObject.put(Constants.VIA_REPORT_TYPE_CHAT_AIO, c7172ap.m34344b(Constants.VIA_REPORT_TYPE_CHAT_AIO));
                    jSONObject.put(Constants.VIA_REPORT_TYPE_CHAT_AUDIO, c7172ap.m34344b(Constants.VIA_REPORT_TYPE_CHAT_AUDIO));
                    jSONObject.put(Constants.VIA_REPORT_TYPE_CHAT_VIDEO, c7172ap.m34344b(Constants.VIA_REPORT_TYPE_CHAT_VIDEO));
                    jSONObject.put("27", c7172ap.m34344b("27"));
                    jSONObject.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, c7172ap.m34344b(Constants.VIA_ACT_TYPE_TWENTY_EIGHT));
                    jSONObject.put("29", c7172ap.m34344b("29"));
                    jSONObject.put("30", c7172ap.m34344b("30"));
                    jSONObject.put("31", c7172ap.m34344b("31"));
                    jSONObject.put("32", c7172ap.m34344b("32"));
                    jSONObject.put("33", c7172ap.m34344b("33"));
                    jSONObject.put("34", c7172ap.m34344b("34"));
                    jSONObject.put("35", c7172ap.m34344b("35"));
                    jSONObject.put("36", c7172ap.m34344b("36"));
                    jSONObject.put("37", c7172ap.m34344b("37"));
                    jSONObject.put("38", c7172ap.m34344b("38"));
                    jSONObject.put("39", c7172ap.m34344b("39"));
                    jSONObject.put("40", c7172ap.m34344b("40"));
                    jSONObject.put("41", c7172ap.m34344b("41"));
                    jSONObject.put(RoomMasterTable.DEFAULT_ID, c7172ap.m34344b(RoomMasterTable.DEFAULT_ID));
                    jSONObject.put("43", c7172ap.m34345a("43"));
                    jSONObject.put("44", c7172ap.m34345a("44"));
                    jSONObject.put("101", c7172ap.m34344b("101"));
                    jSONObject.put("102", c7172ap.m34344b("102"));
                    jSONObject.put("105", c7172ap.m34344b("105"));
                    jSONObject.put("106", c7172ap.m34344b("106"));
                    jSONObject.put("49", C7268dl.m33946b(this.f24665a));
                }
                if (m33888a.m33878b(C7262df.f24798J, 1) == 1 && Engine.loadSuccess) {
                    C7176at c7176at = new C7176at(this.f24665a);
                    jSONObject.put("45", c7176at.m34326d("45"));
                    if (c7176at.m34333a()) {
                        i2 = 1;
                        jSONObject.put("93", 1);
                    } else {
                        i2 = 1;
                    }
                    if (c7176at.m34329b()) {
                        jSONObject.put("94", i2);
                    }
                    jSONObject.put("46", c7176at.m34326d("46"));
                    jSONObject.put("48", c7176at.m34330a("48"));
                    jSONObject.put("51", c7176at.m34328b("51"));
                    i = 0;
                    jSONObject.put("52", c7176at.m34331a(this.f24665a, "52", 0));
                    jSONObject.put("55", c7176at.m34327c("55"));
                    jSONObject.put("66", c7176at.m34330a("66"));
                    jSONObject.put("67", C7265di.m33960d());
                    jSONObject.put("78", c7176at.m34330a("78"));
                    jSONObject.put("79", c7176at.m34330a("79"));
                    C7182az c7182az = new C7182az(this.f24665a, 200);
                    jSONObject.put("70", c7182az.m34309a("70"));
                    jSONObject.put("71", c7182az.m34309a("71"));
                    jSONObject.put("72", c7182az.m34309a("72"));
                    jSONObject.put("73", c7182az.m34309a("73"));
                    jSONObject.put("74", c7182az.m34309a("74"));
                } else {
                    i = 0;
                }
                if (m33888a.m33878b(C7262df.f24801M, 1) == 1) {
                    C7180ax c7180ax = new C7180ax(this.f24665a);
                    jSONObject.put("53", c7180ax.m34314a(this.f24665a, "53", 1));
                    jSONObject.put("56", c7180ax.m34313a("56"));
                    jSONObject.put("57", c7180ax.m34313a("57"));
                    if (m33867e || m33867e2) {
                        C7167ak c7167ak = new C7167ak();
                        jSONObject.put("47", c7167ak.m34398a(this.f24665a));
                        jSONObject.put("59", c7167ak.m34393d(this.f24665a));
                        jSONObject.put("60", c7167ak.m34394c(this.f24665a));
                        jSONObject.put("61", c7167ak.m34395b(this.f24665a));
                        jSONObject.put("62", c7167ak.m34392e(this.f24665a));
                        jSONObject.put("65", c7167ak.m34391f(this.f24665a));
                        jSONObject.put("69", c7167ak.m34390g(this.f24665a));
                        jSONObject.put("75", c7167ak.m34389h(this.f24665a));
                        jSONObject.put("80", C7167ak.m34399a());
                        jSONObject.put("85", c7167ak.m34388i(this.f24665a));
                        jSONObject.put("87", c7167ak.m34387j(this.f24665a));
                        jSONObject.put("91", c7167ak.m34386k(this.f24665a));
                        jSONObject.put("92", c7167ak.m34385l(this.f24665a));
                    }
                    jSONObject.put("64", C7265di.m33965a());
                }
                if (m33888a.m33878b(C7262df.f24802N, 1) == 1) {
                    C7237cs c7237cs = new C7237cs();
                    jSONObject.put("98", c7237cs.m34040a());
                    jSONObject.put("107", c7237cs.m34039b());
                    String m34368d = C7169am.m34368d();
                    if (!TextUtils.isEmpty(m34368d)) {
                        jSONObject.put("77", m34368d);
                    }
                    jSONObject.put("104", C7169am.m34369c());
                    jSONObject.put("109", C7268dl.m33943e(this.f24665a));
                    C7166aj c7166aj = new C7166aj(this.f24665a);
                    jSONObject.put("82", c7166aj.m34403h());
                    String m34402i = c7166aj.m34402i();
                    if (!TextUtils.isEmpty(m34402i)) {
                        jSONObject.put("83", m34402i);
                    }
                    String m34401j = c7166aj.m34401j();
                    if (!TextUtils.isEmpty(m34401j)) {
                        jSONObject.put("84", m34401j);
                    }
                    String m34400k = c7166aj.m34400k();
                    if (!TextUtils.isEmpty(m34400k)) {
                        jSONObject.put("86", m34400k);
                    }
                }
                if (m33888a.m33878b(C7262df.f24800L, 1) == 1) {
                    C7177au c7177au = new C7177au(this.f24665a);
                    jSONObject.put("95", c7177au.m34323b("95"));
                    jSONObject.put("96", c7177au.m34325a() ? 1 : 0);
                    jSONObject.put("97", C7265di.m33959e());
                    try {
                        jSONObject.put("11301", C7191bh.m34254c(C10758b.m24900Is().mo23999Ir()));
                        jSONObject.put("11302", C7191bh.m34254c(C10758b.m24900Is().getSdkVersion()));
                        jSONObject.put("11303", C7191bh.m34254c(C10758b.m24900Is().getAppId()));
                    } catch (Throwable unused) {
                    }
                }
                jSONObject.put("11006", m33867e ? 1 : 0);
                if (m33867e2) {
                    i = 1;
                }
                jSONObject.put("11029", i);
                jSONObject.put("11002", Engine.soVersion);
                jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
                jSONObject.put("11017", jSONObject.toString().length());
                return jSONObject;
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    /* renamed from: a */
    public String m34085a(String str) {
        JSONObject m34086a;
        try {
            JSONObject m34081a = new C7229cm(str, C7227ck.f24680l).m34081a(this.f24665a);
            if (m34081a == null || (m34086a = m34086a()) == null) {
                return null;
            }
            m34081a.put("module_section", m34086a);
            return m34081a.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
