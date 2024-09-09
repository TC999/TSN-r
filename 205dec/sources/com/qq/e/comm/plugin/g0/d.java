package com.qq.e.comm.plugin.g0;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(c cVar, JSONObject jSONObject) {
        cVar.f43490b = jSONObject.optString("dl_progress");
        cVar.f43491c = jSONObject.optString("dl_paused");
        cVar.f43492d = jSONObject.optString("dl_finish");
        cVar.f43493e = jSONObject.optString("installed");
    }
}
