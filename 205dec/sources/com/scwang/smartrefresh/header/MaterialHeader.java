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
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.material.CircleImageView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.c;
import r0.e;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MaterialHeader extends ViewGroup implements e {

    /* renamed from: k  reason: collision with root package name */
    public static final int f47535k = 0;

    /* renamed from: l  reason: collision with root package name */
    public static final int f47536l = 1;

    /* renamed from: m  reason: collision with root package name */
    private static final int f47537m = -328966;

    /* renamed from: n  reason: collision with root package name */
    private static final float f47538n = 0.8f;
    @VisibleForTesting

    /* renamed from: o  reason: collision with root package name */
    private static final int f47539o = 40;
    @VisibleForTesting

    /* renamed from: p  reason: collision with root package name */
    private static final int f47540p = 56;

    /* renamed from: a  reason: collision with root package name */
    private boolean f47541a;

    /* renamed from: b  reason: collision with root package name */
    private int f47542b;

    /* renamed from: c  reason: collision with root package name */
    private CircleImageView f47543c;

    /* renamed from: d  reason: collision with root package name */
    private MaterialProgressDrawable f47544d;

    /* renamed from: e  reason: collision with root package name */
    private int f47545e;

    /* renamed from: f  reason: collision with root package name */
    private int f47546f;

    /* renamed from: g  reason: collision with root package name */
    private Path f47547g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f47548h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f47549i;

    /* renamed from: j  reason: collision with root package name */
    private RefreshState f47550j;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f47551a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f47551a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47551a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47551a[RefreshState.ReleaseToRefresh.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47551a[RefreshState.Refreshing.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public MaterialHeader(Context context) {
        super(context);
        this.f47549i = false;
        q(context, null);
    }

    private void q(Context context, AttributeSet attributeSet) {
        setMinimumHeight(c.b(100.0f));
        MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(context, this);
        this.f47544d = materialProgressDrawable;
        materialProgressDrawable.f(-328966);
        this.f47544d.setAlpha(255);
        this.f47544d.g(-16737844, -48060, -10053376, -5609780, -30720);
        CircleImageView circleImageView = new CircleImageView(context, -328966);
        this.f47543c = circleImageView;
        circleImageView.setImageDrawable(this.f47544d);
        this.f47543c.setVisibility(8);
        addView(this.f47543c);
        this.f47542b = (int) (getResources().getDisplayMetrics().density * 40.0f);
        this.f47547g = new Path();
        Paint paint = new Paint();
        this.f47548h = paint;
        paint.setAntiAlias(true);
        this.f47548h.setStyle(Paint.Style.FILL);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialHeader);
        this.f47549i = obtainStyledAttributes.getBoolean(R.styleable.MaterialHeader_mhShowBezierWave, this.f47549i);
        this.f47548h.setColor(obtainStyledAttributes.getColor(R.styleable.MaterialHeader_mhPrimaryColor, -15614977));
        int i4 = R.styleable.MaterialHeader_mhShadowRadius;
        if (obtainStyledAttributes.hasValue(i4)) {
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(i4, 0);
            this.f47548h.setShadowLayer(dimensionPixelOffset, 0.0f, 0.0f, obtainStyledAttributes.getColor(R.styleable.MaterialHeader_mhShadowColor, -16777216));
            setLayerType(1, null);
        }
        obtainStyledAttributes.recycle();
    }

    public MaterialHeader A(int i4) {
        if (i4 == 0 || i4 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i4 == 0) {
                this.f47542b = (int) (displayMetrics.density * 56.0f);
            } else {
                this.f47542b = (int) (displayMetrics.density * 40.0f);
            }
            this.f47543c.setImageDrawable(null);
            this.f47544d.o(i4);
            this.f47543c.setImageDrawable(this.f47544d);
            return this;
        }
        return this;
    }

    @Override // s0.f
    public void b(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f47550j = refreshState2;
        if (a.f47551a[refreshState2.ordinal()] != 2) {
            return;
        }
        this.f47541a = false;
        this.f47543c.setVisibility(0);
        this.f47543c.setScaleX(1.0f);
        this.f47543c.setScaleY(1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f47549i) {
            this.f47547g.reset();
            this.f47547g.lineTo(0.0f, this.f47546f);
            this.f47547g.quadTo(getMeasuredWidth() / 2, this.f47546f + (this.f47545e * 1.9f), getMeasuredWidth(), this.f47546f);
            this.f47547g.lineTo(getMeasuredWidth(), 0.0f);
            canvas.drawPath(this.f47547g, this.f47548h);
        }
        super.dispatchDraw(canvas);
    }

    @Override // r0.f
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.MatchLayout;
    }

    @Override // r0.f
    @NonNull
    public View getView() {
        return this;
    }

    @Override // r0.e
    public void i(float f4, int i4, int i5, int i6) {
        if (!this.f47544d.isRunning() && !this.f47541a) {
            w(f4, i4, i5, i6);
        } else if (this.f47549i) {
            this.f47546f = Math.min(i4, i5);
            this.f47545e = Math.max(0, i4 - i5);
            postInvalidate();
        }
    }

    @Override // r0.e
    public void j(h hVar, int i4, int i5) {
        this.f47544d.start();
        int i6 = i4 / 2;
        if (((int) this.f47543c.getTranslationY()) != (this.f47542b / 2) + i6) {
            this.f47543c.animate().translationY(i6 + (this.f47542b / 2));
        }
    }

    @Override // r0.f
    public void n(float f4, int i4, int i5) {
    }

    @Override // r0.f
    public void o(g gVar, int i4, int i5) {
        if (!this.f47549i) {
            gVar.j(false);
        }
        if (isInEditMode()) {
            int i6 = i4 / 2;
            this.f47546f = i6;
            this.f47545e = i6;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        int i8;
        if (getChildCount() == 0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = this.f47543c.getMeasuredWidth();
        int measuredHeight = this.f47543c.getMeasuredHeight();
        if (isInEditMode() && (i8 = this.f47546f) > 0) {
            int i9 = i8 - (measuredHeight / 2);
            int i10 = measuredWidth / 2;
            int i11 = measuredWidth2 / 2;
            this.f47543c.layout(i10 - i11, i9, i10 + i11, measuredHeight + i9);
            this.f47544d.m(true);
            this.f47544d.k(0.0f, 0.8f);
            this.f47544d.e(1.0f);
            this.f47543c.setAlpha(1.0f);
            this.f47543c.setVisibility(0);
            return;
        }
        int i12 = measuredWidth / 2;
        int i13 = measuredWidth2 / 2;
        int i14 = this.f47542b;
        this.f47543c.layout(i12 - i13, -i14, i12 + i13, measuredHeight - i14);
    }

    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        setMeasuredDimension(View.MeasureSpec.getSize(i4), View.MeasureSpec.getSize(i5));
        this.f47543c.measure(View.MeasureSpec.makeMeasureSpec(this.f47542b, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f47542b, 1073741824));
    }

    @Override // r0.f
    public boolean p() {
        return false;
    }

    public MaterialHeader s(int... iArr) {
        this.f47544d.g(iArr);
        return this;
    }

    @Override // r0.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.f47548h.setColor(iArr[0]);
        }
    }

    @Override // r0.f
    public void u(h hVar, int i4, int i5) {
    }

    @Override // r0.f
    public int v(h hVar, boolean z3) {
        this.f47544d.stop();
        this.f47543c.animate().scaleX(0.0f).scaleY(0.0f);
        this.f47541a = true;
        return 0;
    }

    @Override // r0.e
    public void w(float f4, int i4, int i5, int i6) {
        if (this.f47549i) {
            this.f47546f = Math.min(i4, i5);
            this.f47545e = Math.max(0, i4 - i5);
            postInvalidate();
        }
        if (this.f47550j != RefreshState.Refreshing) {
            float f5 = i5;
            float f6 = (i4 * 1.0f) / f5;
            double min = Math.min(1.0f, Math.abs(f6));
            Double.isNaN(min);
            float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
            double max2 = Math.max(0.0f, Math.min(Math.abs(i4) - i5, f5 * 2.0f) / f5) / 4.0f;
            double pow = Math.pow(max2, 2.0d);
            Double.isNaN(max2);
            this.f47544d.m(true);
            this.f47544d.k(0.0f, Math.min(0.8f, max * 0.8f));
            this.f47544d.e(Math.min(1.0f, max));
            this.f47544d.h((((max * 0.4f) - 0.25f) + (((float) (max2 - pow)) * 2.0f * 2.0f)) * 0.5f);
            this.f47543c.setAlpha(Math.min(1.0f, f6 * 2.0f));
        }
        this.f47543c.setTranslationY(Math.min(i4, (i4 / 2) + (this.f47542b / 2)));
    }

    public MaterialHeader z(boolean z3) {
        this.f47549i = z3;
        return this;
    }

    public MaterialHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47549i = false;
        q(context, attributeSet);
    }

    public MaterialHeader(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f47549i = false;
        q(context, attributeSet);
    }

    @RequiresApi(21)
    public MaterialHeader(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f47549i = false;
        q(context, attributeSet);
    }
}
