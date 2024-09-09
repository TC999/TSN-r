package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.track.AdTrackLog;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class at implements com.kwad.sdk.core.d<AdTrackLog> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdTrackLog adTrackLog, JSONObject jSONObject) {
        a2(adTrackLog, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdTrackLog adTrackLog, JSONObject jSONObject) {
        return b2(adTrackLog, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdTrackLog adTrackLog, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTrackLog.templateId = jSONObject.optString("template_id");
        if (JSONObject.NULL.toString().equals(adTrackLog.templateId)) {
            adTrackLog.templateId = "";
        }
        adTrackLog.sceneId = jSONObject.optString("scene_id");
        if (JSONObject.NULL.toString().equals(adTrackLog.sceneId)) {
            adTrackLog.sceneId = "";
        }
        adTrackLog.preLandingPageSwitch = jSONObject.optInt("pre_landing_page_switch");
        adTrackLog.preLandingPageShowType = jSONObject.optInt("pre_landing_page_show_type");
        adTrackLog.adLiveSwitch = jSONObject.optInt("ad_live_switch");
        adTrackLog.adTkLiveSwitch = jSONObject.optInt("ad_tk_live_switch");
        adTrackLog.adLiveComponentReady = jSONObject.optInt("ad_live_component_ready");
        adTrackLog.serverCheckSwitch = jSONObject.optInt("server_check_switch");
        adTrackLog.rewardAdvanceSwitch = jSONObject.optInt("reward_advance_switch");
        adTrackLog.rewardSkipShowTime = jSONObject.optInt("reward_skip_show_time");
        adTrackLog.isPlugin = jSONObject.optInt("is_plugin");
        adTrackLog.apiSdkVersion = jSONObject.optString("api_sdk_version");
        if (JSONObject.NULL.toString().equals(adTrackLog.apiSdkVersion)) {
            adTrackLog.apiSdkVersion = "";
        }
        adTrackLog.rewardDetailStatusBarHeight = jSONObject.optInt("reward_detail_status_bar_height");
        adTrackLog.rewardDetailCallPositionY = jSONObject.optInt("reward_detail_call_position_y");
        adTrackLog.screenOrientation = jSONObject.optInt("screen_orientation");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdTrackLog adTrackLog, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adTrackLog.templateId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "template_id", adTrackLog.templateId);
        }
        String str2 = adTrackLog.sceneId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "scene_id", adTrackLog.sceneId);
        }
        int i4 = adTrackLog.preLandingPageSwitch;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pre_landing_page_switch", i4);
        }
        int i5 = adTrackLog.preLandingPageShowType;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pre_landing_page_show_type", i5);
        }
        int i6 = adTrackLog.adLiveSwitch;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_live_switch", i6);
        }
        int i7 = adTrackLog.adTkLiveSwitch;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_tk_live_switch", i7);
        }
        int i8 = adTrackLog.adLiveComponentReady;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ad_live_component_ready", i8);
        }
        int i9 = adTrackLog.serverCheckSwitch;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "server_check_switch", i9);
        }
        int i10 = adTrackLog.rewardAdvanceSwitch;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reward_advance_switch", i10);
        }
        int i11 = adTrackLog.rewardSkipShowTime;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reward_skip_show_time", i11);
        }
        int i12 = adTrackLog.isPlugin;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_plugin", i12);
        }
        String str3 = adTrackLog.apiSdkVersion;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "api_sdk_version", adTrackLog.apiSdkVersion);
        }
        int i13 = adTrackLog.rewardDetailStatusBarHeight;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reward_detail_status_bar_height", i13);
        }
        int i14 = adTrackLog.rewardDetailCallPositionY;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "reward_detail_call_position_y", i14);
        }
        int i15 = adTrackLog.screenOrientation;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screen_orientation", i15);
        }
        return jSONObject;
    }
}
