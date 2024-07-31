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
import com.beizi.fusion.model.TaskBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.EventCar;
import com.beizi.fusion.p066d.AdManager;
import com.beizi.fusion.p072g.C3145h;
import com.beizi.fusion.p072g.HttpUtil;
import com.beizi.fusion.p072g.StringUtil;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LandingView extends WebView {

    /* renamed from: a */
    private static String f11623a = "LandingView";

    /* renamed from: b */
    private TaskBean.BackTaskArrayBean f11624b;

    /* renamed from: c */
    private int f11625c;

    /* renamed from: d */
    private Context f11626d;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: e */
    private Handler f11627e;

    public LandingView(Context context) {
        this(context, null);
    }

    public void init() {
        WebSettings settings = getSettings();
        settings.setSavePassword(false);
        int i = Build.VERSION.SDK_INT;
        if (i < 19) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        if (i >= 19) {
            WebView.setWebContentsDebuggingEnabled(false);
        }
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        setWebChromeClient(new WebChromeClient() { // from class: com.beizi.fusion.widget.LandingView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
            }
        });
        setWebViewClient(new WebViewClient() { // from class: com.beizi.fusion.widget.LandingView.3
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                C3145h.m48264b().m48261e().execute(new Runnable() { // from class: com.beizi.fusion.widget.LandingView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        List<String> report;
                        if (LandingView.this.f11624b == null || (report = LandingView.this.f11624b.getReport()) == null || report.size() <= 0) {
                            return;
                        }
                        for (int i2 = 0; i2 < report.size(); i2++) {
                            if (!TextUtils.isEmpty(report.get(i2))) {
                                if (HttpUtil.m48508a(StringUtil.m48310a(LandingView.this.f11626d, report.get(i2), null), LandingView.this.f11624b.getUserAgent()) != null) {
                                    EventCar.m48869a(LandingView.this.f11626d).m48862b(new EventBean(AdManager.f11053b, "", "520.200", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                } else {
                                    EventCar.m48869a(LandingView.this.f11626d).m48862b(new EventBean(AdManager.f11053b, "", "520.500", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                }
                                try {
                                    Thread.sleep(LandingView.this.f11624b.getSleepTime());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                });
                LandingView.this.f11627e.sendEmptyMessageDelayed(1, LandingView.this.f11624b.getShowTime());
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                LandingView.this.m48067a();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                LandingView.this.m48067a();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                LandingView.this.m48067a();
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
    }

    public void load() {
        TaskBean.BackTaskArrayBean backTaskArrayBean = this.f11624b;
        if (backTaskArrayBean == null || TextUtils.isEmpty(backTaskArrayBean.getContentUrl())) {
            return;
        }
        loadUrl(this.f11624b.getContentUrl());
        this.f11625c--;
    }

    public LandingView(Context context, TaskBean.BackTaskArrayBean backTaskArrayBean) {
        this(context, null, 0);
        this.f11626d = context;
        this.f11624b = backTaskArrayBean;
        this.f11625c = backTaskArrayBean.getRepeatCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m48067a() {
        EventCar.m48869a(this.f11626d).m48868a(new EventBean(AdManager.f11053b, "", "510.500", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m48065b() {
        try {
            EventCar.m48869a(this.f11626d).m48868a(new EventBean(AdManager.f11053b, "", "510.200", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            clearCache(true);
            clearHistory();
            clearFormData();
            destroy();
            Handler handler = this.f11627e;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LandingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11625c = 1;
        this.f11627e = new Handler() { // from class: com.beizi.fusion.widget.LandingView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                if (LandingView.this.f11625c <= 0) {
                    LandingView.this.m48065b();
                } else {
                    LandingView.this.load();
                }
            }
        };
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
