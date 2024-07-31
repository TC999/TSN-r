package com.kwad.components.p208ad.fullscreen.p229c;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.p208ad.fullscreen.p229c.p230a.C7626e;
import com.kwad.components.p208ad.fullscreen.p229c.p231b.C7643a;
import com.kwad.components.p208ad.reward.C7838a;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p252e.AbstractC7880a;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7890j;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7894n;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.C9659R;

/* renamed from: com.kwad.components.ad.fullscreen.c.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7644c extends C8094b implements InterfaceC7890j {

    /* renamed from: hc */
    private View f25934hc;

    /* renamed from: hd */
    private View f25935hd;
    private InterfaceC7886g mPlayEndPageListener = new AbstractC7880a() { // from class: com.kwad.components.ad.fullscreen.c.c.1
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
        /* renamed from: bL */
        public final void mo31009bL() {
            C7644c.this.m32720i(false);
        }
    };

    public C7644c() {
        m24612a(new C7626e());
        m24612a(new C7643a());
    }

    /* renamed from: bX */
    private void m32721bX() {
        C7907g c7907g = this.f26957qo;
        if (c7907g.f26552pa || c7907g.f26545oZ) {
            return;
        }
        this.f25934hc.setVisibility(0);
        this.f25935hd.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m32720i(boolean z) {
        C7907g c7907g = this.f26957qo;
        if ((c7907g.f26552pa || c7907g.f26545oZ) && !z) {
            this.f25934hc.setVisibility(8);
            this.f25935hd.setVisibility(8);
            return;
        }
        this.f25934hc.setVisibility(8);
        this.f25935hd.setVisibility(0);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: a */
    public final void mo31050a(PlayableSource playableSource, @Nullable InterfaceC7894n interfaceC7894n) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f26957qo.m32034b(this.mPlayEndPageListener);
        C7838a.m32198eX().m32205a(this);
        this.f25934hc.setVisibility(0);
        this.f25935hd.setVisibility(8);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: bY */
    public final void mo31048bY() {
        m32721bX();
        if (this.f26957qo.f26545oZ && this.f25935hd.getVisibility() == 0) {
            this.f25935hd.setVisibility(8);
        }
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: bZ */
    public final void mo31047bZ() {
        m32720i(true);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25934hc = findViewById(C9659R.C9662id.ksad_play_detail_top_toolbar);
        this.f25935hd = findViewById(C9659R.C9662id.ksad_play_end_top_toolbar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.m32024c(this.mPlayEndPageListener);
        C7838a.m32198eX().m32203b(this);
    }
}
