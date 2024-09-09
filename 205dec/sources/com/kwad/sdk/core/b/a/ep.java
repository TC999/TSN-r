package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ep implements com.kwad.sdk.core.d<AdInfo.H5Config> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        a2(h5Config, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        return b2(h5Config, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.H5Config h5Config, JSONObject jSONObject) {
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
    private static JSONObject b2(AdInfo.H5Config h5Config, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = h5Config.apiMisTouch;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apiMisTouch", i4);
        }
        int i5 = h5Config.apiAdTag;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apiAdTag", i5);
        }
        int i6 = h5Config.apiBreathLamp;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "apiBreathLamp", i6);
        }
        String str = h5Config.tagTip;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tagTip", h5Config.tagTip);
        }
        boolean z3 = h5Config.aggregateMiddlePageShowPathSwitch;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "aggregateMiddlePageShowPathSwitch", z3);
        }
        return jSONObject;
    }
}
