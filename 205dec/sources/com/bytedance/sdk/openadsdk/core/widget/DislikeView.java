package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DislikeView extends View {

    /* renamed from: c  reason: collision with root package name */
    private int f35370c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private int f35371f;

    /* renamed from: r  reason: collision with root package name */
    private Paint f35372r;
    private Paint sr;
    private Paint ux;

    /* renamed from: w  reason: collision with root package name */
    private int f35373w;
    private RectF xv;

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.xv;
        int i4 = this.f35371f;
        canvas.drawRoundRect(rectF, i4, i4, this.ux);
        RectF rectF2 = this.xv;
        int i5 = this.f35371f;
        canvas.drawRoundRect(rectF2, i5, i5, this.sr);
        int i6 = this.f35370c;
        int i7 = this.f35373w;
        canvas.drawLine(i6 * 0.3f, i7 * 0.3f, i6 * 0.7f, i7 * 0.7f, this.f35372r);
        int i8 = this.f35370c;
        int i9 = this.f35373w;
        canvas.drawLine(i8 * 0.7f, i9 * 0.3f, i8 * 0.3f, i9 * 0.7f, this.f35372r);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f35370c = i4;
        this.f35373w = i5;
        int i8 = this.ev;
        this.xv = new RectF(i8, i8, this.f35370c - i8, this.f35373w - i8);
    }

    public void setBgColor(int i4) {
        this.ux.setStyle(Paint.Style.FILL);
        this.ux.setColor(i4);
    }

    public void setDislikeColor(int i4) {
        this.f35372r.setColor(i4);
    }

    public void setDislikeWidth(int i4) {
        this.f35372r.setStrokeWidth(i4);
    }

    public void setRadius(int i4) {
        this.f35371f = i4;
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
