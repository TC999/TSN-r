package com.qq.e.comm.plugin.q0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.q0.p;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.e1;
import com.qq.e.comm.plugin.util.q0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends WebView implements o, i {

    /* renamed from: o  reason: collision with root package name */
    private static final com.qq.e.comm.plugin.q0.s.b f45427o = new com.qq.e.comm.plugin.q0.s.b("webviewLayout", null);

    /* renamed from: p  reason: collision with root package name */
    private static final com.qq.e.comm.plugin.q0.s.g f45428p = new a();

    /* renamed from: c  reason: collision with root package name */
    private List<com.qq.e.comm.plugin.q0.t.b> f45429c;

    /* renamed from: d  reason: collision with root package name */
    private h.a f45430d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f45431e;

    /* renamed from: f  reason: collision with root package name */
    private com.qq.e.comm.plugin.apkmanager.w.a f45432f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f45433g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f45434h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f45435i;

    /* renamed from: j  reason: collision with root package name */
    private com.qq.e.comm.plugin.q0.s.g f45436j;

    /* renamed from: k  reason: collision with root package name */
    private p f45437k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f45438l;

    /* renamed from: m  reason: collision with root package name */
    private q f45439m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f45440n;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements com.qq.e.comm.plugin.q0.s.g {
        a() {
        }

        @Override // com.qq.e.comm.plugin.q0.s.g
        public com.qq.e.comm.plugin.q0.s.f<String> a(String str) {
            return new com.qq.e.comm.plugin.q0.s.f<>(1000, "");
        }

        @Override // com.qq.e.comm.plugin.q0.s.g
        public com.qq.e.comm.plugin.q0.s.g a(com.qq.e.comm.plugin.q0.u.i iVar) {
            return this;
        }

        @Override // com.qq.e.comm.plugin.q0.s.g
        public com.qq.e.comm.plugin.q0.s.g a(String str, com.qq.e.comm.plugin.q0.u.j jVar) {
            return this;
        }

        @Override // com.qq.e.comm.plugin.q0.s.g
        public void a(com.qq.e.comm.plugin.q0.s.b bVar) {
        }

        @Override // com.qq.e.comm.plugin.q0.s.g
        public void a(com.qq.e.comm.plugin.q0.s.e eVar) {
        }

        @Override // com.qq.e.comm.plugin.q0.s.g
        public void b(String str) {
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.q0.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0876b implements DownloadListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f45441a;

        C0876b(Context context) {
            this.f45441a = context;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j4) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            if (intent.resolveActivity(com.qq.e.comm.plugin.d0.a.d().a().getPackageManager()) != null) {
                if (!(this.f45441a instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                this.f45441a.startActivity(intent);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c extends WebViewClient {
        c() {
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null && renderProcessGoneDetail.didCrash()) {
                m.a().a(webView);
                v.a(9130001, null, 1);
                return true;
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return motionEvent.getAction() == 2;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class e implements View.OnLongClickListener {
        e() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return true;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class f implements p.b {
        f() {
        }

        @Override // com.qq.e.comm.plugin.q0.p.b
        public void a() {
            d1.a("GDTWebView", "onNextClick");
        }

        @Override // com.qq.e.comm.plugin.q0.p.b
        public void b() {
            d1.a("GDTWebView", "onPreClick");
        }

        @Override // com.qq.e.comm.plugin.q0.p.b
        public void d() {
            d1.a("GDTWebView", "onShow");
        }

        @Override // com.qq.e.comm.plugin.q0.p.b
        public void onDismiss() {
            d1.a("GDTWebView", "onDismiss");
        }
    }

    public b(Context context) {
        super(b(context));
        this.f45429c = new ArrayList();
        this.f45431e = false;
        this.f45433g = false;
        this.f45435i = true;
        n();
        getSettings().setJavaScriptEnabled(true);
        j();
        i();
        setDownloadListener(new C0876b(context));
        resumeTimers();
    }

    private static Context b(Context context) {
        int i4 = Build.VERSION.SDK_INT;
        return (i4 == 21 || i4 == 22) ? context.createConfigurationContext(new Configuration()) : context;
    }

    private void g() {
        if (this.f45433g) {
            return;
        }
        this.f45433g = true;
        com.qq.e.comm.plugin.apkmanager.k.e().a(this.f45432f);
    }

    private void i() {
        try {
            String absolutePath = b1.a(getContext()).getAbsolutePath();
            WebSettings settings = getSettings();
            settings.setAllowFileAccess(false);
            settings.setAppCachePath(absolutePath);
            settings.setAppCacheMaxSize(8388608L);
            settings.setAppCacheEnabled(true);
            settings.setLoadsImagesAutomatically(true);
            settings.setCacheMode(-1);
            settings.setDomStorageEnabled(true);
        } catch (Throwable th) {
            d1.a("GDTWebView", "cache", th);
        }
    }

    private void j() {
        m();
        getSettings().setSavePassword(false);
    }

    private void m() {
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
    }

    private void n() {
        WebSettings settings = getSettings();
        String userAgentString = settings.getUserAgentString();
        settings.setUserAgentString(userAgentString + " GDTMobSDK" + TTPathConst.sSeparator + e1.c());
    }

    private void o() {
        this.f45433g = false;
        com.qq.e.comm.plugin.apkmanager.k.e().b(this.f45432f);
    }

    public void c(boolean z3) {
        if (z3) {
            WebSettings settings = getSettings();
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            setInitialScale(100);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setSupportMultipleWindows(false);
            settings.setSaveFormData(false);
            File b4 = b1.b(getContext());
            if (!b4.exists()) {
                b4.mkdirs();
            }
            String absolutePath = b4.getAbsolutePath();
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(absolutePath);
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(absolutePath);
            if (Build.VERSION.SDK_INT >= 17) {
                settings.setMediaPlaybackRequiresUserGesture(false);
            }
        } else if (Build.VERSION.SDK_INT >= 19) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void d() {
        setOnTouchListener(new d());
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setOnLongClickListener(new e());
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            if (this.f45434h) {
                return;
            }
            if (!q0.e() || Build.VERSION.SDK_INT > 23) {
                loadUrl("about:blank");
            }
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this);
            }
            if (this.f45439m != null) {
                this.f45439m = null;
            }
            this.f45436j = f45428p;
            removeAllViews();
            super.destroy();
            this.f45434h = true;
        } catch (Throwable th) {
            d1.a("WebView destroy Exception", th);
        }
    }

    public void e(boolean z3) {
        this.f45438l = z3;
        if (z3) {
            p pVar = new p(getContext(), this);
            this.f45437k = pVar;
            pVar.a(new f());
        }
    }

    public void g(boolean z3) {
    }

    public boolean h() {
        return this.f45440n;
    }

    public boolean k() {
        return this.f45434h;
    }

    public void l() {
        setWebViewClient(new c());
        setWebChromeClient(null);
        this.f45436j = f45428p;
        this.f45439m = null;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        try {
            super.loadUrl(str);
        } catch (Throwable th) {
            d1.a("WebView loadUrl Exception", th);
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        p pVar;
        d1.a("OnWebViewAttachedToWindow", new Object[0]);
        super.onAttachedToWindow();
        if (this.f45432f != null) {
            g();
        }
        if (this.f45438l && (pVar = this.f45437k) != null && pVar.getParent() == null) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup instanceof FrameLayout) {
                viewGroup.addView(this.f45437k);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        d1.a("OnWebViewDetachedFromWindow", new Object[0]);
        super.onDetachedFromWindow();
        if (this.f45432f != null) {
            o();
        }
    }

    @Override // android.widget.AbsoluteLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        com.qq.e.comm.plugin.q0.s.g gVar;
        super.onLayout(z3, i4, i5, i6, i7);
        if (!this.f45431e && (gVar = this.f45436j) != null) {
            this.f45431e = true;
            gVar.a(f45427o);
        }
        h.a aVar = this.f45430d;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i4, int i5, int i6, int i7) {
        p pVar;
        if (!this.f45435i) {
            scrollTo(i4, 0);
            return;
        }
        super.onScrollChanged(i4, i5, i6, i7);
        if (!this.f45438l || (pVar = this.f45437k) == null) {
            return;
        }
        if (i5 > i7) {
            pVar.b();
        } else {
            pVar.d();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onVisibilityChanged(View view, int i4) {
        super.onVisibilityChanged(view, i4);
        q qVar = this.f45439m;
        if (qVar != null) {
            qVar.a(i4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002f, code lost:
        if (com.qq.e.comm.plugin.d0.a.d().f().a("iswcc", 1) == 0) goto L12;
     */
    @Override // android.webkit.WebView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setWebChromeClient(android.webkit.WebChromeClient r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = 1
            if (r7 == 0) goto L31
            boolean r2 = r7 instanceof com.qq.e.comm.plugin.q0.a
            if (r2 != 0) goto L31
            com.qq.e.comm.plugin.n0.d r2 = new com.qq.e.comm.plugin.n0.d
            r2.<init>()
            java.lang.String r3 = r7.toString()
            java.lang.String r4 = "msg"
            r2.a(r4, r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r4 = 9130004(0x8b5014, float:1.279386E-38)
            r5 = 0
            com.qq.e.comm.plugin.n0.v.b(r4, r5, r3, r2)
            com.qq.e.comm.plugin.d0.a r2 = com.qq.e.comm.plugin.d0.a.d()
            com.qq.e.comm.plugin.d0.d.h r2 = r2.f()
            java.lang.String r3 = "iswcc"
            int r2 = r2.a(r3, r1)
            if (r2 != 0) goto L32
        L31:
            r0 = 1
        L32:
            if (r0 == 0) goto L37
            super.setWebChromeClient(r7)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.q0.b.setWebChromeClient(android.webkit.WebChromeClient):void");
    }

    public void a(WebViewClient webViewClient) {
        if (webViewClient != null) {
            setWebViewClient(webViewClient);
        }
    }

    public void a(com.qq.e.comm.plugin.q0.a aVar) {
        if (aVar != null) {
            setWebChromeClient(aVar);
        }
    }

    public p b() {
        return this.f45437k;
    }

    public void a(com.qq.e.comm.plugin.apkmanager.w.a aVar) {
        this.f45432f = aVar;
    }

    public void a(com.qq.e.comm.plugin.q0.s.g gVar) {
        this.f45436j = gVar;
        this.f45439m = new q(gVar);
    }

    @Override // com.qq.e.comm.plugin.q0.o
    public void a(String str) {
        a(str, null);
    }

    @Override // com.qq.e.comm.plugin.q0.o
    public void a(String str, ValueCallback<String> valueCallback) {
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                evaluateJavascript(str, valueCallback);
            } else {
                loadUrl("javascript:" + str);
                if (valueCallback != null) {
                    valueCallback.onReceiveValue("");
                }
            }
        } catch (Throwable th) {
            d1.a("WebView evaluateJavaScript Exception", th);
        }
    }

    public void d(boolean z3) {
        WebSettings settings = getSettings();
        if (settings == null || Build.VERSION.SDK_INT < 17) {
            return;
        }
        settings.setMediaPlaybackRequiresUserGesture(z3);
    }

    public void a(com.qq.e.comm.plugin.q0.t.b bVar) {
        this.f45429c.add(bVar);
    }

    public void a(com.qq.e.comm.plugin.q0.t.a aVar) {
        List<com.qq.e.comm.plugin.q0.t.b> list = this.f45429c;
        if (list != null) {
            for (com.qq.e.comm.plugin.q0.t.b bVar : list) {
                bVar.a(aVar);
            }
        }
    }

    public void a(h.a aVar) {
        this.f45430d = aVar;
    }

    public com.qq.e.comm.plugin.q0.s.g c() {
        return this.f45436j;
    }
}
