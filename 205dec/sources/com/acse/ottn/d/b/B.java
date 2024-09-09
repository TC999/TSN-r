package com.acse.ottn.d.b;

import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.util.ra;
import com.ss.android.download.api.constant.BaseConstants;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class B {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5416a = "RomUtils";

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0064: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:28:0x0064 */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r7) {
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
            com.acse.ottn.util.ra.a(r1, r0, r7)
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
            com.acse.ottn.util.ra.a(r1, r7, r3)     // Catch: java.lang.Throwable -> L63
            if (r4 == 0) goto L62
            r4.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r7 = move-exception
            com.acse.ottn.util.ra.a(r1, r0, r7)
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
            com.acse.ottn.util.ra.a(r1, r0, r2)
        L6f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.d.b.B.a(java.lang.String):java.lang.String");
    }

    public static boolean a() {
        String str = Build.MANUFACTURER;
        return str.contains("QiKU") || str.contains("360");
    }

    public static boolean b() {
        return Build.MANUFACTURER.contains("HUAWEI");
    }

    public static boolean c() {
        String a4 = a("ro.build.display.id");
        if (TextUtils.isEmpty(a4)) {
            return false;
        }
        return a4.contains("flyme") || a4.toLowerCase().contains("flyme");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name"));
    }

    public static boolean e() {
        String str = Build.MANUFACTURER;
        return str.contains(BaseConstants.ROM_OPPO_UPPER_CONSTANT) || str.contains("oppo");
    }

    public static double f() {
        try {
            String a4 = a("ro.build.version.emui");
            return Double.parseDouble(a4.substring(a4.indexOf("_") + 1));
        } catch (Exception e4) {
            e4.printStackTrace();
            return 4.0d;
        }
    }

    public static int g() {
        String a4 = a("ro.miui.ui.version.name");
        if (a4 != null) {
            try {
                return Integer.parseInt(a4.substring(1));
            } catch (Exception unused) {
                ra.b("RomUtils", "get miui version code error, version : " + a4);
                return -1;
            }
        }
        return -1;
    }
}
