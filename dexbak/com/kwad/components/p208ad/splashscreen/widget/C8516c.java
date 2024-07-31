package com.kwad.components.p208ad.splashscreen.widget;

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
import com.kwad.sdk.C9659R;
import com.kwad.sdk.p430d.p431a.C10751a;

/* renamed from: com.kwad.components.ad.splashscreen.widget.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8516c extends AnimationDrawable {

    /* renamed from: GA */
    private float f27974GA;

    /* renamed from: GB */
    private RectF f27975GB;

    /* renamed from: GC */
    private Paint f27976GC;

    /* renamed from: GD */
    private int f27977GD;

    /* renamed from: GE */
    private int f27978GE;

    /* renamed from: GF */
    private ValueAnimator f27979GF;

    /* renamed from: GG */
    private final float f27980GG = 6.0f;

    /* renamed from: GH */
    private final float f27981GH = 11.0f;

    /* renamed from: GI */
    private float f27982GI;

    /* renamed from: GJ */
    private float f27983GJ;

    /* renamed from: GK */
    private int f27984GK;

    /* renamed from: Gm */
    private Bitmap f27985Gm;

    /* renamed from: Gn */
    private Bitmap f27986Gn;

    /* renamed from: Go */
    private Bitmap f27987Go;

    /* renamed from: Gp */
    private Bitmap f27988Gp;

    /* renamed from: Gq */
    private Bitmap f27989Gq;

    /* renamed from: Gr */
    private Bitmap f27990Gr;

    /* renamed from: Gs */
    private int f27991Gs;

    /* renamed from: Gt */
    private RectF f27992Gt;

    /* renamed from: Gu */
    private Paint f27993Gu;

    /* renamed from: Gv */
    private Paint f27994Gv;

    /* renamed from: Gw */
    private PorterDuffXfermode f27995Gw;

    /* renamed from: Gx */
    private final int f27996Gx;

    /* renamed from: Gy */
    private final int f27997Gy;

    /* renamed from: Gz */
    private float f27998Gz;
    private Context mContext;

    public C8516c(Context context, int i) {
        this.mContext = context;
        this.f27996Gx = C10751a.m24924a(context, 51.0f);
        this.f27997Gy = C10751a.m24924a(context, 61.0f);
        this.f27984GK = i;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m30448c(float f) {
        if (f <= 6.0f) {
            float f2 = f / 6.0f;
            int i = this.f27984GK;
            if (i == 0) {
                RectF rectF = this.f27975GB;
                float f3 = this.f27978GE * (1.0f - f2);
                rectF.top = f3;
                this.f27992Gt.offsetTo(rectF.left + this.f27974GA, f3 + this.f27998Gz);
                this.f27983GJ = (f2 * 30.0f) + 290.0f;
            } else if (i == 1) {
                RectF rectF2 = this.f27975GB;
                float f4 = 1.0f - f2;
                float f5 = this.f27977GD * f4;
                rectF2.left = f5;
                this.f27992Gt.offsetTo(f5 + this.f27974GA, rectF2.top + this.f27998Gz);
                this.f27983GJ = f4 * 30.0f;
            } else if (i != 2) {
            } else {
                RectF rectF3 = this.f27975GB;
                float f6 = this.f27977GD * f2;
                rectF3.right = f6;
                this.f27992Gt.offsetTo(f6 + this.f27974GA, rectF3.top + this.f27998Gz);
                this.f27983GJ = (f2 * 30.0f) + 330.0f;
            }
        }
    }

    private void init() {
        this.f27985Gm = BitmapFactory.decodeResource(this.mContext.getResources(), C9659R.C9661drawable.ksad_splash_hand);
        this.f27986Gn = BitmapFactory.decodeResource(this.mContext.getResources(), C9659R.C9661drawable.ksad_splash_hand_lt);
        this.f27987Go = BitmapFactory.decodeResource(this.mContext.getResources(), C9659R.C9661drawable.ksad_splash_hand_lb);
        this.f27988Gp = BitmapFactory.decodeResource(this.mContext.getResources(), C9659R.C9661drawable.ksad_splash_hand_rt);
        this.f27989Gq = BitmapFactory.decodeResource(this.mContext.getResources(), C9659R.C9661drawable.ksad_splash_hand_rb);
        Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), C9659R.C9661drawable.ksad_splash_side_bg);
        int i = this.f27984GK;
        if (i == 0) {
            this.f27990Gr = decodeResource;
        } else if (i == 1) {
            Matrix matrix = new Matrix();
            matrix.postRotate(270.0f);
            this.f27990Gr = Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true);
        } else if (i == 2) {
            Matrix matrix2 = new Matrix();
            matrix2.postRotate(90.0f);
            this.f27990Gr = Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix2, true);
        }
        this.f27991Gs = C10751a.m24924a(this.mContext, 10.0f);
        this.f27976GC = new Paint(1);
        int i2 = this.f27984GK;
        if (i2 == 0) {
            this.f27978GE = (int) this.mContext.getResources().getDimension(C9659R.dimen.ksad_splash_hand_bgh);
            int dimension = (int) this.mContext.getResources().getDimension(C9659R.dimen.ksad_splash_hand_bgw);
            this.f27977GD = dimension;
            this.f27998Gz = (-this.f27997Gy) * 0.22f;
            this.f27974GA = dimension * 0.08f;
        } else if (i2 == 1) {
            this.f27978GE = (int) this.mContext.getResources().getDimension(C9659R.dimen.ksad_splash_hand_bgw);
            this.f27977GD = (int) this.mContext.getResources().getDimension(C9659R.dimen.ksad_splash_hand_bgh);
            this.f27998Gz = this.f27978GE * 0.09f;
            this.f27974GA = (-this.f27996Gx) * 0.2f;
        } else if (i2 == 2) {
            this.f27978GE = (int) this.mContext.getResources().getDimension(C9659R.dimen.ksad_splash_hand_bgw);
            this.f27977GD = (int) this.mContext.getResources().getDimension(C9659R.dimen.ksad_splash_hand_bgh);
            this.f27998Gz = this.f27978GE * 0.09f;
            this.f27974GA = (-this.f27996Gx) * 0.5f;
        }
        this.f27975GB = new RectF(0.0f, 0.0f, this.f27977GD, this.f27978GE);
        this.f27993Gu = new Paint(3);
        Paint paint = new Paint(3);
        this.f27994Gv = paint;
        paint.setDither(true);
        float f = this.f27975GB.right;
        this.f27992Gt = new RectF(f - this.f27996Gx, 0.0f, f, this.f27997Gy);
        this.f27995Gw = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 6.0f, 11.0f);
        this.f27979GF = ofFloat;
        ofFloat.setDuration(1100L);
        this.f27979GF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C8516c.this.f27982GI = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                C8516c c8516c = C8516c.this;
                c8516c.m30448c(c8516c.f27982GI);
                C8516c.this.invalidateSelf();
            }
        });
        this.f27979GF.setRepeatCount(-1);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void draw(@NonNull Canvas canvas) {
        if (this.f27975GB == null) {
            return;
        }
        canvas.save();
        canvas.translate((getIntrinsicWidth() - this.f27977GD) / 2, (getIntrinsicHeight() - this.f27978GE) / 2);
        float f = this.f27982GI;
        if (f <= 6.0f) {
            this.f27976GC.setAlpha((int) ((f * 255.0f) / 6.0f));
            this.f27994Gv.setAlpha(255);
        } else {
            int i = (int) ((1.0f - ((f - 6.0f) / 5.0f)) * 255.0f);
            this.f27976GC.setAlpha(i);
            this.f27994Gv.setAlpha(i);
        }
        int save = canvas.save();
        int saveLayer = canvas.saveLayer(this.f27975GB, this.f27976GC, 31);
        try {
            canvas.drawBitmap(this.f27990Gr, (Rect) null, this.f27975GB, this.f27976GC);
        } catch (Throwable unused) {
        }
        canvas.rotate(this.f27983GJ, this.f27992Gt.centerX(), this.f27992Gt.centerY());
        this.f27993Gu.setXfermode(this.f27995Gw);
        int i2 = this.f27984GK;
        if (i2 == 0) {
            canvas.drawBitmap(this.f27988Gp, (Rect) null, this.f27992Gt, this.f27993Gu);
            canvas.drawBitmap(this.f27989Gq, (Rect) null, this.f27992Gt, this.f27993Gu);
        } else if (i2 == 1) {
            canvas.drawBitmap(this.f27986Gn, (Rect) null, this.f27992Gt, this.f27993Gu);
            canvas.drawBitmap(this.f27987Go, (Rect) null, this.f27992Gt, this.f27993Gu);
        }
        canvas.drawBitmap(this.f27985Gm, (Rect) null, this.f27992Gt, this.f27993Gu);
        canvas.restoreToCount(saveLayer);
        canvas.rotate(this.f27983GJ, this.f27992Gt.centerX(), this.f27992Gt.centerY());
        canvas.drawBitmap(this.f27985Gm, (Rect) null, this.f27992Gt, this.f27994Gv);
        canvas.restoreToCount(save);
        canvas.restore();
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f27978GE + this.f27997Gy + this.f27991Gs;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f27977GD + this.f27996Gx;
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ValueAnimator valueAnimator = this.f27979GF;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void start() {
        ValueAnimator valueAnimator = this.f27979GF;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // android.graphics.drawable.AnimationDrawable, android.graphics.drawable.Animatable
    public final void stop() {
        ValueAnimator valueAnimator = this.f27979GF;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
