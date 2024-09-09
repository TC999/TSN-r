package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.bytedance.adsdk.ugeno.w.g;
import com.bytedance.sdk.component.adexpress.sr.r;
import com.bytedance.sdk.component.adexpress.ux.ux;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.fz;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c.c;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.widget.c.sr;
import com.bytedance.sdk.openadsdk.core.widget.c.w;
import com.bytedance.sdk.openadsdk.core.widget.c.xv;
import com.bytedance.sdk.openadsdk.core.xk;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class InteractWebView extends SSWebView {

    /* renamed from: c  reason: collision with root package name */
    private Context f34928c;
    private me sr;
    private g ux;

    /* renamed from: w  reason: collision with root package name */
    private xk f34929w;
    private Map<String, Object> xv;

    public InteractWebView(Context context) {
        super(context);
        this.f34928c = context;
    }

    private void c(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            w.c(this.f34928c).c(false).c(sSWebView.getWebView());
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            sSWebView.setUserAgentString(fz.c(sSWebView.getWebView(), eq.f33190w, me.f(this.sr)));
            if (Build.VERSION.SDK_INT >= 21) {
                sSWebView.setMixedContentMode(0);
            }
            sSWebView.setJavaScriptEnabled(true);
            sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.setDomStorageEnabled(true);
            sSWebView.setDatabaseEnabled(true);
            sSWebView.setAppCacheEnabled(true);
            sSWebView.setAllowFileAccess(false);
            sSWebView.setSupportZoom(true);
            sSWebView.setBuiltInZoomControls(true);
            sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            sSWebView.setUseWideViewPort(true);
        } catch (Exception e4) {
            a.f("InteractWebView", e4.toString());
        }
    }

    public void bk() {
        Map<String, Object> map = this.xv;
        if (map == null || map.size() <= 0 || !this.xv.containsKey("key_material")) {
            return;
        }
        Object obj = this.xv.get("key_material");
        if (obj instanceof me) {
            this.sr = (me) obj;
            this.f34929w = (xk) this.xv.get("key_js_object");
            if (this.xv.containsKey("key_data_list") && (this.xv.get("key_data_list") instanceof List)) {
                this.f34929w.w((List) this.xv.get("key_data_list"));
            }
            this.f34929w.w(this).c(this.sr).w(this.sr.jr()).xv(this.sr.cf()).sr(wv.t(this.sr)).c((SSWebView) this);
        }
    }

    public g getUGenContext() {
        return this.ux;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setUGenContext(g gVar) {
        this.ux = gVar;
    }

    public void setUGenExtraMap(Map<String, Object> map) {
        this.xv = map;
    }

    public void t() {
        setBackgroundColor(0);
        setBackgroundResource(17170445);
        c((SSWebView) this);
        if (this.sr != null) {
            Context context = this.f34928c;
            xk xkVar = this.f34929w;
            me meVar = this.sr;
            setWebViewClient(new c(context, xkVar, meVar, meVar.jr()));
        }
        ux.c().c(this, this.f34929w);
        setWebChromeClient(new xv(this.f34929w));
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c extends sr {

        /* renamed from: c  reason: collision with root package name */
        private me f34930c;

        public c(Context context, xk xkVar, me meVar, String str) {
            super(context, xkVar, str);
            this.f34930c = meVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView webView, String str) {
            try {
                com.bytedance.sdk.component.adexpress.c.w.c c4 = com.bytedance.sdk.openadsdk.core.nativeexpress.c.c.c(webView, this.f34930c, str, new c.InterfaceC0500c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.InteractWebView.c.1
                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c.c.InterfaceC0500c
                    public com.bytedance.sdk.component.adexpress.c.w.c c(String str2, r.c cVar, String str3) {
                        com.bytedance.sdk.component.adexpress.c.w.c cVar2 = new com.bytedance.sdk.component.adexpress.c.w.c();
                        cVar2.c(5);
                        cVar2.c(com.bytedance.sdk.openadsdk.core.ugeno.ux.c.w().c(webView, cVar, str2));
                        return cVar2;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c.c.InterfaceC0500c
                    public boolean c() {
                        return false;
                    }
                });
                if (c4 != null && c4.c() != null) {
                    return c4.c();
                }
            } catch (Throwable unused) {
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            } catch (Throwable th) {
                a.xv("InteractWebView", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView
    public void c(String str) {
        super.c(str);
    }
}
