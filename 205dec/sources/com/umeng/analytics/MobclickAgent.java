package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.umeng.analytics.pro.j;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class MobclickAgent {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum EScenarioType {
        E_UM_NORMAL(0),
        E_UM_GAME(1);
        

        /* renamed from: a  reason: collision with root package name */
        private int f52431a;

        EScenarioType(int i4) {
            this.f52431a = i4;
        }

        public int toValue() {
            return this.f52431a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum PageMode {
        AUTO,
        MANUAL,
        LEGACY_AUTO,
        LEGACY_MANUAL
    }

    public static void clearPreProperties(Context context) {
        getAgent().g(context);
    }

    public static void disable() {
        AnalyticsConfig.enable = false;
    }

    private static void disableExceptionCatch() {
        b.a().a(false);
        AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    }

    @Deprecated
    public static void enableEncrypt(boolean z3) {
    }

    public static b getAgent() {
        return b.a();
    }

    public static JSONObject getPreProperties(Context context) {
        return getAgent().h(context);
    }

    private static void init(Context context) {
        b.a().a(context);
    }

    public static void onEvent(Context context, String str) {
        b.a().a(context, str, (String) null, -1L, 1);
    }

    public static void onEventObject(Context context, String str, Map<String, Object> map) {
        if (map == null) {
            UMLog.aq(j.f52991a, 0, "\\|");
        } else {
            b.a().a(context, str, map, -1L);
        }
    }

    public static void onEventValue(Context context, String str, Map<String, String> map, int i4) {
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map);
        }
        hashMap.put("__ct__", Integer.valueOf(i4));
        b.a().a(context, str, hashMap, -1L);
    }

    private static void onGKVEvent(Context context, String str, HashMap<String, Object> hashMap) {
        b.a().a(context, str, hashMap);
    }

    public static void onKillProcess(Context context) {
        b.a().d(context);
    }

    public static void onPageEnd(String str) {
        if (!TextUtils.isEmpty(str)) {
            b.a().b(str);
        } else {
            UMLog.aq(j.D, 0, "\\|");
        }
    }

    public static void onPageStart(String str) {
        if (!TextUtils.isEmpty(str)) {
            b.a().a(str);
        } else {
            UMLog.aq(j.C, 0, "\\|");
        }
    }

    public static void onPause(Context context) {
        b.a().c(context);
    }

    public static void onProfileSignIn(String str) {
        onProfileSignIn("_adhoc", str);
    }

    public static void onProfileSignOff() {
        b.a().j();
    }

    public static void onResume(Context context) {
        if (context == null) {
            UMLog.aq(j.f53004n, 0, "\\|");
        } else {
            b.a().b(context);
        }
    }

    public static void registerPreProperties(Context context, JSONObject jSONObject) {
        getAgent().a(context, jSONObject);
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

    public static void setCatchUncaughtExceptions(boolean z3) {
        b.a().a(z3);
    }

    @Deprecated
    public static void setCheckDevice(boolean z3) {
    }

    @Deprecated
    public static void setDebugMode(boolean z3) {
    }

    public static void setFirstLaunchEvent(Context context, List<String> list) {
        getAgent().a(context, list);
    }

    private static void setGameScenarioType(Context context) {
        b.a().a(context, EScenarioType.E_UM_GAME);
    }

    @Deprecated
    public static void setLatencyWindow(long j4) {
    }

    public static void setLocation(double d4, double d5) {
        b.a().a(d4, d5);
    }

    public static void setOpenGLContext(GL10 gl10) {
        b.a().a(gl10);
    }

    public static void setPageCollectionMode(PageMode pageMode) {
        UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION = pageMode;
    }

    @Deprecated
    public static void setScenarioType(Context context, EScenarioType eScenarioType) {
    }

    public static void setSecret(Context context, String str) {
        b.a().c(context, str);
    }

    public static void setSessionContinueMillis(long j4) {
        if (j4 <= PolicyConfig.mServerBusyRetryBaseInternal) {
            j4 = 30000;
        }
        b.a().a(j4);
    }

    private static void setSysListener(ISysListener iSysListener) {
        b.a().a(iSysListener);
    }

    public static void unregisterPreProperty(Context context, String str) {
        getAgent().f(context, str);
    }

    public static void userProfile(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            MLog.e("userProfile: key is null or empty, please check!");
        } else if (str.startsWith("_")) {
            MLog.e("userProfile: The user-defined key cannot start with an underscore, please check!");
        } else {
            boolean z3 = false;
            if (Character.isDigit(str.charAt(0))) {
                MLog.e("userProfile: The user-defined key cannot start with an number, please check!");
                return;
            }
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                char c4 = charArray[i4];
                if ((c4 < 'a' || c4 > 'z') && !((c4 >= 'A' && c4 <= 'Z') || Character.isDigit(c4) || c4 == '_')) {
                    z3 = true;
                    break;
                }
                i4++;
            }
            if (z3) {
                MLog.e("userProfile: The user-defined key contains invalid characters, please check!");
            } else if (obj == null) {
                MLog.e("userProfile: value is null, please check!");
            } else {
                b.a().a(str, obj);
            }
        }
    }

    public static void userProfileEMail(String str) {
        if (str == null) {
            MLog.e("userProfileEMail: email value is null, please check!");
        } else {
            b.a().d(str);
        }
    }

    public static void userProfileMobile(String str) {
        if (str == null) {
            MLog.e("userProfileMobile: mobile value is null, please check!");
        } else {
            b.a().c(str);
        }
    }

    public static void onEvent(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            UMLog.aq(j.f53001k, 0, "\\|");
        } else {
            b.a().a(context, str, str2, -1L, 1);
        }
    }

    public static void onProfileSignIn(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            UMLog.aq(j.f53010t, 0, "\\|");
        } else if (str2.length() > 64) {
            UMLog.aq(j.f53011u, 0, "\\|");
        } else if (TextUtils.isEmpty(str)) {
            b.a().a("_adhoc", str2);
        } else if (str.length() > 32) {
            UMLog.aq(j.f53012v, 0, "\\|");
        } else {
            b.a().a(str, str2);
        }
    }

    public static void onEvent(Context context, String str, Map<String, String> map) {
        if (map == null) {
            UMLog.aq(j.f52991a, 0, "\\|");
        } else {
            b.a().a(context, str, new HashMap(map), -1L);
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
