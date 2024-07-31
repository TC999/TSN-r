package com.kwad.components.p208ad.draw.p215b.p216a;

import android.view.View;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.p330s.C8934b;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.p208ad.draw.p214a.C7357a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.utils.C11103l;
import com.kwad.sdk.widget.InterfaceC11154j;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.draw.b.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7364a extends C7357a {

    /* renamed from: cB */
    private List<Integer> f25292cB;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* renamed from: bR */
    private boolean f25291bR = false;

    /* renamed from: cC */
    private volatile boolean f25293cC = false;

    /* renamed from: cD */
    private InterfaceC11154j f25294cD = new InterfaceC11154j() { // from class: com.kwad.components.ad.draw.b.a.a.1
        @Override // com.kwad.sdk.widget.InterfaceC11154j
        /* renamed from: ao */
        public final void mo23526ao() {
            C11103l.m23773el(C7364a.this.mAdTemplate);
        }
    };
    private InterfaceC9001k mVideoPlayStateListener = new C9002l() { // from class: com.kwad.components.ad.draw.b.a.a.2
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayCompleted() {
            C9908c.m27323bL(C7364a.this.mAdTemplate);
            if (C7364a.this.f25273bO.f25274bN != null) {
                try {
                    C7364a.this.f25273bO.f25274bN.onVideoPlayEnd();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayError(int i, int i2) {
            super.onMediaPlayError(i, i2);
            if (C7364a.this.f25273bO.f25274bN != null) {
                try {
                    C7364a.this.f25273bO.f25274bN.onVideoPlayError();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            if (C7364a.this.f25273bO.f25274bN != null) {
                try {
                    C7364a.this.f25273bO.f25274bN.onVideoPlayPause();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
            C7364a.this.f25291bR = true;
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            C7364a.this.m33427c(j2);
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayStart() {
            C7364a.this.f25293cC = false;
            if (!C7364a.this.mAdTemplate.mPvReported && C7364a.this.f25273bO.f25274bN != null) {
                C7364a.this.f25273bO.f25274bN.onAdShow();
            }
            if (C7364a.this.f25273bO.f25274bN != null) {
                try {
                    C7364a.this.f25273bO.f25274bN.onVideoPlayStart();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
                C7364a.this.f25291bR = false;
            }
            C8934b.m29570qY().m29571a(C7364a.this.mAdTemplate, null, null);
            C9908c.m27324bK(C7364a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (C7364a.this.f25291bR) {
                C7364a.this.f25291bR = false;
                if (C7364a.this.f25273bO.f25274bN != null) {
                    try {
                        C7364a.this.f25273bO.f25274bN.onVideoPlayResume();
                    } catch (Throwable th) {
                        C10331c.printStackTraceOnly(th);
                    }
                }
            } else if (C7364a.this.f25293cC) {
            } else {
                C7364a.this.f25293cC = true;
                C8766a.m29888qi().m29902b(C7364a.this.mAdTemplate, System.currentTimeMillis(), 1);
            }
        }
    };

    @Override // com.kwad.components.p208ad.draw.p214a.C7357a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        AdTemplate adTemplate = this.f25273bO.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        this.mAdInfo = m25641dQ;
        this.f25292cB = C10483a.m25867bm(m25641dQ);
        this.f25273bO.f25275bP.mo31843b(this.mVideoPlayStateListener);
        m33430a(this.f25294cD);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f25273bO.f25275bP.mo31844a(this.mVideoPlayStateListener);
        m33430a((InterfaceC11154j) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m33427c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.f25292cB;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.f25292cB) {
            if (ceil >= num.intValue()) {
                C9908c.m27348a(this.mAdTemplate, ceil, (JSONObject) null);
                this.f25292cB.remove(num);
                return;
            }
        }
    }

    /* renamed from: a */
    private void m33430a(InterfaceC11154j interfaceC11154j) {
        View rootView = getRootView();
        if (rootView instanceof AdBasePvFrameLayout) {
            ((AdBasePvFrameLayout) rootView).setVisibleListener(interfaceC11154j);
        }
    }
}
