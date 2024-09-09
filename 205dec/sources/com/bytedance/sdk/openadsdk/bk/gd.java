package com.bytedance.sdk.openadsdk.bk;

import android.webkit.WebSettings;
import android.webkit.WebView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd {
    private static void c(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            r.c("WebViewSettings", "allowMediaPlayWithoutUserGesture error", th);
        }
    }

    private static void w(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            r.c("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.webkit.WebView r6) {
        /*
            java.lang.String r0 = "WebViewSettings"
            w(r6)
            android.webkit.WebSettings r1 = r6.getSettings()
            c(r1)
            if (r1 != 0) goto Lf
            return
        Lf:
            r2 = 1
            r1.setJavaScriptEnabled(r2)     // Catch: java.lang.Throwable -> L14
            goto L1a
        L14:
            r3 = move-exception
            java.lang.String r4 = "setJavaScriptEnabled error"
            com.bytedance.sdk.openadsdk.bk.r.c(r0, r4, r3)
        L1a:
            r3 = 0
            r1.setSupportZoom(r3)     // Catch: java.lang.Throwable -> L1f
            goto L25
        L1f:
            r4 = move-exception
            java.lang.String r5 = "setSupportZoom error"
            com.bytedance.sdk.openadsdk.bk.r.c(r0, r5, r4)
        L25:
            r1.setLoadWithOverviewMode(r2)
            r1.setUseWideViewPort(r2)
            r1.setDomStorageEnabled(r2)
            r1.setAllowFileAccess(r3)
            r1.setBlockNetworkImage(r3)
            r1.setDisplayZoomControls(r3)
            int r4 = android.os.Build.VERSION.SDK_INT
            r1.setAllowFileAccessFromFileURLs(r3)
            r1.setAllowUniversalAccessFromFileURLs(r3)
            r1.setSavePassword(r3)
            r1 = 28
            if (r4 < r1) goto L47
            goto L48
        L47:
            r2 = 0
        L48:
            r1 = 0
            if (r2 != 0) goto L51
            r6.setLayerType(r3, r1)     // Catch: java.lang.Throwable -> L4f
            goto L5d
        L4f:
            r1 = move-exception
            goto L58
        L51:
            if (r2 == 0) goto L5d
            r2 = 2
            r6.setLayerType(r2, r1)     // Catch: java.lang.Throwable -> L4f
            goto L5d
        L58:
            java.lang.String r2 = "setLayerType error"
            com.bytedance.sdk.openadsdk.bk.r.c(r0, r2, r1)
        L5d:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 < r1) goto L6a
            android.webkit.WebSettings r6 = r6.getSettings()
            r6.setMixedContentMode(r3)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.bk.gd.c(android.webkit.WebView):void");
    }
}
