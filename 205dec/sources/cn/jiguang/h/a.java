package cn.jiguang.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {
    public static PackageInfo a(Context context, String str, int i4) {
        PackageInfo packageInfo;
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && i4 >= 0) {
                    if (JConstants.SDK_VERSION_INT >= 332) {
                        Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 99, null, null, str, Integer.valueOf(i4));
                        if (!(onEvent instanceof PackageInfo)) {
                            return null;
                        }
                        packageInfo = (PackageInfo) onEvent;
                    } else {
                        packageInfo = context.getPackageManager().getPackageInfo(str, i4);
                    }
                    return packageInfo;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static String a(Context context) {
        try {
            Object onEvent = JCoreManager.onEvent(context, null, 4, null, null, new Object[0]);
            return onEvent instanceof String ? (String) onEvent : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static JSONObject a(Context context, JSONObject jSONObject, String str) {
        try {
            Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 26, null, null, jSONObject, str);
            if (onEvent instanceof JSONObject) {
                return (JSONObject) onEvent;
            }
        } catch (Throwable unused) {
        }
        return new JSONObject();
    }

    public static boolean b(Context context) {
        Object onEvent = JCoreManager.onEvent(context, null, 121, null, null, new Object[0]);
        if (onEvent instanceof Boolean) {
            return ((Boolean) onEvent).booleanValue();
        }
        return false;
    }

    public static String c(Context context) {
        try {
            Object onEvent = JCoreManager.onEvent(context, null, 7, null, null, new Object[0]);
            return onEvent instanceof String ? (String) onEvent : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long d(Context context) {
        try {
            Object onEvent = JCoreManager.onEvent(context, null, 20, null, null, new Object[0]);
            if (onEvent instanceof Long) {
                return ((Long) onEvent).longValue();
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String e(Context context) {
        try {
            Object onEvent = JCoreManager.onEvent(context, null, 6, null, null, new Object[0]);
            return onEvent instanceof String ? (String) onEvent : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String f(Context context) {
        try {
            Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 8, null, null, new Object[0]);
            return onEvent instanceof String ? (String) onEvent : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int g(Context context) {
        try {
            Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 102, null, null, new Object[0]);
            if (onEvent instanceof Integer) {
                return ((Integer) onEvent).intValue();
            }
            return 1;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static String h(Context context) {
        try {
            Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 34, null, null, new Object[0]);
            return onEvent instanceof String ? (String) onEvent : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean i(Context context) {
        try {
            Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 58, null, null, new Object[0]);
            if (onEvent instanceof Boolean) {
                return ((Boolean) onEvent).booleanValue();
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static String j(Context context) {
        try {
            Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 107, null, null, new Object[0]);
            if (onEvent instanceof String) {
                return (String) onEvent;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean k(Context context) {
        try {
            Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 125, null, null, new Object[0]);
            if (onEvent instanceof Boolean) {
                return ((Boolean) onEvent).booleanValue();
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean l(Context context) {
        try {
            Object onEvent = JCoreManager.onEvent(context, JConstants.SDK_TYPE, 126, null, null, new Object[0]);
            if (onEvent instanceof Boolean) {
                return ((Boolean) onEvent).booleanValue();
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }
}
