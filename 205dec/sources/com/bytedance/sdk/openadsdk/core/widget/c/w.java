package com.bytedance.sdk.openadsdk.core.widget.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.a;
import java.lang.ref.WeakReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<Context> f35405c;

    /* renamed from: w  reason: collision with root package name */
    private boolean f35408w = true;
    private boolean xv = true;
    private boolean sr = true;
    private boolean ux = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f35406f = true;

    /* renamed from: r  reason: collision with root package name */
    private boolean f35407r = true;
    private boolean ev = true;

    private w(Context context) {
        this.f35405c = new WeakReference<>(context);
    }

    public static w c(Context context) {
        return new w(context);
    }

    public w w(boolean z3) {
        this.xv = z3;
        return this;
    }

    private void w(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            a.xv(th.toString());
        }
    }

    public w c(boolean z3) {
        this.ev = z3;
        return this;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0067 -> B:39:0x006a). Please submit an issue!!! */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void c(WebView webView) {
        if (webView == null || this.f35405c.get() == null) {
            return;
        }
        w(webView);
        WebSettings settings = webView.getSettings();
        c(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            if (this.xv) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(this.sr);
        settings.setDomStorageEnabled(this.ux);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(true ^ this.f35407r);
        settings.setDisplayZoomControls(false);
        if (Build.VERSION.SDK_INT < 28) {
            this.ev = false;
        }
        try {
            boolean z3 = this.ev;
            if (!z3) {
                webView.setLayerType(0, null);
            } else if (z3) {
                webView.setLayerType(2, null);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void c(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            a.xv(th.toString());
        }
    }

    public static String c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || "0".equals(str2) || !str.contains("{{ad_id}}")) {
            return null;
        }
        String replace = str.replace("{{ad_id}}", str2);
        return "javascript:(function () {    var JS_ACTLOG_URL = '" + replace + "';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head.appendChild(script);})();";
    }
}
