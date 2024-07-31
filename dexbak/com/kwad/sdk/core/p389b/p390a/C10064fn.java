package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.interstitial.report.InterstitialReportInfo;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fn */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10064fn implements InterfaceC10273d<InterstitialReportInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        m26960a(interstitialReportInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        return m26959b(interstitialReportInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26960a(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        interstitialReportInfo.status = jSONObject.optInt("status");
        interstitialReportInfo.type = jSONObject.optInt("type");
        interstitialReportInfo.loadDataTime = jSONObject.optLong("load_data_duration_ms");
        interstitialReportInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        interstitialReportInfo.renderType = jSONObject.optInt("render_type");
        interstitialReportInfo.expectedRenderType = jSONObject.optInt("expected_render_type");
        interstitialReportInfo.materialType = jSONObject.optInt("material_type");
        interstitialReportInfo.downloadDuration = jSONObject.optLong("download_duration_ms");
        interstitialReportInfo.downloadType = jSONObject.optInt("download_type");
        interstitialReportInfo.downloadSize = jSONObject.optLong("download_size");
        interstitialReportInfo.creativeId = jSONObject.optLong(CampaignEx.JSON_KEY_CREATIVE_ID);
        interstitialReportInfo.videoUrl = jSONObject.optString(CampaignEx.JSON_KEY_VIDEO_URL);
        if (JSONObject.NULL.toString().equals(interstitialReportInfo.videoUrl)) {
            interstitialReportInfo.videoUrl = "";
        }
        interstitialReportInfo.videoDuration = jSONObject.optLong("video_duration_ms");
        interstitialReportInfo.playStartedDuration = jSONObject.optLong("play_started_duration_ms");
        interstitialReportInfo.abParams = jSONObject.optString("ab_params");
        if (JSONObject.NULL.toString().equals(interstitialReportInfo.abParams)) {
            interstitialReportInfo.abParams = "";
        }
        interstitialReportInfo.actionType = jSONObject.optLong("action_type");
        interstitialReportInfo.callbackType = jSONObject.optLong("callback_type");
        interstitialReportInfo.clickSceneType = jSONObject.optLong("click_scene_type");
        interstitialReportInfo.itemClickType = jSONObject.optLong("item_click_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26959b(InterstitialReportInfo interstitialReportInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = interstitialReportInfo.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        int i2 = interstitialReportInfo.type;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "type", i2);
        }
        long j = interstitialReportInfo.loadDataTime;
        if (j != 0) {
            C11126t.putValue(jSONObject, "load_data_duration_ms", j);
        }
        long j2 = interstitialReportInfo.renderDuration;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "render_duration_ms", j2);
        }
        int i3 = interstitialReportInfo.renderType;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "render_type", i3);
        }
        int i4 = interstitialReportInfo.expectedRenderType;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "expected_render_type", i4);
        }
        int i5 = interstitialReportInfo.materialType;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "material_type", i5);
        }
        long j3 = interstitialReportInfo.downloadDuration;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "download_duration_ms", j3);
        }
        int i6 = interstitialReportInfo.downloadType;
        if (i6 != 0) {
            C11126t.putValue(jSONObject, "download_type", i6);
        }
        long j4 = interstitialReportInfo.downloadSize;
        if (j4 != 0) {
            C11126t.putValue(jSONObject, "download_size", j4);
        }
        long j5 = interstitialReportInfo.creativeId;
        if (j5 != 0) {
            C11126t.putValue(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, j5);
        }
        String str = interstitialReportInfo.videoUrl;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, CampaignEx.JSON_KEY_VIDEO_URL, interstitialReportInfo.videoUrl);
        }
        long j6 = interstitialReportInfo.videoDuration;
        if (j6 != 0) {
            C11126t.putValue(jSONObject, "video_duration_ms", j6);
        }
        long j7 = interstitialReportInfo.playStartedDuration;
        if (j7 != 0) {
            C11126t.putValue(jSONObject, "play_started_duration_ms", j7);
        }
        String str2 = interstitialReportInfo.abParams;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "ab_params", interstitialReportInfo.abParams);
        }
        long j8 = interstitialReportInfo.actionType;
        if (j8 != 0) {
            C11126t.putValue(jSONObject, "action_type", j8);
        }
        long j9 = interstitialReportInfo.callbackType;
        if (j9 != 0) {
            C11126t.putValue(jSONObject, "callback_type", j9);
        }
        long j10 = interstitialReportInfo.clickSceneType;
        if (j10 != 0) {
            C11126t.putValue(jSONObject, "click_scene_type", j10);
        }
        long j11 = interstitialReportInfo.itemClickType;
        if (j11 != 0) {
            C11126t.putValue(jSONObject, "item_click_type", j11);
        }
        return jSONObject;
    }
}
