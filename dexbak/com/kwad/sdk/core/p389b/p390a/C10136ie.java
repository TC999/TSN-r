package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.reward.monitor.RewardMonitorInfo;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ie */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10136ie implements InterfaceC10273d<RewardMonitorInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        m26816a(rewardMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        return m26815b(rewardMonitorInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26816a(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
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
    private static JSONObject m26815b(RewardMonitorInfo rewardMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = rewardMonitorInfo.loadType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "load_type", i);
        }
        int i2 = rewardMonitorInfo.loadStatus;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "load_status", i2);
        }
        int i3 = rewardMonitorInfo.adCount;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "ad_count", i3);
        }
        long j = rewardMonitorInfo.loadDataDuration;
        if (j != 0) {
            C11126t.putValue(jSONObject, "load_data_duration_ms", j);
        }
        long j2 = rewardMonitorInfo.downloadDuration;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "download_duration_ms", j2);
        }
        long j3 = rewardMonitorInfo.totalDuration;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "total_duration_ms", j3);
        }
        int i4 = rewardMonitorInfo.downloadType;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "download_type", i4);
        }
        long j4 = rewardMonitorInfo.downloadSize;
        if (j4 != 0) {
            C11126t.putValue(jSONObject, "download_size", j4);
        }
        long j5 = rewardMonitorInfo.creativeId;
        if (j5 != 0) {
            C11126t.putValue(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, j5);
        }
        String str = rewardMonitorInfo.videoUrl;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, CampaignEx.JSON_KEY_VIDEO_URL, rewardMonitorInfo.videoUrl);
        }
        long j6 = rewardMonitorInfo.videoDuration;
        if (j6 != 0) {
            C11126t.putValue(jSONObject, "video_duration_ms", j6);
        }
        long j7 = rewardMonitorInfo.dataLoadInterval;
        if (j7 != 0) {
            C11126t.putValue(jSONObject, "data_load_interval_duration_ms", j7);
        }
        long j8 = rewardMonitorInfo.dataDownloadInterval;
        if (j8 != 0) {
            C11126t.putValue(jSONObject, "data_download_interval_duration_ms", j8);
        }
        int i5 = rewardMonitorInfo.adSceneType;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "ad_scene_type", i5);
        }
        long j9 = rewardMonitorInfo.renderDuration;
        if (j9 != 0) {
            C11126t.putValue(jSONObject, "render_duration_ms", j9);
        }
        long j10 = rewardMonitorInfo.currentDuration;
        if (j10 != 0) {
            C11126t.putValue(jSONObject, "video_duration_ms", j10);
        }
        int i6 = rewardMonitorInfo.pageStatus;
        if (i6 != 0) {
            C11126t.putValue(jSONObject, "page_status", i6);
        }
        String str2 = rewardMonitorInfo.subStage;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "sub_stage", rewardMonitorInfo.subStage);
        }
        String str3 = rewardMonitorInfo.launchFrom;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "launch_from", rewardMonitorInfo.launchFrom);
        }
        int i7 = rewardMonitorInfo.rewardType;
        if (i7 != 0) {
            C11126t.putValue(jSONObject, "reward_type", i7);
        }
        int i8 = rewardMonitorInfo.taskType;
        if (i8 != 0) {
            C11126t.putValue(jSONObject, "task_type", i8);
        }
        int i9 = rewardMonitorInfo.taskStep;
        if (i9 != 0) {
            C11126t.putValue(jSONObject, "task_step", i9);
        }
        long j11 = rewardMonitorInfo.posId;
        if (j11 != 0) {
            C11126t.putValue(jSONObject, "pos_Id", j11);
        }
        int i10 = rewardMonitorInfo.materialType;
        if (i10 != 0) {
            C11126t.putValue(jSONObject, "material_type", i10);
        }
        String str4 = rewardMonitorInfo.materialRenderType;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "material_render_type", rewardMonitorInfo.materialRenderType);
        }
        int i11 = rewardMonitorInfo.operationType;
        if (i11 != 0) {
            C11126t.putValue(jSONObject, "operation_type", i11);
        }
        int i12 = rewardMonitorInfo.tkRenderType;
        if (i12 != 0) {
            C11126t.putValue(jSONObject, "tk_render_type", i12);
        }
        String str5 = rewardMonitorInfo.callbackType;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "callback_type", rewardMonitorInfo.callbackType);
        }
        boolean z = rewardMonitorInfo.enableRewardLayoutOptimise;
        if (z) {
            C11126t.putValue(jSONObject, "enable_reward_layout_optimise", z);
        }
        boolean z2 = rewardMonitorInfo.enableFullscreenLayoutOptimise;
        if (z2) {
            C11126t.putValue(jSONObject, "enable_fullscreen_layout_optimise", z2);
        }
        int i13 = rewardMonitorInfo.rewardTaskType;
        if (i13 != 0) {
            C11126t.putValue(jSONObject, "reward_task_type", i13);
        }
        String str6 = rewardMonitorInfo.interceptReason;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "intercept_reason", rewardMonitorInfo.interceptReason);
        }
        return jSONObject;
    }
}
