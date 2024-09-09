package xyz.adscope.amps.tool.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSCustomWebView extends WebView {
    public AMPSCustomWebView(Context context) {
        super(context);
        init();
    }

    private void init() {
        try {
            setWebViewSettings();
            setAdScopeWebViewClient();
        } catch (Throwable th) {
            LogUtil.e(AMPSConstants.AMPS_LOG_TAG, "e : " + th);
        }
    }

    private void openNativeIntent(String str) {
        Uri parse = TextUtils.isEmpty(str) ? null : Uri.parse(str);
        if (parse == null) {
            LogUtil.i(AMPSConstants.AMPS_LOG_TAG, "Failed to launch custom protocol: " + str);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.setFlags(268435456);
        try {
            getContext().startActivity(intent);
            destroy();
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        } catch (Exception e4) {
            LogUtil.e(AMPSConstants.AMPS_LOG_TAG, "e : " + e4);
        }
    }

    private void setAdScopeWebViewClient() {
        setWebViewClient(new WebViewClient() { // from class: xyz.adscope.amps.tool.widget.AMPSCustomWebView.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                LogUtil.i("AdscopeWebView_", "url : " + str);
                if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                AMPSCustomWebView.this.showJumpPromptDialog(webView.getContext(), str);
                return true;
            }
        });
    }

    private void setWebViewSettings() {
        CookieManager cookieManager;
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setBuiltInZoomControls(false);
        settings.setEnableSmoothTransition(true);
        settings.setLightTouchEnabled(false);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setLoadsImagesAutomatically(true);
        settings.setSavePassword(false);
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(false);
        int i4 = Build.VERSION.SDK_INT;
        settings.setMediaPlaybackRequiresUserGesture(false);
        if (i4 >= 21) {
            settings.setMixedContentMode(0);
        }
        if (i4 >= 19) {
            WebView.setWebContentsDebuggingEnabled(false);
        }
        settings.setAppCachePath(getContext().getCacheDir().getAbsolutePath());
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(-1);
        if (i4 < 19) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        if (i4 >= 21 && (cookieManager = CookieManager.getInstance()) != null) {
            cookieManager.setAcceptThirdPartyCookies(this, true);
        }
        setHorizontalScrollbarOverlay(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setScrollBarStyle(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showJumpPromptDialog(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && context != null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                context.startActivity(intent);
            }
        } catch (Throwable th) {
            LogUtil.e(AMPSConstants.AMPS_LOG_TAG, "e : " + th);
        }
    }

    public AMPSCustomWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AMPSCustomWebView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        init();
    }

    public AMPSCustomWebView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        init();
    }
}
