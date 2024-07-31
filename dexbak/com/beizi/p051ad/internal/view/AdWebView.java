package com.beizi.p051ad.internal.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.beizi.p051ad.AdActivity;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.internal.CreativeType;
import com.beizi.p051ad.internal.EnumC2888k;
import com.beizi.p051ad.internal.activity.BrowserAdActivity;
import com.beizi.p051ad.internal.network.ServerResponse;
import com.beizi.p051ad.internal.utilities.HTTPGet;
import com.beizi.p051ad.internal.utilities.HTTPResponse;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.SPUtils;
import com.beizi.p051ad.internal.utilities.StringUtil;
import com.beizi.p051ad.internal.utilities.ViewUtil;
import com.beizi.p051ad.internal.utilities.WebviewUtil;
import com.beizi.p051ad.internal.video.AdVideoView;
import com.beizi.p051ad.internal.view.AdViewImpl;
import com.beizi.p051ad.internal.view.MRAIDImplementation;
import com.beizi.p051ad.lance.p062a.C3019b;
import com.beizi.p051ad.lance.p062a.HeaderUtil;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.beizi.p051ad.p056c.ClickPositionModel;
import com.beizi.p051ad.p056c.EnumType;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.material.badge.BadgeDrawable;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import master.flame.danmaku.danmaku.parser.IDataSource;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.beizi.ad.internal.view.AdWebView */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdWebView extends WebView implements Displayable {

    /* renamed from: A */
    private boolean f10613A;

    /* renamed from: B */
    private boolean f10614B;

    /* renamed from: C */
    private boolean f10615C;

    /* renamed from: D */
    private boolean f10616D;

    /* renamed from: E */
    private int f10617E;

    /* renamed from: F */
    private long f10618F;

    /* renamed from: G */
    private float f10619G;

    /* renamed from: H */
    private float f10620H;

    /* renamed from: I */
    private boolean f10621I;

    /* renamed from: J */
    private HttpURLConnection f10622J;

    /* renamed from: K */
    private InputStream f10623K;

    /* renamed from: L */
    private final Runnable f10624L;

    /* renamed from: a */
    boolean f10625a;

    /* renamed from: ad */
    public ServerResponse f10626ad;
    public AdViewImpl adViewImpl;

    /* renamed from: b */
    protected String f10627b;

    /* renamed from: c */
    boolean f10628c;

    /* renamed from: d */
    private boolean f10629d;

    /* renamed from: e */
    private boolean f10630e;

    /* renamed from: f */
    private MRAIDImplementation f10631f;

    /* renamed from: g */
    private int f10632g;
    public GestureDetector gestureDetector;

    /* renamed from: h */
    private int f10633h;

    /* renamed from: i */
    private boolean f10634i;

    /* renamed from: j */
    private int f10635j;

    /* renamed from: k */
    private int f10636k;

    /* renamed from: l */
    private int f10637l;

    /* renamed from: m */
    private int f10638m;
    public AdVideoView mAdVideoView;

    /* renamed from: n */
    private int f10639n;

    /* renamed from: o */
    private boolean f10640o;

    /* renamed from: p */
    private boolean f10641p;

    /* renamed from: q */
    private Handler f10642q;

    /* renamed from: r */
    private boolean f10643r;

    /* renamed from: s */
    private int f10644s;

    /* renamed from: t */
    private ProgressDialog f10645t;

    /* renamed from: u */
    private boolean f10646u;

    /* renamed from: v */
    private boolean f10647v;

    /* renamed from: w */
    private int f10648w;

    /* renamed from: x */
    private int f10649x;

    /* renamed from: y */
    private int f10650y;

    /* renamed from: z */
    private boolean f10651z;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.beizi.ad.internal.view.AdWebView$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2991a extends WebViewClient {
        private C2991a() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            if (str.startsWith(IDataSource.f43971a)) {
                try {
                    WebView.HitTestResult hitTestResult = AdWebView.this.getHitTestResult();
                    if (hitTestResult == null || hitTestResult.getExtra() == null) {
                        return;
                    }
                    if (hitTestResult.getExtra().equals(str)) {
                        int type = hitTestResult.getType();
                        if (type == 1 || type == 6 || type == 7 || type == 8) {
                            AdWebView.this.m49190b(str);
                            webView.stopLoading();
                            AdWebView.this.m49189c();
                        }
                    }
                } catch (NullPointerException unused) {
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            AdWebView adWebView = AdWebView.this;
            if (adWebView.f10626ad.mMediaType == EnumC2888k.SPLASH) {
                adWebView.visible();
            }
            if (AdWebView.this.f10634i) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                webView.evaluateJavascript("javascript:window.mraid.util.pageFinished()", null);
            } else {
                webView.loadUrl("javascript:window.mraid.util.pageFinished()");
            }
            if (AdWebView.this.f10630e) {
                MRAIDImplementation mRAIDImplementation = AdWebView.this.f10631f;
                AdWebView adWebView2 = AdWebView.this;
                mRAIDImplementation.m49116a(adWebView2, adWebView2.f10627b);
                AdWebView.this.m49170i();
            }
            AdWebView.this.f10634i = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            HaoboLog.m49284w(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.webview_received_error, i, str, str2));
            AdViewImpl adViewImpl = AdWebView.this.adViewImpl;
            if (adViewImpl == null || adViewImpl.getAdDispatcher() == null) {
                return;
            }
            AdWebView.this.adViewImpl.getAdDispatcher().mo49221a(2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            AdWebView.this.m49173h();
            HaoboLog.m49284w(HaoboLog.httpRespLogTag, HaoboLog.getString(C2750R.C2755string.webclient_error, sslError.getPrimaryError(), sslError.toString()));
            AdViewImpl adViewImpl = AdWebView.this.adViewImpl;
            if (adViewImpl == null || adViewImpl.getAdDispatcher() == null) {
                return;
            }
            AdWebView.this.adViewImpl.getAdDispatcher().mo49221a(2);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return AdWebView.this.m49203a(webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            AdViewImpl adViewImpl;
            String str2 = HaoboLog.baseLogTag;
            HaoboLog.m49286v(str2, "Loading URL: " + str);
            LogUtil.m49046a("lance", "Loading:::::::::::::::::::::::" + str);
            if (str.startsWith("javascript:")) {
                return false;
            }
            if (str.startsWith("mraid://")) {
                HaoboLog.m49286v(HaoboLog.mraidLogTag, str);
                if (AdWebView.this.f10630e) {
                    AdWebView.this.f10631f.m49112a(str, AdWebView.this.f10647v);
                } else {
                    String host = Uri.parse(str).getHost();
                    if (host != null && host.equals("enable")) {
                        AdWebView.this.fireMRAIDEnabled();
                    } else if (host != null && host.equals("open")) {
                        AdWebView.this.f10631f.m49112a(str, AdWebView.this.f10647v);
                    }
                }
                return true;
            } else if (str.startsWith("BeiZi://")) {
                try {
                    String host2 = Uri.parse(str).getHost();
                    if (!TextUtils.isEmpty(host2) && !"ClosePage".equals(host2)) {
                        AdWebView adWebView = AdWebView.this;
                        if (adWebView.f10626ad != null && (adViewImpl = adWebView.adViewImpl) != null && adViewImpl.getAdParameters() != null) {
                            AdWebView adWebView2 = AdWebView.this;
                            adWebView2.f10626ad.handleClick(adWebView2, "", "", "", "", "", "", adWebView2.f10628c, adWebView2.adViewImpl.getAdParameters().m49519a());
                            AdWebView.this.f10628c = true;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                BeiZiImplementation.m49141a(AdWebView.this, str);
                return true;
            } else {
                AdWebView.this.m49190b(str);
                AdWebView.this.m49189c();
                return true;
            }
        }
    }

    /* renamed from: com.beizi.ad.internal.view.AdWebView$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2992b {
        /* renamed from: a */
        void mo49096a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.beizi.ad.internal.view.AdWebView$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2993c extends WebView {
        @SuppressLint({"SetJavaScriptEnabled"})
        public C2993c(Context context) {
            super(new MutableContextWrapper(context));
            WebviewUtil.setWebViewSettings(this);
            setWebViewClient(new WebViewClient() { // from class: com.beizi.ad.internal.view.AdWebView.c.1

                /* renamed from: c */
                private boolean f10666c = false;

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    String str2 = HaoboLog.browserLogTag;
                    HaoboLog.m49286v(str2, "Opening URL: " + str);
                    ViewUtil.removeChildFromParent(C2993c.this);
                    if (AdWebView.this.f10645t != null && AdWebView.this.f10645t.isShowing()) {
                        AdWebView.this.f10645t.dismiss();
                    }
                    if (this.f10666c) {
                        this.f10666c = false;
                        C2993c.this.destroy();
                        AdWebView.this.m49166k();
                        return;
                    }
                    C2993c.this.setVisibility(0);
                    C2993c c2993c = C2993c.this;
                    AdWebView.this.m49202a(c2993c);
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    String str2 = HaoboLog.browserLogTag;
                    HaoboLog.m49286v(str2, "Redirecting to URL: " + str);
                    boolean m49171h = AdWebView.this.m49171h(str);
                    this.f10666c = m49171h;
                    if (m49171h && AdWebView.this.f10645t != null && AdWebView.this.f10645t.isShowing()) {
                        AdWebView.this.f10645t.dismiss();
                    }
                    return this.f10666c;
                }
            });
        }
    }

    public AdWebView(AdViewImpl adViewImpl) {
        super(new MutableContextWrapper(adViewImpl.getContext()));
        this.f10629d = false;
        this.f10626ad = null;
        this.mAdVideoView = null;
        this.f10625a = false;
        this.f10640o = false;
        this.f10641p = false;
        this.f10642q = new Handler();
        this.f10643r = false;
        this.f10646u = false;
        this.f10647v = false;
        this.f10650y = -1;
        this.f10651z = false;
        this.f10613A = false;
        this.f10614B = false;
        this.f10615C = false;
        this.f10616D = false;
        this.f10617E = 0;
        this.f10628c = false;
        this.f10622J = null;
        this.f10623K = null;
        this.f10624L = new Runnable() { // from class: com.beizi.ad.internal.view.AdWebView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AdWebView.this.f10643r) {
                    return;
                }
                AdWebView.this.m49179f();
                AdWebView.this.f10642q.postDelayed(this, 1000L);
            }
        };
        setBackgroundColor(0);
        this.adViewImpl = adViewImpl;
        this.f10627b = MRAIDImplementation.f10726a[MRAIDImplementation.EnumC3014b.STARTING_DEFAULT.ordinal()];
        m49209a();
        m49193b();
        setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m49166k() {
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl == null || !(adViewImpl instanceof InterstitialAdViewImpl)) {
            return;
        }
        ((InterstitialAdViewImpl) adViewImpl).m49145g();
    }

    private void setCreativeHeight(int i) {
        this.f10638m = i;
    }

    private void setCreativeWidth(int i) {
        this.f10637l = i;
    }

    public boolean IsVideoWifiOnly() {
        return this.f10616D;
    }

    public void closeWebResourceRequestConnection() {
        try {
            InputStream inputStream = this.f10623K;
            if (inputStream != null) {
                inputStream.close();
            }
            HttpURLConnection httpURLConnection = this.f10622J;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.webkit.WebView, com.beizi.p051ad.internal.view.Displayable
    public void destroy() {
        setVisibility(4);
        ViewUtil.removeChildFromParent(this);
        super.destroy();
        removeAllViews();
        m49168j();
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public boolean failed() {
        return this.f10629d;
    }

    public void fireMRAIDEnabled() {
        if (this.f10630e) {
            return;
        }
        this.f10630e = true;
        if (this.f10634i) {
            this.f10631f.m49116a(this, this.f10627b);
            m49170i();
        }
    }

    public HashMap<String, Object> getAdExtras() {
        ServerResponse serverResponse = this.f10626ad;
        if (serverResponse == null) {
            return null;
        }
        return serverResponse.getExtras();
    }

    public int getAutoCloseTime() {
        return this.f10649x;
    }

    public Context getContextFromMutableContext() {
        if (getContext() instanceof MutableContextWrapper) {
            return ((MutableContextWrapper) getContext()).getBaseContext();
        }
        return getContext();
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public int getCreativeHeight() {
        return this.f10638m;
    }

    public int getCreativeLeft() {
        return this.f10635j;
    }

    public int getCreativeTop() {
        return this.f10636k;
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public int getCreativeWidth() {
        return this.f10637l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MRAIDImplementation getMRAIDImplementation() {
        return this.f10631f;
    }

    public int getOrientation() {
        return this.f10644s;
    }

    public Displayable getRealDisplayable() {
        AdVideoView adVideoView;
        return (!this.f10615C || (adVideoView = this.mAdVideoView) == null) ? this : adVideoView;
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public int getRefreshInterval() {
        return this.f10639n;
    }

    public int getShowCloseBtnTime() {
        return this.f10648w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getUserInteraction() {
        return this.f10647v;
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public View getView() {
        return this;
    }

    public void handleClickView(MotionEvent motionEvent, long j, long j2) {
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl == null || adViewImpl.getAdDispatcher() == null || this.adViewImpl.isRewardedVideo()) {
            return;
        }
        this.f10617E++;
        this.adViewImpl.getAdDispatcher().mo49212d();
        this.f10626ad.setOpenInNativeBrowser(this.adViewImpl.getOpensNativeBrowser());
        this.f10626ad.setCloseMarketDialog(this.adViewImpl.isCloseMarketDialog());
        if (motionEvent == null) {
            this.f10626ad.handleClick(this, "100", "200", "105", "206", String.valueOf(j), String.valueOf(j2), this.f10628c, this.adViewImpl.getAdParameters().m49519a());
        } else {
            this.f10626ad.handleClick(this, motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "", String.valueOf(j), String.valueOf(j2), this.f10628c, this.adViewImpl.getAdParameters().m49519a());
        }
        this.f10628c = true;
    }

    public boolean isAutoPlay() {
        return this.f10651z;
    }

    public boolean isMRAIDUseCustomClose() {
        return this.f10646u;
    }

    public boolean isMuted() {
        return this.f10613A;
    }

    public boolean isVideoFullScreen() {
        return this.f10614B;
    }

    public void loadAd(ServerResponse serverResponse) {
        int i;
        if (serverResponse == null) {
            return;
        }
        this.f10626ad = serverResponse;
        setCreativeHeight(serverResponse.getHeight());
        setCreativeWidth(serverResponse.getWidth());
        setCreativeLeft(serverResponse.getLeft());
        setCreativeTop(serverResponse.getTop());
        setRefreshInterval(serverResponse.getRefreshInterval());
        if (serverResponse.isManualClose()) {
            this.f10648w = serverResponse.getMinTimer();
        } else {
            this.f10648w = -1;
        }
        if (serverResponse.isAutoClose() && serverResponse.getMaxTimer() != 0) {
            this.f10649x = serverResponse.getMaxTimer();
        } else {
            this.f10649x = -1;
        }
        if (this.f10648w == -1 && this.f10649x == -1 && serverResponse.getAdType() != EnumType.EnumC2812a.ADP_IVIDEO) {
            this.f10648w = 0;
        } else {
            int i2 = this.f10648w;
            if (i2 != -1 && (i = this.f10649x) != -1 && i2 > i) {
                this.f10648w = i;
            }
        }
        this.f10651z = serverResponse.isAutoPlay();
        this.f10613A = serverResponse.isMuted();
        this.f10614B = serverResponse.isFullScreen();
        this.f10644s = serverResponse.getAdOrientation();
        this.f10616D = serverResponse.isWifiOnly();
        this.f10650y = -1;
        setInitialScale((int) ((BeiZiImpl.m49492a().m49468j() * 100.0f) + 0.5f));
        loadAdAt(0);
    }

    public boolean loadAdAt(int i) {
        int creativeHeight;
        int creativeWidth;
        ServerResponse serverResponse = this.f10626ad;
        if (serverResponse != null && this.f10650y != i) {
            if (!serverResponse.getCreatives().isEmpty() && this.f10626ad.getCreatives().size() > i) {
                Pair<CreativeType, String> pair = this.f10626ad.getCreatives().get(i);
                if (StringUtil.isEmpty((String) pair.second)) {
                    m49173h();
                    return false;
                }
                if (pair.first == CreativeType.VIDEO) {
                    if (this.mAdVideoView == null) {
                        this.mAdVideoView = new AdVideoView(this);
                    }
                    this.mAdVideoView.transferAd(this, (String) pair.second);
                    this.f10615C = true;
                    String m49089a = C3019b.m49089a("aHR0cDovL2Fib3V0OmJsYW5r");
                    if (!TextUtils.isEmpty(m49089a)) {
                        loadUrl(m49089a, HeaderUtil.m49052a());
                    }
                } else {
                    HaoboLog.m49286v(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.webview_loading, (String) pair.second));
                    m49194a(this.f10626ad.getExtras());
                    String m49177f = m49177f(m49180e(m49182d((String) pair.second)));
                    float m49470h = BeiZiImpl.m49492a().m49470h();
                    float m49469i = BeiZiImpl.m49492a().m49469i();
                    float m49468j = BeiZiImpl.m49492a().m49468j();
                    if (getCreativeWidth() == -1 && getCreativeHeight() == -1) {
                        creativeWidth = -1;
                        creativeHeight = -1;
                    } else {
                        creativeHeight = (int) ((getCreativeHeight() * m49468j) + 0.5f);
                        creativeWidth = (int) ((getCreativeWidth() * m49468j) + 0.5f);
                    }
                    if (getCreativeLeft() == 0 && getCreativeTop() == 0) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(creativeWidth, creativeHeight, 17);
                        EnumC2888k enumC2888k = this.f10626ad.mMediaType;
                        if (enumC2888k == EnumC2888k.SPLASH) {
                            setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
                        } else if (enumC2888k == EnumC2888k.BANNER) {
                            m49201a(new FrameLayout.LayoutParams(-2, -1, 17));
                        } else {
                            m49201a(layoutParams);
                        }
                    } else {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(creativeWidth, creativeHeight, BadgeDrawable.TOP_START);
                        layoutParams2.setMargins((int) ((getCreativeLeft() * m49470h) + 0.5f), (int) ((getCreativeTop() * m49469i) + 0.5f), 0, 0);
                        if (this.f10626ad.mMediaType == EnumC2888k.SPLASH) {
                            setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
                        } else {
                            m49201a(layoutParams2);
                        }
                    }
                    loadDataWithBaseURL(null, m49177f, "text/html", "UTF-8", null);
                    this.f10615C = false;
                }
                this.f10650y = i;
                return true;
            }
            m49173h();
        }
        return false;
    }

    public boolean loadAdBy(int i) {
        return loadAdAt(this.f10650y + i);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m49179f();
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public void onDestroy() {
        destroy();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ProgressDialog progressDialog = this.f10645t;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.f10645t.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f10647v = true;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f10618F = System.currentTimeMillis();
            this.f10619G = motionEvent.getX();
            this.f10620H = motionEvent.getY();
            this.f10621I = true;
        } else if (action != 1) {
            if (action == 2 && this.f10621I && m49207a(this.f10619G, this.f10620H, motionEvent.getX(), motionEvent.getY()) > 15.0f) {
                this.f10621I = false;
            }
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f10618F;
            if (currentTimeMillis - j < 1000 && this.f10621I) {
                handleClickView(motionEvent, j, currentTimeMillis);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        m49206a(getWindowVisibility(), i);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        m49206a(i, getVisibility());
    }

    public void resize(int i, int i2, int i3, int i4, MRAIDImplementation.EnumC3013a enumC3013a, boolean z) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        MRAIDImplementation mRAIDImplementation = this.f10631f;
        if (!mRAIDImplementation.f10729d) {
            this.f10632g = layoutParams.width;
            this.f10633h = layoutParams.height;
        }
        float f = displayMetrics.density;
        double d = i2 * f;
        Double.isNaN(d);
        int i5 = (int) (d + 0.5d);
        double d2 = i * f;
        Double.isNaN(d2);
        int i6 = (int) (d2 + 0.5d);
        layoutParams.height = i5;
        layoutParams.width = i6;
        layoutParams.gravity = 17;
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl != null) {
            adViewImpl.m49253a(i6, i5, i3, i4, enumC3013a, z, mRAIDImplementation);
        }
        AdViewImpl adViewImpl2 = this.adViewImpl;
        if (adViewImpl2 != null) {
            adViewImpl2.mo49146f();
        }
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        super.scrollTo(0, 0);
    }

    public void setCreativeLeft(int i) {
        this.f10635j = i;
    }

    public void setCreativeTop(int i) {
        this.f10636k = i;
    }

    public void setMRAIDUseCustomClose(boolean z) {
        this.f10646u = z;
    }

    public void setRefreshInterval(int i) {
        this.f10639n = i;
    }

    public boolean shouldDisplayButton() {
        if (this.f10626ad.getAdType() == EnumType.EnumC2812a.ADP_BANNER) {
            return false;
        }
        if (this.f10626ad.getAdType() == EnumType.EnumC2812a.ADP_IVIDEO) {
            if (this.f10626ad.getCreatives().get(this.f10650y).first != CreativeType.VIDEO) {
                return false;
            }
        } else if (this.f10650y != 0) {
            return false;
        }
        return true;
    }

    @Override // com.beizi.p051ad.internal.view.Displayable
    public void visible() {
        Handler handler;
        AdViewImpl adViewImpl;
        setVisibility(0);
        this.adViewImpl.showAdLogo(this);
        this.adViewImpl.addDownloadTextView(this);
        EnumC2888k enumC2888k = EnumC2888k.BANNER;
        if (enumC2888k.equals(this.adViewImpl.getMediaType())) {
            AdViewImpl adViewImpl2 = this.adViewImpl;
            adViewImpl2.showBannerCloseBtn(adViewImpl2);
        }
        if (shouldDisplayButton() && (adViewImpl = this.adViewImpl) != null) {
            if (adViewImpl.getMediaType() == EnumC2888k.INTERSTITIAL) {
                this.adViewImpl.addInterstitialCloseButton(getShowCloseBtnTime(), getAutoCloseTime(), this, this.f10626ad.getAdType() == EnumType.EnumC2812a.ADP_IVIDEO);
            } else {
                this.adViewImpl.isLoadToShow(this);
            }
        }
        AdViewImpl adViewImpl3 = this.adViewImpl;
        if (adViewImpl3 == null || adViewImpl3.getAdDispatcher() == null || this.adViewImpl.getMediaType() != enumC2888k || (handler = this.f10642q) == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.beizi.ad.internal.view.AdWebView.3
            @Override // java.lang.Runnable
            public void run() {
                AdWebView.this.adViewImpl.getAdDispatcher().mo49222a();
                AdWebView adWebView = AdWebView.this;
                ServerResponse serverResponse = adWebView.f10626ad;
                if (serverResponse != null) {
                    serverResponse.handleView(adWebView, adWebView.adViewImpl.getAdParameters().m49519a());
                }
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public String m49180e(String str) {
        if (StringUtil.isEmpty(str)) {
            return str;
        }
        Resources resources = getResources();
        StringBuilder sb = new StringBuilder("<html><head><script>");
        if (resources != null && StringUtil.appendLocalStr(sb, StringUtil.adscopeJSStr) && StringUtil.appendLocalStr(sb, StringUtil.adscopeStr) && StringUtil.appendRes(sb)) {
            sb.append("</script></head>");
            return str.replaceFirst("<html>", Matcher.quoteReplacement(sb.toString()));
        }
        HaoboLog.m49290e(HaoboLog.baseLogTag, "Error reading SDK's raw resources.");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public String m49177f(String str) {
        return !StringUtil.isEmpty(str) ? str.replaceFirst("<head>", Matcher.quoteReplacement(new StringBuilder("<head><meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0,user-scalable=no\"/>").toString())) : str;
    }

    /* renamed from: g */
    private boolean m49174g(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            this.adViewImpl.getContext().startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            HaoboLog.m49284w(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.opening_url_failed, str));
            if (this.f10630e) {
                Toast.makeText(this.adViewImpl.getContext(), C2750R.C2755string.action_cant_be_completed, 0).show();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public boolean m49171h(String str) {
        String m49089a = C3019b.m49089a("aHR0cDovL2Fib3V0OmJsYW5r");
        if (str.startsWith(IDataSource.f43971a) || str.startsWith(m49089a)) {
            return false;
        }
        HaoboLog.m49288i(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.opening_app_store));
        return m49174g(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m49170i() {
        if (this.f10641p) {
            this.f10643r = false;
            this.f10642q.removeCallbacks(this.f10624L);
            this.f10642q.post(this.f10624L);
        }
    }

    /* renamed from: j */
    private void m49168j() {
        this.f10643r = true;
        this.f10642q.removeCallbacks(this.f10624L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public String m49182d(String str) {
        if (StringUtil.isEmpty(str)) {
            return str;
        }
        str.trim();
        if (str.startsWith("<html>")) {
            return str;
        }
        return "<html><body style='padding:0;margin:0;'>" + str + "</body></html>";
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: b */
    protected void m49193b() {
        this.f10631f = new MRAIDImplementation(this);
        setWebChromeClient(new VideoEnabledWebChromeClient(this));
        setWebViewClient(new C2991a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m49189c() {
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl != null) {
            adViewImpl.mo49146f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void m49186c(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            evaluateJavascript(str, null);
        } else {
            loadUrl(str, HeaderUtil.m49052a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public void m49179f() {
        if (getContextFromMutableContext() instanceof Activity) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            boolean z = false;
            int i = iArr[0];
            int width = iArr[0] + getWidth();
            int i2 = iArr[1];
            int height = iArr[1] + getHeight();
            int[] screenSizeAsPixels = ViewUtil.getScreenSizeAsPixels((Activity) getContextFromMutableContext());
            if (width > 0 && i < screenSizeAsPixels[0] && height > 0 && i2 < screenSizeAsPixels[1]) {
                z = true;
            }
            this.f10640o = z;
            MRAIDImplementation mRAIDImplementation = this.f10631f;
            if (mRAIDImplementation != null) {
                mRAIDImplementation.m49109b();
                this.f10631f.m49121a(i, i2, getWidth(), getHeight());
                this.f10631f.m49122a(getContext().getResources().getConfiguration().orientation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m49173h() {
        this.f10629d = true;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: a */
    protected void m49209a() {
        try {
            String userAgentString = getSettings().getUserAgentString();
            if (!TextUtils.isEmpty(userAgentString) && !userAgentString.equals(BeiZiImpl.m49492a().f10137d)) {
                SPUtils.put(getContext(), TTDownloadField.TT_USERAGENT, userAgentString);
            }
            BeiZiImpl.m49492a().f10137d = userAgentString;
            getSettings().setJavaScriptEnabled(true);
            getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            getSettings().setBuiltInZoomControls(false);
            getSettings().setEnableSmoothTransition(true);
            getSettings().setLightTouchEnabled(false);
            getSettings().setPluginState(WebSettings.PluginState.ON);
            getSettings().setLoadsImagesAutomatically(true);
            getSettings().setSavePassword(false);
            getSettings().setSupportZoom(false);
            getSettings().setUseWideViewPort(false);
            int i = Build.VERSION.SDK_INT;
            getSettings().setMediaPlaybackRequiresUserGesture(false);
            if (i >= 21) {
                getSettings().setMixedContentMode(0);
            }
            if (i >= 19) {
                WebView.setWebContentsDebuggingEnabled(false);
            }
            if (i < 19) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            }
            getSettings().setAllowFileAccess(false);
            getSettings().setAllowContentAccess(false);
            getSettings().setAllowFileAccessFromFileURLs(false);
            getSettings().setAllowUniversalAccessFromFileURLs(false);
            if (i >= 21) {
                CookieManager cookieManager = CookieManager.getInstance();
                if (cookieManager != null) {
                    cookieManager.setAcceptThirdPartyCookies(this, true);
                } else {
                    HaoboLog.m49292d(HaoboLog.baseLogTag, "Failed to set Webview to accept 3rd party cookie");
                }
            }
            setHorizontalScrollbarOverlay(false);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollbarOverlay(false);
            setVerticalScrollBarEnabled(false);
            if (this.f10614B) {
                setBackgroundColor(0);
            }
            setScrollBarStyle(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m49190b(String str) {
        if (!this.adViewImpl.getOpensNativeBrowser()) {
            HaoboLog.m49292d(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.opening_inapp));
            if (m49171h(str)) {
                return;
            }
            try {
                if (this.adViewImpl.getLoadsInBackground()) {
                    final C2993c c2993c = new C2993c(getContext());
                    c2993c.loadUrl(str, HeaderUtil.m49052a());
                    c2993c.setVisibility(8);
                    this.adViewImpl.addView(c2993c);
                    if (this.adViewImpl.getShowLoadingIndicator()) {
                        ProgressDialog progressDialog = new ProgressDialog(getContextFromMutableContext());
                        this.f10645t = progressDialog;
                        progressDialog.setCancelable(true);
                        this.f10645t.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.beizi.ad.internal.view.AdWebView.2
                            @Override // android.content.DialogInterface.OnCancelListener
                            public void onCancel(DialogInterface dialogInterface) {
                                c2993c.stopLoading();
                            }
                        });
                        this.f10645t.setMessage(getContext().getResources().getString(C2750R.C2755string.loading));
                        this.f10645t.setProgressStyle(0);
                        this.f10645t.show();
                    }
                } else {
                    WebView webView = new WebView(new MutableContextWrapper(getContext()));
                    WebviewUtil.setWebViewSettings(webView);
                    webView.loadUrl(str, HeaderUtil.m49052a());
                    m49202a(webView);
                }
                return;
            } catch (Exception e) {
                String str2 = HaoboLog.baseLogTag;
                HaoboLog.m49290e(str2, "Exception initializing the redirect webview: " + e.getMessage());
                return;
            }
        }
        HaoboLog.m49292d(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.opening_native));
        m49174g(str);
        m49166k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m49185d() {
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl != null) {
            adViewImpl.m49240c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean m49176g() {
        return this.f10640o && this.f10641p;
    }

    public void handleClickView(ClickPositionModel clickPositionModel, long j, long j2, int i) {
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl == null || adViewImpl.getAdDispatcher() == null || this.adViewImpl.isRewardedVideo()) {
            return;
        }
        this.f10617E++;
        this.adViewImpl.getAdDispatcher().mo49212d();
        this.f10626ad.setOpenInNativeBrowser(this.adViewImpl.getOpensNativeBrowser());
        this.f10626ad.setCloseMarketDialog(this.adViewImpl.isCloseMarketDialog());
        this.f10626ad.handleClick(this, clickPositionModel, String.valueOf(j), String.valueOf(j2), this.f10628c, this.adViewImpl.getAdParameters().m49519a(), i);
        this.f10628c = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo49095e() {
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl != null) {
            adViewImpl.m49252a(this.f10632g, this.f10633h, this.f10631f);
        }
    }

    /* renamed from: a */
    private void m49201a(FrameLayout.LayoutParams layoutParams) {
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl instanceof BannerAdViewImpl) {
            if (((BannerAdViewImpl) adViewImpl).getResizeAdToFitContainer()) {
                setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
                return;
            } else {
                setLayoutParams(layoutParams);
                return;
            }
        }
        setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private void m49194a(HashMap hashMap) {
        if (!hashMap.isEmpty() && hashMap.containsKey(ServerResponse.EXTRAS_KEY_MRAID)) {
            this.f10630e = ((Boolean) hashMap.get(ServerResponse.EXTRAS_KEY_MRAID)).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m49195a(final String str) {
        new HTTPGet(false, true) { // from class: com.beizi.ad.internal.view.AdWebView.1
            @Override // com.beizi.p051ad.internal.utilities.HTTPGet
            protected String getUrl() {
                return str;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.beizi.p051ad.internal.utilities.HTTPGet, android.os.AsyncTask
            public void onPostExecute(HTTPResponse hTTPResponse) {
                if (hTTPResponse.getSucceeded()) {
                    AdWebView.this.loadDataWithBaseURL(null, AdWebView.this.m49177f(AdWebView.this.m49180e(AdWebView.this.m49182d(hTTPResponse.getResponseBody()))), "text/html", "UTF-8", null);
                    AdWebView.this.fireMRAIDEnabled();
                }
            }
        }.execute(new Void[0]);
    }

    /* renamed from: a */
    private static float m49207a(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return m49208a((float) Math.sqrt((f5 * f5) + (f6 * f6)));
    }

    /* renamed from: a */
    private static float m49208a(float f) {
        return f / BeiZiImpl.m49492a().m49467k().density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public WebResourceResponse m49203a(WebResourceRequest webResourceRequest) {
        try {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            String str = "*/*";
            if (requestHeaders != null && requestHeaders.size() > 0 && requestHeaders.containsKey("Accept")) {
                str = requestHeaders.get("Accept");
            }
            Uri url = webResourceRequest.getUrl();
            if (url == null) {
                return null;
            }
            String uri = url.toString();
            if (uri.startsWith(IDataSource.f43971a)) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
                this.f10622J = httpURLConnection;
                httpURLConnection.setRequestMethod(webResourceRequest.getMethod());
                this.f10622J.setRequestProperty("X-Requested-With", "");
                this.f10622J.setRequestProperty("Accept", str);
                this.f10622J.setRequestProperty("User-Agent", BeiZiImpl.m49492a().f10137d);
                this.f10623K = this.f10622J.getInputStream();
                return new WebResourceResponse(str, "UTF-8", this.f10623K);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m49202a(WebView webView) {
        Class m50215a = AdActivity.m50215a();
        Intent intent = new Intent(this.adViewImpl.getContext(), m50215a);
        intent.setFlags(268435456);
        intent.putExtra("ACTIVITY_TYPE", "BROWSER");
        BrowserAdActivity.f9980a.add(webView);
        if (this.adViewImpl.getBrowserStyle() != null) {
            String str = "" + super.hashCode();
            intent.putExtra("bridgeid", str);
            AdViewImpl.C2985c.f10612a.add(new Pair<>(str, this.adViewImpl.getBrowserStyle()));
        }
        try {
            this.adViewImpl.getContext().startActivity(intent);
            m49166k();
        } catch (ActivityNotFoundException unused) {
            HaoboLog.m49284w(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.adactivity_missing, m50215a.getName()));
            BrowserAdActivity.f9980a.remove();
        }
    }

    /* renamed from: a */
    private void m49206a(int i, int i2) {
        if (i == 0 && i2 == 0) {
            WebviewUtil.onResume(this);
            this.f10641p = true;
            if (this.f10630e && this.f10634i) {
                m49170i();
            }
        } else {
            WebviewUtil.onPause(this);
            this.f10641p = false;
            m49168j();
        }
        MRAIDImplementation mRAIDImplementation = this.f10631f;
        if (mRAIDImplementation != null) {
            mRAIDImplementation.m49109b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m49205a(int i, int i2, boolean z, final MRAIDImplementation mRAIDImplementation, final boolean z2, final AdActivity.EnumC2742b enumC2742b) {
        int i3 = i;
        int i4 = i2;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        if (!this.f10631f.f10729d) {
            this.f10632g = layoutParams.width;
            this.f10633h = layoutParams.height;
        }
        if (i4 == -1 && i3 == -1 && this.adViewImpl != null) {
            this.f10625a = true;
        }
        if (i4 != -1) {
            double d = i4 * displayMetrics.density;
            Double.isNaN(d);
            i4 = (int) (d + 0.5d);
        }
        int i5 = i4;
        if (i3 != -1) {
            double d2 = i3 * displayMetrics.density;
            Double.isNaN(d2);
            i3 = (int) (d2 + 0.5d);
        }
        int i6 = i3;
        layoutParams.height = i5;
        layoutParams.width = i6;
        layoutParams.gravity = 17;
        InterfaceC2992b interfaceC2992b = null;
        if (this.f10625a) {
            interfaceC2992b = new InterfaceC2992b() { // from class: com.beizi.ad.internal.view.AdWebView.4
                @Override // com.beizi.p051ad.internal.view.AdWebView.InterfaceC2992b
                /* renamed from: a */
                public void mo49096a() {
                    MRAIDImplementation mRAIDImplementation2 = mRAIDImplementation;
                    if (mRAIDImplementation2 == null || mRAIDImplementation2.m49107c() == null) {
                        return;
                    }
                    AdWebView.this.m49204a(mRAIDImplementation.m49107c(), z2, enumC2742b);
                    AdViewImpl.setMRAIDFullscreenListener(null);
                }
            };
        }
        InterfaceC2992b interfaceC2992b2 = interfaceC2992b;
        AdViewImpl adViewImpl = this.adViewImpl;
        if (adViewImpl != null) {
            adViewImpl.m49251a(i6, i5, z, mRAIDImplementation, interfaceC2992b2);
            this.adViewImpl.mo49146f();
        }
        setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m49204a(Activity activity, boolean z, AdActivity.EnumC2742b enumC2742b) {
        AdActivity.EnumC2742b enumC2742b2 = AdActivity.EnumC2742b.none;
        if (enumC2742b != enumC2742b2) {
            AdActivity.m50212a(activity, enumC2742b);
        }
        if (z) {
            AdActivity.m50211b(activity);
        } else if (enumC2742b == enumC2742b2) {
            AdActivity.m50214a(activity);
        }
    }
}
