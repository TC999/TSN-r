package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9081am;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.eq */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10040eq implements InterfaceC10273d<C9081am.C9083b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9081am.C9083b c9083b, JSONObject jSONObject) {
        m27008a(c9083b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9081am.C9083b c9083b, JSONObject jSONObject) {
        return m27007b(c9083b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27008a(C9081am.C9083b c9083b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9083b.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27007b(C9081am.C9083b c9083b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "creativeId", c9083b.creativeId);
        return jSONObject;
    }
}
