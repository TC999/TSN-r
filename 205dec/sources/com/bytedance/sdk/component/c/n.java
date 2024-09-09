package com.bytedance.sdk.component.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class n extends c {

    /* renamed from: p  reason: collision with root package name */
    static final /* synthetic */ boolean f29678p = true;
    protected String ev;
    protected WebView gd;

    @Override // com.bytedance.sdk.component.c.c
    protected String c() {
        return this.gd.getUrl();
    }

    @Override // com.bytedance.sdk.component.c.c
    protected Context getContext(p pVar) {
        Context context = pVar.ux;
        if (context != null) {
            return context;
        }
        WebView webView = pVar.f29682c;
        if (webView != null) {
            return webView.getContext();
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.bytedance.sdk.component.c.c
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    protected void sr() {
        this.gd.removeJavascriptInterface(this.ev);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.c.c
    public void w() {
        super.w();
        sr();
    }

    @SuppressLint({"AddJavascriptInterface"})
    protected void xv() {
        if (!f29678p && this.gd == null) {
            throw new AssertionError();
        }
        this.gd.addJavascriptInterface(this, this.ev);
    }

    @Override // com.bytedance.sdk.component.c.c
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    protected void c(p pVar) {
        this.gd = pVar.f29682c;
        this.ev = pVar.xv;
        if (pVar.f29687t) {
            return;
        }
        xv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.c.c
    public void c(String str, ia iaVar) {
        if (iaVar != null && !TextUtils.isEmpty(iaVar.ev)) {
            String str2 = iaVar.ev;
            c(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
            return;
        }
        super.c(str, iaVar);
    }

    @Override // com.bytedance.sdk.component.c.c
    protected void c(String str) {
        c(str, "javascript:" + this.ev + "._handleMessageFromToutiao(" + str + ")");
    }

    private void c(String str, final String str2) {
        if (this.f29652f || TextUtils.isEmpty(str2)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.c.n.1
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.f29652f) {
                    return;
                }
                try {
                    if (Build.VERSION.SDK_INT >= 19) {
                        gd.c("Invoking Jsb using evaluateJavascript: " + str2);
                        n.this.gd.evaluateJavascript(str2, null);
                    } else {
                        gd.c("Invoking Jsb using loadUrl: " + str2);
                        n.this.gd.loadUrl(str2);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            gd.c("Received call on sub-thread, posting to main thread: " + str2);
            this.sr.post(runnable);
            return;
        }
        runnable.run();
    }
}
