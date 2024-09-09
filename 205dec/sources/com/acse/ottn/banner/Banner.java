package com.acse.ottn.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.acse.ottn.R;
import com.acse.ottn.a2;
import com.acse.ottn.banner.util.BannerLifecycleObserverAdapter;
import com.acse.ottn.banner.util.ScrollSpeedManger;
import com.acse.ottn.c2;
import com.acse.ottn.n1;
import com.acse.ottn.o1;
import com.acse.ottn.p3;
import com.acse.ottn.r2;
import com.acse.ottn.s2;
import com.acse.ottn.t;
import com.acse.ottn.u;
import com.acse.ottn.x;
import com.acse.ottn.y;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class Banner<T, BA extends t> extends FrameLayout implements x {
    public static final int I = -1;
    public static final int J = 0;
    public static final int K = 1;
    public int A;
    public float B;
    public float C;
    public boolean D;
    public boolean E;
    public Paint F;
    public Paint G;
    public RecyclerView.AdapterDataObserver H;

    /* renamed from: a  reason: collision with root package name */
    public ViewPager2 f5210a;

    /* renamed from: b  reason: collision with root package name */
    public b f5211b;

    /* renamed from: c  reason: collision with root package name */
    public s2 f5212c;

    /* renamed from: d  reason: collision with root package name */
    public BA f5213d;

    /* renamed from: e  reason: collision with root package name */
    public n1 f5214e;

    /* renamed from: f  reason: collision with root package name */
    public CompositePageTransformer f5215f;

    /* renamed from: g  reason: collision with root package name */
    public Banner<T, BA>.c f5216g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5217h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5218i;

    /* renamed from: j  reason: collision with root package name */
    public long f5219j;

    /* renamed from: k  reason: collision with root package name */
    public int f5220k;

    /* renamed from: l  reason: collision with root package name */
    public int f5221l;

    /* renamed from: m  reason: collision with root package name */
    public float f5222m;

    /* renamed from: n  reason: collision with root package name */
    public int f5223n;

    /* renamed from: o  reason: collision with root package name */
    public int f5224o;

    /* renamed from: p  reason: collision with root package name */
    public int f5225p;

    /* renamed from: q  reason: collision with root package name */
    public int f5226q;

    /* renamed from: r  reason: collision with root package name */
    public int f5227r;

    /* renamed from: s  reason: collision with root package name */
    public int f5228s;

    /* renamed from: t  reason: collision with root package name */
    public int f5229t;

    /* renamed from: u  reason: collision with root package name */
    public int f5230u;

    /* renamed from: v  reason: collision with root package name */
    public int f5231v;

    /* renamed from: w  reason: collision with root package name */
    public int f5232w;

    /* renamed from: x  reason: collision with root package name */
    public int f5233x;

    /* renamed from: y  reason: collision with root package name */
    public int f5234y;

    /* renamed from: z  reason: collision with root package name */
    public int f5235z;

    /* renamed from: com.acse.ottn.banner.Banner$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    class AnonymousClass1 extends RecyclerView.AdapterDataObserver {
        AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            if (Banner.this.getItemCount() <= 1) {
                Banner.this.f();
            } else {
                Banner.this.e();
            }
            Banner.this.d();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class AutoLoopTask implements Runnable {
        private final WeakReference<Banner> reference;

        AutoLoopTask(Banner banner) {
            this.reference = new WeakReference<>(banner);
        }

        @Override // java.lang.Runnable
        public void run() {
            int itemCount;
            Banner banner = this.reference.get();
            if (banner == null || !banner.f5218i || (itemCount = banner.getItemCount()) == 0) {
                return;
            }
            banner.b((banner.getCurrentItem() + 1) % itemCount);
            banner.postDelayed(banner.f5211b, banner.f5219j);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    class BannerOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        private boolean isScrolled;
        private int mTempPosition = -1;

        BannerOnPageChangeCallback() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i4) {
            if (i4 == 1 || i4 == 2) {
                this.isScrolled = true;
            } else if (i4 == 0) {
                this.isScrolled = false;
                if (this.mTempPosition != -1 && Banner.this.f5217h) {
                    int i5 = this.mTempPosition;
                    if (i5 == 0) {
                        Banner banner = Banner.this;
                        banner.a(banner.getRealCount(), false);
                    } else if (i5 == Banner.this.getItemCount() - 1) {
                        Banner.this.a(1, false);
                    }
                }
            }
            if (Banner.this.f5212c != null) {
                Banner.this.f5212c.onPageScrollStateChanged(i4);
            }
            if (Banner.this.f5214e != null) {
                Banner.this.f5214e.onPageScrollStateChanged(i4);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i4, float f4, int i5) {
            int a4 = com.acse.ottn.banner.util.b.a(Banner.this.b(), i4, Banner.this.getRealCount());
            if (Banner.this.f5212c != null) {
                Banner.this.f5212c.onPageScrolled(a4, f4, i5);
            }
            if (Banner.this.f5214e != null) {
                Banner.this.f5214e.onPageScrolled(a4, f4, i5);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i4) {
            if (this.isScrolled) {
                this.mTempPosition = i4;
                int a4 = com.acse.ottn.banner.util.b.a(Banner.this.b(), i4, Banner.this.getRealCount());
                if (Banner.this.f5212c != null) {
                    Banner.this.f5212c.onPageSelected(a4);
                }
                if (Banner.this.f5214e != null) {
                    Banner.this.f5214e.onPageSelected(a4);
                }
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public @interface Orientation {
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends RecyclerView.AdapterDataObserver {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            if (Banner.this.getItemCount() <= 1) {
                Banner.this.i();
            } else {
                Banner.this.h();
            }
            Banner.this.f();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<Banner> f5237a;

        public b(Banner banner) {
            this.f5237a = new WeakReference<>(banner);
        }

        @Override // java.lang.Runnable
        public void run() {
            int itemCount;
            Banner banner = this.f5237a.get();
            if (banner == null || !banner.f5218i || (itemCount = banner.getItemCount()) == 0) {
                return;
            }
            banner.b((banner.getCurrentItem() + 1) % itemCount);
            banner.postDelayed(banner.f5211b, banner.f5219j);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a  reason: collision with root package name */
        public int f5238a = -1;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5239b;

        public c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i4) {
            if (i4 == 1 || i4 == 2) {
                this.f5239b = true;
            } else if (i4 == 0) {
                this.f5239b = false;
                if (this.f5238a != -1 && Banner.this.f5217h) {
                    int i5 = this.f5238a;
                    if (i5 == 0) {
                        Banner banner = Banner.this;
                        banner.a(banner.getRealCount(), false);
                    } else if (i5 == Banner.this.getItemCount() - 1) {
                        Banner.this.a(1, false);
                    }
                }
            }
            if (Banner.this.f5212c != null) {
                Banner.this.f5212c.onPageScrollStateChanged(i4);
            }
            if (Banner.this.f5214e != null) {
                Banner.this.f5214e.onPageScrollStateChanged(i4);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i4, float f4, int i5) {
            int a4 = y.a(Banner.this.d(), i4, Banner.this.getRealCount());
            if (Banner.this.f5212c != null) {
                Banner.this.f5212c.onPageScrolled(a4, f4, i5);
            }
            if (Banner.this.f5214e != null) {
                Banner.this.f5214e.onPageScrolled(a4, f4, i5);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i4) {
            if (this.f5239b) {
                this.f5238a = i4;
                int a4 = y.a(Banner.this.d(), i4, Banner.this.getRealCount());
                if (Banner.this.f5212c != null) {
                    Banner.this.f5212c.onPageSelected(a4);
                }
                if (Banner.this.f5214e != null) {
                    Banner.this.f5214e.onPageSelected(a4);
                }
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public @interface d {
    }

    public Banner(Context context) {
        this(context, null);
    }

    private void setRecyclerViewPadding(int i4) {
        c(i4, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f5222m > 0.0f) {
            canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.G, 31);
            super.dispatchDraw(canvas);
            c(canvas);
            d(canvas);
            a(canvas);
            b(canvas);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!getViewPager2().isUserInputEnabled()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3 || actionMasked == 4) {
            h();
        } else if (actionMasked == 0) {
            i();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void g() {
        if (!d()) {
            a(false);
        }
        o(d() ? 1 : 0);
    }

    public BA getAdapter() {
        if (this.f5213d == null) {
            a2.b(getContext().getString(R.string.banner_adapter_use_error));
        }
        return this.f5213d;
    }

    public int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public n1 getIndicator() {
        if (this.f5214e == null) {
            a2.b(getContext().getString(R.string.indicator_null_error));
        }
        return this.f5214e;
    }

    public o1 getIndicatorConfig() {
        if (getIndicator() != null) {
            return getIndicator().getIndicatorConfig();
        }
        return null;
    }

    public int getItemCount() {
        if (getAdapter() == null) {
            return 0;
        }
        return getAdapter().getItemCount();
    }

    public int getRealCount() {
        return getAdapter().a();
    }

    public int getScrollTime() {
        return this.f5220k;
    }

    public ViewPager2 getViewPager2() {
        return this.f5210a;
    }

    public Banner h() {
        if (this.f5218i) {
            i();
            postDelayed(this.f5211b, this.f5219j);
        }
        return this;
    }

    public Banner i() {
        if (this.f5218i) {
            removeCallbacks(this.f5211b);
        }
        return this;
    }

    public Banner j(@ColorRes int i4) {
        i(ContextCompat.getColor(getContext(), i4));
        return this;
    }

    public Banner k(int i4) {
        n1 n1Var = this.f5214e;
        if (n1Var != null) {
            n1Var.getIndicatorConfig().j(i4);
        }
        return this;
    }

    public Banner l(int i4) {
        n1 n1Var = this.f5214e;
        if (n1Var != null) {
            n1Var.getIndicatorConfig().e(i4);
        }
        return this;
    }

    public Banner m(int i4) {
        getViewPager2().setOrientation(i4);
        return this;
    }

    public Banner n(int i4) {
        this.f5220k = i4;
        return this;
    }

    public Banner o(int i4) {
        this.f5221l = i4;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
        if (r0 != 3) goto L13;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.viewpager2.widget.ViewPager2 r0 = r5.getViewPager2()
            boolean r0 = r0.isUserInputEnabled()
            if (r0 == 0) goto L8a
            boolean r0 = r5.E
            if (r0 != 0) goto L10
            goto L8a
        L10:
            int r0 = r6.getAction()
            r1 = 1
            if (r0 == 0) goto L72
            r2 = 0
            if (r0 == r1) goto L6a
            r3 = 2
            if (r0 == r3) goto L21
            r1 = 3
            if (r0 == r1) goto L6a
            goto L85
        L21:
            float r0 = r6.getX()
            float r3 = r6.getY()
            float r4 = r5.B
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            float r4 = r5.C
            float r3 = r3 - r4
            float r3 = java.lang.Math.abs(r3)
            androidx.viewpager2.widget.ViewPager2 r4 = r5.getViewPager2()
            int r4 = r4.getOrientation()
            if (r4 != 0) goto L51
            int r4 = r5.A
            float r4 = (float) r4
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto L4d
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L4d
            goto L4e
        L4d:
            r1 = 0
        L4e:
            r5.D = r1
            goto L60
        L51:
            int r4 = r5.A
            float r4 = (float) r4
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L5d
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L5d
            goto L5e
        L5d:
            r1 = 0
        L5e:
            r5.D = r1
        L60:
            android.view.ViewParent r0 = r5.getParent()
            boolean r1 = r5.D
            r0.requestDisallowInterceptTouchEvent(r1)
            goto L85
        L6a:
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L85
        L72:
            float r0 = r6.getX()
            r5.B = r0
            float r0 = r6.getY()
            r5.C = r0
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
        L85:
            boolean r6 = super.onInterceptTouchEvent(r6)
            return r6
        L8a:
            boolean r6 = super.onInterceptTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.banner.Banner.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public Banner p(int i4) {
        this.A = i4;
        return this;
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(Context context) {
        this.A = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
        this.f5215f = new CompositePageTransformer();
        this.f5216g = new c();
        this.f5211b = new b(this);
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.f5210a = viewPager2;
        viewPager2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f5210a.setOffscreenPageLimit(1);
        this.f5210a.registerOnPageChangeCallback(this.f5216g);
        this.f5210a.setPageTransformer(this.f5215f);
        ScrollSpeedManger.a(this);
        addView(this.f5210a);
        Paint paint = new Paint();
        this.F = paint;
        paint.setColor(-1);
        this.F.setAntiAlias(true);
        this.F.setStyle(Paint.Style.FILL);
        this.F.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.G = paint2;
        paint2.setXfermode(null);
    }

    public final void b(Canvas canvas) {
        int height = getHeight();
        int width = getWidth();
        Path path = new Path();
        float f4 = width;
        float f5 = height;
        path.moveTo(f4 - this.f5222m, f5);
        path.lineTo(f4, f5);
        path.lineTo(f4, f5 - this.f5222m);
        float f6 = this.f5222m * 2.0f;
        path.arcTo(new RectF(f4 - f6, f5 - f6, f4, f5), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.F);
    }

    public final void c() {
        int i4 = this.f5229t;
        if (i4 != 0) {
            a(new o1.b(i4));
        } else {
            int i5 = this.f5230u;
            if (i5 != 0 || this.f5231v != 0 || this.f5232w != 0 || this.f5233x != 0) {
                a(new o1.b(i5, this.f5231v, this.f5232w, this.f5233x));
            }
        }
        int i6 = this.f5228s;
        if (i6 > 0) {
            l(i6);
        }
        int i7 = this.f5227r;
        if (i7 != 1) {
            c(i7);
        }
        int i8 = this.f5223n;
        if (i8 > 0) {
            g(i8);
        }
        int i9 = this.f5224o;
        if (i9 > 0) {
            k(i9);
        }
        int i10 = this.f5234y;
        if (i10 > 0) {
            d(i10);
        }
        int i11 = this.f5235z;
        if (i11 > 0) {
            h(i11);
        }
        e(this.f5225p);
        i(this.f5226q);
    }

    public final void d(Canvas canvas) {
        int width = getWidth();
        Path path = new Path();
        float f4 = width;
        path.moveTo(f4 - this.f5222m, 0.0f);
        path.lineTo(f4, 0.0f);
        path.lineTo(f4, this.f5222m);
        float f5 = this.f5222m * 2.0f;
        path.arcTo(new RectF(f4 - f5, 0.0f, f4, f5), 0.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.F);
    }

    public Banner e() {
        n1 n1Var = this.f5214e;
        if (n1Var != null) {
            removeView(n1Var.getIndicatorView());
        }
        return this;
    }

    public Banner f() {
        if (this.f5214e != null) {
            this.f5214e.a(getRealCount(), y.a(d(), getCurrentItem(), getRealCount()));
        }
        return this;
    }

    public Banner(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f5217h = true;
        this.f5218i = true;
        this.f5219j = 3000L;
        this.f5220k = 600;
        this.f5221l = 1;
        this.f5222m = 0.0f;
        this.f5223n = u.f6637g;
        this.f5224o = u.f6638h;
        this.f5225p = -1996488705;
        this.f5226q = -2013265920;
        this.f5227r = 1;
        this.f5234y = u.f6641k;
        this.f5235z = u.f6642l;
        this.E = true;
        this.H = new a();
        a(context);
        a(context, attributeSet);
    }

    public Banner i(@ColorInt int i4) {
        n1 n1Var = this.f5214e;
        if (n1Var != null) {
            n1Var.getIndicatorConfig().i(i4);
        }
        return this;
    }

    public Banner e(@ColorInt int i4) {
        n1 n1Var = this.f5214e;
        if (n1Var != null) {
            n1Var.getIndicatorConfig().f(i4);
        }
        return this;
    }

    public Banner g(int i4) {
        n1 n1Var = this.f5214e;
        if (n1Var != null) {
            n1Var.getIndicatorConfig().g(i4);
        }
        return this;
    }

    public Banner<T, BA> h(int i4) {
        n1 n1Var = this.f5214e;
        if (n1Var != null) {
            n1Var.getIndicatorConfig().h(i4);
        }
        return this;
    }

    public Banner f(@ColorRes int i4) {
        e(ContextCompat.getColor(getContext(), i4));
        return this;
    }

    public boolean d() {
        return this.f5217h;
    }

    public final void b() {
        if (this.f5214e == null || getAdapter() == null) {
            return;
        }
        if (this.f5214e.getIndicatorConfig().l()) {
            e();
            addView(this.f5214e.getIndicatorView());
        }
        c();
        f();
    }

    public Banner<T, BA> d(int i4) {
        n1 n1Var = this.f5214e;
        if (n1Var != null) {
            n1Var.getIndicatorConfig().c(i4);
        }
        return this;
    }

    public Banner d(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            lifecycleOwner.getLifecycle().addObserver(new BannerLifecycleObserverAdapter(lifecycleOwner, this));
        }
        return this;
    }

    public Banner b(boolean z3) {
        this.E = z3;
        return this;
    }

    public Banner b(int i4) {
        return a(i4, true);
    }

    public Banner b(ViewPager2.PageTransformer pageTransformer) {
        this.f5215f.removeTransformer(pageTransformer);
        return this;
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Banner);
        this.f5222m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_radius, 0);
        this.f5219j = obtainStyledAttributes.getInt(R.styleable.Banner_banner_loop_time, 3000);
        this.f5218i = obtainStyledAttributes.getBoolean(R.styleable.Banner_banner_auto_loop, true);
        this.f5217h = obtainStyledAttributes.getBoolean(R.styleable.Banner_banner_infinite_loop, true);
        this.f5223n = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_normal_width, u.f6637g);
        this.f5224o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_selected_width, u.f6638h);
        this.f5225p = obtainStyledAttributes.getColor(R.styleable.Banner_banner_indicator_normal_color, -1996488705);
        this.f5226q = obtainStyledAttributes.getColor(R.styleable.Banner_banner_indicator_selected_color, -2013265920);
        this.f5227r = obtainStyledAttributes.getInt(R.styleable.Banner_banner_indicator_gravity, 1);
        this.f5228s = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_space, 0);
        this.f5229t = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_margin, 0);
        this.f5230u = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginLeft, 0);
        this.f5231v = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginTop, 0);
        this.f5232w = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginRight, 0);
        this.f5233x = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_marginBottom, 0);
        this.f5234y = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_height, u.f6641k);
        this.f5235z = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_banner_indicator_radius, u.f6642l);
        m(obtainStyledAttributes.getInt(R.styleable.Banner_banner_orientation, 0));
        g();
        obtainStyledAttributes.recycle();
    }

    @RequiresApi(api = 21)
    public Banner b(float f4) {
        y.a(this, f4);
        return this;
    }

    public final void c(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0.0f, this.f5222m);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.f5222m, 0.0f);
        float f4 = this.f5222m * 2.0f;
        path.arcTo(new RectF(0.0f, 0.0f, f4, f4), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.F);
    }

    public Banner b(int i4, int i5) {
        n1 n1Var = this.f5214e;
        if (n1Var != null) {
            n1Var.getIndicatorConfig().g(i4);
            this.f5214e.getIndicatorConfig().j(i5);
        }
        return this;
    }

    @Override // com.acse.ottn.x
    public void b(LifecycleOwner lifecycleOwner) {
        h();
    }

    public final void c(int i4, int i5) {
        RecyclerView recyclerView = (RecyclerView) getViewPager2().getChildAt(0);
        if (getViewPager2().getOrientation() == 1) {
            recyclerView.setPadding(0, i4, 0, i5);
        } else {
            recyclerView.setPadding(i4, 0, i5, 0);
        }
        recyclerView.setClipToPadding(false);
    }

    public Banner c(boolean z3) {
        getViewPager2().setUserInputEnabled(z3);
        return this;
    }

    public Banner c(@Nullable ViewPager2.PageTransformer pageTransformer) {
        getViewPager2().setPageTransformer(pageTransformer);
        return this;
    }

    public Banner c(int i4) {
        n1 n1Var = this.f5214e;
        if (n1Var != null && n1Var.getIndicatorConfig().l()) {
            this.f5214e.getIndicatorConfig().b(i4);
            this.f5214e.getIndicatorView().postInvalidate();
        }
        return this;
    }

    @Override // com.acse.ottn.x
    public void c(LifecycleOwner lifecycleOwner) {
        i();
    }

    public final void a(Canvas canvas) {
        int height = getHeight();
        Path path = new Path();
        float f4 = height;
        path.moveTo(0.0f, f4 - this.f5222m);
        path.lineTo(0.0f, f4);
        path.lineTo(this.f5222m, f4);
        float f5 = this.f5222m * 2.0f;
        path.arcTo(new RectF(0.0f, f4 - f5, f5, f4), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.F);
    }

    public Banner a(int i4, boolean z3) {
        getViewPager2().setCurrentItem(i4, z3);
        return this;
    }

    public Banner a(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.f5215f.addTransformer(pageTransformer);
        return this;
    }

    public Banner a(RecyclerView.ItemDecoration itemDecoration) {
        getViewPager2().addItemDecoration(itemDecoration);
        return this;
    }

    public Banner a(RecyclerView.ItemDecoration itemDecoration, int i4) {
        getViewPager2().addItemDecoration(itemDecoration, i4);
        return this;
    }

    public Banner a(boolean z3) {
        this.f5218i = z3;
        return this;
    }

    public Banner a(long j4) {
        this.f5219j = j4;
        return this;
    }

    public void a() {
        if (getViewPager2() != null && this.f5216g != null) {
            getViewPager2().unregisterOnPageChangeCallback(this.f5216g);
            this.f5216g = null;
        }
        i();
    }

    public Banner a(BA ba) {
        if (ba != null) {
            this.f5213d = ba;
            if (!d()) {
                this.f5213d.c(0);
            }
            this.f5213d.registerAdapterDataObserver(this.H);
            this.f5210a.setAdapter(ba);
            a(this.f5221l, false);
            b();
            return this;
        }
        throw new NullPointerException(getContext().getString(R.string.banner_adapter_null_error));
    }

    public Banner a(BA ba, boolean z3) {
        this.f5217h = z3;
        g();
        a((Banner<T, BA>) ba);
        return this;
    }

    public Banner a(List<T> list) {
        if (getAdapter() != null) {
            getAdapter().a(list);
            getAdapter().notifyDataSetChanged();
            a(this.f5221l, false);
            f();
            h();
        }
        return this;
    }

    public Banner a(r2 r2Var) {
        if (getAdapter() != null) {
            getAdapter().a(r2Var);
        }
        return this;
    }

    public Banner a(s2 s2Var) {
        this.f5212c = s2Var;
        return this;
    }

    public Banner a(float f4) {
        this.f5222m = f4;
        return this;
    }

    public Banner a(int i4, int i5) {
        return a(i4, i5, 0.85f);
    }

    public Banner a(int i4, int i5, int i6) {
        return a(i4, i5, i6, 0.85f);
    }

    public Banner a(int i4, int i5, float f4) {
        return a(i4, i4, i5, f4);
    }

    public Banner a(int i4, int i5, int i6, float f4) {
        if (i6 > 0) {
            a(new MarginPageTransformer((int) y.a(i6)));
        }
        if (f4 < 1.0f && f4 > 0.0f) {
            a(new p3(f4));
        }
        c(i4 > 0 ? (int) y.a(i4 + i6) : 0, i5 > 0 ? (int) y.a(i5 + i6) : 0);
        return this;
    }

    public Banner a(int i4) {
        return a(i4, 0.88f);
    }

    public Banner a(int i4, float f4) {
        if (f4 < 1.0f && f4 > 0.0f) {
            a(new c2(f4));
        }
        setRecyclerViewPadding((int) y.a(i4));
        return this;
    }

    public Banner a(n1 n1Var) {
        return a(n1Var, true);
    }

    public Banner a(n1 n1Var, boolean z3) {
        e();
        n1Var.getIndicatorConfig().a(z3);
        this.f5214e = n1Var;
        b();
        return this;
    }

    public Banner a(o1.b bVar) {
        n1 n1Var = this.f5214e;
        if (n1Var != null && n1Var.getIndicatorConfig().l()) {
            this.f5214e.getIndicatorConfig().a(bVar);
            this.f5214e.getIndicatorView().requestLayout();
        }
        return this;
    }

    @Override // com.acse.ottn.x
    public void a(LifecycleOwner lifecycleOwner) {
        a();
    }
}
