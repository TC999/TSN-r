package com.kwad.components.p208ad.reward.presenter.p274h;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p301l.p302a.AbstractC8690b;
import com.kwad.components.core.p301l.p302a.InterfaceC8689a;
import com.kwad.components.core.p326q.C8898a;
import com.kwad.components.core.proxy.AbstractC8886c;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.tachikoma.C9294f;
import com.kwad.components.core.webview.tachikoma.InterfaceC9339j;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.p333a.C9216o;
import com.kwad.components.core.webview.tachikoma.p333a.C9218p;
import com.kwad.components.core.webview.tachikoma.p334b.C9252m;
import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.components.core.webview.tachikoma.p334b.C9261v;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7881b;
import com.kwad.components.p208ad.reward.p258k.p259a.C7964d;
import com.kwad.components.p208ad.reward.p263m.C8025e;
import com.kwad.components.p208ad.reward.presenter.C8209i;
import com.kwad.components.p208ad.reward.presenter.p272f.AbstractC8188g;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.utils.C11017ak;
import com.kwad.sdk.utils.C11059bi;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.widget.InterfaceC11147e;

/* renamed from: com.kwad.components.ad.reward.presenter.h.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8202a extends AbstractC8188g implements InterfaceC9339j {
    private AdInfo mAdInfo;

    /* renamed from: tJ */
    private boolean f27154tJ;

    /* renamed from: tK */
    private boolean f27155tK;

    /* renamed from: wX */
    private boolean f27157wX;

    /* renamed from: wY */
    private C9294f f27158wY;

    /* renamed from: wZ */
    private long f27159wZ;

    /* renamed from: wk */
    private C7964d f27160wk;

    /* renamed from: tL */
    private C7907g.InterfaceC7921b f27156tL = new C7907g.InterfaceC7921b() { // from class: com.kwad.components.ad.reward.presenter.h.a.1
        @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7921b
        public final boolean interceptPlayCardResume() {
            return C8202a.this.f27116wD != null && C8202a.this.f27116wD.getVisibility() == 0;
        }
    };

    /* renamed from: sn */
    private final InterfaceC8689a f27153sn = new AbstractC8690b() { // from class: com.kwad.components.ad.reward.presenter.h.a.2
        @Override // com.kwad.components.core.p301l.p302a.AbstractC8690b, com.kwad.components.core.p301l.p302a.InterfaceC8689a
        /* renamed from: c */
        public final void mo29623c(AbstractC8886c abstractC8886c) {
            C8202a.this.f27157wX = false;
            if (C8202a.this.f27158wY == null) {
                return;
            }
            C9261v c9261v = new C9261v();
            if (C8898a.m29651qH().m29645qN()) {
                C8898a.m29651qH().m29652aM(false);
                if (C10483a.m25948aN(C8202a.this.mAdInfo) == 0) {
                    c9261v.aau = 1;
                    C8202a.this.f27158wY.m29171b(c9261v);
                } else if (C8898a.m29651qH().m29649qJ()) {
                    c9261v.aau = 1;
                    C8202a.this.f27158wY.m29171b(c9261v);
                } else {
                    c9261v.aau = 0;
                    C8202a.this.f27158wY.m29171b(c9261v);
                }
            } else if (C8898a.m29651qH().m29647qL() && C10483a.m25948aN(C8202a.this.mAdInfo) == 1) {
                if (C8898a.m29651qH().m29646qM() == 1) {
                    if (C11017ak.m24114an(C8202a.this.getContext(), C10483a.m25911ay(C8202a.this.mAdInfo))) {
                        c9261v.aau = 2;
                        C8898a.m29651qH().m29656aI(2);
                        C8202a.this.f27158wY.m29171b(c9261v);
                        return;
                    }
                    c9261v.aau = 0;
                    C8202a.this.f27158wY.m29171b(c9261v);
                } else if (C8898a.m29651qH().m29646qM() == 3) {
                    c9261v.aau = 1;
                    C8898a.m29651qH().m29656aI(0);
                    C8202a.this.f27158wY.m29171b(c9261v);
                }
            }
        }

        @Override // com.kwad.components.core.p301l.p302a.AbstractC8690b, com.kwad.components.core.p301l.p302a.InterfaceC8689a
        /* renamed from: d */
        public final void mo29622d(AbstractC8886c abstractC8886c) {
            super.mo29622d(abstractC8886c);
            C8202a.this.f27157wX = true;
        }
    };

    /* renamed from: gO */
    private final C9002l f27152gO = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.h.a.3
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            long m32055a = C7907g.m32055a(j, C8202a.this.mAdInfo);
            long m25949aM = C10483a.m25949aM(C8202a.this.mAdInfo) * 1000;
            if (j2 <= C8202a.this.f27159wZ || m32055a - j2 <= m25949aM || C8202a.this.f27154tJ) {
                return;
            }
            if (C10483a.m25948aN(C8202a.this.mAdInfo) == 1) {
                if (C11017ak.m24114an(C8202a.this.getContext(), C10483a.m25911ay(C8202a.this.mAdInfo))) {
                    return;
                }
            } else if (C8202a.this.f26957qo.f26523fP) {
                return;
            }
            C8202a.m31285b(C8202a.this, true);
            C8202a.this.f27160wk.mo29075a(C8202a.this.f26957qo.getActivity(), C8202a.this.f26957qo.mAdResultData, C8202a.this);
            C8202a.this.m31274je();
        }
    };

    /* renamed from: hw */
    private void m31277hw() {
        boolean m31264x = C8209i.m31264x(this.f26957qo);
        C10331c.m26254d("jky", "onPlayCompleted: " + m31264x);
        if (m31264x) {
            C11064bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.h.a.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (C8202a.this.f26957qo.f26528oI != null) {
                        C8202a.this.f26957qo.f26528oI.onRewardVerify();
                    }
                    C8202a.this.f26957qo.f26529oJ.pause();
                    C8202a.this.f26957qo.m32013fB();
                }
            }, 200L);
            return;
        }
        InterfaceC7881b interfaceC7881b = this.f26957qo.f26528oI;
        if (interfaceC7881b != null) {
            interfaceC7881b.onRewardVerify();
        }
        this.f26957qo.f26529oJ.pause();
        this.f26957qo.m32013fB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: je */
    public void m31274je() {
        this.f27116wD.setVisibility(0);
        C8025e c8025e = this.f26957qo.f26529oJ;
        if (c8025e != null) {
            c8025e.pause();
        }
        this.f27155tK = true;
    }

    /* renamed from: jf */
    private C9294f m31273jf() {
        return new C9294f() { // from class: com.kwad.components.ad.reward.presenter.h.a.5
            @Override // com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
            /* renamed from: a */
            public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
                super.mo25241a(str, interfaceC10627c);
            }
        };
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28990a(C9109aw c9109aw) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28988a(C9216o c9216o) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28987a(C9218p c9218p) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28986a(C9252m c9252m) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28985a(C9259t c9259t) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        getContext();
        if (C11015ai.m24123LZ()) {
            this.f27157wX = false;
            C10331c.m26254d("TkRewardVideoTaskPresenter", "onBind: ");
            if (this.f27160wk == null) {
                this.f27160wk = new C7964d(this.f26957qo, -1L, getContext(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.presenter.h.a.4
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        if (C8202a.this.f27158wY == null) {
                            return;
                        }
                        C9261v c9261v = new C9261v();
                        if (C8898a.m29651qH().m29645qN()) {
                            C8898a.m29651qH().m29652aM(false);
                            if (C10483a.m25948aN(C8202a.this.mAdInfo) == 0) {
                                c9261v.aau = 1;
                                C8202a.this.f27158wY.m29171b(c9261v);
                            } else if (C8898a.m29651qH().m29649qJ()) {
                                c9261v.aau = 1;
                                C8202a.this.f27158wY.m29171b(c9261v);
                            } else {
                                c9261v.aau = 0;
                                C8202a.this.f27158wY.m29171b(c9261v);
                            }
                        } else if (C8898a.m29651qH().m29647qL() && C10483a.m25948aN(C8202a.this.mAdInfo) == 1) {
                            if (C8898a.m29651qH().m29646qM() == 1) {
                                if (C11017ak.m24114an(C8202a.this.getContext(), C10483a.m25911ay(C8202a.this.mAdInfo))) {
                                    return;
                                }
                                c9261v.aau = 0;
                                C8202a.this.f27158wY.m29171b(c9261v);
                            } else if (C8898a.m29651qH().m29646qM() == 3) {
                                c9261v.aau = 1;
                                C8898a.m29651qH().m29656aI(0);
                                C8202a.this.f27158wY.m29171b(c9261v);
                            }
                        }
                    }
                });
            }
            AdInfo m25641dQ = C10487e.m25641dQ(this.f26957qo.mAdTemplate);
            this.mAdInfo = m25641dQ;
            this.f27159wZ = C10483a.m25950aL(m25641dQ) * 1000;
            C8025e c8025e = this.f26957qo.f26529oJ;
            if (c8025e != null) {
                c8025e.m31828a(this.f27152gO);
            }
            this.f26957qo.m32048a(this.f27156tL);
            this.f26957qo.f28358Ms.add(this.f27153sn);
        }
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bG */
    public final void mo28979bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTKReaderScene() {
        return "tk_reward_task_card";
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTkTemplateId() {
        return C10484b.m25689dq(this.f26957qo.mAdTemplate);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final InterfaceC11147e getTouchCoordsView() {
        return this.f26957qo.mRootContainer;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractC8188g
    /* renamed from: hM */
    public final int mo31278hM() {
        return C9659R.C9662id.ksad_js_task;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C8025e c8025e = this.f26957qo.f26529oJ;
        if (c8025e != null) {
            c8025e.m31826b(this.f27152gO);
        }
        this.f26957qo.m32032b(this.f27156tL);
        this.f26957qo.f28358Ms.remove(this.f27153sn);
        C7964d c7964d = this.f27160wk;
        if (c7964d != null) {
            c7964d.mo29029jp();
            this.f27160wk = null;
        }
        this.f27116wD.setVisibility(8);
        C8898a.m29651qH().clear();
        this.f27154tJ = false;
        this.f27155tK = false;
        this.f27157wX = false;
    }

    /* renamed from: b */
    static /* synthetic */ boolean m31285b(C8202a c8202a, boolean z) {
        c8202a.f27154tJ = true;
        return true;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28989a(TKRenderFailReason tKRenderFailReason) {
        C10331c.m26254d("TkRewardVideoTaskPresenter", "onTkLoadFailed: ");
        this.f27116wD.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: b */
    public final void mo28981b(C9043ac.C9044a c9044a) {
        float m24919aJ = C10751a.m24919aJ(getContext());
        c9044a.width = (int) ((C11059bi.getScreenWidth(getContext()) / m24919aJ) + 0.5f);
        c9044a.height = (int) ((C11059bi.getScreenHeight(getContext()) / m24919aJ) + 0.5f);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
        C9294f m31273jf = m31273jf();
        this.f27158wY = m31273jf;
        interfaceC9876q.mo27480c(m31273jf);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28982a(@Nullable C10640a c10640a) {
        this.f26957qo.f26528oI.mo32088bJ();
        C10331c.m26254d("jky", "onAdClicked convertPageType: " + c10640a.aEL);
        if (C10483a.m25947aO(this.mAdInfo)) {
            C8898a.m29651qH().m29657aH(c10640a.aEL);
            if (c10640a.aEL == -1) {
                C8898a.m29651qH().m29652aM(false);
                C8898a.m29651qH().m29656aI(0);
            } else if (C10483a.m25956aF(this.mAdInfo)) {
                if (C8898a.m29651qH().m29646qM() == 2) {
                    C8898a.m29651qH().m29656aI(3);
                } else {
                    C8898a.m29651qH().m29656aI(1);
                }
            } else {
                C8898a.m29651qH().m29652aM(true);
            }
        }
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28984a(WebCloseStatus webCloseStatus) {
        boolean z = false;
        this.f26957qo.f26553pb = webCloseStatus != null && webCloseStatus.interactSuccess;
        int m29650qI = C8898a.m29651qH().m29650qI();
        C7907g c7907g = this.f26957qo;
        C8025e c8025e = c7907g.f26529oJ;
        if (c8025e != null) {
            if (c7907g.f26553pb) {
                c8025e.m31823jJ();
                if (m29650qI == 1) {
                    m31277hw();
                    z = true;
                }
            }
            if (this.f27155tK && !this.f27157wX && !z) {
                this.f26957qo.f26529oJ.resume();
            }
        }
        this.f27116wD.setVisibility(8);
    }
}
