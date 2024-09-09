package com.umeng.commonsdk.internal.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMProbe.java */
@SuppressLint({"NewApi"})
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class k {

    /* renamed from: b  reason: collision with root package name */
    public static final String f53510b = "_dsk_s";

    /* renamed from: c  reason: collision with root package name */
    public static final String f53511c = "_thm_z";

    /* renamed from: d  reason: collision with root package name */
    public static final String f53512d = "_gdf_r";

    /* renamed from: a  reason: collision with root package name */
    public static final String f53509a = au.b().b("probe");

    /* renamed from: e  reason: collision with root package name */
    private static Object f53513e = new Object();

    public static void b(final Context context) {
        if (c(context)) {
            return;
        }
        final String[] strArr = {"unknown", "unknown", "unknown"};
        new Thread() { // from class: com.umeng.commonsdk.internal.utils.k.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    strArr[0] = k.c();
                    strArr[1] = k.a();
                    strArr[2] = k.b();
                    ULog.i("diskType = " + strArr[0] + "; ThremalZone = " + strArr[1] + "; GoldFishRc = " + strArr[2]);
                    k.b(context, strArr);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }.start();
    }

    public static boolean c(Context context) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f53509a, 0)) == null || TextUtils.isEmpty(sharedPreferences.getString("_dsk_s", ""))) ? false : true;
    }

    public static String a(Context context) {
        try {
            SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f53509a, 0);
            if (sharedPreferences != null) {
                JSONObject jSONObject = new JSONObject();
                synchronized (f53513e) {
                    jSONObject.put("_dsk_s", sharedPreferences.getString("_dsk_s", ""));
                    jSONObject.put("_thm_z", sharedPreferences.getString("_thm_z", ""));
                    jSONObject.put("_gdf_r", sharedPreferences.getString("_gdf_r", ""));
                }
                return jSONObject.toString();
            }
            return null;
        } catch (Exception e4) {
            UMCrashManager.reportCrash(context, e4);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String[] strArr) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f53509a, 0)) == null) {
            return;
        }
        synchronized (f53513e) {
            sharedPreferences.edit().putString("_dsk_s", strArr[0]).putString("_thm_z", strArr[1]).putString("_gdf_r", strArr[2]).commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c() {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L34
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L34
            java.lang.String r3 = "/proc/diskstats"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L34
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L34
        Ld:
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> L33
            java.lang.String r2 = "mtd"
            java.lang.String r3 = "sda"
            java.lang.String r4 = "mmcblk"
            if (r0 == 0) goto L30
            boolean r5 = r0.contains(r4)     // Catch: java.lang.Throwable -> L33
            if (r5 == 0) goto L21
            r2 = r4
            goto L37
        L21:
            boolean r4 = r0.contains(r3)     // Catch: java.lang.Throwable -> L33
            if (r4 == 0) goto L29
            r2 = r3
            goto L37
        L29:
            boolean r0 = r0.contains(r2)     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto Ld
            goto L37
        L30:
            java.lang.String r2 = "unknown"
            goto L37
        L33:
            r0 = r1
        L34:
            java.lang.String r2 = "noper"
            r1 = r0
        L37:
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.lang.Throwable -> L3c
        L3c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.k.c():java.lang.String");
    }

    public static String b() {
        int i4;
        try {
            i4 = a("ls /", "goldfish");
        } catch (Throwable unused) {
            i4 = -1;
        }
        return i4 > 0 ? "goldfish" : i4 < 0 ? "noper" : "unknown";
    }

    public static int a(String str, String str2) throws IOException {
        int i4;
        if (Build.VERSION.SDK_INT > 28) {
            return -1;
        }
        Process exec = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                i4 = -1;
                break;
            } else if (readLine.contains(str2)) {
                i4 = 1;
                break;
            }
        }
        try {
            if (exec.waitFor() != 0) {
                return -1;
            }
            return i4;
        } catch (InterruptedException unused) {
            return -1;
        }
    }

    public static String a() {
        int i4;
        try {
            i4 = a("ls /sys/class/thermal", "thermal_zone");
        } catch (Throwable unused) {
            i4 = -1;
        }
        return i4 > 0 ? "thermal_zone" : i4 < 0 ? "noper" : "unknown";
    }
}
