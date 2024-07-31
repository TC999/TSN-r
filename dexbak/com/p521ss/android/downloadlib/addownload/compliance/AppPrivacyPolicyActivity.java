package com.p521ss.android.downloadlib.addownload.compliance;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.C6266R;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12029a;
import com.p521ss.android.downloadlib.p534h.C12216r;
import com.stub.StubApp;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AppPrivacyPolicyActivity extends Activity {

    /* renamed from: a */
    private WebView f34130a;

    /* renamed from: bl */
    private long f34131bl;

    /* renamed from: n */
    private String f34132n;

    /* renamed from: ok */
    private ImageView f34133ok;

    /* renamed from: s */
    private long f34134s;

    static {
        StubApp.interface11(22639);
    }

    /* renamed from: a */
    private void m19236a() {
        this.f34133ok = (ImageView) findViewById(C6266R.C6269id.iv_privacy_back);
        this.f34130a = (WebView) findViewById(C6266R.C6269id.privacy_webview);
        this.f34133ok.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C12066h.m19210ok("lp_app_privacy_click_close", AppPrivacyPolicyActivity.this.f34134s);
                AppPrivacyPolicyActivity.this.finish();
            }
        });
        WebSettings settings = this.f34130a.getSettings();
        settings.setDefaultFontSize(16);
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        this.f34130a.setWebViewClient(new WebViewClient() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.2
            /* renamed from: ok */
            private boolean m19231ok(Uri uri) {
                String scheme = uri.getScheme();
                return (IDataSource.f43971a.equals(scheme) || "https".equals(scheme)) ? false : true;
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (Build.VERSION.SDK_INT < 26) {
                    return super.onRenderProcessGone(webView, renderProcessGoneDetail);
                }
                if (!renderProcessGoneDetail.didCrash()) {
                    C12216r.m18675ok("System killed the WebView rendering process to reclaim memory. Recreating...");
                    if (webView != null) {
                        ((ViewGroup) webView.getParent()).removeView(webView);
                        webView.destroy();
                    }
                    return true;
                }
                C12216r.m18675ok("The WebView rendering process crashed!");
                if (webView != null) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                    webView.destroy();
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(21)
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return m19231ok(webResourceRequest.getUrl());
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return m19231ok(Uri.parse(str));
            }
        });
        m19233ok(this.f34130a);
        this.f34130a.setScrollBarStyle(0);
        this.f34130a.loadUrl(this.f34132n);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C12066h.m19210ok("lp_app_privacy_click_close", this.f34134s);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    /* renamed from: ok */
    public static void m19234ok(Activity activity, long j) {
        Intent intent = new Intent(activity, AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    /* renamed from: ok */
    private boolean m19235ok() {
        this.f34131bl = getIntent().getLongExtra("app_info_id", 0L);
        C12029a m19217ok = C12063bl.m19218ok().m19217ok(this.f34131bl);
        if (m19217ok == null) {
            return false;
        }
        this.f34134s = m19217ok.f34048a;
        String str = m19217ok.f34055q;
        this.f34132n = str;
        if (TextUtils.isEmpty(str)) {
            this.f34132n = C12128r.m18946q().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
            return true;
        }
        return true;
    }

    /* renamed from: ok */
    private void m19233ok(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }
}
