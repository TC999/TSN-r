package com.mbridge.msdk.foundation.tools;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import java.io.File;

/* renamed from: com.mbridge.msdk.foundation.tools.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class CommonBatteryStatusUtil {

    /* renamed from: a */
    private static int f31009a = -1;

    /* renamed from: b */
    private static int f31010b = -1;

    /* renamed from: c */
    private static int f31011c = -1;

    /* renamed from: d */
    private static boolean f31012d;

    /* renamed from: e */
    private static int f31013e;

    /* renamed from: f */
    private static boolean f31014f;

    /* renamed from: g */
    private static boolean f31015g;

    /* renamed from: a */
    public static int m21932a() {
        try {
            Intent registerReceiver = MBSDKContext.m22865f().m22861j().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int[] iArr = new int[2];
            if (registerReceiver != null) {
                iArr[0] = registerReceiver.getIntExtra("level", 50);
                iArr[1] = registerReceiver.getIntExtra("plugged", 0);
                m21927a(iArr[1] != 0);
                iArr[0] = m21930a(iArr[0], iArr[1]);
                m21931a(iArr[0]);
            } else {
                iArr[0] = 50;
                iArr[1] = 0;
            }
            return iArr[0];
        } catch (Exception unused) {
            int i = f31009a;
            if (i != -1) {
                return i;
            }
            return 50;
        }
    }

    /* renamed from: b */
    public static int m21926b() {
        int i;
        try {
            i = MBSDKContext.m22865f().m22861j().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", 1);
        } catch (Throwable th) {
            SameLogTool.m21735b("BatteryStatusUtil", th.getMessage(), th);
            i = 0;
        }
        return (i == 2 || i == 5) ? 1 : 0;
    }

    /* renamed from: a */
    private static int m21930a(int i, int i2) {
        String str = Build.MODEL;
        if (str.equalsIgnoreCase("SCH-i909") || str.equalsIgnoreCase("SCH-I535") || str.equalsIgnoreCase("SCH-W899")) {
            if (i > 100) {
                i /= 10;
            }
        } else if (!str.trim().toUpperCase().contains("XT702") && !str.trim().toUpperCase().contains("XT907") && !str.trim().toUpperCase().contains("XT1058") && !str.trim().toUpperCase().contains("XT1080") && Build.MANUFACTURER.equalsIgnoreCase("motorola")) {
            File file = new File("/sys/class/power_supply/battery/charge_counter");
            int parseInt = file.exists() ? Integer.parseInt(m21928a(file)) : 0;
            if (parseInt <= 0) {
                File file2 = new File("/sys/class/power_supply/battery/capacity");
                if (file2.exists()) {
                    Integer.parseInt(m21928a(file2));
                }
            }
            if (parseInt <= 100 && parseInt > 0 && i % 10 == 0) {
                i = parseInt;
            }
        }
        if (i <= 100) {
            return i;
        }
        if (i2 == 0 || i >= 110) {
            do {
                i /= 10;
            } while (i > 100);
            return i;
        }
        return 100;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0040 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m21928a(java.io.File r4) {
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
            m21929a(r2, r1, r0)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27
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
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.CommonBatteryStatusUtil.m21928a(java.io.File):java.lang.String");
    }

    /* renamed from: a */
    private static void m21929a(int i, char[] cArr, StringBuilder sb) {
        for (int i2 = 0; i2 < i; i2++) {
            if (cArr[i2] != '\n' && cArr[i2] != '\r') {
                sb.append(cArr[i2]);
            }
        }
    }

    /* renamed from: a */
    private static synchronized void m21931a(int i) {
        synchronized (CommonBatteryStatusUtil.class) {
            f31013e = i;
        }
    }

    /* renamed from: a */
    private static synchronized void m21927a(boolean z) {
        synchronized (CommonBatteryStatusUtil.class) {
            f31014f = z;
        }
    }
}
