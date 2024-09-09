package com.qq.e.comm.plugin.r0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.view.View;
import com.qq.e.comm.plugin.util.f1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends View {

    /* renamed from: c  reason: collision with root package name */
    private Paint f45672c;

    /* renamed from: d  reason: collision with root package name */
    private int f45673d;

    /* renamed from: e  reason: collision with root package name */
    private RectF f45674e;

    /* renamed from: f  reason: collision with root package name */
    private int f45675f;

    /* renamed from: g  reason: collision with root package name */
    private Matrix f45676g;

    /* renamed from: h  reason: collision with root package name */
    private SweepGradient f45677h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f45678i;

    /* renamed from: j  reason: collision with root package name */
    Runnable f45679j;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.r0.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class RunnableC0883a implements Runnable {
        RunnableC0883a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f45675f += 10;
            a.this.f45675f %= 360;
            if (a.this.f45678i) {
                a.this.postInvalidate();
                a aVar = a.this;
                aVar.postDelayed(aVar.f45679j, 20L);
            }
        }
    }

    public a(Context context) {
        super(context);
        this.f45673d = f1.a(getContext().getApplicationContext(), 4);
        this.f45675f = 0;
        this.f45679j = new RunnableC0883a();
        setLayerType(1, null);
        a();
    }

    public void c() {
        this.f45678i = false;
        removeCallbacks(this.f45679j);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f45678i) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (this.f45677h == null) {
                this.f45677h = new SweepGradient(measuredWidth / 2, measuredHeight / 2, new int[]{0, Color.parseColor("#FFC3C4C5")}, (float[]) null);
            }
            this.f45677h.setLocalMatrix(this.f45676g);
            this.f45676g.setRotate(this.f45675f, measuredWidth / 2, measuredHeight / 2);
            this.f45672c.setShader(this.f45677h);
            RectF rectF = this.f45674e;
            int i4 = this.f45673d;
            float f4 = i4;
            rectF.left = f4;
            rectF.top = f4;
            float f5 = measuredWidth - i4;
            rectF.right = f5;
            rectF.bottom = f5;
            canvas.drawArc(rectF, this.f45675f, 359.0f, false, this.f45672c);
        }
    }

    public void b() {
        if (this.f45678i) {
            return;
        }
        this.f45678i = true;
        post(this.f45679j);
    }

    private void a() {
        Paint paint = new Paint();
        this.f45672c = paint;
        paint.setAntiAlias(true);
        this.f45672c.setStyle(Paint.Style.STROKE);
        this.f45672c.setStrokeWidth(this.f45673d);
        this.f45676g = new Matrix();
        this.f45674e = new RectF();
    }
}
