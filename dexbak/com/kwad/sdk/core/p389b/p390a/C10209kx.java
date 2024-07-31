package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kx */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10209kx implements InterfaceC10273d<WebCloseStatus> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        m26670a(webCloseStatus, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        return m26669b(webCloseStatus, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26670a(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webCloseStatus.interactSuccess = jSONObject.optBoolean("interactSuccess");
        webCloseStatus.closeType = jSONObject.optInt("closeType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26669b(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = webCloseStatus.interactSuccess;
        if (z) {
            C11126t.putValue(jSONObject, "interactSuccess", z);
        }
        int i = webCloseStatus.closeType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "closeType", i);
        }
        return jSONObject;
    }
}
