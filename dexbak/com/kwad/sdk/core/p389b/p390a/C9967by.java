package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.by */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9967by implements InterfaceC10273d<C9893a.C9894a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9893a.C9894a c9894a, JSONObject jSONObject) {
        m27140a(c9894a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9893a.C9894a c9894a, JSONObject jSONObject) {
        return m27139b(c9894a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27140a(C9893a.C9894a c9894a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9894a.templateId = jSONObject.optString("template_id");
        if (JSONObject.NULL.toString().equals(c9894a.templateId)) {
            c9894a.templateId = "";
        }
        c9894a.apd = jSONObject.optString("template_show_type");
        if (JSONObject.NULL.toString().equals(c9894a.apd)) {
            c9894a.apd = "";
        }
        c9894a.ape = jSONObject.optInt("award_task_name");
        c9894a.apf = jSONObject.optInt("jumps_liveroom_type");
        c9894a.apg = jSONObject.optInt("universe_feature_freg");
        c9894a.api = jSONObject.optInt("is_special_preload");
        c9894a.apj = jSONObject.optInt("card_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27139b(C9893a.C9894a c9894a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9894a.templateId;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "template_id", c9894a.templateId);
        }
        String str2 = c9894a.apd;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "template_show_type", c9894a.apd);
        }
        int i = c9894a.ape;
        if (i != 0) {
            C11126t.putValue(jSONObject, "award_task_name", i);
        }
        int i2 = c9894a.apf;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "jumps_liveroom_type", i2);
        }
        int i3 = c9894a.apg;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "universe_feature_freg", i3);
        }
        int i4 = c9894a.api;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "is_special_preload", i4);
        }
        int i5 = c9894a.apj;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "card_type", i5);
        }
        return jSONObject;
    }
}
