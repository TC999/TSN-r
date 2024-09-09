package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class je implements com.kwad.sdk.core.d<SplashMonitorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        a2(splashMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        return b2(splashMonitorInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashMonitorInfo.status = jSONObject.optInt("status");
        splashMonitorInfo.type = jSONObject.optInt("type");
        splashMonitorInfo.preloadId = jSONObject.optString("preload_id");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.preloadId)) {
            splashMonitorInfo.preloadId = "";
        }
        splashMonitorInfo.checkStatus = jSONObject.optInt("check_status");
        splashMonitorInfo.loadDataTime = jSONObject.optLong("load_data_duration_ms");
        splashMonitorInfo.beforeLoadDataTime = jSONObject.optLong("before_load_data_duration_ms");
        splashMonitorInfo.checkDataTime = jSONObject.optLong("check_data_duration_ms");
        splashMonitorInfo.loadAndCheckDataTime = jSONObject.optLong("load_and_check_data_duration_ms");
        splashMonitorInfo.costTime = jSONObject.optLong("duration_ms");
        splashMonitorInfo.ids = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("ids");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                splashMonitorInfo.ids.add((String) optJSONArray.opt(i4));
            }
        }
        splashMonitorInfo.count = jSONObject.optInt("count");
        splashMonitorInfo.cacheValidTime = jSONObject.optLong("validity_period_ms");
        splashMonitorInfo.size = jSONObject.optLong("size");
        splashMonitorInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.url)) {
            splashMonitorInfo.url = "";
        }
        splashMonitorInfo.creativeId = jSONObject.optLong(CampaignEx.JSON_KEY_CREATIVE_ID);
        splashMonitorInfo.materialType = jSONObject.optInt("material_type");
        splashMonitorInfo.totalCount = jSONObject.optInt("total_count");
        splashMonitorInfo.creativeIds = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("creative_ids");
        if (optJSONArray2 != null) {
            for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                splashMonitorInfo.creativeIds.add((String) optJSONArray2.opt(i5));
            }
        }
        splashMonitorInfo.preloadIds = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("preload_ids");
        if (optJSONArray3 != null) {
            for (int i6 = 0; i6 < optJSONArray3.length(); i6++) {
                splashMonitorInfo.preloadIds.add((String) optJSONArray3.opt(i6));
            }
        }
        splashMonitorInfo.posId = jSONObject.optLong("pos_Id");
        splashMonitorInfo.viewSource = jSONObject.optInt("view_source");
        splashMonitorInfo.elementTypes = new ArrayList();
        JSONArray optJSONArray4 = jSONObject.optJSONArray("element_types");
        if (optJSONArray4 != null) {
            for (int i7 = 0; i7 < optJSONArray4.length(); i7++) {
                splashMonitorInfo.elementTypes.add((Integer) optJSONArray4.opt(i7));
            }
        }
        splashMonitorInfo.interactiveStyle = jSONObject.optString("interactive_style");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.interactiveStyle)) {
            splashMonitorInfo.interactiveStyle = "";
        }
        splashMonitorInfo.interactivityDefaultStyle = jSONObject.optString("interactivity_default_style");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.interactivityDefaultStyle)) {
            splashMonitorInfo.interactivityDefaultStyle = "";
        }
        splashMonitorInfo.showEndTime = jSONObject.optLong("show_end_time");
        splashMonitorInfo.isRotateComposeTimeout = jSONObject.optBoolean("is_rotate_compose_timeout");
        splashMonitorInfo.tkDefaultTimeout = jSONObject.optLong("tk_default_timeout");
        splashMonitorInfo.soSource = jSONObject.optInt("so_source");
        splashMonitorInfo.soLoadTime = jSONObject.optLong("so_load_time");
        splashMonitorInfo.offlineSource = jSONObject.optInt("offline_source");
        splashMonitorInfo.offlineLoadTime = jSONObject.optLong("offline_load_time");
        splashMonitorInfo.tkFileLoadTime = jSONObject.optLong("tk_file_load_time");
        splashMonitorInfo.tkInitTime = jSONObject.optLong("tk_init_time");
        splashMonitorInfo.tkRenderTime = jSONObject.optLong("tk_render_time");
        splashMonitorInfo.nativeLoadTime = jSONObject.optLong("native_load_time");
        splashMonitorInfo.isWebTimeout = jSONObject.optBoolean("is_web_timeout");
        splashMonitorInfo.webLoadTime = jSONObject.optLong("web_load_time");
        splashMonitorInfo.templateId = jSONObject.optString("template_id");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.templateId)) {
            splashMonitorInfo.templateId = "";
        }
        splashMonitorInfo.templateVersionCode = jSONObject.optInt("template_version_code");
        splashMonitorInfo.tkTotalTime = jSONObject.optLong("tk_total_time");
        splashMonitorInfo.actionType = jSONObject.optInt("action_type");
        splashMonitorInfo.callbackType = jSONObject.optInt("callback_type");
        splashMonitorInfo.tkRenderType = jSONObject.optLong("tk_render_type");
        splashMonitorInfo.loadProcessType = jSONObject.optLong("load_process_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = splashMonitorInfo.status;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "status", i4);
        }
        int i5 = splashMonitorInfo.type;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i5);
        }
        String str = splashMonitorInfo.preloadId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "preload_id", splashMonitorInfo.preloadId);
        }
        int i6 = splashMonitorInfo.checkStatus;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "check_status", i6);
        }
        long j4 = splashMonitorInfo.loadDataTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_data_duration_ms", j4);
        }
        long j5 = splashMonitorInfo.beforeLoadDataTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "before_load_data_duration_ms", j5);
        }
        long j6 = splashMonitorInfo.checkDataTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "check_data_duration_ms", j6);
        }
        long j7 = splashMonitorInfo.loadAndCheckDataTime;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_and_check_data_duration_ms", j7);
        }
        long j8 = splashMonitorInfo.costTime;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "duration_ms", j8);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "ids", splashMonitorInfo.ids);
        int i7 = splashMonitorInfo.count;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "count", i7);
        }
        long j9 = splashMonitorInfo.cacheValidTime;
        if (j9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "validity_period_ms", j9);
        }
        long j10 = splashMonitorInfo.size;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "size", j10);
        }
        String str2 = splashMonitorInfo.url;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", splashMonitorInfo.url);
        }
        long j11 = splashMonitorInfo.creativeId;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, j11);
        }
        int i8 = splashMonitorInfo.materialType;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_type", i8);
        }
        int i9 = splashMonitorInfo.totalCount;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "total_count", i9);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "creative_ids", splashMonitorInfo.creativeIds);
        com.kwad.sdk.utils.t.putValue(jSONObject, "preload_ids", splashMonitorInfo.preloadIds);
        long j12 = splashMonitorInfo.posId;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pos_Id", j12);
        }
        int i10 = splashMonitorInfo.viewSource;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "view_source", i10);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "element_types", splashMonitorInfo.elementTypes);
        String str3 = splashMonitorInfo.interactiveStyle;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "interactive_style", splashMonitorInfo.interactiveStyle);
        }
        String str4 = splashMonitorInfo.interactivityDefaultStyle;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "interactivity_default_style", splashMonitorInfo.interactivityDefaultStyle);
        }
        long j13 = splashMonitorInfo.showEndTime;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "show_end_time", j13);
        }
        boolean z3 = splashMonitorInfo.isRotateComposeTimeout;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_rotate_compose_timeout", z3);
        }
        long j14 = splashMonitorInfo.tkDefaultTimeout;
        if (j14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tk_default_timeout", j14);
        }
        int i11 = splashMonitorInfo.soSource;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "so_source", i11);
        }
        long j15 = splashMonitorInfo.soLoadTime;
        if (j15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "so_load_time", j15);
        }
        int i12 = splashMonitorInfo.offlineSource;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "offline_source", i12);
        }
        long j16 = splashMonitorInfo.offlineLoadTime;
        if (j16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "offline_load_time", j16);
        }
        long j17 = splashMonitorInfo.tkFileLoadTime;
        if (j17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tk_file_load_time", j17);
        }
        long j18 = splashMonitorInfo.tkInitTime;
        if (j18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tk_init_time", j18);
        }
        long j19 = splashMonitorInfo.tkRenderTime;
        if (j19 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tk_render_time", j19);
        }
        long j20 = splashMonitorInfo.nativeLoadTime;
        if (j20 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "native_load_time", j20);
        }
        boolean z4 = splashMonitorInfo.isWebTimeout;
        if (z4) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "is_web_timeout", z4);
        }
        long j21 = splashMonitorInfo.webLoadTime;
        if (j21 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "web_load_time", j21);
        }
        String str5 = splashMonitorInfo.templateId;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "template_id", splashMonitorInfo.templateId);
        }
        int i13 = splashMonitorInfo.templateVersionCode;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "template_version_code", i13);
        }
        long j22 = splashMonitorInfo.tkTotalTime;
        if (j22 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tk_total_time", j22);
        }
        int i14 = splashMonitorInfo.actionType;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "action_type", i14);
        }
        int i15 = splashMonitorInfo.callbackType;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "callback_type", i15);
        }
        long j23 = splashMonitorInfo.tkRenderType;
        if (j23 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tk_render_type", j23);
        }
        long j24 = splashMonitorInfo.loadProcessType;
        if (j24 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "load_process_type", j24);
        }
        return jSONObject;
    }
}
