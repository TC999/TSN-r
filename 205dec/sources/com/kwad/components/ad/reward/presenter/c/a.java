package com.kwad.components.ad.reward.presenter.c;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.model.EcOrderCardStyle;
import com.kwad.components.ad.reward.monitor.c;
import com.kwad.components.ad.reward.presenter.b;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.l;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends b {
    private List<Integer> cB;
    private AdInfo mAdInfo;
    private l su;
    private final i tV = new i();
    private long pm = 0;
    private Handler fS = new Handler(Looper.getMainLooper());
    private boolean tW = true;
    private volatile boolean cC = false;
    private Runnable tX = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.1
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.tV.rT()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.tV.rV();
                int rW = a.this.tV.rU().rW();
                a.this.qo.a(elapsedRealtime, a.this.tV.rU().rX(), rW);
            } else if (a.this.tW) {
                a.this.qo.a(5000L, 5000L, 1);
            }
            com.kwad.components.core.o.a.qi().aw(a.this.mAdTemplate);
        }
    };
    private l sv = new l() { // from class: com.kwad.components.ad.reward.presenter.c.a.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.hw();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            a.this.tV.rS();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j4, long j5) {
            super.onMediaPlayProgress(j4, j5);
            a.this.c(j5);
            a.this.pm = j5;
            a.this.tV.rS();
            a.a(a.this, false);
            a.this.qo.pm = j5;
            if (a.this.cC) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.o.a.qi().b(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            c.b(a.this.qo.oY, a.this.mAdTemplate, a.this.qo.mPageEnterTime);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.hQ();
        }
    };
    private l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.c.a.3
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            a.this.hw();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i4, int i5) {
            super.onMediaPlayError(i4, i5);
            c.a(a.this.qo.oY, a.this.qo.mAdTemplate, a.this.qo.pv, i4, i5);
            com.kwad.components.ad.reward.monitor.b.c(a.this.qo.oY, a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            a.this.tV.rS();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j4, long j5) {
            a.this.c(j5);
            a.this.pm = j5;
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.hQ();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            a.this.tV.rS();
            a.a(a.this, false);
            if (a.this.cC) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.o.a.qi().b(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            c.b(a.this.qo.oY, a.this.mAdTemplate, a.this.qo.mPageEnterTime);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            a.this.tV.rR();
            a.this.fS.removeCallbacks(a.this.tX);
            a.this.fS.postDelayed(a.this.tX, 5000L);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.k
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            a.this.tV.rR();
            a.this.fS.removeCallbacks(a.this.tX);
            a.this.fS.postDelayed(a.this.tX, 5000L);
        }
    };

    private void checkExposure() {
        AdInfo adInfo = this.mAdInfo;
        long j4 = adInfo.adRewardInfo.callBackStrategyInfo.impressionCheckMs;
        if (j4 <= 0 || com.kwad.sdk.core.response.b.a.ag(adInfo) <= 5000) {
            return;
        }
        this.fS.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.4
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.ad.reward.l.a(1, a.this.qo);
            }
        }, j4);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdInfo dQ = e.dQ(this.mAdTemplate);
        this.mAdInfo = dQ;
        this.cB = com.kwad.sdk.core.response.b.a.bm(dQ);
        if (this.qo.oJ.jM()) {
            this.su = this.sv;
        } else {
            this.su = this.gO;
        }
        this.qo.oJ.a(this.su);
        this.fS.postDelayed(this.tX, 5000L);
    }

    public final void hQ() {
        this.cC = false;
        EcOrderCardStyle createFromAdInfo = EcOrderCardStyle.createFromAdInfo(this.mAdInfo);
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        if (createFromAdInfo != null) {
            a.C0688a c0688a = new a.C0688a();
            c0688a.apd = String.valueOf(createFromAdInfo.getValue());
            bVar.b(c0688a);
        }
        if (!this.mAdTemplate.mPvReported) {
            checkExposure();
        }
        com.kwad.components.ad.reward.j.b.a(true, this.mAdTemplate, null, bVar);
        com.kwad.sdk.core.adlog.c.f(this.mAdTemplate, this.qo.mReportExtData);
    }

    public final void hw() {
        g gVar = this.qo;
        if (!gVar.oY || !gVar.pd) {
            com.kwad.sdk.core.adlog.c.g(this.mAdTemplate, gVar.mReportExtData);
        }
        this.tV.rS();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.fS.removeCallbacksAndMessages(null);
        this.qo.oJ.b(this.su);
        i.a rU = this.tV.rU();
        com.kwad.components.core.o.a.qi().a(this.qo.mAdTemplate, this.pm, rU.rX(), rU.rW());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j4) {
        int ceil = (int) Math.ceil(((float) j4) / 1000.0f);
        List<Integer> list = this.cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.cB) {
            if (ceil >= num.intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, ceil, this.qo.mReportExtData);
                this.cB.remove(num);
                return;
            }
        }
    }

    static /* synthetic */ boolean a(a aVar, boolean z3) {
        aVar.tW = false;
        return false;
    }

    static /* synthetic */ boolean b(a aVar, boolean z3) {
        aVar.cC = true;
        return true;
    }
}
