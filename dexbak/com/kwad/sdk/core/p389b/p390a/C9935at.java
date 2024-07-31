package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.at */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9935at implements InterfaceC10273d<AdTrackLog> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdTrackLog adTrackLog, JSONObject jSONObject) {
        m27204a(adTrackLog, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdTrackLog adTrackLog, JSONObject jSONObject) {
        return m27203b(adTrackLog, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27204a(AdTrackLog adTrackLog, JSONObject jSONObject) {
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
    private static JSONObject m27203b(AdTrackLog adTrackLog, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adTrackLog.templateId;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "template_id", adTrackLog.templateId);
        }
        String str2 = adTrackLog.sceneId;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "scene_id", adTrackLog.sceneId);
        }
        int i = adTrackLog.preLandingPageSwitch;
        if (i != 0) {
            C11126t.putValue(jSONObject, "pre_landing_page_switch", i);
        }
        int i2 = adTrackLog.preLandingPageShowType;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "pre_landing_page_show_type", i2);
        }
        int i3 = adTrackLog.adLiveSwitch;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "ad_live_switch", i3);
        }
        int i4 = adTrackLog.adTkLiveSwitch;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "ad_tk_live_switch", i4);
        }
        int i5 = adTrackLog.adLiveComponentReady;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "ad_live_component_ready", i5);
        }
        int i6 = adTrackLog.serverCheckSwitch;
        if (i6 != 0) {
            C11126t.putValue(jSONObject, "server_check_switch", i6);
        }
        int i7 = adTrackLog.rewardAdvanceSwitch;
        if (i7 != 0) {
            C11126t.putValue(jSONObject, "reward_advance_switch", i7);
        }
        int i8 = adTrackLog.rewardSkipShowTime;
        if (i8 != 0) {
            C11126t.putValue(jSONObject, "reward_skip_show_time", i8);
        }
        int i9 = adTrackLog.isPlugin;
        if (i9 != 0) {
            C11126t.putValue(jSONObject, "is_plugin", i9);
        }
        String str3 = adTrackLog.apiSdkVersion;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "api_sdk_version", adTrackLog.apiSdkVersion);
        }
        int i10 = adTrackLog.rewardDetailStatusBarHeight;
        if (i10 != 0) {
            C11126t.putValue(jSONObject, "reward_detail_status_bar_height", i10);
        }
        int i11 = adTrackLog.rewardDetailCallPositionY;
        if (i11 != 0) {
            C11126t.putValue(jSONObject, "reward_detail_call_position_y", i11);
        }
        int i12 = adTrackLog.screenOrientation;
        if (i12 != 0) {
            C11126t.putValue(jSONObject, "screen_orientation", i12);
        }
        return jSONObject;
    }
}
