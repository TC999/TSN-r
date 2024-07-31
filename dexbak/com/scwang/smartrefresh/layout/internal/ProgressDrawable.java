package com.scwang.smartrefresh.layout.internal;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.SdkConfigData;

/* renamed from: com.scwang.smartrefresh.layout.internal.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ProgressDrawable extends Drawable implements Animatable {

    /* renamed from: b */
    private ValueAnimator f33710b;

    /* renamed from: d */
    private Paint f33712d;

    /* renamed from: a */
    private int f33709a = 0;

    /* renamed from: c */
    private Path f33711c = new Path();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProgressDrawable.java */
    /* renamed from: com.scwang.smartrefresh.layout.internal.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11922a implements ValueAnimator.AnimatorUpdateListener {
        C11922a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ProgressDrawable.this.f33709a = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
            ProgressDrawable.this.invalidateSelf();
        }
    }

    public ProgressDrawable() {
        Paint paint = new Paint();
        this.f33712d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f33712d.setAntiAlias(true);
        this.f33712d.setColor(-5592406);
        m19831d();
    }

    /* renamed from: d */
    private void m19831d() {
        ValueAnimator ofInt = ValueAnimator.ofInt(30, SdkConfigData.DEFAULT_REQUEST_INTERVAL);
        this.f33710b = ofInt;
        ofInt.addUpdateListener(new C11922a());
        this.f33710b.setDuration(10000L);
        this.f33710b.setInterpolator(new LinearInterpolator());
        this.f33710b.setRepeatCount(-1);
        this.f33710b.setRepeatMode(1);
    }

    /* renamed from: b */
    public int m19833b() {
        return getBounds().height();
    }

    /* renamed from: c */
    public void m19832c(int i) {
        this.f33712d.setColor(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int i;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        canvas.save();
        float f = width / 2;
        float f2 = height / 2;
        canvas.rotate(this.f33709a, f, f2);
        int max = Math.max(1, width / 20);
        for (int i2 = 0; i2 < 12; i2++) {
            this.f33711c.reset();
            float f3 = width - max;
            float f4 = max;
            this.f33711c.addCircle(f3, f2, f4, Path.Direction.CW);
            float f5 = width - (max * 5);
            this.f33711c.addRect(f5, i - max, f3, i + max, Path.Direction.CW);
            this.f33711c.addCircle(f5, f2, f4, Path.Direction.CW);
            this.f33712d.setAlpha((i2 + 5) * 17);
            canvas.rotate(30.0f, f, f2);
            canvas.drawPath(this.f33711c, this.f33712d);
        }
        canvas.restore();
    }

    /* renamed from: e */
    public int m19830e() {
        return getBounds().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f33710b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f33712d.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f33712d.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f33710b.isRunning()) {
            return;
        }
        this.f33710b.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f33710b.isRunning()) {
            this.f33710b.cancel();
        }
    }
}
