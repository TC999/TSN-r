package com.kwad.sdk.core.webview.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class c extends com.kwad.sdk.core.webview.a.a {
    private a HF;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private KsAdWebView.c OJ;
        private int Om;
        private KsAdWebView.d aDY;
        private KsAdWebView.b aDZ;
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

        public a(Context context) {
            this.mContext = context;
        }

        private boolean GP() {
            return this.aEe;
        }

        public final boolean GQ() {
            return this.aEc;
        }

        public final boolean GR() {
            return this.aDX;
        }

        public final boolean GS() {
            return this.aEb;
        }

        public final boolean GT() {
            return this.aEd;
        }

        public final boolean GU() {
            if (GP()) {
                long currentTimeMillis = System.currentTimeMillis();
                long j4 = this.aEg;
                return j4 > 0 && currentTimeMillis - j4 <= this.aEf;
            }
            return true;
        }

        public final a a(KsAdWebView.b bVar) {
            this.aDZ = bVar;
            return this;
        }

        public final void av(long j4) {
            this.aEg = j4;
        }

        public final a b(KsAdWebView.d dVar) {
            this.aDY = dVar;
            return this;
        }

        public final a bs(boolean z3) {
            this.aEe = true;
            return this;
        }

        public final a bt(boolean z3) {
            this.aEa = true;
            return this;
        }

        public final a bu(boolean z3) {
            this.aEc = z3;
            return this;
        }

        public final a bv(boolean z3) {
            this.aEb = z3;
            return this;
        }

        public final a bw(boolean z3) {
            this.aEd = true;
            return this;
        }

        public final a c(KsAdWebView.c cVar) {
            this.OJ = cVar;
            return this;
        }

        public final a dx(int i4) {
            this.Om = i4;
            return this;
        }

        public final a ei(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final Context getContext() {
            return this.mContext;
        }

        public final KsAdWebView.d ij() {
            return this.aDY;
        }

        public final KsAdWebView.b mh() {
            return this.aDZ;
        }

        public final com.kwad.sdk.core.adlog.c.a nL() {
            return com.kwad.sdk.core.adlog.c.a.Br().cI(this.Om).cJ(this.aEa ? 1 : 0);
        }

        public final KsAdWebView.c pB() {
            return this.OJ;
        }
    }

    private boolean eK(String str) {
        try {
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
        }
        if (!str.startsWith("http") && !str.startsWith("https")) {
            if (!str.startsWith("tel:") && !str.startsWith("sms:")) {
                a aVar = this.HF;
                if (aVar != null) {
                    if (aVar.GQ()) {
                        int D = com.kwad.sdk.core.download.a.b.D(this.HF.getContext(), str);
                        if (D == 1) {
                            if (this.HF.mh() != null) {
                                this.HF.mh().onSuccess();
                            }
                            com.kwad.sdk.core.adlog.c.a(this.HF.getAdTemplate(), "", 2, (com.kwad.sdk.core.adlog.c.a) null);
                        } else {
                            if (this.HF.mh() != null) {
                                this.HF.mh().onFailed();
                            }
                            if (D == -1) {
                                com.kwad.sdk.core.adlog.c.b(this.HF.getAdTemplate(), "", 2, null);
                            }
                        }
                        return true;
                    } else if (eL(str)) {
                        return true;
                    }
                }
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            a aVar2 = this.HF;
            if (aVar2 != null) {
                aVar2.getContext().startActivity(intent);
            }
            return true;
        }
        return false;
    }

    private static boolean eL(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("hwfastapp://") || str.startsWith("hap://app") || str.startsWith("intent://hapjs.org/") || str.startsWith("intent://");
    }

    public final void K(String str) {
        this.mUniqueId = str;
    }

    public final a getClientConfig() {
        return this.HF;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "onPageFinished");
        a aVar = this.HF;
        if (aVar == null || aVar.ij() == null) {
            return;
        }
        this.HF.ij().onPageFinished();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "onPageStart");
        a aVar = this.HF;
        if (aVar == null || aVar.ij() == null) {
            return;
        }
        this.HF.ij().onPageStart();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i4, String str, String str2) {
        super.onReceivedError(webView, i4, str, str2);
        com.kwad.sdk.core.e.c.d("KsAdWebViewClient", "onReceivedError " + i4);
        a aVar = this.HF;
        if (aVar != null && aVar.ij() != null) {
            this.HF.ij().onReceivedHttpError(i4, str, str2);
        }
        com.kwad.sdk.core.webview.b.c.b.ag(str2, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return (Build.VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null && renderProcessGoneDetail.didCrash()) || super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    public final void setClientConfig(a aVar) {
        this.HF = aVar;
        setNeedHybridLoad(aVar.GR());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.kwad.sdk.core.e.c.w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
        com.kwad.sdk.core.webview.b.c.b.ae(this.mUniqueId, "shouldOverrideUrlLoading");
        a aVar = this.HF;
        if (aVar == null || !aVar.GU() || eK(str)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
