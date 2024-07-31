package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.github.mikephil.charting.utils.Utils;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.waterdrop.WaterDropView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.util.C11925c;
import p638r0.RefreshHeader;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class WaterDropHeader extends ViewGroup implements RefreshHeader {

    /* renamed from: g */
    private static final float f33224g = 0.8f;

    /* renamed from: a */
    private RefreshState f33225a;

    /* renamed from: b */
    private ImageView f33226b;

    /* renamed from: c */
    private WaterDropView f33227c;

    /* renamed from: d */
    private ProgressDrawable f33228d;

    /* renamed from: e */
    private MaterialProgressDrawable f33229e;

    /* renamed from: f */
    private int f33230f;

    /* renamed from: com.scwang.smartrefresh.header.WaterDropHeader$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11859a extends AnimatorListenerAdapter {

        /* renamed from: com.scwang.smartrefresh.header.WaterDropHeader$a$a */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        class C11860a extends AnimatorListenerAdapter {
            C11860a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                WaterDropHeader.this.f33227c.setVisibility(8);
                WaterDropHeader.this.f33227c.setAlpha(1.0f);
            }
        }

        C11859a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            WaterDropHeader.this.f33227c.animate().alpha(0.0f).setListener(new C11860a());
        }
    }

    /* renamed from: com.scwang.smartrefresh.header.WaterDropHeader$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class RunnableC11861b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RefreshLayout f33233a;

        RunnableC11861b(RefreshLayout refreshLayout) {
            this.f33233a = refreshLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            WaterDropHeader waterDropHeader = WaterDropHeader.this;
            waterDropHeader.f33230f = (waterDropHeader.f33230f + 30) % 360;
            WaterDropHeader.this.invalidate();
            if (WaterDropHeader.this.f33225a == RefreshState.Refreshing || WaterDropHeader.this.f33225a == RefreshState.RefreshReleased) {
                this.f33233a.getLayout().postDelayed(this, 100L);
            }
        }
    }

    /* renamed from: com.scwang.smartrefresh.header.WaterDropHeader$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C11862c {

        /* renamed from: a */
        static final /* synthetic */ int[] f33235a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f33235a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33235a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33235a[RefreshState.PullDownCanceled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33235a[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33235a[RefreshState.Refreshing.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33235a[RefreshState.RefreshFinish.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public WaterDropHeader(Context context) {
        super(context);
        this.f33230f = 0;
        m20147B(context);
    }

    /* renamed from: B */
    private void m20147B(Context context) {
        C11925c c11925c = new C11925c();
        WaterDropView waterDropView = new WaterDropView(context);
        this.f33227c = waterDropView;
        addView(waterDropView, -1, -1);
        this.f33227c.m20020e(0);
        ProgressDrawable progressDrawable = new ProgressDrawable();
        this.f33228d = progressDrawable;
        progressDrawable.setBounds(0, 0, c11925c.m19767a(20.0f), c11925c.m19767a(20.0f));
        this.f33226b = new ImageView(context);
        MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(context, this.f33226b);
        this.f33229e = materialProgressDrawable;
        materialProgressDrawable.m20079f(-1);
        this.f33229e.setAlpha(255);
        this.f33229e.m20078g(-1, -16737844, -48060, -10053376, -5609780, -30720);
        this.f33226b.setImageDrawable(this.f33229e);
        addView(this.f33226b, c11925c.m19767a(30.0f), c11925c.m19767a(30.0f));
    }

    @Override // p642s0.OnStateChangedListener
    /* renamed from: b */
    public void mo329b(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        this.f33225a = refreshState2;
        int i = C11862c.f33235a[refreshState2.ordinal()];
        if (i == 1) {
            this.f33227c.setVisibility(0);
        } else if (i == 2) {
            this.f33227c.setVisibility(0);
        } else if (i == 4) {
            this.f33227c.setVisibility(0);
        } else if (i != 6) {
        } else {
            this.f33227c.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f33225a == RefreshState.Refreshing) {
            canvas.save();
            canvas.translate((getWidth() / 2) - (this.f33228d.m19830e() / 2), (this.f33227c.getMaxCircleRadius() + this.f33227c.getPaddingTop()) - (this.f33228d.m19833b() / 2));
            canvas.rotate(this.f33230f, this.f33228d.m19830e() / 2, this.f33228d.m19833b() / 2);
            this.f33228d.draw(canvas);
            canvas.restore();
        }
    }

    @Override // p638r0.RefreshInternal
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
    }

    @Override // p638r0.RefreshInternal
    @NonNull
    public View getView() {
        return this;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: i */
    public void mo2102i(float f, int i, int i2, int i3) {
        RefreshState refreshState = this.f33225a;
        if (refreshState == RefreshState.Refreshing || refreshState == RefreshState.RefreshReleased) {
            return;
        }
        this.f33227c.m20019f(Math.max(i, 0), i2 + i3);
        this.f33227c.postInvalidate();
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: j */
    public void mo2101j(RefreshLayout refreshLayout, int i, int i2) {
        Animator m20024a = this.f33227c.m20024a();
        m20024a.addListener(new C11859a());
        m20024a.start();
        refreshLayout.getLayout().postDelayed(new RunnableC11861b(refreshLayout), 100L);
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: n */
    public void mo2099n(float f, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: o */
    public void mo2098o(RefreshKernel refreshKernel, int i, int i2) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = this.f33227c.getMeasuredWidth();
        int i5 = measuredWidth / 2;
        int i6 = measuredWidth2 / 2;
        int i7 = i5 - i6;
        this.f33227c.layout(i7, 0, i7 + measuredWidth2, this.f33227c.getMeasuredHeight() + 0);
        int measuredWidth3 = this.f33226b.getMeasuredWidth();
        int measuredHeight = this.f33226b.getMeasuredHeight();
        int i8 = measuredWidth3 / 2;
        int i9 = i5 - i8;
        int i10 = i6 - i8;
        int i11 = (measuredWidth2 - measuredWidth3) / 2;
        if (i10 + measuredHeight > this.f33227c.getBottom() - i11) {
            i10 = (this.f33227c.getBottom() - i11) - measuredHeight;
        }
        this.f33226b.layout(i9, i10, measuredWidth3 + i9, measuredHeight + i10);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        ViewGroup.LayoutParams layoutParams = this.f33226b.getLayoutParams();
        this.f33226b.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
        this.f33227c.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), Integer.MIN_VALUE), i2);
        setMeasuredDimension(ViewGroup.resolveSize(Math.max(this.f33226b.getMeasuredWidth(), this.f33227c.getMeasuredHeight()), i), ViewGroup.resolveSize(Math.max(this.f33226b.getMeasuredHeight(), this.f33227c.getMeasuredHeight()), i2));
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: p */
    public boolean mo2097p() {
        return false;
    }

    @Override // p638r0.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.f33227c.setIndicatorColor(iArr[0]);
        }
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: u */
    public void mo2096u(RefreshLayout refreshLayout, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: v */
    public int mo2095v(RefreshLayout refreshLayout, boolean z) {
        return 0;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: w */
    public void mo2100w(float f, int i, int i2, int i3) {
        this.f33227c.m20019f(i, i3 + i2);
        this.f33227c.postInvalidate();
        float f2 = i2;
        double min = Math.min(1.0f, Math.abs((i * 1.0f) / f2));
        Double.isNaN(min);
        float max = (((float) Math.max(min - 0.4d, (double) Utils.DOUBLE_EPSILON)) * 5.0f) / 3.0f;
        double max2 = Math.max(0.0f, Math.min(Math.abs(i) - i2, f2 * 2.0f) / f2) / 4.0f;
        double pow = Math.pow(max2, 2.0d);
        Double.isNaN(max2);
        float f3 = max * f33224g;
        this.f33229e.m20072m(true);
        this.f33229e.m20074k(0.0f, Math.min((float) f33224g, f3));
        this.f33229e.m20080e(Math.min(1.0f, max));
        this.f33229e.m20077h((((0.4f * max) - 0.25f) + (((float) (max2 - pow)) * 2.0f * 2.0f)) * 0.5f);
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33230f = 0;
        m20147B(context);
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33230f = 0;
        m20147B(context);
    }

    @RequiresApi(21)
    public WaterDropHeader(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f33230f = 0;
        m20147B(context);
    }
}
