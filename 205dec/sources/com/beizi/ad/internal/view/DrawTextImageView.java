package com.beizi.ad.internal.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DrawTextImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private String f14272a;

    /* renamed from: b  reason: collision with root package name */
    private float f14273b;

    /* renamed from: c  reason: collision with root package name */
    private float f14274c;

    /* renamed from: d  reason: collision with root package name */
    private float f14275d;

    /* renamed from: e  reason: collision with root package name */
    private int f14276e;

    /* renamed from: f  reason: collision with root package name */
    private int f14277f;

    public DrawTextImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f14272a = "";
        this.f14273b = 30.0f;
        this.f14274c = -1000.0f;
        this.f14275d = -1000.0f;
        this.f14276e = 0;
        this.f14277f = 3;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f14272a.equals("")) {
            return;
        }
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(this.f14276e));
        paint.setStrokeWidth(this.f14277f);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(this.f14273b);
        String str = this.f14272a;
        float f4 = this.f14274c;
        if (f4 == -1000.0f) {
            f4 = canvas.getWidth() - (this.f14273b * this.f14272a.length());
        }
        float f5 = this.f14275d;
        if (f5 == -1000.0f) {
            f5 = canvas.getHeight() - 50;
        }
        canvas.drawText(str, f4, f5, paint);
    }

    public void setDrawLocalXY(float f4, float f5) {
        this.f14274c = f4;
        this.f14275d = f5;
        drawableStateChanged();
    }

    public void setDrawText(String str) {
        this.f14272a = str;
        drawableStateChanged();
    }

    public void setDrawTextColorResourse(int i4) {
        this.f14276e = i4;
        drawableStateChanged();
    }

    public void setDrawTextSize(float f4) {
        this.f14273b = f4;
        drawableStateChanged();
    }

    public void setDrawTextStrokeWidth(int i4) {
        this.f14277f = i4;
        drawableStateChanged();
    }

    public DrawTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14272a = "";
        this.f14273b = 30.0f;
        this.f14274c = -1000.0f;
        this.f14275d = -1000.0f;
        this.f14276e = 0;
        this.f14277f = 3;
    }

    public DrawTextImageView(Context context) {
        super(context);
        this.f14272a = "";
        this.f14273b = 30.0f;
        this.f14274c = -1000.0f;
        this.f14275d = -1000.0f;
        this.f14276e = 0;
        this.f14277f = 3;
    }
}
