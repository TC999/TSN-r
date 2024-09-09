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
import cn.jpush.android.local.JPushConstants;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: SmartWebView.kt */
@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0004\"%'3B\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/B\u0019\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u00101\u001a\u000200\u00a2\u0006\u0004\b.\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\tJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\b\u0010\u001d\u001a\u00020\u0002H\u0014R\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0018\u0010)\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00064"}, d2 = {"Lcn/bluemobi/dylan/smartwebview/SmartWebView;", "Landroid/widget/RelativeLayout;", "Lkotlin/f1;", "g", "", "url", "data", "baseUrl", "k", "Landroid/webkit/WebView;", "webView", "setScale", "j", "h", "i", "m", "Lcn/bluemobi/dylan/smartwebview/SmartWebView$c;", "webViewClient", "setWebViewClient", "l", "Landroid/view/View;", "errorView", "setErrorPage", "Lcn/bluemobi/dylan/smartwebview/SmartWebView$b;", "webChromeClient", "setWebChromeClient", "getWebView", "Landroid/widget/ProgressBar;", "getProgressBar", "onDetachedFromWindow", "a", "Landroid/webkit/WebView;", "mWebView", "", "b", "I", "DEFAULT_BAR_HEIGHT", "c", "mBarHeight", "d", "Lcn/bluemobi/dylan/smartwebview/SmartWebView$c;", "baseWebViewClient", "e", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ProgressStyle", "smartwebview_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class SmartWebView extends RelativeLayout {

    /* renamed from: f  reason: collision with root package name */
    private static ProgressBar f1942f;

    /* renamed from: g  reason: collision with root package name */
    private static RelativeLayout f1943g;

    /* renamed from: a  reason: collision with root package name */
    private WebView f1946a;

    /* renamed from: b  reason: collision with root package name */
    private int f1947b;

    /* renamed from: c  reason: collision with root package name */
    private int f1948c;

    /* renamed from: d  reason: collision with root package name */
    private c f1949d;

    /* renamed from: e  reason: collision with root package name */
    private View f1950e;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public static final d f1945i = new d(null);

    /* renamed from: h  reason: collision with root package name */
    private static int f1944h = ProgressStyle.Horizontal.ordinal();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: SmartWebView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcn/bluemobi/dylan/smartwebview/SmartWebView$ProgressStyle;", "", "(Ljava/lang/String;I)V", "Horizontal", "Circle", "smartwebview_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public enum ProgressStyle {
        Horizontal,
        Circle
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: SmartWebView.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "Lkotlin/f1;", "onClick", "(Landroid/view/View;)V", "cn/bluemobi/dylan/smartwebview/SmartWebView$initWebView$1$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WebSettings f1952b;

        a(WebSettings webSettings) {
            this.f1952b = webSettings;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SmartWebView.this.l();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: SmartWebView.kt */
    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcn/bluemobi/dylan/smartwebview/SmartWebView$b;", "Landroid/webkit/WebChromeClient;", "", LiveConfigKey.ORIGIN, "Landroid/webkit/GeolocationPermissions$Callback;", "callback", "Lkotlin/f1;", "onGeolocationPermissionsShowPrompt", "Landroid/webkit/WebView;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "", "newProgress", "onProgressChanged", "<init>", "()V", "smartwebview_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class b extends WebChromeClient {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
        /* compiled from: SmartWebView.kt */
        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/f1;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public static final a f1953a = new a();

            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ProgressBar progressBar = SmartWebView.f1942f;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
        /* compiled from: SmartWebView.kt */
        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/f1;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: cn.bluemobi.dylan.smartwebview.SmartWebView$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        static final class RunnableC0042b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public static final RunnableC0042b f1954a = new RunnableC0042b();

            RunnableC0042b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                RelativeLayout relativeLayout = SmartWebView.f1943g;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
        /* compiled from: SmartWebView.kt */
        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/f1;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        static final class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public static final c f1955a = new c();

            c() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                RelativeLayout relativeLayout = SmartWebView.f1943g;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(@NotNull String origin, @NotNull GeolocationPermissions.Callback callback) {
            f0.p(origin, "origin");
            f0.p(callback, "callback");
            super.onGeolocationPermissionsShowPrompt(origin, callback);
            callback.invoke(origin, true, false);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(@NotNull WebView view, int i4) {
            ProgressBar progressBar;
            f0.p(view, "view");
            super.onProgressChanged(view, i4);
            if (i4 == 100) {
                ProgressBar progressBar2 = SmartWebView.f1942f;
                if (progressBar2 != null) {
                    progressBar2.postDelayed(a.f1953a, 10L);
                }
                RelativeLayout relativeLayout = SmartWebView.f1943g;
                if (relativeLayout != null) {
                    relativeLayout.postDelayed(RunnableC0042b.f1954a, 10L);
                }
            } else if (SmartWebView.f1944h == ProgressStyle.Horizontal.ordinal()) {
                ProgressBar progressBar3 = SmartWebView.f1942f;
                if (progressBar3 != null) {
                    progressBar3.setProgress(i4);
                    if (!(progressBar3.getVisibility() == 8)) {
                        progressBar3 = null;
                    }
                    if (progressBar3 == null || (progressBar = SmartWebView.f1942f) == null) {
                        return;
                    }
                    progressBar.setVisibility(0);
                }
            } else {
                RelativeLayout relativeLayout2 = SmartWebView.f1943g;
                if (relativeLayout2 != null) {
                    relativeLayout2.postDelayed(c.f1955a, 10L);
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: SmartWebView.kt */
    @Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J&\u0010\f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0017J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001aR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcn/bluemobi/dylan/smartwebview/SmartWebView$c;", "Landroid/webkit/WebViewClient;", "Landroid/webkit/WebView;", "webView", "Lkotlin/f1;", "b", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "c", "Landroid/webkit/SslErrorHandler;", "handler", "Landroid/net/http/SslError;", "error", "onReceivedSslError", "Landroid/webkit/WebResourceRequest;", "webResourceRequest", "Landroid/webkit/WebResourceError;", "webResourceError", "onReceivedError", "Landroid/view/View;", "errorView", "a", "", "url", "onPageFinished", "", "shouldOverrideUrlLoading", "Z", "isError", "Landroid/view/View;", "<init>", "()V", "smartwebview_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class c extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1956a;

        /* renamed from: b  reason: collision with root package name */
        private View f1957b;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
        /* compiled from: SmartWebView.kt */
        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/f1;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public static final a f1958a = new a();

            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ProgressBar progressBar = SmartWebView.f1942f;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
            }
        }

        private final void b(WebView webView) {
            this.f1956a = true;
            if (Build.VERSION.SDK_INT >= 19 && webView != null) {
                webView.evaluateJavascript("javascript:document.open();document.write('');document.close();", null);
            }
            View view = this.f1957b;
            if (view != null) {
                if (view != null) {
                    view.setVisibility(0);
                }
                if (webView != null) {
                    webView.setVisibility(8);
                }
            }
        }

        private final void c(WebView webView) {
            View view = this.f1957b;
            if (view != null) {
                if (view != null) {
                    view.setVisibility(8);
                }
                if (webView != null) {
                    webView.setVisibility(0);
                }
            }
        }

        public final void a(@NotNull View errorView) {
            f0.p(errorView, "errorView");
            this.f1957b = errorView;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
            super.onPageFinished(webView, str);
            ProgressBar progressBar = SmartWebView.f1942f;
            if (progressBar != null) {
                progressBar.postDelayed(a.f1958a, 10L);
            }
            if (this.f1956a) {
                b(webView);
            } else {
                c(webView);
            }
            this.f1956a = false;
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public void onReceivedError(@Nullable WebView webView, @NotNull WebResourceRequest webResourceRequest, @Nullable WebResourceError webResourceError) {
            f0.p(webResourceRequest, "webResourceRequest");
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceRequest.isForMainFrame()) {
                b(webView);
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
            boolean u22;
            boolean u23;
            boolean K1;
            f0.p(webView, "webView");
            f0.p(url, "url");
            webView.loadUrl(url);
            u22 = w.u2(url, JPushConstants.HTTP_PRE, false, 2, null);
            if (!u22) {
                u23 = w.u2(url, JPushConstants.HTTPS_PRE, false, 2, null);
                if (!u23) {
                    Uri parse = Uri.parse(url);
                    f0.o(parse, "Uri.parse(url)");
                    K1 = w.K1("bilibili", parse.getScheme(), true);
                    return K1;
                }
            }
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: SmartWebView.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcn/bluemobi/dylan/smartwebview/SmartWebView$d;", "", "", "mProgressStyle", "I", "Landroid/widget/ProgressBar;", "progressBar", "Landroid/widget/ProgressBar;", "Landroid/widget/RelativeLayout;", "progressBarCircle", "Landroid/widget/RelativeLayout;", "<init>", "()V", "smartwebview_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(u uVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartWebView(@NotNull Context context) {
        super(context);
        f0.p(context, "context");
        this.f1947b = 8;
        this.f1948c = 8;
        g();
    }

    private final void g() {
        this.f1946a = new WebView(getContext());
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        WebView webView = this.f1946a;
        if (webView == null) {
            f0.S("mWebView");
        }
        setScale(webView);
        WebView webView2 = this.f1946a;
        if (webView2 == null) {
            f0.S("mWebView");
        }
        webView2.setInitialScale(3);
        View view = this.f1946a;
        if (view == null) {
            f0.S("mWebView");
        }
        addView(view, -1, -1);
        if (f1944h == ProgressStyle.Horizontal.ordinal()) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ac_progress_horizontal, (ViewGroup) null);
            if (inflate != null) {
                ProgressBar progressBar = (ProgressBar) inflate;
                f1942f = progressBar;
                progressBar.setMax(100);
                ProgressBar progressBar2 = f1942f;
                if (progressBar2 != null) {
                    progressBar2.setProgress(0);
                }
                addView(f1942f, -1, this.f1948c);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ProgressBar");
            }
        } else {
            View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.ac_progress_circle, (ViewGroup) null);
            if (inflate2 != null) {
                RelativeLayout relativeLayout = (RelativeLayout) inflate2;
                f1943g = relativeLayout;
                addView(relativeLayout, -1, -1);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
            }
        }
        this.f1949d = new c();
        WebView webView3 = this.f1946a;
        if (webView3 == null) {
            f0.S("mWebView");
        }
        webView3.setWebViewClient(this.f1949d);
        WebView webView4 = this.f1946a;
        if (webView4 == null) {
            f0.S("mWebView");
        }
        webView4.setWebChromeClient(new b());
        WebView webView5 = this.f1946a;
        if (webView5 == null) {
            f0.S("mWebView");
        }
        WebSettings webSettings = webView5.getSettings();
        int i4 = Build.VERSION.SDK_INT;
        webSettings.setLoadsImagesAutomatically(i4 >= 19);
        if (i4 >= 21) {
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
        f0.o(webSettings, "webSettings");
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setSupportZoom(false);
        View errorPageView = LayoutInflater.from(getContext()).inflate(R.layout.default_error_page, (ViewGroup) null);
        ((Button) errorPageView.findViewById(R.id.bt_error_retry)).setOnClickListener(new a(webSettings));
        f0.o(errorPageView, "errorPageView");
        setErrorPage(errorPageView);
    }

    private final void k(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            WebView webView = this.f1946a;
            if (webView == null) {
                f0.S("mWebView");
            }
            webView.loadUrl(str);
        } else if (!TextUtils.isEmpty(str3)) {
            WebView webView2 = this.f1946a;
            if (webView2 == null) {
                f0.S("mWebView");
            }
            webView2.loadDataWithBaseURL(str3, str2, "text/html", "UTF-8", str3);
        } else if (TextUtils.isEmpty(str2)) {
        } else {
            WebView webView3 = this.f1946a;
            if (webView3 == null) {
                f0.S("mWebView");
            }
            webView3.loadData(str2, "text/html", "UTF-8");
        }
    }

    private final void setScale(WebView webView) {
        Object systemService = getContext().getSystemService("window");
        if (systemService != null) {
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            f0.o(defaultDisplay, "wm.defaultDisplay");
            int width = defaultDisplay.getWidth();
            if (width > 650) {
                webView.setInitialScale(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME);
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
        return f1942f;
    }

    @NotNull
    public final WebView getWebView() {
        WebView webView = this.f1946a;
        if (webView == null) {
            f0.S("mWebView");
        }
        return webView;
    }

    public final void h(@NotNull String data) {
        f0.p(data, "data");
        k(null, data, null);
    }

    public final void i(@NotNull String data, @NotNull String baseUrl) {
        f0.p(data, "data");
        f0.p(baseUrl, "baseUrl");
        k(null, data, baseUrl);
    }

    public final void j(@NotNull String url) {
        f0.p(url, "url");
        k(url, null, null);
    }

    public final void l() {
        WebView webView = this.f1946a;
        if (webView == null) {
            f0.S("mWebView");
        }
        webView.reload();
    }

    public final void m() {
        WebView webView = this.f1946a;
        if (webView == null) {
            f0.S("mWebView");
        }
        WebSettings settings = webView.getSettings();
        settings.setAppCacheEnabled(true);
        f0.o(settings, "settings");
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(-1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        f1942f = null;
        WebView webView = this.f1946a;
        if (webView == null) {
            f0.S("mWebView");
        }
        removeView(webView);
        WebView webView2 = this.f1946a;
        if (webView2 == null) {
            f0.S("mWebView");
        }
        webView2.stopLoading();
        WebView webView3 = this.f1946a;
        if (webView3 == null) {
            f0.S("mWebView");
        }
        WebSettings settings = webView3.getSettings();
        f0.o(settings, "mWebView.settings");
        settings.setJavaScriptEnabled(false);
        WebView webView4 = this.f1946a;
        if (webView4 == null) {
            f0.S("mWebView");
        }
        webView4.clearHistory();
        WebView webView5 = this.f1946a;
        if (webView5 == null) {
            f0.S("mWebView");
        }
        webView5.removeAllViews();
        WebView webView6 = this.f1946a;
        if (webView6 == null) {
            f0.S("mWebView");
        }
        webView6.destroy();
        super.onDetachedFromWindow();
    }

    public final void setErrorPage(@NotNull View errorView) {
        f0.p(errorView, "errorView");
        this.f1950e = errorView;
        errorView.setVisibility(8);
        if (errorView.getParent() != null) {
            ViewParent parent = errorView.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ((ViewGroup) parent).removeView(errorView);
        }
        addView(errorView, -1, -1);
        c cVar = this.f1949d;
        if (cVar != null) {
            cVar.a(errorView);
        }
    }

    public final void setWebChromeClient(@NotNull b webChromeClient) {
        f0.p(webChromeClient, "webChromeClient");
        WebView webView = this.f1946a;
        if (webView == null) {
            f0.S("mWebView");
        }
        webView.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(@NotNull c webViewClient) {
        f0.p(webViewClient, "webViewClient");
        this.f1949d = webViewClient;
        WebView webView = this.f1946a;
        if (webView == null) {
            f0.S("mWebView");
        }
        webView.setWebViewClient(webViewClient);
        View view = this.f1950e;
        if (view != null) {
            setErrorPage(view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartWebView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        f0.p(context, "context");
        f0.p(attrs, "attrs");
        this.f1947b = 8;
        this.f1948c = 8;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.WebViewWithProgress);
        f1944h = obtainStyledAttributes.getInt(R.styleable.WebViewWithProgress_progressStyle, ProgressStyle.Horizontal.ordinal());
        this.f1948c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.WebViewWithProgress_barHeight, this.f1947b);
        obtainStyledAttributes.recycle();
        g();
    }
}
