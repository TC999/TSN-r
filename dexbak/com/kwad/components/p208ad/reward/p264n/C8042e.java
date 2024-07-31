package com.kwad.components.p208ad.reward.p264n;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.C9003a;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9046ad;
import com.kwad.components.core.webview.jshandler.C9057ag;
import com.kwad.components.core.webview.jshandler.C9067aj;
import com.kwad.components.core.webview.jshandler.C9072ak;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.components.core.webview.jshandler.C9119az;
import com.kwad.components.core.webview.jshandler.C9125bb;
import com.kwad.components.core.webview.jshandler.C9161l;
import com.kwad.components.core.webview.jshandler.C9163m;
import com.kwad.components.core.webview.jshandler.C9185x;
import com.kwad.components.core.webview.tachikoma.p333a.C9200f;
import com.kwad.components.p208ad.reward.C7845b;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7892l;
import com.kwad.components.p208ad.reward.p256i.C7950b;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.utils.C11053bg;

/* renamed from: com.kwad.components.ad.reward.n.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8042e extends AbstractC10298a implements C9067aj.InterfaceC9071b, C9092aq.InterfaceC9095b {

    /* renamed from: cL */
    private KsAdWebView f26792cL;

    /* renamed from: cN */
    private C9003a f26793cN;

    /* renamed from: cO */
    private C10605b f26794cO;

    /* renamed from: cR */
    private InterfaceC10635a f26795cR;
    @Nullable
    private AdTemplate mAdTemplate;
    @Nullable
    private C8619c mApkDownloadHelper;
    private final InterfaceC7892l mRewardVerifyListener = new InterfaceC7892l() { // from class: com.kwad.components.ad.reward.n.e.1
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7892l
        public final void onRewardVerify() {
            if (C8042e.this.f26797yt != null) {
                C8042e.this.f26797yt.m29250ag(true);
            }
        }
    };

    /* renamed from: ys */
    private View f26796ys;

    /* renamed from: yt */
    private C9125bb f26797yt;

    /* renamed from: yu */
    private InterfaceC8045f f26798yu;

    public C8042e(KsAdWebView ksAdWebView, View view, @Nullable C8619c c8619c, InterfaceC10635a interfaceC10635a) {
        this.f26796ys = view;
        this.f26792cL = ksAdWebView;
        this.mApkDownloadHelper = c8619c;
        this.f26795cR = interfaceC10635a;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    /* renamed from: R */
    private void m31725R(String str) {
        if (C11053bg.isNullString(str)) {
            m31715jT();
            return;
        }
        m31720aA();
        this.f26792cL.setClientConfig(this.f26792cL.getClientConfig().m25331ei(this.mAdTemplate).m25339b(getWebErrorListener()));
        C9003a c9003a = new C9003a(this.f26792cL);
        this.f26793cN = c9003a;
        m31722a(c9003a, str);
        this.f26792cL.addJavascriptInterface(this.f26793cN, "KwaiAd");
        this.f26792cL.loadUrl(str);
    }

    /* renamed from: aA */
    private void m31720aA() {
        C9003a c9003a = this.f26793cN;
        if (c9003a != null) {
            c9003a.destroy();
            this.f26793cN = null;
        }
    }

    /* renamed from: ac */
    private void m31719ac(boolean z) {
        C10331c.m26254d("BottomCardWebViewHelper", "switchWebView: " + z);
        KsAdWebView ksAdWebView = this.f26792cL;
        if (ksAdWebView == null) {
            return;
        }
        ksAdWebView.setVisibility(z ? 0 : 8);
    }

    @NonNull
    private KsAdWebView.InterfaceC10599d getWebErrorListener() {
        return new KsAdWebView.InterfaceC10599d() { // from class: com.kwad.components.ad.reward.n.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onPageFinished() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onReceivedHttpError(int i, String str, String str2) {
                C10331c.m26254d("BottomCardWebViewHelper", "onReceivedHttpError: " + i + ", " + str);
                C8042e.this.m31715jT();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: jT */
    public void m31715jT() {
        View view = this.f26796ys;
        if (view != null) {
            view.setVisibility(0);
        }
        m31719ac(false);
    }

    /* renamed from: l */
    private void m31714l(String str, int i) {
        InterfaceC8045f interfaceC8045f = this.f26798yu;
        if (interfaceC8045f != null) {
            interfaceC8045f.mo31289j(str, i);
        }
    }

    /* renamed from: jS */
    public final void m31716jS() {
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c != null) {
            c8619c.m30148c(this);
        }
        C7845b.m32173fb().m32174b(this.mRewardVerifyListener);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        m31714l(adTemplate != null ? C10483a.m25957aE(C10487e.m25641dQ(adTemplate)) : "立即下载", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        m31714l(adTemplate == null ? "" : C10483a.m25882bY(adTemplate), 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        m31714l(adTemplate != null ? C10483a.m25957aE(C10487e.m25641dQ(adTemplate)) : "立即下载", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        m31714l(adTemplate != null ? C10483a.m25933ac(C10487e.m25641dQ(adTemplate)) : "立即打开", 100);
    }

    @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
    public final void onPaused(int i) {
        m31714l(C10483a.m25794dn(i), i);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        if (i != 0) {
            m31714l(C10483a.m25795dm(i), i);
        }
    }

    /* renamed from: b */
    private void m31717b(AdTemplate adTemplate, ViewGroup viewGroup) {
        C10605b c10605b = new C10605b();
        this.f26794cO = c10605b;
        c10605b.setAdTemplate(adTemplate);
        C10605b c10605b2 = this.f26794cO;
        c10605b2.mScreenOrientation = 0;
        c10605b2.aDJ = null;
        c10605b2.f29621OE = viewGroup;
        c10605b2.f29620NY = this.f26792cL;
        c10605b2.mReportExtData = null;
        c10605b2.aDL = true;
    }

    /* renamed from: a */
    public final void m31723a(InterfaceC8045f interfaceC8045f) {
        this.f26798yu = interfaceC8045f;
    }

    /* renamed from: a */
    public final void m31721a(AdTemplate adTemplate, ViewGroup viewGroup) {
        KsAdWebView ksAdWebView = this.f26792cL;
        if (ksAdWebView != null) {
            ksAdWebView.setBackgroundColor(0);
            if (this.f26792cL.getBackground() != null) {
                this.f26792cL.getBackground().setAlpha(0);
            }
        }
        C7845b.m32173fb().m32175a(this.mRewardVerifyListener);
        this.mAdTemplate = adTemplate;
        m31717b(adTemplate, viewGroup);
        m31725R(C10484b.m25757ck(this.mAdTemplate));
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c != null) {
            c8619c.m30151b(this);
        }
    }

    /* renamed from: a */
    private void m31722a(C9003a c9003a, String str) {
        c9003a.m29403a(new C9185x(this.f26794cO, this.mApkDownloadHelper, this.f26795cR));
        c9003a.m29403a(new C9046ad(this.f26794cO));
        c9003a.m29403a(new C9043ac(this.f26794cO));
        c9003a.m29403a(new C9092aq(this, str));
        C9125bb c9125bb = new C9125bb();
        this.f26797yt = c9125bb;
        c9003a.m29403a(c9125bb);
        c9003a.m29403a(new C9072ak(this.f26794cO));
        c9003a.m29402b(new C9163m(this.f26794cO));
        c9003a.m29402b(new C9161l(this.f26794cO));
        c9003a.m29403a(new C9057ag(this.f26794cO));
        c9003a.m29403a(new C9200f());
        c9003a.m29403a(new C9067aj(this.f26794cO, this));
        c9003a.m29403a(new C9119az(this.f26794cO, this.mApkDownloadHelper));
        c9003a.m29403a(new C7950b(this.f26792cL.getContext(), this.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    @Override // com.kwad.components.core.webview.jshandler.C9092aq.InterfaceC9095b
    /* renamed from: a */
    public final void mo28994a(C9092aq.C9094a c9094a) {
        C10331c.m26254d("BottomCardWebViewHelper", getClass().getName() + " updatePageStatus: " + c9094a);
        if (c9094a.status == 1) {
            m31719ac(true);
        } else {
            m31715jT();
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.C9067aj.InterfaceC9071b
    /* renamed from: a */
    public final void mo28995a(@NonNull C9067aj.C9070a c9070a) {
        C10331c.m26254d("BottomCardWebViewHelper", "onAdFrameValid : " + c9070a.toJson());
    }
}
