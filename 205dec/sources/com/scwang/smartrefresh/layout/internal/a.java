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
import com.bykv.vk.component.ttvideo.ILivePlayer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProgressDrawable.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a extends Drawable implements Animatable {

    /* renamed from: b  reason: collision with root package name */
    private ValueAnimator f48044b;

    /* renamed from: d  reason: collision with root package name */
    private Paint f48046d;

    /* renamed from: a  reason: collision with root package name */
    private int f48043a = 0;

    /* renamed from: c  reason: collision with root package name */
    private Path f48045c = new Path();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ProgressDrawable.java */
    /* renamed from: com.scwang.smartrefresh.layout.internal.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class C0932a implements ValueAnimator.AnimatorUpdateListener {
        C0932a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f48043a = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
            a.this.invalidateSelf();
        }
    }

    public a() {
        Paint paint = new Paint();
        this.f48046d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f48046d.setAntiAlias(true);
        this.f48046d.setColor(-5592406);
        d();
    }

    private void d() {
        ValueAnimator ofInt = ValueAnimator.ofInt(30, 3600);
        this.f48044b = ofInt;
        ofInt.addUpdateListener(new C0932a());
        this.f48044b.setDuration(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        this.f48044b.setInterpolator(new LinearInterpolator());
        this.f48044b.setRepeatCount(-1);
        this.f48044b.setRepeatMode(1);
    }

    public int b() {
        return getBounds().height();
    }

    public void c(int i4) {
        this.f48046d.setColor(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int i4;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        canvas.save();
        float f4 = width / 2;
        float f5 = height / 2;
        canvas.rotate(this.f48043a, f4, f5);
        int max = Math.max(1, width / 20);
        for (int i5 = 0; i5 < 12; i5++) {
            this.f48045c.reset();
            float f6 = width - max;
            float f7 = max;
            this.f48045c.addCircle(f6, f5, f7, Path.Direction.CW);
            float f8 = width - (max * 5);
            this.f48045c.addRect(f8, i4 - max, f6, i4 + max, Path.Direction.CW);
            this.f48045c.addCircle(f8, f5, f7, Path.Direction.CW);
            this.f48046d.setAlpha((i5 + 5) * 17);
            canvas.rotate(30.0f, f4, f5);
            canvas.drawPath(this.f48045c, this.f48046d);
        }
        canvas.restore();
    }

    public int e() {
        return getBounds().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f48044b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f48046d.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f48046d.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f48044b.isRunning()) {
            return;
        }
        this.f48044b.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f48044b.isRunning()) {
            this.f48044b.cancel();
        }
    }
}
