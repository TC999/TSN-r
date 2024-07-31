package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.request.model.C8929b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bi */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9951bi implements InterfaceC10273d<C8929b.C8930a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C8929b.C8930a c8930a, JSONObject jSONObject) {
        m27172a(c8930a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C8929b.C8930a c8930a, JSONObject jSONObject) {
        return m27171b(c8930a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27172a(C8929b.C8930a c8930a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c8930a.streamType = jSONObject.optInt("streamType");
        c8930a.f28840Sa = jSONObject.optInt("maxVolume");
        c8930a.f28841Sb = jSONObject.optInt("minVolume");
        c8930a.f28842Sc = jSONObject.optInt("currentVolume");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27171b(C8929b.C8930a c8930a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c8930a.streamType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "streamType", i);
        }
        int i2 = c8930a.f28840Sa;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "maxVolume", i2);
        }
        int i3 = c8930a.f28841Sb;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "minVolume", i3);
        }
        int i4 = c8930a.f28842Sc;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "currentVolume", i4);
        }
        return jSONObject;
    }
}
