package com.beizi.p051ad.lance.p062a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

/* renamed from: com.beizi.ad.lance.a.p */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SystemUtil {

    /* renamed from: a */
    private static String f10816a = "SystemUtil";

    /* renamed from: a */
    public static long m49037a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* renamed from: b */
    public static long m49033b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* renamed from: c */
    public static String m49030c(Context context) {
        return context.getPackageName();
    }

    /* renamed from: d */
    public static String m49029d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* renamed from: e */
    public static String m49028e(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager != null ? String.valueOf(packageManager.getPackageInfo("com.huawei.appmarket", 0).versionCode) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: f */
    public static String m49027f(Context context) {
        return String.valueOf(context.getResources().getDisplayMetrics().widthPixels);
    }

    /* renamed from: g */
    public static int m49026g(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: h */
    public static String m49025h(Context context) {
        return String.valueOf(context.getResources().getDisplayMetrics().heightPixels);
    }

    /* renamed from: i */
    public static int m49024i(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: j */
    public static int m49023j(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /* renamed from: k */
    public static int m49022k(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().widthPixels;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (int) ((f2 / f) + 0.5f);
    }

    /* renamed from: l */
    public static String m49021l(Context context) {
        return context.getResources().getConfiguration().orientation == 2 ? "2" : "1";
    }

    /* renamed from: m */
    public static String m49020m(Context context) {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem + "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: c */
    public static long m49031c() {
        Long l = 0L;
        switch (Calendar.getInstance().get(7)) {
            case 1:
            case 2:
            case 4:
            case 6:
                l = Long.valueOf(System.currentTimeMillis() / 1000);
                break;
            case 3:
            case 5:
            case 7:
                l = Long.valueOf(System.currentTimeMillis());
                break;
        }
        return l.longValue();
    }

    /* renamed from: a */
    public static String m49036a(Context context, String str) {
        try {
            int i = context.getPackageManager().getPackageInfo(str, 0).versionCode;
            return i != 0 ? String.valueOf(i) : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    private static boolean m49032b(String str) {
        Process process = null;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                process = runtime.exec("ls -l " + str);
                String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
                if (readLine != null && readLine.length() >= 4) {
                    char charAt = readLine.charAt(3);
                    if (charAt == 's' || charAt == 'x') {
                        process.destroy();
                        return true;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (process == null) {
                    return false;
                }
            }
            process.destroy();
            return false;
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static String m49038a() {
        return (new File("/system/bin/su").exists() && m49032b("/system/bin/su")) ? "yes" : (new File("/system/xbin/su").exists() && m49032b("/system/xbin/su")) ? "yes" : "no";
    }

    /* renamed from: a */
    public static boolean m49035a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static String m49034b() {
        StatFs statFs;
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                long blockSize = new StatFs(Environment.getExternalStorageDirectory().getPath()).getBlockSize();
                return (statFs.getBlockCount() * blockSize) + "";
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
