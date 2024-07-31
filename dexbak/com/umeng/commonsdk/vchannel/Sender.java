package com.umeng.commonsdk.vchannel;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.UMInternalConfig;
import com.umeng.commonsdk.internal.UMInternalData;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Sender {
    private static long INTERVAL_THRESHOLD = 500;
    public static final String VCHANNEL_VERSION = "1.0.0";
    private static Map<String, String> customHeader;
    private static long lastTriggerTime;

    public static void handleEvent(Context context, Event event) {
        if (context == null) {
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> Sender:handleEvent: context is null.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UMCommonContent.f37789aS, "1.0.0");
                Map<String, String> map = customHeader;
                if (map != null && map.size() > 0) {
                    for (String str : customHeader.keySet()) {
                        jSONObject.put(str, customHeader.get(str));
                    }
                }
            } catch (Throwable unused) {
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("analytics", event.m13448d());
            UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2, Constant.f39229c, "v", "1.0.0");
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void onEvent(Context context, String str, Map<String, Object> map) {
        if (context == null) {
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: context is null.");
        } else if (TextUtils.isEmpty(str)) {
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: eventID is null or an empty string.");
        } else if (map == null) {
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: map is null.");
        } else if (!UMFrUtils.isOnline(context)) {
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: Network unavailable.");
        } else if (System.currentTimeMillis() - lastTriggerTime < INTERVAL_THRESHOLD) {
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: The interval between events is less than 500 milliseconds.");
        } else {
            Event event = new Event(context);
            event.m13452a(str);
            event.m13453a(System.currentTimeMillis());
            event.m13451a(map);
            try {
                UMWorkDispatch.sendEvent(context, UMInternalConfig.f38803o, UMInternalData.m13974a(context).m13975a(), event);
            } catch (Throwable unused) {
            }
            lastTriggerTime = System.currentTimeMillis();
        }
    }

    public static void setCustomHeader(Map<String, String> map) {
        if (map != null) {
            customHeader = map;
        }
    }
}
