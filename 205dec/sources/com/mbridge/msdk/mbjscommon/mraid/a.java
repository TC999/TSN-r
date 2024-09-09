package com.mbridge.msdk.mbjscommon.mraid;

import android.webkit.WebView;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: CallMraidJS.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CallMraidJS.java */
    /* renamed from: com.mbridge.msdk.mbjscommon.mraid.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0751a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f40293a = new a();
    }

    public static a a() {
        return C0751a.f40293a;
    }

    public final void b(WebView webView, float f4, float f5) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setScreenSize(%.1f, %.1f);", Float.valueOf(f4), Float.valueOf(f5)));
    }

    public final void c(WebView webView, float f4, float f5) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setMaxSize(%.1f, %.1f);", Float.valueOf(f4), Float.valueOf(f5)));
    }

    public final void a(WebView webView) {
        c(webView, "javascript:window.mraidbridge.fireReadyEvent();");
    }

    private void c(WebView webView, String str) {
        if (webView != null) {
            try {
                webView.loadUrl(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(WebView webView, Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        c(webView, String.format("javascript:window.mraidbridge.fireChangeEvent(%s);", jSONObject.toString()));
    }

    public final void b(WebView webView, float f4, float f5, float f6, float f7) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setCurrentPosition(%.1f, %.1f, %.1f, %.1f);", Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)));
    }

    public final void b(WebView webView, String str) {
        c(webView, String.format("javascript:window.mraidbridge.setIsViewable(%s);", str));
    }

    public final void a(WebView webView, String str, String str2) {
        c(webView, String.format("javascript:window.mraidbridge.fireErrorEvent('%1s', '%2s');", str2, str));
    }

    public final void a(WebView webView, float f4, float f5) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.notifySizeChangeEvent(%.1f, %.1f);", Float.valueOf(f4), Float.valueOf(f5)));
    }

    public final void a(WebView webView, double d4) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.audioVolumeChange(%s);", Double.valueOf(d4)));
    }

    public final void a(WebView webView, float f4, float f5, float f6, float f7) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setDefaultPosition(%.1f, %.1f, %.1f, %.1f);", Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)));
    }

    public final void a(WebView webView, String str) {
        c(webView, String.format("javascript:window.mraidbridge.nativeCallComplete('%s');", str));
    }
}
