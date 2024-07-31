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
import com.mbridge.msdk.foundation.tools.DomainSameSDKTool;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import java.lang.reflect.Method;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BrowserView extends LinearLayout {

    /* renamed from: a */
    private String f31179a;

    /* renamed from: b */
    private ProgressBar f31180b;

    /* renamed from: c */
    private WebView f31181c;

    /* renamed from: d */
    private ToolBar f31182d;

    /* renamed from: e */
    private InterfaceC11444a f31183e;

    /* renamed from: f */
    private CampaignEx f31184f;

    /* renamed from: com.mbridge.msdk.foundation.webview.BrowserView$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11444a {
        /* renamed from: a */
        void mo21707a();

        /* renamed from: a */
        void mo21705a(WebView webView, String str, Bitmap bitmap);

        /* renamed from: a */
        boolean mo21706a(WebView webView, String str);
    }

    public BrowserView(Context context, CampaignEx campaignEx) {
        super(context);
        this.f31184f = campaignEx;
        init();
    }

    public void destroy() {
        WebView webView = this.f31181c;
        if (webView != null) {
            webView.stopLoading();
            this.f31181c.setWebViewClient(null);
            this.f31181c.destroy();
            removeAllViews();
        }
    }

    public void init() {
        setOrientation(1);
        setGravity(17);
        ProgressBar progressBar = new ProgressBar(getContext());
        this.f31180b = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        try {
            if (this.f31181c == null) {
                this.f31181c = m21716a();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.f31181c.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            SameLogTool.m21735b("BrowserView", "webview is error", th);
        }
        this.f31182d = new ToolBar(getContext());
        this.f31182d.setLayoutParams(new LinearLayout.LayoutParams(-1, SameTool.m22001b(getContext(), 40.0f)));
        this.f31182d.setBackgroundColor(-1);
        addView(this.f31180b);
        WebView webView = this.f31181c;
        if (webView != null) {
            addView(webView);
        }
        addView(this.f31182d);
        this.f31180b.initResource(true);
        this.f31182d.getItem("backward").setEnabled(false);
        this.f31182d.getItem("forward").setEnabled(false);
        this.f31182d.setOnItemClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (BrowserView.this.f31181c != null) {
                    BrowserView.this.f31181c.stopLoading();
                }
                String str = (String) view.getTag();
                boolean z = false;
                if (TextUtils.equals(str, "backward")) {
                    BrowserView.this.f31182d.getItem("forward").setEnabled(true);
                    if (BrowserView.this.f31181c != null && BrowserView.this.f31181c.canGoBack()) {
                        BrowserView.this.f31181c.goBack();
                    }
                    View item = BrowserView.this.f31182d.getItem("backward");
                    if (BrowserView.this.f31181c != null && BrowserView.this.f31181c.canGoBack()) {
                        z = true;
                    }
                    item.setEnabled(z);
                } else if (TextUtils.equals(str, "forward")) {
                    BrowserView.this.f31182d.getItem("backward").setEnabled(true);
                    if (BrowserView.this.f31181c != null && BrowserView.this.f31181c.canGoForward()) {
                        BrowserView.this.f31181c.goForward();
                    }
                    View item2 = BrowserView.this.f31182d.getItem("forward");
                    if (BrowserView.this.f31181c != null && BrowserView.this.f31181c.canGoForward()) {
                        z = true;
                    }
                    item2.setEnabled(z);
                } else if (TextUtils.equals(str, "refresh")) {
                    BrowserView.this.f31182d.getItem("backward").setEnabled(BrowserView.this.f31181c != null && BrowserView.this.f31181c.canGoBack());
                    View item3 = BrowserView.this.f31182d.getItem("forward");
                    if (BrowserView.this.f31181c != null && BrowserView.this.f31181c.canGoForward()) {
                        z = true;
                    }
                    item3.setEnabled(z);
                    if (BrowserView.this.f31181c != null) {
                        BrowserView.this.f31181c.loadUrl(BrowserView.this.f31179a);
                    }
                } else if (!TextUtils.equals(str, "exits") || BrowserView.this.f31183e == null) {
                } else {
                    BrowserView.this.f31183e.mo21707a();
                }
            }
        });
    }

    public void loadUrl(String str) {
        WebView webView = this.f31181c;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    public void setListener(InterfaceC11444a interfaceC11444a) {
        this.f31183e = interfaceC11444a;
    }

    public void setWebView(WebView webView) {
        this.f31181c = webView;
    }

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class MBDownloadListener implements DownloadListener {
        private CampaignEx campaignEx;
        private String title;

        public MBDownloadListener(CampaignEx campaignEx) {
            this.campaignEx = campaignEx;
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            DomainSameSDKTool.m21875a(this.title, str, this.campaignEx, true);
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public MBDownloadListener() {
        }
    }

    /* renamed from: a */
    private WebView m21716a() {
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
            } catch (Exception e) {
                SameLogTool.m21733d("BrowserView", e.getMessage());
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
            } catch (Exception e2) {
                SameLogTool.m21733d("BrowserView", e2.getMessage());
            }
        } catch (Throwable th) {
            SameLogTool.m21733d("BrowserView", th.getMessage());
        }
        webView.setDownloadListener(new MBDownloadListener(this.f31184f));
        webView.setWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.2
            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                SameLogTool.m21736b("BrowserView", "开始! = " + str);
                BrowserView.this.f31179a = str;
                if (BrowserView.this.f31183e != null) {
                    BrowserView.this.f31183e.mo21705a(webView2, str, bitmap);
                }
                BrowserView.this.f31180b.setVisible(true);
                BrowserView.this.f31180b.setProgressState(5);
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                SameLogTool.m21736b("BrowserView", "js大跳! = " + str);
                BrowserView.this.f31182d.getItem("backward").setEnabled(true);
                BrowserView.this.f31182d.getItem("forward").setEnabled(false);
                if (BrowserView.this.f31183e != null) {
                    BrowserView.this.f31183e.mo21706a(webView2, str);
                }
                return false;
            }
        });
        if (SameDiTool.m21805D() <= 10) {
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
                public final void onProgressChanged(WebView webView2, int i) {
                    if (i == 100) {
                        BrowserView.this.f31180b.setProgressState(7);
                        new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.3.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                BrowserView.this.f31180b.setVisible(false);
                            }
                        }, 200L);
                    }
                }
            };
        } else {
            webChromeClient = new WebChromeClient() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.4
                @Override // android.webkit.WebChromeClient
                public final void onProgressChanged(WebView webView2, int i) {
                    if (i == 100) {
                        BrowserView.this.f31180b.setProgressState(7);
                        new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.4.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                BrowserView.this.f31180b.setVisible(false);
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
