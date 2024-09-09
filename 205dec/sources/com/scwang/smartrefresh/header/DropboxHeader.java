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
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DropboxHeader extends View implements r0.e {

    /* renamed from: a  reason: collision with root package name */
    private Path f47494a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f47495b;

    /* renamed from: c  reason: collision with root package name */
    private e f47496c;

    /* renamed from: d  reason: collision with root package name */
    private int f47497d;

    /* renamed from: e  reason: collision with root package name */
    private int f47498e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f47499f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f47500g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f47501h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f47502i;

    /* renamed from: j  reason: collision with root package name */
    private float f47503j;

    /* renamed from: k  reason: collision with root package name */
    private float f47504k;

    /* renamed from: l  reason: collision with root package name */
    private ValueAnimator f47505l;

    /* renamed from: m  reason: collision with root package name */
    private ValueAnimator f47506m;

    /* renamed from: n  reason: collision with root package name */
    private RefreshState f47507n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DropboxHeader.this.f47504k = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            DropboxHeader.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (DropboxHeader.this.f47507n != RefreshState.Refreshing || DropboxHeader.this.f47506m == null) {
                return;
            }
            DropboxHeader.this.f47506m.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (DropboxHeader.this.f47503j >= 1.0f && DropboxHeader.this.f47503j < 3.0f) {
                if (DropboxHeader.this.f47503j < 2.0f) {
                    DropboxHeader.this.f47503j = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 1.0f;
                } else if (DropboxHeader.this.f47503j < 3.0f) {
                    DropboxHeader.this.f47503j = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 2.0f;
                    if (DropboxHeader.this.f47503j == 3.0f) {
                        DropboxHeader.this.f47499f = true;
                    }
                }
            } else {
                DropboxHeader.this.f47503j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
            DropboxHeader.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (DropboxHeader.this.f47505l != null) {
                DropboxHeader.this.f47505l.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private int f47512a;

        /* renamed from: b  reason: collision with root package name */
        private int f47513b;

        /* renamed from: c  reason: collision with root package name */
        private int f47514c;

        /* renamed from: d  reason: collision with root package name */
        private int f47515d;

        /* renamed from: e  reason: collision with root package name */
        private int f47516e;

        /* renamed from: f  reason: collision with root package name */
        private int f47517f;

        /* renamed from: g  reason: collision with root package name */
        private int f47518g;

        /* renamed from: h  reason: collision with root package name */
        private int f47519h;

        /* renamed from: i  reason: collision with root package name */
        private int f47520i;

        private e() {
        }

        e j(int i4, int i5, int i6, int i7) {
            this.f47520i = i6;
            int i8 = i4 / 2;
            this.f47512a = i8;
            int i9 = i5 - i7;
            this.f47514c = i9;
            this.f47515d = i9 - (i6 * 2);
            double d4 = i6;
            double sin = Math.sin(1.0471975511965976d);
            Double.isNaN(d4);
            int i10 = i8 - ((int) (d4 * sin));
            this.f47516e = i10;
            int i11 = i6 / 2;
            this.f47517f = this.f47515d + i11;
            int i12 = this.f47514c;
            this.f47518g = i12 - i11;
            this.f47519h = i4 - i10;
            this.f47513b = i12 - i6;
            return this;
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    public DropboxHeader(Context context) {
        super(context);
        K(context, null);
    }

    @NonNull
    private e E(int i4, int i5, int i6) {
        return this.f47496c.j(i4, i5, i6, i6 / 2);
    }

    @NonNull
    private Path F(e eVar) {
        this.f47494a.reset();
        this.f47494a.moveTo(eVar.f47516e, eVar.f47518g);
        this.f47494a.lineTo(eVar.f47512a, eVar.f47514c);
        this.f47494a.lineTo(eVar.f47519h, eVar.f47518g);
        this.f47494a.quadTo(eVar.f47519h + ((eVar.f47520i / 2) * this.f47504k), eVar.f47513b, eVar.f47519h, eVar.f47517f);
        this.f47494a.lineTo(eVar.f47512a, eVar.f47515d);
        this.f47494a.lineTo(eVar.f47516e, eVar.f47517f);
        this.f47494a.quadTo(eVar.f47516e - ((eVar.f47520i / 2) * this.f47504k), eVar.f47513b, eVar.f47516e, eVar.f47518g);
        this.f47494a.close();
        return this.f47494a;
    }

    @NonNull
    private Path G(e eVar) {
        this.f47494a.reset();
        double d4 = this.f47504k;
        Double.isNaN(d4);
        double d5 = d4 * 1.2566370614359172d;
        float f4 = ((eVar.f47512a - eVar.f47516e) * 4) / 5;
        double d6 = 1.0471975511965976d - (d5 / 2.0d);
        float sin = ((float) Math.sin(d6)) * f4;
        float cos = ((float) Math.cos(d6)) * f4;
        this.f47494a.moveTo(eVar.f47516e, eVar.f47517f);
        this.f47494a.lineTo(eVar.f47512a, eVar.f47515d);
        this.f47494a.lineTo(eVar.f47512a - sin, eVar.f47515d - cos);
        this.f47494a.lineTo(eVar.f47516e - sin, eVar.f47517f - cos);
        this.f47494a.close();
        double d7 = d5 + 1.0471975511965976d;
        float sin2 = ((float) Math.sin(d7)) * f4;
        float cos2 = ((float) Math.cos(d7)) * f4;
        this.f47494a.moveTo(eVar.f47516e, eVar.f47517f);
        this.f47494a.lineTo(eVar.f47512a, (eVar.f47514c + eVar.f47515d) / 2);
        this.f47494a.lineTo(eVar.f47512a - sin2, ((eVar.f47514c + eVar.f47515d) / 2) + cos2);
        this.f47494a.lineTo(eVar.f47516e - sin2, eVar.f47517f + cos2);
        this.f47494a.close();
        float sin3 = ((float) Math.sin(d6)) * f4;
        float cos3 = ((float) Math.cos(d6)) * f4;
        this.f47494a.moveTo(eVar.f47519h, eVar.f47517f);
        this.f47494a.lineTo(eVar.f47512a, eVar.f47515d);
        this.f47494a.lineTo(eVar.f47512a + sin3, eVar.f47515d - cos3);
        this.f47494a.lineTo(eVar.f47519h + sin3, eVar.f47517f - cos3);
        this.f47494a.close();
        float sin4 = ((float) Math.sin(d7)) * f4;
        float cos4 = f4 * ((float) Math.cos(d7));
        this.f47494a.moveTo(eVar.f47519h, eVar.f47517f);
        this.f47494a.lineTo(eVar.f47512a, (eVar.f47514c + eVar.f47515d) / 2);
        this.f47494a.lineTo(eVar.f47512a + sin4, ((eVar.f47514c + eVar.f47515d) / 2) + cos4);
        this.f47494a.lineTo(eVar.f47519h + sin4, eVar.f47517f + cos4);
        this.f47494a.close();
        return this.f47494a;
    }

    @NonNull
    private Path H(e eVar, int i4) {
        this.f47494a.reset();
        this.f47494a.lineTo(0.0f, eVar.f47517f);
        this.f47494a.lineTo(eVar.f47516e, eVar.f47517f);
        this.f47494a.lineTo(eVar.f47512a, eVar.f47513b);
        this.f47494a.lineTo(eVar.f47519h, eVar.f47517f);
        float f4 = i4;
        this.f47494a.lineTo(f4, eVar.f47517f);
        this.f47494a.lineTo(f4, 0.0f);
        this.f47494a.close();
        return this.f47494a;
    }

    private int I() {
        return this.f47498e / 5;
    }

    private void J() {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f, 0.0f);
        this.f47505l = ofFloat;
        ofFloat.setInterpolator(accelerateInterpolator);
        this.f47505l.setDuration(300L);
        this.f47505l.addUpdateListener(new a());
        this.f47505l.addListener(new b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f47506m = ofFloat2;
        ofFloat2.setInterpolator(accelerateInterpolator);
        this.f47506m.setDuration(300L);
        this.f47506m.addUpdateListener(new c());
        this.f47506m.addListener(new d());
    }

    private void K(Context context, AttributeSet attributeSet) {
        this.f47494a = new Path();
        this.f47495b = new Paint();
        this.f47496c = new e(null);
        this.f47495b.setAntiAlias(true);
        this.f47497d = -9524737;
        setBackgroundColor(-14141883);
        setMinimumHeight(com.scwang.smartrefresh.layout.util.c.b(150.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DropboxHeader);
        int i4 = R.styleable.DropboxHeader_dhDrawable1;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.f47500g = obtainStyledAttributes.getDrawable(i4);
        } else {
            com.scwang.smartrefresh.layout.internal.pathview.b bVar = new com.scwang.smartrefresh.layout.internal.pathview.b();
            bVar.i("M3 2h18v20h-18z", "m4,1c-1.105,0 -2,0.895 -2,2v3,11 3,1c0,1.105 0.895,2 2,2h2,12 2c1.105,0 2,-0.895 2,-2v-1,-3 -11,-3c0,-1.105 -0.895,-2 -2,-2h-2,-12 -2zM3.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5z");
            bVar.h(-1249039, -245496);
            this.f47500g = bVar;
        }
        int i5 = R.styleable.DropboxHeader_dhDrawable2;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.f47501h = obtainStyledAttributes.getDrawable(i5);
        } else {
            com.scwang.smartrefresh.layout.internal.pathview.b bVar2 = new com.scwang.smartrefresh.layout.internal.pathview.b();
            bVar2.i("M49,16.5l-14,-14l-27,0l0,53l41,0z", "m16,23.5h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,21.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "m16,15.5h10c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,13.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "M41,29.5L16,29.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,37.5L16,37.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,45.5L16,45.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M49,16.5l-14,-14l0,14z");
            bVar2.h(-76695, -2773417);
            this.f47501h = bVar2;
        }
        int i6 = R.styleable.DropboxHeader_dhDrawable3;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.f47502i = obtainStyledAttributes.getDrawable(i6);
        } else {
            com.scwang.smartrefresh.layout.internal.pathview.b bVar3 = new com.scwang.smartrefresh.layout.internal.pathview.b();
            bVar3.i("M6.021,2.188L6.021,11.362C5.46,11.327 4.843,11.414 4.229,11.663C2.624,12.312 1.696,13.729 2.155,14.825C2.62,15.924 4.294,16.284 5.898,15.634C7.131,15.134 7.856,14.184 7.965,13.272L7.958,4.387L15.02,3.028L15.02,9.406C14.422,9.343 13.746,9.432 13.076,9.703C11.471,10.353 10.544,11.77 11.004,12.866C11.467,13.964 13.141,14.325 14.746,13.675C15.979,13.174 16.836,12.224 16.947,11.313L16.958,0.002L6.021,2.188L6.021,2.188Z");
            bVar3.h(-6760607);
            this.f47502i = bVar3;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // s0.f
    public void b(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f47507n = refreshState2;
        if (refreshState2 == RefreshState.None) {
            this.f47499f = false;
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
        this.f47504k = (Math.max(0, i4 - i5) * 1.0f) / i6;
    }

    @Override // r0.e
    public void j(h hVar, int i4, int i5) {
    }

    @Override // r0.f
    public void n(float f4, int i4, int i5) {
    }

    @Override // r0.f
    public void o(g gVar, int i4, int i5) {
        this.f47498e = i4;
        int I = I();
        this.f47500g.setBounds(0, 0, I, I);
        this.f47501h.setBounds(0, 0, I, I);
        this.f47502i.setBounds(0, 0, I, I);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        J();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f47505l;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f47505l.removeAllListeners();
            this.f47505l = null;
        }
        ValueAnimator valueAnimator2 = this.f47506m;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.f47506m.removeAllListeners();
            this.f47506m = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        e E = E(width, getHeight(), I());
        this.f47495b.setColor(com.scwang.smartrefresh.layout.util.a.A(this.f47497d, 150));
        canvas.drawPath(F(E), this.f47495b);
        this.f47495b.setColor(this.f47497d);
        canvas.drawPath(G(E), this.f47495b);
        if (isInEditMode()) {
            this.f47503j = 2.5f;
        }
        if (this.f47503j > 0.0f) {
            canvas.clipPath(H(E, width));
            float min = Math.min(this.f47503j, 1.0f);
            Rect bounds = this.f47500g.getBounds();
            int i4 = width / 2;
            bounds.offsetTo(i4 - (bounds.width() / 2), ((int) (((E.f47513b - (bounds.height() / 2)) + bounds.height()) * min)) - bounds.height());
            this.f47500g.draw(canvas);
            float min2 = Math.min(Math.max(this.f47503j - 1.0f, 0.0f), 1.0f);
            Rect bounds2 = this.f47501h.getBounds();
            bounds2.offsetTo(i4 - (bounds2.width() / 2), ((int) (((E.f47513b - (bounds2.height() / 2)) + bounds2.height()) * min2)) - bounds2.height());
            this.f47501h.draw(canvas);
            float min3 = Math.min(Math.max(this.f47503j - 2.0f, 0.0f), 1.0f);
            Rect bounds3 = this.f47502i.getBounds();
            bounds3.offsetTo(i4 - (bounds3.width() / 2), ((int) (((E.f47513b - (bounds3.height() / 2)) + bounds3.height()) * min3)) - bounds3.height());
            this.f47502i.draw(canvas);
            if (this.f47499f) {
                bounds.offsetTo(i4 - (bounds.width() / 2), E.f47513b - (bounds.height() / 2));
                this.f47500g.draw(canvas);
                bounds2.offsetTo(i4 - (bounds2.width() / 2), E.f47513b - (bounds2.height() / 2));
                this.f47501h.draw(canvas);
                bounds3.offsetTo(i4 - (bounds3.width() / 2), E.f47513b - (bounds3.height() / 2));
                this.f47502i.draw(canvas);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i4), View.resolveSize(getSuggestedMinimumHeight(), i5));
    }

    @Override // r0.f
    public boolean p() {
        return false;
    }

    @Override // r0.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            setBackgroundColor(iArr[0]);
            if (iArr.length > 1) {
                this.f47497d = iArr[1];
            }
        }
    }

    @Override // r0.f
    public void u(h hVar, int i4, int i5) {
        ValueAnimator valueAnimator = this.f47506m;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // r0.f
    public int v(h hVar, boolean z3) {
        this.f47503j = 0.0f;
        return 0;
    }

    @Override // r0.e
    public void w(float f4, int i4, int i5, int i6) {
        if (this.f47507n != RefreshState.Refreshing) {
            this.f47504k = (Math.max(0, i4 - i5) * 1.0f) / i6;
        }
    }

    public DropboxHeader(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        K(context, attributeSet);
    }

    public DropboxHeader(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        K(context, attributeSet);
    }

    @RequiresApi(21)
    public DropboxHeader(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        K(context, attributeSet);
    }
}
