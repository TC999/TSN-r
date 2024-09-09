package com.scwang.smartrefresh.header.material;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.annotation.ColorInt;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class CircleImageView extends ImageView {

    /* renamed from: c  reason: collision with root package name */
    private static final int f47785c = 503316480;

    /* renamed from: d  reason: collision with root package name */
    private static final int f47786d = 1023410176;

    /* renamed from: e  reason: collision with root package name */
    private static final float f47787e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private static final float f47788f = 1.75f;

    /* renamed from: g  reason: collision with root package name */
    private static final float f47789g = 3.5f;

    /* renamed from: h  reason: collision with root package name */
    private static final int f47790h = 4;

    /* renamed from: a  reason: collision with root package name */
    private Animation.AnimationListener f47791a;

    /* renamed from: b  reason: collision with root package name */
    int f47792b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private class a extends OvalShape {

        /* renamed from: a  reason: collision with root package name */
        private RadialGradient f47793a;

        /* renamed from: b  reason: collision with root package name */
        private Paint f47794b = new Paint();

        a(int i4) {
            CircleImageView.this.f47792b = i4;
            a((int) rect().width());
        }

        private void a(int i4) {
            float f4 = i4 / 2;
            RadialGradient radialGradient = new RadialGradient(f4, f4, CircleImageView.this.f47792b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f47793a = radialGradient;
            this.f47794b.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            int width;
            float width2 = CircleImageView.this.getWidth() / 2;
            float height = CircleImageView.this.getHeight() / 2;
            canvas.drawCircle(width2, height, width2, this.f47794b);
            canvas.drawCircle(width2, height, width - CircleImageView.this.f47792b, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f4, float f5) {
            super.onResize(f4, f5);
            a((int) f4);
        }
    }

    public CircleImageView(Context context, int i4) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f4 = getContext().getResources().getDisplayMetrics().density;
        int i5 = (int) (1.75f * f4);
        int i6 = (int) (0.0f * f4);
        this.f47792b = (int) (3.5f * f4);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            setElevation(f4 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new a(this.f47792b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f47792b, i6, i5, 503316480);
            int i7 = this.f47792b;
            setPadding(i7, i7, i7, i7);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i4);
        setBackground(shapeDrawable);
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f47791a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f47791a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.f47792b * 2), getMeasuredHeight() + (this.f47792b * 2));
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f47791a = animationListener;
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i4) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i4);
        }
    }

    public void setBackgroundColorRes(int i4) {
        Context context = getContext();
        if (Build.VERSION.SDK_INT >= 23) {
            setBackgroundColor(context.getResources().getColor(i4, context.getTheme()));
        } else {
            setBackgroundColor(context.getResources().getColor(i4));
        }
    }
}
