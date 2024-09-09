package com.qq.e.comm.plugin.util;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    private static List<String> f46725a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f46726b;

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f46727c;

    static {
        boolean z3 = true;
        f46726b = com.qq.e.comm.plugin.d0.a.d().f().a("mipaddr", 1) == 1 && !b("mipaddr");
        f46727c = (com.qq.e.comm.plugin.d0.a.d().f().a("wipaddr", 1) != 1 || b("wipaddr")) ? false : false;
    }

    private static boolean a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context != null && (runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) != null && !runningAppProcesses.isEmpty()) {
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && packageName.equals(runningAppProcessInfo.processName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Pair<Integer, Integer> b() {
        Display defaultDisplay = ((WindowManager) com.qq.e.comm.plugin.d0.a.d().a().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return new Pair<>(Integer.valueOf(displayMetrics.heightPixels), Integer.valueOf(displayMetrics.widthPixels));
    }

    public static String c() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME, 1, new Object[0]);
    }

    private static String d() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 1, new Object[0]);
    }

    public static boolean e(Context context) {
        if (context != null) {
            try {
                KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
                if (keyguardManager != null) {
                    return keyguardManager.inKeyguardRestrictedInputMode();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public static boolean f(Context context) {
        PowerManager powerManager;
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 20) {
                DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
                if (displayManager != null) {
                    Display[] displayArr = null;
                    try {
                        displayArr = displayManager.getDisplays();
                    } catch (Exception unused) {
                    }
                    if (displayArr != null && displayArr.length > 0) {
                        int i4 = 0;
                        for (Display display : displayArr) {
                            if (display != null && display.getState() == 1) {
                                i4++;
                            }
                        }
                        return i4 == displayArr.length;
                    }
                }
            } else {
                if (((PowerManager) context.getSystemService("power")) != null) {
                    return !powerManager.isScreenOn();
                }
            }
        }
        return false;
    }

    public static boolean e() {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        return stackTrace != null && stackTrace.length > 0 && (stackTraceElement = stackTrace[stackTrace.length - 1]) != null && "de.robv.android.xposed.XposedBridge".equals(stackTraceElement.getClassName());
    }

    private static boolean b(Context context) throws IllegalStateException {
        if (context != null) {
            String packageName = context.getPackageName();
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            if (runningTasks != null && !runningTasks.isEmpty()) {
                ComponentName componentName = runningTasks.get(0).topActivity;
                return componentName != null && packageName.equals(componentName.getPackageName());
            }
            throw new IllegalStateException("tasks is empty");
        }
        throw new IllegalStateException("context is null");
    }

    private static boolean a(int i4) throws IOException {
        String d4 = d(String.format("/proc/%d/cgroup", Integer.valueOf(i4)));
        d1.a("gdt_tag_p", "checkForegroundUseCGroup : cgroup = %s ", d4);
        if (TextUtils.isEmpty(d4)) {
            throw new IOException("No content");
        }
        return (d4.contains("bg_non_interactive") || d4.contains("background")) ? false : true;
    }

    public static boolean d(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            try {
                return b(context);
            } catch (SecurityException unused) {
                d1.a("no permission : android.permission.GET_TASKS", new Object[0]);
            } catch (Exception e4) {
                d1.a(e4.getMessage(), e4);
            }
        }
        int myPid = Process.myPid();
        if (new File("/dev/cpuctl/tasks").exists()) {
            try {
                return a(myPid);
            } catch (IOException unused2) {
                d1.a("checkForegroundUseCGroup Exception", new Object[0]);
            }
        } else {
            try {
                return b(myPid);
            } catch (IOException unused3) {
                d1.a("checkForegroundUseStat Exception", new Object[0]);
            }
        }
        return a(context);
    }

    public static boolean a(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("status", -1);
            return intExtra == 2 || intExtra == 5;
        }
        return false;
    }

    public static long a() {
        File externalStorageDirectory;
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && externalStorageDirectory.exists()) {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private static boolean b(int i4) throws IOException {
        String d4 = d(String.format("/proc/%d/stat", Integer.valueOf(i4)));
        d1.a("gdt_tag_p", "checkForegroundUseStat : stat = %s ", d4);
        if (!TextUtils.isEmpty(d4)) {
            String[] split = d4.split("\\s+");
            if (split == null || split.length <= 40) {
                throw new IOException("Invalid format,no match status");
            }
            return Integer.parseInt(split[40]) == 0;
        }
        throw new IOException("No content");
    }

    private static boolean a(String str) {
        JSONObject optJSONObject = GlobalSetting.getSettings().optJSONObject("agree_privacy");
        return (optJSONObject == null || optJSONObject.optBoolean(str, true)) ? false : true;
    }

    public static boolean b(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("plugged", -1);
            return intExtra == 2 || intExtra == 1;
        }
        return false;
    }

    public static boolean b(String str) {
        return a(str) && c(str);
    }

    private static String c(int i4) {
        return (i4 & 255) + "." + ((i4 >> 8) & 255) + "." + ((i4 >> 16) & 255) + "." + ((i4 >> 24) & 255);
    }

    public static Intent c(Context context) {
        if (context != null) {
            try {
                return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static boolean c(String str) {
        if (f46725a == null) {
            String[] split = com.qq.e.comm.plugin.d0.a.d().f().b("oflt", "device_id,android_id,bssid,ssid,cell_id,mac_address,taid,oaid,netop,mipaddr,wipaddr").split(",");
            if (split.length > 0) {
                f46725a = Arrays.asList(split);
            } else {
                f46725a = new ArrayList();
            }
        }
        return f46725a.contains(str);
    }

    private static String d(String str) throws IOException {
        BufferedReader bufferedReader;
        StringBuilder sb;
        try {
            sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), com.qq.e.comm.plugin.k.a.f44515a));
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            String str2 = "";
            while (readLine != null) {
                sb.append(str2);
                sb.append(readLine);
                readLine = bufferedReader.readLine();
                str2 = "\n";
            }
            String sb2 = sb.toString();
            bufferedReader.close();
            return sb2;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }
}
