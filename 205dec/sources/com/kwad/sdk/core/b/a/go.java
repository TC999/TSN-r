package com.kwad.sdk.core.b.a;

import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class go implements com.kwad.sdk.core.d<NativeAdExtraDataImpl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        a2(nativeAdExtraDataImpl, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        return b2(nativeAdExtraDataImpl, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeAdExtraDataImpl.enableShake = jSONObject.optBoolean("enableShake");
        nativeAdExtraDataImpl.showLiveStatus = jSONObject.optInt("showLiveStatus");
        nativeAdExtraDataImpl.showLiveStyle = jSONObject.optInt("showLiveStyle");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z3 = nativeAdExtraDataImpl.enableShake;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enableShake", z3);
        }
        int i4 = nativeAdExtraDataImpl.showLiveStatus;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showLiveStatus", i4);
        }
        int i5 = nativeAdExtraDataImpl.showLiveStyle;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showLiveStyle", i5);
        }
        return jSONObject;
    }
}
