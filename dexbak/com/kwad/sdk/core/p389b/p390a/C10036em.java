package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9151h;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.em */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10036em implements InterfaceC10273d<C9151h.C9153b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9151h.C9153b c9153b, JSONObject jSONObject) {
        m27016a(c9153b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9151h.C9153b c9153b, JSONObject jSONObject) {
        return m27015b(c9153b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27016a(C9151h.C9153b c9153b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9153b.f29245Wb = jSONObject.optInt("playableSrc");
        c9153b.f29246Wc = jSONObject.optInt("isMiddleEnd");
        c9153b.f29244Md = jSONObject.optInt("adType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27015b(C9151h.C9153b c9153b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9153b.f29245Wb;
        if (i != 0) {
            C11126t.putValue(jSONObject, "playableSrc", i);
        }
        int i2 = c9153b.f29246Wc;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "isMiddleEnd", i2);
        }
        int i3 = c9153b.f29244Md;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "adType", i3);
        }
        return jSONObject;
    }
}
