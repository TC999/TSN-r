package defpackage;

import android.app.ActivityThread;
import android.app.LoadedApk;
import android.os.Build;
import android.os.IBinder;
import io.github.libxposed.api.XposedInterface;
import io.github.libxposed.api.annotations.AfterInvocation;
import io.github.libxposed.api.annotations.XposedHooker;
import java.lang.reflect.Field;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import ulL.WeEFDVoZmmWVmW.yXd.XposedBridge;
import ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers;
import ulL.WeEFDVoZmmWVmW.yXd.XposedInit;
import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XC_LoadPackage;
import ulL.WeEFDVoZmmWVmW.yXd.callbacks.XCallback;

@XposedHooker
/* renamed from: h0  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class C1464h0 implements XposedInterface.Hooker {

    /* renamed from: a  reason: collision with root package name */
    public static final Field f54731a;

    /* renamed from: b  reason: collision with root package name */
    public static final ConcurrentHashMap.KeySetView f54732b = ConcurrentHashMap.newKeySet();

    static {
        Field field = null;
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                field = LoadedApk.class.getDeclaredField("mDefaultClassLoader");
                field.setAccessible(true);
            } catch (Throwable unused) {
            }
        }
        f54731a = field;
    }

    @AfterInvocation
    public static void a(XposedInterface.AfterHookCallback afterHookCallback) {
        String currentPackageName;
        String currentProcessName;
        boolean z3;
        Object objectField;
        ClassLoader classLoader;
        LoadedApk loadedApk = (LoadedApk) afterHookCallback.getThisObject();
        if (afterHookCallback.getArgs()[0] == null && f54732b.contains(loadedApk)) {
            try {
                AbstractC1457e.d("LoadedApk#createClassLoader starts");
                currentPackageName = ActivityThread.currentPackageName();
                currentProcessName = ActivityThread.currentProcessName();
                z3 = (currentPackageName == null || currentProcessName == null || !currentPackageName.equals(loadedApk.getPackageName())) ? false : true;
                if (!z3) {
                    currentPackageName = loadedApk.getPackageName();
                    currentProcessName = ActivityThread.currentPackageName();
                } else if (currentPackageName.equals("android")) {
                    currentPackageName = "system";
                }
                objectField = XposedHelpers.getObjectField(loadedApk, "mAppDir");
                classLoader = (ClassLoader) XposedHelpers.getObjectField(loadedApk, "mClassLoader");
                AbstractC1457e.d("LoadedApk#createClassLoader ends: " + objectField + " -> " + classLoader);
            } finally {
                try {
                } finally {
                }
            }
            if (classLoader == null) {
                return;
            }
            if (!z3 && !XposedHelpers.getBooleanField(loadedApk, "mIncludeCode")) {
                AbstractC1457e.d("LoadedApk#<init> mIncludeCode == false: " + objectField);
            } else if (z3 || ((Optional) XposedInit.getLoadedModules().getOrDefault(currentPackageName, Optional.of(""))).isPresent()) {
                XC_LoadPackage.LoadPackageParam loadPackageParam = new XC_LoadPackage.LoadPackageParam(XposedBridge.sLoadedPackageCallbacks);
                loadPackageParam.packageName = currentPackageName;
                loadPackageParam.processName = currentProcessName;
                loadPackageParam.classLoader = classLoader;
                loadPackageParam.appInfo = loadedApk.getApplicationInfo();
                loadPackageParam.isFirstApplication = z3;
                if (z3 && ((Optional) XposedInit.getLoadedModules().getOrDefault(currentPackageName, Optional.empty())).isPresent()) {
                    b(loadPackageParam);
                }
                IBinder b4 = C1455d.f54605b.b(loadPackageParam.packageName);
                if (b4 != null) {
                    XposedHelpers.findAndHookMethod("android.app.Activity", loadPackageParam.classLoader, "getSystemService", String.class, new C1456d0(0, b4));
                }
                AbstractC1457e.d("Call handleLoadedPackage: packageName=" + loadPackageParam.packageName + " processName=" + loadPackageParam.processName + " isFirstPackage=" + z3 + " classLoader=" + loadPackageParam.classLoader + " appInfo=" + loadPackageParam.appInfo);
                XCallback.callAll(loadPackageParam);
                N.callOnPackageLoaded(new C1458e0(loadedApk, classLoader, z3));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(ulL.WeEFDVoZmmWVmW.yXd.callbacks.XC_LoadPackage.LoadPackageParam r5) {
        /*
            r0 = -1
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.io.IOException -> L25 java.lang.NumberFormatException -> L27
            android.content.pm.ApplicationInfo r3 = r5.appInfo     // Catch: java.io.IOException -> L25 java.lang.NumberFormatException -> L27
            java.lang.String r3 = r3.sourceDir     // Catch: java.io.IOException -> L25 java.lang.NumberFormatException -> L27
            r2.<init>(r3)     // Catch: java.io.IOException -> L25 java.lang.NumberFormatException -> L27
            P r3 = new P     // Catch: java.io.IOException -> L25 java.lang.NumberFormatException -> L27
            r3.<init>(r2)     // Catch: java.io.IOException -> L25 java.lang.NumberFormatException -> L27
            java.lang.Object r2 = r3.f53a     // Catch: java.io.IOException -> L25 java.lang.NumberFormatException -> L27
            java.util.HashMap r2 = (java.util.HashMap) r2     // Catch: java.io.IOException -> L25 java.lang.NumberFormatException -> L27
            java.lang.String r3 = "xposedminversion"
            java.lang.Object r3 = r2.get(r3)     // Catch: java.io.IOException -> L25 java.lang.NumberFormatException -> L27
            boolean r4 = r3 instanceof java.lang.Integer     // Catch: java.io.IOException -> L25 java.lang.NumberFormatException -> L27
            if (r4 == 0) goto L29
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.io.IOException -> L25 java.lang.NumberFormatException -> L27
            int r0 = r3.intValue()     // Catch: java.io.IOException -> L25 java.lang.NumberFormatException -> L27
            goto L33
        L25:
            r2 = move-exception
            goto L3a
        L27:
            r2 = move-exception
            goto L3a
        L29:
            boolean r4 = r3 instanceof java.lang.String     // Catch: java.io.IOException -> L25 java.lang.NumberFormatException -> L27
            if (r4 == 0) goto L33
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.io.IOException -> L25 java.lang.NumberFormatException -> L27
            int r0 = defpackage.P.b(r3)     // Catch: java.io.IOException -> L25 java.lang.NumberFormatException -> L27
        L33:
            java.lang.String r3 = "xposedsharedprefs"
            boolean r2 = r2.containsKey(r3)     // Catch: java.io.IOException -> L25 java.lang.NumberFormatException -> L27
            goto L40
        L3a:
            java.lang.String r3 = "ApkParser fails"
            defpackage.AbstractC1457e.e(r3, r2)
            r2 = r1
        L40:
            r3 = 92
            if (r0 > r3) goto L46
            if (r2 == 0) goto L73
        L46:
            boolean r0 = defpackage.K0.f35a
            java.lang.String r0 = "LSPosed"
            java.lang.String r2 = "New modules detected, hook preferences"
            android.util.Log.i(r0, r2)
            java.lang.ClassLoader r0 = r5.classLoader
            java.lang.Class r2 = java.lang.Integer.TYPE
            f0 r3 = new f0
            r3.<init>(r1)
            java.lang.Object[] r1 = new java.lang.Object[]{r2, r3}
            java.lang.String r2 = "checkMode"
            java.lang.String r3 = "android.app.ContextImpl"
            ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers.findAndHookMethod(r3, r0, r2, r1)
            java.lang.ClassLoader r0 = r5.classLoader
            g0 r1 = new g0
            r1.<init>(r5)
            java.lang.Object[] r5 = new java.lang.Object[]{r1}
            java.lang.String r1 = "getPreferencesDir"
            ulL.WeEFDVoZmmWVmW.yXd.XposedHelpers.findAndHookMethod(r3, r0, r1, r5)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1464h0.b(ulL.WeEFDVoZmmWVmW.yXd.callbacks.XC_LoadPackage$LoadPackageParam):void");
    }
}
