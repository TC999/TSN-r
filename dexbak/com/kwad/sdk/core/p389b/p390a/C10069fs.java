package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9134be;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fs */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10069fs implements InterfaceC10273d<C9134be.C9136a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9134be.C9136a c9136a, JSONObject jSONObject) {
        m26950a(c9136a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9134be.C9136a c9136a, JSONObject jSONObject) {
        return m26949b(c9136a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26950a(C9134be.C9136a c9136a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9136a.f29233kl = jSONObject.optInt("itemClickType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26949b(C9134be.C9136a c9136a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9136a.f29233kl;
        if (i != 0) {
            C11126t.putValue(jSONObject, "itemClickType", i);
        }
        return jSONObject;
    }
}
