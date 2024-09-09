package com.qq.e.comm.plugin.q0;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import xyz.adscope.common.network.Headers;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class a extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    private com.qq.e.comm.plugin.q0.s.g f45425a;

    /* renamed from: b  reason: collision with root package name */
    private f f45426b;

    public void a(f fVar) {
        this.f45426b = fVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(str, callback);
        callback.invoke(str, true, false);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        com.qq.e.comm.plugin.q0.s.g gVar = this.f45425a;
        if (gVar == null) {
            v.b(100292, null, 1, new com.qq.e.comm.plugin.n0.d().a("msg", str2));
            return true;
        }
        com.qq.e.comm.plugin.q0.s.f<String> a4 = gVar.a(str2);
        if (a4.d()) {
            jsPromptResult.confirm(a4.b());
            return true;
        } else if (a4.a() == 1000) {
            jsPromptResult.confirm("message:" + a4.c() + ",code:" + a4.a());
            d1.a(String.format("failed message: %s --> (%d,%s)", str2, Integer.valueOf(a4.a()), a4.c()), new Object[0]);
            return true;
        } else {
            jsPromptResult.confirm("message:" + a4.c() + ",code:" + a4.a());
            d1.a(String.format("failed message: %s --> (%d,%s)", str2, Integer.valueOf(a4.a()), a4.c()), new Object[0]);
            return true;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i4) {
        super.onProgressChanged(webView, i4);
        f fVar = this.f45426b;
        if (fVar != null) {
            fVar.a(i4);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        f fVar = this.f45426b;
        if (fVar != null) {
            fVar.b(str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        d1.a("gdt_tag_inner_webview", "onShowFileChooser(%s,%s)", valueCallback, fileChooserParams);
        f fVar = this.f45426b;
        if (fVar == null || Build.VERSION.SDK_INT < 21 || fileChooserParams == null) {
            return false;
        }
        return fVar.b(valueCallback, fileChooserParams.createIntent());
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        d1.a("gdt_tag_inner_webview", "openFileChooser(%s,%s)", valueCallback, str);
        openFileChooser(valueCallback, str, null);
    }

    public void a(com.qq.e.comm.plugin.q0.s.g gVar) {
        this.f45425a = gVar;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        d1.a("gdt_tag_inner_webview", "openFileChooser(%s,%s,%s)", valueCallback, str, str2);
        if (this.f45426b == null) {
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
                return;
            }
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (TextUtils.isEmpty(str)) {
            str = Headers.VALUE_ACCEPT_ALL;
        }
        intent.setType(str);
        this.f45426b.a(valueCallback, intent);
    }
}
