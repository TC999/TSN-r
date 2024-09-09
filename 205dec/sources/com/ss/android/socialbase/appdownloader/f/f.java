package com.ss.android.socialbase.appdownloader.f;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.acse.ottn.f3;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f49087c;

    public static boolean c() {
        Boolean bool = f49087c;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005c A[Catch: Exception -> 0x0089, TryCatch #0 {Exception -> 0x0089, blocks: (B:2:0x0000, B:3:0x0029, B:5:0x0030, B:7:0x0038, B:9:0x0040, B:10:0x004f, B:11:0x0056, B:13:0x005c, B:16:0x006f, B:19:0x007c), top: B:25:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean f() {
        /*
            java.util.HashSet r0 = new java.util.HashSet     // Catch: java.lang.Exception -> L89
            r0.<init>()     // Catch: java.lang.Exception -> L89
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L89
            r1.<init>()     // Catch: java.lang.Exception -> L89
            java.lang.String r2 = "/proc/"
            r1.append(r2)     // Catch: java.lang.Exception -> L89
            int r2 = android.os.Process.myPid()     // Catch: java.lang.Exception -> L89
            r1.append(r2)     // Catch: java.lang.Exception -> L89
            java.lang.String r2 = "/maps"
            r1.append(r2)     // Catch: java.lang.Exception -> L89
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L89
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L89
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Exception -> L89
            r3.<init>(r1)     // Catch: java.lang.Exception -> L89
            r2.<init>(r3)     // Catch: java.lang.Exception -> L89
        L29:
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Exception -> L89
            r3 = 1
            if (r1 == 0) goto L4f
            java.lang.String r4 = ".so"
            boolean r4 = r1.endsWith(r4)     // Catch: java.lang.Exception -> L89
            if (r4 != 0) goto L40
            java.lang.String r4 = ".jar"
            boolean r4 = r1.endsWith(r4)     // Catch: java.lang.Exception -> L89
            if (r4 == 0) goto L29
        L40:
            java.lang.String r4 = " "
            int r4 = r1.lastIndexOf(r4)     // Catch: java.lang.Exception -> L89
            int r4 = r4 + r3
            java.lang.String r1 = r1.substring(r4)     // Catch: java.lang.Exception -> L89
            r0.add(r1)     // Catch: java.lang.Exception -> L89
            goto L29
        L4f:
            r2.close()     // Catch: java.lang.Exception -> L89
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L89
        L56:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> L89
            if (r1 == 0) goto L89
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Exception -> L89
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L89
            java.lang.String r2 = "636f6d2e73617572696b2e737562737472617465"
            java.lang.String r2 = c(r2)     // Catch: java.lang.Exception -> L89
            boolean r2 = r1.contains(r2)     // Catch: java.lang.Exception -> L89
            if (r2 == 0) goto L6f
            return r3
        L6f:
            java.lang.String r2 = "58706f7365644272696467652e6a6172"
            java.lang.String r2 = c(r2)     // Catch: java.lang.Exception -> L89
            boolean r2 = r1.contains(r2)     // Catch: java.lang.Exception -> L89
            if (r2 == 0) goto L7c
            return r3
        L7c:
            java.lang.String r2 = "6c696273616e64686f6f6b2e656478702e736f"
            java.lang.String r2 = c(r2)     // Catch: java.lang.Exception -> L89
            boolean r1 = r1.contains(r2)     // Catch: java.lang.Exception -> L89
            if (r1 == 0) goto L56
            return r3
        L89:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.f.f.f():boolean");
    }

    private static int sr() {
        String str = null;
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod(f3.f5657f, String.class).invoke(null, c("726f2e736563757265"));
            if (invoke != null) {
                str = (String) invoke;
            }
        } catch (Exception unused) {
        }
        return (str != null && "0".equals(str)) ? 0 : 1;
    }

    private static boolean ux() {
        String[] strArr = {c("2f7362696e2f7375"), c("2f73797374656d2f62696e2f7375"), c("2f73797374656d2f7862696e2f7375"), c("2f646174612f6c6f63616c2f7862696e2f7375"), c("2f646174612f6c6f63616c2f62696e2f7375"), c("2f73797374656d2f73642f7862696e2f7375"), c("2f73797374656d2f62696e2f6661696c736166652f7375"), c("2f646174612f6c6f63616c2f7375")};
        for (int i4 = 0; i4 < 8; i4++) {
            if (new File(strArr[i4]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean w() {
        if (sr() == 0) {
            return true;
        }
        return ux();
    }

    public static boolean xv(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return registerReceiver != null && registerReceiver.getIntExtra("plugged", -1) == 2;
    }

    @WorkerThread
    public static synchronized void c(@NonNull Context context) {
        synchronized (f.class) {
            if (f49087c == null) {
                f49087c = Boolean.valueOf((w() || w(context) || xv(context) || !sr(context) || xv() || ux(context)) ? false : true);
            }
        }
    }

    public static boolean w(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    @WorkerThread
    public static boolean xv() {
        try {
            InetAddress.getByName(c("3132372e302e302e31"));
            new Socket(c("3132372e302e302e31"), Integer.parseInt(c("3237303432")));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean sr(Context context) {
        try {
            int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
            return (simState == 1 || simState == 0) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String c(@NonNull String str) {
        return com.ss.android.socialbase.downloader.gd.f.c(str);
    }

    @WorkerThread
    public static boolean ux(Context context) {
        return f() || f(context);
    }

    private static boolean f(Context context) {
        List<String> asList = Arrays.asList(c("64652e726f62762e616e64726f69642e78706f736564"), c("636f6d2e746f706a6f686e77752e6d616769736b"), c("696f2e76612e6578706f736564"), c("636f6d2e77696e642e636f74746572"), c("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), c("6d652e7765697368752e657870"), c("636f6d2e73617572696b2e737562737472617465"));
        PackageManager packageManager = context.getPackageManager();
        for (String str : asList) {
            try {
            } catch (PackageManager.NameNotFoundException e4) {
                e4.printStackTrace();
            }
            if (packageManager.getPackageInfo(str, 0) != null) {
                return true;
            }
        }
        return false;
    }
}
