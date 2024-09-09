package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ie implements com.kwad.sdk.core.d<RewardMonitorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        a2(rewardMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        return b2(rewardMonitorInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardMonitorInfo.loadType = jSONObject.optInt("load_type");
        rewardMonitorInfo.loadStatus = jSONObject.optInt("load_status");
        rewardMonitorInfo.adCount = jSONObject.optInt("ad_count");
        rewardMonitorInfo.loadDataDuration = jSONObject.optLong("load_data_duration_ms");
        rewardMonitorInfo.downloadDuration = jSONObject.optLong("download_duration_ms");
        rewardMonitorInfo.totalDuration = jSONObject.optLong("total_duration_ms");
        rewardMonitorInfo.downloadType = jSONObject.optInt("download_type");
        rewardMonitorInfo.downloadSize = jSONObject.optLong("download_size");
        rewardMonitorInfo.creativeId = jSONObject.optLong(CampaignEx.JSON_KEY_CREATIVE_ID);
        rewardMonitorInfo.videoUrl = jSONObject.optString(CampaignEx.JSON_KEY_VIDEO_URL);
        if (JSONObject.NULL.toString().equals(rewardMonitorInfo.videoUrl)) {
            rewardMonitorInfo.videoUrl = "";
        }
        rewardMonitorInfo.videoDuration = jSONObject.optLong("video_duration_ms");
        rewardMonitorInfo.dataLoadInterval = jSONObject.optLong("data_load_interval_duration_ms");
        rewardMonitorInfo.dataDownloadInterval = jSONObject.optLong("data_download_interval_duration_ms");
        rewardMonitorInfo.adSceneType = jSONObject.optInt("ad_scene_type");
        rewardMonitorInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        rewardMonitorInfo.currentDuration = jSONObject.optLong("video_duration_ms");
        rewardMonitorInfo.pageStatus = jSONObject.optInt("page_status");
        rewardMonitorInfo.subStage = jSONObject.optString("sub_stage");
        if (JSONObject.NULL.toString().equals(rewardMonitorInfo.subStage)) {
            rewardMonitorInfo.subStage = "";
        }
        rewardMonitorInfo.launchFrom = jSONObject.optString("launch_from");
        if (JSONObject.NULL.toString().equals(rewardMonitorInfo.launchFrom)) {
            rewardMonitorInfo.launchFrom = "";
        }
        rewardMonitorInfo.rewardType = jSONObject.optInt("reward_type");
        rewardMonitorInfo.taskType = jSONObject.optInt("task_type");
        rewardMonitorInfo.taskStep = jSONObject.optInt("task_step");
        rewardMonitorInfo.posId = jSONObject.optLong("pos_Id");
        rewardMonitorInfo.materialType = jSONObject.optInt("material_type");
        rewardMonitorInfo.materialRenderType = jSONObject.optString("material_render_type");
        if (JSONObject.NULL.toString().equals(rewardMonitorInfo.materialRenderType)) {
            rewardMonitorInfo.materialRenderType = "";
        }
        rewardMonitorInfo.operationType = jSONObject.optInt("operation_type");
        rewardMonitorInfo.tkRenderType = jSONObject.optInt("tk_render_type");
        rewardMonitorInfo.callbackType = jSONObject.optString("callback_type");
        if (JSONObject.NULL.toString().equals(rewardMonitorInfo.callbackType)) {
            rewardMonitorInfo.callbackType = "";
        }
        rewardMonitorInfo.enableRewardLayoutOptimise = jSONObject.optBoolean("enable_reward_layout_optimise");
        rewardMonitorInfo.enableFullscreenLayoutOptimise = jSONObject.optBoolean("enable_fullscreen_layout_optimise");
        rewardMonitorInfo.rewardTaskType = jSONObject.optInt("reward_task_type");
        rewardMonitorInfo.interceptReason = jSONObject.optString("intercept_reason");
        if (JSONObject.NULL.toString().equals(rewardMonitorInfo.interceptReason)) {
            rewardMonitorInfo.interceptReason = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = rewardMonitorInfo.loadType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_type", i4);
        }
        int i5 = rewardMonitorInfo.loadStatus;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_status", i5);
        }
        int i6 = rewardMonitorInfo.adCount;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_count", i6);
        }
        long j4 = rewardMonitorInfo.loadDataDuration;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_data_duration_ms", j4);
        }
        long j5 = rewardMonitorInfo.downloadDuration;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "download_duration_ms", j5);
        }
        long j6 = rewardMonitorInfo.totalDuration;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "total_duration_ms", j6);
        }
        int i7 = rewardMonitorInfo.downloadType;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "download_type", i7);
        }
        long j7 = rewardMonitorInfo.downloadSize;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "download_size", j7);
        }
        long j8 = rewardMonitorInfo.creativeId;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, j8);
        }
        String str = rewardMonitorInfo.videoUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CampaignEx.JSON_KEY_VIDEO_URL, rewardMonitorInfo.videoUrl);
        }
        long j9 = rewardMonitorInfo.videoDuration;
        if (j9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "video_duration_ms", j9);
        }
        long j10 = rewardMonitorInfo.dataLoadInterval;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "data_load_interval_duration_ms", j10);
        }
        long j11 = rewardMonitorInfo.dataDownloadInterval;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "data_download_interval_duration_ms", j11);
        }
        int i8 = rewardMonitorInfo.adSceneType;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_scene_type", i8);
        }
        long j12 = rewardMonitorInfo.renderDuration;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "render_duration_ms", j12);
        }
        long j13 = rewardMonitorInfo.currentDuration;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "video_duration_ms", j13);
        }
        int i9 = rewardMonitorInfo.pageStatus;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "page_status", i9);
        }
        String str2 = rewardMonitorInfo.subStage;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sub_stage", rewardMonitorInfo.subStage);
        }
        String str3 = rewardMonitorInfo.launchFrom;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "launch_from", rewardMonitorInfo.launchFrom);
        }
        int i10 = rewardMonitorInfo.rewardType;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reward_type", i10);
        }
        int i11 = rewardMonitorInfo.taskType;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "task_type", i11);
        }
        int i12 = rewardMonitorInfo.taskStep;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "task_step", i12);
        }
        long j14 = rewardMonitorInfo.posId;
        if (j14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pos_Id", j14);
        }
        int i13 = rewardMonitorInfo.materialType;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_type", i13);
        }
        String str4 = rewardMonitorInfo.materialRenderType;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_render_type", rewardMonitorInfo.materialRenderType);
        }
        int i14 = rewardMonitorInfo.operationType;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "operation_type", i14);
        }
        int i15 = rewardMonitorInfo.tkRenderType;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tk_render_type", i15);
        }
        String str5 = rewardMonitorInfo.callbackType;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "callback_type", rewardMonitorInfo.callbackType);
        }
        boolean z3 = rewardMonitorInfo.enableRewardLayoutOptimise;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enable_reward_layout_optimise", z3);
        }
        boolean z4 = rewardMonitorInfo.enableFullscreenLayoutOptimise;
        if (z4) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enable_fullscreen_layout_optimise", z4);
        }
        int i16 = rewardMonitorInfo.rewardTaskType;
        if (i16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reward_task_type", i16);
        }
        String str6 = rewardMonitorInfo.interceptReason;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "intercept_reason", rewardMonitorInfo.interceptReason);
        }
        return jSONObject;
    }
}
