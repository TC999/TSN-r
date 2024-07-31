package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.crash.online.monitor.p428a.C10696a;
import com.kwad.sdk.crash.online.monitor.p428a.C10698c;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.gm */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10090gm implements InterfaceC10273d<C10698c> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10698c c10698c, JSONObject jSONObject) {
        m26908a(c10698c, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10698c c10698c, JSONObject jSONObject) {
        return m26907b(c10698c, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26908a(C10698c c10698c, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        C10696a c10696a = new C10696a();
        c10698c.aHd = c10696a;
        c10696a.parseJson(jSONObject.optJSONObject("blockConfig"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26907b(C10698c c10698c, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.m23678a(jSONObject, "blockConfig", c10698c.aHd);
        return jSONObject;
    }
}
