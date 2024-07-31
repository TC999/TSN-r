package com.mbridge.msdk.mbjscommon.windvane;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.SameLogTool;

/* renamed from: com.mbridge.msdk.mbjscommon.windvane.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class WindVaneWebViewChromeClient extends WebChromeClient {

    /* renamed from: a */
    WindVaneWebView f31591a;

    /* renamed from: b */
    private IWebViewListener f31592b;

    public WindVaneWebViewChromeClient(WindVaneWebView windVaneWebView) {
        this.f31591a = windVaneWebView;
    }

    /* renamed from: a */
    public final void m21372a(IWebViewListener iWebViewListener) {
        this.f31592b = iWebViewListener;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.LOG) {
            return super.onConsoleMessage(consoleMessage);
        }
        IJsBridge jsBridge = this.f31591a.getJsBridge();
        if (jsBridge != null) {
            String message = consoleMessage.message();
            if (TextUtils.isEmpty(message) || !message.startsWith("mv://")) {
                return false;
            }
            SameLogTool.m21738a("H5_ENTRY", "onConsoleMessage: message.length() = " + message.length() + " " + message);
            if (message.contains("wv_hybrid:") && jsBridge.mo21380a("wv_hybrid:")) {
                String substring = message.substring(0, message.lastIndexOf(" ") + 1);
                SameLogTool.m21738a("H5_ENTRY", "message = " + substring);
                jsBridge.mo21379b(substring);
                return true;
            }
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        SameLogTool.m21733d("H5_ENTRY", str2 + "");
        IJsBridge jsBridge = this.f31591a.getJsBridge();
        if (jsBridge == null || str3 == null || !jsBridge.mo21380a(str3)) {
            return false;
        }
        jsBridge.mo21379b(str2);
        jsPromptResult.confirm("");
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        IWebViewListener iWebViewListener = this.f31592b;
        if (iWebViewListener != null) {
            iWebViewListener.mo21399b(webView, i);
        }
    }
}
