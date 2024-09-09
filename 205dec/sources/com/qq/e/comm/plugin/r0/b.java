package com.qq.e.comm.plugin.r0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.qq.e.comm.plugin.util.f1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends View {

    /* renamed from: c  reason: collision with root package name */
    private Paint f45681c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f45682d;

    /* renamed from: e  reason: collision with root package name */
    private int f45683e;

    /* renamed from: f  reason: collision with root package name */
    private int f45684f;

    /* renamed from: g  reason: collision with root package name */
    private int f45685g;

    /* renamed from: h  reason: collision with root package name */
    private RectF f45686h;

    public b(Context context) {
        super(context);
        this.f45684f = f1.a(getContext().getApplicationContext(), 4);
        this.f45685g = 100;
        setLayerType(1, null);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f45681c = paint;
        paint.setAntiAlias(true);
        this.f45681c.setColor(Color.parseColor("#C3C4C5"));
        this.f45681c.setStyle(Paint.Style.STROKE);
        this.f45681c.setStrokeWidth(this.f45684f);
        Paint paint2 = new Paint();
        this.f45682d = paint2;
        paint2.setAntiAlias(true);
        this.f45682d.setStyle(Paint.Style.STROKE);
        this.f45682d.setColor(-1);
        this.f45682d.setStrokeWidth(this.f45684f);
        this.f45686h = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i4;
        super.onDraw(canvas);
        int measuredWidth = getMeasuredWidth();
        canvas.drawCircle(measuredWidth / 2, getMeasuredHeight() / 2, i4 - this.f45684f, this.f45681c);
        int i5 = this.f45683e;
        if (i5 > 0) {
            RectF rectF = this.f45686h;
            int i6 = this.f45684f;
            float f4 = i6;
            rectF.left = f4;
            rectF.top = f4;
            float f5 = measuredWidth - i6;
            rectF.right = f5;
            rectF.bottom = f5;
            canvas.drawArc(rectF, -90.0f, (i5 / this.f45685g) * 360.0f, false, this.f45682d);
        }
    }

    public void a(int i4) {
        if (i4 <= 0) {
            this.f45683e = 0;
        } else if (i4 >= 100) {
            this.f45683e = 100;
        } else {
            this.f45683e = i4;
        }
        postInvalidate();
    }
}
