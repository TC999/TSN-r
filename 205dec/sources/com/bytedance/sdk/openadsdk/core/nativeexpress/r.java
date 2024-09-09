package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.sr.r;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c.c;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.xk;
import java.util.ArrayList;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends com.bytedance.sdk.openadsdk.core.widget.c.sr {

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Integer> f34181c;
    private final com.bytedance.sdk.openadsdk.bk.ev gd;

    /* renamed from: k  reason: collision with root package name */
    private boolean f34182k;

    /* renamed from: p  reason: collision with root package name */
    private me f34183p;

    public r(Context context, xk xkVar, me meVar, com.bytedance.sdk.openadsdk.core.a.sr srVar, boolean z3, com.bytedance.sdk.openadsdk.bk.ev evVar) {
        super(context, xkVar, meVar.jr(), srVar);
        this.f34181c = new ArrayList<>();
        this.f34183p = meVar;
        this.f34182k = z3;
        this.gd = evVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String sr() {
        me meVar = this.f34183p;
        if (meVar == null || meVar.rh() == null) {
            return null;
        }
        return this.f34183p.rh().k();
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.f35399f = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f35401r = false;
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.xv("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int c() {
        /*
            r5 = this;
            java.util.ArrayList<java.lang.Integer> r0 = r5.f34181c
            java.util.Iterator r0 = r0.iterator()
        L6:
            boolean r1 = r0.hasNext()
            r2 = -1
            if (r1 == 0) goto L2c
            java.lang.Object r1 = r0.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r3 = r1.intValue()
            r4 = 3
            if (r3 == r4) goto L27
            int r3 = r1.intValue()
            r4 = 2
            if (r3 == r4) goto L27
            int r3 = r1.intValue()
            if (r3 != r2) goto L6
        L27:
            int r0 = r1.intValue()
            return r0
        L2c:
            java.lang.String r0 = r5.sr()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L37
            goto L38
        L37:
            r2 = 1
        L38:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.r.c():int");
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            com.bytedance.sdk.openadsdk.bk.ev evVar = this.gd;
            if (evVar != null) {
                evVar.gd(str);
            }
            long currentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.adexpress.c.w.c c4 = com.bytedance.sdk.openadsdk.core.nativeexpress.c.c.c(webView, this.f34183p, str, new c.InterfaceC0500c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.r.1
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c.c.InterfaceC0500c
                public com.bytedance.sdk.component.adexpress.c.w.c c(String str2, r.c cVar, String str3) {
                    return com.bytedance.sdk.component.adexpress.c.w.w.c(str2, cVar, str3, r.this.sr());
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c.c.InterfaceC0500c
                public boolean c() {
                    return true;
                }
            });
            c(currentTimeMillis, System.currentTimeMillis(), str, (c4 == null || c4.c() == null) ? 2 : 1);
            if (c4 != null && c4.getType() != 5) {
                this.f34181c.add(Integer.valueOf(c4.getType()));
            }
            if (c4 != null && c4.c() != null) {
                com.bytedance.sdk.openadsdk.bk.ev evVar2 = this.gd;
                if (evVar2 != null) {
                    evVar2.p(str);
                }
                return c4.c();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.xv("ExpressClient", "shouldInterceptRequest error2", th);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    private void c(long j4, long j5, String str, int i4) {
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.ux;
        if (srVar == null || srVar.w() == null) {
            return;
        }
        r.c c4 = com.bytedance.sdk.component.adexpress.sr.r.c(str);
        if (c4 == r.c.HTML) {
            this.ux.w().c(str, j4, j5, i4);
        } else if (c4 == r.c.JS) {
            this.ux.w().w(str, j4, j5, i4);
        }
    }
}
