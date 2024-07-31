package com.kwad.components.p208ad.interstitial.p242e.p243a;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.C9031a;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.tachikoma.C9305i;
import com.kwad.components.core.webview.tachikoma.InterfaceC9339j;
import com.kwad.components.core.webview.tachikoma.p333a.C9205i;
import com.kwad.components.core.webview.tachikoma.p333a.C9216o;
import com.kwad.components.core.webview.tachikoma.p333a.C9218p;
import com.kwad.components.core.webview.tachikoma.p334b.C9252m;
import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.components.p208ad.interstitial.p242e.C7760b;
import com.kwad.components.p208ad.interstitial.p242e.C7761c;
import com.kwad.components.p208ad.interstitial.report.C7802a;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.widget.InterfaceC11147e;

/* renamed from: com.kwad.components.ad.interstitial.e.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC7737a extends C7760b implements InterfaceC9339j {

    /* renamed from: gj */
    private C9305i f26160gj;

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public void mo28990a(C9109aw c9109aw) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28987a(C9218p c9218p) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28986a(C9252m c9252m) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public void mo28985a(C9259t c9259t) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public void mo28984a(WebCloseStatus webCloseStatus) {
    }

    @Override // com.kwad.components.p208ad.interstitial.p242e.C7760b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public void mo24610aj() {
        super.mo24610aj();
        this.f26160gj.mo29075a(getActivity(), this.f26196jK.mAdResultData, this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public InterfaceC11147e getTouchCoordsView() {
        return this.f26196jK.f26210jS;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        this.f26160gj = new C9305i(-1L, getContext());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.f26160gj.mo29029jp();
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
        interfaceC9876q.mo27480c(new C9205i(new C9205i.InterfaceC9206a() { // from class: com.kwad.components.ad.interstitial.e.a.a.1
            @Override // com.kwad.components.core.webview.tachikoma.p333a.C9205i.InterfaceC9206a
            /* renamed from: a */
            public final void mo29185a(C10640a c10640a) {
                C7802a.m32299dM().m32302a(AbstractC7737a.this.f26196jK.mAdTemplate, 1L, 177L);
                AbstractC7737a.this.mo28982a(c10640a);
            }
        }));
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28991a(C9031a.C9033a c9033a) {
        C7761c c7761c = this.f26196jK;
        if (c7761c == null || c7761c.f26201ie == null) {
            return;
        }
        String str = c9033a.f29075VR;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2079474009:
                if (str.equals("adSkipCallback")) {
                    c = 0;
                    break;
                }
                break;
            case -1929947611:
                if (str.equals("adShowCallback")) {
                    c = 1;
                    break;
                }
                break;
            case -1228923142:
                if (str.equals("adCloseCallback")) {
                    c = 2;
                    break;
                }
                break;
            case 1609027339:
                if (str.equals("adAutoCloseCallback")) {
                    c = 3;
                    break;
                }
                break;
            case 1852274314:
                if (str.equals("adClickCallback")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f26196jK.f26201ie.onSkippedAd();
                return;
            case 1:
                this.f26196jK.f26201ie.onAdShow();
                return;
            case 2:
                this.f26196jK.f26201ie.onAdClosed();
                return;
            case 3:
                this.f26196jK.f26201ie.onPageDismiss();
                return;
            case 4:
                this.f26196jK.f26201ie.onAdClicked();
                return;
            default:
                return;
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28982a(@Nullable C10640a c10640a) {
        C7761c c7761c = this.f26196jK;
        c7761c.f26204jM = true;
        c7761c.m32456b(c10640a.aEM, c10640a.f29646kl);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28988a(C9216o c9216o) {
        C9252m c9252m = new C9252m();
        c9252m.aao = !this.f26196jK.f26197dU.isVideoSoundEnable();
        c9216o.m29179c(c9252m);
    }
}
