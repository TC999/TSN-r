package com.bytedance.pangle.log;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.apm.ApmUtils;
import java.util.Arrays;

@Keep
/* loaded from: E:\fuckcool\tsn\5141176.dex */
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

    /* renamed from: d */
    public static void m37084d(String str) {
        m37083d(null, str);
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
            int i = 1;
            while (true) {
                if (i >= stackTrace.length) {
                    break;
                } else if (!TextUtils.equals(stackTrace[i].getClassName(), ZeusLogger.class.getName())) {
                    stackTraceElement = stackTrace[i];
                    break;
                } else {
                    i++;
                }
            }
            if (stackTraceElement != null) {
                return "\t\t[" + stackTraceElement.toString() + "]";
            }
            return "\t\t[No Trace Info]";
        } catch (Exception e) {
            e.printStackTrace();
            return "\t\t[No Trace Info]";
        }
    }

    /* renamed from: i */
    public static void m37082i(String str) {
        m37081i(null, str);
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

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    public static void setEnableTrace(boolean z) {
        sEnableTrace = z;
    }

    /* renamed from: v */
    public static void m37080v(String str) {
        m37079v(null, str);
    }

    /* renamed from: w */
    public static void m37078w(String str) {
        m37077w(null, str);
    }

    /* renamed from: d */
    public static void m37083d(String str, String str2) {
        m37081i(str, str2);
    }

    /* renamed from: i */
    public static void m37081i(String str, String str2) {
        String prefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.i(str, prefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().mo36544i(str, prefixTraceInfo);
        }
    }

    /* renamed from: v */
    public static void m37079v(String str, String str2) {
        String prefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.v(str, prefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().mo36543v(str, prefixTraceInfo);
        }
    }

    /* renamed from: w */
    public static void m37077w(String str, String str2) {
        String prefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.w(str, prefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().mo36542w(str, prefixTraceInfo);
        }
    }

    public static void errReport(String str, String str2, @NonNull Throwable th) {
        errReport(str, str2, th, true);
    }

    private static void errReport(String str, String str2, @NonNull Throwable th, boolean z) {
        if (sDebug) {
            Log.e(str, str2, z ? th : null);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().mo36545e(str, str2, z ? th : null);
        }
        ApmUtils.getApmInstance().reportError(str2, th);
    }

    /* renamed from: w */
    public static void m37076w(String str, String str2, Throwable th) {
        String prefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.w(str, prefixTraceInfo, th);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().mo36541w(str, prefixTraceInfo, th);
        }
    }
}
