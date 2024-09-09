package com.qq.e.comm.plugin.g0;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, JSONObject jSONObject) {
        hVar.f43578a = jSONObject.optInt("type");
        hVar.f43579b = jSONObject.optString("cta_txt");
        hVar.f43580c = jSONObject.optString("form_url");
        hVar.f43581d = jSONObject.optString("consult_url");
        hVar.f43582e = jSONObject.optString("tel");
    }
}
