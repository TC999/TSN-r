package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.interstitial.report.realtime.model.InterstitialRealTimeInfo;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fm */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10063fm implements InterfaceC10273d<InterstitialRealTimeInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(InterstitialRealTimeInfo interstitialRealTimeInfo, JSONObject jSONObject) {
        m26962a(interstitialRealTimeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(InterstitialRealTimeInfo interstitialRealTimeInfo, JSONObject jSONObject) {
        return m26961b(interstitialRealTimeInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26962a(InterstitialRealTimeInfo interstitialRealTimeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        interstitialRealTimeInfo.renderType = jSONObject.optLong("render_type");
        interstitialRealTimeInfo.monitorIndex = jSONObject.optLong("monitor_index");
        interstitialRealTimeInfo.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(interstitialRealTimeInfo.materialUrl)) {
            interstitialRealTimeInfo.materialUrl = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26961b(InterstitialRealTimeInfo interstitialRealTimeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = interstitialRealTimeInfo.renderType;
        if (j != 0) {
            C11126t.putValue(jSONObject, "render_type", j);
        }
        long j2 = interstitialRealTimeInfo.monitorIndex;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "monitor_index", j2);
        }
        String str = interstitialRealTimeInfo.materialUrl;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "material_url", interstitialRealTimeInfo.materialUrl);
        }
        return jSONObject;
    }
}
