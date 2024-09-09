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
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import com.scwang.smartrefresh.header.waveswipe.AnimationImageView;
import com.scwang.smartrefresh.header.waveswipe.WaveView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class WaveSwipeHeader extends ViewGroup implements r0.e {

    /* renamed from: e  reason: collision with root package name */
    private static final float f47648e = 0.8f;

    /* renamed from: a  reason: collision with root package name */
    private WaveView f47649a;

    /* renamed from: b  reason: collision with root package name */
    private RefreshState f47650b;

    /* renamed from: c  reason: collision with root package name */
    private e f47651c;

    /* renamed from: d  reason: collision with root package name */
    private float f47652d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveSwipeHeader.this.f47651c.setTranslationY(WaveSwipeHeader.this.f47649a.getCurrentCircleCenterY() + (WaveSwipeHeader.this.f47651c.getHeight() / 2.0f));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class b extends Animation {
        b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f4, Transformation transformation) {
            WaveSwipeHeader.this.f47651c.d(1.0f - f4);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            WaveSwipeHeader.this.f47651c.m();
            WaveSwipeHeader.this.f47651c.b();
            WaveSwipeHeader.this.f47649a.s();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f47656a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f47656a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47656a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47656a[RefreshState.PullDownCanceled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47656a[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f47656a[RefreshState.Refreshing.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class e extends AnimationImageView {

        /* renamed from: b  reason: collision with root package name */
        private final MaterialProgressDrawable f47657b;

        public e(Context context) {
            super(context);
            MaterialProgressDrawable materialProgressDrawable = new MaterialProgressDrawable(context, WaveSwipeHeader.this);
            this.f47657b = materialProgressDrawable;
            materialProgressDrawable.f(0);
            if (com.scwang.smartrefresh.header.waveswipe.a.a(getContext())) {
                materialProgressDrawable.o(0);
            }
            setImageDrawable(materialProgressDrawable);
        }

        private int a(int i4) {
            return View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }

        public void b() {
            this.f47657b.setAlpha(255);
        }

        public void c() {
            int intrinsicWidth = this.f47657b.getIntrinsicWidth();
            measure(a(intrinsicWidth), a(intrinsicWidth));
        }

        public void d(float f4) {
            setScaleX(f4);
            setScaleY(f4);
        }

        public void e(float f4) {
            this.f47657b.e(f4);
        }

        public void f(int i4) {
            this.f47657b.setAlpha(i4);
        }

        public void g(@NonNull int... iArr) {
            this.f47657b.g(iArr);
        }

        public void h(@IdRes int... iArr) {
            Resources resources = getResources();
            int[] iArr2 = new int[iArr.length];
            for (int i4 = 0; i4 < iArr.length; i4++) {
                iArr2[i4] = resources.getColor(iArr[i4]);
            }
            WaveSwipeHeader.this.setColorSchemeColors(iArr2);
        }

        public void i(float f4) {
            this.f47657b.h(f4);
        }

        public void j(float f4, float f5) {
            this.f47657b.k(f4, f5);
        }

        public void k(boolean z3) {
            this.f47657b.m(z3);
        }

        public void l() {
            this.f47657b.start();
        }

        public void m() {
            this.f47657b.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
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
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class f {

        /* renamed from: b  reason: collision with root package name */
        public static final f f47659b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f47660c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f47661d;

        /* renamed from: e  reason: collision with root package name */
        private static final /* synthetic */ f[] f47662e;

        /* renamed from: a  reason: collision with root package name */
        final float f47663a;

        static {
            f fVar = new f("FIRST", 0, 0.1f);
            f47659b = fVar;
            f fVar2 = new f("SECOND", 1, fVar.f47663a + 0.16f);
            f47660c = fVar2;
            f fVar3 = new f("THIRD", 2, fVar.f47663a + 0.5f);
            f47661d = fVar3;
            f47662e = new f[]{fVar, fVar2, fVar3};
        }

        private f(String str, int i4, float f4) {
            this.f47663a = f4;
        }

        public static f valueOf(String str) {
            return (f) Enum.valueOf(f.class, str);
        }

        public static f[] values() {
            return (f[]) f47662e.clone();
        }
    }

    public WaveSwipeHeader(Context context) {
        super(context);
        z(context, null);
    }

    private void z(Context context, AttributeSet attributeSet) {
        WaveView waveView = new WaveView(context);
        this.f47649a = waveView;
        addView(waveView);
        e eVar = new e(getContext());
        this.f47651c = eVar;
        addView(eVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WaveSwipeHeader);
        int color = obtainStyledAttributes.getColor(R.styleable.WaveSwipeHeader_wshPrimaryColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.WaveSwipeHeader_wshAccentColor, 0);
        if (color != 0) {
            this.f47649a.setWaveColor(color);
        }
        if (color2 != 0) {
            this.f47651c.g(color2);
        } else {
            this.f47651c.g(-1);
        }
        int i4 = R.styleable.WaveSwipeHeader_wshShadowRadius;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.f47649a.o(obtainStyledAttributes.getDimensionPixelOffset(i4, 0), obtainStyledAttributes.getColor(R.styleable.WaveSwipeHeader_wshShadowColor, -16777216));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // s0.f
    public void b(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f47650b = refreshState2;
        int i4 = d.f47656a[refreshState2.ordinal()];
        if (i4 == 2) {
            this.f47651c.k(true);
            this.f47651c.d(1.0f);
            this.f47651c.b();
        } else if (i4 != 3) {
        } else {
            this.f47651c.k(false);
            this.f47651c.i(0.0f);
            this.f47651c.j(0.0f, 0.0f);
            this.f47649a.u(this.f47652d);
            this.f47652d = 0.0f;
        }
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
    }

    @Override // r0.e
    public void j(h hVar, int i4, int i5) {
        this.f47652d = 0.0f;
        this.f47649a.f();
        this.f47651c.b();
        this.f47651c.l();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
    }

    @Override // r0.f
    public void n(float f4, int i4, int i5) {
    }

    @Override // r0.f
    public void o(g gVar, int i4, int i5) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        this.f47649a.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = this.f47651c.getMeasuredWidth();
        this.f47651c.layout((measuredWidth - measuredWidth2) / 2, -this.f47651c.getMeasuredHeight(), (measuredWidth + measuredWidth2) / 2, 0);
        if (isInEditMode()) {
            w(0.99f, com.scwang.smartrefresh.layout.util.c.b(99.0f), com.scwang.smartrefresh.layout.util.c.b(100.0f), com.scwang.smartrefresh.layout.util.c.b(100.0f));
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(View.MeasureSpec.getSize(i4), View.MeasureSpec.getSize(i5));
        this.f47651c.c();
        this.f47649a.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4), 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i5), 1073741824));
    }

    @Override // r0.f
    public boolean p() {
        return false;
    }

    public void setColorSchemeColors(int... iArr) {
        this.f47651c.g(iArr);
    }

    @Override // r0.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.f47649a.setWaveColor(iArr[0]);
            if (iArr.length > 1) {
                this.f47651c.g(iArr[1]);
            }
        }
    }

    @Override // r0.f
    public void u(h hVar, int i4, int i5) {
    }

    @Override // r0.f
    public int v(h hVar, boolean z3) {
        b bVar = new b();
        bVar.setDuration(200L);
        this.f47651c.setAnimationListener(new c());
        this.f47651c.clearAnimation();
        this.f47651c.startAnimation(bVar);
        return 0;
    }

    @Override // r0.e
    public void w(float f4, int i4, int i5, int i6) {
        if (this.f47650b == RefreshState.Refreshing) {
            return;
        }
        double min = Math.min(1.0f, f4);
        Double.isNaN(min);
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float f5 = f4 > 3.0f ? 2.0f : f4 > 1.0f ? f4 - 1.0f : 0.0f;
        float f6 = ((4.0f - f5) * f5) / 8.0f;
        if (f4 < 1.0f) {
            this.f47651c.j(0.0f, Math.min(0.8f, max * 0.8f));
            this.f47651c.e(Math.min(1.0f, max));
        }
        this.f47651c.i((((max * 0.4f) - 0.25f) + (f6 * 2.0f)) * 0.5f);
        this.f47651c.setTranslationY(this.f47649a.getCurrentCircleCenterY());
        float min2 = (i4 * 1.0f) / Math.min(getMeasuredWidth(), getMeasuredHeight());
        float f7 = (min2 * (5.0f - (2.0f * min2))) / 3.5f;
        float f8 = f.f47659b.f47663a;
        float f9 = f7 - f8;
        float f10 = f.f47660c.f47663a;
        float f11 = (f7 - f10) / 5.0f;
        this.f47652d = f7;
        if (f7 < f8) {
            this.f47649a.h(f7);
        } else if (f7 < f10) {
            this.f47649a.g(f7, f9);
        } else {
            this.f47649a.i(f7, f9, f11);
        }
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        z(context, attributeSet);
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        z(context, attributeSet);
    }

    @RequiresApi(21)
    public WaveSwipeHeader(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        z(context, attributeSet);
    }
}
