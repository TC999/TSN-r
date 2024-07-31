package com.beizi.p051ad.internal.view;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.utilities.HaoboLog;

/* renamed from: com.beizi.ad.internal.view.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaseWebChromeClient extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        HaoboLog.m49286v(HaoboLog.jsLogTag, HaoboLog.getString(C2750R.C2755string.console_message, consoleMessage.message(), consoleMessage.lineNumber(), consoleMessage.sourceId()));
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        HaoboLog.m49286v(HaoboLog.jsLogTag, HaoboLog.getString(C2750R.C2755string.js_alert, str2, str));
        jsResult.confirm();
        return true;
    }
}
