package com.kwad.components.ad.splashscreen;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    private static final Handler fS = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private volatile boolean Ca;

        private a() {
            this.Ca = false;
        }

        /* synthetic */ a(byte b4) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.ad.splashscreen.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0599b {
        private volatile boolean Cb;

        private C0599b() {
            this.Cb = false;
        }

        static /* synthetic */ boolean a(C0599b c0599b, boolean z3) {
            c0599b.Cb = true;
            return true;
        }

        /* synthetic */ C0599b(byte b4) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(C0599b c0599b, AdTemplate adTemplate, long j4, long j5, Runnable runnable) {
        if (c0599b.Cb) {
            com.kwad.components.ad.splashscreen.monitor.b.kV();
            com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 7, j4, j5);
            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
            return true;
        }
        fS.removeCallbacks(runnable);
        return false;
    }

    public static void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.b(covert);
        com.kwad.components.ad.splashscreen.monitor.b.kV();
        com.kwad.components.ad.splashscreen.monitor.b.p(covert.getPosId());
        boolean a4 = m.re().a(covert, "loadSplashScreenAd");
        covert.setAdStyle(4);
        covert.setAdNum(1);
        com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
        final a aVar = new a((byte) 0);
        aVar.Ca = false;
        final long elapsedRealtime2 = SystemClock.elapsedRealtime();
        final ImpInfo impInfo = new ImpInfo(covert);
        final C0599b c0599b = new C0599b((byte) 0);
        com.kwad.components.core.o.a.qi().qk();
        Handler handler = fS;
        handler.postDelayed(new ay() { // from class: com.kwad.components.ad.splashscreen.b.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                b.a(ImpInfo.this);
            }
        }, 15000L);
        final ay ayVar = new ay() { // from class: com.kwad.components.ad.splashscreen.b.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                C0599b.a(C0599b.this, true);
                com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = splashScreenAdListener;
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.avA;
                splashScreenAdListener2.onError(eVar.errorCode, eVar.msg);
                com.kwad.components.ad.splashscreen.monitor.b.kV();
                com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.avA;
                com.kwad.components.ad.splashscreen.monitor.b.c(false, eVar2.errorCode, eVar2.msg, covert.getPosId());
                com.kwad.components.core.o.a.qi().aD(4);
            }
        };
        int a5 = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CM);
        if (a5 < 0) {
            a5 = 5000;
        }
        handler.postDelayed(ayVar, a5);
        final long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime;
        com.kwad.components.ad.splashscreen.monitor.b.kV();
        com.kwad.components.ad.splashscreen.monitor.b.f(covert.getPosId(), elapsedRealtime3);
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0649a().e(impInfo).aI(true).aJ(a4).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.3
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(final int i4, final String str, boolean z3) {
                if (C0599b.this.Cb) {
                    com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i4), str));
                    return;
                }
                b.fS.removeCallbacks(ayVar);
                if (!aVar.Ca && i4 != com.kwad.sdk.core.network.e.avy.errorCode) {
                    com.kwad.components.ad.splashscreen.monitor.b.kV();
                    com.kwad.components.ad.splashscreen.monitor.b.b(z3, i4, str, covert.getPosId());
                    com.kwad.components.ad.splashscreen.monitor.b.kV();
                    com.kwad.components.ad.splashscreen.monitor.b.c(z3, i4, str, covert.getPosId());
                }
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i4), str));
                        splashScreenAdListener.onError(i4, str);
                        if (i4 == com.kwad.sdk.core.network.e.avB.errorCode) {
                            com.kwad.components.core.o.a.qi().aD(0);
                        } else {
                            com.kwad.components.core.o.a.qi().aD(3);
                        }
                    }
                });
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v8, types: [com.kwad.sdk.api.KsSplashScreenAd, com.kwad.components.ad.splashscreen.KsSplashScreenAdControl] */
            /* JADX WARN: Type inference failed for: r2v9 */
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull final AdResultData adResultData, boolean z3) {
                boolean z4;
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.splashscreen.b.3.2
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        try {
                            splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                            com.kwad.components.ad.splashscreen.monitor.a.kT().o(covert.getPosId());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                        }
                    }
                });
                try {
                    if (b.a(adResultData, aVar, this, z3, covert.posId)) {
                        return;
                    }
                    AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
                    adTemplate.loadDataTime = SystemClock.elapsedRealtime() - elapsedRealtime2;
                    adTemplate.notNetworkRequest = z3;
                    com.kwad.components.ad.splashscreen.monitor.b.kV();
                    com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, elapsedRealtime3);
                    com.kwad.sdk.commercial.d.d.a(covert, 1);
                    long elapsedRealtime4 = SystemClock.elapsedRealtime();
                    z4 = new KsSplashScreenAdControl(covert, adResultData);
                    if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CQ)) {
                        try {
                            SplashPreloadManager.ky();
                            if (SplashPreloadManager.f(adResultData)) {
                                if (b.a(C0599b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, ayVar)) {
                                    return;
                                }
                                b.a(splashScreenAdListener, z4, adTemplate);
                                if (SplashPreloadManager.ky().e(adResultData)) {
                                    com.kwad.components.ad.splashscreen.monitor.b.kV();
                                    com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                                    com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                                    com.kwad.components.core.o.a.qi().aD(1);
                                    return;
                                } else if (SplashPreloadManager.ky().b(adResultData, true) > 0) {
                                    com.kwad.components.ad.splashscreen.monitor.b.kV();
                                    com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                                    com.kwad.components.core.o.a.qi().aD(2);
                                    return;
                                } else {
                                    com.kwad.components.ad.splashscreen.monitor.b.kV();
                                    com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            z4 = z3;
                            ServiceProvider.reportSdkCaughtException(th);
                            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.avD;
                            a(eVar.errorCode, eVar.msg, z4);
                        }
                    }
                    SplashPreloadManager.ky();
                    if (!SplashPreloadManager.f(adResultData)) {
                        SplashPreloadManager.ky();
                        if (!SplashPreloadManager.g(adResultData)) {
                            if (b.a(C0599b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, ayVar)) {
                                return;
                            }
                            b.a(splashScreenAdListener, z4, adTemplate);
                            com.kwad.components.ad.splashscreen.monitor.b.kV();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 8, elapsedRealtime4, elapsedRealtime3);
                            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd live no cache returned");
                            com.kwad.components.core.o.a.qi().aD(5);
                            return;
                        }
                    }
                    boolean e4 = SplashPreloadManager.ky().e(adResultData);
                    com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + e4);
                    if (e4) {
                        if (b.a(C0599b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, ayVar)) {
                            return;
                        }
                        b.a(splashScreenAdListener, z4, adTemplate);
                        com.kwad.components.ad.splashscreen.monitor.b.kV();
                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, elapsedRealtime4, elapsedRealtime3);
                        com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                        com.kwad.components.core.o.a.qi().aD(1);
                        return;
                    }
                    SplashPreloadManager.ky();
                    try {
                        if (!SplashPreloadManager.f(adResultData)) {
                            if (C0599b.this.Cb) {
                                com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                                return;
                            }
                            b.fS.removeCallbacks(ayVar);
                            com.kwad.components.ad.splashscreen.monitor.b.kV();
                            com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 5, elapsedRealtime4, elapsedRealtime3);
                            aVar.Ca = true;
                            a(com.kwad.sdk.core.network.e.avz.errorCode, "\u8bf7\u6c42\u6210\u529f\uff0c\u4f46\u7f13\u5b58\u672a\u547d\u4e2d", z3);
                            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                            com.kwad.components.core.o.a.qi().aD(3);
                            return;
                        }
                        com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                        int b4 = SplashPreloadManager.ky().b(adResultData, true);
                        if (b.a(C0599b.this, adTemplate, elapsedRealtime4, elapsedRealtime3, ayVar)) {
                            return;
                        }
                        if (b4 > 0) {
                            b.a(splashScreenAdListener, z4, adTemplate);
                            com.kwad.components.ad.splashscreen.monitor.b.kV();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, elapsedRealtime4, elapsedRealtime3);
                            com.kwad.components.core.o.a.qi().aD(2);
                            return;
                        }
                        com.kwad.components.ad.splashscreen.monitor.b.kV();
                        com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, elapsedRealtime4, elapsedRealtime3);
                        aVar.Ca = true;
                        com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.avB;
                        a(eVar2.errorCode, eVar2.msg, z3);
                    } catch (Throwable th2) {
                        th = th2;
                        ServiceProvider.reportSdkCaughtException(th);
                        com.kwad.sdk.core.network.e eVar3 = com.kwad.sdk.core.network.e.avD;
                        a(eVar3.errorCode, eVar3.msg, z4);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z4 = z3;
                }
            }
        }).qy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final KsLoadManager.SplashScreenAdListener splashScreenAdListener, final KsSplashScreenAd ksSplashScreenAd, final AdTemplate adTemplate) {
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.splashscreen.b.4
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                try {
                    KsAdLoadManager.M().a((KsAdLoadManager) KsSplashScreenAd.this);
                    splashScreenAdListener.onSplashScreenAdLoad(KsSplashScreenAd.this);
                    com.kwad.components.ad.splashscreen.monitor.a.kT().X(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(AdResultData adResultData, a aVar, com.kwad.components.core.request.d dVar, boolean z3, long j4) {
        if (adResultData.getAdTemplateList().size() == 0) {
            com.kwad.components.ad.splashscreen.monitor.b.kV();
            com.kwad.components.ad.splashscreen.monitor.b.c(z3, com.kwad.sdk.core.network.e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.avy.msg : adResultData.testErrorMsg, j4);
            aVar.Ca = true;
            dVar.a(com.kwad.sdk.core.network.e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.avy.msg : adResultData.testErrorMsg, z3);
            com.kwad.components.core.o.a.qi().aD(3);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(ImpInfo impInfo) {
        final SceneImpl sceneImpl = impInfo.adScene;
        if (TextUtils.isEmpty(sceneImpl.getBidResponse()) && TextUtils.isEmpty(sceneImpl.getBidResponseV2())) {
            com.kwad.components.core.o.a.qi().ql();
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.kV();
            com.kwad.components.ad.splashscreen.monitor.b.q(sceneImpl.posId);
            sceneImpl.setAdStyle(4);
            sceneImpl.setAdNum(5);
            ImpInfo impInfo2 = new ImpInfo(sceneImpl);
            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
            KsAdLoadManager.M();
            KsAdLoadManager.a(new a.C0649a().e(impInfo2).aJ(false).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.5
                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
                public final void a(@NonNull AdResultData adResultData) {
                    try {
                        if (adResultData.getAdTemplateList().size() > 0) {
                            int b4 = SplashPreloadManager.ky().b(adResultData, false);
                            com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + b4);
                            com.kwad.components.ad.splashscreen.monitor.b.kV();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - elapsedRealtime, SceneImpl.this.getPosId());
                            com.kwad.components.core.o.a.qi().aE(adResultData.getAdTemplateList().size());
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
                public final void onError(int i4, String str) {
                    com.kwad.components.ad.splashscreen.monitor.b.kV();
                    com.kwad.components.ad.splashscreen.monitor.b.b(i4, str, SceneImpl.this.getPosId());
                    com.kwad.sdk.core.e.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i4), str));
                }
            }).qy());
        }
    }
}
