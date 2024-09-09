package com.bytedance.sdk.component.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k {

    /* renamed from: c  reason: collision with root package name */
    private static final c f30196c;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class c {
        private c() {
        }

        public void c(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    @TargetApi(19)
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class w extends c {
        private w() {
            super();
        }

        @Override // com.bytedance.sdk.component.utils.k.c
        public void c(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            boolean z3 = false;
            if (str != null && str.startsWith("javascript:")) {
                try {
                    webView.evaluateJavascript(str, null);
                    z3 = true;
                } catch (Throwable th) {
                    boolean z4 = th instanceof IllegalStateException;
                }
            }
            if (z3) {
                return;
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f30196c = new w();
        } else {
            f30196c = new c();
        }
    }

    public static void c(WebView webView, String str) {
        f30196c.c(webView, str);
    }
}
