package com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import com.qq.e.comm.util.GDTLogger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0092, code lost:
        com.qq.e.comm.util.GDTLogger.e(java.lang.String.format("Service[%s]\u9700\u8981\u5728AndroidManifest.xml\u4e2d\u58f0\u660e", r3.getName()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ab, code lost:
        r8 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r8) {
        /*
            r0 = 0
            r1 = 2
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r3 = "android.permission.INTERNET"
            r2[r0] = r3     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r3 = "android.permission.ACCESS_NETWORK_STATE"
            r4 = 1
            r2[r4] = r3     // Catch: java.lang.Throwable -> Lb2
            r3 = 0
        Le:
            if (r3 >= r1) goto L32
            r5 = r2[r3]     // Catch: java.lang.Throwable -> L2a
            int r6 = r8.checkCallingOrSelfPermission(r5)     // Catch: java.lang.Throwable -> L2a
            r7 = -1
            if (r6 != r7) goto L27
            java.lang.String r1 = "Permission[%s]\u9700\u8981\u5728AndroidManifest.xml\u4e2d\u58f0\u660e"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L2a
            r2[r0] = r5     // Catch: java.lang.Throwable -> L2a
            java.lang.String r1 = java.lang.String.format(r1, r2)     // Catch: java.lang.Throwable -> L2a
            com.qq.e.comm.util.GDTLogger.e(r1)     // Catch: java.lang.Throwable -> L2a
            goto L30
        L27:
            int r3 = r3 + 1
            goto Le
        L2a:
            r1 = move-exception
            java.lang.String r2 = "\u68c0\u67e5\u6743\u9650\u65f6\u53d1\u751f\u5f02\u5e38"
            com.qq.e.comm.util.GDTLogger.e(r2, r1)     // Catch: java.lang.Throwable -> Lb2
        L30:
            r1 = 0
            goto L33
        L32:
            r1 = 1
        L33:
            if (r1 == 0) goto Lb1
            java.lang.Class[] r1 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = com.qq.e.comm.constants.CustomPkgConstants.getADActivityName()     // Catch: java.lang.Throwable -> Lb2
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> Lb2
            r1[r0] = r2     // Catch: java.lang.Throwable -> Lb2
            boolean r1 = a(r8, r1)     // Catch: java.lang.Throwable -> Lb2
            if (r1 == 0) goto Lb1
            java.lang.Class[] r1 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = com.qq.e.comm.constants.CustomPkgConstants.getPortraitADActivityName()     // Catch: java.lang.Throwable -> Lb2
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> Lb2
            r1[r0] = r2     // Catch: java.lang.Throwable -> Lb2
            boolean r1 = a(r8, r1)     // Catch: java.lang.Throwable -> Lb2
            if (r1 == 0) goto Lb1
            java.lang.Class[] r1 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = com.qq.e.comm.constants.CustomPkgConstants.getLandscapeADActivityName()     // Catch: java.lang.Throwable -> Lb2
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> Lb2
            r1[r0] = r2     // Catch: java.lang.Throwable -> Lb2
            boolean r1 = a(r8, r1)     // Catch: java.lang.Throwable -> Lb2
            if (r1 == 0) goto Lb1
            java.lang.Class[] r1 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = com.qq.e.comm.constants.CustomPkgConstants.getDownLoadServiceName()     // Catch: java.lang.Throwable -> Lb2
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> Lb2
            r1[r0] = r2     // Catch: java.lang.Throwable -> Lb2
            r2 = 0
        L78:
            if (r2 >= r4) goto Lad
            r3 = r1[r2]     // Catch: java.lang.Throwable -> La5
            android.content.Intent r5 = new android.content.Intent     // Catch: java.lang.Throwable -> La5
            r5.<init>()     // Catch: java.lang.Throwable -> La5
            r5.setClass(r8, r3)     // Catch: java.lang.Throwable -> La5
            android.content.pm.PackageManager r6 = r8.getPackageManager()     // Catch: java.lang.Throwable -> La5
            r7 = 65536(0x10000, float:9.1835E-41)
            android.content.pm.ResolveInfo r5 = r6.resolveService(r5, r7)     // Catch: java.lang.Throwable -> La5
            if (r5 != 0) goto La2
            java.lang.String r8 = "Service[%s]\u9700\u8981\u5728AndroidManifest.xml\u4e2d\u58f0\u660e"
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> La5
            java.lang.String r2 = r3.getName()     // Catch: java.lang.Throwable -> La5
            r1[r0] = r2     // Catch: java.lang.Throwable -> La5
            java.lang.String r8 = java.lang.String.format(r8, r1)     // Catch: java.lang.Throwable -> La5
            com.qq.e.comm.util.GDTLogger.e(r8)     // Catch: java.lang.Throwable -> La5
            goto Lab
        La2:
            int r2 = r2 + 1
            goto L78
        La5:
            r8 = move-exception
            java.lang.String r1 = "\u68c0\u67e5Service\u65f6\u53d1\u751f\u5f02\u5e38"
            com.qq.e.comm.util.GDTLogger.e(r1, r8)     // Catch: java.lang.Throwable -> Lb2
        Lab:
            r8 = 0
            goto Lae
        Lad:
            r8 = 1
        Lae:
            if (r8 == 0) goto Lb1
            r0 = 1
        Lb1:
            return r0
        Lb2:
            r8 = move-exception
            java.lang.String r1 = "\u68c0\u67e5AndroidManifest.xml\u65f6\u53d1\u751f\u5f02\u5e38"
            com.qq.e.comm.util.GDTLogger.e(r1, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.a.a(android.content.Context):boolean");
    }

    private static boolean a(Context context, Class<?>... clsArr) {
        for (int i4 = 0; i4 < clsArr.length; i4++) {
            try {
                Intent intent = new Intent();
                intent.setClass(context, clsArr[i4]);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    GDTLogger.e(String.format("Activity[%s]\u9700\u8981\u5728AndroidManifest.xml\u4e2d\u58f0\u660e", clsArr[i4].getName()));
                    return false;
                }
            } catch (Throwable th) {
                GDTLogger.e("\u68c0\u67e5Activity\u65f6\u53d1\u751f\u5f02\u5e38", th);
                return false;
            }
        }
        return true;
    }
}
