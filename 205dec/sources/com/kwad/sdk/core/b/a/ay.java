package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ay implements com.kwad.sdk.core.d<AdMatrixInfo.AggregationCardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.AggregationCardInfo aggregationCardInfo, JSONObject jSONObject) {
        a2(aggregationCardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.AggregationCardInfo aggregationCardInfo, JSONObject jSONObject) {
        return b2(aggregationCardInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.AggregationCardInfo aggregationCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aggregationCardInfo.changeTime = jSONObject.optInt("changeTime");
        aggregationCardInfo.maxTimesPerDay = jSONObject.optInt("maxTimesPerDay");
        aggregationCardInfo.intervalTime = jSONObject.optLong("intervalTime", new Long("1200").longValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.AggregationCardInfo aggregationCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = aggregationCardInfo.changeTime;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "changeTime", i4);
        }
        int i5 = aggregationCardInfo.maxTimesPerDay;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "maxTimesPerDay", i5);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "intervalTime", aggregationCardInfo.intervalTime);
        return jSONObject;
    }
}
