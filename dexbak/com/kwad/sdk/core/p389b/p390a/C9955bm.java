package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9102at;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bm */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9955bm implements InterfaceC10273d<C9102at.C9103a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9102at.C9103a c9103a, JSONObject jSONObject) {
        m27164a(c9103a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9102at.C9103a c9103a, JSONObject jSONObject) {
        return m27163b(c9103a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27164a(C9102at.C9103a c9103a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9103a.status = jSONObject.optInt("status");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27163b(C9102at.C9103a c9103a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9103a.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        return jSONObject;
    }
}
