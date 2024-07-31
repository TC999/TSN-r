package com.kwad.components.p208ad.interstitial.p242e;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.alibaba.fastjson.asm.Opcodes;
import com.kwad.components.core.p330s.C8934b;
import com.kwad.components.core.video.View$OnClickListenerC8966a;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.components.core.widget.p338a.C9366b;
import com.kwad.components.p208ad.interstitial.p239b.C7721b;
import com.kwad.components.p208ad.interstitial.p240c.C7724b;
import com.kwad.components.p208ad.interstitial.p242e.C7761c;
import com.kwad.components.p208ad.interstitial.p244f.C7791a;
import com.kwad.components.p208ad.interstitial.p245g.C7798d;
import com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e;
import com.kwad.components.p208ad.interstitial.report.C7802a;
import com.kwad.components.p208ad.interstitial.report.C7806c;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p403h.C10386d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.video.videoview.TextureView$SurfaceTextureListenerC10537a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.interstitial.e.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7772d extends C7760b {

    /* renamed from: ks */
    private static float f26239ks = 0.749f;

    /* renamed from: kt */
    private static float f26240kt = 0.8f;

    /* renamed from: ku */
    private static float f26241ku = 1.0f;

    /* renamed from: bQ */
    private C9366b f26242bQ;

    /* renamed from: eN */
    private TextureView$SurfaceTextureListenerC10537a f26243eN;

    /* renamed from: jH */
    private KsAutoCloseView f26244jH;

    /* renamed from: jK */
    private C7761c f26245jK;

    /* renamed from: jP */
    private C7761c.InterfaceC7768a f26246jP;

    /* renamed from: kq */
    private boolean f26247kq;

    /* renamed from: kr */
    private KSFrameLayout f26248kr;

    /* renamed from: kv */
    private C10386d f26249kv = new C10386d() { // from class: com.kwad.components.ad.interstitial.e.d.5
        @Override // com.kwad.sdk.core.p403h.C10386d, com.kwad.sdk.core.p403h.InterfaceC10385c
        /* renamed from: aM */
        public final void mo26182aM() {
            if (!C7772d.this.mAdTemplate.mPvReported && !C7772d.this.f26245jK.f26206jO && C7772d.this.f26245jK.f26201ie != null) {
                C7772d.this.f26245jK.f26201ie.onAdShow();
                C7772d.this.f26245jK.f26202io.getTimerHelper().startTiming();
                C7806c.m32283dQ().m32288a(C7772d.this.f26245jK.mAdTemplate, 1);
            }
            C9913b m27254cW = new C9913b().m27254cW(C7772d.this.f26245jK.f26217jZ);
            if (!C7772d.this.mAdTemplate.mPvReported) {
                C7806c.m32283dQ().m32276u(C7772d.this.mAdTemplate);
            }
            C8934b.m29570qY().m29571a(C7772d.this.mAdTemplate, null, m27254cW);
            C7772d.this.f26244jH.setCountDownPaused(false);
        }

        @Override // com.kwad.sdk.core.p403h.C10386d, com.kwad.sdk.core.p403h.InterfaceC10385c
        /* renamed from: aN */
        public final void mo26181aN() {
            C7772d.this.f26244jH.setCountDownPaused(true);
        }
    };
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public static ViewGroup.LayoutParams m32431B(int i) {
        int i2 = (int) (i * f26239ks);
        return new ViewGroup.LayoutParams((int) (i2 / 0.749f), i2);
    }

    /* renamed from: b */
    private static float m32421b(boolean z, boolean z2) {
        return (z && z2) ? 1.7777778f : 0.749f;
    }

    /* renamed from: db */
    private C7761c.InterfaceC7768a m32417db() {
        C7761c.InterfaceC7768a interfaceC7768a = new C7761c.InterfaceC7768a() { // from class: com.kwad.components.ad.interstitial.e.d.4
            @Override // com.kwad.components.p208ad.interstitial.p242e.C7761c.InterfaceC7768a
            /* renamed from: b */
            public final void mo32411b(long j, long j2) {
                C7802a.m32299dM().m32300b(C7772d.this.mAdTemplate, j, j2);
            }
        };
        this.f26246jP = interfaceC7768a;
        return interfaceC7768a;
    }

    /* renamed from: dc */
    private void m32416dc() {
        final C7798d c7798d = this.f26245jK.f26203jL;
        c7798d.setAdTemplate(this.mAdTemplate);
        if (C10483a.m25876bd(this.mAdInfo)) {
            c7798d.m32343c(C10483a.m25941aU(this.mAdInfo).materialUrl, this.mAdTemplate);
            c7798d.m32342c(true, true);
            c7798d.m32331t(false);
        } else {
            c7798d.m32331t(true);
            String url = C10483a.m25862br(this.mAdInfo).getUrl();
            if (!TextUtils.isEmpty(url)) {
                c7798d.m32343c(url, this.mAdTemplate);
                c7798d.m32342c(true, false);
            } else {
                c7798d.m32342c(false, false);
            }
            TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = this.f26245jK.f26198eN;
            this.f26243eN = textureView$SurfaceTextureListenerC10537a;
            if (textureView$SurfaceTextureListenerC10537a.getParent() != null) {
                ((ViewGroup) this.f26243eN.getParent()).removeView(this.f26243eN);
            }
            if (C10483a.m25877bc(this.mAdInfo)) {
                c7798d.m32351a(C10483a.m25940aV(this.mAdInfo).height / C10483a.m25940aV(this.mAdInfo).width, this.f26243eN);
            }
            c7798d.m32330u(this.f26245jK.f26197dU.isVideoSoundEnable());
            final int m25976L = C10483a.m25976L(this.mAdInfo);
            this.f26245jK.m32459a(new View$OnClickListenerC8966a.InterfaceC8970c() { // from class: com.kwad.components.ad.interstitial.e.d.6
                @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
                /* renamed from: bl */
                public final void mo28935bl() {
                    c7798d.m32342c(false, false);
                }

                @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
                /* renamed from: bm */
                public final void mo28934bm() {
                    C7772d.this.f26243eN.setVisibility(8);
                    if (C7772d.this.f26245jK.m32468K(C7772d.this.getContext())) {
                        return;
                    }
                    c7798d.m32337eg();
                }

                @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
                @SuppressLint({"SetTextI18n"})
                /* renamed from: e */
                public final void mo28933e(long j) {
                    int i = m25976L - ((int) (j / 1000));
                    if (i >= 0) {
                        c7798d.m32329w(String.valueOf(i));
                    } else {
                        c7798d.m32339ee();
                    }
                }

                @Override // com.kwad.components.core.video.View$OnClickListenerC8966a.InterfaceC8970c
                public final void onVideoPlayStart() {
                    c7798d.m32331t(true);
                }
            });
            c7798d.m32348a(this.mAdTemplate, this.mAdInfo);
            c7798d.m32331t(true);
            this.f26245jK.f26212jU.add(new C7761c.InterfaceC7770c() { // from class: com.kwad.components.ad.interstitial.e.d.7
                @Override // com.kwad.components.p208ad.interstitial.p242e.C7761c.InterfaceC7770c
                /* renamed from: cZ */
                public final void mo32410cZ() {
                    c7798d.m32336eh();
                    C7772d.this.f26243eN.setVisibility(0);
                }
            });
        }
        this.f26245jK.m32463a(getContext(), this.mAdInfo, this.mAdTemplate, c7798d.getBlurBgView());
        String m25973O = C10483a.m25973O(this.mAdInfo);
        if (TextUtils.isEmpty(m25973O)) {
            m25973O = C10483a.m25964X(this.mAdInfo);
        }
        KSImageLoader.loadImage(c7798d.getTailFrameView(), m25973O, this.mAdTemplate);
        if (m32419c(this.mAdInfo)) {
            this.f26244jH.m28923aY(true);
            m32415dd();
            return;
        }
        this.f26244jH.m28923aY(false);
    }

    /* renamed from: dd */
    private void m32415dd() {
        AdInfo adInfo = this.mAdInfo;
        int i = adInfo.adInsertScreenInfo.autoCloseTime;
        if (C10483a.m25877bc(adInfo)) {
            i = Math.min(i, C10483a.m25976L(this.mAdInfo));
            this.f26245jK.f26203jL.m32339ee();
            this.f26245jK.f26203jL.m32338ef();
        }
        this.f26244jH.m28926U(i);
        C9908c.m27337b(this.mAdTemplate, (int) Opcodes.IF_ACMPEQ, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m32412n(boolean z) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        C7761c c7761c = this.f26245jK;
        if (!c7761c.f26206jO && !z && !c7761c.f26204jM && !c7761c.f26205jN && C7791a.m32366d(c7761c)) {
            this.f26245jK.f26205jN = true;
            C7724b.m32562I(getContext());
            return;
        }
        this.f26245jK.m32457a(z, -1, this.f26243eN);
        this.f26245jK.f26202io.dismiss();
        TextureView$SurfaceTextureListenerC10537a textureView$SurfaceTextureListenerC10537a = this.f26243eN;
        if (textureView$SurfaceTextureListenerC10537a != null) {
            textureView$SurfaceTextureListenerC10537a.release();
        }
        C7761c c7761c2 = this.f26245jK;
        if (c7761c2.f26206jO || (adInteractionListener = c7761c2.f26201ie) == null) {
            return;
        }
        adInteractionListener.onAdClosed();
    }

    @Override // com.kwad.components.p208ad.interstitial.p242e.C7760b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C7761c c7761c = (C7761c) m24613Jx();
        this.f26245jK = c7761c;
        this.mAdTemplate = c7761c.mAdTemplate;
        C7806c.m32283dQ().m32277t(this.f26245jK.mAdTemplate);
        this.mAdInfo = C10487e.m25641dQ(this.f26245jK.mAdTemplate);
        this.f26245jK.f26210jS.setBackgroundColor(Color.parseColor("#99000000"));
        this.f26245jK.f26203jL.setVisibility(0);
        this.f26245jK.f26203jL.m32328y(this.mAdTemplate);
        this.f26245jK.m32462a(m32417db());
        m32416dc();
        this.f26245jK.f26203jL.setViewListener(new InterfaceC7801e() { // from class: com.kwad.components.ad.interstitial.e.d.2
            @Override // com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e
            /* renamed from: a */
            public final void mo32319a(KSFrameLayout kSFrameLayout) {
                C7772d.this.f26248kr = kSFrameLayout;
            }

            @Override // com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e
            /* renamed from: df */
            public final void mo32318df() {
                C7772d.this.m32412n(false);
            }

            @Override // com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e
            /* renamed from: dg */
            public final void mo32317dg() {
                C7772d.this.m32414e(3, C7772d.this.f26245jK.f26203jL.m32335ei() ? 53 : 85);
            }

            @Override // com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e
            /* renamed from: dh */
            public final void mo32316dh() {
                C7772d.this.m32414e(1, 39);
            }

            @Override // com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e
            /* renamed from: di */
            public final void mo32315di() {
                C7772d.this.m32414e(1, 29);
            }

            @Override // com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e
            /* renamed from: dj */
            public final void mo32314dj() {
                C7772d.this.m32414e(3, 85);
            }

            @Override // com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e
            /* renamed from: dk */
            public final void mo32313dk() {
                C7772d.this.m32414e(3, 85);
            }

            @Override // com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e
            /* renamed from: dl */
            public final void mo32312dl() {
                C7772d.this.m32414e(2, 53);
            }

            @Override // com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e
            /* renamed from: dm */
            public final void mo32311dm() {
                C7772d.this.m32414e(2, 30);
            }

            @Override // com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e
            /* renamed from: dn */
            public final void mo32310dn() {
                C7772d.this.m32414e(2, 31);
            }

            @Override // com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e
            /* renamed from: do */
            public final void mo32309do() {
                C7772d.this.m32414e(2, 32);
            }

            @Override // com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e
            /* renamed from: dp */
            public final void mo32308dp() {
                C7772d.this.m32414e(2, 15);
            }

            @Override // com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e
            /* renamed from: dq */
            public final void mo32307dq() {
                C7772d.this.m32414e(2, 16);
            }

            @Override // com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e
            /* renamed from: dr */
            public final void mo32306dr() {
                C7772d.this.m32414e(2, 17);
            }

            @Override // com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e
            /* renamed from: ds */
            public final void mo32305ds() {
                C7772d.this.m32414e(2, 35);
            }

            @Override // com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e
            /* renamed from: o */
            public final void mo32304o(boolean z) {
                if (C7772d.this.f26243eN != null) {
                    C7772d.this.f26243eN.setVideoSoundEnable(z);
                }
            }

            @Override // com.kwad.components.p208ad.interstitial.p245g.InterfaceC7801e
            /* renamed from: p */
            public final void mo32303p(boolean z) {
                C7772d.this.f26247kq = z;
            }
        });
        C9366b c9366b = new C9366b(this.f26245jK.f26203jL, 100);
        this.f26242bQ = c9366b;
        c9366b.mo26187a(this.f26249kv);
        this.f26242bQ.m28900tw();
        final boolean m25939aW = C10483a.m25939aW(this.mAdInfo);
        getContext();
        final boolean m24123LZ = C11015ai.m24123LZ();
        this.f26245jK.f26203jL.setRatio(m32421b(m24123LZ, m25939aW));
        final ViewGroup viewGroup = (ViewGroup) findViewById(C9659R.C9662id.ksad_interstitial_native);
        viewGroup.setVisibility(0);
        viewGroup.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.interstitial.e.d.3
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                ViewGroup.LayoutParams m32431B;
                if (m24123LZ) {
                    m32431B = C7772d.m32429a(C7772d.this.getRootView().getWidth(), m25939aW);
                } else {
                    m32431B = C7772d.m32431B(C7772d.this.getRootView().getHeight());
                }
                ViewParent parent = C7772d.this.f26245jK.f26203jL.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(C7772d.this.f26245jK.f26203jL);
                }
                viewGroup.addView(C7772d.this.f26245jK.f26203jL);
                C7772d.this.f26245jK.f26203jL.m32334f(m32431B.width, m32431B.height);
                viewGroup.requestLayout();
                viewGroup.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.interstitial.e.d.3.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        if (C7772d.this.f26243eN != null) {
                            C7772d.this.f26243eN.requestLayout();
                        }
                    }
                });
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KsAutoCloseView ksAutoCloseView = (KsAutoCloseView) findViewById(C9659R.C9662id.ksad_interstitial_auto_close);
        this.f26244jH = ksAutoCloseView;
        ksAutoCloseView.setViewListener(new KsAutoCloseView.InterfaceC9359a() { // from class: com.kwad.components.ad.interstitial.e.d.1
            @Override // com.kwad.components.core.widget.KsAutoCloseView.InterfaceC9359a
            /* renamed from: de */
            public final void mo28917de() {
                C7772d.this.m32412n(true);
            }

            @Override // com.kwad.components.core.widget.KsAutoCloseView.InterfaceC9359a
            /* renamed from: df */
            public final void mo28916df() {
                C7772d.this.m32412n(false);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26245jK.m32454b(this.f26246jP);
        this.f26242bQ.mo26186b(this.f26249kv);
        this.f26242bQ.m28899tx();
    }

    /* renamed from: c */
    private static boolean m32419c(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.autoCloseTime > 0 && !C10483a.m25900bH(adInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m32414e(int i, int i2) {
        this.f26245jK.m32461a(new C7761c.C7769b(getContext()).m32435k(this.f26247kq).m32444a(this.f26248kr.getTouchCoords()).m32432z(i).m32445A(i2));
        if (C7721b.m32569cK()) {
            C7761c c7761c = this.f26245jK;
            if (c7761c.f26202io != null) {
                c7761c.m32457a(false, -1, c7761c.f26198eN);
                this.f26245jK.f26202io.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static ViewGroup.LayoutParams m32429a(int i, boolean z) {
        float f;
        if (z) {
            f = f26240kt;
        } else {
            f = f26241ku;
        }
        int i2 = (int) (i * f);
        return new ViewGroup.LayoutParams(i2, (int) (i2 * (z ? 1.7777778f : 0.749f)));
    }
}
