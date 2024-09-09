package com.kwad.components.ad.splashscreen.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.az;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c extends AnimationDrawable {
    private float GA;
    private RectF GB;
    private Paint GC;
    private int GD;
    private int GE;
    private ValueAnimator GF;
    private final float GG = 6.0f;
    private final float GH = 11.0f;
    private float GI;
    private float GJ;
    private int GK;
    private Bitmap Gm;
    private Bitmap Gn;
    private Bitmap Go;
    private Bitmap Gp;
    private Bitmap Gq;
    private Bitmap Gr;
    private int Gs;
    private RectF Gt;
    private Paint Gu;
    private Paint Gv;
    private PorterDuffXfermode Gw;
    private final int Gx;
    private final int Gy;
    private float Gz;
    private Context mContext;

    public c(Context context, int i4) {
        this.mContext = context;
        this.Gx = com.kwad.sdk.d.a.a.a(context, 51.0f);
        this.Gy = com.kwad.sdk.d.a.a.a(context, 61.0f);
        this.GK = i4;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f4) {
        if (f4 <= 6.0f) {
            float f5 = f4 / 6.0f;
            int i4 = this.GK;
            if (i4 == 0) {
                RectF rectF = this.GB;
                float f6 = this.GE * (1.0f - f5);
                rectF.top = f6;
                this.Gt.offsetTo(rectF.left + this.GA, f6 + this.Gz);
                this.GJ = (f5 * 30.0f) + 290.0f;
            } else if (i4 == 1) {
                RectF rectF2 = this.GB;
                float f7 = 1.0f - f5;
                float f8 = this.GD * f7;
                rectF2.left = f8;
                this.Gt.offsetTo(f8 + this.GA, rectF2.top + this.Gz);
                this.GJ = f7 * 30.0f;
            } else if (i4 != 2) {
            } else {
                RectF rectF3 = this.GB;
                float f9 = this.GD * f5;
                rectF3.right = f9;
                this.Gt.offsetTo(f9 + this.GA, rectF3.top + this.Gz);
                this.GJ = (f5 * 30.0f) + 330.0f;
            }
        }
    }

    private void init() {
        this.Gm = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand);
        this.Gn = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_lt);
        this.Go = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_lb);
        this.Gp = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_rt);
        this.Gq = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_rb);
        Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_side_bg);
        int i4 = this.GK;
        if (i4 == 0) {
            this.Gr = decodeResource;
        } else if (i4 == 1) {
            Matrix matrix = new Matrix();
            matrix.postRotate(270.0f);
            this.Gr = Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true);
        } else if (i4 == 2) {
            Matrix matrix2 = new Matrix();
            matrix2.postRotate(90.0f);
            this.Gr = Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix2, true);
        }
        this.Gs = com.kwad.sdk.d.a.a.a(this.mContext, 10.0f);
        this.GC = new Paint(1);
        int i5 = this.GK;
        if (i5 == 0) {
            this.GE = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            int dimension = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.GD = dimension;
            this.Gz = (-this.Gy) * 0.22f;
            this.GA = dimension * 0.08f;
        } else if (i5 == 1) {
            this.GE = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.GD = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            this.Gz = this.GE * 0.09f;
            this.GA = (-this.Gx) * 0.2f;
        } else if (i5 == 2) {
            this.GE = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.GD = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            this.Gz = this.GE * 0.09f;
            this.GA = (-this.Gx) * 0.5f;
        }
        this.GB = new RectF(0.0f, 0.0f, this.GD, this.GE);
        this.Gu = new Paint(3);
        Paint paint = new Paint(3);
        this.Gv = paint;
        paint.setDither(true);
        float f4 = this.GB.right;
        this.Gt = new RectF(f4 - this.Gx, 0.0f, f4, this.Gy);
        this.Gw = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 6.0f, 11.0f);
        this.GF = ofFloat;
        ofFloat.setDuration(1100L);
        this.GF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.c.1

            /* renamed from: com.kwad.components.ad.splashscreen.widget.c$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\6241084.dex */
            final class C06181 extends az {
                C06181() {
                }

                public final void doTask() {
                    if (c.b(AnonymousClass1.this.Gu) != null) {
                        c.b(AnonymousClass1.this.Gu).start();
                    }
                }
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.GI = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                c cVar = c.this;
                cVar.c(cVar.GI);
                c.this.invalidateSelf();
            }
        });
        this.GF.setRepeatCount(-1);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void draw(@NonNull Canvas canvas) {
        if (this.GB == null) {
            return;
        }
        canvas.save();
        canvas.translate((getIntrinsicWidth() - this.GD) / 2, (getIntrinsicHeight() - this.GE) / 2);
        float f4 = this.GI;
        if (f4 <= 6.0f) {
            this.GC.setAlpha((int) ((f4 * 255.0f) / 6.0f));
            this.Gv.setAlpha(255);
        } else {
            int i4 = (int) ((1.0f - ((f4 - 6.0f) / 5.0f)) * 255.0f);
            this.GC.setAlpha(i4);
            this.Gv.setAlpha(i4);
        }
        int save = canvas.save();
        int saveLayer = canvas.saveLayer(this.GB, this.GC, 31);
        try {
            canvas.drawBitmap(this.Gr, (Rect) null, this.GB, this.GC);
        } catch (Throwable unused) {
        }
        canvas.rotate(this.GJ, this.Gt.centerX(), this.Gt.centerY());
        this.Gu.setXfermode(this.Gw);
        int i5 = this.GK;
        if (i5 == 0) {
            canvas.drawBitmap(this.Gp, (Rect) null, this.Gt, this.Gu);
            canvas.drawBitmap(this.Gq, (Rect) null, this.Gt, this.Gu);
        } else if (i5 == 1) {
            canvas.drawBitmap(this.Gn, (Rect) null, this.Gt, this.Gu);
            canvas.drawBitmap(this.Go, (Rect) null, this.Gt, this.Gu);
        }
        canvas.drawBitmap(this.Gm, (Rect) null, this.Gt, this.Gu);
        canvas.restoreToCount(saveLayer);
        canvas.rotate(this.GJ, this.Gt.centerX(), this.Gt.centerY());
        canvas.drawBitmap(this.Gm, (Rect) null, this.Gt, this.Gv);
        canvas.restoreToCount(save);
        canvas.restore();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.GE + this.Gy + this.Gs;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.GD + this.Gx;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ValueAnimator valueAnimator = this.GF;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void start() {
        ValueAnimator valueAnimator = this.GF;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void stop() {
        ValueAnimator valueAnimator = this.GF;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
