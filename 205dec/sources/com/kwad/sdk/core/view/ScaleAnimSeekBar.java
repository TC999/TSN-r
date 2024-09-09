package com.kwad.sdk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ScaleAnimSeekBar extends View {
    private Paint aCQ;
    private int aCR;
    private int aCS;
    private int aCT;
    private int aCU;
    private int aCV;
    private int aCW;
    private int aCX;
    private int aCY;
    private boolean aCZ;
    private float aDA;
    private float aDB;
    private float aDC;
    private float aDD;
    private int aDE;
    private boolean aDF;
    private int aDa;
    private int aDb;
    private int aDc;
    private int aDd;
    private int aDe;
    private int aDf;
    private int aDg;
    private GradientDrawable aDh;
    private GradientDrawable aDi;
    private GradientDrawable aDj;
    private Rect aDk;
    private Rect aDl;
    private Rect aDm;
    private Rect aDn;
    private Drawable aDo;
    private boolean aDp;
    private boolean aDq;
    private boolean aDr;
    private boolean aDs;
    private boolean aDt;
    private WeakReference<a> aDu;
    private boolean aDv;
    private boolean aDw;
    private ValueAnimator aDx;
    private ValueAnimator aDy;
    private ValueAnimator aDz;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void a(ScaleAnimSeekBar scaleAnimSeekBar);

        void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z3);

        void tr();
    }

    public ScaleAnimSeekBar(Context context) {
        this(context, null);
    }

    private void bm(Context context) {
        this.aDv = true;
        this.aDE = com.kwad.sdk.d.a.a.a(context, 10.0f);
        this.aCU = com.kwad.sdk.d.a.a.a(context, 3.0f);
        this.aDb = com.kwad.sdk.d.a.a.a(context, 20.0f);
        this.aDo = null;
        this.aDw = false;
        this.aCY = com.kwad.sdk.d.a.a.a(context, 0.5f);
        this.aCX = com.kwad.sdk.d.a.a.a(context, 1.0f);
        this.aCR = 654311423;
        this.aCS = -1;
        this.aCT = 1090519039;
        this.aCV = 0;
        this.aCW = 100;
        this.aCZ = false;
    }

    private void bp(boolean z3) {
        if (this.aDv) {
            if (z3) {
                bq(true);
                br(true);
                return;
            }
            bq(false);
            br(false);
        }
    }

    private void bq(boolean z3) {
        float f4 = this.aDA;
        float f5 = z3 ? this.aDB : 1.0f;
        ValueAnimator valueAnimator = this.aDx;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aDx = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.aDx.setInterpolator(new LinearInterpolator());
            this.aDx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aDA = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aDx.setFloatValues(f4, f5);
        this.aDx.start();
    }

    private void br(boolean z3) {
        float f4 = this.aDC;
        float f5 = z3 ? this.aDD : 1.0f;
        ValueAnimator valueAnimator = this.aDy;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aDy = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.aDy.setInterpolator(new LinearInterpolator());
            this.aDy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aDC = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aDy.setFloatValues(f4, f5);
        this.aDy.start();
    }

    private boolean d(float f4, float f5) {
        int i4;
        int i5;
        Rect rect = this.aDn;
        int i6 = rect.left;
        int i7 = rect.right;
        if (i6 >= i7 || (i4 = rect.top) >= (i5 = rect.bottom)) {
            return false;
        }
        float f6 = this.aDA;
        int i8 = this.aDb;
        return f4 >= (((float) i6) * f6) - ((float) i8) && f4 <= (((float) i7) * f6) + ((float) i8) && f5 >= (((float) i4) * f6) - ((float) i8) && f5 <= (((float) i5) * f6) + ((float) i8);
    }

    private float dv(int i4) {
        int i5 = this.aDa;
        int i6 = this.aCV;
        return ((i5 * (i4 - i6)) / (this.aCW - i6)) - (i5 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dw(int i4) {
        int i5 = this.aDa;
        if (i4 > i5 / 2) {
            return this.aCW;
        }
        if (i4 < (-i5) / 2) {
            return this.aCV;
        }
        return Math.round(((i4 + (i5 / 2.0f)) * (this.aCW - this.aCV)) / i5) + this.aCV;
    }

    private boolean e(float f4, float f5) {
        int i4;
        int i5;
        Rect rect = this.aDk;
        int i6 = rect.left;
        int i7 = rect.right;
        if (i6 >= i7 || (i4 = rect.top) >= (i5 = rect.bottom)) {
            return false;
        }
        float f6 = this.aDC;
        int i8 = this.aDb;
        return f4 >= (((float) i6) * f6) - ((float) i8) && f4 <= (((float) i7) * f6) + ((float) i8) && f5 >= (((float) i4) * f6) - ((float) i8) && f5 <= (((float) i5) * f6) + ((float) i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(float f4) {
        Rect rect = this.aDn;
        int i4 = this.aCU;
        rect.left = (int) (f4 - i4);
        rect.right = (int) (i4 + f4);
        this.aDl.right = (int) f4;
        invalidate();
    }

    private a getOnSeekBarChangedListener() {
        WeakReference<a> weakReference = this.aDu;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private float h(float f4) {
        float f5 = this.aDa / 2;
        if (f4 > f5) {
            return f5;
        }
        float f6 = -f5;
        return f4 < f6 ? f6 : f4;
    }

    private void i(boolean z3, int i4) {
        if (z3) {
            float h4 = h(dv(this.aDc));
            float h5 = h(dv(i4));
            ValueAnimator valueAnimator = this.aDz;
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.aDz = valueAnimator2;
                valueAnimator2.setDuration(300L);
                this.aDz.setInterpolator(new Interpolator() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.1
                    @Override // android.animation.TimeInterpolator
                    public final float getInterpolation(float f4) {
                        float f5 = f4 - 1.0f;
                        return (f5 * f5 * f5) + 1.0f;
                    }
                });
                this.aDz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        float floatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                        ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
                        scaleAnimSeekBar.aDc = scaleAnimSeekBar.dw((int) floatValue);
                        ScaleAnimSeekBar.this.g(floatValue);
                    }
                });
            } else {
                valueAnimator.cancel();
            }
            this.aDz.setFloatValues(h4, h5);
            this.aDz.start();
            return;
        }
        this.aDc = i4;
        g(h(dv(i4)));
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            bm(context);
        }
        Paint paint = new Paint();
        this.aCQ = paint;
        paint.setStyle(Paint.Style.FILL);
        this.aCQ.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.aDh = gradientDrawable;
        gradientDrawable.setShape(0);
        this.aDh.setColor(this.aCR);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.aDi = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.aDi.setColor(this.aCS);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.aDj = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.aDj.setColor(this.aCT);
        this.aDk = new Rect();
        this.aDl = new Rect();
        this.aDn = new Rect();
        this.aDm = new Rect();
        this.aDc = this.aCV;
    }

    private void x(int i4, int i5) {
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        if (this.aDv) {
            this.aDa = (int) (i4 - ((this.aDE * 2) * (this.aDB - this.aDA)));
        } else {
            this.aDa = i4 - (this.aDE * 2);
        }
        Rect rect = this.aDk;
        int i6 = this.aCY;
        int i7 = -i6;
        rect.top = i7;
        rect.bottom = -i7;
        boolean z3 = this.aCZ;
        rect.left = (z3 ? -i4 : -this.aDa) / 2;
        rect.right = z3 ? i4 / 2 : this.aDa / 2;
        Rect rect2 = this.aDl;
        int i8 = -i6;
        rect2.top = i8;
        rect2.bottom = -i8;
        rect2.left = (z3 ? -i4 : -this.aDa) / 2;
        int i9 = this.aDa;
        rect2.right = (-i9) / 2;
        Rect rect3 = this.aDm;
        rect3.top = -i6;
        rect3.bottom = -rect2.top;
        rect3.left = (z3 ? -i4 : -i9) / 2;
        rect3.right = (-i9) / 2;
        Rect rect4 = this.aDn;
        int i10 = this.aCU;
        rect4.top = -i10;
        rect4.bottom = i10;
        rect4.left = ((-i9) / 2) - i10;
        rect4.right = ((-i9) / 2) + i10;
        setThumbDrawable(this.aDo);
        setProgress(this.aDc);
        setSecondaryProgress(this.aDe);
    }

    public final void bo(boolean z3) {
        this.aDF = z3;
        bp(z3);
    }

    public int getMaxProgress() {
        return this.aCW;
    }

    public int getProgress() {
        return this.aDc;
    }

    public int getProgressLength() {
        return this.aDa;
    }

    public int getProgressX() {
        return (int) (getX() + (this.aCU * this.aDB));
    }

    public int getSecondaryProgress() {
        return this.aDe;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.aDg / 2, this.aDf / 2);
        a(canvas, this.aDk, this.aDh);
        a(canvas, this.aDm, this.aDj);
        a(canvas, this.aDl, this.aDi);
        if (this.aDF) {
            c(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i5);
        if (mode == 1073741824) {
            this.aDg = size;
        } else {
            this.aDg = getWidth();
        }
        if (mode2 == 1073741824) {
            this.aDf = size2;
        } else {
            this.aDf = getHeight();
        }
        x(this.aDg, this.aDf);
        setMeasuredDimension(this.aDg, this.aDf);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x3 = motionEvent.getX() - (this.aDg / 2);
        float y3 = motionEvent.getY() - (this.aDf / 2);
        ViewParent parent = getParent();
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && (this.aDp || this.aDq)) {
                    a(dw((int) x3), false, true);
                }
            } else {
                this.aDt = false;
                if (this.aDq || this.aDp) {
                    this.aDq = false;
                    this.aDp = false;
                    a(dw((int) x3), this.aDw, true);
                    if (onSeekBarChangedListener != null) {
                        onSeekBarChangedListener.a(this);
                    }
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        } else if (!this.aDs) {
            return super.onTouchEvent(motionEvent);
        } else {
            if (d(x3, y3)) {
                bp(true);
                this.aDp = true;
                this.aDt = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.tr();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if (e(x3, y3)) {
                bp(true);
                this.aDq = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.tr();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        return true;
    }

    public void setMaxProgress(int i4) {
        this.aCW = i4;
    }

    public void setMinProgress(int i4) {
        this.aCV = i4;
        if (this.aDc < i4) {
            this.aDc = i4;
        }
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.aDu = new WeakReference<>(aVar);
    }

    public void setProgress(int i4) {
        a(i4, false, false);
    }

    public void setProgressBackgroundColor(@ColorInt int i4) {
        this.aCR = i4;
        this.aDh.setColor(i4);
    }

    public void setProgressColor(@ColorInt int i4) {
        this.aCS = i4;
        this.aDi.setColor(i4);
    }

    public void setSecondaryProgress(int i4) {
        int i5 = this.aCV;
        if (i4 <= i5 || i4 >= (i5 = this.aCW)) {
            i4 = i5;
        }
        this.aDe = i4;
        this.aDm.right = (int) h(dv(i4));
        invalidate();
    }

    public void setSecondaryProgressColor(@ColorInt int i4) {
        this.aCT = i4;
        this.aDj.setColor(i4);
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.aDo = drawable;
    }

    public void setThumbEnable(boolean z3) {
        this.aDs = z3;
    }

    public void setThumbScale(float f4) {
        this.aDA = f4;
    }

    public void setThumbTouchOffset(int i4) {
        this.aDb = i4;
        invalidate();
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Canvas canvas) {
        canvas.save();
        Drawable drawable = this.aDo;
        if (drawable != null) {
            drawable.setBounds(this.aDn);
            this.aDo.draw(canvas);
        } else {
            this.aCQ.setColor(this.aCS);
            canvas.drawCircle(this.aDn.centerX(), this.aDn.centerY(), (this.aDn.width() * this.aDA) / 2.0f, this.aCQ);
        }
        canvas.restore();
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.aCW = 100;
        this.aCZ = false;
        this.aDo = null;
        this.aDp = false;
        this.aDq = false;
        this.aDr = false;
        this.aDs = true;
        this.aDv = true;
        this.aDw = false;
        this.aDA = 1.0f;
        this.aDB = 1.34f;
        this.aDC = 1.0f;
        this.aDD = 2.0f;
        init(context, attributeSet);
    }

    private void a(Canvas canvas, Rect rect, GradientDrawable gradientDrawable) {
        canvas.save();
        Rect rect2 = new Rect();
        float f4 = this.aDC;
        rect2.top = (int) (rect.top * f4);
        rect2.bottom = (int) (rect.bottom * f4);
        rect2.left = rect.left;
        rect2.right = rect.right;
        gradientDrawable.setBounds(rect2);
        gradientDrawable.setCornerRadius(this.aCX * this.aDC);
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private void a(int i4, boolean z3, boolean z4) {
        int i5 = this.aCV;
        if (i4 <= i5 || i4 >= (i5 = this.aCW)) {
            i4 = i5;
        }
        i(z3, i4);
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        if (onSeekBarChangedListener != null && this.aDd != this.aDc) {
            this.aDr = z4;
            onSeekBarChangedListener.a(this, z4);
            this.aDr = false;
        }
        this.aDd = this.aDc;
    }
}
