package com.mbridge.msdk.splash.c;

import android.content.Context;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;
import java.util.ArrayList;

/* compiled from: WebViewRenderManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f40632a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f40633b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebViewRenderManager.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e f40640a = new e();

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ e a() {
            return f40640a;
        }
    }

    /* compiled from: WebViewRenderManager.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        void a();

        void a(int i4);

        void a(String str);
    }

    /* compiled from: WebViewRenderManager.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private String f40641a;

        /* renamed from: b  reason: collision with root package name */
        private String f40642b;

        /* renamed from: c  reason: collision with root package name */
        private CampaignEx f40643c;

        /* renamed from: d  reason: collision with root package name */
        private String f40644d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f40645e;

        /* renamed from: f  reason: collision with root package name */
        private int f40646f;

        public final String a() {
            return this.f40644d;
        }

        public final String b() {
            return this.f40641a;
        }

        public final String c() {
            return this.f40642b;
        }

        public final CampaignEx d() {
            return this.f40643c;
        }

        public final boolean e() {
            return this.f40645e;
        }

        public final int f() {
            return this.f40646f;
        }

        public final void a(String str) {
            this.f40644d = str;
        }

        public final void b(String str) {
            this.f40641a = str;
        }

        public final void c(String str) {
            this.f40642b = str;
        }

        public final void a(CampaignEx campaignEx) {
            this.f40643c = campaignEx;
        }

        public final void a(boolean z3) {
            this.f40645e = z3;
        }

        public final void a(int i4) {
            this.f40646f = i4;
        }
    }

    private e() {
        this.f40632a = false;
        this.f40633b = false;
    }

    public final void a() {
        this.f40632a = false;
        this.f40633b = false;
    }

    public final void a(final MBSplashView mBSplashView, c cVar, final b bVar) {
        String requestId;
        if (mBSplashView == null || cVar == null) {
            return;
        }
        final String c4 = cVar.c();
        String b4 = cVar.b();
        final CampaignEx d4 = cVar.d();
        String a4 = cVar.a();
        boolean e4 = cVar.e();
        int f4 = cVar.f();
        MBSplashWebview splashWebview = mBSplashView.getSplashWebview();
        if (splashWebview == null) {
            return;
        }
        com.mbridge.msdk.splash.js.b bVar2 = new com.mbridge.msdk.splash.js.b(mBSplashView.getContext(), b4, c4);
        ArrayList arrayList = new ArrayList();
        arrayList.add(d4);
        bVar2.a(arrayList);
        bVar2.a(e4 ? 1 : 0);
        bVar2.b(f4);
        mBSplashView.setSplashJSBridgeImpl(bVar2);
        if (TextUtils.isEmpty(d4.getRequestId())) {
            requestId = d4.getRequestIdNotice();
        } else {
            requestId = d4.getRequestId();
        }
        String requestId2 = splashWebview.getRequestId();
        x.d("WebViewRenderManager", "CampaignEx RequestId = " + requestId + " WebView RequestId = " + requestId2);
        if (!TextUtils.isEmpty(requestId2) && requestId2.equals(requestId) && (this.f40632a || this.f40633b)) {
            mBSplashView.setH5Ready(true);
            if (bVar != null) {
                bVar.a(1);
                return;
            }
            return;
        }
        a();
        splashWebview.setRequestId(requestId);
        com.mbridge.msdk.splash.a.b a5 = com.mbridge.msdk.splash.a.b.a().c(d4.getId()).d(d4.getRequestId()).g(d4.getRequestIdNotice()).b(c4).a(d4.isBidCampaign());
        if (a5 != null) {
            a5.a("2000067");
            if (com.mbridge.msdk.foundation.same.report.b.a().c()) {
                com.mbridge.msdk.foundation.same.report.b.a().a(a5.b());
            } else {
                com.mbridge.msdk.foundation.same.report.c.a(a5.b(), com.mbridge.msdk.foundation.controller.a.f().j(), c4);
            }
        }
        final long currentTimeMillis = System.currentTimeMillis();
        splashWebview.setWebViewListener(new com.mbridge.msdk.mbjscommon.c.b() { // from class: com.mbridge.msdk.splash.c.e.1
            @Override // com.mbridge.msdk.mbjscommon.c.b, com.mbridge.msdk.mbjscommon.windvane.d
            public final void a(WebView webView, int i4) {
                super.a(webView, i4);
                b bVar3 = bVar;
                if (bVar3 != null) {
                    bVar3.a(i4);
                }
                if (i4 == 1) {
                    e.this.f40632a = true;
                    mBSplashView.setH5Ready(true);
                    x.a("WindVaneWebView", "======\u6e32\u67d3\u6210\u529f\uff1aready");
                    com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.a.f().j(), d4, c4, "", currentTimeMillis, 1);
                    com.mbridge.msdk.splash.e.a.a(d4, c4);
                    return;
                }
                e.this.f40632a = false;
                mBSplashView.setH5Ready(false);
                x.a("WindVaneWebView", "======\u6e32\u67d3\u5931\u8d25");
                com.mbridge.msdk.splash.e.a.b(d4, "readyState 2", c4);
                com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.a.f().j(), d4, c4, "readyState 2", currentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbjscommon.c.b, com.mbridge.msdk.mbjscommon.windvane.d
            public final void a(WebView webView, int i4, String str, String str2) {
                super.a(webView, i4, str, str2);
                b bVar3 = bVar;
                if (bVar3 != null) {
                    bVar3.a(str);
                }
                e.this.a();
                mBSplashView.setH5Ready(false);
                x.a("WindVaneWebView", "======\u6e32\u67d3\u5931\u8d25");
                CampaignEx campaignEx = d4;
                com.mbridge.msdk.splash.e.a.b(campaignEx, "error code:" + i4 + str, c4);
                Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
                CampaignEx campaignEx2 = d4;
                String str3 = c4;
                com.mbridge.msdk.splash.e.a.a(j4, campaignEx2, str3, "error code:" + i4 + str, currentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbjscommon.c.b, com.mbridge.msdk.mbjscommon.windvane.d
            public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.a(webView, sslErrorHandler, sslError);
                b bVar3 = bVar;
                if (bVar3 != null) {
                    bVar3.a(sslError.toString());
                }
                e.this.a();
                mBSplashView.setH5Ready(false);
                x.a("WindVaneWebView", "======\u6e32\u67d3\u5931\u8d25");
                CampaignEx campaignEx = d4;
                com.mbridge.msdk.splash.e.a.b(campaignEx, "error url:" + sslError.getUrl(), c4);
                Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
                CampaignEx campaignEx2 = d4;
                String str = c4;
                com.mbridge.msdk.splash.e.a.a(j4, campaignEx2, str, "error url:" + sslError.getUrl(), currentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbjscommon.c.b, com.mbridge.msdk.mbjscommon.windvane.d
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                b bVar3 = bVar;
                if (bVar3 != null) {
                    bVar3.a();
                }
                e.this.f40633b = true;
                if (!d4.isHasMBTplMark()) {
                    mBSplashView.setH5Ready(true);
                    x.a("WindVaneWebView", "======\u6e32\u67d3\u6210\u529f\uff1afinish");
                    com.mbridge.msdk.splash.e.a.a(d4, c4);
                    com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.a.f().j(), d4, c4, "", currentTimeMillis, 1);
                }
                com.mbridge.msdk.splash.js.c.a(webView);
            }
        });
        if (!splashWebview.isDestoryed()) {
            x.a("WebViewRenderManager", "======\u5f00\u59cb\u6e32\u67d3\uff1a" + a4);
            splashWebview.loadUrl(a4);
            return;
        }
        mBSplashView.setH5Ready(false);
        com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.a.f().j(), d4, c4, "webview had destory", currentTimeMillis, 3);
    }
}
