package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.iu */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10152iu implements InterfaceC10273d<C9259t> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9259t c9259t, JSONObject jSONObject) {
        m26784a(c9259t, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9259t c9259t, JSONObject jSONObject) {
        return m26783b(c9259t, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26784a(C9259t c9259t, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9259t.aas = jSONObject.optBoolean("needPromopt");
        c9259t.f29317KE = jSONObject.optBoolean("needReport");
        c9259t.showTime = jSONObject.optInt("showTime");
        c9259t.f29318VU = jSONObject.optLong("playDuration");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26783b(C9259t c9259t, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = c9259t.aas;
        if (z) {
            C11126t.putValue(jSONObject, "needPromopt", z);
        }
        boolean z2 = c9259t.f29317KE;
        if (z2) {
            C11126t.putValue(jSONObject, "needReport", z2);
        }
        int i = c9259t.showTime;
        if (i != 0) {
            C11126t.putValue(jSONObject, "showTime", i);
        }
        long j = c9259t.f29318VU;
        if (j != 0) {
            C11126t.putValue(jSONObject, "playDuration", j);
        }
        return jSONObject;
    }
}
