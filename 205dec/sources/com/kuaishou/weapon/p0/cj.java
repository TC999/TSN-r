package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class cj {

    /* renamed from: a  reason: collision with root package name */
    private Context f38164a;

    public cj(Context context) {
        this.f38164a = context;
    }

    public JSONObject a() {
        int i4;
        int i5;
        try {
            JSONObject jSONObject = new JSONObject();
            h a4 = h.a(this.f38164a, "re_po_rt");
            boolean e4 = a4.e("a1_p_s_p_s");
            boolean e5 = a4.e("a1_p_s_p_s_c_b");
            if (a4.b("plc002_pp_s", 1) == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (a4.b("plc002_pp_pcl_cp", 0) == 1 && Engine.loadSuccess) {
                    ap apVar = new ap(this.f38164a);
                    jSONObject.put("0", apVar.b("0"));
                    jSONObject.put("1", apVar.b("1"));
                    jSONObject.put("2", apVar.b("2"));
                    jSONObject.put("4", apVar.b("4"));
                    jSONObject.put("5", apVar.b("5"));
                    jSONObject.put("6", apVar.b("6"));
                    jSONObject.put("7", apVar.b("7"));
                    jSONObject.put("8", apVar.b("8"));
                    jSONObject.put("9", apVar.b("9"));
                    jSONObject.put("10", apVar.b("10"));
                    jSONObject.put("11", apVar.b("11"));
                    jSONObject.put("12", apVar.b("12"));
                    jSONObject.put("13", apVar.b("13"));
                    jSONObject.put("14", apVar.b("14"));
                    jSONObject.put("15", apVar.b("15"));
                    jSONObject.put("16", apVar.b("16"));
                    jSONObject.put("17", apVar.b("17"));
                    jSONObject.put("18", apVar.b("18"));
                    jSONObject.put("19", apVar.b("19"));
                    jSONObject.put("20", apVar.b("20"));
                    jSONObject.put("21", apVar.b("21"));
                    jSONObject.put("22", apVar.b("22"));
                    jSONObject.put("23", apVar.b("23"));
                    jSONObject.put("24", apVar.b("24"));
                    jSONObject.put("25", apVar.b("25"));
                    jSONObject.put("26", apVar.b("26"));
                    jSONObject.put("27", apVar.b("27"));
                    jSONObject.put("28", apVar.b("28"));
                    jSONObject.put("29", apVar.b("29"));
                    jSONObject.put("30", apVar.b("30"));
                    jSONObject.put("31", apVar.b("31"));
                    jSONObject.put("32", apVar.b("32"));
                    jSONObject.put("33", apVar.b("33"));
                    jSONObject.put("34", apVar.b("34"));
                    jSONObject.put("35", apVar.b("35"));
                    jSONObject.put("36", apVar.b("36"));
                    jSONObject.put("37", apVar.b("37"));
                    jSONObject.put("38", apVar.b("38"));
                    jSONObject.put("39", apVar.b("39"));
                    jSONObject.put("40", apVar.b("40"));
                    jSONObject.put("41", apVar.b("41"));
                    jSONObject.put("42", apVar.b("42"));
                    jSONObject.put("43", apVar.a("43"));
                    jSONObject.put("44", apVar.a("44"));
                    jSONObject.put("101", apVar.b("101"));
                    jSONObject.put("102", apVar.b("102"));
                    jSONObject.put("105", apVar.b("105"));
                    jSONObject.put("106", apVar.b("106"));
                    jSONObject.put("49", dl.b(this.f38164a));
                }
                if (a4.b("plc002_pp_pcl_gc", 1) == 1 && Engine.loadSuccess) {
                    at atVar = new at(this.f38164a);
                    jSONObject.put("45", atVar.d("45"));
                    if (atVar.a()) {
                        i5 = 1;
                        jSONObject.put("93", 1);
                    } else {
                        i5 = 1;
                    }
                    if (atVar.b()) {
                        jSONObject.put("94", i5);
                    }
                    jSONObject.put("46", atVar.d("46"));
                    jSONObject.put("48", atVar.a("48"));
                    jSONObject.put("51", atVar.b("51"));
                    i4 = 0;
                    jSONObject.put("52", atVar.a(this.f38164a, "52", 0));
                    jSONObject.put("55", atVar.c("55"));
                    jSONObject.put("66", atVar.a("66"));
                    jSONObject.put("67", di.d());
                    jSONObject.put("78", atVar.a("78"));
                    jSONObject.put("79", atVar.a("79"));
                    az azVar = new az(this.f38164a, 200);
                    jSONObject.put("70", azVar.a("70"));
                    jSONObject.put("71", azVar.a("71"));
                    jSONObject.put("72", azVar.a("72"));
                    jSONObject.put("73", azVar.a("73"));
                    jSONObject.put("74", azVar.a("74"));
                } else {
                    i4 = 0;
                }
                if (a4.b("plc002_pp_pcl_pds", 1) == 1) {
                    ax axVar = new ax(this.f38164a);
                    jSONObject.put("53", axVar.a(this.f38164a, "53", 1));
                    jSONObject.put("56", axVar.a("56"));
                    jSONObject.put("57", axVar.a("57"));
                    if (e4 || e5) {
                        ak akVar = new ak();
                        jSONObject.put("47", akVar.a(this.f38164a));
                        jSONObject.put("59", akVar.d(this.f38164a));
                        jSONObject.put("60", akVar.c(this.f38164a));
                        jSONObject.put("61", akVar.b(this.f38164a));
                        jSONObject.put("62", akVar.e(this.f38164a));
                        jSONObject.put("65", akVar.f(this.f38164a));
                        jSONObject.put("69", akVar.g(this.f38164a));
                        jSONObject.put("75", akVar.h(this.f38164a));
                        jSONObject.put("80", ak.a());
                        jSONObject.put("85", akVar.i(this.f38164a));
                        jSONObject.put("87", akVar.j(this.f38164a));
                        jSONObject.put("91", akVar.k(this.f38164a));
                        jSONObject.put("92", akVar.l(this.f38164a));
                    }
                    jSONObject.put("64", di.a());
                }
                if (a4.b("plc002_pp_pcl_pam", 1) == 1) {
                    cs csVar = new cs();
                    jSONObject.put("98", csVar.a());
                    jSONObject.put("107", csVar.b());
                    String d4 = am.d();
                    if (!TextUtils.isEmpty(d4)) {
                        jSONObject.put("77", d4);
                    }
                    jSONObject.put("104", am.c());
                    jSONObject.put("109", dl.e(this.f38164a));
                    aj ajVar = new aj(this.f38164a);
                    jSONObject.put("82", ajVar.h());
                    String i6 = ajVar.i();
                    if (!TextUtils.isEmpty(i6)) {
                        jSONObject.put("83", i6);
                    }
                    String j4 = ajVar.j();
                    if (!TextUtils.isEmpty(j4)) {
                        jSONObject.put("84", j4);
                    }
                    String k4 = ajVar.k();
                    if (!TextUtils.isEmpty(k4)) {
                        jSONObject.put("86", k4);
                    }
                }
                if (a4.b("plc002_pp_pcl_pke", 1) == 1) {
                    au auVar = new au(this.f38164a);
                    jSONObject.put("95", auVar.b("95"));
                    jSONObject.put("96", auVar.a() ? 1 : 0);
                    jSONObject.put("97", di.e());
                    try {
                        jSONObject.put("11301", bh.c(com.kwad.sdk.f.b.Is().Ir()));
                        jSONObject.put("11302", bh.c(com.kwad.sdk.f.b.Is().getSdkVersion()));
                        jSONObject.put("11303", bh.c(com.kwad.sdk.f.b.Is().getAppId()));
                    } catch (Throwable unused) {
                    }
                }
                jSONObject.put("11006", e4 ? 1 : 0);
                if (e5) {
                    i4 = 1;
                }
                jSONObject.put("11029", i4);
                jSONObject.put("11002", Engine.soVersion);
                jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
                jSONObject.put("11017", jSONObject.toString().length());
                return jSONObject;
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    public String a(String str) {
        JSONObject a4;
        try {
            JSONObject a5 = new cm(str, ck.f38176l).a(this.f38164a);
            if (a5 == null || (a4 = a()) == null) {
                return null;
            }
            a5.put("module_section", a4);
            return a5.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
