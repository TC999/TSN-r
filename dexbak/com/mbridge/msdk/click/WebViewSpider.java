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
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.report.ReportController;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import java.util.HashMap;

/* renamed from: com.mbridge.msdk.click.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class WebViewSpider {

    /* renamed from: a */
    public static long f30089a = 0;

    /* renamed from: d */
    private static final String f30090d = "g";

    /* renamed from: b */
    boolean f30091b;

    /* renamed from: c */
    boolean f30092c;

    /* renamed from: e */
    private int f30093e;

    /* renamed from: f */
    private int f30094f;

    /* renamed from: h */
    private Setting f30096h;

    /* renamed from: i */
    private InterfaceC11230a f30097i;

    /* renamed from: j */
    private String f30098j;

    /* renamed from: k */
    private String f30099k;

    /* renamed from: l */
    private WebView f30100l;

    /* renamed from: m */
    private boolean f30101m;

    /* renamed from: n */
    private String f30102n;

    /* renamed from: o */
    private int f30103o;

    /* renamed from: q */
    private boolean f30105q;

    /* renamed from: p */
    private boolean f30104p = false;

    /* renamed from: r */
    private final Runnable f30106r = new Runnable() { // from class: com.mbridge.msdk.click.g.4
        @Override // java.lang.Runnable
        public final void run() {
            WebViewSpider.this.f30104p = true;
            WebViewSpider.this.f30103o = 1;
            String str = WebViewSpider.f30090d;
            SameLogTool.m21733d(str, "js超时！超时上限：" + WebViewSpider.this.f30094f + "ms");
            WebViewSpider.m23032n(WebViewSpider.this);
        }
    };

    /* renamed from: s */
    private final Runnable f30107s = new Runnable() { // from class: com.mbridge.msdk.click.g.5
        @Override // java.lang.Runnable
        public final void run() {
            WebViewSpider.this.f30104p = true;
            WebViewSpider.this.f30103o = 2;
            String str = WebViewSpider.f30090d;
            SameLogTool.m21733d(str, "http超时！超时上限：" + WebViewSpider.this.f30093e + "ms");
            WebViewSpider.m23032n(WebViewSpider.this);
        }
    };

    /* renamed from: g */
    private Handler f30095g = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebViewSpider.java */
    /* renamed from: com.mbridge.msdk.click.g$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11230a {
        /* renamed from: a */
        void mo23008a(int i, String str, String str2, String str3);

        /* renamed from: a */
        void mo23006a(String str, boolean z, String str2);

        /* renamed from: a */
        boolean mo23007a(String str);

        /* renamed from: b */
        boolean mo23005b(String str);

        /* renamed from: c */
        boolean mo23004c(String str);
    }

    public WebViewSpider(boolean z) {
        this.f30093e = 15000;
        this.f30094f = 3000;
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        this.f30096h = m23252b;
        if (m23252b == null) {
            this.f30096h = SettingManager.m23261a().m23253b();
        }
        this.f30101m = this.f30096h.m23366af();
        if (z) {
            this.f30093e = (int) this.f30096h.m23370ab();
            this.f30094f = (int) this.f30096h.m23370ab();
            return;
        }
        this.f30093e = (int) this.f30096h.m23369ac();
        this.f30094f = (int) this.f30096h.m23369ac();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m23045c() {
        this.f30095g.removeCallbacks(this.f30107s);
    }

    /* renamed from: e */
    static /* synthetic */ void m23041e(WebViewSpider webViewSpider) {
        webViewSpider.m23045c();
        webViewSpider.f30095g.postDelayed(webViewSpider.f30107s, webViewSpider.f30093e);
    }

    /* renamed from: l */
    static /* synthetic */ void m23034l(WebViewSpider webViewSpider) {
        webViewSpider.m23043d();
        webViewSpider.f30095g.postDelayed(webViewSpider.f30106r, webViewSpider.f30094f);
    }

    /* renamed from: n */
    static /* synthetic */ void m23032n(WebViewSpider webViewSpider) {
        synchronized (f30090d) {
            try {
                webViewSpider.m23048b();
                webViewSpider.f30100l.destroy();
                InterfaceC11230a interfaceC11230a = webViewSpider.f30097i;
                if (interfaceC11230a != null) {
                    interfaceC11230a.mo23006a(webViewSpider.f30098j, webViewSpider.f30104p, webViewSpider.f30102n);
                }
            } catch (Exception unused) {
                SameLogTool.m21733d(f30090d, "webview colse to failed");
            } catch (Throwable unused2) {
                SameLogTool.m21733d(f30090d, "webview colse to failed");
            }
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m23044c(WebViewSpider webViewSpider) {
        synchronized (f30090d) {
            try {
                webViewSpider.m23048b();
                InterfaceC11230a interfaceC11230a = webViewSpider.f30097i;
                if (interfaceC11230a != null) {
                    interfaceC11230a.mo23006a(webViewSpider.f30098j, webViewSpider.f30104p, webViewSpider.f30102n);
                }
            } catch (Exception unused) {
                SameLogTool.m21733d(f30090d, "webview colse to failed");
            } catch (Throwable unused2) {
                SameLogTool.m21733d(f30090d, "webview colse to failed");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m23043d() {
        this.f30095g.removeCallbacks(this.f30106r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m23048b() {
        m23043d();
        m23045c();
    }

    /* renamed from: a */
    public final void m23049a(String str, String str2, String str3, Context context, String str4, String str5, InterfaceC11230a interfaceC11230a) {
        if (interfaceC11230a != null) {
            this.f30099k = str5;
            this.f30098j = str4;
            this.f30097i = interfaceC11230a;
            m23052a(str, str2, str3, context);
            return;
        }
        throw new NullPointerException("OverrideUrlLoadingListener can not be null");
    }

    /* renamed from: a */
    public final void m23050a(String str, String str2, String str3, Context context, String str4, InterfaceC11230a interfaceC11230a) {
        if (interfaceC11230a != null) {
            this.f30098j = str4;
            this.f30097i = interfaceC11230a;
            m23052a(str, str2, str3, context);
            return;
        }
        throw new NullPointerException("OverrideUrlLoadingListener can not be null");
    }

    /* renamed from: a */
    private void m23052a(final String str, final String str2, final String str3, final Context context) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            m23051a(str, str2, str3, context, this.f30098j);
        } else {
            this.f30095g.post(new Runnable() { // from class: com.mbridge.msdk.click.g.1
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewSpider webViewSpider = WebViewSpider.this;
                    webViewSpider.m23051a(str, str2, str3, context, webViewSpider.f30098j);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m23051a(String str, String str2, String str3, Context context, String str4) {
        try {
            m23058a(context, str, str2, str3);
            if (!TextUtils.isEmpty(this.f30099k)) {
                this.f30100l.getSettings().setDefaultTextEncodingName("utf-8");
                this.f30094f = 2000;
                this.f30093e = 2000;
                SameLogTool.m21736b(f30090d, this.f30099k);
                this.f30100l.loadDataWithBaseURL(str4, this.f30099k, "*/*", "utf-8", str4);
            } else if (this.f30101m) {
                HashMap hashMap = new HashMap();
                if (this.f30100l.getUrl() != null) {
                    hashMap.put("Referer", this.f30100l.getUrl());
                }
                this.f30100l.loadUrl(str4, hashMap);
            } else {
                this.f30100l.loadUrl(str4);
            }
        } catch (Throwable th) {
            try {
                InterfaceC11230a interfaceC11230a = this.f30097i;
                if (interfaceC11230a != null) {
                    interfaceC11230a.mo23008a(0, this.f30098j, th.getMessage(), this.f30102n);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private void m23058a(final Context context, final String str, final String str2, final String str3) {
        WebView webView = new WebView(context);
        this.f30100l = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f30100l.getSettings().setCacheMode(2);
        this.f30100l.getSettings().setLoadsImagesAutomatically(false);
        this.f30100l.setWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.click.g.2
            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView2, String str4) {
                super.onPageFinished(webView2, str4);
                try {
                    webView2.loadUrl("javascript:window.navigator.vibrate([]);");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView2, String str4, Bitmap bitmap) {
                try {
                    webView2.loadUrl("javascript:window.navigator.vibrate([]);");
                    boolean z = false;
                    if (WebViewSpider.this.f30105q) {
                        WebViewSpider.this.f30103o = 0;
                        WebViewSpider.m23044c(WebViewSpider.this);
                        return;
                    }
                    WebViewSpider.this.f30092c = false;
                    if (webView2.getTag() == null) {
                        webView2.setTag("has_first_started");
                    } else {
                        WebViewSpider.this.f30091b = true;
                    }
                    synchronized (WebViewSpider.f30090d) {
                        String str5 = "加载页面-开始：";
                        WebViewSpider webViewSpider = WebViewSpider.this;
                        if ((webViewSpider.f30091b || webViewSpider.f30092c) ? true : true) {
                            str5 = "加载页面-开始：（重定向）";
                        }
                        if (URLUtil.isHttpsUrl(str4)) {
                            SameLogTool.m21733d(WebViewSpider.f30090d, str5 + str4);
                        } else {
                            SameLogTool.m21736b(WebViewSpider.f30090d, str5 + str4);
                        }
                        WebViewSpider.this.f30098j = str4;
                        if (WebViewSpider.this.f30097i != null && WebViewSpider.this.f30097i.mo23007a(str4)) {
                            WebViewSpider.this.f30105q = true;
                            WebViewSpider.m23044c(WebViewSpider.this);
                        } else {
                            WebViewSpider.m23041e(WebViewSpider.this);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView2, int i, String str4, String str5) {
                String str6 = WebViewSpider.f30090d;
                SameLogTool.m21736b(str6, "onReceivedError: errno = " + i + ", url: " + webView2.getUrl() + ",\n onReceivedError：, description: " + str4 + ", failingUrl: " + str5);
                synchronized (WebViewSpider.f30090d) {
                    WebViewSpider.this.f30105q = true;
                    WebViewSpider.this.m23048b();
                    WebViewSpider.m23044c(WebViewSpider.this);
                }
                if (WebViewSpider.this.f30097i != null) {
                    WebViewSpider.this.f30097i.mo23008a(i, webView2.getUrl(), str4, WebViewSpider.this.f30102n);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) {
                try {
                    String str4 = WebViewSpider.f30090d;
                    SameLogTool.m21738a(str4, "onReceivedSslError IS_SP_CBT_CF:" + MBridgeConstans.IS_SP_CBT_CF);
                    if (MBridgeConstans.IS_SP_CBT_CF && sslErrorHandler != null) {
                        sslErrorHandler.cancel();
                    }
                    if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
                        return;
                    }
                    new ReportController(context).m22094a(str, str2, str3, webView2.getUrl());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, String str4) {
                synchronized (WebViewSpider.f30090d) {
                    String str5 = WebViewSpider.f30090d;
                    SameLogTool.m21738a(str5, "override js跳转：" + str4);
                    WebViewSpider webViewSpider = WebViewSpider.this;
                    webViewSpider.f30092c = true;
                    webViewSpider.m23043d();
                    if (!WebViewSpider.this.f30105q) {
                        WebViewSpider.this.f30098j = str4;
                        if (WebViewSpider.this.f30097i != null && WebViewSpider.this.f30097i.mo23005b(str4)) {
                            WebViewSpider.this.f30105q = true;
                            WebViewSpider.this.m23045c();
                            WebViewSpider.m23044c(WebViewSpider.this);
                            return true;
                        }
                        if (WebViewSpider.this.f30101m) {
                            HashMap hashMap = new HashMap();
                            if (WebViewSpider.this.f30100l.getUrl() != null) {
                                hashMap.put("Referer", WebViewSpider.this.f30100l.getUrl());
                            }
                            WebViewSpider.this.f30100l.loadUrl(str4, hashMap);
                        } else {
                            WebViewSpider.this.f30100l.loadUrl(str4);
                        }
                        return true;
                    }
                    WebViewSpider.this.m23045c();
                    WebViewSpider.m23044c(WebViewSpider.this);
                    return true;
                }
            }
        });
        this.f30100l.setWebChromeClient(new WebChromeClient() { // from class: com.mbridge.msdk.click.g.3
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
            public final void onProgressChanged(WebView webView2, int i) {
                if (i == 100) {
                    try {
                        String str4 = WebViewSpider.f30090d;
                        SameLogTool.m21736b(str4, "加载页面-进度完成：" + webView2.getUrl());
                        webView2.loadUrl("javascript:window.navigator.vibrate([]);");
                        if (!WebViewSpider.this.f30105q) {
                            WebViewSpider webViewSpider = WebViewSpider.this;
                            if (!webViewSpider.f30092c) {
                                WebViewSpider.m23034l(webViewSpider);
                            }
                        }
                        if (WebViewSpider.this.f30097i != null) {
                            WebViewSpider.this.f30097i.mo23004c(webView2.getUrl());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
