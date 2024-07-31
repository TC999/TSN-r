package com.mbridge.msdk.splash.p504c;

import android.content.Context;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.MBBatchReportManager;
import com.mbridge.msdk.foundation.same.report.PlayableReportUtils;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbjscommon.p496c.DefaultWebViewListener;
import com.mbridge.msdk.splash.p501a.C11567b;
import com.mbridge.msdk.splash.p506e.SplashReport;
import com.mbridge.msdk.splash.p508js.SplashJSBridgeImpl;
import com.mbridge.msdk.splash.p508js.SplashJsUtils;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;
import java.util.ArrayList;

/* renamed from: com.mbridge.msdk.splash.c.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class WebViewRenderManager {

    /* renamed from: a */
    private boolean f31860a;

    /* renamed from: b */
    private boolean f31861b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebViewRenderManager.java */
    /* renamed from: com.mbridge.msdk.splash.c.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11595a {

        /* renamed from: a */
        private static final WebViewRenderManager f31868a = new WebViewRenderManager();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public static /* synthetic */ WebViewRenderManager m21136a() {
            return f31868a;
        }
    }

    /* compiled from: WebViewRenderManager.java */
    /* renamed from: com.mbridge.msdk.splash.c.e$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11596b {
        /* renamed from: a */
        void mo21135a();

        /* renamed from: a */
        void mo21134a(int i);

        /* renamed from: a */
        void mo21133a(String str);
    }

    /* compiled from: WebViewRenderManager.java */
    /* renamed from: com.mbridge.msdk.splash.c.e$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11597c {

        /* renamed from: a */
        private String f31869a;

        /* renamed from: b */
        private String f31870b;

        /* renamed from: c */
        private CampaignEx f31871c;

        /* renamed from: d */
        private String f31872d;

        /* renamed from: e */
        private boolean f31873e;

        /* renamed from: f */
        private int f31874f;

        /* renamed from: a */
        public final String m21132a() {
            return this.f31872d;
        }

        /* renamed from: b */
        public final String m21127b() {
            return this.f31869a;
        }

        /* renamed from: c */
        public final String m21125c() {
            return this.f31870b;
        }

        /* renamed from: d */
        public final CampaignEx m21123d() {
            return this.f31871c;
        }

        /* renamed from: e */
        public final boolean m21122e() {
            return this.f31873e;
        }

        /* renamed from: f */
        public final int m21121f() {
            return this.f31874f;
        }

        /* renamed from: a */
        public final void m21129a(String str) {
            this.f31872d = str;
        }

        /* renamed from: b */
        public final void m21126b(String str) {
            this.f31869a = str;
        }

        /* renamed from: c */
        public final void m21124c(String str) {
            this.f31870b = str;
        }

        /* renamed from: a */
        public final void m21130a(CampaignEx campaignEx) {
            this.f31871c = campaignEx;
        }

        /* renamed from: a */
        public final void m21128a(boolean z) {
            this.f31873e = z;
        }

        /* renamed from: a */
        public final void m21131a(int i) {
            this.f31874f = i;
        }
    }

    private WebViewRenderManager() {
        this.f31860a = false;
        this.f31861b = false;
    }

    /* renamed from: a */
    public final void m21143a() {
        this.f31860a = false;
        this.f31861b = false;
    }

    /* renamed from: a */
    public final void m21141a(final MBSplashView mBSplashView, C11597c c11597c, final InterfaceC11596b interfaceC11596b) {
        String requestId;
        if (mBSplashView == null || c11597c == null) {
            return;
        }
        final String m21125c = c11597c.m21125c();
        String m21127b = c11597c.m21127b();
        final CampaignEx m21123d = c11597c.m21123d();
        String m21132a = c11597c.m21132a();
        boolean m21122e = c11597c.m21122e();
        int m21121f = c11597c.m21121f();
        MBSplashWebview splashWebview = mBSplashView.getSplashWebview();
        if (splashWebview == null) {
            return;
        }
        SplashJSBridgeImpl splashJSBridgeImpl = new SplashJSBridgeImpl(mBSplashView.getContext(), m21127b, m21125c);
        ArrayList arrayList = new ArrayList();
        arrayList.add(m21123d);
        splashJSBridgeImpl.m21030a(arrayList);
        splashJSBridgeImpl.m21035a(m21122e ? 1 : 0);
        splashJSBridgeImpl.m21028b(m21121f);
        mBSplashView.setSplashJSBridgeImpl(splashJSBridgeImpl);
        if (TextUtils.isEmpty(m21123d.getRequestId())) {
            requestId = m21123d.getRequestIdNotice();
        } else {
            requestId = m21123d.getRequestId();
        }
        String requestId2 = splashWebview.getRequestId();
        SameLogTool.m21733d("WebViewRenderManager", "CampaignEx RequestId = " + requestId + " WebView RequestId = " + requestId2);
        if (!TextUtils.isEmpty(requestId2) && requestId2.equals(requestId) && (this.f31860a || this.f31861b)) {
            mBSplashView.setH5Ready(true);
            if (interfaceC11596b != null) {
                interfaceC11596b.mo21134a(1);
                return;
            }
            return;
        }
        m21143a();
        splashWebview.setRequestId(requestId);
        C11567b m21290a = C11567b.m21293a().m21286c(m21123d.getId()).m21285d(m21123d.getRequestId()).m21282g(m21123d.getRequestIdNotice()).m21287b(m21125c).m21290a(m21123d.isBidCampaign());
        if (m21290a != null) {
            m21290a.m21291a("2000067");
            if (MBBatchReportManager.m22142a().m22135c()) {
                MBBatchReportManager.m22142a().m22139a(m21290a.m21289b());
            } else {
                PlayableReportUtils.m22112a(m21290a.m21289b(), MBSDKContext.m22865f().m22861j(), m21125c);
            }
        }
        final long currentTimeMillis = System.currentTimeMillis();
        splashWebview.setWebViewListener(new DefaultWebViewListener() { // from class: com.mbridge.msdk.splash.c.e.1
            @Override // com.mbridge.msdk.mbjscommon.p496c.DefaultWebViewListener, com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
            /* renamed from: a */
            public final void mo21139a(WebView webView, int i) {
                super.mo21139a(webView, i);
                InterfaceC11596b interfaceC11596b2 = interfaceC11596b;
                if (interfaceC11596b2 != null) {
                    interfaceC11596b2.mo21134a(i);
                }
                if (i == 1) {
                    WebViewRenderManager.this.f31860a = true;
                    mBSplashView.setH5Ready(true);
                    SameLogTool.m21738a("WindVaneWebView", "======渲染成功：ready");
                    SplashReport.m21065a(MBSDKContext.m22865f().m22861j(), m21123d, m21125c, "", currentTimeMillis, 1);
                    SplashReport.m21064a(m21123d, m21125c);
                    return;
                }
                WebViewRenderManager.this.f31860a = false;
                mBSplashView.setH5Ready(false);
                SameLogTool.m21738a("WindVaneWebView", "======渲染失败");
                SplashReport.m21056b(m21123d, "readyState 2", m21125c);
                SplashReport.m21065a(MBSDKContext.m22865f().m22861j(), m21123d, m21125c, "readyState 2", currentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbjscommon.p496c.DefaultWebViewListener, com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
            /* renamed from: a */
            public final void mo21138a(WebView webView, int i, String str, String str2) {
                super.mo21138a(webView, i, str, str2);
                InterfaceC11596b interfaceC11596b2 = interfaceC11596b;
                if (interfaceC11596b2 != null) {
                    interfaceC11596b2.mo21133a(str);
                }
                WebViewRenderManager.this.m21143a();
                mBSplashView.setH5Ready(false);
                SameLogTool.m21738a("WindVaneWebView", "======渲染失败");
                CampaignEx campaignEx = m21123d;
                SplashReport.m21056b(campaignEx, "error code:" + i + str, m21125c);
                Context m22861j = MBSDKContext.m22865f().m22861j();
                CampaignEx campaignEx2 = m21123d;
                String str3 = m21125c;
                SplashReport.m21065a(m22861j, campaignEx2, str3, "error code:" + i + str, currentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbjscommon.p496c.DefaultWebViewListener, com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
            /* renamed from: a */
            public final void mo21137a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.mo21137a(webView, sslErrorHandler, sslError);
                InterfaceC11596b interfaceC11596b2 = interfaceC11596b;
                if (interfaceC11596b2 != null) {
                    interfaceC11596b2.mo21133a(sslError.toString());
                }
                WebViewRenderManager.this.m21143a();
                mBSplashView.setH5Ready(false);
                SameLogTool.m21738a("WindVaneWebView", "======渲染失败");
                CampaignEx campaignEx = m21123d;
                SplashReport.m21056b(campaignEx, "error url:" + sslError.getUrl(), m21125c);
                Context m22861j = MBSDKContext.m22865f().m22861j();
                CampaignEx campaignEx2 = m21123d;
                String str = m21125c;
                SplashReport.m21065a(m22861j, campaignEx2, str, "error url:" + sslError.getUrl(), currentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbjscommon.p496c.DefaultWebViewListener, com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
            /* renamed from: a */
            public final void mo21037a(WebView webView, String str) {
                super.mo21037a(webView, str);
                InterfaceC11596b interfaceC11596b2 = interfaceC11596b;
                if (interfaceC11596b2 != null) {
                    interfaceC11596b2.mo21135a();
                }
                WebViewRenderManager.this.f31861b = true;
                if (!m21123d.isHasMBTplMark()) {
                    mBSplashView.setH5Ready(true);
                    SameLogTool.m21738a("WindVaneWebView", "======渲染成功：finish");
                    SplashReport.m21064a(m21123d, m21125c);
                    SplashReport.m21065a(MBSDKContext.m22865f().m22861j(), m21123d, m21125c, "", currentTimeMillis, 1);
                }
                SplashJsUtils.m21012a(webView);
            }
        });
        if (!splashWebview.isDestoryed()) {
            SameLogTool.m21738a("WebViewRenderManager", "======开始渲染：" + m21132a);
            splashWebview.loadUrl(m21132a);
            return;
        }
        mBSplashView.setH5Ready(false);
        SplashReport.m21065a(MBSDKContext.m22865f().m22861j(), m21123d, m21125c, "webview had destory", currentTimeMillis, 3);
    }
}
