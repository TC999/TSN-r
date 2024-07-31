package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.UMLogAnalytics;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.statistics.common.MLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MobclickAgent {

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EScenarioType {
        E_UM_NORMAL(0),
        E_UM_GAME(1);
        

        /* renamed from: a */
        private int f37533a;

        EScenarioType(int i) {
            this.f37533a = i;
        }

        public int toValue() {
            return this.f37533a;
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum PageMode {
        AUTO,
        MANUAL,
        LEGACY_AUTO,
        LEGACY_MANUAL
    }

    public static void clearPreProperties(Context context) {
        getAgent().m14794g(context);
    }

    public static void disable() {
        AnalyticsConfig.enable = false;
    }

    private static void disableExceptionCatch() {
        InternalAgent.m14841a().m14819a(false);
        AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    }

    @Deprecated
    public static void enableEncrypt(boolean z) {
    }

    public static InternalAgent getAgent() {
        return InternalAgent.m14841a();
    }

    public static JSONObject getPreProperties(Context context) {
        return getAgent().m14791h(context);
    }

    private static void init(Context context) {
        InternalAgent.m14841a().m14838a(context);
    }

    public static void onEvent(Context context, String str) {
        InternalAgent.m14841a().m14833a(context, str, (String) null, -1L, 1);
    }

    public static void onEventObject(Context context, String str, Map<String, Object> map) {
        if (map == null) {
            UMLog.m14015aq(UMLogAnalytics.f38295a, 0, "\\|");
        } else {
            InternalAgent.m14841a().m14830a(context, str, map, -1L);
        }
    }

    public static void onEventValue(Context context, String str, Map<String, String> map, int i) {
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map);
        }
        hashMap.put("__ct__", Integer.valueOf(i));
        InternalAgent.m14841a().m14830a(context, str, hashMap, -1L);
    }

    private static void onGKVEvent(Context context, String str, HashMap<String, Object> hashMap) {
        InternalAgent.m14841a().m14832a(context, str, hashMap);
    }

    public static void onKillProcess(Context context) {
        InternalAgent.m14841a().m14806d(context);
    }

    public static void onPageEnd(String str) {
        if (!TextUtils.isEmpty(str)) {
            InternalAgent.m14841a().m14814b(str);
        } else {
            UMLog.m14015aq(UMLogAnalytics.f38272D, 0, "\\|");
        }
    }

    public static void onPageStart(String str) {
        if (!TextUtils.isEmpty(str)) {
            InternalAgent.m14841a().m14823a(str);
        } else {
            UMLog.m14015aq(UMLogAnalytics.f38271C, 0, "\\|");
        }
    }

    public static void onPause(Context context) {
        InternalAgent.m14841a().m14811c(context);
    }

    public static void onProfileSignIn(String str) {
        onProfileSignIn("_adhoc", str);
    }

    public static void onProfileSignOff() {
        InternalAgent.m14841a().m14788j();
    }

    public static void onResume(Context context) {
        if (context == null) {
            UMLog.m14015aq(UMLogAnalytics.f38326n, 0, "\\|");
        } else {
            InternalAgent.m14841a().m14817b(context);
        }
    }

    public static void registerPreProperties(Context context, JSONObject jSONObject) {
        getAgent().m14826a(context, jSONObject);
    }

    public static void reportError(Context context, String str) {
        try {
            Class<?> cls = Class.forName("com.umeng.umcrash.UMCrash");
            Method declaredMethod = cls.getDeclaredMethod("generateCustomLog", String.class, String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(cls, str, "DEFAULT");
            }
        } catch (Throwable unused) {
        }
    }

    public static void setCatchUncaughtExceptions(boolean z) {
        InternalAgent.m14841a().m14819a(z);
    }

    @Deprecated
    public static void setCheckDevice(boolean z) {
    }

    @Deprecated
    public static void setDebugMode(boolean z) {
    }

    public static void setFirstLaunchEvent(Context context, List<String> list) {
        getAgent().m14827a(context, list);
    }

    private static void setGameScenarioType(Context context) {
        InternalAgent.m14841a().m14836a(context, EScenarioType.E_UM_GAME);
    }

    @Deprecated
    public static void setLatencyWindow(long j) {
    }

    public static void setLocation(double d, double d2) {
        InternalAgent.m14841a().m14840a(d, d2);
    }

    public static void setOpenGLContext(GL10 gl10) {
        InternalAgent.m14841a().m14820a(gl10);
    }

    public static void setPageCollectionMode(PageMode pageMode) {
        UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION = pageMode;
    }

    @Deprecated
    public static void setScenarioType(Context context, EScenarioType eScenarioType) {
    }

    public static void setSecret(Context context, String str) {
        InternalAgent.m14841a().m14810c(context, str);
    }

    public static void setSessionContinueMillis(long j) {
        if (j <= 30000) {
            j = 30000;
        }
        InternalAgent.m14841a().m14839a(j);
    }

    private static void setSysListener(ISysListener iSysListener) {
        InternalAgent.m14841a().m14825a(iSysListener);
    }

    public static void unregisterPreProperty(Context context, String str) {
        getAgent().m14797f(context, str);
    }

    public static void userProfile(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            MLog.m13820e("userProfile: key is null or empty, please check!");
        } else if (str.startsWith("_")) {
            MLog.m13820e("userProfile: The user-defined key cannot start with an underscore, please check!");
        } else {
            boolean z = false;
            if (Character.isDigit(str.charAt(0))) {
                MLog.m13820e("userProfile: The user-defined key cannot start with an number, please check!");
                return;
            }
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                char c = charArray[i];
                if ((c < 'a' || c > 'z') && !((c >= 'A' && c <= 'Z') || Character.isDigit(c) || c == '_')) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                MLog.m13820e("userProfile: The user-defined key contains invalid characters, please check!");
            } else if (obj == null) {
                MLog.m13820e("userProfile: value is null, please check!");
            } else {
                InternalAgent.m14841a().m14822a(str, obj);
            }
        }
    }

    public static void userProfileEMail(String str) {
        if (str == null) {
            MLog.m13820e("userProfileEMail: email value is null, please check!");
        } else {
            InternalAgent.m14841a().m14804d(str);
        }
    }

    public static void userProfileMobile(String str) {
        if (str == null) {
            MLog.m13820e("userProfileMobile: mobile value is null, please check!");
        } else {
            InternalAgent.m14841a().m14809c(str);
        }
    }

    public static void onEvent(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            UMLog.m14015aq(UMLogAnalytics.f38323k, 0, "\\|");
        } else {
            InternalAgent.m14841a().m14833a(context, str, str2, -1L, 1);
        }
    }

    public static void onProfileSignIn(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            UMLog.m14015aq(UMLogAnalytics.f38332t, 0, "\\|");
        } else if (str2.length() > 64) {
            UMLog.m14015aq(UMLogAnalytics.f38333u, 0, "\\|");
        } else if (TextUtils.isEmpty(str)) {
            InternalAgent.m14841a().m14821a("_adhoc", str2);
        } else if (str.length() > 32) {
            UMLog.m14015aq(UMLogAnalytics.f38334v, 0, "\\|");
        } else {
            InternalAgent.m14841a().m14821a(str, str2);
        }
    }

    public static void onEvent(Context context, String str, Map<String, String> map) {
        if (map == null) {
            UMLog.m14015aq(UMLogAnalytics.f38295a, 0, "\\|");
        } else {
            InternalAgent.m14841a().m14830a(context, str, new HashMap(map), -1L);
        }
    }

    public static void reportError(Context context, Throwable th) {
        try {
            Class<?> cls = Class.forName("com.umeng.umcrash.UMCrash");
            Method declaredMethod = cls.getDeclaredMethod("generateCustomLog", Throwable.class, String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(cls, th, "DEFAULT");
            }
        } catch (Throwable unused) {
        }
    }
}
