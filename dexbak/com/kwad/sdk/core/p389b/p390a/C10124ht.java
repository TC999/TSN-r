package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ht */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10124ht implements InterfaceC10273d<AdInfo.PlayableStyleInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        m26840a(playableStyleInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        return m26839b(playableStyleInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26840a(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        playableStyleInfo.playableOrientation = jSONObject.optInt("playableOrientation");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26839b(AdInfo.PlayableStyleInfo playableStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = playableStyleInfo.playableOrientation;
        if (i != 0) {
            C11126t.putValue(jSONObject, "playableOrientation", i);
        }
        return jSONObject;
    }
}
