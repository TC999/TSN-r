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
import com.kwad.sdk.core.webview.a.c;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.s;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsAdWebView extends com.kwad.sdk.core.webview.c {
    @NonNull
    private c.a HF;
    private com.kwad.sdk.core.webview.a.c aDQ;
    private String aDR;
    private long aDS;
    @Nullable
    private com.kwad.sdk.core.webview.d aDT;
    private String mUniqueId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class a implements DownloadListener {
        private a() {
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j4) {
            boolean o4 = bq.o(KsAdWebView.this, 100);
            com.kwad.sdk.core.e.c.d("KsAdWebView", "onDownloadStart: currentVisible " + o4);
            if (o4 && KsAdWebView.this.HF.GU()) {
                if (KsAdWebView.this.HF != null && KsAdWebView.this.HF.getAdTemplate() != null && KsAdWebView.this.HF.GS()) {
                    com.kwad.sdk.core.response.b.e.dQ(KsAdWebView.this.HF.getAdTemplate()).adConversionInfo.appDownloadUrl = str;
                    KsAdWebView.this.HF.getAdTemplate().isWebViewDownload = true;
                    c.a readyClientConfig = KsAdWebView.this.getReadyClientConfig();
                    if (readyClientConfig != null) {
                        readyClientConfig.ei(KsAdWebView.this.HF.getAdTemplate());
                    }
                    ((com.kwad.sdk.service.a.a) ServiceProvider.get(com.kwad.sdk.service.a.a.class)).g(l.wrapContextIfNeed(KsAdWebView.this.getContext()), KsAdWebView.this.HF.getAdTemplate());
                    return;
                }
                try {
                    KsAdWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception e4) {
                    com.kwad.sdk.core.e.c.printStackTrace(e4);
                }
            }
        }

        /* synthetic */ a(KsAdWebView ksAdWebView, byte b4) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        void onFailed();

        void onSuccess();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface c {
        void pC();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface d {
        void onPageFinished();

        void onPageStart();

        void onReceivedHttpError(int i4, String str, String str2);
    }

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface e {
        void onPageFinished();

        void onPageStart();

        void onReceivedHttpError(int i4, String str, String str2);
    }

    public KsAdWebView(Context context) {
        super(context);
        init(context);
    }

    private String GO() {
        return "KSADSDK_V3.3.59.1_" + getContext().getPackageName() + "_" + k.bQ(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a getReadyClientConfig() {
        com.kwad.sdk.core.webview.a.c cVar = this.aDQ;
        if (cVar == null || cVar.getClientConfig() == null) {
            return null;
        }
        return this.aDQ.getClientConfig();
    }

    private void init(Context context) {
        com.kwad.sdk.core.e.c.i("KsAdWebView", "init");
        setAccessibilityStateDisable(context);
        WebSettings a4 = bs.a(this);
        a4.setUseWideViewPort(true);
        a4.setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(false);
        com.kwad.sdk.core.webview.a.c cVar = new com.kwad.sdk.core.webview.a.c() { // from class: com.kwad.sdk.core.webview.KsAdWebView.1
            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (KsAdWebView.this.aDT != null) {
                    KsAdWebView.this.aDT.c(KsAdWebView.this.HF);
                }
            }

            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i4, String str, String str2) {
                super.onReceivedError(webView, i4, str, str2);
                if (KsAdWebView.this.aDT != null) {
                    com.kwad.sdk.core.webview.d unused = KsAdWebView.this.aDT;
                    com.kwad.sdk.core.webview.d.d(KsAdWebView.this.HF);
                }
            }
        };
        this.aDQ = cVar;
        cVar.K(this.mUniqueId);
        setWebViewClient(this.aDQ);
        setWebChromeClient(new com.kwad.sdk.core.webview.a.b());
        setDownloadListener(new a(this, (byte) 0));
        String userAgentString = a4.getUserAgentString();
        a4.setUserAgentString(userAgentString + GO());
        this.HF = new c.a(getContext());
    }

    private void setAccessibilityStateDisable(Context context) {
        if (Build.VERSION.SDK_INT != 17 || context == null) {
            return;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                s.callMethod(accessibilityManager, "setState", 0);
            }
        } catch (Throwable unused) {
        }
    }

    public c.a getClientConfig() {
        return this.HF;
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
        com.kwad.sdk.core.webview.b.c.b.eW(this.mUniqueId);
        this.aDR = str;
        this.aDS = System.currentTimeMillis();
        super.loadUrl(str);
    }

    public final void onActivityCreate() {
        com.kwad.sdk.core.webview.d dVar = this.aDT;
        if (dVar != null) {
            dVar.a(this.HF);
        }
    }

    public final void onActivityDestroy() {
        release();
        com.kwad.sdk.core.webview.d dVar = this.aDT;
        if (dVar != null) {
            dVar.b(this.HF);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i4, int i5, int i6, int i7) {
        super.onScrollChanged(i4, i5, i6, i7);
        c.a aVar = this.HF;
        if (aVar == null || aVar.pB() == null) {
            return;
        }
        this.HF.pB().pC();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.HF.av(System.currentTimeMillis());
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setClientConfig(c.a aVar) {
        this.aDQ.setClientConfig(aVar);
        if (this.HF.GT()) {
            this.aDT = new com.kwad.sdk.core.webview.d();
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (com.kwad.framework.a.a.md.booleanValue() && !(webChromeClient instanceof com.kwad.sdk.core.webview.a.b)) {
            throw new IllegalArgumentException("client is not instanceof KSWebChromeClient");
        }
        super.setWebChromeClient(webChromeClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (com.kwad.framework.a.a.md.booleanValue() && !(webViewClient instanceof com.kwad.sdk.core.webview.a.a)) {
            throw new IllegalArgumentException("Not supported set webViewClient, please check it");
        }
        super.setWebViewClient(webViewClient);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i4, boolean z3) {
        super(context, attributeSet, i4, z3);
        init(context);
    }
}
