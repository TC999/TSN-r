package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.p304n.p316c.C8765d;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kj */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10195kj implements InterfaceC10273d<C8765d> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C8765d c8765d, JSONObject jSONObject) {
        m26698a(c8765d, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C8765d c8765d, JSONObject jSONObject) {
        return m26697b(c8765d, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26698a(C8765d c8765d, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c8765d.f28469NR = jSONObject.optString("load_module");
        if (JSONObject.NULL.toString().equals(c8765d.f28469NR)) {
            c8765d.f28469NR = "";
        }
        c8765d.f28470NS = jSONObject.optLong("load_status");
        c8765d.f28471NT = jSONObject.optLong("load_duration_ms");
        c8765d.f28473NW = jSONObject.optLong("update_duration_ms");
        c8765d.f28472NV = jSONObject.optString("load_source");
        if (JSONObject.NULL.toString().equals(c8765d.f28472NV)) {
            c8765d.f28472NV = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26697b(C8765d c8765d, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c8765d.f28469NR;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "load_module", c8765d.f28469NR);
        }
        long j = c8765d.f28470NS;
        if (j != 0) {
            C11126t.putValue(jSONObject, "load_status", j);
        }
        long j2 = c8765d.f28471NT;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "load_duration_ms", j2);
        }
        long j3 = c8765d.f28473NW;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "update_duration_ms", j3);
        }
        String str2 = c8765d.f28472NV;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "load_source", c8765d.f28472NV);
        }
        return jSONObject;
    }
}
