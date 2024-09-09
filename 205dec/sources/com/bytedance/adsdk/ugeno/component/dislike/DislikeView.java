package com.bytedance.adsdk.ugeno.component.dislike;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.adsdk.ugeno.component.b;
import j0.d;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DislikeView extends View {

    /* renamed from: a  reason: collision with root package name */
    private d f26050a;

    /* renamed from: b  reason: collision with root package name */
    private int f26051b;

    /* renamed from: c  reason: collision with root package name */
    private int f26052c;

    /* renamed from: d  reason: collision with root package name */
    private RectF f26053d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f26054e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f26055f;

    /* renamed from: g  reason: collision with root package name */
    private float f26056g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f26057h;

    /* renamed from: i  reason: collision with root package name */
    private int f26058i;

    public DislikeView(Context context) {
        super(context);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f26054e = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f26057h = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.f26055f = paint3;
        paint3.setAntiAlias(true);
        setBackgroundColor(0);
    }

    public void b(b bVar) {
        this.f26050a = bVar;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.f26050a;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.f26050a;
        if (dVar != null) {
            dVar.r();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(0);
        RectF rectF = this.f26053d;
        float f4 = this.f26056g;
        canvas.drawRoundRect(rectF, f4, f4, this.f26055f);
        RectF rectF2 = this.f26053d;
        float f5 = this.f26056g;
        canvas.drawRoundRect(rectF2, f5, f5, this.f26054e);
        int i4 = this.f26051b;
        int i5 = this.f26052c;
        canvas.drawLine(i4 * 0.3f, i5 * 0.3f, i4 * 0.7f, i5 * 0.7f, this.f26057h);
        int i6 = this.f26051b;
        int i7 = this.f26052c;
        canvas.drawLine(i6 * 0.7f, i7 * 0.3f, i6 * 0.3f, i7 * 0.7f, this.f26057h);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f26051b = i4;
        this.f26052c = i5;
        int i8 = this.f26058i;
        this.f26053d = new RectF(i8, i8, this.f26051b - i8, this.f26052c - i8);
    }

    public void setBgColor(int i4) {
        this.f26055f.setStyle(Paint.Style.FILL);
        this.f26055f.setColor(i4);
    }

    public void setDislikeColor(int i4) {
        this.f26057h.setColor(i4);
    }

    public void setDislikeWidth(int i4) {
        this.f26057h.setStrokeWidth(i4);
    }

    public void setRadius(float f4) {
        this.f26056g = f4;
    }

    public void setStrokeColor(int i4) {
        this.f26054e.setStyle(Paint.Style.STROKE);
        this.f26054e.setColor(i4);
    }

    public void setStrokeWidth(int i4) {
        this.f26054e.setStrokeWidth(i4);
        this.f26058i = i4;
    }
}
