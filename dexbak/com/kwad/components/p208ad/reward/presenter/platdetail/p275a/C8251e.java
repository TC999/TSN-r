package com.kwad.components.p208ad.reward.presenter.platdetail.p275a;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.p208ad.reward.C7838a;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p252e.AbstractC7880a;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7890j;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7894n;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.components.p208ad.reward.presenter.p268d.C8112a;
import com.kwad.components.p208ad.reward.presenter.platdetail.C8233a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.utils.C11015ai;

/* renamed from: com.kwad.components.ad.reward.presenter.platdetail.a.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8251e extends C8094b implements InterfaceC7890j {
    private InterfaceC7886g mPlayEndPageListener = new AbstractC7880a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.e.1
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
        /* renamed from: bL */
        public final void mo31009bL() {
            C8251e.this.m31206is();
        }
    };

    /* renamed from: vv */
    private View f27250vv;

    /* renamed from: vw */
    private View f27251vw;

    /* renamed from: vx */
    private ImageView f27252vx;

    public C8251e() {
        m24612a(new C8233a());
        m24612a(new C8112a());
    }

    /* renamed from: ir */
    private void m31207ir() {
        if (!this.f26957qo.f26552pa) {
            this.f27251vw.setVisibility(8);
        }
        this.f27250vv.setVisibility(0);
        getContext();
        if (C7907g.m32063F(this.f26957qo.mAdTemplate) && C11015ai.m24123LZ()) {
            this.f27252vx.setVisibility(8);
        }
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: a */
    public final void mo31050a(PlayableSource playableSource, @Nullable InterfaceC7894n interfaceC7894n) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f27250vv.setVisibility(0);
        this.f27251vw.setVisibility(8);
        this.f26957qo.m32034b(this.mPlayEndPageListener);
        C7838a.m32198eX().m32205a(this);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: bY */
    public final void mo31048bY() {
        m31207ir();
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: bZ */
    public final void mo31047bZ() {
        m31206is();
    }

    /* renamed from: is */
    public final void m31206is() {
        if (this.f26957qo.f26552pa) {
            this.f27250vv.setVisibility(8);
        } else {
            this.f27250vv.setVisibility(8);
            this.f27251vw.setVisibility(0);
        }
        getContext();
        if (C7907g.m32063F(this.f26957qo.mAdTemplate) && C11015ai.m24123LZ()) {
            this.f27252vx.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27250vv = findViewById(C9659R.C9662id.ksad_play_detail_top_toolbar);
        this.f27251vw = findViewById(C9659R.C9662id.ksad_play_end_top_toolbar);
        this.f27252vx = (ImageView) findViewById(C9659R.C9662id.ksad_blur_end_cover);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        m31207ir();
        this.f26957qo.m32024c(this.mPlayEndPageListener);
        C7838a.m32198eX().m32203b(this);
        this.f27251vw.setVisibility(8);
    }
}
