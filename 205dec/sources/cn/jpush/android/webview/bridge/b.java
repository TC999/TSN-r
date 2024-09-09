package cn.jpush.android.webview.bridge;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    private final String f4508a = "InjectedChromeClient";

    /* renamed from: b  reason: collision with root package name */
    private c f4509b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4510c;

    public b(String str, Class cls) {
        this.f4509b = new c(str, cls);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i4) {
        webView.getSettings().setSavePassword(false);
        super.onProgressChanged(webView, i4);
    }
}
