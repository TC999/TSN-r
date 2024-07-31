package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.gu */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10098gu implements InterfaceC10273d<AdGlobalConfigInfo.NeoScanAggregationSceneInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        m26892a(neoScanAggregationSceneInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        return m26891b(neoScanAggregationSceneInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26892a(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        neoScanAggregationSceneInfo.neoCountDownNeedSwipeTrigger = jSONObject.optBoolean("neoCountDownNeedSwipeTrigger");
        neoScanAggregationSceneInfo.neoCountDownTime = jSONObject.optInt("neoCountDownTime");
        neoScanAggregationSceneInfo.noActionStopCountDown = jSONObject.optBoolean("noActionStopCountDown");
        neoScanAggregationSceneInfo.noActionTime = jSONObject.optInt("noActionTime");
        neoScanAggregationSceneInfo.guidSwipezShowMore = jSONObject.optBoolean("guidSwipezShowMore");
        neoScanAggregationSceneInfo.mute = jSONObject.optBoolean(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26891b(AdGlobalConfigInfo.NeoScanAggregationSceneInfo neoScanAggregationSceneInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = neoScanAggregationSceneInfo.neoCountDownNeedSwipeTrigger;
        if (z) {
            C11126t.putValue(jSONObject, "neoCountDownNeedSwipeTrigger", z);
        }
        int i = neoScanAggregationSceneInfo.neoCountDownTime;
        if (i != 0) {
            C11126t.putValue(jSONObject, "neoCountDownTime", i);
        }
        boolean z2 = neoScanAggregationSceneInfo.noActionStopCountDown;
        if (z2) {
            C11126t.putValue(jSONObject, "noActionStopCountDown", z2);
        }
        int i2 = neoScanAggregationSceneInfo.noActionTime;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "noActionTime", i2);
        }
        boolean z3 = neoScanAggregationSceneInfo.guidSwipezShowMore;
        if (z3) {
            C11126t.putValue(jSONObject, "guidSwipezShowMore", z3);
        }
        boolean z4 = neoScanAggregationSceneInfo.mute;
        if (z4) {
            C11126t.putValue(jSONObject, CampaignEx.JSON_NATIVE_VIDEO_MUTE, z4);
        }
        return jSONObject;
    }
}
