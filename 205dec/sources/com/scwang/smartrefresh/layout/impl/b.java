package com.scwang.smartrefresh.layout.impl;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: RefreshFooterWrapper.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b implements r0.d {

    /* renamed from: a  reason: collision with root package name */
    private View f48036a;

    /* renamed from: b  reason: collision with root package name */
    private SpinnerStyle f48037b;

    public b(View view) {
        this.f48036a = view;
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
        SpinnerStyle spinnerStyle = this.f48037b;
        if (spinnerStyle != null) {
            return spinnerStyle;
        }
        ViewGroup.LayoutParams layoutParams = this.f48036a.getLayoutParams();
        if (layoutParams instanceof SmartRefreshLayout.o) {
            SpinnerStyle spinnerStyle2 = ((SmartRefreshLayout.o) layoutParams).f47917b;
            this.f48037b = spinnerStyle2;
            if (spinnerStyle2 != null) {
                return spinnerStyle2;
            }
        }
        if (layoutParams != null && layoutParams.height == 0) {
            SpinnerStyle spinnerStyle3 = SpinnerStyle.Scale;
            this.f48037b = spinnerStyle3;
            return spinnerStyle3;
        }
        SpinnerStyle spinnerStyle4 = SpinnerStyle.Translate;
        this.f48037b = spinnerStyle4;
        return spinnerStyle4;
    }

    @Override // r0.f
    @NonNull
    public View getView() {
        return this.f48036a;
    }

    @Override // r0.f
    public void n(float f4, int i4, int i5) {
    }

    @Override // r0.f
    public void o(g gVar, int i4, int i5) {
        ViewGroup.LayoutParams layoutParams = this.f48036a.getLayoutParams();
        if (layoutParams instanceof SmartRefreshLayout.o) {
            gVar.l(((SmartRefreshLayout.o) layoutParams).f47916a);
        }
    }

    @Override // r0.f
    public boolean p() {
        return false;
    }

    @Override // r0.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
    }

    @Override // r0.d
    public void t(float f4, int i4, int i5, int i6) {
    }

    @Override // r0.f
    public void u(h hVar, int i4, int i5) {
    }

    @Override // r0.f
    public int v(h hVar, boolean z3) {
        return 0;
    }
}
