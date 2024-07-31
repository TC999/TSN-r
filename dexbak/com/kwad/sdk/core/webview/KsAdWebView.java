package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.p417a.C10601a;
import com.kwad.sdk.core.webview.p417a.C10602b;
import com.kwad.sdk.core.webview.p417a.C10603c;
import com.kwad.sdk.core.webview.p418b.p421c.C10621b;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10963a;
import com.kwad.sdk.utils.C11067bq;
import com.kwad.sdk.utils.C11070bs;
import com.kwad.sdk.utils.C11102k;
import com.kwad.sdk.utils.C11124s;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsAdWebView extends C10624c {
    @NonNull

    /* renamed from: HF */
    private C10603c.C10604a f29616HF;
    private C10603c aDQ;
    private String aDR;
    private long aDS;
    @Nullable
    private C10632d aDT;
    private String mUniqueId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.webview.KsAdWebView$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class C10596a implements DownloadListener {
        private C10596a() {
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            boolean m23850o = C11067bq.m23850o(KsAdWebView.this, 100);
            C10331c.m26254d("KsAdWebView", "onDownloadStart: currentVisible " + m23850o);
            if (m23850o && KsAdWebView.this.f29616HF.m25342GU()) {
                if (KsAdWebView.this.f29616HF != null && KsAdWebView.this.f29616HF.getAdTemplate() != null && KsAdWebView.this.f29616HF.m25344GS()) {
                    C10487e.m25641dQ(KsAdWebView.this.f29616HF.getAdTemplate()).adConversionInfo.appDownloadUrl = str;
                    KsAdWebView.this.f29616HF.getAdTemplate().isWebViewDownload = true;
                    C10603c.C10604a readyClientConfig = KsAdWebView.this.getReadyClientConfig();
                    if (readyClientConfig != null) {
                        readyClientConfig.m25331ei(KsAdWebView.this.f29616HF.getAdTemplate());
                    }
                    ((InterfaceC10963a) ServiceProvider.get(InterfaceC10963a.class)).mo24354g(C10887l.wrapContextIfNeed(KsAdWebView.this.getContext()), KsAdWebView.this.f29616HF.getAdTemplate());
                    return;
                }
                try {
                    KsAdWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception e) {
                    C10331c.printStackTrace(e);
                }
            }
        }

        /* synthetic */ C10596a(KsAdWebView ksAdWebView, byte b) {
            this();
        }
    }

    /* renamed from: com.kwad.sdk.core.webview.KsAdWebView$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10597b {
        void onFailed();

        void onSuccess();
    }

    /* renamed from: com.kwad.sdk.core.webview.KsAdWebView$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10598c {
        /* renamed from: pC */
        void mo25352pC();
    }

    /* renamed from: com.kwad.sdk.core.webview.KsAdWebView$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10599d {
        void onPageFinished();

        void onPageStart();

        void onReceivedHttpError(int i, String str, String str2);
    }

    public KsAdWebView(Context context) {
        super(context);
        init(context);
    }

    /* renamed from: GO */
    private String m25356GO() {
        return "KSADSDK_V3.3.59.1_" + getContext().getPackageName() + "_" + C11102k.m23780bQ(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C10603c.C10604a getReadyClientConfig() {
        C10603c c10603c = this.aDQ;
        if (c10603c == null || c10603c.getClientConfig() == null) {
            return null;
        }
        return this.aDQ.getClientConfig();
    }

    private void init(Context context) {
        C10331c.m26248i("KsAdWebView", "init");
        setAccessibilityStateDisable(context);
        WebSettings m23848a = C11070bs.m23848a(this);
        m23848a.setUseWideViewPort(true);
        m23848a.setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(false);
        C10603c c10603c = new C10603c() { // from class: com.kwad.sdk.core.webview.KsAdWebView.1
            @Override // com.kwad.sdk.core.webview.p417a.C10603c, android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (KsAdWebView.this.aDT != null) {
                    KsAdWebView.this.aDT.m25248c(KsAdWebView.this.f29616HF);
                }
            }

            @Override // com.kwad.sdk.core.webview.p417a.C10603c, android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (KsAdWebView.this.aDT != null) {
                    C10632d unused = KsAdWebView.this.aDT;
                    C10632d.m25247d(KsAdWebView.this.f29616HF);
                }
            }
        };
        this.aDQ = c10603c;
        c10603c.m25350K(this.mUniqueId);
        setWebViewClient(this.aDQ);
        setWebChromeClient(new C10602b());
        setDownloadListener(new C10596a(this, (byte) 0));
        String userAgentString = m23848a.getUserAgentString();
        m23848a.setUserAgentString(userAgentString + m25356GO());
        this.f29616HF = new C10603c.C10604a(getContext());
    }

    private void setAccessibilityStateDisable(Context context) {
        if (Build.VERSION.SDK_INT != 17 || context == null) {
            return;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                C11124s.callMethod(accessibilityManager, "setState", 0);
            }
        } catch (Throwable unused) {
        }
    }

    public C10603c.C10604a getClientConfig() {
        return this.f29616HF;
    }

    public long getLoadTime() {
        return this.aDS;
    }

    public String getLoadUrl() {
        return this.aDR;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        C10621b.m25254eW(this.mUniqueId);
        this.aDR = str;
        this.aDS = System.currentTimeMillis();
        super.loadUrl(str);
    }

    public final void onActivityCreate() {
        C10632d c10632d = this.aDT;
        if (c10632d != null) {
            c10632d.m25250a(this.f29616HF);
        }
    }

    public final void onActivityDestroy() {
        release();
        C10632d c10632d = this.aDT;
        if (c10632d != null) {
            c10632d.m25249b(this.f29616HF);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        C10603c.C10604a c10604a = this.f29616HF;
        if (c10604a == null || c10604a.m25327pB() == null) {
            return;
        }
        this.f29616HF.m25327pB().mo25352pC();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f29616HF.m25340av(System.currentTimeMillis());
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setClientConfig(C10603c.C10604a c10604a) {
        this.aDQ.setClientConfig(c10604a);
        if (this.f29616HF.m25343GT()) {
            this.aDT = new C10632d();
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (C9425a.f29473md.booleanValue() && !(webChromeClient instanceof C10602b)) {
            throw new IllegalArgumentException("client is not instanceof KSWebChromeClient");
        }
        super.setWebChromeClient(webChromeClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (C9425a.f29473md.booleanValue() && !(webViewClient instanceof C10601a)) {
            throw new IllegalArgumentException("Not supported set webViewClient, please check it");
        }
        super.setWebViewClient(webViewClient);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        init(context);
    }
}
