package com.ss.android.downloadlib.r;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.r.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class C0956c implements InvocationHandler {

        /* renamed from: c  reason: collision with root package name */
        private Object f48916c;

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("startActivity".contains(method.getName())) {
                    c.c(objArr);
                }
            } catch (Throwable unused) {
            }
            return method.invoke(this.f48916c, objArr);
        }

        private C0956c(Object obj) {
            this.f48916c = obj;
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.c.xv.c(new File(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xv() {
        Field declaredField;
        try {
            if (Build.VERSION.SDK_INT < 26) {
                declaredField = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
            } else {
                declaredField = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            }
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 == null) {
                return;
            }
            Class<?> cls = Class.forName("android.app.IActivityManager");
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new C0956c(obj2)));
        } catch (Throwable unused) {
        }
    }

    public static String w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = com.ss.android.downloadlib.addownload.k.getContext().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static int c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 5;
        }
        return com.ss.android.c.xv.c(str, new File(str2));
    }

    public static void c() {
        if (com.ss.android.downloadlib.addownload.k.gd().optInt("hook", 0) != 1) {
            return;
        }
        com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.r.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.f.ux.ev();
                c.xv();
            }
        }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    public static void c(Object[] objArr) {
        if (com.ss.android.downloadlib.addownload.k.gd().optInt("hook", 0) == 1 && (objArr[1] instanceof String) && (objArr[2] instanceof Intent)) {
            Intent intent = (Intent) objArr[2];
            if ("android.intent.action.VIEW".equals(intent.getAction()) && com.ss.android.socialbase.downloader.constants.ux.f49351c.equals(intent.getType())) {
                if (com.ss.android.socialbase.appdownloader.f.ux.sr()) {
                    String optString = com.ss.android.downloadlib.addownload.k.gd().optString("hook_vivo_arg", "com.android.settings");
                    if ("null".equals(optString)) {
                        return;
                    }
                    objArr[1] = optString;
                } else if (com.ss.android.socialbase.appdownloader.f.ux.ux()) {
                    JSONObject gd = com.ss.android.downloadlib.addownload.k.gd();
                    String optString2 = gd.optString("hook_kllk_arg1", "com." + com.ss.android.socialbase.downloader.constants.ux.xv + ".market");
                    if (!"null".equals(optString2)) {
                        objArr[1] = optString2;
                    }
                    String optString3 = com.ss.android.downloadlib.addownload.k.gd().optString("hook_kllk_arg2", "com.android.browser");
                    JSONObject gd2 = com.ss.android.downloadlib.addownload.k.gd();
                    String optString4 = gd2.optString("hook_kllk_arg3", "m.store." + com.ss.android.socialbase.downloader.constants.ux.xv + "mobile.com");
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.ss.android.socialbase.downloader.constants.ux.xv);
                    sb.append("_extra_pkg_name");
                    intent.putExtra(sb.toString(), optString3);
                    intent.putExtra("refererHost", optString4);
                    if (com.ss.android.downloadlib.addownload.k.gd().optInt("hook_kllk_arg4", 0) == 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(com.ss.android.socialbase.downloader.constants.ux.xv + "_extra_pkg_name", optString3);
                        intent2.putExtra("refererHost", optString4);
                        intent.putExtra("android.intent.extra.INTENT", intent2);
                    }
                } else if (com.ss.android.socialbase.appdownloader.f.ux.c()) {
                    String optString5 = com.ss.android.downloadlib.addownload.k.gd().optString("hook_huawei_arg1", "com.huawei.appmarket");
                    if (!"null".equals(optString5)) {
                        objArr[1] = optString5;
                    }
                    intent.putExtra("caller_package", com.ss.android.downloadlib.addownload.k.gd().optString("hook_huawei_arg2", "com.huawei.appmarket"));
                }
            }
        }
    }
}
