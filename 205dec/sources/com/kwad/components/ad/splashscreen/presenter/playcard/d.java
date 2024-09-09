package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.ad.splashscreen.g;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.m;
import com.kwad.sdk.R;
import com.kwad.sdk.components.r;
import com.kwad.sdk.core.response.b.e;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class d extends com.kwad.components.ad.splashscreen.presenter.a.c implements g, com.kwad.sdk.core.h.c {
    f ES = new f() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.d.2
        public final void kx() {
            d.this.ld.setVisibility(8);
            if (d.this.wA != null) {
                d.this.wA.sX();
                d.this.wA.sY();
            }
        }
    };
    private m Fx;
    private FrameLayout ld;
    private aw wA;

    @NonNull
    private m md() {
        m mVar = new m();
        this.Fx = mVar;
        return mVar;
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void W(int i4) {
        m mVar = this.Fx;
        if (mVar != null) {
            mVar.aT(i4);
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        aw awVar;
        if (this.Di.CA || (awVar = this.wA) == null) {
            return;
        }
        awVar.sZ();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        aw awVar;
        if (this.Di.CA || (awVar = this.wA) == null) {
            return;
        }
        awVar.ta();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.splashscreen.monitor.b.kW();
        h hVar = this.Di;
        com.kwad.components.ad.splashscreen.monitor.b.b(hVar.mAdTemplate, hVar.Cs);
        this.Di.Ct.a(this);
        this.Di.a(this);
        this.Di.a(this.ES);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        if (this.Di.CA) {
            return;
        }
        aw awVar = this.wA;
        if (awVar != null) {
            awVar.sV();
            this.wA.sW();
        }
        this.ld.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.ld;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dt(this.Di.mAdTemplate);
    }

    public final void kB() {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c
    public final int mc() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h hVar = this.Di;
        return (int) (com.kwad.sdk.core.response.b.b.ds(e.dS(hVar.mAdTemplate)) - (elapsedRealtime - hVar.CB));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ld = (FrameLayout) findViewById(R.id.splash_tk_play_card_view);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        aw awVar = this.wA;
        if (awVar != null) {
            awVar.sX();
            this.wA.sY();
        }
        super.onUnbind();
        this.Di.Ct.b(this);
        this.Di.b(this.ES);
        this.Di.b(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        aw awVar = this.wA;
        if (awVar != null) {
            awVar.sX();
            this.wA.sY();
        }
        this.ld.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        aVar.width = com.kwad.sdk.c.a.a.px2dip(getContext(), this.Di.mRootContainer.getWidth());
        aVar.height = com.kwad.sdk.c.a.a.px2dip(getContext(), this.Di.mRootContainer.getHeight());
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        super.a(awVar);
        this.wA = awVar;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c
    public final void a(r rVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(rVar, bVar);
        rVar.c(a(bVar));
        rVar.c(md());
    }

    @NonNull
    private x a(com.kwad.sdk.core.webview.b bVar) {
        return new x(bVar, this.Di.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.d.1
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    d.this.Di.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.d.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.this.Di.kC();
                        }
                    });
                }
            }
        });
    }
}
