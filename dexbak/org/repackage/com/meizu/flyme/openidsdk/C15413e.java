package org.repackage.com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.repackage.com.meizu.flyme.openidsdk.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15413e extends BroadcastReceiver {
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
        if (r0 == 0) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (android.text.TextUtils.equals(r6.getStringExtra("openIdPackage"), r5.getPackageName()) != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
        r1 = true;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onReceive(android.content.Context r5, android.content.Intent r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L86
            if (r6 != 0) goto L6
            goto L86
        L6:
            java.lang.String r0 = "openIdNotifyFlag"
            r1 = 0
            int r0 = r6.getIntExtra(r0, r1)
            java.lang.String r2 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "shouldUpdateId, notifyFlag : "
            java.lang.String r2 = r3.concat(r2)
            org.repackage.com.meizu.flyme.openidsdk.C15414f.m2772e(r2)
            r2 = 1
            if (r0 != r2) goto L2f
            java.lang.String r0 = "openIdPackage"
            java.lang.String r0 = r6.getStringExtra(r0)
            java.lang.String r5 = r5.getPackageName()
            boolean r5 = android.text.TextUtils.equals(r0, r5)
            if (r5 == 0) goto L46
        L2d:
            r1 = 1
            goto L46
        L2f:
            r3 = 2
            if (r0 != r3) goto L43
            java.lang.String r0 = "openIdPackageList"
            java.util.ArrayList r0 = r6.getStringArrayListExtra(r0)
            if (r0 == 0) goto L46
            java.lang.String r5 = r5.getPackageName()
            boolean r1 = r0.contains(r5)
            goto L46
        L43:
            if (r0 != 0) goto L46
            goto L2d
        L46:
            if (r1 != 0) goto L49
            return
        L49:
            java.lang.String r5 = "openIdType"
            java.lang.String r5 = r6.getStringExtra(r5)
            org.repackage.com.meizu.flyme.openidsdk.f r6 = org.repackage.com.meizu.flyme.openidsdk.C15414f.m2773d()
            java.lang.String r0 = "oaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L5e
            org.repackage.com.meizu.flyme.openidsdk.a r5 = r6.f44183b
            goto L80
        L5e:
            java.lang.String r0 = "vaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L69
            org.repackage.com.meizu.flyme.openidsdk.a r5 = r6.f44185d
            goto L80
        L69:
            java.lang.String r0 = "aaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L74
            org.repackage.com.meizu.flyme.openidsdk.a r5 = r6.f44184c
            goto L80
        L74:
            java.lang.String r0 = "udid"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L7f
            org.repackage.com.meizu.flyme.openidsdk.a r5 = r6.f44182a
            goto L80
        L7f:
            r5 = 0
        L80:
            if (r5 != 0) goto L83
            return
        L83:
            r5.m2788e()
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.meizu.flyme.openidsdk.C15413e.onReceive(android.content.Context, android.content.Intent):void");
    }
}
