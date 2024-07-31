package com.mbridge.msdk.mbjscommon.mraid;

import android.webkit.WebView;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.mbjscommon.mraid.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class CallMraidJS {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CallMraidJS.java */
    /* renamed from: com.mbridge.msdk.mbjscommon.mraid.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11499a {

        /* renamed from: a */
        private static final CallMraidJS f31521a = new CallMraidJS();
    }

    /* renamed from: a */
    public static CallMraidJS m21430a() {
        return C11499a.f31521a;
    }

    /* renamed from: b */
    public final void m21422b(WebView webView, float f, float f2) {
        m21418c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setScreenSize(%.1f, %.1f);", Float.valueOf(f), Float.valueOf(f2)));
    }

    /* renamed from: c */
    public final void m21419c(WebView webView, float f, float f2) {
        m21418c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setMaxSize(%.1f, %.1f);", Float.valueOf(f), Float.valueOf(f2)));
    }

    /* renamed from: a */
    public final void m21429a(WebView webView) {
        m21418c(webView, "javascript:window.mraidbridge.fireReadyEvent();");
    }

    /* renamed from: c */
    private void m21418c(WebView webView, String str) {
        if (webView != null) {
            try {
                webView.loadUrl(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m21423a(WebView webView, Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        m21418c(webView, String.format("javascript:window.mraidbridge.fireChangeEvent(%s);", jSONObject.toString()));
    }

    /* renamed from: b */
    public final void m21421b(WebView webView, float f, float f2, float f3, float f4) {
        m21418c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setCurrentPosition(%.1f, %.1f, %.1f, %.1f);", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
    }

    /* renamed from: b */
    public final void m21420b(WebView webView, String str) {
        m21418c(webView, String.format("javascript:window.mraidbridge.setIsViewable(%s);", str));
    }

    /* renamed from: a */
    public final void m21424a(WebView webView, String str, String str2) {
        m21418c(webView, String.format("javascript:window.mraidbridge.fireErrorEvent('%1s', '%2s');", str2, str));
    }

    /* renamed from: a */
    public final void m21427a(WebView webView, float f, float f2) {
        m21418c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.notifySizeChangeEvent(%.1f, %.1f);", Float.valueOf(f), Float.valueOf(f2)));
    }

    /* renamed from: a */
    public final void m21428a(WebView webView, double d) {
        m21418c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.audioVolumeChange(%s);", Double.valueOf(d)));
    }

    /* renamed from: a */
    public final void m21426a(WebView webView, float f, float f2, float f3, float f4) {
        m21418c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setDefaultPosition(%.1f, %.1f, %.1f, %.1f);", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
    }

    /* renamed from: a */
    public final void m21425a(WebView webView, String str) {
        m21418c(webView, String.format("javascript:window.mraidbridge.nativeCallComplete('%s');", str));
    }
}
