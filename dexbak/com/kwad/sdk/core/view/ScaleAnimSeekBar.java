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
import com.kwad.sdk.p430d.p431a.C10751a;
import java.lang.ref.WeakReference;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
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
    private WeakReference<InterfaceC10590a> aDu;
    private boolean aDv;
    private boolean aDw;
    private ValueAnimator aDx;
    private ValueAnimator aDy;
    private ValueAnimator aDz;

    /* renamed from: com.kwad.sdk.core.view.ScaleAnimSeekBar$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10590a {
        /* renamed from: a */
        void mo25363a(ScaleAnimSeekBar scaleAnimSeekBar);

        /* renamed from: a */
        void mo25362a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z);

        /* renamed from: tr */
        void mo25361tr();
    }

    public ScaleAnimSeekBar(Context context) {
        this(context, null);
    }

    /* renamed from: bm */
    private void m25378bm(Context context) {
        this.aDv = true;
        this.aDE = C10751a.m24924a(context, 10.0f);
        this.aCU = C10751a.m24924a(context, 3.0f);
        this.aDb = C10751a.m24924a(context, 20.0f);
        this.aDo = null;
        this.aDw = false;
        this.aCY = C10751a.m24924a(context, 0.5f);
        this.aCX = C10751a.m24924a(context, 1.0f);
        this.aCR = 654311423;
        this.aCS = -1;
        this.aCT = 1090519039;
        this.aCV = 0;
        this.aCW = 100;
        this.aCZ = false;
    }

    /* renamed from: bp */
    private void m25376bp(boolean z) {
        if (this.aDv) {
            if (z) {
                m25375bq(true);
                m25374br(true);
                return;
            }
            m25375bq(false);
            m25374br(false);
        }
    }

    /* renamed from: bq */
    private void m25375bq(boolean z) {
        float f = this.aDA;
        float f2 = z ? this.aDB : 1.0f;
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
        this.aDx.setFloatValues(f, f2);
        this.aDx.start();
    }

    /* renamed from: br */
    private void m25374br(boolean z) {
        float f = this.aDC;
        float f2 = z ? this.aDD : 1.0f;
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
        this.aDy.setFloatValues(f, f2);
        this.aDy.start();
    }

    /* renamed from: d */
    private boolean m25371d(float f, float f2) {
        int i;
        int i2;
        Rect rect = this.aDn;
        int i3 = rect.left;
        int i4 = rect.right;
        if (i3 >= i4 || (i = rect.top) >= (i2 = rect.bottom)) {
            return false;
        }
        float f3 = this.aDA;
        int i5 = this.aDb;
        return f >= (((float) i3) * f3) - ((float) i5) && f <= (((float) i4) * f3) + ((float) i5) && f2 >= (((float) i) * f3) - ((float) i5) && f2 <= (((float) i2) * f3) + ((float) i5);
    }

    /* renamed from: dv */
    private float m25370dv(int i) {
        int i2 = this.aDa;
        int i3 = this.aCV;
        return ((i2 * (i - i3)) / (this.aCW - i3)) - (i2 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dw */
    public int m25369dw(int i) {
        int i2 = this.aDa;
        if (i > i2 / 2) {
            return this.aCW;
        }
        if (i < (-i2) / 2) {
            return this.aCV;
        }
        return Math.round(((i + (i2 / 2.0f)) * (this.aCW - this.aCV)) / i2) + this.aCV;
    }

    /* renamed from: e */
    private boolean m25368e(float f, float f2) {
        int i;
        int i2;
        Rect rect = this.aDk;
        int i3 = rect.left;
        int i4 = rect.right;
        if (i3 >= i4 || (i = rect.top) >= (i2 = rect.bottom)) {
            return false;
        }
        float f3 = this.aDC;
        int i5 = this.aDb;
        return f >= (((float) i3) * f3) - ((float) i5) && f <= (((float) i4) * f3) + ((float) i5) && f2 >= (((float) i) * f3) - ((float) i5) && f2 <= (((float) i2) * f3) + ((float) i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m25367g(float f) {
        Rect rect = this.aDn;
        int i = this.aCU;
        rect.left = (int) (f - i);
        rect.right = (int) (i + f);
        this.aDl.right = (int) f;
        invalidate();
    }

    private InterfaceC10590a getOnSeekBarChangedListener() {
        WeakReference<InterfaceC10590a> weakReference = this.aDu;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: h */
    private float m25366h(float f) {
        float f2 = this.aDa / 2;
        if (f > f2) {
            return f2;
        }
        float f3 = -f2;
        return f < f3 ? f3 : f;
    }

    /* renamed from: i */
    private void m25365i(boolean z, int i) {
        if (z) {
            float m25366h = m25366h(m25370dv(this.aDc));
            float m25366h2 = m25366h(m25370dv(i));
            ValueAnimator valueAnimator = this.aDz;
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.aDz = valueAnimator2;
                valueAnimator2.setDuration(300L);
                this.aDz.setInterpolator(new Interpolator() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.1
                    @Override // android.animation.TimeInterpolator
                    public final float getInterpolation(float f) {
                        float f2 = f - 1.0f;
                        return (f2 * f2 * f2) + 1.0f;
                    }
                });
                this.aDz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        float floatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                        ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
                        scaleAnimSeekBar.aDc = scaleAnimSeekBar.m25369dw((int) floatValue);
                        ScaleAnimSeekBar.this.m25367g(floatValue);
                    }
                });
            } else {
                valueAnimator.cancel();
            }
            this.aDz.setFloatValues(m25366h, m25366h2);
            this.aDz.start();
            return;
        }
        this.aDc = i;
        m25367g(m25366h(m25370dv(i)));
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            m25378bm(context);
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

    /* renamed from: x */
    private void m25364x(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (this.aDv) {
            this.aDa = (int) (i - ((this.aDE * 2) * (this.aDB - this.aDA)));
        } else {
            this.aDa = i - (this.aDE * 2);
        }
        Rect rect = this.aDk;
        int i3 = this.aCY;
        int i4 = -i3;
        rect.top = i4;
        rect.bottom = -i4;
        boolean z = this.aCZ;
        rect.left = (z ? -i : -this.aDa) / 2;
        rect.right = z ? i / 2 : this.aDa / 2;
        Rect rect2 = this.aDl;
        int i5 = -i3;
        rect2.top = i5;
        rect2.bottom = -i5;
        rect2.left = (z ? -i : -this.aDa) / 2;
        int i6 = this.aDa;
        rect2.right = (-i6) / 2;
        Rect rect3 = this.aDm;
        rect3.top = -i3;
        rect3.bottom = -rect2.top;
        rect3.left = (z ? -i : -i6) / 2;
        rect3.right = (-i6) / 2;
        Rect rect4 = this.aDn;
        int i7 = this.aCU;
        rect4.top = -i7;
        rect4.bottom = i7;
        rect4.left = ((-i6) / 2) - i7;
        rect4.right = ((-i6) / 2) + i7;
        setThumbDrawable(this.aDo);
        setProgress(this.aDc);
        setSecondaryProgress(this.aDe);
    }

    /* renamed from: bo */
    public final void m25377bo(boolean z) {
        this.aDF = z;
        m25376bp(z);
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
        m25383a(canvas, this.aDk, this.aDh);
        m25383a(canvas, this.aDm, this.aDj);
        m25383a(canvas, this.aDl, this.aDi);
        if (this.aDF) {
            m25373c(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
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
        m25364x(this.aDg, this.aDf);
        setMeasuredDimension(this.aDg, this.aDf);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX() - (this.aDg / 2);
        float y = motionEvent.getY() - (this.aDf / 2);
        ViewParent parent = getParent();
        InterfaceC10590a onSeekBarChangedListener = getOnSeekBarChangedListener();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && (this.aDp || this.aDq)) {
                    m25384a(m25369dw((int) x), false, true);
                }
            } else {
                this.aDt = false;
                if (this.aDq || this.aDp) {
                    this.aDq = false;
                    this.aDp = false;
                    m25384a(m25369dw((int) x), this.aDw, true);
                    if (onSeekBarChangedListener != null) {
                        onSeekBarChangedListener.mo25363a(this);
                    }
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        } else if (!this.aDs) {
            return super.onTouchEvent(motionEvent);
        } else {
            if (m25371d(x, y)) {
                m25376bp(true);
                this.aDp = true;
                this.aDt = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.mo25361tr();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if (m25368e(x, y)) {
                m25376bp(true);
                this.aDq = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.mo25361tr();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        return true;
    }

    public void setMaxProgress(int i) {
        this.aCW = i;
    }

    public void setMinProgress(int i) {
        this.aCV = i;
        if (this.aDc < i) {
            this.aDc = i;
        }
    }

    public void setOnSeekBarChangeListener(InterfaceC10590a interfaceC10590a) {
        this.aDu = new WeakReference<>(interfaceC10590a);
    }

    public void setProgress(int i) {
        m25384a(i, false, false);
    }

    public void setProgressBackgroundColor(@ColorInt int i) {
        this.aCR = i;
        this.aDh.setColor(i);
    }

    public void setProgressColor(@ColorInt int i) {
        this.aCS = i;
        this.aDi.setColor(i);
    }

    public void setSecondaryProgress(int i) {
        int i2 = this.aCV;
        if (i <= i2 || i >= (i2 = this.aCW)) {
            i = i2;
        }
        this.aDe = i;
        this.aDm.right = (int) m25366h(m25370dv(i));
        invalidate();
    }

    public void setSecondaryProgressColor(@ColorInt int i) {
        this.aCT = i;
        this.aDj.setColor(i);
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.aDo = drawable;
    }

    public void setThumbEnable(boolean z) {
        this.aDs = z;
    }

    public void setThumbScale(float f) {
        this.aDA = f;
    }

    public void setThumbTouchOffset(int i) {
        this.aDb = i;
        invalidate();
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: c */
    private void m25373c(Canvas canvas) {
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

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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

    /* renamed from: a */
    private void m25383a(Canvas canvas, Rect rect, GradientDrawable gradientDrawable) {
        canvas.save();
        Rect rect2 = new Rect();
        float f = this.aDC;
        rect2.top = (int) (rect.top * f);
        rect2.bottom = (int) (rect.bottom * f);
        rect2.left = rect.left;
        rect2.right = rect.right;
        gradientDrawable.setBounds(rect2);
        gradientDrawable.setCornerRadius(this.aCX * this.aDC);
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    /* renamed from: a */
    private void m25384a(int i, boolean z, boolean z2) {
        int i2 = this.aCV;
        if (i <= i2 || i >= (i2 = this.aCW)) {
            i = i2;
        }
        m25365i(z, i);
        InterfaceC10590a onSeekBarChangedListener = getOnSeekBarChangedListener();
        if (onSeekBarChangedListener != null && this.aDd != this.aDc) {
            this.aDr = z2;
            onSeekBarChangedListener.mo25362a(this, z2);
            this.aDr = false;
        }
        this.aDd = this.aDc;
    }
}
