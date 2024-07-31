package com.kwad.components.p208ad.reward.presenter.p272f;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.p333a.C9197e;
import com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9289a;
import com.kwad.components.p208ad.reward.C7838a;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p252e.AbstractC7880a;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7890j;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7894n;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7895o;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.InterfaceC8259a;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.p430d.p431a.C10751a;

/* renamed from: com.kwad.components.ad.reward.presenter.f.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8189h extends AbstractC8188g implements InterfaceC7890j, InterfaceC8259a {

    /* renamed from: wA */
    private boolean f27117wA;

    /* renamed from: wB */
    private boolean f27118wB;
    @Nullable

    /* renamed from: wE */
    private View f27119wE;

    /* renamed from: wz */
    private C9109aw f27122wz;

    /* renamed from: wF */
    private boolean f27120wF = false;
    private InterfaceC7886g mPlayEndPageListener = new AbstractC7880a() { // from class: com.kwad.components.ad.reward.presenter.f.h.1
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
        /* renamed from: bL */
        public final void mo31009bL() {
            C8189h.this.f27116wD.setVisibility(8);
        }
    };

    /* renamed from: wG */
    private C7907g.InterfaceC7920a f27121wG = new C7907g.InterfaceC7920a() { // from class: com.kwad.components.ad.reward.presenter.f.h.2
        @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7920a
        /* renamed from: fU */
        public final void mo31309fU() {
            C8189h.this.f27118wB = true;
        }

        @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7920a
        /* renamed from: fV */
        public final void mo31308fV() {
            C8189h.this.f27118wB = true;
            C8189h.this.m31311iY();
        }

        @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7920a
        /* renamed from: fW */
        public final void mo31307fW() {
            C8189h.this.f27118wB = false;
            if (C8189h.this.f27122wz != null) {
                C8189h.this.f27122wz.m29263sw();
            }
        }

        @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7920a
        /* renamed from: fX */
        public final void mo31306fX() {
            C8189h.this.f27118wB = false;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: iY */
    public void m31311iY() {
        C9109aw c9109aw = this.f27122wz;
        if (c9109aw == null || !this.f27118wB) {
            return;
        }
        if (!this.f27117wA) {
            c9109aw.m29268sr();
            this.f27122wz.m29267ss();
            this.f27117wA = true;
            return;
        }
        c9109aw.m29264sv();
    }

    /* renamed from: jb */
    private C9197e.InterfaceC9199b m31310jb() {
        return new C9197e.InterfaceC9199b() { // from class: com.kwad.components.ad.reward.presenter.f.h.3
            @Override // com.kwad.components.core.webview.tachikoma.p333a.C9197e.InterfaceC9199b
            /* renamed from: jc */
            public final int mo29189jc() {
                InterfaceC7895o interfaceC7895o = C8189h.this.f26957qo.f26566po;
                if (interfaceC7895o != null) {
                    return C10751a.px2dip(C8189h.this.getContext(), interfaceC7895o.mo31017cf());
                }
                if (C8189h.this.f27119wE != null) {
                    ViewGroup.LayoutParams layoutParams = C8189h.this.f27119wE.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        return C10751a.px2dip(C8189h.this.getContext(), C8189h.this.f27119wE.getHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    }
                    return C10751a.px2dip(C8189h.this.getContext(), C8189h.this.f27119wE.getHeight());
                }
                return 0;
            }
        };
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: a */
    public final void mo31050a(PlayableSource playableSource, @Nullable InterfaceC7894n interfaceC7894n) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f26957qo.m32049a(this.f27121wG);
        this.f26957qo.f26532oM.m31197a(this);
        this.f26957qo.m32034b(this.mPlayEndPageListener);
        C7838a.m32198eX().m32205a(this);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bF */
    public final void mo28980bF() {
        super.mo28980bF();
        m31311iY();
        this.f27120wF = true;
        this.f27116wD.setVisibility(0);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: bY */
    public final void mo31048bY() {
        if (this.f27120wF) {
            this.f27116wD.setVisibility(0);
        }
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: bZ */
    public final void mo31047bZ() {
        if (this.f27120wF) {
            this.f27116wD.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTKReaderScene() {
        return "tk_top_floor_bar";
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTkTemplateId() {
        return C10484b.m25699dl(this.f26957qo.mAdTemplate);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractC8188g
    /* renamed from: hM */
    protected final int mo31278hM() {
        return C9659R.C9662id.ksad_js_topfloor;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        C9109aw c9109aw = this.f27122wz;
        if (c9109aw != null) {
            c9109aw.m29266st();
            this.f27122wz.m29265su();
        }
        super.onUnbind();
        this.f26957qo.m32033b(this.f27121wG);
        this.f26957qo.f26532oM.m31193b(this);
        this.f26957qo.m32024c(this.mPlayEndPageListener);
        C7838a.m32198eX().m32203b(this);
        this.f26957qo.m32040a((InterfaceC9289a) null);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: b */
    public final void mo28981b(C9043ac.C9044a c9044a) {
        float m24919aJ = C10751a.m24919aJ(getContext());
        c9044a.width = (int) ((C10751a.getScreenWidth(getContext()) / m24919aJ) + 0.5f);
        c9044a.height = (int) ((C10751a.getScreenHeight(getContext()) / m24919aJ) + 0.5f);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28989a(TKRenderFailReason tKRenderFailReason) {
        C9109aw c9109aw = this.f27122wz;
        if (c9109aw != null) {
            c9109aw.m29266st();
            this.f27122wz.m29265su();
        }
        this.f27120wF = false;
        this.f27116wD.setVisibility(8);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
        super.mo28983a(interfaceC9876q, c10605b);
        interfaceC9876q.mo27480c(new C9197e(m31310jb()));
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28990a(C9109aw c9109aw) {
        super.mo28990a(c9109aw);
        this.f27122wz = c9109aw;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.InterfaceC8259a
    /* renamed from: a */
    public final void mo31183a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        this.f27119wE = view;
    }
}
