package com.kwad.components.p208ad.reward.presenter.p267c;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.video.C8998i;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.C7996l;
import com.kwad.components.p208ad.reward.model.EcOrderCardStyle;
import com.kwad.components.p208ad.reward.monitor.C8031b;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.p257j.C7955b;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import java.util.List;

/* renamed from: com.kwad.components.ad.reward.presenter.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8106a extends C8094b {

    /* renamed from: cB */
    private List<Integer> f26976cB;
    private AdInfo mAdInfo;

    /* renamed from: su */
    private C9002l f26981su;

    /* renamed from: tV */
    private final C8998i f26983tV = new C8998i();

    /* renamed from: pm */
    private long f26980pm = 0;

    /* renamed from: fS */
    private Handler f26978fS = new Handler(Looper.getMainLooper());

    /* renamed from: tW */
    private boolean f26984tW = true;

    /* renamed from: cC */
    private volatile boolean f26977cC = false;

    /* renamed from: tX */
    private Runnable f26985tX = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.1
        @Override // java.lang.Runnable
        public final void run() {
            if (C8106a.this.f26983tV.m29416rT()) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - C8106a.this.f26983tV.m29414rV();
                int m29413rW = C8106a.this.f26983tV.m29415rU().m29413rW();
                C8106a.this.f26957qo.m32056a(elapsedRealtime, C8106a.this.f26983tV.m29415rU().m29412rX(), m29413rW);
            } else if (C8106a.this.f26984tW) {
                C8106a.this.f26957qo.m32056a(5000L, 5000L, 1);
            }
            C8766a.m29888qi().m29905aw(C8106a.this.mAdTemplate);
        }
    };

    /* renamed from: sv */
    private C9002l f26982sv = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.c.a.2
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            C8106a.this.m31565hw();
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            C8106a.this.f26983tV.m29417rS();
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            C8106a.this.m31573c(j2);
            C8106a.this.f26980pm = j2;
            C8106a.this.f26983tV.m29417rS();
            C8106a.m31577a(C8106a.this, false);
            C8106a.this.f26957qo.f26564pm = j2;
            if (C8106a.this.f26977cC) {
                return;
            }
            C8106a.m31574b(C8106a.this, true);
            C8766a.m29888qi().m29902b(C8106a.this.mAdTemplate, System.currentTimeMillis(), 1);
            C8032c.m31757b(C8106a.this.f26957qo.f26544oY, C8106a.this.mAdTemplate, C8106a.this.f26957qo.mPageEnterTime);
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            C8106a.this.m31566hQ();
        }
    };

    /* renamed from: gO */
    private C9002l f26979gO = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.c.a.3
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayCompleted() {
            C8106a.this.m31565hw();
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayError(int i, int i2) {
            super.onMediaPlayError(i, i2);
            C8032c.m31767a(C8106a.this.f26957qo.f26544oY, C8106a.this.f26957qo.mAdTemplate, C8106a.this.f26957qo.f26573pv, i, i2);
            C8031b.m31778c(C8106a.this.f26957qo.f26544oY, C8106a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            C8106a.this.f26983tV.m29417rS();
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            C8106a.this.m31573c(j2);
            C8106a.this.f26980pm = j2;
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            C8106a.this.m31566hQ();
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            C8106a.this.f26983tV.m29417rS();
            C8106a.m31577a(C8106a.this, false);
            if (C8106a.this.f26977cC) {
                return;
            }
            C8106a.m31574b(C8106a.this, true);
            C8766a.m29888qi().m29902b(C8106a.this.mAdTemplate, System.currentTimeMillis(), 1);
            C8032c.m31757b(C8106a.this.f26957qo.f26544oY, C8106a.this.mAdTemplate, C8106a.this.f26957qo.mPageEnterTime);
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC9001k
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            C8106a.this.f26983tV.m29418rR();
            C8106a.this.f26978fS.removeCallbacks(C8106a.this.f26985tX);
            C8106a.this.f26978fS.postDelayed(C8106a.this.f26985tX, 5000L);
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC9001k
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            C8106a.this.f26983tV.m29418rR();
            C8106a.this.f26978fS.removeCallbacks(C8106a.this.f26985tX);
            C8106a.this.f26978fS.postDelayed(C8106a.this.f26985tX, 5000L);
        }
    };

    private void checkExposure() {
        AdInfo adInfo = this.mAdInfo;
        long j = adInfo.adRewardInfo.callBackStrategyInfo.impressionCheckMs;
        if (j <= 0 || C10483a.m25929ag(adInfo) <= 5000) {
            return;
        }
        this.f26978fS.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.4
            @Override // java.lang.Runnable
            public final void run() {
                C7996l.m31898a(1, C8106a.this.f26957qo);
            }
        }, j);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
        this.mAdInfo = m25641dQ;
        this.f26976cB = C10483a.m25867bm(m25641dQ);
        if (this.f26957qo.f26529oJ.m31821jM()) {
            this.f26981su = this.f26982sv;
        } else {
            this.f26981su = this.f26979gO;
        }
        this.f26957qo.f26529oJ.m31828a(this.f26981su);
        this.f26978fS.postDelayed(this.f26985tX, 5000L);
    }

    /* renamed from: hQ */
    public final void m31566hQ() {
        this.f26977cC = false;
        EcOrderCardStyle createFromAdInfo = EcOrderCardStyle.createFromAdInfo(this.mAdInfo);
        C9913b c9913b = new C9913b();
        if (createFromAdInfo != null) {
            C9893a.C9894a c9894a = new C9893a.C9894a();
            c9894a.apd = String.valueOf(createFromAdInfo.getValue());
            c9913b.m27268b(c9894a);
        }
        if (!this.mAdTemplate.mPvReported) {
            checkExposure();
        }
        C7955b.m31926a(true, this.mAdTemplate, null, c9913b);
        C9908c.m27305f(this.mAdTemplate, this.f26957qo.mReportExtData);
    }

    /* renamed from: hw */
    public final void m31565hw() {
        C7907g c7907g = this.f26957qo;
        if (!c7907g.f26544oY || !c7907g.f26555pd) {
            C9908c.m27304g(this.mAdTemplate, c7907g.mReportExtData);
        }
        this.f26983tV.m29417rS();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26978fS.removeCallbacksAndMessages(null);
        this.f26957qo.f26529oJ.m31826b(this.f26981su);
        C8998i.C8999a m29415rU = this.f26983tV.m29415rU();
        C8766a.m29888qi().m29914a(this.f26957qo.mAdTemplate, this.f26980pm, m29415rU.m29412rX(), m29415rU.m29413rW());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m31573c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f26976cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f26976cB) {
            if (ceil >= num.intValue()) {
                C9908c.m27348a(this.mAdTemplate, ceil, this.f26957qo.mReportExtData);
                this.f26976cB.remove(num);
                return;
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m31577a(C8106a c8106a, boolean z) {
        c8106a.f26984tW = false;
        return false;
    }

    /* renamed from: b */
    static /* synthetic */ boolean m31574b(C8106a c8106a, boolean z) {
        c8106a.f26977cC = true;
        return true;
    }
}
