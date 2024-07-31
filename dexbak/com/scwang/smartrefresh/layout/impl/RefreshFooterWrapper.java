package com.scwang.smartrefresh.layout.impl;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import p638r0.RefreshFooter;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* renamed from: com.scwang.smartrefresh.layout.impl.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RefreshFooterWrapper implements RefreshFooter {

    /* renamed from: a */
    private View f33702a;

    /* renamed from: b */
    private SpinnerStyle f33703b;

    public RefreshFooterWrapper(View view) {
        this.f33702a = view;
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
        SpinnerStyle spinnerStyle = this.f33703b;
        if (spinnerStyle != null) {
            return spinnerStyle;
        }
        ViewGroup.LayoutParams layoutParams = this.f33702a.getLayoutParams();
        if (layoutParams instanceof SmartRefreshLayout.C11905o) {
            SpinnerStyle spinnerStyle2 = ((SmartRefreshLayout.C11905o) layoutParams).f33583b;
            this.f33703b = spinnerStyle2;
            if (spinnerStyle2 != null) {
                return spinnerStyle2;
            }
        }
        if (layoutParams != null && layoutParams.height == 0) {
            SpinnerStyle spinnerStyle3 = SpinnerStyle.Scale;
            this.f33703b = spinnerStyle3;
            return spinnerStyle3;
        }
        SpinnerStyle spinnerStyle4 = SpinnerStyle.Translate;
        this.f33703b = spinnerStyle4;
        return spinnerStyle4;
    }

    @Override // p638r0.RefreshInternal
    @NonNull
    public View getView() {
        return this.f33702a;
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: n */
    public void mo2099n(float f, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: o */
    public void mo2098o(RefreshKernel refreshKernel, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f33702a.getLayoutParams();
        if (layoutParams instanceof SmartRefreshLayout.C11905o) {
            refreshKernel.mo2083l(((SmartRefreshLayout.C11905o) layoutParams).f33582a);
        }
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: p */
    public boolean mo2097p() {
        return false;
    }

    @Override // p638r0.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
    }

    @Override // p638r0.RefreshFooter
    /* renamed from: t */
    public void mo2103t(float f, int i, int i2, int i3) {
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
}
