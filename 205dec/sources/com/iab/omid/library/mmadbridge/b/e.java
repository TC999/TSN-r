package com.iab.omid.library.mmadbridge.b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.mmadbridge.adsession.ErrorType;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f37721a = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebView f37722a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f37723b;

        a(WebView webView, String str) {
            this.f37722a = webView;
            this.f37723b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f37722a.loadUrl(this.f37723b);
        }
    }

    private e() {
    }

    public static final e a() {
        return f37721a;
    }

    public void b(WebView webView) {
        h(webView, "finishSession", new Object[0]);
    }

    public void c(WebView webView, float f4) {
        h(webView, "setDeviceVolume", Float.valueOf(f4));
    }

    public void d(WebView webView, ErrorType errorType, String str) {
        h(webView, "error", errorType.toString(), str);
    }

    public void e(WebView webView, String str, String str2) {
        if (str == null || TextUtils.isEmpty(str2)) {
            return;
        }
        l(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};this.omidVerificationProperties.injectionId = '%INJECTION_ID%';var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", str).replace("%INJECTION_ID%", str2));
    }

    public void f(WebView webView, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            h(webView, "publishMediaEvent", str, jSONObject);
        } else {
            h(webView, "publishMediaEvent", str);
        }
    }

    public void g(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        h(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    @VisibleForTesting
    void h(WebView webView, String str, Object... objArr) {
        if (webView == null) {
            com.iab.omid.library.mmadbridge.d.c.a("The WebView is null for " + str);
            return;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
        sb.append(str);
        sb.append("(");
        k(sb, objArr);
        sb.append(")}");
        i(webView, sb);
    }

    @VisibleForTesting
    void i(WebView webView, StringBuilder sb) {
        String sb2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            webView.loadUrl(sb2);
        } else {
            handler.post(new a(webView, sb2));
        }
    }

    public void j(WebView webView, JSONObject jSONObject) {
        h(webView, "init", jSONObject);
    }

    @VisibleForTesting
    void k(StringBuilder sb, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                sb.append('\"');
            } else {
                if (obj instanceof String) {
                    String obj2 = obj.toString();
                    if (obj2.startsWith("{")) {
                        sb.append(obj2);
                    } else {
                        sb.append('\"');
                        sb.append(obj2);
                    }
                } else {
                    sb.append(obj);
                }
                sb.append(",");
            }
            sb.append('\"');
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
    }

    public boolean l(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        webView.loadUrl("javascript: " + str);
        return true;
    }

    public void m(WebView webView) {
        h(webView, "publishImpressionEvent", new Object[0]);
    }

    public void n(WebView webView, String str) {
        h(webView, "setNativeViewHierarchy", str);
    }

    public void o(WebView webView, @NonNull JSONObject jSONObject) {
        h(webView, "publishLoadedEvent", jSONObject);
    }

    public void p(WebView webView) {
        h(webView, "publishLoadedEvent", new Object[0]);
    }

    public void q(WebView webView, String str) {
        h(webView, "setState", str);
    }
}
