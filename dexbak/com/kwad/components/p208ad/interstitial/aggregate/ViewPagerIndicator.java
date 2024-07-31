package com.kwad.components.p208ad.interstitial.aggregate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.p430d.p431a.C10751a;

/* renamed from: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ViewPagerIndicator extends View {

    /* renamed from: iU */
    private int f26038iU;

    /* renamed from: ja */
    private int f26039ja;

    /* renamed from: jb */
    private int f26040jb;

    /* renamed from: jc */
    private int f26041jc;

    /* renamed from: jd */
    private float f26042jd;

    /* renamed from: je */
    private float f26043je;

    /* renamed from: jf */
    private Paint f26044jf;

    /* renamed from: jg */
    private float f26045jg;

    /* renamed from: jh */
    private float f26046jh;

    /* renamed from: ji */
    private float f26047ji;

    /* renamed from: jj */
    private int f26048jj;

    /* renamed from: jk */
    private Paint f26049jk;

    /* renamed from: jl */
    private float f26050jl;

    /* renamed from: jm */
    private boolean f26051jm;

    /* renamed from: jn */
    private InterfaceC7692a f26052jn;

    /* renamed from: jo */
    private ValueAnimator f26053jo;
    private final Context mContext;

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7692a {
        /* renamed from: cw */
        void mo32589cw();
    }

    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    /* renamed from: cA */
    private void m32630cA() {
        Paint paint = new Paint(1);
        this.f26044jf = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f26044jf.setStrokeWidth(1.0f);
        this.f26044jf.setColor(this.f26040jb);
        Paint paint2 = new Paint(1);
        this.f26049jk = paint2;
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f26049jk.setStrokeWidth(1.0f);
        this.f26049jk.setColor(this.f26039ja);
    }

    /* renamed from: cB */
    private void m32629cB() {
        if (this.f26048jj <= 0) {
            setVisibility(8);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f26047ji, this.f26046jh);
        this.f26053jo = ofFloat;
        ofFloat.setDuration(this.f26048jj * 1000);
        this.f26053jo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewPagerIndicator.this.f26050jl = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewPagerIndicator.this.invalidate();
            }
        });
        this.f26053jo.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                ViewPagerIndicator.m32633a(ViewPagerIndicator.this, true);
                if (ViewPagerIndicator.this.f26052jn != null) {
                    ViewPagerIndicator.this.f26052jn.mo32589cw();
                }
            }
        });
        this.f26053jo.start();
    }

    @RequiresApi(api = 19)
    /* renamed from: cC */
    public final void m32628cC() {
        ValueAnimator valueAnimator = this.f26053jo;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    @RequiresApi(api = 19)
    /* renamed from: cD */
    public final void m32627cD() {
        ValueAnimator valueAnimator = this.f26053jo;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m32637a(canvas);
        m32632b(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? (int) this.f26045jg : 0;
        }
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                int i3 = this.f26041jc;
                if (i3 > 1) {
                    size = (int) (this.f26046jh + ((i3 - 1) * (this.f26043je + this.f26047ji)));
                } else {
                    size = (int) this.f26046jh;
                }
            } else {
                size = 0;
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setFirstAdShowTime(int i) {
        this.f26048jj = i;
    }

    public void setPlayProgressListener(InterfaceC7692a interfaceC7692a) {
        this.f26052jn = interfaceC7692a;
    }

    public void setViewPager(ViewPager viewPager) {
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null) {
            return;
        }
        int count = adapter.getCount();
        this.f26041jc = count;
        if (count <= 1) {
            return;
        }
        this.f26051jm = false;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i, float f, int i2) {
                ViewPagerIndicator.this.f26038iU = i;
                ViewPagerIndicator.this.f26042jd = f;
                ViewPagerIndicator.this.invalidate();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i) {
                ViewPagerIndicator.this.f26038iU = i;
                ViewPagerIndicator.this.f26042jd = 0.0f;
                ViewPagerIndicator.this.invalidate();
            }
        });
        m32629cB();
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: b */
    private void m32632b(Canvas canvas) {
        if (this.f26051jm || this.f26038iU != 0) {
            return;
        }
        RectF rectF = new RectF(0.0f, 0.0f, this.f26050jl, this.f26045jg);
        float f = this.f26045jg;
        canvas.drawRoundRect(rectF, f / 2.0f, f / 2.0f, this.f26049jk);
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        setWillNotDraw(false);
        m32638a(context, attributeSet, i);
        m32630cA();
    }

    /* renamed from: a */
    static /* synthetic */ boolean m32633a(ViewPagerIndicator viewPagerIndicator, boolean z) {
        viewPagerIndicator.f26051jm = true;
        return true;
    }

    @SuppressLint({"CustomViewStyleable"})
    /* renamed from: a */
    private void m32638a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C9659R.styleable.ksad_ViewPagerIndicator, i, 0);
        this.f26043je = obtainStyledAttributes.getDimension(C9659R.styleable.ksad_ViewPagerIndicator_ksad_dot_distance, C10751a.m24924a(this.mContext, 5.0f));
        this.f26045jg = obtainStyledAttributes.getDimension(C9659R.styleable.ksad_ViewPagerIndicator_ksad_dot_height, C10751a.m24924a(this.mContext, 6.0f));
        this.f26046jh = obtainStyledAttributes.getDimension(C9659R.styleable.ksad_ViewPagerIndicator_ksad_dot_selected_width, C10751a.m24924a(this.mContext, 50.0f));
        this.f26047ji = obtainStyledAttributes.getDimension(C9659R.styleable.ksad_ViewPagerIndicator_ksad_dot_unselected_width, C10751a.m24924a(this.mContext, 6.0f));
        this.f26040jb = obtainStyledAttributes.getColor(C9659R.styleable.ksad_ViewPagerIndicator_ksad_default_color, getResources().getColor(C9659R.C9660color.ksad_88_white));
        this.f26039ja = obtainStyledAttributes.getColor(C9659R.styleable.ksad_ViewPagerIndicator_ksad_height_color, getResources().getColor(C9659R.C9660color.ksad_white));
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m32637a(Canvas canvas) {
        RectF rectF = new RectF();
        for (int i = 0; i < this.f26041jc; i++) {
            int i2 = this.f26038iU;
            if (i < i2) {
                float f = this.f26043je;
                float f2 = this.f26047ji;
                float f3 = i * (f + f2);
                rectF.left = f3;
                rectF.right = f3 + f2;
                this.f26044jf.setColor(this.f26040jb);
            } else if (i == i2) {
                float f4 = this.f26043je;
                float f5 = this.f26047ji;
                float f6 = i * (f4 + f5);
                rectF.left = f6;
                rectF.right = f6 + f5 + ((this.f26046jh - f5) * (1.0f - this.f26042jd));
                if (this.f26051jm) {
                    this.f26044jf.setColor(this.f26039ja);
                    this.f26044jf.setAlpha((int) (((1.0f - this.f26042jd) * 127.0f) + 127.0f));
                } else {
                    this.f26044jf.setColor(this.f26040jb);
                }
            } else if (i == i2 + 1) {
                float f7 = this.f26043je;
                float f8 = this.f26047ji;
                float f9 = this.f26046jh;
                float f10 = this.f26042jd;
                float f11 = ((i - 1) * (f7 + f8)) + f8 + ((f9 - f8) * (1.0f - f10)) + f7;
                rectF.left = f11;
                rectF.right = f11 + (f10 * (f9 - f8)) + f8;
                if (this.f26051jm) {
                    this.f26044jf.setColor(this.f26039ja);
                    this.f26044jf.setAlpha((int) (255.0f - ((1.0f - this.f26042jd) * 127.0f)));
                } else {
                    this.f26044jf.setColor(this.f26040jb);
                }
            } else {
                float f12 = this.f26043je;
                float f13 = this.f26047ji;
                float f14 = ((i - 1) * (f12 + f13)) + f12 + this.f26046jh;
                rectF.left = f14;
                rectF.right = f14 + f13;
                this.f26044jf.setColor(this.f26040jb);
            }
            rectF.top = 0.0f;
            float f15 = this.f26045jg;
            rectF.bottom = 0.0f + f15;
            canvas.drawRoundRect(rectF, f15 / 2.0f, f15 / 2.0f, this.f26044jf);
        }
    }
}
