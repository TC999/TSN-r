package com.bytedance.pangle.sdk.component.log.impl.core;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.IDBCallback;
import com.bytedance.pangle.sdk.component.log.impl.debug.LDebug;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DBEventUtils {
    public static long getFreeMem(Context context) {
        Runtime runtime = Runtime.getRuntime();
        LDebug.e("Current free memory:adFree" + (runtime.freeMemory() / 1048576) + "M");
        LDebug.e("Currently available memory:adFree" + (runtime.totalMemory() / 1048576) + "M");
        LDebug.e("Current maximum memory: adFree" + (runtime.maxMemory() / 1048576) + "M");
        return runtime.freeMemory();
    }

    public static long getMaxCount(int i4, Context context) {
        long maxLimitByMemory = getMaxLimitByMemory(i4, context);
        LDebug.d("ad limit by memory:" + maxLimitByMemory);
        return maxLimitByMemory;
    }

    private static long getMaxLimitByMemory(int i4, Context context) {
        if (context == null) {
            return i4;
        }
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory() / 1048576;
        long maxMemory = (runtime.maxMemory() / 1048576) - (runtime.totalMemory() / 1048576);
        if (maxMemory <= 0) {
            if (freeMemory <= 2) {
                return 1L;
            }
            if (freeMemory <= 10) {
                return Math.min(i4, 10);
            }
            return Math.min((freeMemory / 2) * 10, i4);
        }
        long j4 = ((freeMemory + maxMemory) - 10) / 2;
        if (j4 <= 2) {
            return 1L;
        }
        if (j4 <= 10) {
            return Math.min(i4, 10);
        }
        return Math.min(j4 * 10, i4);
    }

    public static boolean isAdEventAvailable() {
        IDBCallback dbCallback = LogInternalManager.getInstance().getDbCallback();
        return (dbCallback == null || TextUtils.isEmpty(dbCallback.getAdEventTableName())) ? false : true;
    }

    public static boolean isAdEventV3Available() {
        IDBCallback dbCallback = LogInternalManager.getInstance().getDbCallback();
        return (dbCallback == null || TextUtils.isEmpty(dbCallback.getAdEventV3TableName())) ? false : true;
    }

    public static boolean isBatchAvailable() {
        IDBCallback dbCallback = LogInternalManager.getInstance().getDbCallback();
        return (dbCallback == null || TextUtils.isEmpty(dbCallback.getStatsBatchTableName())) ? false : true;
    }

    public static boolean isHighAvailable() {
        IDBCallback dbCallback = LogInternalManager.getInstance().getDbCallback();
        return (dbCallback == null || TextUtils.isEmpty(dbCallback.getHighPriorityTableName())) ? false : true;
    }

    public static boolean isOtherEventAvailable() {
        IDBCallback dbCallback = LogInternalManager.getInstance().getDbCallback();
        return (dbCallback == null || TextUtils.isEmpty(dbCallback.getOtherEventTableName())) ? false : true;
    }

    public static boolean isStatsAvailable() {
        IDBCallback dbCallback = LogInternalManager.getInstance().getDbCallback();
        return (dbCallback == null || TextUtils.isEmpty(dbCallback.getStatsEventTableName())) ? false : true;
    }
}
