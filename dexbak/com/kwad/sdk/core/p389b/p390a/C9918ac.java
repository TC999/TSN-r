package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.adlog.p387b.C9905b;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ac */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9918ac implements InterfaceC10273d<C9905b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9905b c9905b, JSONObject jSONObject) {
        m27238a(c9905b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9905b c9905b, JSONObject jSONObject) {
        return m27237b(c9905b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27238a(C9905b c9905b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9905b.status = jSONObject.optInt("status");
        c9905b.aoM = jSONObject.optInt("ad_action_type");
        c9905b.retryCount = jSONObject.optInt("retry_count");
        c9905b.apt = jSONObject.optInt("retry_error_code");
        c9905b.apu = jSONObject.optString("retry_error_msg");
        if (JSONObject.NULL.toString().equals(c9905b.apu)) {
            c9905b.apu = "";
        }
        c9905b.apD = jSONObject.optInt("cache_total_num");
        c9905b.apE = jSONObject.optInt("cache_num");
        c9905b.apF = jSONObject.optLong("cacheTimeMs");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27237b(C9905b c9905b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9905b.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        int i2 = c9905b.aoM;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "ad_action_type", i2);
        }
        int i3 = c9905b.retryCount;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "retry_count", i3);
        }
        int i4 = c9905b.apt;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "retry_error_code", i4);
        }
        String str = c9905b.apu;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "retry_error_msg", c9905b.apu);
        }
        int i5 = c9905b.apD;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "cache_total_num", i5);
        }
        int i6 = c9905b.apE;
        if (i6 != 0) {
            C11126t.putValue(jSONObject, "cache_num", i6);
        }
        long j = c9905b.apF;
        if (j != 0) {
            C11126t.putValue(jSONObject, "cacheTimeMs", j);
        }
        return jSONObject;
    }
}
