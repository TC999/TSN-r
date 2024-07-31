package com.kwad.components.core.webview.tachikoma.p335c;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.C9305i;
import com.kwad.components.core.webview.tachikoma.InterfaceC9339j;
import com.kwad.components.core.webview.tachikoma.p333a.C9216o;
import com.kwad.components.core.webview.tachikoma.p333a.C9218p;
import com.kwad.components.core.webview.tachikoma.p334b.C9252m;
import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.components.offline.api.p341tk.model.StyleTemplate;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.InterfaceC11147e;

/* renamed from: com.kwad.components.core.webview.tachikoma.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC9266a extends Presenter implements InterfaceC9339j {
    protected C9267b aay;

    /* renamed from: gj */
    protected C9305i f29322gj;

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28988a(C9216o c9216o) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public void mo28987a(C9218p c9218p) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28986a(C9252m c9252m) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public void mo28985a(C9259t c9259t) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29159a(C9267b c9267b) {
    }

    /* renamed from: a */
    public void mo28984a(WebCloseStatus webCloseStatus) {
        DialogFragmentC9274e dialogFragmentC9274e = this.aay.f29325YI;
        if (dialogFragmentC9274e != null) {
            dialogFragmentC9274e.dismiss();
        }
    }

    /* renamed from: a */
    public void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
    }

    /* renamed from: a */
    public void mo28982a(@Nullable C10640a c10640a) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public void mo24610aj() {
        super.mo24610aj();
        C9267b c9267b = (C9267b) m24613Jx();
        this.aay = c9267b;
        mo29159a(c9267b);
        if (this.f29322gj == null) {
            this.f29322gj = mo29161hN();
        }
        StyleTemplate styleTemplate = this.aay.f29323SA;
        if (styleTemplate != null) {
            this.f29322gj.m29060a(styleTemplate);
        }
        C9305i c9305i = this.f29322gj;
        C9267b c9267b2 = this.aay;
        c9305i.mo29075a(c9267b2.mActivity, c9267b2.mAdResultData, this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bG */
    public void mo28979bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public InterfaceC11147e getTouchCoordsView() {
        return this.aay.aaz;
    }

    /* renamed from: hN */
    protected C9305i mo29161hN() {
        return new C9305i(this.aay.f29327xs, getContext());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f29322gj.mo29029jp();
        this.f29322gj = null;
    }
}
