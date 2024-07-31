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

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CircleImageView extends ImageView {

    /* renamed from: c */
    private static final int f33400c = 503316480;

    /* renamed from: d */
    private static final int f33401d = 1023410176;

    /* renamed from: e */
    private static final float f33402e = 0.0f;

    /* renamed from: f */
    private static final float f33403f = 1.75f;

    /* renamed from: g */
    private static final float f33404g = 3.5f;

    /* renamed from: h */
    private static final int f33405h = 4;

    /* renamed from: a */
    private Animation.AnimationListener f33406a;

    /* renamed from: b */
    int f33407b;

    /* renamed from: com.scwang.smartrefresh.header.material.CircleImageView$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private class C11875a extends OvalShape {

        /* renamed from: a */
        private RadialGradient f33408a;

        /* renamed from: b */
        private Paint f33409b = new Paint();

        C11875a(int i) {
            CircleImageView.this.f33407b = i;
            m20034a((int) rect().width());
        }

        /* renamed from: a */
        private void m20034a(int i) {
            float f = i / 2;
            RadialGradient radialGradient = new RadialGradient(f, f, CircleImageView.this.f33407b, new int[]{CircleImageView.f33401d, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f33408a = radialGradient;
            this.f33409b.setShader(radialGradient);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            int width;
            float width2 = CircleImageView.this.getWidth() / 2;
            float height = CircleImageView.this.getHeight() / 2;
            canvas.drawCircle(width2, height, width2, this.f33409b);
            canvas.drawCircle(width2, height, width - CircleImageView.this.f33407b, paint);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f, float f2) {
            super.onResize(f, f2);
            m20034a((int) f);
        }
    }

    public CircleImageView(Context context, int i) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f);
        int i3 = (int) (0.0f * f);
        this.f33407b = (int) (f33404g * f);
        if (m20035a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            setElevation(f * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C11875a(this.f33407b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f33407b, i3, i2, f33400c);
            int i4 = this.f33407b;
            setPadding(i4, i4, i4, i4);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        setBackground(shapeDrawable);
    }

    /* renamed from: a */
    private boolean m20035a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f33406a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f33406a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (m20035a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.f33407b * 2), getMeasuredHeight() + (this.f33407b * 2));
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f33406a = animationListener;
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    public void setBackgroundColorRes(int i) {
        Context context = getContext();
        if (Build.VERSION.SDK_INT >= 23) {
            setBackgroundColor(context.getResources().getColor(i, context.getTheme()));
        } else {
            setBackgroundColor(context.getResources().getColor(i));
        }
    }
}
