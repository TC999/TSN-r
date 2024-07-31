package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.pathview.PathsDrawable;
import com.scwang.smartrefresh.layout.util.C11925c;
import com.scwang.smartrefresh.layout.util.ColorUtils;
import p638r0.RefreshHeader;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DropboxHeader extends View implements RefreshHeader {

    /* renamed from: a */
    private Path f33035a;

    /* renamed from: b */
    private Paint f33036b;

    /* renamed from: c */
    private C11846e f33037c;

    /* renamed from: d */
    private int f33038d;

    /* renamed from: e */
    private int f33039e;

    /* renamed from: f */
    private boolean f33040f;

    /* renamed from: g */
    private Drawable f33041g;

    /* renamed from: h */
    private Drawable f33042h;

    /* renamed from: i */
    private Drawable f33043i;

    /* renamed from: j */
    private float f33044j;

    /* renamed from: k */
    private float f33045k;

    /* renamed from: l */
    private ValueAnimator f33046l;

    /* renamed from: m */
    private ValueAnimator f33047m;

    /* renamed from: n */
    private RefreshState f33048n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.header.DropboxHeader$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11842a implements ValueAnimator.AnimatorUpdateListener {
        C11842a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DropboxHeader.this.f33045k = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            DropboxHeader.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.header.DropboxHeader$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11843b extends AnimatorListenerAdapter {
        C11843b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (DropboxHeader.this.f33048n != RefreshState.Refreshing || DropboxHeader.this.f33047m == null) {
                return;
            }
            DropboxHeader.this.f33047m.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.header.DropboxHeader$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11844c implements ValueAnimator.AnimatorUpdateListener {
        C11844c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (DropboxHeader.this.f33044j >= 1.0f && DropboxHeader.this.f33044j < 3.0f) {
                if (DropboxHeader.this.f33044j < 2.0f) {
                    DropboxHeader.this.f33044j = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 1.0f;
                } else if (DropboxHeader.this.f33044j < 3.0f) {
                    DropboxHeader.this.f33044j = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 2.0f;
                    if (DropboxHeader.this.f33044j == 3.0f) {
                        DropboxHeader.this.f33040f = true;
                    }
                }
            } else {
                DropboxHeader.this.f33044j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
            DropboxHeader.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.header.DropboxHeader$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11845d extends AnimatorListenerAdapter {
        C11845d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (DropboxHeader.this.f33046l != null) {
                DropboxHeader.this.f33046l.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.scwang.smartrefresh.header.DropboxHeader$e */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C11846e {

        /* renamed from: a */
        private int f33053a;

        /* renamed from: b */
        private int f33054b;

        /* renamed from: c */
        private int f33055c;

        /* renamed from: d */
        private int f33056d;

        /* renamed from: e */
        private int f33057e;

        /* renamed from: f */
        private int f33058f;

        /* renamed from: g */
        private int f33059g;

        /* renamed from: h */
        private int f33060h;

        /* renamed from: i */
        private int f33061i;

        private C11846e() {
        }

        /* renamed from: j */
        C11846e m20215j(int i, int i2, int i3, int i4) {
            this.f33061i = i3;
            int i5 = i / 2;
            this.f33053a = i5;
            int i6 = i2 - i4;
            this.f33055c = i6;
            this.f33056d = i6 - (i3 * 2);
            double d = i3;
            double sin = Math.sin(1.0471975511965976d);
            Double.isNaN(d);
            int i7 = i5 - ((int) (d * sin));
            this.f33057e = i7;
            int i8 = i3 / 2;
            this.f33058f = this.f33056d + i8;
            int i9 = this.f33055c;
            this.f33059g = i9 - i8;
            this.f33060h = i - i7;
            this.f33054b = i9 - i3;
            return this;
        }

        /* synthetic */ C11846e(C11842a c11842a) {
            this();
        }
    }

    public DropboxHeader(Context context) {
        super(context);
        m20228K(context, null);
    }

    @NonNull
    /* renamed from: E */
    private C11846e m20234E(int i, int i2, int i3) {
        return this.f33037c.m20215j(i, i2, i3, i3 / 2);
    }

    @NonNull
    /* renamed from: F */
    private Path m20233F(C11846e c11846e) {
        this.f33035a.reset();
        this.f33035a.moveTo(c11846e.f33057e, c11846e.f33059g);
        this.f33035a.lineTo(c11846e.f33053a, c11846e.f33055c);
        this.f33035a.lineTo(c11846e.f33060h, c11846e.f33059g);
        this.f33035a.quadTo(c11846e.f33060h + ((c11846e.f33061i / 2) * this.f33045k), c11846e.f33054b, c11846e.f33060h, c11846e.f33058f);
        this.f33035a.lineTo(c11846e.f33053a, c11846e.f33056d);
        this.f33035a.lineTo(c11846e.f33057e, c11846e.f33058f);
        this.f33035a.quadTo(c11846e.f33057e - ((c11846e.f33061i / 2) * this.f33045k), c11846e.f33054b, c11846e.f33057e, c11846e.f33059g);
        this.f33035a.close();
        return this.f33035a;
    }

    @NonNull
    /* renamed from: G */
    private Path m20232G(C11846e c11846e) {
        this.f33035a.reset();
        double d = this.f33045k;
        Double.isNaN(d);
        double d2 = d * 1.2566370614359172d;
        float f = ((c11846e.f33053a - c11846e.f33057e) * 4) / 5;
        double d3 = 1.0471975511965976d - (d2 / 2.0d);
        float sin = ((float) Math.sin(d3)) * f;
        float cos = ((float) Math.cos(d3)) * f;
        this.f33035a.moveTo(c11846e.f33057e, c11846e.f33058f);
        this.f33035a.lineTo(c11846e.f33053a, c11846e.f33056d);
        this.f33035a.lineTo(c11846e.f33053a - sin, c11846e.f33056d - cos);
        this.f33035a.lineTo(c11846e.f33057e - sin, c11846e.f33058f - cos);
        this.f33035a.close();
        double d4 = d2 + 1.0471975511965976d;
        float sin2 = ((float) Math.sin(d4)) * f;
        float cos2 = ((float) Math.cos(d4)) * f;
        this.f33035a.moveTo(c11846e.f33057e, c11846e.f33058f);
        this.f33035a.lineTo(c11846e.f33053a, (c11846e.f33055c + c11846e.f33056d) / 2);
        this.f33035a.lineTo(c11846e.f33053a - sin2, ((c11846e.f33055c + c11846e.f33056d) / 2) + cos2);
        this.f33035a.lineTo(c11846e.f33057e - sin2, c11846e.f33058f + cos2);
        this.f33035a.close();
        float sin3 = ((float) Math.sin(d3)) * f;
        float cos3 = ((float) Math.cos(d3)) * f;
        this.f33035a.moveTo(c11846e.f33060h, c11846e.f33058f);
        this.f33035a.lineTo(c11846e.f33053a, c11846e.f33056d);
        this.f33035a.lineTo(c11846e.f33053a + sin3, c11846e.f33056d - cos3);
        this.f33035a.lineTo(c11846e.f33060h + sin3, c11846e.f33058f - cos3);
        this.f33035a.close();
        float sin4 = ((float) Math.sin(d4)) * f;
        float cos4 = f * ((float) Math.cos(d4));
        this.f33035a.moveTo(c11846e.f33060h, c11846e.f33058f);
        this.f33035a.lineTo(c11846e.f33053a, (c11846e.f33055c + c11846e.f33056d) / 2);
        this.f33035a.lineTo(c11846e.f33053a + sin4, ((c11846e.f33055c + c11846e.f33056d) / 2) + cos4);
        this.f33035a.lineTo(c11846e.f33060h + sin4, c11846e.f33058f + cos4);
        this.f33035a.close();
        return this.f33035a;
    }

    @NonNull
    /* renamed from: H */
    private Path m20231H(C11846e c11846e, int i) {
        this.f33035a.reset();
        this.f33035a.lineTo(0.0f, c11846e.f33058f);
        this.f33035a.lineTo(c11846e.f33057e, c11846e.f33058f);
        this.f33035a.lineTo(c11846e.f33053a, c11846e.f33054b);
        this.f33035a.lineTo(c11846e.f33060h, c11846e.f33058f);
        float f = i;
        this.f33035a.lineTo(f, c11846e.f33058f);
        this.f33035a.lineTo(f, 0.0f);
        this.f33035a.close();
        return this.f33035a;
    }

    /* renamed from: I */
    private int m20230I() {
        return this.f33039e / 5;
    }

    /* renamed from: J */
    private void m20229J() {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f, 0.0f);
        this.f33046l = ofFloat;
        ofFloat.setInterpolator(accelerateInterpolator);
        this.f33046l.setDuration(300L);
        this.f33046l.addUpdateListener(new C11842a());
        this.f33046l.addListener(new C11843b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f33047m = ofFloat2;
        ofFloat2.setInterpolator(accelerateInterpolator);
        this.f33047m.setDuration(300L);
        this.f33047m.addUpdateListener(new C11844c());
        this.f33047m.addListener(new C11845d());
    }

    /* renamed from: K */
    private void m20228K(Context context, AttributeSet attributeSet) {
        this.f33035a = new Path();
        this.f33036b = new Paint();
        this.f33037c = new C11846e(null);
        this.f33036b.setAntiAlias(true);
        this.f33038d = -9524737;
        setBackgroundColor(-14141883);
        setMinimumHeight(C11925c.m19766b(150.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11852R.styleable.DropboxHeader);
        int i = C11852R.styleable.DropboxHeader_dhDrawable1;
        if (obtainStyledAttributes.hasValue(i)) {
            this.f33041g = obtainStyledAttributes.getDrawable(i);
        } else {
            PathsDrawable pathsDrawable = new PathsDrawable();
            pathsDrawable.m19800i("M3 2h18v20h-18z", "m4,1c-1.105,0 -2,0.895 -2,2v3,11 3,1c0,1.105 0.895,2 2,2h2,12 2c1.105,0 2,-0.895 2,-2v-1,-3 -11,-3c0,-1.105 -0.895,-2 -2,-2h-2,-12 -2zM3.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5z");
            pathsDrawable.m19801h(-1249039, -245496);
            this.f33041g = pathsDrawable;
        }
        int i2 = C11852R.styleable.DropboxHeader_dhDrawable2;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.f33042h = obtainStyledAttributes.getDrawable(i2);
        } else {
            PathsDrawable pathsDrawable2 = new PathsDrawable();
            pathsDrawable2.m19800i("M49,16.5l-14,-14l-27,0l0,53l41,0z", "m16,23.5h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,21.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "m16,15.5h10c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,13.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "M41,29.5L16,29.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,37.5L16,37.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,45.5L16,45.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M49,16.5l-14,-14l0,14z");
            pathsDrawable2.m19801h(-76695, -2773417);
            this.f33042h = pathsDrawable2;
        }
        int i3 = C11852R.styleable.DropboxHeader_dhDrawable3;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.f33043i = obtainStyledAttributes.getDrawable(i3);
        } else {
            PathsDrawable pathsDrawable3 = new PathsDrawable();
            pathsDrawable3.m19800i("M6.021,2.188L6.021,11.362C5.46,11.327 4.843,11.414 4.229,11.663C2.624,12.312 1.696,13.729 2.155,14.825C2.62,15.924 4.294,16.284 5.898,15.634C7.131,15.134 7.856,14.184 7.965,13.272L7.958,4.387L15.02,3.028L15.02,9.406C14.422,9.343 13.746,9.432 13.076,9.703C11.471,10.353 10.544,11.77 11.004,12.866C11.467,13.964 13.141,14.325 14.746,13.675C15.979,13.174 16.836,12.224 16.947,11.313L16.958,0.002L6.021,2.188L6.021,2.188Z");
            pathsDrawable3.m19801h(-6760607);
            this.f33043i = pathsDrawable3;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // p642s0.OnStateChangedListener
    /* renamed from: b */
    public void mo329b(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        this.f33048n = refreshState2;
        if (refreshState2 == RefreshState.None) {
            this.f33040f = false;
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
        this.f33045k = (Math.max(0, i - i2) * 1.0f) / i3;
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
        this.f33039e = i;
        int m20230I = m20230I();
        this.f33041g.setBounds(0, 0, m20230I, m20230I);
        this.f33042h.setBounds(0, 0, m20230I, m20230I);
        this.f33043i.setBounds(0, 0, m20230I, m20230I);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m20229J();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f33046l;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f33046l.removeAllListeners();
            this.f33046l = null;
        }
        ValueAnimator valueAnimator2 = this.f33047m;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.f33047m.removeAllListeners();
            this.f33047m = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        C11846e m20234E = m20234E(width, getHeight(), m20230I());
        this.f33036b.setColor(ColorUtils.m19794A(this.f33038d, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME));
        canvas.drawPath(m20233F(m20234E), this.f33036b);
        this.f33036b.setColor(this.f33038d);
        canvas.drawPath(m20232G(m20234E), this.f33036b);
        if (isInEditMode()) {
            this.f33044j = 2.5f;
        }
        if (this.f33044j > 0.0f) {
            canvas.clipPath(m20231H(m20234E, width));
            float min = Math.min(this.f33044j, 1.0f);
            Rect bounds = this.f33041g.getBounds();
            int i = width / 2;
            bounds.offsetTo(i - (bounds.width() / 2), ((int) (((m20234E.f33054b - (bounds.height() / 2)) + bounds.height()) * min)) - bounds.height());
            this.f33041g.draw(canvas);
            float min2 = Math.min(Math.max(this.f33044j - 1.0f, 0.0f), 1.0f);
            Rect bounds2 = this.f33042h.getBounds();
            bounds2.offsetTo(i - (bounds2.width() / 2), ((int) (((m20234E.f33054b - (bounds2.height() / 2)) + bounds2.height()) * min2)) - bounds2.height());
            this.f33042h.draw(canvas);
            float min3 = Math.min(Math.max(this.f33044j - 2.0f, 0.0f), 1.0f);
            Rect bounds3 = this.f33043i.getBounds();
            bounds3.offsetTo(i - (bounds3.width() / 2), ((int) (((m20234E.f33054b - (bounds3.height() / 2)) + bounds3.height()) * min3)) - bounds3.height());
            this.f33043i.draw(canvas);
            if (this.f33040f) {
                bounds.offsetTo(i - (bounds.width() / 2), m20234E.f33054b - (bounds.height() / 2));
                this.f33041g.draw(canvas);
                bounds2.offsetTo(i - (bounds2.width() / 2), m20234E.f33054b - (bounds2.height() / 2));
                this.f33042h.draw(canvas);
                bounds3.offsetTo(i - (bounds3.width() / 2), m20234E.f33054b - (bounds3.height() / 2));
                this.f33043i.draw(canvas);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i), View.resolveSize(getSuggestedMinimumHeight(), i2));
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: p */
    public boolean mo2097p() {
        return false;
    }

    @Override // p638r0.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            setBackgroundColor(iArr[0]);
            if (iArr.length > 1) {
                this.f33038d = iArr[1];
            }
        }
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: u */
    public void mo2096u(RefreshLayout refreshLayout, int i, int i2) {
        ValueAnimator valueAnimator = this.f33047m;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: v */
    public int mo2095v(RefreshLayout refreshLayout, boolean z) {
        this.f33044j = 0.0f;
        return 0;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: w */
    public void mo2100w(float f, int i, int i2, int i3) {
        if (this.f33048n != RefreshState.Refreshing) {
            this.f33045k = (Math.max(0, i - i2) * 1.0f) / i3;
        }
    }

    public DropboxHeader(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m20228K(context, attributeSet);
    }

    public DropboxHeader(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20228K(context, attributeSet);
    }

    @RequiresApi(21)
    public DropboxHeader(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m20228K(context, attributeSet);
    }
}
