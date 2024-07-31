package com.kwad.components.p208ad.p247k;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.webview.AbstractC9028c;
import com.kwad.components.core.webview.C9003a;
import com.kwad.components.core.webview.C9013b;
import com.kwad.components.core.webview.jshandler.C9036aa;
import com.kwad.components.core.webview.jshandler.C9063ai;
import com.kwad.components.core.webview.jshandler.C9081am;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9125bb;
import com.kwad.components.core.webview.jshandler.C9185x;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11067bq;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.k.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7824b {

    /* renamed from: HK */
    protected View f26382HK;

    /* renamed from: HM */
    private String f26384HM;

    /* renamed from: HN */
    private InterfaceC7828a f26385HN;
    @Nullable

    /* renamed from: HO */
    private InterfaceC7829b f26386HO;

    /* renamed from: cL */
    protected KsAdWebView f26387cL;

    /* renamed from: cO */
    protected C10605b f26388cO;

    /* renamed from: cQ */
    protected C9109aw f26390cQ;
    @Nullable

    /* renamed from: cR */
    private InterfaceC10635a f26391cR;

    /* renamed from: dB */
    private AdBaseFrameLayout f26393dB;

    /* renamed from: da */
    private FrameLayout f26394da;

    /* renamed from: fX */
    private C9013b f26395fX;
    protected AdTemplate mAdTemplate;
    @Nullable
    private JSONObject mReportExtData;

    /* renamed from: yt */
    private C9125bb f26397yt;

    /* renamed from: HI */
    private List<AdTemplate> f26380HI = new ArrayList();
    @NonNull

    /* renamed from: HJ */
    private List<C8619c> f26381HJ = new ArrayList();

    /* renamed from: cP */
    private int f26389cP = -1;

    /* renamed from: HL */
    protected boolean f26383HL = false;

    /* renamed from: fY */
    private AbstractC9028c f26396fY = new AbstractC9028c() { // from class: com.kwad.components.ad.k.b.1
        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: a */
        public final void mo29355a(C9003a c9003a, C10605b c10605b) {
            C7824b c7824b = C7824b.this;
            c7824b.f26388cO = c10605b;
            c7824b.mo32118b(c10605b);
            C7824b.this.mo31936a(c9003a);
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: g */
        public final void mo29348g(int i, String str) {
            C7824b.this.f26383HL = false;
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        public final void onPageFinished() {
            C7824b c7824b = C7824b.this;
            c7824b.f26383HL = true;
            c7824b.mo31933fo();
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: a */
        public final void mo29350a(WebCloseStatus webCloseStatus) {
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.k.b.1.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    if (C7824b.this.f26385HN != null) {
                        C7824b.this.f26385HN.mo31507iA();
                    }
                }
            });
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: a */
        public final void mo29352a(C9092aq.C9094a c9094a) {
            C7824b.this.f26389cP = c9094a.status;
            C10331c.m26248i("PlayEndWebCard", C7824b.this.getName() + "updatePageStatus mPageState: " + c9094a + "，targetUrl: " + C7824b.this.f26384HM);
            if (c9094a.isSuccess() && C7824b.this.f26386HO != null) {
                C7824b.this.f26386HO.mo31026hJ();
            }
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: a */
        public final void mo29351a(C9109aw c9109aw) {
            C7824b.this.f26390cQ = c9109aw;
        }

        @Override // com.kwad.components.core.webview.AbstractC9028c
        /* renamed from: a */
        public final void mo29349a(C10640a c10640a) {
            if (C7824b.this.f26391cR != null) {
                C7824b.this.f26391cR.mo25245a(c10640a);
            }
        }
    };

    /* renamed from: cT */
    private C9063ai.InterfaceC9066b f26392cT = new C9063ai.InterfaceC9066b() { // from class: com.kwad.components.ad.k.b.2
        @Override // com.kwad.components.core.webview.jshandler.C9063ai.InterfaceC9066b
        /* renamed from: a */
        public final void mo29313a(C9063ai.C9065a c9065a) {
            C7824b.this.m32212mj();
        }
    };

    /* renamed from: com.kwad.components.ad.k.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7828a {
        /* renamed from: iA */
        void mo31507iA();
    }

    /* renamed from: com.kwad.components.ad.k.b$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7829b {
        /* renamed from: hJ */
        void mo31026hJ();
    }

    public C7824b() {
    }

    /* renamed from: aH */
    private void m32219aH() {
        int i = this.f26389cP;
        String str = i == -1 ? "timeout" : i != 1 ? "h5error" : "others";
        C10331c.m26246w("PlayEndWebCard", "show webCard fail, reason: " + str);
    }

    private static int getLayoutId() {
        return C9659R.C9663layout.ksad_ad_web_card_layout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B */
    public String mo32120B(AdTemplate adTemplate) {
        String str = this.f26384HM;
        return str == null ? C10484b.m25743cy(this.mAdTemplate) : str;
    }

    /* renamed from: ag */
    public final void m32218ag(boolean z) {
        this.f26397yt.m29250ag(true);
    }

    /* renamed from: ar */
    public final boolean m32217ar() {
        if (mo32117bx()) {
            C9109aw c9109aw = this.f26390cQ;
            if (c9109aw != null) {
                c9109aw.m29268sr();
            }
            FrameLayout frameLayout = this.f26394da;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            if (this.f26390cQ == null || !mo32115fk()) {
                return true;
            }
            this.f26390cQ.m29267ss();
            return true;
        }
        FrameLayout frameLayout2 = this.f26394da;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(4);
        }
        m32219aH();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: bx */
    public boolean mo32117bx() {
        return this.f26389cP == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: fj */
    public void mo32116fj() {
        this.f26394da.removeAllViews();
        this.f26394da.setVisibility(4);
        this.f26382HK = C10887l.inflate(this.f26394da.getContext(), getLayoutId(), this.f26394da);
        KsAdWebView ksAdWebView = (KsAdWebView) this.f26394da.findViewById(C9659R.C9662id.ksad_web_card_webView);
        this.f26387cL = ksAdWebView;
        if (ksAdWebView != null) {
            boolean z = false;
            ksAdWebView.setBackgroundColor(0);
            this.f26387cL.getBackground().setAlpha(0);
            this.f26395fX = new C9013b();
            C9013b.C9027a m29364f = new C9013b.C9027a().m29368az(this.mAdTemplate).m29370aF(mo32120B(this.mAdTemplate)).m29366d(this.f26387cL).m29365e(this.mReportExtData).m29362k(this.f26393dB).m29364f(this.f26381HJ.get(0));
            if (this.f26381HJ.size() > 1 && this.f26380HI.size() > 1) {
                z = true;
            }
            this.f26395fX.m29391a(m29364f.m29369aS(z).m29371a(this.f26396fY));
            this.f26387cL.loadUrl(mo32120B(this.mAdTemplate));
            mo31935fm();
        }
    }

    /* renamed from: fk */
    protected boolean mo32115fk() {
        return true;
    }

    /* renamed from: fm */
    protected void mo31935fm() {
    }

    /* renamed from: fn */
    protected void mo31934fn() {
    }

    /* renamed from: fo */
    protected void mo31933fo() {
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.f26387cL;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    protected String getName() {
        return "PlayEndWebCard";
    }

    /* renamed from: lW */
    public final void m32213lW() {
        C9013b c9013b = this.f26395fX;
        if (c9013b != null) {
            c9013b.m29378jp();
        }
    }

    /* renamed from: mj */
    public final void m32212mj() {
        if (C11067bq.m23853a(this.f26387cL, 50, false)) {
            C9109aw c9109aw = this.f26390cQ;
            if (c9109aw != null) {
                c9109aw.m29266st();
            }
            this.f26394da.setVisibility(4);
            C9109aw c9109aw2 = this.f26390cQ;
            if (c9109aw2 != null) {
                c9109aw2.m29265su();
            }
        }
    }

    public final void release() {
        this.f26386HO = null;
    }

    /* renamed from: b */
    protected void mo32118b(C10605b c10605b) {
        c10605b.setAdTemplate(this.mAdTemplate);
    }

    /* renamed from: a */
    public final void m32220a(InterfaceC10635a interfaceC10635a) {
        this.f26391cR = interfaceC10635a;
    }

    /* renamed from: a */
    public final void m32226a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable C8619c c8619c) {
        mo32119a(frameLayout, adBaseFrameLayout, adTemplate, c8619c, 0);
    }

    @Deprecated
    /* renamed from: a */
    public void mo32119a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, C8619c c8619c, int i) {
        this.f26381HJ.add(c8619c);
        this.f26393dB = adBaseFrameLayout;
        this.f26394da = frameLayout;
        this.mAdTemplate = adTemplate;
        mo32116fj();
    }

    public C7824b(@Nullable JSONObject jSONObject, @Nullable String str) {
        this.mReportExtData = jSONObject;
        this.f26384HM = str;
    }

    /* renamed from: a */
    public final void m32225a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, List<AdTemplate> list, List<C8619c> list2) {
        this.f26381HJ = list2;
        this.f26393dB = adBaseFrameLayout;
        this.f26394da = frameLayout;
        if (list != null && list.size() > 0) {
            this.f26380HI = list;
            this.mAdTemplate = list.get(0);
        }
        mo32116fj();
    }

    /* renamed from: a */
    public final void m32223a(@Nullable InterfaceC7829b interfaceC7829b) {
        this.f26386HO = interfaceC7829b;
        this.f26394da.setVisibility(4);
        this.f26389cP = -1;
        String mo32120B = mo32120B(this.mAdTemplate);
        C10331c.m26254d("PlayEndWebCard", "startPreloadWebView url : " + mo32120B);
        if (TextUtils.isEmpty(mo32120B) || this.f26387cL == null) {
            return;
        }
        mo31934fn();
        this.f26387cL.loadUrl(mo32120B);
    }

    /* renamed from: a */
    public final void m32224a(InterfaceC7828a interfaceC7828a) {
        this.f26385HN = interfaceC7828a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo31936a(C9003a c9003a) {
        if (this.f26381HJ.size() > 1 && this.f26380HI.size() > 1) {
            c9003a.m29403a(new C9036aa(this.f26388cO, this.f26381HJ.get(0), this.f26391cR, (byte) 0));
            c9003a.m29403a(new C9185x(this.f26388cO, this.f26381HJ, this.f26391cR));
            c9003a.m29403a(new C9081am(this.f26380HI, this.f26381HJ));
        }
        C9125bb c9125bb = new C9125bb();
        this.f26397yt = c9125bb;
        c9003a.m29403a(c9125bb);
        c9003a.m29403a(new C9063ai(this.f26392cT));
    }
}
