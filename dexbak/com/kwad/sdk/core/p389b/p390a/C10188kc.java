package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.threads.C10515d;
import com.kwad.sdk.utils.C11126t;
import com.umeng.analytics.pro.UMCommonContent;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kc */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10188kc implements InterfaceC10273d<C10515d> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10515d c10515d, JSONObject jSONObject) {
        m26712a(c10515d, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10515d c10515d, JSONObject jSONObject) {
        return m26711b(c10515d, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26712a(C10515d c10515d, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10515d.aAN = jSONObject.optInt("rate_reciprocal");
        c10515d.aAT = jSONObject.optInt("threshold");
        c10515d.interval = jSONObject.optLong(UMCommonContent.f37794aX);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26711b(C10515d c10515d, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c10515d.aAN;
        if (i != 0) {
            C11126t.putValue(jSONObject, "rate_reciprocal", i);
        }
        int i2 = c10515d.aAT;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "threshold", i2);
        }
        long j = c10515d.interval;
        if (j != 0) {
            C11126t.putValue(jSONObject, UMCommonContent.f37794aX, j);
        }
        return jSONObject;
    }
}
