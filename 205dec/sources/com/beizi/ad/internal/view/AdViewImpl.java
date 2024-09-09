package com.beizi.ad.internal.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Color;
import android.graphics.Point;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.beizi.ad.AdActivity;
import com.beizi.ad.AdLifeControl;
import com.beizi.ad.AdListener;
import com.beizi.ad.AppEventListener;
import com.beizi.ad.R;
import com.beizi.ad.RewardedVideoAdListener;
import com.beizi.ad.c.e;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.ad.internal.i;
import com.beizi.ad.internal.k;
import com.beizi.ad.internal.n;
import com.beizi.ad.internal.network.ServerResponse;
import com.beizi.ad.internal.network.a;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.SPUtils;
import com.beizi.ad.internal.utilities.StringUtil;
import com.beizi.ad.internal.utilities.VideoCacheManager;
import com.beizi.ad.internal.utilities.ViewUtil;
import com.beizi.ad.internal.utilities.WebviewUtil;
import com.beizi.ad.internal.video.AdVideoView;
import com.beizi.ad.internal.view.AdWebView;
import com.beizi.ad.internal.view.f;
import com.beizi.ad.lance.a.l;
import com.beizi.ad.lance.a.p;
import com.stub.StubApp;
import java.util.ArrayList;
import xyz.adscope.ad.constants.Constants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class AdViewImpl extends FrameLayout implements AdLifeControl, com.beizi.ad.internal.a {
    private static FrameLayout U;
    private static f V;
    private static AdWebView.b W;
    private AppCompatTextView A;
    private ImageView B;
    private CountDownTimer C;
    private AppCompatImageView D;
    private long E;
    private GestureDetector F;
    private float G;
    private float H;
    private float I;
    private float J;
    private FrameLayout K;

    /* renamed from: L  reason: collision with root package name */
    private FrameLayout f14090L;
    private String M;
    private String N;
    private String O;
    private String P;
    private String Q;
    private boolean R;
    private AdWebView S;
    private boolean T;

    /* renamed from: a  reason: collision with root package name */
    protected ViewGroup f14091a;

    /* renamed from: b  reason: collision with root package name */
    protected a f14092b;
    public int bottomPadding;

    /* renamed from: c  reason: collision with root package name */
    protected com.beizi.ad.internal.view.c f14093c;
    public int clickCount;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f14094d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f14095e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f14096f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f14097g;

    /* renamed from: h  reason: collision with root package name */
    protected com.beizi.ad.internal.e f14098h;

    /* renamed from: i  reason: collision with root package name */
    protected a.C0126a f14099i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f14100j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f14101k;

    /* renamed from: l  reason: collision with root package name */
    int f14102l;
    public int leftPadding;
    public int loadCount;

    /* renamed from: m  reason: collision with root package name */
    private View f14103m;
    public com.beizi.ad.internal.d mAdFetcher;

    /* renamed from: n  reason: collision with root package name */
    private int f14104n;

    /* renamed from: o  reason: collision with root package name */
    private int f14105o;

    /* renamed from: p  reason: collision with root package name */
    private String f14106p;

    /* renamed from: q  reason: collision with root package name */
    private AdListener f14107q;

    /* renamed from: r  reason: collision with root package name */
    private RewardedVideoAdListener f14108r;
    public int rightPadding;

    /* renamed from: s  reason: collision with root package name */
    private AppEventListener f14109s;
    public ServerResponse serverResponse;

    /* renamed from: t  reason: collision with root package name */
    private c f14110t;
    public int topPadding;

    /* renamed from: u  reason: collision with root package name */
    private final Handler f14111u;

    /* renamed from: v  reason: collision with root package name */
    private b f14112v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f14113w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f14114x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f14115y;

    /* renamed from: z  reason: collision with root package name */
    private AppCompatTextView f14116z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* renamed from: com.beizi.ad.internal.view.AdViewImpl$14  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static /* synthetic */ class AnonymousClass14 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14126a;

        static {
            int[] iArr = new int[f.a.values().length];
            f14126a = iArr;
            try {
                iArr[f.a.bottom_center.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14126a[f.a.bottom_left.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14126a[f.a.bottom_right.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14126a[f.a.center.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14126a[f.a.top_center.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14126a[f.a.top_left.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14126a[f.a.top_right.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public EnumC0131a f14161a = EnumC0131a.UNCHANGE;

        /* renamed from: b  reason: collision with root package name */
        public boolean f14162b = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* renamed from: com.beizi.ad.internal.view.AdViewImpl$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public enum EnumC0131a {
            UNCHANGE,
            STATE_PREPARE_CHANGE,
            STATE_BACKGROUND,
            FINISHCLOSE
        }

        a() {
        }

        public boolean a() {
            return this.f14162b;
        }

        public void b() {
            this.f14161a = EnumC0131a.UNCHANGE;
        }

        public EnumC0131a c() {
            return this.f14161a;
        }

        public void a(boolean z3) {
            this.f14162b = z3;
        }

        public synchronized void a(EnumC0131a enumC0131a) {
            EnumC0131a enumC0131a2 = EnumC0131a.STATE_PREPARE_CHANGE;
            if (enumC0131a == enumC0131a2 && this.f14161a == EnumC0131a.UNCHANGE) {
                this.f14161a = enumC0131a2;
            }
            EnumC0131a enumC0131a3 = EnumC0131a.STATE_BACKGROUND;
            if (enumC0131a == enumC0131a3 && this.f14161a == enumC0131a2) {
                this.f14161a = enumC0131a3;
            }
            EnumC0131a enumC0131a4 = EnumC0131a.FINISHCLOSE;
            if (enumC0131a == enumC0131a4 && this.f14161a == enumC0131a3 && this.f14162b) {
                this.f14161a = enumC0131a4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class b implements com.beizi.ad.internal.c {

        /* renamed from: b  reason: collision with root package name */
        private Handler f14169b;

        /* renamed from: c  reason: collision with root package name */
        private com.beizi.ad.internal.network.b f14170c;

        public b(Handler handler) {
            this.f14169b = handler;
        }

        @Override // com.beizi.ad.internal.c
        public void b() {
            this.f14169b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AdViewImpl adViewImpl = AdViewImpl.this;
                        if (!adViewImpl.f14100j) {
                            if (adViewImpl.f14107q != null) {
                                AdViewImpl.this.f14107q.onAdClosed();
                                AdViewImpl.this.f14092b.b();
                                if (AdViewImpl.this.S != null) {
                                    AdViewImpl.this.S.closeWebResourceRequestConnection();
                                }
                            }
                        } else if (adViewImpl.f14108r != null) {
                            AdViewImpl.this.f14108r.onRewardedVideoAdClosed();
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void c() {
            this.f14169b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.8
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (!adViewImpl.f14100j) {
                        if (adViewImpl.f14107q != null) {
                            AdViewImpl.this.f14107q.onAdOpened();
                        }
                    } else if (adViewImpl.f14108r != null) {
                        AdViewImpl.this.f14108r.onRewardedVideoAdOpened();
                    }
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void d() {
            this.f14169b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.10
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (adViewImpl.f14100j || adViewImpl.f14107q == null) {
                        return;
                    }
                    AdViewImpl.this.f14092b.a(a.EnumC0131a.STATE_PREPARE_CHANGE);
                    Log.i("BeiZisAd", "enter BeiZi ad click");
                    AdViewImpl.this.f14107q.onAdClicked();
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void e() {
            this.f14169b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.11
                @Override // java.lang.Runnable
                public void run() {
                    if (AdViewImpl.this.f14107q != null) {
                        AdViewImpl.this.f14107q.onAdRequest();
                    }
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void f() {
            this.f14169b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.2
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (!adViewImpl.f14100j || adViewImpl.f14108r == null) {
                        return;
                    }
                    AdViewImpl.this.f14108r.onRewardedVideoStarted();
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void a(final com.beizi.ad.internal.network.b bVar) {
            this.f14170c = bVar;
            if (!bVar.a().equals(k.BANNER) && !bVar.a().equals(k.INTERSTITIAL) && !bVar.a().equals(k.SPLASH)) {
                a(0);
            } else {
                this.f14169b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdViewImpl.this.setCreativeWidth(bVar.c().getCreativeWidth());
                        AdViewImpl.this.setCreativeHeight(bVar.c().getCreativeHeight());
                        AdViewImpl.this.setAdExtInfo(bVar.e());
                        AdViewImpl.this.setPrice(bVar.f());
                        AdViewImpl.this.setAdId(bVar.g());
                        AdViewImpl.this.setDownloadApp(bVar.i());
                        if (bVar.b()) {
                            try {
                                AdViewImpl.this.a((com.beizi.ad.internal.a.e) bVar.c());
                            } catch (ClassCastException unused) {
                                HaoboLog.e(HaoboLog.baseLogTag, "The SDK shouldn't fail downcasts to MediatedDisplayable in AdView");
                            }
                        } else {
                            AdViewImpl.this.a(bVar.c());
                        }
                        AdViewImpl adViewImpl = AdViewImpl.this;
                        if (!adViewImpl.f14100j) {
                            if (adViewImpl.f14107q == null || bVar.a().equals(k.SPLASH)) {
                                return;
                            }
                            Log.e("BeiZisAd", "enter BeiZi ad load");
                            if (bVar.a().equals(k.INTERSTITIAL)) {
                                AdViewImpl.this.h();
                            } else {
                                AdViewImpl.this.f14107q.onAdLoaded();
                            }
                            if (bVar.d() != null) {
                                AdViewImpl.this.setLandingPageUrl(bVar.d().getLandingPageUrl());
                            }
                        } else if (adViewImpl.f14108r != null) {
                            AdViewImpl.this.f14108r.onRewardedVideoAdLoaded();
                        }
                    }
                });
            }
        }

        @Override // com.beizi.ad.internal.c
        public void a() {
            AdViewImpl.this.E = System.currentTimeMillis();
            this.f14169b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.6
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (!adViewImpl.f14100j) {
                        if (adViewImpl.f14107q != null) {
                            Log.e("BeiZisAd", "enter BeiZi ad show");
                            AdViewImpl.this.f14107q.onAdShown();
                        }
                    } else if (adViewImpl.f14108r != null) {
                        AdViewImpl.this.f14108r.onRewardedVideoAdShown();
                    }
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void a(final int i4) {
            this.f14169b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.7
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (!adViewImpl.f14100j) {
                        if (adViewImpl.f14107q != null) {
                            AdViewImpl.this.f14107q.onAdFailedToLoad(i4);
                        }
                    } else if (adViewImpl.f14108r != null) {
                        AdViewImpl.this.f14108r.onRewardedVideoAdFailedToLoad(i4);
                    }
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void a(final String str, final String str2) {
            this.f14169b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.12
                @Override // java.lang.Runnable
                public void run() {
                    if (AdViewImpl.this.f14109s != null) {
                        AdViewImpl.this.f14109s.onAppEvent(str, str2);
                    }
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void a(final String str, final int i4) {
            this.f14169b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.3
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (!adViewImpl.f14100j || adViewImpl.f14108r == null) {
                        return;
                    }
                    AdViewImpl.this.f14108r.onRewarded(new n(str, i4));
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void a(final long j4) {
            this.f14169b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (AdViewImpl.this.f14107q == null || b.this.f14170c == null || !b.this.f14170c.a().equals(k.SPLASH)) {
                        return;
                    }
                    AdViewImpl.this.f14107q.onAdTick(j4);
                }
            });
        }

        @Override // com.beizi.ad.internal.c
        public void a(final String str) {
            this.f14169b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.5
                @Override // java.lang.Runnable
                public void run() {
                    if (AdViewImpl.this.f14107q == null || b.this.f14170c == null) {
                        return;
                    }
                    AdViewImpl.this.f14107q.onAdComplainResult(str);
                }
            });
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final ArrayList<Pair<String, c>> f14191a = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdViewImpl(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public static FrameLayout getMRAIDFullscreenContainer() {
        return U;
    }

    public static f getMRAIDFullscreenImplementation() {
        return V;
    }

    public static AdWebView.b getMRAIDFullscreenListener() {
        return W;
    }

    public static void setMRAIDFullscreenContainer(FrameLayout frameLayout) {
        U = frameLayout;
    }

    public static void setMRAIDFullscreenImplementation(f fVar) {
        V = fVar;
    }

    public static void setMRAIDFullscreenListener(AdWebView.b bVar) {
        W = bVar;
    }

    protected abstract void a(com.beizi.ad.internal.a.e eVar);

    protected abstract void a(com.beizi.ad.internal.view.c cVar);

    public abstract void activityOnDestroy();

    public abstract void activityOnPause();

    public abstract void activityOnResume();

    public void addBannerCloseBtn() {
        ViewUtil.removeChildFromParent(this.B);
        ImageView createImageCloseButton = ViewUtil.createImageCloseButton(getContext());
        this.B = createImageCloseButton;
        createImageCloseButton.setVisibility(0);
        this.B.setEnabled(true);
        this.B.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdViewImpl.this.getAdDispatcher().b();
            }
        });
    }

    public void addCloseButton(int i4, int i5, int i6, final View view, final boolean z3) {
        final int i7;
        ViewUtil.removeChildFromParent(this.A);
        ViewUtil.removeChildFromParent(this.f14116z);
        CountDownTimer countDownTimer = this.C;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.A = ViewUtil.createCloseButton(getContext(), this.leftPadding, this.topPadding, this.rightPadding, this.bottomPadding);
        int i8 = 0;
        if (i6 != -1) {
            this.f14116z = ViewUtil.createCountDown(getContext(), i6, this.leftPadding, this.topPadding, this.rightPadding, this.bottomPadding);
            if (i5 > 0) {
                this.A.setEnabled(false);
                i7 = i6 - i5;
            } else {
                if (i5 == -1) {
                    this.A.setVisibility(8);
                }
                i7 = 0;
            }
            CountDownTimer countDownTimer2 = new CountDownTimer(i6 * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.4
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AdViewImpl.this.f14116z.setText("0");
                    if (AdViewImpl.this.e()) {
                        if (z3) {
                            View view2 = view;
                            if (view2 instanceof AdWebView) {
                                if (((AdWebView) view2).loadAdBy(1)) {
                                    ((com.beizi.ad.internal.activity.b) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).g();
                                    return;
                                }
                                return;
                            } else if ((view2 instanceof AdVideoView) && ((AdVideoView) view2).getAdWebView().loadAdBy(1)) {
                                ((com.beizi.ad.internal.activity.b) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).g();
                                return;
                            } else {
                                return;
                            }
                        }
                        AdViewImpl.this.getAdDispatcher().b();
                        Activity activity = (Activity) AdViewImpl.this.a(view);
                        if (activity == null || activity.isFinishing()) {
                            return;
                        }
                        activity.finish();
                        return;
                    }
                    AdViewImpl.this.f14092b.a(true);
                    if (AdViewImpl.this.f14092b.a() && (AdViewImpl.this.f14092b.c() == a.EnumC0131a.UNCHANGE || AdViewImpl.this.f14092b.c() == a.EnumC0131a.STATE_PREPARE_CHANGE)) {
                        AdViewImpl.this.getAdDispatcher().b();
                    }
                    if (AdViewImpl.this.f14091a == null) {
                        HaoboLog.e(HaoboLog.jsLogTag, "Should not close banner!");
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    int i9 = (int) ((j4 / 1000) + 1);
                    int i10 = i7;
                    if (i10 > 0 && i9 <= i10) {
                        AdViewImpl.this.A.setEnabled(true);
                    }
                    AdViewImpl.this.f14116z.setText(Integer.toString(i9));
                }
            };
            this.C = countDownTimer2;
            countDownTimer2.start();
        } else if (i5 == -1 || i4 == -1) {
            if (i4 != -1) {
                this.f14116z = ViewUtil.createCountDown(getContext(), i4, this.leftPadding, this.topPadding, this.rightPadding, this.bottomPadding);
                CountDownTimer countDownTimer3 = new CountDownTimer(i4 * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.6
                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        AdViewImpl.this.f14116z.setText("0");
                        AdViewImpl.this.f14116z.setVisibility(8);
                    }

                    @Override // android.os.CountDownTimer
                    public void onTick(long j4) {
                        AdViewImpl.this.f14116z.setText(Integer.toString((int) ((j4 / 1000) + 1)));
                    }
                };
                this.C = countDownTimer3;
                countDownTimer3.start();
                ViewParent parent = e() ? view.getParent() : getParent();
                if (parent instanceof FrameLayout) {
                    ((FrameLayout) parent).addView(this.f14116z);
                    return;
                }
                return;
            }
            return;
        } else {
            this.f14116z = ViewUtil.createCountDown(getContext(), i4, this.leftPadding, this.topPadding, this.rightPadding, this.bottomPadding);
            if (i5 > 0) {
                this.A.setEnabled(false);
                i8 = i4 - i5;
            }
            final int i9 = i8;
            CountDownTimer countDownTimer4 = new CountDownTimer(i4 * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.5
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AdViewImpl.this.f14116z.setText("0");
                    AdViewImpl.this.f14116z.setVisibility(8);
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    int i10 = (int) ((j4 / 1000) + 1);
                    AdViewImpl.this.f14116z.setText(Integer.toString(i10));
                    int i11 = i9;
                    if (i11 <= 0 || i10 > i11) {
                        return;
                    }
                    AdViewImpl.this.A.setEnabled(true);
                }
            };
            this.C = countDownTimer4;
            countDownTimer4.start();
        }
        this.A.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AdViewImpl.this.e()) {
                    if (z3) {
                        View view3 = view;
                        if (view3 instanceof AdWebView) {
                            if (((AdWebView) view3).loadAdBy(1)) {
                                ((com.beizi.ad.internal.activity.b) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).g();
                                return;
                            }
                            return;
                        } else if ((view3 instanceof AdVideoView) && ((AdVideoView) view3).getAdWebView().loadAdBy(1)) {
                            ((com.beizi.ad.internal.activity.b) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).g();
                            return;
                        } else {
                            return;
                        }
                    }
                    AdViewImpl.this.getAdDispatcher().b();
                    Activity activity = (Activity) AdViewImpl.this.a(view);
                    if (activity == null || activity.isFinishing()) {
                        return;
                    }
                    activity.onBackPressed();
                    activity.finish();
                    return;
                }
                AdViewImpl.this.getAdDispatcher().b();
                AdViewImpl.this.C.cancel();
                if (AdViewImpl.this.f14091a != null) {
                    HaoboLog.e(HaoboLog.jsLogTag, "Should not close banner!");
                }
            }
        });
        ViewParent parent2 = e() ? view.getParent() : getParent();
        if (parent2 instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) parent2;
            frameLayout.addView(this.A);
            frameLayout.addView(this.f14116z);
        }
    }

    public void addDownloadTextView(View view) {
        try {
            ServerResponse serverResponse = this.serverResponse;
            if (serverResponse != null && view != null) {
                int interactType = serverResponse.getInteractType();
                if (interactType == 2 || interactType == 5) {
                    final String apkName = this.serverResponse.getApkName();
                    String appDeveloper = this.serverResponse.getAppDeveloper();
                    String appVersion = this.serverResponse.getAppVersion();
                    String appPermissionsUrl = this.serverResponse.getAppPermissionsUrl();
                    final String appPermissionsDesc = !TextUtils.isEmpty(appPermissionsUrl) ? appPermissionsUrl : this.serverResponse.getAppPermissionsDesc();
                    final String appPrivacyUrl = this.serverResponse.getAppPrivacyUrl();
                    final String appintro = this.serverResponse.getAppintro();
                    ViewParent parent = view.getParent();
                    TextView textView = new TextView(getContext());
                    textView.setText(Html.fromHtml("\u5e94\u7528\u540d\u79f0\uff1a" + apkName + " | \u5f00\u53d1\u8005\uff1a" + appDeveloper + " | \u5e94\u7528\u7248\u672c\uff1a" + appVersion + " | <u>\u6743\u9650\u8be6\u60c5</u> | <u>\u9690\u79c1\u534f\u8bae</u> | <u>\u529f\u80fd\u4ecb\u7ecd</u>"));
                    textView.setTextSize(2, 6.0f);
                    textView.setTextColor(Color.parseColor("#999999"));
                    textView.setShadowLayer(1.0f, 1.0f, 1.0f, Color.parseColor("#333333"));
                    textView.setPadding(10, 10, 10, 10);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.17
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            try {
                                Intent intent = new Intent(AdViewImpl.this.getContext(), DownloadAppInfoActivity.class);
                                intent.putExtra(Constants.TITLE_CONTENT_KEY, apkName);
                                intent.putExtra(Constants.PRIVACY_CONTENT_KEY, appPrivacyUrl);
                                intent.putExtra("permission_content_key", appPermissionsDesc);
                                intent.putExtra(Constants.INTRO_CONTENT_KEY, appintro);
                                AdViewImpl.this.getContext().startActivity(intent);
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    });
                    int g4 = (p.g(getContext()) * 2) / 3;
                    if (parent instanceof FrameLayout) {
                        ((FrameLayout) parent).addView(textView, new FrameLayout.LayoutParams(g4, -2, 83));
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void addInterstitialCloseButton(int i4, int i5, final View view, final boolean z3) {
        ViewUtil.removeChildFromParent(this.f14116z);
        if (i5 != -1) {
            this.f14116z = ViewUtil.createInterstitialCountDown(getContext(), i5);
            final int i6 = i4 > 0 ? i5 - i4 : 0;
            CountDownTimer countDownTimer = new CountDownTimer(i5 * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.19
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AdViewImpl.this.f14116z.setText("0");
                    if (AdViewImpl.this.e()) {
                        if (z3) {
                            View view2 = view;
                            if (view2 instanceof AdWebView) {
                                if (((AdWebView) view2).loadAdBy(1)) {
                                    ((com.beizi.ad.internal.activity.b) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).g();
                                    return;
                                }
                                return;
                            } else if ((view2 instanceof AdVideoView) && ((AdVideoView) view2).getAdWebView().loadAdBy(1)) {
                                ((com.beizi.ad.internal.activity.b) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).g();
                                return;
                            } else {
                                return;
                            }
                        }
                        AdViewImpl.this.getAdDispatcher().b();
                        Activity activity = (Activity) AdViewImpl.this.a(view);
                        if (activity == null || activity.isFinishing()) {
                            return;
                        }
                        activity.finish();
                        return;
                    }
                    AdViewImpl.this.getAdDispatcher().b();
                    if (AdViewImpl.this.f14091a == null) {
                        HaoboLog.e(HaoboLog.jsLogTag, "Should not close banner!");
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    AdViewImpl.this.f14116z.setText(Integer.toString((int) ((j4 / 1000) + 1)));
                }
            };
            this.C = countDownTimer;
            countDownTimer.start();
        } else if (i4 == -1) {
            return;
        } else {
            this.f14116z = ViewUtil.createInterstitialCountDown(getContext(), i4);
            CountDownTimer countDownTimer2 = new CountDownTimer(i4 * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.20
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AdViewImpl.this.f14116z.setText("");
                    AdViewImpl.this.f14116z.setBackgroundResource(R.mipmap.ad_close);
                    AdViewImpl.this.f14116z.setVisibility(0);
                    AdViewImpl.this.f14116z.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.20.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (AdViewImpl.this.e()) {
                                AnonymousClass20 anonymousClass20 = AnonymousClass20.this;
                                if (z3) {
                                    View view3 = view;
                                    if (view3 instanceof AdWebView) {
                                        if (((AdWebView) view3).loadAdBy(1)) {
                                            ((com.beizi.ad.internal.activity.b) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).g();
                                            return;
                                        }
                                        return;
                                    } else if ((view3 instanceof AdVideoView) && ((AdVideoView) view3).getAdWebView().loadAdBy(1)) {
                                        ((com.beizi.ad.internal.activity.b) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).g();
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                AdViewImpl.this.getAdDispatcher().b();
                                AnonymousClass20 anonymousClass202 = AnonymousClass20.this;
                                Activity activity = (Activity) AdViewImpl.this.a(view);
                                if (activity == null || activity.isFinishing()) {
                                    return;
                                }
                                activity.finish();
                            }
                        }
                    });
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    AdViewImpl.this.f14116z.setText(Integer.toString((int) ((j4 / 1000) + 1)));
                }
            };
            this.C = countDownTimer2;
            countDownTimer2.start();
        }
        ViewParent parent = e() ? view.getParent() : getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).addView(this.f14116z);
        }
    }

    public void addMuteButton(final AdVideoView adVideoView, boolean z3) {
        ViewUtil.removeChildFromParent(this.D);
        AppCompatImageView createMuteButton = ViewUtil.createMuteButton(getContext(), z3);
        this.D = createMuteButton;
        createMuteButton.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdViewImpl.this.D.setImageResource(adVideoView.toggleMute() ? R.drawable.voice_off : R.drawable.voice_on);
            }
        });
        ViewParent parent = e() ? adVideoView.getParent() : getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).addView(this.D);
        }
    }

    public void addSkipView(int i4, View view) {
        ViewUtil.removeChildFromParent(this.A);
        ViewUtil.removeChildFromParent(this.f14116z);
        CountDownTimer countDownTimer = this.C;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (i4 <= 0) {
            i4 = 5;
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(i4 * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                AdViewImpl.this.f14092b.a(true);
                if (AdViewImpl.this.f14092b.a() && (AdViewImpl.this.f14092b.c() == a.EnumC0131a.UNCHANGE || AdViewImpl.this.f14092b.c() == a.EnumC0131a.STATE_PREPARE_CHANGE)) {
                    AdViewImpl.this.getAdDispatcher().b();
                }
                if (AdViewImpl.this.f14091a == null) {
                    HaoboLog.e(HaoboLog.jsLogTag, "Should not close banner!");
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
                AdViewImpl.this.getAdDispatcher().a(j4);
            }
        };
        this.C = countDownTimer2;
        countDownTimer2.start();
        view.setVisibility(0);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AdViewImpl.this.getAdDispatcher().b();
                AdViewImpl.this.C.cancel();
                if (AdViewImpl.this.f14091a != null) {
                    HaoboLog.e(HaoboLog.jsLogTag, "Should not close banner!");
                }
            }
        });
    }

    protected abstract void b(Context context, AttributeSet attributeSet);

    public void clearAdRequest() {
        this.f14099i = null;
    }

    public void closeAd() {
        try {
            getAdDispatcher().b();
            this.C.cancel();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void createAdLogo(ServerResponse.AdLogoInfo adLogoInfo, ServerResponse.AdLogoInfo adLogoInfo2) {
        ViewUtil.removeChildFromParent(this.K);
        ViewUtil.removeChildFromParent(this.f14090L);
        if (!TextUtils.isEmpty(adLogoInfo.getAdurl())) {
            this.K = ViewUtil.createAdImageView(new MutableContextWrapper(getContext()), adLogoInfo);
        }
        if (TextUtils.isEmpty(adLogoInfo2.getAdurl())) {
            return;
        }
        this.f14090L = ViewUtil.createLogoImageView(new MutableContextWrapper(getContext()), adLogoInfo2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean d();

    public void destroy() {
        HaoboLog.d(HaoboLog.baseLogTag, "called destroy() on AdView");
        com.beizi.ad.internal.view.c cVar = this.f14093c;
        if (cVar != null) {
            cVar.destroy();
            this.f14093c = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.F.onTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    protected void finalize() {
        try {
            super.finalize();
        } catch (Throwable unused) {
        }
        com.beizi.ad.internal.d dVar = this.mAdFetcher;
        if (dVar != null) {
            dVar.a();
        }
    }

    public com.beizi.ad.internal.c getAdDispatcher() {
        return this.f14112v;
    }

    public String getAdId() {
        return this.O;
    }

    public AdListener getAdListener() {
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(R.string.get_ad_listener));
        return this.f14107q;
    }

    public com.beizi.ad.internal.e getAdParameters() {
        return this.f14098h;
    }

    public a.C0126a getAdRequest() {
        return this.f14099i;
    }

    public com.beizi.ad.a getAdSize() {
        return new com.beizi.ad.a(this.f14104n, this.f14105o);
    }

    public String getAdUnitId() {
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(R.string.get_placement_id, this.f14098h.c()));
        return this.f14098h.c();
    }

    public AppEventListener getAppEventListener() {
        return this.f14109s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c getBrowserStyle() {
        return this.f14110t;
    }

    int getContainerHeight() {
        return this.f14098h.g();
    }

    int getContainerWidth() {
        return this.f14098h.f();
    }

    public int getCreativeHeight() {
        return this.f14105o;
    }

    public int getCreativeWidth() {
        return this.f14104n;
    }

    public String getLandingPageUrl() {
        return this.N;
    }

    public boolean getLoadsInBackground() {
        return this.f14097g;
    }

    public String getMediationAdapterClassName() {
        return null;
    }

    public Handler getMyHandler() {
        return this.f14111u;
    }

    public boolean getOpensNativeBrowser() {
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(R.string.get_opens_native_browser, this.f14098h.h()));
        return this.f14098h.h();
    }

    public String getPrice() {
        return this.M;
    }

    public RewardedVideoAdListener getRewaredVideoAdListener() {
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(R.string.get_rewarded_video_ad_listener));
        return this.f14108r;
    }

    public boolean getShowLoadingIndicator() {
        return this.f14114x;
    }

    public ViewGroup getSplashParent() {
        return this.f14091a;
    }

    public boolean isCloseMarketDialog() {
        com.beizi.ad.internal.e eVar = this.f14098h;
        if (eVar != null) {
            return eVar.l();
        }
        return true;
    }

    public boolean isDownloadApp() {
        return this.R;
    }

    public void isLoadToShow(AdWebView adWebView) {
        this.S = adWebView;
        this.T = true;
        if (this.f14107q != null) {
            Log.e("BeiZisAd", "enter BeiZi ad load");
            this.f14107q.onAdLoaded();
        }
    }

    public boolean isLoaded() {
        return this.T;
    }

    public boolean isLoading() {
        return this.f14115y;
    }

    @Override // com.beizi.ad.internal.a
    public boolean isReadyToStart() {
        if (a()) {
            HaoboLog.e(HaoboLog.baseLogTag, HaoboLog.getString(R.string.already_expanded));
            return false;
        }
        com.beizi.ad.internal.e eVar = this.f14098h;
        return (eVar == null || !eVar.j() || this.f14099i == null) ? false : true;
    }

    public boolean isRewardedVideo() {
        return this.f14100j;
    }

    public boolean loadAd(a.C0126a c0126a) {
        com.beizi.ad.internal.d dVar;
        com.beizi.ad.internal.d dVar2;
        this.f14099i = c0126a;
        if (!isReadyToStart()) {
            AdListener adListener = this.f14107q;
            if (adListener != null) {
                adListener.onAdFailedToLoad(4);
            }
            return false;
        } else if (getWindowVisibility() == 0 && (dVar2 = this.mAdFetcher) != null) {
            dVar2.a();
            this.mAdFetcher.c();
            this.mAdFetcher.b();
            this.f14115y = true;
            this.loadCount = 1;
            this.clickCount = 0;
            return true;
        } else {
            if (this.f14091a != null && (dVar = this.mAdFetcher) != null) {
                dVar.a();
                this.mAdFetcher.c();
                this.mAdFetcher.b();
                this.f14115y = true;
                this.loadCount = 1;
                this.clickCount = 0;
            }
            return false;
        }
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onCreateLifeCycle() {
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onDestoryLifeCycle() {
        com.beizi.ad.internal.d dVar = this.mAdFetcher;
        if (dVar != null) {
            dVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onPauseLifeCycle() {
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onRestartLifeCycle() {
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onResumeLifeCycle() {
        a aVar = this.f14092b;
        a.EnumC0131a enumC0131a = a.EnumC0131a.FINISHCLOSE;
        aVar.a(enumC0131a);
        if (this.f14092b.c() == enumC0131a) {
            getAdDispatcher().b();
        }
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onStartLifeCycle() {
    }

    @Override // com.beizi.ad.AdLifeControl
    public void onStopLifeCycle() {
        this.f14092b.a(a.EnumC0131a.STATE_BACKGROUND);
    }

    @Override // com.beizi.ad.AdLifeControl
    public void openAdInNativeBrowser(boolean z3) {
        setOpensNativeBrowser(z3);
    }

    public void pingClick(String str) {
        if (StringUtil.isEmpty(str)) {
            return;
        }
        new i(str).execute(new Void[0]);
    }

    public void pingConvert(String str) {
        if (StringUtil.isEmpty(str)) {
            return;
        }
        new i(str).execute(new Void[0]);
    }

    void setAdExtInfo(String str) {
        this.f14106p = str;
    }

    public void setAdId(String str) {
        this.O = str;
    }

    public void setAdListener(AdListener adListener) {
        if (this.f14100j) {
            HaoboLog.e(HaoboLog.publicFunctionsLogTag, "setAdListener() called on RewardedVideoAd");
            return;
        }
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(R.string.set_ad_listener));
        this.f14107q = adListener;
    }

    public void setAdUnitId(String str) {
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(R.string.set_placement_id, str));
        this.f14098h.a(str);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.f14109s = appEventListener;
    }

    protected void setBrowserStyle(c cVar) {
        this.f14110t = cVar;
    }

    public void setCloseButtonPadding(int i4, int i5, int i6, int i7) {
        this.leftPadding = i4;
        this.topPadding = i5;
        this.rightPadding = i6;
        this.bottomPadding = i7;
    }

    public void setCloseMarketDialog(boolean z3) {
        com.beizi.ad.internal.e eVar = this.f14098h;
        if (eVar != null) {
            eVar.c(z3);
        }
    }

    void setCreativeHeight(int i4) {
        this.f14105o = i4;
    }

    void setCreativeWidth(int i4) {
        this.f14104n = i4;
    }

    public void setDownloadApp(boolean z3) {
        this.R = z3;
    }

    public void setLandingPageUrl(String str) {
        this.N = str;
    }

    public void setLoadsInBackground(boolean z3) {
        this.f14097g = z3;
    }

    public void setOpensNativeBrowser(boolean z3) {
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(R.string.set_opens_native_browser, z3));
        this.f14098h.b(z3);
    }

    public void setPrice(String str) {
        this.M = str;
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        if (!this.f14100j) {
            HaoboLog.e(HaoboLog.publicFunctionsLogTag, "setRewardedVideoAdListener() called on non-RewardedVideoAd");
            return;
        }
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(R.string.set_rewarded_video_ad_listener));
        this.f14108r = rewardedVideoAdListener;
    }

    protected void setShouldResizeParent(boolean z3) {
        this.f14113w = z3;
    }

    public void setShowLoadingIndicator(boolean z3) {
        this.f14114x = z3;
    }

    public void showAd() {
        try {
            ViewGroup viewGroup = this.f14091a;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                this.f14091a.addView(this);
            }
            AdWebView adWebView = this.S;
            ServerResponse serverResponse = adWebView.ad;
            if (serverResponse != null && serverResponse.mMediaType == k.SPLASH && this.f14103m != null) {
                addSkipView(adWebView.getAutoCloseTime(), this.f14103m);
            } else {
                int showCloseBtnTime = adWebView.getShowCloseBtnTime();
                int autoCloseTime = this.S.getAutoCloseTime();
                AdWebView adWebView2 = this.S;
                addCloseButton(-1, showCloseBtnTime, autoCloseTime, adWebView2, adWebView2.ad.getAdType() == e.a.ADP_IVIDEO);
            }
            Log.e("BeiZisAd", "enter BeiZi ad show");
            this.S.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.15
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl.this.S.ad.handleView(AdViewImpl.this.S, AdViewImpl.this.f14098h.a());
                    if (AdViewImpl.this.f14107q != null) {
                        AdViewImpl.this.f14107q.onAdShown();
                    }
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void showAdLogo(View view) {
        try {
            ViewUtil.removeChildFromParent(this.K);
            ViewUtil.removeChildFromParent(this.f14090L);
            ViewParent parent = e() ? view.getParent() : this;
            if (parent instanceof FrameLayout) {
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                FrameLayout frameLayout = this.f14090L;
                if (frameLayout != null) {
                    linearLayout.addView(frameLayout, new FrameLayout.LayoutParams(-2, -2, 17));
                    this.f14090L.setVisibility(0);
                    this.f14090L.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            AdViewImpl.this.g();
                        }
                    });
                }
                FrameLayout frameLayout2 = this.K;
                if (frameLayout2 != null) {
                    linearLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-2, -2, 17));
                    this.K.setVisibility(0);
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.K.getLayoutParams();
                layoutParams.setMargins(5, 0, 0, 0);
                layoutParams.gravity = 17;
                this.K.setLayoutParams(layoutParams);
                ((FrameLayout) parent).addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                int dip2px = ViewUtil.dip2px(getContext(), 12.0f);
                layoutParams2.setMargins(0, 0, dip2px, dip2px);
                linearLayout.setLayoutParams(layoutParams2);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void showBannerCloseBtn(View view) {
        ImageView imageView;
        if (!(view instanceof FrameLayout) || (imageView = this.B) == null) {
            return;
        }
        ((FrameLayout) view).addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdViewImpl(Context context, ViewGroup viewGroup, View view) {
        super(context, null, 0);
        this.f14091a = null;
        this.f14103m = null;
        this.f14106p = "";
        this.f14092b = new a();
        this.f14111u = new Handler(Looper.getMainLooper()) { // from class: com.beizi.ad.internal.view.AdViewImpl.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        };
        this.f14094d = false;
        this.f14095e = false;
        this.f14096f = false;
        this.f14097g = true;
        this.f14113w = false;
        this.f14114x = true;
        this.f14098h = null;
        this.f14099i = null;
        this.f14115y = false;
        this.f14100j = false;
        this.f14101k = false;
        this.T = false;
        this.f14102l = 0;
        this.f14091a = viewGroup;
        this.f14103m = view;
        a(context, (AttributeSet) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        WebView webView = new WebView(new MutableContextWrapper(getContext()));
        WebviewUtil.setWebViewSettings(webView);
        String a4 = com.beizi.ad.lance.a.b.a("aHR0cDovL3Nka2RvYy5iZWl6aS5iaXovIy96aC1jbi9ndWlkZS9Vc2VQcml2YWN5");
        if (!TextUtils.isEmpty(a4)) {
            webView.loadUrl(a4, com.beizi.ad.lance.a.i.a());
        }
        a(webView, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        String str;
        boolean z3 = false;
        try {
            ServerResponse serverResponse = this.serverResponse;
            String str2 = null;
            if (serverResponse != null) {
                z3 = serverResponse.isVideo();
                String imageUrl = this.serverResponse.getImageUrl();
                str2 = this.serverResponse.getVideoUrl();
                str = imageUrl;
            } else {
                str = null;
            }
            if (!z3) {
                if (TextUtils.isEmpty(str)) {
                    AdListener adListener = this.f14107q;
                    if (adListener != null) {
                        adListener.onAdFailedToLoad(3);
                        return;
                    }
                    return;
                }
                AdListener adListener2 = this.f14107q;
                if (adListener2 != null) {
                    this.T = true;
                    adListener2.onAdLoaded();
                }
            } else if (TextUtils.isEmpty(str2)) {
                AdListener adListener3 = this.f14107q;
                if (adListener3 != null) {
                    adListener3.onAdFailedToLoad(3);
                }
            } else {
                VideoCacheManager.with().getCacheVideo(getContext(), str2, new VideoCacheManager.VideoLoadedListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.13
                    @Override // com.beizi.ad.internal.utilities.VideoCacheManager.VideoLoadedListener
                    public void onVideoLoadFailed() {
                        if (AdViewImpl.this.f14107q != null) {
                            AdViewImpl.this.f14107q.onAdFailedToLoad(6);
                        }
                    }

                    @Override // com.beizi.ad.internal.utilities.VideoCacheManager.VideoLoadedListener
                    public void onVideoLoaded(String str3) {
                        l.a("BeiZisAd", "onVideoLoaded: \u52a0\u8f7d\u6210\u529f");
                        if (AdViewImpl.this.f14107q != null) {
                            AdViewImpl.this.T = true;
                            AdViewImpl.this.f14107q.onAdLoaded();
                        }
                    }
                });
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        getVisibility();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        getVisibility();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, AttributeSet attributeSet) {
        setBackgroundColor(0);
        this.f14112v = new b(this.f14111u);
        this.f14098h = new com.beizi.ad.internal.e(context, StringUtil.createRequestId());
        this.F = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.12
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                AdViewImpl.this.G = motionEvent.getX();
                AdViewImpl.this.H = motionEvent.getY();
                AdViewImpl.this.I = motionEvent.getRawX();
                AdViewImpl.this.J = motionEvent.getRawY();
                AdViewImpl adViewImpl = AdViewImpl.this;
                int i4 = adViewImpl.clickCount;
                int i5 = adViewImpl.loadCount;
                return true;
            }
        });
        try {
            HaoboLog.setErrorContext(StubApp.getOrigApplicationContext(getContext().getApplicationContext()));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        HaoboLog.v(HaoboLog.baseLogTag, HaoboLog.getString(R.string.appid, com.beizi.ad.internal.h.a().d()));
        setPadding(0, 0, 0, 0);
        this.mAdFetcher = new com.beizi.ad.internal.d(this);
        if (attributeSet != null) {
            b(context, attributeSet);
        }
        try {
            this.P = (String) SPUtils.get(this.f14098h.b(), "urlTemplate", com.beizi.ad.lance.a.b.a("aHR0cHM6Ly9hcGkuaHRwLmFkLXNjb3BlLmNvbS5jbi9tYi9zZGsvZXZlbnQvdjE/ZXh0SW5mbz13QkxRZVA4Ym1xNkF1SjVEYVp5YzV4UVFVXzkyT1drU1VkeV82VjRuMlJBM01iZ2VodzZKNjdaZndjRFFDbWozdVR5aENrclQ4bk1Bc1EmcmVxdWVzdFV1aWQ9X19SRVFVRVNUVVVJRF9fJmV2ZW50VHlwZT1fX0VWRU5UVFlQRV9fJmFwcElEPV9fQVBQSURfXyZzcGFjZUlEPV9fU1BBQ0VJRF9fJmNoYW5uZWxJRD1fX0NIQU5ORUxJRF9fJmNoYW5uZWxBcHBJRD1fX0NIQU5ORUxBUFBJRF9fJmNoYW5uZWxTcGFjZUlEPV9fQ0hBTk5FTFNQQUNFSURfXyZ0cz1fX1RTX18maXA9X19JUF9fJm5ldFR5cGU9X19ORVRUWVBFX18mY2Fycmllcj1fX0NBUlJJRVJfXyZlcnJJbmZvPV9fRVJSSU5GT19fJnNka0V4dEluZm89X19TREtFWFRJTkZPX18maW1laT1fX0lNRUlfXyZhbmRyb2lkSUQ9X19BTkRST0lESURfXyZpZGZhPV9fSURGQV9fJmlkZnY9X19JREZWX18mbWFjPV9fTUFDX18mdWlkPV9fVUlEX18mc2RrVmVyc2lvbj1fX1NES1ZFUlNJT05fXyZhcHBWZXJpc29uPV9fQVBQVkVSU0lPTl9f"));
            this.Q = (String) SPUtils.get(this.f14098h.b(), "eventsList", "[1, 2, 3, 4, 5, 6]");
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f14095e;
    }

    protected Context a(View view) {
        if (view.getContext() instanceof MutableContextWrapper) {
            return ((MutableContextWrapper) view.getContext()).getBaseContext();
        }
        return getContext();
    }

    private void a(WebView webView, Context context) {
        Intent intent = new Intent(context, AdActivity.a());
        intent.setFlags(268435456);
        intent.putExtra("ACTIVITY_TYPE", "BROWSER");
        com.beizi.ad.internal.activity.a.f13657a.add(webView);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            com.beizi.ad.internal.activity.a.f13657a.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdViewImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdViewImpl(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f14091a = null;
        this.f14103m = null;
        this.f14106p = "";
        this.f14092b = new a();
        this.f14111u = new Handler(Looper.getMainLooper()) { // from class: com.beizi.ad.internal.view.AdViewImpl.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        };
        this.f14094d = false;
        this.f14095e = false;
        this.f14096f = false;
        this.f14097g = true;
        this.f14113w = false;
        this.f14114x = true;
        this.f14098h = null;
        this.f14099i = null;
        this.f14115y = false;
        this.f14100j = false;
        this.f14101k = false;
        this.T = false;
        this.f14102l = 0;
        a(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i4, int i5, f fVar) {
        ViewUtil.removeChildFromParent(this.A);
        this.A = null;
        AdWebView adWebView = fVar.f14292b;
        if (adWebView.f14193a) {
            ViewUtil.removeChildFromParent(adWebView);
            if (fVar.d() != null) {
                fVar.d().addView(fVar.f14292b, 0);
            }
            if (fVar.c() != null) {
                fVar.c().finish();
            }
            if (getMediaType().equals(k.BANNER) && (fVar.f14292b.getContext() instanceof MutableContextWrapper)) {
                ((MutableContextWrapper) fVar.f14292b.getContext()).setBaseContext(getContext());
            }
        }
        U = null;
        V = null;
        W = null;
        a(i4, i5);
        this.f14096f = true;
        this.f14095e = false;
    }

    private void a(int i4, int i5) {
        this.f14094d = true;
        if (getLayoutParams() != null) {
            if (getLayoutParams().width > 0) {
                getLayoutParams().width = i4;
            }
            if (getLayoutParams().height > 0) {
                getLayoutParams().height = i5;
            }
        }
        if (this.f14113w && (getParent() instanceof View)) {
            View view = (View) getParent();
            if (view.getLayoutParams() != null) {
                if (view.getLayoutParams().width > 0) {
                    view.getLayoutParams().width = i4;
                }
                if (view.getLayoutParams().height > 0) {
                    view.getLayoutParams().height = i5;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final f fVar, boolean z3, AdWebView.b bVar) {
        fVar.a((ViewGroup) fVar.f14292b.getParent());
        FrameLayout frameLayout = new FrameLayout(getContext());
        ViewUtil.removeChildFromParent(fVar.f14292b);
        frameLayout.addView(fVar.f14292b);
        if (this.A == null) {
            AppCompatTextView createCloseButton = ViewUtil.createCloseButton(getContext());
            this.A = createCloseButton;
            createCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    fVar.a();
                }
            });
        }
        frameLayout.addView(this.A);
        U = frameLayout;
        V = fVar;
        W = bVar;
        Class a4 = AdActivity.a();
        try {
            Intent intent = new Intent(getContext(), a4);
            intent.putExtra("ACTIVITY_TYPE", "MRAID");
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            HaoboLog.e(HaoboLog.baseLogTag, HaoboLog.getString(R.string.adactivity_missing, a4.getName()));
            U = null;
            V = null;
            W = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i4, int i5, boolean z3, final f fVar, AdWebView.b bVar) {
        a(i4, i5);
        AppCompatTextView createCloseButton = ViewUtil.createCloseButton(getContext());
        this.A = createCloseButton;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) createCloseButton.getLayoutParams();
        if (!fVar.f14292b.f14193a && getChildAt(0) != null) {
            layoutParams.rightMargin = (getMeasuredWidth() - getChildAt(0).getMeasuredWidth()) / 2;
        }
        this.A.setLayoutParams(layoutParams);
        this.A.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                fVar.a();
            }
        });
        if (fVar.f14292b.f14193a) {
            a(fVar, z3, bVar);
        } else {
            addView(this.A);
        }
        this.f14095e = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i4, int i5, int i6, int i7, f.a aVar, boolean z3, final f fVar) {
        a(i4, i5);
        ViewUtil.removeChildFromParent(this.A);
        if (this.f14102l <= 0) {
            this.f14102l = (int) (fVar.f14292b.getContext().getResources().getDisplayMetrics().density * 50.0f);
        }
        this.A = new AppCompatTextView(getContext()) { // from class: com.beizi.ad.internal.view.AdViewImpl.10
            @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
            @SuppressLint({"NewApi", "DrawAllocation"})
            public void onLayout(boolean z4, int i8, int i9, int i10, int i11) {
                Activity activity;
                boolean z5;
                Point point;
                int i12;
                int i13;
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                Point point2 = new Point(0, 0);
                try {
                    activity = (Activity) fVar.f14292b.getContext();
                    z5 = true;
                } catch (ClassCastException unused) {
                    activity = null;
                    z5 = false;
                }
                if (z5) {
                    activity.getWindowManager().getDefaultDisplay().getSize(point2);
                }
                int[] iArr2 = new int[2];
                if (AdViewImpl.this.getMediaType().equals(k.INTERSTITIAL)) {
                    InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.measure(0, 0);
                    InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.getLocationOnScreen(iArr2);
                    point = new Point(InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.getMeasuredWidth(), InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.getMeasuredHeight());
                } else {
                    AdViewImpl.this.measure(0, 0);
                    AdViewImpl.this.getLocationOnScreen(iArr2);
                    point = new Point(AdViewImpl.this.getMeasuredWidth(), AdViewImpl.this.getMeasuredHeight());
                }
                int i14 = point.x;
                int i15 = AdViewImpl.this.f14102l;
                int i16 = i14 - i15;
                int i17 = point.y - i15;
                if (z5) {
                    i16 = (iArr2[0] + Math.min(point2.x, i14)) - AdViewImpl.this.f14102l;
                    i17 = (iArr2[1] + Math.min(point2.y, point.y)) - AdViewImpl.this.f14102l;
                    i12 = iArr2[0];
                    i13 = iArr2[1];
                } else {
                    i12 = 0;
                    i13 = 0;
                }
                if (iArr[0] + 1 < i12 || iArr[0] - 1 > i16 || iArr[1] + 1 < i13 || iArr[1] - 1 > i17) {
                    final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 53);
                    layoutParams.setMargins(40, 40, 40, 40);
                    post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            setLayoutParams(layoutParams);
                        }
                    });
                    AdViewImpl.this.A.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_close_background));
                    AdViewImpl.this.A.setTextColor(ContextCompat.getColorStateList(getContext(), R.color.button_text_selector));
                    AdViewImpl.this.A.setTextSize(2, 16.0f);
                    AdViewImpl.this.A.setText(R.string.skip_ad);
                }
            }
        };
        int i8 = this.f14102l;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i8, i8, 17);
        int i9 = this.f14102l;
        int i10 = (i5 / 2) - (i9 / 2);
        int i11 = (i4 / 2) - (i9 / 2);
        int i12 = AnonymousClass14.f14126a[aVar.ordinal()];
        if (i12 == 1) {
            layoutParams.topMargin = i10;
        } else if (i12 == 2) {
            layoutParams.rightMargin = i11;
            layoutParams.topMargin = i10;
        } else if (i12 == 3) {
            layoutParams.leftMargin = i11;
            layoutParams.topMargin = i10;
        } else if (i12 == 5) {
            layoutParams.bottomMargin = i10;
        } else if (i12 == 6) {
            layoutParams.rightMargin = i11;
            layoutParams.bottomMargin = i10;
        } else if (i12 == 7) {
            layoutParams.leftMargin = i11;
            layoutParams.bottomMargin = i10;
        }
        this.A.setLayoutParams(layoutParams);
        this.A.setBackgroundColor(0);
        this.A.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                fVar.a();
            }
        });
        if (fVar.f14292b.getParent() != null) {
            ((ViewGroup) fVar.f14292b.getParent()).addView(this.A);
        }
    }
}
