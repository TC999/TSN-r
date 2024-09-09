package com.beizi.ad.internal.view;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.beizi.ad.R;
import com.beizi.ad.internal.utilities.HaoboLog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BaseWebChromeClient.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        HaoboLog.v(HaoboLog.jsLogTag, HaoboLog.getString(R.string.console_message, consoleMessage.message(), consoleMessage.lineNumber(), consoleMessage.sourceId()));
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        HaoboLog.v(HaoboLog.jsLogTag, HaoboLog.getString(R.string.js_alert, str2, str));
        jsResult.confirm();
        return true;
    }
}
