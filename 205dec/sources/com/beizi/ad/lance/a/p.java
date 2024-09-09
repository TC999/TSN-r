package com.beizi.ad.lance.a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SystemUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private static String f14381a = "SystemUtil";

    public static long a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return 0L;
        }
    }

    public static long b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return 0L;
        }
    }

    public static String c(Context context) {
        return context.getPackageName();
    }

    public static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return "";
        } catch (Exception e5) {
            e5.printStackTrace();
            return "";
        }
    }

    public static String e(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager != null ? String.valueOf(packageManager.getPackageInfo("com.huawei.appmarket", 0).versionCode) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String f(Context context) {
        return String.valueOf(context.getResources().getDisplayMetrics().widthPixels);
    }

    public static int g(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static String h(Context context) {
        return String.valueOf(context.getResources().getDisplayMetrics().heightPixels);
    }

    public static int i(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int j(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int k(Context context) {
        float f4 = context.getResources().getDisplayMetrics().density;
        float f5 = context.getResources().getDisplayMetrics().widthPixels;
        if (f4 <= 0.0f) {
            f4 = 1.0f;
        }
        return (int) ((f5 / f4) + 0.5f);
    }

    public static String l(Context context) {
        return context.getResources().getConfiguration().orientation == 2 ? "2" : "1";
    }

    public static String m(Context context) {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem + "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static long c() {
        Long l4 = 0L;
        switch (Calendar.getInstance().get(7)) {
            case 1:
            case 2:
            case 4:
            case 6:
                l4 = Long.valueOf(System.currentTimeMillis() / 1000);
                break;
            case 3:
            case 5:
            case 7:
                l4 = Long.valueOf(System.currentTimeMillis());
                break;
        }
        return l4.longValue();
    }

    public static String a(Context context, String str) {
        try {
            int i4 = context.getPackageManager().getPackageInfo(str, 0).versionCode;
            return i4 != 0 ? String.valueOf(i4) : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String b() {
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

    public static String a() {
        return (new File("/system/bin/su").exists() && a("/system/bin/su")) ? "yes" : (new File("/system/xbin/su").exists() && a("/system/xbin/su")) ? "yes" : "no";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(String str) {
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
            } catch (IOException e4) {
                e4.printStackTrace();
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
}
