package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ballpulse.BallPulseView;
import com.scwang.smartrefresh.layout.util.c;
import r0.d;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class BallPulseFooter extends ViewGroup implements d {

    /* renamed from: a  reason: collision with root package name */
    private BallPulseView f47926a;

    /* renamed from: b  reason: collision with root package name */
    private SpinnerStyle f47927b;

    public BallPulseFooter(@NonNull Context context) {
        super(context);
        this.f47927b = SpinnerStyle.Translate;
        q(context, null, 0);
    }

    private void q(Context context, AttributeSet attributeSet, int i4) {
        BallPulseView ballPulseView = new BallPulseView(context);
        this.f47926a = ballPulseView;
        addView(ballPulseView, -2, -2);
        setMinimumHeight(c.b(60.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BallPulseFooter);
        int color = obtainStyledAttributes.getColor(R.styleable.BallPulseFooter_srlPrimaryColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.BallPulseFooter_srlAccentColor, 0);
        if (color != 0) {
            this.f47926a.setNormalColor(color);
        }
        if (color2 != 0) {
            this.f47926a.setAnimatingColor(color2);
        }
        this.f47927b = SpinnerStyle.values()[obtainStyledAttributes.getInt(R.styleable.BallPulseFooter_srlClassicsSpinnerStyle, this.f47927b.ordinal())];
        obtainStyledAttributes.recycle();
    }

    public BallPulseFooter A(@ColorInt int i4) {
        this.f47926a.setNormalColor(i4);
        return this;
    }

    public BallPulseFooter B(SpinnerStyle spinnerStyle) {
        this.f47927b = spinnerStyle;
        return this;
    }

    @Override // s0.f
    public void b(h hVar, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Override // r0.d
    public boolean c(boolean z3) {
        return false;
    }

    @Override // r0.d
    public void d(float f4, int i4, int i5, int i6) {
    }

    @Override // r0.d
    public void f(h hVar, int i4, int i5) {
    }

    @Override // r0.f
    public SpinnerStyle getSpinnerStyle() {
        return this.f47927b;
    }

    @Override // r0.f
    @NonNull
    public View getView() {
        return this;
    }

    @Override // r0.f
    public void n(float f4, int i4, int i5) {
    }

    @Override // r0.f
    public void o(g gVar, int i4, int i5) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.f47926a.getMeasuredWidth();
        int measuredHeight2 = this.f47926a.getMeasuredHeight();
        int i8 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i9 = (measuredHeight / 2) - (measuredHeight2 / 2);
        this.f47926a.layout(i8, i9, measuredWidth2 + i8, measuredHeight2 + i9);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        this.f47926a.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i5), Integer.MIN_VALUE));
        setMeasuredDimension(ViewGroup.resolveSize(this.f47926a.getMeasuredWidth(), i4), ViewGroup.resolveSize(this.f47926a.getMeasuredHeight(), i5));
    }

    @Override // r0.f
    public boolean p() {
        return false;
    }

    public BallPulseFooter s(@ColorInt int i4) {
        this.f47926a.setAnimatingColor(i4);
        return this;
    }

    @Override // r0.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 1) {
            this.f47926a.setNormalColor(iArr[1]);
            this.f47926a.setAnimatingColor(iArr[0]);
        } else if (iArr.length > 0) {
            this.f47926a.setNormalColor(ColorUtils.compositeColors(-1711276033, iArr[0]));
            this.f47926a.setAnimatingColor(iArr[0]);
        }
    }

    @Override // r0.d
    public void t(float f4, int i4, int i5, int i6) {
    }

    @Override // r0.f
    public void u(h hVar, int i4, int i5) {
        this.f47926a.d();
    }

    @Override // r0.f
    public int v(h hVar, boolean z3) {
        this.f47926a.e();
        return 0;
    }

    public BallPulseFooter z(@ColorInt int i4) {
        this.f47926a.setIndicatorColor(i4);
        return this;
    }

    public BallPulseFooter(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47927b = SpinnerStyle.Translate;
        q(context, attributeSet, 0);
    }

    public BallPulseFooter(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i4) {
        super(context, attributeSet, i4);
        this.f47927b = SpinnerStyle.Translate;
        q(context, attributeSet, i4);
    }
}
