package com.kwad.components.p208ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.playable.C8874a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.components.core.webview.tachikoma.p336d.C9283b;
import com.kwad.components.core.webview.tachikoma.p337e.AbstractC9293e;
import com.kwad.components.p208ad.reward.C7838a;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7890j;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7894n;
import com.kwad.components.p208ad.reward.p263m.C8025e;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.ad.reward.presenter.r */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8297r extends C8094b implements InterfaceC7886g, InterfaceC7890j, C9092aq.InterfaceC9095b {

    /* renamed from: gX */
    private AbstractC9293e f27373gX;

    /* renamed from: sC */
    private float f27374sC;

    /* renamed from: sR */
    private boolean f27375sR;
    @Nullable

    /* renamed from: sS */
    private C8300a f27376sS;
    @Nullable

    /* renamed from: sT */
    private C8293q f27377sT;
    @Nullable

    /* renamed from: sU */
    private View$OnClickListenerC8225o f27378sU;

    /* renamed from: sV */
    private C8229p f27379sV;

    /* renamed from: sW */
    private int f27380sW;

    /* renamed from: sX */
    private boolean f27381sX;

    /* renamed from: sY */
    private boolean f27382sY;

    /* renamed from: sZ */
    private boolean f27383sZ;

    /* renamed from: com.kwad.components.ad.reward.presenter.r$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    class C8300a extends C9002l {

        /* renamed from: tb */
        private long f27387tb;
        private long videoDuration;

        private C8300a() {
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            this.f27387tb = j2;
            this.videoDuration = j;
            if (C8297r.this.f26957qo.m31995fx()) {
                return;
            }
            C8297r.this.m31054a(j, j2, false);
        }

        /* synthetic */ C8300a(C8297r c8297r, byte b) {
            this();
        }
    }

    public C8297r(AdTemplate adTemplate, boolean z, boolean z2) {
        this.f27380sW = 0;
        this.f27381sX = false;
        this.f27382sY = z;
        this.f27383sZ = z2;
        if (C10483a.m25900bH(C10487e.m25641dQ(adTemplate))) {
            C8229p c8229p = new C8229p();
            this.f27379sV = c8229p;
            m24612a(c8229p);
        }
    }

    /* renamed from: bV */
    private AbstractC9293e m31049bV() {
        if (this.f27373gX == null) {
            this.f27373gX = new AbstractC9293e() { // from class: com.kwad.components.ad.reward.presenter.r.2
                @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9290b
                /* renamed from: q */
                public final void mo29101q(String str) {
                    C8297r.this.m31046hE();
                }
            };
        }
        return this.f27373gX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hE */
    public void m31046hE() {
        if (this.f27383sZ) {
            C8293q c8293q = new C8293q(this);
            this.f27377sT = c8293q;
            m24611a((Presenter) c8293q, true);
        }
        if (this.f27382sY) {
            View$OnClickListenerC8225o view$OnClickListenerC8225o = new View$OnClickListenerC8225o(this);
            this.f27378sU = view$OnClickListenerC8225o;
            m24611a((Presenter) view$OnClickListenerC8225o, true);
        }
    }

    /* renamed from: hF */
    private boolean m31045hF() {
        return this.f27375sR;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        AdInfo m25641dQ = C10487e.m25641dQ(this.f26957qo.mAdTemplate);
        if (C10483a.m25900bH(m25641dQ)) {
            if (!this.f26957qo.f26545oZ) {
                C11064bn.runOnUiThreadDelay(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.presenter.r.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C8297r.this.m31046hE();
                    }
                }, 100L);
            } else {
                C9283b.m29107tc().m29113a(m31049bV());
            }
        } else if (!C10483a.m25897bK(m25641dQ)) {
            C8766a.m29888qi().m29906av(this.f26957qo.mAdTemplate);
        }
        this.f26957qo.m32034b(this);
        C8874a c8874a = this.f26957qo.f26531oL;
        if (c8874a != null) {
            c8874a.m29699a(this);
        }
        boolean m32182gw = C7844b.m32182gw();
        this.f27374sC = C7844b.m32183gv();
        if (m32182gw) {
            C8300a c8300a = new C8300a(this, (byte) 0);
            this.f27376sS = c8300a;
            C8025e c8025e = this.f26957qo.f26529oJ;
            if (c8025e != null) {
                c8025e.m31828a(c8300a);
            }
        }
        C7838a.m32198eX().m32205a(this);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
    /* renamed from: bL */
    public final void mo31009bL() {
        RewardActionBarControl.ShowActionBarResult m31187ig = this.f26957qo.f26532oM.m31187ig();
        if (m31187ig != null) {
            m31187ig.equals(RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
        }
        if (this.f27379sV == null || this.f26957qo.m32007fH()) {
            return;
        }
        if (m31045hF()) {
            this.f27379sV.m31246e(PlayableSource.PLAY_FINISHED_NORMAL);
        } else {
            this.f27379sV.m31245hz();
        }
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: bY */
    public final void mo31048bY() {
        this.f26957qo.m31989z(false);
        C8300a c8300a = this.f27376sS;
        if (c8300a == null || this.f27380sW != 2) {
            return;
        }
        m31054a(c8300a.videoDuration, this.f27376sS.f27387tb, true);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: bZ */
    public final void mo31047bZ() {
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
    public final int getPriority() {
        return 0;
    }

    public final boolean onBackPressed() {
        boolean m32003fL = this.f26957qo.m32003fL();
        if (!this.f26957qo.m31995fx() || m32003fL) {
            return false;
        }
        C7838a.m32198eX().m32197eY();
        this.f26957qo.m31989z(false);
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        C8025e c8025e;
        super.onUnbind();
        this.f26957qo.m32024c(this);
        C8874a c8874a = this.f26957qo.f26531oL;
        if (c8874a != null) {
            c8874a.m29690b(this);
        }
        C8300a c8300a = this.f27376sS;
        if (c8300a != null && (c8025e = this.f26957qo.f26529oJ) != null) {
            c8025e.m31826b(c8300a);
        }
        C7838a.m32198eX().m32203b(this);
        C9283b.m29107tc().m29112b(this.f27373gX);
    }

    @Override // com.kwad.components.core.webview.jshandler.C9092aq.InterfaceC9095b
    /* renamed from: a */
    public final void mo28994a(C9092aq.C9094a c9094a) {
        C8300a c8300a;
        boolean isSuccess = c9094a.isSuccess();
        this.f27375sR = isSuccess;
        if (!isSuccess || (c8300a = this.f27376sS) == null) {
            return;
        }
        m31054a(c8300a.videoDuration, this.f27376sS.f27387tb, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m31054a(long j, long j2, boolean z) {
        C8293q c8293q;
        if (m31045hF() && j2 >= 10000 && ((float) j2) >= ((float) j) * this.f27374sC) {
            if (C7844b.m32181gx()) {
                if (this.f27381sX || (c8293q = this.f27377sT) == null) {
                    return;
                }
                c8293q.m31059hA();
                this.f27380sW = 1;
                this.f27381sX = true;
                return;
            }
            View$OnClickListenerC8225o view$OnClickListenerC8225o = this.f27378sU;
            if (view$OnClickListenerC8225o != null) {
                view$OnClickListenerC8225o.m31253H(!z);
                this.f27380sW = 2;
            }
        }
    }

    public C8297r(AdTemplate adTemplate) {
        this(adTemplate, true, true);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: a */
    public final void mo31050a(PlayableSource playableSource, @Nullable InterfaceC7894n interfaceC7894n) {
        View$OnClickListenerC8225o view$OnClickListenerC8225o;
        C8293q c8293q;
        this.f26957qo.m31989z(true);
        int i = this.f27380sW;
        if (i == 1 && (c8293q = this.f27377sT) != null) {
            c8293q.m31058hB();
        } else if (i != 2 || (view$OnClickListenerC8225o = this.f27378sU) == null) {
        } else {
            view$OnClickListenerC8225o.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC7886g interfaceC7886g) {
        return getPriority() - interfaceC7886g.getPriority();
    }
}
