package com.kwad.components.core.page.d;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.j;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.h;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a implements com.kwad.components.core.l.a.a {
    private b Hs;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean no;
    private l nq;
    private String xL;
    private boolean xN = false;
    private final List<h.a> xO = new ArrayList();
    private OfflineOnAudioConflictListener xQ = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.page.d.a.1
        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            a.a(a.this, true);
            if (a.this.Hs != null) {
                a.this.Hs.setAudioEnabled(false);
            }
            synchronized (a.this.xO) {
                for (h.a aVar : a.this.xO) {
                    aVar.onAudioBeOccupied();
                }
            }
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            synchronized (a.this.xO) {
                for (h.a aVar : a.this.xO) {
                    aVar.onAudioBeReleased();
                }
            }
        }
    };

    public a(@NonNull final AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mAdTemplate = adTemplate;
        Context context = detailVideoView.getContext();
        this.mContext = context;
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        this.xL = j.f(context, adTemplate);
        this.mDetailVideoView = detailVideoView;
        this.Hs = new b(detailVideoView, adTemplate);
        aL();
        l lVar = new l() { // from class: com.kwad.components.core.page.d.a.2
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i4, int i5) {
                super.onMediaPlayError(i4, i5);
                com.kwad.components.core.o.a.qi().c(adTemplate, i4, i5);
            }
        };
        this.nq = lVar;
        this.Hs.c(lVar);
        this.Hs.a(new c.e() { // from class: com.kwad.components.core.page.d.a.3
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(c cVar) {
                try {
                    a.this.Hs.start();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        com.kwad.components.core.s.a.ah(this.mContext).a(this.xQ);
    }

    private void aL() {
        this.Hs.a(new b.a(this.mAdTemplate).cR(this.xL).cS(com.kwad.sdk.core.response.b.h.b(e.dR(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.bD(this.mAdTemplate)).Bb(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Hs.prepareAsync();
    }

    private void pause() {
        SceneImpl sceneImpl;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
            return;
        }
        this.Hs.pause();
    }

    private void resume() {
        this.Hs.resume();
    }

    private void setAudioEnabled(boolean z3, boolean z4) {
        this.no = z3;
        this.Hs.setAudioEnabled(z3);
    }

    @Override // com.kwad.components.core.l.a.a
    public final void c(com.kwad.components.core.proxy.c cVar) {
        resume();
    }

    @Override // com.kwad.components.core.l.a.a
    public final void d(com.kwad.components.core.proxy.c cVar) {
        pause();
    }

    @Override // com.kwad.components.core.l.a.a
    public final void fP() {
        this.xN = false;
        if (this.Hs.rs() == null) {
            aL();
        }
    }

    @Override // com.kwad.components.core.l.a.a
    public final void fQ() {
        this.xN = false;
        com.kwad.components.core.video.b bVar = this.Hs;
        if (bVar != null) {
            bVar.d(this.nq);
            this.Hs.release();
        }
    }

    @MainThread
    public final void release() {
        com.kwad.components.core.video.b bVar = this.Hs;
        if (bVar != null) {
            bVar.clear();
            this.Hs.release();
        }
        com.kwad.components.core.s.a.ah(this.mContext).b(this.xQ);
    }

    static /* synthetic */ boolean a(a aVar, boolean z3) {
        aVar.xN = true;
        return true;
    }

    @MainThread
    public final void b(k kVar) {
        if (kVar == null) {
            return;
        }
        this.Hs.d(kVar);
    }

    @MainThread
    public final void a(k kVar) {
        if (kVar == null) {
            return;
        }
        this.Hs.c(kVar);
    }
}
