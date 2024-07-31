package com.kwad.components.p208ad.reward.p263m;

import android.content.Context;
import androidx.annotation.MainThread;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.core.video.C8978b;
import com.kwad.components.core.video.C9000j;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.components.p208ad.p246j.C7813b;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.p383a.p384a.C9877a;
import com.kwad.sdk.contentalliance.p383a.p384a.C9878b;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.response.p409b.C10490h;
import com.kwad.sdk.core.video.p411a.InterfaceC10522c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11096h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.components.ad.reward.m.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8021d extends C7813b implements C7907g.InterfaceC7920a {

    /* renamed from: kI */
    private boolean f26733kI;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;

    /* renamed from: no */
    private boolean f26734no;

    /* renamed from: nq */
    private C9002l f26735nq;

    /* renamed from: qo */
    private C7907g f26736qo;

    /* renamed from: xL */
    private String f26737xL;

    /* renamed from: xM */
    private AtomicBoolean f26738xM;

    /* renamed from: xN */
    private boolean f26739xN;

    /* renamed from: xO */
    private final List<C11096h.InterfaceC11099a> f26740xO;

    /* renamed from: xP */
    private final List<Object> f26741xP;

    /* renamed from: xQ */
    private OfflineOnAudioConflictListener f26742xQ;

    public C8021d(C7907g c7907g, DetailVideoView detailVideoView) {
        super(c7907g.mAdTemplate, detailVideoView);
        this.f26738xM = new AtomicBoolean(false);
        this.f26739xN = false;
        this.f26733kI = false;
        this.f26740xO = new ArrayList();
        this.f26741xP = new ArrayList();
        this.f26742xQ = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.reward.m.d.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                C8021d.m31840a(C8021d.this, true);
                if (C8021d.this.f26355Hs != null) {
                    C8021d.this.f26355Hs.setAudioEnabled(false);
                }
                synchronized (C8021d.this.f26740xO) {
                    for (C11096h.InterfaceC11099a interfaceC11099a : C8021d.this.f26740xO) {
                        interfaceC11099a.onAudioBeOccupied();
                    }
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
                synchronized (C8021d.this.f26740xO) {
                    for (C11096h.InterfaceC11099a interfaceC11099a : C8021d.this.f26740xO) {
                        interfaceC11099a.onAudioBeReleased();
                    }
                }
            }
        };
        this.f26736qo = c7907g;
        this.mContext = c7907g.mContext;
        this.mVideoPlayConfig = c7907g.mVideoPlayConfig;
        this.mVideoPlayerStatus = this.mAdTemplate.mVideoPlayerStatus;
        this.f26737xL = getVideoUrl();
    }

    /* renamed from: aL */
    private void m31838aL() {
        if (m31830jK()) {
            return;
        }
        this.f26355Hs.m29480a(new C9878b.C9879a(this.mAdTemplate).m27470cR(this.f26737xL).m27469cS(C10490h.m25611b(C10487e.m25640dR(this.mAdTemplate))).m27475a(this.mVideoPlayerStatus).m27474b(C9877a.m27478bD(this.mAdTemplate)).m27477Bb(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.f26355Hs.prepareAsync();
    }

    private String getVideoUrl() {
        return m31830jK() ? "" : C9000j.m29407f(this.mContext, this.mAdTemplate);
    }

    /* renamed from: jK */
    private boolean m31830jK() {
        return C10483a.m25842cL(C10487e.m25641dQ(this.mAdTemplate));
    }

    private void stop() {
        pause();
        this.f26733kI = true;
    }

    @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7920a
    /* renamed from: fU */
    public final void mo31309fU() {
        this.f26739xN = false;
    }

    @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7920a
    /* renamed from: fV */
    public final void mo31308fV() {
        if (this.f26733kI) {
            return;
        }
        resume();
        if (this.f26734no || (C7844b.m32186gs() && this.f26739xN)) {
            C8932a.m29575ah(this.mContext).m29576aN(C7844b.m32186gs());
            if (C7844b.m32186gs() && this.f26739xN) {
                this.f26739xN = false;
                this.f26734no = true;
                setAudioEnabled(true, false);
            } else if (this.f26736qo.f26527oH || !C8932a.m29575ah(this.mContext).m29573qW()) {
            } else {
                this.f26734no = false;
                setAudioEnabled(false, false);
            }
        }
    }

    @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7920a
    /* renamed from: fW */
    public final void mo31307fW() {
        pause();
    }

    @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7920a
    /* renamed from: fX */
    public final void mo31306fX() {
        C8978b c8978b;
        this.f26739xN = false;
        if (!this.f26738xM.get() || (c8978b = this.f26355Hs) == null) {
            return;
        }
        c8978b.m29461d(this.f26735nq);
        this.f26355Hs.release();
    }

    @Override // com.kwad.components.p208ad.p246j.C7813b, com.kwad.components.p208ad.p246j.AbstractC7812a
    public final long getPlayDuration() {
        if (this.f26738xM.get()) {
            return super.getPlayDuration();
        }
        return 0L;
    }

    /* renamed from: jI */
    public final void m31832jI() {
        if (this.f26738xM.get()) {
            return;
        }
        this.f26738xM.set(true);
        m31838aL();
        C9002l c9002l = new C9002l() { // from class: com.kwad.components.ad.reward.m.d.2
            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                C8766a.m29888qi().m29900c(C8021d.this.mAdTemplate, i, i2);
            }
        };
        this.f26735nq = c9002l;
        this.f26355Hs.m29464c(c9002l);
        this.f26355Hs.m29476a(new InterfaceC10522c.InterfaceC10527e() { // from class: com.kwad.components.ad.reward.m.d.3
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10527e
            /* renamed from: a */
            public final void mo25501a(InterfaceC10522c interfaceC10522c) {
                try {
                    C10232b.m26625DD();
                    if (C10232b.isAppOnForeground()) {
                        C8021d.this.f26355Hs.start();
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        this.f26355Hs.start();
        C8932a.m29575ah(this.mContext).m29577a(this.f26742xQ);
    }

    /* renamed from: jJ */
    public final void m31831jJ() {
        Iterator<Object> it = this.f26741xP.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.kwad.components.p208ad.p246j.C7813b, com.kwad.components.p208ad.p246j.AbstractC7812a
    public final void pause() {
        if (!this.f26738xM.get() || this.f26355Hs == null || m31830jK()) {
            return;
        }
        super.pause();
    }

    @Override // com.kwad.components.p208ad.p246j.C7813b, com.kwad.components.p208ad.p246j.AbstractC7812a
    @MainThread
    public final void release() {
        super.release();
        C8932a.m29575ah(this.mContext).m29574b(this.f26742xQ);
    }

    @Override // com.kwad.components.p208ad.p246j.C7813b, com.kwad.components.p208ad.p246j.AbstractC7812a
    public final void resume() {
        this.f26733kI = false;
        if (!this.f26738xM.get() || this.f26355Hs == null || m31830jK() || C7907g.m32031b(this.f26736qo)) {
            return;
        }
        super.resume();
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    public final void setAudioEnabled(boolean z, boolean z2) {
        this.f26734no = z;
        if (!this.f26738xM.get() || this.f26355Hs == null) {
            return;
        }
        if (z && z2) {
            C8932a.m29575ah(this.mContext).m29576aN(true);
        }
        this.f26355Hs.setAudioEnabled(z);
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    @Deprecated
    public final void skipToEnd() {
        C8978b c8978b;
        if (!this.f26738xM.get() || (c8978b = this.f26355Hs) == null) {
            return;
        }
        c8978b.onPlayStateChanged(9);
        stop();
    }

    /* renamed from: a */
    static /* synthetic */ boolean m31840a(C8021d c8021d, boolean z) {
        c8021d.f26739xN = true;
        return true;
    }

    /* renamed from: b */
    public final void m31836b(C11096h.InterfaceC11099a interfaceC11099a) {
        this.f26740xO.remove(interfaceC11099a);
    }

    /* renamed from: a */
    public final void m31839a(C11096h.InterfaceC11099a interfaceC11099a) {
        this.f26740xO.add(interfaceC11099a);
    }
}
