package com.beizi.p051ad.internal.view;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.beizi.p051ad.AdSize;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.AdFetcher;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.internal.EnumC2888k;
import com.beizi.p051ad.internal.animation.Animator;
import com.beizi.p051ad.internal.animation.TransitionDirection;
import com.beizi.p051ad.internal.animation.TransitionType;
import com.beizi.p051ad.internal.network.AdRequestImpl;
import com.beizi.p051ad.internal.p057a.MediationDisplayable;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.WebviewUtil;
import com.beizi.p051ad.internal.video.AdVideoView;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.beizi.p051ad.p056c.ClickPositionModel;
import com.clj.fastble.BleManager;

/* renamed from: com.beizi.ad.internal.view.BannerAdViewImpl */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BannerAdViewImpl extends AdViewImpl {

    /* renamed from: A */
    private Displayable f10667A;

    /* renamed from: B */
    private EnumC2997a f10668B;

    /* renamed from: m */
    protected boolean f10669m;

    /* renamed from: n */
    protected int f10670n;

    /* renamed from: o */
    protected int f10671o;

    /* renamed from: p */
    private int f10672p;

    /* renamed from: q */
    private boolean f10673q;

    /* renamed from: r */
    private boolean f10674r;

    /* renamed from: s */
    private BroadcastReceiver f10675s;

    /* renamed from: t */
    private boolean f10676t;

    /* renamed from: u */
    private boolean f10677u;

    /* renamed from: v */
    private boolean f10678v;

    /* renamed from: w */
    private Animator f10679w;

    /* renamed from: x */
    private boolean f10680x;

    /* renamed from: y */
    private AdWebView f10681y;

    /* renamed from: z */
    private boolean f10682z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.beizi.ad.internal.view.BannerAdViewImpl$2 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static /* synthetic */ class C29962 {

        /* renamed from: a */
        static final /* synthetic */ int[] f10684a;

        static {
            int[] iArr = new int[EnumC2997a.values().length];
            f10684a = iArr;
            try {
                iArr[EnumC2997a.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10684a[EnumC2997a.TOP_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10684a[EnumC2997a.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10684a[EnumC2997a.CENTER_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10684a[EnumC2997a.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10684a[EnumC2997a.CENTER_RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10684a[EnumC2997a.BOTTOM_LEFT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10684a[EnumC2997a.BOTTOM_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10684a[EnumC2997a.BOTTOM_RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* renamed from: com.beizi.ad.internal.view.BannerAdViewImpl$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2997a {
        TOP_LEFT,
        TOP_CENTER,
        TOP_RIGHT,
        CENTER_LEFT,
        CENTER,
        CENTER_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_CENTER,
        BOTTOM_RIGHT;

        /* renamed from: a */
        int m49156a() {
            switch (C29962.f10684a[ordinal()]) {
                case 1:
                    return 51;
                case 2:
                    return 49;
                case 3:
                    return 53;
                case 4:
                    return 19;
                case 5:
                default:
                    return 17;
                case 6:
                    return 21;
                case 7:
                    return 83;
                case 8:
                    return 81;
                case 9:
                    return 85;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.beizi.ad.internal.view.BannerAdViewImpl$b  reason: invalid class name */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class animationAnimation$AnimationListenerC2998b implements Animation.AnimationListener {

        /* renamed from: b */
        private final Displayable f10696b;

        /* renamed from: c */
        private final Animator f10697c;

        animationAnimation$AnimationListenerC2998b(Displayable displayable, Animator animator) {
            this.f10696b = displayable;
            this.f10697c = animator;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            animation.setAnimationListener(null);
            final Displayable displayable = this.f10696b;
            final Animator animator = this.f10697c;
            if (displayable == null || animator == null) {
                return;
            }
            displayable.getView().getHandler().post(new Runnable() { // from class: com.beizi.ad.internal.view.BannerAdViewImpl.b.1
                @Override // java.lang.Runnable
                public void run() {
                    animator.clearAnimation();
                    displayable.destroy();
                    animator.setAnimation();
                }
            });
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public BannerAdViewImpl(Context context) {
        super(context);
        this.f10682z = true;
    }

    /* renamed from: j */
    private void m49160j() {
        this.f10673q = false;
        this.f10672p = -1;
        this.f10674r = false;
        this.f10680x = true;
    }

    /* renamed from: k */
    private void m49159k() {
        if (this.f10675s != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        this.f10675s = new BroadcastReceiver() { // from class: com.beizi.ad.internal.view.BannerAdViewImpl.1
            /* JADX WARN: Removed duplicated region for block: B:15:0x004f A[Catch: Exception -> 0x005b, TRY_LEAVE, TryCatch #0 {Exception -> 0x005b, blocks: (B:2:0x0000, B:4:0x000c, B:5:0x001d, B:7:0x0029, B:9:0x0033, B:15:0x004f, B:11:0x003a, B:13:0x0042), top: B:20:0x0000 }] */
            /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
            @Override // android.content.BroadcastReceiver
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onReceive(android.content.Context r2, android.content.Intent r3) {
                /*
                    r1 = this;
                    java.lang.String r2 = r3.getAction()     // Catch: java.lang.Exception -> L5b
                    java.lang.String r0 = "android.intent.action.SCREEN_OFF"
                    boolean r2 = r2.equals(r0)     // Catch: java.lang.Exception -> L5b
                    if (r2 == 0) goto L1d
                    com.beizi.ad.internal.view.BannerAdViewImpl r2 = com.beizi.p051ad.internal.view.BannerAdViewImpl.this     // Catch: java.lang.Exception -> L5b
                    r2.m49162h()     // Catch: java.lang.Exception -> L5b
                    java.lang.String r2 = com.beizi.p051ad.internal.utilities.HaoboLog.baseLogTag     // Catch: java.lang.Exception -> L5b
                    int r3 = com.beizi.p051ad.C2750R.C2755string.screen_off_stop     // Catch: java.lang.Exception -> L5b
                    java.lang.String r3 = com.beizi.p051ad.internal.utilities.HaoboLog.getString(r3)     // Catch: java.lang.Exception -> L5b
                    com.beizi.p051ad.internal.utilities.HaoboLog.m49292d(r2, r3)     // Catch: java.lang.Exception -> L5b
                    goto L5f
                L1d:
                    java.lang.String r2 = r3.getAction()     // Catch: java.lang.Exception -> L5b
                    java.lang.String r3 = "android.intent.action.SCREEN_ON"
                    boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L5b
                    if (r2 == 0) goto L5f
                    r2 = 0
                    com.beizi.ad.internal.view.BannerAdViewImpl r3 = com.beizi.p051ad.internal.view.BannerAdViewImpl.this     // Catch: java.lang.Exception -> L5b
                    int r3 = com.beizi.p051ad.internal.view.BannerAdViewImpl.m49165a(r3)     // Catch: java.lang.Exception -> L5b
                    r0 = 1
                    if (r3 <= 0) goto L3a
                    com.beizi.ad.internal.view.BannerAdViewImpl r2 = com.beizi.p051ad.internal.view.BannerAdViewImpl.this     // Catch: java.lang.Exception -> L5b
                    r2.m49163g()     // Catch: java.lang.Exception -> L5b
                L38:
                    r2 = 1
                    goto L4d
                L3a:
                    com.beizi.ad.internal.view.BannerAdViewImpl r3 = com.beizi.p051ad.internal.view.BannerAdViewImpl.this     // Catch: java.lang.Exception -> L5b
                    boolean r3 = com.beizi.p051ad.internal.view.BannerAdViewImpl.m49164b(r3)     // Catch: java.lang.Exception -> L5b
                    if (r3 == 0) goto L4d
                    com.beizi.ad.internal.view.BannerAdViewImpl r2 = com.beizi.p051ad.internal.view.BannerAdViewImpl.this     // Catch: java.lang.Exception -> L5b
                    r2.m49162h()     // Catch: java.lang.Exception -> L5b
                    com.beizi.ad.internal.view.BannerAdViewImpl r2 = com.beizi.p051ad.internal.view.BannerAdViewImpl.this     // Catch: java.lang.Exception -> L5b
                    r2.m49163g()     // Catch: java.lang.Exception -> L5b
                    goto L38
                L4d:
                    if (r2 == 0) goto L5f
                    java.lang.String r2 = com.beizi.p051ad.internal.utilities.HaoboLog.baseLogTag     // Catch: java.lang.Exception -> L5b
                    int r3 = com.beizi.p051ad.C2750R.C2755string.screen_on_start     // Catch: java.lang.Exception -> L5b
                    java.lang.String r3 = com.beizi.p051ad.internal.utilities.HaoboLog.getString(r3)     // Catch: java.lang.Exception -> L5b
                    com.beizi.p051ad.internal.utilities.HaoboLog.m49292d(r2, r3)     // Catch: java.lang.Exception -> L5b
                    goto L5f
                L5b:
                    r2 = move-exception
                    r2.printStackTrace()
                L5f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.beizi.p051ad.internal.view.BannerAdViewImpl.C29951.onReceive(android.content.Context, android.content.Intent):void");
            }
        };
        try {
            LogUtil.m49044c("BeiZisAd", "before registerReceiver");
            getContext().registerReceiver(this.f10675s, intentFilter);
        } catch (Throwable unused) {
            LogUtil.m49044c("BeiZisAd", "ignore error");
        }
    }

    /* renamed from: l */
    private void m49158l() {
        if (this.f10672p > 0) {
            m49159k();
        }
    }

    /* renamed from: m */
    private void m49157m() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter dismantleBroadcast mReceiver == null ? ");
        sb.append(this.f10675s == null);
        LogUtil.m49044c("BeiZisAd", sb.toString());
        if (this.f10675s == null) {
            return;
        }
        try {
            getContext().unregisterReceiver(this.f10675s);
            LogUtil.m49044c("BeiZisAd", "after unregisterReceiver");
        } catch (IllegalArgumentException unused) {
            LogUtil.m49044c("BeiZisAd", "got IllegalArgumentException");
        }
        this.f10675s = null;
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    public void activityOnDestroy() {
        Displayable displayable = this.f10667A;
        if (displayable != null) {
            displayable.onDestroy();
            this.f10667A = null;
        }
        LogUtil.m49044c("BeiZisAd", "enter activityOnDestroy before dismantleBroadcast");
        m49157m();
        if (this.mAdFetcher != null) {
            m49162h();
        }
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    public void activityOnPause() {
        Displayable displayable = this.f10667A;
        if (displayable != null) {
            displayable.onPause();
        }
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    public void activityOnResume() {
        Displayable displayable = this.f10667A;
        if (displayable != null) {
            displayable.onResume();
        }
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void cancel() {
        AdFetcher adFetcher = this.mAdFetcher;
        if (adFetcher != null) {
            adFetcher.m49539a();
        }
    }

    public void clickArea() {
        AdWebView adWebView = this.f10681y;
        if (adWebView != null) {
            adWebView.handleClickView(null, System.currentTimeMillis(), System.currentTimeMillis() + 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    /* renamed from: d */
    public boolean mo49148d() {
        return true;
    }

    public void disableFullClick(View.OnTouchListener onTouchListener) {
        AdWebView adWebView = this.f10681y;
        if (adWebView != null) {
            adWebView.setOnTouchListener(onTouchListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    /* renamed from: e */
    public boolean mo49147e() {
        return false;
    }

    @SuppressLint({"NewApi"})
    public void expandToFitScreenWidth(int i, int i2, Displayable displayable) {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i3 = point.x;
        int floor = (int) Math.floor(i2 * (i3 / i));
        this.f10670n = getLayoutParams().height;
        this.f10671o = getLayoutParams().width;
        if (getLayoutParams().width > 0 || getLayoutParams().width == -2) {
            getLayoutParams().width = i3;
        }
        getLayoutParams().height = floor;
        View view = displayable.getView();
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        } else {
            view.getLayoutParams().width = -1;
            view.getLayoutParams().height = -1;
        }
        view.invalidate();
        this.f10669m = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    /* renamed from: f */
    public void mo49146f() {
    }

    /* renamed from: g */
    void m49163g() {
        if (this.f10673q) {
            return;
        }
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.start));
        this.mAdFetcher.m49534b();
        this.f10673q = true;
    }

    public EnumC2997a getAdAlignment() {
        if (this.f10668B == null) {
            this.f10668B = EnumC2997a.CENTER;
        }
        return this.f10668B;
    }

    public int getAdHeight() {
        HaoboLog.m49292d(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.get_height, this.f10519h.m49506e()));
        return this.f10519h.m49506e();
    }

    public int getAdWidth() {
        HaoboLog.m49292d(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.get_width, this.f10519h.m49508d()));
        return this.f10519h.m49508d();
    }

    public int getAutoRefreshInterval() {
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.get_period, this.f10672p));
        return this.f10672p;
    }

    public boolean getExpandsToFitScreenWidth() {
        return this.f10676t;
    }

    @Override // com.beizi.p051ad.internal.Ad
    public EnumC2888k getMediaType() {
        return this.f10512a != null ? EnumC2888k.SPLASH : EnumC2888k.BANNER;
    }

    public boolean getResizeAdToFitContainer() {
        return this.f10677u;
    }

    public boolean getShouldReloadOnResume() {
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.get_should_resume, this.f10674r));
        return this.f10674r;
    }

    public TransitionDirection getTransitionDirection() {
        return this.f10679w.getTransitionDirection();
    }

    public long getTransitionDuration() {
        return this.f10679w.getTransitionDuration();
    }

    public TransitionType getTransitionType() {
        return this.f10679w.getTransitionType();
    }

    /* renamed from: h */
    void m49162h() {
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.stop));
        this.mAdFetcher.m49539a();
        this.f10673q = false;
    }

    /* renamed from: i */
    protected void m49161i() {
        this.f10669m = false;
        if (getLayoutParams() != null) {
            getLayoutParams().height = this.f10670n;
            getLayoutParams().width = this.f10671o;
        }
    }

    public boolean isAutoRefresh() {
        return this.f10682z;
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    public boolean loadAd(AdRequestImpl.C2918a c2918a) {
        if (super.loadAd(c2918a)) {
            this.f10673q = true;
            return true;
        }
        return false;
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f10515d) {
            this.f10515d = false;
            return;
        }
        if (!this.f10678v || z) {
            BeiZiImpl m49492a = BeiZiImpl.m49492a();
            int m49470h = (int) (((i3 - i) / m49492a.m49470h()) + 0.5f);
            int m49469i = (int) (((i4 - i2) / m49492a.m49469i()) + 0.5f);
            if (m49470h >= this.f10519h.m49508d() && (m49469i >= this.f10519h.m49506e() || m49470h <= 0 || m49469i <= 0)) {
                this.f10519h.m49507d(m49470h);
                this.f10519h.m49505e(m49469i);
                if (!this.f10678v) {
                    m49240c();
                }
                this.f10678v = true;
            } else {
                HaoboLog.m49290e(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.adsize_too_big, m49470h, m49469i, this.f10519h.m49508d(), this.f10519h.m49506e()));
                m49240c();
                AdFetcher adFetcher = this.mAdFetcher;
                if (adFetcher != null) {
                    adFetcher.m49539a();
                    return;
                }
                return;
            }
        }
        if (this.f10673q) {
            m49159k();
            if (this.f10674r) {
                m49163g();
            }
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            m49159k();
            HaoboLog.m49292d(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.unhidden));
            if ((this.f10673q || this.f10674r || this.f10672p > 0) && !this.f10517f && !this.f10515d && !m49255a() && this.mAdFetcher != null) {
                m49163g();
            }
            this.f10517f = false;
            if (getChildAt(0) instanceof WebView) {
                WebviewUtil.onResume((WebView) getChildAt(0));
                return;
            }
            return;
        }
        LogUtil.m49044c("BeiZisAd", "enter onWindowVisibilityChanged before dismantleBroadcast");
        m49157m();
        HaoboLog.m49292d(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.hidden));
        if (this.mAdFetcher != null && this.f10673q) {
            m49162h();
        }
        if (getChildAt(0) instanceof WebView) {
            WebviewUtil.onPause((WebView) getChildAt(0));
        }
    }

    public void resetContainerIfNeeded() {
        if (this.f10669m) {
            m49161i();
        }
    }

    @SuppressLint({"NewApi"})
    public void resizeWebViewToFitContainer(int i, int i2, Displayable displayable) {
        int width;
        int height;
        if (getWidth() <= 0) {
            width = getMeasuredWidth();
        } else {
            width = getWidth();
        }
        if (getHeight() <= 0) {
            height = getMeasuredHeight();
        } else {
            height = getHeight();
        }
        if (height > 0 && width > 0) {
            View view = displayable.getView();
            if (i / width < i2 / height) {
                width = (i * height) / i2;
                if (view instanceof WebView) {
                    ((WebView) view).setInitialScale((int) Math.ceil((height * 100) / i2));
                }
            } else {
                height = (i2 * width) / i;
                if (view instanceof WebView) {
                    ((WebView) view).setInitialScale((int) Math.ceil((width * 100) / i));
                }
            }
            if (view.getLayoutParams() == null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
                layoutParams.gravity = 17;
                view.setLayoutParams(layoutParams);
            } else {
                view.getLayoutParams().width = width;
                view.getLayoutParams().height = height;
                ((FrameLayout.LayoutParams) view.getLayoutParams()).gravity = 17;
            }
            view.invalidate();
            return;
        }
        HaoboLog.m49284w(HaoboLog.baseLogTag, "Unable to resize ad to fit container because of failure to obtain the container size.");
    }

    public void setAdAlignment(EnumC2997a enumC2997a) {
        this.f10668B = enumC2997a;
    }

    public void setAdSize(int i, int i2) {
        HaoboLog.m49292d(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.set_size, i, i2));
        this.f10519h.m49513b(i);
        this.f10519h.m49510c(i2);
    }

    public void setAutoRefresh(boolean z) {
        this.f10682z = z;
    }

    public void setAutoRefreshInterval(int i) {
        if (i > 0) {
            this.f10672p = Math.max((int) BleManager.f22896l, i);
        } else {
            this.f10672p = i;
        }
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.set_period, this.f10672p));
        AdFetcher adFetcher = this.mAdFetcher;
        if (adFetcher != null) {
            adFetcher.m49538a(this.f10672p);
        }
    }

    public void setExpandsToFitScreenWidth(boolean z) {
        this.f10676t = z;
    }

    public void setResizeAdToFitContainer(boolean z) {
        this.f10677u = z;
    }

    public void setScrollClick(View.OnTouchListener onTouchListener) {
        AdWebView adWebView = this.f10681y;
        if (adWebView != null) {
            adWebView.setOnTouchListener(onTouchListener);
        }
    }

    public void setShouldReloadOnResume(boolean z) {
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.set_should_resume, z));
        this.f10674r = z;
    }

    public void setTransitionDirection(TransitionDirection transitionDirection) {
        this.f10679w.setTransitionDirection(transitionDirection);
    }

    public void setTransitionDuration(long j) {
        this.f10679w.setTransitionDuration(j);
    }

    public void setTransitionType(TransitionType transitionType) {
        this.f10679w.setTransitionType(transitionType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    /* renamed from: a */
    public void mo49153a(Context context, AttributeSet attributeSet) {
        this.f10672p = -1;
        this.f10669m = false;
        this.f10676t = false;
        this.f10677u = false;
        this.f10678v = false;
        this.f10679w = new Animator(getContext(), TransitionType.NONE, TransitionDirection.UP, 500L);
        View view = (View) getParent();
        if (view != null) {
            int measuredHeight = view.getMeasuredHeight();
            int measuredHeight2 = view.getMeasuredHeight();
            BeiZiImpl m49492a = BeiZiImpl.m49492a();
            this.f10519h.m49507d((int) ((measuredHeight2 / m49492a.m49470h()) + 0.5f));
            this.f10519h.m49505e((int) ((measuredHeight / m49492a.m49469i()) + 0.5f));
        }
        super.mo49153a(context, attributeSet);
        m49158l();
        this.f10519h.m49517a(this.f10512a != null ? EnumC2888k.SPLASH : EnumC2888k.BANNER);
        this.mAdFetcher.m49538a(this.f10672p);
        if (this.f10680x) {
            this.mAdFetcher.m49534b();
            this.f10673q = true;
        }
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    /* renamed from: b */
    protected void mo49150b(Context context, AttributeSet attributeSet) {
        m49160j();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2750R.styleable.AdView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        HaoboLog.m49286v(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.found_n_in_xml, indexCount));
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == C2750R.styleable.AdView_beizi_adUnitId) {
                setAdUnitId(obtainStyledAttributes.getString(index));
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.placement_id, obtainStyledAttributes.getString(index)));
            } else if (index == C2750R.styleable.AdView_auto_refresh_interval) {
                int i2 = obtainStyledAttributes.getInt(index, -1);
                setAutoRefreshInterval(i2);
                if (i2 <= 0) {
                    this.f10680x = true;
                }
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.xml_set_period, i2));
            } else if (index == C2750R.styleable.AdView_test) {
                BeiZiImpl.m49492a().f10136c = obtainStyledAttributes.getBoolean(index, false);
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.xml_set_test, BeiZiImpl.m49492a().f10136c));
            } else if (index == C2750R.styleable.AdView_beizi_adSize) {
                String string = obtainStyledAttributes.getString(index);
                AdSize adSize = null;
                if (string != null && !string.isEmpty()) {
                    try {
                        adSize = (AdSize) AdSize.class.getDeclaredField(string).get(null);
                    } catch (Exception unused) {
                    }
                }
                if (adSize == null) {
                    adSize = AdSize.f9395g;
                }
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.xml_ad_size, adSize.toString()));
                setAdSize(adSize.m50190b(), adSize.m50192a());
            } else if (index == C2750R.styleable.AdView_should_reload_on_resume) {
                setShouldReloadOnResume(obtainStyledAttributes.getBoolean(index, false));
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.xml_set_should_reload, this.f10674r));
            } else if (index == C2750R.styleable.AdView_opens_native_browser) {
                setOpensNativeBrowser(obtainStyledAttributes.getBoolean(index, false));
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.xml_set_opens_native_browser, getOpensNativeBrowser()));
            } else if (index == C2750R.styleable.AdView_expands_to_fit_screen_width) {
                setExpandsToFitScreenWidth(obtainStyledAttributes.getBoolean(index, false));
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.xml_set_expands_to_full_screen_width, this.f10676t));
            } else if (index == C2750R.styleable.AdView_resize_ad_to_fit_container) {
                setResizeAdToFitContainer(obtainStyledAttributes.getBoolean(index, false));
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.xml_resize_ad_to_fit_container, this.f10677u));
            } else if (index == C2750R.styleable.AdView_show_loading_indicator) {
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.show_loading_indicator_xml));
                setShowLoadingIndicator(obtainStyledAttributes.getBoolean(index, true));
            } else if (index == C2750R.styleable.AdView_transition_type) {
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.transition_type));
                setTransitionType(TransitionType.getTypeForInt(obtainStyledAttributes.getInt(index, 0)));
            } else if (index == C2750R.styleable.AdView_transition_direction) {
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.transition_direction));
                setTransitionDirection(TransitionDirection.getDirectionForInt(obtainStyledAttributes.getInt(index, 0)));
            } else if (index == C2750R.styleable.AdView_transition_duration) {
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.transition_duration));
                setTransitionDuration(obtainStyledAttributes.getInt(index, 1000));
            } else if (index == C2750R.styleable.AdView_load_landing_page_in_background) {
                setLoadsInBackground(obtainStyledAttributes.getBoolean(index, true));
                HaoboLog.m49292d(HaoboLog.xmlLogTag, HaoboLog.getString(C2750R.C2755string.xml_load_landing_page_in_background, this.f10518g));
            }
        }
        obtainStyledAttributes.recycle();
    }

    public BannerAdViewImpl(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
        this.f10682z = true;
    }

    public void clickArea(ClickPositionModel clickPositionModel, int i) {
        AdWebView adWebView = this.f10681y;
        if (adWebView != null) {
            adWebView.handleClickView(clickPositionModel, System.currentTimeMillis(), System.currentTimeMillis() + 10, i);
        }
    }

    public BannerAdViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10682z = true;
    }

    public BannerAdViewImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10682z = true;
    }

    public BannerAdViewImpl(Context context, int i) {
        super(context);
        this.f10682z = true;
        setAutoRefreshInterval(i);
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    /* renamed from: a */
    protected void mo49151a(Displayable displayable) {
        int refreshInterval;
        if (displayable != null && !displayable.failed() && displayable.getView() != null) {
            if (this.f10514c == displayable) {
                return;
            }
            this.f10667A = displayable;
            if (getTransitionType() == TransitionType.NONE) {
                removeAllViews();
                Displayable displayable2 = this.f10514c;
                if (displayable2 != null) {
                    displayable2.destroy();
                }
                View view = displayable.getView();
                addView(view);
                if (view instanceof AdWebView) {
                    LogUtil.m49046a("BeiZisAd", "set mAdWebView");
                    this.f10681y = (AdWebView) view;
                }
                if (view.getLayoutParams() != null) {
                    ((FrameLayout.LayoutParams) view.getLayoutParams()).gravity = getAdAlignment().m49156a();
                }
                if (getMediaType() != EnumC2888k.SPLASH || (displayable.getView() instanceof AdVideoView)) {
                    displayable.visible();
                }
            } else {
                if (displayable.getView().getLayoutParams() != null) {
                    ((FrameLayout.LayoutParams) displayable.getView().getLayoutParams()).gravity = getAdAlignment().m49156a();
                    this.f10679w.setLayoutParams(displayable.getView().getLayoutParams());
                }
                if (getChildCount() != 0 && indexOfChild(this.f10679w) != -1) {
                    if (getMediaType() != EnumC2888k.SPLASH || (displayable.getView() instanceof AdVideoView)) {
                        displayable.visible();
                    }
                    this.f10679w.addView(displayable.getView());
                    this.f10679w.showNext();
                } else {
                    removeAllViews();
                    if (getMediaType() != EnumC2888k.SPLASH || (displayable.getView() instanceof AdVideoView)) {
                        displayable.visible();
                    }
                    addView(this.f10679w, 0);
                    this.f10679w.addView(displayable.getView());
                }
                Displayable displayable3 = this.f10514c;
                if (displayable3 != null) {
                    if (displayable3.getView().getAnimation() != null) {
                        displayable3.getView().getAnimation().setAnimationListener(new animationAnimation$AnimationListenerC2998b(displayable3, this.f10679w));
                    } else {
                        displayable3.destroy();
                    }
                }
            }
            m49243b();
            if (this.f10512a == null && (refreshInterval = displayable.getRefreshInterval()) > 0 && this.f10682z) {
                setAutoRefreshInterval(refreshInterval * 1000);
            }
            this.f10514c = displayable;
            return;
        }
        getAdListener().onAdFailedToLoad(5);
        HaoboLog.m49290e(HaoboLog.baseLogTag, "Loaded an ad with an invalid displayable");
    }

    @Override // com.beizi.p051ad.internal.view.AdViewImpl
    /* renamed from: a */
    protected void mo49152a(MediationDisplayable mediationDisplayable) {
        mo49151a((Displayable) mediationDisplayable);
    }
}
