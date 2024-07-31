package com.p521ss.android.downloadlib.p534h;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.p521ss.android.downloadlib.C12265s;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.p540ok.C12274bl;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12317n;
import com.p521ss.android.socialbase.downloader.constants.C12415n;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.h.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12202ok {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.h.ok$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12204ok implements InvocationHandler {

        /* renamed from: ok */
        private Object f34477ok;

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("startActivity".contains(method.getName())) {
                    C12202ok.m18727ok(objArr);
                }
            } catch (Throwable unused) {
            }
            return method.invoke(this.f34477ok, objArr);
        }

        private C12204ok(Object obj) {
            this.f34477ok = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bl */
    public static void m18731bl() {
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
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new C12204ok(obj2)));
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ok */
    public static String m18729ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return C12274bl.m18512ok(new File(str));
    }

    /* renamed from: a */
    public static String m18732a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = C12128r.getContext().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: ok */
    public static int m18728ok(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 5;
        }
        return C12274bl.m18509ok(str, new File(str2));
    }

    /* renamed from: ok */
    public static void m18730ok() {
        if (C12128r.m18946q().optInt("hook", 0) != 1) {
            return;
        }
        C12265s.m18554ok().m18552ok(new Runnable() { // from class: com.ss.android.downloadlib.h.ok.1
            @Override // java.lang.Runnable
            public void run() {
                C12317n.m18234p();
                C12202ok.m18731bl();
            }
        }, 10000L);
    }

    /* renamed from: ok */
    public static void m18727ok(Object[] objArr) {
        if (C12128r.m18946q().optInt("hook", 0) == 1 && (objArr[1] instanceof String) && (objArr[2] instanceof Intent)) {
            Intent intent = (Intent) objArr[2];
            if ("android.intent.action.VIEW".equals(intent.getAction()) && C12415n.f34990ok.equals(intent.getType())) {
                if (C12317n.m18230s()) {
                    String optString = C12128r.m18946q().optString("hook_vivo_arg", "com.android.settings");
                    if ("null".equals(optString)) {
                        return;
                    }
                    objArr[1] = optString;
                } else if (C12317n.m18237n()) {
                    JSONObject m18946q = C12128r.m18946q();
                    String optString2 = m18946q.optString("hook_kllk_arg1", "com." + C12415n.f34986bl + ".market");
                    if (!"null".equals(optString2)) {
                        objArr[1] = optString2;
                    }
                    String optString3 = C12128r.m18946q().optString("hook_kllk_arg2", "com.android.browser");
                    JSONObject m18946q2 = C12128r.m18946q();
                    String optString4 = m18946q2.optString("hook_kllk_arg3", "m.store." + C12415n.f34986bl + "mobile.com");
                    StringBuilder sb = new StringBuilder();
                    sb.append(C12415n.f34986bl);
                    sb.append("_extra_pkg_name");
                    intent.putExtra(sb.toString(), optString3);
                    intent.putExtra("refererHost", optString4);
                    if (C12128r.m18946q().optInt("hook_kllk_arg4", 0) == 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(C12415n.f34986bl + "_extra_pkg_name", optString3);
                        intent2.putExtra("refererHost", optString4);
                        intent.putExtra("android.intent.extra.INTENT", intent2);
                    }
                } else if (C12317n.m18236ok()) {
                    String optString5 = C12128r.m18946q().optString("hook_huawei_arg1", "com.huawei.appmarket");
                    if (!"null".equals(optString5)) {
                        objArr[1] = optString5;
                    }
                    intent.putExtra("caller_package", C12128r.m18946q().optString("hook_huawei_arg2", "com.huawei.appmarket"));
                }
            }
        }
    }
}
