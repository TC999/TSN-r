package com.kwad.sdk.core.webview.p417a;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.webview.p418b.C10606a;

/* renamed from: com.kwad.sdk.core.webview.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10601a extends WebViewClient {
    private boolean aDX = true;
    protected String mUniqueId = "";

    public final void setNeedHybridLoad(boolean z) {
        this.aDX = z;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.aDX && C10251d.m26545Cj()) {
            C10331c.m26254d("HybridWebViewClient", "shouldInterceptRequest: " + str);
            WebResourceResponse m25307aa = C10606a.m25320GV().m25307aa(str, this.mUniqueId);
            return m25307aa == null ? super.shouldInterceptRequest(webView, str) : m25307aa;
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.aDX && C10251d.m26545Cj()) {
            String uri = webResourceRequest.getUrl().toString();
            C10331c.m26254d("HybridWebViewClient", "shouldInterceptRequestAPI 21: " + uri);
            WebResourceResponse m25307aa = C10606a.m25320GV().m25307aa(uri, this.mUniqueId);
            return m25307aa == null ? super.shouldInterceptRequest(webView, webResourceRequest) : m25307aa;
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }
}
