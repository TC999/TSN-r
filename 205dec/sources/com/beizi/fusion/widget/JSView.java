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
public class JSView extends WebView {

    /* renamed from: a  reason: collision with root package name */
    private static String f15199a = "JSView";

    /* renamed from: b  reason: collision with root package name */
    private TaskBean.BackTaskArrayBean f15200b;

    /* renamed from: c  reason: collision with root package name */
    private int f15201c;

    /* renamed from: d  reason: collision with root package name */
    private Context f15202d;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: e  reason: collision with root package name */
    private Handler f15203e;

    public JSView(Context context) {
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
        setWebChromeClient(new WebChromeClient() { // from class: com.beizi.fusion.widget.JSView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i5) {
            }
        });
        setWebViewClient(new WebViewClient() { // from class: com.beizi.fusion.widget.JSView.3
            @Override // android.webkit.WebViewClient
            @RequiresApi(api = 19)
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                List<String> action = JSView.this.f15200b.getAction();
                if (action != null && action.size() > 0) {
                    for (int i5 = 0; i5 < action.size(); i5++) {
                        if (!TextUtils.isEmpty(action.get(i5))) {
                            String str2 = "javascript:" + action.get(i5) + "()";
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
                h.b().e().execute(new Runnable() { // from class: com.beizi.fusion.widget.JSView.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        List<String> report;
                        if (JSView.this.f15200b == null || (report = JSView.this.f15200b.getReport()) == null || report.size() <= 0) {
                            return;
                        }
                        for (int i6 = 0; i6 < report.size(); i6++) {
                            if (!TextUtils.isEmpty(report.get(i6))) {
                                if (ab.a(av.a(JSView.this.f15202d, report.get(i6), null), JSView.this.f15200b.getUserAgent()) != null) {
                                    c.a(JSView.this.f15202d).b(new b(com.beizi.fusion.d.b.f14592b, "", "520.200", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                } else {
                                    c.a(JSView.this.f15202d).b(new b(com.beizi.fusion.d.b.f14592b, "", "520.500", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                }
                                try {
                                    Thread.sleep(JSView.this.f15200b.getSleepTime());
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                    }
                });
                JSView.this.f15203e.sendEmptyMessageDelayed(1, JSView.this.f15200b.getShowTime());
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                JSView.this.a();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                JSView.this.a();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                JSView.this.a();
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }
        });
    }

    public void load() {
        TaskBean.BackTaskArrayBean backTaskArrayBean = this.f15200b;
        if (backTaskArrayBean == null || TextUtils.isEmpty(backTaskArrayBean.getContentUrl())) {
            return;
        }
        loadUrl(this.f15200b.getContentUrl());
        this.f15201c--;
    }

    public JSView(Context context, TaskBean.BackTaskArrayBean backTaskArrayBean) {
        this(context, null, 0);
        this.f15202d = context;
        this.f15200b = backTaskArrayBean;
        this.f15201c = backTaskArrayBean.getRepeatCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        c.a(this.f15202d).a(new b(com.beizi.fusion.d.b.f14592b, "", "510.500", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            c.a(this.f15202d).a(new b(com.beizi.fusion.d.b.f14592b, "", "510.200", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            clearCache(true);
            clearHistory();
            clearFormData();
            destroy();
            Handler handler = this.f15203e;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public JSView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f15201c = 1;
        this.f15203e = new Handler() { // from class: com.beizi.fusion.widget.JSView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                if (JSView.this.f15201c <= 0) {
                    JSView.this.b();
                } else {
                    JSView.this.load();
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
