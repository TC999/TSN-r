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
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import r0.c;
import r0.e;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class FunGameBase extends FrameLayout implements e {

    /* renamed from: a  reason: collision with root package name */
    protected int f47699a;

    /* renamed from: b  reason: collision with root package name */
    protected int f47700b;

    /* renamed from: c  reason: collision with root package name */
    protected int f47701c;

    /* renamed from: d  reason: collision with root package name */
    protected float f47702d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f47703e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f47704f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f47705g;

    /* renamed from: h  reason: collision with root package name */
    protected RefreshState f47706h;

    /* renamed from: i  reason: collision with root package name */
    protected g f47707i;

    /* renamed from: j  reason: collision with root package name */
    protected c f47708j;

    /* renamed from: k  reason: collision with root package name */
    boolean f47709k;

    public FunGameBase(Context context) {
        super(context);
        q(context);
    }

    private void q(Context context) {
        this.f47701c = context.getResources().getDisplayMetrics().heightPixels;
    }

    protected void A() {
        if (this.f47705g) {
            return;
        }
        this.f47705g = true;
        this.f47708j = this.f47707i.k();
        this.f47709k = this.f47707i.n().U();
        this.f47707i.n().P(false);
        View view = this.f47708j.getView();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin += this.f47700b;
        view.setLayoutParams(marginLayoutParams);
    }

    @Override // s0.f
    public void b(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f47706h = refreshState2;
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
        w(f4, i4, i5, i6);
    }

    @Override // r0.e
    public void j(h hVar, int i4, int i5) {
    }

    @Override // r0.f
    public void n(float f4, int i4, int i5) {
    }

    @Override // r0.f
    public void o(g gVar, int i4, int i5) {
        this.f47707i = gVar;
        this.f47700b = i4;
        setTranslationY(this.f47699a - i4);
        gVar.g(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f47707i = null;
        this.f47708j = null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f47706h == RefreshState.Refreshing || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        RefreshState refreshState = this.f47706h;
        if (refreshState != RefreshState.Refreshing && refreshState != RefreshState.RefreshFinish) {
            return super.onTouchEvent(motionEvent);
        }
        if (!this.f47705g) {
            A();
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawY = motionEvent.getRawY() - this.f47702d;
                    if (rawY >= 0.0f) {
                        double d4 = this.f47700b * 2;
                        double d5 = (this.f47701c * 2) / 3;
                        double d6 = rawY;
                        Double.isNaN(d6);
                        double max = Math.max(0.0d, d6 * 0.5d);
                        Double.isNaN(d5);
                        Double.isNaN(d4);
                        this.f47707i.i((int) Math.min(d4 * (1.0d - Math.pow(100.0d, (-max) / d5)), max), false);
                    } else {
                        double d7 = this.f47700b * 2;
                        double d8 = (this.f47701c * 2) / 3;
                        double d9 = rawY;
                        Double.isNaN(d9);
                        double d10 = -Math.min(0.0d, d9 * 0.5d);
                        Double.isNaN(d8);
                        Double.isNaN(d7);
                        this.f47707i.i((int) (-Math.min(d7 * (1.0d - Math.pow(100.0d, (-d10) / d8)), d10)), false);
                    }
                    return true;
                } else if (action != 3) {
                    return true;
                }
            }
            z();
            this.f47702d = -1.0f;
            if (this.f47703e) {
                this.f47707i.i(this.f47700b, true);
                return true;
            }
            return true;
        }
        this.f47702d = motionEvent.getRawY();
        this.f47707i.i(0, true);
        return true;
    }

    @Override // r0.f
    public boolean p() {
        return false;
    }

    protected void s(float f4, int i4, int i5, int i6) {
    }

    @Override // r0.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
    }

    @Override // android.view.View
    public void setTranslationY(float f4) {
        if (isInEditMode()) {
            return;
        }
        super.setTranslationY(f4);
    }

    @Override // r0.f
    public void u(h hVar, int i4, int i5) {
        this.f47703e = false;
    }

    @Override // r0.f
    public int v(h hVar, boolean z3) {
        this.f47704f = z3;
        if (!this.f47703e) {
            this.f47703e = true;
            if (this.f47705g) {
                if (this.f47702d == -1.0f) {
                    z();
                    v(hVar, z3);
                    return 0;
                }
                return Integer.MAX_VALUE;
            }
        }
        return 0;
    }

    @Override // r0.e
    public void w(float f4, int i4, int i5, int i6) {
        if (this.f47705g) {
            s(f4, i4, i5, i6);
            return;
        }
        this.f47699a = i4;
        setTranslationY(i4 - this.f47700b);
    }

    protected void z() {
        if (this.f47703e) {
            this.f47705g = false;
            this.f47707i.n().P(this.f47709k);
            if (this.f47702d != -1.0f) {
                v(this.f47707i.n(), this.f47704f);
                this.f47707i.b(RefreshState.RefreshFinish);
                this.f47707i.e(0);
            } else {
                this.f47707i.i(this.f47700b, true);
            }
            View view = this.f47708j.getView();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.topMargin -= this.f47700b;
            view.setLayoutParams(marginLayoutParams);
            return;
        }
        this.f47707i.i(0, true);
    }

    public FunGameBase(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        q(context);
    }

    public FunGameBase(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        q(context);
    }

    @RequiresApi(21)
    public FunGameBase(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        q(context);
    }
}
