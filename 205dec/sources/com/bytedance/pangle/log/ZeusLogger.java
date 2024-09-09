package com.bytedance.pangle.log;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.apm.ApmUtils;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ZeusLogger {
    public static final String TAG = "Zeus_pangle";
    public static final String TAG_ACTIVITY = "Zeus/activity_pangle";
    public static final String TAG_DOWNLOAD = "Zeus/download_pangle";
    public static final String TAG_INIT = "Zeus/init_pangle";
    public static final String TAG_INSTALL = "Zeus/install_pangle";
    public static final String TAG_LOAD = "Zeus/load_pangle";
    public static final String TAG_PAM = "Zeus/pam_pangle";
    public static final String TAG_PPM = "Zeus/ppm_pangle";
    public static final String TAG_PROVIDER = "Zeus/provider_pangle";
    public static final String TAG_RECEIVER = "Zeus/receiver_pangle";
    public static final String TAG_REPORTER = "Zeus/reporter_pangle";
    public static final String TAG_RESOURCES = "Zeus/resources_pangle";
    public static final String TAG_SERVER = "Zeus/server_pangle";
    public static final String TAG_SERVICE = "Zeus/service_pangle";
    public static final String TAG_SO = "Zeus/so_pangle";
    private static boolean sDebug = true;
    private static boolean sEnableTrace;

    public static void d(String str) {
        d(null, str);
    }

    public static void errReport(String str, String str2) {
        RuntimeException runtimeException = new RuntimeException();
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, 1, stackTrace.length - 1));
        errReport(str, str2, runtimeException, false);
    }

    private static String getTraceInfo() {
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            StackTraceElement stackTraceElement = null;
            int i4 = 1;
            while (true) {
                if (i4 >= stackTrace.length) {
                    break;
                } else if (!TextUtils.equals(stackTrace[i4].getClassName(), ZeusLogger.class.getName())) {
                    stackTraceElement = stackTrace[i4];
                    break;
                } else {
                    i4++;
                }
            }
            if (stackTraceElement != null) {
                return "\t\t[" + stackTraceElement.toString() + "]";
            }
            return "\t\t[No Trace Info]";
        } catch (Exception e4) {
            e4.printStackTrace();
            return "\t\t[No Trace Info]";
        }
    }

    public static void i(String str) {
        i(null, str);
    }

    public static boolean isDebug() {
        return sDebug;
    }

    public static boolean isEnableTrace() {
        return sEnableTrace;
    }

    private static String prefixTraceInfo(String str) {
        if (sEnableTrace) {
            return str + getTraceInfo();
        }
        return str;
    }

    public static void setDebug(boolean z3) {
        sDebug = z3;
    }

    public static void setEnableTrace(boolean z3) {
        sEnableTrace = z3;
    }

    public static void v(String str) {
        v(null, str);
    }

    public static void w(String str) {
        w(null, str);
    }

    public static void d(String str, String str2) {
        i(str, str2);
    }

    public static void i(String str, String str2) {
        String prefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.i(str, prefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().i(str, prefixTraceInfo);
        }
    }

    public static void v(String str, String str2) {
        String prefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.v(str, prefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().v(str, prefixTraceInfo);
        }
    }

    public static void w(String str, String str2) {
        String prefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.w(str, prefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().w(str, prefixTraceInfo);
        }
    }

    public static void errReport(String str, String str2, @NonNull Throwable th) {
        errReport(str, str2, th, true);
    }

    private static void errReport(String str, String str2, @NonNull Throwable th, boolean z3) {
        if (sDebug) {
            Log.e(str, str2, z3 ? th : null);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().e(str, str2, z3 ? th : null);
        }
        ApmUtils.getApmInstance().reportError(str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        String prefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.w(str, prefixTraceInfo, th);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().w(str, prefixTraceInfo, th);
        }
    }
}
