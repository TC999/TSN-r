package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.p304n.p316c.C8763b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ha */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10105ha implements InterfaceC10273d<C8763b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C8763b c8763b, JSONObject jSONObject) {
        m26878a(c8763b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C8763b c8763b, JSONObject jSONObject) {
        return m26877b(c8763b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26878a(C8763b c8763b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c8763b.f28464NR = jSONObject.optString("load_module");
        if (JSONObject.NULL.toString().equals(c8763b.f28464NR)) {
            c8763b.f28464NR = "";
        }
        c8763b.f28465NS = jSONObject.optLong("load_status");
        c8763b.f28466NT = jSONObject.optLong("load_duration_ms");
        c8763b.f28467NU = jSONObject.optLong("thread_core_size", new Long("0").longValue());
        c8763b.f28468NV = jSONObject.optString("load_source");
        if (JSONObject.NULL.toString().equals(c8763b.f28468NV)) {
            c8763b.f28468NV = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26877b(C8763b c8763b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c8763b.f28464NR;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "load_module", c8763b.f28464NR);
        }
        long j = c8763b.f28465NS;
        if (j != 0) {
            C11126t.putValue(jSONObject, "load_status", j);
        }
        long j2 = c8763b.f28466NT;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "load_duration_ms", j2);
        }
        C11126t.putValue(jSONObject, "thread_core_size", c8763b.f28467NU);
        String str2 = c8763b.f28468NV;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "load_source", c8763b.f28468NV);
        }
        return jSONObject;
    }
}
