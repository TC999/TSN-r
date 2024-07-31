package com.kwad.components.p208ad.p221f.p224c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.p299j.C8682a;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.widget.p338a.C9366b;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.components.p208ad.p246j.C7813b;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.p383a.p384a.C9877a;
import com.kwad.sdk.contentalliance.p383a.p384a.C9878b;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.response.p409b.C10490h;
import com.kwad.sdk.core.video.p411a.InterfaceC10522c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11103l;

/* renamed from: com.kwad.components.ad.f.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7459a extends C7813b {

    /* renamed from: bQ */
    private C9366b f25481bQ;

    /* renamed from: dU */
    private KsAdVideoPlayConfig f25482dU;

    /* renamed from: df */
    private final InterfaceC10385c f25483df;

    /* renamed from: eQ */
    private boolean f25484eQ;

    /* renamed from: eY */
    private C8682a.C8684b f25485eY;

    /* renamed from: fa */
    private OfflineOnAudioConflictListener f25486fa;
    private boolean hasNoCache;
    private final AdInfo mAdInfo;
    private Context mContext;

    /* renamed from: no */
    private boolean f25487no;

    /* renamed from: np */
    private boolean f25488np;

    /* renamed from: nq */
    private C9002l f25489nq;

    public C7459a(@NonNull final AdTemplate adTemplate, @NonNull C9366b c9366b, @NonNull DetailVideoView detailVideoView, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.hasNoCache = false;
        this.f25483df = new InterfaceC10385c() { // from class: com.kwad.components.ad.f.c.a.3
            @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
            /* renamed from: aM */
            public final void mo26182aM() {
                C8682a.m30020oG().m30023a(C7459a.this.getCurrentVoiceItem());
                C7459a.this.resume();
            }

            @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
            /* renamed from: aN */
            public final void mo26181aN() {
                C8682a.m30020oG().m30021c(C7459a.this.f25485eY);
                C7459a.this.pause();
            }
        };
        this.f25486fa = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.f.c.a.5
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                C7459a.m33242c(C7459a.this, false);
                C7459a.this.setAudioEnabled(false);
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.f25481bQ = c9366b;
        AdInfo m25641dQ = C10487e.m25641dQ(this.mAdTemplate);
        this.mAdInfo = m25641dQ;
        if ((ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() != 0) {
            this.f25487no = ksAdVideoPlayConfig.isVideoSoundEnable();
        } else {
            this.f25487no = C10483a.m25888bT(m25641dQ);
        }
        this.f25482dU = ksAdVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        if (ksAdVideoPlayConfig != null) {
            try {
                this.hasNoCache = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                C10331c.printStackTraceOnly(th);
            }
        }
        C9002l c9002l = new C9002l() { // from class: com.kwad.components.ad.f.c.a.1
            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                C8766a.m29888qi().m29900c(adTemplate, i, i2);
            }
        };
        this.f25489nq = c9002l;
        this.f26355Hs.m29464c(c9002l);
        m33246aL();
        this.f26355Hs.m29476a(new InterfaceC10522c.InterfaceC10527e() { // from class: com.kwad.components.ad.f.c.a.2
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10527e
            /* renamed from: a */
            public final void mo25501a(InterfaceC10522c interfaceC10522c) {
                try {
                    if (C7459a.this.m33239eC() && C7459a.this.f25481bQ.mo28897dW()) {
                        C7459a.this.f26355Hs.m29482a(C9877a.m27478bD(C7459a.this.mAdTemplate));
                        C8682a.m30020oG().m30023a(C7459a.this.getCurrentVoiceItem());
                        C7459a.this.f26355Hs.start();
                    }
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        });
    }

    /* renamed from: aL */
    private void m33246aL() {
        this.f26355Hs.m29478a(new C9878b.C9879a(this.mAdTemplate).m27470cR(C10487e.m25639dS(this.mAdTemplate)).m27469cS(C10490h.m25611b(C10487e.m25640dR(this.mAdTemplate))).m27475a(this.mAdTemplate.mVideoPlayerStatus).m27472bl(this.hasNoCache).m27474b(C9877a.m27478bD(this.mAdTemplate)).m27477Bb(), true, true, this.mDetailVideoView);
        setAudioEnabled(m33235g(this.f25487no));
        if (m33239eC()) {
            this.f26355Hs.prepareAsync();
            C8932a.m29575ah(this.mContext).m29577a(this.f25486fa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: eC */
    public boolean m33239eC() {
        if (this.f25488np) {
            return true;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.f25482dU;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return C11013ag.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return C11013ag.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return C11013ag.isWifiConnected(this.mContext) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && C11013ag.isMobileConnected(this.mContext));
            }
        }
        if (C10483a.m25887bU(this.mAdInfo) && C11013ag.isNetworkConnected(this.mContext)) {
            return true;
        }
        return C10483a.m25886bV(this.mAdInfo) && C11013ag.isWifiConnected(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C8682a.C8684b getCurrentVoiceItem() {
        if (this.f25485eY == null) {
            this.f25485eY = new C8682a.C8684b(new C8682a.InterfaceC8685c() { // from class: com.kwad.components.ad.f.c.a.4
                @Override // com.kwad.components.core.p299j.C8682a.InterfaceC8685c
                /* renamed from: bk */
                public final void mo30017bk() {
                    C7459a c7459a = C7459a.this;
                    c7459a.setAudioEnabled(c7459a.m33235g(c7459a.f25487no));
                }
            });
        }
        return this.f25485eY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioEnabled(boolean z) {
        this.f26355Hs.setAudioEnabled(z);
    }

    /* renamed from: aJ */
    public final void m33248aJ() {
        C11103l.m23773el(this.mAdTemplate);
        if (this.f26355Hs.m29448rs() == null) {
            m33246aL();
        }
        if (m33239eC() && this.f25481bQ.mo28897dW()) {
            this.f26355Hs.m29482a(C9877a.m27478bD(this.mAdTemplate));
            C8682a.m30020oG().m30023a(getCurrentVoiceItem());
            this.f26355Hs.start();
        }
        this.f25481bQ.mo26187a(this.f25483df);
    }

    /* renamed from: aK */
    public final void m33247aK() {
        C11103l.m23775ej(this.mAdTemplate);
        this.f25481bQ.mo26186b(this.f25483df);
        this.f26355Hs.release();
        C8682a.m30020oG().m30021c(this.f25485eY);
        C8932a.m29575ah(this.mContext).m29574b(this.f25486fa);
    }

    /* renamed from: eD */
    public final void m33238eD() {
        this.f25488np = true;
        if (this.f25481bQ.mo28897dW()) {
            C11103l.m23774ek(this.mAdTemplate);
            this.f26355Hs.m29482a(C9877a.m27478bD(this.mAdTemplate));
            C8682a.m30020oG().m30023a(getCurrentVoiceItem());
            this.f26355Hs.start();
        }
    }

    @Override // com.kwad.components.p208ad.p246j.C7813b, com.kwad.components.p208ad.p246j.AbstractC7812a
    public final void resume() {
        C8682a.m30020oG().m30023a(getCurrentVoiceItem());
        setAudioEnabled(m33235g(this.f25487no));
        if (m33239eC()) {
            super.resume();
        }
    }

    /* renamed from: c */
    static /* synthetic */ boolean m33242c(C7459a c7459a, boolean z) {
        c7459a.f25484eQ = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public boolean m33235g(boolean z) {
        if (z) {
            if (this.f25485eY != null) {
                C8682a.m30020oG();
                if (!C8682a.m30022b(this.f25485eY)) {
                    return false;
                }
            }
            if (!C10251d.m26517gs()) {
                if (C8932a.m29575ah(this.mContext).m29572qX()) {
                    return !C8932a.m29575ah(this.mContext).m29573qW();
                }
                return C8932a.m29575ah(this.mContext).m29576aN(false);
            }
            if (!this.f25484eQ) {
                this.f25484eQ = C8932a.m29575ah(this.mContext).m29576aN(true);
            }
            return this.f25484eQ;
        }
        return false;
    }
}
