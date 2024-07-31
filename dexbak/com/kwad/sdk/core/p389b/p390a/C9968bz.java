package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.report.C10464n;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bz */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9968bz implements InterfaceC10273d<C10464n.C10465a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10464n.C10465a c10465a, JSONObject jSONObject) {
        m27138a(c10465a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10464n.C10465a c10465a, JSONObject jSONObject) {
        return m27137b(c10465a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27138a(C10464n.C10465a c10465a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10465a.ayR = jSONObject.optInt("posIdWidth");
        c10465a.ayS = jSONObject.optInt("posIdHeight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27137b(C10464n.C10465a c10465a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c10465a.ayR;
        if (i != 0) {
            C11126t.putValue(jSONObject, "posIdWidth", i);
        }
        int i2 = c10465a.ayS;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "posIdHeight", i2);
        }
        return jSONObject;
    }
}
