package com.bytedance.sdk.openadsdk.core.widget.c;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.eq.fz;
import com.bytedance.sdk.openadsdk.core.u.n;
import com.bytedance.sdk.openadsdk.core.xk;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends WebChromeClient {

    /* renamed from: c  reason: collision with root package name */
    private static final String f35409c = WebChromeClient.class.getSimpleName();

    /* renamed from: w  reason: collision with root package name */
    private final xk f35410w;
    private com.bytedance.sdk.openadsdk.core.a.sr xv;

    public xv(xk xkVar) {
        this.f35410w = xkVar;
    }

    private boolean c(String str) {
        try {
            Uri parse = Uri.parse(str);
            if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                fz.c(parse, this.f35410w);
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i4, String str2) {
        if (!TextUtils.isEmpty(str)) {
            c(str);
        }
        super.onConsoleMessage(str, i4, str2);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (n.c(this.f35410w, 1, str2)) {
            jsResult.confirm();
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (n.c(this.f35410w, 4, str2)) {
            jsResult.confirm();
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (n.c(this.f35410w, 2, str2)) {
            jsResult.confirm();
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (n.c(this.f35410w, 3, str2)) {
            jsPromptResult.confirm();
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i4) {
        com.bytedance.sdk.openadsdk.core.a.sr srVar;
        super.onProgressChanged(webView, i4);
        com.bytedance.sdk.openadsdk.core.a.sr srVar2 = this.xv;
        if (srVar2 != null) {
            srVar2.c(webView, i4);
        }
        if (i4 <= 90 || (srVar = this.xv) == null) {
            return;
        }
        srVar.c(webView, webView.getUrl());
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }

    public xv(xk xkVar, com.bytedance.sdk.openadsdk.core.a.sr srVar) {
        this.f35410w = xkVar;
        this.xv = srVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage == null || TextUtils.isEmpty(consoleMessage.message()) || !c(consoleMessage.message())) {
            return super.onConsoleMessage(consoleMessage);
        }
        return true;
    }
}
