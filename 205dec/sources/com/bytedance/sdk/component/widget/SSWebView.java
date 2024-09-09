package com.bytedance.sdk.component.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.bytedance.sdk.component.utils.q;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SSWebView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private float f30457a;
    private float bk;

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.component.widget.w.c f30458c;
    private long ev;

    /* renamed from: f  reason: collision with root package name */
    private float f30459f;
    private int fp;
    private AtomicBoolean fz;
    private long gd;

    /* renamed from: i  reason: collision with root package name */
    private AtomicInteger f30460i;
    private w ia;

    /* renamed from: j  reason: collision with root package name */
    private xv f30461j;

    /* renamed from: k  reason: collision with root package name */
    private WebView f30462k;

    /* renamed from: p  reason: collision with root package name */
    private boolean f30463p;

    /* renamed from: q  reason: collision with root package name */
    private JSONObject f30464q;

    /* renamed from: r  reason: collision with root package name */
    private long f30465r;

    /* renamed from: s  reason: collision with root package name */
    private q f30466s;
    private boolean sr;

    /* renamed from: t  reason: collision with root package name */
    private float f30467t;

    /* renamed from: u  reason: collision with root package name */
    private AtomicBoolean f30468u;
    private float ux;

    /* renamed from: w  reason: collision with root package name */
    private String f30469w;
    private JSONObject xv;
    private int ys;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            if (webView != null) {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                webView.destroy();
                return true;
            }
            return true;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        void c(int i4);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface xv {
        void c(boolean z3);
    }

    public SSWebView(Context context) {
        super(c(context));
        this.ux = 0.0f;
        this.f30459f = 0.0f;
        this.f30465r = 0L;
        this.ev = 0L;
        this.gd = 0L;
        this.f30463p = false;
        this.f30457a = 20.0f;
        this.f30467t = 50.0f;
        this.fz = new AtomicBoolean();
        this.f30468u = new AtomicBoolean();
        this.f30460i = new AtomicInteger();
        try {
            this.f30462k = new WebView(c(context));
            c();
        } catch (Throwable unused) {
        }
        w(c(context));
    }

    private void bk() {
        try {
            this.f30462k.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f30462k.removeJavascriptInterface("accessibility");
            this.f30462k.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    public static void setDataDirectorySuffix(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            WebView.setDataDirectorySuffix(str);
        }
    }

    private void t() {
        try {
            WebSettings settings = this.f30462k.getSettings();
            if (settings != null) {
                settings.setSavePassword(false);
            }
        } catch (Throwable unused) {
        }
    }

    private void w(Context context) {
        xv(context);
        t();
        bk();
    }

    private static boolean xv(View view) {
        try {
            Class<?> loadClass = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (loadClass != null) {
                if (loadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Class<?> loadClass2 = view.getClass().getClassLoader().loadClass("androidx.core.view.ScrollingView");
            if (loadClass2 != null) {
                return loadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public void Z_() {
        try {
            this.f30462k.stopLoading();
        } catch (Throwable unused) {
        }
    }

    public void a() {
        this.f30468u.set(false);
        q qVar = this.f30466s;
        if (qVar != null) {
            qVar.sr();
        }
    }

    public void aa_() {
        WebView webView = this.f30462k;
        if (webView != null) {
            webView.onResume();
        }
    }

    public void ab_() {
        try {
            this.f30462k.onPause();
            xv xvVar = this.f30461j;
            if (xvVar != null) {
                xvVar.c(false);
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        if (this.f30462k != null) {
            removeAllViews();
            setBackground(null);
            try {
                this.f30462k.setId(2064056317);
            } catch (Throwable unused) {
            }
            addView(this.f30462k, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void c_(int i4) {
        this.f30468u.set(true);
        this.f30460i.set(i4);
        if (this.fz.get()) {
            xv(i4);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        try {
            this.f30462k.computeScroll();
        } catch (Throwable unused) {
        }
    }

    public void d_(int i4) {
        w wVar = this.ia;
        if (wVar != null) {
            wVar.c(i4);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        xv xvVar = this.f30461j;
        if (xvVar != null) {
            xvVar.c(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void gd() {
        try {
            this.f30462k.destroy();
        } catch (Throwable unused) {
        }
    }

    public int getContentHeight() {
        try {
            return this.f30462k.getContentHeight();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public com.bytedance.sdk.component.widget.w.c getMaterialMeta() {
        return this.f30458c;
    }

    public String getOriginalUrl() {
        String url;
        try {
            String originalUrl = this.f30462k.getOriginalUrl();
            return (originalUrl == null || !originalUrl.startsWith("data:text/html") || (url = this.f30462k.getUrl()) == null) ? originalUrl : url.startsWith("file://") ? url : originalUrl;
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getProgress() {
        try {
            return this.f30462k.getProgress();
        } catch (Throwable unused) {
            return 100;
        }
    }

    public String getUrl() {
        try {
            return this.f30462k.getUrl();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getUserAgentString() {
        try {
            return this.f30462k.getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public WebView getWebView() {
        return this.f30462k;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public void k() {
        try {
            this.f30462k.pauseTimers();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.fz.set(true);
        if (this.f30468u.get()) {
            xv(this.f30460i.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fz.set(false);
        q qVar = this.f30466s;
        if (qVar != null) {
            qVar.w();
        }
    }

    @Override // android.view.ViewGroup
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent c4;
        try {
            c(motionEvent);
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            if ((motionEvent.getActionMasked() == 2 || motionEvent.getActionMasked() == 0) && this.f30463p && (c4 = c(this)) != null) {
                c4.requestDisallowInterceptTouchEvent(true);
            }
            return onInterceptTouchEvent;
        } catch (Throwable unused) {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        q qVar = this.f30466s;
        if (qVar != null) {
            if (z3) {
                qVar.c();
            } else {
                qVar.w();
            }
        }
    }

    public void p() {
        try {
            this.f30462k.clearView();
        } catch (Throwable unused) {
        }
    }

    public void r() {
        try {
            this.f30462k.clearHistory();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        try {
            this.f30462k.removeAllViews();
        } catch (Throwable unused) {
        }
    }

    public void setAllowFileAccess(boolean z3) {
        try {
            this.f30462k.getSettings().setAllowFileAccess(z3);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setAlpha(float f4) {
        try {
            super.setAlpha(f4);
            this.f30462k.setAlpha(f4);
        } catch (Throwable unused) {
        }
    }

    public void setAppCacheEnabled(boolean z3) {
        try {
            this.f30462k.getSettings().setAppCacheEnabled(z3);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        try {
            this.f30462k.setBackgroundColor(i4);
        } catch (Throwable unused) {
        }
    }

    public void setBuiltInZoomControls(boolean z3) {
        try {
            this.f30462k.getSettings().setBuiltInZoomControls(z3);
        } catch (Throwable unused) {
        }
    }

    public void setCacheMode(int i4) {
        try {
            this.f30462k.getSettings().setCacheMode(i4);
        } catch (Throwable unused) {
        }
    }

    public void setCalculationMethod(int i4) {
        this.ys = i4;
    }

    public void setCalculationTwistMethod(int i4) {
        this.fp = i4;
    }

    public void setDatabaseEnabled(boolean z3) {
        try {
            this.f30462k.getSettings().setDatabaseEnabled(z3);
        } catch (Throwable unused) {
        }
    }

    public void setDeepShakeValue(float f4) {
        this.bk = f4;
    }

    public void setDefaultFontSize(int i4) {
        try {
            this.f30462k.getSettings().setDefaultFontSize(i4);
        } catch (Throwable unused) {
        }
    }

    public void setDefaultTextEncodingName(String str) {
        try {
            this.f30462k.getSettings().setDefaultTextEncodingName(str);
        } catch (Throwable unused) {
        }
    }

    public void setDisplayZoomControls(boolean z3) {
        try {
            this.f30462k.getSettings().setDisplayZoomControls(z3);
        } catch (Throwable unused) {
        }
    }

    public void setDomStorageEnabled(boolean z3) {
        try {
            this.f30462k.getSettings().setDomStorageEnabled(z3);
        } catch (Throwable unused) {
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        try {
            this.f30462k.setDownloadListener(downloadListener);
        } catch (Throwable unused) {
        }
    }

    public void setIsPreventTouchEvent(boolean z3) {
        this.f30463p = z3;
    }

    public void setJavaScriptCanOpenWindowsAutomatically(boolean z3) {
        try {
            this.f30462k.getSettings().setJavaScriptCanOpenWindowsAutomatically(z3);
        } catch (Throwable unused) {
        }
    }

    public void setJavaScriptEnabled(boolean z3) {
        try {
            this.f30462k.getSettings().setJavaScriptEnabled(z3);
        } catch (Throwable unused) {
        }
    }

    public void setLandingPage(boolean z3) {
        this.sr = z3;
    }

    @Override // android.view.View
    public void setLayerType(int i4, Paint paint) {
        try {
            this.f30462k.setLayerType(i4, paint);
        } catch (Throwable unused) {
        }
    }

    public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutAlgorithm) {
        try {
            this.f30462k.getSettings().setLayoutAlgorithm(layoutAlgorithm);
        } catch (Throwable unused) {
        }
    }

    public void setLoadWithOverviewMode(boolean z3) {
        try {
            this.f30462k.getSettings().setLoadWithOverviewMode(z3);
        } catch (Throwable unused) {
        }
    }

    public void setMaterialMeta(com.bytedance.sdk.component.widget.w.c cVar) {
        this.f30458c = cVar;
    }

    public void setMixedContentMode(int i4) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f30462k.getSettings().setMixedContentMode(i4);
            }
        } catch (Throwable unused) {
        }
    }

    public void setNetworkAvailable(boolean z3) {
        try {
            this.f30462k.setNetworkAvailable(z3);
        } catch (Throwable unused) {
        }
    }

    public void setOnShakeListener(w wVar) {
        this.ia = wVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i4) {
        try {
            this.f30462k.setOverScrollMode(i4);
            super.setOverScrollMode(i4);
        } catch (Throwable unused) {
        }
    }

    public void setRecycler(boolean z3) {
    }

    public void setShakeValue(float f4) {
        this.f30457a = f4;
    }

    public void setSupportZoom(boolean z3) {
        try {
            this.f30462k.getSettings().setSupportZoom(z3);
        } catch (Throwable unused) {
        }
    }

    public void setTag(String str) {
        this.f30469w = str;
    }

    public void setTouchStateListener(xv xvVar) {
        this.f30461j = xvVar;
    }

    public void setTwistConfig(JSONObject jSONObject) {
        this.f30464q = jSONObject;
    }

    public void setUseWideViewPort(boolean z3) {
        try {
            this.f30462k.getSettings().setUseWideViewPort(z3);
        } catch (Throwable unused) {
        }
    }

    public void setUserAgentString(String str) {
        try {
            this.f30462k.getSettings().setUserAgentString(str);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        try {
            super.setVisibility(i4);
            this.f30462k.setVisibility(i4);
        } catch (Throwable unused) {
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        try {
            this.f30462k.setWebChromeClient(webChromeClient);
        } catch (Throwable unused) {
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        try {
            if (webViewClient instanceof xv) {
                setTouchStateListener((xv) webViewClient);
            } else {
                setTouchStateListener(null);
            }
            if (webViewClient == null) {
                webViewClient = new c();
            }
            this.f30462k.setWebViewClient(webViewClient);
        } catch (Throwable unused) {
        }
    }

    public void setWriggleValue(float f4) {
        this.f30467t = f4;
    }

    public boolean sr() {
        try {
            return this.f30462k.canGoBack();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void ux() {
        try {
            this.f30462k.goBack();
        } catch (Throwable unused) {
        }
    }

    private void setJavaScriptEnabled(String str) {
        WebSettings settings;
        try {
            if (TextUtils.isEmpty(str) || (settings = this.f30462k.getSettings()) == null) {
                return;
            }
            if (Uri.parse(str).getScheme().equals("file")) {
                settings.setJavaScriptEnabled(false);
            } else {
                settings.setJavaScriptEnabled(true);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public String getTag() {
        return this.f30469w;
    }

    public boolean w() {
        q qVar = this.f30466s;
        if (qVar == null) {
            return false;
        }
        return qVar.ux();
    }

    private static Context c(Context context) {
        int i4 = Build.VERSION.SDK_INT;
        return (i4 < 21 || i4 >= 23) ? context : context.createConfigurationContext(new Configuration());
    }

    private static boolean w(View view) {
        try {
            Class<?> loadClass = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (loadClass != null) {
                if (loadClass.isInstance(view)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            Class<?> loadClass2 = view.getClass().getClassLoader().loadClass("androidx.viewpager.widget.ViewPager");
            if (loadClass2 != null) {
                return loadClass2.isInstance(view);
            }
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    private static void xv(Context context) {
        if (Build.VERSION.SDK_INT != 17 || context == null) {
            return;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(accessibilityManager, 0);
            }
        } catch (Throwable unused) {
        }
    }

    public void c(String str) {
        try {
            setJavaScriptEnabled(str);
            this.f30462k.loadUrl(str);
        } catch (Throwable unused) {
        }
    }

    public void c(boolean z3) {
        try {
            this.f30462k.clearCache(z3);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewParent c(View view) {
        ViewParent parent = view.getParent();
        if ((parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || !(parent instanceof View)) {
            return parent;
        }
        View view2 = (View) parent;
        return (w(view2) || xv(view2)) ? parent : c(view2);
    }

    public void w(String str) {
        try {
            this.f30462k.removeJavascriptInterface(str);
        } catch (Throwable unused) {
        }
    }

    private void xv(int i4) {
        if (this.f30466s == null) {
            this.f30466s = new q(getContext(), i4);
        }
        this.f30466s.c(this.f30457a);
        this.f30466s.xv(this.bk);
        this.f30466s.w(this.f30467t);
        this.f30466s.c(this.f30464q);
        this.f30466s.c(this.ys);
        this.f30466s.w(this.fp);
        this.f30466s.c(new q.c() { // from class: com.bytedance.sdk.component.widget.SSWebView.1
            @Override // com.bytedance.sdk.component.utils.q.c
            public void c(int i5) {
                if (i5 == 1) {
                    SSWebView.this.d_(1);
                } else if (i5 != 2) {
                } else {
                    SSWebView.this.d_(2);
                }
            }
        });
        this.f30466s.xv();
    }

    @SuppressLint({"JavascriptInterface"})
    public void c(Object obj, String str) {
        try {
            this.f30462k.addJavascriptInterface(obj, str);
        } catch (Throwable unused) {
        }
    }

    private void c(MotionEvent motionEvent) {
        if (!this.sr || this.f30458c == null) {
            return;
        }
        if ((this.f30469w == null && this.xv == null) || motionEvent == null) {
            return;
        }
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.ux = motionEvent.getRawX();
                this.f30459f = motionEvent.getRawY();
                this.f30465r = System.currentTimeMillis();
                this.xv = new JSONObject();
                WebView webView = this.f30462k;
                if (webView != null) {
                    webView.setTag(2064056319, Long.valueOf(this.f30465r));
                }
            } else if (action == 1 || action == 3) {
                this.xv.put("start_x", String.valueOf(this.ux));
                this.xv.put("start_y", String.valueOf(this.f30459f));
                this.xv.put("offset_x", String.valueOf(motionEvent.getRawX() - this.ux));
                this.xv.put("offset_y", String.valueOf(motionEvent.getRawY() - this.f30459f));
                this.xv.put("url", String.valueOf(getUrl()));
                this.xv.put("tag", "");
                long currentTimeMillis = System.currentTimeMillis();
                this.ev = currentTimeMillis;
                WebView webView2 = this.f30462k;
                if (webView2 != null) {
                    webView2.setTag(2064056318, Long.valueOf(currentTimeMillis));
                }
                this.xv.put("down_time", this.f30465r);
                this.xv.put("up_time", this.ev);
                if (com.bytedance.sdk.component.widget.c.c.c().w() != null) {
                    long j4 = this.gd;
                    long j5 = this.f30465r;
                    if (j4 != j5) {
                        this.gd = j5;
                        com.bytedance.sdk.component.widget.c.c.c().w().c(this.f30458c, this.f30469w, "in_web_click", this.xv, this.ev - this.f30465r);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
