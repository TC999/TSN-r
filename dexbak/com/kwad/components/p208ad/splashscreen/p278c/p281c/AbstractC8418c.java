package com.kwad.components.p208ad.splashscreen.p278c.p281c;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.C9031a;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.tachikoma.InterfaceC9339j;
import com.kwad.components.core.webview.tachikoma.p333a.C9216o;
import com.kwad.components.core.webview.tachikoma.p333a.C9218p;
import com.kwad.components.core.webview.tachikoma.p334b.C9252m;
import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.components.p208ad.splashscreen.p278c.C8421e;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.widget.InterfaceC11147e;

/* renamed from: com.kwad.components.ad.splashscreen.c.c.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8418c extends C8421e implements InterfaceC9339j {

    /* renamed from: Fl */
    private C8417b f27731Fl;

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28991a(C9031a.C9033a c9033a) {
        String str = c9033a.f29075VR;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1929947611:
                if (str.equals("adShowCallback")) {
                    c = 0;
                    break;
                }
                break;
            case -1291763712:
                if (str.equals("adDownloadConfirmTipCancel")) {
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
            case -532703741:
                if (str.equals("adDownloadConfirmTipShow")) {
                    c = 3;
                    break;
                }
                break;
            case -268512828:
                if (str.equals("adDownloadConfirmTipDismiss")) {
                    c = 4;
                    break;
                }
                break;
            case 1609027339:
                if (str.equals("adAutoCloseCallback")) {
                    c = 5;
                    break;
                }
                break;
            case 1699234957:
                if (str.equals("adShowErrorCallback")) {
                    c = 6;
                    break;
                }
                break;
            case 1852274314:
                if (str.equals("adClickCallback")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f27734Dg.m30611kF();
                return;
            case 1:
                this.f27734Dg.m30606kK();
                return;
            case 2:
                this.f27734Dg.m30609kH();
                return;
            case 3:
                this.f27734Dg.m30607kJ();
                return;
            case 4:
                this.f27734Dg.m30605kL();
                return;
            case 5:
                this.f27734Dg.m30610kG();
                return;
            case 6:
                this.f27734Dg.m30612kE();
                return;
            case 7:
                this.f27734Dg.m30608kI();
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo28990a(C9109aw c9109aw) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28988a(C9216o c9216o) {
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
    public final void mo28985a(C9259t c9259t) {
    }

    /* renamed from: a */
    public void mo28984a(WebCloseStatus webCloseStatus) {
    }

    /* renamed from: a */
    public void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28982a(@Nullable C10640a c10640a) {
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public void mo24610aj() {
        super.mo24610aj();
        int mo30759lJ = mo30759lJ();
        C8417b c8417b = new C8417b(getContext(), mo30759lJ, mo30759lJ);
        this.f27731Fl = c8417b;
        c8417b.mo29075a((Activity) null, this.f27734Dg.mAdResultData, this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bG */
    public final void mo28979bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public InterfaceC11147e getTouchCoordsView() {
        return this.f27734Dg.mRootContainer;
    }

    /* renamed from: lJ */
    protected int mo30759lJ() {
        return 1000;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.f27731Fl.mo29029jp();
    }
}
