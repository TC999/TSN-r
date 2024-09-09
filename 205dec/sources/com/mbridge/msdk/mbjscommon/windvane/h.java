package com.mbridge.msdk.mbjscommon.windvane;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import org.json.JSONObject;

/* compiled from: WindVaneCallJs.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static h f40350a = new h();

    private h() {
    }

    public static h a() {
        return f40350a;
    }

    public final void b(Object obj, String str) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (TextUtils.isEmpty(str)) {
                String.format("javascript:window.WindVane.onFailure(%s,'');", aVar.f40332g);
            } else {
                str = k.c(str);
            }
            String format = String.format("javascript:window.WindVane.onFailure(%s,'%s');", aVar.f40332g, str);
            WindVaneWebView windVaneWebView = aVar.f40326a;
            if (windVaneWebView == null || windVaneWebView.isDestoryed()) {
                return;
            }
            try {
                aVar.f40326a.loadUrl(format);
            } catch (Exception e4) {
                e4.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(Object obj, String str, String str2) {
        String format;
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (TextUtils.isEmpty(str2)) {
                format = String.format("javascript:window.WindVane.fireEvent('%s', '');", str);
            } else {
                format = String.format("javascript:window.WindVane.fireEvent('%s','%s');", str, k.c(str2));
            }
            WindVaneWebView windVaneWebView = aVar.f40326a;
            if (windVaneWebView == null || windVaneWebView.isDestoryed()) {
                return;
            }
            try {
                aVar.f40326a.loadUrl(format);
            } catch (Exception e4) {
                e4.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(WebView webView, String str, String str2) {
        String format;
        if (TextUtils.isEmpty(str2)) {
            format = String.format("javascript:window.WindVane.fireEvent('%s', '');", str);
        } else {
            format = String.format("javascript:window.WindVane.fireEvent('%s','%s');", str, k.c(str2));
        }
        if (webView != null) {
            if ((webView instanceof WindVaneWebView) && ((WindVaneWebView) webView).isDestoryed()) {
                return;
            }
            try {
                webView.loadUrl(format);
            } catch (Exception e4) {
                e4.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(Object obj, String str) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            String format = TextUtils.isEmpty(str) ? String.format("javascript:window.WindVane.onSuccess(%s,'');", aVar.f40332g) : String.format("javascript:window.WindVane.onSuccess(%s,'%s');", aVar.f40332g, k.c(str));
            WindVaneWebView windVaneWebView = aVar.f40326a;
            if (windVaneWebView == null || windVaneWebView.isDestoryed()) {
                return;
            }
            try {
                aVar.f40326a.loadUrl(format);
            } catch (Exception e4) {
                e4.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(WebView webView) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("api_version", "1.0.0");
            f40350a.a(webView, "onJSBridgeConnected", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception unused) {
            f40350a.a(webView, "onJSBridgeConnected", "");
        } catch (Throwable unused2) {
            f40350a.a(webView, "onJSBridgeConnected", "");
        }
    }
}
