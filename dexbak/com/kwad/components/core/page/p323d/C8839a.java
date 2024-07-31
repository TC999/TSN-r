package com.kwad.components.core.page.p323d;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.core.p301l.p302a.InterfaceC8689a;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.core.proxy.AbstractC8886c;
import com.kwad.components.core.video.C8978b;
import com.kwad.components.core.video.C9000j;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.p383a.p384a.C9877a;
import com.kwad.sdk.contentalliance.p383a.p384a.C9878b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.response.p409b.C10490h;
import com.kwad.sdk.core.video.p411a.InterfaceC10522c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11096h;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.components.core.page.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8839a implements InterfaceC8689a {

    /* renamed from: Hs */
    private C8978b f28616Hs;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;

    /* renamed from: no */
    private boolean f28617no;

    /* renamed from: nq */
    private C9002l f28618nq;

    /* renamed from: xL */
    private String f28619xL;

    /* renamed from: xN */
    private boolean f28620xN = false;

    /* renamed from: xO */
    private final List<C11096h.InterfaceC11099a> f28621xO = new ArrayList();

    /* renamed from: xQ */
    private OfflineOnAudioConflictListener f28622xQ = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.page.d.a.1
        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            C8839a.m29762a(C8839a.this, true);
            if (C8839a.this.f28616Hs != null) {
                C8839a.this.f28616Hs.setAudioEnabled(false);
            }
            synchronized (C8839a.this.f28621xO) {
                for (C11096h.InterfaceC11099a interfaceC11099a : C8839a.this.f28621xO) {
                    interfaceC11099a.onAudioBeOccupied();
                }
            }
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            synchronized (C8839a.this.f28621xO) {
                for (C11096h.InterfaceC11099a interfaceC11099a : C8839a.this.f28621xO) {
                    interfaceC11099a.onAudioBeReleased();
                }
            }
        }
    };

    public C8839a(@NonNull final AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mAdTemplate = adTemplate;
        Context context = detailVideoView.getContext();
        this.mContext = context;
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        this.f28619xL = C9000j.m29407f(context, adTemplate);
        this.mDetailVideoView = detailVideoView;
        this.f28616Hs = new C8978b(detailVideoView, adTemplate);
        m29760aL();
        C9002l c9002l = new C9002l() { // from class: com.kwad.components.core.page.d.a.2
            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                C8766a.m29888qi().m29900c(adTemplate, i, i2);
            }
        };
        this.f28618nq = c9002l;
        this.f28616Hs.m29464c(c9002l);
        this.f28616Hs.m29476a(new InterfaceC10522c.InterfaceC10527e() { // from class: com.kwad.components.core.page.d.a.3
            @Override // com.kwad.sdk.core.video.p411a.InterfaceC10522c.InterfaceC10527e
            /* renamed from: a */
            public final void mo25501a(InterfaceC10522c interfaceC10522c) {
                try {
                    C8839a.this.f28616Hs.start();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        C8932a.m29575ah(this.mContext).m29577a(this.f28622xQ);
    }

    /* renamed from: aL */
    private void m29760aL() {
        this.f28616Hs.m29480a(new C9878b.C9879a(this.mAdTemplate).m27470cR(this.f28619xL).m27469cS(C10490h.m25611b(C10487e.m25640dR(this.mAdTemplate))).m27475a(this.mVideoPlayerStatus).m27474b(C9877a.m27478bD(this.mAdTemplate)).m27477Bb(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.f28616Hs.prepareAsync();
    }

    private void pause() {
        SceneImpl sceneImpl;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
            return;
        }
        this.f28616Hs.pause();
    }

    private void resume() {
        this.f28616Hs.resume();
    }

    private void setAudioEnabled(boolean z, boolean z2) {
        this.f28617no = z;
        this.f28616Hs.setAudioEnabled(z);
    }

    @Override // com.kwad.components.core.p301l.p302a.InterfaceC8689a
    /* renamed from: c */
    public final void mo29623c(AbstractC8886c abstractC8886c) {
        resume();
    }

    @Override // com.kwad.components.core.p301l.p302a.InterfaceC8689a
    /* renamed from: d */
    public final void mo29622d(AbstractC8886c abstractC8886c) {
        pause();
    }

    @Override // com.kwad.components.core.p301l.p302a.InterfaceC8689a
    /* renamed from: fP */
    public final void mo29621fP() {
        this.f28620xN = false;
        if (this.f28616Hs.m29448rs() == null) {
            m29760aL();
        }
    }

    @Override // com.kwad.components.core.p301l.p302a.InterfaceC8689a
    /* renamed from: fQ */
    public final void mo29620fQ() {
        this.f28620xN = false;
        C8978b c8978b = this.f28616Hs;
        if (c8978b != null) {
            c8978b.m29461d(this.f28618nq);
            this.f28616Hs.release();
        }
    }

    @MainThread
    public final void release() {
        C8978b c8978b = this.f28616Hs;
        if (c8978b != null) {
            c8978b.clear();
            this.f28616Hs.release();
        }
        C8932a.m29575ah(this.mContext).m29574b(this.f28622xQ);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m29762a(C8839a c8839a, boolean z) {
        c8839a.f28620xN = true;
        return true;
    }

    @MainThread
    /* renamed from: b */
    public final void m29758b(InterfaceC9001k interfaceC9001k) {
        if (interfaceC9001k == null) {
            return;
        }
        this.f28616Hs.m29461d(interfaceC9001k);
    }

    @MainThread
    /* renamed from: a */
    public final void m29761a(InterfaceC9001k interfaceC9001k) {
        if (interfaceC9001k == null) {
            return;
        }
        this.f28616Hs.m29464c(interfaceC9001k);
    }
}
