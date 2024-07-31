package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.page.p320b.C8797a;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fy */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10075fy implements InterfaceC10273d<C8797a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C8797a c8797a, JSONObject jSONObject) {
        m26938a(c8797a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C8797a c8797a, JSONObject jSONObject) {
        return m26937b(c8797a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26938a(C8797a c8797a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c8797a.adStyle = jSONObject.optInt("ad_style");
        c8797a.f28536Ov = jSONObject.optInt("neo_tk_render_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26937b(C8797a c8797a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c8797a.adStyle;
        if (i != 0) {
            C11126t.putValue(jSONObject, "ad_style", i);
        }
        int i2 = c8797a.f28536Ov;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "neo_tk_render_type", i2);
        }
        return jSONObject;
    }
}
