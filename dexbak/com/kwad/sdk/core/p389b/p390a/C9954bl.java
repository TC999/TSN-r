package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9243d;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bl */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9954bl implements InterfaceC10273d<C9243d> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9243d c9243d, JSONObject jSONObject) {
        m27166a(c9243d, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9243d c9243d, JSONObject jSONObject) {
        return m27165b(c9243d, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27166a(C9243d c9243d, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9243d.aah = jSONObject.optBoolean("autoPlay");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27165b(C9243d c9243d, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = c9243d.aah;
        if (z) {
            C11126t.putValue(jSONObject, "autoPlay", z);
        }
        return jSONObject;
    }
}
