package com.beizi.ad.internal.utilities;

import android.content.Context;
import com.beizi.ad.internal.utilities.HaoboLogListener;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class HaoboLog {
    private static final boolean mIsDebug = false;
    public static String baseLogTag = "BEIZISDK";
    public static String mediationLogTag = baseLogTag + "-MEDIATION";
    public static String publicFunctionsLogTag = baseLogTag + "-INTERFACE";
    public static String httpReqLogTag = baseLogTag + "-REQUEST";
    public static String httpRespLogTag = baseLogTag + "-RESPONSE";
    public static String pbLogTag = baseLogTag + "-PB";
    public static String xmlLogTag = baseLogTag + "-XML";
    public static String jsonLogTag = baseLogTag + "-JSON";
    public static String jsLogTag = baseLogTag + "-JS";
    public static String mraidLogTag = baseLogTag + "-MRAID";
    public static String browserLogTag = baseLogTag + "-APPBROWSER";
    public static String nativeLogTag = baseLogTag + "-NATIVE";
    public static String videoLogTag = baseLogTag + "-VIDEO";
    public static String fixLog = baseLogTag + "-FIX";
    public static String pingerLogTag = baseLogTag + "-PINGER";
    public static String lruDiskUsageLogTag = baseLogTag + "-LRUDISKUSAGE";
    public static String httpProxyCacheServerLogTag = baseLogTag + "-CACHESERVER";
    public static String httpUrlSourceLogTag = baseLogTag + "-URLSOURCE";
    public static String proxyCacheLogTag = baseLogTag + "-PROXYCACHE";
    public static String proxyCacheUtilsLogTag = baseLogTag + "-PROXYCACHEUTILS";
    public static String storageUtilsLogTag = baseLogTag + "-STORAGEUTILS";
    private static SoftReference<Context> sLogContext = new SoftReference<>(null);
    private static String lastRequest = "";
    private static String lastResponse = "";
    private static String lastLog = "";
    private static final ArrayList<HaoboLogListener> listeners = new ArrayList<>();

    public static synchronized void clearLastResponse() {
        synchronized (HaoboLog.class) {
            lastResponse = "";
        }
    }

    public static void d(String str, String str2) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.D, str, str2);
            logIfLoggable(str, str2, 4, null);
        }
    }

    public static void e(String str, String str2) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.E, str, str2);
            logIfLoggable(str, str2, 6, null);
        }
    }

    public static synchronized String getLastLogRequest() {
        String str;
        synchronized (HaoboLog.class) {
            str = lastLog;
        }
        return str;
    }

    public static synchronized String getLastRequest() {
        String str;
        synchronized (HaoboLog.class) {
            str = lastRequest;
        }
        return str;
    }

    public static synchronized String getLastResponse() {
        String str;
        synchronized (HaoboLog.class) {
            str = lastResponse;
        }
        return str;
    }

    public static String getString(int i4) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i4);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static void i(String str, String str2) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.I, str, str2);
            logIfLoggable(str, str2, 4, null);
        }
    }

    private static void logIfLoggable(String str, String str2, int i4, Throwable th) {
    }

    private static synchronized void notifyListener(HaoboLogListener.LOG_LEVEL log_level, String str, String str2) {
        synchronized (HaoboLog.class) {
            notifyListener(log_level, str, str2, null);
        }
    }

    public static synchronized boolean registerListener(HaoboLogListener haoboLogListener) {
        boolean z3;
        synchronized (HaoboLog.class) {
            if (haoboLogListener != null) {
                z3 = listeners.add(haoboLogListener) ? true : true;
            }
            z3 = false;
        }
        return z3;
    }

    public static void setErrorContext(Context context) {
        sLogContext = new SoftReference<>(context);
    }

    public static synchronized void setLastLogRequest(String str) {
        synchronized (HaoboLog.class) {
            lastLog = str;
        }
    }

    public static synchronized void setLastRequest(String str) {
        synchronized (HaoboLog.class) {
            lastRequest = str;
        }
    }

    public static synchronized void setLastResponse(String str) {
        synchronized (HaoboLog.class) {
            lastResponse = str;
        }
    }

    public static synchronized void unregisterAllListeners() {
        synchronized (HaoboLog.class) {
            listeners.clear();
        }
    }

    public static synchronized boolean unregisterListener(HaoboLogListener haoboLogListener) {
        boolean z3;
        synchronized (HaoboLog.class) {
            if (haoboLogListener != null) {
                z3 = listeners.remove(haoboLogListener) ? true : true;
            }
            z3 = false;
        }
        return z3;
    }

    public static void v(String str, String str2) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.V, str, str2);
            logIfLoggable(str, str2, 4, null);
        }
    }

    public static void w(String str, String str2) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.W, str, str2);
            logIfLoggable(str, str2, 5, null);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.D, str, str2, th);
            logIfLoggable(str, str2, 4, th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.E, str, str2, th);
            logIfLoggable(str, str2, 6, th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.I, str, str2, th);
            logIfLoggable(str, str2, 4, th);
        }
    }

    private static synchronized void notifyListener(HaoboLogListener.LOG_LEVEL log_level, String str, String str2, Throwable th) {
        synchronized (HaoboLog.class) {
            Iterator<HaoboLogListener> it = listeners.iterator();
            while (it.hasNext()) {
                HaoboLogListener next = it.next();
                if (log_level.ordinal() >= next.getLogLevel().ordinal()) {
                    if (th != null) {
                        next.onReceiveMessage(log_level, str, str2, th);
                    } else {
                        next.onReceiveMessage(log_level, str, str2);
                    }
                }
            }
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.V, str, str2, th);
            logIfLoggable(str, str2, 4, th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (str2 != null) {
            notifyListener(HaoboLogListener.LOG_LEVEL.W, str, str2, th);
            logIfLoggable(str, str2, 5, th);
        }
    }

    public static String getString(int i4, long j4) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i4, Long.valueOf(j4));
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String getString(int i4, String str) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i4, str);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String getString(int i4, String str, int i5) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i4, str, Integer.valueOf(i5));
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String getString(int i4, int i5, int i6, int i7, int i8) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i4, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String getString(int i4, boolean z3) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i4, Boolean.valueOf(z3));
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String getString(int i4, String str, String str2) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i4, str, str2);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String getString(int i4, int i5, String str, String str2) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i4, Integer.valueOf(i5), str, str2);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String getString(int i4, String str, int i5, String str2) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i4, str, Integer.valueOf(i5), str2);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String getString(int i4, int i5, String str) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i4, Integer.valueOf(i5), str);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String getString(int i4, int i5, int i6, int i7, int i8, String str, boolean z3) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i4, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), str, Boolean.valueOf(z3));
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String getString(int i4, boolean z3, int i5) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i4, Boolean.valueOf(z3), Integer.valueOf(i5));
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String getString(int i4, int i5, int i6) {
        try {
            Context context = sLogContext.get();
            if (context == null) {
                return null;
            }
            return context.getString(i4, Integer.valueOf(i5), Integer.valueOf(i6));
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
