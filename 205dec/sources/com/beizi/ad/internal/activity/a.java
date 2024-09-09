package com.beizi.ad.internal.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.VideoView;
import com.beizi.ad.AdActivity;
import com.beizi.ad.R;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.StringUtil;
import com.beizi.ad.internal.utilities.ViewUtil;
import com.beizi.ad.internal.view.AdViewImpl;
import com.beizi.ad.internal.view.h;
import com.beizi.ad.lance.a.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BrowserAdActivity.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a implements AdActivity.a {

    /* renamed from: a  reason: collision with root package name */
    public static LinkedList<WebView> f13657a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    private Activity f13658b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f13659c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f13660d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13661e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13662f;

    public a(Activity activity, boolean z3, boolean z4) {
        this.f13658b = activity;
        this.f13661e = z3;
        this.f13662f = z4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Activity activity = this.f13658b;
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.beizi.ad.AdActivity.a
    public void c() {
        WebView webView = this.f13659c;
        if (webView == null) {
            return;
        }
        ViewUtil.removeChildFromParent(webView);
        this.f13659c.destroy();
    }

    @Override // com.beizi.ad.AdActivity.a
    public void d() {
    }

    @Override // com.beizi.ad.AdActivity.a
    public void e() {
    }

    @Override // com.beizi.ad.AdActivity.a
    public WebView f() {
        return this.f13659c;
    }

    @Override // com.beizi.ad.AdActivity.a
    @SuppressLint({"SetJavaScriptEnabled", "NewApi"})
    @TargetApi(17)
    public void a() {
        this.f13658b.setTheme(R.style.BeiZiTheme);
        this.f13658b.setContentView(R.layout.activity_in_app_browser);
        WebView poll = f13657a.poll();
        this.f13659c = poll;
        if (poll != null && poll.getSettings() != null) {
            if (this.f13659c.getContext() instanceof MutableContextWrapper) {
                ((MutableContextWrapper) this.f13659c.getContext()).setBaseContext(this.f13658b);
            }
            WebView webView = (WebView) this.f13658b.findViewById(R.id.web_view);
            webView.getSettings().setSavePassword(false);
            ViewGroup.LayoutParams layoutParams = webView.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            int indexOfChild = viewGroup.indexOfChild(webView);
            viewGroup.removeView(webView);
            ViewUtil.removeChildFromParent(this.f13659c);
            this.f13659c.setLayoutParams(layoutParams);
            this.f13659c.getSettings().setUseWideViewPort(true);
            this.f13659c.getSettings().setLoadWithOverviewMode(true);
            this.f13659c.getSettings().setJavaScriptEnabled(true);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 < 19) {
                this.f13659c.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f13659c.removeJavascriptInterface("accessibility");
                this.f13659c.removeJavascriptInterface("accessibilityTraversal");
            }
            if (i4 >= 19) {
                WebView.setWebContentsDebuggingEnabled(false);
            }
            viewGroup.addView(this.f13659c, indexOfChild);
            final ProgressBar progressBar = (ProgressBar) this.f13658b.findViewById(R.id.progress_bar);
            try {
                String stringExtra = this.f13658b.getIntent().getStringExtra("bridgeid");
                if (stringExtra != null) {
                    Iterator<Pair<String, AdViewImpl.c>> it = AdViewImpl.c.f14191a.iterator();
                    while (it.hasNext()) {
                        Pair<String, AdViewImpl.c> next = it.next();
                        if (((String) next.first).equals(stringExtra)) {
                            AdViewImpl.c cVar = (AdViewImpl.c) next.second;
                            AdViewImpl.c.f14191a.remove(next);
                        }
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            this.f13659c.setDownloadListener(new DownloadListener() { // from class: com.beizi.ad.internal.activity.a.1
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j4) {
                }
            });
            this.f13659c.setWebViewClient(new WebViewClient() { // from class: com.beizi.ad.internal.activity.a.2
                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView2, String str) {
                    CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
                    if (cookieSyncManager != null) {
                        cookieSyncManager.sync();
                    }
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                    try {
                        Uri url = webResourceRequest.getUrl();
                        if (url == null) {
                            return false;
                        }
                        String uri = url.toString();
                        if (!uri.startsWith("http")) {
                            if (a.this.b(uri)) {
                                a.this.a(uri);
                            }
                            return true;
                        }
                        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
                        if (requestHeaders == null || requestHeaders.size() == 0) {
                            requestHeaders = new HashMap<>();
                        }
                        requestHeaders.put("X-Requested-With", "");
                        webView2.loadUrl(uri, requestHeaders);
                        return true;
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        return true;
                    }
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                    HaoboLog.v(HaoboLog.browserLogTag, HaoboLog.getString(R.string.opening_url, str));
                    if (str.startsWith("http")) {
                        return false;
                    }
                    if (a.this.b(str)) {
                        a.this.a(str);
                        return true;
                    }
                    return true;
                }
            });
            this.f13659c.setWebChromeClient(new h(this.f13658b) { // from class: com.beizi.ad.internal.activity.a.3
                @Override // com.beizi.ad.internal.view.a, android.webkit.WebChromeClient
                public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                    HaoboLog.w(HaoboLog.browserLogTag, HaoboLog.getString(R.string.console_message, consoleMessage.message(), consoleMessage.lineNumber(), consoleMessage.sourceId()));
                    return true;
                }

                @Override // com.beizi.ad.internal.view.a, android.webkit.WebChromeClient
                public boolean onJsAlert(WebView webView2, String str, String str2, JsResult jsResult) {
                    HaoboLog.w(HaoboLog.browserLogTag, HaoboLog.getString(R.string.js_alert, str2, str));
                    jsResult.confirm();
                    return true;
                }

                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView2, int i5) {
                    if (i5 < 100 && progressBar.getVisibility() == 8) {
                        progressBar.setVisibility(0);
                    }
                    progressBar.setProgress(i5);
                    if (i5 == 100) {
                        progressBar.setVisibility(8);
                    }
                }

                @Override // com.beizi.ad.internal.view.h, android.webkit.WebChromeClient
                public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                    super.onShowCustomView(view, customViewCallback);
                    if (view instanceof FrameLayout) {
                        FrameLayout frameLayout = (FrameLayout) view;
                        if (frameLayout.getFocusedChild() instanceof VideoView) {
                            VideoView videoView = (VideoView) frameLayout.getFocusedChild();
                            frameLayout.removeView(videoView);
                            ((Activity) a.this.f13659c.getContext()).setContentView(videoView);
                            videoView.start();
                        }
                    }
                }
            });
            ImageView imageView = (ImageView) this.f13658b.findViewById(R.id.close_iv);
            this.f13660d = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.g();
                }
            });
            return;
        }
        g();
    }

    @Override // com.beizi.ad.AdActivity.a
    public void b() {
        l.a("lance", "...........................backPressed...........................");
        if (this.f13659c.canGoBack()) {
            this.f13659c.goBack();
            l.a("lance", " mWebView.goBack()");
            return;
        }
        g();
    }

    private boolean c(String str) {
        List<String> o4 = com.beizi.ad.internal.h.a().o();
        if (o4 != null && o4.size() > 0) {
            for (String str2 : o4) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        if (c(str)) {
            return this.f13661e && this.f13662f;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Uri parse = StringUtil.isEmpty(str) ? null : Uri.parse(str);
        if (parse == null) {
            HaoboLog.w(HaoboLog.browserLogTag, HaoboLog.getString(R.string.opening_url_failed, str));
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.setFlags(268435456);
        try {
            this.f13658b.startActivity(intent);
            c();
            g();
        } catch (Exception unused) {
            HaoboLog.w(HaoboLog.browserLogTag, HaoboLog.getString(R.string.opening_url_failed, str));
        }
    }
}
