package com.scwang.smartrefresh.header.fungame;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.github.mikephil.charting.utils.Utils;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import p638r0.RefreshContent;
import p638r0.RefreshHeader;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class FunGameBase extends FrameLayout implements RefreshHeader {

    /* renamed from: a */
    protected int f33291a;

    /* renamed from: b */
    protected int f33292b;

    /* renamed from: c */
    protected int f33293c;

    /* renamed from: d */
    protected float f33294d;

    /* renamed from: e */
    protected boolean f33295e;

    /* renamed from: f */
    protected boolean f33296f;

    /* renamed from: g */
    protected boolean f33297g;

    /* renamed from: h */
    protected RefreshState f33298h;

    /* renamed from: i */
    protected RefreshKernel f33299i;

    /* renamed from: j */
    protected RefreshContent f33300j;

    /* renamed from: k */
    boolean f33301k;

    public FunGameBase(Context context) {
        super(context);
        m20109q(context);
    }

    /* renamed from: q */
    private void m20109q(Context context) {
        this.f33293c = context.getResources().getDisplayMetrics().heightPixels;
    }

    /* renamed from: A */
    protected void m20110A() {
        if (this.f33297g) {
            return;
        }
        this.f33297g = true;
        this.f33300j = this.f33299i.mo2084k();
        this.f33301k = this.f33299i.mo2081n().mo2059U();
        this.f33299i.mo2081n().mo2064P(false);
        View view = this.f33300j.getView();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin += this.f33292b;
        view.setLayoutParams(marginLayoutParams);
    }

    @Override // p642s0.OnStateChangedListener
    /* renamed from: b */
    public void mo329b(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        this.f33298h = refreshState2;
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
        mo2100w(f, i, i2, i3);
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
        this.f33299i = refreshKernel;
        this.f33292b = i;
        setTranslationY(this.f33291a - i);
        refreshKernel.mo2088g(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f33299i = null;
        this.f33300j = null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f33298h == RefreshState.Refreshing || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        RefreshState refreshState = this.f33298h;
        if (refreshState != RefreshState.Refreshing && refreshState != RefreshState.RefreshFinish) {
            return super.onTouchEvent(motionEvent);
        }
        if (!this.f33297g) {
            m20110A();
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawY = motionEvent.getRawY() - this.f33294d;
                    if (rawY >= 0.0f) {
                        double d = this.f33292b * 2;
                        double d2 = (this.f33293c * 2) / 3;
                        double d3 = rawY;
                        Double.isNaN(d3);
                        double max = Math.max((double) Utils.DOUBLE_EPSILON, d3 * 0.5d);
                        Double.isNaN(d2);
                        Double.isNaN(d);
                        this.f33299i.mo2086i((int) Math.min(d * (1.0d - Math.pow(100.0d, (-max) / d2)), max), false);
                    } else {
                        double d4 = this.f33292b * 2;
                        double d5 = (this.f33293c * 2) / 3;
                        double d6 = rawY;
                        Double.isNaN(d6);
                        double d7 = -Math.min((double) Utils.DOUBLE_EPSILON, d6 * 0.5d);
                        Double.isNaN(d5);
                        Double.isNaN(d4);
                        this.f33299i.mo2086i((int) (-Math.min(d4 * (1.0d - Math.pow(100.0d, (-d7) / d5)), d7)), false);
                    }
                    return true;
                } else if (action != 3) {
                    return true;
                }
            }
            m20108z();
            this.f33294d = -1.0f;
            if (this.f33295e) {
                this.f33299i.mo2086i(this.f33292b, true);
                return true;
            }
            return true;
        }
        this.f33294d = motionEvent.getRawY();
        this.f33299i.mo2086i(0, true);
        return true;
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: p */
    public boolean mo2097p() {
        return false;
    }

    /* renamed from: s */
    protected void mo20085s(float f, int i, int i2, int i3) {
    }

    @Override // p638r0.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        if (isInEditMode()) {
            return;
        }
        super.setTranslationY(f);
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: u */
    public void mo2096u(RefreshLayout refreshLayout, int i, int i2) {
        this.f33295e = false;
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: v */
    public int mo2095v(RefreshLayout refreshLayout, boolean z) {
        this.f33296f = z;
        if (!this.f33295e) {
            this.f33295e = true;
            if (this.f33297g) {
                if (this.f33294d == -1.0f) {
                    m20108z();
                    mo2095v(refreshLayout, z);
                    return 0;
                }
                return Integer.MAX_VALUE;
            }
        }
        return 0;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: w */
    public void mo2100w(float f, int i, int i2, int i3) {
        if (this.f33297g) {
            mo20085s(f, i, i2, i3);
            return;
        }
        this.f33291a = i;
        setTranslationY(i - this.f33292b);
    }

    /* renamed from: z */
    protected void m20108z() {
        if (this.f33295e) {
            this.f33297g = false;
            this.f33299i.mo2081n().mo2064P(this.f33301k);
            if (this.f33294d != -1.0f) {
                mo2095v(this.f33299i.mo2081n(), this.f33296f);
                this.f33299i.mo2093b(RefreshState.RefreshFinish);
                this.f33299i.mo2090e(0);
            } else {
                this.f33299i.mo2086i(this.f33292b, true);
            }
            View view = this.f33300j.getView();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.topMargin -= this.f33292b;
            view.setLayoutParams(marginLayoutParams);
            return;
        }
        this.f33299i.mo2086i(0, true);
    }

    public FunGameBase(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m20109q(context);
    }

    public FunGameBase(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20109q(context);
    }

    @RequiresApi(21)
    public FunGameBase(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m20109q(context);
    }
}
