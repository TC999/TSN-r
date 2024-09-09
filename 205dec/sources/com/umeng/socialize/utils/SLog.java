package com.umeng.socialize.utils;

import android.os.Bundle;
import android.util.Log;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SLog {
    private static boolean DEBUG = true;
    private static final int E = 0;
    private static final int I = 2;
    private static final String PRIVATE = "priviteSocial";
    private static final String TAG = "Social";

    public static void AQ(String str, String str2) {
        UMLog uMLog = UMConfigure.umDebugLog;
        UMLog.aq("Social", 0, str, str2);
    }

    public static void BUNDLE(Bundle bundle) {
        if (UMConfigure.umDebugLog != null) {
            UMLog.bundle("Social", 2, bundle);
        }
    }

    public static void E(String str) {
        if (UMConfigure.umDebugLog != null) {
            String[] split = str.split("\n");
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo("Social", 0, split);
        }
    }

    public static void I(String str) {
        if (UMConfigure.umDebugLog != null) {
            String[] split = str.split("\n");
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo("Social", 2, split);
        }
    }

    public static void JARRY(JSONArray jSONArray) {
        if (UMConfigure.umDebugLog != null) {
            UMLog.jsonArry("Social", jSONArray);
        }
    }

    public static void JSON(JSONObject jSONObject) {
        if (UMConfigure.umDebugLog != null) {
            UMLog.jsonObject("Social", jSONObject);
        }
    }

    public static void TE(String str, String str2) {
        if (UMConfigure.umDebugLog != null) {
            String[] split = str2.split("\n");
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo("Social_" + str, 0, split);
        }
    }

    public static void TI(String str, String str2) {
        if (UMConfigure.umDebugLog != null) {
            String[] split = str2.split("\n");
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo("Social_" + str, 2, split);
        }
    }

    public static void debug(String str) {
        if (UMConfigure.umDebugLog == null || !DEBUG) {
            return;
        }
        UMLog.mutlInfo("priviteSocial", 2, "[private log]  " + str);
    }

    public static void error(Throwable th) {
        if (UMConfigure.umDebugLog != null) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i4 = 2;
            String[] strArr = new String[stackTrace.length + 2];
            strArr[0] = "\u9519\u8bef\u4fe1\u606f\u5982\u4e0b:";
            strArr[1] = "\u9519\u8bef\u7c7b\u578b:" + th.getMessage();
            for (StackTraceElement stackTraceElement : stackTrace) {
                strArr[i4] = "        at\t " + stackTraceElement.toString();
                i4++;
            }
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo("Social", 0, strArr);
        }
    }

    public static boolean isDebug() {
        if (UMConfigure.umDebugLog != null) {
            return UMConfigure.isDebugLog();
        }
        return false;
    }

    public static void mutlE(String... strArr) {
        UMLog uMLog = UMConfigure.umDebugLog;
        UMLog.mutlInfo("Social", 0, strArr);
    }

    public static void mutlI(String... strArr) {
        if (UMConfigure.umDebugLog != null) {
            UMLog.mutlInfo("Social", 2, strArr);
        }
    }

    public static void runtimePrint(String str) {
        UMRTLog.e("priviteSocial", str);
    }

    public static void selfLog(String str) {
        Log.e("priviteSocial", str);
    }

    public static void welcome() {
        if (UMConfigure.isDebugLog()) {
            Log.e("priviteSocial", "\u6b22\u8fce\u4f7f\u7528\u53cb\u76df\u793e\u4f1a\u5316\u5206\u4eab\u4e1a\u52a1!");
        }
    }

    public static void error(String str, Throwable th) {
        if (UMConfigure.umDebugLog == null || th == null) {
            return;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        int i4 = 2;
        String[] strArr = new String[stackTrace.length + 2];
        strArr[0] = str;
        strArr[1] = "\u9519\u8bef\u7c7b\u578b:" + th.getMessage();
        for (StackTraceElement stackTraceElement : stackTrace) {
            strArr[i4] = "        at\t " + stackTraceElement.toString();
            i4++;
        }
        UMLog uMLog = UMConfigure.umDebugLog;
        UMLog.mutlInfo("Social", 0, strArr);
    }
}
