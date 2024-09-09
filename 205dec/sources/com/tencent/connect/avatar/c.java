package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    final String f51474a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51475b;

    /* renamed from: c  reason: collision with root package name */
    private Matrix f51476c;

    /* renamed from: d  reason: collision with root package name */
    private Matrix f51477d;

    /* renamed from: e  reason: collision with root package name */
    private int f51478e;

    /* renamed from: f  reason: collision with root package name */
    private float f51479f;

    /* renamed from: g  reason: collision with root package name */
    private float f51480g;

    /* renamed from: h  reason: collision with root package name */
    private Bitmap f51481h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f51482i;

    /* renamed from: j  reason: collision with root package name */
    private float f51483j;

    /* renamed from: k  reason: collision with root package name */
    private float f51484k;

    /* renamed from: l  reason: collision with root package name */
    private PointF f51485l;

    /* renamed from: m  reason: collision with root package name */
    private PointF f51486m;

    /* renamed from: n  reason: collision with root package name */
    private float f51487n;

    /* renamed from: o  reason: collision with root package name */
    private float f51488o;

    /* renamed from: p  reason: collision with root package name */
    private Rect f51489p;

    public c(Context context) {
        super(context);
        this.f51476c = new Matrix();
        this.f51477d = new Matrix();
        this.f51478e = 0;
        this.f51479f = 1.0f;
        this.f51480g = 1.0f;
        this.f51482i = false;
        this.f51474a = "TouchView";
        this.f51485l = new PointF();
        this.f51486m = new PointF();
        this.f51487n = 1.0f;
        this.f51488o = 0.0f;
        this.f51475b = false;
        Rect rect = new Rect();
        this.f51489p = rect;
        getDrawingRect(rect);
        a();
    }

    private void a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        boolean z3;
        ScaleAnimation scaleAnimation;
        if (this.f51481h == null) {
            return;
        }
        float width = this.f51489p.width();
        float height = this.f51489p.height();
        float[] fArr = new float[9];
        this.f51476c.getValues(fArr);
        float f4 = fArr[2];
        float f5 = fArr[5];
        float f6 = fArr[0];
        float f7 = this.f51479f;
        if (f6 > f7) {
            float f8 = f7 / f6;
            this.f51488o = f8;
            Matrix matrix = this.f51476c;
            PointF pointF = this.f51486m;
            matrix.postScale(f8, f8, pointF.x, pointF.y);
            setImageMatrix(this.f51476c);
            float f9 = this.f51488o;
            float f10 = 1.0f / f9;
            float f11 = 1.0f / f9;
            PointF pointF2 = this.f51486m;
            scaleAnimation = new ScaleAnimation(f10, 1.0f, f11, 1.0f, pointF2.x, pointF2.y);
        } else {
            float f12 = this.f51480g;
            if (f6 < f12) {
                float f13 = f12 / f6;
                this.f51488o = f13;
                Matrix matrix2 = this.f51476c;
                PointF pointF3 = this.f51486m;
                matrix2.postScale(f13, f13, pointF3.x, pointF3.y);
                float f14 = this.f51488o;
                PointF pointF4 = this.f51486m;
                scaleAnimation = new ScaleAnimation(1.0f, f14, 1.0f, f14, pointF4.x, pointF4.y);
            } else {
                float width2 = this.f51481h.getWidth() * f6;
                float height2 = this.f51481h.getHeight() * f6;
                Rect rect = this.f51489p;
                int i4 = rect.left;
                float f15 = i4 - f4;
                int i5 = rect.top;
                float f16 = i5 - f5;
                if (f15 < 0.0f) {
                    f4 = i4;
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (f16 < 0.0f) {
                    f5 = i5;
                    z3 = true;
                }
                float f17 = height2 - f16;
                if (width2 - f15 < width) {
                    f4 = i4 - (width2 - width);
                    z3 = true;
                }
                if (f17 < height) {
                    f5 = i5 - (height2 - height);
                    z3 = true;
                }
                if (z3) {
                    fArr[2] = f4;
                    fArr[5] = f5;
                    this.f51476c.setValues(fArr);
                    setImageMatrix(this.f51476c);
                    scaleAnimation = new TranslateAnimation(fArr[2] - f4, 0.0f, fArr[5] - f5, 0.0f);
                } else {
                    setImageMatrix(this.f51476c);
                    scaleAnimation = null;
                }
            }
        }
        if (scaleAnimation != null) {
            this.f51482i = true;
            scaleAnimation.setDuration(300L);
            startAnimation(scaleAnimation);
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e4) {
                        e4.printStackTrace();
                    }
                    c.this.post(new Runnable() { // from class: com.tencent.connect.avatar.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.clearAnimation();
                            c.this.b();
                        }
                    });
                    c.this.f51482i = false;
                }
            }).start();
        }
    }

    private void c() {
        if (this.f51481h == null) {
            return;
        }
        this.f51476c.getValues(r0);
        float max = Math.max(this.f51489p.width() / this.f51481h.getWidth(), this.f51489p.height() / this.f51481h.getHeight());
        this.f51483j = this.f51489p.left - (((this.f51481h.getWidth() * max) - this.f51489p.width()) / 2.0f);
        float height = this.f51489p.top - (((this.f51481h.getHeight() * max) - this.f51489p.height()) / 2.0f);
        this.f51484k = height;
        float[] fArr = {max, 0.0f, this.f51483j, 0.0f, max, height};
        this.f51476c.setValues(fArr);
        float min = Math.min(2048.0f / this.f51481h.getWidth(), 2048.0f / this.f51481h.getHeight());
        this.f51479f = min;
        this.f51480g = max;
        if (min < max) {
            this.f51479f = max;
        }
        setImageMatrix(this.f51476c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
        if (r0 != 6) goto L14;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.f51482i
            r1 = 1
            if (r0 == 0) goto L6
            return r1
        L6:
            int r0 = r6.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == 0) goto L90
            if (r0 == r1) goto L89
            r2 = 1092616192(0x41200000, float:10.0)
            r3 = 2
            if (r0 == r3) goto L37
            r4 = 5
            if (r0 == r4) goto L1d
            r6 = 6
            if (r0 == r6) goto L89
            goto Laf
        L1d:
            float r6 = r5.a(r6)
            r5.f51487n = r6
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 <= 0) goto Laf
            android.graphics.Matrix r6 = r5.f51477d
            android.graphics.Matrix r0 = r5.f51476c
            r6.set(r0)
            android.graphics.PointF r6 = r5.f51486m
            r5.a(r6)
            r5.f51478e = r3
            goto Laf
        L37:
            int r0 = r5.f51478e
            if (r0 != r1) goto L5f
            android.graphics.Matrix r0 = r5.f51476c
            android.graphics.Matrix r2 = r5.f51477d
            r0.set(r2)
            float r0 = r6.getX()
            android.graphics.PointF r2 = r5.f51485l
            float r2 = r2.x
            float r0 = r0 - r2
            float r6 = r6.getY()
            android.graphics.PointF r2 = r5.f51485l
            float r2 = r2.y
            float r6 = r6 - r2
            android.graphics.Matrix r2 = r5.f51476c
            r2.postTranslate(r0, r6)
            android.graphics.Matrix r6 = r5.f51476c
            r5.setImageMatrix(r6)
            goto Laf
        L5f:
            if (r0 != r3) goto Laf
            android.graphics.Matrix r0 = r5.f51476c
            r0.set(r0)
            float r6 = r5.a(r6)
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L83
            android.graphics.Matrix r0 = r5.f51476c
            android.graphics.Matrix r2 = r5.f51477d
            r0.set(r2)
            float r0 = r5.f51487n
            float r6 = r6 / r0
            android.graphics.Matrix r0 = r5.f51476c
            android.graphics.PointF r2 = r5.f51486m
            float r3 = r2.x
            float r2 = r2.y
            r0.postScale(r6, r6, r3, r2)
        L83:
            android.graphics.Matrix r6 = r5.f51476c
            r5.setImageMatrix(r6)
            goto Laf
        L89:
            r5.b()
            r6 = 0
            r5.f51478e = r6
            goto Laf
        L90:
            android.graphics.Matrix r0 = r5.f51476c
            android.graphics.Matrix r2 = r5.getImageMatrix()
            r0.set(r2)
            android.graphics.Matrix r0 = r5.f51477d
            android.graphics.Matrix r2 = r5.f51476c
            r0.set(r2)
            android.graphics.PointF r0 = r5.f51485l
            float r2 = r6.getX()
            float r6 = r6.getY()
            r0.set(r2, r6)
            r5.f51478e = r1
        Laf:
            r5.f51475b = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.avatar.c.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f51481h = bitmap;
        if (bitmap != null) {
            this.f51481h = bitmap;
        }
    }

    private float a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x3 = motionEvent.getX(0) - motionEvent.getX(1);
        float y3 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x3 * x3) + (y3 * y3));
    }

    public void a(Rect rect) {
        this.f51489p = rect;
        if (this.f51481h != null) {
            c();
        }
    }

    private void a(PointF pointF) {
        if (this.f51481h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.f51476c.getValues(fArr);
        float f4 = fArr[2];
        float f5 = fArr[5];
        float f6 = fArr[0];
        float width = this.f51481h.getWidth() * f6;
        float height = this.f51481h.getHeight() * f6;
        Rect rect = this.f51489p;
        float f7 = rect.left - f4;
        if (f7 <= 1.0f) {
            f7 = 1.0f;
        }
        float f8 = (f4 + width) - rect.right;
        if (f8 <= 1.0f) {
            f8 = 1.0f;
        }
        float width2 = (rect.width() * f7) / (f8 + f7);
        Rect rect2 = this.f51489p;
        float f9 = width2 + rect2.left;
        float f10 = rect2.top - f5;
        float f11 = (f5 + height) - rect2.bottom;
        if (f10 <= 1.0f) {
            f10 = 1.0f;
        }
        pointF.set(f9, ((rect2.height() * f10) / ((f11 > 1.0f ? f11 : 1.0f) + f10)) + this.f51489p.top);
    }
}
