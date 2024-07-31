package com.beizi.p051ad.internal.utilities;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.beizi.p051ad.alipay.p054js.JavaScriptInterface;
import com.beizi.p051ad.internal.BeiZiImpl;
import java.util.List;
import java.util.Map;

/* renamed from: com.beizi.ad.internal.utilities.WebviewUtil */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class WebviewUtil {
    private static final String VERSION_ZERO_HEADER = "Set-cookie";

    public static void cookieSync(Map<String, List<String>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager == null) {
            HaoboLog.m49288i(HaoboLog.httpRespLogTag, "Unable to find a CookieManager");
            return;
        }
        try {
            String existingSDKUID = getExistingSDKUID();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && key.equalsIgnoreCase(VERSION_ZERO_HEADER)) {
                    for (String str : entry.getValue()) {
                        if (!TextUtils.isEmpty(str) && str.contains("sdkuid") && (existingSDKUID == null || !str.contains(existingSDKUID))) {
                            cookieManager.setCookie(BeiZiImpl.m49492a().m49471g(), str);
                            if (Build.VERSION.SDK_INT < 21) {
                                CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
                                if (cookieSyncManager == null) {
                                    HaoboLog.m49288i(HaoboLog.httpRespLogTag, "Unable to find a CookieSyncManager");
                                    return;
                                }
                                cookieSyncManager.sync();
                            } else {
                                cookieManager.flush();
                            }
                        }
                    }
                    continue;
                }
            }
        } catch (IllegalStateException | Exception unused) {
        }
    }

    public static String getCookie() {
        return null;
    }

    private static String getExistingSDKUID() {
        String[] split;
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager != null) {
            String cookie = cookieManager.getCookie(BeiZiImpl.m49492a().m49471g());
            if (TextUtils.isEmpty(cookie)) {
                return null;
            }
            for (String str : cookie.split("; ")) {
                if (str != null && str.contains("sdkuid")) {
                    return str;
                }
            }
            return null;
        }
        return null;
    }

    public static void onPause(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            WebView.class.getDeclaredMethod("onPause", new Class[0]).invoke(webView, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public static void onResume(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            WebView.class.getDeclaredMethod("onResume", new Class[0]).invoke(webView, new Object[0]);
        } catch (Exception unused) {
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static void setWebViewSettings(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            webView.getSettings().setBuiltInZoomControls(false);
            webView.getSettings().setSupportZoom(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setJavaScriptEnabled(true);
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                webView.getSettings().setMixedContentMode(0);
            }
            webView.getSettings().setDomStorageEnabled(true);
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
            webView.getSettings().setAllowFileAccess(false);
            webView.getSettings().setAllowContentAccess(false);
            webView.getSettings().setSavePassword(false);
            webView.getSettings().setAllowFileAccessFromFileURLs(false);
            webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
            if (i >= 21) {
                CookieManager cookieManager = CookieManager.getInstance();
                if (cookieManager != null) {
                    cookieManager.setAcceptThirdPartyCookies(webView, true);
                } else {
                    HaoboLog.m49292d(HaoboLog.baseLogTag, "Failed to set Webview to accept 3rd party cookie");
                }
            }
            webView.getSettings().setAppCachePath(webView.getContext().getCacheDir().getAbsolutePath());
            webView.getSettings().setAppCacheEnabled(true);
            webView.getSettings().setCacheMode(-1);
            if (i < 19) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            webView.addJavascriptInterface(new JavaScriptInterface(webView), "JSBridge");
            if (i >= 19) {
                WebView.setWebContentsDebuggingEnabled(false);
            }
        } catch (Exception e) {
            String str = HaoboLog.httpRespLogTag;
            HaoboLog.m49290e(str, "Unable update webview settings - Exception: " + e.getMessage());
        }
    }
}
