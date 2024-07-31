package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.je */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10163je implements InterfaceC10273d<SplashMonitorInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        m26762a(splashMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        return m26761b(splashMonitorInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26762a(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
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
            for (int i = 0; i < optJSONArray.length(); i++) {
                splashMonitorInfo.ids.add((String) optJSONArray.opt(i));
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
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                splashMonitorInfo.creativeIds.add((String) optJSONArray2.opt(i2));
            }
        }
        splashMonitorInfo.preloadIds = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("preload_ids");
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                splashMonitorInfo.preloadIds.add((String) optJSONArray3.opt(i3));
            }
        }
        splashMonitorInfo.posId = jSONObject.optLong("pos_Id");
        splashMonitorInfo.viewSource = jSONObject.optInt("view_source");
        splashMonitorInfo.elementTypes = new ArrayList();
        JSONArray optJSONArray4 = jSONObject.optJSONArray("element_types");
        if (optJSONArray4 != null) {
            for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                splashMonitorInfo.elementTypes.add((Integer) optJSONArray4.opt(i4));
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
    private static JSONObject m26761b(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = splashMonitorInfo.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        int i2 = splashMonitorInfo.type;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "type", i2);
        }
        String str = splashMonitorInfo.preloadId;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "preload_id", splashMonitorInfo.preloadId);
        }
        int i3 = splashMonitorInfo.checkStatus;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "check_status", i3);
        }
        long j = splashMonitorInfo.loadDataTime;
        if (j != 0) {
            C11126t.putValue(jSONObject, "load_data_duration_ms", j);
        }
        long j2 = splashMonitorInfo.beforeLoadDataTime;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "before_load_data_duration_ms", j2);
        }
        long j3 = splashMonitorInfo.checkDataTime;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "check_data_duration_ms", j3);
        }
        long j4 = splashMonitorInfo.loadAndCheckDataTime;
        if (j4 != 0) {
            C11126t.putValue(jSONObject, "load_and_check_data_duration_ms", j4);
        }
        long j5 = splashMonitorInfo.costTime;
        if (j5 != 0) {
            C11126t.putValue(jSONObject, "duration_ms", j5);
        }
        C11126t.putValue(jSONObject, "ids", splashMonitorInfo.ids);
        int i4 = splashMonitorInfo.count;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "count", i4);
        }
        long j6 = splashMonitorInfo.cacheValidTime;
        if (j6 != 0) {
            C11126t.putValue(jSONObject, "validity_period_ms", j6);
        }
        long j7 = splashMonitorInfo.size;
        if (j7 != 0) {
            C11126t.putValue(jSONObject, "size", j7);
        }
        String str2 = splashMonitorInfo.url;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "url", splashMonitorInfo.url);
        }
        long j8 = splashMonitorInfo.creativeId;
        if (j8 != 0) {
            C11126t.putValue(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, j8);
        }
        int i5 = splashMonitorInfo.materialType;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "material_type", i5);
        }
        int i6 = splashMonitorInfo.totalCount;
        if (i6 != 0) {
            C11126t.putValue(jSONObject, "total_count", i6);
        }
        C11126t.putValue(jSONObject, "creative_ids", splashMonitorInfo.creativeIds);
        C11126t.putValue(jSONObject, "preload_ids", splashMonitorInfo.preloadIds);
        long j9 = splashMonitorInfo.posId;
        if (j9 != 0) {
            C11126t.putValue(jSONObject, "pos_Id", j9);
        }
        int i7 = splashMonitorInfo.viewSource;
        if (i7 != 0) {
            C11126t.putValue(jSONObject, "view_source", i7);
        }
        C11126t.putValue(jSONObject, "element_types", splashMonitorInfo.elementTypes);
        String str3 = splashMonitorInfo.interactiveStyle;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "interactive_style", splashMonitorInfo.interactiveStyle);
        }
        String str4 = splashMonitorInfo.interactivityDefaultStyle;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "interactivity_default_style", splashMonitorInfo.interactivityDefaultStyle);
        }
        long j10 = splashMonitorInfo.showEndTime;
        if (j10 != 0) {
            C11126t.putValue(jSONObject, "show_end_time", j10);
        }
        boolean z = splashMonitorInfo.isRotateComposeTimeout;
        if (z) {
            C11126t.putValue(jSONObject, "is_rotate_compose_timeout", z);
        }
        long j11 = splashMonitorInfo.tkDefaultTimeout;
        if (j11 != 0) {
            C11126t.putValue(jSONObject, "tk_default_timeout", j11);
        }
        int i8 = splashMonitorInfo.soSource;
        if (i8 != 0) {
            C11126t.putValue(jSONObject, "so_source", i8);
        }
        long j12 = splashMonitorInfo.soLoadTime;
        if (j12 != 0) {
            C11126t.putValue(jSONObject, "so_load_time", j12);
        }
        int i9 = splashMonitorInfo.offlineSource;
        if (i9 != 0) {
            C11126t.putValue(jSONObject, "offline_source", i9);
        }
        long j13 = splashMonitorInfo.offlineLoadTime;
        if (j13 != 0) {
            C11126t.putValue(jSONObject, "offline_load_time", j13);
        }
        long j14 = splashMonitorInfo.tkFileLoadTime;
        if (j14 != 0) {
            C11126t.putValue(jSONObject, "tk_file_load_time", j14);
        }
        long j15 = splashMonitorInfo.tkInitTime;
        if (j15 != 0) {
            C11126t.putValue(jSONObject, "tk_init_time", j15);
        }
        long j16 = splashMonitorInfo.tkRenderTime;
        if (j16 != 0) {
            C11126t.putValue(jSONObject, "tk_render_time", j16);
        }
        long j17 = splashMonitorInfo.nativeLoadTime;
        if (j17 != 0) {
            C11126t.putValue(jSONObject, "native_load_time", j17);
        }
        boolean z2 = splashMonitorInfo.isWebTimeout;
        if (z2) {
            C11126t.putValue(jSONObject, "is_web_timeout", z2);
        }
        long j18 = splashMonitorInfo.webLoadTime;
        if (j18 != 0) {
            C11126t.putValue(jSONObject, "web_load_time", j18);
        }
        String str5 = splashMonitorInfo.templateId;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "template_id", splashMonitorInfo.templateId);
        }
        int i10 = splashMonitorInfo.templateVersionCode;
        if (i10 != 0) {
            C11126t.putValue(jSONObject, "template_version_code", i10);
        }
        long j19 = splashMonitorInfo.tkTotalTime;
        if (j19 != 0) {
            C11126t.putValue(jSONObject, "tk_total_time", j19);
        }
        int i11 = splashMonitorInfo.actionType;
        if (i11 != 0) {
            C11126t.putValue(jSONObject, "action_type", i11);
        }
        int i12 = splashMonitorInfo.callbackType;
        if (i12 != 0) {
            C11126t.putValue(jSONObject, "callback_type", i12);
        }
        long j20 = splashMonitorInfo.tkRenderType;
        if (j20 != 0) {
            C11126t.putValue(jSONObject, "tk_render_type", j20);
        }
        long j21 = splashMonitorInfo.loadProcessType;
        if (j21 != 0) {
            C11126t.putValue(jSONObject, "load_process_type", j21);
        }
        return jSONObject;
    }
}
