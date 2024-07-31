package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9261v;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kk */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10196kk implements InterfaceC10273d<C9261v> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9261v c9261v, JSONObject jSONObject) {
        m26696a(c9261v, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9261v c9261v, JSONObject jSONObject) {
        return m26695b(c9261v, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26696a(C9261v c9261v, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9261v.aau = jSONObject.optInt("rewardTaskState");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26695b(C9261v c9261v, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9261v.aau;
        if (i != 0) {
            C11126t.putValue(jSONObject, "rewardTaskState", i);
        }
        return jSONObject;
    }
}
