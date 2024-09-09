package com.ss.android.downloadlib.addownload.compliance;

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
import com.bytedance.sdk.openadsdk.R;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class AppPrivacyPolicyActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private WebView f48425a;
    private long bl;

    /* renamed from: n  reason: collision with root package name */
    private String f48426n;
    private ImageView ok;

    /* renamed from: s  reason: collision with root package name */
    private long f48427s;

    static {
        StubApp.interface11(22639);
    }

    private void a() {
        this.ok = (ImageView) findViewById(R.id.iv_privacy_back);
        this.f48425a = (WebView) findViewById(R.id.privacy_webview);
        this.ok.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.ok("lp_app_privacy_click_close", AppPrivacyPolicyActivity.this.f48427s);
                AppPrivacyPolicyActivity.this.finish();
            }
        });
        WebSettings settings = this.f48425a.getSettings();
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
        this.f48425a.setWebViewClient(new WebViewClient() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.2
            private boolean ok(Uri uri) {
                String scheme = uri.getScheme();
                return ("http".equals(scheme) || "https".equals(scheme)) ? false : true;
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (Build.VERSION.SDK_INT < 26) {
                    return super.onRenderProcessGone(webView, renderProcessGoneDetail);
                }
                if (!renderProcessGoneDetail.didCrash()) {
                    com.ss.android.downloadlib.h.r.ok("System killed the WebView rendering process to reclaim memory. Recreating...");
                    if (webView != null) {
                        ((ViewGroup) webView.getParent()).removeView(webView);
                        webView.destroy();
                    }
                    return true;
                }
                com.ss.android.downloadlib.h.r.ok("The WebView rendering process crashed!");
                if (webView != null) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                    webView.destroy();
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(21)
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return ok(webResourceRequest.getUrl());
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ok(Uri.parse(str));
            }
        });
        ok(this.f48425a);
        this.f48425a.setScrollBarStyle(0);
        this.f48425a.loadUrl(this.f48426n);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        h.ok("lp_app_privacy_click_close", this.f48427s);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void ok(Activity activity, long j4) {
        Intent intent = new Intent(activity, AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j4);
        activity.startActivity(intent);
    }

    private boolean ok() {
        this.bl = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.a.a ok = bl.ok().ok(this.bl);
        if (ok == null) {
            return false;
        }
        this.f48427s = ok.f48355a;
        String str = ok.f48359q;
        this.f48426n = str;
        if (TextUtils.isEmpty(str)) {
            this.f48426n = com.ss.android.downloadlib.addownload.r.q().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
            return true;
        }
        return true;
    }

    private void ok(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }
}
