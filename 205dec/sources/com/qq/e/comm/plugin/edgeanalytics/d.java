package com.qq.e.comm.plugin.edgeanalytics;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.qq.e.comm.plugin.d0.d.h;
import com.qq.e.comm.plugin.edgeanalytics.c;
import com.qq.e.comm.plugin.g0.b0;
import com.qq.e.comm.plugin.util.j0;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {
    public static boolean a(String str) {
        return TextUtils.isEmpty(str) || "{}".equals(str);
    }

    public static c b() {
        String a4 = a("eaecc", "", "", (b0) null);
        if (a(a4)) {
            return c.f42986s;
        }
        return new c.b().a(1).a(-1L).a(a4);
    }

    public static c c() {
        String a4 = a("eiac", "", "", (b0) null);
        if (a(a4)) {
            return c.f42986s;
        }
        return new c.b().a(1).a(-1L).a(a4);
    }

    public static String d() {
        return a("eacsuc", "", "", (b0) null);
    }

    public static c a() {
        String a4 = a("adtcec", "", "", com.qq.e.comm.plugin.t.a.b().a());
        if (a(a4)) {
            return c.f42986s;
        }
        return new c.b().c("adtc").a(-1L).a(a4);
    }

    public static c b(com.qq.e.comm.plugin.b.g gVar) {
        String a4 = a(gVar, "eapcfg2", "", "");
        if (a(a4)) {
            return c.f42986s;
        }
        return new c.b().a(8).a(-1L).a(gVar).c(h.a("eapr2", gVar)).a(a4);
    }

    public static c a(com.qq.e.comm.plugin.b.g gVar) {
        String a4 = a(gVar, "eapcfg", "", "");
        if (a(a4)) {
            return c.f42986s;
        }
        return new c.b().a(8).a(-1L).a(gVar).c(h.a("eapr", gVar)).a(a4);
    }

    public static String b(com.qq.e.comm.plugin.b.g gVar, String str) {
        return a(gVar, "eapatc", "", str);
    }

    public static c b(String str, com.qq.e.comm.plugin.b.g gVar, String str2, List<JSONObject> list, int i4) {
        JSONObject a4 = a(str2, gVar, list, i4);
        c.b a5 = new c.b().a(gVar);
        return a5.c("patr_" + str2).a(a4).a(str);
    }

    public static c a(com.qq.e.comm.plugin.g0.e eVar) {
        return a(eVar.o(), eVar.q0(), eVar.p0());
    }

    public static c a(com.qq.e.comm.plugin.b.g gVar, String str, b0 b0Var) {
        String a4 = a(gVar, "eaetcfg", "", str, b0Var);
        if (a(a4)) {
            return c.f42986s;
        }
        return new c.b().a(8).a(-1L).a(gVar).c(h.a("eaet", gVar)).a(a4);
    }

    private static JSONObject a(String str, com.qq.e.comm.plugin.b.g gVar, List<JSONObject> list, int i4) {
        int a4;
        JSONArray jSONArray = new JSONArray();
        for (JSONObject jSONObject : list) {
            j0 a5 = new j0().a("aid", jSONObject.opt("cl")).a("prid", jSONObject.opt("productid")).a("tid", jSONObject.opt("traceid")).a("aetime", jSONObject.opt("ad_expire")).a("actime", jSONObject.opt("adCachedTime")).a("prld", jSONObject.optInt("prld", 0));
            long optLong = jSONObject.optLong("adReturnTime");
            if (optLong > 0 && (a4 = e.a(gVar)) > 0) {
                a5.a("ufztime", optLong + (a4 * 60 * 1000));
            }
            int optInt = jSONObject.optInt("ecpm", -1);
            if (optInt != -1) {
                a5.a("ecpm", optInt);
            }
            int a6 = com.qq.e.comm.plugin.g0.e.a(jSONObject, str);
            if (a6 != -1) {
                a5.a(CampaignEx.JSON_KEY_AD_MP, a6);
            }
            a5.a("adext", jSONObject.optJSONObject("ext3"));
            jSONArray.put(a5.a());
        }
        return new j0().a("cindex", i4).a("pid", str).a("alist", jSONArray).a();
    }

    public static String a(com.qq.e.comm.plugin.b.g gVar, String str) {
        return a(gVar, "eapasc", com.qq.e.comm.plugin.b.g.REWARDVIDEOAD == gVar ? "{\"sn\":\"ca1cf6dac1eb2a4ef55c1b8acd598f30\",\"p\":{\"clientRerankerExp\":\"0.5,0.9#1020034:-0.5,1022016:-0.5,4000000:1.5#1\"},\"rse\":1,\"pf\":1}" : "{}", str);
    }

    public static c a(String str, com.qq.e.comm.plugin.b.g gVar, String str2, List<JSONObject> list, int i4) {
        JSONObject a4 = a(str2, gVar, list, i4);
        c.b a5 = new c.b().a(gVar).a(1, 2);
        return a5.c("pasr_" + str2).a(a4).a(str);
    }

    public static c a(long j4, g gVar) {
        String a4 = a("eapuoc", "", "", (b0) null);
        if (a(a4)) {
            return c.f42986s;
        }
        return new c.b().c("puor").a(1, 3).a(-1L).a(new j0().a("fu", j4).a()).a(a4).a(gVar);
    }

    public static c a(String str, long j4, long j5) {
        if (a(str)) {
            return c.f42986s;
        }
        return new c.b().c("csur").a(1, 2).a(new j0().a("lrt", j4).a("fiut", j5).a()).a(str);
    }

    private static String a(com.qq.e.comm.plugin.b.g gVar, String str, String str2, String str3, b0 b0Var) {
        if (gVar != null) {
            String a4 = h.a(str, gVar);
            if (!TextUtils.isEmpty(com.qq.e.comm.plugin.d0.a.d().f().a(a4, str3, (String) null))) {
                return a(a4, str2, str3, b0Var);
            }
        }
        return a(str, str2, str3, b0Var);
    }

    private static String a(com.qq.e.comm.plugin.b.g gVar, String str, String str2, String str3) {
        if (gVar == null) {
            return com.qq.e.comm.plugin.t.c.a(str, "APP", str3, str2);
        }
        String a4 = h.a(str, gVar);
        if (!TextUtils.isEmpty(com.qq.e.comm.plugin.d0.a.d().f().a(a4, str3, (String) null))) {
            return com.qq.e.comm.plugin.t.c.a(a4, gVar.b(), str3, str2);
        }
        return com.qq.e.comm.plugin.t.c.a(str, gVar.b(), str3, str2);
    }

    private static String a(String str, String str2, String str3, b0 b0Var) {
        return com.qq.e.comm.plugin.t.c.a(str, str3, str2, b0Var);
    }
}
