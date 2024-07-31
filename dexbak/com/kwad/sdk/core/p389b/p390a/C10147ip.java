package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ip */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10147ip implements InterfaceC10273d<AdMatrixInfo.ShakeInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        m26794a(shakeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        return m26793b(shakeInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26794a(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        shakeInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(shakeInfo.title)) {
            shakeInfo.title = "";
        }
        shakeInfo.subtitle = jSONObject.optString("subtitle");
        if (JSONObject.NULL.toString().equals(shakeInfo.subtitle)) {
            shakeInfo.subtitle = "";
        }
        shakeInfo.acceleration = jSONObject.optInt("acceleration");
        shakeInfo.clickDisabled = jSONObject.optBoolean("clickDisabled");
        shakeInfo.componentIndex = jSONObject.optInt("componentIndex");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26793b(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = shakeInfo.title;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "title", shakeInfo.title);
        }
        String str2 = shakeInfo.subtitle;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "subtitle", shakeInfo.subtitle);
        }
        int i = shakeInfo.acceleration;
        if (i != 0) {
            C11126t.putValue(jSONObject, "acceleration", i);
        }
        boolean z = shakeInfo.clickDisabled;
        if (z) {
            C11126t.putValue(jSONObject, "clickDisabled", z);
        }
        int i2 = shakeInfo.componentIndex;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "componentIndex", i2);
        }
        return jSONObject;
    }
}
