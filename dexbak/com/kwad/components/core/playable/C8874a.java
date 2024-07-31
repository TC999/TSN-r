package com.kwad.components.core.playable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.webview.C9003a;
import com.kwad.components.core.webview.jshandler.C9053ae;
import com.kwad.components.core.webview.jshandler.C9055af;
import com.kwad.components.core.webview.jshandler.C9072ak;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9134be;
import com.kwad.components.core.webview.jshandler.C9151h;
import com.kwad.components.core.webview.jshandler.C9161l;
import com.kwad.components.core.webview.jshandler.C9163m;
import com.kwad.components.core.webview.jshandler.InterfaceC9165n;
import com.kwad.components.core.webview.tachikoma.p333a.C9200f;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.C11064bn;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.components.core.playable.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8874a implements InterfaceC9165n {

    /* renamed from: QM */
    private final KsAdWebView f28722QM;

    /* renamed from: QN */
    private long f28723QN;

    /* renamed from: QO */
    private int f28724QO;

    /* renamed from: QP */
    private PlayableSource f28725QP = PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE;

    /* renamed from: QQ */
    private List<C9092aq.InterfaceC9095b> f28726QQ = new CopyOnWriteArrayList();

    /* renamed from: QR */
    private List<KsAdWebView.InterfaceC10599d> f28727QR = new CopyOnWriteArrayList();
    @Nullable

    /* renamed from: cN */
    private C9003a f28728cN;

    /* renamed from: cQ */
    private C9109aw f28729cQ;
    @Nullable
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;
    private Context mContext;
    private AdBaseFrameLayout mRootContainer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.playable.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8879a implements C9134be.InterfaceC9137b {

        /* renamed from: QT */
        private final WeakReference<C8874a> f28734QT;

        public C8879a(C8874a c8874a) {
            this.f28734QT = new WeakReference<>(c8874a);
        }

        @Override // com.kwad.components.core.webview.jshandler.C9134be.InterfaceC9137b
        /* renamed from: Q */
        public final void mo29241Q(int i) {
            C8874a c8874a = this.f28734QT.get();
            if (c8874a != null) {
                c8874a.m29693aC(i);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public C8874a(KsAdWebView ksAdWebView) {
        this.f28722QM = ksAdWebView;
        ksAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.playable.a.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    C8874a.this.f28723QN = SystemClock.elapsedRealtime();
                    C8874a.this.f28722QM.getClientConfig().m25336bu(true);
                    return false;
                }
                return false;
            }
        });
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().m25331ei(this.mAdTemplate).m25339b(m29685ij()));
        m29696a(ksAdWebView);
    }

    /* renamed from: aA */
    private void m29694aA() {
        C9003a c9003a = this.f28728cN;
        if (c9003a != null) {
            c9003a.destroy();
            this.f28728cN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aC */
    public void m29693aC(int i) {
        if (getAdTemplate() == null) {
            return;
        }
        long m26538Cq = C10251d.m26538Cq();
        if (m26538Cq <= 0 || SystemClock.elapsedRealtime() - this.f28723QN <= m26538Cq) {
            C8615a.m30233a(new C8615a.C8616a(this.mContext).m30198aq(this.mAdTemplate).m30189b(this.mApkDownloadHelper).m30202ao(false).m30207am(i).m30185d(this.mRootContainer.getTouchCoords()).m30197aq(true));
        }
    }

    @Nullable
    private AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    private String getUrl() {
        AdTemplate adTemplate = this.mAdTemplate;
        return adTemplate == null ? "" : C10483a.m25894bN(C10487e.m25641dQ(adTemplate));
    }

    /* renamed from: ij */
    private KsAdWebView.InterfaceC10599d m29685ij() {
        return new KsAdWebView.InterfaceC10599d() { // from class: com.kwad.components.core.playable.a.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onPageFinished() {
                for (KsAdWebView.InterfaceC10599d interfaceC10599d : C8874a.this.f28727QR) {
                    interfaceC10599d.onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onPageStart() {
                for (KsAdWebView.InterfaceC10599d interfaceC10599d : C8874a.this.f28727QR) {
                    interfaceC10599d.onPageStart();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onReceivedHttpError(int i, String str, String str2) {
                for (KsAdWebView.InterfaceC10599d interfaceC10599d : C8874a.this.f28727QR) {
                    interfaceC10599d.onReceivedHttpError(i, str, str2);
                }
            }
        };
    }

    /* renamed from: pE */
    private void m29684pE() {
        if (C10483a.m25898bJ(C10487e.m25641dQ(this.mAdTemplate)) > 0) {
            C11064bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.playable.a.4
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public final void run() {
                    C8874a.this.f28722QM.getClientConfig().m25336bu(true);
                }
            }, C10483a.m25898bJ(C10487e.m25641dQ(this.mAdTemplate)));
        }
        if (C10483a.m25898bJ(C10487e.m25641dQ(this.mAdTemplate)) == 0) {
            this.f28722QM.getClientConfig().m25336bu(true);
        }
    }

    /* renamed from: e */
    public final void m29687e(PlayableSource playableSource) {
        if (playableSource != null) {
            this.f28725QP = playableSource;
        }
        if (this.f28722QM == null) {
            return;
        }
        m29684pE();
        C10331c.m26254d("PlayableViewHelper", "showPlayable");
        C9109aw c9109aw = this.f28729cQ;
        if (c9109aw != null) {
            c9109aw.m29268sr();
        }
        this.f28722QM.setVisibility(0);
        C9109aw c9109aw2 = this.f28729cQ;
        if (c9109aw2 != null) {
            c9109aw2.m29267ss();
        }
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.f28722QM;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    /* renamed from: hz */
    public final void m29686hz() {
        C10331c.m26254d("PlayableViewHelper", "showPlayable");
        if (this.f28722QM == null) {
            return;
        }
        C9109aw c9109aw = this.f28729cQ;
        if (c9109aw != null) {
            c9109aw.m29266st();
        }
        this.f28722QM.setVisibility(8);
        C9109aw c9109aw2 = this.f28729cQ;
        if (c9109aw2 != null) {
            c9109aw2.m29265su();
        }
        this.f28722QM.reload();
    }

    /* renamed from: qd */
    public final void m29683qd() {
        C9003a c9003a = this.f28728cN;
        if (c9003a != null) {
            c9003a.destroy();
            this.f28728cN = null;
        }
    }

    /* renamed from: qe */
    public final void m29682qe() {
        KsAdWebView ksAdWebView;
        if (this.mAdTemplate == null || (ksAdWebView = this.f28722QM) == null) {
            return;
        }
        ksAdWebView.getClientConfig().m25336bu(false);
        String url = getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.f28722QM.loadUrl(url);
        }
        C9908c.m27318bQ(this.mAdTemplate);
    }

    /* renamed from: qf */
    public final boolean m29681qf() {
        return this.f28722QM != null && this.f28724QO == 1;
    }

    /* renamed from: b */
    public final void m29690b(@Nullable C9092aq.InterfaceC9095b interfaceC9095b) {
        this.f28726QQ.remove(interfaceC9095b);
    }

    /* renamed from: a */
    private static void m29696a(KsAdWebView ksAdWebView) {
        if (C10251d.m26539Cp()) {
            ksAdWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    /* renamed from: a */
    public final void m29698a(AdTemplate adTemplate, AdBaseFrameLayout adBaseFrameLayout, C8619c c8619c) {
        if (this.f28722QM == null) {
            C10331c.m26246w("PlayableViewHelper", "registerJsBridge mPlayableView is null");
            return;
        }
        this.mContext = adBaseFrameLayout.getContext();
        this.mRootContainer = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = c8619c;
        this.f28724QO = -1;
        C10605b c10605b = new C10605b();
        c10605b.setAdTemplate(adTemplate);
        c10605b.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout2 = this.mRootContainer;
        c10605b.aDJ = adBaseFrameLayout2;
        c10605b.f29621OE = adBaseFrameLayout2;
        c10605b.f29620NY = this.f28722QM;
        m29694aA();
        C9003a c9003a = new C9003a(this.f28722QM);
        this.f28728cN = c9003a;
        m29695a(c10605b, c9003a, c8619c);
        this.f28722QM.addJavascriptInterface(this.f28728cN, "KwaiAd");
    }

    /* renamed from: a */
    public final void m29699a(@Nullable C9092aq.InterfaceC9095b interfaceC9095b) {
        this.f28726QQ.add(interfaceC9095b);
    }

    /* renamed from: a */
    public final void m29697a(@Nullable KsAdWebView.InterfaceC10599d interfaceC10599d) {
        this.f28727QR.add(interfaceC10599d);
    }

    /* renamed from: a */
    private void m29695a(C10605b c10605b, C9003a c9003a, C8619c c8619c) {
        c9003a.m29403a(new C9134be(c10605b, c8619c, new C8879a(this)));
        c9003a.m29403a(new C9092aq(new C9092aq.InterfaceC9095b() { // from class: com.kwad.components.core.playable.a.3
            @Override // com.kwad.components.core.webview.jshandler.C9092aq.InterfaceC9095b
            /* renamed from: a */
            public final void mo28994a(C9092aq.C9094a c9094a) {
                C8874a.this.f28724QO = c9094a.status;
                if (c9094a.status == 1 && C8874a.this.mAdTemplate != null) {
                    C9908c.m27319bP(C8874a.this.mAdTemplate);
                }
                for (C9092aq.InterfaceC9095b interfaceC9095b : C8874a.this.f28726QQ) {
                    interfaceC9095b.mo28994a(c9094a);
                }
            }
        }, getUrl()));
        c9003a.m29403a(new C9072ak(c10605b));
        c9003a.m29402b(new C9163m(c10605b));
        c9003a.m29402b(new C9161l(c10605b));
        this.f28729cQ = new C9109aw();
        c9003a.m29403a(new C9055af());
        c9003a.m29403a(new C9053ae(c10605b));
        c9003a.m29403a(new C9200f());
        c9003a.m29403a(this.f28729cQ);
        c9003a.m29403a(new C9151h(this));
    }

    @Override // com.kwad.components.core.webview.jshandler.InterfaceC9165n
    /* renamed from: a */
    public final void mo29222a(C9151h c9151h, String str) {
        AdTemplate adTemplate;
        if ("playableSrc".equals(str)) {
            c9151h.m29232f(this.f28725QP);
        }
        if (!"getAdType".equals(str) || (adTemplate = this.mAdTemplate) == null) {
            return;
        }
        c9151h.m29234aO(adTemplate.adStyle);
    }
}
