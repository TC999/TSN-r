package com.bytedance.sdk.openadsdk.core.a;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: f  reason: collision with root package name */
    private final me f31738f;
    private WebView fp;
    private com.bytedance.sdk.openadsdk.ux.c fz;

    /* renamed from: j  reason: collision with root package name */
    private long f31740j;
    private WeakReference<w> ls;

    /* renamed from: s  reason: collision with root package name */
    private JSONObject f31745s;
    private String sr;
    private String ux;

    /* renamed from: c  reason: collision with root package name */
    private int f31737c = 0;

    /* renamed from: w  reason: collision with root package name */
    private volatile boolean f31748w = false;
    private int xv = -1;

    /* renamed from: r  reason: collision with root package name */
    private String f31744r = "landingpage";
    private long ev = 0;
    private long gd = 0;

    /* renamed from: p  reason: collision with root package name */
    private long f31742p = 0;

    /* renamed from: k  reason: collision with root package name */
    private long f31741k = 0;

    /* renamed from: a  reason: collision with root package name */
    private long f31736a = 0;
    private long bk = 0;

    /* renamed from: t  reason: collision with root package name */
    private boolean f31746t = false;
    private AtomicInteger ys = new AtomicInteger(0);
    private boolean ia = false;

    /* renamed from: u  reason: collision with root package name */
    private AtomicBoolean f31747u = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    private boolean f31739i = false;

    /* renamed from: q  reason: collision with root package name */
    private boolean f31743q = true;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class c {

        /* renamed from: c  reason: collision with root package name */
        private final WebView f31751c;

        /* renamed from: w  reason: collision with root package name */
        private final AtomicInteger f31752w;
        private final WeakReference<w> xv;

        c(WebView webView, AtomicInteger atomicInteger, WeakReference<w> weakReference) {
            this.f31751c = webView;
            this.f31752w = atomicInteger;
            this.xv = weakReference;
        }

        @JavascriptInterface
        public String getUrl() {
            return "";
        }

        @JavascriptInterface
        public void readHtml(String str, String str2) {
        }

        @JavascriptInterface
        public void readPercent(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("measure height: ");
            WebView webView = this.f31751c;
            int i4 = 0;
            sb.append(webView == null ? 0 : webView.getMeasuredHeight());
            a.w("LandingPageLog", sb.toString());
            a.w("LandingPageLog", "read percent: " + String.valueOf(str));
            try {
                int intValue = Float.valueOf(str).intValue();
                if (intValue > 100) {
                    i4 = 100;
                } else if (intValue >= 0) {
                    i4 = intValue;
                }
            } catch (Throwable unused) {
            }
            AtomicInteger atomicInteger = this.f31752w;
            if (atomicInteger != null) {
                atomicInteger.set(i4);
            }
            WeakReference<w> weakReference = this.xv;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.xv.get().c(str);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        void c(String str);
    }

    public sr(me meVar, WebView webView) {
        this.f31738f = meVar;
        this.fp = webView;
        if (webView != null) {
            webView.addJavascriptInterface(new c(webView, this.ys, this.ls), "JS_LANDING_PAGE_LOG_OBJ");
        }
        this.f31740j = System.currentTimeMillis();
    }

    public void c(w wVar) {
        this.ls = new WeakReference<>(wVar);
    }

    public void sr() {
        a.w("LandingPageLog", "onStop");
        if (this.f31743q) {
            this.f31743q = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_START, this.f31740j);
                jSONObject.put("end", System.currentTimeMillis());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            xv.c(this.f31738f, "landingpage", "agg_stay_page", new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.a.sr.1
                @Override // com.bytedance.sdk.openadsdk.ux.c.c
                public void c(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put("ad_extra_data", jSONObject);
                }
            });
        }
        if (this.f31737c == 2) {
            if (this.f31742p > 0 || !c()) {
                long currentTimeMillis = System.currentTimeMillis();
                this.gd = currentTimeMillis;
                long max = currentTimeMillis - Math.max(this.ev, this.f31742p);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("load_status", this.f31737c);
                    jSONObject2.put("max_scroll_percent", this.ys.get());
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                } catch (JSONException unused) {
                }
                c("stay_page", jSONObject2, Math.min(max, 600000L));
            }
        }
    }

    public void ux() {
        a.w("LandingPageLog", "onDestroy");
        WebView webView = this.fp;
        if (webView != null) {
            webView.removeJavascriptInterface("JS_LANDING_PAGE_LOG_OBJ");
        }
        this.fp = null;
        if (this.f31747u.get() || !this.f31748w) {
            return;
        }
        xv.xv(this.f31738f, this.f31744r, System.currentTimeMillis() - this.bk);
    }

    public com.bytedance.sdk.openadsdk.ux.c w() {
        return this.fz;
    }

    public void xv() {
        a.w("LandingPageLog", "onResume");
        this.ev = System.currentTimeMillis();
        if (this.bk == 0) {
            this.bk = System.currentTimeMillis();
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f31744r = str;
    }

    public sr w(boolean z3) {
        this.ia = z3;
        return this;
    }

    public void c(long j4) {
        this.f31742p = j4;
    }

    public boolean c() {
        return this.f31739i;
    }

    public void c(boolean z3) {
        this.f31739i = z3;
    }

    public void c(com.bytedance.sdk.openadsdk.ux.c cVar) {
        this.fz = cVar;
    }

    public void c(JSONObject jSONObject) {
        this.f31745s = jSONObject;
    }

    public void c(WebView webView, int i4) {
        a.w("LandingPageLog", "onWebProgress: " + i4);
        if (this.f31741k == 0 && i4 > 0) {
            this.f31737c = 1;
            this.f31741k = System.currentTimeMillis();
        } else if (this.f31736a == 0 && i4 == 100) {
            this.f31736a = System.currentTimeMillis();
        }
    }

    public void c(WebView webView, String str, Bitmap bitmap) {
        a.w("LandingPageLog", "onWebStarted: " + String.valueOf(str));
        com.bytedance.sdk.openadsdk.ux.c cVar = this.fz;
        if (cVar != null) {
            cVar.f();
        }
        if (this.f31748w) {
            return;
        }
        this.bk = System.currentTimeMillis();
        this.f31748w = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (Exception unused) {
        }
        c("load_start", jSONObject);
    }

    public void c(WebView webView, String str) {
        a.w("LandingPageLog", "onWebFinished: " + String.valueOf(str));
        com.bytedance.sdk.openadsdk.ux.c cVar = this.fz;
        if (cVar != null) {
            cVar.r();
        }
        if (webView != null && !this.f31746t && this.ia) {
            this.f31746t = true;
            k.c(webView, "javascript:\n    function sendScroll() {\n        try {\n            var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n            var clientH = window.innerHeight || document.documentElement.clientHeight;\n            var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n            var validH = scrollH + clientH;\n            var result = (validH / totalH * 100).toFixed(2);\n            console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n            window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n        } catch (e) {\n            console.log('sendScroll error' + e)\n        }\n    }\nsendScroll();\nwindow.addEventListener('scroll', function (e) {\n    sendScroll();\n});");
        }
        if (this.f31747u.get()) {
            return;
        }
        if (this.f31737c != 3) {
            this.f31737c = 2;
        }
        this.f31747u.set(true);
        this.ev = System.currentTimeMillis();
        if (this.f31737c == 2) {
            long j4 = this.f31736a - this.f31741k;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", this.xv);
                jSONObject.put("error_msg", this.sr);
                jSONObject.put("error_url", this.ux);
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
            } catch (Exception unused) {
            }
            c("load_finish", jSONObject, Math.min(j4, 600000L));
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("error_code", this.xv);
            jSONObject2.put("error_msg", this.sr);
            jSONObject2.put("error_url", this.ux);
            jSONObject2.putOpt("render_type", "h5");
            jSONObject2.putOpt("render_type_2", 0);
        } catch (Exception unused2) {
        }
        c("load_fail", jSONObject2);
    }

    public void c(int i4, String str, String str2, String str3) {
        a.w("LandingPageLog", "onWebError: " + i4 + ", " + str + ", " + str2 + "\uff0c" + str3);
        com.bytedance.sdk.openadsdk.ux.c cVar = this.fz;
        if (cVar != null) {
            cVar.ev();
        }
        if (!(str3 != null && str3.startsWith("image")) && this.f31737c != 2) {
            this.f31737c = 3;
        }
        this.xv = i4;
        this.sr = str;
        this.ux = str2;
    }

    public void c(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url;
        if (webResourceRequest == null) {
            return;
        }
        String str = null;
        if (Build.VERSION.SDK_INT >= 21 && (url = webResourceRequest.getUrl()) != null) {
            str = url.toString();
        }
        TextUtils.isEmpty(str);
    }

    private void c(String str, JSONObject jSONObject) {
        c(str, jSONObject, -1L);
    }

    private void c(String str, JSONObject jSONObject, long j4) {
        if (!this.ia || this.f31738f == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                int i4 = 1;
                jSONObject.put("is_playable", u.xv(this.f31738f) ? 1 : 0);
                if (!com.bytedance.sdk.openadsdk.core.playable.c.c().c(this.f31738f)) {
                    i4 = 0;
                }
                jSONObject.put("usecache", i4);
            } catch (JSONException unused) {
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("ad_extra_data", jSONObject.toString());
                    if (j4 > 0) {
                        jSONObject3.put("duration", j4);
                    }
                } catch (JSONException unused2) {
                }
                jSONObject2 = jSONObject3;
            } catch (JSONException unused3) {
            }
        }
        a.w("LandingPageLog", "sendEvent: " + String.valueOf(this.f31744r) + ", " + String.valueOf(str) + ", ext=" + String.valueOf(jSONObject2));
        xv.sr(this.f31738f, this.f31744r, str, jSONObject2);
    }
}
