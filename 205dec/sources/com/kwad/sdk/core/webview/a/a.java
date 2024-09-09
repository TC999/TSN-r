package com.kwad.sdk.core.webview.a;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.config.d;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a extends WebViewClient {
    private boolean aDX = true;
    protected String mUniqueId = "";

    public final void setNeedHybridLoad(boolean z3) {
        this.aDX = z3;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.aDX && d.Cj()) {
            com.kwad.sdk.core.e.c.d("HybridWebViewClient", "shouldInterceptRequest: " + str);
            WebResourceResponse aa = com.kwad.sdk.core.webview.b.a.GV().aa(str, this.mUniqueId);
            return aa == null ? super.shouldInterceptRequest(webView, str) : aa;
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.aDX && d.Cj()) {
            String uri = webResourceRequest.getUrl().toString();
            com.kwad.sdk.core.e.c.d("HybridWebViewClient", "shouldInterceptRequestAPI 21: " + uri);
            WebResourceResponse aa = com.kwad.sdk.core.webview.b.a.GV().aa(uri, this.mUniqueId);
            return aa == null ? super.shouldInterceptRequest(webView, webResourceRequest) : aa;
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }
}
