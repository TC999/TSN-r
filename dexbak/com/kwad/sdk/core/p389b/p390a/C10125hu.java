package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.C10492a;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hu */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10125hu implements InterfaceC10273d<C10492a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10492a c10492a, JSONObject jSONObject) {
        m26838a(c10492a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10492a c10492a, JSONObject jSONObject) {
        return m26837b(c10492a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26838a(C10492a c10492a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10492a.posId = jSONObject.optLong("posId");
        c10492a.azV = jSONObject.optInt("adPhotoCountForMedia");
        c10492a.azW = jSONObject.optBoolean("enablePreload");
        c10492a.azX = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        c10492a.azY = jSONObject.optInt("adLoadStrategy");
        c10492a.azZ = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26837b(C10492a c10492a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = c10492a.posId;
        if (j != 0) {
            C11126t.putValue(jSONObject, "posId", j);
        }
        int i = c10492a.azV;
        if (i != 0) {
            C11126t.putValue(jSONObject, "adPhotoCountForMedia", i);
        }
        boolean z = c10492a.azW;
        if (z) {
            C11126t.putValue(jSONObject, "enablePreload", z);
        }
        C11126t.putValue(jSONObject, "increaseAdLoadTime", c10492a.azX);
        int i2 = c10492a.azY;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "adLoadStrategy", i2);
        }
        C11126t.putValue(jSONObject, "drawAdForcedWatchTimes", c10492a.azZ);
        return jSONObject;
    }
}
