package com.scwang.smartrefresh.layout.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.header.bezierradar.RippleView;
import com.scwang.smartrefresh.layout.header.bezierradar.RoundDotView;
import com.scwang.smartrefresh.layout.header.bezierradar.RoundProgressView;
import com.scwang.smartrefresh.layout.header.bezierradar.WaveView;
import r0.e;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class BezierRadarHeader extends FrameLayout implements e {

    /* renamed from: a  reason: collision with root package name */
    private WaveView f47959a;

    /* renamed from: b  reason: collision with root package name */
    private RippleView f47960b;

    /* renamed from: c  reason: collision with root package name */
    private RoundDotView f47961c;

    /* renamed from: d  reason: collision with root package name */
    private RoundProgressView f47962d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f47963e;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BezierRadarHeader.this.f47959a.setWaveHeight(((Integer) valueAnimator.getAnimatedValue()).intValue() / 2);
            BezierRadarHeader.this.f47959a.invalidate();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f47965a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BezierRadarHeader.this.f47962d.c();
            }
        }

        b(h hVar) {
            this.f47965a = hVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            BezierRadarHeader.this.f47961c.setVisibility(4);
            BezierRadarHeader.this.f47962d.animate().scaleX(1.0f);
            BezierRadarHeader.this.f47962d.animate().scaleY(1.0f);
            this.f47965a.getLayout().postDelayed(new a(), 200L);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BezierRadarHeader.this.f47961c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f47969a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f47969a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47969a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47969a[RefreshState.PullToUpLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47969a[RefreshState.Refreshing.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f47969a[RefreshState.Loading.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public BezierRadarHeader(Context context) {
        this(context, null);
    }

    private void A(Context context, AttributeSet attributeSet, int i4) {
        setMinimumHeight(com.scwang.smartrefresh.layout.util.c.b(100.0f));
        this.f47959a = new WaveView(getContext());
        this.f47960b = new RippleView(getContext());
        this.f47961c = new RoundDotView(getContext());
        this.f47962d = new RoundProgressView(getContext());
        if (isInEditMode()) {
            addView(this.f47959a, -1, -1);
            addView(this.f47962d, -1, -1);
            this.f47959a.setHeadHeight(1000);
        } else {
            addView(this.f47959a, -1, -1);
            addView(this.f47961c, -1, -1);
            addView(this.f47962d, -1, -1);
            addView(this.f47960b, -1, -1);
            this.f47962d.setScaleX(0.0f);
            this.f47962d.setScaleY(0.0f);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BezierRadarHeader);
        this.f47963e = obtainStyledAttributes.getBoolean(R.styleable.BezierRadarHeader_srlEnableHorizontalDrag, this.f47963e);
        int color = obtainStyledAttributes.getColor(R.styleable.BezierRadarHeader_srlPrimaryColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.BezierRadarHeader_srlAccentColor, 0);
        if (color != 0) {
            E(color);
        }
        if (color2 != 0) {
            B(color2);
        }
        obtainStyledAttributes.recycle();
    }

    public BezierRadarHeader B(@ColorInt int i4) {
        this.f47961c.setDotColor(i4);
        this.f47960b.setFrontColor(i4);
        this.f47962d.setFrontColor(i4);
        return this;
    }

    public BezierRadarHeader C(@ColorRes int i4) {
        B(ContextCompat.getColor(getContext(), i4));
        return this;
    }

    public BezierRadarHeader D(boolean z3) {
        this.f47963e = z3;
        if (!z3) {
            this.f47959a.setWaveOffsetX(-1);
        }
        return this;
    }

    public BezierRadarHeader E(@ColorInt int i4) {
        this.f47959a.setWaveColor(i4);
        this.f47962d.setBackColor(i4);
        return this;
    }

    public BezierRadarHeader F(@ColorRes int i4) {
        E(ContextCompat.getColor(getContext(), i4));
        return this;
    }

    @Override // s0.f
    public void b(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        int i4 = d.f47969a[refreshState2.ordinal()];
        if (i4 == 1) {
            this.f47960b.setVisibility(8);
            this.f47961c.setAlpha(1.0f);
            this.f47961c.setVisibility(0);
        } else if (i4 != 2) {
        } else {
            this.f47962d.setScaleX(0.0f);
            this.f47962d.setScaleY(0.0f);
        }
    }

    @Override // r0.f
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
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
        this.f47959a.setHeadHeight(i4);
        double waveHeight = this.f47959a.getWaveHeight();
        Double.isNaN(waveHeight);
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f47959a.getWaveHeight(), 0, -((int) (waveHeight * 0.8d)), 0, -((int) (this.f47959a.getWaveHeight() * 0.4f)), 0);
        ofInt.addUpdateListener(new a());
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(800L);
        ofInt.start();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addListener(new b(hVar));
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new c());
        ofFloat.start();
    }

    @Override // r0.f
    public void n(float f4, int i4, int i5) {
        this.f47959a.setWaveOffsetX(i4);
        this.f47959a.invalidate();
    }

    @Override // r0.f
    public void o(g gVar, int i4, int i5) {
    }

    @Override // r0.f
    public boolean p() {
        return this.f47963e;
    }

    @Override // r0.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            E(iArr[0]);
        }
        if (iArr.length > 1) {
            B(iArr[1]);
        }
    }

    @Override // r0.f
    public void u(h hVar, int i4, int i5) {
    }

    @Override // r0.f
    public int v(h hVar, boolean z3) {
        this.f47962d.d();
        this.f47962d.animate().scaleX(0.0f);
        this.f47962d.animate().scaleY(0.0f);
        this.f47960b.setVisibility(0);
        this.f47960b.b();
        return 400;
    }

    @Override // r0.e
    public void w(float f4, int i4, int i5, int i6) {
        this.f47959a.setHeadHeight(Math.min(i5, i4));
        this.f47959a.setWaveHeight((int) (Math.max(0, i4 - i5) * 1.9f));
        this.f47961c.setFraction(f4);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f47963e = false;
        A(context, attributeSet, i4);
    }
}
