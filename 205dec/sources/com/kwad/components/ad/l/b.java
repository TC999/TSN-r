package com.kwad.components.ad.l;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.br;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class b {
    protected View Im;
    private String Io;
    private a Ip;
    @Nullable
    private InterfaceC0585b Iq;
    protected KsAdWebView cL;
    protected com.kwad.sdk.core.webview.b cO;
    protected aw cQ;
    @Nullable
    private com.kwad.sdk.core.webview.d.a.a cR;
    private AdBaseFrameLayout dB;
    private FrameLayout da;
    private com.kwad.components.core.webview.b fX;
    protected AdTemplate mAdTemplate;
    @Nullable
    private JSONObject mReportExtData;
    private bb yu;
    private List<AdTemplate> Ik = new ArrayList();
    @NonNull
    private List<c> Il = new ArrayList();
    private int cP = -1;
    protected boolean In = false;
    private com.kwad.components.core.webview.c fY = new com.kwad.components.core.webview.c() { // from class: com.kwad.components.ad.l.b.1
        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            b bVar2 = b.this;
            bVar2.cO = bVar;
            bVar2.b(bVar);
            b.this.a(aVar);
        }

        @Override // com.kwad.components.core.webview.c
        public final void g(int i4, String str) {
            b.this.In = false;
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            b bVar = b.this;
            bVar.In = true;
            bVar.fp();
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.kwad.components.ad.l.b$1$1, java.lang.Runnable] */
        @Override // com.kwad.components.core.webview.c
        public final void a(WebCloseStatus webCloseStatus) {
            bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.l.b.1.1
                public final void doTask() {
                    if (b.this.Ip != null) {
                        b.this.Ip.iB();
                    }
                }
            });
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aq.a aVar) {
            b.this.cP = aVar.status;
            com.kwad.sdk.core.e.c.i("PlayEndWebCard", b.this.getName() + "updatePageStatus mPageState: " + aVar + "\uff0ctargetUrl: " + b.this.Io);
            if (aVar.isSuccess() && b.this.Iq != null) {
                b.this.Iq.hK();
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aw awVar) {
            b.this.cQ = awVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (b.this.cR != null) {
                b.this.cR.a(aVar);
            }
        }
    };
    private ai.b cT = new ai.b() { // from class: com.kwad.components.ad.l.b.2
        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            b.this.mJ();
        }
    };

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface a {
        void iB();
    }

    /* renamed from: com.kwad.components.ad.l.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface InterfaceC0585b {
        void hK();
    }

    public b() {
    }

    private void aH() {
        int i4 = this.cP;
        String str = i4 == -1 ? "timeout" : i4 != 1 ? "h5error" : "others";
        com.kwad.sdk.core.e.c.w("PlayEndWebCard", "show webCard fail, reason: " + str);
    }

    private static int getLayoutId() {
        return R.layout.ksad_ad_web_card_layout;
    }

    protected String B(AdTemplate adTemplate) {
        String str = this.Io;
        return str == null ? com.kwad.sdk.core.response.b.b.cA(this.mAdTemplate) : str;
    }

    public final void ag(boolean z3) {
        this.yu.ag(true);
    }

    public final boolean ar() {
        if (bx()) {
            aw awVar = this.cQ;
            if (awVar != null) {
                awVar.sV();
            }
            FrameLayout frameLayout = this.da;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            if (this.cQ == null || !fl()) {
                return true;
            }
            this.cQ.sW();
            return true;
        }
        FrameLayout frameLayout2 = this.da;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(4);
        }
        aH();
        return false;
    }

    protected boolean bx() {
        return this.cP == 1;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    protected void fk() {
        this.da.removeAllViews();
        this.da.setVisibility(4);
        this.Im = l.inflate(this.da.getContext(), getLayoutId(), this.da);
        KsAdWebView ksAdWebView = (KsAdWebView) this.da.findViewById(R.id.ksad_web_card_webView);
        this.cL = ksAdWebView;
        if (ksAdWebView != null) {
            boolean z3 = false;
            ksAdWebView.setBackgroundColor(0);
            this.cL.getBackground().setAlpha(0);
            this.fX = new com.kwad.components.core.webview.b();
            b.a f4 = new b.a().aA(this.mAdTemplate).aH(B(this.mAdTemplate)).d(this.cL).e(this.mReportExtData).k(this.dB).f(this.Il.get(0));
            if (this.Il.size() > 1 && this.Ik.size() > 1) {
                z3 = true;
            }
            this.fX.a(f4.aS(z3).a(this.fY));
            this.cL.loadUrl(B(this.mAdTemplate));
            fn();
        }
    }

    protected boolean fl() {
        return true;
    }

    protected void fn() {
    }

    protected void fo() {
    }

    protected void fp() {
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.cL;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    protected String getName() {
        return "PlayEndWebCard";
    }

    public final void mJ() {
        if (br.a(this.cL, 50, false)) {
            aw awVar = this.cQ;
            if (awVar != null) {
                awVar.sX();
            }
            this.da.setVisibility(4);
            aw awVar2 = this.cQ;
            if (awVar2 != null) {
                awVar2.sY();
            }
        }
    }

    public final void mw() {
        com.kwad.components.core.webview.b bVar = this.fX;
        if (bVar != null) {
            bVar.jq();
        }
    }

    public final void release() {
        this.Iq = null;
    }

    protected void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplate(this.mAdTemplate);
    }

    public final void a(com.kwad.sdk.core.webview.d.a.a aVar) {
        this.cR = aVar;
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable c cVar) {
        a(frameLayout, adBaseFrameLayout, adTemplate, cVar, 0);
    }

    @Deprecated
    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, c cVar, int i4) {
        this.Il.add(cVar);
        this.dB = adBaseFrameLayout;
        this.da = frameLayout;
        this.mAdTemplate = adTemplate;
        fk();
    }

    public b(@Nullable JSONObject jSONObject, @Nullable String str) {
        this.mReportExtData = jSONObject;
        this.Io = str;
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, List<AdTemplate> list, List<c> list2) {
        this.Il = list2;
        this.dB = adBaseFrameLayout;
        this.da = frameLayout;
        if (list != null && list.size() > 0) {
            this.Ik = list;
            this.mAdTemplate = list.get(0);
        }
        fk();
    }

    public final void a(@Nullable InterfaceC0585b interfaceC0585b) {
        this.Iq = interfaceC0585b;
        this.da.setVisibility(4);
        this.cP = -1;
        String B = B(this.mAdTemplate);
        com.kwad.sdk.core.e.c.d("PlayEndWebCard", "startPreloadWebView url : " + B);
        if (TextUtils.isEmpty(B) || this.cL == null) {
            return;
        }
        fo();
        this.cL.loadUrl(B);
    }

    public final void a(a aVar) {
        this.Ip = aVar;
    }

    protected void a(com.kwad.components.core.webview.a aVar) {
        if (this.Il.size() > 1 && this.Ik.size() > 1) {
            aVar.a(new aa(this.cO, this.Il.get(0), this.cR, (byte) 0));
            aVar.a(new x(this.cO, this.Il, this.cR));
            aVar.a(new am(this.Ik, this.Il));
        }
        bb bbVar = new bb();
        this.yu = bbVar;
        aVar.a(bbVar);
        aVar.a(new ai(this.cT));
    }
}
