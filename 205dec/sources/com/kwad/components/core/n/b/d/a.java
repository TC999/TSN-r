package com.kwad.components.core.n.b.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.webview.BaseKsWebView;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bt;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends BaseKsWebView {
    private KsAdWebView NP;
    private boolean enableScroll;

    /* renamed from: com.kwad.components.core.n.b.d.a$3  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    final class AnonymousClass3 implements KsAdWebView.e {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageFinished() {
            if (a.k(a.this) != null) {
                a.l(a.this).onPageFinished();
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageStart() {
            if (a.this.mWebLoadListener != null) {
                a.this.mWebLoadListener.onPageStart();
            }
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onReceivedHttpError(int i4, String str, String str2) {
            if (a.this.mWebLoadListener != null) {
                a.this.mWebLoadListener.onReceivedHttpError(i4, str, str2);
            }
        }
    }

    public a(@NonNull Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        setBackgroundColor(0);
        this.NP = new KsAdWebView(context);
        this.NP.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.NP.setBackgroundColor(0);
        this.NP.setClientConfig(this.NP.getClientConfig().b(new KsAdWebView.d() { // from class: com.kwad.components.core.n.b.d.a.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onPageStart();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i4, String str, String str2) {
                if (a.this.mWebLoadListener != null) {
                    a.this.mWebLoadListener.onReceivedHttpError(i4, str, str2);
                }
            }
        }).a(new KsAdWebView.b() { // from class: com.kwad.components.core.n.b.d.a.1
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (a.this.mDeeplinkListener != null) {
                    a.this.mDeeplinkListener.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (a.this.mDeeplinkListener != null) {
                    a.this.mDeeplinkListener.onSuccess();
                }
            }
        }));
        addView(this.NP);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public final void addJavascriptInterface(Object obj, String str) {
        this.NP.addJavascriptInterface(obj, str);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void callJs(String str) {
        bt.a(this.NP, str, (String) null);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final boolean canGoBack() {
        return this.NP.canGoBack();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final boolean canGoForward() {
        return this.NP.canGoForward();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void destroy() {
        this.NP.destroy();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void goBack() {
        this.NP.goBack();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void goForward() {
        this.NP.goForward();
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void loadUrl(String str) {
        this.NP.loadUrl(str);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView, android.view.View
    public final void scrollBy(int i4, int i5) {
        if (this.enableScroll) {
            this.NP.scrollBy(i4, i5);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView, android.view.View
    public final void scrollTo(int i4, int i5) {
        if (this.enableScroll) {
            this.NP.scrollTo(i4, i5);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAcceptThirdPartyCookies(boolean z3) {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.NP, z3);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAdCacheId(int i4, String str) {
        AdTemplate a4 = c.a(com.kwad.components.core.n.a.d.a.a.at(i4), str);
        if (a4 != null) {
            this.NP.getClientConfig().ei(a4);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAdTemplateString(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(jSONObject);
            this.NP.getClientConfig().ei(adTemplate);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowContentAccess(boolean z3) {
        this.NP.getSettings().setAllowContentAccess(z3);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowFileAccess(boolean z3) {
        this.NP.getSettings().setAllowFileAccess(z3);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowFileAccessFromFileURLs(boolean z3) {
        this.NP.getSettings().setAllowFileAccessFromFileURLs(z3);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setAllowUniversalAccessFromFileURLs(boolean z3) {
        this.NP.getSettings().setAllowUniversalAccessFromFileURLs(z3);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setCacheMode(int i4) {
        this.NP.getSettings().setCacheMode(i4);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setContextUniqId(int i4) {
        AdTemplate n4 = c.n(com.kwad.components.core.n.a.d.a.a.at(i4));
        if (n4 != null) {
            this.NP.getClientConfig().ei(n4);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setDebugEnabled(boolean z3) {
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(z3);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setDeeplinkEnabled(boolean z3) {
        this.NP.getClientConfig().bu(z3);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setEnableScroll(boolean z3) {
        this.enableScroll = z3;
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setEnableWebCache(boolean z3) {
        this.NP.setNeedHybridLoad(z3);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setInnerDownloadEnabled(boolean z3) {
        this.NP.getClientConfig().bv(z3);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setJavaScriptEnabled(boolean z3) {
        this.NP.getSettings().setJavaScriptEnabled(z3);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setMixedContentMode(int i4) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.NP.getSettings().setMixedContentMode(i4);
        }
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setSavePassword(boolean z3) {
        this.NP.getSettings().setSavePassword(z3);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void setTextZoom(int i4) {
        this.NP.getSettings().setTextZoom(i4);
    }

    @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView
    public final void callJs(String str, String str2) {
        bt.a(this.NP, str, str2);
    }
}
