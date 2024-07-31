package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9264y;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ku */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10206ku implements InterfaceC10273d<C9264y> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9264y c9264y, JSONObject jSONObject) {
        m26676a(c9264y, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9264y c9264y, JSONObject jSONObject) {
        return m26675b(c9264y, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26676a(C9264y c9264y, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9264y.f29321nE = jSONObject.optInt("currentTime");
        c9264y.aax = jSONObject.optBoolean("failed");
        c9264y.aat = jSONObject.optBoolean("finished");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26675b(C9264y c9264y, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9264y.f29321nE;
        if (i != 0) {
            C11126t.putValue(jSONObject, "currentTime", i);
        }
        boolean z = c9264y.aax;
        if (z) {
            C11126t.putValue(jSONObject, "failed", z);
        }
        boolean z2 = c9264y.aat;
        if (z2) {
            C11126t.putValue(jSONObject, "finished", z2);
        }
        return jSONObject;
    }
}
