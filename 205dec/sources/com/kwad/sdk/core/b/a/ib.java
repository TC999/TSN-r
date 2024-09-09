package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.check.RewardCheckMonitorInfo;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ib implements com.kwad.sdk.core.d<RewardCheckMonitorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        a2(rewardCheckMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        return b2(rewardCheckMonitorInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardCheckMonitorInfo.checkType = jSONObject.optInt("check_type");
        rewardCheckMonitorInfo.requestStatus = jSONObject.optInt("request_state");
        rewardCheckMonitorInfo.code = jSONObject.optInt("code");
        rewardCheckMonitorInfo.creativeId = jSONObject.optLong(CampaignEx.JSON_KEY_CREATIVE_ID);
        rewardCheckMonitorInfo.dataLoadInterval = jSONObject.optLong("data_load_interval_duration_ms");
        rewardCheckMonitorInfo.posId = jSONObject.optLong("pos_Id");
        rewardCheckMonitorInfo.enviType = jSONObject.optInt("enviType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = rewardCheckMonitorInfo.checkType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "check_type", i4);
        }
        int i5 = rewardCheckMonitorInfo.requestStatus;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_state", i5);
        }
        int i6 = rewardCheckMonitorInfo.code;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "code", i6);
        }
        long j4 = rewardCheckMonitorInfo.creativeId;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, j4);
        }
        long j5 = rewardCheckMonitorInfo.dataLoadInterval;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "data_load_interval_duration_ms", j5);
        }
        long j6 = rewardCheckMonitorInfo.posId;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pos_Id", j6);
        }
        int i7 = rewardCheckMonitorInfo.enviType;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enviType", i7);
        }
        return jSONObject;
    }
}
