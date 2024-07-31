package com.kwad.components.p208ad.interstitial.p245g;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.webview.tachikoma.p337e.AbstractC9293e;
import com.kwad.components.p208ad.interstitial.AlertDialogC7725d;
import com.kwad.components.p208ad.interstitial.p239b.C7721b;
import com.kwad.components.p208ad.interstitial.p242e.C7735a;
import com.kwad.components.p208ad.interstitial.p242e.C7760b;
import com.kwad.components.p208ad.interstitial.p242e.C7761c;
import com.kwad.components.p208ad.interstitial.p242e.C7772d;
import com.kwad.components.p208ad.interstitial.p242e.C7781e;
import com.kwad.components.p208ad.interstitial.p242e.C7783f;
import com.kwad.components.p208ad.interstitial.p242e.C7788g;
import com.kwad.components.p208ad.interstitial.p242e.p243a.C7739b;
import com.kwad.components.p208ad.interstitial.p244f.C7793b;
import com.kwad.components.p208ad.interstitial.p245g.C7798d;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.video.videoview.TextureView$SurfaceTextureListenerC10537a;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.ad.interstitial.g.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7796c extends AbstractC7794a {

    /* renamed from: dU */
    private KsAdVideoPlayConfig f26309dU;

    /* renamed from: ie */
    protected KsInterstitialAd.AdInteractionListener f26310ie;

    /* renamed from: io */
    private AlertDialogC7725d f26311io;

    /* renamed from: jK */
    protected C7761c f26312jK;

    /* renamed from: jO */
    private boolean f26313jO;

    /* renamed from: jP */
    private C7761c.InterfaceC7768a f26314jP;

    /* renamed from: jR */
    private AbstractC9293e f26315jR;

    /* renamed from: jZ */
    private int f26316jZ;
    @Nullable

    /* renamed from: lB */
    protected C7760b f26317lB;

    /* renamed from: lC */
    private boolean f26318lC;

    /* renamed from: lD */
    protected ViewGroup f26319lD;
    protected AdInfo mAdInfo;
    @NonNull
    protected AdResultData mAdResultData;
    @NonNull
    protected AdTemplate mAdTemplate;

    public C7796c(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m32361a(C7796c c7796c, boolean z) {
        c7796c.f26318lC = false;
        return false;
    }

    /* renamed from: dX */
    private C7761c m32357dX() {
        C7761c c7761c = new C7761c();
        c7761c.m32446d(this.mAdResultData);
        c7761c.f26201ie = this.f26310ie;
        c7761c.f26202io = this.f26311io;
        c7761c.mApkDownloadHelper = new C8619c(this.mAdTemplate);
        c7761c.f26197dU = this.f26309dU;
        c7761c.f26198eN = new TextureView$SurfaceTextureListenerC10537a(this.mContext);
        KSFrameLayout kSFrameLayout = (KSFrameLayout) this.f26319lD.findViewById(C9659R.C9662id.ksad_container);
        c7761c.f26210jS = kSFrameLayout;
        C7793b c7793b = new C7793b(kSFrameLayout, 100);
        c7761c.f26200ib = c7793b;
        c7793b.m28900tw();
        c7761c.f26217jZ = this.f26316jZ;
        c7761c.f26206jO = this.f26313jO;
        c7761c.f26207jP = this.f26314jP;
        c7761c.f26209jR = this.f26315jR;
        c7761c.f26203jL = m32362a(this.mContext, C10487e.m25641dQ(this.mAdTemplate), c7761c);
        return c7761c;
    }

    @Override // com.kwad.components.p208ad.interstitial.p245g.AbstractC7794a
    /* renamed from: cr */
    public final void mo32359cr() {
        C7760b c7760b = this.f26317lB;
        if (c7760b != null) {
            c7760b.mo32406cP();
        }
    }

    @Override // com.kwad.components.p208ad.interstitial.p245g.AbstractC7794a
    /* renamed from: cs */
    public final void mo32358cs() {
        C7760b c7760b = this.f26317lB;
        if (c7760b != null) {
            c7760b.mo32405cQ();
        }
    }

    @NonNull
    /* renamed from: dY */
    public final C7760b m32356dY() {
        C7760b c7760b = new C7760b();
        if (this.f26318lC) {
            c7760b.m24612a(new C7739b());
        } else {
            if (C10483a.m25877bc(this.mAdInfo)) {
                c7760b.m24612a(new C7783f());
            }
            c7760b.m24612a(new C7788g());
            c7760b.m24612a(new C7772d());
            if (C10483a.m25946aP(this.mAdInfo)) {
                c7760b.m24612a(new C7735a());
            }
            if (this.f26312jK.m32468K(getContext())) {
                c7760b.m24612a(new C7781e());
            }
        }
        return c7760b;
    }

    /* renamed from: dZ */
    public final void m32355dZ() {
        C7761c c7761c = this.f26312jK;
        if (c7761c == null || !c7761c.f26215jX) {
            return;
        }
        c7761c.m32449cR();
    }

    /* renamed from: ea */
    public final void m32354ea() {
        C7761c c7761c = this.f26312jK;
        if (c7761c != null) {
            if (this.f26318lC || c7761c.f26215jX) {
                c7761c.m32448cS();
            }
        }
    }

    /* renamed from: eb */
    public final void m32353eb() {
        if (this.f26312jK != null) {
            this.f26312jK.m32461a(new C7761c.C7769b(this.mContext).m32435k(true).m32445A(1).m32433m(true).m32432z(2));
        }
    }

    /* renamed from: ec */
    public final boolean m32352ec() {
        C7761c c7761c = this.f26312jK;
        if (c7761c != null) {
            return c7761c.f26216jY;
        }
        return false;
    }

    protected final int getLayoutId() {
        return C9659R.C9663layout.ksad_interstitial;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C7761c c7761c = this.f26312jK;
        if (c7761c != null) {
            c7761c.release();
        }
        C7760b c7760b = this.f26317lB;
        if (c7760b != null) {
            c7760b.destroy();
        }
    }

    public final void setAdConvertListener(C7761c.InterfaceC7768a interfaceC7768a) {
        this.f26314jP = interfaceC7768a;
        C7761c c7761c = this.f26312jK;
        if (c7761c != null) {
            c7761c.f26207jP = interfaceC7768a;
        }
    }

    @Override // com.kwad.components.p208ad.interstitial.p245g.AbstractC7794a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.f26310ie = adInteractionListener;
        C7761c c7761c = this.f26312jK;
        if (c7761c != null) {
            c7761c.f26201ie = adInteractionListener;
        }
    }

    public final void setAggregateAdView(boolean z) {
        this.f26313jO = z;
        C7761c c7761c = this.f26312jK;
        if (c7761c != null) {
            c7761c.f26206jO = z;
        }
    }

    public final void setAggregateShowTriggerType(int i) {
        this.f26316jZ = i;
        C7761c c7761c = this.f26312jK;
        if (c7761c != null) {
            c7761c.f26217jZ = i;
        }
    }

    private C7796c(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        this.f26316jZ = -1;
        this.f26315jR = new AbstractC9293e() { // from class: com.kwad.components.ad.interstitial.g.c.1
            @Override // com.kwad.components.core.webview.tachikoma.p337e.AbstractC9293e
            /* renamed from: a */
            public final void mo29094a(String str, long j, long j2, long j3) {
                C7796c.this.f26312jK.f26216jY = true;
            }

            @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9290b
            /* renamed from: q */
            public final void mo29101q(String str) {
                if ("tk_interstitial".equals(str)) {
                    C7796c.m32361a(C7796c.this, false);
                    C7760b c7760b = C7796c.this.f26317lB;
                    if (c7760b != null) {
                        c7760b.m24604lW();
                    }
                    C7796c c7796c = C7796c.this;
                    c7796c.f26317lB = c7796c.m32356dY();
                    C7796c c7796c2 = C7796c.this;
                    c7796c2.f26317lB.m24616G(c7796c2.f26319lD);
                    C7796c c7796c3 = C7796c.this;
                    c7796c3.f26317lB.m24605k(c7796c3.f26312jK);
                }
            }
        };
        this.f26319lD = (ViewGroup) C10887l.inflate(context, getLayoutId(), this);
    }

    /* renamed from: a */
    private C7798d m32362a(Context context, AdInfo adInfo, C7761c c7761c) {
        boolean m32464a = C7761c.m32464a(this.mContext, adInfo);
        C7798d.C7800a c7800a = new C7798d.C7800a();
        c7800a.m32322v(m32464a);
        boolean z = true;
        c7800a.m32321w(!c7761c.m32468K(context) && C7721b.m32574cF());
        c7800a.m32327F(C7721b.m32573cG());
        if (C10483a.m25939aW(adInfo) && C11015ai.m24123LZ()) {
            z = false;
        }
        c7800a.m32320x(z);
        return new C7798d(context, c7800a);
    }

    @Override // com.kwad.components.p208ad.interstitial.p245g.AbstractC7794a
    /* renamed from: a */
    public final void mo32360a(@NonNull AdResultData adResultData, AlertDialogC7725d alertDialogC7725d, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mAdResultData = adResultData;
        AdTemplate m25661n = C10485c.m25661n(adResultData);
        this.mAdTemplate = m25661n;
        this.mAdInfo = C10487e.m25641dQ(m25661n);
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.realShowType = 2;
        this.f26309dU = ksAdVideoPlayConfig;
        this.f26311io = alertDialogC7725d;
        this.f26318lC = C10484b.m25773cS(adTemplate);
        this.f26310ie = adInteractionListener;
        this.f26312jK = m32357dX();
        if (this.f26317lB == null) {
            this.f26317lB = m32356dY();
        }
        this.f26317lB.m24616G(this.f26319lD);
        this.f26317lB.m24605k(this.f26312jK);
    }
}
