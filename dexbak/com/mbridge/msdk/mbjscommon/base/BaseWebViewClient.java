package com.mbridge.msdk.mbjscommon.base;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mbridge.msdk.mbjscommon.windvane.IWebViewListener;

/* renamed from: com.mbridge.msdk.mbjscommon.base.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BaseWebViewClient extends WebViewClient {

    /* renamed from: a */
    private BaseFilter f31431a;

    /* renamed from: b */
    private IWebViewListener f31432b;

    /* renamed from: a */
    public final void m21527a(BaseFilter baseFilter) {
        this.f31431a = baseFilter;
    }

    /* renamed from: b */
    public final BaseFilter m21525b() {
        return this.f31431a;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        IWebViewListener iWebViewListener = this.f31432b;
        if (iWebViewListener != null) {
            iWebViewListener.mo21037a(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        IWebViewListener iWebViewListener = this.f31432b;
        if (iWebViewListener != null) {
            iWebViewListener.mo21138a(webView, i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        IWebViewListener iWebViewListener = this.f31432b;
        if (iWebViewListener != null) {
            iWebViewListener.mo21137a(webView, sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        BaseFilter baseFilter = this.f31431a;
        if (baseFilter == null || !baseFilter.mo21524a(str)) {
            IWebViewListener iWebViewListener = this.f31432b;
            if (iWebViewListener != null) {
                iWebViewListener.mo21398b(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }

    /* renamed from: a */
    public final void m21526a(IWebViewListener iWebViewListener) {
        this.f31432b = iWebViewListener;
    }
}
