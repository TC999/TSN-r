package com.qq.e.comm.plugin.g0;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class x {
    public static e a(e eVar, JSONObject jSONObject) {
        if (eVar == null) {
            eVar = new e(com.qq.e.comm.plugin.d0.a.d().b().a(), null, null, null, com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD, null, com.qq.e.comm.plugin.b.l.f42027d);
        }
        if (jSONObject == null) {
            return eVar;
        }
        String optString = jSONObject.optString("adId");
        if (!TextUtils.isEmpty(optString)) {
            eVar.f43510b = optString;
        }
        String optString2 = jSONObject.optString("productId");
        if (!TextUtils.isEmpty(optString2)) {
            eVar.f43528h0 = optString2;
        }
        return eVar;
    }
}
