package com.kwad.components.p208ad.splashscreen.p283e;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.components.p208ad.p246j.C7813b;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.p383a.p384a.C9877a;
import com.kwad.sdk.contentalliance.p383a.p384a.C9878b;
import com.kwad.sdk.core.diskcache.p394b.C10291a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.response.p409b.C10490h;
import com.kwad.sdk.core.video.p411a.InterfaceC10522c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11067bq;
import com.kwad.sdk.utils.C11096h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.components.ad.splashscreen.e.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8478a extends C7813b implements InterfaceC10385c {

    /* renamed from: Fm */
    private boolean f27849Fm;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;

    /* renamed from: no */
    private boolean f27850no;

    /* renamed from: xL */
    private String f27851xL;

    /* renamed from: xO */
    private final List<C11096h.InterfaceC11099a> f27852xO;

    /* renamed from: xQ */
    private OfflineOnAudioConflictListener f27853xQ;

    public C8478a(@NonNull AdTemplate adTemplate, @NonNull final DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.f27852xO = new ArrayList();
        this.f27853xQ = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.splashscreen.e.a.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                synchronized (C8478a.this.f27852xO) {
                    for (C11096h.InterfaceC11099a interfaceC11099a : C8478a.this.f27852xO) {
                        interfaceC11099a.onAudioBeOccupied();
                    }
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
                synchronized (C8478a.this.f27852xO) {
                    for (C11096h.InterfaceC11099a interfaceC11099a : C8478a.this.f27852xO) {
                        interfaceC11099a.onAudioBeReleased();
                    }
                }
            }
        };
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        String m25936aZ = C10483a.m25936aZ(C10487e.m25641dQ(adTemplate));
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        File m26391bV = C10291a.m26395Dc().m26391bV(m25936aZ);
        if (m26391bV != null && m26391bV.exists()) {
            this.f27851xL = m26391bV.getAbsolutePath();
        }
        this.f26355Hs.m29476a(new InterfaceC10522c.InterfaceC10527e() { // from class: com.kwad.components.ad.splashscreen.e.a.2
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10527e
            /* renamed from: a */
            public final void mo25501a(InterfaceC10522c interfaceC10522c) {
                C10331c.m26254d("SplashPlayModule", " onPrepared");
                detailVideoView.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.e.a.2.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        boolean m23853a = C11067bq.m23853a(detailVideoView, 50, true);
                        C10331c.m26254d("SplashPlayModule", " onPrepared" + m23853a);
                        if (m23853a) {
                            C8478a.this.f26355Hs.start();
                        }
                    }
                });
            }
        });
        C8932a.m29575ah(this.mContext).m29577a(this.f27853xQ);
    }

    /* renamed from: aL */
    private void m30648aL() {
        this.f26355Hs.m29480a(new C9878b.C9879a(this.mAdTemplate).m27475a(this.mVideoPlayerStatus).m27470cR(this.f27851xL).m27469cS(C10490h.m25611b(C10487e.m25640dR(this.mAdTemplate))).m27474b(C9877a.m27478bD(this.mAdTemplate)).m27477Bb(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.f26355Hs.prepareAsync();
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
        resume();
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
        pause();
    }

    /* renamed from: ae */
    public final void m30647ae(boolean z) {
        this.f27849Fm = true;
    }

    public final long getCurrentPosition() {
        return this.f26355Hs.getCurrentPosition();
    }

    /* renamed from: lO */
    public final void m30644lO() {
        if (this.f26355Hs.m29448rs() == null) {
            m30648aL();
        }
        this.f26355Hs.start();
    }

    @Override // com.kwad.components.p208ad.p246j.C7813b, com.kwad.components.p208ad.p246j.AbstractC7812a
    public final void release() {
        super.release();
        C8932a.m29575ah(this.mContext).m29574b(this.f27853xQ);
    }

    @Override // com.kwad.components.p208ad.p246j.C7813b, com.kwad.components.p208ad.p246j.AbstractC7812a
    public final void resume() {
        super.resume();
        if (this.f27850no && this.f27849Fm) {
            C8932a.m29575ah(this.mContext).m29576aN(false);
            if (C8932a.m29575ah(this.mContext).m29573qW()) {
                this.f27850no = false;
                setAudioEnabled(false, false);
            }
        }
    }

    @Override // com.kwad.components.p208ad.p246j.AbstractC7812a
    public final void setAudioEnabled(boolean z, boolean z2) {
        this.f27850no = z;
        if (z && z2) {
            C8932a.m29575ah(this.mContext).m29576aN(true);
        }
        this.f26355Hs.setAudioEnabled(z);
    }

    /* renamed from: a */
    public final void m30649a(C11096h.InterfaceC11099a interfaceC11099a) {
        this.f27852xO.add(interfaceC11099a);
    }

    /* renamed from: b */
    public final void m30645b(C11096h.InterfaceC11099a interfaceC11099a) {
        this.f27852xO.remove(interfaceC11099a);
    }
}
