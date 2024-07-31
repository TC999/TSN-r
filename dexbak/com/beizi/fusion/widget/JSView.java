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
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import com.beizi.fusion.model.TaskBean;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.EventCar;
import com.beizi.fusion.p066d.AdManager;
import com.beizi.fusion.p072g.C3145h;
import com.beizi.fusion.p072g.HttpUtil;
import com.beizi.fusion.p072g.StringUtil;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class JSView extends WebView {

    /* renamed from: a */
    private static String f11613a = "JSView";

    /* renamed from: b */
    private TaskBean.BackTaskArrayBean f11614b;

    /* renamed from: c */
    private int f11615c;

    /* renamed from: d */
    private Context f11616d;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: e */
    private Handler f11617e;

    public JSView(Context context) {
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
        setWebChromeClient(new WebChromeClient() { // from class: com.beizi.fusion.widget.JSView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
            }
        });
        setWebViewClient(new WebViewClient() { // from class: com.beizi.fusion.widget.JSView.3
            @Override // android.webkit.WebViewClient
            @RequiresApi(api = 19)
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                List<String> action = JSView.this.f11614b.getAction();
                if (action != null && action.size() > 0) {
                    for (int i2 = 0; i2 < action.size(); i2++) {
                        if (!TextUtils.isEmpty(action.get(i2))) {
                            String str2 = "javascript:" + action.get(i2) + "()";
                            if (Build.VERSION.SDK_INT < 18) {
                                JSView.this.loadUrl(str2);
                            } else {
                                JSView.this.evaluateJavascript(str2, new ValueCallback<String>() { // from class: com.beizi.fusion.widget.JSView.3.1
                                    @Override // android.webkit.ValueCallback
                                    /* renamed from: a */
                                    public void onReceiveValue(String str3) {
                                    }
                                });
                            }
                        }
                    }
                }
                C3145h.m48264b().m48261e().execute(new Runnable() { // from class: com.beizi.fusion.widget.JSView.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        List<String> report;
                        if (JSView.this.f11614b == null || (report = JSView.this.f11614b.getReport()) == null || report.size() <= 0) {
                            return;
                        }
                        for (int i3 = 0; i3 < report.size(); i3++) {
                            if (!TextUtils.isEmpty(report.get(i3))) {
                                if (HttpUtil.m48508a(StringUtil.m48310a(JSView.this.f11616d, report.get(i3), null), JSView.this.f11614b.getUserAgent()) != null) {
                                    EventCar.m48869a(JSView.this.f11616d).m48862b(new EventBean(AdManager.f11053b, "", "520.200", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                } else {
                                    EventCar.m48869a(JSView.this.f11616d).m48862b(new EventBean(AdManager.f11053b, "", "520.500", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                }
                                try {
                                    Thread.sleep(JSView.this.f11614b.getSleepTime());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                });
                JSView.this.f11617e.sendEmptyMessageDelayed(1, JSView.this.f11614b.getShowTime());
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                JSView.this.m48076a();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                JSView.this.m48076a();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                JSView.this.m48076a();
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
    }

    public void load() {
        TaskBean.BackTaskArrayBean backTaskArrayBean = this.f11614b;
        if (backTaskArrayBean == null || TextUtils.isEmpty(backTaskArrayBean.getContentUrl())) {
            return;
        }
        loadUrl(this.f11614b.getContentUrl());
        this.f11615c--;
    }

    public JSView(Context context, TaskBean.BackTaskArrayBean backTaskArrayBean) {
        this(context, null, 0);
        this.f11616d = context;
        this.f11614b = backTaskArrayBean;
        this.f11615c = backTaskArrayBean.getRepeatCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m48076a() {
        EventCar.m48869a(this.f11616d).m48868a(new EventBean(AdManager.f11053b, "", "510.500", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m48074b() {
        try {
            EventCar.m48869a(this.f11616d).m48868a(new EventBean(AdManager.f11053b, "", "510.200", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            clearCache(true);
            clearHistory();
            clearFormData();
            destroy();
            Handler handler = this.f11617e;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11615c = 1;
        this.f11617e = new Handler() { // from class: com.beizi.fusion.widget.JSView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                if (JSView.this.f11615c <= 0) {
                    JSView.this.m48074b();
                } else {
                    JSView.this.load();
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
