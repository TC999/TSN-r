package com.iab.omid.library.mmadbridge.p202b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.mmadbridge.adsession.ErrorType;
import com.iab.omid.library.mmadbridge.p204d.C7103c;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mmadbridge.b.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7090e {

    /* renamed from: a */
    private static C7090e f24239a = new C7090e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.iab.omid.library.mmadbridge.b.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class RunnableC7091a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ WebView f24240a;

        /* renamed from: b */
        final /* synthetic */ String f24241b;

        RunnableC7091a(WebView webView, String str) {
            this.f24240a = webView;
            this.f24241b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f24240a.loadUrl(this.f24241b);
        }
    }

    private C7090e() {
    }

    /* renamed from: a */
    public static final C7090e m34735a() {
        return f24239a;
    }

    /* renamed from: b */
    public void m34734b(WebView webView) {
        m34728h(webView, "finishSession", new Object[0]);
    }

    /* renamed from: c */
    public void m34733c(WebView webView, float f) {
        m34728h(webView, "setDeviceVolume", Float.valueOf(f));
    }

    /* renamed from: d */
    public void m34732d(WebView webView, ErrorType errorType, String str) {
        m34728h(webView, "error", errorType.toString(), str);
    }

    /* renamed from: e */
    public void m34731e(WebView webView, String str, String str2) {
        if (str == null || TextUtils.isEmpty(str2)) {
            return;
        }
        m34724l(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};this.omidVerificationProperties.injectionId = '%INJECTION_ID%';var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", str).replace("%INJECTION_ID%", str2));
    }

    /* renamed from: f */
    public void m34730f(WebView webView, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            m34728h(webView, "publishMediaEvent", str, jSONObject);
        } else {
            m34728h(webView, "publishMediaEvent", str);
        }
    }

    /* renamed from: g */
    public void m34729g(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        m34728h(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    @VisibleForTesting
    /* renamed from: h */
    void m34728h(WebView webView, String str, Object... objArr) {
        if (webView == null) {
            C7103c.m34677a("The WebView is null for " + str);
            return;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
        sb.append(str);
        sb.append("(");
        m34725k(sb, objArr);
        sb.append(")}");
        m34727i(webView, sb);
    }

    @VisibleForTesting
    /* renamed from: i */
    void m34727i(WebView webView, StringBuilder sb) {
        String sb2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            webView.loadUrl(sb2);
        } else {
            handler.post(new RunnableC7091a(webView, sb2));
        }
    }

    /* renamed from: j */
    public void m34726j(WebView webView, JSONObject jSONObject) {
        m34728h(webView, "init", jSONObject);
    }

    @VisibleForTesting
    /* renamed from: k */
    void m34725k(StringBuilder sb, Object[] objArr) {
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

    /* renamed from: l */
    public boolean m34724l(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        webView.loadUrl("javascript: " + str);
        return true;
    }

    /* renamed from: m */
    public void m34723m(WebView webView) {
        m34728h(webView, "publishImpressionEvent", new Object[0]);
    }

    /* renamed from: n */
    public void m34722n(WebView webView, String str) {
        m34728h(webView, "setNativeViewHierarchy", str);
    }

    /* renamed from: o */
    public void m34721o(WebView webView, @NonNull JSONObject jSONObject) {
        m34728h(webView, "publishLoadedEvent", jSONObject);
    }

    /* renamed from: p */
    public void m34720p(WebView webView) {
        m34728h(webView, "publishLoadedEvent", new Object[0]);
    }

    /* renamed from: q */
    public void m34719q(WebView webView, String str) {
        m34728h(webView, "setState", str);
    }
}
