package com.scwang.smartrefresh.layout.header.bezierradar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.ColorInt;
import com.baidu.idl.face.platform.utils.BitmapUtils;
import com.scwang.smartrefresh.layout.util.C11925c;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RoundProgressView extends View {

    /* renamed from: a */
    private Paint f33672a;

    /* renamed from: b */
    private Paint f33673b;

    /* renamed from: c */
    private ValueAnimator f33674c;

    /* renamed from: d */
    private int f33675d;

    /* renamed from: e */
    private int f33676e;

    /* renamed from: f */
    private int f33677f;

    /* renamed from: g */
    private int f33678g;

    /* renamed from: h */
    private RectF f33679h;

    /* renamed from: com.scwang.smartrefresh.layout.header.bezierradar.RoundProgressView$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11919a implements ValueAnimator.AnimatorUpdateListener {
        C11919a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RoundProgressView.this.f33675d = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            RoundProgressView.this.postInvalidate();
        }
    }

    public RoundProgressView(Context context) {
        super(context);
        this.f33675d = 0;
        this.f33676e = BitmapUtils.ROTATE270;
        this.f33677f = 0;
        this.f33678g = 0;
        this.f33679h = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        m19848b();
    }

    /* renamed from: b */
    private void m19848b() {
        this.f33672a = new Paint();
        this.f33673b = new Paint();
        this.f33672a.setAntiAlias(true);
        this.f33673b.setAntiAlias(true);
        this.f33672a.setColor(-1);
        this.f33673b.setColor(1426063360);
        C11925c c11925c = new C11925c();
        this.f33677f = c11925c.m19767a(20.0f);
        this.f33678g = c11925c.m19767a(7.0f);
        this.f33672a.setStrokeWidth(c11925c.m19767a(3.0f));
        this.f33673b.setStrokeWidth(c11925c.m19767a(3.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 360);
        this.f33674c = ofInt;
        ofInt.setDuration(720L);
        this.f33674c.setRepeatCount(-1);
        this.f33674c.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    /* renamed from: c */
    public void m19847c() {
        ValueAnimator valueAnimator = this.f33674c;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    /* renamed from: d */
    public void m19846d() {
        ValueAnimator valueAnimator = this.f33674c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f33674c.cancel();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f33674c.addUpdateListener(new C11919a());
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f33674c.removeAllUpdateListeners();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (isInEditMode()) {
            this.f33676e = 0;
            this.f33675d = BitmapUtils.ROTATE270;
        }
        this.f33672a.setStyle(Paint.Style.FILL);
        float f = width / 2;
        float f2 = height / 2;
        canvas.drawCircle(f, f2, this.f33677f, this.f33672a);
        this.f33672a.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(f, f2, this.f33677f + this.f33678g, this.f33672a);
        this.f33673b.setStyle(Paint.Style.FILL);
        RectF rectF = this.f33679h;
        int i3 = this.f33677f;
        rectF.set(i - i3, i2 - i3, i + i3, i3 + i2);
        canvas.drawArc(this.f33679h, this.f33676e, this.f33675d, true, this.f33673b);
        this.f33677f += this.f33678g;
        this.f33673b.setStyle(Paint.Style.STROKE);
        RectF rectF2 = this.f33679h;
        int i4 = this.f33677f;
        rectF2.set(i - i4, i2 - i4, i + i4, i2 + i4);
        canvas.drawArc(this.f33679h, this.f33676e, this.f33675d, false, this.f33673b);
        this.f33677f -= this.f33678g;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i), View.resolveSize(getSuggestedMinimumHeight(), i2));
    }

    public void setBackColor(@ColorInt int i) {
        this.f33673b.setColor((i & 16777215) | 1426063360);
    }

    public void setFrontColor(@ColorInt int i) {
        this.f33672a.setColor(i);
    }
}
