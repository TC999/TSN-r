package com.kwad.components.p208ad.fullscreen.p229c;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p294e.C8642g;
import com.kwad.components.core.p289e.p294e.InterfaceC8641f;
import com.kwad.components.core.p301l.AbstractC8691b;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.p336d.C9283b;
import com.kwad.components.core.webview.tachikoma.p337e.AbstractC9293e;
import com.kwad.components.p208ad.fullscreen.C7607b;
import com.kwad.components.p208ad.fullscreen.p229c.p230a.C7627f;
import com.kwad.components.p208ad.fullscreen.p229c.p232c.C7646a;
import com.kwad.components.p208ad.fullscreen.p229c.p232c.C7647b;
import com.kwad.components.p208ad.fullscreen.p229c.p232c.C7649c;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.RewardRenderResult;
import com.kwad.components.p208ad.reward.monitor.C8031b;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.page.BackPressHandleResult;
import com.kwad.components.p208ad.reward.presenter.C8088a;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.components.p208ad.reward.presenter.C8111d;
import com.kwad.components.p208ad.reward.presenter.C8136e;
import com.kwad.components.p208ad.reward.presenter.C8210j;
import com.kwad.components.p208ad.reward.presenter.C8212k;
import com.kwad.components.p208ad.reward.presenter.C8215l;
import com.kwad.components.p208ad.reward.presenter.C8218m;
import com.kwad.components.p208ad.reward.presenter.C8297r;
import com.kwad.components.p208ad.reward.presenter.C8322v;
import com.kwad.components.p208ad.reward.presenter.p266b.C8095a;
import com.kwad.components.p208ad.reward.presenter.p266b.C8097b;
import com.kwad.components.p208ad.reward.presenter.p266b.C8102c;
import com.kwad.components.p208ad.reward.presenter.p267c.C8106a;
import com.kwad.components.p208ad.reward.presenter.p268d.C8126b;
import com.kwad.components.p208ad.reward.presenter.p271e.C8138a;
import com.kwad.components.p208ad.reward.presenter.p272f.C8153b;
import com.kwad.components.p208ad.reward.presenter.p272f.C8180f;
import com.kwad.components.p208ad.reward.presenter.p272f.C8189h;
import com.kwad.components.p208ad.reward.presenter.platdetail.C8286b;
import com.kwad.components.p208ad.reward.presenter.platdetail.C8291c;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.C8272c;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.C11015ai;

/* renamed from: com.kwad.components.ad.fullscreen.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7641b extends C8094b implements InterfaceC7886g, InterfaceC8641f {

    /* renamed from: gR */
    private C7607b f25923gR;

    /* renamed from: gS */
    private ViewGroup f25924gS;

    /* renamed from: gT */
    private AbstractC8691b f25925gT;
    @Nullable

    /* renamed from: gU */
    private C8297r f25926gU;

    /* renamed from: gV */
    private FrameLayout f25927gV;

    /* renamed from: gW */
    private C8153b f25928gW;

    /* renamed from: gX */
    private AbstractC9293e f25929gX;
    @Nullable

    /* renamed from: gY */
    private C8138a f25930gY;

    /* renamed from: gZ */
    private C8180f f25931gZ;

    /* renamed from: ha */
    private boolean f25932ha = false;

    public C7641b(AbstractC8691b abstractC8691b, ViewGroup viewGroup, C7607b c7607b, C7907g c7907g) {
        this.f25925gT = abstractC8691b;
        this.f25923gR = c7607b;
        this.f25924gS = viewGroup;
        this.f26957qo = c7907g;
        m32735bP();
    }

    /* renamed from: bP */
    private void m32735bP() {
        if (this.f25923gR == null) {
            return;
        }
        m32730bU();
        AdInfo m32794bH = this.f25923gR.m32794bH();
        boolean m25831cW = C10483a.m25831cW(m32794bH);
        boolean m25719dV = C10484b.m25719dV(m32794bH);
        if (m25831cW) {
            this.f26957qo.m32051a(RewardRenderResult.LIVE_TK);
            C9283b.m29107tc().m29113a(m32729bV());
            m32733bR();
        } else if (m25719dV) {
            C9283b.m29107tc().m29113a(m32729bV());
            this.f26957qo.m32051a(RewardRenderResult.TK_IMAGE);
            m32732bS();
        } else if (m32737a(this.f26957qo)) {
            this.f26957qo.m32051a(RewardRenderResult.FULLSCREEN_TK);
            m32731bT();
            C9283b.m29107tc().m29113a(m32729bV());
        } else {
            this.f26957qo.m32051a(RewardRenderResult.DEFAULT);
            m32734bQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bQ */
    public void m32734bQ() {
        C9283b.m29107tc().m29112b(this.f25929gX);
        C8642g.m30090or().m30092a(this);
        AdTemplate adTemplate = this.f25923gR.getAdTemplate();
        AdInfo m32794bH = this.f25923gR.m32794bH();
        boolean z = this.f25923gR.m32793bI() && !C11015ai.isOrientationPortrait();
        if (this.f25923gR.f25856gt) {
            m32740a(this);
        }
        m24611a(new C8322v(), true);
        if (C10483a.m25946aP(m32794bH)) {
            m24611a(new C8111d(), true);
        }
        m24611a(new C8218m(), true);
        m24611a(new C8291c(), true);
        if (C10484b.m25710dg(m32794bH)) {
            m24611a(new C8189h(), true);
        }
        if (!z) {
            m24611a(new C8272c(), true);
        }
        m24611a(new C8106a(), true);
        if (C10484b.m25709dg(adTemplate)) {
            m24611a(new C7627f(), true);
        }
        if (C10483a.m25876bd(m32794bH)) {
            m24611a(new C8286b(), true);
        }
        m24611a(new C8215l(), true);
        if (C10483a.m25842cL(m32794bH)) {
            m24611a(new C8102c(), true);
            m24611a(new C8097b(), true);
            m24611a(new C8212k(), true);
            m24611a(new C8095a(), true);
        }
        C8297r c8297r = new C8297r(adTemplate, false, false);
        this.f25926gU = c8297r;
        m24611a((Presenter) c8297r, true);
        m24611a(new C7644c(), true);
        m24611a(new C7611a(), true);
        m24611a(new C8126b(adTemplate, false), true);
        m24611a(new C8136e(m32794bH, this.f25924gS), true);
        m24611a(new C8210j(), true);
    }

    /* renamed from: bR */
    private void m32733bR() {
        C7649c c7649c = new C7649c();
        this.f25928gW = c7649c;
        m24612a(c7649c);
    }

    /* renamed from: bS */
    private void m32732bS() {
        C7646a c7646a = new C7646a();
        this.f25931gZ = c7646a;
        m24612a(c7646a);
    }

    /* renamed from: bT */
    private void m32731bT() {
        m24611a((Presenter) new C7647b(), true);
    }

    /* renamed from: bU */
    private void m32730bU() {
        AdInfo m32794bH = this.f25923gR.m32794bH();
        if (!this.f25923gR.f25856gt) {
            m32740a(this);
        }
        if (C10484b.m25722dS(m32794bH) && C11015ai.isOrientationPortrait()) {
            C8138a c8138a = new C8138a();
            this.f25930gY = c8138a;
            m24611a((Presenter) c8138a, true);
        }
    }

    /* renamed from: bV */
    private AbstractC9293e m32729bV() {
        if (this.f25929gX == null) {
            this.f25929gX = new AbstractC9293e() { // from class: com.kwad.components.ad.fullscreen.c.b.1
                @Override // com.kwad.components.core.webview.tachikoma.p337e.AbstractC9293e
                /* renamed from: a */
                public final void mo29094a(String str, long j, long j2, long j3) {
                    C7641b.this.f26957qo.f26526jY = true;
                }

                @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9290b
                /* renamed from: q */
                public final void mo29101q(String str) {
                    if (!"tk_fullscreen".equals(str) && !"tk_live_video".equals(str)) {
                        if ("tk_image_video".equals(str)) {
                            C7641b c7641b = C7641b.this;
                            c7641b.m32740a(c7641b);
                            C7641b.this.f26957qo.m32051a(RewardRenderResult.DEFAULT);
                            C7641b.this.m32734bQ();
                            return;
                        }
                        return;
                    }
                    C7641b c7641b2 = C7641b.this;
                    c7641b2.m32740a(c7641b2);
                    C7907g.m32053a(C7641b.this.getContext(), C7641b.this.f26957qo, C7641b.this.m32728bW());
                    C7641b.this.m32734bQ();
                }
            };
        }
        return this.f25929gX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bW */
    public FrameLayout m32728bW() {
        if (this.f25927gV == null) {
            this.f25927gV = (FrameLayout) this.f25924gS.findViewById(C9659R.C9662id.ksad_reward_play_layout);
        }
        return this.f25927gV;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f26957qo.m32034b(this);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
    /* renamed from: bL */
    public final void mo31009bL() {
        this.f26957qo.m32067C(true);
    }

    @Override // com.kwad.components.core.p289e.p294e.InterfaceC8641f
    public final void dismiss() {
        this.f26957qo.m32066D(false);
        this.f26957qo.m31998fu();
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
    public final int getPriority() {
        return 0;
    }

    public final boolean onBackPressed() {
        C8297r c8297r = this.f25926gU;
        if (c8297r == null || !c8297r.onBackPressed()) {
            C8138a c8138a = this.f25930gY;
            if (c8138a == null || c8138a.m31480gn() != BackPressHandleResult.HANDLED) {
                C8153b c8153b = this.f25928gW;
                return c8153b != null && c8153b.m31420gn() == BackPressHandleResult.HANDLED;
            }
            return true;
        }
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25927gV = (FrameLayout) this.f25924gS.findViewById(C9659R.C9662id.ksad_reward_play_layout);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.m32024c(this);
        C8642g.m30090or().m30091b(this);
        C9283b.m29107tc().m29112b(this.f25929gX);
    }

    @Override // com.kwad.components.core.p289e.p294e.InterfaceC8641f
    public final void show() {
        this.f26957qo.m31997fv();
        this.f26957qo.m32066D(true);
    }

    /* renamed from: a */
    private static boolean m32737a(C7907g c7907g) {
        if (!C10251d.m26572BV()) {
            C8031b.m31783a(c7907g.mAdTemplate, TKRenderFailReason.SWITCH_CLOSE);
            return false;
        } else if (C10483a.m25876bd(C10487e.m25641dQ(c7907g.mAdTemplate))) {
            return false;
        } else {
            AdMatrixInfo.FullScreenInfo m25716dc = C10484b.m25716dc(c7907g.mAdTemplate);
            if (m25716dc == null || m25716dc.renderType != 1) {
                C8031b.m31783a(c7907g.mAdTemplate, TKRenderFailReason.TK_FILE_LOAD_ERROR);
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m32740a(C7641b c7641b) {
        if (this.f25932ha) {
            return;
        }
        c7641b.m24611a((Presenter) new C8088a(this.f26957qo), true);
        this.f25932ha = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC7886g interfaceC7886g) {
        return getPriority() - interfaceC7886g.getPriority();
    }
}
