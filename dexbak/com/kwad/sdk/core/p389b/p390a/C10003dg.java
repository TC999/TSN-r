package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.dg */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10003dg implements InterfaceC10273d<AdStyleInfo.PlayDetailInfo.DrawAdInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo, JSONObject jSONObject) {
        m27076a(drawAdInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo, JSONObject jSONObject) {
        return m27075b(drawAdInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27076a(AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        drawAdInfo.forcedWatch = jSONObject.optBoolean("forcedWatch");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27075b(AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = drawAdInfo.forcedWatch;
        if (z) {
            C11126t.putValue(jSONObject, "forcedWatch", z);
        }
        return jSONObject;
    }
}
