package com.bytedance.pangle.sdk.component.log.impl.debug;

import android.util.Log;
import com.bytedance.pangle.sdk.component.log.impl.IAdLogDepend;
import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class LDebug {
    private static final String LOG_DEBUG = "log";

    public static void d(String str) {
        try {
            IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
            if (adLogDepend == null || !adLogDepend.isDebug()) {
                return;
            }
            String debugLogTag = adLogDepend.getDebugLogTag();
            if (debugLogTag == null) {
                debugLogTag = "";
            }
            Log.d(debugLogTag + LOG_DEBUG, str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void e(String str) {
        try {
            IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
            if (adLogDepend == null || !adLogDepend.isDebug()) {
                return;
            }
            String debugLogTag = adLogDepend.getDebugLogTag();
            if (debugLogTag == null) {
                debugLogTag = "";
            }
            Log.e(debugLogTag + LOG_DEBUG, str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void i(String str) {
        try {
            IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
            if (adLogDepend == null || !adLogDepend.isDebug()) {
                return;
            }
            String debugLogTag = adLogDepend.getDebugLogTag();
            if (debugLogTag == null) {
                debugLogTag = "";
            }
            Log.i(debugLogTag + LOG_DEBUG, str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void w(String str) {
        try {
            IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
            if (adLogDepend == null || !adLogDepend.isDebug()) {
                return;
            }
            String debugLogTag = adLogDepend.getDebugLogTag();
            if (debugLogTag == null) {
                debugLogTag = "";
            }
            Log.w(debugLogTag + LOG_DEBUG, str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void d(String str, String str2) {
        try {
            IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
            if (adLogDepend == null || !adLogDepend.isDebug()) {
                return;
            }
            String debugLogTag = adLogDepend.getDebugLogTag();
            if (debugLogTag == null) {
                debugLogTag = "";
            }
            Log.d((debugLogTag + LOG_DEBUG) + str, str2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void e(String str, String str2) {
        try {
            IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
            if (adLogDepend == null || !adLogDepend.isDebug()) {
                return;
            }
            String debugLogTag = adLogDepend.getDebugLogTag();
            if (debugLogTag == null) {
                debugLogTag = "";
            }
            Log.e((debugLogTag + LOG_DEBUG) + str, str2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void i(String str, String str2) {
        try {
            IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
            if (adLogDepend == null || !adLogDepend.isDebug()) {
                return;
            }
            String debugLogTag = adLogDepend.getDebugLogTag();
            if (debugLogTag == null) {
                debugLogTag = "";
            }
            Log.i((debugLogTag + LOG_DEBUG) + str, str2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void w(String str, String str2) {
        try {
            IAdLogDepend adLogDepend = LogInternalManager.getInstance().getAdLogDepend();
            if (adLogDepend == null || !adLogDepend.isDebug()) {
                return;
            }
            String debugLogTag = adLogDepend.getDebugLogTag();
            if (debugLogTag == null) {
                debugLogTag = "";
            }
            Log.w((debugLogTag + LOG_DEBUG) + str, str2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
