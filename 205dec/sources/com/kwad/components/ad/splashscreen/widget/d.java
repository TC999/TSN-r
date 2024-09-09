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

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class d extends AnimationDrawable {
    private Bitmap GO;
    private Bitmap GP;
    private Bitmap GQ;
    private Bitmap GR;
    private Bitmap GS;
    private Bitmap GT;
    private int GU;
    private RectF GV;
    private Paint GW;
    private Paint GX;
    private PorterDuffXfermode GY;
    private final int GZ;
    private final int Ha;
    private float Hb;
    private float Hc;
    private RectF Hd;
    private Paint He;
    private int Hf;
    private int Hg;
    private ValueAnimator Hh;
    private final float Hi = 6.0f;
    private final float Hj = 11.0f;
    private float Hk;
    private float Hl;
    private int Hm;
    private Context mContext;

    public d(Context context, int i4) {
        this.mContext = context;
        this.GZ = com.kwad.sdk.c.a.a.a(context, 51.0f);
        this.Ha = com.kwad.sdk.c.a.a.a(context, 61.0f);
        this.Hm = i4;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(float f4) {
        if (f4 <= 6.0f) {
            float f5 = f4 / 6.0f;
            int i4 = this.Hm;
            if (i4 == 0) {
                RectF rectF = this.Hd;
                float f6 = this.Hg * (1.0f - f5);
                rectF.top = f6;
                this.GV.offsetTo(rectF.left + this.Hc, f6 + this.Hb);
                this.Hl = (f5 * 30.0f) + 290.0f;
            } else if (i4 == 1) {
                RectF rectF2 = this.Hd;
                float f7 = 1.0f - f5;
                float f8 = this.Hf * f7;
                rectF2.left = f8;
                this.GV.offsetTo(f8 + this.Hc, rectF2.top + this.Hb);
                this.Hl = f7 * 30.0f;
            } else if (i4 != 2) {
            } else {
                RectF rectF3 = this.Hd;
                float f9 = this.Hf * f5;
                rectF3.right = f9;
                this.GV.offsetTo(f9 + this.Hc, rectF3.top + this.Hb);
                this.Hl = (f5 * 30.0f) + 330.0f;
            }
        }
    }

    private void init() {
        this.GO = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand);
        this.GP = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_lt);
        this.GQ = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_lb);
        this.GR = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_rt);
        this.GS = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_hand_rb);
        Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ksad_splash_side_bg);
        int i4 = this.Hm;
        if (i4 == 0) {
            this.GT = decodeResource;
        } else if (i4 == 1) {
            Matrix matrix = new Matrix();
            matrix.postRotate(270.0f);
            this.GT = Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true);
        } else if (i4 == 2) {
            Matrix matrix2 = new Matrix();
            matrix2.postRotate(90.0f);
            this.GT = Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix2, true);
        }
        this.GU = com.kwad.sdk.c.a.a.a(this.mContext, 10.0f);
        this.He = new Paint(1);
        int i5 = this.Hm;
        if (i5 == 0) {
            this.Hg = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            int dimension = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.Hf = dimension;
            this.Hb = (-this.Ha) * 0.22f;
            this.Hc = dimension * 0.08f;
        } else if (i5 == 1) {
            this.Hg = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.Hf = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            this.Hb = this.Hg * 0.09f;
            this.Hc = (-this.GZ) * 0.2f;
        } else if (i5 == 2) {
            this.Hg = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgw);
            this.Hf = (int) this.mContext.getResources().getDimension(R.dimen.ksad_splash_hand_bgh);
            this.Hb = this.Hg * 0.09f;
            this.Hc = (-this.GZ) * 0.5f;
        }
        this.Hd = new RectF(0.0f, 0.0f, this.Hf, this.Hg);
        this.GW = new Paint(3);
        Paint paint = new Paint(3);
        this.GX = paint;
        paint.setDither(true);
        float f4 = this.Hd.right;
        this.GV = new RectF(f4 - this.GZ, 0.0f, f4, this.Ha);
        this.GY = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 6.0f, 11.0f);
        this.Hh = ofFloat;
        ofFloat.setDuration(1100L);
        this.Hh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.Hk = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                d dVar = d.this;
                dVar.e(dVar.Hk);
                d.this.invalidateSelf();
            }
        });
        this.Hh.setRepeatCount(-1);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void draw(@NonNull Canvas canvas) {
        if (this.Hd == null) {
            return;
        }
        canvas.save();
        canvas.translate((getIntrinsicWidth() - this.Hf) / 2, (getIntrinsicHeight() - this.Hg) / 2);
        float f4 = this.Hk;
        if (f4 <= 6.0f) {
            this.He.setAlpha((int) ((f4 * 255.0f) / 6.0f));
            this.GX.setAlpha(255);
        } else {
            int i4 = (int) ((1.0f - ((f4 - 6.0f) / 5.0f)) * 255.0f);
            this.He.setAlpha(i4);
            this.GX.setAlpha(i4);
        }
        int save = canvas.save();
        int saveLayer = canvas.saveLayer(this.Hd, this.He, 31);
        try {
            canvas.drawBitmap(this.GT, (Rect) null, this.Hd, this.He);
        } catch (Throwable unused) {
        }
        canvas.rotate(this.Hl, this.GV.centerX(), this.GV.centerY());
        this.GW.setXfermode(this.GY);
        int i5 = this.Hm;
        if (i5 == 0) {
            canvas.drawBitmap(this.GR, (Rect) null, this.GV, this.GW);
            canvas.drawBitmap(this.GS, (Rect) null, this.GV, this.GW);
        } else if (i5 == 1) {
            canvas.drawBitmap(this.GP, (Rect) null, this.GV, this.GW);
            canvas.drawBitmap(this.GQ, (Rect) null, this.GV, this.GW);
        }
        canvas.drawBitmap(this.GO, (Rect) null, this.GV, this.GW);
        canvas.restoreToCount(saveLayer);
        canvas.rotate(this.Hl, this.GV.centerX(), this.GV.centerY());
        canvas.drawBitmap(this.GO, (Rect) null, this.GV, this.GX);
        canvas.restoreToCount(save);
        canvas.restore();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.Hg + this.Ha + this.GU;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.Hf + this.GZ;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ValueAnimator valueAnimator = this.Hh;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void start() {
        ValueAnimator valueAnimator = this.Hh;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void stop() {
        ValueAnimator valueAnimator = this.Hh;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
