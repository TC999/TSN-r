package com.bytedance.pangle.sdk.component.log.impl;

import android.content.Context;
import com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback;
import com.bytedance.pangle.sdk.component.log.impl.core.LogThreadCenter;
import com.bytedance.pangle.sdk.component.log.impl.core.thread.AdPriorityLogThread;
import com.bytedance.pangle.sdk.component.log.impl.debug.LDebug;
import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AdLogManager {
    private static volatile List<HighPriorityEventUploadCallback> sEventUploadCallbackList = new ArrayList();

    public static void addEventUploadCallback(HighPriorityEventUploadCallback highPriorityEventUploadCallback) {
        if (highPriorityEventUploadCallback != null) {
            sEventUploadCallbackList.add(highPriorityEventUploadCallback);
        }
    }

    public static void flushMemoryAndDB() {
        EventMultiUtils.INSTANCE.flushMemoryAndDB();
    }

    public static String getBatch() {
        AdPriorityLogThread adThread = LogThreadCenter.instance.getAdThread();
        return adThread != null ? adThread.getCache().printBatchEvent() : "";
    }

    public static String getHigh() {
        AdPriorityLogThread adThread = LogThreadCenter.instance.getAdThread();
        return adThread != null ? adThread.getCache().printHighEvent() : "";
    }

    public static String getRealAd() {
        AdPriorityLogThread adThread = LogThreadCenter.instance.getAdThread();
        return adThread != null ? adThread.getCache().printRealAdEvent() : "";
    }

    public static String getRealStats() {
        AdPriorityLogThread adThread = LogThreadCenter.instance.getAdThread();
        return adThread != null ? adThread.getCache().printRealStatsEvent() : "";
    }

    public static List<HighPriorityEventUploadCallback> getsEventUploadCallbackList() {
        return sEventUploadCallbackList;
    }

    public static void init(AdLogConfig adLogConfig, Context context) {
        EventMultiUtils.INSTANCE.initHelper(adLogConfig, context);
        LDebug.d("init  end");
    }

    public static boolean isDependNull() {
        return LogInternalManager.getInstance().getAdLogDepend() == null || LogInternalManager.getInstance().getContext() == null;
    }

    public static void reportEvent(AdLogEventFace adLogEventFace) {
        EventMultiUtils.INSTANCE.reportEvent(adLogEventFace);
    }

    public static void setDBCallback(IDBCallback iDBCallback) {
        EventMultiUtils.INSTANCE.setDBCallback(iDBCallback);
    }

    public static void start() {
        LDebug.d("AppLogManager#start");
        EventMultiUtils.INSTANCE.start();
    }

    public static void stop() {
        EventMultiUtils.INSTANCE.stop();
    }

    public static void track(String str, List<String> list, boolean z3) {
        EventMultiUtils.INSTANCE.track(str, list, z3);
    }

    public static void trackFailedUrls(String str) {
        EventMultiUtils.INSTANCE.trackFailedUrls(str);
    }

    public static void trackStop() {
        EventMultiUtils.INSTANCE.trackStop();
    }
}
