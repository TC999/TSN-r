package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdProductInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ix implements com.kwad.sdk.core.d<AdProductInfo.SpikeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        a2(spikeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        return b2(spikeInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        spikeInfo.endTime = jSONObject.optLong("endTime");
        spikeInfo.soldStock = jSONObject.optInt("soldStock");
        spikeInfo.originalStock = jSONObject.optInt("originalStock");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = spikeInfo.endTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "endTime", j4);
        }
        int i4 = spikeInfo.soldStock;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "soldStock", i4);
        }
        int i5 = spikeInfo.originalStock;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "originalStock", i5);
        }
        return jSONObject;
    }
}
