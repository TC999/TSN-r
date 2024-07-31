package com.devlin_n.floatWindowPermission;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

/* compiled from: RomUtils.java */
/* renamed from: com.devlin_n.floatWindowPermission.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6595g {

    /* renamed from: a */
    private static final String f23189a = "RomUtils";

    /* renamed from: a */
    public static boolean m35789a() {
        String str = Build.MANUFACTURER;
        return str.contains("QiKU") || str.contains("360");
    }

    /* renamed from: b */
    public static boolean m35788b() {
        return Build.MANUFACTURER.contains("HUAWEI");
    }

    /* renamed from: c */
    public static boolean m35787c() {
        String m35783g = m35783g("ro.build.display.id");
        if (TextUtils.isEmpty(m35783g)) {
            return false;
        }
        return m35783g.contains("flyme") || m35783g.toLowerCase().contains("flyme");
    }

    /* renamed from: d */
    public static boolean m35786d() {
        return !TextUtils.isEmpty(m35783g("ro.miui.ui.version.name"));
    }

    /* renamed from: e */
    public static double m35785e() {
        try {
            String m35783g = m35783g("ro.build.version.emui");
            return Double.parseDouble(m35783g.substring(m35783g.indexOf("_") + 1));
        } catch (Exception e) {
            e.printStackTrace();
            return 4.0d;
        }
    }

    /* renamed from: f */
    public static int m35784f() {
        String m35783g = m35783g("ro.miui.ui.version.name");
        if (m35783g != null) {
            try {
                return Integer.parseInt(m35783g.substring(1));
            } catch (Exception unused) {
                Log.e(f23189a, "get miui version code error, version : " + m35783g);
                return -1;
            }
        }
        return -1;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0064: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:24:0x0064 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m35783g(java.lang.String r7) {
        /*
            java.lang.String r0 = "Exception while closing InputStream"
            java.lang.String r1 = "RomUtils"
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r4.<init>()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.lang.String r5 = "getprop "
            r4.append(r5)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r4.append(r7)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.lang.Process r3 = r3.exec(r4)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r3 = 1024(0x400, float:1.435E-42)
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.lang.String r3 = r4.readLine()     // Catch: java.io.IOException -> L3e java.lang.Throwable -> L63
            r4.close()     // Catch: java.io.IOException -> L3e java.lang.Throwable -> L63
            r4.close()     // Catch: java.io.IOException -> L39
            goto L3d
        L39:
            r7 = move-exception
            android.util.Log.e(r1, r0, r7)
        L3d:
            return r3
        L3e:
            r3 = move-exception
            goto L44
        L40:
            r7 = move-exception
            goto L65
        L42:
            r3 = move-exception
            r4 = r2
        L44:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L63
            r5.<init>()     // Catch: java.lang.Throwable -> L63
            java.lang.String r6 = "Unable to read sysprop "
            r5.append(r6)     // Catch: java.lang.Throwable -> L63
            r5.append(r7)     // Catch: java.lang.Throwable -> L63
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L63
            android.util.Log.e(r1, r7, r3)     // Catch: java.lang.Throwable -> L63
            if (r4 == 0) goto L62
            r4.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r7 = move-exception
            android.util.Log.e(r1, r0, r7)
        L62:
            return r2
        L63:
            r7 = move-exception
            r2 = r4
        L65:
            if (r2 == 0) goto L6f
            r2.close()     // Catch: java.io.IOException -> L6b
            goto L6f
        L6b:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L6f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devlin_n.floatWindowPermission.C6595g.m35783g(java.lang.String):java.lang.String");
    }
}
