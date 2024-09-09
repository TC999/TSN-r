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
import com.scwang.smartrefresh.layout.constant.DimensionStatus;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SmartRefreshLayout extends ViewGroup implements j1.h, NestedScrollingParent, NestedScrollingChild {

    /* renamed from: i1  reason: collision with root package name */
    protected static boolean f47849i1;

    /* renamed from: j1  reason: collision with root package name */
    protected static j1.a f47850j1 = new f();

    /* renamed from: k1  reason: collision with root package name */
    protected static j1.b f47851k1 = new g();
    protected boolean A;
    protected boolean B;
    protected boolean B0;
    protected boolean C;
    protected NestedScrollingChildHelper C0;
    protected boolean D;
    protected NestedScrollingParentHelper D0;
    protected boolean E;
    protected int E0;
    protected boolean F;
    protected DimensionStatus F0;
    protected boolean G;
    protected int G0;
    protected boolean H;
    protected DimensionStatus H0;
    protected boolean I;
    protected int I0;
    protected boolean J;
    protected int J0;
    protected boolean K;
    protected float K0;

    /* renamed from: L  reason: collision with root package name */
    protected boolean f47852L;
    protected float L0;
    protected boolean M;
    protected float M0;
    protected boolean N;
    protected float N0;
    protected boolean O;
    protected j1.e O0;
    protected boolean P;
    protected j1.d P0;
    protected boolean Q;
    protected j1.c Q0;
    protected k1.d R;
    protected Paint R0;
    protected k1.b S;
    protected Handler S0;
    protected k1.c T;
    protected j1.g T0;
    protected j1.i U;
    protected List<com.scwang.smartrefresh.layout.util.b> U0;
    protected int[] V;
    protected RefreshState V0;
    protected int[] W;
    protected RefreshState W0;
    protected boolean X0;
    protected long Y0;
    protected long Z0;

    /* renamed from: a  reason: collision with root package name */
    protected int f47853a;

    /* renamed from: a1  reason: collision with root package name */
    protected int f47854a1;

    /* renamed from: b  reason: collision with root package name */
    protected int f47855b;

    /* renamed from: b1  reason: collision with root package name */
    protected int f47856b1;

    /* renamed from: c  reason: collision with root package name */
    protected int f47857c;

    /* renamed from: c1  reason: collision with root package name */
    protected boolean f47858c1;

    /* renamed from: d  reason: collision with root package name */
    protected int f47859d;

    /* renamed from: d1  reason: collision with root package name */
    protected boolean f47860d1;

    /* renamed from: e  reason: collision with root package name */
    protected int f47861e;

    /* renamed from: e1  reason: collision with root package name */
    MotionEvent f47862e1;

    /* renamed from: f  reason: collision with root package name */
    protected int f47863f;

    /* renamed from: f1  reason: collision with root package name */
    protected ValueAnimator f47864f1;

    /* renamed from: g  reason: collision with root package name */
    protected int f47865g;

    /* renamed from: g1  reason: collision with root package name */
    protected Animator.AnimatorListener f47866g1;

    /* renamed from: h  reason: collision with root package name */
    protected float f47867h;

    /* renamed from: h1  reason: collision with root package name */
    protected ValueAnimator.AnimatorUpdateListener f47868h1;

    /* renamed from: i  reason: collision with root package name */
    protected float f47869i;

    /* renamed from: j  reason: collision with root package name */
    protected float f47870j;

    /* renamed from: k  reason: collision with root package name */
    protected float f47871k;

    /* renamed from: l  reason: collision with root package name */
    protected float f47872l;

    /* renamed from: m  reason: collision with root package name */
    protected boolean f47873m;

    /* renamed from: n  reason: collision with root package name */
    protected boolean f47874n;

    /* renamed from: o  reason: collision with root package name */
    protected boolean f47875o;

    /* renamed from: p  reason: collision with root package name */
    protected boolean f47876p;

    /* renamed from: p0  reason: collision with root package name */
    protected int f47877p0;

    /* renamed from: q  reason: collision with root package name */
    protected Interpolator f47878q;

    /* renamed from: r  reason: collision with root package name */
    protected int f47879r;

    /* renamed from: s  reason: collision with root package name */
    protected int f47880s;

    /* renamed from: t  reason: collision with root package name */
    protected int f47881t;

    /* renamed from: u  reason: collision with root package name */
    protected int f47882u;

    /* renamed from: v  reason: collision with root package name */
    protected Scroller f47883v;

    /* renamed from: w  reason: collision with root package name */
    protected VelocityTracker f47884w;

    /* renamed from: x  reason: collision with root package name */
    protected int[] f47885x;

    /* renamed from: y  reason: collision with root package name */
    protected boolean f47886y;

    /* renamed from: z  reason: collision with root package name */
    protected boolean f47887z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f47888a;

        a(boolean z3) {
            this.f47888a = z3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.scwang.smartrefresh.layout.SmartRefreshLayout, r0.h] */
        @Override // java.lang.Runnable
        public void run() {
            ?? r02 = SmartRefreshLayout.this;
            if (((SmartRefreshLayout) r02).U0 == RefreshState.Refreshing) {
                r0.e eVar = ((SmartRefreshLayout) r02).N0;
                if (eVar != 0 && ((SmartRefreshLayout) r02).P0 != null) {
                    int v3 = eVar.v(r02, this.f47888a);
                    if (v3 < Integer.MAX_VALUE) {
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        if (smartRefreshLayout.f47873m) {
                            smartRefreshLayout.f47859d = 0;
                            smartRefreshLayout.f47869i = smartRefreshLayout.f47871k;
                            smartRefreshLayout.f47873m = false;
                            long currentTimeMillis = System.currentTimeMillis();
                            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                            smartRefreshLayout2.F1(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout2.f47870j, smartRefreshLayout2.f47869i + smartRefreshLayout2.f47855b, 0));
                        }
                        SmartRefreshLayout.this.I0(RefreshState.RefreshFinish);
                    }
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    s0.c cVar = smartRefreshLayout3.T;
                    if (cVar != null) {
                        cVar.a(smartRefreshLayout3.N0, this.f47888a);
                    }
                    if (v3 < Integer.MAX_VALUE) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        if (smartRefreshLayout4.f47855b > 0) {
                            ValueAnimator o02 = smartRefreshLayout4.o0(0, v3);
                            SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                            ValueAnimator.AnimatorUpdateListener g4 = smartRefreshLayout5.J ? smartRefreshLayout5.P0.g(smartRefreshLayout5.f47855b) : null;
                            if (o02 == null || g4 == null) {
                                return;
                            }
                            o02.addUpdateListener(g4);
                            return;
                        }
                        smartRefreshLayout4.G0(0, true);
                        SmartRefreshLayout.this.L0();
                        return;
                    }
                    return;
                }
                r02.L0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f47890a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f47891b;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f47893a;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
            /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$b$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\6400276.dex */
            class C0930a extends AnimatorListenerAdapter {
                C0930a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SmartRefreshLayout.this.c(true);
                }
            }

            a(int i4) {
                this.f47893a = i4;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i4;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                ValueAnimator.AnimatorUpdateListener g4 = (!smartRefreshLayout.I || (i4 = smartRefreshLayout.f47855b) >= 0) ? null : smartRefreshLayout.P0.g(i4);
                if (g4 != null) {
                    g4.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                }
                if (g4 == null) {
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.f47855b < 0) {
                        ValueAnimator o02 = smartRefreshLayout2.o0(0, this.f47893a);
                        if (o02 == null || !b.this.f47891b) {
                            return;
                        }
                        o02.addListener(new C0930a());
                        return;
                    }
                }
                SmartRefreshLayout.this.G0(0, true);
                SmartRefreshLayout.this.L0();
                b bVar = b.this;
                if (bVar.f47891b) {
                    SmartRefreshLayout.this.c(true);
                }
            }
        }

        b(boolean z3, boolean z4) {
            this.f47890a = z3;
            this.f47891b = z4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.scwang.smartrefresh.layout.SmartRefreshLayout, r0.h] */
        @Override // java.lang.Runnable
        public void run() {
            ?? r02 = SmartRefreshLayout.this;
            if (((SmartRefreshLayout) r02).U0 == RefreshState.Loading) {
                r0.d dVar = ((SmartRefreshLayout) r02).O0;
                if (dVar != 0 && ((SmartRefreshLayout) r02).P0 != null) {
                    int v3 = dVar.v(r02, this.f47890a);
                    if (v3 < Integer.MAX_VALUE) {
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        if (smartRefreshLayout.f47873m) {
                            smartRefreshLayout.f47859d = 0;
                            smartRefreshLayout.f47869i = smartRefreshLayout.f47871k;
                            smartRefreshLayout.f47873m = false;
                            long currentTimeMillis = System.currentTimeMillis();
                            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                            smartRefreshLayout2.F1(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout2.f47870j, smartRefreshLayout2.f47869i + smartRefreshLayout2.f47855b, 0));
                        }
                        SmartRefreshLayout.this.I0(RefreshState.LoadFinish);
                    }
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    s0.c cVar = smartRefreshLayout3.T;
                    if (cVar != null) {
                        cVar.x(smartRefreshLayout3.O0, this.f47890a);
                    }
                    if (v3 < Integer.MAX_VALUE) {
                        SmartRefreshLayout.this.postDelayed(new a(v3), SmartRefreshLayout.this.f47855b < 0 ? v3 : 0L);
                        return;
                    }
                    return;
                }
                r02.L0();
            } else if (this.f47891b) {
                r02.c(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f47896a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f47897b;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.G0(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.e1 = null;
                if (smartRefreshLayout.U0 != RefreshState.ReleaseToRefresh) {
                    smartRefreshLayout.E1();
                }
                SmartRefreshLayout.this.J0();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.f47870j = smartRefreshLayout.getMeasuredWidth() / 2;
                SmartRefreshLayout.this.z1();
            }
        }

        c(float f4, int i4) {
            this.f47896a = f4;
            this.f47897b = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.e1 = ValueAnimator.ofInt(smartRefreshLayout.f47855b, (int) (smartRefreshLayout.D0 * this.f47896a));
            SmartRefreshLayout.this.e1.setDuration(this.f47897b);
            SmartRefreshLayout.this.e1.setInterpolator(new DecelerateInterpolator());
            SmartRefreshLayout.this.e1.addUpdateListener(new a());
            SmartRefreshLayout.this.e1.addListener(new b());
            SmartRefreshLayout.this.e1.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f47901a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f47902b;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.G0(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.e1 = null;
                if (smartRefreshLayout.U0 != RefreshState.ReleaseToLoad) {
                    smartRefreshLayout.D1();
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (smartRefreshLayout2.G) {
                    smartRefreshLayout2.G = false;
                    smartRefreshLayout2.J0();
                    SmartRefreshLayout.this.G = true;
                    return;
                }
                smartRefreshLayout2.J0();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.f47870j = smartRefreshLayout.getMeasuredWidth() / 2;
                SmartRefreshLayout.this.B1();
            }
        }

        d(float f4, int i4) {
            this.f47901a = f4;
            this.f47902b = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.e1 = ValueAnimator.ofInt(smartRefreshLayout.f47855b, -((int) (smartRefreshLayout.F0 * this.f47901a)));
            SmartRefreshLayout.this.e1.setDuration(this.f47902b);
            SmartRefreshLayout.this.e1.setInterpolator(new DecelerateInterpolator());
            SmartRefreshLayout.this.e1.addUpdateListener(new a());
            SmartRefreshLayout.this.e1.addListener(new b());
            SmartRefreshLayout.this.e1.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f47906a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f47907b;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f47907b = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47907b[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47907b[RefreshState.PullToUpLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47907b[RefreshState.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f47907b[RefreshState.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f47907b[RefreshState.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f47907b[RefreshState.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f47907b[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f47907b[RefreshState.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f47907b[RefreshState.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f47907b[RefreshState.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f47907b[RefreshState.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f47907b[RefreshState.RefreshFinish.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f47907b[RefreshState.LoadFinish.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr2 = new int[SpinnerStyle.values().length];
            f47906a = iArr2;
            try {
                iArr2[SpinnerStyle.Translate.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f47906a[SpinnerStyle.Scale.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class f implements r0.a {
        f() {
        }

        @Override // r0.a
        @NonNull
        public r0.d a(Context context, r0.h hVar) {
            return new BallPulseFooter(context);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class g implements r0.b {
        g() {
        }

        @Override // r0.b
        @NonNull
        public r0.e a(Context context, r0.h hVar) {
            return new BezierRadarHeader(context);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class h implements s0.d {
        h() {
        }

        @Override // s0.d
        public void q(r0.h hVar) {
            hVar.W(3000);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class i implements s0.b {
        i() {
        }

        @Override // s0.b
        public void s(r0.h hVar) {
            hVar.n(2000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class j extends AnimatorListenerAdapter {
        j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.w1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class k extends AnimatorListenerAdapter {
        k() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v3, types: [com.scwang.smartrefresh.layout.SmartRefreshLayout, r0.h] */
        /* JADX WARN: Type inference failed for: r4v4, types: [com.scwang.smartrefresh.layout.SmartRefreshLayout, r0.h] */
        /* JADX WARN: Type inference failed for: r4v5, types: [com.scwang.smartrefresh.layout.SmartRefreshLayout, r0.h] */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.Y0 = System.currentTimeMillis();
            SmartRefreshLayout.this.I0(RefreshState.Refreshing);
            ?? r4 = SmartRefreshLayout.this;
            s0.d dVar = ((SmartRefreshLayout) r4).R;
            if (dVar != 0) {
                dVar.q(r4);
            }
            ?? r42 = SmartRefreshLayout.this;
            r0.e eVar = ((SmartRefreshLayout) r42).N0;
            if (eVar != 0) {
                eVar.u(r42, ((SmartRefreshLayout) r42).D0, ((SmartRefreshLayout) r42).H0);
            }
            ?? r43 = SmartRefreshLayout.this;
            s0.c cVar = ((SmartRefreshLayout) r43).T;
            if (cVar != 0) {
                cVar.q(r43);
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                smartRefreshLayout.T.l(smartRefreshLayout.N0, smartRefreshLayout.D0, smartRefreshLayout.H0);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class l extends AnimatorListenerAdapter {
        l() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.e1 = null;
            if (smartRefreshLayout.f47855b == 0) {
                RefreshState refreshState = smartRefreshLayout.U0;
                RefreshState refreshState2 = RefreshState.None;
                if (refreshState == refreshState2 || refreshState.opening) {
                    return;
                }
                smartRefreshLayout.I0(refreshState2);
                return;
            }
            RefreshState refreshState3 = smartRefreshLayout.U0;
            if (refreshState3 != smartRefreshLayout.V0) {
                smartRefreshLayout.setViceState(refreshState3);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class m implements ValueAnimator.AnimatorUpdateListener {
        m() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmartRefreshLayout.this.G0(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class n extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f47914a;

        n(int i4) {
            this.f47914a = i4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.e1 = ValueAnimator.ofInt(smartRefreshLayout.f47855b, 0);
            SmartRefreshLayout.this.e1.setDuration(this.f47914a);
            SmartRefreshLayout.this.e1.setInterpolator(new DecelerateInterpolator());
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            smartRefreshLayout2.e1.addUpdateListener(smartRefreshLayout2.g1);
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            smartRefreshLayout3.e1.addListener(smartRefreshLayout3.f1);
            SmartRefreshLayout.this.e1.start();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class p implements r0.g {

        /* renamed from: a  reason: collision with root package name */
        SmartRefreshLayout f47918a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                p.this.f47918a.I0(RefreshState.TwoLevel);
            }
        }

        public p(SmartRefreshLayout smartRefreshLayout) {
            this.f47918a = smartRefreshLayout;
        }

        @Override // r0.g
        public r0.g a() {
            SmartRefreshLayout smartRefreshLayout = this.f47918a;
            DimensionStatus dimensionStatus = smartRefreshLayout.E0;
            if (dimensionStatus.notifyed) {
                smartRefreshLayout.E0 = dimensionStatus.unNotify();
            }
            return this;
        }

        @Override // r0.g
        public r0.g b(@NonNull RefreshState refreshState) {
            switch (e.f47907b[refreshState.ordinal()]) {
                case 1:
                    this.f47918a.L0();
                    return null;
                case 2:
                    this.f47918a.z1();
                    return null;
                case 3:
                    this.f47918a.B1();
                    return null;
                case 4:
                    this.f47918a.y1();
                    return null;
                case 5:
                    this.f47918a.A1();
                    return null;
                case 6:
                    this.f47918a.E1();
                    return null;
                case 7:
                    this.f47918a.D1();
                    return null;
                case 8:
                    SmartRefreshLayout smartRefreshLayout = this.f47918a;
                    if (!smartRefreshLayout.U0.opening && smartRefreshLayout.Y()) {
                        this.f47918a.I0(RefreshState.ReleaseToTwoLevel);
                        return null;
                    }
                    this.f47918a.setViceState(RefreshState.ReleaseToTwoLevel);
                    return null;
                case 9:
                    SmartRefreshLayout smartRefreshLayout2 = this.f47918a;
                    if (!smartRefreshLayout2.U0.opening && smartRefreshLayout2.Y()) {
                        this.f47918a.I0(RefreshState.RefreshReleased);
                        return null;
                    }
                    this.f47918a.setViceState(RefreshState.RefreshReleased);
                    return null;
                case 10:
                    SmartRefreshLayout smartRefreshLayout3 = this.f47918a;
                    if (!smartRefreshLayout3.U0.opening && smartRefreshLayout3.U()) {
                        this.f47918a.I0(RefreshState.LoadReleased);
                        return null;
                    }
                    this.f47918a.setViceState(RefreshState.LoadReleased);
                    return null;
                case 11:
                    this.f47918a.C1();
                    return null;
                case 12:
                    this.f47918a.x1();
                    return null;
                case 13:
                    SmartRefreshLayout smartRefreshLayout4 = this.f47918a;
                    if (smartRefreshLayout4.U0 == RefreshState.Refreshing) {
                        smartRefreshLayout4.I0(RefreshState.RefreshFinish);
                        return null;
                    }
                    return null;
                case 14:
                    SmartRefreshLayout smartRefreshLayout5 = this.f47918a;
                    if (smartRefreshLayout5.U0 == RefreshState.Loading) {
                        smartRefreshLayout5.I0(RefreshState.LoadFinish);
                        return null;
                    }
                    return null;
                default:
                    return null;
            }
        }

        @Override // r0.g
        public r0.g c(int i4) {
            SmartRefreshLayout smartRefreshLayout = this.f47918a;
            if (smartRefreshLayout.Q0 == null && i4 != 0) {
                smartRefreshLayout.Q0 = new Paint();
            }
            this.f47918a.Z0 = i4;
            return this;
        }

        @Override // r0.g
        public void d() {
            SmartRefreshLayout smartRefreshLayout = this.f47918a;
            if (smartRefreshLayout.U0 == RefreshState.TwoLevel) {
                smartRefreshLayout.I0(RefreshState.TwoLevelFinish);
                SmartRefreshLayout smartRefreshLayout2 = this.f47918a;
                if (smartRefreshLayout2.f47855b == 0) {
                    i(0, true);
                    this.f47918a.I0(RefreshState.None);
                    return;
                }
                smartRefreshLayout2.n0(0).setDuration(this.f47918a.f47861e);
            }
        }

        @Override // r0.g
        public r0.g e(int i4) {
            this.f47918a.n0(i4);
            return this;
        }

        @Override // r0.g
        public r0.g f(int i4) {
            this.f47918a.f47861e = i4;
            return this;
        }

        @Override // r0.g
        public r0.g g(boolean z3) {
            this.f47918a.b1 = z3;
            return this;
        }

        @Override // r0.g
        public void h(boolean z3) {
            if (z3) {
                a aVar = new a();
                SmartRefreshLayout smartRefreshLayout = this.f47918a;
                ValueAnimator n02 = smartRefreshLayout.n0(smartRefreshLayout.getMeasuredHeight());
                if (n02 != null) {
                    SmartRefreshLayout smartRefreshLayout2 = this.f47918a;
                    if (n02 == smartRefreshLayout2.e1) {
                        n02.setDuration(smartRefreshLayout2.f47861e);
                        n02.addListener(aVar);
                        return;
                    }
                }
                aVar.onAnimationEnd(null);
            } else if (e(0) == null) {
                this.f47918a.I0(RefreshState.None);
            }
        }

        @Override // r0.g
        public r0.g i(int i4, boolean z3) {
            this.f47918a.G0(i4, z3);
            return this;
        }

        @Override // r0.g
        public r0.g j(boolean z3) {
            SmartRefreshLayout smartRefreshLayout = this.f47918a;
            if (!smartRefreshLayout.Q) {
                smartRefreshLayout.Q = true;
                smartRefreshLayout.A = z3;
            }
            return this;
        }

        @Override // r0.g
        @NonNull
        public r0.c k() {
            return this.f47918a.P0;
        }

        @Override // r0.g
        public r0.g l(int i4) {
            SmartRefreshLayout smartRefreshLayout = this.f47918a;
            if (smartRefreshLayout.Q0 == null && i4 != 0) {
                smartRefreshLayout.Q0 = new Paint();
            }
            this.f47918a.f47854a1 = i4;
            return this;
        }

        @Override // r0.g
        public r0.g m() {
            SmartRefreshLayout smartRefreshLayout = this.f47918a;
            DimensionStatus dimensionStatus = smartRefreshLayout.G0;
            if (dimensionStatus.notifyed) {
                smartRefreshLayout.G0 = dimensionStatus.unNotify();
            }
            return this;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.scwang.smartrefresh.layout.SmartRefreshLayout, r0.h] */
        @Override // r0.g
        @NonNull
        public r0.h n() {
            return this.f47918a;
        }

        @Override // r0.g
        public r0.g o(boolean z3) {
            this.f47918a.f47858c1 = z3;
            return this;
        }
    }

    public SmartRefreshLayout(Context context) {
        super(context);
        this.f47861e = 250;
        this.f47863f = 250;
        this.f47872l = 0.5f;
        this.f47886y = true;
        this.f47887z = false;
        this.A = true;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = true;
        this.f47852L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.V = new int[2];
        this.W = new int[2];
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.F0 = dimensionStatus;
        this.H0 = dimensionStatus;
        this.K0 = 2.5f;
        this.L0 = 2.5f;
        this.M0 = 1.0f;
        this.N0 = 1.0f;
        RefreshState refreshState = RefreshState.None;
        this.V0 = refreshState;
        this.W0 = refreshState;
        this.X0 = false;
        this.Y0 = 0L;
        this.Z0 = 0L;
        this.f47854a1 = 0;
        this.f47856b1 = 0;
        this.f47862e1 = null;
        this.f47866g1 = new l();
        this.f47868h1 = new m();
        E0(context, null);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [j1.g, com.scwang.smartrefresh.layout.SmartRefreshLayout$p] */
    private void E0(Context context, AttributeSet attributeSet) {
        setClipToPadding(false);
        com.scwang.smartrefresh.layout.util.c cVar = new com.scwang.smartrefresh.layout.util.c();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f47883v = new Scroller(context);
        this.T0 = new p(this);
        this.f47884w = VelocityTracker.obtain();
        this.f47865g = context.getResources().getDisplayMetrics().heightPixels;
        this.f47878q = new com.scwang.smartrefresh.layout.util.e();
        this.f47853a = viewConfiguration.getScaledTouchSlop();
        this.f47881t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f47882u = viewConfiguration.getScaledMaximumFlingVelocity();
        this.D0 = new NestedScrollingParentHelper(this);
        this.C0 = new NestedScrollingChildHelper(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout);
        int i4 = R.styleable.SmartRefreshLayout_srlEnableNestedScrolling;
        ViewCompat.setNestedScrollingEnabled(this, obtainStyledAttributes.getBoolean(i4, false));
        this.f47872l = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlDragRate, this.f47872l);
        this.K0 = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.K0);
        this.L0 = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.L0);
        this.M0 = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.M0);
        this.N0 = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.N0);
        this.f47886y = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableRefresh, this.f47886y);
        this.f47863f = obtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_srlReboundDuration, this.f47863f);
        int i5 = R.styleable.SmartRefreshLayout_srlEnableLoadmore;
        this.f47887z = obtainStyledAttributes.getBoolean(i5, this.f47887z);
        int i6 = R.styleable.SmartRefreshLayout_srlHeaderHeight;
        this.E0 = obtainStyledAttributes.getDimensionPixelOffset(i6, cVar.a(100.0f));
        int i7 = R.styleable.SmartRefreshLayout_srlFooterHeight;
        this.G0 = obtainStyledAttributes.getDimensionPixelOffset(i7, cVar.a(60.0f));
        this.f47852L = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.f47852L);
        this.M = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.M);
        int i8 = R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent;
        this.A = obtainStyledAttributes.getBoolean(i8, this.A);
        this.B = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, this.B);
        this.D = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.D);
        this.G = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableAutoLoadmore, this.G);
        this.E = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.E);
        this.H = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.H);
        this.I = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.I);
        this.J = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.J);
        this.K = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadmoreWhenContentNotFull, this.K);
        this.C = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.C);
        this.F = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.F);
        this.f47879r = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, -1);
        this.f47880s = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedFooterViewId, -1);
        this.O = obtainStyledAttributes.hasValue(i5);
        this.P = obtainStyledAttributes.hasValue(i4);
        this.Q = obtainStyledAttributes.hasValue(i8);
        this.F0 = obtainStyledAttributes.hasValue(i6) ? DimensionStatus.XmlLayoutUnNotify : this.F0;
        this.H0 = obtainStyledAttributes.hasValue(i7) ? DimensionStatus.XmlLayoutUnNotify : this.H0;
        this.I0 = (int) Math.max(this.E0 * (this.K0 - 1.0f), 0.0f);
        this.J0 = (int) Math.max(this.G0 * (this.L0 - 1.0f), 0.0f);
        int color = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.f47885x = new int[]{color2, color};
            } else {
                this.f47885x = new int[]{color2};
            }
        } else if (color != 0) {
            this.f47885x = new int[]{0, color};
        }
        obtainStyledAttributes.recycle();
    }

    public static void setDefaultRefreshFooterCreater(@NonNull j1.a aVar) {
        f47850j1 = aVar;
        f47849i1 = true;
    }

    public static void setDefaultRefreshHeaderCreater(@NonNull j1.b bVar) {
        f47851k1 = bVar;
    }

    @Override // j1.h
    /* renamed from: A0 */
    public SmartRefreshLayout P(boolean z3) {
        return l0(z3 ? Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.Z0))) : 0, z3);
    }

    protected void A1() {
        if (T() && !this.N && !this.V0.opening) {
            I0(RefreshState.PullUpCanceled);
            L0();
            return;
        }
        setViceState(RefreshState.PullUpCanceled);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: B0 */
    public o generateDefaultLayoutParams() {
        return new o(-1, -1);
    }

    protected void B1() {
        if (T() && !this.N && !this.V0.opening) {
            I0(RefreshState.PullToUpLoad);
        } else {
            setViceState(RefreshState.PullToUpLoad);
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: C0 */
    public o generateLayoutParams(AttributeSet attributeSet) {
        return new o(getContext(), attributeSet);
    }

    protected void C1() {
        k kVar = new k();
        I0(RefreshState.RefreshReleased);
        ValueAnimator n02 = n0(this.E0);
        if (n02 != null) {
            n02.addListener(kVar);
        }
        j1.e eVar = this.O0;
        if (eVar != null) {
            eVar.k(this, this.E0, this.I0);
        }
        k1.c cVar = this.T;
        if (cVar != null) {
            cVar.i(this.O0, this.E0, this.I0);
        }
        if (n02 == null) {
            kVar.onAnimationEnd(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: D0 */
    public o generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new o(layoutParams);
    }

    protected void D1() {
        if (T() && !this.N && !this.V0.opening) {
            I0(RefreshState.ReleaseToLoad);
        } else {
            setViceState(RefreshState.ReleaseToLoad);
        }
    }

    protected void E1() {
        if (!this.V0.opening && X()) {
            I0(RefreshState.ReleaseToRefresh);
        } else {
            setViceState(RefreshState.ReleaseToRefresh);
        }
    }

    protected boolean F0(int i4) {
        RefreshState refreshState;
        if (this.f47864f1 == null || i4 != 0 || (refreshState = this.V0) == RefreshState.LoadFinish || refreshState == RefreshState.RefreshFinish) {
            return false;
        }
        if (refreshState == RefreshState.PullDownCanceled) {
            z1();
        } else if (refreshState == RefreshState.PullUpCanceled) {
            B1();
        }
        this.f47864f1.cancel();
        this.f47864f1 = null;
        return true;
    }

    protected boolean F1(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1) {
            float f4 = -this.f47884w.getYVelocity();
            if (Math.abs(f4) > this.f47881t && this.f47855b == 0 && this.f47859d == 0) {
                this.X0 = false;
                this.f47883v.fling(0, getScrollY(), 0, (int) f4, 0, 0, -2147483647, Integer.MAX_VALUE);
                this.f47883v.computeScrollOffset();
                invalidate();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void G0(int i4, boolean z3) {
        k1.c cVar;
        k1.c cVar2;
        j1.d dVar;
        j1.e eVar;
        j1.e eVar2;
        j1.d dVar2;
        if (this.f47855b != i4 || (((eVar2 = this.O0) != null && eVar2.m()) || ((dVar2 = this.P0) != null && dVar2.m()))) {
            int i5 = this.f47855b;
            this.f47855b = i4;
            if (!z3 && getViceState().draging) {
                int i6 = this.f47855b;
                if (i6 > this.E0 * this.M0) {
                    if (this.V0 != RefreshState.ReleaseToTwoLevel) {
                        E1();
                    }
                } else if ((-i6) > this.G0 * this.N0 && !this.N) {
                    D1();
                } else if (i6 < 0 && !this.N) {
                    B1();
                } else if (i6 > 0) {
                    z1();
                }
            }
            if (this.Q0 != null) {
                Integer num = null;
                if (i4 >= 0) {
                    if (this.A || (eVar = this.O0) == null || eVar.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                        num = Integer.valueOf(i4);
                    } else if (i5 < 0) {
                        num = 0;
                    }
                }
                if (i4 <= 0) {
                    if (this.B || (dVar = this.P0) == null || dVar.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                        num = Integer.valueOf(i4);
                    } else if (i5 > 0) {
                        num = 0;
                    }
                }
                if (num != null) {
                    this.Q0.e(num.intValue());
                    if ((this.f47854a1 != 0 && (num.intValue() >= 0 || i5 > 0)) || (this.f47856b1 != 0 && (num.intValue() <= 0 || i5 < 0))) {
                        invalidate();
                    }
                }
            }
            if ((i4 >= 0 || i5 > 0) && this.O0 != null) {
                int max = Math.max(i4, 0);
                int i7 = this.E0;
                int i8 = this.I0;
                float f4 = (max * 1.0f) / i7;
                if (X() || (this.V0 == RefreshState.RefreshFinish && z3)) {
                    if (i5 != this.f47855b) {
                        int i9 = e.f47906a[this.O0.getSpinnerStyle().ordinal()];
                        if (i9 == 1) {
                            this.O0.getView().setTranslationY(this.f47855b);
                        } else if (i9 == 2) {
                            this.O0.getView().requestLayout();
                        }
                        if (z3) {
                            this.O0.j(f4, max, i7, i8);
                        }
                    }
                    if (!z3) {
                        if (this.O0.m()) {
                            int width = getWidth();
                            this.O0.l(this.f47870j / width, (int) this.f47870j, width);
                            this.O0.x(f4, max, i7, i8);
                        } else if (i5 != this.f47855b) {
                            this.O0.x(f4, max, i7, i8);
                        }
                    }
                }
                if (i5 != this.f47855b && (cVar = this.T) != null) {
                    if (z3) {
                        cVar.y(this.O0, f4, max, i7, i8);
                    } else {
                        cVar.w(this.O0, f4, max, i7, i8);
                    }
                }
            }
            if ((i4 <= 0 || i5 < 0) && this.P0 != null) {
                int i10 = -Math.min(i4, 0);
                int i11 = this.G0;
                int i12 = this.J0;
                float f5 = (i10 * 1.0f) / i11;
                if (T() || (this.V0 == RefreshState.LoadFinish && z3)) {
                    if (i5 != this.f47855b) {
                        int i13 = e.f47906a[this.P0.getSpinnerStyle().ordinal()];
                        if (i13 == 1) {
                            this.P0.getView().setTranslationY(this.f47855b);
                        } else if (i13 == 2) {
                            this.P0.getView().requestLayout();
                        }
                        if (z3) {
                            this.P0.s(f5, i10, i11, i12);
                        }
                    }
                    if (!z3) {
                        if (this.P0.m()) {
                            int width2 = getWidth();
                            this.P0.l(this.f47870j / width2, (int) this.f47870j, width2);
                            this.P0.d(f5, i10, i11, i12);
                        } else if (i5 != this.f47855b) {
                            this.P0.d(f5, i10, i11, i12);
                        }
                    }
                }
                if (i5 == this.f47855b || (cVar2 = this.T) == null) {
                    return;
                }
                if (z3) {
                    cVar2.v(this.P0, f5, i10, i11, i12);
                } else {
                    cVar2.g(this.P0, f5, i10, i11, i12);
                }
            }
        }
    }

    protected void H0(float f4) {
        RefreshState refreshState;
        RefreshState refreshState2 = this.V0;
        if (refreshState2 == RefreshState.TwoLevel && f4 > 0.0f) {
            G0(Math.min((int) f4, getMeasuredHeight()), false);
        } else if (refreshState2 == RefreshState.Refreshing && f4 >= 0.0f) {
            if (f4 < this.E0) {
                G0((int) f4, false);
            } else {
                double d4 = this.I0;
                int max = Math.max((this.f47865g * 4) / 3, getHeight());
                int i4 = this.E0;
                double d5 = max - i4;
                double max2 = Math.max(0.0f, (f4 - i4) * this.f47872l);
                Double.isNaN(max2);
                Double.isNaN(d5);
                Double.isNaN(d4);
                G0(((int) Math.min(d4 * (1.0d - Math.pow(100.0d, (-max2) / d5)), max2)) + this.E0, false);
            }
        } else if (f4 >= 0.0f || !(refreshState2 == RefreshState.Loading || ((this.C && this.N) || (this.G && T() && !this.N)))) {
            if (f4 >= 0.0f) {
                double d6 = this.I0 + this.E0;
                double max3 = Math.max(this.f47865g / 2, getHeight());
                double max4 = Math.max(0.0f, this.f47872l * f4);
                Double.isNaN(max4);
                Double.isNaN(max3);
                Double.isNaN(d6);
                G0((int) Math.min(d6 * (1.0d - Math.pow(100.0d, (-max4) / max3)), max4), false);
            } else {
                double d7 = this.J0 + this.G0;
                double max5 = Math.max(this.f47865g / 2, getHeight());
                double d8 = -Math.min(0.0f, this.f47872l * f4);
                Double.isNaN(d8);
                Double.isNaN(max5);
                Double.isNaN(d7);
                G0((int) (-Math.min(d7 * (1.0d - Math.pow(100.0d, (-d8) / max5)), d8)), false);
            }
        } else if (f4 > (-this.G0)) {
            G0((int) f4, false);
        } else {
            double d9 = this.J0;
            int max6 = Math.max((this.f47865g * 4) / 3, getHeight());
            int i5 = this.G0;
            double d10 = max6 - i5;
            double d11 = -Math.min(0.0f, (i5 + f4) * this.f47872l);
            Double.isNaN(d11);
            Double.isNaN(d10);
            Double.isNaN(d9);
            G0(((int) (-Math.min(d9 * (1.0d - Math.pow(100.0d, (-d11) / d10)), d11))) - this.G0, false);
        }
        if (!this.G || !T() || f4 >= 0.0f || (refreshState = this.V0) == RefreshState.Refreshing || refreshState == RefreshState.Loading || refreshState == RefreshState.LoadFinish || this.N) {
            return;
        }
        w1();
    }

    protected void I0(RefreshState refreshState) {
        RefreshState refreshState2 = this.V0;
        if (refreshState2 != refreshState) {
            this.V0 = refreshState;
            this.W0 = refreshState;
            j1.d dVar = this.P0;
            if (dVar != null) {
                dVar.p(this, refreshState2, refreshState);
            }
            j1.e eVar = this.O0;
            if (eVar != null) {
                eVar.p(this, refreshState2, refreshState);
            }
            k1.c cVar = this.T;
            if (cVar != null) {
                cVar.p(this, refreshState2, refreshState);
            }
        }
    }

    protected boolean J0() {
        RefreshState refreshState = this.V0;
        if (refreshState == RefreshState.TwoLevel) {
            if (this.f47884w.getYVelocity() > -1000.0f && this.f47855b > getMeasuredHeight() / 2) {
                ValueAnimator n02 = n0(getMeasuredHeight());
                if (n02 != null) {
                    n02.setDuration(this.f47861e);
                }
            } else if (this.f47873m) {
                this.T0.d();
            }
            return this.f47873m;
        } else if (refreshState != RefreshState.Loading && ((!this.G || !T() || this.N || this.f47855b >= 0 || this.V0 == RefreshState.Refreshing) && (!this.C || !this.N || this.f47855b >= 0))) {
            RefreshState refreshState2 = this.V0;
            if (refreshState2 == RefreshState.Refreshing) {
                int i4 = this.f47855b;
                int i5 = this.E0;
                if (i4 > i5) {
                    this.f47877p0 = i5;
                    n0(i5);
                    return true;
                } else if (i4 < 0) {
                    this.f47877p0 = 0;
                    n0(0);
                    return true;
                } else {
                    return false;
                }
            } else if (refreshState2 == RefreshState.PullDownToRefresh) {
                y1();
                return true;
            } else if (refreshState2 == RefreshState.PullToUpLoad) {
                A1();
                return true;
            } else if (refreshState2 == RefreshState.ReleaseToRefresh) {
                C1();
                return true;
            } else if (refreshState2 == RefreshState.ReleaseToLoad) {
                x1();
                return true;
            } else if (refreshState2 == RefreshState.ReleaseToTwoLevel) {
                I0(RefreshState.TwoLevelReleased);
                return true;
            } else if (this.f47855b != 0) {
                n0(0);
                return true;
            } else {
                return false;
            }
        } else {
            int i6 = this.f47855b;
            int i7 = this.G0;
            if (i6 < (-i7)) {
                this.f47877p0 = -i7;
                n0(-i7);
                return true;
            } else if (i6 > 0) {
                this.f47877p0 = 0;
                n0(0);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override // j1.h
    public j1.h K(boolean z3) {
        setNestedScrollingEnabled(z3);
        return this;
    }

    @Override // j1.h
    /* renamed from: K0 */
    public SmartRefreshLayout u() {
        c(false);
        return this;
    }

    @Override // j1.h
    public boolean L(int i4) {
        int i5 = this.f47863f;
        int i6 = this.E0;
        return i(i4, i5, (((this.I0 / 2) + i6) * 1.0f) / i6);
    }

    protected void L0() {
        RefreshState refreshState = this.V0;
        RefreshState refreshState2 = RefreshState.None;
        if (refreshState != refreshState2 && this.f47855b == 0) {
            I0(refreshState2);
        }
        if (this.f47855b != 0) {
            n0(0);
        }
    }

    @Override // j1.h
    /* renamed from: M0 */
    public SmartRefreshLayout i0(boolean z3) {
        this.M = z3;
        return this;
    }

    @Override // j1.h
    /* renamed from: N0 */
    public SmartRefreshLayout d(boolean z3) {
        this.f47852L = z3;
        return this;
    }

    @Override // j1.h
    /* renamed from: O0 */
    public SmartRefreshLayout k0(float f4) {
        this.f47872l = f4;
        return this;
    }

    @Override // j1.h
    /* renamed from: P0 */
    public SmartRefreshLayout r(boolean z3) {
        this.G = z3;
        return this;
    }

    @Override // j1.h
    /* renamed from: Q0 */
    public SmartRefreshLayout J(boolean z3) {
        this.C = z3;
        return this;
    }

    @Override // j1.h
    public boolean R() {
        return this.V0 == RefreshState.Refreshing;
    }

    @Override // j1.h
    /* renamed from: R0 */
    public SmartRefreshLayout l(boolean z3) {
        this.B = z3;
        return this;
    }

    @Override // j1.h
    /* renamed from: S0 */
    public SmartRefreshLayout E(boolean z3) {
        this.A = z3;
        this.Q = true;
        return this;
    }

    @Override // j1.h
    public boolean T() {
        return this.f47887z && !this.H;
    }

    @Override // j1.h
    /* renamed from: T0 */
    public SmartRefreshLayout O(boolean z3) {
        this.O = true;
        this.f47887z = z3;
        return this;
    }

    @Override // j1.h
    /* renamed from: U0 */
    public SmartRefreshLayout b(boolean z3) {
        this.K = z3;
        j1.c cVar = this.Q0;
        if (cVar != null) {
            cVar.b(z3);
        }
        return this;
    }

    @Override // j1.h
    /* renamed from: V0 */
    public SmartRefreshLayout N(boolean z3) {
        this.E = z3;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.scwang.smartrefresh.layout.impl.a, j1.c] */
    @Override // j1.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public j1.h W(android.view.View r3, int r4, int r5) {
        /*
            r2 = this;
            if (r3 == 0) goto L8e
            j1.c r0 = r2.Q0
            if (r0 == 0) goto Ld
            android.view.View r0 = r0.getView()
            r2.removeView(r0)
        Ld:
            r0 = 0
            com.scwang.smartrefresh.layout.SmartRefreshLayout$o r1 = new com.scwang.smartrefresh.layout.SmartRefreshLayout$o
            r1.<init>(r4, r5)
            r2.addView(r3, r0, r1)
            j1.e r4 = r2.O0
            if (r4 == 0) goto L39
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r4 = r4.getSpinnerStyle()
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r5 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.FixedBehind
            if (r4 != r5) goto L39
            r2.bringChildToFront(r3)
            j1.d r4 = r2.P0
            if (r4 == 0) goto L5b
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r4 = r4.getSpinnerStyle()
            if (r4 == r5) goto L5b
            j1.d r4 = r2.P0
            android.view.View r4 = r4.getView()
            r2.bringChildToFront(r4)
            goto L5b
        L39:
            j1.d r4 = r2.P0
            if (r4 == 0) goto L5b
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r4 = r4.getSpinnerStyle()
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r5 = com.scwang.smartrefresh.layout.constant.SpinnerStyle.FixedBehind
            if (r4 != r5) goto L5b
            r2.bringChildToFront(r3)
            j1.e r4 = r2.O0
            if (r4 == 0) goto L5b
            com.scwang.smartrefresh.layout.constant.SpinnerStyle r4 = r4.getSpinnerStyle()
            if (r4 != r5) goto L5b
            j1.e r4 = r2.O0
            android.view.View r4 = r4.getView()
            r2.bringChildToFront(r4)
        L5b:
            com.scwang.smartrefresh.layout.impl.a r4 = new com.scwang.smartrefresh.layout.impl.a
            r4.<init>(r3)
            r2.Q0 = r4
            android.os.Handler r3 = r2.S0
            if (r3 == 0) goto L8e
            int r3 = r2.f47879r
            r4 = 0
            if (r3 <= 0) goto L70
            android.view.View r3 = r2.findViewById(r3)
            goto L71
        L70:
            r3 = r4
        L71:
            int r5 = r2.f47880s
            if (r5 <= 0) goto L79
            android.view.View r4 = r2.findViewById(r5)
        L79:
            j1.c r5 = r2.Q0
            j1.i r0 = r2.U
            r5.a(r0)
            j1.c r5 = r2.Q0
            boolean r0 = r2.K
            r5.b(r0)
            j1.c r5 = r2.Q0
            j1.g r0 = r2.T0
            r5.h(r0, r3, r4)
        L8e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.W(android.view.View, int, int):j1.h");
    }

    @Override // j1.h
    /* renamed from: W0 */
    public SmartRefreshLayout s(boolean z3) {
        this.F = z3;
        return this;
    }

    @Override // j1.h
    public boolean X() {
        return this.f47886y && !this.H;
    }

    @Override // j1.h
    /* renamed from: X0 */
    public SmartRefreshLayout A(boolean z3) {
        this.H = z3;
        return this;
    }

    @Override // j1.h
    /* renamed from: Y0 */
    public SmartRefreshLayout b0(boolean z3) {
        this.f47886y = z3;
        return this;
    }

    @Override // j1.h
    /* renamed from: Z0 */
    public SmartRefreshLayout F(boolean z3) {
        this.I = z3;
        return this;
    }

    @Override // j1.h
    public j1.h a(j1.i iVar) {
        this.U = iVar;
        j1.c cVar = this.Q0;
        if (cVar != null) {
            cVar.a(iVar);
        }
        return this;
    }

    @Override // j1.h
    public boolean a0() {
        return L(this.S0 == null ? 400 : 0);
    }

    @Override // j1.h
    /* renamed from: a1 */
    public SmartRefreshLayout I(boolean z3) {
        this.J = z3;
        return this;
    }

    @Override // j1.h
    /* renamed from: b1 */
    public SmartRefreshLayout n(float f4) {
        return t(com.scwang.smartrefresh.layout.util.c.b(f4));
    }

    @Override // j1.h
    /* renamed from: c1 */
    public SmartRefreshLayout t(int i4) {
        if (this.H0.canReplaceWith(DimensionStatus.CodeExact)) {
            this.G0 = i4;
            this.J0 = (int) Math.max(i4 * (this.L0 - 1.0f), 0.0f);
            this.H0 = DimensionStatus.CodeExactUnNotify;
            j1.d dVar = this.P0;
            if (dVar != null) {
                dVar.getView().requestLayout();
            }
        }
        return this;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof o;
    }

    @Override // android.view.View
    public void computeScroll() {
        int currY = this.f47883v.getCurrY();
        if (this.f47883v.computeScrollOffset()) {
            int finalY = this.f47883v.getFinalY();
            if ((finalY > 0 && this.Q0.p()) || (finalY < 0 && this.Q0.m())) {
                if (this.X0) {
                    int currVelocity = (int) this.f47883v.getCurrVelocity();
                    AnimationUtils.currentAnimationTimeMillis();
                    int abs = (Math.abs(this.f47883v.getCurrY() - currY) * 1000) / currVelocity;
                    if (finalY > 0) {
                        if (T() || this.F) {
                            if (this.G && T() && !this.N) {
                                double d4 = this.G0;
                                double d5 = currVelocity;
                                Double.isNaN(d5);
                                double d6 = this.f47882u;
                                Double.isNaN(d6);
                                double pow = Math.pow((d5 * 1.0d) / d6, 0.5d);
                                Double.isNaN(d4);
                                q0(-((int) (d4 * pow)));
                                RefreshState refreshState = this.V0;
                                if (!refreshState.opening && refreshState != RefreshState.Loading && refreshState != RefreshState.LoadFinish) {
                                    w1();
                                }
                            } else if (this.E) {
                                double d7 = this.G0;
                                double d8 = currVelocity;
                                Double.isNaN(d8);
                                double d9 = this.f47882u;
                                Double.isNaN(d9);
                                double pow2 = Math.pow((d8 * 1.0d) / d9, 0.5d);
                                Double.isNaN(d7);
                                q0(-((int) (d7 * pow2)));
                            }
                        }
                    } else if ((X() || this.F) && this.E) {
                        double d10 = this.E0;
                        double d11 = currVelocity;
                        Double.isNaN(d11);
                        double d12 = this.f47882u;
                        Double.isNaN(d12);
                        double pow3 = Math.pow((d11 * 1.0d) / d12, 0.5d);
                        Double.isNaN(d10);
                        q0((int) (d10 * pow3));
                    }
                    this.X0 = false;
                }
                this.f47883v.forceFinished(true);
                return;
            }
            this.X0 = true;
            invalidate();
        }
    }

    @Override // j1.h
    /* renamed from: d1 */
    public SmartRefreshLayout Q(float f4) {
        this.L0 = f4;
        int max = (int) Math.max(this.G0 * (f4 - 1.0f), 0.0f);
        this.J0 = max;
        j1.d dVar = this.P0;
        if (dVar != null && this.S0 != null) {
            dVar.f(this.T0, this.G0, max);
        } else {
            this.H0 = this.H0.unNotify();
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i4;
        boolean z3 = this.D && isInEditMode();
        if (X() && (i4 = this.f47854a1) != 0 && (this.f47855b > 0 || z3)) {
            this.R0.setColor(i4);
            canvas.drawRect(0.0f, 0.0f, getWidth(), z3 ? this.E0 : this.f47855b, this.R0);
        } else if (T() && this.f47856b1 != 0 && (this.f47855b < 0 || z3)) {
            int height = getHeight();
            this.R0.setColor(this.f47856b1);
            canvas.drawRect(0.0f, height - (z3 ? this.G0 : -this.f47855b), getWidth(), height, this.R0);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f4, float f5, boolean z3) {
        return this.C0.dispatchNestedFling(f4, f5, z3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f4, float f5) {
        return this.C0.dispatchNestedPreFling(f4, f5);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i4, int i5, int[] iArr, int[] iArr2) {
        return this.C0.dispatchNestedPreScroll(i4, i5, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr) {
        return this.C0.dispatchNestedScroll(i4, i5, i6, i7, iArr);
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

    @Override // j1.h
    public j1.h e(View view) {
        return W(view, -1, -1);
    }

    @Override // j1.h
    /* renamed from: e1 */
    public SmartRefreshLayout k(float f4) {
        this.N0 = f4;
        return this;
    }

    @Override // j1.h
    public boolean f() {
        return this.H;
    }

    @Override // j1.h
    public boolean f0(int i4) {
        int i5 = this.f47863f;
        int i6 = this.G0;
        return v(i4, i5, (((this.J0 / 2) + i6) * 1.0f) / i6);
    }

    @Override // j1.h
    /* renamed from: f1 */
    public SmartRefreshLayout G(float f4) {
        return B(com.scwang.smartrefresh.layout.util.c.b(f4));
    }

    @Override // j1.h
    /* renamed from: g1 */
    public SmartRefreshLayout B(int i4) {
        if (this.F0.canReplaceWith(DimensionStatus.CodeExact)) {
            this.E0 = i4;
            this.I0 = (int) Math.max(i4 * (this.K0 - 1.0f), 0.0f);
            this.F0 = DimensionStatus.CodeExactUnNotify;
            j1.e eVar = this.O0;
            if (eVar != null) {
                eVar.getView().requestLayout();
            }
        }
        return this;
    }

    @Override // j1.h
    public SmartRefreshLayout getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.D0.getNestedScrollAxes();
    }

    @Override // j1.h
    @Nullable
    public j1.d getRefreshFooter() {
        return this.P0;
    }

    @Override // j1.h
    @Nullable
    public j1.e getRefreshHeader() {
        return this.O0;
    }

    @Override // j1.h
    public RefreshState getState() {
        return this.V0;
    }

    protected RefreshState getViceState() {
        return this.W0;
    }

    @Override // j1.h
    public boolean h0() {
        return this.I;
    }

    @Override // j1.h
    /* renamed from: h1 */
    public SmartRefreshLayout Y(float f4) {
        this.K0 = f4;
        int max = (int) Math.max(this.E0 * (f4 - 1.0f), 0.0f);
        this.I0 = max;
        j1.e eVar = this.O0;
        if (eVar != null && this.S0 != null) {
            eVar.f(this.T0, this.E0, max);
        } else {
            this.F0 = this.F0.unNotify();
        }
        return this;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.C0.hasNestedScrollingParent();
    }

    @Override // j1.h
    public boolean i(int i4, int i5, float f4) {
        if (this.V0 == RefreshState.None && X()) {
            ValueAnimator valueAnimator = this.f47864f1;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            c cVar = new c(f4, i5);
            if (i4 > 0) {
                this.f47864f1 = new ValueAnimator();
                postDelayed(cVar, i4);
                return true;
            }
            cVar.run();
            return true;
        }
        return false;
    }

    @Override // j1.h
    /* renamed from: i1 */
    public SmartRefreshLayout z(float f4) {
        this.M0 = f4;
        return this;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.C0.isNestedScrollingEnabled();
    }

    @Override // j1.h
    public boolean j() {
        return this.E;
    }

    @Override // j1.h
    public boolean j0() {
        return this.N;
    }

    @Override // j1.h
    /* renamed from: j1 */
    public SmartRefreshLayout c(boolean z3) {
        this.N = z3;
        j1.d dVar = this.P0;
        if (dVar != null) {
            dVar.c(z3);
        }
        return this;
    }

    @Override // j1.h
    /* renamed from: k1 */
    public SmartRefreshLayout g(k1.b bVar) {
        this.S = bVar;
        this.f47887z = this.f47887z || !(this.O || bVar == null);
        return this;
    }

    @Override // j1.h
    /* renamed from: l1 */
    public SmartRefreshLayout o(k1.c cVar) {
        this.T = cVar;
        return this;
    }

    @Override // j1.h
    /* renamed from: m1 */
    public SmartRefreshLayout H(k1.d dVar) {
        this.R = dVar;
        return this;
    }

    protected ValueAnimator n0(int i4) {
        return o0(i4, 0);
    }

    @Override // j1.h
    /* renamed from: n1 */
    public SmartRefreshLayout M(k1.e eVar) {
        this.R = eVar;
        this.S = eVar;
        this.f47887z = this.f47887z || !(this.O || eVar == null);
        return this;
    }

    protected ValueAnimator o0(int i4, int i5) {
        return p0(i4, i5, this.f47878q);
    }

    @Override // j1.h
    /* renamed from: o1 */
    public SmartRefreshLayout setPrimaryColors(int... iArr) {
        j1.e eVar = this.O0;
        if (eVar != null) {
            eVar.setPrimaryColors(iArr);
        }
        j1.d dVar = this.P0;
        if (dVar != null) {
            dVar.setPrimaryColors(iArr);
        }
        this.f47885x = iArr;
        return this;
    }

    /* JADX WARN: Type inference failed for: r0v25, types: [com.scwang.smartrefresh.layout.SmartRefreshLayout$i, k1.b] */
    /* JADX WARN: Type inference failed for: r0v26, types: [com.scwang.smartrefresh.layout.SmartRefreshLayout$h, k1.d] */
    /* JADX WARN: Type inference failed for: r0v34, types: [com.scwang.smartrefresh.layout.impl.a, j1.c] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.scwang.smartrefresh.layout.impl.a, j1.c] */
    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        j1.c cVar;
        j1.d dVar;
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        if (this.S0 == null) {
            this.S0 = new Handler();
        }
        List<com.scwang.smartrefresh.layout.util.b> list = this.U0;
        if (list != null) {
            for (com.scwang.smartrefresh.layout.util.b bVar : list) {
                this.S0.postDelayed(bVar, bVar.f48077a);
            }
            this.U0.clear();
            this.U0 = null;
        }
        if (this.O0 == null) {
            j1.e a4 = f47851k1.a(getContext(), this);
            this.O0 = a4;
            if (!(a4.getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                if (this.O0.getSpinnerStyle() == SpinnerStyle.Scale) {
                    addView(this.O0.getView(), -1, -1);
                } else {
                    addView(this.O0.getView(), -1, -2);
                }
            }
        }
        if (this.P0 == null) {
            j1.d a5 = f47850j1.a(getContext(), this);
            this.P0 = a5;
            this.f47887z = this.f47887z || (!this.O && f47849i1);
            if (!(a5.getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                if (this.P0.getSpinnerStyle() == SpinnerStyle.Scale) {
                    addView(this.P0.getView(), -1, -1);
                } else {
                    addView(this.P0.getView(), -1, -2);
                }
            }
        }
        int childCount = getChildCount();
        int i4 = 0;
        while (true) {
            cVar = this.Q0;
            if (cVar != null || i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            j1.e eVar = this.O0;
            if ((eVar == null || childAt != eVar.getView()) && ((dVar = this.P0) == null || childAt != dVar.getView())) {
                this.Q0 = new com.scwang.smartrefresh.layout.impl.a(childAt);
            }
            i4++;
        }
        if (cVar == null) {
            this.Q0 = new com.scwang.smartrefresh.layout.impl.a(getContext());
        }
        int i5 = this.f47879r;
        View findViewById = i5 > 0 ? findViewById(i5) : null;
        int i6 = this.f47880s;
        View findViewById2 = i6 > 0 ? findViewById(i6) : null;
        this.Q0.a(this.U);
        this.Q0.b(this.K);
        this.Q0.h(this.T0, findViewById, findViewById2);
        if (this.f47855b != 0) {
            I0(RefreshState.None);
            j1.c cVar2 = this.Q0;
            this.f47855b = 0;
            cVar2.e(0);
        }
        bringChildToFront(this.Q0.getView());
        SpinnerStyle spinnerStyle = this.O0.getSpinnerStyle();
        SpinnerStyle spinnerStyle2 = SpinnerStyle.FixedBehind;
        if (spinnerStyle != spinnerStyle2) {
            bringChildToFront(this.O0.getView());
        }
        if (this.P0.getSpinnerStyle() != spinnerStyle2) {
            bringChildToFront(this.P0.getView());
        }
        if (this.R == null) {
            this.R = new h();
        }
        if (this.S == null) {
            this.S = new i();
        }
        int[] iArr = this.f47885x;
        if (iArr != null) {
            this.O0.setPrimaryColors(iArr);
            this.P0.setPrimaryColors(this.f47885x);
        }
        if (this.P || isNestedScrollingEnabled()) {
            return;
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof NestedScrollingParent) {
                setNestedScrollingEnabled(true);
                this.P = false;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        G0(0, false);
        I0(RefreshState.None);
        this.S0.removeCallbacksAndMessages(null);
        this.S0 = null;
        this.O = true;
        this.P = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.scwang.smartrefresh.layout.impl.a, j1.c] */
    /* JADX WARN: Type inference failed for: r6v12, types: [com.scwang.smartrefresh.layout.impl.b, j1.d] */
    /* JADX WARN: Type inference failed for: r6v15, types: [com.scwang.smartrefresh.layout.impl.a, j1.c] */
    /* JADX WARN: Type inference failed for: r6v17, types: [com.scwang.smartrefresh.layout.impl.c, j1.e] */
    /* JADX WARN: Type inference failed for: r6v19, types: [com.scwang.smartrefresh.layout.impl.a, j1.c] */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.scwang.smartrefresh.layout.impl.b, j1.d] */
    /* JADX WARN: Type inference failed for: r6v8, types: [com.scwang.smartrefresh.layout.impl.a, j1.c] */
    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount <= 3) {
            boolean[] zArr = new boolean[childCount];
            int i4 = 0;
            while (true) {
                boolean z3 = true;
                if (i4 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i4);
                if ((childAt instanceof j1.e) && this.O0 == null) {
                    this.O0 = (j1.e) childAt;
                } else if ((childAt instanceof j1.d) && this.P0 == null) {
                    if (!this.f47887z && this.O) {
                        z3 = false;
                    }
                    this.f47887z = z3;
                    this.P0 = (j1.d) childAt;
                } else if (this.Q0 == null && ((childAt instanceof AbsListView) || (childAt instanceof WebView) || (childAt instanceof ScrollView) || (childAt instanceof ScrollingView) || (childAt instanceof NestedScrollingChild) || (childAt instanceof NestedScrollingParent) || (childAt instanceof ViewPager))) {
                    this.Q0 = new com.scwang.smartrefresh.layout.impl.a(childAt);
                } else {
                    zArr[i4] = true;
                }
                i4++;
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                if (zArr[i5]) {
                    View childAt2 = getChildAt(i5);
                    if (childCount == 1 && this.Q0 == null) {
                        this.Q0 = new com.scwang.smartrefresh.layout.impl.a(childAt2);
                    } else if (i5 == 0 && this.O0 == null) {
                        this.O0 = new com.scwang.smartrefresh.layout.impl.c(childAt2);
                    } else if (childCount == 2 && this.Q0 == null) {
                        this.Q0 = new com.scwang.smartrefresh.layout.impl.a(childAt2);
                    } else if (i5 == 2 && this.P0 == null) {
                        this.f47887z = this.f47887z || !this.O;
                        this.P0 = new com.scwang.smartrefresh.layout.impl.b(childAt2);
                    } else if (this.Q0 == null) {
                        this.Q0 = new com.scwang.smartrefresh.layout.impl.a(childAt2);
                    } else if (i5 == 1 && childCount == 2 && this.P0 == null) {
                        this.f47887z = this.f47887z || !this.O;
                        this.P0 = new com.scwang.smartrefresh.layout.impl.b(childAt2);
                    }
                }
            }
            if (isInEditMode()) {
                int[] iArr = this.f47885x;
                if (iArr != null) {
                    j1.e eVar = this.O0;
                    if (eVar != null) {
                        eVar.setPrimaryColors(iArr);
                    }
                    j1.d dVar = this.P0;
                    if (dVar != null) {
                        dVar.setPrimaryColors(this.f47885x);
                    }
                }
                j1.c cVar = this.Q0;
                if (cVar != null) {
                    bringChildToFront(cVar.getView());
                }
                j1.e eVar2 = this.O0;
                if (eVar2 != null && eVar2.getSpinnerStyle() != SpinnerStyle.FixedBehind) {
                    bringChildToFront(this.O0.getView());
                }
                j1.d dVar2 = this.P0;
                if (dVar2 == null || dVar2.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                    return;
                }
                bringChildToFront(this.P0.getView());
                return;
            }
            return;
        }
        throw new RuntimeException("\u6700\u591a\u53ea\u652f\u63013\u4e2a\u5b50View\uff0cMost only support three sub view");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        int i8;
        int max;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            j1.c cVar = this.Q0;
            boolean z4 = true;
            if (cVar != null && cVar.getView() == childAt) {
                boolean z5 = isInEditMode() && this.D;
                o oVar = (o) this.Q0.getLayoutParams();
                int i10 = ((ViewGroup.MarginLayoutParams) oVar).leftMargin + paddingLeft;
                int i11 = ((ViewGroup.MarginLayoutParams) oVar).topMargin + paddingTop;
                int j4 = this.Q0.j() + i10;
                int c4 = this.Q0.c() + i11;
                if (z5 && X() && (this.A || this.O0.getSpinnerStyle() == SpinnerStyle.FixedBehind)) {
                    int i12 = this.E0;
                    i11 += i12;
                    c4 += i12;
                }
                this.Q0.i(i10, i11, j4, c4);
            }
            j1.e eVar = this.O0;
            if (eVar != null && eVar.getView() == childAt) {
                boolean z6 = isInEditMode() && this.D && X();
                View view = this.O0.getView();
                o oVar2 = (o) view.getLayoutParams();
                int i13 = ((ViewGroup.MarginLayoutParams) oVar2).leftMargin;
                int i14 = ((ViewGroup.MarginLayoutParams) oVar2).topMargin;
                int measuredWidth = view.getMeasuredWidth() + i13;
                int measuredHeight = view.getMeasuredHeight() + i14;
                if (!z6) {
                    if (this.O0.getSpinnerStyle() == SpinnerStyle.Translate) {
                        i14 -= this.E0;
                        max = view.getMeasuredHeight();
                    } else if (this.O0.getSpinnerStyle() == SpinnerStyle.Scale) {
                        max = Math.max(Math.max(0, X() ? this.f47855b : 0) - ((ViewGroup.MarginLayoutParams) oVar2).bottomMargin, 0);
                    }
                    measuredHeight = i14 + max;
                }
                view.layout(i13, i14, measuredWidth, measuredHeight);
            }
            j1.d dVar = this.P0;
            if (dVar != null && dVar.getView() == childAt) {
                z4 = (isInEditMode() && this.D && T()) ? false : false;
                View view2 = this.P0.getView();
                o oVar3 = (o) view2.getLayoutParams();
                SpinnerStyle spinnerStyle = this.P0.getSpinnerStyle();
                int i15 = ((ViewGroup.MarginLayoutParams) oVar3).leftMargin;
                int measuredHeight2 = (((ViewGroup.MarginLayoutParams) oVar3).topMargin + getMeasuredHeight()) - ((ViewGroup.MarginLayoutParams) oVar3).bottomMargin;
                if (!z4 && spinnerStyle != SpinnerStyle.FixedFront && spinnerStyle != SpinnerStyle.FixedBehind) {
                    if (spinnerStyle == SpinnerStyle.Scale) {
                        i8 = Math.max(Math.max(T() ? -this.f47855b : 0, 0) - ((ViewGroup.MarginLayoutParams) oVar3).topMargin, 0);
                    }
                    view2.layout(i15, measuredHeight2, view2.getMeasuredWidth() + i15, view2.getMeasuredHeight() + measuredHeight2);
                } else {
                    i8 = this.G0;
                }
                measuredHeight2 -= i8;
                view2.layout(i15, measuredHeight2, view2.getMeasuredWidth() + i15, view2.getMeasuredHeight() + measuredHeight2);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        boolean z3 = isInEditMode() && this.D;
        int childCount = getChildCount();
        int i11 = 0;
        int i12 = 0;
        while (i11 < childCount) {
            View childAt = getChildAt(i11);
            j1.e eVar = this.O0;
            if (eVar != null && eVar.getView() == childAt) {
                View view = this.O0.getView();
                o oVar = (o) view.getLayoutParams();
                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, ((ViewGroup.MarginLayoutParams) oVar).leftMargin + ((ViewGroup.MarginLayoutParams) oVar).rightMargin, ((ViewGroup.MarginLayoutParams) oVar).width);
                if (this.F0.gteReplaceWith(DimensionStatus.XmlLayoutUnNotify)) {
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(this.E0 - ((ViewGroup.MarginLayoutParams) oVar).bottomMargin, i10), 1073741824));
                } else if (this.O0.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
                    if (this.F0.notifyed) {
                        i9 = 0;
                    } else {
                        measureChild(view, childMeasureSpec, i5);
                        i9 = view.getMeasuredHeight();
                    }
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i5), 1073741824));
                    if (i9 > 0 && i9 != view.getMeasuredHeight()) {
                        this.E0 = i9 + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin;
                    }
                } else {
                    int i13 = ((ViewGroup.MarginLayoutParams) oVar).height;
                    if (i13 > 0) {
                        DimensionStatus dimensionStatus = this.F0;
                        DimensionStatus dimensionStatus2 = DimensionStatus.XmlExactUnNotify;
                        if (dimensionStatus.canReplaceWith(dimensionStatus2)) {
                            this.E0 = ((ViewGroup.MarginLayoutParams) oVar).height + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin;
                            this.F0 = dimensionStatus2;
                        }
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) oVar).height, 1073741824));
                    } else if (i13 == -2) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(View.MeasureSpec.getSize(i5) - ((ViewGroup.MarginLayoutParams) oVar).bottomMargin, 0), Integer.MIN_VALUE));
                        int measuredHeight = view.getMeasuredHeight();
                        if (measuredHeight > 0) {
                            DimensionStatus dimensionStatus3 = this.F0;
                            DimensionStatus dimensionStatus4 = DimensionStatus.XmlWrapUnNotify;
                            if (dimensionStatus3.canReplaceWith(dimensionStatus4)) {
                                this.F0 = dimensionStatus4;
                                this.E0 = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin;
                            }
                        }
                        if (measuredHeight <= 0) {
                            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(this.E0 - ((ViewGroup.MarginLayoutParams) oVar).bottomMargin, 0), 1073741824));
                        }
                    } else if (i13 == -1) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(this.E0 - ((ViewGroup.MarginLayoutParams) oVar).bottomMargin, 0), 1073741824));
                    } else {
                        view.measure(childMeasureSpec, i5);
                    }
                }
                if (this.O0.getSpinnerStyle() == SpinnerStyle.Scale && !z3) {
                    view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max(Math.max(0, X() ? this.f47855b : 0) - ((ViewGroup.MarginLayoutParams) oVar).bottomMargin, 0), 1073741824));
                }
                DimensionStatus dimensionStatus5 = this.F0;
                if (!dimensionStatus5.notifyed) {
                    this.F0 = dimensionStatus5.notifyed();
                    int max = (int) Math.max(this.E0 * (this.K0 - 1.0f), 0.0f);
                    this.I0 = max;
                    this.O0.f(this.T0, this.E0, max);
                }
                if (z3 && X()) {
                    i12 += view.getMeasuredHeight();
                }
            }
            j1.d dVar = this.P0;
            if (dVar != null && dVar.getView() == childAt) {
                View view2 = this.P0.getView();
                o oVar2 = (o) view2.getLayoutParams();
                int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, ((ViewGroup.MarginLayoutParams) oVar2).leftMargin + ((ViewGroup.MarginLayoutParams) oVar2).rightMargin, ((ViewGroup.MarginLayoutParams) oVar2).width);
                if (this.H0.gteReplaceWith(DimensionStatus.XmlLayoutUnNotify)) {
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max(this.G0 - ((ViewGroup.MarginLayoutParams) oVar2).topMargin, 0), 1073741824));
                } else if (this.P0.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
                    if (this.H0.notifyed) {
                        i6 = 0;
                    } else {
                        measureChild(view2, childMeasureSpec2, i5);
                        i6 = view2.getMeasuredHeight();
                    }
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i5), 1073741824));
                    if (i6 > 0 && i6 != view2.getMeasuredHeight()) {
                        this.E0 = i6 + ((ViewGroup.MarginLayoutParams) oVar2).bottomMargin;
                    }
                } else {
                    int i14 = ((ViewGroup.MarginLayoutParams) oVar2).height;
                    if (i14 > 0) {
                        DimensionStatus dimensionStatus6 = this.H0;
                        DimensionStatus dimensionStatus7 = DimensionStatus.XmlExactUnNotify;
                        if (dimensionStatus6.canReplaceWith(dimensionStatus7)) {
                            this.G0 = ((ViewGroup.MarginLayoutParams) oVar2).height + ((ViewGroup.MarginLayoutParams) oVar2).topMargin;
                            this.H0 = dimensionStatus7;
                        }
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) oVar2).height, 1073741824));
                    } else if (i14 == -2) {
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max(View.MeasureSpec.getSize(i5) - ((ViewGroup.MarginLayoutParams) oVar2).topMargin, 0), Integer.MIN_VALUE));
                        int measuredHeight2 = view2.getMeasuredHeight();
                        if (measuredHeight2 > 0) {
                            DimensionStatus dimensionStatus8 = this.H0;
                            DimensionStatus dimensionStatus9 = DimensionStatus.XmlWrapUnNotify;
                            if (dimensionStatus8.canReplaceWith(dimensionStatus9)) {
                                this.H0 = dimensionStatus9;
                                this.G0 = view2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) oVar2).topMargin;
                            }
                        }
                        if (measuredHeight2 <= 0) {
                            view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max(this.G0 - ((ViewGroup.MarginLayoutParams) oVar2).topMargin, 0), 1073741824));
                        }
                    } else if (i14 == -1) {
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max(this.G0 - ((ViewGroup.MarginLayoutParams) oVar2).topMargin, 0), 1073741824));
                    } else {
                        view2.measure(childMeasureSpec2, i5);
                    }
                }
                if (this.P0.getSpinnerStyle() == SpinnerStyle.Scale && !z3) {
                    if (this.f47887z) {
                        i8 = -this.f47855b;
                        i7 = 0;
                    } else {
                        i7 = 0;
                        i8 = 0;
                    }
                    view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max(Math.max(i7, i8) - ((ViewGroup.MarginLayoutParams) oVar2).topMargin, i7), 1073741824));
                }
                DimensionStatus dimensionStatus10 = this.H0;
                if (!dimensionStatus10.notifyed) {
                    this.H0 = dimensionStatus10.notifyed();
                    int max2 = (int) Math.max(this.G0 * (this.L0 - 1.0f), 0.0f);
                    this.J0 = max2;
                    this.P0.f(this.T0, this.G0, max2);
                }
                if (z3 && this.f47887z) {
                    i12 += view2.getMeasuredHeight();
                }
            }
            j1.c cVar = this.Q0;
            if (cVar != null && cVar.getView() == childAt) {
                o oVar3 = (o) this.Q0.getLayoutParams();
                this.Q0.o(ViewGroup.getChildMeasureSpec(i4, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) oVar3).leftMargin + ((ViewGroup.MarginLayoutParams) oVar3).rightMargin, ((ViewGroup.MarginLayoutParams) oVar3).width), ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) oVar3).topMargin + ((ViewGroup.MarginLayoutParams) oVar3).bottomMargin + ((z3 && X() && (this.A || this.O0.getSpinnerStyle() == SpinnerStyle.FixedBehind)) ? this.E0 : 0) + ((z3 && T() && (this.B || this.P0.getSpinnerStyle() == SpinnerStyle.FixedBehind)) ? this.G0 : 0), ((ViewGroup.MarginLayoutParams) oVar3).height));
                this.Q0.f(this.E0, this.G0);
                i12 += this.Q0.c();
            }
            i11++;
            i10 = 0;
        }
        setMeasuredDimension(ViewGroup.resolveSize(getSuggestedMinimumWidth(), i4), ViewGroup.resolveSize(i12, i5));
        this.f47870j = getMeasuredWidth() / 2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f4, float f5, boolean z3) {
        return dispatchNestedFling(f4, f5, z3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f4, float f5) {
        RefreshState refreshState;
        if (this.f47855b != 0 && this.V0.opening) {
            n0(0);
        }
        return this.f47864f1 != null || (refreshState = this.V0) == RefreshState.ReleaseToRefresh || refreshState == RefreshState.ReleaseToLoad || (refreshState == RefreshState.PullDownToRefresh && this.f47855b > 0) || ((refreshState == RefreshState.PullToUpLoad && this.f47855b > 0) || dispatchNestedPreFling(f4, f5));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i4, int i5, @NonNull int[] iArr) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        if (this.V0.opening) {
            int[] iArr2 = this.V;
            if (dispatchNestedPreScroll(i4, i5, iArr2, null)) {
                i5 -= iArr2[1];
            }
            RefreshState refreshState = this.V0;
            if ((refreshState != RefreshState.Refreshing && refreshState != RefreshState.TwoLevel) || (this.f47877p0 * i5 <= 0 && this.f47859d <= 0)) {
                if (refreshState == RefreshState.Loading) {
                    if (this.f47877p0 * i5 > 0 || this.f47859d < 0) {
                        iArr[1] = 0;
                        if (Math.abs(i5) > Math.abs(this.f47877p0)) {
                            iArr[1] = iArr[1] + this.f47877p0;
                            this.f47877p0 = 0;
                            i10 = i5 - 0;
                            if (this.f47859d >= 0) {
                                H0(0.0f);
                            }
                        } else {
                            int i12 = this.f47877p0 - i5;
                            this.f47877p0 = i12;
                            iArr[1] = iArr[1] + i5;
                            H0(i12 + this.f47859d);
                            i10 = 0;
                        }
                        if (i10 >= 0 || (i11 = this.f47859d) >= 0) {
                            return;
                        }
                        if (i10 < i11) {
                            iArr[1] = iArr[1] + i11;
                            this.f47859d = 0;
                        } else {
                            this.f47859d = i11 - i10;
                            iArr[1] = iArr[1] + i10;
                        }
                        H0(this.f47859d);
                        return;
                    }
                    return;
                }
                return;
            }
            iArr[1] = 0;
            if (Math.abs(i5) > Math.abs(this.f47877p0)) {
                iArr[1] = iArr[1] + this.f47877p0;
                this.f47877p0 = 0;
                i8 = i5 - 0;
                if (this.f47859d <= 0) {
                    H0(0.0f);
                }
            } else {
                int i13 = this.f47877p0 - i5;
                this.f47877p0 = i13;
                iArr[1] = iArr[1] + i5;
                H0(i13 + this.f47859d);
                i8 = 0;
            }
            if (i8 <= 0 || (i9 = this.f47859d) <= 0) {
                return;
            }
            if (i8 > i9) {
                iArr[1] = iArr[1] + i9;
                this.f47859d = 0;
            } else {
                this.f47859d = i9 - i8;
                iArr[1] = iArr[1] + i8;
            }
            H0(this.f47859d);
            return;
        }
        if (X() && i5 > 0 && (i7 = this.f47877p0) > 0) {
            if (i5 > i7) {
                iArr[1] = i5 - i7;
                this.f47877p0 = 0;
            } else {
                this.f47877p0 = i7 - i5;
                iArr[1] = i5;
            }
            H0(this.f47877p0);
        } else if (T() && i5 < 0 && (i6 = this.f47877p0) < 0) {
            if (i5 < i6) {
                iArr[1] = i5 - i6;
                this.f47877p0 = 0;
            } else {
                this.f47877p0 = i6 - i5;
                iArr[1] = i5;
            }
            H0(this.f47877p0);
        }
        int[] iArr3 = this.V;
        if (dispatchNestedPreScroll(i4 - iArr[0], i5 - iArr[1], iArr3, null)) {
            iArr[0] = iArr[0] + iArr3[0];
            iArr[1] = iArr[1] + iArr3[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i4, int i5, int i6, int i7) {
        j1.c cVar;
        j1.c cVar2;
        dispatchNestedScroll(i4, i5, i6, i7, this.W);
        int i8 = i7 + this.W[1];
        if (this.V0.opening) {
            if (X() && i8 < 0 && ((cVar2 = this.Q0) == null || cVar2.m())) {
                int abs = this.f47877p0 + Math.abs(i8);
                this.f47877p0 = abs;
                H0(abs + this.f47859d);
            } else if (!T() || i8 <= 0) {
            } else {
                j1.c cVar3 = this.Q0;
                if (cVar3 == null || cVar3.p()) {
                    int abs2 = this.f47877p0 - Math.abs(i8);
                    this.f47877p0 = abs2;
                    H0(abs2 + this.f47859d);
                }
            }
        } else if (X() && i8 < 0 && ((cVar = this.Q0) == null || cVar.m())) {
            if (this.V0 == RefreshState.None) {
                z1();
            }
            int abs3 = this.f47877p0 + Math.abs(i8);
            this.f47877p0 = abs3;
            H0(abs3);
        } else if (!T() || i8 <= 0) {
        } else {
            j1.c cVar4 = this.Q0;
            if (cVar4 == null || cVar4.p()) {
                if (this.V0 == RefreshState.None && !this.N) {
                    B1();
                }
                int abs4 = this.f47877p0 - Math.abs(i8);
                this.f47877p0 = abs4;
                H0(abs4);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i4) {
        this.D0.onNestedScrollAccepted(view, view2, i4);
        startNestedScroll(i4 & 2);
        this.f47877p0 = 0;
        this.f47859d = this.f47855b;
        this.B0 = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i4) {
        return (isEnabled() && isNestedScrollingEnabled() && (i4 & 2) != 0) && (X() || T());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.D0.onStopNestedScroll(view);
        this.B0 = false;
        this.f47877p0 = 0;
        J0();
        stopNestedScroll();
    }

    @Override // j1.h
    public boolean p() {
        return f0(0);
    }

    protected ValueAnimator p0(int i4, int i5, Interpolator interpolator) {
        if (this.f47855b != i4) {
            ValueAnimator valueAnimator = this.f47864f1;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(this.f47855b, i4);
            this.f47864f1 = ofInt;
            ofInt.setDuration(this.f47863f);
            this.f47864f1.setInterpolator(interpolator);
            this.f47864f1.addUpdateListener(this.f47868h1);
            this.f47864f1.addListener(this.f47866g1);
            this.f47864f1.setStartDelay(i5);
            this.f47864f1.start();
            return this.f47864f1;
        }
        return null;
    }

    @Override // j1.h
    /* renamed from: p1 */
    public SmartRefreshLayout D(@ColorRes int... iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            iArr2[i4] = ContextCompat.getColor(getContext(), iArr[i4]);
        }
        setPrimaryColors(iArr2);
        return this;
    }

    @Override // android.view.View
    public boolean post(Runnable runnable) {
        Handler handler = this.S0;
        if (handler == null) {
            List<com.scwang.smartrefresh.layout.util.b> list = this.U0;
            if (list == null) {
                list = new ArrayList<>();
            }
            this.U0 = list;
            list.add(new com.scwang.smartrefresh.layout.util.b(runnable));
            return false;
        }
        return handler.post(new com.scwang.smartrefresh.layout.util.b(runnable));
    }

    @Override // android.view.View
    public boolean postDelayed(Runnable runnable, long j4) {
        if (j4 == 0) {
            new com.scwang.smartrefresh.layout.util.b(runnable).run();
            return true;
        }
        Handler handler = this.S0;
        if (handler == null) {
            List<com.scwang.smartrefresh.layout.util.b> list = this.U0;
            if (list == null) {
                list = new ArrayList<>();
            }
            this.U0 = list;
            list.add(new com.scwang.smartrefresh.layout.util.b(runnable, j4));
            return false;
        }
        return handler.postDelayed(new com.scwang.smartrefresh.layout.util.b(runnable), j4);
    }

    @Override // j1.h
    public boolean q() {
        return this.G;
    }

    protected ValueAnimator q0(int i4) {
        if (this.f47864f1 == null) {
            int i5 = (this.f47863f * 2) / 3;
            this.f47870j = getMeasuredWidth() / 2;
            RefreshState refreshState = this.V0;
            RefreshState refreshState2 = RefreshState.Refreshing;
            if ((refreshState == refreshState2 || refreshState == RefreshState.TwoLevel) && i4 > 0) {
                ValueAnimator ofInt = ValueAnimator.ofInt(this.f47855b, Math.min(i4 * 2, this.E0));
                this.f47864f1 = ofInt;
                ofInt.addListener(this.f47866g1);
            } else if (i4 < 0 && (refreshState == RefreshState.Loading || ((this.C && this.N) || (this.G && T() && !this.N && this.V0 != refreshState2)))) {
                ValueAnimator ofInt2 = ValueAnimator.ofInt(this.f47855b, Math.max((i4 * 7) / 2, -this.G0));
                this.f47864f1 = ofInt2;
                ofInt2.addListener(this.f47866g1);
            } else if (this.f47855b == 0 && this.E) {
                if (i4 > 0) {
                    if (this.V0 != RefreshState.Loading) {
                        z1();
                    }
                    i5 = Math.max(150, (i4 * 250) / this.E0);
                    this.f47864f1 = ValueAnimator.ofInt(0, Math.min(i4, this.E0));
                } else {
                    if (this.V0 != refreshState2) {
                        B1();
                    }
                    i5 = Math.max(150, ((-i4) * 250) / this.G0);
                    this.f47864f1 = ValueAnimator.ofInt(0, Math.max(i4, -this.G0));
                }
                this.f47864f1.addListener(new n(i5));
            }
            ValueAnimator valueAnimator = this.f47864f1;
            if (valueAnimator != null) {
                valueAnimator.setDuration(i5);
                this.f47864f1.setInterpolator(new DecelerateInterpolator());
                this.f47864f1.addUpdateListener(this.f47868h1);
                this.f47864f1.start();
            }
        }
        return this.f47864f1;
    }

    @Override // j1.h
    /* renamed from: q1 */
    public SmartRefreshLayout S(int i4) {
        this.f47863f = i4;
        return this;
    }

    @Override // j1.h
    /* renamed from: r0 */
    public SmartRefreshLayout h() {
        return m(Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.Y0))));
    }

    @Override // j1.h
    /* renamed from: r1 */
    public SmartRefreshLayout g0(Interpolator interpolator) {
        this.f47878q = interpolator;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z3) {
        View k4 = this.Q0.k();
        if (Build.VERSION.SDK_INT >= 21 || !(k4 instanceof AbsListView)) {
            if (k4 == null || ViewCompat.isNestedScrollingEnabled(k4)) {
                super.requestDisallowInterceptTouchEvent(z3);
            }
        }
    }

    @Override // j1.h
    /* renamed from: s0 */
    public SmartRefreshLayout m(int i4) {
        return m0(i4, true);
    }

    @Override // j1.h
    /* renamed from: s1 */
    public SmartRefreshLayout Z(j1.d dVar) {
        return C(dVar, -1, -2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z3) {
        this.P = true;
        this.C0.setNestedScrollingEnabled(z3);
    }

    protected void setViceState(RefreshState refreshState) {
        RefreshState refreshState2 = this.V0;
        if (refreshState2.draging && refreshState2.isHeader() != refreshState.isHeader()) {
            I0(RefreshState.None);
        }
        if (this.W0 != refreshState) {
            this.W0 = refreshState;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i4) {
        return this.C0.startNestedScroll(i4);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.C0.stopNestedScroll();
    }

    @Override // j1.h
    /* renamed from: t0 */
    public SmartRefreshLayout m0(int i4, boolean z3) {
        return U(i4, z3, false);
    }

    @Override // j1.h
    /* renamed from: t1 */
    public SmartRefreshLayout C(j1.d dVar, int i4, int i5) {
        if (dVar != null) {
            j1.d dVar2 = this.P0;
            if (dVar2 != null) {
                removeView(dVar2.getView());
            }
            this.P0 = dVar;
            this.H0 = this.H0.unNotify();
            this.f47887z = !this.O || this.f47887z;
            if (this.P0.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                addView(this.P0.getView(), 0, new o(i4, i5));
            } else {
                addView(this.P0.getView(), i4, i5);
            }
        }
        return this;
    }

    @Override // j1.h
    /* renamed from: u0 */
    public SmartRefreshLayout U(int i4, boolean z3, boolean z4) {
        postDelayed(new b(z3, z4), i4 <= 0 ? 1L : i4);
        return this;
    }

    @Override // j1.h
    /* renamed from: u1 */
    public SmartRefreshLayout c0(j1.e eVar) {
        return d0(eVar, -1, -2);
    }

    @Override // j1.h
    public boolean v(int i4, int i5, float f4) {
        if (this.V0 == RefreshState.None && T() && !this.N) {
            ValueAnimator valueAnimator = this.f47864f1;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            d dVar = new d(f4, i5);
            if (i4 > 0) {
                this.f47864f1 = new ValueAnimator();
                postDelayed(dVar, i4);
                return true;
            }
            dVar.run();
            return true;
        }
        return false;
    }

    @Override // j1.h
    /* renamed from: v0 */
    public SmartRefreshLayout e0(boolean z3) {
        return m0(z3 ? Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.Y0))) : 0, z3);
    }

    @Override // j1.h
    /* renamed from: v1 */
    public SmartRefreshLayout d0(j1.e eVar, int i4, int i5) {
        if (eVar != null) {
            j1.e eVar2 = this.O0;
            if (eVar2 != null) {
                removeView(eVar2.getView());
            }
            this.O0 = eVar;
            this.F0 = this.F0.unNotify();
            if (eVar.getSpinnerStyle() == SpinnerStyle.FixedBehind) {
                addView(this.O0.getView(), 0, new o(i4, i5));
            } else {
                addView(this.O0.getView(), i4, i5);
            }
        }
        return this;
    }

    @Override // j1.h
    public boolean w() {
        return this.V0 == RefreshState.Loading;
    }

    @Override // j1.h
    /* renamed from: w0 */
    public SmartRefreshLayout x() {
        return U(Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.Y0))), true, true);
    }

    protected void w1() {
        RefreshState refreshState = this.V0;
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2) {
            this.Y0 = System.currentTimeMillis();
            RefreshState refreshState3 = this.V0;
            RefreshState refreshState4 = RefreshState.LoadReleased;
            if (refreshState3 != refreshState4) {
                if (refreshState3 != RefreshState.ReleaseToLoad) {
                    if (refreshState3 != RefreshState.PullToUpLoad) {
                        B1();
                    }
                    D1();
                }
                I0(refreshState4);
                j1.d dVar = this.P0;
                if (dVar != null) {
                    dVar.h(this, this.G0, this.J0);
                }
            }
            I0(refreshState2);
            j1.d dVar2 = this.P0;
            if (dVar2 != null) {
                dVar2.t(this, this.G0, this.J0);
            }
            k1.b bVar = this.S;
            if (bVar != null) {
                bVar.q(this);
            }
            k1.c cVar = this.T;
            if (cVar != null) {
                cVar.q(this);
                this.T.o(this.P0, this.G0, this.J0);
            }
        }
    }

    @Override // j1.h
    /* renamed from: x0 */
    public SmartRefreshLayout y() {
        return V(Math.max(0, 1000 - ((int) (System.currentTimeMillis() - this.Z0))));
    }

    protected void x1() {
        j jVar = new j();
        I0(RefreshState.LoadReleased);
        ValueAnimator n02 = n0(-this.G0);
        if (n02 != null) {
            n02.addListener(jVar);
        }
        j1.d dVar = this.P0;
        if (dVar != null) {
            dVar.h(this, this.G0, this.J0);
        }
        k1.c cVar = this.T;
        if (cVar != null) {
            cVar.u(this.P0, this.G0, this.J0);
        }
        if (n02 == null) {
            jVar.onAnimationEnd(null);
        }
    }

    @Override // j1.h
    /* renamed from: y0 */
    public SmartRefreshLayout V(int i4) {
        return l0(i4, true);
    }

    protected void y1() {
        if (!this.V0.opening && X()) {
            I0(RefreshState.PullDownCanceled);
            L0();
            return;
        }
        setViceState(RefreshState.PullDownCanceled);
    }

    @Override // j1.h
    /* renamed from: z0 */
    public SmartRefreshLayout l0(int i4, boolean z3) {
        postDelayed(new a(z3), i4 <= 0 ? 1L : i4);
        return this;
    }

    protected void z1() {
        if (!this.V0.opening && X()) {
            I0(RefreshState.PullDownToRefresh);
        } else {
            setViceState(RefreshState.PullDownToRefresh);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class o extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f47916a;

        /* renamed from: b  reason: collision with root package name */
        public SpinnerStyle f47917b;

        public o(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f47916a = 0;
            this.f47917b = null;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout_Layout);
            this.f47916a = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.f47916a);
            int i4 = R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle;
            if (obtainStyledAttributes.hasValue(i4)) {
                this.f47917b = SpinnerStyle.values()[obtainStyledAttributes.getInt(i4, SpinnerStyle.Translate.ordinal())];
            }
            obtainStyledAttributes.recycle();
        }

        public o(int i4, int i5) {
            super(i4, i5);
            this.f47916a = 0;
            this.f47917b = null;
        }

        public o(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f47916a = 0;
            this.f47917b = null;
        }

        public o(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f47916a = 0;
            this.f47917b = null;
        }
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47861e = 250;
        this.f47863f = 250;
        this.f47872l = 0.5f;
        this.f47886y = true;
        this.f47887z = false;
        this.A = true;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = true;
        this.f47852L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.V = new int[2];
        this.W = new int[2];
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.F0 = dimensionStatus;
        this.H0 = dimensionStatus;
        this.K0 = 2.5f;
        this.L0 = 2.5f;
        this.M0 = 1.0f;
        this.N0 = 1.0f;
        RefreshState refreshState = RefreshState.None;
        this.V0 = refreshState;
        this.W0 = refreshState;
        this.X0 = false;
        this.Y0 = 0L;
        this.Z0 = 0L;
        this.f47854a1 = 0;
        this.f47856b1 = 0;
        this.f47862e1 = null;
        this.f47866g1 = new l();
        this.f47868h1 = new m();
        E0(context, attributeSet);
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f47861e = 250;
        this.f47863f = 250;
        this.f47872l = 0.5f;
        this.f47886y = true;
        this.f47887z = false;
        this.A = true;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = true;
        this.f47852L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.V = new int[2];
        this.W = new int[2];
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.F0 = dimensionStatus;
        this.H0 = dimensionStatus;
        this.K0 = 2.5f;
        this.L0 = 2.5f;
        this.M0 = 1.0f;
        this.N0 = 1.0f;
        RefreshState refreshState = RefreshState.None;
        this.V0 = refreshState;
        this.W0 = refreshState;
        this.X0 = false;
        this.Y0 = 0L;
        this.Z0 = 0L;
        this.f47854a1 = 0;
        this.f47856b1 = 0;
        this.f47862e1 = null;
        this.f47866g1 = new l();
        this.f47868h1 = new m();
        E0(context, attributeSet);
    }

    @RequiresApi(21)
    public SmartRefreshLayout(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f47861e = 250;
        this.f47863f = 250;
        this.f47872l = 0.5f;
        this.f47886y = true;
        this.f47887z = false;
        this.A = true;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = true;
        this.J = true;
        this.K = true;
        this.f47852L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.V = new int[2];
        this.W = new int[2];
        DimensionStatus dimensionStatus = DimensionStatus.DefaultUnNotify;
        this.F0 = dimensionStatus;
        this.H0 = dimensionStatus;
        this.K0 = 2.5f;
        this.L0 = 2.5f;
        this.M0 = 1.0f;
        this.N0 = 1.0f;
        RefreshState refreshState = RefreshState.None;
        this.V0 = refreshState;
        this.W0 = refreshState;
        this.X0 = false;
        this.Y0 = 0L;
        this.Z0 = 0L;
        this.f47854a1 = 0;
        this.f47856b1 = 0;
        this.f47862e1 = null;
        this.f47866g1 = new l();
        this.f47868h1 = new m();
        E0(context, attributeSet);
    }
}
