package com.beizi.p051ad.internal.activity;

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
import com.beizi.p051ad.AdActivity;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.StringUtil;
import com.beizi.p051ad.internal.utilities.ViewUtil;
import com.beizi.p051ad.internal.view.AdViewImpl;
import com.beizi.p051ad.internal.view.VideoEnabledWebChromeClient;
import com.beizi.p051ad.lance.p062a.LogUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: com.beizi.ad.internal.activity.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BrowserAdActivity implements AdActivity.InterfaceC2741a {

    /* renamed from: a */
    public static LinkedList<WebView> f9980a = new LinkedList<>();

    /* renamed from: b */
    private Activity f9981b;

    /* renamed from: c */
    private WebView f9982c;

    /* renamed from: d */
    private ImageView f9983d;

    /* renamed from: e */
    private boolean f9984e;

    public BrowserAdActivity(Activity activity, boolean z) {
        this.f9981b = activity;
        this.f9984e = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m49660g() {
        Activity activity = this.f9981b;
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    /* renamed from: d */
    public void mo49653d() {
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    /* renamed from: e */
    public void mo49652e() {
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    /* renamed from: f */
    public WebView mo49651f() {
        return this.f9982c;
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    /* renamed from: b */
    public void mo49655b() {
        LogUtil.m49046a("lance", "...........................backPressed...........................");
        if (this.f9982c.canGoBack()) {
            this.f9982c.goBack();
            LogUtil.m49046a("lance", " mWebView.goBack()");
            return;
        }
        m49660g();
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    /* renamed from: c */
    public void mo49654c() {
        WebView webView = this.f9982c;
        if (webView == null) {
            return;
        }
        ViewUtil.removeChildFromParent(webView);
        this.f9982c.destroy();
    }

    @Override // com.beizi.p051ad.AdActivity.InterfaceC2741a
    @SuppressLint({"SetJavaScriptEnabled", "NewApi"})
    @TargetApi(17)
    /* renamed from: a */
    public void mo49656a() {
        this.f9981b.setTheme(C2750R.C2756style.BeiZiTheme);
        this.f9981b.setContentView(C2750R.C2754layout.activity_in_app_browser);
        WebView poll = f9980a.poll();
        this.f9982c = poll;
        if (poll != null && poll.getSettings() != null) {
            if (this.f9982c.getContext() instanceof MutableContextWrapper) {
                ((MutableContextWrapper) this.f9982c.getContext()).setBaseContext(this.f9981b);
            }
            WebView webView = (WebView) this.f9981b.findViewById(C2750R.C2753id.web_view);
            webView.getSettings().setSavePassword(false);
            ViewGroup.LayoutParams layoutParams = webView.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            int indexOfChild = viewGroup.indexOfChild(webView);
            viewGroup.removeView(webView);
            ViewUtil.removeChildFromParent(this.f9982c);
            this.f9982c.setLayoutParams(layoutParams);
            this.f9982c.getSettings().setUseWideViewPort(true);
            this.f9982c.getSettings().setLoadWithOverviewMode(true);
            this.f9982c.getSettings().setJavaScriptEnabled(true);
            int i = Build.VERSION.SDK_INT;
            if (i < 19) {
                this.f9982c.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f9982c.removeJavascriptInterface("accessibility");
                this.f9982c.removeJavascriptInterface("accessibilityTraversal");
            }
            if (i >= 19) {
                WebView.setWebContentsDebuggingEnabled(false);
            }
            viewGroup.addView(this.f9982c, indexOfChild);
            final ProgressBar progressBar = (ProgressBar) this.f9981b.findViewById(C2750R.C2753id.progress_bar);
            try {
                String stringExtra = this.f9981b.getIntent().getStringExtra("bridgeid");
                if (stringExtra != null) {
                    Iterator<Pair<String, AdViewImpl.C2985c>> it = AdViewImpl.C2985c.f10612a.iterator();
                    while (it.hasNext()) {
                        Pair<String, AdViewImpl.C2985c> next = it.next();
                        if (((String) next.first).equals(stringExtra)) {
                            AdViewImpl.C2985c c2985c = (AdViewImpl.C2985c) next.second;
                            AdViewImpl.C2985c.f10612a.remove(next);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f9982c.setDownloadListener(new DownloadListener() { // from class: com.beizi.ad.internal.activity.a.1
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                }
            });
            this.f9982c.setWebViewClient(new WebViewClient() { // from class: com.beizi.ad.internal.activity.a.2
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
                        if (!uri.startsWith(IDataSource.f43971a)) {
                            if (BrowserAdActivity.this.f9984e) {
                                BrowserAdActivity.this.m49663a(uri);
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
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return true;
                    }
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                    HaoboLog.m49286v(HaoboLog.browserLogTag, HaoboLog.getString(C2750R.C2755string.opening_url, str));
                    if (str.startsWith(IDataSource.f43971a)) {
                        return false;
                    }
                    if (BrowserAdActivity.this.f9984e) {
                        BrowserAdActivity.this.m49663a(str);
                        return true;
                    }
                    return true;
                }
            });
            this.f9982c.setWebChromeClient(new VideoEnabledWebChromeClient(this.f9981b) { // from class: com.beizi.ad.internal.activity.a.3
                @Override // com.beizi.p051ad.internal.view.BaseWebChromeClient, android.webkit.WebChromeClient
                public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                    HaoboLog.m49284w(HaoboLog.browserLogTag, HaoboLog.getString(C2750R.C2755string.console_message, consoleMessage.message(), consoleMessage.lineNumber(), consoleMessage.sourceId()));
                    return true;
                }

                @Override // com.beizi.p051ad.internal.view.BaseWebChromeClient, android.webkit.WebChromeClient
                public boolean onJsAlert(WebView webView2, String str, String str2, JsResult jsResult) {
                    HaoboLog.m49284w(HaoboLog.browserLogTag, HaoboLog.getString(C2750R.C2755string.js_alert, str2, str));
                    jsResult.confirm();
                    return true;
                }

                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView2, int i2) {
                    if (i2 < 100 && progressBar.getVisibility() == 8) {
                        progressBar.setVisibility(0);
                    }
                    progressBar.setProgress(i2);
                    if (i2 == 100) {
                        progressBar.setVisibility(8);
                    }
                }

                @Override // com.beizi.p051ad.internal.view.VideoEnabledWebChromeClient, android.webkit.WebChromeClient
                public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                    super.onShowCustomView(view, customViewCallback);
                    if (view instanceof FrameLayout) {
                        FrameLayout frameLayout = (FrameLayout) view;
                        if (frameLayout.getFocusedChild() instanceof VideoView) {
                            VideoView videoView = (VideoView) frameLayout.getFocusedChild();
                            frameLayout.removeView(videoView);
                            ((Activity) BrowserAdActivity.this.f9982c.getContext()).setContentView(videoView);
                            videoView.start();
                        }
                    }
                }
            });
            ImageView imageView = (ImageView) this.f9981b.findViewById(C2750R.C2753id.close_iv);
            this.f9983d = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BrowserAdActivity.this.m49660g();
                }
            });
            return;
        }
        m49660g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49663a(String str) {
        Uri parse = StringUtil.isEmpty(str) ? null : Uri.parse(str);
        if (parse == null) {
            HaoboLog.m49284w(HaoboLog.browserLogTag, HaoboLog.getString(C2750R.C2755string.opening_url_failed, str));
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.setFlags(268435456);
        try {
            this.f9981b.startActivity(intent);
            mo49654c();
            m49660g();
        } catch (Exception unused) {
            HaoboLog.m49284w(HaoboLog.browserLogTag, HaoboLog.getString(C2750R.C2755string.opening_url_failed, str));
        }
    }
}
