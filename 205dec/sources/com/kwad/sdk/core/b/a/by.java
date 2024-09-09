package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.adlog.a;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class by implements com.kwad.sdk.core.d<a.C0688a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0688a c0688a, JSONObject jSONObject) {
        a2(c0688a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0688a c0688a, JSONObject jSONObject) {
        return b2(c0688a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.C0688a c0688a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0688a.templateId = jSONObject.optString("template_id");
        if (JSONObject.NULL.toString().equals(c0688a.templateId)) {
            c0688a.templateId = "";
        }
        c0688a.apd = jSONObject.optString("template_show_type");
        if (JSONObject.NULL.toString().equals(c0688a.apd)) {
            c0688a.apd = "";
        }
        c0688a.ape = jSONObject.optInt("award_task_name");
        c0688a.apf = jSONObject.optInt("jumps_liveroom_type");
        c0688a.apg = jSONObject.optInt("universe_feature_freg");
        c0688a.api = jSONObject.optInt("is_special_preload");
        c0688a.apj = jSONObject.optInt("card_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0688a c0688a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0688a.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "template_id", c0688a.templateId);
        }
        String str2 = c0688a.apd;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "template_show_type", c0688a.apd);
        }
        int i4 = c0688a.ape;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "award_task_name", i4);
        }
        int i5 = c0688a.apf;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jumps_liveroom_type", i5);
        }
        int i6 = c0688a.apg;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "universe_feature_freg", i6);
        }
        int i7 = c0688a.api;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_special_preload", i7);
        }
        int i8 = c0688a.apj;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "card_type", i8);
        }
        return jSONObject;
    }
}
