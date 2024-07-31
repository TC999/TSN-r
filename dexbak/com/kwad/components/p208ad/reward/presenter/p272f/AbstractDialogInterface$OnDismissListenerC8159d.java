package com.kwad.components.p208ad.reward.presenter.p272f;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.mikephil.charting.utils.Utils;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.core.p330s.C8947j;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.webview.jshandler.C9031a;
import com.kwad.components.core.webview.jshandler.C9055af;
import com.kwad.components.core.webview.jshandler.C9063ai;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9134be;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.p333a.C9202h;
import com.kwad.components.core.webview.tachikoma.p333a.C9216o;
import com.kwad.components.core.webview.tachikoma.p333a.C9218p;
import com.kwad.components.core.webview.tachikoma.p333a.C9219q;
import com.kwad.components.core.webview.tachikoma.p333a.C9235y;
import com.kwad.components.core.webview.tachikoma.p334b.C9247h;
import com.kwad.components.core.webview.tachikoma.p334b.C9252m;
import com.kwad.components.core.webview.tachikoma.p334b.C9254o;
import com.kwad.components.core.webview.tachikoma.p334b.C9255p;
import com.kwad.components.core.webview.tachikoma.p334b.C9256q;
import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.components.core.webview.tachikoma.p334b.C9264y;
import com.kwad.components.p208ad.reward.C7845b;
import com.kwad.components.p208ad.reward.C7860c;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.RewardRenderResult;
import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.components.p208ad.reward.p250c.C7864b;
import com.kwad.components.p208ad.reward.p252e.AbstractC7880a;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7892l;
import com.kwad.components.p208ad.reward.p256i.C7950b;
import com.kwad.components.p208ad.reward.p257j.C7955b;
import com.kwad.components.p208ad.reward.p258k.C7966b;
import com.kwad.components.p208ad.reward.p258k.C7968c;
import com.kwad.components.p208ad.reward.p258k.C7970d;
import com.kwad.components.p208ad.reward.p258k.C7972e;
import com.kwad.components.p208ad.reward.p258k.C7974f;
import com.kwad.components.p208ad.reward.p258k.C7977g;
import com.kwad.components.p208ad.reward.p258k.C7978h;
import com.kwad.components.p208ad.reward.p258k.C7980i;
import com.kwad.components.p208ad.reward.p258k.C7981j;
import com.kwad.components.p208ad.reward.p258k.C7982k;
import com.kwad.components.p208ad.reward.p258k.p259a.C7964d;
import com.kwad.components.p208ad.reward.p258k.p259a.InterfaceC7965e;
import com.kwad.components.p208ad.reward.p263m.C8025e;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.components.p208ad.reward.presenter.C8141f;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11096h;
import com.kwad.sdk.widget.InterfaceC11147e;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.presenter.f.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractDialogInterface$OnDismissListenerC8159d extends C8094b implements DialogInterface.OnDismissListener, InterfaceC7965e, C9235y.InterfaceC9237a {

    /* renamed from: wk */
    protected C7964d f27071wk;

    /* renamed from: wl */
    private C9218p f27072wl;

    /* renamed from: wm */
    private C9216o f27073wm;

    /* renamed from: wn */
    private C7980i f27074wn;

    /* renamed from: wo */
    private C7981j f27075wo;

    /* renamed from: wp */
    private C9264y f27076wp;

    /* renamed from: wq */
    private boolean f27077wq;

    /* renamed from: wr */
    private C9202h f27078wr;
    @Nullable

    /* renamed from: ws */
    protected C8179e f27079ws;

    /* renamed from: wt */
    private C9134be.InterfaceC9137b f27080wt = new C9134be.InterfaceC9137b() { // from class: com.kwad.components.ad.reward.presenter.f.d.1
        @Override // com.kwad.components.core.webview.jshandler.C9134be.InterfaceC9137b
        /* renamed from: Q */
        public final void mo29241Q(int i) {
            C9913b m27247f = new C9913b().m27266cK(i).m27247f(AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.mRootContainer.getTouchCoords());
            C8615a.m30233a(new C8615a.C8616a(AbstractDialogInterface$OnDismissListenerC8159d.this.getContext()).m30198aq(AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.mAdTemplate).m30189b(AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.mApkDownloadHelper).m30202ao(false));
            C7955b.m31927a(AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.mAdTemplate, AbstractDialogInterface$OnDismissListenerC8159d.this.m31365iV(), (String) null, m27247f, (JSONObject) null);
        }
    };

    /* renamed from: hq */
    private final C11096h.InterfaceC11099a f27070hq = new C11096h.InterfaceC11099a() { // from class: com.kwad.components.ad.reward.presenter.f.d.5
        @Override // com.kwad.sdk.utils.C11096h.InterfaceC11099a
        public final void onAudioBeOccupied() {
            if (AbstractDialogInterface$OnDismissListenerC8159d.this.f27073wm == null || C7844b.m32186gs()) {
                return;
            }
            C9252m c9252m = new C9252m();
            c9252m.aao = true;
            AbstractDialogInterface$OnDismissListenerC8159d.this.f27073wm.m29179c(c9252m);
        }

        @Override // com.kwad.sdk.utils.C11096h.InterfaceC11099a
        public final void onAudioBeReleased() {
        }
    };
    private final InterfaceC7892l mRewardVerifyListener = new InterfaceC7892l() { // from class: com.kwad.components.ad.reward.presenter.f.d.6
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7892l
        public final void onRewardVerify() {
            if (AbstractDialogInterface$OnDismissListenerC8159d.this.f27074wn != null) {
                C9247h c9247h = new C9247h();
                c9247h.aaj = 1;
                AbstractDialogInterface$OnDismissListenerC8159d.this.f27074wn.m31909a(c9247h);
            }
        }
    };
    private final InterfaceC7886g mPlayEndPageListener = new AbstractC7880a() { // from class: com.kwad.components.ad.reward.presenter.f.d.7
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
        /* renamed from: bL */
        public final void mo31009bL() {
            if (AbstractDialogInterface$OnDismissListenerC8159d.this.f27075wo != null) {
                C11064bn.runOnUiThreadDelay(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.presenter.f.d.7.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C9254o c9254o = new C9254o();
                        c9254o.scene = 1;
                        AbstractDialogInterface$OnDismissListenerC8159d.this.f27075wo.m31908a(c9254o);
                        if (AbstractDialogInterface$OnDismissListenerC8159d.this.f27078wr != null) {
                            AbstractDialogInterface$OnDismissListenerC8159d.this.f27078wr.m29187aV(AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.f26546pA);
                        }
                    }
                }, 0L);
            }
        }
    };

    /* renamed from: gO */
    private final C9002l f27069gO = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.f.d.8
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayCompleted() {
            AbstractDialogInterface$OnDismissListenerC8159d.this.m31376hw();
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayError(int i, int i2) {
            AbstractDialogInterface$OnDismissListenerC8159d.this.m31367iT();
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            AbstractDialogInterface$OnDismissListenerC8159d.this.m31389a(j, j2);
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayStart() {
            AbstractDialogInterface$OnDismissListenerC8159d.this.m31379g(Utils.DOUBLE_EPSILON);
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPreparing() {
            AbstractDialogInterface$OnDismissListenerC8159d.this.m31379g(Utils.DOUBLE_EPSILON);
        }
    };

    public AbstractDialogInterface$OnDismissListenerC8159d() {
        if (mo31374iM()) {
            this.f27079ws = new C8179e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hw */
    public void m31376hw() {
        if (this.f26957qo.f26555pd) {
            m31367iT();
        } else {
            m31368iS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: iN */
    public void m31373iN() {
        C7907g c7907g = this.f26957qo;
        C9908c.m27337b(c7907g.mAdTemplate, 17, c7907g.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: iO */
    public void m31372iO() {
        this.f26957qo.m31990x(m31365iV());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: iP */
    public void m31371iP() {
        C7955b.m31927a(this.f26957qo.mAdTemplate, m31365iV(), "endTopBar", new C9913b().m27266cK(39).m27247f(this.f26957qo.mRootContainer.getTouchCoords()), this.f26957qo.mReportExtData);
        this.f26957qo.f26528oI.mo32088bJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: iQ */
    public void m31370iQ() {
        C7955b.m31927a(this.f26957qo.mAdTemplate, m31365iV(), (String) null, new C9913b().m27266cK(40).m27247f(this.f26957qo.mRootContainer.getTouchCoords()), this.f26957qo.mReportExtData);
        this.f26957qo.f26528oI.mo32088bJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: iR */
    public void m31369iR() {
        C7955b.m31927a(this.f26957qo.mAdTemplate, m31365iV(), (String) null, new C9913b().m27266cK(41).m27247f(this.f26957qo.mRootContainer.getTouchCoords()), this.f26957qo.mReportExtData);
        this.f26957qo.f26528oI.mo32088bJ();
    }

    /* renamed from: iS */
    private void m31368iS() {
        C9264y c9264y = this.f27076wp;
        c9264y.aat = true;
        c9264y.aax = false;
        c9264y.f29321nE = C10483a.m25976L(C10487e.m25641dQ(this.f26957qo.mAdTemplate));
        m31366iU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: iT */
    public void m31367iT() {
        C9264y c9264y = this.f27076wp;
        c9264y.aax = true;
        c9264y.aat = false;
        m31366iU();
    }

    /* renamed from: iU */
    private void m31366iU() {
        C9264y c9264y;
        C9218p c9218p = this.f27072wl;
        if (c9218p == null || (c9264y = this.f27076wp) == null) {
            return;
        }
        c9218p.m29178a(c9264y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: iV */
    public String m31365iV() {
        C7964d c7964d = this.f27071wk;
        if (c7964d == null) {
            return null;
        }
        return c7964d.getTkTemplateId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        this.f26957qo.f26528oI.onRewardVerify();
    }

    /* renamed from: a */
    public void mo28984a(WebCloseStatus webCloseStatus) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public void mo24610aj() {
        super.mo24610aj();
        this.f27077wq = true;
        this.f26957qo.m32052a(this);
        if (this.f27071wk == null) {
            this.f27071wk = new C7964d(this.f26957qo, -1L, getContext());
        }
        if (this.f27076wp == null) {
            this.f27076wp = new C9264y();
        }
        this.f27071wk.mo29075a(this.f26957qo.getActivity(), this.f26957qo.mAdResultData, this);
        C8179e c8179e = this.f27079ws;
        if (c8179e != null) {
            c8179e.m31336y(this.f26957qo);
        }
    }

    /* renamed from: bF */
    public void mo28980bF() {
        C8179e c8179e = this.f27079ws;
        if (c8179e != null) {
            c8179e.m31339bF();
        }
    }

    /* renamed from: bG */
    public void mo28979bG() {
    }

    public InterfaceC11147e getTouchCoordsView() {
        return this.f26957qo.mRootContainer;
    }

    /* renamed from: iM */
    protected boolean mo31374iM() {
        return false;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        C7964d c7964d = this.f27071wk;
        if (c7964d == null || c7964d.m31913jn() == null) {
            return;
        }
        this.f27071wk.m31913jn().m32124gQ();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        if (this.f27077wq) {
            C8179e c8179e = this.f27079ws;
            if (c8179e != null) {
                c8179e.m31335z(this.f26957qo);
            }
            this.f26957qo.m32036b(this);
            this.f27071wk.mo29029jp();
            C8025e c8025e = this.f26957qo.f26529oJ;
            if (c8025e != null) {
                c8025e.m31826b(this.f27069gO);
                this.f26957qo.f26529oJ.m31825b(this.f27070hq);
            }
            C7845b.m32173fb().m32174b(this.mRewardVerifyListener);
            this.f26957qo.m32024c(this.mPlayEndPageListener);
        }
    }

    /* renamed from: d */
    private void m31383d(long j, long j2) {
        long min = Math.min(C10483a.m25929ag(this.f26957qo.mAdTemplate.adInfoList.get(0)), j);
        if (j2 < min - 800) {
            this.f26957qo.f26570ps = (int) ((((float) (min - j2)) / 1000.0f) + 0.5f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m31379g(double d) {
        C9264y c9264y = this.f27076wp;
        c9264y.aax = false;
        c9264y.aat = false;
        c9264y.f29321nE = (int) ((d / 1000.0d) + 0.5d);
        m31366iU();
    }

    /* renamed from: a */
    public void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
        C7982k c7982k = new C7982k();
        c7982k.m31907a(new C7982k.InterfaceC7983a() { // from class: com.kwad.components.ad.reward.presenter.f.d.9
            @Override // com.kwad.components.p208ad.reward.p258k.C7982k.InterfaceC7983a
            /* renamed from: d */
            public final void mo31341d(C9256q c9256q) {
                C7860c.m32139fe().m32140c(c9256q);
            }
        });
        interfaceC9876q.mo27480c(c7982k);
        long j = this.f26957qo.f26572pu;
        interfaceC9876q.mo27480c(new C7977g(j > 0 ? ((int) j) / 1000 : 0));
        C7980i c7980i = new C7980i();
        this.f27074wn = c7980i;
        interfaceC9876q.mo27480c(c7980i);
        C7981j c7981j = new C7981j();
        this.f27075wo = c7981j;
        interfaceC9876q.mo27480c(c7981j);
        C7845b.m32173fb().m32175a(this.mRewardVerifyListener);
        this.f26957qo.m32034b(this.mPlayEndPageListener);
        interfaceC9876q.mo27480c(new C9063ai(new C9063ai.InterfaceC9066b() { // from class: com.kwad.components.ad.reward.presenter.f.d.10
            @Override // com.kwad.components.core.webview.jshandler.C9063ai.InterfaceC9066b
            /* renamed from: a */
            public final void mo29313a(C9063ai.C9065a c9065a) {
                AbstractDialogInterface$OnDismissListenerC8159d.this.getTKContainer().setVisibility(8);
            }
        }));
        C7970d c7970d = new C7970d();
        c7970d.m31911a(new C7970d.InterfaceC7971a() { // from class: com.kwad.components.ad.reward.presenter.f.d.11
            @Override // com.kwad.components.p208ad.reward.p258k.C7970d.InterfaceC7971a
            /* renamed from: a */
            public final void mo31347a(final C9255p c9255p) {
                C8615a.m30233a(new C8615a.C8616a(AbstractDialogInterface$OnDismissListenerC8159d.this.getContext()).m30198aq(AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.mAdTemplate).m30189b(AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.mApkDownloadHelper).m30205an(1).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.reward.presenter.f.d.11.1
                    @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                    public final void onAdClicked() {
                        if (c9255p.aaq) {
                            AbstractDialogInterface$OnDismissListenerC8159d.this.m31371iP();
                        } else {
                            AbstractDialogInterface$OnDismissListenerC8159d.this.m31370iQ();
                        }
                    }
                }));
            }
        });
        interfaceC9876q.mo27480c(c7970d);
        C7972e c7972e = new C7972e();
        c7972e.m31910a(new C7972e.InterfaceC7973a() { // from class: com.kwad.components.ad.reward.presenter.f.d.12
            @Override // com.kwad.components.p208ad.reward.p258k.C7972e.InterfaceC7973a
            /* renamed from: iW */
            public final void mo31346iW() {
                C8615a.m30233a(new C8615a.C8616a(AbstractDialogInterface$OnDismissListenerC8159d.this.getContext()).m30198aq(AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.mAdTemplate).m30189b(AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.mApkDownloadHelper).m30205an(2).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.reward.presenter.f.d.12.1
                    @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                    public final void onAdClicked() {
                        AbstractDialogInterface$OnDismissListenerC8159d.this.m31369iR();
                    }
                }));
            }
        });
        interfaceC9876q.mo27480c(c7972e);
        interfaceC9876q.mo27480c(new C7978h(new C7978h.InterfaceC7979a() { // from class: com.kwad.components.ad.reward.presenter.f.d.13
            @Override // com.kwad.components.p208ad.reward.p258k.C7978h.InterfaceC7979a
            /* renamed from: R */
            public final void mo31345R(int i) {
                if (C7907g.m32062G(AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.mAdTemplate)) {
                    if (C7907g.m32065E(AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.mAdTemplate) && AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.f26568pq != null) {
                        if (!AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.f26568pq.m31876jB()) {
                            AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.f26568pq.m31877jA();
                        }
                    } else if (C7907g.m32063F(AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.mAdTemplate) && AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.f26569pr != null && !AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.f26569pr.m31884jB()) {
                        AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.f26569pr.m31885jA();
                    }
                }
                if (AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.m32005fJ() != RewardRenderResult.DEFAULT) {
                    AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.f26558pg = i;
                }
                AbstractDialogInterface$OnDismissListenerC8159d.this.notifyRewardVerify();
            }
        }));
        interfaceC9876q.mo27480c(new C7968c() { // from class: com.kwad.components.ad.reward.presenter.f.d.14
            @Override // com.kwad.components.p208ad.reward.p258k.C7968c
            /* renamed from: iX */
            public final void mo31344iX() {
                super.mo31344iX();
                AbstractDialogInterface$OnDismissListenerC8159d.this.m31372iO();
            }
        });
        interfaceC9876q.mo27480c(new C7974f() { // from class: com.kwad.components.ad.reward.presenter.f.d.15
            @Override // com.kwad.components.p208ad.reward.p258k.C7974f
            /* renamed from: U */
            public final void mo31343U(boolean z) {
                super.mo31343U(z);
                C8141f.m31458t(AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo);
            }
        });
        interfaceC9876q.mo27480c(new C7966b() { // from class: com.kwad.components.ad.reward.presenter.f.d.16
            @Override // com.kwad.components.p208ad.reward.p258k.C7966b
            /* renamed from: iX */
            public final void mo31342iX() {
                super.mo31342iX();
                AbstractDialogInterface$OnDismissListenerC8159d.this.m31373iN();
            }
        });
        interfaceC9876q.mo27480c(new C9219q() { // from class: com.kwad.components.ad.reward.presenter.f.d.2
            @Override // com.kwad.components.core.webview.tachikoma.p333a.C9219q, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
            /* renamed from: a */
            public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
                super.mo25241a(str, interfaceC10627c);
                C8947j.m29548e(AbstractDialogInterface$OnDismissListenerC8159d.this.getContext(), AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.mAdTemplate);
            }
        });
        interfaceC9876q.mo27480c(new C7950b(getContext(), this.f26957qo.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
        C9202h c9202h = new C9202h();
        this.f27078wr = c9202h;
        c9202h.m29188a(new C9202h.InterfaceC9203a() { // from class: com.kwad.components.ad.reward.presenter.f.d.3
            @Override // com.kwad.components.core.webview.tachikoma.p333a.C9202h.InterfaceC9203a
            /* renamed from: a */
            public final void mo29186a(C9202h c9202h2) {
                c9202h2.m29187aV(AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.f26546pA);
            }
        });
        interfaceC9876q.mo27480c(this.f27078wr);
        interfaceC9876q.mo27480c(new C9055af());
        interfaceC9876q.mo27480c(new C9134be(c10605b, this.f26957qo.mApkDownloadHelper, this.f27080wt));
        interfaceC9876q.mo27480c(new C9235y(this));
    }

    /* renamed from: a */
    public void mo28987a(C9218p c9218p) {
        this.f27072wl = c9218p;
        C8025e c8025e = this.f26957qo.f26529oJ;
        if (c8025e != null) {
            c8025e.m31828a(this.f27069gO);
        }
    }

    /* renamed from: a */
    public void mo28985a(C9259t c9259t) {
        C8141f.m31471a(this.f26957qo, false);
    }

    /* renamed from: a */
    public void mo28989a(TKRenderFailReason tKRenderFailReason) {
        C8179e c8179e = this.f27079ws;
        if (c8179e != null) {
            c8179e.m31337iZ();
        }
    }

    /* renamed from: a */
    public void mo28990a(C9109aw c9109aw) {
        C8179e c8179e = this.f27079ws;
        if (c8179e != null) {
            c8179e.m31340b(c9109aw);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28991a(C9031a.C9033a c9033a) {
        C7907g c7907g = this.f26957qo;
        if (c7907g == null || c7907g.f26528oI == null) {
            return;
        }
        try {
            C9031a.C9035c c9035c = new C9031a.C9035c();
            c9035c.parseJson(new JSONObject(c9033a.f29076VS));
            String str = c9033a.f29075VR;
            char c = 65535;
            switch (str.hashCode()) {
                case -1552949011:
                    if (str.equals("rewardVerifyCallback")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1228923142:
                    if (str.equals("adCloseCallback")) {
                        c = 5;
                        break;
                    }
                    break;
                case -402746255:
                    if (str.equals("videoPlayEndCallback")) {
                        c = 3;
                        break;
                    }
                    break;
                case 601135198:
                    if (str.equals("videoPlayErrorCallback")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1620545720:
                    if (str.equals("videoPlayStartCallback")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1852274314:
                    if (str.equals("adClickCallback")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1917267918:
                    if (str.equals("adSkipWithPlayTimeCallback")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.f26957qo.f26528oI.mo32088bJ();
                    return;
                case 1:
                    this.f26957qo.f26528oI.onVideoPlayStart();
                    return;
                case 2:
                    this.f26957qo.f26528oI.onVideoPlayError(c9035c.errorCode, c9035c.f29077VT);
                    return;
                case 3:
                    this.f26957qo.f26528oI.onVideoPlayEnd();
                    return;
                case 4:
                    this.f26957qo.f26528oI.onVideoSkipToEnd(c9035c.f29078VU);
                    return;
                case 5:
                    this.f26957qo.f26528oI.mo32084h(c9035c.f29079VV);
                    return;
                case 6:
                    this.f26957qo.f26528oI.onRewardVerify();
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            C10331c.m26250e("TKBasePresenter", "onOutCallback Error: " + th.getMessage());
        }
    }

    /* renamed from: a */
    public void mo28986a(C9252m c9252m) {
        C8025e c8025e = this.f26957qo.f26529oJ;
        if (c8025e != null) {
            c8025e.setAudioEnabled(!c9252m.aao, true);
        }
    }

    /* renamed from: a */
    public void mo28982a(@Nullable C10640a c10640a) {
        this.f26957qo.f26528oI.mo32088bJ();
    }

    /* renamed from: a */
    public final void m31388a(C7864b c7864b) {
        C7907g c7907g = this.f26957qo;
        if (c7907g != null) {
            c7907g.m32035b(c7864b);
        }
    }

    /* renamed from: a */
    public void mo28988a(C9216o c9216o) {
        this.f27073wm = c9216o;
        C8025e c8025e = this.f26957qo.f26529oJ;
        if (c8025e != null) {
            c8025e.m31827a(this.f27070hq);
        }
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.presenter.f.d.4
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                boolean z = C8932a.m29575ah(AbstractDialogInterface$OnDismissListenerC8159d.this.getContext()).m29573qW() || !AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.mVideoPlayConfig.isVideoSoundEnable();
                C9252m c9252m = new C9252m();
                c9252m.aao = z;
                AbstractDialogInterface$OnDismissListenerC8159d.this.f27073wm.m29179c(c9252m);
                if (AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.f26529oJ != null) {
                    AbstractDialogInterface$OnDismissListenerC8159d.this.f26957qo.f26529oJ.setAudioEnabled(!z, false);
                }
            }
        });
    }

    /* renamed from: a */
    public final void m31389a(long j, long j2) {
        m31383d(j, j2);
        m31379g(j2);
    }

    @Override // com.kwad.components.core.webview.tachikoma.p333a.C9235y.InterfaceC9237a
    /* renamed from: a */
    public final void mo29167a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo) {
        this.f26957qo.mAdTemplate.tkLiveShopItemInfo = tKAdLiveShopItemInfo;
    }
}
