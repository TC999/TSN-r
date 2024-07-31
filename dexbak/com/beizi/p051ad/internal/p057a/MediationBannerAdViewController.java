package com.beizi.p051ad.internal.p057a;

import android.app.Activity;
import com.beizi.p051ad.internal.AdDispatcher;
import com.beizi.p051ad.internal.AdRequestDelegate;
import com.beizi.p051ad.internal.network.ServerResponse;
import com.beizi.p051ad.p055b.MediationAdapter;

/* renamed from: com.beizi.ad.internal.a.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MediationBannerAdViewController extends MediationAdViewController {
    /* JADX WARN: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private MediationBannerAdViewController(android.app.Activity r9, com.beizi.p051ad.internal.AdRequestDelegate r10, com.beizi.p051ad.internal.p057a.MediationAd r11, com.beizi.p051ad.internal.AdDispatcher r12, com.beizi.p051ad.internal.network.ServerResponse r13) {
        /*
            r8 = this;
            com.beizi.ad.internal.k r4 = com.beizi.p051ad.internal.EnumC2888k.BANNER
            r0 = r8
            r1 = r10
            r2 = r11
            r3 = r12
            r5 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            java.lang.Class<com.beizi.ad.internal.a.d> r10 = com.beizi.p051ad.internal.p057a.MediationBannerAdapter.class
            boolean r10 = r8.m49772a(r10)
            if (r10 != 0) goto L13
            return
        L13:
            java.lang.String r10 = com.beizi.p051ad.internal.utilities.HaoboLog.mediationLogTag
            int r11 = com.beizi.p051ad.C2750R.C2755string.mediated_request
            java.lang.String r11 = com.beizi.p051ad.internal.utilities.HaoboLog.getString(r11)
            com.beizi.p051ad.internal.utilities.HaoboLog.m49292d(r10, r11)
            r8.m49765e()
            r8.m49763g()
            r10 = -1
            r11 = 0
            if (r9 == 0) goto L5c
            boolean r12 = r8.m49766d()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            if (r12 != 0) goto L5c
            com.beizi.ad.b.b r12 = r8.f9830b     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            r0 = r12
            com.beizi.ad.internal.a.d r0 = (com.beizi.p051ad.internal.p057a.MediationBannerAdapter) r0     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            com.beizi.ad.internal.a.a r12 = r8.f9831c     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            java.lang.String r3 = r12.m49781b()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            com.beizi.ad.internal.a.a r12 = r8.f9831c     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            java.lang.String r4 = r12.m49778e()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            com.beizi.ad.internal.a.a r12 = r8.f9831c     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            int r5 = r12.m49780c()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            com.beizi.ad.internal.a.a r12 = r8.f9831c     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            int r6 = r12.m49779d()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            com.beizi.ad.b.a r7 = r8.m49775a()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            r1 = r8
            r2 = r9
            android.view.View r9 = r0.m49758a(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            com.beizi.ad.internal.a.e r12 = r8.f9833e     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            r12.m49756a(r9)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            r9 = -1
            goto L82
        L5c:
            java.lang.String r9 = com.beizi.p051ad.internal.utilities.HaoboLog.mediationLogTag     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            int r12 = com.beizi.p051ad.C2750R.C2755string.mediated_request_null_activity     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            java.lang.String r12 = com.beizi.p051ad.internal.utilities.HaoboLog.getString(r12)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            com.beizi.p051ad.internal.utilities.HaoboLog.m49290e(r9, r12)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L75
            goto L81
        L68:
            r9 = move-exception
            java.lang.String r12 = com.beizi.p051ad.internal.utilities.HaoboLog.mediationLogTag
            int r13 = com.beizi.p051ad.C2750R.C2755string.mediated_request_error
            java.lang.String r13 = com.beizi.p051ad.internal.utilities.HaoboLog.getString(r13)
            com.beizi.p051ad.internal.utilities.HaoboLog.m49289e(r12, r13, r9)
            goto L81
        L75:
            r9 = move-exception
            java.lang.String r12 = com.beizi.p051ad.internal.utilities.HaoboLog.mediationLogTag
            int r13 = com.beizi.p051ad.C2750R.C2755string.mediated_request_exception
            java.lang.String r13 = com.beizi.p051ad.internal.utilities.HaoboLog.getString(r13)
            com.beizi.p051ad.internal.utilities.HaoboLog.m49289e(r12, r13, r9)
        L81:
            r9 = 0
        L82:
            if (r9 != r10) goto L98
            com.beizi.ad.internal.a.e r12 = r8.f9833e
            android.view.View r12 = r12.getView()
            if (r12 != 0) goto L98
            java.lang.String r9 = com.beizi.p051ad.internal.utilities.HaoboLog.mediationLogTag
            int r12 = com.beizi.p051ad.C2750R.C2755string.mediated_view_null
            java.lang.String r12 = com.beizi.p051ad.internal.utilities.HaoboLog.getString(r12)
            com.beizi.p051ad.internal.utilities.HaoboLog.m49290e(r9, r12)
            goto L99
        L98:
            r11 = r9
        L99:
            if (r11 == r10) goto L9e
            r8.m49774a(r11)
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.p051ad.internal.p057a.MediationBannerAdViewController.<init>(android.app.Activity, com.beizi.ad.internal.f, com.beizi.ad.internal.a.a, com.beizi.ad.internal.c, com.beizi.ad.internal.network.ServerResponse):void");
    }

    /* renamed from: a */
    public static MediationBannerAdViewController m49759a(Activity activity, AdRequestDelegate adRequestDelegate, MediationAd mediationAd, AdDispatcher adDispatcher, ServerResponse serverResponse) {
        MediationBannerAdViewController mediationBannerAdViewController = new MediationBannerAdViewController(activity, adRequestDelegate, mediationAd, adDispatcher, serverResponse);
        if (mediationBannerAdViewController.f9835g) {
            return null;
        }
        return mediationBannerAdViewController;
    }

    @Override // com.beizi.p051ad.internal.p057a.MediationAdViewController
    /* renamed from: c */
    public void mo49751c() {
    }

    @Override // com.beizi.p051ad.internal.p057a.MediationAdViewController
    /* renamed from: i */
    public void mo49750i() {
        this.f9837i = true;
        MediationAdapter mediationAdapter = this.f9830b;
        if (mediationAdapter != null) {
            mediationAdapter.m50086e();
        }
    }

    @Override // com.beizi.p051ad.internal.p057a.MediationAdViewController
    /* renamed from: j */
    public void mo49749j() {
        MediationAdapter mediationAdapter = this.f9830b;
        if (mediationAdapter != null) {
            mediationAdapter.m50088c();
        }
    }

    @Override // com.beizi.p051ad.internal.p057a.MediationAdViewController
    /* renamed from: k */
    public void mo49748k() {
        MediationAdapter mediationAdapter = this.f9830b;
        if (mediationAdapter != null) {
            mediationAdapter.m50087d();
        }
    }
}
