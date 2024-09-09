package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h0 {
    public static void a(com.qq.e.comm.plugin.b.d dVar, JSONObject jSONObject) {
        if (dVar == null || jSONObject == null || dVar.z() == 1) {
            return;
        }
        a(jSONObject.optString("ip_ping_url"));
    }

    public static void a(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar == null || !eVar.e1()) {
            return;
        }
        a(eVar.W());
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a1.a(str, true);
    }
}
