package com.kwad.components.p208ad.splashscreen;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.p330s.C8950m;
import com.kwad.components.core.request.C8915d;
import com.kwad.components.core.request.model.C8927a;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.p208ad.KsAdLoadManager;
import com.kwad.components.p208ad.splashscreen.monitor.C8495a;
import com.kwad.components.p208ad.splashscreen.monitor.C8497b;
import com.kwad.components.p208ad.splashscreen.p277b.C8363a;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.commercial.p375d.C9829d;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.ad.splashscreen.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8353b {

    /* renamed from: fS */
    private static final Handler f27600fS = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.splashscreen.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8361a {

        /* renamed from: Ca */
        private volatile boolean f27622Ca;

        private C8361a() {
            this.f27622Ca = false;
        }

        /* synthetic */ C8361a(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.splashscreen.b$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8362b {

        /* renamed from: Cb */
        private volatile boolean f27623Cb;

        private C8362b() {
            this.f27623Cb = false;
        }

        /* renamed from: a */
        static /* synthetic */ boolean m30890a(C8362b c8362b, boolean z) {
            c8362b.f27623Cb = true;
            return true;
        }

        /* synthetic */ C8362b(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static boolean m30902a(C8362b c8362b, AdTemplate adTemplate, long j, long j2, Runnable runnable) {
        if (c8362b.f27623Cb) {
            C8497b.m30550kV();
            C8497b.m30564b(adTemplate, 7, j, j2);
            C10331c.m26254d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
            return true;
        }
        f27600fS.removeCallbacks(runnable);
        return false;
    }

    public static void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        C9829d.m27583b(covert);
        C8497b.m30550kV();
        C8497b.m30549p(covert.getPosId());
        boolean m29540a = C8950m.m29533re().m29540a(covert, "loadSplashScreenAd");
        covert.setAdStyle(4);
        covert.setAdNum(1);
        C10331c.m26254d("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
        final C8361a c8361a = new C8361a((byte) 0);
        c8361a.f27622Ca = false;
        final long elapsedRealtime2 = SystemClock.elapsedRealtime();
        final ImpInfo impInfo = new ImpInfo(covert);
        final C8362b c8362b = new C8362b((byte) 0);
        C8766a.m29888qi().m29886qk();
        Handler handler = f27600fS;
        handler.postDelayed(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.b.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8353b.m30901a(ImpInfo.this);
            }
        }, 15000L);
        final AbstractRunnableC11033ay abstractRunnableC11033ay = new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.b.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8362b.m30890a(C8362b.this, true);
                C10331c.m26254d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = splashScreenAdListener;
                C10419e c10419e = C10419e.avA;
                splashScreenAdListener2.onError(c10419e.errorCode, c10419e.msg);
                C8497b.m30550kV();
                C10419e c10419e2 = C10419e.avA;
                C8497b.m30559c(false, c10419e2.errorCode, c10419e2.msg, covert.getPosId());
                C8766a.m29888qi().m29910aD(4);
            }
        };
        int m26524a = C10251d.m26524a(C8363a.f27624CM);
        if (m26524a < 0) {
            m26524a = 5000;
        }
        handler.postDelayed(abstractRunnableC11033ay, m26524a);
        final long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime;
        C8497b.m30550kV();
        C8497b.m30553f(covert.getPosId(), elapsedRealtime3);
        KsAdLoadManager.m33469M();
        KsAdLoadManager.m33468a(new C8927a.C8928a().m29585e(impInfo).m29587aI(true).m29586aJ(m29540a).m29589a(new C8915d() { // from class: com.kwad.components.ad.splashscreen.b.3
            @Override // com.kwad.components.core.request.C8915d, com.kwad.components.core.request.AbstractC8914c
            /* renamed from: a */
            public final void mo29609a(final int i, final String str, boolean z) {
                if (C8362b.this.f27623Cb) {
                    C10331c.m26254d("KsAdSplashScreenLoadManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                    return;
                }
                C8353b.f27600fS.removeCallbacks(abstractRunnableC11033ay);
                if (!c8361a.f27622Ca && i != C10419e.avy.errorCode) {
                    C8497b.m30550kV();
                    C8497b.m30562b(z, i, str, covert.getPosId());
                    C8497b.m30550kV();
                    C8497b.m30559c(z, i, str, covert.getPosId());
                }
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C10331c.m26254d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        splashScreenAdListener.onError(i, str);
                        if (i == C10419e.avB.errorCode) {
                            C8766a.m29888qi().m29910aD(0);
                        } else {
                            C8766a.m29888qi().m29910aD(3);
                        }
                    }
                });
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v8, types: [com.kwad.sdk.api.KsSplashScreenAd, com.kwad.components.ad.splashscreen.KsSplashScreenAdControl] */
            /* JADX WARN: Type inference failed for: r2v9 */
            @Override // com.kwad.components.core.request.C8915d, com.kwad.components.core.request.AbstractC8914c
            /* renamed from: a */
            public final void mo29608a(@NonNull final AdResultData adResultData, boolean z) {
                boolean z2;
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.b.3.2
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        try {
                            splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                            C8495a.m30585kT().m30581o(covert.getPosId());
                        } catch (Throwable th) {
                            C10331c.printStackTraceOnly(th);
                        }
                    }
                });
                try {
                    if (C8353b.m30899a(adResultData, c8361a, this, z, covert.posId)) {
                        return;
                    }
                    AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
                    adTemplate.loadDataTime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                    adTemplate.notNetworkRequest = z;
                    C8497b.m30550kV();
                    C8497b.m30557d(adTemplate, elapsedRealtime3);
                    C9829d.m27586a(covert, 1);
                    long elapsedRealtime4 = SystemClock.elapsedRealtime();
                    z2 = new KsSplashScreenAdControl(covert, adResultData);
                    if (C10251d.m26527a(C8363a.f27628CQ)) {
                        try {
                            SplashPreloadManager.m30908ky();
                            if (SplashPreloadManager.m30911f(adResultData)) {
                                if (C8353b.m30902a(C8362b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, abstractRunnableC11033ay)) {
                                    return;
                                }
                                C8353b.m30900a(splashScreenAdListener, z2, adTemplate);
                                if (SplashPreloadManager.m30908ky().m30912e(adResultData)) {
                                    C8497b.m30550kV();
                                    C8497b.m30577a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                                    C10331c.m26254d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                                    C8766a.m29888qi().m29910aD(1);
                                    return;
                                } else if (SplashPreloadManager.m30908ky().m30913b(adResultData, true) > 0) {
                                    C8497b.m30550kV();
                                    C8497b.m30577a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                                    C8766a.m29888qi().m29910aD(2);
                                    return;
                                } else {
                                    C8497b.m30550kV();
                                    C8497b.m30564b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            z2 = z;
                            ServiceProvider.reportSdkCaughtException(th);
                            C10419e c10419e = C10419e.avD;
                            mo29609a(c10419e.errorCode, c10419e.msg, z2);
                        }
                    }
                    SplashPreloadManager.m30908ky();
                    if (!SplashPreloadManager.m30911f(adResultData)) {
                        SplashPreloadManager.m30908ky();
                        if (!SplashPreloadManager.m30910g(adResultData)) {
                            if (C8353b.m30902a(C8362b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, abstractRunnableC11033ay)) {
                                return;
                            }
                            C8353b.m30900a(splashScreenAdListener, z2, adTemplate);
                            C8497b.m30550kV();
                            C8497b.m30577a(adTemplate, 8, elapsedRealtime4, elapsedRealtime3);
                            C10331c.m26254d("KsAdSplashScreenLoadManager", "loadSplashAd live no cache returned");
                            C8766a.m29888qi().m29910aD(5);
                            return;
                        }
                    }
                    boolean m30912e = SplashPreloadManager.m30908ky().m30912e(adResultData);
                    C10331c.m26254d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + m30912e);
                    if (m30912e) {
                        if (C8353b.m30902a(C8362b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, abstractRunnableC11033ay)) {
                            return;
                        }
                        C8353b.m30900a(splashScreenAdListener, z2, adTemplate);
                        C8497b.m30550kV();
                        C8497b.m30577a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                        C10331c.m26254d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                        C8766a.m29888qi().m29910aD(1);
                        return;
                    }
                    SplashPreloadManager.m30908ky();
                    try {
                        if (!SplashPreloadManager.m30911f(adResultData)) {
                            if (C8362b.this.f27623Cb) {
                                C10331c.m26254d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                                return;
                            }
                            C8353b.f27600fS.removeCallbacks(abstractRunnableC11033ay);
                            C8497b.m30550kV();
                            C8497b.m30564b(adTemplate, 5, elapsedRealtime4, elapsedRealtime3);
                            c8361a.f27622Ca = true;
                            mo29609a(C10419e.avz.errorCode, "请求成功，但缓存未命中", z);
                            C10331c.m26254d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                            C8766a.m29888qi().m29910aD(3);
                            return;
                        }
                        C10331c.m26254d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                        int m30913b = SplashPreloadManager.m30908ky().m30913b(adResultData, true);
                        if (C8353b.m30902a(C8362b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, abstractRunnableC11033ay)) {
                            return;
                        }
                        if (m30913b > 0) {
                            C8353b.m30900a(splashScreenAdListener, z2, adTemplate);
                            C8497b.m30550kV();
                            C8497b.m30577a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                            C8766a.m29888qi().m29910aD(2);
                            return;
                        }
                        C8497b.m30550kV();
                        C8497b.m30564b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                        c8361a.f27622Ca = true;
                        C10419e c10419e2 = C10419e.avB;
                        mo29609a(c10419e2.errorCode, c10419e2.msg, z);
                    } catch (Throwable th2) {
                        th = th2;
                        ServiceProvider.reportSdkCaughtException(th);
                        C10419e c10419e3 = C10419e.avD;
                        mo29609a(c10419e3.errorCode, c10419e3.msg, z2);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z2 = z;
                }
            }
        }).m29584qy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m30900a(final KsLoadManager.SplashScreenAdListener splashScreenAdListener, final KsSplashScreenAd ksSplashScreenAd, final AdTemplate adTemplate) {
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.b.4
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                try {
                    KsAdLoadManager.m33469M().m33467a((KsAdLoadManager) KsSplashScreenAd.this);
                    splashScreenAdListener.onSplashScreenAdLoad(KsSplashScreenAd.this);
                    C8495a.m30585kT().m30589X(adTemplate);
                } catch (Throwable th) {
                    C10331c.printStackTrace(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static boolean m30899a(AdResultData adResultData, C8361a c8361a, C8915d c8915d, boolean z, long j) {
        if (adResultData.getAdTemplateList().size() == 0) {
            C8497b.m30550kV();
            C8497b.m30559c(z, C10419e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? C10419e.avy.msg : adResultData.testErrorMsg, j);
            c8361a.f27622Ca = true;
            c8915d.mo29609a(C10419e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? C10419e.avy.msg : adResultData.testErrorMsg, z);
            C8766a.m29888qi().m29910aD(3);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m30901a(ImpInfo impInfo) {
        final SceneImpl sceneImpl = impInfo.adScene;
        if (TextUtils.isEmpty(sceneImpl.getBidResponse()) && TextUtils.isEmpty(sceneImpl.getBidResponseV2())) {
            C8766a.m29888qi().m29885ql();
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            C8497b.m30550kV();
            C8497b.m30548q(sceneImpl.posId);
            sceneImpl.setAdStyle(4);
            sceneImpl.setAdNum(5);
            ImpInfo impInfo2 = new ImpInfo(sceneImpl);
            C10331c.m26254d("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
            KsAdLoadManager.m33469M();
            KsAdLoadManager.m33468a(new C8927a.C8928a().m29585e(impInfo2).m29586aJ(false).m29589a(new C8915d() { // from class: com.kwad.components.ad.splashscreen.b.5
                @Override // com.kwad.components.core.request.C8915d, com.kwad.components.core.request.InterfaceC8926k
                /* renamed from: a */
                public final void mo29595a(@NonNull AdResultData adResultData) {
                    try {
                        if (adResultData.getAdTemplateList().size() > 0) {
                            int m30913b = SplashPreloadManager.m30908ky().m30913b(adResultData, false);
                            C10331c.m26254d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + m30913b);
                            C8497b.m30550kV();
                            C8497b.m30571a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - elapsedRealtime, SceneImpl.this.getPosId());
                            C8766a.m29888qi().m29909aE(adResultData.getAdTemplateList().size());
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.request.C8915d, com.kwad.components.core.request.InterfaceC8926k
                public final void onError(int i, String str) {
                    C8497b.m30550kV();
                    C8497b.m30565b(i, str, SceneImpl.this.getPosId());
                    C10331c.m26254d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                }
            }).m29584qy());
        }
    }
}
