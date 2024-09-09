package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DislikeView extends View {

    /* renamed from: c  reason: collision with root package name */
    private int f29511c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private int f29512f;

    /* renamed from: r  reason: collision with root package name */
    private Paint f29513r;
    private Paint sr;
    private Paint ux;

    /* renamed from: w  reason: collision with root package name */
    private int f29514w;
    private final RectF xv;

    public DislikeView(Context context) {
        super(context);
        this.xv = new RectF();
        c();
    }

    private void c() {
        Paint paint = new Paint();
        this.sr = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f29513r = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.ux = paint3;
        paint3.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.xv;
        int i4 = this.f29512f;
        canvas.drawRoundRect(rectF, i4, i4, this.ux);
        RectF rectF2 = this.xv;
        int i5 = this.f29512f;
        canvas.drawRoundRect(rectF2, i5, i5, this.sr);
        int i6 = this.f29511c;
        int i7 = this.f29514w;
        canvas.drawLine(i6 * 0.3f, i7 * 0.3f, i6 * 0.7f, i7 * 0.7f, this.f29513r);
        int i8 = this.f29511c;
        int i9 = this.f29514w;
        canvas.drawLine(i8 * 0.7f, i9 * 0.3f, i8 * 0.3f, i9 * 0.7f, this.f29513r);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f29511c = i4;
        this.f29514w = i5;
        RectF rectF = this.xv;
        int i8 = this.ev;
        rectF.set(i8, i8, i4 - i8, i5 - i8);
    }

    public void setBgColor(int i4) {
        this.ux.setStyle(Paint.Style.FILL);
        this.ux.setColor(i4);
    }

    public void setDislikeColor(int i4) {
        this.f29513r.setColor(i4);
    }

    public void setDislikeWidth(int i4) {
        this.f29513r.setStrokeWidth(i4);
    }

    public void setRadius(int i4) {
        this.f29512f = i4;
    }

    public void setStrokeColor(int i4) {
        this.sr.setStyle(Paint.Style.STROKE);
        this.sr.setColor(i4);
    }

    public void setStrokeWidth(int i4) {
        this.sr.setStrokeWidth(i4);
        this.ev = i4;
    }
}
