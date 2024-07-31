package com.kwad.components.p208ad.fullscreen.p229c.p232c;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.p208ad.reward.C7838a;
import com.kwad.components.p208ad.reward.monitor.C8031b;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7890j;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7894n;
import com.kwad.components.p208ad.reward.presenter.p272f.AbstractC8149a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p409b.C10484b;

/* renamed from: com.kwad.components.ad.fullscreen.c.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7647b extends AbstractC8149a {

    /* renamed from: hR */
    private FrameLayout f25937hR;

    /* renamed from: hS */
    private InterfaceC7890j f25938hS = new InterfaceC7890j() { // from class: com.kwad.components.ad.fullscreen.c.c.b.1
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
        /* renamed from: a */
        public final void mo31050a(PlayableSource playableSource, @Nullable InterfaceC7894n interfaceC7894n) {
        }

        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
        /* renamed from: bY */
        public final void mo31048bY() {
            C7647b.this.f25937hR.setVisibility(0);
        }

        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
        /* renamed from: bZ */
        public final void mo31047bZ() {
            C7647b.this.f25937hR.setVisibility(4);
        }
    };

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f26957qo.f26545oZ = true;
        C7838a.m32198eX().m32205a(this.f25938hS);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final FrameLayout getTKContainer() {
        return this.f25937hR;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTKReaderScene() {
        return "tk_fullscreen";
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTkTemplateId() {
        return C10484b.m25691dp(this.f26957qo.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25937hR = (FrameLayout) findViewById(C9659R.C9662id.ksad_js_full_card);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C7838a.m32198eX().m32203b(this.f25938hS);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28989a(TKRenderFailReason tKRenderFailReason) {
        super.mo28989a(tKRenderFailReason);
        C10331c.m26254d("jky", "fullscreen onTkLoadFailed: " + tKRenderFailReason);
        C8031b.m31783a(this.mAdTemplate, tKRenderFailReason);
        this.f25937hR.setVisibility(8);
        this.f26957qo.f26545oZ = false;
    }
}
