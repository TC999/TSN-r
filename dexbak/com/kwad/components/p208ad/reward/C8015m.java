package com.kwad.components.p208ad.reward;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p294e.C8642g;
import com.kwad.components.core.p289e.p294e.InterfaceC8641f;
import com.kwad.components.core.p301l.AbstractC8691b;
import com.kwad.components.core.webview.tachikoma.p336d.C9283b;
import com.kwad.components.core.webview.tachikoma.p337e.AbstractC9293e;
import com.kwad.components.p208ad.reward.model.C8028c;
import com.kwad.components.p208ad.reward.p250c.C7863a;
import com.kwad.components.p208ad.reward.p251d.C7874a;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.page.BackPressHandleResult;
import com.kwad.components.p208ad.reward.presenter.C8088a;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.components.p208ad.reward.presenter.C8104c;
import com.kwad.components.p208ad.reward.presenter.C8111d;
import com.kwad.components.p208ad.reward.presenter.C8136e;
import com.kwad.components.p208ad.reward.presenter.C8193g;
import com.kwad.components.p208ad.reward.presenter.C8201h;
import com.kwad.components.p208ad.reward.presenter.C8210j;
import com.kwad.components.p208ad.reward.presenter.C8212k;
import com.kwad.components.p208ad.reward.presenter.C8215l;
import com.kwad.components.p208ad.reward.presenter.C8218m;
import com.kwad.components.p208ad.reward.presenter.C8221n;
import com.kwad.components.p208ad.reward.presenter.C8297r;
import com.kwad.components.p208ad.reward.presenter.C8321u;
import com.kwad.components.p208ad.reward.presenter.C8322v;
import com.kwad.components.p208ad.reward.presenter.View$OnClickListenerC8307t;
import com.kwad.components.p208ad.reward.presenter.p265a.C8090a;
import com.kwad.components.p208ad.reward.presenter.p266b.C8095a;
import com.kwad.components.p208ad.reward.presenter.p266b.C8097b;
import com.kwad.components.p208ad.reward.presenter.p266b.C8102c;
import com.kwad.components.p208ad.reward.presenter.p267c.C8106a;
import com.kwad.components.p208ad.reward.presenter.p268d.C8126b;
import com.kwad.components.p208ad.reward.presenter.p271e.C8138a;
import com.kwad.components.p208ad.reward.presenter.p272f.C8153b;
import com.kwad.components.p208ad.reward.presenter.p272f.C8158c;
import com.kwad.components.p208ad.reward.presenter.p272f.C8180f;
import com.kwad.components.p208ad.reward.presenter.p272f.C8189h;
import com.kwad.components.p208ad.reward.presenter.p274h.C8202a;
import com.kwad.components.p208ad.reward.presenter.platdetail.C8286b;
import com.kwad.components.p208ad.reward.presenter.platdetail.C8291c;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.C8272c;
import com.kwad.components.p208ad.reward.presenter.platdetail.p275a.C8251e;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.C11015ai;

/* renamed from: com.kwad.components.ad.reward.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8015m extends C8094b implements InterfaceC7886g, InterfaceC8641f {

    /* renamed from: gS */
    private ViewGroup f26720gS;

    /* renamed from: gT */
    private AbstractC8691b f26721gT;
    @Nullable

    /* renamed from: gU */
    private C8297r f26722gU;

    /* renamed from: gV */
    private FrameLayout f26723gV;

    /* renamed from: gW */
    private C8153b f26724gW;
    @Nullable

    /* renamed from: gY */
    private C8138a f26725gY;

    /* renamed from: gZ */
    private C8180f f26726gZ;

    /* renamed from: ha */
    private boolean f26727ha = false;

    /* renamed from: jR */
    private AbstractC9293e f26728jR = new AbstractC9293e() { // from class: com.kwad.components.ad.reward.m.1
        @Override // com.kwad.components.core.webview.tachikoma.p337e.AbstractC9293e
        /* renamed from: a */
        public final void mo29094a(String str, long j, long j2, long j3) {
            C8015m.this.f26729qo.f26526jY = true;
        }

        @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9290b
        /* renamed from: q */
        public final void mo29101q(String str) {
            if (!"tk_reward".equals(str) && !"tk_live_video".equals(str)) {
                if ("tk_image_video".equals(str)) {
                    C8015m c8015m = C8015m.this;
                    c8015m.m31862a(c8015m);
                    C8015m.this.f26729qo.m32051a(RewardRenderResult.DEFAULT);
                    C8015m c8015m2 = C8015m.this;
                    c8015m2.m31858a(c8015m2.f26721gT, C8015m.this.mModel);
                    return;
                }
                return;
            }
            C8015m c8015m3 = C8015m.this;
            c8015m3.m31862a(c8015m3);
            C7907g.m32053a(C8015m.this.getContext(), C8015m.this.f26729qo, C8015m.this.m31853bW());
            C8015m.this.f26729qo.m32051a(RewardRenderResult.DEFAULT);
            C8015m c8015m4 = C8015m.this;
            c8015m4.m31858a(c8015m4.f26721gT, C8015m.this.mModel);
        }
    };
    private Context mContext;
    private C8028c mModel;

    /* renamed from: qo */
    private C7907g f26729qo;
    @Nullable

    /* renamed from: qp */
    private InterfaceC8017a f26730qp;

    /* renamed from: com.kwad.components.ad.reward.m$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8017a {
        void onUnbind();
    }

    public C8015m(AbstractC8691b abstractC8691b, Context context, ViewGroup viewGroup, C8028c c8028c, C7907g c7907g) {
        boolean z = false;
        this.mContext = context;
        this.f26720gS = viewGroup;
        this.mModel = c8028c;
        this.f26729qo = c7907g;
        this.f26721gT = abstractC8691b;
        m31859a(c8028c);
        AdInfo m31794bH = c8028c.m31794bH();
        boolean m25719dV = C10484b.m25719dV(m31794bH);
        boolean z2 = (C10483a.m25842cL(m31794bH) && m31857a(this.f26729qo.mAdResultData.adGlobalConfigInfo)) || C10483a.m25876bd(m31794bH) || C7907g.m32062G(c8028c.getAdTemplate());
        if (C10483a.m25831cW(m31794bH) && m31857a(this.f26729qo.mAdResultData.adGlobalConfigInfo)) {
            z = true;
        }
        C10331c.m26254d("RewardPresenter", "notFullTk: " + z2 + ", mLoadStrategy: " + this.f26729qo.f26547pB);
        if (z) {
            C9283b.m29107tc().m29113a(this.f26728jR);
            c7907g.m32051a(RewardRenderResult.LIVE_TK);
            m31855bR();
        } else if (m25719dV) {
            C9283b.m29107tc().m29113a(this.f26728jR);
            c7907g.m32051a(RewardRenderResult.TK_IMAGE);
            m31854bS();
        } else if (!z2 && this.f26729qo.f26547pB.equals(LoadStrategy.FULL_TK)) {
            C9283b.m29107tc().m29113a(this.f26728jR);
            c7907g.m32051a(RewardRenderResult.NEO_TK);
            m31848gm();
        } else {
            c7907g.m32051a(RewardRenderResult.DEFAULT);
            m31858a(abstractC8691b, c8028c);
        }
    }

    /* renamed from: bR */
    private void m31855bR() {
        C8153b c8153b = new C8153b();
        this.f26724gW = c8153b;
        m24612a(c8153b);
    }

    /* renamed from: bS */
    private void m31854bS() {
        C8158c c8158c = new C8158c();
        this.f26726gZ = c8158c;
        m24612a(c8158c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bW */
    public FrameLayout m31853bW() {
        if (this.f26723gV == null) {
            this.f26723gV = (FrameLayout) this.f26720gS.findViewById(C9659R.C9662id.ksad_reward_play_layout);
        }
        return this.f26723gV;
    }

    /* renamed from: gm */
    private void m31848gm() {
        C8180f c8180f = new C8180f();
        this.f26726gZ = c8180f;
        m24612a(c8180f);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f26729qo.m32034b(this);
        C7863a.m32133gL().setCallerContext(this.f26729qo);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
    /* renamed from: bL */
    public final void mo31009bL() {
        this.f26729qo.m32067C(true);
    }

    @Override // com.kwad.components.core.p289e.p294e.InterfaceC8641f
    public final void dismiss() {
        this.f26729qo.m32066D(false);
        this.f26729qo.m31998fu();
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
    public final int getPriority() {
        return 0;
    }

    /* renamed from: gn */
    public final BackPressHandleResult m31847gn() {
        C8297r c8297r = this.f26722gU;
        if (c8297r != null && c8297r.onBackPressed()) {
            return BackPressHandleResult.HANDLED;
        }
        C8138a c8138a = this.f26725gY;
        if (c8138a != null) {
            BackPressHandleResult m31480gn = c8138a.m31480gn();
            BackPressHandleResult backPressHandleResult = BackPressHandleResult.HANDLED;
            if (m31480gn == backPressHandleResult) {
                return backPressHandleResult;
            }
        }
        C8153b c8153b = this.f26724gW;
        if (c8153b != null) {
            return c8153b.m31420gn();
        }
        C8180f c8180f = this.f26726gZ;
        if (c8180f != null) {
            return c8180f.m31323gn();
        }
        return BackPressHandleResult.NOT_HANDLED;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f26723gV = (FrameLayout) this.f26720gS.findViewById(C9659R.C9662id.ksad_reward_play_layout);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.f26721gT = null;
        C9283b.m29107tc().m29112b(this.f26728jR);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26729qo.m32024c(this);
        InterfaceC8017a interfaceC8017a = this.f26730qp;
        if (interfaceC8017a != null) {
            interfaceC8017a.onUnbind();
        }
        C8642g.m30090or().m30091b(this);
        C7863a.m32133gL().reset();
    }

    @Override // com.kwad.components.core.p289e.p294e.InterfaceC8641f
    public final void show() {
        this.f26729qo.m31997fv();
        this.f26729qo.m32066D(true);
    }

    /* renamed from: a */
    private static boolean m31857a(AdGlobalConfigInfo adGlobalConfigInfo) {
        return adGlobalConfigInfo == null || adGlobalConfigInfo.neoPageType != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m31862a(C8015m c8015m) {
        if (this.f26727ha) {
            return;
        }
        c8015m.m24611a((Presenter) new C8088a(this.f26729qo), true);
        this.f26727ha = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m31858a(AbstractC8691b abstractC8691b, C8028c c8028c) {
        if (this.mModel == null) {
            return;
        }
        C8642g.m30090or().m30092a(this);
        AdInfo m31794bH = this.mModel.m31794bH();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        if (c8028c.f26769gt) {
            m31862a(this);
        }
        m24611a(new C8322v(), true);
        if (C10483a.m25946aP(m31794bH)) {
            m24611a(new C8111d(), true);
        }
        m24611a(new C8218m(), true);
        m24611a(new C8201h(), true);
        m24611a(new C8291c(), true);
        m24611a(new C8251e(), true);
        boolean m31791hi = c8028c.m31791hi();
        boolean m31790hj = c8028c.m31790hj();
        boolean z = c8028c.m31793bI() && !C11015ai.isOrientationPortrait();
        if (!m31791hi && !m31790hj && !z) {
            m24611a(new C8272c(), true);
        }
        m24611a(new C8221n(), true);
        m24611a(new C8104c(m31794bH), true);
        m24611a(new C8126b(adTemplate, true), true);
        m24611a(new C8106a(), true);
        m24611a(new C8321u(), true);
        m24611a(new C8136e(m31794bH, this.f26720gS), true);
        C8297r c8297r = new C8297r(adTemplate);
        this.f26722gU = c8297r;
        m24611a((Presenter) c8297r, true);
        m24611a(new C8215l(), true);
        C7907g c7907g = this.f26729qo;
        if (c7907g.f26544oY && C7874a.m32112b(c7907g.mContext, C10487e.m25641dQ(adTemplate))) {
            m24611a(new C8090a(), true);
        }
        if (C10484b.m25707dh(adTemplate)) {
            m24611a(new View$OnClickListenerC8307t(), true);
        }
        if (C10483a.m25876bd(m31794bH)) {
            m24611a(new C8286b(), true);
        }
        if (C10483a.m25842cL(m31794bH)) {
            m24611a(new C8102c(), true);
            m24611a(new C8095a(), true);
            m24611a(new C8097b(), true);
            m24611a(new C8212k(), true);
        }
        m24611a(new C8210j(), true);
    }

    /* renamed from: a */
    private void m31859a(C8028c c8028c) {
        AdInfo m31794bH = c8028c.m31794bH();
        if (!c8028c.f26769gt) {
            m31862a(this);
        }
        if (C7907g.m31991g(m31794bH)) {
            m24612a(new C8193g());
        }
        if (C10483a.m25947aO(m31794bH) && C11015ai.m24123LZ()) {
            m24612a(new C8202a());
        }
        if (C10484b.m25710dg(m31794bH)) {
            m24612a(new C8189h());
        }
        if (C10484b.m25722dS(m31794bH) && C11015ai.isOrientationPortrait()) {
            C8138a c8138a = new C8138a();
            this.f26725gY = c8138a;
            m24612a(c8138a);
        }
    }

    /* renamed from: a */
    public final void m31863a(@Nullable InterfaceC8017a interfaceC8017a) {
        this.f26730qp = interfaceC8017a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC7886g interfaceC7886g) {
        return getPriority() - interfaceC7886g.getPriority();
    }
}
