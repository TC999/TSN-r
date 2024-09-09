package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.g;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class BrowserView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private String f39952a;

    /* renamed from: b  reason: collision with root package name */
    private ProgressBar f39953b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f39954c;

    /* renamed from: d  reason: collision with root package name */
    private ToolBar f39955d;

    /* renamed from: e  reason: collision with root package name */
    private a f39956e;

    /* renamed from: f  reason: collision with root package name */
    private CampaignEx f39957f;

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void a();

        void a(WebView webView, String str, Bitmap bitmap);

        boolean a(WebView webView, String str);
    }

    public BrowserView(Context context, CampaignEx campaignEx) {
        super(context);
        this.f39957f = campaignEx;
        init();
    }

    public void destroy() {
        WebView webView = this.f39954c;
        if (webView != null) {
            webView.stopLoading();
            this.f39954c.setWebViewClient(null);
            this.f39954c.destroy();
            removeAllViews();
        }
    }

    public void init() {
        setOrientation(1);
        setGravity(17);
        ProgressBar progressBar = new ProgressBar(getContext());
        this.f39953b = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        try {
            if (this.f39954c == null) {
                this.f39954c = a();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.f39954c.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            x.b("BrowserView", "webview is error", th);
        }
        this.f39955d = new ToolBar(getContext());
        this.f39955d.setLayoutParams(new LinearLayout.LayoutParams(-1, ac.b(getContext(), 40.0f)));
        this.f39955d.setBackgroundColor(-1);
        addView(this.f39953b);
        WebView webView = this.f39954c;
        if (webView != null) {
            addView(webView);
        }
        addView(this.f39955d);
        this.f39953b.initResource(true);
        this.f39955d.getItem("backward").setEnabled(false);
        this.f39955d.getItem("forward").setEnabled(false);
        this.f39955d.setOnItemClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (BrowserView.this.f39954c != null) {
                    BrowserView.this.f39954c.stopLoading();
                }
                String str = (String) view.getTag();
                boolean z3 = false;
                if (TextUtils.equals(str, "backward")) {
                    BrowserView.this.f39955d.getItem("forward").setEnabled(true);
                    if (BrowserView.this.f39954c != null && BrowserView.this.f39954c.canGoBack()) {
                        BrowserView.this.f39954c.goBack();
                    }
                    View item = BrowserView.this.f39955d.getItem("backward");
                    if (BrowserView.this.f39954c != null && BrowserView.this.f39954c.canGoBack()) {
                        z3 = true;
                    }
                    item.setEnabled(z3);
                } else if (TextUtils.equals(str, "forward")) {
                    BrowserView.this.f39955d.getItem("backward").setEnabled(true);
                    if (BrowserView.this.f39954c != null && BrowserView.this.f39954c.canGoForward()) {
                        BrowserView.this.f39954c.goForward();
                    }
                    View item2 = BrowserView.this.f39955d.getItem("forward");
                    if (BrowserView.this.f39954c != null && BrowserView.this.f39954c.canGoForward()) {
                        z3 = true;
                    }
                    item2.setEnabled(z3);
                } else if (TextUtils.equals(str, "refresh")) {
                    BrowserView.this.f39955d.getItem("backward").setEnabled(BrowserView.this.f39954c != null && BrowserView.this.f39954c.canGoBack());
                    View item3 = BrowserView.this.f39955d.getItem("forward");
                    if (BrowserView.this.f39954c != null && BrowserView.this.f39954c.canGoForward()) {
                        z3 = true;
                    }
                    item3.setEnabled(z3);
                    if (BrowserView.this.f39954c != null) {
                        BrowserView.this.f39954c.loadUrl(BrowserView.this.f39952a);
                    }
                } else if (!TextUtils.equals(str, "exits") || BrowserView.this.f39956e == null) {
                } else {
                    BrowserView.this.f39956e.a();
                }
            }
        });
    }

    public void loadUrl(String str) {
        WebView webView = this.f39954c;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    public void setListener(a aVar) {
        this.f39956e = aVar;
    }

    public void setWebView(WebView webView) {
        this.f39954c = webView;
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class MBDownloadListener implements DownloadListener {
        private CampaignEx campaignEx;
        private String title;

        public MBDownloadListener(CampaignEx campaignEx) {
            this.campaignEx = campaignEx;
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j4) {
            g.a(this.title, str, this.campaignEx, true);
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public MBDownloadListener() {
        }
    }

    private WebView a() {
        WebChromeClient webChromeClient;
        WebView webView = new WebView(getContext());
        try {
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAppCacheMaxSize(5242880L);
            settings.setAllowFileAccess(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            if (Build.VERSION.SDK_INT >= 26) {
                settings.setSafeBrowsingEnabled(false);
            }
            settings.setMediaPlaybackRequiresUserGesture(false);
            settings.setAllowUniversalAccessFromFileURLs(true);
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    settings.setMixedContentMode(0);
                }
            } catch (Exception e4) {
                x.d("BrowserView", e4.getMessage());
            }
            settings.setDatabaseEnabled(true);
            String path = getContext().getDir("database", 0).getPath();
            settings.setDatabasePath(path);
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(path);
            try {
                Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(settings, Boolean.FALSE);
            } catch (Exception e5) {
                x.d("BrowserView", e5.getMessage());
            }
        } catch (Throwable th) {
            x.d("BrowserView", th.getMessage());
        }
        webView.setDownloadListener(new MBDownloadListener(this.f39957f));
        webView.setWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.2
            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                x.b("BrowserView", "\u5f00\u59cb! = " + str);
                BrowserView.this.f39952a = str;
                if (BrowserView.this.f39956e != null) {
                    BrowserView.this.f39956e.a(webView2, str, bitmap);
                }
                BrowserView.this.f39953b.setVisible(true);
                BrowserView.this.f39953b.setProgressState(5);
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                x.b("BrowserView", "js\u5927\u8df3! = " + str);
                BrowserView.this.f39955d.getItem("backward").setEnabled(true);
                BrowserView.this.f39955d.getItem("forward").setEnabled(false);
                if (BrowserView.this.f39956e != null) {
                    BrowserView.this.f39956e.a(webView2, str);
                }
                return false;
            }
        });
        if (t.D() <= 10) {
            webChromeClient = new WebChromeClient() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.3
                @Override // android.webkit.WebChromeClient
                public final boolean onJsAlert(WebView webView2, String str, String str2, JsResult jsResult) {
                    return true;
                }

                @Override // android.webkit.WebChromeClient
                public final boolean onJsConfirm(WebView webView2, String str, String str2, JsResult jsResult) {
                    return true;
                }

                @Override // android.webkit.WebChromeClient
                public final boolean onJsPrompt(WebView webView2, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                    return true;
                }

                @Override // android.webkit.WebChromeClient
                public final void onProgressChanged(WebView webView2, int i4) {
                    if (i4 == 100) {
                        BrowserView.this.f39953b.setProgressState(7);
                        new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.3.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                BrowserView.this.f39953b.setVisible(false);
                            }
                        }, 200L);
                    }
                }
            };
        } else {
            webChromeClient = new WebChromeClient() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.4
                @Override // android.webkit.WebChromeClient
                public final void onProgressChanged(WebView webView2, int i4) {
                    if (i4 == 100) {
                        BrowserView.this.f39953b.setProgressState(7);
                        new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.4.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                BrowserView.this.f39953b.setVisible(false);
                            }
                        }, 200L);
                    }
                }
            };
        }
        webView.setWebChromeClient(webChromeClient);
        return webView;
    }

    public BrowserView(Context context) {
        super(context);
        init();
    }

    public BrowserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
