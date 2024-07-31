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
import com.autonavi.base.p048ae.gmap.glyph.FontStyle;
import com.scwang.smartrefresh.layout.C11882R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.header.bezierradar.RippleView;
import com.scwang.smartrefresh.layout.header.bezierradar.RoundDotView;
import com.scwang.smartrefresh.layout.header.bezierradar.RoundProgressView;
import com.scwang.smartrefresh.layout.header.bezierradar.WaveView;
import com.scwang.smartrefresh.layout.util.C11925c;
import p638r0.RefreshHeader;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BezierRadarHeader extends FrameLayout implements RefreshHeader {

    /* renamed from: a */
    private WaveView f33625a;

    /* renamed from: b */
    private RippleView f33626b;

    /* renamed from: c */
    private RoundDotView f33627c;

    /* renamed from: d */
    private RoundProgressView f33628d;

    /* renamed from: e */
    private boolean f33629e;

    /* renamed from: com.scwang.smartrefresh.layout.header.BezierRadarHeader$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11911a implements ValueAnimator.AnimatorUpdateListener {
        C11911a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BezierRadarHeader.this.f33625a.setWaveHeight(((Integer) valueAnimator.getAnimatedValue()).intValue() / 2);
            BezierRadarHeader.this.f33625a.invalidate();
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.header.BezierRadarHeader$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11912b extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ RefreshLayout f33631a;

        /* renamed from: com.scwang.smartrefresh.layout.header.BezierRadarHeader$b$a */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        class RunnableC11913a implements Runnable {
            RunnableC11913a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BezierRadarHeader.this.f33628d.m19847c();
            }
        }

        C11912b(RefreshLayout refreshLayout) {
            this.f33631a = refreshLayout;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            BezierRadarHeader.this.f33627c.setVisibility(4);
            BezierRadarHeader.this.f33628d.animate().scaleX(1.0f);
            BezierRadarHeader.this.f33628d.animate().scaleY(1.0f);
            this.f33631a.getLayout().postDelayed(new RunnableC11913a(), 200L);
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.header.BezierRadarHeader$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11914c implements ValueAnimator.AnimatorUpdateListener {
        C11914c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BezierRadarHeader.this.f33627c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.header.BezierRadarHeader$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C11915d {

        /* renamed from: a */
        static final /* synthetic */ int[] f33635a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f33635a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33635a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33635a[RefreshState.PullToUpLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33635a[RefreshState.Refreshing.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33635a[RefreshState.Loading.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public BezierRadarHeader(Context context) {
        this(context, null);
    }

    /* renamed from: A */
    private void m19891A(Context context, AttributeSet attributeSet, int i) {
        setMinimumHeight(C11925c.m19766b(100.0f));
        this.f33625a = new WaveView(getContext());
        this.f33626b = new RippleView(getContext());
        this.f33627c = new RoundDotView(getContext());
        this.f33628d = new RoundProgressView(getContext());
        if (isInEditMode()) {
            addView(this.f33625a, -1, -1);
            addView(this.f33628d, -1, -1);
            this.f33625a.setHeadHeight(1000);
        } else {
            addView(this.f33625a, -1, -1);
            addView(this.f33627c, -1, -1);
            addView(this.f33628d, -1, -1);
            addView(this.f33626b, -1, -1);
            this.f33628d.setScaleX(0.0f);
            this.f33628d.setScaleY(0.0f);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11882R.styleable.BezierRadarHeader);
        this.f33629e = obtainStyledAttributes.getBoolean(C11882R.styleable.BezierRadarHeader_srlEnableHorizontalDrag, this.f33629e);
        int color = obtainStyledAttributes.getColor(C11882R.styleable.BezierRadarHeader_srlPrimaryColor, 0);
        int color2 = obtainStyledAttributes.getColor(C11882R.styleable.BezierRadarHeader_srlAccentColor, 0);
        if (color != 0) {
            m19887E(color);
        }
        if (color2 != 0) {
            m19890B(color2);
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: B */
    public BezierRadarHeader m19890B(@ColorInt int i) {
        this.f33627c.setDotColor(i);
        this.f33626b.setFrontColor(i);
        this.f33628d.setFrontColor(i);
        return this;
    }

    /* renamed from: C */
    public BezierRadarHeader m19889C(@ColorRes int i) {
        m19890B(ContextCompat.getColor(getContext(), i));
        return this;
    }

    /* renamed from: D */
    public BezierRadarHeader m19888D(boolean z) {
        this.f33629e = z;
        if (!z) {
            this.f33625a.setWaveOffsetX(-1);
        }
        return this;
    }

    /* renamed from: E */
    public BezierRadarHeader m19887E(@ColorInt int i) {
        this.f33625a.setWaveColor(i);
        this.f33628d.setBackColor(i);
        return this;
    }

    /* renamed from: F */
    public BezierRadarHeader m19886F(@ColorRes int i) {
        m19887E(ContextCompat.getColor(getContext(), i));
        return this;
    }

    @Override // p642s0.OnStateChangedListener
    /* renamed from: b */
    public void mo329b(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        int i = C11915d.f33635a[refreshState2.ordinal()];
        if (i == 1) {
            this.f33626b.setVisibility(8);
            this.f33627c.setAlpha(1.0f);
            this.f33627c.setVisibility(0);
        } else if (i != 2) {
        } else {
            this.f33628d.setScaleX(0.0f);
            this.f33628d.setScaleY(0.0f);
        }
    }

    @Override // p638r0.RefreshInternal
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
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
        this.f33625a.setHeadHeight(i);
        double waveHeight = this.f33625a.getWaveHeight();
        Double.isNaN(waveHeight);
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f33625a.getWaveHeight(), 0, -((int) (waveHeight * 0.8d)), 0, -((int) (this.f33625a.getWaveHeight() * 0.4f)), 0);
        ofInt.addUpdateListener(new C11911a());
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(800L);
        ofInt.start();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addListener(new C11912b(refreshLayout));
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new C11914c());
        ofFloat.start();
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: n */
    public void mo2099n(float f, int i, int i2) {
        this.f33625a.setWaveOffsetX(i);
        this.f33625a.invalidate();
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: o */
    public void mo2098o(RefreshKernel refreshKernel, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: p */
    public boolean mo2097p() {
        return this.f33629e;
    }

    @Override // p638r0.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            m19887E(iArr[0]);
        }
        if (iArr.length > 1) {
            m19890B(iArr[1]);
        }
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: u */
    public void mo2096u(RefreshLayout refreshLayout, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: v */
    public int mo2095v(RefreshLayout refreshLayout, boolean z) {
        this.f33628d.m19846d();
        this.f33628d.animate().scaleX(0.0f);
        this.f33628d.animate().scaleY(0.0f);
        this.f33626b.setVisibility(0);
        this.f33626b.m19850b();
        return FontStyle.WEIGHT_NORMAL;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: w */
    public void mo2100w(float f, int i, int i2, int i3) {
        this.f33625a.setHeadHeight(Math.min(i2, i));
        this.f33625a.setWaveHeight((int) (Math.max(0, i - i2) * 1.9f));
        this.f33627c.setFraction(f);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33629e = false;
        m19891A(context, attributeSet, i);
    }
}
