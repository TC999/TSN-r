package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1;

import android.content.Context;
import android.os.Build;

/* compiled from: MIUIPermissionUtils.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f303a = "b";

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b0 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.RequiresApi(api = 19)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.String r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.b.f303a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "checkPermissinKITKATNew\uff0cpermission\uff1a"
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            com.bytedance.msdk.adapter.util.Logger.e(r0, r1)
            r1 = 0
            r2 = 1
            int r3 = r7.hashCode()     // Catch: java.lang.Exception -> Lb2
            r4 = -1888586689(0xffffffff8f6e743f, float:-1.1756694E-29)
            r5 = 2
            if (r3 == r4) goto L41
            r4 = -63024214(0xfffffffffc3e53aa, float:-3.9529332E36)
            if (r3 == r4) goto L37
            r4 = -5573545(0xffffffffffaaf457, float:NaN)
            if (r3 == r4) goto L2d
            goto L4b
        L2d:
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            boolean r3 = r7.equals(r3)     // Catch: java.lang.Exception -> Lb2
            if (r3 == 0) goto L4b
            r3 = 2
            goto L4c
        L37:
            java.lang.String r3 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r3 = r7.equals(r3)     // Catch: java.lang.Exception -> Lb2
            if (r3 == 0) goto L4b
            r3 = 0
            goto L4c
        L41:
            java.lang.String r3 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r3 = r7.equals(r3)     // Catch: java.lang.Exception -> Lb2
            if (r3 == 0) goto L4b
            r3 = 1
            goto L4c
        L4b:
            r3 = -1
        L4c:
            if (r3 == 0) goto L65
            if (r3 == r2) goto L62
            if (r3 == r5) goto L5f
            java.lang.String r3 = "android.permission."
            java.lang.String r4 = "android:"
            java.lang.String r7 = r7.replaceFirst(r3, r4)     // Catch: java.lang.Exception -> Lb2
            java.lang.String r7 = r7.toLowerCase()     // Catch: java.lang.Exception -> Lb2
            goto L67
        L5f:
            java.lang.String r7 = "android:read_phone_state"
            goto L67
        L62:
            java.lang.String r7 = "android:fine_location"
            goto L67
        L65:
            java.lang.String r7 = "android:coarse_location"
        L67:
            java.lang.String r3 = "appops"
            java.lang.Object r3 = r6.getSystemService(r3)     // Catch: java.lang.Exception -> Lb2
            android.app.AppOpsManager r3 = (android.app.AppOpsManager) r3     // Catch: java.lang.Exception -> Lb2
            int r4 = android.os.Binder.getCallingUid()     // Catch: java.lang.Exception -> Lb2
            java.lang.String r6 = r6.getPackageName()     // Catch: java.lang.Exception -> Lb2
            int r6 = r3.checkOp(r7, r4, r6)     // Catch: java.lang.Exception -> Lb2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb2
            r3.<init>()     // Catch: java.lang.Exception -> Lb2
            java.lang.String r4 = "checkPermissinKITKATNew\uff0clocationOp,permission\uff1a"
            r3.append(r4)     // Catch: java.lang.Exception -> Lb2
            r3.append(r6)     // Catch: java.lang.Exception -> Lb2
            java.lang.String r4 = ","
            r3.append(r4)     // Catch: java.lang.Exception -> Lb2
            r3.append(r7)     // Catch: java.lang.Exception -> Lb2
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> Lb2
            com.bytedance.msdk.adapter.util.Logger.e(r0, r3)     // Catch: java.lang.Exception -> Lb2
            if (r6 == 0) goto Lb0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lae
            r6.<init>()     // Catch: java.lang.Exception -> Lae
            java.lang.String r2 = "checkPermissinKITKATNew\uff0cfalse,permission\uff1a"
            r6.append(r2)     // Catch: java.lang.Exception -> Lae
            r6.append(r7)     // Catch: java.lang.Exception -> Lae
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> Lae
            com.bytedance.msdk.adapter.util.Logger.e(r0, r6)     // Catch: java.lang.Exception -> Lae
            goto Lca
        Lae:
            r6 = move-exception
            goto Lb4
        Lb0:
            r1 = 1
            goto Lca
        Lb2:
            r6 = move-exception
            r1 = 1
        Lb4:
            java.lang.String r7 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.b.f303a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "\u6743\u9650\u68c0\u67e5\u51fa\u9519\u65f6\u9ed8\u8ba4\u8fd4\u56de\u6709\u6743\u9650\uff0c\u5f02\u5e38\u4ee3\u7801\uff1a"
            r0.append(r2)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            com.bytedance.msdk.adapter.util.Logger.e(r7, r6)
        Lca:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.b.a(android.content.Context, java.lang.String):boolean");
    }

    public static boolean b(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a(context, str);
        }
        return c(context, str);
    }

    private static boolean c(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
