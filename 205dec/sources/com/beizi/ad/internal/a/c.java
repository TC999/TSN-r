package com.beizi.ad.internal.a;

import android.app.Activity;
import com.beizi.ad.internal.network.ServerResponse;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MediationBannerAdViewController.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c extends b {
    /* JADX WARN: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private c(android.app.Activity r9, com.beizi.ad.internal.f r10, com.beizi.ad.internal.a.a r11, com.beizi.ad.internal.c r12, com.beizi.ad.internal.network.ServerResponse r13) {
        /*
            r8 = this;
            com.beizi.ad.internal.k r4 = com.beizi.ad.internal.k.BANNER
            r0 = r8
            r1 = r10
            r2 = r11
            r3 = r12
            r5 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            java.lang.Class<com.beizi.ad.internal.a.d> r10 = com.beizi.ad.internal.a.d.class
            boolean r10 = r8.a(r10)
            if (r10 != 0) goto L13
            return
        L13:
            java.lang.String r10 = com.beizi.ad.internal.utilities.HaoboLog.mediationLogTag
            int r11 = com.beizi.ad.R.string.mediated_request
            java.lang.String r11 = com.beizi.ad.internal.utilities.HaoboLog.getString(r11)
            com.beizi.ad.internal.utilities.HaoboLog.d(r10, r11)
            r8.e()
            r8.g()
            r10 = -1
            r11 = 0
            if (r9 == 0) goto L5c
            boolean r12 = r8.d()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            if (r12 != 0) goto L5c
            com.beizi.ad.b.b r12 = r8.f13528b     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            r0 = r12
            com.beizi.ad.internal.a.d r0 = (com.beizi.ad.internal.a.d) r0     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            com.beizi.ad.internal.a.a r12 = r8.f13529c     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            java.lang.String r3 = r12.b()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            com.beizi.ad.internal.a.a r12 = r8.f13529c     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            java.lang.String r4 = r12.e()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            com.beizi.ad.internal.a.a r12 = r8.f13529c     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            int r5 = r12.c()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            com.beizi.ad.internal.a.a r12 = r8.f13529c     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            int r6 = r12.d()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            com.beizi.ad.b.a r7 = r8.a()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            r1 = r8
            r2 = r9
            android.view.View r9 = r0.a(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            com.beizi.ad.internal.a.e r12 = r8.f13531e     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            r12.a(r9)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            r9 = -1
            goto L82
        L5c:
            java.lang.String r9 = com.beizi.ad.internal.utilities.HaoboLog.mediationLogTag     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            int r12 = com.beizi.ad.R.string.mediated_request_null_activity     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            java.lang.String r12 = com.beizi.ad.internal.utilities.HaoboLog.getString(r12)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            com.beizi.ad.internal.utilities.HaoboLog.e(r9, r12)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            goto L81
        L68:
            r9 = move-exception
            java.lang.String r12 = com.beizi.ad.internal.utilities.HaoboLog.mediationLogTag
            int r13 = com.beizi.ad.R.string.mediated_request_error
            java.lang.String r13 = com.beizi.ad.internal.utilities.HaoboLog.getString(r13)
            com.beizi.ad.internal.utilities.HaoboLog.e(r12, r13, r9)
            goto L81
        L75:
            r9 = move-exception
            java.lang.String r12 = com.beizi.ad.internal.utilities.HaoboLog.mediationLogTag
            int r13 = com.beizi.ad.R.string.mediated_request_exception
            java.lang.String r13 = com.beizi.ad.internal.utilities.HaoboLog.getString(r13)
            com.beizi.ad.internal.utilities.HaoboLog.e(r12, r13, r9)
        L81:
            r9 = 0
        L82:
            if (r9 != r10) goto L98
            com.beizi.ad.internal.a.e r12 = r8.f13531e
            android.view.View r12 = r12.getView()
            if (r12 != 0) goto L98
            java.lang.String r9 = com.beizi.ad.internal.utilities.HaoboLog.mediationLogTag
            int r12 = com.beizi.ad.R.string.mediated_view_null
            java.lang.String r12 = com.beizi.ad.internal.utilities.HaoboLog.getString(r12)
            com.beizi.ad.internal.utilities.HaoboLog.e(r9, r12)
            goto L99
        L98:
            r11 = r9
        L99:
            if (r11 == r10) goto L9e
            r8.a(r11)
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.ad.internal.a.c.<init>(android.app.Activity, com.beizi.ad.internal.f, com.beizi.ad.internal.a.a, com.beizi.ad.internal.c, com.beizi.ad.internal.network.ServerResponse):void");
    }

    public static c a(Activity activity, com.beizi.ad.internal.f fVar, a aVar, com.beizi.ad.internal.c cVar, ServerResponse serverResponse) {
        c cVar2 = new c(activity, fVar, aVar, cVar, serverResponse);
        if (cVar2.f13533g) {
            return null;
        }
        return cVar2;
    }

    @Override // com.beizi.ad.internal.a.b
    public void c() {
    }

    @Override // com.beizi.ad.internal.a.b
    public void i() {
        this.f13535i = true;
        com.beizi.ad.b.b bVar = this.f13528b;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // com.beizi.ad.internal.a.b
    public void j() {
        com.beizi.ad.b.b bVar = this.f13528b;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // com.beizi.ad.internal.a.b
    public void k() {
        com.beizi.ad.b.b bVar = this.f13528b;
        if (bVar != null) {
            bVar.d();
        }
    }
}
