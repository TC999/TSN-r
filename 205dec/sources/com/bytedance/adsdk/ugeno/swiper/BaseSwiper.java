package com.bytedance.adsdk.ugeno.swiper;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.swiper.indicator.DotIndicator;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class BaseSwiper<T> extends FrameLayout implements ViewPager.i {

    /* renamed from: a  reason: collision with root package name */
    private boolean f26224a;
    private boolean bk;

    /* renamed from: c  reason: collision with root package name */
    protected List<T> f26225c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private int f26226f;
    private int fp;
    private ViewPager.i fz;
    private float gd;

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f26227i;
    private DotIndicator ia;

    /* renamed from: k  reason: collision with root package name */
    private boolean f26228k;

    /* renamed from: p  reason: collision with root package name */
    private boolean f26229p;

    /* renamed from: r  reason: collision with root package name */
    private int f26230r;

    /* renamed from: s  reason: collision with root package name */
    private c f26231s;
    private int sr;

    /* renamed from: t  reason: collision with root package name */
    private int f26232t;

    /* renamed from: u  reason: collision with root package name */
    private final Runnable f26233u;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    protected ViewPager f26234w;
    private int xv;
    private int ys;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int currentItem = BaseSwiper.this.f26234w.getCurrentItem() + 1;
            if (BaseSwiper.this.f26224a) {
                if (currentItem >= Integer.MAX_VALUE) {
                    BaseSwiper.this.f26234w.m(1073741823, false);
                } else {
                    BaseSwiper.this.f26234w.m(currentItem, true);
                }
            } else if (currentItem >= BaseSwiper.this.f26234w.getAdapter().b()) {
                BaseSwiper.this.f26234w.m(0, false);
            } else {
                BaseSwiper.this.f26234w.m(currentItem, true);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BaseSwiper.this.f26228k) {
                int currentItem = BaseSwiper.this.f26234w.getCurrentItem() + 1;
                if (BaseSwiper.this.f26224a) {
                    if (currentItem >= Integer.MAX_VALUE) {
                        BaseSwiper.this.f26234w.m(1073741823, false);
                    } else {
                        BaseSwiper.this.f26234w.m(currentItem, true);
                    }
                    BaseSwiper baseSwiper = BaseSwiper.this;
                    baseSwiper.postDelayed(baseSwiper.f26227i, BaseSwiper.this.xv);
                } else if (currentItem >= BaseSwiper.this.f26234w.getAdapter().b()) {
                    BaseSwiper.this.f26234w.m(0, false);
                    BaseSwiper baseSwiper2 = BaseSwiper.this;
                    baseSwiper2.postDelayed(baseSwiper2.f26227i, BaseSwiper.this.xv);
                } else {
                    BaseSwiper.this.f26234w.m(currentItem, true);
                    BaseSwiper baseSwiper3 = BaseSwiper.this;
                    baseSwiper3.postDelayed(baseSwiper3.f26227i, BaseSwiper.this.xv);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c extends com.bytedance.adsdk.ugeno.viewpager.a {
        c() {
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.a
        public float a(int i4) {
            if (BaseSwiper.this.gd <= 0.0f) {
                return 1.0f;
            }
            return 1.0f / BaseSwiper.this.gd;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.a
        public int b() {
            if (BaseSwiper.this.f26224a) {
                return Integer.MAX_VALUE;
            }
            return BaseSwiper.this.f26225c.size();
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.a
        public int c(Object obj) {
            return -2;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.a
        public Object e(ViewGroup viewGroup, int i4) {
            View c4 = BaseSwiper.this.c(i4, com.bytedance.adsdk.ugeno.swiper.a.a(BaseSwiper.this.f26224a, i4, BaseSwiper.this.f26225c.size()));
            viewGroup.addView(c4);
            return c4;
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.a
        public void k(ViewGroup viewGroup, int i4, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.a
        public boolean l(View view, Object obj) {
            return view == obj;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class d extends ViewPager {
        public d(Context context) {
            super(context);
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (BaseSwiper.this.bk) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
    }

    public BaseSwiper(Context context) {
        super(context);
        this.f26225c = new CopyOnWriteArrayList();
        this.xv = 2000;
        this.sr = 500;
        this.ux = 10;
        this.f26226f = -1;
        this.f26230r = -1;
        this.ev = "normal";
        this.gd = 1.0f;
        this.f26229p = true;
        this.f26228k = true;
        this.f26224a = true;
        this.bk = true;
        this.f26232t = 0;
        this.ys = 0;
        this.fp = 0;
        this.f26233u = new a();
        this.f26227i = new b();
        this.f26234w = new d(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.f26234w, layoutParams);
        DotIndicator dotIndicator = new DotIndicator(context);
        this.ia = dotIndicator;
        addView(dotIndicator);
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.i
    public void c(int i4, float f4, int i5) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f26228k) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                w();
            } else if (action == 0) {
                xv();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.i
    public void ev(int i4) {
        ViewPager.i iVar = this.fz;
        if (iVar != null) {
            iVar.ev(com.bytedance.adsdk.ugeno.swiper.a.a(this.f26224a, i4, this.f26225c.size()));
        }
        if (this.f26229p) {
            this.ia.b(i4);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.i
    public void gd(int i4) {
    }

    public com.bytedance.adsdk.ugeno.viewpager.a getAdapter() {
        return this.f26234w.getAdapter();
    }

    public int getCurrentItem() {
        return this.f26234w.getCurrentItem();
    }

    public ViewPager getViewPager() {
        return this.f26234w;
    }

    public void k(int i4) {
        removeCallbacks(this.f26233u);
        postDelayed(this.f26233u, i4);
    }

    public void p(int i4) {
        c(this.ev, this.ux, this.f26226f, this.f26230r, true);
        if (this.f26231s == null) {
            this.f26231s = new c();
            this.f26234w.r(this);
            this.f26234w.setAdapter(this.f26231s);
        }
        if (i4 < 0 || i4 >= this.f26225c.size()) {
            return;
        }
        this.f26234w.m(i4, true);
    }

    public abstract View r(int i4);

    public void setOnPageChangeListener(ViewPager.i iVar) {
        this.fz = iVar;
    }

    public BaseSwiper f(int i4) {
        this.f26230r = i4;
        c(this.ev, this.ux, this.f26226f, i4, true);
        return this;
    }

    public BaseSwiper sr(boolean z3) {
        this.ia.setLoop(z3);
        if (this.f26224a != z3) {
            int a4 = com.bytedance.adsdk.ugeno.swiper.a.a(z3, this.f26234w.getCurrentItem(), this.f26225c.size());
            this.f26224a = z3;
            c cVar = this.f26231s;
            if (cVar != null) {
                cVar.r();
                this.f26234w.setCurrentItem(a4);
            }
        }
        return this;
    }

    public BaseSwiper ux(int i4) {
        this.f26226f = i4;
        c(this.ev, this.ux, i4, this.f26230r, true);
        return this;
    }

    public BaseSwiper w(boolean z3) {
        this.bk = z3;
        return this;
    }

    public BaseSwiper xv(boolean z3) {
        this.f26229p = z3;
        return this;
    }

    public BaseSwiper c(boolean z3) {
        this.f26228k = z3;
        w();
        return this;
    }

    public BaseSwiper w(int i4) {
        this.ia.setSelectedColor(i4);
        return this;
    }

    public BaseSwiper xv(int i4) {
        this.ia.setUnSelectedColor(i4);
        return this;
    }

    public void ux() {
        removeCallbacks(this.f26233u);
    }

    public void w() {
        removeCallbacks(this.f26227i);
        postDelayed(this.f26227i, this.xv);
    }

    public void xv() {
        removeCallbacks(this.f26227i);
    }

    public BaseSwiper c(int i4) {
        this.xv = i4;
        w();
        return this;
    }

    public BaseSwiper c(float f4) {
        this.gd = f4;
        return this;
    }

    public BaseSwiper c(String str) {
        this.ev = str;
        c(str, this.ux, this.f26226f, this.f26230r, true);
        return this;
    }

    public BaseSwiper sr(int i4) {
        this.ux = i4;
        c(this.ev, i4, this.f26226f, this.f26230r, true);
        return this;
    }

    public void c(String str, int i4, int i5, int i6, boolean z3) {
        c cVar = this.f26231s;
        if (cVar != null) {
            cVar.r();
        }
        setClipChildren(false);
        this.f26234w.setClipChildren(false);
        this.f26234w.setPageMargin(i4);
        ViewGroup.LayoutParams layoutParams = this.f26234w.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = i5 + i4;
            marginLayoutParams.rightMargin = i6 + i4;
            this.f26234w.setLayoutParams(layoutParams);
        }
        if (TextUtils.equals(str, "linear")) {
            this.f26234w.u(false, new com.bytedance.adsdk.ugeno.swiper.c.a());
        } else {
            this.f26234w.u(false, null);
        }
        this.f26234w.setOffscreenPageLimit((int) this.gd);
    }

    public void sr() {
        int i4;
        c(this.ev, this.ux, this.f26226f, this.f26230r, true);
        if (this.f26231s == null) {
            this.f26231s = new c();
            this.f26234w.r(this);
            this.f26234w.setAdapter(this.f26231s);
        }
        int i5 = this.f26232t;
        if (i5 < 0 || i5 >= this.f26225c.size()) {
            this.f26232t = 0;
        }
        if (this.f26224a) {
            i4 = this.f26232t + 1073741823;
        } else {
            i4 = this.f26232t;
        }
        this.f26234w.m(i4, true);
    }

    public void c() {
        int i4;
        c(this.ev, this.ux, this.f26226f, this.f26230r, true);
        if (this.f26231s == null) {
            this.f26231s = new c();
            this.f26234w.r(this);
            this.f26234w.setAdapter(this.f26231s);
        }
        int i5 = this.f26232t;
        if (i5 < 0 || i5 >= this.f26225c.size()) {
            this.f26232t = 0;
        }
        if (this.f26224a) {
            i4 = this.f26232t + 1073741823;
        } else {
            i4 = this.f26232t;
        }
        this.f26234w.m(i4, true);
        if (this.f26228k) {
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View c(int i4, int i5) {
        if (this.f26225c.size() == 0) {
            return new View(getContext());
        }
        View r3 = r(i5);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (r3 instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (r3.getParent() instanceof ViewGroup) {
            ((ViewGroup) r3.getParent()).removeView(r3);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(r3, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public BaseSwiper<T> c(T t3) {
        if (t3 != null) {
            this.f26225c.add(t3);
            if (this.f26229p) {
                this.ia.e();
            }
        }
        c cVar = this.f26231s;
        if (cVar != null) {
            cVar.r();
            this.ia.c(this.f26232t, this.f26234w.getCurrentItem());
        }
        return this;
    }
}
