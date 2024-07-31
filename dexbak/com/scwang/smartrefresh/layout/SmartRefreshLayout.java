package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import com.autonavi.base.p048ae.gmap.glyph.FontStyle;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.scwang.smartrefresh.layout.constant.DimensionStatus;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.impl.RefreshContentWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper;
import com.scwang.smartrefresh.layout.util.C11925c;
import com.scwang.smartrefresh.layout.util.DelayedRunable;
import com.scwang.smartrefresh.layout.util.ViscousFluidInterpolator;
import java.util.ArrayList;
import java.util.List;
import p638r0.DefaultRefreshFooterCreater;
import p638r0.DefaultRefreshHeaderCreater;
import p638r0.RefreshContent;
import p638r0.RefreshFooter;
import p638r0.RefreshHeader;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;
import p638r0.ScrollBoundaryDecider;
import p642s0.OnLoadmoreListener;
import p642s0.OnMultiPurposeListener;
import p642s0.OnRefreshListener;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SmartRefreshLayout extends ViewGroup implements RefreshLayout, NestedScrollingParent, NestedScrollingChild {

    /* renamed from: h1 */
    protected static boolean f33468h1;

    /* renamed from: i1 */
    protected static DefaultRefreshFooterCreater f33469i1 = new C11896f();

    /* renamed from: j1 */
    protected static DefaultRefreshHeaderCreater f33470j1 = new C11897g();

    /* renamed from: A */
    protected boolean f33471A;

    /* renamed from: A0 */
    protected boolean f33472A0;

    /* renamed from: B */
    protected boolean f33473B;

    /* renamed from: B0 */
    protected NestedScrollingChildHelper f33474B0;

    /* renamed from: C */
    protected boolean f33475C;

    /* renamed from: C0 */
    protected NestedScrollingParentHelper f33476C0;

    /* renamed from: D */
    protected boolean f33477D;

    /* renamed from: D0 */
    protected int f33478D0;

    /* renamed from: E */
    protected boolean f33479E;

    /* renamed from: E0 */
    protected DimensionStatus f33480E0;

    /* renamed from: F */
    protected boolean f33481F;

    /* renamed from: F0 */
    protected int f33482F0;

    /* renamed from: G */
    protected boolean f33483G;

    /* renamed from: G0 */
    protected DimensionStatus f33484G0;

    /* renamed from: H */
    protected boolean f33485H;

    /* renamed from: H0 */
    protected int f33486H0;

    /* renamed from: I */
    protected boolean f33487I;

    /* renamed from: I0 */
    protected int f33488I0;

    /* renamed from: J */
    protected boolean f33489J;

    /* renamed from: J0 */
    protected float f33490J0;

    /* renamed from: K */
    protected boolean f33491K;

    /* renamed from: K0 */
    protected float f33492K0;

    /* renamed from: L */
    protected boolean f33493L;

    /* renamed from: L0 */
    protected float f33494L0;

    /* renamed from: M */
    protected boolean f33495M;

    /* renamed from: M0 */
    protected float f33496M0;

    /* renamed from: N */
    protected boolean f33497N;

    /* renamed from: N0 */
    protected RefreshHeader f33498N0;

    /* renamed from: O */
    protected boolean f33499O;

    /* renamed from: O0 */
    protected RefreshFooter f33500O0;

    /* renamed from: P */
    protected boolean f33501P;

    /* renamed from: P0 */
    protected RefreshContent f33502P0;

    /* renamed from: Q */
    protected boolean f33503Q;

    /* renamed from: Q0 */
    protected Paint f33504Q0;

    /* renamed from: R */
    protected OnRefreshListener f33505R;

    /* renamed from: R0 */
    protected Handler f33506R0;

    /* renamed from: S */
    protected OnLoadmoreListener f33507S;

    /* renamed from: S0 */
    protected RefreshKernel f33508S0;

    /* renamed from: T */
    protected OnMultiPurposeListener f33509T;

    /* renamed from: T0 */
    protected List<DelayedRunable> f33510T0;

    /* renamed from: U */
    protected ScrollBoundaryDecider f33511U;

    /* renamed from: U0 */
    protected RefreshState f33512U0;

    /* renamed from: V */
    protected int[] f33513V;

    /* renamed from: V0 */
    protected RefreshState f33514V0;

    /* renamed from: W */
    protected int[] f33515W;

    /* renamed from: W0 */
    protected boolean f33516W0;

    /* renamed from: X0 */
    protected long f33517X0;

    /* renamed from: Y0 */
    protected long f33518Y0;

    /* renamed from: Z0 */
    protected int f33519Z0;

    /* renamed from: a */
    protected int f33520a;

    /* renamed from: a1 */
    protected int f33521a1;

    /* renamed from: b */
    protected int f33522b;

    /* renamed from: b1 */
    protected boolean f33523b1;

    /* renamed from: c */
    protected int f33524c;

    /* renamed from: c1 */
    protected boolean f33525c1;

    /* renamed from: d */
    protected int f33526d;

    /* renamed from: d1 */
    MotionEvent f33527d1;

    /* renamed from: e */
    protected int f33528e;

    /* renamed from: e1 */
    protected ValueAnimator f33529e1;

    /* renamed from: f */
    protected int f33530f;

    /* renamed from: f1 */
    protected Animator.AnimatorListener f33531f1;

    /* renamed from: g */
    protected int f33532g;

    /* renamed from: g1 */
    protected ValueAnimator.AnimatorUpdateListener f33533g1;

    /* renamed from: h */
    protected float f33534h;

    /* renamed from: i */
    protected float f33535i;

    /* renamed from: j */
    protected float f33536j;

    /* renamed from: k */
    protected float f33537k;

    /* renamed from: l */
    protected float f33538l;

    /* renamed from: m */
    protected boolean f33539m;

    /* renamed from: n */
    protected boolean f33540n;

    /* renamed from: o */
    protected boolean f33541o;

    /* renamed from: p */
    protected boolean f33542p;

    /* renamed from: p0 */
    protected int f33543p0;

    /* renamed from: q */
    protected Interpolator f33544q;

    /* renamed from: r */
    protected int f33545r;

    /* renamed from: s */
    protected int f33546s;

    /* renamed from: t */
    protected int f33547t;

    /* renamed from: u */
    protected int f33548u;

    /* renamed from: v */
    protected Scroller f33549v;

    /* renamed from: w */
    protected VelocityTracker f33550w;

    /* renamed from: x */
    protected int[] f33551x;

    /* renamed from: y */
    protected boolean f33552y;

    /* renamed from: z */
    protected boolean f33553z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class RunnableC11885a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f33554a;

        RunnableC11885a(boolean z) {
            this.f33554a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f33512U0 == RefreshState.Refreshing) {
                RefreshHeader refreshHeader = smartRefreshLayout.f33498N0;
                if (refreshHeader != null && smartRefreshLayout.f33502P0 != null) {
                    int mo2095v = refreshHeader.mo2095v(smartRefreshLayout, this.f33554a);
                    if (mo2095v < Integer.MAX_VALUE) {
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        if (smartRefreshLayout2.f33539m) {
                            smartRefreshLayout2.f33526d = 0;
                            smartRefreshLayout2.f33535i = smartRefreshLayout2.f33537k;
                            smartRefreshLayout2.f33539m = false;
                            long currentTimeMillis = System.currentTimeMillis();
                            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                            smartRefreshLayout3.m19984F1(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout3.f33536j, smartRefreshLayout3.f33535i + smartRefreshLayout3.f33522b, 0));
                        }
                        SmartRefreshLayout.this.m19981I0(RefreshState.RefreshFinish);
                    }
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    OnMultiPurposeListener onMultiPurposeListener = smartRefreshLayout4.f33509T;
                    if (onMultiPurposeListener != null) {
                        onMultiPurposeListener.mo330a(smartRefreshLayout4.f33498N0, this.f33554a);
                    }
                    if (mo2095v < Integer.MAX_VALUE) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        if (smartRefreshLayout5.f33522b > 0) {
                            ValueAnimator m19948o0 = smartRefreshLayout5.m19948o0(0, mo2095v);
                            SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                            ValueAnimator.AnimatorUpdateListener mo2116g = smartRefreshLayout6.f33489J ? smartRefreshLayout6.f33502P0.mo2116g(smartRefreshLayout6.f33522b) : null;
                            if (m19948o0 == null || mo2116g == null) {
                                return;
                            }
                            m19948o0.addUpdateListener(mo2116g);
                            return;
                        }
                        smartRefreshLayout5.m19983G0(0, true);
                        SmartRefreshLayout.this.m19978L0();
                        return;
                    }
                    return;
                }
                smartRefreshLayout.m19978L0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class RunnableC11886b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f33556a;

        /* renamed from: b */
        final /* synthetic */ boolean f33557b;

        /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$b$a */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        class RunnableC11887a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f33559a;

            /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$b$a$a */
            /* loaded from: E:\fuckcool\tsn\6400276.dex */
            class C11888a extends AnimatorListenerAdapter {
                C11888a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SmartRefreshLayout.this.mo2049c(true);
                }
            }

            RunnableC11887a(int i) {
                this.f33559a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                ValueAnimator.AnimatorUpdateListener mo2116g = (!smartRefreshLayout.f33487I || (i = smartRefreshLayout.f33522b) >= 0) ? null : smartRefreshLayout.f33502P0.mo2116g(i);
                if (mo2116g != null) {
                    mo2116g.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                }
                if (mo2116g == null) {
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.f33522b < 0) {
                        ValueAnimator m19948o0 = smartRefreshLayout2.m19948o0(0, this.f33559a);
                        if (m19948o0 == null || !RunnableC11886b.this.f33557b) {
                            return;
                        }
                        m19948o0.addListener(new C11888a());
                        return;
                    }
                }
                SmartRefreshLayout.this.m19983G0(0, true);
                SmartRefreshLayout.this.m19978L0();
                RunnableC11886b runnableC11886b = RunnableC11886b.this;
                if (runnableC11886b.f33557b) {
                    SmartRefreshLayout.this.mo2049c(true);
                }
            }
        }

        RunnableC11886b(boolean z, boolean z2) {
            this.f33556a = z;
            this.f33557b = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f33512U0 == RefreshState.Loading) {
                RefreshFooter refreshFooter = smartRefreshLayout.f33500O0;
                if (refreshFooter != null && smartRefreshLayout.f33502P0 != null) {
                    int mo2095v = refreshFooter.mo2095v(smartRefreshLayout, this.f33556a);
                    if (mo2095v < Integer.MAX_VALUE) {
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        if (smartRefreshLayout2.f33539m) {
                            smartRefreshLayout2.f33526d = 0;
                            smartRefreshLayout2.f33535i = smartRefreshLayout2.f33537k;
                            smartRefreshLayout2.f33539m = false;
                            long currentTimeMillis = System.currentTimeMillis();
                            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                            smartRefreshLayout3.m19984F1(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout3.f33536j, smartRefreshLayout3.f33535i + smartRefreshLayout3.f33522b, 0));
                        }
                        SmartRefreshLayout.this.m19981I0(RefreshState.LoadFinish);
                    }
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    OnMultiPurposeListener onMultiPurposeListener = smartRefreshLayout4.f33509T;
                    if (onMultiPurposeListener != null) {
                        onMultiPurposeListener.mo319x(smartRefreshLayout4.f33500O0, this.f33556a);
                    }
                    if (mo2095v < Integer.MAX_VALUE) {
                        SmartRefreshLayout.this.postDelayed(new RunnableC11887a(mo2095v), SmartRefreshLayout.this.f33522b < 0 ? mo2095v : 0L);
                        return;
                    }
                    return;
                }
                smartRefreshLayout.m19978L0();
            } else if (this.f33557b) {
                smartRefreshLayout.mo2049c(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class RunnableC11889c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ float f33562a;

        /* renamed from: b */
        final /* synthetic */ int f33563b;

        /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$c$a */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        class C11890a implements ValueAnimator.AnimatorUpdateListener {
            C11890a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.m19983G0(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        }

        /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$c$b */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        class C11891b extends AnimatorListenerAdapter {
            C11891b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.f33529e1 = null;
                if (smartRefreshLayout.f33512U0 != RefreshState.ReleaseToRefresh) {
                    smartRefreshLayout.m19986E1();
                }
                SmartRefreshLayout.this.m19980J0();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.f33536j = smartRefreshLayout.getMeasuredWidth() / 2;
                SmartRefreshLayout.this.m19925z1();
            }
        }

        RunnableC11889c(float f, int i) {
            this.f33562a = f;
            this.f33563b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.f33529e1 = ValueAnimator.ofInt(smartRefreshLayout.f33522b, (int) (smartRefreshLayout.f33478D0 * this.f33562a));
            SmartRefreshLayout.this.f33529e1.setDuration(this.f33563b);
            SmartRefreshLayout.this.f33529e1.setInterpolator(new DecelerateInterpolator());
            SmartRefreshLayout.this.f33529e1.addUpdateListener(new C11890a());
            SmartRefreshLayout.this.f33529e1.addListener(new C11891b());
            SmartRefreshLayout.this.f33529e1.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class RunnableC11892d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ float f33567a;

        /* renamed from: b */
        final /* synthetic */ int f33568b;

        /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$d$a */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        class C11893a implements ValueAnimator.AnimatorUpdateListener {
            C11893a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.m19983G0(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        }

        /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$d$b */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        class C11894b extends AnimatorListenerAdapter {
            C11894b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.f33529e1 = null;
                if (smartRefreshLayout.f33512U0 != RefreshState.ReleaseToLoad) {
                    smartRefreshLayout.m19988D1();
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (smartRefreshLayout2.f33483G) {
                    smartRefreshLayout2.f33483G = false;
                    smartRefreshLayout2.m19980J0();
                    SmartRefreshLayout.this.f33483G = true;
                    return;
                }
                smartRefreshLayout2.m19980J0();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.f33536j = smartRefreshLayout.getMeasuredWidth() / 2;
                SmartRefreshLayout.this.m19992B1();
            }
        }

        RunnableC11892d(float f, int i) {
            this.f33567a = f;
            this.f33568b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.f33529e1 = ValueAnimator.ofInt(smartRefreshLayout.f33522b, -((int) (smartRefreshLayout.f33482F0 * this.f33567a)));
            SmartRefreshLayout.this.f33529e1.setDuration(this.f33568b);
            SmartRefreshLayout.this.f33529e1.setInterpolator(new DecelerateInterpolator());
            SmartRefreshLayout.this.f33529e1.addUpdateListener(new C11893a());
            SmartRefreshLayout.this.f33529e1.addListener(new C11894b());
            SmartRefreshLayout.this.f33529e1.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$e */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C11895e {

        /* renamed from: a */
        static final /* synthetic */ int[] f33572a;

        /* renamed from: b */
        static final /* synthetic */ int[] f33573b;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f33573b = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33573b[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33573b[RefreshState.PullToUpLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33573b[RefreshState.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33573b[RefreshState.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33573b[RefreshState.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33573b[RefreshState.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f33573b[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f33573b[RefreshState.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f33573b[RefreshState.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f33573b[RefreshState.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f33573b[RefreshState.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f33573b[RefreshState.RefreshFinish.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f33573b[RefreshState.LoadFinish.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr2 = new int[SpinnerStyle.values().length];
            f33572a = iArr2;
            try {
                iArr2[SpinnerStyle.Translate.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f33572a[SpinnerStyle.Scale.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$f */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C11896f implements DefaultRefreshFooterCreater {
        C11896f() {
        }

        @Override // p638r0.DefaultRefreshFooterCreater
        @NonNull
        /* renamed from: a */
        public RefreshFooter mo2124a(Context context, RefreshLayout refreshLayout) {
            return new BallPulseFooter(context);
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$g */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C11897g implements DefaultRefreshHeaderCreater {
        C11897g() {
        }

        @Override // p638r0.DefaultRefreshHeaderCreater
        @NonNull
        /* renamed from: a */
        public RefreshHeader mo2123a(Context context, RefreshLayout refreshLayout) {
            return new BezierRadarHeader(context);
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$h */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11898h implements OnRefreshListener {
        C11898h() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshLayout) {
            refreshLayout.mo2057W(3000);
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$i */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11899i implements OnLoadmoreListener {
        C11899i() {
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshLayout) {
            refreshLayout.mo2027n(2000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$j */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11900j extends AnimatorListenerAdapter {
        C11900j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.m19931w1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$k */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11901k extends AnimatorListenerAdapter {
        C11901k() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.f33518Y0 = System.currentTimeMillis();
            SmartRefreshLayout.this.m19981I0(RefreshState.Refreshing);
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            OnRefreshListener onRefreshListener = smartRefreshLayout.f33505R;
            if (onRefreshListener != null) {
                onRefreshListener.mo322q(smartRefreshLayout);
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            RefreshHeader refreshHeader = smartRefreshLayout2.f33498N0;
            if (refreshHeader != null) {
                refreshHeader.mo2096u(smartRefreshLayout2, smartRefreshLayout2.f33478D0, smartRefreshLayout2.f33486H0);
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            OnMultiPurposeListener onMultiPurposeListener = smartRefreshLayout3.f33509T;
            if (onMultiPurposeListener != null) {
                onMultiPurposeListener.mo322q(smartRefreshLayout3);
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                smartRefreshLayout4.f33509T.mo324l(smartRefreshLayout4.f33498N0, smartRefreshLayout4.f33478D0, smartRefreshLayout4.f33486H0);
            }
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$l */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11902l extends AnimatorListenerAdapter {
        C11902l() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.f33529e1 = null;
            if (smartRefreshLayout.f33522b == 0) {
                RefreshState refreshState = smartRefreshLayout.f33512U0;
                RefreshState refreshState2 = RefreshState.None;
                if (refreshState == refreshState2 || refreshState.opening) {
                    return;
                }
                smartRefreshLayout.m19981I0(refreshState2);
                return;
            }
            RefreshState refreshState3 = smartRefreshLayout.f33512U0;
            if (refreshState3 != smartRefreshLayout.f33514V0) {
                smartRefreshLayout.setViceState(refreshState3);
            }
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$m */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11903m implements ValueAnimator.AnimatorUpdateListener {
        C11903m() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmartRefreshLayout.this.m19983G0(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$n */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11904n extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ int f33580a;

        C11904n(int i) {
            this.f33580a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.f33529e1 = ValueAnimator.ofInt(smartRefreshLayout.f33522b, 0);
            SmartRefreshLayout.this.f33529e1.setDuration(this.f33580a);
            SmartRefreshLayout.this.f33529e1.setInterpolator(new DecelerateInterpolator());
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            smartRefreshLayout2.f33529e1.addUpdateListener(smartRefreshLayout2.f33533g1);
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            smartRefreshLayout3.f33529e1.addListener(smartRefreshLayout3.f33531f1);
            SmartRefreshLayout.this.f33529e1.start();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$p */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C11906p implements RefreshKernel {

        /* renamed from: a */
        SmartRefreshLayout f33584a;

        /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$p$a */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        class C11907a extends AnimatorListenerAdapter {
            C11907a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                C11906p.this.f33584a.m19981I0(RefreshState.TwoLevel);
            }
        }

        public C11906p(SmartRefreshLayout smartRefreshLayout) {
            this.f33584a = smartRefreshLayout;
        }

        @Override // p638r0.RefreshKernel
        /* renamed from: a */
        public RefreshKernel mo2094a() {
            SmartRefreshLayout smartRefreshLayout = this.f33584a;
            DimensionStatus dimensionStatus = smartRefreshLayout.f33480E0;
            if (dimensionStatus.notifyed) {
                smartRefreshLayout.f33480E0 = dimensionStatus.unNotify();
            }
            return this;
        }

        @Override // p638r0.RefreshKernel
        /* renamed from: b */
        public RefreshKernel mo2093b(@NonNull RefreshState refreshState) {
            switch (C11895e.f33573b[refreshState.ordinal()]) {
                case 1:
                    this.f33584a.m19978L0();
                    return null;
                case 2:
                    this.f33584a.m19925z1();
                    return null;
                case 3:
                    this.f33584a.m19992B1();
                    return null;
                case 4:
                    this.f33584a.m19927y1();
                    return null;
                case 5:
                    this.f33584a.m19994A1();
                    return null;
                case 6:
                    this.f33584a.m19986E1();
                    return null;
                case 7:
                    this.f33584a.m19988D1();
                    return null;
                case 8:
                    SmartRefreshLayout smartRefreshLayout = this.f33584a;
                    if (!smartRefreshLayout.f33512U0.opening && smartRefreshLayout.mo2055Y()) {
                        this.f33584a.m19981I0(RefreshState.ReleaseToTwoLevel);
                        return null;
                    }
                    this.f33584a.setViceState(RefreshState.ReleaseToTwoLevel);
                    return null;
                case 9:
                    SmartRefreshLayout smartRefreshLayout2 = this.f33584a;
                    if (!smartRefreshLayout2.f33512U0.opening && smartRefreshLayout2.mo2055Y()) {
                        this.f33584a.m19981I0(RefreshState.RefreshReleased);
                        return null;
                    }
                    this.f33584a.setViceState(RefreshState.RefreshReleased);
                    return null;
                case 10:
                    SmartRefreshLayout smartRefreshLayout3 = this.f33584a;
                    if (!smartRefreshLayout3.f33512U0.opening && smartRefreshLayout3.mo2059U()) {
                        this.f33584a.m19981I0(RefreshState.LoadReleased);
                        return null;
                    }
                    this.f33584a.setViceState(RefreshState.LoadReleased);
                    return null;
                case 11:
                    this.f33584a.m19990C1();
                    return null;
                case 12:
                    this.f33584a.m19929x1();
                    return null;
                case 13:
                    SmartRefreshLayout smartRefreshLayout4 = this.f33584a;
                    if (smartRefreshLayout4.f33512U0 == RefreshState.Refreshing) {
                        smartRefreshLayout4.m19981I0(RefreshState.RefreshFinish);
                        return null;
                    }
                    return null;
                case 14:
                    SmartRefreshLayout smartRefreshLayout5 = this.f33584a;
                    if (smartRefreshLayout5.f33512U0 == RefreshState.Loading) {
                        smartRefreshLayout5.m19981I0(RefreshState.LoadFinish);
                        return null;
                    }
                    return null;
                default:
                    return null;
            }
        }

        @Override // p638r0.RefreshKernel
        /* renamed from: c */
        public RefreshKernel mo2092c(int i) {
            SmartRefreshLayout smartRefreshLayout = this.f33584a;
            if (smartRefreshLayout.f33504Q0 == null && i != 0) {
                smartRefreshLayout.f33504Q0 = new Paint();
            }
            this.f33584a.f33519Z0 = i;
            return this;
        }

        @Override // p638r0.RefreshKernel
        /* renamed from: d */
        public void mo2091d() {
            SmartRefreshLayout smartRefreshLayout = this.f33584a;
            if (smartRefreshLayout.f33512U0 == RefreshState.TwoLevel) {
                smartRefreshLayout.m19981I0(RefreshState.TwoLevelFinish);
                SmartRefreshLayout smartRefreshLayout2 = this.f33584a;
                if (smartRefreshLayout2.f33522b == 0) {
                    mo2086i(0, true);
                    this.f33584a.m19981I0(RefreshState.None);
                    return;
                }
                smartRefreshLayout2.m19950n0(0).setDuration(this.f33584a.f33528e);
            }
        }

        @Override // p638r0.RefreshKernel
        /* renamed from: e */
        public RefreshKernel mo2090e(int i) {
            this.f33584a.m19950n0(i);
            return this;
        }

        @Override // p638r0.RefreshKernel
        /* renamed from: f */
        public RefreshKernel mo2089f(int i) {
            this.f33584a.f33528e = i;
            return this;
        }

        @Override // p638r0.RefreshKernel
        /* renamed from: g */
        public RefreshKernel mo2088g(boolean z) {
            this.f33584a.f33523b1 = z;
            return this;
        }

        @Override // p638r0.RefreshKernel
        /* renamed from: h */
        public void mo2087h(boolean z) {
            if (z) {
                C11907a c11907a = new C11907a();
                SmartRefreshLayout smartRefreshLayout = this.f33584a;
                ValueAnimator m19950n0 = smartRefreshLayout.m19950n0(smartRefreshLayout.getMeasuredHeight());
                if (m19950n0 != null) {
                    SmartRefreshLayout smartRefreshLayout2 = this.f33584a;
                    if (m19950n0 == smartRefreshLayout2.f33529e1) {
                        m19950n0.setDuration(smartRefreshLayout2.f33528e);
                        m19950n0.addListener(c11907a);
                        return;
                    }
                }
                c11907a.onAnimationEnd(null);
            } else if (mo2090e(0) == null) {
                this.f33584a.m19981I0(RefreshState.None);
            }
        }

        @Override // p638r0.RefreshKernel
        /* renamed from: i */
        public RefreshKernel mo2086i(int i, boolean z) {
            this.f33584a.m19983G0(i, z);
            return this;
        }

        @Override // p638r0.RefreshKernel
        /* renamed from: j */
        public RefreshKernel mo2085j(boolean z) {
            SmartRefreshLayout smartRefreshLayout = this.f33584a;
            if (!smartRefreshLayout.f33503Q) {
                smartRefreshLayout.f33503Q = true;
                smartRefreshLayout.f33471A = z;
            }
            return this;
        }

        @Override // p638r0.RefreshKernel
        @NonNull
        /* renamed from: k */
        public RefreshContent mo2084k() {
            return this.f33584a.f33502P0;
        }

        @Override // p638r0.RefreshKernel
        /* renamed from: l */
        public RefreshKernel mo2083l(int i) {
            SmartRefreshLayout smartRefreshLayout = this.f33584a;
            if (smartRefreshLayout.f33504Q0 == null && i != 0) {
                smartRefreshLayout.f33504Q0 = new Paint();
            }
            this.f33584a.f33521a1 = i;
            return this;
        }

        @Override // p638r0.RefreshKernel
        /* renamed from: m */
        public RefreshKernel mo2082m() {
            SmartRefreshLayout smartRefreshLayout = this.f33584a;
            DimensionStatus dimensionStatus = smartRefreshLayout.f33484G0;
            if (dimensionStatus.notifyed) {
                smartRefreshLayout.f33484G0 = dimensionStatus.unNotify();
            }
            return this;
        }

        @Override // p638r0.RefreshKernel
        @NonNull
        /* renamed from: n */
        public RefreshLayout mo2081n() {
            return this.f33584a;
        }

        @Override // p638r0.RefreshKernel
        /* renamed from: o */
        public RefreshKernel mo2080o(boolean z) {
            this.f33584a.f33525c1 = z;
            return this;
        }
    }

    public SmartRefreshLayout(Context context) {
        super(context);
        this.f33528e = 250;
        this.f33530f = 250;
        this.f33538l = 0.5f;
        this.f33552y = true;
        this.f33553z = false;
        this.f33471A = true;
        this.f33473B = true;
        this.f33475C = false;
        this.f33477D = true;
        this.f33479E = true;
        this.f33481F = true;
        this.f33483G = true;
        this.f33485H = false;
        this.f33487I = true;
        this.f33489J = true;
        this.f33491K = true;
        this.f33493L = false;
        this.f33495M = false;
        this.f33497N = false;
        this.f33499O = false;
        this.f33501P = false;
        this.f33503Q = false;
        this.f33513V = new int[2];
        this.f33515W = new int[2];
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.f33480E0 = dimensionStatus;
        this.f33484G0 = dimensionStatus;
        this.f33490J0 = 2.5f;
        this.f33492K0 = 2.5f;
        this.f33494L0 = 1.0f;
        this.f33496M0 = 1.0f;
        RefreshState refreshState = RefreshState.None;
        this.f33512U0 = refreshState;
        this.f33514V0 = refreshState;
        this.f33516W0 = false;
        this.f33517X0 = 0L;
        this.f33518Y0 = 0L;
        this.f33519Z0 = 0;
        this.f33521a1 = 0;
        this.f33527d1 = null;
        this.f33531f1 = new C11902l();
        this.f33533g1 = new C11903m();
        m19987E0(context, null);
    }

    /* renamed from: E0 */
    private void m19987E0(Context context, AttributeSet attributeSet) {
        setClipToPadding(false);
        C11925c c11925c = new C11925c();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f33549v = new Scroller(context);
        this.f33508S0 = new C11906p(this);
        this.f33550w = VelocityTracker.obtain();
        this.f33532g = context.getResources().getDisplayMetrics().heightPixels;
        this.f33544q = new ViscousFluidInterpolator();
        this.f33520a = viewConfiguration.getScaledTouchSlop();
        this.f33547t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f33548u = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f33476C0 = new NestedScrollingParentHelper(this);
        this.f33474B0 = new NestedScrollingChildHelper(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11882R.styleable.SmartRefreshLayout);
        int i = C11882R.styleable.SmartRefreshLayout_srlEnableNestedScrolling;
        ViewCompat.setNestedScrollingEnabled(this, obtainStyledAttributes.getBoolean(i, false));
        this.f33538l = obtainStyledAttributes.getFloat(C11882R.styleable.SmartRefreshLayout_srlDragRate, this.f33538l);
        this.f33490J0 = obtainStyledAttributes.getFloat(C11882R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.f33490J0);
        this.f33492K0 = obtainStyledAttributes.getFloat(C11882R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.f33492K0);
        this.f33494L0 = obtainStyledAttributes.getFloat(C11882R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.f33494L0);
        this.f33496M0 = obtainStyledAttributes.getFloat(C11882R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.f33496M0);
        this.f33552y = obtainStyledAttributes.getBoolean(C11882R.styleable.SmartRefreshLayout_srlEnableRefresh, this.f33552y);
        this.f33530f = obtainStyledAttributes.getInt(C11882R.styleable.SmartRefreshLayout_srlReboundDuration, this.f33530f);
        int i2 = C11882R.styleable.SmartRefreshLayout_srlEnableLoadmore;
        this.f33553z = obtainStyledAttributes.getBoolean(i2, this.f33553z);
        int i3 = C11882R.styleable.SmartRefreshLayout_srlHeaderHeight;
        this.f33478D0 = obtainStyledAttributes.getDimensionPixelOffset(i3, c11925c.m19767a(100.0f));
        int i4 = C11882R.styleable.SmartRefreshLayout_srlFooterHeight;
        this.f33482F0 = obtainStyledAttributes.getDimensionPixelOffset(i4, c11925c.m19767a(60.0f));
        this.f33493L = obtainStyledAttributes.getBoolean(C11882R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.f33493L);
        this.f33495M = obtainStyledAttributes.getBoolean(C11882R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.f33495M);
        int i5 = C11882R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent;
        this.f33471A = obtainStyledAttributes.getBoolean(i5, this.f33471A);
        this.f33473B = obtainStyledAttributes.getBoolean(C11882R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, this.f33473B);
        this.f33477D = obtainStyledAttributes.getBoolean(C11882R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.f33477D);
        this.f33483G = obtainStyledAttributes.getBoolean(C11882R.styleable.SmartRefreshLayout_srlEnableAutoLoadmore, this.f33483G);
        this.f33479E = obtainStyledAttributes.getBoolean(C11882R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.f33479E);
        this.f33485H = obtainStyledAttributes.getBoolean(C11882R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.f33485H);
        this.f33487I = obtainStyledAttributes.getBoolean(C11882R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.f33487I);
        this.f33489J = obtainStyledAttributes.getBoolean(C11882R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.f33489J);
        this.f33491K = obtainStyledAttributes.getBoolean(C11882R.styleable.SmartRefreshLayout_srlEnableLoadmoreWhenContentNotFull, this.f33491K);
        this.f33475C = obtainStyledAttributes.getBoolean(C11882R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.f33475C);
        this.f33481F = obtainStyledAttributes.getBoolean(C11882R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.f33481F);
        this.f33545r = obtainStyledAttributes.getResourceId(C11882R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, -1);
        this.f33546s = obtainStyledAttributes.getResourceId(C11882R.styleable.SmartRefreshLayout_srlFixedFooterViewId, -1);
        this.f33499O = obtainStyledAttributes.hasValue(i2);
        this.f33501P = obtainStyledAttributes.hasValue(i);
        this.f33503Q = obtainStyledAttributes.hasValue(i5);
        this.f33480E0 = obtainStyledAttributes.hasValue(i3) ? DimensionStatus.XmlLayoutUnNotify : this.f33480E0;
        this.f33484G0 = obtainStyledAttributes.hasValue(i4) ? DimensionStatus.XmlLayoutUnNotify : this.f33484G0;
        this.f33486H0 = (int) Math.max(this.f33478D0 * (this.f33490J0 - 1.0f), 0.0f);
        this.f33488I0 = (int) Math.max(this.f33482F0 * (this.f33492K0 - 1.0f), 0.0f);
        int color = obtainStyledAttributes.getColor(C11882R.styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(C11882R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.f33551x = new int[]{color2, color};
            } else {
                this.f33551x = new int[]{color2};
            }
        } else if (color != 0) {
            this.f33551x = new int[]{0, color};
        }
        obtainStyledAttributes.recycle();
    }

    public static void setDefaultRefreshFooterCreater(@NonNull DefaultRefreshFooterCreater defaultRefreshFooterCreater) {
        f33469i1 = defaultRefreshFooterCreater;
        f33468h1 = true;
    }

    public static void setDefaultRefreshHeaderCreater(@NonNull DefaultRefreshHeaderCreater defaultRefreshHeaderCreater) {
        f33470j1 = defaultRefreshHeaderCreater;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: A0 */
    public SmartRefreshLayout mo2063Q(boolean z) {
        return mo2030l0(z ? Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.f33518Y0))) : 0, z);
    }

    /* renamed from: A1 */
    protected void m19994A1() {
        if (mo2059U() && !this.f33497N && !this.f33512U0.opening) {
            m19981I0(RefreshState.PullUpCanceled);
            m19978L0();
            return;
        }
        setViceState(RefreshState.PullUpCanceled);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: B0 */
    public C11905o generateDefaultLayoutParams() {
        return new C11905o(-1, -1);
    }

    /* renamed from: B1 */
    protected void m19992B1() {
        if (mo2059U() && !this.f33497N && !this.f33512U0.opening) {
            m19981I0(RefreshState.PullToUpLoad);
        } else {
            setViceState(RefreshState.PullToUpLoad);
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: C0 */
    public C11905o generateLayoutParams(AttributeSet attributeSet) {
        return new C11905o(getContext(), attributeSet);
    }

    /* renamed from: C1 */
    protected void m19990C1() {
        C11901k c11901k = new C11901k();
        m19981I0(RefreshState.RefreshReleased);
        ValueAnimator m19950n0 = m19950n0(this.f33478D0);
        if (m19950n0 != null) {
            m19950n0.addListener(c11901k);
        }
        RefreshHeader refreshHeader = this.f33498N0;
        if (refreshHeader != null) {
            refreshHeader.mo2101j(this, this.f33478D0, this.f33486H0);
        }
        OnMultiPurposeListener onMultiPurposeListener = this.f33509T;
        if (onMultiPurposeListener != null) {
            onMultiPurposeListener.mo327g(this.f33498N0, this.f33478D0, this.f33486H0);
        }
        if (m19950n0 == null) {
            c11901k.onAnimationEnd(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: D0 */
    public C11905o generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C11905o(layoutParams);
    }

    /* renamed from: D1 */
    protected void m19988D1() {
        if (mo2059U() && !this.f33497N && !this.f33512U0.opening) {
            m19981I0(RefreshState.ReleaseToLoad);
        } else {
            setViceState(RefreshState.ReleaseToLoad);
        }
    }

    /* renamed from: E1 */
    protected void m19986E1() {
        if (!this.f33512U0.opening && mo2055Y()) {
            m19981I0(RefreshState.ReleaseToRefresh);
        } else {
            setViceState(RefreshState.ReleaseToRefresh);
        }
    }

    /* renamed from: F0 */
    protected boolean m19985F0(int i) {
        RefreshState refreshState;
        if (this.f33529e1 == null || i != 0 || (refreshState = this.f33512U0) == RefreshState.LoadFinish || refreshState == RefreshState.RefreshFinish) {
            return false;
        }
        if (refreshState == RefreshState.PullDownCanceled) {
            m19925z1();
        } else if (refreshState == RefreshState.PullUpCanceled) {
            m19992B1();
        }
        this.f33529e1.cancel();
        this.f33529e1 = null;
        return true;
    }

    /* renamed from: F1 */
    protected boolean m19984F1(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1) {
            float f = -this.f33550w.getYVelocity();
            if (Math.abs(f) > this.f33547t && this.f33522b == 0 && this.f33526d == 0) {
                this.f33516W0 = false;
                this.f33549v.fling(0, getScrollY(), 0, (int) f, 0, 0, -2147483647, Integer.MAX_VALUE);
                this.f33549v.computeScrollOffset();
                invalidate();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: G0 */
    protected void m19983G0(int i, boolean z) {
        OnMultiPurposeListener onMultiPurposeListener;
        OnMultiPurposeListener onMultiPurposeListener2;
        RefreshFooter refreshFooter;
        RefreshHeader refreshHeader;
        RefreshHeader refreshHeader2;
        RefreshFooter refreshFooter2;
        if (this.f33522b != i || (((refreshHeader2 = this.f33498N0) != null && refreshHeader2.mo2097p()) || ((refreshFooter2 = this.f33500O0) != null && refreshFooter2.mo2097p()))) {
            int i2 = this.f33522b;
            this.f33522b = i;
            if (!z && getViceState().draging) {
                int i3 = this.f33522b;
                if (i3 > this.f33478D0 * this.f33494L0) {
                    if (this.f33512U0 != RefreshState.ReleaseToTwoLevel) {
                        m19986E1();
                    }
                } else if ((-i3) > this.f33482F0 * this.f33496M0 && !this.f33497N) {
                    m19988D1();
                } else if (i3 < 0 && !this.f33497N) {
                    m19992B1();
                } else if (i3 > 0) {
                    m19925z1();
                }
            }
            if (this.f33502P0 != null) {
                Integer num = null;
                if (i >= 0) {
                    if (this.f33471A || (refreshHeader = this.f33498N0) == null || refreshHeader.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                        num = Integer.valueOf(i);
                    } else if (i2 < 0) {
                        num = 0;
                    }
                }
                if (i <= 0) {
                    if (this.f33473B || (refreshFooter = this.f33500O0) == null || refreshFooter.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                        num = Integer.valueOf(i);
                    } else if (i2 > 0) {
                        num = 0;
                    }
                }
                if (num != null) {
                    this.f33502P0.mo2118e(num.intValue());
                    if ((this.f33519Z0 != 0 && (num.intValue() >= 0 || i2 > 0)) || (this.f33521a1 != 0 && (num.intValue() <= 0 || i2 < 0))) {
                        invalidate();
                    }
                }
            }
            if ((i >= 0 || i2 > 0) && this.f33498N0 != null) {
                int max = Math.max(i, 0);
                int i4 = this.f33478D0;
                int i5 = this.f33486H0;
                float f = (max * 1.0f) / i4;
                if (mo2055Y() || (this.f33512U0 == RefreshState.RefreshFinish && z)) {
                    if (i2 != this.f33522b) {
                        int i6 = C11895e.f33572a[this.f33498N0.getSpinnerStyle().ordinal()];
                        if (i6 == 1) {
                            this.f33498N0.getView().setTranslationY(this.f33522b);
                        } else if (i6 == 2) {
                            this.f33498N0.getView().requestLayout();
                        }
                        if (z) {
                            this.f33498N0.mo2102i(f, max, i4, i5);
                        }
                    }
                    if (!z) {
                        if (this.f33498N0.mo2097p()) {
                            int width = getWidth();
                            this.f33498N0.mo2099n(this.f33536j / width, (int) this.f33536j, width);
                            this.f33498N0.mo2100w(f, max, i4, i5);
                        } else if (i2 != this.f33522b) {
                            this.f33498N0.mo2100w(f, max, i4, i5);
                        }
                    }
                }
                if (i2 != this.f33522b && (onMultiPurposeListener = this.f33509T) != null) {
                    if (z) {
                        onMultiPurposeListener.mo321r(this.f33498N0, f, max, i4, i5);
                    } else {
                        onMultiPurposeListener.mo325k(this.f33498N0, f, max, i4, i5);
                    }
                }
            }
            if ((i <= 0 || i2 < 0) && this.f33500O0 != null) {
                int i7 = -Math.min(i, 0);
                int i8 = this.f33482F0;
                int i9 = this.f33488I0;
                float f2 = (i7 * 1.0f) / i8;
                if (mo2059U() || (this.f33512U0 == RefreshState.LoadFinish && z)) {
                    if (i2 != this.f33522b) {
                        int i10 = C11895e.f33572a[this.f33500O0.getSpinnerStyle().ordinal()];
                        if (i10 == 1) {
                            this.f33500O0.getView().setTranslationY(this.f33522b);
                        } else if (i10 == 2) {
                            this.f33500O0.getView().requestLayout();
                        }
                        if (z) {
                            this.f33500O0.mo2103t(f2, i7, i8, i9);
                        }
                    }
                    if (!z) {
                        if (this.f33500O0.mo2097p()) {
                            int width2 = getWidth();
                            this.f33500O0.mo2099n(this.f33536j / width2, (int) this.f33536j, width2);
                            this.f33500O0.mo2105d(f2, i7, i8, i9);
                        } else if (i2 != this.f33522b) {
                            this.f33500O0.mo2105d(f2, i7, i8, i9);
                        }
                    }
                }
                if (i2 == this.f33522b || (onMultiPurposeListener2 = this.f33509T) == null) {
                    return;
                }
                if (z) {
                    onMultiPurposeListener2.mo323m(this.f33500O0, f2, i7, i8, i9);
                } else {
                    onMultiPurposeListener2.mo326h(this.f33500O0, f2, i7, i8, i9);
                }
            }
        }
    }

    /* renamed from: H0 */
    protected void m19982H0(float f) {
        RefreshState refreshState;
        RefreshState refreshState2 = this.f33512U0;
        if (refreshState2 == RefreshState.TwoLevel && f > 0.0f) {
            m19983G0(Math.min((int) f, getMeasuredHeight()), false);
        } else if (refreshState2 == RefreshState.Refreshing && f >= 0.0f) {
            if (f < this.f33478D0) {
                m19983G0((int) f, false);
            } else {
                double d = this.f33486H0;
                int max = Math.max((this.f33532g * 4) / 3, getHeight());
                int i = this.f33478D0;
                double d2 = max - i;
                double max2 = Math.max(0.0f, (f - i) * this.f33538l);
                Double.isNaN(max2);
                Double.isNaN(d2);
                Double.isNaN(d);
                m19983G0(((int) Math.min(d * (1.0d - Math.pow(100.0d, (-max2) / d2)), max2)) + this.f33478D0, false);
            }
        } else if (f >= 0.0f || !(refreshState2 == RefreshState.Loading || ((this.f33475C && this.f33497N) || (this.f33483G && mo2059U() && !this.f33497N)))) {
            if (f >= 0.0f) {
                double d3 = this.f33486H0 + this.f33478D0;
                double max3 = Math.max(this.f33532g / 2, getHeight());
                double max4 = Math.max(0.0f, this.f33538l * f);
                Double.isNaN(max4);
                Double.isNaN(max3);
                Double.isNaN(d3);
                m19983G0((int) Math.min(d3 * (1.0d - Math.pow(100.0d, (-max4) / max3)), max4), false);
            } else {
                double d4 = this.f33488I0 + this.f33482F0;
                double max5 = Math.max(this.f33532g / 2, getHeight());
                double d5 = -Math.min(0.0f, this.f33538l * f);
                Double.isNaN(d5);
                Double.isNaN(max5);
                Double.isNaN(d4);
                m19983G0((int) (-Math.min(d4 * (1.0d - Math.pow(100.0d, (-d5) / max5)), d5)), false);
            }
        } else if (f > (-this.f33482F0)) {
            m19983G0((int) f, false);
        } else {
            double d6 = this.f33488I0;
            int max6 = Math.max((this.f33532g * 4) / 3, getHeight());
            int i2 = this.f33482F0;
            double d7 = max6 - i2;
            double d8 = -Math.min(0.0f, (i2 + f) * this.f33538l);
            Double.isNaN(d8);
            Double.isNaN(d7);
            Double.isNaN(d6);
            m19983G0(((int) (-Math.min(d6 * (1.0d - Math.pow(100.0d, (-d8) / d7)), d8))) - this.f33482F0, false);
        }
        if (!this.f33483G || !mo2059U() || f >= 0.0f || (refreshState = this.f33512U0) == RefreshState.Refreshing || refreshState == RefreshState.Loading || refreshState == RefreshState.LoadFinish || this.f33497N) {
            return;
        }
        m19931w1();
    }

    /* renamed from: I0 */
    protected void m19981I0(RefreshState refreshState) {
        RefreshState refreshState2 = this.f33512U0;
        if (refreshState2 != refreshState) {
            this.f33512U0 = refreshState;
            this.f33514V0 = refreshState;
            RefreshFooter refreshFooter = this.f33500O0;
            if (refreshFooter != null) {
                refreshFooter.mo329b(this, refreshState2, refreshState);
            }
            RefreshHeader refreshHeader = this.f33498N0;
            if (refreshHeader != null) {
                refreshHeader.mo329b(this, refreshState2, refreshState);
            }
            OnMultiPurposeListener onMultiPurposeListener = this.f33509T;
            if (onMultiPurposeListener != null) {
                onMultiPurposeListener.mo329b(this, refreshState2, refreshState);
            }
        }
    }

    /* renamed from: J0 */
    protected boolean m19980J0() {
        RefreshState refreshState = this.f33512U0;
        if (refreshState == RefreshState.TwoLevel) {
            if (this.f33550w.getYVelocity() > -1000.0f && this.f33522b > getMeasuredHeight() / 2) {
                ValueAnimator m19950n0 = m19950n0(getMeasuredHeight());
                if (m19950n0 != null) {
                    m19950n0.setDuration(this.f33528e);
                }
            } else if (this.f33539m) {
                this.f33508S0.mo2091d();
            }
            return this.f33539m;
        } else if (refreshState != RefreshState.Loading && ((!this.f33483G || !mo2059U() || this.f33497N || this.f33522b >= 0 || this.f33512U0 == RefreshState.Refreshing) && (!this.f33475C || !this.f33497N || this.f33522b >= 0))) {
            RefreshState refreshState2 = this.f33512U0;
            if (refreshState2 == RefreshState.Refreshing) {
                int i = this.f33522b;
                int i2 = this.f33478D0;
                if (i > i2) {
                    this.f33543p0 = i2;
                    m19950n0(i2);
                    return true;
                } else if (i < 0) {
                    this.f33543p0 = 0;
                    m19950n0(0);
                    return true;
                } else {
                    return false;
                }
            } else if (refreshState2 == RefreshState.PullDownToRefresh) {
                m19927y1();
                return true;
            } else if (refreshState2 == RefreshState.PullToUpLoad) {
                m19994A1();
                return true;
            } else if (refreshState2 == RefreshState.ReleaseToRefresh) {
                m19990C1();
                return true;
            } else if (refreshState2 == RefreshState.ReleaseToLoad) {
                m19929x1();
                return true;
            } else if (refreshState2 == RefreshState.ReleaseToTwoLevel) {
                m19981I0(RefreshState.TwoLevelReleased);
                return true;
            } else if (this.f33522b != 0) {
                m19950n0(0);
                return true;
            } else {
                return false;
            }
        } else {
            int i3 = this.f33522b;
            int i4 = this.f33482F0;
            if (i3 < (-i4)) {
                this.f33543p0 = -i4;
                m19950n0(-i4);
                return true;
            } else if (i3 > 0) {
                this.f33543p0 = 0;
                m19950n0(0);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: K0 */
    public SmartRefreshLayout mo2018w() {
        mo2049c(false);
        return this;
    }

    /* renamed from: L0 */
    protected void m19978L0() {
        RefreshState refreshState = this.f33512U0;
        RefreshState refreshState2 = RefreshState.None;
        if (refreshState != refreshState2 && this.f33522b == 0) {
            m19981I0(refreshState2);
        }
        if (this.f33522b != 0) {
            m19950n0(0);
        }
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: M */
    public RefreshLayout mo2067M(boolean z) {
        setNestedScrollingEnabled(z);
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: M0 */
    public SmartRefreshLayout mo2036i0(boolean z) {
        this.f33495M = z;
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: N */
    public boolean mo2066N(int i) {
        int i2 = this.f33530f;
        int i3 = this.f33478D0;
        return mo2039h(i, i2, (((this.f33486H0 / 2) + i3) * 1.0f) / i3);
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: N0 */
    public SmartRefreshLayout mo2047d(boolean z) {
        this.f33493L = z;
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: O0 */
    public SmartRefreshLayout mo2032k0(float f) {
        this.f33538l = f;
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: P0 */
    public SmartRefreshLayout mo2022s(boolean z) {
        this.f33483G = z;
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: Q0 */
    public SmartRefreshLayout mo2068L(boolean z) {
        this.f33475C = z;
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: R0 */
    public SmartRefreshLayout mo2029m(boolean z) {
        this.f33473B = z;
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: S */
    public boolean mo2061S() {
        return this.f33512U0 == RefreshState.Refreshing;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: S0 */
    public SmartRefreshLayout mo2072H(boolean z) {
        this.f33471A = z;
        this.f33503Q = true;
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: T0 */
    public SmartRefreshLayout mo2064P(boolean z) {
        this.f33499O = true;
        this.f33553z = z;
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: U */
    public boolean mo2059U() {
        return this.f33553z && !this.f33485H;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: U0 */
    public SmartRefreshLayout mo2051b(boolean z) {
        this.f33491K = z;
        RefreshContent refreshContent = this.f33502P0;
        if (refreshContent != null) {
            refreshContent.mo2121b(z);
        }
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: V0 */
    public SmartRefreshLayout mo2065O(boolean z) {
        this.f33479E = z;
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: W0 */
    public SmartRefreshLayout mo2021t(boolean z) {
        this.f33481F = z;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    @Override // p638r0.RefreshLayout
    /* renamed from: X */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p638r0.RefreshLayout mo2056X(android.view.View r3, int r4, int r5) {
        /*
            r2 = this;
            if (r3 == 0) goto L8e
            r0.c r0 = r2.f33502P0
            if (r0 == 0) goto Ld
            android.view.View r0 = r0.getView()
            r2.removeView(r0)
        Ld:
            r0 = 0
            com.scwang.smartrefresh.layout.SmartRefreshLayout$o r1 = new com.scwang.smartrefresh.layout.SmartRefreshLayout$o
            r1.<init>(r4, r5)
            r2.addView(r3, r0, r1)
            r0.e r4 = r2.f33498N0
            if (r4 == 0) goto L39
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r4 = r4.getSpinnerStyle()
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r5 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.FixedBehind
            if (r4 != r5) goto L39
            r2.bringChildToFront(r3)
            r0.d r4 = r2.f33500O0
            if (r4 == 0) goto L5b
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r4 = r4.getSpinnerStyle()
            if (r4 == r5) goto L5b
            r0.d r4 = r2.f33500O0
            android.view.View r4 = r4.getView()
            r2.bringChildToFront(r4)
            goto L5b
        L39:
            r0.d r4 = r2.f33500O0
            if (r4 == 0) goto L5b
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r4 = r4.getSpinnerStyle()
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r5 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.FixedBehind
            if (r4 != r5) goto L5b
            r2.bringChildToFront(r3)
            r0.e r4 = r2.f33498N0
            if (r4 == 0) goto L5b
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r4 = r4.getSpinnerStyle()
            if (r4 != r5) goto L5b
            r0.e r4 = r2.f33498N0
            android.view.View r4 = r4.getView()
            r2.bringChildToFront(r4)
        L5b:
            com.scwang.smartrefresh.layout.impl.a r4 = new com.scwang.smartrefresh.layout.impl.a
            r4.<init>(r3)
            r2.f33502P0 = r4
            android.os.Handler r3 = r2.f33506R0
            if (r3 == 0) goto L8e
            int r3 = r2.f33545r
            r4 = 0
            if (r3 <= 0) goto L70
            android.view.View r3 = r2.findViewById(r3)
            goto L71
        L70:
            r3 = r4
        L71:
            int r5 = r2.f33546s
            if (r5 <= 0) goto L79
            android.view.View r4 = r2.findViewById(r5)
        L79:
            r0.c r5 = r2.f33502P0
            r0.i r0 = r2.f33511U
            r5.mo2122a(r0)
            r0.c r5 = r2.f33502P0
            boolean r0 = r2.f33491K
            r5.mo2121b(r0)
            r0.c r5 = r2.f33502P0
            r0.g r0 = r2.f33508S0
            r5.mo2114i(r0, r3, r4)
        L8e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.mo2056X(android.view.View, int, int):r0.h");
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: X0 */
    public SmartRefreshLayout mo2076D(boolean z) {
        this.f33485H = z;
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: Y */
    public boolean mo2055Y() {
        return this.f33552y && !this.f33485H;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: Y0 */
    public SmartRefreshLayout mo2050b0(boolean z) {
        this.f33552y = z;
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: Z0 */
    public SmartRefreshLayout mo2071I(boolean z) {
        this.f33487I = z;
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: a */
    public RefreshLayout mo2053a(ScrollBoundaryDecider scrollBoundaryDecider) {
        this.f33511U = scrollBoundaryDecider;
        RefreshContent refreshContent = this.f33502P0;
        if (refreshContent != null) {
            refreshContent.mo2122a(scrollBoundaryDecider);
        }
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: a0 */
    public boolean mo2052a0() {
        return mo2066N(this.f33506R0 == null ? FontStyle.WEIGHT_NORMAL : 0);
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: a1 */
    public SmartRefreshLayout mo2069K(boolean z) {
        this.f33489J = z;
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: b1 */
    public SmartRefreshLayout mo2025p(float f) {
        return mo2020u(C11925c.m19766b(f));
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: c1 */
    public SmartRefreshLayout mo2020u(int i) {
        if (this.f33484G0.canReplaceWith(DimensionStatus.CodeExact)) {
            this.f33482F0 = i;
            this.f33488I0 = (int) Math.max(i * (this.f33492K0 - 1.0f), 0.0f);
            this.f33484G0 = DimensionStatus.CodeExactUnNotify;
            RefreshFooter refreshFooter = this.f33500O0;
            if (refreshFooter != null) {
                refreshFooter.getView().requestLayout();
            }
        }
        return this;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C11905o;
    }

    @Override // android.view.View
    public void computeScroll() {
        int currY = this.f33549v.getCurrY();
        if (this.f33549v.computeScrollOffset()) {
            int finalY = this.f33549v.getFinalY();
            if ((finalY > 0 && this.f33502P0.mo2107p()) || (finalY < 0 && this.f33502P0.mo2110m())) {
                if (this.f33516W0) {
                    int currVelocity = (int) this.f33549v.getCurrVelocity();
                    AnimationUtils.currentAnimationTimeMillis();
                    int abs = (Math.abs(this.f33549v.getCurrY() - currY) * 1000) / currVelocity;
                    if (finalY > 0) {
                        if (mo2059U() || this.f33481F) {
                            if (this.f33483G && mo2059U() && !this.f33497N) {
                                double d = this.f33482F0;
                                double d2 = currVelocity;
                                Double.isNaN(d2);
                                double d3 = this.f33548u;
                                Double.isNaN(d3);
                                double pow = Math.pow((d2 * 1.0d) / d3, 0.5d);
                                Double.isNaN(d);
                                m19944q0(-((int) (d * pow)));
                                RefreshState refreshState = this.f33512U0;
                                if (!refreshState.opening && refreshState != RefreshState.Loading && refreshState != RefreshState.LoadFinish) {
                                    m19931w1();
                                }
                            } else if (this.f33479E) {
                                double d4 = this.f33482F0;
                                double d5 = currVelocity;
                                Double.isNaN(d5);
                                double d6 = this.f33548u;
                                Double.isNaN(d6);
                                double pow2 = Math.pow((d5 * 1.0d) / d6, 0.5d);
                                Double.isNaN(d4);
                                m19944q0(-((int) (d4 * pow2)));
                            }
                        }
                    } else if ((mo2055Y() || this.f33481F) && this.f33479E) {
                        double d7 = this.f33478D0;
                        double d8 = currVelocity;
                        Double.isNaN(d8);
                        double d9 = this.f33548u;
                        Double.isNaN(d9);
                        double pow3 = Math.pow((d8 * 1.0d) / d9, 0.5d);
                        Double.isNaN(d7);
                        m19944q0((int) (d7 * pow3));
                    }
                    this.f33516W0 = false;
                }
                this.f33549v.forceFinished(true);
                return;
            }
            this.f33516W0 = true;
            invalidate();
        }
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: d1 */
    public SmartRefreshLayout mo2062R(float f) {
        this.f33492K0 = f;
        int max = (int) Math.max(this.f33482F0 * (f - 1.0f), 0.0f);
        this.f33488I0 = max;
        RefreshFooter refreshFooter = this.f33500O0;
        if (refreshFooter != null && this.f33506R0 != null) {
            refreshFooter.mo2098o(this.f33508S0, this.f33482F0, max);
        } else {
            this.f33484G0 = this.f33484G0.unNotify();
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        boolean z = this.f33477D && isInEditMode();
        if (mo2055Y() && (i = this.f33519Z0) != 0 && (this.f33522b > 0 || z)) {
            this.f33504Q0.setColor(i);
            canvas.drawRect(0.0f, 0.0f, getWidth(), z ? this.f33478D0 : this.f33522b, this.f33504Q0);
        } else if (mo2059U() && this.f33521a1 != 0 && (this.f33522b < 0 || z)) {
            int height = getHeight();
            this.f33504Q0.setColor(this.f33521a1);
            canvas.drawRect(0.0f, height - (z ? this.f33482F0 : -this.f33522b), getWidth(), height, this.f33504Q0);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f33474B0.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f33474B0.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f33474B0.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f33474B0.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
        if (r6 != 3) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x012b, code lost:
        if (r6 != 3) goto L93;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r22) {
        /*
            Method dump skipped, instructions count: 851
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: e */
    public RefreshLayout mo2045e(View view) {
        return mo2056X(view, -1, -1);
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: e1 */
    public SmartRefreshLayout mo2031l(float f) {
        this.f33496M0 = f;
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: f */
    public boolean mo2043f() {
        return this.f33485H;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: f0 */
    public boolean mo2042f0(int i) {
        int i2 = this.f33530f;
        int i3 = this.f33482F0;
        return mo2017x(i, i2, (((this.f33488I0 / 2) + i3) * 1.0f) / i3);
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: f1 */
    public SmartRefreshLayout mo2070J(float f) {
        return mo2075E(C11925c.m19766b(f));
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: g1 */
    public SmartRefreshLayout mo2075E(int i) {
        if (this.f33480E0.canReplaceWith(DimensionStatus.CodeExact)) {
            this.f33478D0 = i;
            this.f33486H0 = (int) Math.max(i * (this.f33490J0 - 1.0f), 0.0f);
            this.f33480E0 = DimensionStatus.CodeExactUnNotify;
            RefreshHeader refreshHeader = this.f33498N0;
            if (refreshHeader != null) {
                refreshHeader.getView().requestLayout();
            }
        }
        return this;
    }

    @Override // p638r0.RefreshLayout
    public SmartRefreshLayout getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f33476C0.getNestedScrollAxes();
    }

    @Override // p638r0.RefreshLayout
    @Nullable
    public RefreshFooter getRefreshFooter() {
        return this.f33500O0;
    }

    @Override // p638r0.RefreshLayout
    @Nullable
    public RefreshHeader getRefreshHeader() {
        return this.f33498N0;
    }

    @Override // p638r0.RefreshLayout
    public RefreshState getState() {
        return this.f33512U0;
    }

    protected RefreshState getViceState() {
        return this.f33514V0;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: h */
    public boolean mo2039h(int i, int i2, float f) {
        if (this.f33512U0 == RefreshState.None && mo2055Y()) {
            ValueAnimator valueAnimator = this.f33529e1;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            RunnableC11889c runnableC11889c = new RunnableC11889c(f, i2);
            if (i > 0) {
                this.f33529e1 = new ValueAnimator();
                postDelayed(runnableC11889c, i);
                return true;
            }
            runnableC11889c.run();
            return true;
        }
        return false;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: h0 */
    public boolean mo2038h0() {
        return this.f33487I;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: h1 */
    public SmartRefreshLayout mo2054Z(float f) {
        this.f33490J0 = f;
        int max = (int) Math.max(this.f33478D0 * (f - 1.0f), 0.0f);
        this.f33486H0 = max;
        RefreshHeader refreshHeader = this.f33498N0;
        if (refreshHeader != null && this.f33506R0 != null) {
            refreshHeader.mo2098o(this.f33508S0, this.f33478D0, max);
        } else {
            this.f33480E0 = this.f33480E0.unNotify();
        }
        return this;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.f33474B0.hasNestedScrollingParent();
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: i */
    public boolean mo2037i() {
        return this.f33479E;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: i1 */
    public SmartRefreshLayout mo2077C(float f) {
        this.f33494L0 = f;
        return this;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f33474B0.isNestedScrollingEnabled();
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: j0 */
    public boolean mo2034j0() {
        return this.f33497N;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: j1 */
    public SmartRefreshLayout mo2049c(boolean z) {
        this.f33497N = z;
        RefreshFooter refreshFooter = this.f33500O0;
        if (refreshFooter != null) {
            refreshFooter.mo2106c(z);
        }
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: k1 */
    public SmartRefreshLayout mo2026o(OnLoadmoreListener onLoadmoreListener) {
        this.f33507S = onLoadmoreListener;
        this.f33553z = this.f33553z || !(this.f33499O || onLoadmoreListener == null);
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: l1 */
    public SmartRefreshLayout mo2048c0(OnMultiPurposeListener onMultiPurposeListener) {
        this.f33509T = onMultiPurposeListener;
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: m1 */
    public SmartRefreshLayout mo2035j(OnRefreshListener onRefreshListener) {
        this.f33505R = onRefreshListener;
        return this;
    }

    /* renamed from: n0 */
    protected ValueAnimator m19950n0(int i) {
        return m19948o0(i, 0);
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: n1 */
    public SmartRefreshLayout mo2019v(OnRefreshLoadmoreListener onRefreshLoadmoreListener) {
        this.f33505R = onRefreshLoadmoreListener;
        this.f33507S = onRefreshLoadmoreListener;
        this.f33553z = this.f33553z || !(this.f33499O || onRefreshLoadmoreListener == null);
        return this;
    }

    /* renamed from: o0 */
    protected ValueAnimator m19948o0(int i, int i2) {
        return m19946p0(i, i2, this.f33544q);
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: o1 */
    public SmartRefreshLayout setPrimaryColors(int... iArr) {
        RefreshHeader refreshHeader = this.f33498N0;
        if (refreshHeader != null) {
            refreshHeader.setPrimaryColors(iArr);
        }
        RefreshFooter refreshFooter = this.f33500O0;
        if (refreshFooter != null) {
            refreshFooter.setPrimaryColors(iArr);
        }
        this.f33551x = iArr;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        RefreshContent refreshContent;
        RefreshFooter refreshFooter;
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        if (this.f33506R0 == null) {
            this.f33506R0 = new Handler();
        }
        List<DelayedRunable> list = this.f33510T0;
        if (list != null) {
            for (DelayedRunable delayedRunable : list) {
                this.f33506R0.postDelayed(delayedRunable, delayedRunable.f33743a);
            }
            this.f33510T0.clear();
            this.f33510T0 = null;
        }
        if (this.f33498N0 == null) {
            RefreshHeader mo2123a = f33470j1.mo2123a(getContext(), this);
            this.f33498N0 = mo2123a;
            if (!(mo2123a.getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                if (this.f33498N0.getSpinnerStyle() == SpinnerStyle.Scale) {
                    addView(this.f33498N0.getView(), -1, -1);
                } else {
                    addView(this.f33498N0.getView(), -1, -2);
                }
            }
        }
        if (this.f33500O0 == null) {
            RefreshFooter mo2124a = f33469i1.mo2124a(getContext(), this);
            this.f33500O0 = mo2124a;
            this.f33553z = this.f33553z || (!this.f33499O && f33468h1);
            if (!(mo2124a.getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                if (this.f33500O0.getSpinnerStyle() == SpinnerStyle.Scale) {
                    addView(this.f33500O0.getView(), -1, -1);
                } else {
                    addView(this.f33500O0.getView(), -1, -2);
                }
            }
        }
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            refreshContent = this.f33502P0;
            if (refreshContent != null || i >= childCount) {
                break;
            }
            View childAt = getChildAt(i);
            RefreshHeader refreshHeader = this.f33498N0;
            if ((refreshHeader == null || childAt != refreshHeader.getView()) && ((refreshFooter = this.f33500O0) == null || childAt != refreshFooter.getView())) {
                this.f33502P0 = new RefreshContentWrapper(childAt);
            }
            i++;
        }
        if (refreshContent == null) {
            this.f33502P0 = new RefreshContentWrapper(getContext());
        }
        int i2 = this.f33545r;
        View findViewById = i2 > 0 ? findViewById(i2) : null;
        int i3 = this.f33546s;
        View findViewById2 = i3 > 0 ? findViewById(i3) : null;
        this.f33502P0.mo2122a(this.f33511U);
        this.f33502P0.mo2121b(this.f33491K);
        this.f33502P0.mo2114i(this.f33508S0, findViewById, findViewById2);
        if (this.f33522b != 0) {
            m19981I0(RefreshState.None);
            RefreshContent refreshContent2 = this.f33502P0;
            this.f33522b = 0;
            refreshContent2.mo2118e(0);
        }
        bringChildToFront(this.f33502P0.getView());
        SpinnerStyle spinnerStyle = this.f33498N0.getSpinnerStyle();
        SpinnerStyle spinnerStyle2 = SpinnerStyle.FixedBehind;
        if (spinnerStyle != spinnerStyle2) {
            bringChildToFront(this.f33498N0.getView());
        }
        if (this.f33500O0.getSpinnerStyle() != spinnerStyle2) {
            bringChildToFront(this.f33500O0.getView());
        }
        if (this.f33505R == null) {
            this.f33505R = new C11898h();
        }
        if (this.f33507S == null) {
            this.f33507S = new C11899i();
        }
        int[] iArr = this.f33551x;
        if (iArr != null) {
            this.f33498N0.setPrimaryColors(iArr);
            this.f33500O0.setPrimaryColors(this.f33551x);
        }
        if (this.f33501P || isNestedScrollingEnabled()) {
            return;
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof NestedScrollingParent) {
                setNestedScrollingEnabled(true);
                this.f33501P = false;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m19983G0(0, false);
        m19981I0(RefreshState.None);
        this.f33506R0.removeCallbacksAndMessages(null);
        this.f33506R0 = null;
        this.f33499O = true;
        this.f33501P = true;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount <= 3) {
            boolean[] zArr = new boolean[childCount];
            int i = 0;
            while (true) {
                boolean z = true;
                if (i >= childCount) {
                    break;
                }
                View childAt = getChildAt(i);
                if ((childAt instanceof RefreshHeader) && this.f33498N0 == null) {
                    this.f33498N0 = (RefreshHeader) childAt;
                } else if ((childAt instanceof RefreshFooter) && this.f33500O0 == null) {
                    if (!this.f33553z && this.f33499O) {
                        z = false;
                    }
                    this.f33553z = z;
                    this.f33500O0 = (RefreshFooter) childAt;
                } else if (this.f33502P0 == null && ((childAt instanceof AbsListView) || (childAt instanceof WebView) || (childAt instanceof ScrollView) || (childAt instanceof ScrollingView) || (childAt instanceof NestedScrollingChild) || (childAt instanceof NestedScrollingParent) || (childAt instanceof ViewPager))) {
                    this.f33502P0 = new RefreshContentWrapper(childAt);
                } else {
                    zArr[i] = true;
                }
                i++;
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                if (zArr[i2]) {
                    View childAt2 = getChildAt(i2);
                    if (childCount == 1 && this.f33502P0 == null) {
                        this.f33502P0 = new RefreshContentWrapper(childAt2);
                    } else if (i2 == 0 && this.f33498N0 == null) {
                        this.f33498N0 = new RefreshHeaderWrapper(childAt2);
                    } else if (childCount == 2 && this.f33502P0 == null) {
                        this.f33502P0 = new RefreshContentWrapper(childAt2);
                    } else if (i2 == 2 && this.f33500O0 == null) {
                        this.f33553z = this.f33553z || !this.f33499O;
                        this.f33500O0 = new RefreshFooterWrapper(childAt2);
                    } else if (this.f33502P0 == null) {
                        this.f33502P0 = new RefreshContentWrapper(childAt2);
                    } else if (i2 == 1 && childCount == 2 && this.f33500O0 == null) {
                        this.f33553z = this.f33553z || !this.f33499O;
                        this.f33500O0 = new RefreshFooterWrapper(childAt2);
                    }
                }
            }
            if (isInEditMode()) {
                int[] iArr = this.f33551x;
                if (iArr != null) {
                    RefreshHeader refreshHeader = this.f33498N0;
                    if (refreshHeader != null) {
                        refreshHeader.setPrimaryColors(iArr);
                    }
                    RefreshFooter refreshFooter = this.f33500O0;
                    if (refreshFooter != null) {
                        refreshFooter.setPrimaryColors(this.f33551x);
                    }
                }
                RefreshContent refreshContent = this.f33502P0;
                if (refreshContent != null) {
                    bringChildToFront(refreshContent.getView());
                }
                RefreshHeader refreshHeader2 = this.f33498N0;
                if (refreshHeader2 != null && refreshHeader2.getSpinnerStyle() != SpinnerStyle.FixedBehind) {
                    bringChildToFront(this.f33498N0.getView());
                }
                RefreshFooter refreshFooter2 = this.f33500O0;
                if (refreshFooter2 == null || refreshFooter2.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                    return;
                }
                bringChildToFront(this.f33500O0.getView());
                return;
            }
            return;
        }
        throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int max;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            RefreshContent refreshContent = this.f33502P0;
            boolean z2 = true;
            if (refreshContent != null && refreshContent.getView() == childAt) {
                boolean z3 = isInEditMode() && this.f33477D;
                C11905o c11905o = (C11905o) this.f33502P0.getLayoutParams();
                int i7 = ((ViewGroup.MarginLayoutParams) c11905o).leftMargin + paddingLeft;
                int i8 = ((ViewGroup.MarginLayoutParams) c11905o).topMargin + paddingTop;
                int mo2113j = this.f33502P0.mo2113j() + i7;
                int mo2120c = this.f33502P0.mo2120c() + i8;
                if (z3 && mo2055Y() && (this.f33471A || this.f33498N0.getSpinnerStyle() == SpinnerStyle.FixedBehind)) {
                    int i9 = this.f33478D0;
                    i8 += i9;
                    mo2120c += i9;
                }
                this.f33502P0.mo2115h(i7, i8, mo2113j, mo2120c);
            }
            RefreshHeader refreshHeader = this.f33498N0;
            if (refreshHeader != null && refreshHeader.getView() == childAt) {
                boolean z4 = isInEditMode() && this.f33477D && mo2055Y();
                View view = this.f33498N0.getView();
                C11905o c11905o2 = (C11905o) view.getLayoutParams();
                int i10 = ((ViewGroup.MarginLayoutParams) c11905o2).leftMargin;
                int i11 = ((ViewGroup.MarginLayoutParams) c11905o2).topMargin;
                int measuredWidth = view.getMeasuredWidth() + i10;
                int measuredHeight = view.getMeasuredHeight() + i11;
                if (!z4) {
                    if (this.f33498N0.getSpinnerStyle() == SpinnerStyle.Translate) {
                        i11 -= this.f33478D0;
                        max = view.getMeasuredHeight();
                    } else if (this.f33498N0.getSpinnerStyle() == SpinnerStyle.Scale) {
                        max = Math.max(Math.max(0, mo2055Y() ? this.f33522b : 0) - ((ViewGroup.MarginLayoutParams) c11905o2).bottomMargin, 0);
                    }
                    measuredHeight = i11 + max;
                }
                view.layout(i10, i11, measuredWidth, measuredHeight);
            }
            RefreshFooter refreshFooter = this.f33500O0;
            if (refreshFooter != null && refreshFooter.getView() == childAt) {
                z2 = (isInEditMode() && this.f33477D && mo2059U()) ? false : false;
                View view2 = this.f33500O0.getView();
                C11905o c11905o3 = (C11905o) view2.getLayoutParams();
                SpinnerStyle spinnerStyle = this.f33500O0.getSpinnerStyle();
                int i12 = ((ViewGroup.MarginLayoutParams) c11905o3).leftMargin;
                int measuredHeight2 = (((ViewGroup.MarginLayoutParams) c11905o3).topMargin + getMeasuredHeight()) - ((ViewGroup.MarginLayoutParams) c11905o3).bottomMargin;
                if (!z2 && spinnerStyle != SpinnerStyle.FixedFront && spinnerStyle != SpinnerStyle.FixedBehind) {
                    if (spinnerStyle == SpinnerStyle.Scale) {
                        i5 = Math.max(Math.max(mo2059U() ? -this.f33522b : 0, 0) - ((ViewGroup.MarginLayoutParams) c11905o3).topMargin, 0);
                    }
                    view2.layout(i12, measuredHeight2, view2.getMeasuredWidth() + i12, view2.getMeasuredHeight() + measuredHeight2);
                } else {
                    i5 = this.f33482F0;
                }
                measuredHeight2 -= i5;
                view2.layout(i12, measuredHeight2, view2.getMeasuredWidth() + i12, view2.getMeasuredHeight() + measuredHeight2);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        boolean z = isInEditMode() && this.f33477D;
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            RefreshHeader refreshHeader = this.f33498N0;
            if (refreshHeader != null && refreshHeader.getView() == childAt) {
                View view = this.f33498N0.getView();
                C11905o c11905o = (C11905o) view.getLayoutParams();
                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, ((ViewGroup.MarginLayoutParams) c11905o).leftMargin + ((ViewGroup.MarginLayoutParams) c11905o).rightMargin, ((ViewGroup.MarginLayoutParams) c11905o).width);
                if (this.f33480E0.gteReplaceWith(DimensionStatus.XmlLayoutUnNotify)) {
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(this.f33478D0 - ((ViewGroup.MarginLayoutParams) c11905o).bottomMargin, i7), 1073741824));
                } else if (this.f33498N0.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
                    if (this.f33480E0.notifyed) {
                        i6 = 0;
                    } else {
                        measureChild(view, childMeasureSpec, i2);
                        i6 = view.getMeasuredHeight();
                    }
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824));
                    if (i6 > 0 && i6 != view.getMeasuredHeight()) {
                        this.f33478D0 = i6 + ((ViewGroup.MarginLayoutParams) c11905o).bottomMargin;
                    }
                } else {
                    int i10 = ((ViewGroup.MarginLayoutParams) c11905o).height;
                    if (i10 > 0) {
                        DimensionStatus dimensionStatus = this.f33480E0;
                        DimensionStatus dimensionStatus2 = DimensionStatus.XmlExactUnNotify;
                        if (dimensionStatus.canReplaceWith(dimensionStatus2)) {
                            this.f33478D0 = ((ViewGroup.MarginLayoutParams) c11905o).height + ((ViewGroup.MarginLayoutParams) c11905o).bottomMargin;
                            this.f33480E0 = dimensionStatus2;
                        }
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) c11905o).height, 1073741824));
                    } else if (i10 == -2) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(View.MeasureSpec.getSize(i2) - ((ViewGroup.MarginLayoutParams) c11905o).bottomMargin, 0), Integer.MIN_VALUE));
                        int measuredHeight = view.getMeasuredHeight();
                        if (measuredHeight > 0) {
                            DimensionStatus dimensionStatus3 = this.f33480E0;
                            DimensionStatus dimensionStatus4 = DimensionStatus.XmlWrapUnNotify;
                            if (dimensionStatus3.canReplaceWith(dimensionStatus4)) {
                                this.f33480E0 = dimensionStatus4;
                                this.f33478D0 = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c11905o).bottomMargin;
                            }
                        }
                        if (measuredHeight <= 0) {
                            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(this.f33478D0 - ((ViewGroup.MarginLayoutParams) c11905o).bottomMargin, 0), 1073741824));
                        }
                    } else if (i10 == -1) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(this.f33478D0 - ((ViewGroup.MarginLayoutParams) c11905o).bottomMargin, 0), 1073741824));
                    } else {
                        view.measure(childMeasureSpec, i2);
                    }
                }
                if (this.f33498N0.getSpinnerStyle() == SpinnerStyle.Scale && !z) {
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(Math.max(0, mo2055Y() ? this.f33522b : 0) - ((ViewGroup.MarginLayoutParams) c11905o).bottomMargin, 0), 1073741824));
                }
                DimensionStatus dimensionStatus5 = this.f33480E0;
                if (!dimensionStatus5.notifyed) {
                    this.f33480E0 = dimensionStatus5.notifyed();
                    int max = (int) Math.max(this.f33478D0 * (this.f33490J0 - 1.0f), 0.0f);
                    this.f33486H0 = max;
                    this.f33498N0.mo2098o(this.f33508S0, this.f33478D0, max);
                }
                if (z && mo2055Y()) {
                    i9 += view.getMeasuredHeight();
                }
            }
            RefreshFooter refreshFooter = this.f33500O0;
            if (refreshFooter != null && refreshFooter.getView() == childAt) {
                View view2 = this.f33500O0.getView();
                C11905o c11905o2 = (C11905o) view2.getLayoutParams();
                int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i, ((ViewGroup.MarginLayoutParams) c11905o2).leftMargin + ((ViewGroup.MarginLayoutParams) c11905o2).rightMargin, ((ViewGroup.MarginLayoutParams) c11905o2).width);
                if (this.f33484G0.gteReplaceWith(DimensionStatus.XmlLayoutUnNotify)) {
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max(this.f33482F0 - ((ViewGroup.MarginLayoutParams) c11905o2).topMargin, 0), 1073741824));
                } else if (this.f33500O0.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
                    if (this.f33484G0.notifyed) {
                        i3 = 0;
                    } else {
                        measureChild(view2, childMeasureSpec2, i2);
                        i3 = view2.getMeasuredHeight();
                    }
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824));
                    if (i3 > 0 && i3 != view2.getMeasuredHeight()) {
                        this.f33478D0 = i3 + ((ViewGroup.MarginLayoutParams) c11905o2).bottomMargin;
                    }
                } else {
                    int i11 = ((ViewGroup.MarginLayoutParams) c11905o2).height;
                    if (i11 > 0) {
                        DimensionStatus dimensionStatus6 = this.f33484G0;
                        DimensionStatus dimensionStatus7 = DimensionStatus.XmlExactUnNotify;
                        if (dimensionStatus6.canReplaceWith(dimensionStatus7)) {
                            this.f33482F0 = ((ViewGroup.MarginLayoutParams) c11905o2).height + ((ViewGroup.MarginLayoutParams) c11905o2).topMargin;
                            this.f33484G0 = dimensionStatus7;
                        }
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) c11905o2).height, 1073741824));
                    } else if (i11 == -2) {
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max(View.MeasureSpec.getSize(i2) - ((ViewGroup.MarginLayoutParams) c11905o2).topMargin, 0), Integer.MIN_VALUE));
                        int measuredHeight2 = view2.getMeasuredHeight();
                        if (measuredHeight2 > 0) {
                            DimensionStatus dimensionStatus8 = this.f33484G0;
                            DimensionStatus dimensionStatus9 = DimensionStatus.XmlWrapUnNotify;
                            if (dimensionStatus8.canReplaceWith(dimensionStatus9)) {
                                this.f33484G0 = dimensionStatus9;
                                this.f33482F0 = view2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c11905o2).topMargin;
                            }
                        }
                        if (measuredHeight2 <= 0) {
                            view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max(this.f33482F0 - ((ViewGroup.MarginLayoutParams) c11905o2).topMargin, 0), 1073741824));
                        }
                    } else if (i11 == -1) {
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max(this.f33482F0 - ((ViewGroup.MarginLayoutParams) c11905o2).topMargin, 0), 1073741824));
                    } else {
                        view2.measure(childMeasureSpec2, i2);
                    }
                }
                if (this.f33500O0.getSpinnerStyle() == SpinnerStyle.Scale && !z) {
                    if (this.f33553z) {
                        i5 = -this.f33522b;
                        i4 = 0;
                    } else {
                        i4 = 0;
                        i5 = 0;
                    }
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max(Math.max(i4, i5) - ((ViewGroup.MarginLayoutParams) c11905o2).topMargin, i4), 1073741824));
                }
                DimensionStatus dimensionStatus10 = this.f33484G0;
                if (!dimensionStatus10.notifyed) {
                    this.f33484G0 = dimensionStatus10.notifyed();
                    int max2 = (int) Math.max(this.f33482F0 * (this.f33492K0 - 1.0f), 0.0f);
                    this.f33488I0 = max2;
                    this.f33500O0.mo2098o(this.f33508S0, this.f33482F0, max2);
                }
                if (z && this.f33553z) {
                    i9 += view2.getMeasuredHeight();
                }
            }
            RefreshContent refreshContent = this.f33502P0;
            if (refreshContent != null && refreshContent.getView() == childAt) {
                C11905o c11905o3 = (C11905o) this.f33502P0.getLayoutParams();
                this.f33502P0.mo2108o(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) c11905o3).leftMargin + ((ViewGroup.MarginLayoutParams) c11905o3).rightMargin, ((ViewGroup.MarginLayoutParams) c11905o3).width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) c11905o3).topMargin + ((ViewGroup.MarginLayoutParams) c11905o3).bottomMargin + ((z && mo2055Y() && (this.f33471A || this.f33498N0.getSpinnerStyle() == SpinnerStyle.FixedBehind)) ? this.f33478D0 : 0) + ((z && mo2059U() && (this.f33473B || this.f33500O0.getSpinnerStyle() == SpinnerStyle.FixedBehind)) ? this.f33482F0 : 0), ((ViewGroup.MarginLayoutParams) c11905o3).height));
                this.f33502P0.mo2117f(this.f33478D0, this.f33482F0);
                i9 += this.f33502P0.mo2120c();
            }
            i8++;
            i7 = 0;
        }
        setMeasuredDimension(ViewGroup.resolveSize(getSuggestedMinimumWidth(), i), ViewGroup.resolveSize(i9, i2));
        this.f33536j = getMeasuredWidth() / 2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f, float f2) {
        RefreshState refreshState;
        if (this.f33522b != 0 && this.f33512U0.opening) {
            m19950n0(0);
        }
        return this.f33529e1 != null || (refreshState = this.f33512U0) == RefreshState.ReleaseToRefresh || refreshState == RefreshState.ReleaseToLoad || (refreshState == RefreshState.PullDownToRefresh && this.f33522b > 0) || ((refreshState == RefreshState.PullToUpLoad && this.f33522b > 0) || dispatchNestedPreFling(f, f2));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i, int i2, @NonNull int[] iArr) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        if (this.f33512U0.opening) {
            int[] iArr2 = this.f33513V;
            if (dispatchNestedPreScroll(i, i2, iArr2, null)) {
                i2 -= iArr2[1];
            }
            RefreshState refreshState = this.f33512U0;
            if ((refreshState != RefreshState.Refreshing && refreshState != RefreshState.TwoLevel) || (this.f33543p0 * i2 <= 0 && this.f33526d <= 0)) {
                if (refreshState == RefreshState.Loading) {
                    if (this.f33543p0 * i2 > 0 || this.f33526d < 0) {
                        iArr[1] = 0;
                        if (Math.abs(i2) > Math.abs(this.f33543p0)) {
                            iArr[1] = iArr[1] + this.f33543p0;
                            this.f33543p0 = 0;
                            i7 = i2 - 0;
                            if (this.f33526d >= 0) {
                                m19982H0(0.0f);
                            }
                        } else {
                            int i9 = this.f33543p0 - i2;
                            this.f33543p0 = i9;
                            iArr[1] = iArr[1] + i2;
                            m19982H0(i9 + this.f33526d);
                            i7 = 0;
                        }
                        if (i7 >= 0 || (i8 = this.f33526d) >= 0) {
                            return;
                        }
                        if (i7 < i8) {
                            iArr[1] = iArr[1] + i8;
                            this.f33526d = 0;
                        } else {
                            this.f33526d = i8 - i7;
                            iArr[1] = iArr[1] + i7;
                        }
                        m19982H0(this.f33526d);
                        return;
                    }
                    return;
                }
                return;
            }
            iArr[1] = 0;
            if (Math.abs(i2) > Math.abs(this.f33543p0)) {
                iArr[1] = iArr[1] + this.f33543p0;
                this.f33543p0 = 0;
                i5 = i2 - 0;
                if (this.f33526d <= 0) {
                    m19982H0(0.0f);
                }
            } else {
                int i10 = this.f33543p0 - i2;
                this.f33543p0 = i10;
                iArr[1] = iArr[1] + i2;
                m19982H0(i10 + this.f33526d);
                i5 = 0;
            }
            if (i5 <= 0 || (i6 = this.f33526d) <= 0) {
                return;
            }
            if (i5 > i6) {
                iArr[1] = iArr[1] + i6;
                this.f33526d = 0;
            } else {
                this.f33526d = i6 - i5;
                iArr[1] = iArr[1] + i5;
            }
            m19982H0(this.f33526d);
            return;
        }
        if (mo2055Y() && i2 > 0 && (i4 = this.f33543p0) > 0) {
            if (i2 > i4) {
                iArr[1] = i2 - i4;
                this.f33543p0 = 0;
            } else {
                this.f33543p0 = i4 - i2;
                iArr[1] = i2;
            }
            m19982H0(this.f33543p0);
        } else if (mo2059U() && i2 < 0 && (i3 = this.f33543p0) < 0) {
            if (i2 < i3) {
                iArr[1] = i2 - i3;
                this.f33543p0 = 0;
            } else {
                this.f33543p0 = i3 - i2;
                iArr[1] = i2;
            }
            m19982H0(this.f33543p0);
        }
        int[] iArr3 = this.f33513V;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr3, null)) {
            iArr[0] = iArr[0] + iArr3[0];
            iArr[1] = iArr[1] + iArr3[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i, int i2, int i3, int i4) {
        RefreshContent refreshContent;
        RefreshContent refreshContent2;
        dispatchNestedScroll(i, i2, i3, i4, this.f33515W);
        int i5 = i4 + this.f33515W[1];
        if (this.f33512U0.opening) {
            if (mo2055Y() && i5 < 0 && ((refreshContent2 = this.f33502P0) == null || refreshContent2.mo2110m())) {
                int abs = this.f33543p0 + Math.abs(i5);
                this.f33543p0 = abs;
                m19982H0(abs + this.f33526d);
            } else if (!mo2059U() || i5 <= 0) {
            } else {
                RefreshContent refreshContent3 = this.f33502P0;
                if (refreshContent3 == null || refreshContent3.mo2107p()) {
                    int abs2 = this.f33543p0 - Math.abs(i5);
                    this.f33543p0 = abs2;
                    m19982H0(abs2 + this.f33526d);
                }
            }
        } else if (mo2055Y() && i5 < 0 && ((refreshContent = this.f33502P0) == null || refreshContent.mo2110m())) {
            if (this.f33512U0 == RefreshState.None) {
                m19925z1();
            }
            int abs3 = this.f33543p0 + Math.abs(i5);
            this.f33543p0 = abs3;
            m19982H0(abs3);
        } else if (!mo2059U() || i5 <= 0) {
        } else {
            RefreshContent refreshContent4 = this.f33502P0;
            if (refreshContent4 == null || refreshContent4.mo2107p()) {
                if (this.f33512U0 == RefreshState.None && !this.f33497N) {
                    m19992B1();
                }
                int abs4 = this.f33543p0 - Math.abs(i5);
                this.f33543p0 = abs4;
                m19982H0(abs4);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i) {
        this.f33476C0.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(i & 2);
        this.f33543p0 = 0;
        this.f33526d = this.f33522b;
        this.f33472A0 = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i) {
        return (isEnabled() && isNestedScrollingEnabled() && (i & 2) != 0) && (mo2055Y() || mo2059U());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.f33476C0.onStopNestedScroll(view);
        this.f33472A0 = false;
        this.f33543p0 = 0;
        m19980J0();
        stopNestedScroll();
    }

    /* renamed from: p0 */
    protected ValueAnimator m19946p0(int i, int i2, Interpolator interpolator) {
        if (this.f33522b != i) {
            ValueAnimator valueAnimator = this.f33529e1;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(this.f33522b, i);
            this.f33529e1 = ofInt;
            ofInt.setDuration(this.f33530f);
            this.f33529e1.setInterpolator(interpolator);
            this.f33529e1.addUpdateListener(this.f33533g1);
            this.f33529e1.addListener(this.f33531f1);
            this.f33529e1.setStartDelay(i2);
            this.f33529e1.start();
            return this.f33529e1;
        }
        return null;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: p1 */
    public SmartRefreshLayout mo2073G(@ColorRes int... iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = ContextCompat.getColor(getContext(), iArr[i]);
        }
        setPrimaryColors(iArr2);
        return this;
    }

    @Override // android.view.View
    public boolean post(Runnable runnable) {
        Handler handler = this.f33506R0;
        if (handler == null) {
            List<DelayedRunable> list = this.f33510T0;
            if (list == null) {
                list = new ArrayList<>();
            }
            this.f33510T0 = list;
            list.add(new DelayedRunable(runnable));
            return false;
        }
        return handler.post(new DelayedRunable(runnable));
    }

    @Override // android.view.View
    public boolean postDelayed(Runnable runnable, long j) {
        if (j == 0) {
            new DelayedRunable(runnable).run();
            return true;
        }
        Handler handler = this.f33506R0;
        if (handler == null) {
            List<DelayedRunable> list = this.f33510T0;
            if (list == null) {
                list = new ArrayList<>();
            }
            this.f33510T0 = list;
            list.add(new DelayedRunable(runnable, j));
            return false;
        }
        return handler.postDelayed(new DelayedRunable(runnable), j);
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: q */
    public boolean mo2024q() {
        return mo2042f0(0);
    }

    /* renamed from: q0 */
    protected ValueAnimator m19944q0(int i) {
        if (this.f33529e1 == null) {
            int i2 = (this.f33530f * 2) / 3;
            this.f33536j = getMeasuredWidth() / 2;
            RefreshState refreshState = this.f33512U0;
            RefreshState refreshState2 = RefreshState.Refreshing;
            if ((refreshState == refreshState2 || refreshState == RefreshState.TwoLevel) && i > 0) {
                ValueAnimator ofInt = ValueAnimator.ofInt(this.f33522b, Math.min(i * 2, this.f33478D0));
                this.f33529e1 = ofInt;
                ofInt.addListener(this.f33531f1);
            } else if (i < 0 && (refreshState == RefreshState.Loading || ((this.f33475C && this.f33497N) || (this.f33483G && mo2059U() && !this.f33497N && this.f33512U0 != refreshState2)))) {
                ValueAnimator ofInt2 = ValueAnimator.ofInt(this.f33522b, Math.max((i * 7) / 2, -this.f33482F0));
                this.f33529e1 = ofInt2;
                ofInt2.addListener(this.f33531f1);
            } else if (this.f33522b == 0 && this.f33479E) {
                if (i > 0) {
                    if (this.f33512U0 != RefreshState.Loading) {
                        m19925z1();
                    }
                    i2 = Math.max((int) TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME, (i * 250) / this.f33478D0);
                    this.f33529e1 = ValueAnimator.ofInt(0, Math.min(i, this.f33478D0));
                } else {
                    if (this.f33512U0 != refreshState2) {
                        m19992B1();
                    }
                    i2 = Math.max((int) TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME, ((-i) * 250) / this.f33482F0);
                    this.f33529e1 = ValueAnimator.ofInt(0, Math.max(i, -this.f33482F0));
                }
                this.f33529e1.addListener(new C11904n(i2));
            }
            ValueAnimator valueAnimator = this.f33529e1;
            if (valueAnimator != null) {
                valueAnimator.setDuration(i2);
                this.f33529e1.setInterpolator(new DecelerateInterpolator());
                this.f33529e1.addUpdateListener(this.f33533g1);
                this.f33529e1.start();
            }
        }
        return this.f33529e1;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: q1 */
    public SmartRefreshLayout mo2060T(int i) {
        this.f33530f = i;
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: r */
    public boolean mo2023r() {
        return this.f33483G;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: r0 */
    public SmartRefreshLayout mo2041g() {
        return mo2027n(Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.f33517X0))));
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: r1 */
    public SmartRefreshLayout mo2040g0(Interpolator interpolator) {
        this.f33544q = interpolator;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        View mo2112k = this.f33502P0.mo2112k();
        if (Build.VERSION.SDK_INT >= 21 || !(mo2112k instanceof AbsListView)) {
            if (mo2112k == null || ViewCompat.isNestedScrollingEnabled(mo2112k)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: s0 */
    public SmartRefreshLayout mo2027n(int i) {
        return mo2028m0(i, true);
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: s1 */
    public SmartRefreshLayout mo2074F(RefreshFooter refreshFooter) {
        return mo2033k(refreshFooter, -1, -2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.f33501P = true;
        this.f33474B0.setNestedScrollingEnabled(z);
    }

    protected void setViceState(RefreshState refreshState) {
        RefreshState refreshState2 = this.f33512U0;
        if (refreshState2.draging && refreshState2.isHeader() != refreshState.isHeader()) {
            m19981I0(RefreshState.None);
        }
        if (this.f33514V0 != refreshState) {
            this.f33514V0 = refreshState;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.f33474B0.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.f33474B0.stopNestedScroll();
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: t0 */
    public SmartRefreshLayout mo2028m0(int i, boolean z) {
        return mo2058V(i, z, false);
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: t1 */
    public SmartRefreshLayout mo2033k(RefreshFooter refreshFooter, int i, int i2) {
        if (refreshFooter != null) {
            RefreshFooter refreshFooter2 = this.f33500O0;
            if (refreshFooter2 != null) {
                removeView(refreshFooter2.getView());
            }
            this.f33500O0 = refreshFooter;
            this.f33484G0 = this.f33484G0.unNotify();
            this.f33553z = !this.f33499O || this.f33553z;
            if (this.f33500O0.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                addView(this.f33500O0.getView(), 0, new C11905o(i, i2));
            } else {
                addView(this.f33500O0.getView(), i, i2);
            }
        }
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: u0 */
    public SmartRefreshLayout mo2058V(int i, boolean z, boolean z2) {
        postDelayed(new RunnableC11886b(z, z2), i <= 0 ? 1L : i);
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: u1 */
    public SmartRefreshLayout mo2016y(RefreshHeader refreshHeader) {
        return mo2046d0(refreshHeader, -1, -2);
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: v0 */
    public SmartRefreshLayout mo2044e0(boolean z) {
        return mo2028m0(z ? Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.f33517X0))) : 0, z);
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: v1 */
    public SmartRefreshLayout mo2046d0(RefreshHeader refreshHeader, int i, int i2) {
        if (refreshHeader != null) {
            RefreshHeader refreshHeader2 = this.f33498N0;
            if (refreshHeader2 != null) {
                removeView(refreshHeader2.getView());
            }
            this.f33498N0 = refreshHeader;
            this.f33480E0 = this.f33480E0.unNotify();
            if (refreshHeader.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                addView(this.f33498N0.getView(), 0, new C11905o(i, i2));
            } else {
                addView(this.f33498N0.getView(), i, i2);
            }
        }
        return this;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: w0 */
    public SmartRefreshLayout mo2079A() {
        return mo2058V(Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.f33517X0))), true, true);
    }

    /* renamed from: w1 */
    protected void m19931w1() {
        RefreshState refreshState = this.f33512U0;
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2) {
            this.f33517X0 = System.currentTimeMillis();
            RefreshState refreshState3 = this.f33512U0;
            RefreshState refreshState4 = RefreshState.LoadReleased;
            if (refreshState3 != refreshState4) {
                if (refreshState3 != RefreshState.ReleaseToLoad) {
                    if (refreshState3 != RefreshState.PullToUpLoad) {
                        m19992B1();
                    }
                    m19988D1();
                }
                m19981I0(refreshState4);
                RefreshFooter refreshFooter = this.f33500O0;
                if (refreshFooter != null) {
                    refreshFooter.mo2104f(this, this.f33482F0, this.f33488I0);
                }
            }
            m19981I0(refreshState2);
            RefreshFooter refreshFooter2 = this.f33500O0;
            if (refreshFooter2 != null) {
                refreshFooter2.mo2096u(this, this.f33482F0, this.f33488I0);
            }
            OnLoadmoreListener onLoadmoreListener = this.f33507S;
            if (onLoadmoreListener != null) {
                onLoadmoreListener.mo320s(this);
            }
            OnMultiPurposeListener onMultiPurposeListener = this.f33509T;
            if (onMultiPurposeListener != null) {
                onMultiPurposeListener.mo320s(this);
                this.f33509T.mo328e(this.f33500O0, this.f33482F0, this.f33488I0);
            }
        }
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: x */
    public boolean mo2017x(int i, int i2, float f) {
        if (this.f33512U0 == RefreshState.None && mo2059U() && !this.f33497N) {
            ValueAnimator valueAnimator = this.f33529e1;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            RunnableC11892d runnableC11892d = new RunnableC11892d(f, i2);
            if (i > 0) {
                this.f33529e1 = new ValueAnimator();
                postDelayed(runnableC11892d, i);
                return true;
            }
            runnableC11892d.run();
            return true;
        }
        return false;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: x0 */
    public SmartRefreshLayout mo2078B() {
        return mo2057W(Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.f33518Y0))));
    }

    /* renamed from: x1 */
    protected void m19929x1() {
        C11900j c11900j = new C11900j();
        m19981I0(RefreshState.LoadReleased);
        ValueAnimator m19950n0 = m19950n0(-this.f33482F0);
        if (m19950n0 != null) {
            m19950n0.addListener(c11900j);
        }
        RefreshFooter refreshFooter = this.f33500O0;
        if (refreshFooter != null) {
            refreshFooter.mo2104f(this, this.f33482F0, this.f33488I0);
        }
        OnMultiPurposeListener onMultiPurposeListener = this.f33509T;
        if (onMultiPurposeListener != null) {
            onMultiPurposeListener.mo318y(this.f33500O0, this.f33482F0, this.f33488I0);
        }
        if (m19950n0 == null) {
            c11900j.onAnimationEnd(null);
        }
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: y0 */
    public SmartRefreshLayout mo2057W(int i) {
        return mo2030l0(i, true);
    }

    /* renamed from: y1 */
    protected void m19927y1() {
        if (!this.f33512U0.opening && mo2055Y()) {
            m19981I0(RefreshState.PullDownCanceled);
            m19978L0();
            return;
        }
        setViceState(RefreshState.PullDownCanceled);
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: z */
    public boolean mo2015z() {
        return this.f33512U0 == RefreshState.Loading;
    }

    @Override // p638r0.RefreshLayout
    /* renamed from: z0 */
    public SmartRefreshLayout mo2030l0(int i, boolean z) {
        postDelayed(new RunnableC11885a(z), i <= 0 ? 1L : i);
        return this;
    }

    /* renamed from: z1 */
    protected void m19925z1() {
        if (!this.f33512U0.opening && mo2055Y()) {
            m19981I0(RefreshState.PullDownToRefresh);
        } else {
            setViceState(RefreshState.PullDownToRefresh);
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$o */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C11905o extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f33582a;

        /* renamed from: b */
        public SpinnerStyle f33583b;

        public C11905o(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f33582a = 0;
            this.f33583b = null;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11882R.styleable.SmartRefreshLayout_Layout);
            this.f33582a = obtainStyledAttributes.getColor(C11882R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.f33582a);
            int i = C11882R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle;
            if (obtainStyledAttributes.hasValue(i)) {
                this.f33583b = SpinnerStyle.values()[obtainStyledAttributes.getInt(i, SpinnerStyle.Translate.ordinal())];
            }
            obtainStyledAttributes.recycle();
        }

        public C11905o(int i, int i2) {
            super(i, i2);
            this.f33582a = 0;
            this.f33583b = null;
        }

        public C11905o(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f33582a = 0;
            this.f33583b = null;
        }

        public C11905o(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f33582a = 0;
            this.f33583b = null;
        }
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33528e = 250;
        this.f33530f = 250;
        this.f33538l = 0.5f;
        this.f33552y = true;
        this.f33553z = false;
        this.f33471A = true;
        this.f33473B = true;
        this.f33475C = false;
        this.f33477D = true;
        this.f33479E = true;
        this.f33481F = true;
        this.f33483G = true;
        this.f33485H = false;
        this.f33487I = true;
        this.f33489J = true;
        this.f33491K = true;
        this.f33493L = false;
        this.f33495M = false;
        this.f33497N = false;
        this.f33499O = false;
        this.f33501P = false;
        this.f33503Q = false;
        this.f33513V = new int[2];
        this.f33515W = new int[2];
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.f33480E0 = dimensionStatus;
        this.f33484G0 = dimensionStatus;
        this.f33490J0 = 2.5f;
        this.f33492K0 = 2.5f;
        this.f33494L0 = 1.0f;
        this.f33496M0 = 1.0f;
        RefreshState refreshState = RefreshState.None;
        this.f33512U0 = refreshState;
        this.f33514V0 = refreshState;
        this.f33516W0 = false;
        this.f33517X0 = 0L;
        this.f33518Y0 = 0L;
        this.f33519Z0 = 0;
        this.f33521a1 = 0;
        this.f33527d1 = null;
        this.f33531f1 = new C11902l();
        this.f33533g1 = new C11903m();
        m19987E0(context, attributeSet);
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33528e = 250;
        this.f33530f = 250;
        this.f33538l = 0.5f;
        this.f33552y = true;
        this.f33553z = false;
        this.f33471A = true;
        this.f33473B = true;
        this.f33475C = false;
        this.f33477D = true;
        this.f33479E = true;
        this.f33481F = true;
        this.f33483G = true;
        this.f33485H = false;
        this.f33487I = true;
        this.f33489J = true;
        this.f33491K = true;
        this.f33493L = false;
        this.f33495M = false;
        this.f33497N = false;
        this.f33499O = false;
        this.f33501P = false;
        this.f33503Q = false;
        this.f33513V = new int[2];
        this.f33515W = new int[2];
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.f33480E0 = dimensionStatus;
        this.f33484G0 = dimensionStatus;
        this.f33490J0 = 2.5f;
        this.f33492K0 = 2.5f;
        this.f33494L0 = 1.0f;
        this.f33496M0 = 1.0f;
        RefreshState refreshState = RefreshState.None;
        this.f33512U0 = refreshState;
        this.f33514V0 = refreshState;
        this.f33516W0 = false;
        this.f33517X0 = 0L;
        this.f33518Y0 = 0L;
        this.f33519Z0 = 0;
        this.f33521a1 = 0;
        this.f33527d1 = null;
        this.f33531f1 = new C11902l();
        this.f33533g1 = new C11903m();
        m19987E0(context, attributeSet);
    }

    @RequiresApi(21)
    public SmartRefreshLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f33528e = 250;
        this.f33530f = 250;
        this.f33538l = 0.5f;
        this.f33552y = true;
        this.f33553z = false;
        this.f33471A = true;
        this.f33473B = true;
        this.f33475C = false;
        this.f33477D = true;
        this.f33479E = true;
        this.f33481F = true;
        this.f33483G = true;
        this.f33485H = false;
        this.f33487I = true;
        this.f33489J = true;
        this.f33491K = true;
        this.f33493L = false;
        this.f33495M = false;
        this.f33497N = false;
        this.f33499O = false;
        this.f33501P = false;
        this.f33503Q = false;
        this.f33513V = new int[2];
        this.f33515W = new int[2];
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.f33480E0 = dimensionStatus;
        this.f33484G0 = dimensionStatus;
        this.f33490J0 = 2.5f;
        this.f33492K0 = 2.5f;
        this.f33494L0 = 1.0f;
        this.f33496M0 = 1.0f;
        RefreshState refreshState = RefreshState.None;
        this.f33512U0 = refreshState;
        this.f33514V0 = refreshState;
        this.f33516W0 = false;
        this.f33517X0 = 0L;
        this.f33518Y0 = 0L;
        this.f33519Z0 = 0;
        this.f33521a1 = 0;
        this.f33527d1 = null;
        this.f33531f1 = new C11902l();
        this.f33533g1 = new C11903m();
        m19987E0(context, attributeSet);
    }
}
