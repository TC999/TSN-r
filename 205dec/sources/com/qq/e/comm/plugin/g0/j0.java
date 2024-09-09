package com.qq.e.comm.plugin.g0;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j0 {
    public static e a(String str, String str2, int i4, String str3, JSONObject jSONObject) {
        e eVar = new e(com.qq.e.comm.plugin.d0.a.d().b().a(), str2, null, null, com.qq.e.comm.plugin.b.g.a(i4), jSONObject, com.qq.e.comm.plugin.b.l.f42027d);
        eVar.f43510b = str;
        eVar.f43547r = str3;
        if (jSONObject != null) {
            eVar.f43539n = jSONObject.optInt("producttype");
            eVar.f43528h0 = jSONObject.optString("productid");
            eVar.T = jSONObject.optInt("video_duration");
            eVar.J0 = jSONObject.optString("ext3");
        }
        return eVar;
    }

    public static JSONObject a(e eVar) {
        return new com.qq.e.comm.plugin.util.j0().a("producttype", eVar.g()).a("productid", eVar.s0()).a("video_duration", eVar.M0()).a("ext3", eVar.P()).a();
    }
}
