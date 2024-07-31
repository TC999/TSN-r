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
import com.acse.ottn.C1239R;
import com.acse.ottn.banner.adapter.AbstractC1446a;
import com.acse.ottn.banner.config.C1454a;
import com.acse.ottn.banner.config.IndicatorConfig;
import com.acse.ottn.banner.p037b.InterfaceC1450c;
import com.acse.ottn.banner.p039d.InterfaceC1455a;
import com.acse.ottn.banner.p039d.InterfaceC1456b;
import com.acse.ottn.banner.p040e.C1460d;
import com.acse.ottn.banner.p040e.C1464h;
import com.acse.ottn.banner.util.BannerLifecycleObserverAdapter;
import com.acse.ottn.banner.util.C1468b;
import com.acse.ottn.banner.util.C1469c;
import com.acse.ottn.banner.util.InterfaceC1467a;
import com.acse.ottn.banner.util.ScrollSpeedManger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class Banner<T, BA extends AbstractC1446a> extends FrameLayout implements InterfaceC1467a {

    /* renamed from: a */
    public static final int f2603a = -1;

    /* renamed from: b */
    public static final int f2604b = 0;

    /* renamed from: c */
    public static final int f2605c = 1;

    /* renamed from: A */
    private int f2606A;

    /* renamed from: B */
    private int f2607B;

    /* renamed from: C */
    private int f2608C;

    /* renamed from: D */
    private int f2609D;

    /* renamed from: E */
    private float f2610E;

    /* renamed from: F */
    private float f2611F;

    /* renamed from: G */
    private boolean f2612G;

    /* renamed from: H */
    private boolean f2613H;

    /* renamed from: I */
    private Paint f2614I;

    /* renamed from: J */
    private Paint f2615J;

    /* renamed from: K */
    private RecyclerView.AdapterDataObserver f2616K;

    /* renamed from: d */
    private ViewPager2 f2617d;

    /* renamed from: e */
    private AutoLoopTask f2618e;

    /* renamed from: f */
    private InterfaceC1456b f2619f;

    /* renamed from: g */
    private BA f2620g;

    /* renamed from: h */
    private InterfaceC1450c f2621h;

    /* renamed from: i */
    private CompositePageTransformer f2622i;

    /* renamed from: j */
    private Banner<T, BA>.BannerOnPageChangeCallback f2623j;

    /* renamed from: k */
    private boolean f2624k;

    /* renamed from: l */
    private boolean f2625l;

    /* renamed from: m */
    private long f2626m;

    /* renamed from: n */
    private int f2627n;

    /* renamed from: o */
    private int f2628o;

    /* renamed from: p */
    private float f2629p;

    /* renamed from: q */
    private int f2630q;

    /* renamed from: r */
    private int f2631r;

    /* renamed from: s */
    private int f2632s;

    /* renamed from: t */
    private int f2633t;

    /* renamed from: u */
    private int f2634u;

    /* renamed from: v */
    private int f2635v;

    /* renamed from: w */
    private int f2636w;

    /* renamed from: x */
    private int f2637x;

    /* renamed from: y */
    private int f2638y;

    /* renamed from: z */
    private int f2639z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class AutoLoopTask implements Runnable {
        private final WeakReference<Banner> reference;

        AutoLoopTask(Banner banner) {
            this.reference = new WeakReference<>(banner);
        }

        @Override // java.lang.Runnable
        public void run() {
            int itemCount;
            Banner banner = this.reference.get();
            if (banner == null || !banner.f2625l || (itemCount = banner.getItemCount()) == 0) {
                return;
            }
            banner.m56779b((banner.getCurrentItem() + 1) % itemCount);
            banner.postDelayed(banner.f2618e, banner.f2626m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class BannerOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        private boolean isScrolled;
        private int mTempPosition = -1;

        BannerOnPageChangeCallback() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
            if (i == 1 || i == 2) {
                this.isScrolled = true;
            } else if (i == 0) {
                this.isScrolled = false;
                if (this.mTempPosition != -1 && Banner.this.f2624k) {
                    int i2 = this.mTempPosition;
                    if (i2 == 0) {
                        Banner banner = Banner.this;
                        banner.m56800a(banner.getRealCount(), false);
                    } else if (i2 == Banner.this.getItemCount() - 1) {
                        Banner.this.m56800a(1, false);
                    }
                }
            }
            if (Banner.this.f2619f != null) {
                Banner.this.f2619f.onPageScrollStateChanged(i);
            }
            if (Banner.this.f2621h != null) {
                Banner.this.f2621h.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i, float f, int i2) {
            int m56700a = C1468b.m56700a(Banner.this.m56781b(), i, Banner.this.getRealCount());
            if (Banner.this.f2619f != null) {
                Banner.this.f2619f.onPageScrolled(m56700a, f, i2);
            }
            if (Banner.this.f2621h != null) {
                Banner.this.f2621h.onPageScrolled(m56700a, f, i2);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            if (this.isScrolled) {
                this.mTempPosition = i;
                int m56700a = C1468b.m56700a(Banner.this.m56781b(), i, Banner.this.getRealCount());
                if (Banner.this.f2619f != null) {
                    Banner.this.f2619f.onPageSelected(m56700a);
                }
                if (Banner.this.f2621h != null) {
                    Banner.this.f2621h.onPageSelected(m56700a);
                }
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public @interface Orientation {
    }

    public Banner(Context context) {
        this(context, null);
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Banner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2624k = true;
        this.f2625l = true;
        this.f2626m = 3000L;
        this.f2627n = 600;
        this.f2628o = 1;
        this.f2629p = 0.0f;
        this.f2630q = C1454a.f2671g;
        this.f2631r = C1454a.f2672h;
        this.f2632s = C1454a.f2669e;
        this.f2633t = C1454a.f2670f;
        this.f2634u = 1;
        this.f2607B = C1454a.f2675k;
        this.f2608C = C1454a.f2676l;
        this.f2613H = true;
        this.f2616K = new RecyclerView.AdapterDataObserver() { // from class: com.acse.ottn.banner.Banner.1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                if (Banner.this.getItemCount() <= 1) {
                    Banner.this.m56759f();
                } else {
                    Banner.this.m56762e();
                }
                Banner.this.m56766d();
            }
        };
        m56798a(context);
        m56797a(context, attributeSet);
    }

    /* renamed from: a */
    private void m56798a(Context context) {
        this.f2609D = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
        this.f2622i = new CompositePageTransformer();
        this.f2623j = new BannerOnPageChangeCallback();
        this.f2618e = new AutoLoopTask(this);
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.f2617d = viewPager2;
        viewPager2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f2617d.setOffscreenPageLimit(1);
        this.f2617d.registerOnPageChangeCallback(this.f2623j);
        this.f2617d.setPageTransformer(this.f2622i);
        ScrollSpeedManger.m56705a(this);
        addView(this.f2617d);
        Paint paint = new Paint();
        this.f2614I = paint;
        paint.setColor(-1);
        this.f2614I.setAntiAlias(true);
        this.f2614I.setStyle(Paint.Style.FILL);
        this.f2614I.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f2615J = paint2;
        paint2.setXfermode(null);
    }

    /* renamed from: a */
    private void m56797a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1239R.styleable.Banner);
        this.f2629p = obtainStyledAttributes.getDimensionPixelSize(C1239R.styleable.Banner_banner_radius, 0);
        this.f2626m = obtainStyledAttributes.getInt(C1239R.styleable.Banner_banner_loop_time, 3000);
        this.f2625l = obtainStyledAttributes.getBoolean(C1239R.styleable.Banner_banner_auto_loop, true);
        this.f2624k = obtainStyledAttributes.getBoolean(C1239R.styleable.Banner_banner_infinite_loop, true);
        this.f2630q = obtainStyledAttributes.getDimensionPixelSize(C1239R.styleable.Banner_banner_indicator_normal_width, C1454a.f2671g);
        this.f2631r = obtainStyledAttributes.getDimensionPixelSize(C1239R.styleable.Banner_banner_indicator_selected_width, C1454a.f2672h);
        this.f2632s = obtainStyledAttributes.getColor(C1239R.styleable.Banner_banner_indicator_normal_color, C1454a.f2669e);
        this.f2633t = obtainStyledAttributes.getColor(C1239R.styleable.Banner_banner_indicator_selected_color, C1454a.f2670f);
        this.f2634u = obtainStyledAttributes.getInt(C1239R.styleable.Banner_banner_indicator_gravity, 1);
        this.f2635v = obtainStyledAttributes.getDimensionPixelSize(C1239R.styleable.Banner_banner_indicator_space, 0);
        this.f2636w = obtainStyledAttributes.getDimensionPixelSize(C1239R.styleable.Banner_banner_indicator_margin, 0);
        this.f2637x = obtainStyledAttributes.getDimensionPixelSize(C1239R.styleable.Banner_banner_indicator_marginLeft, 0);
        this.f2638y = obtainStyledAttributes.getDimensionPixelSize(C1239R.styleable.Banner_banner_indicator_marginTop, 0);
        this.f2639z = obtainStyledAttributes.getDimensionPixelSize(C1239R.styleable.Banner_banner_indicator_marginRight, 0);
        this.f2606A = obtainStyledAttributes.getDimensionPixelSize(C1239R.styleable.Banner_banner_indicator_marginBottom, 0);
        this.f2607B = obtainStyledAttributes.getDimensionPixelSize(C1239R.styleable.Banner_banner_indicator_height, C1454a.f2675k);
        this.f2608C = obtainStyledAttributes.getDimensionPixelSize(C1239R.styleable.Banner_banner_indicator_radius, C1454a.f2676l);
        m56747m(obtainStyledAttributes.getInt(C1239R.styleable.Banner_banner_orientation, 0));
        m56752i();
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m56796a(Canvas canvas) {
        int height = getHeight();
        Path path = new Path();
        float f = height;
        path.moveTo(0.0f, f - this.f2629p);
        path.lineTo(0.0f, f);
        path.lineTo(this.f2629p, f);
        float f2 = this.f2629p * 2.0f;
        path.arcTo(new RectF(0.0f, f - f2, f2, f), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.f2614I);
    }

    /* renamed from: b */
    private void m56777b(Canvas canvas) {
        int height = getHeight();
        int width = getWidth();
        Path path = new Path();
        float f = width;
        float f2 = height;
        path.moveTo(f - this.f2629p, f2);
        path.lineTo(f, f2);
        path.lineTo(f, f2 - this.f2629p);
        float f3 = this.f2629p * 2.0f;
        path.arcTo(new RectF(f - f3, f2 - f3, f, f2), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.f2614I);
    }

    /* renamed from: c */
    private void m56771c(int i, int i2) {
        RecyclerView recyclerView = (RecyclerView) getViewPager2().getChildAt(0);
        if (getViewPager2().getOrientation() == 1) {
            recyclerView.setPadding(0, i, 0, i2);
        } else {
            recyclerView.setPadding(i, 0, i2, 0);
        }
        recyclerView.setClipToPadding(false);
    }

    /* renamed from: c */
    private void m56770c(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0.0f, this.f2629p);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.f2629p, 0.0f);
        float f = this.f2629p * 2.0f;
        path.arcTo(new RectF(0.0f, 0.0f, f, f), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.f2614I);
    }

    /* renamed from: d */
    private void m56764d(Canvas canvas) {
        int width = getWidth();
        Path path = new Path();
        float f = width;
        path.moveTo(f - this.f2629p, 0.0f);
        path.lineTo(f, 0.0f);
        path.lineTo(f, this.f2629p);
        float f2 = this.f2629p * 2.0f;
        path.arcTo(new RectF(f - f2, 0.0f, f, f2), 0.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.f2614I);
    }

    /* renamed from: g */
    private void m56756g() {
        if (this.f2621h == null || getAdapter() == null) {
            return;
        }
        if (this.f2621h.getIndicatorConfig().m56708l()) {
            m56773c();
            addView(this.f2621h.getIndicatorView());
        }
        m56754h();
        m56766d();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0051  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m56754h() {
        /*
            r5 = this;
            int r0 = r5.f2636w
            if (r0 == 0) goto Ld
            com.acse.ottn.banner.config.IndicatorConfig$Margins r1 = new com.acse.ottn.banner.config.IndicatorConfig$Margins
            r1.<init>(r0)
        L9:
            r5.m56786a(r1)
            goto L29
        Ld:
            int r0 = r5.f2637x
            if (r0 != 0) goto L1d
            int r1 = r5.f2638y
            if (r1 != 0) goto L1d
            int r1 = r5.f2639z
            if (r1 != 0) goto L1d
            int r1 = r5.f2606A
            if (r1 == 0) goto L29
        L1d:
            com.acse.ottn.banner.config.IndicatorConfig$Margins r1 = new com.acse.ottn.banner.config.IndicatorConfig$Margins
            int r2 = r5.f2638y
            int r3 = r5.f2639z
            int r4 = r5.f2606A
            r1.<init>(r0, r2, r3, r4)
            goto L9
        L29:
            int r0 = r5.f2635v
            if (r0 <= 0) goto L30
            r5.m56748l(r0)
        L30:
            int r0 = r5.f2634u
            r1 = 1
            if (r0 == r1) goto L38
            r5.m56772c(r0)
        L38:
            int r0 = r5.f2630q
            if (r0 <= 0) goto L3f
            r5.m56755g(r0)
        L3f:
            int r0 = r5.f2631r
            if (r0 <= 0) goto L46
            r5.m56749k(r0)
        L46:
            int r0 = r5.f2607B
            if (r0 <= 0) goto L4d
            r5.m56765d(r0)
        L4d:
            int r0 = r5.f2608C
            if (r0 <= 0) goto L54
            r5.m56753h(r0)
        L54:
            int r0 = r5.f2632s
            r5.m56761e(r0)
            int r0 = r5.f2633t
            r5.m56751i(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.banner.Banner.m56754h():void");
    }

    /* renamed from: i */
    private void m56752i() {
        if (!m56781b()) {
            m56782a(false);
        }
        m56745o(m56781b() ? 1 : 0);
    }

    private void setRecyclerViewPadding(int i) {
        m56771c(i, i);
    }

    /* renamed from: a */
    public Banner m56807a(float f) {
        this.f2629p = f;
        return this;
    }

    /* renamed from: a */
    public Banner m56806a(int i) {
        return m56805a(i, 0.88f);
    }

    /* renamed from: a */
    public Banner m56805a(int i, float f) {
        if (f < 1.0f && f > 0.0f) {
            m56792a(new C1460d(f));
        }
        setRecyclerViewPadding((int) C1468b.m56703a(i));
        return this;
    }

    /* renamed from: a */
    public Banner m56804a(int i, int i2) {
        return m56803a(i, i2, 0.85f);
    }

    /* renamed from: a */
    public Banner m56803a(int i, int i2, float f) {
        return m56801a(i, i, i2, f);
    }

    /* renamed from: a */
    public Banner m56802a(int i, int i2, int i3) {
        return m56801a(i, i2, i3, 0.85f);
    }

    /* renamed from: a */
    public Banner m56801a(int i, int i2, int i3, float f) {
        if (i3 > 0) {
            m56792a(new MarginPageTransformer((int) C1468b.m56703a(i3)));
        }
        if (f < 1.0f && f > 0.0f) {
            m56792a(new C1464h(f));
        }
        m56771c(i > 0 ? (int) C1468b.m56703a(i + i3) : 0, i2 > 0 ? (int) C1468b.m56703a(i2 + i3) : 0);
        return this;
    }

    /* renamed from: a */
    public Banner m56800a(int i, boolean z) {
        getViewPager2().setCurrentItem(i, z);
        return this;
    }

    /* renamed from: a */
    public Banner m56799a(long j) {
        this.f2626m = j;
        return this;
    }

    /* renamed from: a */
    public Banner m56795a(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            lifecycleOwner.getLifecycle().addObserver(new BannerLifecycleObserverAdapter(lifecycleOwner, this));
        }
        return this;
    }

    /* renamed from: a */
    public Banner m56794a(RecyclerView.ItemDecoration itemDecoration) {
        getViewPager2().addItemDecoration(itemDecoration);
        return this;
    }

    /* renamed from: a */
    public Banner m56793a(RecyclerView.ItemDecoration itemDecoration, int i) {
        getViewPager2().addItemDecoration(itemDecoration, i);
        return this;
    }

    /* renamed from: a */
    public Banner m56792a(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.f2622i.addTransformer(pageTransformer);
        return this;
    }

    /* renamed from: a */
    public Banner m56790a(BA ba) {
        if (ba != null) {
            this.f2620g = ba;
            if (!m56781b()) {
                this.f2620g.m56735c(0);
            }
            this.f2620g.registerAdapterDataObserver(this.f2616K);
            this.f2617d.setAdapter(ba);
            m56800a(this.f2628o, false);
            m56756g();
            return this;
        }
        throw new NullPointerException(getContext().getString(C1239R.C1245string.banner_adapter_null_error));
    }

    /* renamed from: a */
    public Banner m56789a(BA ba, boolean z) {
        this.f2624k = z;
        m56752i();
        m56790a((Banner<T, BA>) ba);
        return this;
    }

    /* renamed from: a */
    public Banner m56788a(InterfaceC1450c interfaceC1450c) {
        return m56787a(interfaceC1450c, true);
    }

    /* renamed from: a */
    public Banner m56787a(InterfaceC1450c interfaceC1450c, boolean z) {
        m56773c();
        interfaceC1450c.getIndicatorConfig().m56728a(z);
        this.f2621h = interfaceC1450c;
        m56756g();
        return this;
    }

    /* renamed from: a */
    public Banner m56786a(IndicatorConfig.Margins margins) {
        InterfaceC1450c interfaceC1450c = this.f2621h;
        if (interfaceC1450c != null && interfaceC1450c.getIndicatorConfig().m56708l()) {
            this.f2621h.getIndicatorConfig().m56729a(margins);
            this.f2621h.getIndicatorView().requestLayout();
        }
        return this;
    }

    /* renamed from: a */
    public Banner m56785a(InterfaceC1455a interfaceC1455a) {
        if (getAdapter() != null) {
            getAdapter().m56739a(interfaceC1455a);
        }
        return this;
    }

    /* renamed from: a */
    public Banner m56784a(InterfaceC1456b interfaceC1456b) {
        this.f2619f = interfaceC1456b;
        return this;
    }

    /* renamed from: a */
    public Banner m56783a(List<T> list) {
        if (getAdapter() != null) {
            getAdapter().m56738a(list);
            getAdapter().notifyDataSetChanged();
            m56800a(this.f2628o, false);
            m56766d();
            m56762e();
        }
        return this;
    }

    /* renamed from: a */
    public Banner m56782a(boolean z) {
        this.f2625l = z;
        return this;
    }

    /* renamed from: a */
    public void m56808a() {
        if (getViewPager2() != null && this.f2623j != null) {
            getViewPager2().unregisterOnPageChangeCallback(this.f2623j);
            this.f2623j = null;
        }
        m56759f();
    }

    @RequiresApi(api = 21)
    /* renamed from: b */
    public Banner m56780b(float f) {
        C1468b.m56702a(this, f);
        return this;
    }

    /* renamed from: b */
    public Banner m56779b(int i) {
        return m56800a(i, true);
    }

    /* renamed from: b */
    public Banner m56778b(int i, int i2) {
        InterfaceC1450c interfaceC1450c = this.f2621h;
        if (interfaceC1450c != null) {
            interfaceC1450c.getIndicatorConfig().m56716g(i);
            this.f2621h.getIndicatorConfig().m56710j(i2);
        }
        return this;
    }

    /* renamed from: b */
    public Banner m56776b(ViewPager2.PageTransformer pageTransformer) {
        this.f2622i.removeTransformer(pageTransformer);
        return this;
    }

    /* renamed from: b */
    public Banner m56774b(boolean z) {
        this.f2613H = z;
        return this;
    }

    /* renamed from: b */
    public boolean m56781b() {
        return this.f2624k;
    }

    /* renamed from: c */
    public Banner m56773c() {
        InterfaceC1450c interfaceC1450c = this.f2621h;
        if (interfaceC1450c != null) {
            removeView(interfaceC1450c.getIndicatorView());
        }
        return this;
    }

    /* renamed from: c */
    public Banner m56772c(int i) {
        InterfaceC1450c interfaceC1450c = this.f2621h;
        if (interfaceC1450c != null && interfaceC1450c.getIndicatorConfig().m56708l()) {
            this.f2621h.getIndicatorConfig().m56726b(i);
            this.f2621h.getIndicatorView().postInvalidate();
        }
        return this;
    }

    /* renamed from: c */
    public Banner m56769c(@Nullable ViewPager2.PageTransformer pageTransformer) {
        getViewPager2().setPageTransformer(pageTransformer);
        return this;
    }

    /* renamed from: c */
    public Banner m56767c(boolean z) {
        getViewPager2().setUserInputEnabled(z);
        return this;
    }

    /* renamed from: d */
    public Banner m56766d() {
        if (this.f2621h != null) {
            this.f2621h.mo56733a(getRealCount(), C1468b.m56700a(m56781b(), getCurrentItem(), getRealCount()));
        }
        return this;
    }

    /* renamed from: d */
    public Banner<T, BA> m56765d(int i) {
        InterfaceC1450c interfaceC1450c = this.f2621h;
        if (interfaceC1450c != null) {
            interfaceC1450c.getIndicatorConfig().m56724c(i);
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f2629p <= 0.0f) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.f2615J, 31);
        super.dispatchDraw(canvas);
        m56770c(canvas);
        m56764d(canvas);
        m56796a(canvas);
        m56777b(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (getViewPager2().isUserInputEnabled()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 1 || actionMasked == 3 || actionMasked == 4) {
                m56762e();
            } else if (actionMasked == 0) {
                m56759f();
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: e */
    public Banner m56762e() {
        if (this.f2625l) {
            m56759f();
            postDelayed(this.f2618e, this.f2626m);
        }
        return this;
    }

    /* renamed from: e */
    public Banner m56761e(@ColorInt int i) {
        InterfaceC1450c interfaceC1450c = this.f2621h;
        if (interfaceC1450c != null) {
            interfaceC1450c.getIndicatorConfig().m56718f(i);
        }
        return this;
    }

    /* renamed from: f */
    public Banner m56759f() {
        if (this.f2625l) {
            removeCallbacks(this.f2618e);
        }
        return this;
    }

    /* renamed from: f */
    public Banner m56758f(@ColorRes int i) {
        m56761e(ContextCompat.getColor(getContext(), i));
        return this;
    }

    /* renamed from: g */
    public Banner m56755g(int i) {
        InterfaceC1450c interfaceC1450c = this.f2621h;
        if (interfaceC1450c != null) {
            interfaceC1450c.getIndicatorConfig().m56716g(i);
        }
        return this;
    }

    public BA getAdapter() {
        if (this.f2620g == null) {
            C1469c.m56698b(getContext().getString(C1239R.C1245string.banner_adapter_use_error));
        }
        return this.f2620g;
    }

    public int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public InterfaceC1450c getIndicator() {
        if (this.f2621h == null) {
            C1469c.m56698b(getContext().getString(C1239R.C1245string.indicator_null_error));
        }
        return this.f2621h;
    }

    public IndicatorConfig getIndicatorConfig() {
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
        return getAdapter().m56742a();
    }

    public int getScrollTime() {
        return this.f2627n;
    }

    public ViewPager2 getViewPager2() {
        return this.f2617d;
    }

    /* renamed from: h */
    public Banner<T, BA> m56753h(int i) {
        InterfaceC1450c interfaceC1450c = this.f2621h;
        if (interfaceC1450c != null) {
            interfaceC1450c.getIndicatorConfig().m56714h(i);
        }
        return this;
    }

    /* renamed from: i */
    public Banner m56751i(@ColorInt int i) {
        InterfaceC1450c interfaceC1450c = this.f2621h;
        if (interfaceC1450c != null) {
            interfaceC1450c.getIndicatorConfig().m56712i(i);
        }
        return this;
    }

    /* renamed from: j */
    public Banner m56750j(@ColorRes int i) {
        m56751i(ContextCompat.getColor(getContext(), i));
        return this;
    }

    /* renamed from: k */
    public Banner m56749k(int i) {
        InterfaceC1450c interfaceC1450c = this.f2621h;
        if (interfaceC1450c != null) {
            interfaceC1450c.getIndicatorConfig().m56710j(i);
        }
        return this;
    }

    /* renamed from: l */
    public Banner m56748l(int i) {
        InterfaceC1450c interfaceC1450c = this.f2621h;
        if (interfaceC1450c != null) {
            interfaceC1450c.getIndicatorConfig().m56720e(i);
        }
        return this;
    }

    /* renamed from: m */
    public Banner m56747m(int i) {
        getViewPager2().setOrientation(i);
        return this;
    }

    /* renamed from: n */
    public Banner m56746n(int i) {
        this.f2627n = i;
        return this;
    }

    /* renamed from: o */
    public Banner m56745o(int i) {
        this.f2628o = i;
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m56762e();
    }

    @Override // com.acse.ottn.banner.util.InterfaceC1467a
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        m56808a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m56759f();
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
            if (r0 == 0) goto L83
            boolean r0 = r5.f2613H
            if (r0 != 0) goto L10
            goto L83
        L10:
            int r0 = r6.getAction()
            r1 = 1
            if (r0 == 0) goto L6b
            r2 = 0
            if (r0 == r1) goto L63
            r3 = 2
            if (r0 == r3) goto L21
            r1 = 3
            if (r0 == r1) goto L63
            goto L7e
        L21:
            float r0 = r6.getX()
            float r3 = r6.getY()
            float r4 = r5.f2610E
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            float r4 = r5.f2611F
            float r3 = r3 - r4
            float r3 = java.lang.Math.abs(r3)
            androidx.viewpager2.widget.ViewPager2 r4 = r5.getViewPager2()
            int r4 = r4.getOrientation()
            if (r4 != 0) goto L4d
            int r4 = r5.f2609D
            float r4 = (float) r4
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto L59
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L59
            goto L5a
        L4d:
            int r4 = r5.f2609D
            float r4 = (float) r4
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L59
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L59
            goto L5a
        L59:
            r1 = 0
        L5a:
            r5.f2612G = r1
            android.view.ViewParent r0 = r5.getParent()
            boolean r1 = r5.f2612G
            goto L7b
        L63:
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L7e
        L6b:
            float r0 = r6.getX()
            r5.f2610E = r0
            float r0 = r6.getY()
            r5.f2611F = r0
            android.view.ViewParent r0 = r5.getParent()
        L7b:
            r0.requestDisallowInterceptTouchEvent(r1)
        L7e:
            boolean r6 = super.onInterceptTouchEvent(r6)
            return r6
        L83:
            boolean r6 = super.onInterceptTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.banner.Banner.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.acse.ottn.banner.util.InterfaceC1467a
    public void onStart(LifecycleOwner lifecycleOwner) {
        m56762e();
    }

    @Override // com.acse.ottn.banner.util.InterfaceC1467a
    public void onStop(LifecycleOwner lifecycleOwner) {
        m56759f();
    }

    /* renamed from: p */
    public Banner m56744p(int i) {
        this.f2609D = i;
        return this;
    }
}
