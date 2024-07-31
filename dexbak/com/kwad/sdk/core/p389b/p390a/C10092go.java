package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.go */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10092go implements InterfaceC10273d<NativeAdExtraDataImpl> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        m26904a(nativeAdExtraDataImpl, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        return m26903b(nativeAdExtraDataImpl, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26904a(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeAdExtraDataImpl.enableShake = jSONObject.optBoolean("enableShake");
        nativeAdExtraDataImpl.showLiveStatus = jSONObject.optInt("showLiveStatus");
        nativeAdExtraDataImpl.showLiveStyle = jSONObject.optInt("showLiveStyle");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26903b(NativeAdExtraDataImpl nativeAdExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = nativeAdExtraDataImpl.enableShake;
        if (z) {
            C11126t.putValue(jSONObject, "enableShake", z);
        }
        int i = nativeAdExtraDataImpl.showLiveStatus;
        if (i != 0) {
            C11126t.putValue(jSONObject, "showLiveStatus", i);
        }
        int i2 = nativeAdExtraDataImpl.showLiveStyle;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "showLiveStyle", i2);
        }
        return jSONObject;
    }
}
