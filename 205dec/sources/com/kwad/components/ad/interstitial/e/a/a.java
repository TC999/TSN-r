package com.kwad.components.ad.interstitial.e.a;

import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.a.i;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.q;
import com.kwad.sdk.widget.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a extends com.kwad.components.ad.interstitial.e.b implements j {
    private i gj;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(aw awVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(t tVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
    }

    @Override // com.kwad.components.ad.interstitial.e.b, com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        this.gj.a(getActivity(), this.jK.mAdResultData, this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public e getTouchCoordsView() {
        return this.jK.jS;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        this.gj = new i(-1L, getContext());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.gj.jp();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
        qVar.c(new com.kwad.components.core.webview.tachikoma.a.i(new i.a() { // from class: com.kwad.components.ad.interstitial.e.a.a.1
            @Override // com.kwad.components.core.webview.tachikoma.a.i.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                com.kwad.components.ad.interstitial.report.a.dM().a(a.this.jK.mAdTemplate, 1L, 177L);
                a.this.a(aVar);
            }
        }));
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0652a c0652a) {
        c cVar = this.jK;
        if (cVar == null || cVar.ie == null) {
            return;
        }
        String str = c0652a.VR;
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -2079474009:
                if (str.equals("adSkipCallback")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1929947611:
                if (str.equals("adShowCallback")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1228923142:
                if (str.equals("adCloseCallback")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1609027339:
                if (str.equals("adAutoCloseCallback")) {
                    c4 = 3;
                    break;
                }
                break;
            case 1852274314:
                if (str.equals("adClickCallback")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.jK.ie.onSkippedAd();
                return;
            case 1:
                this.jK.ie.onAdShow();
                return;
            case 2:
                this.jK.ie.onAdClosed();
                return;
            case 3:
                this.jK.ie.onPageDismiss();
                return;
            case 4:
                this.jK.ie.onAdClicked();
                return;
            default:
                return;
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        c cVar = this.jK;
        cVar.jM = true;
        cVar.b(aVar.aEM, aVar.kl);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        m mVar = new m();
        mVar.aao = !this.jK.dU.isVideoSoundEnable();
        oVar.c(mVar);
    }
}
