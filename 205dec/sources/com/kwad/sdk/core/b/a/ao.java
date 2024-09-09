package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStatusInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ao implements com.kwad.sdk.core.d<AdStatusInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        a2(adStatusInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        return b2(adStatusInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStatusInfo.loadFromCache = jSONObject.optBoolean("loadFromCache");
        adStatusInfo.loadDataTime = jSONObject.optLong("loadDataTime");
        adStatusInfo.downloadFinishTime = jSONObject.optLong("downloadFinishTime");
        adStatusInfo.downloadType = jSONObject.optInt("downloadType");
        adStatusInfo.downloadSize = jSONObject.optLong("downloadSize");
        adStatusInfo.downloadStatus = jSONObject.optInt("downloadStatus");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z3 = adStatusInfo.loadFromCache;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadFromCache", z3);
        }
        long j4 = adStatusInfo.loadDataTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadDataTime", j4);
        }
        long j5 = adStatusInfo.downloadFinishTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadFinishTime", j5);
        }
        int i4 = adStatusInfo.downloadType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadType", i4);
        }
        long j6 = adStatusInfo.downloadSize;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadSize", j6);
        }
        int i5 = adStatusInfo.downloadStatus;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadStatus", i5);
        }
        return jSONObject;
    }
}
