package p000XI.p008xo.p009XI.p010XI;

import android.content.BroadcastReceiver;

/* renamed from: XI.xo.XI.XI.xo */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C0022xo extends BroadcastReceiver {
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r0 == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (android.text.TextUtils.equals(r6.getStringExtra("openIdPackage"), r5.getPackageName()) != false) goto L27;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceive(android.content.Context r5, android.content.Intent r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L7c
            if (r6 != 0) goto L6
            goto L7c
        L6:
            java.lang.String r0 = "openIdNotifyFlag"
            r1 = 0
            int r0 = r6.getIntExtra(r0, r1)
            r2 = 1
            if (r0 != r2) goto L21
            java.lang.String r0 = "openIdPackage"
            java.lang.String r0 = r6.getStringExtra(r0)
            java.lang.String r5 = r5.getPackageName()
            boolean r5 = android.text.TextUtils.equals(r0, r5)
            if (r5 == 0) goto L38
            goto L37
        L21:
            r3 = 2
            if (r0 != r3) goto L35
            java.lang.String r0 = "openIdPackageList"
            java.util.ArrayList r0 = r6.getStringArrayListExtra(r0)
            if (r0 == 0) goto L38
            java.lang.String r5 = r5.getPackageName()
            boolean r1 = r0.contains(r5)
            goto L38
        L35:
            if (r0 != 0) goto L38
        L37:
            r1 = 1
        L38:
            if (r1 != 0) goto L3b
            return
        L3b:
            java.lang.String r5 = "openIdType"
            java.lang.String r5 = r6.getStringExtra(r5)
            XI.xo.XI.XI.CA r6 = p000XI.p008xo.p009XI.p010XI.C0018CA.m60060XI()
            r6.getClass()
            java.lang.String r0 = "oaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L53
            XI.xo.XI.XI.XI r5 = r6.f37K0
            goto L75
        L53:
            java.lang.String r0 = "vaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L5e
            XI.xo.XI.XI.XI r5 = r6.f41xo
            goto L75
        L5e:
            java.lang.String r0 = "aaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L69
            XI.xo.XI.XI.XI r5 = r6.f39kM
            goto L75
        L69:
            java.lang.String r0 = "udid"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L74
            XI.xo.XI.XI.XI r5 = r6.f38XI
            goto L75
        L74:
            r5 = 0
        L75:
            if (r5 != 0) goto L78
            return
        L78:
            r0 = 0
            r5.f45XI = r0
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000XI.p008xo.p009XI.p010XI.C0022xo.onReceive(android.content.Context, android.content.Intent):void");
    }
}
