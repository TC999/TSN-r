package com.mbridge.msdk.mbjscommon.windvane;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.x;

/* compiled from: WindVaneWebViewChromeClient.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class l extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    WindVaneWebView f40363a;

    /* renamed from: b  reason: collision with root package name */
    private d f40364b;

    public l(WindVaneWebView windVaneWebView) {
        this.f40363a = windVaneWebView;
    }

    public final void a(d dVar) {
        this.f40364b = dVar;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.LOG) {
            return super.onConsoleMessage(consoleMessage);
        }
        b jsBridge = this.f40363a.getJsBridge();
        if (jsBridge != null) {
            String message = consoleMessage.message();
            if (TextUtils.isEmpty(message) || !message.startsWith("mv://")) {
                return false;
            }
            x.a("H5_ENTRY", "onConsoleMessage: message.length() = " + message.length() + " " + message);
            if (message.contains("wv_hybrid:") && jsBridge.a("wv_hybrid:")) {
                String substring = message.substring(0, message.lastIndexOf(" ") + 1);
                x.a("H5_ENTRY", "message = " + substring);
                jsBridge.b(substring);
                return true;
            }
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        x.d("H5_ENTRY", str2 + "");
        b jsBridge = this.f40363a.getJsBridge();
        if (jsBridge == null || str3 == null || !jsBridge.a(str3)) {
            return false;
        }
        jsBridge.b(str2);
        jsPromptResult.confirm("");
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i4) {
        super.onProgressChanged(webView, i4);
        d dVar = this.f40364b;
        if (dVar != null) {
            dVar.b(webView, i4);
        }
    }
}
