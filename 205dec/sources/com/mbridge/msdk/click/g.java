package com.mbridge.msdk.click;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.x;
import java.util.HashMap;
import xyz.adscope.common.network.Headers;

/* compiled from: WebViewSpider.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static long f38916a = 0;

    /* renamed from: d  reason: collision with root package name */
    private static final String f38917d = "g";

    /* renamed from: b  reason: collision with root package name */
    boolean f38918b;

    /* renamed from: c  reason: collision with root package name */
    boolean f38919c;

    /* renamed from: e  reason: collision with root package name */
    private int f38920e;

    /* renamed from: f  reason: collision with root package name */
    private int f38921f;

    /* renamed from: h  reason: collision with root package name */
    private com.mbridge.msdk.c.a f38923h;

    /* renamed from: i  reason: collision with root package name */
    private a f38924i;

    /* renamed from: j  reason: collision with root package name */
    private String f38925j;

    /* renamed from: k  reason: collision with root package name */
    private String f38926k;

    /* renamed from: l  reason: collision with root package name */
    private WebView f38927l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f38928m;

    /* renamed from: n  reason: collision with root package name */
    private String f38929n;

    /* renamed from: o  reason: collision with root package name */
    private int f38930o;

    /* renamed from: q  reason: collision with root package name */
    private boolean f38932q;

    /* renamed from: p  reason: collision with root package name */
    private boolean f38931p = false;

    /* renamed from: r  reason: collision with root package name */
    private final Runnable f38933r = new Runnable() { // from class: com.mbridge.msdk.click.g.4
        @Override // java.lang.Runnable
        public final void run() {
            g.this.f38931p = true;
            g.this.f38930o = 1;
            String str = g.f38917d;
            x.d(str, "js\u8d85\u65f6\uff01\u8d85\u65f6\u4e0a\u9650\uff1a" + g.this.f38921f + "ms");
            g.n(g.this);
        }
    };

    /* renamed from: s  reason: collision with root package name */
    private final Runnable f38934s = new Runnable() { // from class: com.mbridge.msdk.click.g.5
        @Override // java.lang.Runnable
        public final void run() {
            g.this.f38931p = true;
            g.this.f38930o = 2;
            String str = g.f38917d;
            x.d(str, "http\u8d85\u65f6\uff01\u8d85\u65f6\u4e0a\u9650\uff1a" + g.this.f38920e + "ms");
            g.n(g.this);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private Handler f38922g = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebViewSpider.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void a(int i4, String str, String str2, String str3);

        void a(String str, boolean z3, String str2);

        boolean a(String str);

        boolean b(String str);

        boolean c(String str);
    }

    public g(boolean z3) {
        this.f38920e = 15000;
        this.f38921f = 3000;
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        this.f38923h = b4;
        if (b4 == null) {
            this.f38923h = com.mbridge.msdk.c.b.a().b();
        }
        this.f38928m = this.f38923h.af();
        if (z3) {
            this.f38920e = (int) this.f38923h.ab();
            this.f38921f = (int) this.f38923h.ab();
            return;
        }
        this.f38920e = (int) this.f38923h.ac();
        this.f38921f = (int) this.f38923h.ac();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f38922g.removeCallbacks(this.f38934s);
    }

    static /* synthetic */ void e(g gVar) {
        gVar.c();
        gVar.f38922g.postDelayed(gVar.f38934s, gVar.f38920e);
    }

    static /* synthetic */ void l(g gVar) {
        gVar.d();
        gVar.f38922g.postDelayed(gVar.f38933r, gVar.f38921f);
    }

    static /* synthetic */ void n(g gVar) {
        synchronized (f38917d) {
            try {
                gVar.b();
                gVar.f38927l.destroy();
                a aVar = gVar.f38924i;
                if (aVar != null) {
                    aVar.a(gVar.f38925j, gVar.f38931p, gVar.f38929n);
                }
            } catch (Exception unused) {
                x.d(f38917d, "webview colse to failed");
            } catch (Throwable unused2) {
                x.d(f38917d, "webview colse to failed");
            }
        }
    }

    static /* synthetic */ void c(g gVar) {
        synchronized (f38917d) {
            try {
                gVar.b();
                a aVar = gVar.f38924i;
                if (aVar != null) {
                    aVar.a(gVar.f38925j, gVar.f38931p, gVar.f38929n);
                }
            } catch (Exception unused) {
                x.d(f38917d, "webview colse to failed");
            } catch (Throwable unused2) {
                x.d(f38917d, "webview colse to failed");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f38922g.removeCallbacks(this.f38933r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        d();
        c();
    }

    public final void a(String str, String str2, String str3, Context context, String str4, String str5, a aVar) {
        if (aVar != null) {
            this.f38926k = str5;
            this.f38925j = str4;
            this.f38924i = aVar;
            a(str, str2, str3, context);
            return;
        }
        throw new NullPointerException("OverrideUrlLoadingListener can not be null");
    }

    public final void a(String str, String str2, String str3, Context context, String str4, a aVar) {
        if (aVar != null) {
            this.f38925j = str4;
            this.f38924i = aVar;
            a(str, str2, str3, context);
            return;
        }
        throw new NullPointerException("OverrideUrlLoadingListener can not be null");
    }

    private void a(final String str, final String str2, final String str3, final Context context) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            a(str, str2, str3, context, this.f38925j);
        } else {
            this.f38922g.post(new Runnable() { // from class: com.mbridge.msdk.click.g.1
                @Override // java.lang.Runnable
                public final void run() {
                    g gVar = g.this;
                    gVar.a(str, str2, str3, context, gVar.f38925j);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, Context context, String str4) {
        try {
            a(context, str, str2, str3);
            if (!TextUtils.isEmpty(this.f38926k)) {
                this.f38927l.getSettings().setDefaultTextEncodingName("utf-8");
                this.f38921f = 2000;
                this.f38920e = 2000;
                x.b(f38917d, this.f38926k);
                this.f38927l.loadDataWithBaseURL(str4, this.f38926k, Headers.VALUE_ACCEPT_ALL, "utf-8", str4);
            } else if (this.f38928m) {
                HashMap hashMap = new HashMap();
                if (this.f38927l.getUrl() != null) {
                    hashMap.put("Referer", this.f38927l.getUrl());
                }
                this.f38927l.loadUrl(str4, hashMap);
            } else {
                this.f38927l.loadUrl(str4);
            }
        } catch (Throwable th) {
            try {
                a aVar = this.f38924i;
                if (aVar != null) {
                    aVar.a(0, this.f38925j, th.getMessage(), this.f38929n);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void a(final Context context, final String str, final String str2, final String str3) {
        WebView webView = new WebView(context);
        this.f38927l = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f38927l.getSettings().setCacheMode(2);
        this.f38927l.getSettings().setLoadsImagesAutomatically(false);
        this.f38927l.setWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.click.g.2
            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView2, String str4) {
                super.onPageFinished(webView2, str4);
                try {
                    webView2.loadUrl("javascript:window.navigator.vibrate([]);");
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView2, String str4, Bitmap bitmap) {
                try {
                    webView2.loadUrl("javascript:window.navigator.vibrate([]);");
                    boolean z3 = false;
                    if (g.this.f38932q) {
                        g.this.f38930o = 0;
                        g.c(g.this);
                        return;
                    }
                    g.this.f38919c = false;
                    if (webView2.getTag() == null) {
                        webView2.setTag("has_first_started");
                    } else {
                        g.this.f38918b = true;
                    }
                    synchronized (g.f38917d) {
                        String str5 = "\u52a0\u8f7d\u9875\u9762-\u5f00\u59cb\uff1a";
                        g gVar = g.this;
                        if ((gVar.f38918b || gVar.f38919c) ? true : true) {
                            str5 = "\u52a0\u8f7d\u9875\u9762-\u5f00\u59cb\uff1a\uff08\u91cd\u5b9a\u5411\uff09";
                        }
                        if (URLUtil.isHttpsUrl(str4)) {
                            x.d(g.f38917d, str5 + str4);
                        } else {
                            x.b(g.f38917d, str5 + str4);
                        }
                        g.this.f38925j = str4;
                        if (g.this.f38924i != null && g.this.f38924i.a(str4)) {
                            g.this.f38932q = true;
                            g.c(g.this);
                        } else {
                            g.e(g.this);
                        }
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView2, int i4, String str4, String str5) {
                String str6 = g.f38917d;
                x.b(str6, "onReceivedError: errno = " + i4 + ", url: " + webView2.getUrl() + ",\n onReceivedError\uff1a, description: " + str4 + ", failingUrl: " + str5);
                synchronized (g.f38917d) {
                    g.this.f38932q = true;
                    g.this.b();
                    g.c(g.this);
                }
                if (g.this.f38924i != null) {
                    g.this.f38924i.a(i4, webView2.getUrl(), str4, g.this.f38929n);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) {
                try {
                    String str4 = g.f38917d;
                    x.a(str4, "onReceivedSslError IS_SP_CBT_CF:" + MBridgeConstans.IS_SP_CBT_CF);
                    if (MBridgeConstans.IS_SP_CBT_CF && sslErrorHandler != null) {
                        sslErrorHandler.cancel();
                    }
                    if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
                        return;
                    }
                    new com.mbridge.msdk.foundation.same.report.d(context).a(str, str2, str3, webView2.getUrl());
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, String str4) {
                synchronized (g.f38917d) {
                    String str5 = g.f38917d;
                    x.a(str5, "override js\u8df3\u8f6c\uff1a" + str4);
                    g gVar = g.this;
                    gVar.f38919c = true;
                    gVar.d();
                    if (!g.this.f38932q) {
                        g.this.f38925j = str4;
                        if (g.this.f38924i != null && g.this.f38924i.b(str4)) {
                            g.this.f38932q = true;
                            g.this.c();
                            g.c(g.this);
                            return true;
                        }
                        if (g.this.f38928m) {
                            HashMap hashMap = new HashMap();
                            if (g.this.f38927l.getUrl() != null) {
                                hashMap.put("Referer", g.this.f38927l.getUrl());
                            }
                            g.this.f38927l.loadUrl(str4, hashMap);
                        } else {
                            g.this.f38927l.loadUrl(str4);
                        }
                        return true;
                    }
                    g.this.c();
                    g.c(g.this);
                    return true;
                }
            }
        });
        this.f38927l.setWebChromeClient(new WebChromeClient() { // from class: com.mbridge.msdk.click.g.3
            @Override // android.webkit.WebChromeClient
            public final boolean onJsAlert(WebView webView2, String str4, String str5, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsConfirm(WebView webView2, String str4, String str5, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsPrompt(WebView webView2, String str4, String str5, String str6, JsPromptResult jsPromptResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView2, int i4) {
                if (i4 == 100) {
                    try {
                        String str4 = g.f38917d;
                        x.b(str4, "\u52a0\u8f7d\u9875\u9762-\u8fdb\u5ea6\u5b8c\u6210\uff1a" + webView2.getUrl());
                        webView2.loadUrl("javascript:window.navigator.vibrate([]);");
                        if (!g.this.f38932q) {
                            g gVar = g.this;
                            if (!gVar.f38919c) {
                                g.l(gVar);
                            }
                        }
                        if (g.this.f38924i != null) {
                            g.this.f38924i.c(webView2.getUrl());
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        });
    }
}
