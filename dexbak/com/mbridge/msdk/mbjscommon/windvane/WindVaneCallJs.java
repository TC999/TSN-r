package com.mbridge.msdk.mbjscommon.windvane;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.mbjscommon.windvane.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class WindVaneCallJs {

    /* renamed from: a */
    private static WindVaneCallJs f31578a = new WindVaneCallJs();

    private WindVaneCallJs() {
    }

    /* renamed from: a */
    public static WindVaneCallJs m21387a() {
        return f31578a;
    }

    /* renamed from: b */
    public final void m21382b(Object obj, String str) {
        if (obj instanceof CallMethodContext) {
            CallMethodContext callMethodContext = (CallMethodContext) obj;
            if (TextUtils.isEmpty(str)) {
                String.format("javascript:window.WindVane.onFailure(%s,'');", callMethodContext.f31560g);
            } else {
                str = WindVaneUtil.m21376c(str);
            }
            String format = String.format("javascript:window.WindVane.onFailure(%s,'%s');", callMethodContext.f31560g, str);
            WindVaneWebView windVaneWebView = callMethodContext.f31554a;
            if (windVaneWebView == null || windVaneWebView.isDestoryed()) {
                return;
            }
            try {
                callMethodContext.f31554a.loadUrl(format);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m21383a(Object obj, String str, String str2) {
        String format;
        if (obj instanceof CallMethodContext) {
            CallMethodContext callMethodContext = (CallMethodContext) obj;
            if (TextUtils.isEmpty(str2)) {
                format = String.format("javascript:window.WindVane.fireEvent('%s', '');", str);
            } else {
                format = String.format("javascript:window.WindVane.fireEvent('%s','%s');", str, WindVaneUtil.m21376c(str2));
            }
            WindVaneWebView windVaneWebView = callMethodContext.f31554a;
            if (windVaneWebView == null || windVaneWebView.isDestoryed()) {
                return;
            }
            try {
                callMethodContext.f31554a.loadUrl(format);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m21385a(WebView webView, String str, String str2) {
        String format;
        if (TextUtils.isEmpty(str2)) {
            format = String.format("javascript:window.WindVane.fireEvent('%s', '');", str);
        } else {
            format = String.format("javascript:window.WindVane.fireEvent('%s','%s');", str, WindVaneUtil.m21376c(str2));
        }
        if (webView != null) {
            if ((webView instanceof WindVaneWebView) && ((WindVaneWebView) webView).isDestoryed()) {
                return;
            }
            try {
                webView.loadUrl(format);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m21384a(Object obj, String str) {
        if (obj instanceof CallMethodContext) {
            CallMethodContext callMethodContext = (CallMethodContext) obj;
            String format = TextUtils.isEmpty(str) ? String.format("javascript:window.WindVane.onSuccess(%s,'');", callMethodContext.f31560g) : String.format("javascript:window.WindVane.onSuccess(%s,'%s');", callMethodContext.f31560g, WindVaneUtil.m21376c(str));
            WindVaneWebView windVaneWebView = callMethodContext.f31554a;
            if (windVaneWebView == null || windVaneWebView.isDestoryed()) {
                return;
            }
            try {
                callMethodContext.f31554a.loadUrl(format);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m21386a(WebView webView) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("api_version", "1.0.0");
            f31578a.m21385a(webView, "onJSBridgeConnected", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception unused) {
            f31578a.m21385a(webView, "onJSBridgeConnected", "");
        } catch (Throwable unused2) {
            f31578a.m21385a(webView, "onJSBridgeConnected", "");
        }
    }
}
