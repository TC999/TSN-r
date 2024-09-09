package cn.jpush.android.asus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.e.c;
import cn.jpush.android.f.e;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import java.lang.reflect.Field;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4058c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f4059d;

    /* renamed from: a  reason: collision with root package name */
    public static final String f4056a = "asus".toLowerCase();

    /* renamed from: b  reason: collision with root package name */
    public static String f4057b = "";

    /* renamed from: e  reason: collision with root package name */
    private static String f4060e = null;

    private static ActivityInfo a(Context context, String str, Class<? extends BroadcastReceiver> cls) {
        PackageInfo packageInfo;
        ActivityInfo[] activityInfoArr;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            Logger.w("AsusPushHelper", "Action - hasComponent, invalid param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            packageInfo = JCoreHelper.getPackageInfo(context, str, 2);
        } catch (Throwable th) {
            Logger.ww("AsusPushHelper", "getReceiver error:" + th);
        }
        if (packageInfo != null && (activityInfoArr = packageInfo.receivers) != null && activityInfoArr.length != 0) {
            for (ActivityInfo activityInfo : activityInfoArr) {
                try {
                    if (cls.isAssignableFrom(Class.forName(activityInfo.name, false, cls.getClassLoader())) && activityInfo.enabled) {
                        return activityInfo;
                    }
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        Logger.d("AsusPushHelper", "pkgInfo info is null");
        return null;
    }

    public static void a(Context context, int i4) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("code", i4 + "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(JThirdPlatFormInterface.KEY_ROM_TYPE, String.valueOf(6));
            jSONObject.put(JThirdPlatFormInterface.KEY_PLUGIN_SDK_VER, JPushConstants.SDK_VERSION_NAME);
            jSONObject.put(JThirdPlatFormInterface.KEY_VENDOR_SDK_VER, b());
            bundle.putString("extra", jSONObject.toString());
            JThirdPlatFormInterface.doAction(context, JThirdPlatFormInterface.ACTION_SEND_EXCEPTION, bundle);
        } catch (Throwable unused) {
        }
    }

    private static boolean a() {
        boolean equalsIgnoreCase = "asus".equalsIgnoreCase(Build.BRAND);
        return !equalsIgnoreCase ? "asus".equalsIgnoreCase(Build.MANUFACTURER) : equalsIgnoreCase;
    }

    public static boolean a(Context context) {
        b(context);
        return f4058c;
    }

    private static String b() {
        try {
            Field declaredField = e.class.getDeclaredField("SDK_VERSION");
            declaredField.setAccessible(true);
            return (String) declaredField.get(e.class);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static synchronized void b(Context context) {
        synchronized (a.class) {
            if (f4059d) {
                return;
            }
            if (context == null) {
                Logger.ww("AsusPushHelper", "context is null");
                return;
            }
            if (a() && i(context) && cn.jpush.android.c.b.a(context)) {
                f4058c = true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(f4058c ? "support " : "not support ");
            sb.append(f4056a);
            Logger.d("AsusPushHelper", sb.toString());
            f4059d = true;
        }
    }

    public static void c(final Context context) {
        try {
            b(context);
            if (f4058c) {
                cn.jpush.android.c.b.a(context, e(context), new c() { // from class: cn.jpush.android.asus.a.1
                    @Override // cn.jpush.android.e.a
                    public void a(cn.jpush.android.e.b bVar) {
                        try {
                            Logger.dd("AsusPushHelper", "tokenResult:" + bVar);
                            a.a(context, bVar.a());
                            cn.jpush.android.ac.e.a().a(context, (byte) 6, bVar.b());
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th) {
            Logger.w("AsusPushHelper", "register error:" + th.getMessage());
        }
    }

    public static byte d(Context context) {
        return (byte) 6;
    }

    public static String e(Context context) {
        return !TextUtils.isEmpty(f4057b) ? f4057b : JCoreHelper.getAppKey(context);
    }

    public static String f(Context context) {
        return "";
    }

    public static String g(Context context) {
        return cn.jpush.android.c.b.d(context);
    }

    public static boolean h(Context context) {
        String str;
        String e4 = e(context);
        if (TextUtils.isEmpty(e4)) {
            str = f4056a + " appkey or appid is empty,need not clear plugin rid";
        } else {
            String appKey = JCoreHelper.getAppKey(context);
            if (!TextUtils.isEmpty(appKey)) {
                String str2 = (String) Sp.get(context, Key.ThirdPush_ClearFlag());
                String hash = JThirdPlatFormInterface.toHash(e4 + appKey + JCoreHelper.getJCoreSDKVersionInt() + JCoreHelper.getJPushSDKVersionInt());
                if (TextUtils.isEmpty(str2)) {
                    Sp.set(context, Key.ThirdPush_ClearFlag().set(hash));
                    return true;
                } else if (TextUtils.isEmpty(hash)) {
                    return true;
                } else {
                    if (TextUtils.equals(str2, hash)) {
                        return false;
                    }
                    Logger.d("AsusPushHelper", "local set changed,re bind token");
                    Sp.set(context, Key.ThirdPush_ClearFlag().set(hash));
                    return true;
                }
            }
            str = "jpush appkey is empty,need not clear plugin rid";
        }
        Logger.ii("AsusPushHelper", str);
        return false;
    }

    private static boolean i(Context context) {
        ActivityInfo a4 = a(context, context.getPackageName(), AsusPushMessageReceiver.class);
        if (a4 == null) {
            Logger.ww("AsusPushHelper", "AndroidManifest.xml missing receiver extends asus's AsusPushMessageReceiver");
            return false;
        }
        Logger.d("AsusPushHelper", "found receiver:" + a4.name);
        return true;
    }
}
