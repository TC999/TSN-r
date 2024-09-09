package com.bytedance.c.w;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.c.w.r.w;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo;
import com.bytedance.sdk.openadsdk.api.plugin.w;
import com.stub.StubApp;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f26475a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f26476b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f26477c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f26478d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f26479a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f26480b;

        a(Context context, boolean z3) {
            this.f26479a = context;
            this.f26480b = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            w0.a.a().b(this.f26479a);
            com.bytedance.c.w.r.c.a(this.f26479a);
            if (this.f26480b) {
                com.bytedance.c.w.c.b.a(this.f26479a).b();
            }
        }
    }

    /* renamed from: com.bytedance.c.w.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class RunnableC0369b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.bytedance.c.c.b f26481a;

        RunnableC0369b(com.bytedance.c.c.b bVar) {
            this.f26481a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.c.c.a.c(this.f26481a);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        private static String f26482a;

        private static String a() {
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    return Application.getProcessName();
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return null;
                }
            }
            return null;
        }

        public static String b(Context context) {
            if (!TextUtils.isEmpty(f26482a)) {
                return f26482a;
            }
            String a4 = a();
            f26482a = a4;
            if (!TextUtils.isEmpty(a4)) {
                return f26482a;
            }
            String c4 = c();
            f26482a = c4;
            if (!TextUtils.isEmpty(c4)) {
                return f26482a;
            }
            String d4 = d(context);
            f26482a = d4;
            return d4;
        }

        private static String c() {
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                if (invoke instanceof String) {
                    return (String) invoke;
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        private static String d(Context context) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
            if (context == null) {
                return null;
            }
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        private static final CharSequence f26483a = "sony";

        /* renamed from: b  reason: collision with root package name */
        private static final CharSequence f26484b = "amigo";

        /* renamed from: c  reason: collision with root package name */
        private static final CharSequence f26485c = "funtouch";

        public static String a() {
            String str = Build.DISPLAY;
            return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
        }

        public static boolean b() {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.toLowerCase(Locale.getDefault()).contains("oppo");
        }

        public static String c() {
            if (q.f()) {
                return i();
            }
            if (q.c()) {
                return a();
            }
            if (b()) {
                return l();
            }
            String h4 = h();
            if (TextUtils.isEmpty(h4)) {
                if (m()) {
                    return k();
                }
                if (f()) {
                    return j();
                }
                if (o()) {
                    return n();
                }
                String e4 = e();
                return !TextUtils.isEmpty(e4) ? e4 : Build.DISPLAY;
            }
            return h4;
        }

        private static String d(String str) {
            Process exec;
            BufferedReader bufferedReader;
            String str2 = "";
            BufferedReader bufferedReader2 = null;
            try {
                Runtime runtime = Runtime.getRuntime();
                exec = runtime.exec("getprop " + str);
                bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            } catch (Throwable unused) {
            }
            try {
                str2 = bufferedReader.readLine();
                exec.destroy();
                g.a(bufferedReader);
                return str2;
            } catch (Throwable unused2) {
                bufferedReader2 = bufferedReader;
                g.a(bufferedReader2);
                return str2;
            }
        }

        public static String e() {
            if (g()) {
                return "eui_" + d("ro.letv.release.version") + "_" + Build.DISPLAY;
            }
            return "";
        }

        public static boolean f() {
            String str = Build.DISPLAY;
            return !TextUtils.isEmpty(str) && str.toLowerCase(Locale.getDefault()).contains(f26484b);
        }

        public static boolean g() {
            return !TextUtils.isEmpty(d("ro.letv.release.version"));
        }

        public static String h() {
            String a4 = q.a();
            if (a4 == null || !a4.toLowerCase(Locale.getDefault()).contains("emotionui")) {
                return "";
            }
            return a4 + "_" + Build.DISPLAY;
        }

        public static String i() {
            if (q.f()) {
                return "miui_" + d("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
            }
            return "";
        }

        public static String j() {
            return Build.DISPLAY + "_" + d("ro.gn.sv.version");
        }

        public static String k() {
            return d("ro.vivo.os.build.display.id") + "_" + d("ro.vivo.product.version");
        }

        public static String l() {
            if (b()) {
                return "coloros_" + d("ro.build.version.opporom") + "_" + Build.DISPLAY;
            }
            return "";
        }

        public static boolean m() {
            String d4 = d("ro.vivo.os.build.display.id");
            return !TextUtils.isEmpty(d4) && d4.toLowerCase(Locale.getDefault()).contains(f26485c);
        }

        public static String n() {
            return d("ro.build.uiversion") + "_" + Build.DISPLAY;
        }

        public static boolean o() {
            String str = Build.MANUFACTURER + Build.BRAND;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String lowerCase = str.toLowerCase(Locale.getDefault());
            return lowerCase.contains("360") || lowerCase.contains("qiku");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class e {

        /* renamed from: a  reason: collision with root package name */
        private static String f26486a;

        /* renamed from: b  reason: collision with root package name */
        private static Class<?> f26487b;

        /* renamed from: c  reason: collision with root package name */
        private static Field f26488c;

        /* renamed from: d  reason: collision with root package name */
        private static Field f26489d;

        /* renamed from: e  reason: collision with root package name */
        private static boolean f26490e;

        private static long a(int i4) {
            if (i4 < 0) {
                return 0L;
            }
            return i4 * 1024;
        }

        @Nullable
        public static ActivityManager.ProcessErrorStateInfo b(Context context, int i4) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            for (int i5 = 0; i5 < i4; i5++) {
                SystemClock.sleep(200L);
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2) {
                            return processErrorStateInfo;
                        }
                    }
                    continue;
                }
            }
            return null;
        }

        public static void c(@NonNull Context context, @NonNull JSONObject jSONObject) {
            try {
                d(jSONObject);
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null) {
                    k(jSONObject, activityManager);
                }
                e(jSONObject, activityManager);
            } catch (Throwable unused) {
            }
        }

        private static void d(@NonNull JSONObject jSONObject) throws JSONException {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dalvikPrivateDirty", a(memoryInfo.dalvikPrivateDirty));
            jSONObject2.put("dalvikPss", a(memoryInfo.dalvikPss));
            jSONObject2.put("dalvikSharedDirty", a(memoryInfo.dalvikSharedDirty));
            jSONObject2.put("nativePrivateDirty", a(memoryInfo.nativePrivateDirty));
            jSONObject2.put("nativePss", a(memoryInfo.nativePss));
            jSONObject2.put("nativeSharedDirty", a(memoryInfo.nativeSharedDirty));
            jSONObject2.put("otherPrivateDirty", a(memoryInfo.otherPrivateDirty));
            jSONObject2.put("otherPss", a(memoryInfo.otherPss));
            jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
            jSONObject2.put("totalPrivateClean", p.a(memoryInfo));
            jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
            jSONObject2.put("totalPss", a(memoryInfo.getTotalPss()));
            jSONObject2.put("totalSharedClean", p.b(memoryInfo));
            jSONObject2.put("totalSharedDirty", a(memoryInfo.getTotalSharedDirty()));
            jSONObject2.put("totalSwappablePss", a(p.c(memoryInfo)));
            jSONObject.put("memory_info", jSONObject2);
        }

        private static void e(@NonNull JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("native_heap_size", Debug.getNativeHeapSize());
            jSONObject2.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
            jSONObject2.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
            Runtime runtime = Runtime.getRuntime();
            jSONObject2.put("max_memory", runtime.maxMemory());
            jSONObject2.put("free_memory", runtime.freeMemory());
            jSONObject2.put("total_memory", runtime.totalMemory());
            if (activityManager != null) {
                jSONObject2.put("memory_class", activityManager.getMemoryClass());
                jSONObject2.put("large_memory_class", activityManager.getLargeMemoryClass());
            }
            jSONObject.put("app_memory_info", jSONObject2);
        }

        public static boolean f(Context context) {
            List<ActivityManager.RunningTaskInfo> runningTasks;
            ComponentName componentName;
            if (context == null) {
                return false;
            }
            String packageName = context.getPackageName();
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (componentName = runningTasks.get(0).topActivity) != null) {
                    if (packageName.equals(componentName.getPackageName())) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
            return false;
        }

        public static int g(Context context) {
            Class<?> h4 = h(context);
            if (f26489d == null && h4 != null) {
                try {
                    f26489d = h4.getDeclaredField("VERSION_CODE");
                } catch (NoSuchFieldException unused) {
                }
            }
            Field field = f26489d;
            if (field != null) {
                try {
                    return ((Integer) field.get(null)).intValue();
                } catch (Throwable unused2) {
                    return -1;
                }
            }
            return -1;
        }

        @Nullable
        private static Class<?> h(Context context) {
            if (f26487b == null && !f26490e) {
                try {
                    f26487b = Class.forName(context.getPackageName() + ".BuildConfig");
                } catch (ClassNotFoundException unused) {
                }
                f26490e = true;
            }
            return f26487b;
        }

        @Nullable
        public static String i(Context context) {
            String str = f26486a;
            if (TextUtils.isEmpty(str)) {
                try {
                    f26486a = c.b(context);
                } catch (Throwable unused) {
                }
                String str2 = f26486a;
                return str2 == null ? "" : str2;
            }
            return str;
        }

        @NonNull
        public static String j(Context context) {
            Class<?> h4 = h(context);
            if (f26488c == null && h4 != null) {
                try {
                    f26488c = h4.getDeclaredField("VERSION_NAME");
                } catch (NoSuchFieldException unused) {
                }
            }
            Field field = f26488c;
            if (field != null) {
                try {
                    return (String) field.get(null);
                } catch (Throwable unused2) {
                    return "";
                }
            }
            return "";
        }

        private static void k(@NonNull JSONObject jSONObject, ActivityManager activityManager) throws JSONException {
            JSONObject jSONObject2 = new JSONObject();
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            jSONObject2.put("availMem", memoryInfo.availMem);
            jSONObject2.put("lowMemory", memoryInfo.lowMemory);
            jSONObject2.put("threshold", memoryInfo.threshold);
            jSONObject2.put("totalMem", l.a(memoryInfo));
            jSONObject.put("sys_memory_info", jSONObject2);
        }

        public static boolean l(Context context) {
            String i4 = i(context);
            if (i4 == null || !i4.contains(":")) {
                if (i4 == null || !i4.equals(context.getPackageName())) {
                    return i4 != null && i4.equals(context.getApplicationInfo().processName);
                }
                return true;
            }
            return false;
        }

        public static boolean m(Context context) {
            return false;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class f {
        public static File a(@NonNull Context context) {
            return new File(e(context), "CrashLogJava");
        }

        public static String b() {
            return String.format("java_%s.npth", String.valueOf(System.nanoTime()));
        }

        public static File c(@NonNull Context context) {
            return new File(e(context), "crash_history");
        }

        public static String d() {
            return String.format("anr_%s.npth", String.valueOf(System.nanoTime()));
        }

        @SuppressLint({"SdCardPath"})
        private static String e(@NonNull Context context) {
            String path;
            try {
                if (w.c(context) != null) {
                    path = w.c(context).getPath();
                } else {
                    File c4 = w.c(context, "/data/data/" + context.getPackageName() + "/files/", 0);
                    path = c4 != null ? c4.getPath() : null;
                }
                return path != null ? path : "/sdcard/";
            } catch (Exception e4) {
                e4.printStackTrace();
                return "/sdcard/";
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class g {
        public static void a(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class h {
        public static Thread a(Runnable runnable) {
            return b(runnable, null);
        }

        public static Thread b(Runnable runnable, String str) {
            com.bytedance.sdk.component.gd.sr.xv xvVar;
            if (runnable != null) {
                if (str == null) {
                    xvVar = new com.bytedance.sdk.component.gd.sr.xv(runnable, "hreadExecutor");
                } else {
                    xvVar = new com.bytedance.sdk.component.gd.sr.xv(runnable, str);
                }
                xvVar.start();
                return xvVar;
            }
            return null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class i {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ int[] f26491a;

            static {
                int[] iArr = new int[w.EnumC0374w.values().length];
                f26491a = iArr;
                try {
                    iArr[w.EnumC0374w.WIFI.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    f26491a[w.EnumC0374w.MOBILE_2G.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    f26491a[w.EnumC0374w.MOBILE_3G.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    f26491a[w.EnumC0374w.MOBILE_4G.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    f26491a[w.EnumC0374w.MOBILE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
            }
        }

        public static String a(Context context) {
            return b(d(context));
        }

        public static String b(w.EnumC0374w enumC0374w) {
            String str;
            try {
                int i4 = a.f26491a[enumC0374w.ordinal()];
                if (i4 == 1) {
                    str = "wifi";
                } else if (i4 == 2) {
                    str = "2g";
                } else if (i4 == 3) {
                    str = "3g";
                } else if (i4 == 4) {
                    str = "4g";
                } else if (i4 != 5) {
                    return "";
                } else {
                    str = "mobile";
                }
                return str;
            } catch (Exception unused) {
                return "";
            }
        }

        public static boolean c(Context context) {
            NetworkInfo activeNetworkInfo;
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                    return false;
                }
                return activeNetworkInfo.isAvailable();
            } catch (Exception unused) {
                return false;
            }
        }

        private static w.EnumC0374w d(Context context) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return w.EnumC0374w.NONE;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    int type = activeNetworkInfo.getType();
                    if (1 == type) {
                        return w.EnumC0374w.WIFI;
                    }
                    if (type == 0) {
                        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                return w.EnumC0374w.MOBILE_3G;
                            case 4:
                            case 7:
                            case 11:
                            default:
                                return w.EnumC0374w.MOBILE;
                            case 13:
                                return w.EnumC0374w.MOBILE_4G;
                        }
                    }
                    return w.EnumC0374w.MOBILE;
                }
                return w.EnumC0374w.NONE;
            } catch (Throwable unused) {
                return w.EnumC0374w.MOBILE;
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class j {
        public static String a(String str) {
            Map<String, Object> a4;
            if (com.bytedance.c.w.d.a() == null || (a4 = com.bytedance.c.w.d.a().a()) == null) {
                return null;
            }
            Object obj = a4.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        public static void b(com.bytedance.c.w.xv.a aVar, com.bytedance.c.w.xv.b bVar, xv xvVar) {
            if (aVar == null || aVar.j() == null || xvVar == null) {
                return;
            }
            JSONObject j4 = aVar.j();
            long optLong = j4.optLong("crash_time");
            int c4 = c(a("aid"));
            String a4 = com.bytedance.c.w.d.l().a();
            if (optLong <= 0 || c4 <= 0 || TextUtils.isEmpty(a4) || "0".equals(a4) || TextUtils.isEmpty(xvVar.c())) {
                return;
            }
            try {
                String str = "android_" + c4 + "_" + a4 + "_" + optLong + "_" + xvVar;
                if (bVar != null) {
                    JSONObject b4 = bVar.b();
                    if (b4 != null) {
                        b4.put("unique_key", str);
                    }
                } else {
                    j4.put("unique_key", str);
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }

        public static int c(String str) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e4) {
                k.c(e4);
                return 0;
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class k {
        public static void a(String str) {
            if (com.bytedance.c.w.d.j().b()) {
                Log.i("npth", str);
            }
        }

        public static void b(Throwable th) {
            if (com.bytedance.c.w.d.j().b()) {
                Log.e("npth", "NPTH Catch Error", th);
            }
        }

        public static void c(Throwable th) {
            if (com.bytedance.c.w.d.j().b()) {
                Log.w("npth", "NPTH Catch Error", th);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class l {

        /* renamed from: a  reason: collision with root package name */
        static final C0370b f26492a = new c();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bytedance.c.w.b$l$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class C0370b {
            private C0370b() {
            }

            public long a(ActivityManager.MemoryInfo memoryInfo) {
                return 0L;
            }
        }

        @TargetApi(16)
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        private static class c extends C0370b {
            private c() {
                super();
            }

            @Override // com.bytedance.c.w.b.l.C0370b
            public long a(ActivityManager.MemoryInfo memoryInfo) {
                return memoryInfo.totalMem;
            }
        }

        public static long a(ActivityManager.MemoryInfo memoryInfo) {
            return f26492a.a(memoryInfo);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class m {
        public static String a(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z3) {
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("url", str2);
                jSONObject2.put("body", jSONObject);
                if (str3 == null) {
                    str3 = "";
                }
                jSONObject2.put("dump_file", str3);
                jSONObject2.put(AdLogEventRepo.COL_ENCRYPT_TYPE, z3);
                e(file2, jSONObject2.toString(), false);
            } catch (IOException e4) {
                e4.printStackTrace();
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            return file2.getAbsolutePath();
        }

        public static String b(File file, String str, String str2, JSONObject jSONObject, boolean z3) {
            return a(file, str, str2, jSONObject, null, z3);
        }

        public static String c(String str, String str2) throws IOException {
            BufferedReader bufferedReader = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                            if (str2 != null) {
                                sb.append(str2);
                            }
                        } else {
                            g.a(bufferedReader2);
                            return sb.toString();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        g.a(bufferedReader);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public static void d(Context context, String str, String str2) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                sb.append(" ");
                if (str == null) {
                    str = "null";
                }
                sb.append(str);
                sb.append(" ");
                if (str2 == null) {
                    str2 = "null";
                }
                sb.append(str2);
                sb.append("\n");
                e(f.c(context), sb.toString(), true);
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }

        public static void e(@NonNull File file, @NonNull String str, boolean z3) throws IOException {
            FileOutputStream fileOutputStream;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            file.getParentFile().mkdirs();
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(file, z3);
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                g.a(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                g.a(fileOutputStream2);
                throw th;
            }
        }

        public static boolean f(File file) {
            return file.exists() && file.delete();
        }

        public static boolean g(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            return file.exists() && file.delete();
        }

        public static String h(String str) throws IOException {
            return c(str, null);
        }

        public static com.bytedance.c.w.xv.c i(String str) {
            try {
                JSONObject jSONObject = new JSONObject(h(str));
                com.bytedance.c.w.xv.c cVar = new com.bytedance.c.w.xv.c();
                cVar.b(jSONObject.optString("url"));
                cVar.c(jSONObject.optJSONObject("body"));
                cVar.f(jSONObject.optString("dump_file"));
                cVar.d(jSONObject.optBoolean(AdLogEventRepo.COL_ENCRYPT_TYPE, false));
                return cVar;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class n {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private final PrintWriter f26493a;

            a(PrintWriter printWriter) {
                this.f26493a = printWriter;
            }

            Object a() {
                return this.f26493a;
            }

            void b(Object obj) {
                this.f26493a.println(obj);
            }
        }

        @NonNull
        public static String a(@NonNull Throwable th) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            try {
                if (i(th)) {
                    f(th, printWriter);
                } else {
                    th.printStackTrace(printWriter);
                }
                return stringWriter.toString();
            } catch (Exception unused) {
                return "";
            } finally {
                printWriter.close();
            }
        }

        public static String b(StackTraceElement[] stackTraceElementArr) {
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                c(stackTraceElement, sb);
            }
            return sb.toString();
        }

        public static StringBuilder c(StackTraceElement stackTraceElement, StringBuilder sb) {
            String className = stackTraceElement.getClassName();
            sb.append("  at ");
            sb.append(className);
            sb.append(".");
            sb.append(stackTraceElement.getMethodName());
            sb.append("(");
            sb.append(stackTraceElement.getFileName());
            sb.append(":");
            sb.append(stackTraceElement.getLineNumber());
            sb.append(")\n");
            return sb;
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x00d5 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0029 A[SYNTHETIC] */
        @androidx.annotation.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static org.json.JSONObject d(java.lang.String r16) {
            /*
                r0 = r16
                java.lang.String r1 = ")"
                java.lang.String r2 = "("
                r3 = 0
                java.util.Map r4 = java.lang.Thread.getAllStackTraces()     // Catch: java.lang.Throwable -> Le0
                org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Le0
                r5.<init>()     // Catch: java.lang.Throwable -> Le0
                if (r4 != 0) goto L13
                return r3
            L13:
                java.lang.String r6 = "thread_all_count"
                int r7 = r4.size()     // Catch: java.lang.Throwable -> Le0
                r5.put(r6, r7)     // Catch: java.lang.Throwable -> Le0
                org.json.JSONArray r6 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Le0
                r6.<init>()     // Catch: java.lang.Throwable -> Le0
                java.util.Set r4 = r4.entrySet()     // Catch: java.lang.Throwable -> Le0
                java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> Le0
            L29:
                boolean r7 = r4.hasNext()     // Catch: java.lang.Throwable -> Le0
                if (r7 == 0) goto Lda
                java.lang.Object r7 = r4.next()     // Catch: java.lang.Throwable -> Le0
                java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch: java.lang.Throwable -> Le0
                org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Le0
                r8.<init>()     // Catch: java.lang.Throwable -> Le0
                java.lang.Object r9 = r7.getKey()     // Catch: java.lang.Throwable -> Le0
                java.lang.Thread r9 = (java.lang.Thread) r9     // Catch: java.lang.Throwable -> Le0
                java.lang.String r10 = r9.getName()     // Catch: java.lang.Throwable -> Le0
                boolean r11 = g(r10)     // Catch: java.lang.Throwable -> Le0
                if (r11 != 0) goto L29
                if (r0 == 0) goto L5f
                boolean r11 = r0.equals(r10)     // Catch: java.lang.Throwable -> Le0
                if (r11 != 0) goto L29
                boolean r11 = r10.startsWith(r0)     // Catch: java.lang.Throwable -> Le0
                if (r11 != 0) goto L29
                boolean r10 = r10.endsWith(r0)     // Catch: java.lang.Throwable -> Le0
                if (r10 == 0) goto L5f
                goto L29
            L5f:
                java.lang.String r10 = "thread_name"
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le0
                r11.<init>()     // Catch: java.lang.Throwable -> Le0
                java.lang.String r12 = r9.getName()     // Catch: java.lang.Throwable -> Le0
                r11.append(r12)     // Catch: java.lang.Throwable -> Le0
                r11.append(r2)     // Catch: java.lang.Throwable -> Le0
                long r12 = r9.getId()     // Catch: java.lang.Throwable -> Le0
                r11.append(r12)     // Catch: java.lang.Throwable -> Le0
                r11.append(r1)     // Catch: java.lang.Throwable -> Le0
                java.lang.String r9 = r11.toString()     // Catch: java.lang.Throwable -> Le0
                r8.put(r10, r9)     // Catch: java.lang.Throwable -> Le0
                java.lang.Object r7 = r7.getValue()     // Catch: java.lang.Throwable -> Le0
                java.lang.StackTraceElement[] r7 = (java.lang.StackTraceElement[]) r7     // Catch: java.lang.Throwable -> Le0
                if (r7 == 0) goto Ld2
                org.json.JSONArray r10 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Le0
                r10.<init>()     // Catch: java.lang.Throwable -> Le0
                int r11 = r7.length     // Catch: java.lang.Throwable -> Le0
                r12 = 0
                r13 = 0
            L91:
                if (r13 >= r11) goto Lc4
                r14 = r7[r13]     // Catch: java.lang.Throwable -> Le0
                java.lang.String r15 = r14.getClassName()     // Catch: java.lang.Throwable -> Le0
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le0
                r9.<init>()     // Catch: java.lang.Throwable -> Le0
                r9.append(r15)     // Catch: java.lang.Throwable -> Le0
                java.lang.String r15 = "."
                r9.append(r15)     // Catch: java.lang.Throwable -> Le0
                java.lang.String r15 = r14.getMethodName()     // Catch: java.lang.Throwable -> Le0
                r9.append(r15)     // Catch: java.lang.Throwable -> Le0
                r9.append(r2)     // Catch: java.lang.Throwable -> Le0
                int r14 = r14.getLineNumber()     // Catch: java.lang.Throwable -> Le0
                r9.append(r14)     // Catch: java.lang.Throwable -> Le0
                r9.append(r1)     // Catch: java.lang.Throwable -> Le0
                java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Le0
                r10.put(r9)     // Catch: java.lang.Throwable -> Le0
                int r13 = r13 + 1
                goto L91
            Lc4:
                java.lang.String r7 = "thread_stack"
                r8.put(r7, r10)     // Catch: java.lang.Throwable -> Le0
                int r7 = r10.length()     // Catch: java.lang.Throwable -> Le0
                if (r7 <= 0) goto Ld0
                goto Ld2
            Ld0:
                r9 = 0
                goto Ld3
            Ld2:
                r9 = 1
            Ld3:
                if (r9 == 0) goto L29
                r6.put(r8)     // Catch: java.lang.Throwable -> Le0
                goto L29
            Lda:
                java.lang.String r0 = "thread_stacks"
                r5.put(r0, r6)     // Catch: java.lang.Throwable -> Le0
                return r5
            Le0:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.c.w.b.n.d(java.lang.String):org.json.JSONObject");
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static void e(Throwable th, a aVar, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set) {
            if (set.contains(th)) {
                aVar.b("\t[CIRCULAR REFERENCE:" + th + "]");
                return;
            }
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            int min = Math.min(stackTrace.length, 256);
            int i4 = min - 1;
            int i5 = i4;
            for (int min2 = Math.min(stackTraceElementArr.length, 256) - 1; i5 >= 0 && min2 >= 0 && stackTrace[i5].equals(stackTraceElementArr[min2]); min2--) {
                i5--;
            }
            int i6 = i4 - i5;
            aVar.b(str2 + str + th);
            for (int i7 = 0; i7 <= i5; i7++) {
                aVar.b(str2 + "\tat " + stackTrace[i7]);
            }
            if (min < stackTrace.length) {
                aVar.b("\t... skip " + (stackTrace.length - min) + " lines");
            }
            if (i6 != 0) {
                aVar.b(str2 + "\t... " + i6 + " more");
            }
            int i8 = Build.VERSION.SDK_INT;
            Throwable cause = th.getCause();
            if (cause != null) {
                e(cause, aVar, stackTrace, "Caused by: ", str2, set);
            }
        }

        private static void f(Throwable th, PrintWriter printWriter) {
            if (th == null || printWriter == null) {
                return;
            }
            a aVar = new a(printWriter);
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            newSetFromMap.add(th);
            synchronized (aVar.a()) {
                aVar.b(th);
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i4];
                    if (i5 > 256) {
                        aVar.b("\t... skip " + (stackTrace.length - i5) + " lines");
                        break;
                    }
                    aVar.b("\tat " + stackTraceElement);
                    i5++;
                    i4++;
                }
                int i6 = Build.VERSION.SDK_INT;
                Throwable cause = th.getCause();
                if (cause != null) {
                    e(cause, aVar, stackTrace, "Caused by: ", "", newSetFromMap);
                }
            }
        }

        private static boolean g(String str) {
            Set<String> a4 = o.a();
            if (a4.contains(str)) {
                return true;
            }
            for (String str2 : a4) {
                if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean h(Throwable th) {
            if (th == null) {
                return false;
            }
            int i4 = 0;
            while (th != null) {
                try {
                    if (th instanceof OutOfMemoryError) {
                        return true;
                    }
                    if (i4 > 20) {
                        return false;
                    }
                    i4++;
                    th = th.getCause();
                } catch (Throwable unused) {
                }
            }
            return false;
        }

        private static boolean i(Throwable th) {
            int i4 = 0;
            while (th != null) {
                if (th instanceof StackOverflowError) {
                    return true;
                }
                if (i4 > 20) {
                    return false;
                }
                th = th.getCause();
                i4++;
            }
            return false;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class o {

        /* renamed from: a  reason: collision with root package name */
        private static final Set<String> f26494a;

        static {
            HashSet hashSet = new HashSet();
            f26494a = hashSet;
            hashSet.add("HeapTaskDaemon");
            hashSet.add("ThreadPlus");
            hashSet.add("ApiDispatcher");
            hashSet.add("ApiLocalDispatcher");
            hashSet.add("AsyncLoader");
            hashSet.add("AsyncTask");
            hashSet.add("Binder");
            hashSet.add("PackageProcessor");
            hashSet.add("SettingsObserver");
            hashSet.add("WifiManager");
            hashSet.add("JavaBridge");
            hashSet.add("Compiler");
            hashSet.add("Signal Catcher");
            hashSet.add("GC");
            hashSet.add("ReferenceQueueDaemon");
            hashSet.add("FinalizerDaemon");
            hashSet.add("FinalizerWatchdogDaemon");
            hashSet.add("CookieSyncManager");
            hashSet.add("RefQueueWorker");
            hashSet.add("CleanupReference");
            hashSet.add("VideoManager");
            hashSet.add("DBHelper-AsyncOp");
            hashSet.add("InstalledAppTracker2");
            hashSet.add("AppData-AsyncOp");
            hashSet.add("IdleConnectionMonitor");
            hashSet.add("LogReaper");
            hashSet.add("ActionReaper");
            hashSet.add("Okio Watchdog");
            hashSet.add("CheckWaitingQueue");
            hashSet.add("NPTH-CrashTimer");
            hashSet.add("NPTH-JavaCallback");
            hashSet.add("NPTH-LocalParser");
            hashSet.add("ANR_FILE_MODIFY");
        }

        public static Set<String> a() {
            return f26494a;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class p {

        /* renamed from: a  reason: collision with root package name */
        static final C0371b f26495a;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bytedance.c.w.b$p$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class C0371b {
            private C0371b() {
            }

            public int a(Debug.MemoryInfo memoryInfo) {
                return -1;
            }

            public int b(Debug.MemoryInfo memoryInfo) {
                return -1;
            }

            public int c(Debug.MemoryInfo memoryInfo) {
                return -1;
            }
        }

        @TargetApi(19)
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        private static class c extends C0371b {
            private c() {
                super();
            }

            @Override // com.bytedance.c.w.b.p.C0371b
            public int a(Debug.MemoryInfo memoryInfo) {
                return memoryInfo.getTotalPrivateClean();
            }

            @Override // com.bytedance.c.w.b.p.C0371b
            public int b(Debug.MemoryInfo memoryInfo) {
                return memoryInfo.getTotalSharedClean();
            }

            @Override // com.bytedance.c.w.b.p.C0371b
            public int c(Debug.MemoryInfo memoryInfo) {
                return memoryInfo.getTotalSwappablePss();
            }
        }

        static {
            if (Build.VERSION.SDK_INT >= 19) {
                f26495a = new c();
            } else {
                f26495a = new C0371b();
            }
        }

        public static int a(Debug.MemoryInfo memoryInfo) {
            return f26495a.a(memoryInfo);
        }

        public static int b(Debug.MemoryInfo memoryInfo) {
            return f26495a.b(memoryInfo);
        }

        public static int c(Debug.MemoryInfo memoryInfo) {
            return f26495a.c(memoryInfo);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class q {

        /* renamed from: a  reason: collision with root package name */
        private static boolean f26496a;

        public static String a() {
            return d("ro.build.version.emui");
        }

        public static boolean b(String str) {
            if (TextUtils.isEmpty(str)) {
                str = a();
            }
            if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
                return e();
            }
            return true;
        }

        public static boolean c() {
            return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
        }

        private static String d(String str) {
            BufferedReader bufferedReader;
            String str2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    str2 = bufferedReader.readLine();
                    bufferedReader.close();
                    g.a(bufferedReader);
                    return str2;
                } catch (Throwable unused) {
                    g.a(bufferedReader);
                    return str2;
                }
            } catch (Throwable unused2) {
                bufferedReader = null;
            }
        }

        public static boolean e() {
            try {
                String str = Build.BRAND;
                if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                    String str2 = Build.MANUFACTURER;
                    if (TextUtils.isEmpty(str2)) {
                        return false;
                    }
                    if (!str2.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }

        public static boolean f() {
            if (!f26496a) {
                try {
                    Class.forName("miui.os.Build");
                    com.bytedance.c.w.r.w.f26556a = true;
                    f26496a = true;
                    return true;
                } catch (Exception unused) {
                    f26496a = true;
                }
            }
            return com.bytedance.c.w.r.w.f26556a;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class r {
        public static long a(File file) {
            try {
                StatFs statFs = new StatFs(file.getPath());
                if (Build.VERSION.SDK_INT >= 18) {
                    return statFs.getTotalBytes();
                }
                return statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Throwable unused) {
                return 0L;
            }
        }

        public static JSONObject b(Context context) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("inner_app_used", g(context));
                jSONObject.put("inner_free", f());
                jSONObject.put("inner_total", i());
                jSONObject.put("sdcard_app_used", j(context));
                jSONObject.put("sdcard_free", d());
                jSONObject.put("sdcard_total", e());
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public static boolean c() {
            return "mounted".equals(Environment.getExternalStorageState());
        }

        private static long d() {
            try {
                if (c()) {
                    return Environment.getExternalStorageDirectory().getFreeSpace();
                }
                return 0L;
            } catch (Exception unused) {
                return 0L;
            }
        }

        private static long e() {
            try {
                if (c()) {
                    return Environment.getExternalStorageDirectory().getTotalSpace();
                }
                return 0L;
            } catch (Exception unused) {
                return 0L;
            }
        }

        private static long f() {
            try {
                return h(Environment.getRootDirectory());
            } catch (Exception unused) {
                return 0L;
            }
        }

        private static long g(Context context) {
            try {
                return k(com.bytedance.sdk.openadsdk.api.plugin.w.c(context).getParentFile());
            } catch (Exception unused) {
                return 0L;
            }
        }

        public static long h(File file) {
            try {
                StatFs statFs = new StatFs(file.getPath());
                if (Build.VERSION.SDK_INT >= 18) {
                    return statFs.getFreeBytes();
                }
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Throwable unused) {
                return 0L;
            }
        }

        private static long i() {
            try {
                return a(Environment.getRootDirectory());
            } catch (Exception unused) {
                return 0L;
            }
        }

        private static long j(Context context) {
            File c4;
            try {
                if (!c() || (c4 = com.bytedance.sdk.openadsdk.api.plugin.w.c(context, null)) == null) {
                    return 0L;
                }
                return k(c4.getParentFile());
            } catch (Exception unused) {
                return 0L;
            }
        }

        public static long k(File file) {
            long length;
            File[] listFiles = file.listFiles();
            long j4 = 0;
            if (listFiles == null) {
                return 0L;
            }
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    length = k(file2);
                } else {
                    length = file2.length();
                }
                j4 += length;
            }
            return j4;
        }
    }

    public static synchronized void a(@NonNull Context context, @NonNull com.bytedance.c.w.g gVar, boolean z3, boolean z4) {
        synchronized (b.class) {
            b(context, gVar, z3, false, z4);
        }
    }

    public static synchronized void b(@NonNull Context context, @NonNull com.bytedance.c.w.g gVar, boolean z3, boolean z4, boolean z5) {
        synchronized (b.class) {
            c(context, gVar, z3, z3, z4, z5);
        }
    }

    public static synchronized void c(@NonNull Context context, @NonNull com.bytedance.c.w.g gVar, boolean z3, boolean z4, boolean z5, boolean z6) {
        synchronized (b.class) {
            if (f26475a) {
                return;
            }
            if (context == null) {
                throw new IllegalArgumentException("context must be not null.");
            }
            if (gVar != null) {
                if (!(context instanceof Application)) {
                    context = StubApp.getOrigApplicationContext(context.getApplicationContext());
                }
                if (e.m(context)) {
                    return;
                }
                com.bytedance.c.w.d.b(context, gVar);
                com.bytedance.c.w.ux.c.e.d(context);
                if (z3 || z4) {
                    com.bytedance.c.w.sr.a a4 = com.bytedance.c.w.sr.a.a();
                    if (z3) {
                        a4.b(new com.bytedance.c.w.sr.c(context));
                    }
                    f26476b = true;
                }
                f26478d = z5;
                f26475a = true;
                f26477c = z6;
                com.bytedance.c.w.ux.d.b().post(new a(context, z6));
                return;
            }
            throw new IllegalArgumentException("params must be not null.");
        }
    }

    public static void d(com.bytedance.c.c.b bVar) {
        com.bytedance.c.w.ux.d.b().post(new RunnableC0369b(bVar));
    }

    public static void e(com.bytedance.c.w.e eVar) {
        com.bytedance.c.w.d.k().c(eVar);
    }

    @Deprecated
    public static void f(String str) {
        if (com.bytedance.c.w.d.j().a()) {
            com.bytedance.c.w.sr.a.c(str);
        }
    }

    public static void g(Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        com.bytedance.c.w.d.k().d(map);
    }
}
