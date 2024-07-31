package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9031a;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.gt */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10097gt implements InterfaceC10273d<C9031a.C9035c> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9031a.C9035c c9035c, JSONObject jSONObject) {
        m26894a(c9035c, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9031a.C9035c c9035c, JSONObject jSONObject) {
        return m26893b(c9035c, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26894a(C9031a.C9035c c9035c, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9035c.errorCode = jSONObject.optInt("errorCode");
        c9035c.f29077VT = jSONObject.optInt("extra");
        c9035c.f29078VU = jSONObject.optLong("playDuration");
        c9035c.f29079VV = jSONObject.optBoolean("clickRewardDialog");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26893b(C9031a.C9035c c9035c, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9035c.errorCode;
        if (i != 0) {
            C11126t.putValue(jSONObject, "errorCode", i);
        }
        int i2 = c9035c.f29077VT;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "extra", i2);
        }
        long j = c9035c.f29078VU;
        if (j != 0) {
            C11126t.putValue(jSONObject, "playDuration", j);
        }
        boolean z = c9035c.f29079VV;
        if (z) {
            C11126t.putValue(jSONObject, "clickRewardDialog", z);
        }
        return jSONObject;
    }
}
