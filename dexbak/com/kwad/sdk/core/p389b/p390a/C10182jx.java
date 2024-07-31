package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9125bb;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jx */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10182jx implements InterfaceC10273d<C9125bb.C9126a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9125bb.C9126a c9126a, JSONObject jSONObject) {
        m26724a(c9126a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9125bb.C9126a c9126a, JSONObject jSONObject) {
        return m26723b(c9126a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26724a(C9125bb.C9126a c9126a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9126a.f29220Yc = jSONObject.optInt("taskStatus");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26723b(C9125bb.C9126a c9126a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9126a.f29220Yc;
        if (i != 0) {
            C11126t.putValue(jSONObject, "taskStatus", i);
        }
        return jSONObject;
    }
}
