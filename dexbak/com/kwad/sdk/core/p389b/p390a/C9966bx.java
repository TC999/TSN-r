package com.kwad.sdk.core.p389b.p390a;

import com.github.mikephil.charting.utils.Utils;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.webview.p423d.p425b.C10641b;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bx */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9966bx implements InterfaceC10273d<C10641b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10641b c10641b, JSONObject jSONObject) {
        m27142a(c10641b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10641b c10641b, JSONObject jSONObject) {
        return m27141b(c10641b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27142a(C10641b c10641b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10641b.f29647x = jSONObject.optDouble("x");
        c10641b.f29648y = jSONObject.optDouble("y");
        c10641b.width = jSONObject.optInt("width");
        c10641b.height = jSONObject.optInt("height");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27141b(C10641b c10641b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = c10641b.f29647x;
        if (d != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "x", d);
        }
        double d2 = c10641b.f29648y;
        if (d2 != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "y", d2);
        }
        int i = c10641b.width;
        if (i != 0) {
            C11126t.putValue(jSONObject, "width", i);
        }
        int i2 = c10641b.height;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "height", i2);
        }
        return jSONObject;
    }
}
