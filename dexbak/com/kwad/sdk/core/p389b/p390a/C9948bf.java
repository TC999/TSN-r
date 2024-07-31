package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9241b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bf */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9948bf implements InterfaceC10273d<C9241b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9241b c9241b, JSONObject jSONObject) {
        m27178a(c9241b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9241b c9241b, JSONObject jSONObject) {
        return m27177b(c9241b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27178a(C9241b c9241b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9241b.aaf = jSONObject.optInt("hasInstalled");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27177b(C9241b c9241b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9241b.aaf;
        if (i != 0) {
            C11126t.putValue(jSONObject, "hasInstalled", i);
        }
        return jSONObject;
    }
}
