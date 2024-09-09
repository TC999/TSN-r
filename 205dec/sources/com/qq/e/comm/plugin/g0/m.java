package com.qq.e.comm.plugin.g0;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(l lVar, JSONObject jSONObject) {
        lVar.f43594a = jSONObject.optInt("end_card_countdown", 0);
        lVar.f43595b = jSONObject.optInt("end_card_type", 0);
        lVar.f43596c = jSONObject.optInt("image_slide_time", -1);
        lVar.f43597d = jSONObject.optInt("miit_dismiss_time", -1);
        lVar.f43598e = jSONObject.optInt("end_card_showtime", -1);
        lVar.f43599f = jSONObject.optInt("tpl_invalid", 0) == 1;
        lVar.f43600g = jSONObject.optDouble("dim_amount", -1.0d);
        lVar.f43601h = jSONObject.optInt("eac", 0);
        lVar.f43602i = jSONObject.optInt("novel_reading", 0) == 1;
        lVar.f43603j = jSONObject.optInt("et", 0);
        lVar.f43604k = jSONObject.optInt("multi_reward", 0) == 1;
        lVar.f43605l = jSONObject.optInt("dlcte", -1);
        lVar.f43606m = jSONObject.optJSONArray("as");
        lVar.f43607n = jSONObject.optString("tc");
        lVar.f43608o = jSONObject.optString("fb");
        lVar.f43610q = jSONObject.optInt("rpt", 1);
    }
}
