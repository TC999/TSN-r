package com.qq.e.comm.plugin.g0;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class o {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(n nVar, JSONObject jSONObject) {
        nVar.f43720a = jSONObject.optInt("landing_page") == 2;
        nVar.f43721b = jSONObject.optInt("has_endcard") == 1;
        JSONObject jSONObject2 = null;
        String optString = jSONObject.optString("ext");
        if (optString != null && optString.length() >= 2) {
            try {
                jSONObject2 = new JSONObject(optString);
            } catch (Exception unused) {
            }
        }
        if (jSONObject2 == null) {
            try {
                jSONObject2 = new JSONObject("{}");
            } catch (Exception unused2) {
            }
        }
        if (jSONObject2 != null) {
            nVar.f43722c = new l(jSONObject2);
        }
    }
}
