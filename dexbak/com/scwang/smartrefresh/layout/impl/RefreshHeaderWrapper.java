package com.scwang.smartrefresh.layout.impl;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import p638r0.RefreshHeader;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* renamed from: com.scwang.smartrefresh.layout.impl.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RefreshHeaderWrapper implements RefreshHeader {

    /* renamed from: a */
    private View f33704a;

    /* renamed from: b */
    private SpinnerStyle f33705b;

    public RefreshHeaderWrapper(View view) {
        this.f33704a = view;
    }

    @Override // p642s0.OnStateChangedListener
    /* renamed from: b */
    public void mo329b(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Override // p638r0.RefreshInternal
    @NonNull
    public SpinnerStyle getSpinnerStyle() {
        SpinnerStyle spinnerStyle = this.f33705b;
        if (spinnerStyle != null) {
            return spinnerStyle;
        }
        ViewGroup.LayoutParams layoutParams = this.f33704a.getLayoutParams();
        if (layoutParams instanceof SmartRefreshLayout.C11905o) {
            SpinnerStyle spinnerStyle2 = ((SmartRefreshLayout.C11905o) layoutParams).f33583b;
            this.f33705b = spinnerStyle2;
            if (spinnerStyle2 != null) {
                return spinnerStyle2;
            }
        }
        if (layoutParams != null && layoutParams.height == -1) {
            SpinnerStyle spinnerStyle3 = SpinnerStyle.Scale;
            this.f33705b = spinnerStyle3;
            return spinnerStyle3;
        }
        SpinnerStyle spinnerStyle4 = SpinnerStyle.Translate;
        this.f33705b = spinnerStyle4;
        return spinnerStyle4;
    }

    @Override // p638r0.RefreshInternal
    @NonNull
    public View getView() {
        return this.f33704a;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: i */
    public void mo2102i(float f, int i, int i2, int i3) {
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: j */
    public void mo2101j(RefreshLayout refreshLayout, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: n */
    public void mo2099n(float f, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: o */
    public void mo2098o(RefreshKernel refreshKernel, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f33704a.getLayoutParams();
        if (layoutParams instanceof SmartRefreshLayout.C11905o) {
            refreshKernel.mo2092c(((SmartRefreshLayout.C11905o) layoutParams).f33582a);
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
    }
}
