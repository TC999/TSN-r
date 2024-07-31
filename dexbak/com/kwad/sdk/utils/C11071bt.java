package com.kwad.sdk.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.utils.bt */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11071bt {
    /* renamed from: a */
    public static void m23845a(WebView webView, String str, String str2) {
        m23846a(webView, "javascript:" + str + "(" + JSONObject.quote(str2) + ")", (ValueCallback<String>) null);
    }

    private static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    /* renamed from: a */
    private static void m23846a(final WebView webView, final String str, ValueCallback<String> valueCallback) {
        if (Build.VERSION.SDK_INT >= 19) {
            runOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.bt.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        webView.evaluateJavascript(str, r3);
                    } catch (Exception unused) {
                    }
                }
            });
        } else {
            webView.loadUrl(str);
        }
    }
}
