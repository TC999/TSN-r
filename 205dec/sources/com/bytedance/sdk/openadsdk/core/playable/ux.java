package com.bytedance.sdk.openadsdk.core.playable;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.bk.ev;
import com.bytedance.sdk.openadsdk.bk.r;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.core.a.xv;
import com.bytedance.sdk.openadsdk.core.bw;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.fz;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.wx;
import com.bytedance.sdk.openadsdk.core.xk;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private final LruCache<String, c> f34444c = new LruCache<>(1);

    /* renamed from: w  reason: collision with root package name */
    private final Map<Integer, c> f34445w;
    private static final ux xv = new ux();
    private static int sr = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.playable.ux$5  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f34454c;

        static {
            int[] iArr = new int[w.values().length];
            f34454c = iArr;
            try {
                iArr[w.STATUS_LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34454c[w.STATUS_FINISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34454c[w.STATUS_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34454c[w.STATUS_NEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: n  reason: collision with root package name */
        private static final r.c f34455n = new r.c() { // from class: com.bytedance.sdk.openadsdk.core.playable.ux.c.1
            @Override // com.bytedance.sdk.openadsdk.bk.r.c
            public void c(String str, String str2) {
                a.w(str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.bk.r.c
            public void c(String str, String str2, Throwable th) {
                a.xv(str, str2, th);
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private SSWebView f34457c;
        private final me ev;

        /* renamed from: f  reason: collision with root package name */
        private final Context f34458f;
        private final String gd;

        /* renamed from: k  reason: collision with root package name */
        private final boolean f34461k;
        private com.bytedance.sdk.openadsdk.core.widget.c.sr ls;

        /* renamed from: r  reason: collision with root package name */
        private InterfaceC0503c f34464r;
        private com.bytedance.sdk.openadsdk.bk.ev sr;

        /* renamed from: t  reason: collision with root package name */
        private final Object f34466t;

        /* renamed from: u  reason: collision with root package name */
        private boolean f34467u;
        private com.bytedance.sdk.openadsdk.core.a.sr ux;

        /* renamed from: w  reason: collision with root package name */
        private WebView f34468w;
        private xk xv;

        /* renamed from: p  reason: collision with root package name */
        private boolean f34462p = true;

        /* renamed from: a  reason: collision with root package name */
        private int f34456a = 0;
        private int bk = 0;
        private boolean fp = true;
        private boolean ia = false;

        /* renamed from: s  reason: collision with root package name */
        private boolean f34465s = false;
        private int fz = 0;

        /* renamed from: i  reason: collision with root package name */
        private final AtomicBoolean f34459i = new AtomicBoolean(false);

        /* renamed from: q  reason: collision with root package name */
        private int f34463q = 0;

        /* renamed from: j  reason: collision with root package name */
        private int f34460j = 0;
        private final Map<String, com.bytedance.sdk.openadsdk.core.p.w.xv> gb = Collections.synchronizedMap(new HashMap());
        private w ys = w.STATUS_NEW;

        /* renamed from: com.bytedance.sdk.openadsdk.core.playable.ux$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public interface InterfaceC0503c {
            void c(int i4);

            void c(SSWebView sSWebView);

            Activity getActivity();

            void sr();

            void w(int i4);

            com.bytedance.sdk.openadsdk.core.w.ux xv();
        }

        public c(Context context, me meVar, boolean z3) {
            this.f34467u = true;
            this.f34461k = z3;
            this.f34458f = context;
            this.ev = meVar;
            this.gd = u.w(meVar);
            this.f34466t = com.bytedance.sdk.openadsdk.core.t.c.c().c(meVar);
            if (this.f34457c == null) {
                this.f34457c = new SSWebView(context);
            }
            p();
            if (!z3) {
                c((ViewGroup) null);
            }
            if (wx.r(meVar)) {
                return;
            }
            this.f34467u = false;
        }

        static /* synthetic */ int ev(c cVar) {
            int i4 = cVar.f34456a;
            cVar.f34456a = i4 + 1;
            return i4;
        }

        static /* synthetic */ int p(c cVar) {
            int i4 = cVar.bk;
            cVar.bk = i4 + 1;
            return i4;
        }

        private void a() {
            if (this.f34468w == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.widget.c.w.c(this.f34458f).c(false).w(false).c(this.f34468w);
            WebSettings settings = this.f34468w.getSettings();
            settings.setUserAgentString(fz.c(this.f34468w, eq.f33190w, me.f(this.ev)));
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
        }

        private void bk() {
            WebView webView;
            SSWebView sSWebView = this.f34457c;
            if (sSWebView == null || this.sr != null || (webView = sSWebView.getWebView()) == null) {
                return;
            }
            if (k.sr().z()) {
                com.bytedance.sdk.openadsdk.bk.r.c(f34455n);
            }
            com.bytedance.sdk.openadsdk.core.s.xv xvVar = new com.bytedance.sdk.openadsdk.core.s.xv();
            com.bytedance.sdk.openadsdk.core.s.sr srVar = new com.bytedance.sdk.openadsdk.core.s.sr() { // from class: com.bytedance.sdk.openadsdk.core.playable.ux.c.6
                @Override // com.bytedance.sdk.openadsdk.bk.c
                public void c(JSONObject jSONObject) {
                    com.bytedance.sdk.openadsdk.core.a.xv.xv(c.this.ev, "embeded_ad", "playable_track", jSONObject);
                }

                @Override // com.bytedance.sdk.openadsdk.bk.c
                public void c(int i4, String str) {
                    a.c("Playable Plugin notify failed! : code:" + str + "; msg:" + str);
                    if (wx.a(c.this.ev)) {
                        c.this.f34462p = false;
                        c.this.w(3);
                        c.this.xv(false);
                    }
                }
            };
            com.bytedance.sdk.openadsdk.core.s.ux uxVar = new com.bytedance.sdk.openadsdk.core.s.ux(this.xv);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(BidResponsedEx.KEY_CID, this.ev.jr());
                jSONObject.put("log_extra", this.ev.cf());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            new HashSet();
            HashSet hashSet = new HashSet();
            hashSet.add("subscribe_app_ad");
            hashSet.add("adInfo");
            hashSet.add("webview_time_track");
            hashSet.add("download_app_ad");
            com.bytedance.sdk.openadsdk.bk.ev xv = xvVar.c(StubApp.getOrigApplicationContext(this.f34458f.getApplicationContext()), webView, uxVar, srVar, hashSet, ev.c.LAND_PAGE).f(this.gd).w(this.f34461k).ux(com.bytedance.sdk.openadsdk.core.r.c.r()).c(com.bytedance.sdk.openadsdk.core.r.c.c()).ux(jSONObject).w(com.bytedance.sdk.openadsdk.core.r.c.ux()).c("sdkEdition", com.bytedance.sdk.openadsdk.core.r.c.xv()).sr(com.bytedance.sdk.openadsdk.core.r.c.sr()).c(wx.bk(this.ev)).w(wx.t(this.ev)).sr(false).xv(false);
            this.sr = xv;
            try {
                com.bytedance.sdk.openadsdk.core.z.r w3 = ls.w();
                me meVar = this.ev;
                xv.c(w3.c(meVar, wv.gd(meVar)));
            } catch (Exception unused) {
            }
            Set<String> p3 = this.sr.p();
            if (!TextUtils.isEmpty(wx.w(this.ev))) {
                this.sr.xv(wx.w(this.ev));
            }
            final WeakReference weakReference = new WeakReference(this.sr);
            if (this.xv == null || p3 == null || p3.size() <= 0) {
                return;
            }
            for (String str : p3) {
                this.xv.xv().c(str, (com.bytedance.sdk.component.c.ux<?, ?>) new com.bytedance.sdk.component.c.ux<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.playable.ux.c.7
                    @Override // com.bytedance.sdk.component.c.ux
                    public JSONObject c(JSONObject jSONObject2, com.bytedance.sdk.component.c.f fVar) throws Exception {
                        try {
                            com.bytedance.sdk.openadsdk.bk.ev evVar = (com.bytedance.sdk.openadsdk.bk.ev) weakReference.get();
                            if (evVar == null) {
                                return null;
                            }
                            return evVar.sr(c(), jSONObject2);
                        } catch (Throwable unused2) {
                            return null;
                        }
                    }
                });
            }
        }

        private void k() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.ev);
            xk xkVar = new xk(this.f34458f);
            this.xv = xkVar;
            xkVar.w(this.f34457c).c(this.ev).xv(arrayList).w(com.bytedance.sdk.openadsdk.core.p.xv.k.c(this.ev)).w(this.ev.jr()).xv(this.ev.cf()).xv(1).c(this.f34457c).sr(wv.t(this.ev)).gd();
            this.xv.c(new com.bytedance.sdk.openadsdk.core.ia.sr() { // from class: com.bytedance.sdk.openadsdk.core.playable.ux.c.5
                @Override // com.bytedance.sdk.openadsdk.core.ia.sr
                public void c() {
                    if (wx.gd(c.this.ev)) {
                        c.this.w(1);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ia.sr
                public void c(int i4) {
                }

                @Override // com.bytedance.sdk.openadsdk.core.ia.sr
                public void w() {
                }
            });
            bk();
        }

        private void p() {
            WebView webView = this.f34457c.getWebView();
            this.f34468w = webView;
            if (webView == null) {
                return;
            }
            this.f34457c.setBackgroundColor(-16777216);
            com.bytedance.sdk.openadsdk.core.a.sr w3 = new com.bytedance.sdk.openadsdk.core.a.sr(this.ev, this.f34468w).w(true);
            this.ux = w3;
            w3.c("embeded_ad");
            k();
            a();
            this.xv.ux(this.f34461k);
            com.bytedance.sdk.openadsdk.core.widget.c.sr srVar = new com.bytedance.sdk.openadsdk.core.widget.c.sr(this.f34458f, this.xv, this.ev.jr(), this.ux) { // from class: com.bytedance.sdk.openadsdk.core.playable.ux.c.2
                @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
                public void onPageFinished(WebView webView2, String str) {
                    super.onPageFinished(webView2, str);
                    c.this.ys = w.STATUS_FINISH;
                    if (c.this.sr != null) {
                        c.this.sr.ev(str);
                    }
                    if (wx.ev(c.this.ev)) {
                        c.this.w(0);
                    }
                    if (c.this.f34462p) {
                        c.this.c("plLandPage_preRender_success", (String) null);
                        com.bytedance.sdk.openadsdk.core.a.xv.sr(c.this.ev, "embeded_ad", "py_loading_success", (JSONObject) null);
                        return;
                    }
                    c.this.c("plLandPage_preRender_failed", (String) null);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
                public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    super.onReceivedError(webView2, webResourceRequest, webResourceError);
                    c.this.f34462p = false;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
                public void onReceivedHttpError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 >= 21 && c.this.gd != null && webResourceRequest != null && webResourceRequest.getUrl() != null && c.this.gd.equals(webResourceRequest.getUrl().toString())) {
                        c.this.f34462p = false;
                    }
                    if (c.this.sr != null && i4 >= 21) {
                        try {
                            c.this.sr.c(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                        } catch (Throwable unused) {
                        }
                    }
                    super.onReceivedHttpError(webView2, webResourceRequest, webResourceResponse);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
                public WebResourceResponse shouldInterceptRequest(WebView webView2, String str) {
                    try {
                        if (c.this.sr != null) {
                            c.this.sr.gd(str);
                        }
                        if (!TextUtils.isEmpty(c.this.ev.jd())) {
                            c.ev(c.this);
                        }
                        WebResourceResponse c4 = com.bytedance.sdk.openadsdk.core.t.c.c().c(c.this.f34466t, c.this.ev, str);
                        if (c4 != null) {
                            c.p(c.this);
                            if (c.this.sr != null) {
                                c.this.sr.p(str);
                            }
                            return c4;
                        }
                        return super.shouldInterceptRequest(webView2, str);
                    } catch (Throwable unused) {
                        return super.shouldInterceptRequest(webView2, str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.c.sr, android.webkit.WebViewClient
                public void onReceivedError(WebView webView2, int i4, String str, String str2) {
                    super.onReceivedError(webView2, i4, str, str2);
                    c.this.f34462p = false;
                    if (c.this.sr != null) {
                        c.this.sr.c(i4, str, str2);
                    }
                }
            };
            this.ls = srVar;
            this.f34457c.setWebViewClient(srVar);
            this.f34457c.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.c.xv(this.xv, this.ux) { // from class: com.bytedance.sdk.openadsdk.core.playable.ux.c.3
                @Override // com.bytedance.sdk.openadsdk.core.widget.c.xv, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView2, int i4) {
                    super.onProgressChanged(webView2, i4);
                    c.this.fz = i4;
                    if (c.this.f34464r != null) {
                        c.this.f34464r.w(c.this.fz);
                    }
                }
            });
            this.f34457c.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.ux.c.4
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j4) {
                    if (c.this.gb.containsKey(str)) {
                        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = (com.bytedance.sdk.openadsdk.core.p.w.xv) c.this.gb.get(str);
                        if (xvVar != null) {
                            xvVar.c(me.ux(c.this.ev));
                            return;
                        }
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.p.w.xv c4 = com.bytedance.sdk.openadsdk.core.p.xv.c(c.this.f34458f, str, c.this.ev, "embeded_ad");
                    c4.c(com.bytedance.sdk.openadsdk.core.p.xv.k.c(c.this.ev));
                    c.this.gb.put(str, c4);
                    c4.c(me.ux(c.this.ev));
                }
            });
        }

        private void t() {
            if (this.f34457c == null) {
                return;
            }
            this.bk = 0;
            this.f34456a = 0;
            this.f34462p = true;
            this.fz = 0;
            this.fp = true;
            this.f34467u = true;
            this.f34459i.set(false);
            this.ys = w.STATUS_NEW;
        }

        public void ev() {
            me meVar;
            Bitmap w3;
            if (!ls.w().pb() || (meVar = this.ev) == null || this.f34468w == null || !u.sr(meVar) || (w3 = com.bytedance.sdk.openadsdk.core.eq.xk.w(this.f34468w)) == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.eq.xk.c(ls.getContext(), this.ev, "embeded_ad", "playable_show_status", w3, false, 1);
        }

        void f() {
            if (this.ia) {
                this.f34465s = true;
                return;
            }
            int i4 = AnonymousClass5.f34454c[this.ys.ordinal()];
            c("plLandPage_preRender_destroy", i4 != 1 ? i4 != 2 ? i4 != 3 ? "0" : "-1" : "2" : "1");
            bw.c(this.f34458f, this.f34468w);
            bw.c(this.f34468w);
            SSWebView sSWebView = this.f34457c;
            if (sSWebView != null) {
                sSWebView.gd();
            }
            this.f34457c = null;
            this.f34468w = null;
            xk xkVar = this.xv;
            if (xkVar != null) {
                xkVar.y();
            }
            com.bytedance.sdk.openadsdk.bk.ev evVar = this.sr;
            if (evVar != null) {
                evVar.wx();
            }
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.p.w.xv> entry : this.gb.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().f();
                }
            }
            com.bytedance.sdk.openadsdk.core.a.sr srVar = this.ux;
            if (srVar != null) {
                srVar.ux();
            }
        }

        public xk gd() {
            return this.xv;
        }

        public boolean r() {
            return this.f34467u;
        }

        public void sr() {
            xk xkVar = this.xv;
            if (xkVar != null) {
                xkVar.ba();
                this.xv.r(false);
            }
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.p.w.xv> entry : this.gb.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().ux();
                }
            }
            xv(false);
        }

        public void ux() {
            com.bytedance.sdk.openadsdk.core.a.sr srVar = this.ux;
            if (srVar != null) {
                srVar.sr();
            }
        }

        public void xv() {
            if (!TextUtils.isEmpty(this.ev.jd())) {
                xv.c.c(this.bk, this.f34456a, this.ev);
            }
            xk xkVar = this.xv;
            if (xkVar != null) {
                xkVar.c((com.bytedance.sdk.openadsdk.core.w.ux) null);
                this.xv.c((com.bytedance.sdk.openadsdk.core.ia.sr) null);
                this.xv.sr(false);
                this.xv.xv(false);
            }
            InterfaceC0503c interfaceC0503c = this.f34464r;
            if (interfaceC0503c != null) {
                interfaceC0503c.sr();
                this.f34464r = null;
            }
            this.ia = false;
            if (this.f34461k && !this.f34465s) {
                t();
            } else {
                f();
            }
        }

        public int w() {
            return this.fz;
        }

        public void w(boolean z3) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.p.w.xv> entry : this.gb.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().sr();
                }
            }
            if (!this.f34467u || z3) {
                xk xkVar = this.xv;
                if (xkVar != null) {
                    xkVar.z();
                    SSWebView sSWebView = this.f34457c;
                    if (sSWebView != null) {
                        this.xv.r(sSWebView.getVisibility() == 0);
                    }
                }
                com.bytedance.sdk.openadsdk.core.a.sr srVar = this.ux;
                if (srVar != null) {
                    srVar.xv();
                }
                xv(true);
            }
            com.bytedance.sdk.openadsdk.core.widget.c.sr srVar2 = this.ls;
            if (srVar2 != null) {
                srVar2.xv();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ViewGroup viewGroup) {
            if (this.f34457c.getParent() != null) {
                return;
            }
            this.fp = false;
            if (viewGroup != null) {
                this.f34457c.setVisibility(4);
                viewGroup.addView(this.f34457c);
                this.f34457c.setLayoutParams(c(viewGroup.getContext(), this.f34457c.getLayoutParams()));
            }
            this.f34463q++;
            this.f34457c.c(this.gd);
            com.bytedance.sdk.openadsdk.bk.ev evVar = this.sr;
            if (evVar != null) {
                evVar.r(this.gd);
            }
            c("plLandPage_start_preRender", (String) null);
            this.ys = w.STATUS_LOADING;
        }

        public void xv(boolean z3) {
            SSWebView sSWebView;
            com.bytedance.sdk.openadsdk.bk.ev evVar = this.sr;
            if (evVar == null || (sSWebView = this.f34457c) == null) {
                return;
            }
            if (z3) {
                if (sSWebView.getVisibility() == 0) {
                    this.sr.xv(true);
                }
            } else {
                evVar.xv(false);
                this.sr.c(true);
            }
            com.bytedance.sdk.openadsdk.core.widget.c.sr srVar = this.ls;
            if (srVar != null) {
                srVar.xv();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w(int i4) {
            this.f34467u = false;
            c(i4);
            InterfaceC0503c interfaceC0503c = this.f34464r;
            if (interfaceC0503c != null) {
                interfaceC0503c.c(i4);
            }
        }

        private ViewGroup.LayoutParams c(Context context, ViewGroup.LayoutParams layoutParams) {
            int min = Math.min(context.getResources().getDisplayMetrics().heightPixels, context.getResources().getDisplayMetrics().widthPixels);
            int max = Math.max(context.getResources().getDisplayMetrics().heightPixels, context.getResources().getDisplayMetrics().widthPixels);
            if (wx.p(this.ev) == 2) {
                layoutParams.width = max;
                layoutParams.height = min - wx.c(this.f34458f, this.ev);
            } else {
                layoutParams.width = min;
                layoutParams.height = max - wx.c(this.f34458f, this.ev);
            }
            return layoutParams;
        }

        public w c() {
            if (!this.f34462p) {
                return w.STATUS_ERROR;
            }
            return this.ys;
        }

        public void c(boolean z3) {
            if (c() == w.STATUS_ERROR) {
                z3 = true;
            }
            com.bytedance.sdk.openadsdk.bk.ev evVar = this.sr;
            if (evVar != null) {
                evVar.c(z3);
            }
        }

        public void c(InterfaceC0503c interfaceC0503c) {
            SSWebView sSWebView = this.f34457c;
            if (sSWebView == null || this.xv == null) {
                return;
            }
            sSWebView.setVisibility(0);
            this.f34464r = interfaceC0503c;
            this.xv.c(interfaceC0503c.xv());
            this.f34464r.c(this.f34457c);
            this.ia = true;
            if (this.f34461k) {
                this.f34460j++;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(final String str, final String str2) {
            if (this.f34461k) {
                me meVar = this.ev;
                c.C0472c sr = new c.C0472c().c("embeded_ad").w("playable_track").sr(meVar != null ? meVar.cf() : "");
                me meVar2 = this.ev;
                sr.ux(meVar2 != null ? meVar2.jr() : "").c(new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.playable.ux.c.8
                    @Override // com.bytedance.sdk.openadsdk.ux.c.c
                    public void c(JSONObject jSONObject) throws JSONException {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("event", str);
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject2.put("pre_render_process", str2);
                        }
                        if ("plLandPage_preRender_destroy".equals(str)) {
                            jSONObject2.put("csj_playable_cache_reuseCnt_byShow", c.this.f34463q);
                            jSONObject2.put("csj_playable_cache_reuseCnt_byClick", c.this.f34460j);
                        }
                        jSONObject2.put("playable_url", u.w(c.this.ev));
                        jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                    }
                });
            }
        }

        public void c(int i4) {
            if (wx.r(this.ev) && !this.f34459i.getAndSet(true)) {
                HashMap hashMap = new HashMap();
                hashMap.put("remove_loading_page_type", Integer.valueOf(i4));
                hashMap.put("playable_url", u.c(this.ev));
                com.bytedance.sdk.openadsdk.core.a.xv.p(this.ev, "embeded_ad", "remove_loading_page", hashMap);
            }
        }

        public void c(int i4, int i5) {
            if (this.xv == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("downloadStatus", i4);
                jSONObject.put("downloadProcessRate", i5);
                this.xv.w("showDownloadStatus", jSONObject);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum w {
        STATUS_NEW,
        STATUS_LOADING,
        STATUS_FINISH,
        STATUS_ERROR
    }

    private ux() {
        c(0);
        this.f34445w = new HashMap();
    }

    private boolean xv(Context context, me meVar) {
        return w() && com.bytedance.sdk.openadsdk.core.eq.xk.gd(context) > 0 && com.bytedance.sdk.openadsdk.core.eq.xk.gd(context) > 0 && xv(meVar) != null;
    }

    public static boolean w() {
        return sr > 0;
    }

    public static ux c() {
        return xv;
    }

    public void w(final Context context, final me meVar) {
        int ev = wv.ev(meVar);
        if (ev != 7) {
            if (!(ev == 8 && meVar.yx() == 100.0f) && c(meVar) && xv(meVar) == null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.ux.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVar = new c(context, meVar, true);
                        Map snapshot = ux.this.f34444c.snapshot();
                        ux.this.f34444c.put(u.w(meVar), cVar);
                        ux.this.c(snapshot);
                    }
                });
            }
        }
    }

    public void c(int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 29) {
            i4 = 0;
        }
        sr = i4;
        if (i5 >= 21) {
            final Map<String, c> snapshot = this.f34444c.snapshot();
            if (i4 <= 0) {
                this.f34444c.evictAll();
            } else {
                this.f34444c.resize(i4);
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.ux.1
                @Override // java.lang.Runnable
                public void run() {
                    ux.this.c(snapshot);
                }
            });
        }
    }

    public c xv(me meVar) {
        return this.f34444c.snapshot().get(u.w(meVar));
    }

    public void w(final ViewGroup viewGroup) {
        com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.ux.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ViewGroup viewGroup2 = viewGroup;
                    if (viewGroup2 == null) {
                        return;
                    }
                    viewGroup2.removeAllViews();
                    ux.this.f34445w.remove(Integer.valueOf(viewGroup.hashCode()));
                } catch (Exception unused) {
                }
            }
        });
    }

    public int w(me meVar) {
        c xv2 = xv(meVar);
        w wVar = w.STATUS_NEW;
        if (xv2 != null) {
            wVar = xv2.c();
        }
        int i4 = AnonymousClass5.f34454c[wVar.ordinal()];
        int i5 = 1;
        if (i4 != 1) {
            i5 = 2;
            if (i4 != 2) {
                return i4 != 3 ? 0 : -1;
            }
        }
        return i5;
    }

    public c c(Context context, me meVar) {
        c cVar;
        if (u.sr(meVar)) {
            if (xv(context, meVar)) {
                c xv2 = xv(meVar);
                try {
                    if (!xv2.ia) {
                        if (!xv2.fp) {
                            return xv2;
                        }
                        ViewGroup viewGroup = (ViewGroup) xv2.f34457c.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(xv2.f34457c);
                        }
                        cVar = new c(context, meVar, false);
                    } else {
                        cVar = new c(context, meVar, false);
                    }
                    return cVar;
                } catch (Exception unused) {
                    return xv2;
                }
            }
            return new c(context, meVar, false);
        }
        return null;
    }

    public static boolean c(me meVar) {
        return w() && u.sr(meVar) && wx.n(meVar);
    }

    public void c(final ViewGroup viewGroup, final String str, long j4) {
        if (c(viewGroup)) {
            viewGroup.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.ux.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ux.this.c(viewGroup)) {
                        c cVar = null;
                        for (c cVar2 : ux.this.f34444c.snapshot().values()) {
                            if (cVar2.fp && ux.w()) {
                                if (TextUtils.equals(cVar2.gd, str)) {
                                    cVar = cVar2;
                                }
                                if (cVar == null) {
                                    cVar = cVar2;
                                }
                            }
                        }
                        if (cVar != null) {
                            ux.this.f34445w.put(Integer.valueOf(viewGroup.hashCode()), cVar);
                            cVar.c(viewGroup);
                        }
                    }
                }
            }, j4);
        }
    }

    public boolean c(ViewGroup viewGroup) {
        if (viewGroup != null && viewGroup.getChildCount() == 0 && sr > 0) {
            if (Build.VERSION.SDK_INT >= 19) {
                return viewGroup.isAttachedToWindow();
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(Map<String, c> map) {
        c cVar;
        Map<String, c> snapshot = this.f34444c.snapshot();
        for (String str : map.keySet()) {
            if (!snapshot.containsKey(str) && (cVar = map.get(str)) != null) {
                cVar.f();
            }
        }
    }
}
