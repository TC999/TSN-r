package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.gs */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10096gs implements InterfaceC10273d<StatusInfo.NativeAdStyleControl> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(StatusInfo.NativeAdStyleControl nativeAdStyleControl, JSONObject jSONObject) {
        m26896a(nativeAdStyleControl, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(StatusInfo.NativeAdStyleControl nativeAdStyleControl, JSONObject jSONObject) {
        return m26895b(nativeAdStyleControl, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26896a(StatusInfo.NativeAdStyleControl nativeAdStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeAdStyleControl.enableShake = jSONObject.optBoolean("enableShake");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26895b(StatusInfo.NativeAdStyleControl nativeAdStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = nativeAdStyleControl.enableShake;
        if (z) {
            C11126t.putValue(jSONObject, "enableShake", z);
        }
        return jSONObject;
    }
}
