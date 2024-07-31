package com.kwad.sdk.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import com.kwad.sdk.core.p397e.C10331c;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.kwad.sdk.utils.am */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11020am {
    private static Map<String, Integer> aPv;
    private static Set<String> aPw;
    private static Method aPx;

    static {
        HashSet hashSet = new HashSet();
        aPw = hashSet;
        hashSet.add("android.permission.REQUEST_INSTALL_PACKAGES");
        aPw.add("android.permission.WRITE_SETTINGS");
        aPw.add("android.permission.SYSTEM_ALERT_WINDOW");
    }

    /* renamed from: aq */
    public static int m24099aq(Context context, String str) {
        int m24098ar;
        if (aPv == null) {
            m24094h(C11016aj.m24116cq(context));
        }
        if (!aPw.contains(str) || (m24098ar = m24098ar(context, str)) == -2) {
            int m24097as = m24097as(context, str);
            if (m24097as != -2) {
                return m24097as;
            }
            try {
                return context.checkPermission(str, Process.myPid(), Process.myUid());
            } catch (Throwable unused) {
                return m24097as;
            }
        }
        return m24098ar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041 A[RETURN, SYNTHETIC] */
    /* renamed from: ar */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int m24098ar(android.content.Context r3, java.lang.String r4) {
        /*
            r4.hashCode()
            int r0 = r4.hashCode()
            r1 = 0
            r2 = -1
            switch(r0) {
                case -2078357533: goto L24;
                case -1561629405: goto L19;
                case 1777263169: goto Le;
                default: goto Lc;
            }
        Lc:
            r4 = -1
            goto L2e
        Le:
            java.lang.String r0 = "android.permission.REQUEST_INSTALL_PACKAGES"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L17
            goto Lc
        L17:
            r4 = 2
            goto L2e
        L19:
            java.lang.String r0 = "android.permission.SYSTEM_ALERT_WINDOW"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L22
            goto Lc
        L22:
            r4 = 1
            goto L2e
        L24:
            java.lang.String r0 = "android.permission.WRITE_SETTINGS"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L2d
            goto Lc
        L2d:
            r4 = 0
        L2e:
            r0 = 23
            switch(r4) {
                case 0: goto L53;
                case 1: goto L43;
                case 2: goto L34;
                default: goto L33;
            }
        L33:
            goto L5e
        L34:
            int r4 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r4 < r0) goto L5e
            boolean r3 = com.kwad.sdk.utils.C11016aj.m24117cp(r3)
            if (r3 == 0) goto L41
            goto L5f
        L41:
            r1 = -1
            goto L5f
        L43:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r0) goto L5e
            boolean r3 = android.provider.Settings.canDrawOverlays(r3)     // Catch: java.lang.Throwable -> L4e
            if (r3 == 0) goto L41
            goto L5f
        L4e:
            r3 = move-exception
            com.kwad.sdk.core.p397e.C10331c.printStackTraceOnly(r3)
            goto L5e
        L53:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r0) goto L5e
            boolean r3 = android.provider.Settings.System.canWrite(r3)     // Catch: java.lang.Throwable -> L5e
            if (r3 == 0) goto L41
            goto L5f
        L5e:
            r1 = -2
        L5f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.C11020am.m24098ar(android.content.Context, java.lang.String):int");
    }

    /* renamed from: as */
    private static int m24097as(Context context, String str) {
        if (aPv == null || str == null) {
            return -2;
        }
        if (Build.VERSION.SDK_INT < 19) {
            return 0;
        }
        if (aPv.containsKey(str)) {
            try {
                Integer num = aPv.get(str);
                if (num == null) {
                    return -2;
                }
                if (aPx == null) {
                    Class cls = Integer.TYPE;
                    Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class);
                    aPx = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                return ((Integer) aPx.invoke((AppOpsManager) context.getSystemService("appops"), num, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0 ? 0 : -1;
            } catch (Exception e) {
                C10331c.printStackTrace(e);
                return 0;
            }
        }
        return -2;
    }

    /* renamed from: cr */
    public static boolean m24096cr(Context context) {
        int i;
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
        } catch (Throwable unused) {
            i = 0;
        }
        return i == 1;
    }

    /* renamed from: gG */
    private static String m24095gG(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return str;
        }
        try {
            return str.substring(lastIndexOf + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    /* renamed from: h */
    private static void m24094h(String[] strArr) {
        if (Build.VERSION.SDK_INT < 19 || strArr == null) {
            return;
        }
        aPv = new HashMap();
        for (String str : strArr) {
            try {
                int intValue = ((Integer) C11124s.m23696c(AppOpsManager.class, "OP_" + m24095gG(str))).intValue();
                if (intValue >= 0) {
                    aPv.put(str, Integer.valueOf(intValue));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
