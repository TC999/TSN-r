package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9145e;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ei */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10032ei implements InterfaceC10273d<C9145e.C9146a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9145e.C9146a c9146a, JSONObject jSONObject) {
        m27024a(c9146a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9145e.C9146a c9146a, JSONObject jSONObject) {
        return m27023b(c9146a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27024a(C9145e.C9146a c9146a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9146a.showLiveStatus = jSONObject.optInt("showLiveStatus");
        c9146a.showLiveStyle = jSONObject.optInt("showLiveStyle");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27023b(C9145e.C9146a c9146a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9146a.showLiveStatus;
        if (i != 0) {
            C11126t.putValue(jSONObject, "showLiveStatus", i);
        }
        int i2 = c9146a.showLiveStyle;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "showLiveStyle", i2);
        }
        return jSONObject;
    }
}
