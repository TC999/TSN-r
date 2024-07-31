package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

/* renamed from: com.umeng.umzid.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13492d {

    /* renamed from: a */
    public static String[] f39672a = {"com.bly.dkplat", "com.by.chaos", "com.lbe.parallel", "com.excelliance.dualaid", "com.excelliance.multiaccounts", "com.lody.virtual", "com.qihoo.magic"};

    /* renamed from: a */
    public static String m13191a(Context context) {
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

    /* renamed from: a */
    public static String m13189a(String str) {
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 2));
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static void m13190a(Context context, String str) {
        SharedPreferences m13196a;
        SharedPreferences.Editor edit;
        String m13186b = m13186b(str);
        if (context == null || m13186b == null || TextUtils.isEmpty(m13186b) || (m13196a = C13488a.m13196a(context)) == null || (edit = m13196a.edit()) == null) {
            return;
        }
        edit.putString(SocializeProtocolConstants.PROTOCOL_KEY_MAC, m13186b).commit();
    }

    /* renamed from: b */
    public static String m13188b(Context context) {
        SharedPreferences m13196a;
        if (context == null || (m13196a = C13488a.m13196a(context)) == null) {
            return "";
        }
        String string = m13196a.getString("inputDomain", "");
        return m13183c(string) ? m13189a(string) : string;
    }

    /* renamed from: b */
    public static String m13186b(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static void m13187b(Context context, String str) {
        SharedPreferences m13196a;
        SharedPreferences.Editor edit;
        String m13186b = m13186b(str);
        if (context == null || m13186b == null || TextUtils.isEmpty(m13186b) || (m13196a = C13488a.m13196a(context)) == null || (edit = m13196a.edit()) == null) {
            return;
        }
        edit.putString("oaid", m13186b).commit();
    }

    /* renamed from: c */
    public static String m13185c(Context context) {
        SharedPreferences m13196a;
        return (context == null || (m13196a = C13488a.m13196a(context)) == null) ? "" : m13196a.getString("uabc", "");
    }

    /* renamed from: c */
    public static void m13184c(Context context, String str) {
        SharedPreferences m13196a;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (m13196a = C13488a.m13196a(context)) == null || (edit = m13196a.edit()) == null) {
            return;
        }
        edit.putString("resetToken", str).commit();
    }

    /* renamed from: c */
    public static boolean m13183c(String str) {
        return !TextUtils.isEmpty(str) && str.equals(m13186b(m13189a(str)));
    }

    /* renamed from: d */
    public static String m13182d(Context context) {
        SharedPreferences m13196a;
        if (context == null || (m13196a = C13488a.m13196a(context)) == null) {
            return null;
        }
        return m13196a.getString("aaid", null);
    }

    /* renamed from: d */
    public static void m13181d(Context context, String str) {
        SharedPreferences m13196a;
        SharedPreferences.Editor edit;
        if (context == null || TextUtils.isEmpty(str) || (m13196a = C13488a.m13196a(context)) == null || (edit = m13196a.edit()) == null) {
            return;
        }
        edit.putString("uabc", str).commit();
    }

    /* renamed from: e */
    public static String m13180e(Context context) {
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

    /* renamed from: e */
    public static void m13179e(Context context, String str) {
        SharedPreferences m13196a;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (m13196a = C13488a.m13196a(context)) == null || (edit = m13196a.edit()) == null) {
            return;
        }
        edit.putString("aaid", str).commit();
    }

    /* renamed from: f */
    public static String m13178f(Context context) {
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

    /* renamed from: f */
    public static void m13177f(Context context, String str) {
        SharedPreferences m13196a;
        SharedPreferences.Editor edit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (m13196a = C13488a.m13196a(context)) == null || (edit = m13196a.edit()) == null) {
            return;
        }
        edit.putString("zdata", str).commit();
    }

    /* renamed from: g */
    public static boolean m13176g(Context context) {
        boolean z;
        try {
            String path = context.getFilesDir().getPath();
            for (String str : f39672a) {
                if (path.contains(str)) {
                    z = true;
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
        z = false;
        return z;
    }

    /* renamed from: h */
    public static boolean m13175h(Context context) {
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

    /* renamed from: i */
    public static boolean m13174i(Context context) {
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

    /* renamed from: j */
    public static boolean m13173j(Context context) {
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
