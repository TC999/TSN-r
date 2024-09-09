package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f54238a = {"com.bly.dkplat", "com.by.chaos", "com.lbe.parallel", "com.excelliance.dualaid", "com.excelliance.multiaccounts", "com.lody.virtual", "com.qihoo.magic"};

    public static String a(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            Method declaredMethod = cls.getDeclaredMethod("getAndroidId", Context.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(cls, context);
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String a(String str) {
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 2));
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void a(Context context, String str) {
        SharedPreferences a4;
        SharedPreferences.Editor edit;
        String b4 = b(str);
        if (context == null || b4 == null || TextUtils.isEmpty(b4) || (a4 = a.a(context)) == null || (edit = a4.edit()) == null) {
            return;
        }
        edit.putString("mac", b4).commit();
    }

    public static String b(Context context) {
        SharedPreferences a4;
        if (context == null || (a4 = a.a(context)) == null) {
            return "";
        }
        String string = a4.getString("inputDomain", "");
        return c(string) ? a(string) : string;
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void b(Context context, String str) {
        SharedPreferences a4;
        SharedPreferences.Editor edit;
        String b4 = b(str);
        if (context == null || b4 == null || TextUtils.isEmpty(b4) || (a4 = a.a(context)) == null || (edit = a4.edit()) == null) {
            return;
        }
        edit.putString(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, b4).commit();
    }

    public static String c(Context context) {
        SharedPreferences a4;
        return (context == null || (a4 = a.a(context)) == null) ? "" : a4.getString("uabc", "");
    }

    public static void c(Context context, String str) {
        SharedPreferences a4;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (a4 = a.a(context)) == null || (edit = a4.edit()) == null) {
            return;
        }
        edit.putString("resetToken", str).commit();
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.equals(b(a(str)));
    }

    public static String d(Context context) {
        SharedPreferences a4;
        if (context == null || (a4 = a.a(context)) == null) {
            return null;
        }
        return a4.getString("aaid", null);
    }

    public static void d(Context context, String str) {
        SharedPreferences a4;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (a4 = a.a(context)) == null || (edit = a4.edit()) == null) {
            return;
        }
        edit.putString("uabc", str).commit();
    }

    public static String e(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            Method declaredMethod = cls.getDeclaredMethod("getMac", Context.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(cls, context);
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static void e(Context context, String str) {
        SharedPreferences a4;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (a4 = a.a(context)) == null || (edit = a4.edit()) == null) {
            return;
        }
        edit.putString("aaid", str).commit();
    }

    public static String f(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
            Method declaredMethod = cls.getDeclaredMethod("getOaid", Context.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(cls, context);
                if (invoke != null && (invoke instanceof String)) {
                    return (String) invoke;
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static void f(Context context, String str) {
        SharedPreferences a4;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (a4 = a.a(context)) == null || (edit = a4.edit()) == null) {
            return;
        }
        edit.putString("zdata", str).commit();
    }

    public static boolean g(Context context) {
        boolean z3;
        try {
            String path = context.getFilesDir().getPath();
            for (String str : f54238a) {
                if (path.contains(str)) {
                    z3 = true;
                    break;
                }
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } catch (Throwable th2) {
                th2.printStackTrace();
                return false;
            }
        }
        z3 = false;
        return z3;
    }

    public static boolean h(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.utils.UMUtils");
            Method declaredMethod = cls.getDeclaredMethod("isMainProgress", Context.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return ((Boolean) declaredMethod.invoke(cls, context)).booleanValue();
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean i(Context context) {
        NetworkInfo networkInfo;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (networkInfo = connectivityManager.getNetworkInfo(17)) != null) {
                    return networkInfo.isConnected();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static boolean j(Context context) {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
