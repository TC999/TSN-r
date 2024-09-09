package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.component.adexpress.sr.r;
import com.bytedance.sdk.component.adexpress.ux.ux;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.fz;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.p;
import com.bytedance.sdk.openadsdk.core.u.j;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.c.sr;
import com.bytedance.sdk.openadsdk.core.widget.c.w;
import com.bytedance.sdk.openadsdk.core.widget.c.xv;
import com.bytedance.sdk.openadsdk.core.xk;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PlayableFeedWebView extends SSWebView implements p {

    /* renamed from: c  reason: collision with root package name */
    private Context f34933c;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f34934f;
    private j sr;
    private NativeVideoTsView ux;

    /* renamed from: w  reason: collision with root package name */
    private xk f34935w;
    private me xv;

    public PlayableFeedWebView(Context context, me meVar, j jVar, NativeVideoTsView nativeVideoTsView, ViewGroup viewGroup) {
        super(context);
        this.f34933c = context;
        this.xv = meVar;
        this.sr = jVar;
        this.f34934f = viewGroup;
        setVisibility(4);
        setTag("easy_pfwv");
        c(nativeVideoTsView);
    }

    private void t() {
        xk xkVar = new xk(this.f34933c);
        this.f34935w = xkVar;
        xkVar.w(this).c(this.xv).w(this.xv.jr()).xv(this.xv.cf()).sr(wv.t(this.xv)).ia(true).c((SSWebView) this);
    }

    private void ys() {
        setBackgroundColor(0);
        setBackgroundResource(17170445);
        c((SSWebView) this);
        if (this.xv != null) {
            Context context = this.f34933c;
            xk xkVar = this.f34935w;
            me meVar = this.xv;
            setWebViewClient(new c(context, xkVar, meVar, meVar.jr()));
        }
        ux.c().c(this, this.f34935w);
        setWebChromeClient(new xv(this.f34935w));
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public int S_() {
        NativeVideoTsView nativeVideoTsView = this.ux;
        if (nativeVideoTsView == null || nativeVideoTsView.getVideoError()) {
            return 4;
        }
        com.bykv.vk.openvk.component.video.api.sr.xv nativeVideoController = this.ux.getNativeVideoController();
        if (nativeVideoController.u()) {
            return 5;
        }
        if (nativeVideoController.q()) {
            return 1;
        }
        return ((nativeVideoController instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) && ((com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) nativeVideoController).oo()) ? 2 : 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public int T_() {
        com.bykv.vk.openvk.component.video.api.sr.xv nativeVideoController;
        NativeVideoTsView nativeVideoTsView = this.ux;
        if (nativeVideoTsView == null || (nativeVideoController = nativeVideoTsView.getNativeVideoController()) == null) {
            return 0;
        }
        return ((int) nativeVideoController.k()) / 1000;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void U_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void V_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void W_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void X_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void Y_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void a_(boolean z3) {
        com.bykv.vk.openvk.component.video.api.sr.xv nativeVideoController;
        NativeVideoTsView nativeVideoTsView = this.ux;
        if (nativeVideoTsView == null || (nativeVideoController = nativeVideoTsView.getNativeVideoController()) == null) {
            return;
        }
        nativeVideoController.w(z3);
    }

    public void bk() {
        xk xkVar = this.f34935w;
        if (xkVar != null) {
            xkVar.xk();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(float f4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(float f4, float f5, float f6, float f7, int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(int i4, String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void ev() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void f() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public long getActualPlayDuration() {
        com.bykv.vk.openvk.component.video.api.sr.xv nativeVideoController;
        NativeVideoTsView nativeVideoTsView = this.ux;
        if (nativeVideoTsView == null || (nativeVideoController = nativeVideoTsView.getNativeVideoController()) == null) {
            return 0L;
        }
        return ((int) nativeVideoController.k()) / 1000;
    }

    public xk getJsObject() {
        return this.f34935w;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w(false);
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i4) {
        super.onVisibilityChanged(view, i4);
        w(i4 == 0);
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        w(z3);
    }

    public void setExpressVideoListener(p pVar) {
        xk xkVar = this.f34935w;
        if (xkVar != null) {
            xkVar.c(pVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void setPauseFromExpressView(boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void w(int i4) {
    }

    public void c(NativeVideoTsView nativeVideoTsView) {
        t();
        ys();
        c(this.sr.c());
        w(nativeVideoTsView);
        setExpressVideoListener(this);
    }

    public void w(NativeVideoTsView nativeVideoTsView) {
        this.ux = nativeVideoTsView;
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.1
            @Override // java.lang.Runnable
            public void run() {
                int i4;
                int i5 = 0;
                if (PlayableFeedWebView.this.ux == null || PlayableFeedWebView.this.sr == null) {
                    i4 = 0;
                } else {
                    i5 = PlayableFeedWebView.this.ux.getWidth();
                    i4 = PlayableFeedWebView.this.ux.getHeight();
                }
                int w3 = PlayableFeedWebView.this.sr.w();
                if (w3 == 0 || w3 == 2) {
                    i5 = PlayableFeedWebView.this.f34934f.getWidth();
                    i4 = PlayableFeedWebView.this.f34934f.getHeight();
                }
                PlayableFeedWebView.this.c(i5, i4);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public long xv() {
        com.bykv.vk.openvk.component.video.api.sr.xv nativeVideoController;
        NativeVideoTsView nativeVideoTsView = this.ux;
        if (nativeVideoTsView == null || (nativeVideoController = nativeVideoTsView.getNativeVideoController()) == null) {
            return 0L;
        }
        return ((int) nativeVideoController.k()) / 1000;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c extends sr {

        /* renamed from: c  reason: collision with root package name */
        private me f34937c;

        public c(Context context, xk xkVar, me meVar, String str) {
            super(context, xkVar, str);
            this.f34937c = meVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView webView, String str) {
            try {
                com.bytedance.sdk.component.adexpress.c.w.c c4 = com.bytedance.sdk.openadsdk.core.nativeexpress.c.c.c(webView, this.f34937c, str, new c.InterfaceC0500c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.c.1
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
                a.xv("xeasy", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
    }

    public void w(boolean z3) {
        xk xkVar = this.f34935w;
        if (xkVar != null) {
            xkVar.fp(z3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(int i4, int i5) {
        FrameLayout.LayoutParams layoutParams;
        int w3 = this.sr.w();
        if (w3 != 1 && w3 != 2) {
            ViewGroup viewGroup = this.f34934f;
            if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i4, i5);
                layoutParams2.addRule(13);
                layoutParams = layoutParams2;
            } else if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i4, i5);
                layoutParams3.gravity = 17;
                layoutParams = layoutParams3;
            } else {
                a.w("xeasy", "otcon");
                layoutParams = null;
            }
        } else {
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i4, i5);
            layoutParams4.gravity = 17;
            layoutParams = layoutParams4;
        }
        setLayoutParams(layoutParams);
        a.w("xeasy", "wcs:" + i4 + " hcs:" + i5);
    }

    private void c(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            w.c(this.f34933c).c(false).c(sSWebView.getWebView());
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            sSWebView.setUserAgentString(fz.c(sSWebView.getWebView(), eq.f33190w, me.f(this.xv)));
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
            a.f("xeasy", e4.toString());
        }
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView
    public void c(String str) {
        super.c(str);
    }
}
