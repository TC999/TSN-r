package com.bytedance.msdk.core.t;

import android.content.Context;
import android.os.Build;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static final String f28202c = "w";

    public static boolean c(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            return w(context, str);
        }
        return xv(context, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
        if (r1 == 1) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        if (r1 == 2) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
        r8 = r8.replaceFirst("android.permission.", "android:").toLowerCase();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
        r8 = "android:read_phone_state";
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
        r8 = "android:fine_location";
     */
    @androidx.annotation.RequiresApi(api = 19)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean w(android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.String r0 = com.bytedance.msdk.core.t.w.f28202c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "checkPermissinKITKATNew\uff0cpermission\uff1a"
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            com.bytedance.msdk.adapter.sr.xv.sr(r0, r1)
            r1 = -1
            r2 = 0
            r3 = 1
            int r4 = r8.hashCode()     // Catch: java.lang.Exception -> Lb1
            r5 = -1888586689(0xffffffff8f6e743f, float:-1.1756694E-29)
            r6 = 2
            if (r4 == r5) goto L42
            r5 = -63024214(0xfffffffffc3e53aa, float:-3.9529332E36)
            if (r4 == r5) goto L38
            r5 = -5573545(0xffffffffffaaf457, float:NaN)
            if (r4 == r5) goto L2e
            goto L4b
        L2e:
            java.lang.String r4 = "android.permission.READ_PHONE_STATE"
            boolean r4 = r8.equals(r4)     // Catch: java.lang.Exception -> Lb1
            if (r4 == 0) goto L4b
            r1 = 2
            goto L4b
        L38:
            java.lang.String r4 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r4 = r8.equals(r4)     // Catch: java.lang.Exception -> Lb1
            if (r4 == 0) goto L4b
            r1 = 0
            goto L4b
        L42:
            java.lang.String r4 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r4 = r8.equals(r4)     // Catch: java.lang.Exception -> Lb1
            if (r4 == 0) goto L4b
            r1 = 1
        L4b:
            if (r1 == 0) goto L64
            if (r1 == r3) goto L61
            if (r1 == r6) goto L5e
            java.lang.String r1 = "android.permission."
            java.lang.String r4 = "android:"
            java.lang.String r8 = r8.replaceFirst(r1, r4)     // Catch: java.lang.Exception -> Lb1
            java.lang.String r8 = r8.toLowerCase()     // Catch: java.lang.Exception -> Lb1
            goto L66
        L5e:
            java.lang.String r8 = "android:read_phone_state"
            goto L66
        L61:
            java.lang.String r8 = "android:fine_location"
            goto L66
        L64:
            java.lang.String r8 = "android:coarse_location"
        L66:
            java.lang.String r1 = "appops"
            java.lang.Object r1 = r7.getSystemService(r1)     // Catch: java.lang.Exception -> Lb1
            android.app.AppOpsManager r1 = (android.app.AppOpsManager) r1     // Catch: java.lang.Exception -> Lb1
            int r4 = android.os.Binder.getCallingUid()     // Catch: java.lang.Exception -> Lb1
            java.lang.String r7 = r7.getPackageName()     // Catch: java.lang.Exception -> Lb1
            int r7 = r1.checkOp(r8, r4, r7)     // Catch: java.lang.Exception -> Lb1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb1
            r1.<init>()     // Catch: java.lang.Exception -> Lb1
            java.lang.String r4 = "checkPermissinKITKATNew\uff0clocationOp,permission\uff1a"
            r1.append(r4)     // Catch: java.lang.Exception -> Lb1
            r1.append(r7)     // Catch: java.lang.Exception -> Lb1
            java.lang.String r4 = ","
            r1.append(r4)     // Catch: java.lang.Exception -> Lb1
            r1.append(r8)     // Catch: java.lang.Exception -> Lb1
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> Lb1
            com.bytedance.msdk.adapter.sr.xv.sr(r0, r1)     // Catch: java.lang.Exception -> Lb1
            if (r7 == 0) goto Laf
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lad
            r7.<init>()     // Catch: java.lang.Exception -> Lad
            java.lang.String r1 = "checkPermissinKITKATNew\uff0cfalse,permission\uff1a"
            r7.append(r1)     // Catch: java.lang.Exception -> Lad
            r7.append(r8)     // Catch: java.lang.Exception -> Lad
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> Lad
            com.bytedance.msdk.adapter.sr.xv.sr(r0, r7)     // Catch: java.lang.Exception -> Lad
            goto Lc9
        Lad:
            r7 = move-exception
            goto Lb3
        Laf:
            r2 = 1
            goto Lc9
        Lb1:
            r7 = move-exception
            r2 = 1
        Lb3:
            java.lang.String r8 = com.bytedance.msdk.core.t.w.f28202c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "\u6743\u9650\u68c0\u67e5\u51fa\u9519\u65f6\u9ed8\u8ba4\u8fd4\u56de\u6709\u6743\u9650\uff0c\u5f02\u5e38\u4ee3\u7801\uff1a"
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.bytedance.msdk.adapter.sr.xv.sr(r8, r7)
        Lc9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.t.w.w(android.content.Context, java.lang.String):boolean");
    }

    private static boolean xv(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
