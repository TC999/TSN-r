package cn.jpush.android.helper;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.local.JPushConstants;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class JCoreHelper {
    private static void a(Context context, String str, int i4, int i5, long j4, long j5, byte[] bArr, boolean z3) {
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", i4);
        bundle.putInt("ver", i5);
        bundle.putLong("rid", j4);
        bundle.putLong("timeout", j5);
        bundle.putByteArray("body", bArr);
        JCoreManager.onEvent(context, str, z3 ? 17 : 16, null, bundle, new Object[0]);
    }

    public static Boolean checkSdkBanned(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 82, null, null, new Object[0]);
        return onEvent instanceof Boolean ? (Boolean) onEvent : Boolean.FALSE;
    }

    public static void execue(Context context, String str, Runnable runnable) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 11, str, null, runnable);
    }

    public static JSONObject fillBase(Context context, JSONObject jSONObject, String str) {
        Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 26, "", null, jSONObject, str);
        if (onEvent instanceof JSONObject) {
            return (JSONObject) onEvent;
        }
        return null;
    }

    public static void futureExecutor(Context context, Runnable runnable) {
        futureExecutor(context, "FUTURE", runnable);
    }

    public static void futureExecutor(Context context, String str, Runnable runnable) {
        if (cn.jpush.android.m.a.f4250c >= 238) {
            JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 76, null, null, runnable);
        } else {
            execue(context, str, runnable);
        }
    }

    public static String getAppKey(Context context) {
        Object onEvent = JCoreManager.onEvent(context, null, 7, null, null, new Object[0]);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static String getDeviceId(Context context) {
        Object onEvent = JCoreManager.onEvent(context, null, 8, null, null, new Object[0]);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static Object getDyInfo(Context context, int i4) {
        return JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 64, null, null, Integer.valueOf(i4));
    }

    public static int getJCoreSDKVersionInt() {
        Object onEvent = JCoreManager.onEvent(null, null, 25, null, null, new Object[0]);
        if (onEvent instanceof Integer) {
            return ((Integer) onEvent).intValue();
        }
        return 0;
    }

    public static int getJPushSDKVersionInt() {
        return cn.jpush.android.m.a.f4248a;
    }

    public static PackageInfo getPackageInfo(Context context, int i4) {
        if (context != null) {
            return getPackageInfo(context, context.getPackageName(), i4);
        }
        return null;
    }

    public static PackageInfo getPackageInfo(Context context, String str, int i4) {
        PackageInfo packageInfo;
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && i4 >= 0) {
                    if (JConstants.SDK_VERSION_INT >= 332) {
                        Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 99, null, null, str, Integer.valueOf(i4));
                        if (!(onEvent instanceof PackageInfo)) {
                            return null;
                        }
                        packageInfo = (PackageInfo) onEvent;
                    } else {
                        packageInfo = context.getPackageManager().getPackageInfo(str, i4);
                    }
                    return packageInfo;
                }
            } catch (Throwable th) {
                Logger.w("JCoreHelper", "get p info failed, error: " + th.getMessage());
                return null;
            }
        }
        Logger.d("JCoreHelper", "get p info failed, because param is illegal");
        return null;
    }

    public static String getRegistrationID(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 4, null, null, new Object[0]);
        return onEvent instanceof String ? (String) onEvent : "";
    }

    public static long getUid(Context context) {
        Object onEvent = JCoreManager.onEvent(context, null, 20, null, null, null);
        if (onEvent instanceof Long) {
            return ((Long) onEvent).longValue();
        }
        return 0L;
    }

    public static boolean isAuth(Context context) {
        Object onEvent = JCoreManager.onEvent(context, null, 98, null, null, new Object[0]);
        if (onEvent instanceof Boolean) {
            return ((Boolean) onEvent).booleanValue();
        }
        return true;
    }

    public static boolean isContinueBusiness(Context context) {
        if (cn.jpush.android.m.a.f4250c < 470) {
            return true;
        }
        Object onEvent = JCoreManager.onEvent(context, null, 123, null, null, new Object[0]);
        if (onEvent instanceof Boolean) {
            return ((Boolean) onEvent).booleanValue();
        }
        return false;
    }

    public static boolean isIpv6Priority(Context context) {
        Object onEvent = JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 121, null, null, new Object[0]);
        if (onEvent instanceof Boolean) {
            return ((Boolean) onEvent).booleanValue();
        }
        return false;
    }

    public static void majorExecutor(Context context, String str, Runnable runnable) {
        if (cn.jpush.android.m.a.f4250c >= 238) {
            JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 75, null, null, runnable);
        } else {
            execue(context, str, runnable);
        }
    }

    public static void netMonitor(Context context, String str, String str2, long j4, int i4) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putString("type", str2);
        bundle.putLong("req", j4);
        bundle.putLong("res", i4);
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 122, null, bundle, new Object[0]);
    }

    public static void normalExecutor(Context context, String str, Runnable runnable) {
        if (cn.jpush.android.m.a.f4250c >= 238) {
            JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 77, null, null, runnable);
        } else {
            execue(context, str, runnable);
        }
    }

    public static void openLog(Context context, Bundle bundle) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 105, null, bundle, new Object[0]);
    }

    public static void reportSdkType(Context context, String str, int i4, int i5, int i6) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 72, true, null, null, str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public static void runActionWithService(Context context, String str, String str2, Bundle bundle) {
        JCoreManager.onEvent(context, str, 3, str2, bundle, new Object[0]);
    }

    public static void saEvent(Context context, String str, Object obj) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 56, str, null, obj);
    }

    public static void sendData(Context context, String str, int i4, int i5, long j4, byte[] bArr) {
        a(context, str, i4, i5, j4, 0L, bArr, false);
    }

    public static void sendRequest(Context context, String str, int i4, int i5, long j4, long j5, byte[] bArr) {
        a(context, str, i4, i5, j4, j5, bArr, true);
    }

    public static void setChannel(Context context, String str) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 9, str, null, new Object[0]);
    }

    public static void triggerSceneCheck(Context context) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 29, null, null, 3);
    }

    public static void updateDy(Context context, int i4) {
        JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 65, null, null, Integer.valueOf(i4));
    }
}
