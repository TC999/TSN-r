package com.bytedance.sdk.openadsdk.core.widget.c;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.adexpress.ux.ux;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a.f;
import com.bytedance.sdk.openadsdk.core.eq.fz;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.y;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.nativeexpress.r;
import com.bytedance.sdk.openadsdk.core.p.xv.ev;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.n;
import com.bytedance.sdk.openadsdk.core.xk;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends WebViewClient implements SSWebView.xv {

    /* renamed from: k  reason: collision with root package name */
    private static final HashSet<String> f35397k;

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.k.xv f35398c;
    protected final String sr;
    protected com.bytedance.sdk.openadsdk.core.a.sr ux;

    /* renamed from: w  reason: collision with root package name */
    protected final xk f35402w;
    protected final Context xv;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f35399f = true;

    /* renamed from: r  reason: collision with root package name */
    protected boolean f35401r = true;
    private AtomicBoolean gd = new AtomicBoolean(false);
    protected volatile AtomicInteger ev = new AtomicInteger(0);

    /* renamed from: p  reason: collision with root package name */
    private long f35400p = System.currentTimeMillis();

    static {
        HashSet<String> hashSet = new HashSet<>();
        f35397k = hashSet;
        hashSet.add("png");
        hashSet.add("ico");
        hashSet.add("jpg");
        hashSet.add("gif");
        hashSet.add("svg");
        hashSet.add("jpeg");
    }

    public sr(Context context, xk xkVar, String str) {
        this.xv = context;
        this.f35402w = xkVar;
        this.sr = str;
    }

    private static String w(String str) {
        int lastIndexOf;
        String substring;
        if (str == null || (lastIndexOf = str.lastIndexOf(46)) < 0 || lastIndexOf == str.length() - 1 || (substring = str.substring(lastIndexOf)) == null || !f35397k.contains(substring.toLowerCase(Locale.getDefault()))) {
            return null;
        }
        return "image/" + substring;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(WebView webView, WebResourceRequest webResourceRequest) {
        return n.c(webView, this.ev, this.f35402w, webResourceRequest, false, w()) && !(this instanceof r);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (a.c()) {
            a.c("WebChromeClient", "onPageFinished " + str);
        }
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.ux;
        if (srVar != null) {
            srVar.c(webView, str);
        }
        if (webView != null && this.f35399f) {
            try {
                String c4 = w.c(ls.w().ck(), this.sr);
                if (!TextUtils.isEmpty(c4)) {
                    k.c(webView, c4);
                }
            } catch (Throwable unused) {
            }
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.ux;
        if (srVar != null) {
            srVar.c(webView, str, bitmap);
        }
        if (this.f35401r) {
            w.c(this.xv).c(Build.VERSION.SDK_INT >= 19).c(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i4, String str, String str2) {
        super.onReceivedError(webView, i4, str, str2);
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.ux;
        if (srVar != null) {
            srVar.c(i4, str, str2, w(str2));
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.ux == null || webResourceResponse == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String uri = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey("Accept")) {
            str = requestHeaders.get("Accept");
        } else if (requestHeaders.containsKey("accept")) {
            str = requestHeaders.get("accept");
        }
        this.ux.c(webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), uri, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable unused) {
            }
        }
        if (this.ux != null) {
            int i4 = 0;
            String str = "SslError: unknown";
            String str2 = null;
            if (sslError != null) {
                try {
                    i4 = sslError.getPrimaryError();
                    str = "SslError: " + String.valueOf(sslError);
                    str2 = sslError.getUrl();
                } catch (Throwable unused2) {
                }
            }
            this.ux.c(i4, str, str2, w(str2));
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        if (!renderProcessGoneDetail.didCrash()) {
            a.f("WebChromeClient", "System killed the WebView rendering process to reclaim memory. Recreating...");
            if (webView != null) {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                webView.destroy();
                ux.c().w();
            }
            return true;
        }
        a.f("WebChromeClient", "The WebView rendering process crashed!");
        if (webView != null) {
            ViewGroup viewGroup2 = (ViewGroup) webView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(webView);
            }
            webView.destroy();
            ux.c().w();
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.ux;
        if (srVar != null) {
            srVar.c(webView, webResourceRequest);
        }
        WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
        if (this.f35398c != null) {
            a.w("WebChromeClient", "shouldInterceptRequest");
            shouldInterceptRequest = this.f35398c.c(webView, webResourceRequest, shouldInterceptRequest);
        }
        return c(webView, webResourceRequest) ? new WebResourceResponse("", "", null) : shouldInterceptRequest;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        xk xkVar;
        a.w("WebChromeClient", "shouldOverrideUrlLoading " + str);
        c(str);
        try {
        } catch (Exception e4) {
            a.w("WebChromeClient", "shouldOverrideUrlLoading", e4);
            xk xkVar2 = this.f35402w;
            if (xkVar2 != null && xkVar2.r()) {
                return true;
            }
        }
        if (c(webView, str)) {
            return true;
        }
        com.bytedance.sdk.openadsdk.k.xv xvVar = this.f35398c;
        if (xvVar != null) {
            xvVar.c(webView, str);
        }
        Uri parse = Uri.parse(str);
        String lowerCase = parse.getScheme().toLowerCase();
        if ("bytedance".equals(lowerCase)) {
            fz.c(parse, this.f35402w);
            return true;
        }
        if (com.bytedance.sdk.openadsdk.core.k.sr().u() != null) {
            boolean z3 = false;
            if (((Boolean) com.bytedance.sdk.openadsdk.core.k.sr().u().call(15, b.a().h(0, new y().c("uri", parse)).l(), Boolean.class)).booleanValue()) {
                xk xkVar3 = this.f35402w;
                if (xkVar3 != null && xkVar3.f() != null) {
                    me f4 = this.f35402w.f();
                    f4.ls(str);
                    com.bytedance.sdk.openadsdk.core.p.w.sr w3 = com.bytedance.sdk.openadsdk.core.p.xv.w(this.xv, f4, this.f35402w.ck());
                    if (w3 instanceof ev) {
                        ((ev) w3).w(true);
                    }
                    w3.w(me.ux(f4));
                    z3 = true;
                }
                com.bytedance.sdk.openadsdk.core.xv.c().c("is_landing_page_open_market", true);
                if (z3) {
                    return true;
                }
            }
        }
        if (!ys.c(str) && (xkVar = this.f35402w) != null && xkVar.f() != null) {
            final String ck = this.f35402w.ck();
            final me f5 = this.f35402w.f();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            com.bytedance.sdk.openadsdk.core.a.xv.w(f5, ck, "lp_open_dpl", lowerCase);
            if (wv.f(this.xv)) {
                if (wv.c(this.xv, intent)) {
                    com.bytedance.sdk.component.utils.w.c(this.xv, intent, new w.c() { // from class: com.bytedance.sdk.openadsdk.core.widget.c.sr.1
                        @Override // com.bytedance.sdk.component.utils.w.c
                        public void c() {
                            com.bytedance.sdk.openadsdk.core.a.xv.xv(f5, ck, "lp_openurl");
                            com.bytedance.sdk.openadsdk.core.a.xv.xv(f5, ck, "lp_deeplink_success_realtime");
                        }

                        @Override // com.bytedance.sdk.component.utils.w.c
                        public void c(Throwable th) {
                            com.bytedance.sdk.openadsdk.core.a.xv.xv(f5, ck, "lp_openurl_failed");
                            com.bytedance.sdk.openadsdk.core.a.xv.xv(f5, ck, "lp_deeplink_fail_realtime");
                        }
                    });
                    f.c().c(f5, ck, true);
                } else {
                    com.bytedance.sdk.openadsdk.core.a.xv.xv(f5, ck, "lp_openurl_failed");
                    com.bytedance.sdk.openadsdk.core.a.xv.xv(f5, ck, "lp_deeplink_fail_realtime");
                }
            } else {
                c(this.xv, intent);
                com.bytedance.sdk.openadsdk.core.a.xv.xv(f5, ck, "lp_openurl");
                com.bytedance.sdk.openadsdk.core.a.xv.xv(f5, ck, "lp_deeplink_success_realtime");
                f.c().c(f5, ck, true);
            }
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public void xv() {
        this.f35400p = System.currentTimeMillis();
    }

    public boolean c(WebView webView, String str) {
        return n.c(webView, this.ev, this.f35402w, str, false, w()) && !(this instanceof r);
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z3 = false;
        if (((str.contains("weixin://wap/pay") || str.contains("weixin://dl/business/?ticket")) || str.contains("alipays://platformapi/startapp?appId")) ? true : true) {
            com.bytedance.sdk.openadsdk.core.a.xv.w(this.f35402w.f(), "landingpage", "lp_pay");
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.ux == null || webResourceError == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String uri = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey("Accept")) {
            str = requestHeaders.get("Accept");
        } else if (requestHeaders.containsKey("accept")) {
            str = requestHeaders.get("accept");
        }
        this.ux.c(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), uri, str);
    }

    private void c(Context context, Intent intent) {
        if (intent != null) {
            try {
                ComponentName resolveActivity = intent.resolveActivity(context.getPackageManager());
                if ((resolveActivity == null || !resolveActivity.getPackageName().equals(context.getPackageName())) && (intent.getFlags() & MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO) == 0) {
                    com.bytedance.sdk.component.utils.w.c(context, intent, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean w() {
        return System.currentTimeMillis() - this.f35400p < 1000;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (c(webView, str)) {
            return new WebResourceResponse("", "", null);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public sr(Context context, xk xkVar, String str, com.bytedance.sdk.openadsdk.core.a.sr srVar) {
        this.xv = context;
        this.f35402w = xkVar;
        this.sr = str;
        this.ux = srVar;
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView.xv
    public void c(boolean z3) {
        xk xkVar = this.f35402w;
        if (xkVar != null) {
            xkVar.xv(z3);
        }
    }

    public sr(Context context, xk xkVar, String str, com.bytedance.sdk.openadsdk.core.a.sr srVar, com.bytedance.sdk.openadsdk.k.xv xvVar) {
        this.xv = context;
        this.f35402w = xkVar;
        this.sr = str;
        this.ux = srVar;
        this.f35398c = xvVar;
    }
}
