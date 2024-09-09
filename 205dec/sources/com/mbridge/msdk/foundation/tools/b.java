package com.mbridge.msdk.foundation.tools;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import java.io.File;

/* compiled from: CommonBatteryStatusUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static int f39782a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static int f39783b = -1;

    /* renamed from: c  reason: collision with root package name */
    private static int f39784c = -1;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f39785d;

    /* renamed from: e  reason: collision with root package name */
    private static int f39786e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f39787f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f39788g;

    public static int a() {
        try {
            Intent registerReceiver = com.mbridge.msdk.foundation.controller.a.f().j().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int[] iArr = new int[2];
            if (registerReceiver != null) {
                iArr[0] = registerReceiver.getIntExtra("level", 50);
                iArr[1] = registerReceiver.getIntExtra("plugged", 0);
                a(iArr[1] != 0);
                iArr[0] = a(iArr[0], iArr[1]);
                a(iArr[0]);
            } else {
                iArr[0] = 50;
                iArr[1] = 0;
            }
            return iArr[0];
        } catch (Exception unused) {
            int i4 = f39782a;
            if (i4 != -1) {
                return i4;
            }
            return 50;
        }
    }

    public static int b() {
        int i4;
        try {
            i4 = com.mbridge.msdk.foundation.controller.a.f().j().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", 1);
        } catch (Throwable th) {
            x.b("BatteryStatusUtil", th.getMessage(), th);
            i4 = 0;
        }
        return (i4 == 2 || i4 == 5) ? 1 : 0;
    }

    private static int a(int i4, int i5) {
        String str = Build.MODEL;
        if (str.equalsIgnoreCase("SCH-i909") || str.equalsIgnoreCase("SCH-I535") || str.equalsIgnoreCase("SCH-W899")) {
            if (i4 > 100) {
                i4 /= 10;
            }
        } else if (!str.trim().toUpperCase().contains("XT702") && !str.trim().toUpperCase().contains("XT907") && !str.trim().toUpperCase().contains("XT1058") && !str.trim().toUpperCase().contains("XT1080") && Build.MANUFACTURER.equalsIgnoreCase("motorola")) {
            File file = new File("/sys/class/power_supply/battery/charge_counter");
            int parseInt = file.exists() ? Integer.parseInt(a(file)) : 0;
            if (parseInt <= 0) {
                File file2 = new File("/sys/class/power_supply/battery/capacity");
                if (file2.exists()) {
                    Integer.parseInt(a(file2));
                }
            }
            if (parseInt <= 100 && parseInt > 0 && i4 % 10 == 0) {
                i4 = parseInt;
            }
        }
        if (i4 <= 100) {
            return i4;
        }
        if (i5 == 0 || i4 >= 110) {
            do {
                i4 /= 10;
            } while (i4 > 100);
            return i4;
        }
        return 100;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0040 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.io.File r4) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 1024(0x400, float:1.435E-42)
            char[] r1 = new char[r1]
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L30
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L30
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27
        L14:
            int r2 = r4.read(r1)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27
            if (r2 < 0) goto L1e
            a(r2, r1, r0)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27
            goto L14
        L1e:
            r3.close()     // Catch: java.io.IOException -> L22
            goto L36
        L22:
            goto L36
        L24:
            r4 = move-exception
            r2 = r3
            goto L2a
        L27:
            r2 = r3
            goto L31
        L29:
            r4 = move-exception
        L2a:
            if (r2 == 0) goto L2f
            r2.close()     // Catch: java.io.IOException -> L2f
        L2f:
            throw r4
        L30:
        L31:
            if (r2 == 0) goto L36
            r2.close()     // Catch: java.io.IOException -> L22
        L36:
            java.lang.String r4 = r0.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L42
            java.lang.String r4 = "0"
        L42:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.b.a(java.io.File):java.lang.String");
    }

    private static void a(int i4, char[] cArr, StringBuilder sb) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (cArr[i5] != '\n' && cArr[i5] != '\r') {
                sb.append(cArr[i5]);
            }
        }
    }

    private static synchronized void a(int i4) {
        synchronized (b.class) {
            f39786e = i4;
        }
    }

    private static synchronized void a(boolean z3) {
        synchronized (b.class) {
            f39787f = z3;
        }
    }
}
