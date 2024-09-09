package com.bytedance.sdk.component.adexpress.ux;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.component.sdk.annotation.UiThread;
import com.bytedance.sdk.component.c.n;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.widget.SSWebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: f  reason: collision with root package name */
    private static int f29408f = 10;
    private static volatile ux gd = null;

    /* renamed from: r  reason: collision with root package name */
    private static int f29409r = 10;
    private static final byte[] ux = new byte[0];
    private final AtomicBoolean ev = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private List<SSWebView> f29410c = new ArrayList();

    /* renamed from: w  reason: collision with root package name */
    private List<SSWebView> f29411w = new ArrayList();
    private Map<Integer, xv> xv = new HashMap();
    private Map<Integer, sr> sr = new HashMap();

    private ux() {
        com.bytedance.sdk.component.adexpress.c.c.xv xv = com.bytedance.sdk.component.adexpress.c.c.c.c().xv();
        if (xv != null) {
            f29408f = xv.gd();
            f29409r = xv.p();
        }
    }

    public static ux c() {
        if (gd == null) {
            synchronized (ux.class) {
                if (gd == null) {
                    gd = new ux();
                }
            }
        }
        return gd;
    }

    private void r(SSWebView sSWebView) {
        sSWebView.removeAllViews();
        sSWebView.Z_();
        sSWebView.setWebChromeClient(null);
        sSWebView.setWebViewClient(null);
        sSWebView.setDownloadListener(null);
        sSWebView.setJavaScriptEnabled(true);
        sSWebView.setAppCacheEnabled(false);
        sSWebView.setSupportZoom(false);
        sSWebView.setUseWideViewPort(true);
        sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
        sSWebView.setDomStorageEnabled(true);
        sSWebView.setBuiltInZoomControls(false);
        sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        sSWebView.setLoadWithOverviewMode(false);
        sSWebView.setUserAgentString("android_client");
        sSWebView.setDefaultTextEncodingName("UTF-8");
        sSWebView.setDefaultFontSize(16);
    }

    public void f(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        xv xvVar = this.xv.get(Integer.valueOf(sSWebView.hashCode()));
        if (xvVar != null) {
            xvVar.c(null);
        }
        sSWebView.w("SDK_INJECT_GLOBAL");
    }

    public void sr(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.f29410c.size() >= f29408f) {
            a.w("WebViewPool", "WebView pool is full\uff0cdestroy webview");
            sSWebView.gd();
        } else if (this.f29410c.contains(sSWebView)) {
        } else {
            this.f29410c.add(sSWebView);
            a.w("WebViewPool", "recycle WebView\uff0ccurrent available count: " + xv());
        }
    }

    public boolean ux(SSWebView sSWebView) {
        if (sSWebView == null) {
            return false;
        }
        a.w("WebViewPool", "WebView render fail and abandon");
        sSWebView.gd();
        return true;
    }

    @UiThread
    public void w(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        r(sSWebView);
        sSWebView.w("SDK_INJECT_GLOBAL");
        f(sSWebView);
        c(sSWebView);
    }

    @UiThread
    public void xv(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        r(sSWebView);
        sSWebView.w("SDK_INJECT_GLOBAL");
        f(sSWebView);
        sr(sSWebView);
    }

    public int ux() {
        return this.f29410c.size() + sr();
    }

    public SSWebView w(Context context, String str) {
        SSWebView remove;
        if (xv() > 0 && (remove = this.f29410c.remove(0)) != null) {
            a.w("WebViewPool", "get WebView from pool; current available count: " + xv());
            return remove;
        }
        return null;
    }

    public int xv() {
        return this.f29410c.size();
    }

    public SSWebView c(Context context, String str) {
        SSWebView remove;
        if (sr() > 0 && (remove = this.f29411w.remove(0)) != null) {
            a.w("WebViewPool", "get WebView from pool; current available count: " + this.f29411w.size());
            return remove;
        }
        return null;
    }

    public int sr() {
        return this.f29411w.size();
    }

    public void w() {
        for (SSWebView sSWebView : this.f29410c) {
            if (sSWebView != null) {
                sSWebView.gd();
            }
        }
        this.f29410c.clear();
        for (SSWebView sSWebView2 : this.f29411w) {
            if (sSWebView2 != null) {
                sSWebView2.gd();
            }
        }
        this.f29411w.clear();
    }

    public void c(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        if (this.f29411w.size() >= f29409r) {
            a.w("WebViewPool", "WebView pool is full\uff0cdestroy webview");
            sSWebView.gd();
        } else if (this.f29411w.contains(sSWebView)) {
        } else {
            this.f29411w.add(sSWebView);
            a.w("WebViewPool", "recycle WebView\uff0ccurrent available count: " + this.f29411w.size());
        }
    }

    @SuppressLint({"JavascriptInterface"})
    public void c(SSWebView sSWebView, w wVar) {
        if (sSWebView == null || wVar == null) {
            return;
        }
        xv xvVar = this.xv.get(Integer.valueOf(sSWebView.hashCode()));
        if (xvVar != null) {
            xvVar.c(wVar);
        } else {
            xvVar = new xv(wVar);
            this.xv.put(Integer.valueOf(sSWebView.hashCode()), xvVar);
        }
        sSWebView.c(xvVar, "SDK_INJECT_GLOBAL");
    }

    @SuppressLint({"JavascriptInterface"})
    public void c(WebView webView, n nVar, String str) {
        if (webView == null || nVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        sr srVar = this.sr.get(Integer.valueOf(webView.hashCode()));
        if (srVar != null) {
            srVar.c(nVar);
        } else {
            srVar = new sr(nVar);
            this.sr.put(Integer.valueOf(webView.hashCode()), srVar);
        }
        webView.addJavascriptInterface(srVar, str);
    }

    public void c(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        sr srVar = this.sr.get(Integer.valueOf(webView.hashCode()));
        if (srVar != null) {
            srVar.c(null);
        }
        webView.removeJavascriptInterface(str);
    }
}
