package com.bytedance.sdk.openadsdk.core.ev.c.w;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.a.xv;
import com.bytedance.sdk.openadsdk.core.bw;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.fz;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.xk;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

@com.bytedance.sdk.component.p.w.w
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r implements com.bytedance.sdk.component.p.c.c.xv {
    @com.bytedance.sdk.component.p.w.c(c = "end_card_height")
    private int ba;
    @com.bytedance.sdk.component.p.w.c(c = "activity")

    /* renamed from: c  reason: collision with root package name */
    protected TTBaseVideoActivity f33474c;
    @com.bytedance.sdk.component.p.w.c(c = "orientation")
    private int ck;
    protected com.bytedance.sdk.openadsdk.core.widget.c.sr ev;

    /* renamed from: f  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.a.r f33475f;
    @com.bytedance.sdk.component.p.w.c(c = "material_meta")
    private me fz;
    @com.bytedance.sdk.component.p.w.c(c = "show_type")
    private int gb;
    com.bytedance.sdk.openadsdk.core.a.sr gd;
    @com.bytedance.sdk.component.p.w.c(c = "is_reward")

    /* renamed from: i  reason: collision with root package name */
    private boolean f33476i;
    @com.bytedance.sdk.component.p.w.c(c = "close_button")

    /* renamed from: j  reason: collision with root package name */
    private View f33477j;
    @com.bytedance.sdk.component.p.w.c(c = "download_listener")
    private DownloadListener ls;
    private double me;
    @com.bytedance.sdk.component.p.w.c(c = "end_card_param")

    /* renamed from: n  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ev.c.xv.c f33480n;
    private boolean pr;
    @com.bytedance.sdk.component.p.w.c(c = "extra_map")

    /* renamed from: q  reason: collision with root package name */
    private Map<String, Object> f33482q;

    /* renamed from: r  reason: collision with root package name */
    protected String f33483r;
    @com.bytedance.sdk.component.p.w.c(c = "web_view")

    /* renamed from: s  reason: collision with root package name */
    private WeakReference<SSWebView> f33484s;
    @com.bytedance.sdk.component.p.w.c(c = "event_tag")

    /* renamed from: u  reason: collision with root package name */
    private String f33486u;
    protected xk ux;

    /* renamed from: w  reason: collision with root package name */
    Object f33487w;
    private double wv;
    private String wx;
    private double xk;
    @com.bytedance.sdk.component.p.w.c(c = "action_type")

    /* renamed from: y  reason: collision with root package name */
    private int f33489y;
    private double yu;
    @com.bytedance.sdk.component.p.w.c(c = "end_card_width")

    /* renamed from: z  reason: collision with root package name */
    private int f33490z;
    private final Map<String, Bitmap> eq = new HashMap();
    int xv = 0;
    int sr = 0;

    /* renamed from: p  reason: collision with root package name */
    int f33481p = 0;

    /* renamed from: k  reason: collision with root package name */
    String f33478k = "";

    /* renamed from: a  reason: collision with root package name */
    protected boolean f33473a = false;
    protected boolean bk = false;

    /* renamed from: t  reason: collision with root package name */
    protected final AtomicBoolean f33485t = new AtomicBoolean(true);
    private Handler bw = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.sdk.openadsdk.core.ev.c.w.r.1
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    r.this.bk();
                    return;
                case 2:
                    r.this.ux();
                    return;
                case 3:
                    r.this.r();
                    return;
                case 4:
                    r.this.ev();
                    return;
                case 5:
                    r.this.gd();
                    return;
                case 6:
                    r.this.p();
                    return;
                case 7:
                    r.this.k();
                    return;
                case 8:
                    r.this.a();
                    return;
                case 9:
                    r.this.t();
                    return;
                case 10:
                    r.this.ys();
                    return;
                case 11:
                    r.this.fp();
                    return;
                case 12:
                    r.this.ia();
                    return;
                case 13:
                    r.this.s();
                    return;
                case 14:
                    r.this.fz();
                    return;
                default:
                    return;
            }
        }
    };
    protected AtomicBoolean ys = new AtomicBoolean(false);
    protected com.bytedance.sdk.openadsdk.core.ia.c fp = new com.bytedance.sdk.openadsdk.core.ia.c() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.w.r.6
        @Override // com.bytedance.sdk.openadsdk.core.ia.c
        public int c() {
            SSWebView sSWebView = r.this.f33484s != null ? (SSWebView) r.this.f33484s.get() : null;
            int measuredHeight = sSWebView != null ? sSWebView.getMeasuredHeight() : -1;
            return measuredHeight <= 0 ? com.bytedance.sdk.openadsdk.core.eq.xk.ux((Context) r.this.f33474c) : measuredHeight;
        }

        @Override // com.bytedance.sdk.openadsdk.core.ia.c
        public int w() {
            SSWebView sSWebView = r.this.f33484s != null ? (SSWebView) r.this.f33484s.get() : null;
            int measuredWidth = sSWebView != null ? sSWebView.getMeasuredWidth() : -1;
            return measuredWidth <= 0 ? com.bytedance.sdk.openadsdk.core.eq.xk.sr((Context) r.this.f33474c) : measuredWidth;
        }
    };
    protected com.bytedance.sdk.openadsdk.core.ia.gd ia = new com.bytedance.sdk.openadsdk.core.ia.gd() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.w.r.7
        @Override // com.bytedance.sdk.openadsdk.core.ia.gd
        public void c() {
            SSWebView sSWebView = r.this.f33484s != null ? (SSWebView) r.this.f33484s.get() : null;
            if (sSWebView == null) {
                return;
            }
            sSWebView.ab_();
        }

        @Override // com.bytedance.sdk.openadsdk.core.ia.gd
        public void w() {
            SSWebView sSWebView = r.this.f33484s != null ? (SSWebView) r.this.f33484s.get() : null;
            if (sSWebView == null) {
                return;
            }
            sSWebView.k();
        }
    };

    /* renamed from: x  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.ia.w f33488x = new com.bytedance.sdk.openadsdk.core.ia.w() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.w.r.8
        @Override // com.bytedance.sdk.openadsdk.core.ia.w
        public void c(boolean z3, int i4, String str) {
            com.bytedance.sdk.component.utils.a.w("end card load finish: ", "code=" + i4 + " msg=" + str + " isRenderSuc=" + z3);
            if (z3) {
                r rVar = r.this;
                rVar.bk = true;
                if (rVar.pr) {
                    r rVar2 = r.this;
                    rVar2.c(rVar2.me, r.this.wv, r.this.xk, r.this.yu, r.this.wx);
                    r.this.pr = false;
                }
            }
            if (ng.gd(r.this.fz)) {
                r.this.c(z3, i4, str);
            }
        }
    };

    /* renamed from: m  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.gd.c f33479m = new com.bytedance.sdk.openadsdk.gd.c() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.w.r.9
        @Override // com.bytedance.sdk.openadsdk.gd.c
        public void c() {
            r.this.f33474c.gd(1);
        }
    };

    private void i() {
        this.f33483r = ng.r(this.fz);
        float yx = this.fz.yx();
        if (TextUtils.isEmpty(this.f33483r)) {
            return;
        }
        if (this.ck == 1) {
            if (this.f33483r.contains("?")) {
                this.f33483r += "&orientation=portrait";
            } else {
                this.f33483r += "?orientation=portrait";
            }
        }
        if (this.f33483r.contains("?")) {
            this.f33483r += "&height=" + this.ba + "&width=" + this.f33490z + "&aspect_ratio=" + yx;
        } else {
            this.f33483r += "?height=" + this.ba + "&width=" + this.f33490z + "&aspect_ratio=" + yx;
        }
        this.f33483r = com.bytedance.sdk.openadsdk.core.component.reward.ux.c.c(this.f33483r);
    }

    private void j() {
        WeakReference<SSWebView> weakReference;
        final SSWebView sSWebView;
        if (this.ys.getAndSet(true) || (weakReference = this.f33484s) == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(sSWebView, "translationY", 0.0f, com.bytedance.sdk.openadsdk.core.eq.xk.ux((Context) this.f33474c));
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(1000L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.w.r.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.bytedance.sdk.openadsdk.core.eq.xk.c((View) sSWebView, 8);
                r.this.ys.set(false);
            }
        });
        ofFloat.start();
    }

    private void ls() {
        xk xkVar = this.ux;
        if (xkVar == null) {
            return;
        }
        xkVar.c(new SSWebView.w() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.w.r.5
            @Override // com.bytedance.sdk.component.widget.SSWebView.w
            public void c(int i4) {
                xk xkVar2 = r.this.ux;
                if (xkVar2 != null) {
                    xkVar2.c(i4);
                }
            }
        });
    }

    private void q() {
        WeakReference<SSWebView> weakReference;
        if (this.ys.getAndSet(true) || (weakReference = this.f33484s) == null) {
            return;
        }
        try {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(weakReference.get(), "translationY", com.bytedance.sdk.openadsdk.core.eq.xk.ux((Context) this.f33474c), 0.0f);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setDuration(1000L);
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.w.r.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    r.this.ys.set(false);
                }
            });
            ofFloat.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void u() {
        com.bytedance.sdk.openadsdk.core.ev.c.xv.c cVar = this.f33480n;
        if (cVar == null) {
            return;
        }
        cVar.c(new com.bytedance.sdk.openadsdk.core.ev.c.xv.c() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.w.r.10
        });
    }

    public void a() {
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.gd;
        if (srVar != null) {
            srVar.sr();
        }
    }

    public void bk() {
        WeakReference<SSWebView> weakReference = this.f33484s;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            bw.c(this.f33474c, sSWebView.getWebView());
            bw.c(sSWebView.getWebView());
            sSWebView.gd();
        }
        WeakReference<SSWebView> weakReference2 = this.f33484s;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        xk xkVar = this.ux;
        if (xkVar != null) {
            xkVar.y();
        }
        com.bytedance.sdk.openadsdk.core.a.r rVar = this.f33475f;
        if (rVar != null) {
            rVar.c(true);
            this.f33475f.fp();
        }
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.gd;
        if (srVar != null) {
            srVar.ux();
        }
        me meVar = this.fz;
        if (meVar != null && !TextUtils.isEmpty(meVar.jd())) {
            xv.c.c(this.sr, this.xv, this.fz);
        }
        com.bytedance.sdk.openadsdk.core.t.c.c().c(this.f33487w);
        this.eq.clear();
    }

    public void fp() {
        com.bytedance.sdk.openadsdk.core.a.r rVar = this.f33475f;
        if (rVar != null) {
            rVar.k();
        }
    }

    public void fz() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.f33484s;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.c("about:blank");
    }

    public void gd() {
        this.f33475f = null;
    }

    public void ia() {
        com.bytedance.sdk.openadsdk.core.a.r rVar = this.f33475f;
        if (rVar != null) {
            rVar.a();
        }
    }

    public void k() {
        WeakReference<SSWebView> weakReference = this.f33484s;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            sSWebView.ab_();
        }
        xk xkVar = this.ux;
        if (xkVar != null) {
            xkVar.ba();
            this.ux.r(false);
            c(false);
            c(true, false);
        }
    }

    public void p() {
        WeakReference<SSWebView> weakReference = this.f33484s;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        if (sSWebView != null) {
            sSWebView.aa_();
        }
        xk xkVar = this.ux;
        if (xkVar != null) {
            xkVar.z();
            if (sSWebView != null) {
                if (sSWebView.getVisibility() == 0) {
                    this.ux.r(true);
                    c(true);
                    c(false, true);
                } else {
                    this.ux.r(false);
                    c(false);
                    c(true, false);
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.gd;
        if (srVar != null) {
            srVar.xv();
        }
        com.bytedance.sdk.openadsdk.core.widget.c.sr srVar2 = this.ev;
        if (srVar2 != null) {
            srVar2.xv();
        }
    }

    public void s() {
        com.bytedance.sdk.openadsdk.core.a.r rVar = this.f33475f;
        if (rVar != null) {
            rVar.xv();
            this.f33475f.sr();
        }
    }

    public void t() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.f33484s;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        sSWebView.aa_();
        WebView webView = sSWebView.getWebView();
        webView.resumeTimers();
        com.bytedance.sdk.openadsdk.core.eq.xk.c((View) webView, 1.0f);
        com.bytedance.sdk.openadsdk.core.eq.xk.c((View) sSWebView, 1.0f);
        ls();
    }

    public void ys() {
        com.bytedance.sdk.openadsdk.core.a.r rVar = this.f33475f;
        if (rVar != null) {
            rVar.gd();
        }
    }

    public void ev() {
        if (this.f33474c.b() instanceof com.bytedance.sdk.openadsdk.core.component.reward.sr.gd) {
            j();
            return;
        }
        WeakReference<SSWebView> weakReference = this.f33484s;
        if (weakReference == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.eq.xk.c((View) weakReference.get(), 8);
    }

    public void f() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.f33484s;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.eq.xk.c((View) sSWebView, 0);
        com.bytedance.sdk.openadsdk.core.eq.xk.c((View) sSWebView.getWebView(), 0);
        if (this.gb == 1) {
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) sSWebView, 0.0f);
            com.bytedance.sdk.openadsdk.core.eq.xk.c((View) sSWebView.getWebView(), 0.0f);
        }
        if (this.gb == 2) {
            q();
        }
        xk xkVar = this.ux;
        if (xkVar != null) {
            xkVar.c(wv.t(this.fz), false);
        }
        c(true);
        w(true);
        c(false, true);
    }

    public void r() {
        com.bytedance.sdk.openadsdk.core.a.sr srVar = this.gd;
        if (srVar != null) {
            srVar.c(System.currentTimeMillis());
        }
    }

    protected boolean sr() {
        String str = this.f33483r;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void ux() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.f33484s;
        if (weakReference == null || (sSWebView = weakReference.get()) == null || this.f33473a) {
            return;
        }
        sSWebView.c(this.f33483r);
        this.f33473a = true;
    }

    public void w() {
        SSWebView sSWebView;
        WebView webView;
        WeakReference<SSWebView> weakReference = this.f33484s;
        if (weakReference == null || (sSWebView = weakReference.get()) == null || (webView = sSWebView.getWebView()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.a.r rVar = new com.bytedance.sdk.openadsdk.core.a.r(this.f33486u, this.fz, jSONObject);
        this.f33475f = rVar;
        rVar.c(jSONObject, "webview_source", (Object) 2);
        com.bytedance.sdk.openadsdk.core.a.sr w3 = new com.bytedance.sdk.openadsdk.core.a.sr(this.fz, webView).w(true);
        this.gd = w3;
        w3.c(true);
        i();
        this.gd.c(sr() ? "landingpage_endcard" : this.f33476i ? "reward_endcard" : "fullscreen_endcard");
        xk xkVar = new xk(this.f33474c) { // from class: com.bytedance.sdk.openadsdk.core.ev.c.w.r.12
        };
        this.ux = xkVar;
        xkVar.w(sSWebView).c(this.fz).w(this.fz.jr()).xv(this.fz.cf()).xv(this.f33476i ? 7 : 5).c(this.fp).sr(wv.t(this.fz)).c(sSWebView).w(com.bytedance.sdk.openadsdk.core.p.xv.k.c(this.fz)).c(this.f33475f).c(this.f33486u).c(this.f33482q).c(this.ia).c(this.f33477j).c(this.f33479m);
        this.ux.c(this.f33488x);
    }

    public void xv() {
        SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.f33484s;
        if (weakReference == null || (sSWebView = weakReference.get()) == null) {
            return;
        }
        this.f33487w = com.bytedance.sdk.openadsdk.core.t.c.c().c(this.fz);
        com.bytedance.sdk.openadsdk.core.widget.c.sr srVar = new com.bytedance.sdk.openadsdk.core.widget.c.sr(this.f33474c, this.ux, this.fz.jr(), this.gd) { // from class: com.bytedance.sdk.openadsdk.core.ev.c.w.r.13
            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                com.bytedance.sdk.openadsdk.core.a.r rVar = r.this.f33475f;
                if (rVar != null) {
                    rVar.r();
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                com.bytedance.sdk.openadsdk.core.a.r rVar = r.this.f33475f;
                if (rVar != null) {
                    rVar.f();
                }
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i4, String str, String str2) {
                r.this.f33485t.set(false);
                r rVar = r.this;
                rVar.f33481p = i4;
                rVar.f33478k = str;
                if (rVar.f33475f != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put("code", i4);
                            jSONObject.put("msg", str);
                        }
                        r.this.f33475f.c(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i4, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (r.this.f33475f != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 21) {
                            jSONObject.put("code", webResourceResponse.getStatusCode());
                            jSONObject.put("msg", webResourceResponse.getReasonPhrase());
                        }
                        r.this.f33475f.c(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (r.this.f33483r.equals(String.valueOf(webResourceRequest.getUrl()))) {
                    if (webResourceRequest.isForMainFrame()) {
                        r.this.f33485t.set(false);
                    }
                    if (webResourceResponse != null) {
                        r.this.f33481p = webResourceResponse.getStatusCode();
                        r.this.f33478k = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                WebResourceResponse c4 = r.this.c(str);
                return c4 != null ? c4 : super.shouldInterceptRequest(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    String uri = webResourceRequest.getUrl().toString();
                    if (r.this.fz != null) {
                        WebResourceResponse c4 = r.this.c(uri);
                        if (c4 != null) {
                            return c4;
                        }
                        if (TextUtils.isEmpty(r.this.fz.jd())) {
                            return super.shouldInterceptRequest(webView, uri);
                        }
                        r.this.xv++;
                        com.bytedance.sdk.openadsdk.core.t.c c5 = com.bytedance.sdk.openadsdk.core.t.c.c();
                        r rVar = r.this;
                        WebResourceResponse c6 = c5.c(rVar.f33487w, rVar.fz, uri);
                        if (c6 != null) {
                            r.this.sr++;
                            return c6;
                        }
                        return super.shouldInterceptRequest(webView, uri);
                    }
                    return super.shouldInterceptRequest(webView, uri);
                } catch (Throwable unused) {
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.isForMainFrame()) {
                    r.this.f33485t.set(false);
                }
                if (r.this.f33475f != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (Build.VERSION.SDK_INT >= 23) {
                            jSONObject.put("code", webResourceError.getErrorCode());
                            jSONObject.put("msg", webResourceError.getDescription());
                        }
                        r.this.f33475f.c(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                r.this.f33481p = webResourceError.getErrorCode();
                r.this.f33478k = String.valueOf(webResourceError.getDescription());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        };
        this.ev = srVar;
        sSWebView.setWebViewClient(srVar);
        c(sSWebView);
        sSWebView.setBackgroundColor(-1);
        sSWebView.setDisplayZoomControls(false);
        sSWebView.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.c.xv(this.ux, this.gd) { // from class: com.bytedance.sdk.openadsdk.core.ev.c.w.r.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.c.xv, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i4) {
                super.onProgressChanged(webView, i4);
            }
        });
        sSWebView.setDownloadListener(this.ls);
    }

    @Override // com.bytedance.sdk.component.p.c.c.xv
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.c.c cVar) {
        if (this.f33489y != 0) {
            f();
            return true;
        }
        c();
        w();
        xv();
        u();
        return true;
    }

    public void c(boolean z3, int i4, String str) {
        com.bytedance.sdk.openadsdk.core.a.r rVar = this.f33475f;
        if (rVar == null) {
            return;
        }
        if (z3) {
            rVar.w();
        } else {
            rVar.c(i4, str);
        }
    }

    protected void c() {
        final SSWebView sSWebView;
        WeakReference<SSWebView> weakReference = this.f33484s;
        if (weakReference == null || (sSWebView = weakReference.get()) == null || sSWebView.getWebView() == null) {
            return;
        }
        sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.w.r.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                SSWebView sSWebView2 = sSWebView;
                if (sSWebView2 == null || sSWebView2.getViewTreeObserver() == null) {
                    return;
                }
                sSWebView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int measuredWidth = sSWebView.getMeasuredWidth();
                int measuredHeight = sSWebView.getMeasuredHeight();
                if (sSWebView.getVisibility() == 0) {
                    r.this.c(measuredWidth, measuredHeight);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, int i5) {
        if (this.ux == null || this.f33474c.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i4);
            jSONObject.put("height", i5);
            this.ux.c("resize", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    protected void c(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        WebView webView = sSWebView.getWebView();
        com.bytedance.sdk.openadsdk.core.widget.c.w.c(this.f33474c).c(false).w(false).c(webView);
        sSWebView.setUserAgentString(fz.c(webView, eq.f33190w, me.f(this.fz)));
        com.bytedance.sdk.openadsdk.core.eq.xk.c(webView);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            sSWebView.setMixedContentMode(0);
        }
        if (i4 < 24) {
            sSWebView.setLayerType(0, null);
        }
    }

    public void w(boolean z3) {
        if (this.ux == null || this.f33474c.isFinishing()) {
            return;
        }
        try {
            this.ux.r(z3);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void c(boolean z3) {
        if (this.ux == null || this.f33474c.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z3 ? 1 : 0);
            this.ux.c("viewableChange", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void c(boolean z3, boolean z4) {
        if (this.ux == null || this.f33474c.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z3);
            jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD_SHOW, z4);
            this.ux.c("endcard_control_event", jSONObject);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void c(double d4, double d5, double d6, double d7, String str) {
        if (this.ux == null || this.f33474c.isFinishing()) {
            return;
        }
        if (!this.bk) {
            this.me = d4;
            this.wv = d5;
            this.yu = d7;
            this.xk = d6;
            this.wx = str;
            this.pr = true;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", d4);
            jSONObject.put("y", d5);
            jSONObject.put("width", d6);
            jSONObject.put("height", d7);
            jSONObject.put("videoFrameKey", str);
            this.ux.c("endcardTransform", jSONObject);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse c(String str) {
        if (str.startsWith("csjclientimg://")) {
            Bitmap bitmap = this.eq.get(str.replace("csjclientimg://", ""));
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
