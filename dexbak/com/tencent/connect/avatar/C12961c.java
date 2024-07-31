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

/* compiled from: ProGuard */
/* renamed from: com.tencent.connect.avatar.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12961c extends ImageView {

    /* renamed from: a */
    final String f37108a;

    /* renamed from: b */
    public boolean f37109b;

    /* renamed from: c */
    private Matrix f37110c;

    /* renamed from: d */
    private Matrix f37111d;

    /* renamed from: e */
    private int f37112e;

    /* renamed from: f */
    private float f37113f;

    /* renamed from: g */
    private float f37114g;

    /* renamed from: h */
    private Bitmap f37115h;

    /* renamed from: i */
    private boolean f37116i;

    /* renamed from: j */
    private float f37117j;

    /* renamed from: k */
    private float f37118k;

    /* renamed from: l */
    private PointF f37119l;

    /* renamed from: m */
    private PointF f37120m;

    /* renamed from: n */
    private float f37121n;

    /* renamed from: o */
    private float f37122o;

    /* renamed from: p */
    private Rect f37123p;

    public C12961c(Context context) {
        super(context);
        this.f37110c = new Matrix();
        this.f37111d = new Matrix();
        this.f37112e = 0;
        this.f37113f = 1.0f;
        this.f37114g = 1.0f;
        this.f37116i = false;
        this.f37108a = "TouchView";
        this.f37119l = new PointF();
        this.f37120m = new PointF();
        this.f37121n = 1.0f;
        this.f37122o = 0.0f;
        this.f37109b = false;
        Rect rect = new Rect();
        this.f37123p = rect;
        getDrawingRect(rect);
        m15328a();
    }

    /* renamed from: a */
    private void m15328a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m15322b() {
        boolean z;
        ScaleAnimation scaleAnimation;
        if (this.f37115h == null) {
            return;
        }
        float width = this.f37123p.width();
        float height = this.f37123p.height();
        float[] fArr = new float[9];
        this.f37110c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float f4 = this.f37113f;
        if (f3 > f4) {
            float f5 = f4 / f3;
            this.f37122o = f5;
            Matrix matrix = this.f37110c;
            PointF pointF = this.f37120m;
            matrix.postScale(f5, f5, pointF.x, pointF.y);
            setImageMatrix(this.f37110c);
            float f6 = this.f37122o;
            float f7 = 1.0f / f6;
            float f8 = 1.0f / f6;
            PointF pointF2 = this.f37120m;
            scaleAnimation = new ScaleAnimation(f7, 1.0f, f8, 1.0f, pointF2.x, pointF2.y);
        } else {
            float f9 = this.f37114g;
            if (f3 < f9) {
                float f10 = f9 / f3;
                this.f37122o = f10;
                Matrix matrix2 = this.f37110c;
                PointF pointF3 = this.f37120m;
                matrix2.postScale(f10, f10, pointF3.x, pointF3.y);
                float f11 = this.f37122o;
                PointF pointF4 = this.f37120m;
                scaleAnimation = new ScaleAnimation(1.0f, f11, 1.0f, f11, pointF4.x, pointF4.y);
            } else {
                float width2 = this.f37115h.getWidth() * f3;
                float height2 = this.f37115h.getHeight() * f3;
                Rect rect = this.f37123p;
                int i = rect.left;
                float f12 = i - f;
                int i2 = rect.top;
                float f13 = i2 - f2;
                if (f12 < 0.0f) {
                    f = i;
                    z = true;
                } else {
                    z = false;
                }
                if (f13 < 0.0f) {
                    f2 = i2;
                    z = true;
                }
                float f14 = height2 - f13;
                if (width2 - f12 < width) {
                    f = i - (width2 - width);
                    z = true;
                }
                if (f14 < height) {
                    f2 = i2 - (height2 - height);
                    z = true;
                }
                if (z) {
                    fArr[2] = f;
                    fArr[5] = f2;
                    this.f37110c.setValues(fArr);
                    setImageMatrix(this.f37110c);
                    scaleAnimation = new TranslateAnimation(fArr[2] - f, 0.0f, fArr[5] - f2, 0.0f);
                } else {
                    setImageMatrix(this.f37110c);
                    scaleAnimation = null;
                }
            }
        }
        if (scaleAnimation != null) {
            this.f37116i = true;
            scaleAnimation.setDuration(300L);
            startAnimation(scaleAnimation);
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    C12961c.this.post(new Runnable() { // from class: com.tencent.connect.avatar.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C12961c.this.clearAnimation();
                            C12961c.this.m15322b();
                        }
                    });
                    C12961c.this.f37116i = false;
                }
            }).start();
        }
    }

    /* renamed from: c */
    private void m15321c() {
        if (this.f37115h == null) {
            return;
        }
        this.f37110c.getValues(r0);
        float max = Math.max(this.f37123p.width() / this.f37115h.getWidth(), this.f37123p.height() / this.f37115h.getHeight());
        this.f37117j = this.f37123p.left - (((this.f37115h.getWidth() * max) - this.f37123p.width()) / 2.0f);
        float height = this.f37123p.top - (((this.f37115h.getHeight() * max) - this.f37123p.height()) / 2.0f);
        this.f37118k = height;
        float[] fArr = {max, 0.0f, this.f37117j, 0.0f, max, height};
        this.f37110c.setValues(fArr);
        float min = Math.min(2048.0f / this.f37115h.getWidth(), 2048.0f / this.f37115h.getHeight());
        this.f37113f = min;
        this.f37114g = max;
        if (min < max) {
            this.f37113f = max;
        }
        setImageMatrix(this.f37110c);
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
            boolean r0 = r5.f37116i
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
            float r6 = r5.m15325a(r6)
            r5.f37121n = r6
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 <= 0) goto Laf
            android.graphics.Matrix r6 = r5.f37111d
            android.graphics.Matrix r0 = r5.f37110c
            r6.set(r0)
            android.graphics.PointF r6 = r5.f37120m
            r5.m15327a(r6)
            r5.f37112e = r3
            goto Laf
        L37:
            int r0 = r5.f37112e
            if (r0 != r1) goto L5f
            android.graphics.Matrix r0 = r5.f37110c
            android.graphics.Matrix r2 = r5.f37111d
            r0.set(r2)
            float r0 = r6.getX()
            android.graphics.PointF r2 = r5.f37119l
            float r2 = r2.x
            float r0 = r0 - r2
            float r6 = r6.getY()
            android.graphics.PointF r2 = r5.f37119l
            float r2 = r2.y
            float r6 = r6 - r2
            android.graphics.Matrix r2 = r5.f37110c
            r2.postTranslate(r0, r6)
            android.graphics.Matrix r6 = r5.f37110c
            r5.setImageMatrix(r6)
            goto Laf
        L5f:
            if (r0 != r3) goto Laf
            android.graphics.Matrix r0 = r5.f37110c
            r0.set(r0)
            float r6 = r5.m15325a(r6)
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L83
            android.graphics.Matrix r0 = r5.f37110c
            android.graphics.Matrix r2 = r5.f37111d
            r0.set(r2)
            float r0 = r5.f37121n
            float r6 = r6 / r0
            android.graphics.Matrix r0 = r5.f37110c
            android.graphics.PointF r2 = r5.f37120m
            float r3 = r2.x
            float r2 = r2.y
            r0.postScale(r6, r6, r3, r2)
        L83:
            android.graphics.Matrix r6 = r5.f37110c
            r5.setImageMatrix(r6)
            goto Laf
        L89:
            r5.m15322b()
            r6 = 0
            r5.f37112e = r6
            goto Laf
        L90:
            android.graphics.Matrix r0 = r5.f37110c
            android.graphics.Matrix r2 = r5.getImageMatrix()
            r0.set(r2)
            android.graphics.Matrix r0 = r5.f37111d
            android.graphics.Matrix r2 = r5.f37110c
            r0.set(r2)
            android.graphics.PointF r0 = r5.f37119l
            float r2 = r6.getX()
            float r6 = r6.getY()
            r0.set(r2, r6)
            r5.f37112e = r1
        Laf:
            r5.f37109b = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.avatar.C12961c.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f37115h = bitmap;
        if (bitmap != null) {
            this.f37115h = bitmap;
        }
    }

    /* renamed from: a */
    private float m15325a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /* renamed from: a */
    public void m15326a(Rect rect) {
        this.f37123p = rect;
        if (this.f37115h != null) {
            m15321c();
        }
    }

    /* renamed from: a */
    private void m15327a(PointF pointF) {
        if (this.f37115h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.f37110c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        float width = this.f37115h.getWidth() * f3;
        float height = this.f37115h.getHeight() * f3;
        Rect rect = this.f37123p;
        float f4 = rect.left - f;
        if (f4 <= 1.0f) {
            f4 = 1.0f;
        }
        float f5 = (f + width) - rect.right;
        if (f5 <= 1.0f) {
            f5 = 1.0f;
        }
        float width2 = (rect.width() * f4) / (f5 + f4);
        Rect rect2 = this.f37123p;
        float f6 = width2 + rect2.left;
        float f7 = rect2.top - f2;
        float f8 = (f2 + height) - rect2.bottom;
        if (f7 <= 1.0f) {
            f7 = 1.0f;
        }
        pointF.set(f6, ((rect2.height() * f7) / ((f8 > 1.0f ? f8 : 1.0f) + f7)) + this.f37123p.top);
    }
}
