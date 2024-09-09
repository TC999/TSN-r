package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTRewardChestView extends View {

    /* renamed from: a  reason: collision with root package name */
    protected double f32624a;
    private Bitmap ba;
    private Paint bk;

    /* renamed from: c  reason: collision with root package name */
    protected int f32625c;
    private boolean ck;
    private int eq;
    protected boolean ev;

    /* renamed from: f  reason: collision with root package name */
    protected float f32626f;
    private Paint fp;
    private RectF fz;
    private boolean gb;
    protected float gd;

    /* renamed from: i  reason: collision with root package name */
    private ValueAnimator f32627i;
    private float ia;

    /* renamed from: j  reason: collision with root package name */
    private ValueAnimator f32628j;

    /* renamed from: k  reason: collision with root package name */
    protected int f32629k;
    private boolean ls;
    private int me;

    /* renamed from: n  reason: collision with root package name */
    private boolean f32630n;

    /* renamed from: p  reason: collision with root package name */
    protected int f32631p;

    /* renamed from: q  reason: collision with root package name */
    private ValueAnimator f32632q;

    /* renamed from: r  reason: collision with root package name */
    protected int f32633r;

    /* renamed from: s  reason: collision with root package name */
    private float f32634s;
    protected float sr;

    /* renamed from: t  reason: collision with root package name */
    private Paint f32635t;

    /* renamed from: u  reason: collision with root package name */
    private AnimatorSet f32636u;
    protected float ux;

    /* renamed from: w  reason: collision with root package name */
    protected int f32637w;
    private boolean wv;
    private boolean xk;
    protected int xv;

    /* renamed from: y  reason: collision with root package name */
    private Bitmap f32638y;
    private Paint ys;
    private boolean yu;

    /* renamed from: z  reason: collision with root package name */
    private Bitmap f32639z;

    public TTRewardChestView(Context context) {
        this(context, null);
    }

    private void f() {
        try {
            AnimatorSet animatorSet = this.f32636u;
            if (animatorSet == null || Build.VERSION.SDK_INT < 19) {
                return;
            }
            animatorSet.resume();
        } catch (Throwable unused) {
        }
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.f32632q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f32632q = null;
        }
        float f4 = this.ia;
        long j4 = this.gd * f4 * 1000.0f;
        if (j4 < 0) {
            j4 = 0;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f4, 0.0f);
        this.f32632q = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f32632q.setDuration(j4);
        this.f32632q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.TTRewardChestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTRewardChestView.this.ia = 1.0f - ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTRewardChestView.this.postInvalidate();
            }
        });
        return this.f32632q;
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.f32627i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f32627i = null;
        }
        float f4 = this.f32634s;
        long j4 = this.gd * f4 * 1000.0f;
        if (j4 < 0) {
            j4 = 0;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f4, 0.0f);
        this.f32627i = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f32627i.setDuration(j4);
        this.f32627i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.TTRewardChestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTRewardChestView.this.f32634s = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTRewardChestView.this.postInvalidate();
            }
        });
        return this.f32627i;
    }

    private void sr() {
        try {
            AnimatorSet animatorSet = this.f32636u;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.f32636u = null;
            }
            ValueAnimator valueAnimator = this.f32628j;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f32628j = null;
            }
            ValueAnimator valueAnimator2 = this.f32627i;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.f32627i = null;
            }
            ValueAnimator valueAnimator3 = this.f32632q;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.f32632q = null;
            }
            this.ia = 1.0f;
            this.f32634s = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
    }

    private void ux() {
        try {
            AnimatorSet animatorSet = this.f32636u;
            if (animatorSet == null || Build.VERSION.SDK_INT < 19) {
                return;
            }
            animatorSet.pause();
        } catch (Throwable unused) {
        }
    }

    private int xv() {
        return (int) ((((this.sr / 2.0f) + this.f32626f) * 2.0f) + c(4.0f));
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        sr();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f32630n && this.f32631p != -1 && !this.ck) {
            if (((int) Math.ceil(this.f32634s * this.gd)) <= this.f32631p) {
                ux();
            } else {
                f();
            }
        }
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        xv(canvas);
        c(canvas);
        w(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int size = View.MeasureSpec.getSize(i4);
        int mode = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i5);
        if (mode != 1073741824) {
            size = xv();
        }
        if (mode2 != 1073741824) {
            size2 = xv();
        }
        setMeasuredDimension(size, size2);
    }

    public void setCountDownTime(int i4) {
        if (i4 <= 0) {
            this.gb = true;
        }
        this.gd = i4;
        this.f32631p = i4;
        this.f32629k = i4;
        sr();
    }

    public void setRewardLuStyle(boolean z3) {
        this.yu = z3;
        this.wv = false;
        this.eq = 22;
        this.me = 22 + 2;
        this.f32639z = BitmapFactory.decodeResource(getResources(), i.sr(getContext(), "tt_shop_page_red_bag"));
        c();
    }

    public TTRewardChestView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c() {
        Paint paint = new Paint(1);
        this.bk = paint;
        paint.setColor(this.f32625c);
        this.bk.setStrokeWidth(this.sr);
        this.bk.setAntiAlias(true);
        this.bk.setStrokeCap(Paint.Cap.ROUND);
        this.bk.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.f32635t = paint2;
        paint2.setColor(this.f32637w);
        this.f32635t.setAntiAlias(true);
        this.f32635t.setStrokeWidth(this.sr);
        this.f32635t.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.ys = paint3;
        paint3.setColor(this.xv);
        this.ys.setTextSize(this.ux);
        this.ys.setTextAlign(Paint.Align.CENTER);
        Paint paint4 = new Paint(1);
        this.fp = paint4;
        paint4.setFilterBitmap(true);
        this.fp.setDither(true);
    }

    private void w() {
        this.f32639z = BitmapFactory.decodeResource(getResources(), i.sr(getContext(), "tt_reward_chest_box"));
        this.f32638y = BitmapFactory.decodeResource(getResources(), i.sr(getContext(), "tt_reward_box_time_bg"));
    }

    public TTRewardChestView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f32625c = Color.parseColor("#FFDA7B");
        this.f32637w = Color.parseColor("#4D000000");
        this.xv = Color.parseColor("#D9255B");
        this.f32633r = 270;
        this.ev = false;
        this.gd = 5.0f;
        this.f32631p = -1;
        this.f32629k = -1;
        this.f32624a = 3.5d;
        this.ia = 1.0f;
        this.f32634s = 1.0f;
        this.ls = false;
        this.gb = false;
        this.eq = 12;
        this.me = 12;
        this.wv = true;
        this.xk = true;
        this.sr = c(4.0f);
        this.f32626f = c(34.0f);
        this.ux = w(8.0f);
        this.f32633r %= 360;
        float f4 = this.f32626f;
        this.fz = new RectF(-f4, -f4, f4, f4);
        c();
        w();
    }

    private void xv(Canvas canvas) {
        float f4;
        canvas.save();
        float f5 = this.ia * 360.0f;
        if (this.ev) {
            f4 = this.f32633r - f5;
        } else {
            f4 = this.f32633r;
        }
        float f6 = f4;
        if (this.xk) {
            canvas.drawCircle(0.0f, 0.0f, this.f32626f, this.f32635t);
        }
        if (this.wv) {
            canvas.drawArc(this.fz, f6, f5, false, this.bk);
        }
        canvas.restore();
    }

    private void w(Canvas canvas) {
        String str;
        canvas.save();
        Paint.FontMetrics fontMetrics = this.ys.getFontMetrics();
        float f4 = fontMetrics.bottom;
        float f5 = fontMetrics.top;
        float f6 = ((f4 - f5) / 2.0f) + (((f4 - f5) / 2.0f) - f4) + this.me + 4.0f;
        if (!this.f32630n && !this.yu) {
            if (this.gb) {
                str = "\u5df2\u9886\u53d6";
            } else {
                str = "\u5012\u8ba1\u65f6" + ((int) Math.ceil(this.f32634s * this.gd)) + "s";
            }
        } else if (this.gb) {
            str = "\u5956\u52b1\u5df2\u9886\u53d6";
        } else {
            str = this.f32629k + "s\u540e\u9886\u53d6";
        }
        canvas.drawText(str, 0.0f, f6, this.ys);
        canvas.restore();
    }

    private float w(float f4) {
        return TypedValue.applyDimension(2, f4, getResources().getDisplayMetrics());
    }

    private void c(Canvas canvas) {
        Bitmap bitmap;
        double d4;
        int i4;
        canvas.save();
        if (!this.gb || (bitmap = this.ba) == null) {
            bitmap = this.f32639z;
        }
        double d5 = 1.0d;
        if (bitmap.getWidth() > bitmap.getHeight()) {
            double height = bitmap.getHeight();
            double width = bitmap.getWidth();
            Double.isNaN(height);
            Double.isNaN(width);
            d4 = height / width;
        } else if (bitmap.getHeight() > bitmap.getWidth()) {
            double width2 = bitmap.getWidth();
            double height2 = bitmap.getHeight();
            Double.isNaN(width2);
            Double.isNaN(height2);
            double d6 = width2 / height2;
            d4 = 1.0d;
            d5 = d6;
        } else {
            d4 = 1.0d;
        }
        double measuredWidth = getMeasuredWidth();
        double d7 = this.f32624a;
        Double.isNaN(measuredWidth);
        int i5 = (int) ((measuredWidth / d7) * d5);
        double measuredHeight = getMeasuredHeight();
        double d8 = this.f32624a;
        Double.isNaN(measuredHeight);
        int i6 = (int) ((measuredHeight / d8) * d4);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(-i5, -i6, i5, i6), this.fp);
        int width3 = this.f32638y.getWidth();
        int height3 = this.f32638y.getHeight();
        Rect rect = new Rect(0, 0, width3, height3);
        int i7 = this.eq;
        canvas.drawBitmap(this.f32638y, rect, new Rect((-i4) - 6, i7, (width3 - (width3 / 2)) + 6, height3 + i7), this.fp);
        canvas.restore();
    }

    private float c(float f4) {
        return TypedValue.applyDimension(1, f4, getResources().getDisplayMetrics());
    }
}
