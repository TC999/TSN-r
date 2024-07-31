package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.reward.check.RewardCheckMonitorInfo;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ib */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10133ib implements InterfaceC10273d<RewardCheckMonitorInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        m26822a(rewardCheckMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        return m26821b(rewardCheckMonitorInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26822a(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
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
    private static JSONObject m26821b(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = rewardCheckMonitorInfo.checkType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "check_type", i);
        }
        int i2 = rewardCheckMonitorInfo.requestStatus;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "request_state", i2);
        }
        int i3 = rewardCheckMonitorInfo.code;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "code", i3);
        }
        long j = rewardCheckMonitorInfo.creativeId;
        if (j != 0) {
            C11126t.putValue(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, j);
        }
        long j2 = rewardCheckMonitorInfo.dataLoadInterval;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "data_load_interval_duration_ms", j2);
        }
        long j3 = rewardCheckMonitorInfo.posId;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "pos_Id", j3);
        }
        int i4 = rewardCheckMonitorInfo.enviType;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "enviType", i4);
        }
        return jSONObject;
    }
}
