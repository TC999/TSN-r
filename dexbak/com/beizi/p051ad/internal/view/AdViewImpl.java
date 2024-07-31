package com.beizi.p051ad.internal.view;

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
import com.beizi.p051ad.AdActivity;
import com.beizi.p051ad.AdLifeControl;
import com.beizi.p051ad.AdListener;
import com.beizi.p051ad.AdSize;
import com.beizi.p051ad.AppEventListener;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.RewardedVideoAdListener;
import com.beizi.p051ad.internal.Ad;
import com.beizi.p051ad.internal.AdDispatcher;
import com.beizi.p051ad.internal.AdFetcher;
import com.beizi.p051ad.internal.AdParameters;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.internal.ClickTracker;
import com.beizi.p051ad.internal.EnumC2888k;
import com.beizi.p051ad.internal.RewardItemImpl;
import com.beizi.p051ad.internal.activity.BrowserAdActivity;
import com.beizi.p051ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.p051ad.internal.activity.InterstitialAdActivity;
import com.beizi.p051ad.internal.network.AdRequestImpl;
import com.beizi.p051ad.internal.network.AdResponse;
import com.beizi.p051ad.internal.network.ServerResponse;
import com.beizi.p051ad.internal.p057a.MediationDisplayable;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.SPUtils;
import com.beizi.p051ad.internal.utilities.StringUtil;
import com.beizi.p051ad.internal.utilities.VideoCacheManager;
import com.beizi.p051ad.internal.utilities.ViewUtil;
import com.beizi.p051ad.internal.utilities.WebviewUtil;
import com.beizi.p051ad.internal.video.AdVideoView;
import com.beizi.p051ad.internal.view.AdWebView;
import com.beizi.p051ad.internal.view.MRAIDImplementation;
import com.beizi.p051ad.lance.p062a.C3019b;
import com.beizi.p051ad.lance.p062a.HeaderUtil;
import com.beizi.p051ad.lance.p062a.LogUtil;
import com.beizi.p051ad.lance.p062a.SystemUtil;
import com.beizi.p051ad.p056c.EnumType;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.stub.StubApp;
import java.util.ArrayList;

/* renamed from: com.beizi.ad.internal.view.AdViewImpl */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AdViewImpl extends FrameLayout implements AdLifeControl, Ad {

    /* renamed from: T */
    private static FrameLayout f10490T;

    /* renamed from: U */
    private static MRAIDImplementation f10491U;

    /* renamed from: V */
    private static AdWebView.InterfaceC2992b f10492V;

    /* renamed from: A */
    private AppCompatTextView f10493A;

    /* renamed from: B */
    private ImageView f10494B;

    /* renamed from: C */
    private CountDownTimer f10495C;

    /* renamed from: D */
    private AppCompatImageView f10496D;

    /* renamed from: E */
    private long f10497E;

    /* renamed from: F */
    private GestureDetector f10498F;

    /* renamed from: G */
    private float f10499G;

    /* renamed from: H */
    private float f10500H;

    /* renamed from: I */
    private float f10501I;

    /* renamed from: J */
    private float f10502J;

    /* renamed from: K */
    private FrameLayout f10503K;

    /* renamed from: L */
    private FrameLayout f10504L;

    /* renamed from: M */
    private String f10505M;

    /* renamed from: N */
    private String f10506N;

    /* renamed from: O */
    private String f10507O;

    /* renamed from: P */
    private String f10508P;

    /* renamed from: Q */
    private String f10509Q;

    /* renamed from: R */
    private AdWebView f10510R;

    /* renamed from: S */
    private boolean f10511S;

    /* renamed from: a */
    protected ViewGroup f10512a;

    /* renamed from: b */
    protected C2970a f10513b;
    public int bottomPadding;

    /* renamed from: c */
    protected Displayable f10514c;
    public int clickCount;

    /* renamed from: d */
    protected boolean f10515d;

    /* renamed from: e */
    protected boolean f10516e;

    /* renamed from: f */
    protected boolean f10517f;

    /* renamed from: g */
    protected boolean f10518g;

    /* renamed from: h */
    protected AdParameters f10519h;

    /* renamed from: i */
    protected AdRequestImpl.C2918a f10520i;

    /* renamed from: j */
    protected boolean f10521j;

    /* renamed from: k */
    protected boolean f10522k;

    /* renamed from: l */
    int f10523l;
    public int leftPadding;
    public int loadCount;

    /* renamed from: m */
    private View f10524m;
    public AdFetcher mAdFetcher;

    /* renamed from: n */
    private int f10525n;

    /* renamed from: o */
    private int f10526o;

    /* renamed from: p */
    private String f10527p;

    /* renamed from: q */
    private AdListener f10528q;

    /* renamed from: r */
    private RewardedVideoAdListener f10529r;
    public int rightPadding;

    /* renamed from: s */
    private AppEventListener f10530s;
    public ServerResponse serverResponse;

    /* renamed from: t */
    private C2985c f10531t;
    public int topPadding;

    /* renamed from: u */
    private final Handler f10532u;

    /* renamed from: v */
    private C2972b f10533v;

    /* renamed from: w */
    private boolean f10534w;

    /* renamed from: x */
    private boolean f10535x;

    /* renamed from: y */
    private boolean f10536y;

    /* renamed from: z */
    private AppCompatTextView f10537z;

    /* renamed from: com.beizi.ad.internal.view.AdViewImpl$14 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static /* synthetic */ class C295314 {

        /* renamed from: a */
        static final /* synthetic */ int[] f10547a;

        static {
            int[] iArr = new int[MRAIDImplementation.EnumC3013a.values().length];
            f10547a = iArr;
            try {
                iArr[MRAIDImplementation.EnumC3013a.bottom_center.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10547a[MRAIDImplementation.EnumC3013a.bottom_left.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10547a[MRAIDImplementation.EnumC3013a.bottom_right.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10547a[MRAIDImplementation.EnumC3013a.center.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10547a[MRAIDImplementation.EnumC3013a.top_center.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10547a[MRAIDImplementation.EnumC3013a.top_left.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10547a[MRAIDImplementation.EnumC3013a.top_right.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.beizi.ad.internal.view.AdViewImpl$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class C2970a {

        /* renamed from: a */
        public EnumC2971a f10582a = EnumC2971a.UNCHANGE;

        /* renamed from: b */
        public boolean f10583b = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.beizi.ad.internal.view.AdViewImpl$a$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public enum EnumC2971a {
            UNCHANGE,
            STATE_PREPARE_CHANGE,
            STATE_BACKGROUND,
            FINISHCLOSE
        }

        C2970a() {
        }

        /* renamed from: a */
        public boolean m49227a() {
            return this.f10583b;
        }

        /* renamed from: b */
        public void m49224b() {
            this.f10582a = EnumC2971a.UNCHANGE;
        }

        /* renamed from: c */
        public EnumC2971a m49223c() {
            return this.f10582a;
        }

        /* renamed from: a */
        public void m49225a(boolean z) {
            this.f10583b = z;
        }

        /* renamed from: a */
        public synchronized void m49226a(EnumC2971a enumC2971a) {
            EnumC2971a enumC2971a2 = EnumC2971a.STATE_PREPARE_CHANGE;
            if (enumC2971a == enumC2971a2 && this.f10582a == EnumC2971a.UNCHANGE) {
                this.f10582a = enumC2971a2;
            }
            EnumC2971a enumC2971a3 = EnumC2971a.STATE_BACKGROUND;
            if (enumC2971a == enumC2971a3 && this.f10582a == enumC2971a2) {
                this.f10582a = enumC2971a3;
            }
            EnumC2971a enumC2971a4 = EnumC2971a.FINISHCLOSE;
            if (enumC2971a == enumC2971a4 && this.f10582a == enumC2971a3 && this.f10583b) {
                this.f10582a = enumC2971a4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.beizi.ad.internal.view.AdViewImpl$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2972b implements AdDispatcher {

        /* renamed from: b */
        private Handler f10590b;

        /* renamed from: c */
        private AdResponse f10591c;

        public C2972b(Handler handler) {
            this.f10590b = handler;
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: b */
        public void mo49214b() {
            this.f10590b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AdViewImpl adViewImpl = AdViewImpl.this;
                        if (!adViewImpl.f10521j) {
                            if (adViewImpl.f10528q != null) {
                                AdViewImpl.this.f10528q.onAdClosed();
                                AdViewImpl.this.f10513b.m49224b();
                                if (AdViewImpl.this.f10510R != null) {
                                    AdViewImpl.this.f10510R.closeWebResourceRequestConnection();
                                }
                            }
                        } else if (adViewImpl.f10529r != null) {
                            AdViewImpl.this.f10529r.onRewardedVideoAdClosed();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: c */
        public void mo49213c() {
            this.f10590b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.8
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (!adViewImpl.f10521j) {
                        if (adViewImpl.f10528q != null) {
                            AdViewImpl.this.f10528q.onAdOpened();
                        }
                    } else if (adViewImpl.f10529r != null) {
                        AdViewImpl.this.f10529r.onRewardedVideoAdOpened();
                    }
                }
            });
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: d */
        public void mo49212d() {
            this.f10590b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.10
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (adViewImpl.f10521j || adViewImpl.f10528q == null) {
                        return;
                    }
                    AdViewImpl.this.f10513b.m49226a(C2970a.EnumC2971a.STATE_PREPARE_CHANGE);
                    Log.i("BeiZisAd", "enter BeiZi ad click");
                    AdViewImpl.this.f10528q.onAdClicked();
                }
            });
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: e */
        public void mo49211e() {
            this.f10590b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.11
                @Override // java.lang.Runnable
                public void run() {
                    if (AdViewImpl.this.f10528q != null) {
                        AdViewImpl.this.f10528q.onAdRequest();
                    }
                }
            });
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: f */
        public void mo49210f() {
            this.f10590b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.2
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (!adViewImpl.f10521j || adViewImpl.f10529r == null) {
                        return;
                    }
                    AdViewImpl.this.f10529r.onRewardedVideoStarted();
                }
            });
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: a */
        public void mo49219a(final AdResponse adResponse) {
            this.f10591c = adResponse;
            if (!adResponse.mo49313a().equals(EnumC2888k.BANNER) && !adResponse.mo49313a().equals(EnumC2888k.INTERSTITIAL) && !adResponse.mo49313a().equals(EnumC2888k.SPLASH)) {
                mo49221a(0);
            } else {
                this.f10590b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdViewImpl.this.setCreativeWidth(adResponse.mo49311c().getCreativeWidth());
                        AdViewImpl.this.setCreativeHeight(adResponse.mo49311c().getCreativeHeight());
                        AdViewImpl.this.setAdExtInfo(adResponse.mo49309e());
                        AdViewImpl.this.setPrice(adResponse.mo49308f());
                        AdViewImpl.this.setAdId(adResponse.mo49307g());
                        if (adResponse.mo49312b()) {
                            try {
                                AdViewImpl.this.mo49152a((MediationDisplayable) adResponse.mo49311c());
                            } catch (ClassCastException unused) {
                                HaoboLog.m49290e(HaoboLog.baseLogTag, "The SDK shouldn't fail downcasts to MediatedDisplayable in AdView");
                            }
                        } else {
                            AdViewImpl.this.mo49151a(adResponse.mo49311c());
                        }
                        AdViewImpl adViewImpl = AdViewImpl.this;
                        if (!adViewImpl.f10521j) {
                            if (adViewImpl.f10528q == null || adResponse.mo49313a().equals(EnumC2888k.SPLASH)) {
                                return;
                            }
                            Log.e("BeiZisAd", "enter BeiZi ad load");
                            if (adResponse.mo49313a().equals(EnumC2888k.INTERSTITIAL)) {
                                AdViewImpl.this.m49231h();
                            } else {
                                AdViewImpl.this.f10528q.onAdLoaded();
                            }
                            if (adResponse.mo49310d() != null) {
                                AdViewImpl.this.setLandingPageUrl(adResponse.mo49310d().getLandingPageUrl());
                            }
                        } else if (adViewImpl.f10529r != null) {
                            AdViewImpl.this.f10529r.onRewardedVideoAdLoaded();
                        }
                    }
                });
            }
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: a */
        public void mo49222a() {
            AdViewImpl.this.f10497E = System.currentTimeMillis();
            this.f10590b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.6
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (!adViewImpl.f10521j) {
                        if (adViewImpl.f10528q != null) {
                            Log.e("BeiZisAd", "enter BeiZi ad show");
                            AdViewImpl.this.f10528q.onAdShown();
                        }
                    } else if (adViewImpl.f10529r != null) {
                        AdViewImpl.this.f10529r.onRewardedVideoAdShown();
                    }
                }
            });
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: a */
        public void mo49221a(final int i) {
            this.f10590b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.7
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (!adViewImpl.f10521j) {
                        if (adViewImpl.f10528q != null) {
                            AdViewImpl.this.f10528q.onAdFailedToLoad(i);
                        }
                    } else if (adViewImpl.f10529r != null) {
                        AdViewImpl.this.f10529r.onRewardedVideoAdFailedToLoad(i);
                    }
                }
            });
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: a */
        public void mo49215a(final String str, final String str2) {
            this.f10590b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.12
                @Override // java.lang.Runnable
                public void run() {
                    if (AdViewImpl.this.f10530s != null) {
                        AdViewImpl.this.f10530s.onAppEvent(str, str2);
                    }
                }
            });
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: a */
        public void mo49216a(final String str, final int i) {
            this.f10590b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.3
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    if (!adViewImpl.f10521j || adViewImpl.f10529r == null) {
                        return;
                    }
                    AdViewImpl.this.f10529r.onRewarded(new RewardItemImpl(str, i));
                }
            });
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: a */
        public void mo49220a(final long j) {
            this.f10590b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (AdViewImpl.this.f10528q == null || C2972b.this.f10591c == null || !C2972b.this.f10591c.mo49313a().equals(EnumC2888k.SPLASH)) {
                        return;
                    }
                    AdViewImpl.this.f10528q.onAdTick(j);
                }
            });
        }

        @Override // com.beizi.p051ad.internal.AdDispatcher
        /* renamed from: a */
        public void mo49217a(final String str) {
            this.f10590b.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.b.5
                @Override // java.lang.Runnable
                public void run() {
                    if (AdViewImpl.this.f10528q == null || C2972b.this.f10591c == null) {
                        return;
                    }
                    AdViewImpl.this.f10528q.onAdComplainResult(str);
                }
            });
        }
    }

    /* renamed from: com.beizi.ad.internal.view.AdViewImpl$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2985c {

        /* renamed from: a */
        public static final ArrayList<Pair<String, C2985c>> f10612a = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdViewImpl(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public static FrameLayout getMRAIDFullscreenContainer() {
        return f10490T;
    }

    public static MRAIDImplementation getMRAIDFullscreenImplementation() {
        return f10491U;
    }

    public static AdWebView.InterfaceC2992b getMRAIDFullscreenListener() {
        return f10492V;
    }

    public static void setMRAIDFullscreenContainer(FrameLayout frameLayout) {
        f10490T = frameLayout;
    }

    public static void setMRAIDFullscreenImplementation(MRAIDImplementation mRAIDImplementation) {
        f10491U = mRAIDImplementation;
    }

    public static void setMRAIDFullscreenListener(AdWebView.InterfaceC2992b interfaceC2992b) {
        f10492V = interfaceC2992b;
    }

    /* renamed from: a */
    protected abstract void mo49152a(MediationDisplayable mediationDisplayable);

    /* renamed from: a */
    protected abstract void mo49151a(Displayable displayable);

    public abstract void activityOnDestroy();

    public abstract void activityOnPause();

    public abstract void activityOnResume();

    public void addBannerCloseBtn() {
        ViewUtil.removeChildFromParent(this.f10494B);
        ImageView createImageCloseButton = ViewUtil.createImageCloseButton(getContext());
        this.f10494B = createImageCloseButton;
        createImageCloseButton.setVisibility(0);
        this.f10494B.setEnabled(true);
        this.f10494B.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.21
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdViewImpl.this.getAdDispatcher().mo49214b();
            }
        });
    }

    public void addCloseButton(int i, int i2, int i3, final View view, final boolean z) {
        final int i4;
        ViewUtil.removeChildFromParent(this.f10493A);
        ViewUtil.removeChildFromParent(this.f10537z);
        CountDownTimer countDownTimer = this.f10495C;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f10493A = ViewUtil.createCloseButton(getContext(), this.leftPadding, this.topPadding, this.rightPadding, this.bottomPadding);
        int i5 = 0;
        if (i3 != -1) {
            this.f10537z = ViewUtil.createCountDown(getContext(), i3, this.leftPadding, this.topPadding, this.rightPadding, this.bottomPadding);
            if (i2 > 0) {
                this.f10493A.setEnabled(false);
                i4 = i3 - i2;
            } else {
                if (i2 == -1) {
                    this.f10493A.setVisibility(8);
                }
                i4 = 0;
            }
            CountDownTimer countDownTimer2 = new CountDownTimer(i3 * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.4
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AdViewImpl.this.f10537z.setText("0");
                    if (AdViewImpl.this.mo49147e()) {
                        if (z) {
                            View view2 = view;
                            if (view2 instanceof AdWebView) {
                                if (((AdWebView) view2).loadAdBy(1)) {
                                    ((InterstitialAdActivity) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).m49658g();
                                    return;
                                }
                                return;
                            } else if ((view2 instanceof AdVideoView) && ((AdVideoView) view2).getAdWebView().loadAdBy(1)) {
                                ((InterstitialAdActivity) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).m49658g();
                                return;
                            } else {
                                return;
                            }
                        }
                        AdViewImpl.this.getAdDispatcher().mo49214b();
                        Activity activity = (Activity) AdViewImpl.this.m49250a(view);
                        if (activity == null || activity.isFinishing()) {
                            return;
                        }
                        activity.finish();
                        return;
                    }
                    AdViewImpl.this.f10513b.m49225a(true);
                    if (AdViewImpl.this.f10513b.m49227a() && (AdViewImpl.this.f10513b.m49223c() == C2970a.EnumC2971a.UNCHANGE || AdViewImpl.this.f10513b.m49223c() == C2970a.EnumC2971a.STATE_PREPARE_CHANGE)) {
                        AdViewImpl.this.getAdDispatcher().mo49214b();
                    }
                    if (AdViewImpl.this.f10512a == null) {
                        HaoboLog.m49290e(HaoboLog.jsLogTag, "Should not close banner!");
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    int i6 = (int) ((j / 1000) + 1);
                    int i7 = i4;
                    if (i7 > 0 && i6 <= i7) {
                        AdViewImpl.this.f10493A.setEnabled(true);
                    }
                    AdViewImpl.this.f10537z.setText(Integer.toString(i6));
                }
            };
            this.f10495C = countDownTimer2;
            countDownTimer2.start();
        } else if (i2 == -1 || i == -1) {
            if (i != -1) {
                this.f10537z = ViewUtil.createCountDown(getContext(), i, this.leftPadding, this.topPadding, this.rightPadding, this.bottomPadding);
                CountDownTimer countDownTimer3 = new CountDownTimer(i * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.6
                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        AdViewImpl.this.f10537z.setText("0");
                        AdViewImpl.this.f10537z.setVisibility(8);
                    }

                    @Override // android.os.CountDownTimer
                    public void onTick(long j) {
                        AdViewImpl.this.f10537z.setText(Integer.toString((int) ((j / 1000) + 1)));
                    }
                };
                this.f10495C = countDownTimer3;
                countDownTimer3.start();
                ViewParent parent = mo49147e() ? view.getParent() : getParent();
                if (parent instanceof FrameLayout) {
                    ((FrameLayout) parent).addView(this.f10537z);
                    return;
                }
                return;
            }
            return;
        } else {
            this.f10537z = ViewUtil.createCountDown(getContext(), i, this.leftPadding, this.topPadding, this.rightPadding, this.bottomPadding);
            if (i2 > 0) {
                this.f10493A.setEnabled(false);
                i5 = i - i2;
            }
            final int i6 = i5;
            CountDownTimer countDownTimer4 = new CountDownTimer(i * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.5
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AdViewImpl.this.f10537z.setText("0");
                    AdViewImpl.this.f10537z.setVisibility(8);
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    int i7 = (int) ((j / 1000) + 1);
                    AdViewImpl.this.f10537z.setText(Integer.toString(i7));
                    int i8 = i6;
                    if (i8 <= 0 || i7 > i8) {
                        return;
                    }
                    AdViewImpl.this.f10493A.setEnabled(true);
                }
            };
            this.f10495C = countDownTimer4;
            countDownTimer4.start();
        }
        this.f10493A.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AdViewImpl.this.mo49147e()) {
                    if (z) {
                        View view3 = view;
                        if (view3 instanceof AdWebView) {
                            if (((AdWebView) view3).loadAdBy(1)) {
                                ((InterstitialAdActivity) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).m49658g();
                                return;
                            }
                            return;
                        } else if ((view3 instanceof AdVideoView) && ((AdVideoView) view3).getAdWebView().loadAdBy(1)) {
                            ((InterstitialAdActivity) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).m49658g();
                            return;
                        } else {
                            return;
                        }
                    }
                    AdViewImpl.this.getAdDispatcher().mo49214b();
                    Activity activity = (Activity) AdViewImpl.this.m49250a(view);
                    if (activity == null || activity.isFinishing()) {
                        return;
                    }
                    activity.onBackPressed();
                    activity.finish();
                    return;
                }
                AdViewImpl.this.getAdDispatcher().mo49214b();
                AdViewImpl.this.f10495C.cancel();
                if (AdViewImpl.this.f10512a != null) {
                    HaoboLog.m49290e(HaoboLog.jsLogTag, "Should not close banner!");
                }
            }
        });
        ViewParent parent2 = mo49147e() ? view.getParent() : getParent();
        if (parent2 instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) parent2;
            frameLayout.addView(this.f10493A);
            frameLayout.addView(this.f10537z);
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
                    textView.setText(Html.fromHtml("应用名称：" + apkName + " | 开发者：" + appDeveloper + " | 应用版本：" + appVersion + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
                    textView.setTextSize(2, 6.0f);
                    textView.setTextColor(Color.parseColor("#999999"));
                    textView.setShadowLayer(1.0f, 1.0f, 1.0f, Color.parseColor("#333333"));
                    textView.setPadding(10, 10, 10, 10);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.17
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            try {
                                Intent intent = new Intent(AdViewImpl.this.getContext(), DownloadAppInfoActivity.class);
                                intent.putExtra("title_content_key", apkName);
                                intent.putExtra("privacy_content_key", appPrivacyUrl);
                                intent.putExtra(TTDelegateActivity.PERMISSION_CONTENT_KEY, appPermissionsDesc);
                                intent.putExtra("intro_content_key", appintro);
                                AdViewImpl.this.getContext().startActivity(intent);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    int m49026g = (SystemUtil.m49026g(getContext()) * 2) / 3;
                    if (parent instanceof FrameLayout) {
                        ((FrameLayout) parent).addView(textView, new FrameLayout.LayoutParams(m49026g, -2, 83));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addInterstitialCloseButton(int i, int i2, final View view, final boolean z) {
        ViewUtil.removeChildFromParent(this.f10537z);
        if (i2 != -1) {
            this.f10537z = ViewUtil.createInterstitialCountDown(getContext(), i2);
            final int i3 = i > 0 ? i2 - i : 0;
            CountDownTimer countDownTimer = new CountDownTimer(i2 * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.19
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AdViewImpl.this.f10537z.setText("0");
                    if (AdViewImpl.this.mo49147e()) {
                        if (z) {
                            View view2 = view;
                            if (view2 instanceof AdWebView) {
                                if (((AdWebView) view2).loadAdBy(1)) {
                                    ((InterstitialAdActivity) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).m49658g();
                                    return;
                                }
                                return;
                            } else if ((view2 instanceof AdVideoView) && ((AdVideoView) view2).getAdWebView().loadAdBy(1)) {
                                ((InterstitialAdActivity) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).m49658g();
                                return;
                            } else {
                                return;
                            }
                        }
                        AdViewImpl.this.getAdDispatcher().mo49214b();
                        Activity activity = (Activity) AdViewImpl.this.m49250a(view);
                        if (activity == null || activity.isFinishing()) {
                            return;
                        }
                        activity.finish();
                        return;
                    }
                    AdViewImpl.this.getAdDispatcher().mo49214b();
                    if (AdViewImpl.this.f10512a == null) {
                        HaoboLog.m49290e(HaoboLog.jsLogTag, "Should not close banner!");
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    AdViewImpl.this.f10537z.setText(Integer.toString((int) ((j / 1000) + 1)));
                }
            };
            this.f10495C = countDownTimer;
            countDownTimer.start();
        } else if (i == -1) {
            return;
        } else {
            this.f10537z = ViewUtil.createInterstitialCountDown(getContext(), i);
            CountDownTimer countDownTimer2 = new CountDownTimer(i * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.20
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    AdViewImpl.this.f10537z.setText("");
                    AdViewImpl.this.f10537z.setBackgroundResource(C2750R.mipmap.ad_close);
                    AdViewImpl.this.f10537z.setVisibility(0);
                    AdViewImpl.this.f10537z.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.20.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (AdViewImpl.this.mo49147e()) {
                                CountDownTimerC296020 countDownTimerC296020 = CountDownTimerC296020.this;
                                if (z) {
                                    View view3 = view;
                                    if (view3 instanceof AdWebView) {
                                        if (((AdWebView) view3).loadAdBy(1)) {
                                            ((InterstitialAdActivity) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).m49658g();
                                            return;
                                        }
                                        return;
                                    } else if ((view3 instanceof AdVideoView) && ((AdVideoView) view3).getAdWebView().loadAdBy(1)) {
                                        ((InterstitialAdActivity) ((InterstitialAdViewImpl) AdViewImpl.this).getAdImplementation()).m49658g();
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                AdViewImpl.this.getAdDispatcher().mo49214b();
                                CountDownTimerC296020 countDownTimerC2960202 = CountDownTimerC296020.this;
                                Activity activity = (Activity) AdViewImpl.this.m49250a(view);
                                if (activity == null || activity.isFinishing()) {
                                    return;
                                }
                                activity.finish();
                            }
                        }
                    });
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    AdViewImpl.this.f10537z.setText(Integer.toString((int) ((j / 1000) + 1)));
                }
            };
            this.f10495C = countDownTimer2;
            countDownTimer2.start();
        }
        ViewParent parent = mo49147e() ? view.getParent() : getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).addView(this.f10537z);
        }
    }

    public void addMuteButton(final AdVideoView adVideoView, boolean z) {
        ViewUtil.removeChildFromParent(this.f10496D);
        AppCompatImageView createMuteButton = ViewUtil.createMuteButton(getContext(), z);
        this.f10496D = createMuteButton;
        createMuteButton.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdViewImpl.this.f10496D.setImageResource(adVideoView.toggleMute() ? C2750R.C2752drawable.voice_off : C2750R.C2752drawable.voice_on);
            }
        });
        ViewParent parent = mo49147e() ? adVideoView.getParent() : getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).addView(this.f10496D);
        }
    }

    public void addSkipView(int i, View view) {
        ViewUtil.removeChildFromParent(this.f10493A);
        ViewUtil.removeChildFromParent(this.f10537z);
        CountDownTimer countDownTimer = this.f10495C;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (i <= 0) {
            i = 5;
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(i * 1000, 50L) { // from class: com.beizi.ad.internal.view.AdViewImpl.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                AdViewImpl.this.f10513b.m49225a(true);
                if (AdViewImpl.this.f10513b.m49227a() && (AdViewImpl.this.f10513b.m49223c() == C2970a.EnumC2971a.UNCHANGE || AdViewImpl.this.f10513b.m49223c() == C2970a.EnumC2971a.STATE_PREPARE_CHANGE)) {
                    AdViewImpl.this.getAdDispatcher().mo49214b();
                }
                if (AdViewImpl.this.f10512a == null) {
                    HaoboLog.m49290e(HaoboLog.jsLogTag, "Should not close banner!");
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                AdViewImpl.this.getAdDispatcher().mo49220a(j);
            }
        };
        this.f10495C = countDownTimer2;
        countDownTimer2.start();
        view.setVisibility(0);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                AdViewImpl.this.getAdDispatcher().mo49214b();
                AdViewImpl.this.f10495C.cancel();
                if (AdViewImpl.this.f10512a != null) {
                    HaoboLog.m49290e(HaoboLog.jsLogTag, "Should not close banner!");
                }
            }
        });
    }

    /* renamed from: b */
    protected abstract void mo49150b(Context context, AttributeSet attributeSet);

    public void clearAdRequest() {
        this.f10520i = null;
    }

    public void closeAd() {
        try {
            getAdDispatcher().mo49214b();
            this.f10495C.cancel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createAdLogo(ServerResponse.AdLogoInfo adLogoInfo, ServerResponse.AdLogoInfo adLogoInfo2) {
        ViewUtil.removeChildFromParent(this.f10503K);
        ViewUtil.removeChildFromParent(this.f10504L);
        if (!TextUtils.isEmpty(adLogoInfo.getAdurl())) {
            this.f10503K = ViewUtil.createAdImageView(new MutableContextWrapper(getContext()), adLogoInfo);
        }
        if (TextUtils.isEmpty(adLogoInfo2.getAdurl())) {
            return;
        }
        this.f10504L = ViewUtil.createLogoImageView(new MutableContextWrapper(getContext()), adLogoInfo2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract boolean mo49148d();

    public void destroy() {
        HaoboLog.m49292d(HaoboLog.baseLogTag, "called destroy() on AdView");
        Displayable displayable = this.f10514c;
        if (displayable != null) {
            displayable.destroy();
            this.f10514c = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.f10498F.onTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract boolean mo49147e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public abstract void mo49146f();

    protected void finalize() {
        try {
            super.finalize();
        } catch (Throwable unused) {
        }
        AdFetcher adFetcher = this.mAdFetcher;
        if (adFetcher != null) {
            adFetcher.m49539a();
        }
    }

    public AdDispatcher getAdDispatcher() {
        return this.f10533v;
    }

    public String getAdId() {
        return this.f10507O;
    }

    public AdListener getAdListener() {
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.get_ad_listener));
        return this.f10528q;
    }

    public AdParameters getAdParameters() {
        return this.f10519h;
    }

    public AdRequestImpl.C2918a getAdRequest() {
        return this.f10520i;
    }

    public AdSize getAdSize() {
        return new AdSize(this.f10525n, this.f10526o);
    }

    public String getAdUnitId() {
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.get_placement_id, this.f10519h.m49511c()));
        return this.f10519h.m49511c();
    }

    public AppEventListener getAppEventListener() {
        return this.f10530s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2985c getBrowserStyle() {
        return this.f10531t;
    }

    int getContainerHeight() {
        return this.f10519h.m49503g();
    }

    int getContainerWidth() {
        return this.f10519h.m49504f();
    }

    public int getCreativeHeight() {
        return this.f10526o;
    }

    public int getCreativeWidth() {
        return this.f10525n;
    }

    public String getLandingPageUrl() {
        return this.f10506N;
    }

    public boolean getLoadsInBackground() {
        return this.f10518g;
    }

    public String getMediationAdapterClassName() {
        return null;
    }

    public Handler getMyHandler() {
        return this.f10532u;
    }

    public boolean getOpensNativeBrowser() {
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.get_opens_native_browser, this.f10519h.m49502h()));
        return this.f10519h.m49502h();
    }

    public String getPrice() {
        return this.f10505M;
    }

    public RewardedVideoAdListener getRewaredVideoAdListener() {
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.get_rewarded_video_ad_listener));
        return this.f10529r;
    }

    public boolean getShowLoadingIndicator() {
        return this.f10535x;
    }

    public ViewGroup getSplashParent() {
        return this.f10512a;
    }

    public boolean isCloseMarketDialog() {
        AdParameters adParameters = this.f10519h;
        if (adParameters != null) {
            return adParameters.m49498l();
        }
        return true;
    }

    public void isLoadToShow(AdWebView adWebView) {
        this.f10510R = adWebView;
        this.f10511S = true;
        if (this.f10528q != null) {
            Log.e("BeiZisAd", "enter BeiZi ad load");
            this.f10528q.onAdLoaded();
        }
    }

    public boolean isLoaded() {
        return this.f10511S;
    }

    public boolean isLoading() {
        return this.f10536y;
    }

    @Override // com.beizi.p051ad.internal.Ad
    public boolean isReadyToStart() {
        if (m49255a()) {
            HaoboLog.m49290e(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.already_expanded));
            return false;
        }
        AdParameters adParameters = this.f10519h;
        return (adParameters == null || !adParameters.m49500j() || this.f10520i == null) ? false : true;
    }

    public boolean isRewardedVideo() {
        return this.f10521j;
    }

    public boolean loadAd(AdRequestImpl.C2918a c2918a) {
        AdFetcher adFetcher;
        AdFetcher adFetcher2;
        this.f10520i = c2918a;
        if (!isReadyToStart()) {
            AdListener adListener = this.f10528q;
            if (adListener != null) {
                adListener.onAdFailedToLoad(4);
            }
            return false;
        } else if (getWindowVisibility() == 0 && (adFetcher2 = this.mAdFetcher) != null) {
            adFetcher2.m49539a();
            this.mAdFetcher.m49532c();
            this.mAdFetcher.m49534b();
            this.f10536y = true;
            this.loadCount = 1;
            this.clickCount = 0;
            return true;
        } else {
            if (this.f10512a != null && (adFetcher = this.mAdFetcher) != null) {
                adFetcher.m49539a();
                this.mAdFetcher.m49532c();
                this.mAdFetcher.m49534b();
                this.f10536y = true;
                this.loadCount = 1;
                this.clickCount = 0;
            }
            return false;
        }
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onCreateLifeCycle() {
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onDestoryLifeCycle() {
        AdFetcher adFetcher = this.mAdFetcher;
        if (adFetcher != null) {
            adFetcher.m49539a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onPauseLifeCycle() {
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onRestartLifeCycle() {
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onResumeLifeCycle() {
        C2970a c2970a = this.f10513b;
        C2970a.EnumC2971a enumC2971a = C2970a.EnumC2971a.FINISHCLOSE;
        c2970a.m49226a(enumC2971a);
        if (this.f10513b.m49223c() == enumC2971a) {
            getAdDispatcher().mo49214b();
        }
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onStartLifeCycle() {
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void onStopLifeCycle() {
        this.f10513b.m49226a(C2970a.EnumC2971a.STATE_BACKGROUND);
    }

    @Override // com.beizi.p051ad.AdLifeControl
    public void openAdInNativeBrowser(boolean z) {
        setOpensNativeBrowser(z);
    }

    public void pingClick(String str) {
        if (StringUtil.isEmpty(str)) {
            return;
        }
        new ClickTracker(str).execute(new Void[0]);
    }

    public void pingConvert(String str) {
        if (StringUtil.isEmpty(str)) {
            return;
        }
        new ClickTracker(str).execute(new Void[0]);
    }

    void setAdExtInfo(String str) {
        this.f10527p = str;
    }

    public void setAdId(String str) {
        this.f10507O = str;
    }

    public void setAdListener(AdListener adListener) {
        if (this.f10521j) {
            HaoboLog.m49290e(HaoboLog.publicFunctionsLogTag, "setAdListener() called on RewardedVideoAd");
            return;
        }
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.set_ad_listener));
        this.f10528q = adListener;
    }

    public void setAdUnitId(String str) {
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.set_placement_id, str));
        this.f10519h.m49516a(str);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.f10530s = appEventListener;
    }

    protected void setBrowserStyle(C2985c c2985c) {
        this.f10531t = c2985c;
    }

    public void setCloseButtonPadding(int i, int i2, int i3, int i4) {
        this.leftPadding = i;
        this.topPadding = i2;
        this.rightPadding = i3;
        this.bottomPadding = i4;
    }

    public void setCloseMarketDialog(boolean z) {
        AdParameters adParameters = this.f10519h;
        if (adParameters != null) {
            adParameters.m49509c(z);
        }
    }

    void setCreativeHeight(int i) {
        this.f10526o = i;
    }

    void setCreativeWidth(int i) {
        this.f10525n = i;
    }

    public void setLandingPageUrl(String str) {
        this.f10506N = str;
    }

    public void setLoadsInBackground(boolean z) {
        this.f10518g = z;
    }

    public void setOpensNativeBrowser(boolean z) {
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.set_opens_native_browser, z));
        this.f10519h.m49512b(z);
    }

    public void setPrice(String str) {
        this.f10505M = str;
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        if (!this.f10521j) {
            HaoboLog.m49290e(HaoboLog.publicFunctionsLogTag, "setRewardedVideoAdListener() called on non-RewardedVideoAd");
            return;
        }
        HaoboLog.m49292d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(C2750R.C2755string.set_rewarded_video_ad_listener));
        this.f10529r = rewardedVideoAdListener;
    }

    protected void setShouldResizeParent(boolean z) {
        this.f10534w = z;
    }

    public void setShowLoadingIndicator(boolean z) {
        this.f10535x = z;
    }

    public void showAd() {
        try {
            ViewGroup viewGroup = this.f10512a;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                this.f10512a.addView(this);
            }
            AdWebView adWebView = this.f10510R;
            ServerResponse serverResponse = adWebView.f10626ad;
            if (serverResponse != null && serverResponse.mMediaType == EnumC2888k.SPLASH && this.f10524m != null) {
                addSkipView(adWebView.getAutoCloseTime(), this.f10524m);
            } else {
                int showCloseBtnTime = adWebView.getShowCloseBtnTime();
                int autoCloseTime = this.f10510R.getAutoCloseTime();
                AdWebView adWebView2 = this.f10510R;
                addCloseButton(-1, showCloseBtnTime, autoCloseTime, adWebView2, adWebView2.f10626ad.getAdType() == EnumType.EnumC2812a.ADP_IVIDEO);
            }
            Log.e("BeiZisAd", "enter BeiZi ad show");
            this.f10510R.post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.15
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl.this.f10510R.f10626ad.handleView(AdViewImpl.this.f10510R, AdViewImpl.this.f10519h.m49519a());
                    if (AdViewImpl.this.f10528q != null) {
                        AdViewImpl.this.f10528q.onAdShown();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAdLogo(View view) {
        try {
            ViewUtil.removeChildFromParent(this.f10503K);
            ViewUtil.removeChildFromParent(this.f10504L);
            ViewParent parent = mo49147e() ? view.getParent() : this;
            if (parent instanceof FrameLayout) {
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                FrameLayout frameLayout = this.f10504L;
                if (frameLayout != null) {
                    linearLayout.addView(frameLayout, new FrameLayout.LayoutParams(-2, -2, 17));
                    this.f10504L.setVisibility(0);
                    this.f10504L.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.16
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            AdViewImpl.this.m49233g();
                        }
                    });
                }
                FrameLayout frameLayout2 = this.f10503K;
                if (frameLayout2 != null) {
                    linearLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-2, -2, 17));
                    this.f10503K.setVisibility(0);
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f10503K.getLayoutParams();
                layoutParams.setMargins(5, 0, 0, 0);
                layoutParams.gravity = 17;
                this.f10503K.setLayoutParams(layoutParams);
                ((FrameLayout) parent).addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                int dip2px = ViewUtil.dip2px(getContext(), 12.0f);
                layoutParams2.setMargins(0, 0, dip2px, dip2px);
                linearLayout.setLayoutParams(layoutParams2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showBannerCloseBtn(View view) {
        ImageView imageView;
        if (!(view instanceof FrameLayout) || (imageView = this.f10494B) == null) {
            return;
        }
        ((FrameLayout) view).addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdViewImpl(Context context, ViewGroup viewGroup, View view) {
        super(context, null, 0);
        this.f10512a = null;
        this.f10524m = null;
        this.f10527p = "";
        this.f10513b = new C2970a();
        this.f10532u = new Handler(Looper.getMainLooper()) { // from class: com.beizi.ad.internal.view.AdViewImpl.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        };
        this.f10515d = false;
        this.f10516e = false;
        this.f10517f = false;
        this.f10518g = true;
        this.f10534w = false;
        this.f10535x = true;
        this.f10519h = null;
        this.f10520i = null;
        this.f10536y = false;
        this.f10521j = false;
        this.f10522k = false;
        this.f10511S = false;
        this.f10523l = 0;
        this.f10512a = viewGroup;
        this.f10524m = view;
        mo49153a(context, (AttributeSet) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m49233g() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        WebView webView = new WebView(new MutableContextWrapper(getContext()));
        WebviewUtil.setWebViewSettings(webView);
        String m49089a = C3019b.m49089a("aHR0cDovL3Nka2RvYy5iZWl6aS5iaXovIy96aC1jbi9ndWlkZS9Vc2VQcml2YWN5");
        if (!TextUtils.isEmpty(m49089a)) {
            webView.loadUrl(m49089a, HeaderUtil.m49052a());
        }
        m49249a(webView, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m49231h() {
        String str;
        boolean z = false;
        try {
            ServerResponse serverResponse = this.serverResponse;
            String str2 = null;
            if (serverResponse != null) {
                z = serverResponse.isVideo();
                String imageUrl = this.serverResponse.getImageUrl();
                str2 = this.serverResponse.getVideoUrl();
                str = imageUrl;
            } else {
                str = null;
            }
            if (!z) {
                if (TextUtils.isEmpty(str)) {
                    AdListener adListener = this.f10528q;
                    if (adListener != null) {
                        adListener.onAdFailedToLoad(3);
                        return;
                    }
                    return;
                }
                AdListener adListener2 = this.f10528q;
                if (adListener2 != null) {
                    this.f10511S = true;
                    adListener2.onAdLoaded();
                }
            } else if (TextUtils.isEmpty(str2)) {
                AdListener adListener3 = this.f10528q;
                if (adListener3 != null) {
                    adListener3.onAdFailedToLoad(3);
                }
            } else {
                VideoCacheManager.with().getCacheVideo(getContext(), str2, new VideoCacheManager.VideoLoadedListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.13
                    @Override // com.beizi.p051ad.internal.utilities.VideoCacheManager.VideoLoadedListener
                    public void onVideoLoadFailed() {
                        if (AdViewImpl.this.f10528q != null) {
                            AdViewImpl.this.f10528q.onAdFailedToLoad(6);
                        }
                    }

                    @Override // com.beizi.p051ad.internal.utilities.VideoCacheManager.VideoLoadedListener
                    public void onVideoLoaded(String str3) {
                        LogUtil.m49046a("BeiZisAd", "onVideoLoaded: 加载成功");
                        if (AdViewImpl.this.f10528q != null) {
                            AdViewImpl.this.f10511S = true;
                            AdViewImpl.this.f10528q.onAdLoaded();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m49243b() {
        getVisibility();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m49240c() {
        getVisibility();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo49153a(Context context, AttributeSet attributeSet) {
        setBackgroundColor(0);
        this.f10533v = new C2972b(this.f10532u);
        this.f10519h = new AdParameters(context, StringUtil.createRequestId());
        this.f10498F = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.12
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                AdViewImpl.this.f10499G = motionEvent.getX();
                AdViewImpl.this.f10500H = motionEvent.getY();
                AdViewImpl.this.f10501I = motionEvent.getRawX();
                AdViewImpl.this.f10502J = motionEvent.getRawY();
                AdViewImpl adViewImpl = AdViewImpl.this;
                int i = adViewImpl.clickCount;
                int i2 = adViewImpl.loadCount;
                return true;
            }
        });
        try {
            HaoboLog.setErrorContext(StubApp.getOrigApplicationContext(getContext().getApplicationContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        HaoboLog.m49286v(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.appid, BeiZiImpl.m49492a().m49475d()));
        setPadding(0, 0, 0, 0);
        this.mAdFetcher = new AdFetcher(this);
        if (attributeSet != null) {
            mo49150b(context, attributeSet);
        }
        try {
            this.f10508P = (String) SPUtils.get(this.f10519h.m49514b(), "urlTemplate", C3019b.m49089a("aHR0cHM6Ly9hcGkuaHRwLmFkLXNjb3BlLmNvbS5jbi9tYi9zZGsvZXZlbnQvdjE/ZXh0SW5mbz13QkxRZVA4Ym1xNkF1SjVEYVp5YzV4UVFVXzkyT1drU1VkeV82VjRuMlJBM01iZ2VodzZKNjdaZndjRFFDbWozdVR5aENrclQ4bk1Bc1EmcmVxdWVzdFV1aWQ9X19SRVFVRVNUVVVJRF9fJmV2ZW50VHlwZT1fX0VWRU5UVFlQRV9fJmFwcElEPV9fQVBQSURfXyZzcGFjZUlEPV9fU1BBQ0VJRF9fJmNoYW5uZWxJRD1fX0NIQU5ORUxJRF9fJmNoYW5uZWxBcHBJRD1fX0NIQU5ORUxBUFBJRF9fJmNoYW5uZWxTcGFjZUlEPV9fQ0hBTk5FTFNQQUNFSURfXyZ0cz1fX1RTX18maXA9X19JUF9fJm5ldFR5cGU9X19ORVRUWVBFX18mY2Fycmllcj1fX0NBUlJJRVJfXyZlcnJJbmZvPV9fRVJSSU5GT19fJnNka0V4dEluZm89X19TREtFWFRJTkZPX18maW1laT1fX0lNRUlfXyZhbmRyb2lkSUQ9X19BTkRST0lESURfXyZpZGZhPV9fSURGQV9fJmlkZnY9X19JREZWX18mbWFjPV9fTUFDX18mdWlkPV9fVUlEX18mc2RrVmVyc2lvbj1fX1NES1ZFUlNJT05fXyZhcHBWZXJpc29uPV9fQVBQVkVSU0lPTl9f"));
            this.f10509Q = (String) SPUtils.get(this.f10519h.m49514b(), "eventsList", "[1, 2, 3, 4, 5, 6]");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m49255a() {
        return this.f10516e;
    }

    /* renamed from: a */
    protected Context m49250a(View view) {
        if (view.getContext() instanceof MutableContextWrapper) {
            return ((MutableContextWrapper) view.getContext()).getBaseContext();
        }
        return getContext();
    }

    /* renamed from: a */
    private void m49249a(WebView webView, Context context) {
        Intent intent = new Intent(context, AdActivity.m50215a());
        intent.setFlags(268435456);
        intent.putExtra("ACTIVITY_TYPE", "BROWSER");
        BrowserAdActivity.f9980a.add(webView);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            BrowserAdActivity.f9980a.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdViewImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdViewImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10512a = null;
        this.f10524m = null;
        this.f10527p = "";
        this.f10513b = new C2970a();
        this.f10532u = new Handler(Looper.getMainLooper()) { // from class: com.beizi.ad.internal.view.AdViewImpl.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        };
        this.f10515d = false;
        this.f10516e = false;
        this.f10517f = false;
        this.f10518g = true;
        this.f10534w = false;
        this.f10535x = true;
        this.f10519h = null;
        this.f10520i = null;
        this.f10536y = false;
        this.f10521j = false;
        this.f10522k = false;
        this.f10511S = false;
        this.f10523l = 0;
        mo49153a(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m49252a(int i, int i2, MRAIDImplementation mRAIDImplementation) {
        ViewUtil.removeChildFromParent(this.f10493A);
        this.f10493A = null;
        AdWebView adWebView = mRAIDImplementation.f10727b;
        if (adWebView.f10625a) {
            ViewUtil.removeChildFromParent(adWebView);
            if (mRAIDImplementation.m49105d() != null) {
                mRAIDImplementation.m49105d().addView(mRAIDImplementation.f10727b, 0);
            }
            if (mRAIDImplementation.m49107c() != null) {
                mRAIDImplementation.m49107c().finish();
            }
            if (getMediaType().equals(EnumC2888k.BANNER) && (mRAIDImplementation.f10727b.getContext() instanceof MutableContextWrapper)) {
                ((MutableContextWrapper) mRAIDImplementation.f10727b.getContext()).setBaseContext(getContext());
            }
        }
        f10490T = null;
        f10491U = null;
        f10492V = null;
        m49254a(i, i2);
        this.f10517f = true;
        this.f10516e = false;
    }

    /* renamed from: a */
    private void m49254a(int i, int i2) {
        this.f10515d = true;
        if (getLayoutParams() != null) {
            if (getLayoutParams().width > 0) {
                getLayoutParams().width = i;
            }
            if (getLayoutParams().height > 0) {
                getLayoutParams().height = i2;
            }
        }
        if (this.f10534w && (getParent() instanceof View)) {
            View view = (View) getParent();
            if (view.getLayoutParams() != null) {
                if (view.getLayoutParams().width > 0) {
                    view.getLayoutParams().width = i;
                }
                if (view.getLayoutParams().height > 0) {
                    view.getLayoutParams().height = i2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m49244a(final MRAIDImplementation mRAIDImplementation, boolean z, AdWebView.InterfaceC2992b interfaceC2992b) {
        mRAIDImplementation.m49118a((ViewGroup) mRAIDImplementation.f10727b.getParent());
        FrameLayout frameLayout = new FrameLayout(getContext());
        ViewUtil.removeChildFromParent(mRAIDImplementation.f10727b);
        frameLayout.addView(mRAIDImplementation.f10727b);
        if (this.f10493A == null) {
            AppCompatTextView createCloseButton = ViewUtil.createCloseButton(getContext());
            this.f10493A = createCloseButton;
            createCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    mRAIDImplementation.m49123a();
                }
            });
        }
        frameLayout.addView(this.f10493A);
        f10490T = frameLayout;
        f10491U = mRAIDImplementation;
        f10492V = interfaceC2992b;
        Class m50215a = AdActivity.m50215a();
        try {
            Intent intent = new Intent(getContext(), m50215a);
            intent.putExtra("ACTIVITY_TYPE", ServerResponse.EXTRAS_KEY_MRAID);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            HaoboLog.m49290e(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.adactivity_missing, m50215a.getName()));
            f10490T = null;
            f10491U = null;
            f10492V = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m49251a(int i, int i2, boolean z, final MRAIDImplementation mRAIDImplementation, AdWebView.InterfaceC2992b interfaceC2992b) {
        m49254a(i, i2);
        AppCompatTextView createCloseButton = ViewUtil.createCloseButton(getContext());
        this.f10493A = createCloseButton;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) createCloseButton.getLayoutParams();
        if (!mRAIDImplementation.f10727b.f10625a && getChildAt(0) != null) {
            layoutParams.rightMargin = (getMeasuredWidth() - getChildAt(0).getMeasuredWidth()) / 2;
        }
        this.f10493A.setLayoutParams(layoutParams);
        this.f10493A.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                mRAIDImplementation.m49123a();
            }
        });
        if (mRAIDImplementation.f10727b.f10625a) {
            m49244a(mRAIDImplementation, z, interfaceC2992b);
        } else {
            addView(this.f10493A);
        }
        this.f10516e = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m49253a(int i, int i2, int i3, int i4, MRAIDImplementation.EnumC3013a enumC3013a, boolean z, final MRAIDImplementation mRAIDImplementation) {
        m49254a(i, i2);
        ViewUtil.removeChildFromParent(this.f10493A);
        if (this.f10523l <= 0) {
            this.f10523l = (int) (mRAIDImplementation.f10727b.getContext().getResources().getDisplayMetrics().density * 50.0f);
        }
        this.f10493A = new AppCompatTextView(getContext()) { // from class: com.beizi.ad.internal.view.AdViewImpl.10
            @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
            @SuppressLint({"NewApi", "DrawAllocation"})
            public void onLayout(boolean z2, int i5, int i6, int i7, int i8) {
                Activity activity;
                boolean z3;
                Point point;
                int i9;
                int i10;
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                Point point2 = new Point(0, 0);
                try {
                    activity = (Activity) mRAIDImplementation.f10727b.getContext();
                    z3 = true;
                } catch (ClassCastException unused) {
                    activity = null;
                    z3 = false;
                }
                if (z3) {
                    activity.getWindowManager().getDefaultDisplay().getSize(point2);
                }
                int[] iArr2 = new int[2];
                if (AdViewImpl.this.getMediaType().equals(EnumC2888k.INTERSTITIAL)) {
                    InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.measure(0, 0);
                    InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.getLocationOnScreen(iArr2);
                    point = new Point(InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.getMeasuredWidth(), InterstitialAdViewImpl.INTERSTITIALADVIEW_TO_USE.getMeasuredHeight());
                } else {
                    AdViewImpl.this.measure(0, 0);
                    AdViewImpl.this.getLocationOnScreen(iArr2);
                    point = new Point(AdViewImpl.this.getMeasuredWidth(), AdViewImpl.this.getMeasuredHeight());
                }
                int i11 = point.x;
                int i12 = AdViewImpl.this.f10523l;
                int i13 = i11 - i12;
                int i14 = point.y - i12;
                if (z3) {
                    i13 = (iArr2[0] + Math.min(point2.x, i11)) - AdViewImpl.this.f10523l;
                    i14 = (iArr2[1] + Math.min(point2.y, point.y)) - AdViewImpl.this.f10523l;
                    i9 = iArr2[0];
                    i10 = iArr2[1];
                } else {
                    i9 = 0;
                    i10 = 0;
                }
                if (iArr[0] + 1 < i9 || iArr[0] - 1 > i13 || iArr[1] + 1 < i10 || iArr[1] - 1 > i14) {
                    final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 53);
                    layoutParams.setMargins(40, 40, 40, 40);
                    post(new Runnable() { // from class: com.beizi.ad.internal.view.AdViewImpl.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            setLayoutParams(layoutParams);
                        }
                    });
                    AdViewImpl.this.f10493A.setBackgroundDrawable(getResources().getDrawable(C2750R.C2752drawable.button_close_background));
                    AdViewImpl.this.f10493A.setTextColor(ContextCompat.getColorStateList(getContext(), C2750R.C2751color.button_text_selector));
                    AdViewImpl.this.f10493A.setTextSize(2, 16.0f);
                    AdViewImpl.this.f10493A.setText(C2750R.C2755string.skip_ad);
                }
            }
        };
        int i5 = this.f10523l;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i5, 17);
        int i6 = this.f10523l;
        int i7 = (i2 / 2) - (i6 / 2);
        int i8 = (i / 2) - (i6 / 2);
        int i9 = C295314.f10547a[enumC3013a.ordinal()];
        if (i9 == 1) {
            layoutParams.topMargin = i7;
        } else if (i9 == 2) {
            layoutParams.rightMargin = i8;
            layoutParams.topMargin = i7;
        } else if (i9 == 3) {
            layoutParams.leftMargin = i8;
            layoutParams.topMargin = i7;
        } else if (i9 == 5) {
            layoutParams.bottomMargin = i7;
        } else if (i9 == 6) {
            layoutParams.rightMargin = i8;
            layoutParams.bottomMargin = i7;
        } else if (i9 == 7) {
            layoutParams.leftMargin = i8;
            layoutParams.bottomMargin = i7;
        }
        this.f10493A.setLayoutParams(layoutParams);
        this.f10493A.setBackgroundColor(0);
        this.f10493A.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.AdViewImpl.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                mRAIDImplementation.m49123a();
            }
        });
        if (mRAIDImplementation.f10727b.getParent() != null) {
            ((ViewGroup) mRAIDImplementation.f10727b.getParent()).addView(this.f10493A);
        }
    }
}
