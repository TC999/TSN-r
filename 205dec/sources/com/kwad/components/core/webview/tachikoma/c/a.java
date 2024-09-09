package com.kwad.components.core.webview.tachikoma.c;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.q;
import com.kwad.sdk.mvp.Presenter;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a extends Presenter implements j {
    protected b aay;
    protected i gj;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(t tVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(b bVar) {
    }

    public void a(WebCloseStatus webCloseStatus) {
        e eVar = this.aay.YI;
        if (eVar != null) {
            eVar.dismiss();
        }
    }

    public void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
    }

    public void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        b bVar = (b) Jx();
        this.aay = bVar;
        a(bVar);
        if (this.gj == null) {
            this.gj = hN();
        }
        StyleTemplate styleTemplate = this.aay.SA;
        if (styleTemplate != null) {
            this.gj.a(styleTemplate);
        }
        i iVar = this.gj;
        b bVar2 = this.aay;
        iVar.a(bVar2.mActivity, bVar2.mAdResultData, this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.aay.aaz;
    }

    protected i hN() {
        return new i(this.aay.xs, getContext());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.gj.jp();
        this.gj = null;
    }
}
