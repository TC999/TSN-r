package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9254o;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hg */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10111hg implements InterfaceC10273d<C9254o> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9254o c9254o, JSONObject jSONObject) {
        m26866a(c9254o, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9254o c9254o, JSONObject jSONObject) {
        return m26865b(c9254o, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26866a(C9254o c9254o, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9254o.scene = jSONObject.optInt("scene");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26865b(C9254o c9254o, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9254o.scene;
        if (i != 0) {
            C11126t.putValue(jSONObject, "scene", i);
        }
        return jSONObject;
    }
}
