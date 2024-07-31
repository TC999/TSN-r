package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.utils.Utils;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.material.CircleImageView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.C11925c;
import p638r0.RefreshHeader;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MaterialHeader extends ViewGroup implements RefreshHeader {

    /* renamed from: k */
    public static final int f33116k = 0;

    /* renamed from: l */
    public static final int f33117l = 1;

    /* renamed from: m */
    private static final int f33118m = -328966;

    /* renamed from: n */
    private static final float f33119n = 0.8f;
    @VisibleForTesting

    /* renamed from: o */
    private static final int f33120o = 40;
    @VisibleForTesting

    /* renamed from: p */
    private static final int f33121p = 56;

    /* renamed from: a */
    private boolean f33122a;

    /* renamed from: b */
    private int f33123b;

    /* renamed from: c */
    private CircleImageView f33124c;

    /* renamed from: d */
    private MaterialProgressDrawable f33125d;

    /* renamed from: e */
    private int f33126e;

    /* renamed from: f */
    private int f33127f;

    /* renamed from: g */
    private Path f33128g;

    /* renamed from: h */
    private Paint f33129h;

    /* renamed from: i */
    private boolean f33130i;

    /* renamed from: j */
    private RefreshState f33131j;

    /* renamed from: com.scwang.smartrefresh.header.MaterialHeader$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C11850a {

        /* renamed from: a */
        static final /* synthetic */ int[] f33132a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f33132a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33132a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33132a[RefreshState.ReleaseToRefresh.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33132a[RefreshState.Refreshing.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public MaterialHeader(Context context) {
        super(context);
        this.f33130i = false;
        m20191q(context, null);
    }

    /* renamed from: q */
    private void m20191q(Context context, AttributeSet attributeSet) {
        setMinimumHeight(C11925c.m19766b(100.0f));
        MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(context, this);
        this.f33125d = materialProgressDrawable;
        materialProgressDrawable.m20079f(f33118m);
        this.f33125d.setAlpha(255);
        this.f33125d.m20078g(-16737844, -48060, -10053376, -5609780, -30720);
        CircleImageView circleImageView = new CircleImageView(context, f33118m);
        this.f33124c = circleImageView;
        circleImageView.setImageDrawable(this.f33125d);
        this.f33124c.setVisibility(8);
        addView(this.f33124c);
        this.f33123b = (int) (getResources().getDisplayMetrics().density * 40.0f);
        this.f33128g = new Path();
        Paint paint = new Paint();
        this.f33129h = paint;
        paint.setAntiAlias(true);
        this.f33129h.setStyle(Paint.Style.FILL);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11852R.styleable.MaterialHeader);
        this.f33130i = obtainStyledAttributes.getBoolean(C11852R.styleable.MaterialHeader_mhShowBezierWave, this.f33130i);
        this.f33129h.setColor(obtainStyledAttributes.getColor(C11852R.styleable.MaterialHeader_mhPrimaryColor, -15614977));
        int i = C11852R.styleable.MaterialHeader_mhShadowRadius;
        if (obtainStyledAttributes.hasValue(i)) {
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(i, 0);
            this.f33129h.setShadowLayer(dimensionPixelOffset, 0.0f, 0.0f, obtainStyledAttributes.getColor(C11852R.styleable.MaterialHeader_mhShadowColor, ViewCompat.MEASURED_STATE_MASK));
            setLayerType(1, null);
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: A */
    public MaterialHeader m20192A(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.f33123b = (int) (displayMetrics.density * 56.0f);
            } else {
                this.f33123b = (int) (displayMetrics.density * 40.0f);
            }
            this.f33124c.setImageDrawable(null);
            this.f33125d.m20070o(i);
            this.f33124c.setImageDrawable(this.f33125d);
            return this;
        }
        return this;
    }

    @Override // p642s0.OnStateChangedListener
    /* renamed from: b */
    public void mo329b(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        this.f33131j = refreshState2;
        if (C11850a.f33132a[refreshState2.ordinal()] != 2) {
            return;
        }
        this.f33122a = false;
        this.f33124c.setVisibility(0);
        this.f33124c.setScaleX(1.0f);
        this.f33124c.setScaleY(1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f33130i) {
            this.f33128g.reset();
            this.f33128g.lineTo(0.0f, this.f33127f);
            this.f33128g.quadTo(getMeasuredWidth() / 2, this.f33127f + (this.f33126e * 1.9f), getMeasuredWidth(), this.f33127f);
            this.f33128g.lineTo(getMeasuredWidth(), 0.0f);
            canvas.drawPath(this.f33128g, this.f33129h);
        }
        super.dispatchDraw(canvas);
    }

    @Override // p638r0.RefreshInternal
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.MatchLayout;
    }

    @Override // p638r0.RefreshInternal
    @NonNull
    public View getView() {
        return this;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: i */
    public void mo2102i(float f, int i, int i2, int i3) {
        if (!this.f33125d.isRunning() && !this.f33122a) {
            mo2100w(f, i, i2, i3);
        } else if (this.f33130i) {
            this.f33127f = Math.min(i, i2);
            this.f33126e = Math.max(0, i - i2);
            postInvalidate();
        }
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: j */
    public void mo2101j(RefreshLayout refreshLayout, int i, int i2) {
        this.f33125d.start();
        int i3 = i / 2;
        if (((int) this.f33124c.getTranslationY()) != (this.f33123b / 2) + i3) {
            this.f33124c.animate().translationY(i3 + (this.f33123b / 2));
        }
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: n */
    public void mo2099n(float f, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: o */
    public void mo2098o(RefreshKernel refreshKernel, int i, int i2) {
        if (!this.f33130i) {
            refreshKernel.mo2085j(false);
        }
        if (isInEditMode()) {
            int i3 = i / 2;
            this.f33127f = i3;
            this.f33126e = i3;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (getChildCount() == 0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = this.f33124c.getMeasuredWidth();
        int measuredHeight = this.f33124c.getMeasuredHeight();
        if (isInEditMode() && (i5 = this.f33127f) > 0) {
            int i6 = i5 - (measuredHeight / 2);
            int i7 = measuredWidth / 2;
            int i8 = measuredWidth2 / 2;
            this.f33124c.layout(i7 - i8, i6, i7 + i8, measuredHeight + i6);
            this.f33125d.m20072m(true);
            this.f33125d.m20074k(0.0f, f33119n);
            this.f33125d.m20080e(1.0f);
            this.f33124c.setAlpha(1.0f);
            this.f33124c.setVisibility(0);
            return;
        }
        int i9 = measuredWidth / 2;
        int i10 = measuredWidth2 / 2;
        int i11 = this.f33123b;
        this.f33124c.layout(i9 - i10, -i11, i9 + i10, measuredHeight - i11);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.f33124c.measure(View.MeasureSpec.makeMeasureSpec(this.f33123b, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f33123b, 1073741824));
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: p */
    public boolean mo2097p() {
        return false;
    }

    /* renamed from: s */
    public MaterialHeader m20190s(int... iArr) {
        this.f33125d.m20078g(iArr);
        return this;
    }

    @Override // p638r0.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.f33129h.setColor(iArr[0]);
        }
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: u */
    public void mo2096u(RefreshLayout refreshLayout, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: v */
    public int mo2095v(RefreshLayout refreshLayout, boolean z) {
        this.f33125d.stop();
        this.f33124c.animate().scaleX(0.0f).scaleY(0.0f);
        this.f33122a = true;
        return 0;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: w */
    public void mo2100w(float f, int i, int i2, int i3) {
        if (this.f33130i) {
            this.f33127f = Math.min(i, i2);
            this.f33126e = Math.max(0, i - i2);
            postInvalidate();
        }
        if (this.f33131j != RefreshState.Refreshing) {
            float f2 = i2;
            float f3 = (i * 1.0f) / f2;
            double min = Math.min(1.0f, Math.abs(f3));
            Double.isNaN(min);
            float max = (((float) Math.max(min - 0.4d, (double) Utils.DOUBLE_EPSILON)) * 5.0f) / 3.0f;
            double max2 = Math.max(0.0f, Math.min(Math.abs(i) - i2, f2 * 2.0f) / f2) / 4.0f;
            double pow = Math.pow(max2, 2.0d);
            Double.isNaN(max2);
            float f4 = max * f33119n;
            this.f33125d.m20072m(true);
            this.f33125d.m20074k(0.0f, Math.min((float) f33119n, f4));
            this.f33125d.m20080e(Math.min(1.0f, max));
            this.f33125d.m20077h((((max * 0.4f) - 0.25f) + (((float) (max2 - pow)) * 2.0f * 2.0f)) * 0.5f);
            this.f33124c.setAlpha(Math.min(1.0f, f3 * 2.0f));
        }
        this.f33124c.setTranslationY(Math.min(i, (i / 2) + (this.f33123b / 2)));
    }

    /* renamed from: z */
    public MaterialHeader m20189z(boolean z) {
        this.f33130i = z;
        return this;
    }

    public MaterialHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33130i = false;
        m20191q(context, attributeSet);
    }

    public MaterialHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33130i = false;
        m20191q(context, attributeSet);
    }

    @RequiresApi(21)
    public MaterialHeader(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f33130i = false;
        m20191q(context, attributeSet);
    }
}
