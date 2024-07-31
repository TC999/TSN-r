package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ix */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10155ix implements InterfaceC10273d<AdProductInfo.SpikeInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        m26778a(spikeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        return m26777b(spikeInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26778a(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        spikeInfo.endTime = jSONObject.optLong("endTime");
        spikeInfo.soldStock = jSONObject.optInt("soldStock");
        spikeInfo.originalStock = jSONObject.optInt("originalStock");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26777b(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = spikeInfo.endTime;
        if (j != 0) {
            C11126t.putValue(jSONObject, "endTime", j);
        }
        int i = spikeInfo.soldStock;
        if (i != 0) {
            C11126t.putValue(jSONObject, "soldStock", i);
        }
        int i2 = spikeInfo.originalStock;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "originalStock", i2);
        }
        return jSONObject;
    }
}
