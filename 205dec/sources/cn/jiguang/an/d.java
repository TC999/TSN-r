package cn.jiguang.an;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import cn.jiguang.an.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class d {

    /* renamed from: cn.jiguang.an.d$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2315a;

        static {
            int[] iArr = new int[a.EnumC0051a.values().length];
            f2315a = iArr;
            try {
                iArr[a.EnumC0051a.NOT_CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2315a[a.EnumC0051a.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static StatFs a(File file, Context context) {
        String str;
        if (e()) {
            str = "External storage is not mounted or emulated.";
        } else {
            File b4 = b(file, context);
            if (b4 != null) {
                return new StatFs(b4.getPath());
            }
            str = "Not possible to read external files directory";
        }
        cn.jiguang.w.a.e("SentryUtils", str);
        return null;
    }

    private static Float a(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("level", -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra != -1 && intExtra2 != -1) {
                return Float.valueOf((intExtra / intExtra2) * 100.0f);
            }
            return null;
        } catch (Exception e4) {
            cn.jiguang.w.a.a("SentryUtils", "Error getting device battery level.", e4);
            return null;
        }
    }

    private static Long a(ActivityManager.MemoryInfo memoryInfo) {
        return Long.valueOf(memoryInfo.totalMem);
    }

    private static Long a(StatFs statFs) {
        try {
            return Long.valueOf(d(statFs) * b(statFs));
        } catch (Exception e4) {
            cn.jiguang.w.a.a("SentryUtils", "Error getting total internal storage amount.", e4);
            return null;
        }
    }

    private static Date a() {
        try {
            return cn.jiguang.ag.b.a(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        } catch (IllegalArgumentException e4) {
            cn.jiguang.w.a.a("SentryUtils", "Error getting the device's boot time.", e4);
            return null;
        }
    }

    public static JSONObject a(Context context) {
        StatFs a4;
        ActivityManager.MemoryInfo d4;
        try {
            JSONObject jSONObject = new JSONObject();
            if (cn.jiguang.ar.a.a().e(1005)) {
                jSONObject.put("archs", d());
            }
            jSONObject.put("name", c(context));
            if (cn.jiguang.ar.a.a().e(1011)) {
                jSONObject.put("manufacturer", cn.jiguang.ag.a.t(context));
            }
            if (cn.jiguang.ar.a.a().e(1002)) {
                jSONObject.put("brand", cn.jiguang.ag.a.r(context));
            }
            jSONObject.put("family", f(context));
            if (cn.jiguang.ar.a.a().e(1013)) {
                jSONObject.put("model", cn.jiguang.ag.a.p(context));
            }
            jSONObject.put("model_id", Build.ID);
            Intent e4 = e(context);
            if (e4 != null) {
                jSONObject.put("battery_level", a(e4));
                jSONObject.put("charging", b(e4));
                jSONObject.put("battery_temperature", c(e4));
            }
            int i4 = AnonymousClass1.f2315a[a.a(context).ordinal()];
            jSONObject.put("online", i4 != 1 ? i4 != 2 ? null : Boolean.TRUE : Boolean.FALSE);
            jSONObject.put("orientation", g(context));
            jSONObject.put("simulator", h(context));
            if (cn.jiguang.ar.a.a().e(1016) && (d4 = d(context)) != null) {
                jSONObject.put("memory_size", a(d4));
                jSONObject.put("free_memory", d4.availMem);
                jSONObject.put("low_memory", d4.lowMemory);
            }
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                StatFs statFs = new StatFs(externalFilesDir.getPath());
                jSONObject.put("storage_size", a(statFs));
                jSONObject.put("free_storage", h(statFs));
            }
            if (cn.jiguang.ar.a.a().e(1018) && (a4 = a(externalFilesDir, context)) != null) {
                jSONObject.put("external_storage_size", i(a4));
                jSONObject.put("external_free_storage", j(a4));
            }
            if (cn.jiguang.ar.a.a().e(1017)) {
                String c4 = cn.jiguang.ag.a.c(context);
                if (!TextUtils.isEmpty(c4)) {
                    String[] split = c4.split("\\*");
                    try {
                        jSONObject.put("screen_width_pixels", split[0]);
                        jSONObject.put("screen_height_pixels", split[1]);
                    } catch (Throwable unused) {
                    }
                }
                DisplayMetrics j4 = j(context);
                if (j4 != null) {
                    jSONObject.put("screen_density", j4.density);
                    jSONObject.put("screen_dpi", j4.densityDpi);
                }
            }
            jSONObject.put("boot_time", a());
            if (cn.jiguang.ar.a.a().e(1026)) {
                jSONObject.put("timezone", cn.jiguang.ag.a.u(context));
            }
            if (cn.jiguang.ar.a.a().e(1001)) {
                jSONObject.put("id", cn.jiguang.h.a.f(context));
            }
            if (cn.jiguang.ar.a.a().e(1009)) {
                jSONObject.put("language", cn.jiguang.ag.a.s(context));
            }
            jSONObject.put("connection_type", a.b(context));
            return jSONObject;
        } catch (JSONException e5) {
            cn.jiguang.w.a.a("SentryUtils", "Error getting Device.", e5);
            return null;
        }
    }

    private static long b(StatFs statFs) {
        return Build.VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() : c(statFs);
    }

    private static File b(File file, Context context) {
        File[] i4 = i(context);
        if (i4 != null) {
            String absolutePath = file != null ? file.getAbsolutePath() : null;
            for (File file2 : i4) {
                if (file2 != null && (absolutePath == null || absolutePath.isEmpty() || !file2.getAbsolutePath().contains(absolutePath))) {
                    return file2;
                }
            }
        } else {
            cn.jiguang.w.a.e("SentryUtils", "Not possible to read getExternalFilesDirs");
        }
        return null;
    }

    private static Boolean b(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("plugged", -1);
            boolean z3 = true;
            if (intExtra != 1 && intExtra != 2) {
                z3 = false;
            }
            return Boolean.valueOf(z3);
        } catch (Exception e4) {
            cn.jiguang.w.a.a("SentryUtils", "Error getting device charging state.", e4);
            return null;
        }
    }

    private static String b() {
        return Build.CPU_ABI;
    }

    public static JSONObject b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("build", Build.DISPLAY);
            jSONObject.put("kernel_version", f());
            jSONObject.put("name", "Android");
            jSONObject.put("rooted", cn.jiguang.ag.a.h(context));
            if (cn.jiguang.ar.a.a().e(1014)) {
                jSONObject.put("version", cn.jiguang.ag.a.v(context));
            }
            return jSONObject;
        } catch (JSONException e4) {
            cn.jiguang.w.a.a("SentryUtils", "Error getting OperatingSystem.", e4);
            return null;
        }
    }

    private static int c(StatFs statFs) {
        return statFs.getBlockSize();
    }

    private static Float c(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("temperature", -1);
            if (intExtra != -1) {
                return Float.valueOf(intExtra / 10.0f);
            }
            return null;
        } catch (Exception e4) {
            cn.jiguang.w.a.a("SentryUtils", "Error getting battery temperature.", e4);
            return null;
        }
    }

    private static String c() {
        return Build.CPU_ABI2;
    }

    private static String c(Context context) {
        return Settings.Global.getString(context.getContentResolver(), "device_name");
    }

    private static long d(StatFs statFs) {
        return Build.VERSION.SDK_INT >= 18 ? statFs.getBlockCountLong() : e(statFs);
    }

    private static ActivityManager.MemoryInfo d(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            cn.jiguang.w.a.b("SentryUtils", "Error getting MemoryInfo.");
            return null;
        } catch (Exception e4) {
            cn.jiguang.w.a.a("SentryUtils", "Error getting MemoryInfo.", e4);
            return null;
        }
    }

    private static JSONArray d() {
        JSONArray jSONArray = new JSONArray();
        for (String str : Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{b(), c()}) {
            jSONArray.put(str);
        }
        return jSONArray;
    }

    private static int e(StatFs statFs) {
        return statFs.getBlockCount();
    }

    private static Intent e(Context context) {
        return cn.jiguang.ap.a.a(context, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    @TargetApi(11)
    private static boolean e() {
        String externalStorageState = Environment.getExternalStorageState();
        return ("mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) && !Environment.isExternalStorageEmulated();
    }

    private static long f(StatFs statFs) {
        return Build.VERSION.SDK_INT >= 18 ? statFs.getAvailableBlocksLong() : g(statFs);
    }

    @TargetApi(19)
    private static String f() {
        String property = System.getProperty("os.version");
        File file = new File("/proc/version");
        if (file.canRead()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                return readLine;
            } catch (IOException e4) {
                cn.jiguang.w.a.a("SentryUtils", "Exception while attempting to read kernel information", e4);
                return property;
            }
        }
        return property;
    }

    private static String f(Context context) {
        try {
            String p3 = cn.jiguang.ag.a.p(context);
            if (TextUtils.isEmpty(p3)) {
                return null;
            }
            return p3.split(" ", -1)[0];
        } catch (Exception e4) {
            cn.jiguang.w.a.a("SentryUtils", "Error getting device family.", e4);
            return null;
        }
    }

    private static int g(StatFs statFs) {
        return statFs.getAvailableBlocks();
    }

    private static cn.jiguang.am.a g(Context context) {
        Exception e4;
        cn.jiguang.am.a aVar;
        try {
            aVar = b.a(context.getResources().getConfiguration().orientation);
            if (aVar == null) {
                try {
                    cn.jiguang.w.a.e("SentryUtils", "No device orientation available (ORIENTATION_SQUARE|ORIENTATION_UNDEFINED)");
                    return null;
                } catch (Exception e5) {
                    e4 = e5;
                    cn.jiguang.w.a.a("SentryUtils", "Error getting device orientation.", e4);
                    return aVar;
                }
            }
        } catch (Exception e6) {
            e4 = e6;
            aVar = null;
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Boolean h(android.content.Context r6) {
        /*
            java.lang.String r0 = "generic"
            java.lang.String r1 = android.os.Build.BRAND     // Catch: java.lang.Exception -> Lc5
            boolean r1 = r1.startsWith(r0)     // Catch: java.lang.Exception -> Lc5
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L14
            java.lang.String r1 = android.os.Build.DEVICE     // Catch: java.lang.Exception -> Lc5
            boolean r1 = r1.startsWith(r0)     // Catch: java.lang.Exception -> Lc5
            if (r1 != 0) goto L3a
        L14:
            java.lang.String r1 = android.os.Build.FINGERPRINT     // Catch: java.lang.Exception -> Lc5
            boolean r0 = r1.startsWith(r0)     // Catch: java.lang.Exception -> Lc5
            if (r0 != 0) goto L3a
            java.lang.String r0 = "unknown"
            boolean r0 = r1.startsWith(r0)     // Catch: java.lang.Exception -> Lc5
            if (r0 != 0) goto L3a
            java.lang.String r0 = android.os.Build.HARDWARE     // Catch: java.lang.Exception -> Lc5
            java.lang.String r1 = "goldfish"
            boolean r1 = r0.contains(r1)     // Catch: java.lang.Exception -> Lc5
            if (r1 != 0) goto L3a
            java.lang.String r1 = "ranchu"
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Exception -> Lc5
            if (r0 == 0) goto L38
            goto L3a
        L38:
            r0 = 0
            goto L3b
        L3a:
            r0 = 1
        L3b:
            java.lang.String r1 = cn.jiguang.ag.a.n(r6)     // Catch: java.lang.Exception -> Lc5
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> Lc5
            java.lang.String r5 = "google_sdk"
            if (r4 != 0) goto L84
            if (r0 != 0) goto L83
            java.lang.String r0 = "sdk_google"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Exception -> Lc5
            if (r0 != 0) goto L83
            boolean r0 = r1.contains(r5)     // Catch: java.lang.Exception -> Lc5
            if (r0 != 0) goto L83
            java.lang.String r0 = "sdk"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Exception -> Lc5
            if (r0 != 0) goto L83
            java.lang.String r0 = "sdk_x86"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Exception -> Lc5
            if (r0 != 0) goto L83
            java.lang.String r0 = "vbox86p"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Exception -> Lc5
            if (r0 != 0) goto L83
            java.lang.String r0 = "emulator"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Exception -> Lc5
            if (r0 != 0) goto L83
            java.lang.String r0 = "simulator"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Exception -> Lc5
            if (r0 == 0) goto L81
            goto L83
        L81:
            r0 = 0
            goto L84
        L83:
            r0 = 1
        L84:
            java.lang.String r1 = cn.jiguang.ag.a.t(r6)     // Catch: java.lang.Exception -> Lc5
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> Lc5
            if (r4 != 0) goto L9c
            if (r0 != 0) goto L9b
            java.lang.String r0 = "Genymotion"
            boolean r0 = r1.contains(r0)     // Catch: java.lang.Exception -> Lc5
            if (r0 == 0) goto L99
            goto L9b
        L99:
            r0 = 0
            goto L9c
        L9b:
            r0 = 1
        L9c:
            java.lang.String r6 = cn.jiguang.ag.a.p(r6)     // Catch: java.lang.Exception -> Lc5
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Exception -> Lc5
            if (r1 != 0) goto Lc0
            if (r0 != 0) goto Lbe
            boolean r0 = r6.contains(r5)     // Catch: java.lang.Exception -> Lc5
            if (r0 != 0) goto Lbe
            java.lang.String r0 = "Emulator"
            boolean r0 = r6.contains(r0)     // Catch: java.lang.Exception -> Lc5
            if (r0 != 0) goto Lbe
            java.lang.String r0 = "Android SDK built for x86"
            boolean r6 = r6.contains(r0)     // Catch: java.lang.Exception -> Lc5
            if (r6 == 0) goto Lbf
        Lbe:
            r2 = 1
        Lbf:
            r0 = r2
        Lc0:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Exception -> Lc5
            return r6
        Lc5:
            r6 = move-exception
            java.lang.String r0 = "SentryUtils"
            java.lang.String r1 = "Error checking whether application is running in an emulator."
            cn.jiguang.w.a.b(r0, r1, r6)
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.an.d.h(android.content.Context):java.lang.Boolean");
    }

    private static Long h(StatFs statFs) {
        try {
            return Long.valueOf(f(statFs) * b(statFs));
        } catch (Exception e4) {
            cn.jiguang.w.a.a("SentryUtils", "Error getting unused internal storage amount.", e4);
            return null;
        }
    }

    private static Long i(StatFs statFs) {
        try {
            return Long.valueOf(d(statFs) * b(statFs));
        } catch (Exception e4) {
            cn.jiguang.w.a.a("SentryUtils", "Error getting total external storage amount.", e4);
            return null;
        }
    }

    private static File[] i(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return context.getExternalFilesDirs(null);
        }
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return new File[]{externalFilesDir};
        }
        return null;
    }

    private static DisplayMetrics j(Context context) {
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Exception e4) {
            cn.jiguang.w.a.a("SentryUtils", "Error getting DisplayMetrics.", e4);
            return null;
        }
    }

    private static Long j(StatFs statFs) {
        try {
            return Long.valueOf(f(statFs) * b(statFs));
        } catch (Exception e4) {
            cn.jiguang.w.a.a("SentryUtils", "Error getting unused external storage amount.", e4);
            return null;
        }
    }
}
