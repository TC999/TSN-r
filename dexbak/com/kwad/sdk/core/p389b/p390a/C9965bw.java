package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bw */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9965bw implements InterfaceC10273d<AdInfo.CallBackStrategyInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.CallBackStrategyInfo callBackStrategyInfo, JSONObject jSONObject) {
        m27144a(callBackStrategyInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.CallBackStrategyInfo callBackStrategyInfo, JSONObject jSONObject) {
        return m27143b(callBackStrategyInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27144a(AdInfo.CallBackStrategyInfo callBackStrategyInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        callBackStrategyInfo.impressionCheckMs = jSONObject.optInt("impressionCheckMs", new Integer("5000").intValue());
        callBackStrategyInfo.callBackAdvanceMs = jSONObject.optInt("callBackAdvanceMs", new Integer("2000").intValue());
        callBackStrategyInfo.serverCheckSwitch = jSONObject.optBoolean("serverCheckSwitch");
        callBackStrategyInfo.rewardAdvanceSwitch = jSONObject.optBoolean("rewardAdvanceSwitch");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27143b(AdInfo.CallBackStrategyInfo callBackStrategyInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "impressionCheckMs", callBackStrategyInfo.impressionCheckMs);
        C11126t.putValue(jSONObject, "callBackAdvanceMs", callBackStrategyInfo.callBackAdvanceMs);
        boolean z = callBackStrategyInfo.serverCheckSwitch;
        if (z) {
            C11126t.putValue(jSONObject, "serverCheckSwitch", z);
        }
        boolean z2 = callBackStrategyInfo.rewardAdvanceSwitch;
        if (z2) {
            C11126t.putValue(jSONObject, "rewardAdvanceSwitch", z2);
        }
        return jSONObject;
    }
}
