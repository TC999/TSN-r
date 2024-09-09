package cn.jiguang.bj;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import java.io.FileInputStream;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static String f2679a;

    /* renamed from: b  reason: collision with root package name */
    private static String f2680b;

    /* renamed from: c  reason: collision with root package name */
    private static String f2681c;

    private static ComponentInfo a(Context context, String str, Class<?> cls) {
        int i4;
        int i5;
        PackageInfo a4;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            cn.jiguang.bi.b.e("JDyAndroidUtils", "Action - hasComponent, invalide param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            i5 = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            a4 = f.a(context, str, Integer.valueOf(i5));
        } catch (Throwable th) {
            cn.jiguang.bi.b.f("JDyAndroidUtils", "hasComponent error:" + th);
        }
        if (a4 == null) {
            return null;
        }
        ComponentInfo[] componentInfoArr = i5 != 1 ? i5 != 2 ? i5 != 4 ? i5 != 8 ? null : a4.providers : a4.services : a4.receivers : a4.activities;
        if (componentInfoArr == null) {
            return null;
        }
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (cls.isAssignableFrom(Class.forName(componentInfo.name))) {
                return componentInfo;
            }
        }
        return null;
    }

    public static String a() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.bi.b.g("ReflectUtils", "getCurrentProcessNameByActivityThread: " + th.getMessage());
            return null;
        }
    }

    public static String a(Context context) {
        String a4;
        if (TextUtils.isEmpty(f2679a)) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    String processName = Application.getProcessName();
                    f2679a = processName;
                    if (!TextUtils.isEmpty(processName)) {
                        return f2679a;
                    }
                }
                a4 = a();
                f2679a = a4;
            } catch (Throwable th) {
                cn.jiguang.bi.b.f("JDyAndroidUtils", "#unexcepted - getCurProcessName failed:" + th.getMessage());
            }
            if (TextUtils.isEmpty(a4)) {
                f2679a = b();
                return f2679a;
            }
            return f2679a;
        }
        return f2679a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
        if (r4.checkPermission(r6, r5.activityInfo.packageName) != 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r4, android.content.Intent r5, java.lang.String r6) {
        /*
            android.content.pm.PackageManager r0 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L2f
            r1 = 0
            android.content.pm.ResolveInfo r5 = r0.resolveService(r5, r1)     // Catch: java.lang.Throwable -> L2f
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L2f
            android.content.pm.ServiceInfo r0 = r5.serviceInfo     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L2f
            java.lang.String r0 = r0.name     // Catch: java.lang.Throwable -> L2f
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L2f
            if (r2 != 0) goto L2f
            r2 = 1
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L2f
            if (r3 != 0) goto L2b
            android.content.pm.ActivityInfo r5 = r5.activityInfo     // Catch: java.lang.Throwable -> L2f
            java.lang.String r5 = r5.packageName     // Catch: java.lang.Throwable -> L2f
            int r4 = r4.checkPermission(r6, r5)     // Catch: java.lang.Throwable -> L2f
            if (r4 == 0) goto L2b
            goto L2c
        L2b:
            r1 = 1
        L2c:
            if (r1 == 0) goto L2f
            return r0
        L2f:
            java.lang.String r4 = ""
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bj.g.a(android.content.Context, android.content.Intent, java.lang.String):java.lang.String");
    }

    private static String a(Context context, String str) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 128).processName;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String b() {
        FileInputStream fileInputStream;
        byte[] bArr;
        int i4;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream("/proc/self/cmdline");
            } catch (Throwable unused) {
            }
            try {
                bArr = new byte[256];
                i4 = 0;
                while (true) {
                    int read = fileInputStream.read();
                    if (read <= 0 || i4 >= 256) {
                        break;
                    }
                    bArr[i4] = (byte) read;
                    i4++;
                }
            } catch (Throwable unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                    return "";
                }
                return "";
            }
            if (i4 <= 0) {
                fileInputStream.close();
                return "";
            }
            String str = new String(bArr, 0, i4, "UTF-8");
            try {
                fileInputStream.close();
            } catch (Throwable unused3) {
            }
            return str;
        } catch (Throwable unused4) {
            return "";
        }
    }

    public static boolean b(Context context) {
        if (context != null) {
            String a4 = a(context);
            if (TextUtils.isEmpty(a4)) {
                return false;
            }
            return a4.equals(c(context));
        }
        return false;
    }

    public static String c(Context context) {
        StringBuilder sb;
        String str;
        String str2 = f2681c;
        if (str2 != null) {
            return str2;
        }
        String d4 = d(context);
        if (TextUtils.isEmpty(d4)) {
            f2681c = context.getPackageName();
            sb = new StringBuilder();
            str = "user serviceProcess is curProcessName:";
        } else {
            f2681c = a(context, d4);
            sb = new StringBuilder();
            str = "user serviceProcess is:";
        }
        sb.append(str);
        sb.append(f2681c);
        cn.jiguang.bi.b.b("JDyAndroidUtils", sb.toString());
        return f2681c;
    }

    private static String d(Context context) {
        ComponentInfo a4;
        String str;
        Class<?> cls = null;
        try {
            str = f2680b;
        } catch (Throwable th) {
            cn.jiguang.bi.b.b("JDyAndroidUtils", "getUserServiceClass failed:" + th);
        }
        if (str != null) {
            return str;
        }
        cls = Class.forName("cn.jpush.android.service.JCommonService");
        Intent intent = new Intent();
        intent.setAction(JConstants.USER_SERVICE_ACTION);
        intent.setPackage(context.getPackageName());
        String a5 = a(context, intent, "");
        if (!TextUtils.isEmpty(a5) && cls.isAssignableFrom(Class.forName(a5))) {
            f2680b = a5;
            cn.jiguang.bi.b.d("JDyAndroidUtils", "found userServiceClass :" + f2680b + " by getCommonServiceNames");
        }
        if (TextUtils.isEmpty(f2680b) && (a4 = a(context, context.getPackageName(), cls)) != null) {
            f2680b = a4.name;
            cn.jiguang.bi.b.d("JDyAndroidUtils", "found userServiceClass :" + f2680b + " by getComponentInfo");
        }
        if (TextUtils.isEmpty(f2680b)) {
            f2680b = "";
        }
        return f2680b;
    }
}
