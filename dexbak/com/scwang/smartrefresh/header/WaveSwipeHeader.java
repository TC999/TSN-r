package com.scwang.smartrefresh.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.utils.Utils;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.waveswipe.AnimationImageView;
import com.scwang.smartrefresh.header.waveswipe.C11881a;
import com.scwang.smartrefresh.header.waveswipe.WaveView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.C11925c;
import p638r0.RefreshHeader;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class WaveSwipeHeader extends ViewGroup implements RefreshHeader {

    /* renamed from: e */
    private static final float f33236e = 0.8f;

    /* renamed from: a */
    private WaveView f33237a;

    /* renamed from: b */
    private RefreshState f33238b;

    /* renamed from: c */
    private C11867e f33239c;

    /* renamed from: d */
    private float f33240d;

    /* renamed from: com.scwang.smartrefresh.header.WaveSwipeHeader$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11863a implements ValueAnimator.AnimatorUpdateListener {
        C11863a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveSwipeHeader.this.f33239c.setTranslationY(WaveSwipeHeader.this.f33237a.getCurrentCircleCenterY() + (WaveSwipeHeader.this.f33239c.getHeight() / 2.0f));
        }
    }

    /* renamed from: com.scwang.smartrefresh.header.WaveSwipeHeader$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11864b extends Animation {
        C11864b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            WaveSwipeHeader.this.f33239c.m20137d(1.0f - f);
        }
    }

    /* renamed from: com.scwang.smartrefresh.header.WaveSwipeHeader$c  reason: invalid class name */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class animationAnimation$AnimationListenerC11865c implements Animation.AnimationListener {
        animationAnimation$AnimationListenerC11865c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            WaveSwipeHeader.this.f33239c.m20128m();
            WaveSwipeHeader.this.f33239c.m20139b();
            WaveSwipeHeader.this.f33237a.m20000s();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.scwang.smartrefresh.header.WaveSwipeHeader$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static /* synthetic */ class C11866d {

        /* renamed from: a */
        static final /* synthetic */ int[] f33244a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f33244a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33244a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33244a[RefreshState.PullDownCanceled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33244a[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33244a[RefreshState.Refreshing.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.scwang.smartrefresh.header.WaveSwipeHeader$e */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11867e extends AnimationImageView {

        /* renamed from: b */
        private final MaterialProgressDrawable f33245b;

        public C11867e(Context context) {
            super(context);
            MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(context, WaveSwipeHeader.this);
            this.f33245b = materialProgressDrawable;
            materialProgressDrawable.m20079f(0);
            if (C11881a.m19996a(getContext())) {
                materialProgressDrawable.m20070o(0);
            }
            setImageDrawable(materialProgressDrawable);
        }

        /* renamed from: a */
        private int m20140a(int i) {
            return View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        }

        /* renamed from: b */
        public void m20139b() {
            this.f33245b.setAlpha(255);
        }

        /* renamed from: c */
        public void m20138c() {
            int intrinsicWidth = this.f33245b.getIntrinsicWidth();
            measure(m20140a(intrinsicWidth), m20140a(intrinsicWidth));
        }

        /* renamed from: d */
        public void m20137d(float f) {
            setScaleX(f);
            setScaleY(f);
        }

        /* renamed from: e */
        public void m20136e(float f) {
            this.f33245b.m20080e(f);
        }

        /* renamed from: f */
        public void m20135f(int i) {
            this.f33245b.setAlpha(i);
        }

        /* renamed from: g */
        public void m20134g(@NonNull int... iArr) {
            this.f33245b.m20078g(iArr);
        }

        /* renamed from: h */
        public void m20133h(@IdRes int... iArr) {
            Resources resources = getResources();
            int[] iArr2 = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                iArr2[i] = resources.getColor(iArr[i]);
            }
            WaveSwipeHeader.this.setColorSchemeColors(iArr2);
        }

        /* renamed from: i */
        public void m20132i(float f) {
            this.f33245b.m20077h(f);
        }

        /* renamed from: j */
        public void m20131j(float f, float f2) {
            this.f33245b.m20074k(f, f2);
        }

        /* renamed from: k */
        public void m20130k(boolean z) {
            this.f33245b.m20072m(z);
        }

        /* renamed from: l */
        public void m20129l() {
            this.f33245b.start();
        }

        /* renamed from: m */
        public void m20128m() {
            this.f33245b.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum c uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.scwang.smartrefresh.header.WaveSwipeHeader$f */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class EnumC11868f {

        /* renamed from: b */
        public static final EnumC11868f f33247b;

        /* renamed from: c */
        public static final EnumC11868f f33248c;

        /* renamed from: d */
        public static final EnumC11868f f33249d;

        /* renamed from: e */
        private static final /* synthetic */ EnumC11868f[] f33250e;

        /* renamed from: a */
        final float f33251a;

        static {
            EnumC11868f enumC11868f = new EnumC11868f("FIRST", 0, 0.1f);
            f33247b = enumC11868f;
            EnumC11868f enumC11868f2 = new EnumC11868f("SECOND", 1, enumC11868f.f33251a + 0.16f);
            f33248c = enumC11868f2;
            EnumC11868f enumC11868f3 = new EnumC11868f("THIRD", 2, enumC11868f.f33251a + 0.5f);
            f33249d = enumC11868f3;
            f33250e = new EnumC11868f[]{enumC11868f, enumC11868f2, enumC11868f3};
        }

        private EnumC11868f(String str, int i, float f) {
            this.f33251a = f;
        }

        public static EnumC11868f valueOf(String str) {
            return (EnumC11868f) Enum.valueOf(EnumC11868f.class, str);
        }

        public static EnumC11868f[] values() {
            return (EnumC11868f[]) f33250e.clone();
        }
    }

    public WaveSwipeHeader(Context context) {
        super(context);
        m20141z(context, null);
    }

    /* renamed from: z */
    private void m20141z(Context context, AttributeSet attributeSet) {
        WaveView waveView = new WaveView(context);
        this.f33237a = waveView;
        addView(waveView);
        C11867e c11867e = new C11867e(getContext());
        this.f33239c = c11867e;
        addView(c11867e);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11852R.styleable.WaveSwipeHeader);
        int color = obtainStyledAttributes.getColor(C11852R.styleable.WaveSwipeHeader_wshPrimaryColor, 0);
        int color2 = obtainStyledAttributes.getColor(C11852R.styleable.WaveSwipeHeader_wshAccentColor, 0);
        if (color != 0) {
            this.f33237a.setWaveColor(color);
        }
        if (color2 != 0) {
            this.f33239c.m20134g(color2);
        } else {
            this.f33239c.m20134g(-1);
        }
        int i = C11852R.styleable.WaveSwipeHeader_wshShadowRadius;
        if (obtainStyledAttributes.hasValue(i)) {
            this.f33237a.m20004o(obtainStyledAttributes.getDimensionPixelOffset(i, 0), obtainStyledAttributes.getColor(C11852R.styleable.WaveSwipeHeader_wshShadowColor, ViewCompat.MEASURED_STATE_MASK));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // p642s0.OnStateChangedListener
    /* renamed from: b */
    public void mo329b(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        this.f33238b = refreshState2;
        int i = C11866d.f33244a[refreshState2.ordinal()];
        if (i == 2) {
            this.f33239c.m20130k(true);
            this.f33239c.m20137d(1.0f);
            this.f33239c.m20139b();
        } else if (i != 3) {
        } else {
            this.f33239c.m20130k(false);
            this.f33239c.m20132i(0.0f);
            this.f33239c.m20131j(0.0f, 0.0f);
            this.f33237a.m19998u(this.f33240d);
            this.f33240d = 0.0f;
        }
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
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: j */
    public void mo2101j(RefreshLayout refreshLayout, int i, int i2) {
        this.f33240d = 0.0f;
        this.f33237a.m20013f();
        this.f33239c.m20139b();
        this.f33239c.m20129l();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new C11863a());
        ofFloat.start();
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
        this.f33237a.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = this.f33239c.getMeasuredWidth();
        this.f33239c.layout((measuredWidth - measuredWidth2) / 2, -this.f33239c.getMeasuredHeight(), (measuredWidth + measuredWidth2) / 2, 0);
        if (isInEditMode()) {
            mo2100w(0.99f, C11925c.m19766b(99.0f), C11925c.m19766b(100.0f), C11925c.m19766b(100.0f));
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.f33239c.m20138c();
        this.f33237a.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824));
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: p */
    public boolean mo2097p() {
        return false;
    }

    public void setColorSchemeColors(int... iArr) {
        this.f33239c.m20134g(iArr);
    }

    @Override // p638r0.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.f33237a.setWaveColor(iArr[0]);
            if (iArr.length > 1) {
                this.f33239c.m20134g(iArr[1]);
            }
        }
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: u */
    public void mo2096u(RefreshLayout refreshLayout, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: v */
    public int mo2095v(RefreshLayout refreshLayout, boolean z) {
        C11864b c11864b = new C11864b();
        c11864b.setDuration(200L);
        this.f33239c.setAnimationListener(new animationAnimation$AnimationListenerC11865c());
        this.f33239c.clearAnimation();
        this.f33239c.startAnimation(c11864b);
        return 0;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: w */
    public void mo2100w(float f, int i, int i2, int i3) {
        if (this.f33238b == RefreshState.Refreshing) {
            return;
        }
        double min = Math.min(1.0f, f);
        Double.isNaN(min);
        float max = (((float) Math.max(min - 0.4d, (double) Utils.DOUBLE_EPSILON)) * 5.0f) / 3.0f;
        float f2 = f > 3.0f ? 2.0f : f > 1.0f ? f - 1.0f : 0.0f;
        float f3 = ((4.0f - f2) * f2) / 8.0f;
        if (f < 1.0f) {
            this.f33239c.m20131j(0.0f, Math.min((float) f33236e, max * f33236e));
            this.f33239c.m20136e(Math.min(1.0f, max));
        }
        this.f33239c.m20132i((((max * 0.4f) - 0.25f) + (f3 * 2.0f)) * 0.5f);
        this.f33239c.setTranslationY(this.f33237a.getCurrentCircleCenterY());
        float min2 = (i * 1.0f) / Math.min(getMeasuredWidth(), getMeasuredHeight());
        float f4 = (min2 * (5.0f - (2.0f * min2))) / 3.5f;
        float f5 = EnumC11868f.f33247b.f33251a;
        float f6 = f4 - f5;
        float f7 = EnumC11868f.f33248c.f33251a;
        float f8 = (f4 - f7) / 5.0f;
        this.f33240d = f4;
        if (f4 < f5) {
            this.f33237a.m20011h(f4);
        } else if (f4 < f7) {
            this.f33237a.m20012g(f4, f6);
        } else {
            this.f33237a.m20010i(f4, f6, f8);
        }
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20141z(context, attributeSet);
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20141z(context, attributeSet);
    }

    @RequiresApi(21)
    public WaveSwipeHeader(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m20141z(context, attributeSet);
    }
}
