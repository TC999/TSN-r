package com.kwad.components.ad.draw.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.j.b;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends b {
    private com.kwad.components.core.widget.a.b bQ;
    private long dc;
    private com.kwad.sdk.contentalliance.a.a.a dd;
    private boolean de;
    private final c df;
    private Context mContext;

    public a(@NonNull AdTemplate adTemplate, @NonNull com.kwad.components.core.widget.a.b bVar, @NonNull DetailVideoView detailVideoView) {
        super(adTemplate, detailVideoView);
        this.df = new c() { // from class: com.kwad.components.ad.draw.c.a.2
            @Override // com.kwad.sdk.core.h.c
            public final void aM() {
                if (a.this.dd == null) {
                    a aVar = a.this;
                    aVar.dd = com.kwad.sdk.contentalliance.a.a.a.bD(aVar.mAdTemplate);
                    a.this.Hs.a(a.this.dd);
                }
                if (a.this.de) {
                    return;
                }
                a.this.resume();
            }

            @Override // com.kwad.sdk.core.h.c
            public final void aN() {
                a.this.pause();
            }
        };
        this.dc = com.kwad.sdk.core.response.b.a.ab(e.dQ(this.mAdTemplate));
        this.bQ = bVar;
        this.mContext = detailVideoView.getContext();
        aL();
        this.Hs.a(new c.e() { // from class: com.kwad.components.ad.draw.c.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    a.this.start(l.em(a.this.mAdTemplate));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    private void aL() {
        this.Hs.a(new b.a(this.mAdTemplate).cR(e.dS(this.mAdTemplate)).cS(h.b(e.dR(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).Bb(), this.mDetailVideoView);
        this.Hs.prepareAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(long j4) {
        if (this.bQ.dW()) {
            this.Hs.a(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, j4));
            this.Hs.start();
        }
    }

    public final void aJ() {
        long em = l.em(this.mAdTemplate);
        if (this.Hs.rs() == null) {
            aL();
        }
        start(em);
        this.bQ.a(this.df);
    }

    public final void aK() {
        this.dd = null;
        this.bQ.b(this.df);
        this.Hs.release();
    }

    public final void f(boolean z3) {
        this.de = z3;
    }

    @Override // com.kwad.components.ad.j.b, com.kwad.components.ad.j.a
    public final void resume() {
        super.resume();
        com.kwad.components.core.s.a.ah(this.mContext).aN(false);
    }
}
