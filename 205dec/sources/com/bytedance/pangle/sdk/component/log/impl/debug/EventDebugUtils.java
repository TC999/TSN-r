package com.bytedance.pangle.sdk.component.log.impl.debug;

import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend;
import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;
import com.bytedance.pangle.sdk.component.log.impl.core.LogThreadCenter;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import com.bytedance.pangle.sdk.component.log.impl.event.ad.AdLogEvent;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import u0.a;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class EventDebugUtils {
    public static final String DEBUG_AD_TYPE_V3 = "adType_v3";
    public static final String DEBUG_BATCH_READ = "batchRead";
    public static final String DEBUG_HIGH_PRIORITY = "highPriority";
    public static final String DEBUG_LOG_TAG = "csj_log";
    public static final String DEBUG_OTHER_EVENT = "other";
    public static final String DEBUG_STATS = "stats";
    public static final String DEBUG_UPLOAD_CACHE_TIME_OUT = "timeout_dispatch";
    public static final String DEBUG_UPLOAD_IGNORE_RESULT = "ignore_result_dispatch";
    public static final String DEBUG_UPLOAD_MAX_SIZE = "max_size_dispatch";
    public static final String DEBUG_VERSION_V3 = "version_v3";
    private static final long MOVE_SIZE = 10;
    private static final LinkedList<String> createList = new LinkedList<>();
    private static final LinkedList<String> saveList = new LinkedList<>();
    private static final LinkedList<String> uploadList = new LinkedList<>();
    private static final LinkedList<String> logIdList = new LinkedList<>();
    private static final Map<String, Integer> eventSelfIndexMap = new HashMap();
    private static HashMap<String, Integer> debugLabelHashMap = null;
    private static String uploadShowResult = "upload_init";
    private static int mAllShowCnt = 0;
    private static int mSucShowCnt = 0;

    public static void beforeUploadPutLabel(AdLogEventFace adLogEventFace) {
        try {
            if (adLogEventFace.getAdType() == 0 && LogInternalManager.getInstance().getAdLogDepend() != null && LogInternalManager.getInstance().getAdLogDepend().isUploadDebugMessage()) {
                JSONObject event = adLogEventFace.getEvent();
                String labelOrEvent = getLabelOrEvent(adLogEventFace);
                if (isDebugEvent(labelOrEvent)) {
                    return;
                }
                getReqId(adLogEventFace);
                String optString = event.optString("ad_extra_data");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject = new JSONObject(optString);
                    if (TextUtils.isEmpty(jSONObject.optString(EventMonitor.WILL_SEND_LABELS))) {
                        jSONObject.put(EventMonitor.WILL_SEND_LABELS, uploadMoveLabels(labelOrEvent + "_" + getSdkEventValidIndex(adLogEventFace)));
                        jSONObject.put(EventMonitor.SEND_SUCCESS_VALID_LABELS, getLogIdLabels());
                    }
                    event.put("ad_extra_data", jSONObject.toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(EventMonitor.WILL_SEND_LABELS, uploadMoveLabels(labelOrEvent + "_" + getSdkEventValidIndex(adLogEventFace)));
                jSONObject2.put(EventMonitor.SEND_SUCCESS_VALID_LABELS, getLogIdLabels());
                event.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception e4) {
            LDebug.e(e4.getMessage());
        }
    }

    public static synchronized String createMoveLabels(String str) {
        String sb;
        synchronized (EventDebugUtils.class) {
            LinkedList<String> linkedList = createList;
            if (linkedList.size() >= 10) {
                linkedList.removeFirst();
                linkedList.add(str);
            } else {
                linkedList.add(str);
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = linkedList.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append(",");
            }
            sb = sb2.toString();
        }
        return sb;
    }

    private static void debugPrintLabel(AdLogEventFace adLogEventFace, String str) {
    }

    public static void debugQuery(JSONObject jSONObject, AdLogEvent adLogEvent) {
        IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        if (adLogDepend != null && adLogDepend.isDebug() && isCSJOrPangle()) {
            LDebug.d("log_show_query :" + jSONObject.optString("label") + " " + ((int) adLogEvent.getPriority()));
        }
    }

    public static void debugRepoDeleteMessage(AdLogEventFace adLogEventFace) {
        try {
            if (isCSJ()) {
                IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
                if (!TextUtils.isEmpty(adLogEventFace.getLocalId())) {
                    EventMonitorUtils.add(LogThreadCenter.sEventMonitor.getSuccess_delete_count(), 1);
                }
                if (adLogDepend == null || !adLogDepend.isDebug()) {
                    return;
                }
                if (adLogEventFace.getAdType() == 1) {
                    LDebug.w("_delete", "stats,[type:" + getStatsType(adLogEventFace) + ",index:" + getStatsIndex(adLogEventFace) + ",localId:" + adLogEventFace.getLocalId() + ",sessionId:" + getSdkSessionId(adLogEventFace) + "]");
                } else if (adLogEventFace.getAdType() == 0) {
                    if (adLogEventFace.getEventVersion() == 3) {
                        if (adLogEventFace.getEvent() != null) {
                            String optString = adLogEventFace.getEvent().optString("event");
                            StringBuilder sb = new StringBuilder();
                            sb.append("v3,[");
                            sb.append("label:");
                            sb.append(optString);
                            long sdkEventIndex = getSdkEventIndex(adLogEventFace);
                            if (sdkEventIndex != 0) {
                                sb.append(", index:");
                                sb.append(sdkEventIndex);
                            }
                            long sdkEventValidIndex = getSdkEventValidIndex(adLogEventFace);
                            if (sdkEventValidIndex != 0) {
                                sb.append(", validIndex:");
                                sb.append(sdkEventValidIndex);
                            }
                            sb.append(", localId:");
                            sb.append(adLogEventFace.getLocalId());
                            sb.append(", sessionId:");
                            sb.append(getSdkSessionId(adLogEventFace));
                            sb.append("]");
                            LDebug.w("_delete", sb.toString());
                            return;
                        }
                        LDebug.w("_delete", "v3_error");
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    long sdkEventValidIndex2 = getSdkEventValidIndex(adLogEventFace);
                    if (sdkEventValidIndex2 != 0) {
                        sb2.append("v1_core [");
                        sb2.append("label:");
                        sb2.append(getLabelOrEvent(adLogEventFace));
                    } else {
                        sb2.append("v1_debug [");
                        sb2.append("label:");
                        sb2.append(getLabelOrEvent(adLogEventFace));
                    }
                    long sdkEventIndex2 = getSdkEventIndex(adLogEventFace);
                    if (sdkEventIndex2 != 0) {
                        sb2.append(", index:");
                        sb2.append(sdkEventIndex2);
                    }
                    if (sdkEventValidIndex2 != 0) {
                        sb2.append(", validIndex:");
                        sb2.append(sdkEventValidIndex2);
                    }
                    sb2.append(", localId:");
                    sb2.append(adLogEventFace.getLocalId());
                    sb2.append(", sessionId:");
                    sb2.append(getSdkSessionId(adLogEventFace));
                    sb2.append("]");
                    LDebug.w("_delete", sb2.toString());
                }
            }
        } catch (Exception e4) {
            LDebug.e(e4.getMessage());
        }
    }

    public static void debugSaveMessage(boolean z3, int i4, AdLogEventFace adLogEventFace) {
        IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        if (isGroMore() || adLogDepend == null || !adLogDepend.isDebug()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("needUpload:");
        sb.append(z3);
        sb.append(",message:");
        sb.append(getMessageString(i4));
        String statsType = getStatsType(adLogEventFace);
        if (!TextUtils.isEmpty(statsType)) {
            sb.append(",type:");
            sb.append(statsType);
        }
        String labelOrEvent = getLabelOrEvent(adLogEventFace);
        if (!TextUtils.isEmpty(labelOrEvent)) {
            sb.append(",label:");
            sb.append(labelOrEvent);
        }
        LDebug.w("_save", sb.toString());
    }

    public static void debugUploadMessage(List<AdLogEventFace> list, int i4, String str) {
        IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        if (adLogDepend == null || !adLogDepend.isDebug() || list == null || isGroMore()) {
            return;
        }
        boolean z3 = false;
        StringBuilder sb = new StringBuilder();
        for (AdLogEventFace adLogEventFace : list) {
            if (adLogEventFace.getAdType() == 0) {
                JSONObject event = adLogEventFace.getEvent();
                String labelOrEvent = getLabelOrEvent(adLogEventFace);
                if (adLogEventFace.getEventVersion() == 3) {
                    if (event != null) {
                        labelOrEvent = event.optString("event");
                    }
                    sb.append(" [v3:");
                    sb.append(labelOrEvent);
                    sb.append("] ");
                } else {
                    long sdkEventIndex = getSdkEventIndex(adLogEventFace);
                    long sdkEventValidIndex = getSdkEventValidIndex(adLogEventFace);
                    int onlySelfIndex = getOnlySelfIndex(adLogEventFace);
                    sb.append(" [");
                    sb.append(sdkEventIndex);
                    sb.append("_");
                    sb.append(labelOrEvent);
                    if (sdkEventValidIndex != 0) {
                        sb.append("_");
                        sb.append(sdkEventValidIndex);
                    }
                    if (onlySelfIndex == 0) {
                        sb.append("] ");
                    } else {
                        sb.append("_");
                        sb.append(onlySelfIndex);
                        sb.append("] ");
                    }
                }
                z3 = true;
            } else if (adLogEventFace.getAdType() == 1) {
                String statsType = getStatsType(adLogEventFace);
                int statsIndex = getStatsIndex(adLogEventFace);
                sb.append(" [");
                sb.append(statsIndex);
                sb.append("_");
                sb.append(statsType);
                sb.append("] ");
            }
        }
        if (z3) {
            LDebug.w("_upload", "ads:" + ((Object) sb) + getMessageString(i4) + "," + str + ",total:" + list.size());
            return;
        }
        LDebug.w("_upload", "stats:" + ((Object) sb) + getMessageString(i4) + "," + str + ",total:" + list.size());
    }

    private static String getClickState(String str) {
        return System.currentTimeMillis() + ";" + str;
    }

    public static synchronized int getEventSelfIndex(String str) {
        synchronized (EventDebugUtils.class) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            Map<String, Integer> map = eventSelfIndexMap;
            Integer num = map.get(str);
            if (num == null) {
                map.put(str, 1);
                return 1;
            }
            int intValue = num.intValue() + 1;
            map.put(str, Integer.valueOf(intValue));
            return intValue;
        }
    }

    public static String getLabelOrEvent(AdLogEventFace adLogEventFace) {
        if (adLogEventFace == null || adLogEventFace.getEvent() == null || isGroMore()) {
            return null;
        }
        if (adLogEventFace.getEventVersion() == 3) {
            return adLogEventFace.getEvent().optString("event");
        }
        return adLogEventFace.getEvent().optString("label");
    }

    private static synchronized String getLogIdLabels() {
        String sb;
        synchronized (EventDebugUtils.class) {
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = logIdList.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append(",");
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static String getMessageString(int i4) {
        switch (i4) {
            case 1:
                return "flush once";
            case 2:
                return "flush memory db";
            case 3:
                return "flush memory";
            case 4:
                return "new event";
            case 5:
                return "server busy";
            case 6:
                return "empty message";
            case 7:
                return "net error";
            default:
                return "default";
        }
    }

    public static int getNeedUploadLonelyAppId(List<AdLogEventFace> list) {
        JSONObject event;
        JSONObject jSONObject;
        int optInt;
        if (list != null && list.size() == 1) {
            try {
                AdLogEventFace adLogEventFace = list.get(0);
                if (adLogEventFace != null && adLogEventFace.getPriority() == 1 && (event = adLogEventFace.getEvent()) != null && adLogEventFace.getAdType() == 0 && (optInt = (jSONObject = new JSONObject(event.optString("ad_extra_data"))).optInt("inner_appid", 0)) != 0) {
                    jSONObject.remove("inner_appid");
                    event.put("ad_extra_data", jSONObject.toString());
                    LDebug.d("inner_appid:" + optInt);
                    return optInt;
                }
            } catch (Throwable th) {
                LDebug.e(th.getMessage());
            }
        }
        return 0;
    }

    public static long getNewCreateTime(AdLogEventFace adLogEventFace) {
        if (adLogEventFace != null && adLogEventFace.getEvent() != null) {
            try {
                return new JSONObject(adLogEventFace.getEvent().optString("ad_extra_data")).optLong("new_create_time");
            } catch (Exception e4) {
                LDebug.e(e4.getMessage());
            }
        }
        return -1L;
    }

    public static synchronized int getOnlySelfIndex(AdLogEventFace adLogEventFace) {
        synchronized (EventDebugUtils.class) {
            if (adLogEventFace != null) {
                if (adLogEventFace.getEvent() != null) {
                    if (isCSJ()) {
                        try {
                            return new JSONObject(adLogEventFace.getEvent().optString("ad_extra_data")).optInt(EventMonitor.SDK_EVENT_SELF_COUNT);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return 0;
                        }
                    }
                    return 0;
                }
            }
            return 0;
        }
    }

    public static String getReqId(AdLogEventFace adLogEventFace) {
        if (adLogEventFace == null || adLogEventFace.getEvent() == null || isGroMore()) {
            return null;
        }
        String optString = adLogEventFace.getEvent().optString("log_extra");
        if (!TextUtils.isEmpty(optString)) {
            try {
                return new JSONObject(optString).optString("req_id");
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public static String getRitCode(JSONObject jSONObject) {
        if (jSONObject == null || isGroMore()) {
            return "";
        }
        String optString = jSONObject.optString("log_extra");
        if (!TextUtils.isEmpty(optString)) {
            try {
                return new JSONObject(optString).optString("rit");
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return "";
    }

    public static long getSdkEventIndex(AdLogEventFace adLogEventFace) {
        if (adLogEventFace == null || adLogEventFace.getEvent() == null || !isCSJ()) {
            return 0L;
        }
        try {
            return new JSONObject(adLogEventFace.getEvent().optString("ad_extra_data")).optLong(EventMonitor.KEY_SDK_EVENT_INDEX);
        } catch (Exception e4) {
            LDebug.e(e4.getMessage());
            return 0L;
        }
    }

    public static long getSdkEventValidIndex(AdLogEventFace adLogEventFace) {
        if (adLogEventFace == null || adLogEventFace.getEvent() == null || !isCSJ()) {
            return 0L;
        }
        try {
            return new JSONObject(adLogEventFace.getEvent().optString("ad_extra_data")).optLong(EventMonitor.KEY_SDK_EVENT_VALID_INDEX);
        } catch (Exception e4) {
            LDebug.e(e4.getMessage());
            return 0L;
        }
    }

    private static String getSdkSessionId(AdLogEventFace adLogEventFace) {
        String optString;
        if (adLogEventFace == null || adLogEventFace.getEvent() == null || !isCSJ()) {
            return null;
        }
        JSONObject event = adLogEventFace.getEvent();
        if (adLogEventFace.getAdType() == 1) {
            optString = event.optString(EventMonitor.EVENT_EXTRA);
        } else {
            optString = event.optString("ad_extra_data");
        }
        try {
            return new JSONObject(optString).optString(EventMonitor.KEY_SDK_SESSION_ID);
        } catch (JSONException e4) {
            LDebug.e(e4.getMessage());
            return null;
        }
    }

    public static String getShowResult() {
        return uploadShowResult;
    }

    public static int getStatsIndex(AdLogEventFace adLogEventFace) {
        if (adLogEventFace == null || adLogEventFace.getEvent() == null || !isCSJ()) {
            return -1;
        }
        try {
            return new JSONObject(adLogEventFace.getEvent().optString(EventMonitor.EVENT_EXTRA)).optInt(EventMonitor.STATS_INDEX);
        } catch (JSONException e4) {
            e4.printStackTrace();
            return -1;
        }
    }

    public static String getStatsType(AdLogEventFace adLogEventFace) {
        if (adLogEventFace == null || adLogEventFace.getEvent() == null || isGroMore()) {
            return null;
        }
        return adLogEventFace.getEvent().optString("type");
    }

    private static boolean isCSJ() {
        IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        return adLogDepend != null && adLogDepend.sdkType() == 0;
    }

    public static boolean isCSJOrPangle() {
        return isCSJ() || isPangle();
    }

    public static boolean isDebugEvent(String str) {
        HashMap<String, Integer> hashMap = debugLabelHashMap;
        if (hashMap == null || str == null) {
            return false;
        }
        return hashMap.containsKey(str);
    }

    public static boolean isGroMore() {
        IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        return adLogDepend != null && adLogDepend.sdkType() == 2;
    }

    private static boolean isPangle() {
        IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
        return adLogDepend != null && adLogDepend.sdkType() == 1;
    }

    public static void loadDebugEvent() {
        if (debugLabelHashMap != null) {
            return;
        }
        String[] strArr = {"first_view", "open_splash", "ad_landing_webview_init", "show_failed_topview", "adstyle_template_show", "splash_init_monitor_first", "download_video_succeed", "shake_skip", "receive", "video_over_auto", "render_time", "splash_ad", "preload_start", CampaignEx.JSON_NATIVE_VIDEO_MUTE, "covered", "download_image_failed", "splash_init_monitor_all", "preload_success_time", "download_video_start_sdk", "download_video_count", "not_showing_reason", "download_image_succeed", "load_video_success", "launch_covered", "download_video_prepare", "download_video_start", "boarding", "ad_wap_stat", "splash_pick", "preload_fail", "should_show", "adstyle_template_fill", CampaignEx.JSON_NATIVE_VIDEO_UNMUTE, "preload_success", "show_failed", "stop_showing_monitor", "download_video_no_download", "track_url", "download_creative_duration", "adstyle_template_render", "download_video_count_splash_sdk", "landing_preload_finish", "adstyle_template_load", "load_ad_duration", "client_false_show", "client_false", "download_video_failed", "data_invalid", "topview_boarding", "topview_start_download", "topview_show_confirmed", "splash_start_download", "topview_show_rejected", "splash_no_download", "redownload_video_count", "topview_other_show", "topview_no_download", "ad_selected", "invalid_model", "topview_deliver", "ad_no_selected", "topview_ad_download_retry_label", "request", "response", "parse_finished", "front_performance", "ad_resp", "ad_resp_nodata", "preload_finish", "transit_show", "splash_switch", "block_splash_F2", "render_picture_time", "network_type", "play_start_error", "load_video_error", "render_picture_timeout", "py_loading_success", "download_status", "first_screen_load_finish", "landing_preload_failed", "data_received", "preload_result", "show_result", "reponse", "valid_time", "brand_satefy_context", "topview_ad_link_fail_label", "end_feed_request", "start_feed_request", "set_feed_data", "delayinstall_conflict_with_back_dialog", "clean_fetch_apk_head_failed", "cleanspace_download_after_quite_clean", "fps_too_low", "open_policy", "landing_perf_stats", "preload_topview", "show_effect_start", "dislike_monitor", "hour_show", "hour_skip", "triggered", "click_sound_switch", "enter_loft", "download_resume", "install_view_result", "contiguous_ad_event", "contiguous_ad_remove_event", "report_monitor", "open_landing_blank", "dynamic_ad", "report_load_failed", "ad_download_failed", "download_video_start_first_sdk", "splash_receive", "video_play", "clean_fetch_apk_head_switch_close", "label_external_permission", "pause_reserve_wifi_switch_status", "landing_download_dialog_show", "download_connect", "download_uncompleted", "pause_reserve_wifi_dialog_show", "download_io", "pause_reserve_wifi_confirm", "skvc_load_time", "segment_io", "click_no", "pause_reserve_wifi_cancel_on_wifi", "udp_stop", "mma_url", "error_save_sp", "download_notification_try_show", "ttd_pref_monitor", "item_above_the_fold_stay_time", "ttdownloader_unity", "bdad_query_log", "bdad_load_finish", "bdad_load", "bdad_load_fail", "undefined", "valid_stock", "show_filter", "splash_pk_result", "endcard_page_info", "page_on_create", "statistics_feed_docker", "show_search_card_word", "ad_new_video_render_start_label", "ad_new_video_play_start_label", "ad_new_video_ad_patch_data_set_null_label", "ad_new_video_ad_patch_play_label", "ad_new_video_ad_patch_render_label", "debug_touch_start", "try_second_request", "egg_unzip_success", "tap_2", "anti_0_result", "anti_2_result", "egg_unzip_no_start", "preload_no_start", "bind_impression_212202", "guide_auth_dialog_cancel", "show_im_entry", "sub_reco_impression_v2", "sync_request_log_mask", "no_send_sync_request", "load_timeout", "send_sync_request", "sync_request_not_show", "show_subv_tt_video_food", "track", "custom_event", "rd_landing_page_stat", "update_local_data", "showlimit", "upload_result", "debug_othershow", "debug_otherclick", "ad_show_time", "push_launch", "union_send_duplicate", "mnpl_js_finish_load", "mnpl_resource_finish_load", "mnpl_material_render_timeout", "mnpl_render_timing", "mnpl_vedio_interactive_timegap", "click_non_rectify_area", "start_impression", "end_impression", "picture_render_time", "splash_stop_show", "skip_post", "skan_show_start", "skan_show_end", "load_video_start", "rifle_ad_monitor", "download_video_redownload", "splash_video_quality", "splash_video_end", "splash_video_pause", "splash_video_failed", "adtrace_start_clear", "adtrace_clear_past_data", "adtrace_end_clear", "adtrace_write_success", "adtrace_write_failed", "adtrace_read_result", "adtrace_read_success", "adtrace_read_failed", "pick_model", "cache_model", "adtrace_reparse_file", "deeplink_failed_all", "ad_live_degenerate", "ad_live_miss", "live_play_fail", "sko_show_success", "sko_show_fail", "commerce_apps_open", "commerce_apps_jump", "pic_card_show", "live_ad_card_render_finish", "adtrace_select", "received_card_status", "live_ad_page_load_success", "mp_download_result", "download_video_cancel", "jump_count", "adtrace_try_show", "show_cart_entrance", "live_ad_page_load_fail", "click_interacted", "pop_up", "pop_up_cancel", "stream_loadtime", "mnpl_guide_comp_render", "thirdquartile", "customer_feed_pause", "customer_play_start", "customer_feed_break", "click_area_log", "customer_feed_continue", "customer_feed_play", "mnpl_resource_start_preload", "mnpl_resource_finish_preload", "customer_feed_over", "get_preload_ad", "web_inspect_status", "web_report_status", "preload_begin", "preload_end", "open_begin", "open_end", "pangle_live_sdk_monitor", "success", "rifle_load_state", "rifle_uri_load_state", "component_init", "component_release", "ad_lynx_download_sendAdLog", "dynamic2_render", "lynx_card_show", "pop_up_download", "live_shelf_commodity_show", "unity_fe_click", "enter_ads_explain", "adx_ads_switch", "personal_ads_switch", "qc_product_picture_cancel", "qc_product_picture_save", "qc_product_picture_press", "qc_product_detail_show", "qc_price_instruction_click", "qc_edit_sku_num_click", "service_description_page_duration", "enter_business_qualification_page ", "service_description_page_show", "order_words_fe", "qc_payment_mode_show", "qc_click_ali_pay", "qc_district_addr_click", "qc_auto_information_add", "qc_dial_consult_cancel_btn_click", "qc_dial_consult_show", "qc_maomadeng_click", "qc_maomadeng_show", "slide_product_big_picture", "qc_service_description_close", "appstore_manager_request", "preload_video_result", "preload_video_start", "adtrace_bind", "topview_ad_link_match_event", "skip_leisure_interact_render", "click_start_download", "ad_lynx_landing_page_exception", "lynx_page_res_download_monitor_event", "live_fail", "live_over", "render_live_picture_success", "render_live_picture_fail", "live_play_success", "live_play_close", "item_play_pver", "ad_gap_info", "item_play_over", "has_period_first_chance", "enter_live_auto", "mnpl_material_video_scene_show", "ad_rerank", "in_web_click", "post_request_failed", "destroy", "bidding_load", "bidding_receive", "in_web_scroll", a.a, "xigua_ad_rerank", "applink_unity", "top_ad_show", "top_button_show", "skip_button_show", "skip_click", "shake_show", "skip_result", "show_personal_compliance_button_click", "personal_compliance_click", "ad_click_result", "ad_preload_video", "popup_show", "topview_feed_down", "qr_scan", "qr_show", "topview_popup_show", "topview_feed_over", "topview_feed_show", "feed_down", "engine_ad_send", "permission_click", "policy_click", "download_start_click", "mini_playable_style_report", "load_detect", "aweme_show_info", "click_convert_anchor_detail_page", "click_anchor_gift_button", "show_anchor_gift_page", "click_anchor_gift_card", "show_anchor_gift_card", "anchor_convert_button", "show_anchor_page", "search_result_click", "sdk_session_launch", "not_use_app_link_sdk", "click_ios_check", "auto_open", "bind_click_area", "page_load", "show_finish", "next_fresh", "play_ready", "splash_pk_time", "unshow", "feed_show_failed", "othershow_cancel", "lu_cache", "realtime_splash_result", "channel_override_result", "internal_jump_live_status", "mnpl_video_play_backward", "splash_enter_foreground", "splash_enter_background", "button_light", "long_press", "webview_material_missing_key_error", "live_life_project_click_card", "mnpl_click_event", "show_anchor_convert_button", "bdar_log_info", "bdar_ad_request", "bdar_lynx_template_load_time", "bdar_lynx_fallback", "bdar_fetch_template_data", "bdar_lynx_render_time", "bdar_video_play_effective", "bdar_video_first_frame", "bdar_lynx_jsb_error", "invalidate_back_url_monitor_event", "lynx_page_plugin_exception_event", "live_custom_interaction", "pinch", "if_splash_card", "splash_card_show", "card_show_fail", "splash_card_click", "splash_card_close", "wind_icon_click", "excluded", "show_error", "toutiao_ad_receive", "show_ad", "toutiao_ad_excluded", "close_card", "lynx_status", "qpon_join", "apk_download_user", "comment_key_word_show", "v3_show_ad", "show_wish_button", "enterSection", "single_comment_show", "enter_product_detail", "xigua_ad_request", "qpon_apply", "splash_total_duration", "splash_render_duration", "download_template_duration", "homepage_hot", "homepage_follow", "homepage_fresh", "video_play_success", "general_search", "video_render_cost", "single_ad_render_cost", "unexpected_accurate_pause", "mnpl_interact_skip", "web_report_request_url", "web_report_init_status", "first_request", "video_ended", "mnpl_script_error", "open_wechat_failed_shake", "open_wechat_shacke", "open_wechat_success_shake", "options_popup", "close_pers_ads_type", "check_closed_type", "ad_guide_panel", "learn_ads", "learn_adx_ads", "learn_pers_ads", "resume_closed_type", "twist", "open_wechat_shake"};
        debugLabelHashMap = new HashMap<>(446);
        for (int i4 = 0; i4 < 446; i4++) {
            debugLabelHashMap.put(strArr[i4], 1);
        }
    }

    public static void monitorSave(AdLogEventFace adLogEventFace) {
        try {
            if (LogInternalManager.getInstance().getAdLogDepend().isOpenMonitor()) {
                LogThreadCenter.sEventMonitor.setCreateSave(System.currentTimeMillis() - adLogEventFace.getCreateTime());
                adLogEventFace.setSaveTime(System.currentTimeMillis());
                if (adLogEventFace.getAdType() == 0 && LogInternalManager.getInstance().getAdLogDepend() != null && LogInternalManager.getInstance().getAdLogDepend().isUploadDebugMessage()) {
                    String labelOrEvent = getLabelOrEvent(adLogEventFace);
                    if (isDebugEvent(labelOrEvent)) {
                        return;
                    }
                    JSONObject event = adLogEventFace.getEvent();
                    String optString = adLogEventFace.getEvent().optString("ad_extra_data");
                    if (!TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject = new JSONObject(optString);
                        if (TextUtils.isEmpty(jSONObject.optString(EventMonitor.SAVE_SUCCESS_LABELS))) {
                            jSONObject.put(EventMonitor.SAVE_SUCCESS_LABELS, saveMoveLabels(labelOrEvent + "_" + getSdkEventValidIndex(adLogEventFace)));
                        }
                        event.put("ad_extra_data", jSONObject.toString());
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(EventMonitor.SAVE_SUCCESS_LABELS, saveMoveLabels(labelOrEvent + "_" + getSdkEventValidIndex(adLogEventFace)));
                    event.put("ad_extra_data", jSONObject2.toString());
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void monitorUpload(List<AdLogEventFace> list, int i4) {
        try {
            if (LogInternalManager.getInstance().getAdLogDepend().isOpenMonitor()) {
                for (AdLogEventFace adLogEventFace : list) {
                    if (adLogEventFace != null && adLogEventFace.getSaveTime() != 0) {
                        long currentTimeMillis = System.currentTimeMillis() - adLogEventFace.getSaveTime();
                        EventMonitor eventMonitor = LogThreadCenter.sEventMonitor;
                        eventMonitor.getWill_send_count().incrementAndGet();
                        eventMonitor.getSave_upload_cost_ts().getAndAdd(currentTimeMillis);
                        adLogEventFace.setUploadTime(System.currentTimeMillis());
                    }
                    if (adLogEventFace != null) {
                        beforeUploadPutLabel(adLogEventFace);
                    }
                }
                LogThreadCenter.sEventMonitor.getDid_send_count().getAndAdd(list.size());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void putLabelsLogId(List<AdLogEventFace> list, String str) {
        try {
            IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
            if (adLogDepend == null || !adLogDepend.isOpenMonitor() || list == null) {
                return;
            }
            for (AdLogEventFace adLogEventFace : list) {
                if (adLogEventFace != null) {
                    putLogId(adLogEventFace, str, adLogDepend);
                }
            }
        } catch (Exception e4) {
            LDebug.e(e4.getMessage());
        }
    }

    private static void putLogId(AdLogEventFace adLogEventFace, String str, IAdLogDepend iAdLogDepend) {
        String labelOrEvent = getLabelOrEvent(adLogEventFace);
        if (isDebugEvent(labelOrEvent)) {
            return;
        }
        String reqId = getReqId(adLogEventFace);
        if (adLogEventFace.getAdType() == 0 && iAdLogDepend.isUploadDebugMessage()) {
            putLogIdLabels(labelOrEvent + "_" + getSdkEventValidIndex(adLogEventFace) + "_" + reqId + "_" + str);
        }
    }

    private static synchronized void putLogIdLabels(String str) {
        synchronized (EventDebugUtils.class) {
            LinkedList<String> linkedList = logIdList;
            if (linkedList.size() >= 10) {
                linkedList.removeFirst();
                linkedList.add(str);
            } else {
                linkedList.add(str);
            }
        }
    }

    public static void resultMonitor(int i4, List<AdLogEventFace> list, long j4) {
        if (LogInternalManager.getInstance().getAdLogDepend().isOpenMonitor()) {
            long currentTimeMillis = System.currentTimeMillis() - j4;
            LDebug.d("uploadCost:" + currentTimeMillis);
            if (i4 == 200) {
                EventMonitor eventMonitor = LogThreadCenter.sEventMonitor;
                eventMonitor.getSuccess_request_cost_ts().getAndAdd(currentTimeMillis);
                eventMonitor.getRequest_success_count().incrementAndGet();
                eventMonitor.getSend_success_valid_count().getAndAdd(list.size());
                eventMonitor.getSdk_send_success_count().getAndAdd(list.size());
                return;
            }
            LDebug.e("-------AdThread code is " + i4 + " error  ------------");
            if (i4 == -1) {
                LogThreadCenter.sEventMonitor.getSend_success_invalid_count().getAndAdd(list.size());
            } else {
                LogThreadCenter.sEventMonitor.getSend_fail_count().getAndAdd(list.size());
            }
            EventMonitor eventMonitor2 = LogThreadCenter.sEventMonitor;
            eventMonitor2.getFail_request_cost_ts().getAndAdd(currentTimeMillis);
            eventMonitor2.getRequest_fail_count().incrementAndGet();
        }
    }

    private static synchronized String saveMoveLabels(String str) {
        String sb;
        synchronized (EventDebugUtils.class) {
            LinkedList<String> linkedList = saveList;
            if (linkedList.size() >= 10) {
                linkedList.removeFirst();
                linkedList.add(str);
            } else {
                linkedList.add(str);
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = linkedList.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append(",");
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static void setShowResult(boolean z3, int i4, String str, String str2, int i5, String str3) {
        mAllShowCnt++;
        if (z3) {
            mSucShowCnt++;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("suc", z3);
            jSONObject.put("scnt", mSucShowCnt);
            jSONObject.put("acnt", mAllShowCnt);
            jSONObject.put("code", i4);
            jSONObject.put("reqid", str2);
            jSONObject.put("len:", i5);
            jSONObject.put("rit", str3);
            jSONObject.put("msg", str);
            if (LogInternalManager.getInstance().getAdLogDepend().getLogNetDepend() != null) {
                jSONObject.put("url", LogInternalManager.getInstance().getAdLogDepend().getLogNetDepend().getAppLogUrl());
            } else {
                jSONObject.put("url", "emptyurl");
            }
            uploadShowResult = jSONObject.toString();
        } catch (Exception unused) {
            uploadShowResult = "unknown_json";
        }
    }

    private static synchronized String uploadMoveLabels(String str) {
        String sb;
        synchronized (EventDebugUtils.class) {
            LinkedList<String> linkedList = uploadList;
            if (linkedList.size() >= 10) {
                linkedList.removeFirst();
                linkedList.add(str);
            } else {
                linkedList.add(str);
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = linkedList.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append(",");
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static String getLabelOrEvent(JSONObject jSONObject) {
        if (jSONObject == null || isGroMore()) {
            return null;
        }
        String optString = jSONObject.optString("label");
        return TextUtils.isEmpty(optString) ? jSONObject.optString("event") : optString;
    }
}
