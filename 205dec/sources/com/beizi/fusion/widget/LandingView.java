package com.beizi.fusion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.beizi.fusion.b.b;
import com.beizi.fusion.b.c;
import com.beizi.fusion.g.ab;
import com.beizi.fusion.g.av;
import com.beizi.fusion.g.h;
import com.beizi.fusion.model.TaskBean;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LandingView extends WebView {

    /* renamed from: a  reason: collision with root package name */
    private static String f15209a = "LandingView";

    /* renamed from: b  reason: collision with root package name */
    private TaskBean.BackTaskArrayBean f15210b;

    /* renamed from: c  reason: collision with root package name */
    private int f15211c;

    /* renamed from: d  reason: collision with root package name */
    private Context f15212d;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: e  reason: collision with root package name */
    private Handler f15213e;

    public LandingView(Context context) {
        this(context, null);
    }

    public void init() {
        WebSettings settings = getSettings();
        settings.setSavePassword(false);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 19) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        if (i4 >= 19) {
            WebView.setWebContentsDebuggingEnabled(false);
        }
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        setWebChromeClient(new WebChromeClient() { // from class: com.beizi.fusion.widget.LandingView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i5) {
            }
        });
        setWebViewClient(new WebViewClient() { // from class: com.beizi.fusion.widget.LandingView.3
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                h.b().e().execute(new Runnable() { // from class: com.beizi.fusion.widget.LandingView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        List<String> report;
                        if (LandingView.this.f15210b == null || (report = LandingView.this.f15210b.getReport()) == null || report.size() <= 0) {
                            return;
                        }
                        for (int i5 = 0; i5 < report.size(); i5++) {
                            if (!TextUtils.isEmpty(report.get(i5))) {
                                if (ab.a(av.a(LandingView.this.f15212d, report.get(i5), null), LandingView.this.f15210b.getUserAgent()) != null) {
                                    c.a(LandingView.this.f15212d).b(new b(com.beizi.fusion.d.b.f14592b, "", "520.200", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                } else {
                                    c.a(LandingView.this.f15212d).b(new b(com.beizi.fusion.d.b.f14592b, "", "520.500", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                }
                                try {
                                    Thread.sleep(LandingView.this.f15210b.getSleepTime());
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                    }
                });
                LandingView.this.f15213e.sendEmptyMessageDelayed(1, LandingView.this.f15210b.getShowTime());
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                LandingView.this.a();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                LandingView.this.a();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                LandingView.this.a();
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
    }

    public void load() {
        TaskBean.BackTaskArrayBean backTaskArrayBean = this.f15210b;
        if (backTaskArrayBean == null || TextUtils.isEmpty(backTaskArrayBean.getContentUrl())) {
            return;
        }
        loadUrl(this.f15210b.getContentUrl());
        this.f15211c--;
    }

    public LandingView(Context context, TaskBean.BackTaskArrayBean backTaskArrayBean) {
        this(context, null, 0);
        this.f15212d = context;
        this.f15210b = backTaskArrayBean;
        this.f15211c = backTaskArrayBean.getRepeatCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        c.a(this.f15212d).a(new b(com.beizi.fusion.d.b.f14592b, "", "510.500", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            c.a(this.f15212d).a(new b(com.beizi.fusion.d.b.f14592b, "", "510.200", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            clearCache(true);
            clearHistory();
            clearFormData();
            destroy();
            Handler handler = this.f15213e;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public LandingView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f15211c = 1;
        this.f15213e = new Handler() { // from class: com.beizi.fusion.widget.LandingView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                if (LandingView.this.f15211c <= 0) {
                    LandingView.this.b();
                } else {
                    LandingView.this.load();
                }
            }
        };
        try {
            init();
        } catch (Exception e4) {
            e4.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
