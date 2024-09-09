package com.bytedance.sdk.openadsdk.core.component.reward.endcard;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bykv.vk.openvk.component.video.c.ux.w;
import com.bytedance.sdk.component.adexpress.w.t;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.sr.ux;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.p.xv.k;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.xk;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends c {
    private double ba;
    private final com.bytedance.sdk.openadsdk.gd.c ck;
    private double eq;
    private double me;

    /* renamed from: n  reason: collision with root package name */
    private final Map<String, Bitmap> f32341n;
    private String wv;
    private boolean xk;

    /* renamed from: y  reason: collision with root package name */
    private double f32342y;

    /* renamed from: z  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.ia.w f32343z;

    public w(TTBaseVideoActivity tTBaseVideoActivity, me meVar, String str, int i4, int i5, boolean z3, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        super(tTBaseVideoActivity, meVar, str, i4, i5, z3);
        this.f32341n = new HashMap();
        this.ck = new com.bytedance.sdk.openadsdk.gd.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.w.1
            @Override // com.bytedance.sdk.openadsdk.gd.c
            public void c() {
                w.this.f32313c.gd(1);
            }
        };
        this.f32343z = new com.bytedance.sdk.openadsdk.core.ia.w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.w.2
            @Override // com.bytedance.sdk.openadsdk.core.ia.w
            public void c(boolean z4, int i6, String str2) {
                a.w("end card load finish: ", "code=" + i6 + " msg=" + str2 + " isRenderSuc=" + z4);
                if (z4) {
                    w wVar = w.this;
                    wVar.ia = true;
                    if (wVar.xk) {
                        w wVar2 = w.this;
                        wVar2.c(wVar2.ba, w.this.f32342y, w.this.eq, w.this.me, w.this.wv);
                        w.this.xk = false;
                    }
                }
                if (ng.gd(w.this.f32324w)) {
                    a.w("CommonEndCard", "TimeTrackLog report from js " + z4);
                    w.this.c(z4, i6, str2);
                }
            }
        };
        this.ev = abstractEndCardFrameLayout.getEndCardWebView();
        c();
    }

    private void z() {
        this.f32317k = ng.r(this.f32324w);
        float yx = this.f32324w.yx();
        if (TextUtils.isEmpty(this.f32317k)) {
            return;
        }
        if (this.f32323u == 1) {
            if (this.f32317k.contains("?")) {
                this.f32317k += "&orientation=portrait";
            } else {
                this.f32317k += "?orientation=portrait";
            }
        }
        if (this.f32317k.contains("?")) {
            this.f32317k += "&height=" + this.f32319q + "&width=" + this.f32315i + "&aspect_ratio=" + yx;
        } else {
            this.f32317k += "?height=" + this.f32319q + "&width=" + this.f32315i + "&aspect_ratio=" + yx;
        }
        this.f32317k = com.bytedance.sdk.openadsdk.core.component.reward.ux.c.c(this.f32317k);
    }

    public void ck() {
        SSWebView sSWebView;
        if (this.fp || (sSWebView = this.ev) == null) {
            return;
        }
        sSWebView.c(this.f32317k);
        this.fp = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public String ls() {
        return CampaignEx.JSON_NATIVE_VIDEO_ENDCARD;
    }

    protected boolean n() {
        String str = this.f32317k;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public void ys() {
        super.ys();
        this.f32341n.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public void c(boolean z3, Map<String, Object> map, View view) {
        SSWebView sSWebView = this.ev;
        if (sSWebView == null || sSWebView.getWebView() == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        r rVar = new r(this.xv, this.f32324w, jSONObject);
        this.f32318p = rVar;
        rVar.c(jSONObject, "webview_source", (Object) 2);
        com.bytedance.sdk.openadsdk.core.a.sr w3 = new com.bytedance.sdk.openadsdk.core.a.sr(this.f32324w, this.ev.getWebView()).w(true);
        this.bk = w3;
        w3.c(true);
        z();
        this.bk.c(n() ? "landingpage_endcard" : z3 ? "reward_endcard" : "fullscreen_endcard");
        xk xkVar = new xk(this.f32313c);
        this.gd = xkVar;
        xkVar.w(this.ev).c(this.f32324w).w(this.f32324w.jr()).xv(this.f32324w.cf()).xv(z3 ? 7 : 5).c(this.ls).sr(wv.t(this.f32324w)).c(this.ev).w(k.c(this.f32324w)).c(this.f32318p).c(this.xv).c(map).c(this.gb).c(view).c(this.ck);
        this.gd.c(this.f32343z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public void c(DownloadListener downloadListener, com.bytedance.sdk.openadsdk.core.w.w wVar) {
        if (this.ev == null) {
            return;
        }
        this.ux = com.bytedance.sdk.openadsdk.core.t.c.c().c(this.f32324w);
        com.bytedance.sdk.openadsdk.core.widget.c.sr srVar = new com.bytedance.sdk.openadsdk.core.widget.c.sr(this.f32313c, this.gd, this.f32324w.jr(), this.bk) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.w.3
            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                r rVar = w.this.f32318p;
                if (rVar != null) {
                    rVar.r();
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                r rVar = w.this.f32318p;
                if (rVar != null) {
                    rVar.f();
                }
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i4, String str, String str2) {
                w.this.f32321s.set(false);
                w.this.fz = this.ev;
                w wVar2 = w.this;
                wVar2.f32322t = i4;
                wVar2.ys = str;
                if (wVar2.f32318p != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put("code", i4);
                            jSONObject.put("msg", str);
                        }
                        w.this.f32318p.c(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i4, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (w.this.f32318p != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 21) {
                            jSONObject.put("code", webResourceResponse.getStatusCode());
                            jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                        }
                        w.this.f32318p.c(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (w.this.f32317k.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        w.this.f32321s.set(false);
                        w.this.fz = this.ev;
                    }
                    if (webResourceResponse != null) {
                        w.this.f32322t = webResourceResponse.getStatusCode();
                        w.this.ys = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse c4 = w.this.c(str);
                return c4 != null ? c4 : super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String uri = webResourceRequest.getUrl().toString();
                    w wVar2 = w.this;
                    if (wVar2.f32324w != null) {
                        WebResourceResponse c4 = wVar2.c(uri);
                        if (c4 != null) {
                            return c4;
                        }
                        if (TextUtils.isEmpty(w.this.f32324w.jd())) {
                            return super.shouldInterceptRequest(webView, uri);
                        }
                        w.this.f32314f++;
                        com.bytedance.sdk.openadsdk.core.t.c c5 = com.bytedance.sdk.openadsdk.core.t.c.c();
                        w wVar3 = w.this;
                        WebResourceResponse c6 = c5.c(wVar3.ux, wVar3.f32324w, uri);
                        if (c6 != null) {
                            w.this.f32320r++;
                            return c6;
                        }
                        return super.shouldInterceptRequest(webView, uri);
                    }
                    return super.shouldInterceptRequest(webView, uri);
                } catch (Throwable th) {
                    a.xv("CommonEndCard", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    w.this.f32321s.set(false);
                    w.this.fz = this.ev;
                }
                if (w.this.f32318p != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put("code", webResourceError.getErrorCode());
                            jSONObject.put("msg", webResourceError.getDescription());
                        }
                        w.this.f32318p.c(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                w.this.f32322t = webResourceError.getErrorCode();
                w.this.ys = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        };
        this.f32312a = srVar;
        this.ev.setWebViewClient(srVar);
        c(this.ev);
        this.ev.setBackgroundColor(-1);
        this.ev.setDisplayZoomControls(false);
        this.ev.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.c.xv(this.gd, this.bk) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.w.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.c.xv, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i4) {
                super.onProgressChanged(webView, i4);
            }
        });
        this.ev.setDownloadListener(downloadListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.c
    public void c(int i4) {
        super.c(i4);
        c(true);
        xv(true);
        c(false, true);
    }

    public void c(double d4, double d5, double d6, double d7, String str) {
        if (this.gd == null || this.f32313c.isFinishing()) {
            return;
        }
        if (!this.ia) {
            this.ba = d4;
            this.f32342y = d5;
            this.me = d7;
            this.eq = d6;
            this.wv = str;
            this.xk = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", d4);
            jSONObject.put("y", d5);
            jSONObject.put("width", d6);
            jSONObject.put("height", d7);
            jSONObject.put("videoFrameKey", str);
            this.gd.c("endcardTransform", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void c(t tVar) {
        double d4;
        double d5;
        double d6;
        double d7;
        if (m.ls(this.f32324w)) {
            double d8 = this.f32315i;
            double d9 = this.f32319q;
            if (tVar == null || !this.f32313c.b().r() || (tVar.ev() == 0.0d && tVar.gd() == 0.0d)) {
                d4 = d8;
                d5 = d9;
                d6 = 0.0d;
                d7 = 0.0d;
            } else {
                double f4 = tVar.f();
                d6 = f4;
                d7 = tVar.r();
                d4 = tVar.ev();
                d5 = tVar.gd();
            }
            c(d6, d7, d4, d5, null);
            if (this.f32313c.b() instanceof ux) {
                return;
            }
            final double d10 = d6;
            final double d11 = d7;
            final double d12 = d4;
            final double d13 = d5;
            com.bykv.vk.openvk.component.video.c.ux.w.c(2147483647L, ng.c(this.f32324w), new w.InterfaceC0338w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.w.5
                @Override // com.bykv.vk.openvk.component.video.c.ux.w.InterfaceC0338w
                public void c(Bitmap bitmap) {
                    if (bitmap != null) {
                        String valueOf = String.valueOf(bitmap.hashCode());
                        w.this.f32341n.put(valueOf, bitmap);
                        w.this.c(d10, d11, d12, d13, valueOf);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse c(String str) {
        if (str.startsWith("csjclientimg://")) {
            Bitmap bitmap = this.f32341n.get(str.replace("csjclientimg://", ""));
            if (bitmap != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                return new WebResourceResponse("text/html", "UTF-8", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            }
            return null;
        }
        return null;
    }
}
