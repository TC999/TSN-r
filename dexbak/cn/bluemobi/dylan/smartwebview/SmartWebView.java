package cn.bluemobi.dylan.smartwebview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.webkit.GeolocationPermissions;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsJVM;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SmartWebView.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0004\"%'3B\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/B\u0019\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b.\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\tJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\b\u0010\u001d\u001a\u00020\u0002H\u0014R\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010#R\u0018\u0010)\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u00064"}, m12616d2 = {"Lcn/bluemobi/dylan/smartwebview/SmartWebView;", "Landroid/widget/RelativeLayout;", "Lkotlin/f1;", "g", "", "url", "data", "baseUrl", "k", "Landroid/webkit/WebView;", "webView", "setScale", "j", "h", "i", "m", "Lcn/bluemobi/dylan/smartwebview/SmartWebView$c;", "webViewClient", "setWebViewClient", C7304t.f25048d, "Landroid/view/View;", "errorView", "setErrorPage", "Lcn/bluemobi/dylan/smartwebview/SmartWebView$b;", "webChromeClient", "setWebChromeClient", "getWebView", "Landroid/widget/ProgressBar;", "getProgressBar", "onDetachedFromWindow", "a", "Landroid/webkit/WebView;", "mWebView", "", "b", "I", "DEFAULT_BAR_HEIGHT", "c", "mBarHeight", "d", "Lcn/bluemobi/dylan/smartwebview/SmartWebView$c;", "baseWebViewClient", "e", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ProgressStyle", "smartwebview_release"}, m12615k = 1, m12614mv = {1, 4, 2})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class SmartWebView extends RelativeLayout {

    /* renamed from: f */
    private static ProgressBar f1965f;

    /* renamed from: g */
    private static RelativeLayout f1966g;

    /* renamed from: a */
    private WebView f1969a;

    /* renamed from: b */
    private int f1970b;

    /* renamed from: c */
    private int f1971c;

    /* renamed from: d */
    private C1225c f1972d;

    /* renamed from: e */
    private View f1973e;
    @NotNull

    /* renamed from: i */
    public static final C1227d f1968i = new C1227d(null);

    /* renamed from: h */
    private static int f1967h = ProgressStyle.Horizontal.ordinal();

    /* compiled from: SmartWebView.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m12616d2 = {"Lcn/bluemobi/dylan/smartwebview/SmartWebView$ProgressStyle;", "", "(Ljava/lang/String;I)V", "Horizontal", "Circle", "smartwebview_release"}, m12615k = 1, m12614mv = {1, 4, 2})
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public enum ProgressStyle {
        Horizontal,
        Circle
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SmartWebView.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m12616d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "Lkotlin/f1;", "onClick", "(Landroid/view/View;)V", "cn/bluemobi/dylan/smartwebview/SmartWebView$initWebView$1$1$1", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 2})
    /* renamed from: cn.bluemobi.dylan.smartwebview.SmartWebView$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class View$OnClickListenerC1220a implements View.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ WebSettings f1975b;

        View$OnClickListenerC1220a(WebSettings webSettings) {
            this.f1975b = webSettings;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SmartWebView.this.m57491l();
        }
    }

    /* compiled from: SmartWebView.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f"}, m12616d2 = {"Lcn/bluemobi/dylan/smartwebview/SmartWebView$b;", "Landroid/webkit/WebChromeClient;", "", "origin", "Landroid/webkit/GeolocationPermissions$Callback;", "callback", "Lkotlin/f1;", "onGeolocationPermissionsShowPrompt", "Landroid/webkit/WebView;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", "newProgress", "onProgressChanged", "<init>", "()V", "smartwebview_release"}, m12615k = 1, m12614mv = {1, 4, 2})
    /* renamed from: cn.bluemobi.dylan.smartwebview.SmartWebView$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1221b extends WebChromeClient {

        /* compiled from: SmartWebView.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, m12616d2 = {"Lkotlin/f1;", "run", "()V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 2})
        /* renamed from: cn.bluemobi.dylan.smartwebview.SmartWebView$b$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        static final class RunnableC1222a implements Runnable {

            /* renamed from: a */
            public static final RunnableC1222a f1976a = new RunnableC1222a();

            RunnableC1222a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ProgressBar progressBar = SmartWebView.f1965f;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
            }
        }

        /* compiled from: SmartWebView.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, m12616d2 = {"Lkotlin/f1;", "run", "()V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 2})
        /* renamed from: cn.bluemobi.dylan.smartwebview.SmartWebView$b$b */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        static final class RunnableC1223b implements Runnable {

            /* renamed from: a */
            public static final RunnableC1223b f1977a = new RunnableC1223b();

            RunnableC1223b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                RelativeLayout relativeLayout = SmartWebView.f1966g;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            }
        }

        /* compiled from: SmartWebView.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, m12616d2 = {"Lkotlin/f1;", "run", "()V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 2})
        /* renamed from: cn.bluemobi.dylan.smartwebview.SmartWebView$b$c */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        static final class RunnableC1224c implements Runnable {

            /* renamed from: a */
            public static final RunnableC1224c f1978a = new RunnableC1224c();

            RunnableC1224c() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                RelativeLayout relativeLayout = SmartWebView.f1966g;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(@NotNull String origin, @NotNull GeolocationPermissions.Callback callback) {
            C14342f0.m8184p(origin, "origin");
            C14342f0.m8184p(callback, "callback");
            super.onGeolocationPermissionsShowPrompt(origin, callback);
            callback.invoke(origin, true, false);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(@NotNull WebView view, int i) {
            ProgressBar progressBar;
            C14342f0.m8184p(view, "view");
            super.onProgressChanged(view, i);
            if (i == 100) {
                ProgressBar progressBar2 = SmartWebView.f1965f;
                if (progressBar2 != null) {
                    progressBar2.postDelayed(RunnableC1222a.f1976a, 10L);
                }
                RelativeLayout relativeLayout = SmartWebView.f1966g;
                if (relativeLayout != null) {
                    relativeLayout.postDelayed(RunnableC1223b.f1977a, 10L);
                }
            } else if (SmartWebView.f1967h == ProgressStyle.Horizontal.ordinal()) {
                ProgressBar progressBar3 = SmartWebView.f1965f;
                if (progressBar3 != null) {
                    progressBar3.setProgress(i);
                    if (!(progressBar3.getVisibility() == 8)) {
                        progressBar3 = null;
                    }
                    if (progressBar3 == null || (progressBar = SmartWebView.f1965f) == null) {
                        return;
                    }
                    progressBar.setVisibility(0);
                }
            } else {
                RelativeLayout relativeLayout2 = SmartWebView.f1966g;
                if (relativeLayout2 != null) {
                    relativeLayout2.postDelayed(RunnableC1224c.f1978a, 10L);
                }
            }
        }
    }

    /* compiled from: SmartWebView.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J&\u0010\f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0017J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001aR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001c¨\u0006\u001f"}, m12616d2 = {"Lcn/bluemobi/dylan/smartwebview/SmartWebView$c;", "Landroid/webkit/WebViewClient;", "Landroid/webkit/WebView;", "webView", "Lkotlin/f1;", "b", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "c", "Landroid/webkit/SslErrorHandler;", "handler", "Landroid/net/http/SslError;", "error", "onReceivedSslError", "Landroid/webkit/WebResourceRequest;", "webResourceRequest", "Landroid/webkit/WebResourceError;", "webResourceError", "onReceivedError", "Landroid/view/View;", "errorView", "a", "", "url", "onPageFinished", "", "shouldOverrideUrlLoading", "Z", "isError", "Landroid/view/View;", "<init>", "()V", "smartwebview_release"}, m12615k = 1, m12614mv = {1, 4, 2})
    /* renamed from: cn.bluemobi.dylan.smartwebview.SmartWebView$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1225c extends WebViewClient {

        /* renamed from: a */
        private boolean f1979a;

        /* renamed from: b */
        private View f1980b;

        /* compiled from: SmartWebView.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, m12616d2 = {"Lkotlin/f1;", "run", "()V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 2})
        /* renamed from: cn.bluemobi.dylan.smartwebview.SmartWebView$c$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        static final class RunnableC1226a implements Runnable {

            /* renamed from: a */
            public static final RunnableC1226a f1981a = new RunnableC1226a();

            RunnableC1226a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ProgressBar progressBar = SmartWebView.f1965f;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
            }
        }

        /* renamed from: b */
        private final void m57488b(WebView webView) {
            this.f1979a = true;
            if (Build.VERSION.SDK_INT >= 19 && webView != null) {
                webView.evaluateJavascript("javascript:document.open();document.write('');document.close();", null);
            }
            View view = this.f1980b;
            if (view != null) {
                if (view != null) {
                    view.setVisibility(0);
                }
                if (webView != null) {
                    webView.setVisibility(8);
                }
            }
        }

        /* renamed from: c */
        private final void m57487c(WebView webView) {
            View view = this.f1980b;
            if (view != null) {
                if (view != null) {
                    view.setVisibility(8);
                }
                if (webView != null) {
                    webView.setVisibility(0);
                }
            }
        }

        /* renamed from: a */
        public final void m57489a(@NotNull View errorView) {
            C14342f0.m8184p(errorView, "errorView");
            this.f1980b = errorView;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
            super.onPageFinished(webView, str);
            ProgressBar progressBar = SmartWebView.f1965f;
            if (progressBar != null) {
                progressBar.postDelayed(RunnableC1226a.f1981a, 10L);
            }
            if (this.f1979a) {
                m57488b(webView);
            } else {
                m57487c(webView);
            }
            this.f1979a = false;
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public void onReceivedError(@Nullable WebView webView, @NotNull WebResourceRequest webResourceRequest, @Nullable WebResourceError webResourceError) {
            C14342f0.m8184p(webResourceRequest, "webResourceRequest");
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceRequest.isForMainFrame()) {
                m57488b(webView);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(@Nullable WebView webView, @Nullable SslErrorHandler sslErrorHandler, @Nullable SslError sslError) {
            if (sslErrorHandler != null) {
                sslErrorHandler.proceed();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String url) {
            boolean m6548u2;
            boolean m6548u22;
            boolean m6604K1;
            C14342f0.m8184p(webView, "webView");
            C14342f0.m8184p(url, "url");
            webView.loadUrl(url);
            m6548u2 = StringsJVM.m6548u2(url, "http://", false, 2, null);
            if (!m6548u2) {
                m6548u22 = StringsJVM.m6548u2(url, "https://", false, 2, null);
                if (!m6548u22) {
                    Uri parse = Uri.parse(url);
                    C14342f0.m8185o(parse, "Uri.parse(url)");
                    m6604K1 = StringsJVM.m6604K1("bilibili", parse.getScheme(), true);
                    return m6604K1;
                }
            }
            return true;
        }
    }

    /* compiled from: SmartWebView.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, m12616d2 = {"Lcn/bluemobi/dylan/smartwebview/SmartWebView$d;", "", "", "mProgressStyle", "I", "Landroid/widget/ProgressBar;", "progressBar", "Landroid/widget/ProgressBar;", "Landroid/widget/RelativeLayout;", "progressBarCircle", "Landroid/widget/RelativeLayout;", "<init>", "()V", "smartwebview_release"}, m12615k = 1, m12614mv = {1, 4, 2})
    /* renamed from: cn.bluemobi.dylan.smartwebview.SmartWebView$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class C1227d {
        private C1227d() {
        }

        public /* synthetic */ C1227d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartWebView(@NotNull Context context) {
        super(context);
        C14342f0.m8184p(context, "context");
        this.f1970b = 8;
        this.f1971c = 8;
        m57496g();
    }

    /* renamed from: g */
    private final void m57496g() {
        this.f1969a = new WebView(getContext());
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        WebView webView = this.f1969a;
        if (webView == null) {
            C14342f0.m8200S("mWebView");
        }
        setScale(webView);
        WebView webView2 = this.f1969a;
        if (webView2 == null) {
            C14342f0.m8200S("mWebView");
        }
        webView2.setInitialScale(3);
        View view = this.f1969a;
        if (view == null) {
            C14342f0.m8200S("mWebView");
        }
        addView(view, -1, -1);
        if (f1967h == ProgressStyle.Horizontal.ordinal()) {
            View inflate = LayoutInflater.from(getContext()).inflate(C1214R.C1218layout.ac_progress_horizontal, (ViewGroup) null);
            if (inflate != null) {
                ProgressBar progressBar = (ProgressBar) inflate;
                f1965f = progressBar;
                progressBar.setMax(100);
                ProgressBar progressBar2 = f1965f;
                if (progressBar2 != null) {
                    progressBar2.setProgress(0);
                }
                addView(f1965f, -1, this.f1971c);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ProgressBar");
            }
        } else {
            View inflate2 = LayoutInflater.from(getContext()).inflate(C1214R.C1218layout.ac_progress_circle, (ViewGroup) null);
            if (inflate2 != null) {
                RelativeLayout relativeLayout = (RelativeLayout) inflate2;
                f1966g = relativeLayout;
                addView(relativeLayout, -1, -1);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
            }
        }
        this.f1972d = new C1225c();
        WebView webView3 = this.f1969a;
        if (webView3 == null) {
            C14342f0.m8200S("mWebView");
        }
        webView3.setWebViewClient(this.f1972d);
        WebView webView4 = this.f1969a;
        if (webView4 == null) {
            C14342f0.m8200S("mWebView");
        }
        webView4.setWebChromeClient(new C1221b());
        WebView webView5 = this.f1969a;
        if (webView5 == null) {
            C14342f0.m8200S("mWebView");
        }
        WebSettings webSettings = webView5.getSettings();
        int i = Build.VERSION.SDK_INT;
        webSettings.setLoadsImagesAutomatically(i >= 19);
        if (i >= 21) {
            webSettings.setMixedContentMode(2);
        }
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSavePassword(false);
        webSettings.setBlockNetworkImage(false);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setAllowFileAccess(false);
        webSettings.setCacheMode(2);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setDatabaseEnabled(true);
        String path = getContext().getDir("database", 0).getPath();
        webSettings.setGeolocationEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setGeolocationDatabasePath(path);
        webSettings.setBuiltInZoomControls(false);
        C14342f0.m8185o(webSettings, "webSettings");
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setSupportZoom(false);
        View errorPageView = LayoutInflater.from(getContext()).inflate(C1214R.C1218layout.default_error_page, (ViewGroup) null);
        ((Button) errorPageView.findViewById(C1214R.C1217id.bt_error_retry)).setOnClickListener(new View$OnClickListenerC1220a(webSettings));
        C14342f0.m8185o(errorPageView, "errorPageView");
        setErrorPage(errorPageView);
    }

    /* renamed from: k */
    private final void m57492k(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            WebView webView = this.f1969a;
            if (webView == null) {
                C14342f0.m8200S("mWebView");
            }
            webView.loadUrl(str);
        } else if (!TextUtils.isEmpty(str3)) {
            WebView webView2 = this.f1969a;
            if (webView2 == null) {
                C14342f0.m8200S("mWebView");
            }
            webView2.loadDataWithBaseURL(str3, str2, "text/html", "UTF-8", str3);
        } else if (TextUtils.isEmpty(str2)) {
        } else {
            WebView webView3 = this.f1969a;
            if (webView3 == null) {
                C14342f0.m8200S("mWebView");
            }
            webView3.loadData(str2, "text/html", "UTF-8");
        }
    }

    private final void setScale(WebView webView) {
        Object systemService = getContext().getSystemService("window");
        if (systemService != null) {
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            C14342f0.m8185o(defaultDisplay, "wm.defaultDisplay");
            int width = defaultDisplay.getWidth();
            if (width > 650) {
                webView.setInitialScale(190);
                return;
            } else if (width > 520) {
                webView.setInitialScale(160);
                return;
            } else if (width > 450) {
                webView.setInitialScale(140);
                return;
            } else if (width > 300) {
                webView.setInitialScale(120);
                return;
            } else {
                webView.setInitialScale(100);
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    @Nullable
    public final ProgressBar getProgressBar() {
        return f1965f;
    }

    @NotNull
    public final WebView getWebView() {
        WebView webView = this.f1969a;
        if (webView == null) {
            C14342f0.m8200S("mWebView");
        }
        return webView;
    }

    /* renamed from: h */
    public final void m57495h(@NotNull String data) {
        C14342f0.m8184p(data, "data");
        m57492k(null, data, null);
    }

    /* renamed from: i */
    public final void m57494i(@NotNull String data, @NotNull String baseUrl) {
        C14342f0.m8184p(data, "data");
        C14342f0.m8184p(baseUrl, "baseUrl");
        m57492k(null, data, baseUrl);
    }

    /* renamed from: j */
    public final void m57493j(@NotNull String url) {
        C14342f0.m8184p(url, "url");
        m57492k(url, null, null);
    }

    /* renamed from: l */
    public final void m57491l() {
        WebView webView = this.f1969a;
        if (webView == null) {
            C14342f0.m8200S("mWebView");
        }
        webView.reload();
    }

    /* renamed from: m */
    public final void m57490m() {
        WebView webView = this.f1969a;
        if (webView == null) {
            C14342f0.m8200S("mWebView");
        }
        WebSettings settings = webView.getSettings();
        settings.setAppCacheEnabled(true);
        C14342f0.m8185o(settings, "settings");
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(-1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        f1965f = null;
        WebView webView = this.f1969a;
        if (webView == null) {
            C14342f0.m8200S("mWebView");
        }
        removeView(webView);
        WebView webView2 = this.f1969a;
        if (webView2 == null) {
            C14342f0.m8200S("mWebView");
        }
        webView2.stopLoading();
        WebView webView3 = this.f1969a;
        if (webView3 == null) {
            C14342f0.m8200S("mWebView");
        }
        WebSettings settings = webView3.getSettings();
        C14342f0.m8185o(settings, "mWebView.settings");
        settings.setJavaScriptEnabled(false);
        WebView webView4 = this.f1969a;
        if (webView4 == null) {
            C14342f0.m8200S("mWebView");
        }
        webView4.clearHistory();
        WebView webView5 = this.f1969a;
        if (webView5 == null) {
            C14342f0.m8200S("mWebView");
        }
        webView5.removeAllViews();
        WebView webView6 = this.f1969a;
        if (webView6 == null) {
            C14342f0.m8200S("mWebView");
        }
        webView6.destroy();
        super.onDetachedFromWindow();
    }

    public final void setErrorPage(@NotNull View errorView) {
        C14342f0.m8184p(errorView, "errorView");
        this.f1973e = errorView;
        errorView.setVisibility(8);
        if (errorView.getParent() != null) {
            ViewParent parent = errorView.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ((ViewGroup) parent).removeView(errorView);
        }
        addView(errorView, -1, -1);
        C1225c c1225c = this.f1972d;
        if (c1225c != null) {
            c1225c.m57489a(errorView);
        }
    }

    public final void setWebChromeClient(@NotNull C1221b webChromeClient) {
        C14342f0.m8184p(webChromeClient, "webChromeClient");
        WebView webView = this.f1969a;
        if (webView == null) {
            C14342f0.m8200S("mWebView");
        }
        webView.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(@NotNull C1225c webViewClient) {
        C14342f0.m8184p(webViewClient, "webViewClient");
        this.f1972d = webViewClient;
        WebView webView = this.f1969a;
        if (webView == null) {
            C14342f0.m8200S("mWebView");
        }
        webView.setWebViewClient(webViewClient);
        View view = this.f1973e;
        if (view != null) {
            setErrorPage(view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartWebView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        C14342f0.m8184p(context, "context");
        C14342f0.m8184p(attrs, "attrs");
        this.f1970b = 8;
        this.f1971c = 8;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, C1214R.styleable.WebViewWithProgress);
        f1967h = obtainStyledAttributes.getInt(C1214R.styleable.WebViewWithProgress_progressStyle, ProgressStyle.Horizontal.ordinal());
        this.f1971c = obtainStyledAttributes.getDimensionPixelSize(C1214R.styleable.WebViewWithProgress_barHeight, this.f1970b);
        obtainStyledAttributes.recycle();
        m57496g();
    }
}
