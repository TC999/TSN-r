package com.kwad.sdk.core.webview.p417a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9912a;
import com.kwad.sdk.core.download.p395a.C10299b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.p418b.p421c.C10621b;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: com.kwad.sdk.core.webview.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10603c extends C10601a {

    /* renamed from: HF */
    private C10604a f29617HF;

    /* renamed from: com.kwad.sdk.core.webview.a.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10604a {

        /* renamed from: OJ */
        private KsAdWebView.InterfaceC10598c f29618OJ;

        /* renamed from: Om */
        private int f29619Om;
        private KsAdWebView.InterfaceC10599d aDY;
        private KsAdWebView.InterfaceC10597b aDZ;
        private boolean aEa;
        private boolean aEd;
        private AdTemplate mAdTemplate;
        private final Context mContext;
        private boolean aEb = true;
        private boolean aEc = true;
        private boolean aDX = true;
        private boolean aEe = false;
        private long aEf = 600;
        private long aEg = 0;

        public C10604a(Context context) {
            this.mContext = context;
        }

        /* renamed from: GP */
        private boolean m25347GP() {
            return this.aEe;
        }

        /* renamed from: GQ */
        public final boolean m25346GQ() {
            return this.aEc;
        }

        /* renamed from: GR */
        public final boolean m25345GR() {
            return this.aDX;
        }

        /* renamed from: GS */
        public final boolean m25344GS() {
            return this.aEb;
        }

        /* renamed from: GT */
        public final boolean m25343GT() {
            return this.aEd;
        }

        /* renamed from: GU */
        public final boolean m25342GU() {
            if (m25347GP()) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = this.aEg;
                return j > 0 && currentTimeMillis - j <= this.aEf;
            }
            return true;
        }

        /* renamed from: a */
        public final C10604a m25341a(KsAdWebView.InterfaceC10597b interfaceC10597b) {
            this.aDZ = interfaceC10597b;
            return this;
        }

        /* renamed from: av */
        public final void m25340av(long j) {
            this.aEg = j;
        }

        /* renamed from: b */
        public final C10604a m25339b(KsAdWebView.InterfaceC10599d interfaceC10599d) {
            this.aDY = interfaceC10599d;
            return this;
        }

        /* renamed from: bs */
        public final C10604a m25338bs(boolean z) {
            this.aEe = true;
            return this;
        }

        /* renamed from: bt */
        public final C10604a m25337bt(boolean z) {
            this.aEa = true;
            return this;
        }

        /* renamed from: bu */
        public final C10604a m25336bu(boolean z) {
            this.aEc = z;
            return this;
        }

        /* renamed from: bv */
        public final C10604a m25335bv(boolean z) {
            this.aEb = z;
            return this;
        }

        /* renamed from: bw */
        public final C10604a m25334bw(boolean z) {
            this.aEd = true;
            return this;
        }

        /* renamed from: c */
        public final C10604a m25333c(KsAdWebView.InterfaceC10598c interfaceC10598c) {
            this.f29618OJ = interfaceC10598c;
            return this;
        }

        /* renamed from: dx */
        public final C10604a m25332dx(int i) {
            this.f29619Om = i;
            return this;
        }

        /* renamed from: ei */
        public final C10604a m25331ei(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final Context getContext() {
            return this.mContext;
        }

        /* renamed from: ij */
        public final KsAdWebView.InterfaceC10599d m25330ij() {
            return this.aDY;
        }

        /* renamed from: mh */
        public final KsAdWebView.InterfaceC10597b m25329mh() {
            return this.aDZ;
        }

        /* renamed from: nL */
        public final C9912a m25328nL() {
            return C9912a.m27285Br().m27275cI(this.f29619Om).m27274cJ(this.aEa ? 1 : 0);
        }

        /* renamed from: pB */
        public final KsAdWebView.InterfaceC10598c m25327pB() {
            return this.f29618OJ;
        }
    }

    /* renamed from: eK */
    private boolean m25349eK(String str) {
        try {
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
        if (!str.startsWith(IDataSource.f43971a) && !str.startsWith("https")) {
            if (!str.startsWith("tel:") && !str.startsWith("sms:")) {
                C10604a c10604a = this.f29617HF;
                if (c10604a != null) {
                    if (c10604a.m25346GQ()) {
                        int m26367D = C10299b.m26367D(this.f29617HF.getContext(), str);
                        if (m26367D == 1) {
                            if (this.f29617HF.m25329mh() != null) {
                                this.f29617HF.m25329mh().onSuccess();
                            }
                            C9908c.m27339a(this.f29617HF.getAdTemplate(), "", 2, (C9912a) null);
                        } else {
                            if (this.f29617HF.m25329mh() != null) {
                                this.f29617HF.m25329mh().onFailed();
                            }
                            if (m26367D == -1) {
                                C9908c.m27333b(this.f29617HF.getAdTemplate(), "", 2, null);
                            }
                        }
                        return true;
                    } else if (m25348eL(str)) {
                        return true;
                    }
                }
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            C10604a c10604a2 = this.f29617HF;
            if (c10604a2 != null) {
                c10604a2.getContext().startActivity(intent);
            }
            return true;
        }
        return false;
    }

    /* renamed from: eL */
    private static boolean m25348eL(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("hwfastapp://") || str.startsWith("hap://app") || str.startsWith("intent://hapjs.org/") || str.startsWith("intent://");
    }

    /* renamed from: K */
    public final void m25350K(String str) {
        this.mUniqueId = str;
    }

    public final C10604a getClientConfig() {
        return this.f29617HF;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        C10621b.m25261ae(this.mUniqueId, "onPageFinished");
        C10604a c10604a = this.f29617HF;
        if (c10604a == null || c10604a.m25330ij() == null) {
            return;
        }
        this.f29617HF.m25330ij().onPageFinished();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        C10621b.m25261ae(this.mUniqueId, "onPageStart");
        C10604a c10604a = this.f29617HF;
        if (c10604a == null || c10604a.m25330ij() == null) {
            return;
        }
        this.f29617HF.m25330ij().onPageStart();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        C10331c.m26254d("KsAdWebViewClient", "onReceivedError " + i);
        C10604a c10604a = this.f29617HF;
        if (c10604a != null && c10604a.m25330ij() != null) {
            this.f29617HF.m25330ij().onReceivedHttpError(i, str, str2);
        }
        C10621b.m25259ag(str2, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return (Build.VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null && renderProcessGoneDetail.didCrash()) || super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    public final void setClientConfig(C10604a c10604a) {
        this.f29617HF = c10604a;
        setNeedHybridLoad(c10604a.m25345GR());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C10331c.m26246w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
        C10621b.m25261ae(this.mUniqueId, "shouldOverrideUrlLoading");
        C10604a c10604a = this.f29617HF;
        if (c10604a == null || !c10604a.m25342GU() || m25349eK(str)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
