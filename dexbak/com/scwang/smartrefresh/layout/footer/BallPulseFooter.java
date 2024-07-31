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
import com.scwang.smartrefresh.layout.C11882R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ballpulse.BallPulseView;
import com.scwang.smartrefresh.layout.util.C11925c;
import p638r0.RefreshFooter;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BallPulseFooter extends ViewGroup implements RefreshFooter {

    /* renamed from: a */
    private BallPulseView f33592a;

    /* renamed from: b */
    private SpinnerStyle f33593b;

    public BallPulseFooter(@NonNull Context context) {
        super(context);
        this.f33593b = SpinnerStyle.Translate;
        m19922q(context, null, 0);
    }

    /* renamed from: q */
    private void m19922q(Context context, AttributeSet attributeSet, int i) {
        BallPulseView ballPulseView = new BallPulseView(context);
        this.f33592a = ballPulseView;
        addView(ballPulseView, -2, -2);
        setMinimumHeight(C11925c.m19766b(60.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11882R.styleable.BallPulseFooter);
        int color = obtainStyledAttributes.getColor(C11882R.styleable.BallPulseFooter_srlPrimaryColor, 0);
        int color2 = obtainStyledAttributes.getColor(C11882R.styleable.BallPulseFooter_srlAccentColor, 0);
        if (color != 0) {
            this.f33592a.setNormalColor(color);
        }
        if (color2 != 0) {
            this.f33592a.setAnimatingColor(color2);
        }
        this.f33593b = SpinnerStyle.values()[obtainStyledAttributes.getInt(C11882R.styleable.BallPulseFooter_srlClassicsSpinnerStyle, this.f33593b.ordinal())];
        obtainStyledAttributes.recycle();
    }

    /* renamed from: A */
    public BallPulseFooter m19924A(@ColorInt int i) {
        this.f33592a.setNormalColor(i);
        return this;
    }

    /* renamed from: B */
    public BallPulseFooter m19923B(SpinnerStyle spinnerStyle) {
        this.f33593b = spinnerStyle;
        return this;
    }

    @Override // p642s0.OnStateChangedListener
    /* renamed from: b */
    public void mo329b(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Override // p638r0.RefreshFooter
    /* renamed from: c */
    public boolean mo2106c(boolean z) {
        return false;
    }

    @Override // p638r0.RefreshFooter
    /* renamed from: d */
    public void mo2105d(float f, int i, int i2, int i3) {
    }

    @Override // p638r0.RefreshFooter
    /* renamed from: f */
    public void mo2104f(RefreshLayout refreshLayout, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    public SpinnerStyle getSpinnerStyle() {
        return this.f33593b;
    }

    @Override // p638r0.RefreshInternal
    @NonNull
    public View getView() {
        return this;
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
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.f33592a.getMeasuredWidth();
        int measuredHeight2 = this.f33592a.getMeasuredHeight();
        int i5 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i6 = (measuredHeight / 2) - (measuredHeight2 / 2);
        this.f33592a.layout(i5, i6, measuredWidth2 + i5, measuredHeight2 + i6);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.f33592a.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), Integer.MIN_VALUE));
        setMeasuredDimension(ViewGroup.resolveSize(this.f33592a.getMeasuredWidth(), i), ViewGroup.resolveSize(this.f33592a.getMeasuredHeight(), i2));
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: p */
    public boolean mo2097p() {
        return false;
    }

    /* renamed from: s */
    public BallPulseFooter m19921s(@ColorInt int i) {
        this.f33592a.setAnimatingColor(i);
        return this;
    }

    @Override // p638r0.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 1) {
            this.f33592a.setNormalColor(iArr[1]);
            this.f33592a.setAnimatingColor(iArr[0]);
        } else if (iArr.length > 0) {
            this.f33592a.setNormalColor(ColorUtils.compositeColors(-1711276033, iArr[0]));
            this.f33592a.setAnimatingColor(iArr[0]);
        }
    }

    @Override // p638r0.RefreshFooter
    /* renamed from: t */
    public void mo2103t(float f, int i, int i2, int i3) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: u */
    public void mo2096u(RefreshLayout refreshLayout, int i, int i2) {
        this.f33592a.m19893d();
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: v */
    public int mo2095v(RefreshLayout refreshLayout, boolean z) {
        this.f33592a.m19892e();
        return 0;
    }

    /* renamed from: z */
    public BallPulseFooter m19920z(@ColorInt int i) {
        this.f33592a.setIndicatorColor(i);
        return this;
    }

    public BallPulseFooter(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33593b = SpinnerStyle.Translate;
        m19922q(context, attributeSet, 0);
    }

    public BallPulseFooter(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.f33593b = SpinnerStyle.Translate;
        m19922q(context, attributeSet, i);
    }
}
