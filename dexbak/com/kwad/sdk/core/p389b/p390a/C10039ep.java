package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ep */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10039ep implements InterfaceC10273d<AdInfo.H5Config> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        m27010a(h5Config, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        return m27009b(h5Config, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27010a(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        h5Config.apiMisTouch = jSONObject.optInt("apiMisTouch");
        h5Config.apiAdTag = jSONObject.optInt("apiAdTag");
        h5Config.apiBreathLamp = jSONObject.optInt("apiBreathLamp");
        h5Config.tagTip = jSONObject.optString("tagTip");
        if (JSONObject.NULL.toString().equals(h5Config.tagTip)) {
            h5Config.tagTip = "";
        }
        h5Config.aggregateMiddlePageShowPathSwitch = jSONObject.optBoolean("aggregateMiddlePageShowPathSwitch");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27009b(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = h5Config.apiMisTouch;
        if (i != 0) {
            C11126t.putValue(jSONObject, "apiMisTouch", i);
        }
        int i2 = h5Config.apiAdTag;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "apiAdTag", i2);
        }
        int i3 = h5Config.apiBreathLamp;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "apiBreathLamp", i3);
        }
        String str = h5Config.tagTip;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "tagTip", h5Config.tagTip);
        }
        boolean z = h5Config.aggregateMiddlePageShowPathSwitch;
        if (z) {
            C11126t.putValue(jSONObject, "aggregateMiddlePageShowPathSwitch", z);
        }
        return jSONObject;
    }
}
