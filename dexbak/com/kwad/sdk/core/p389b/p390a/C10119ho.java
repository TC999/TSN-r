package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9255p;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ho */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10119ho implements InterfaceC10273d<C9255p> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9255p c9255p, JSONObject jSONObject) {
        m26850a(c9255p, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9255p c9255p, JSONObject jSONObject) {
        return m26849b(c9255p, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26850a(C9255p c9255p, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9255p.aaq = jSONObject.optBoolean("isEnd");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26849b(C9255p c9255p, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = c9255p.aaq;
        if (z) {
            C11126t.putValue(jSONObject, "isEnd", z);
        }
        return jSONObject;
    }
}
