package com.beizi.p051ad.internal.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* renamed from: com.beizi.ad.internal.view.DrawTextImageView */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DrawTextImageView extends AppCompatImageView {

    /* renamed from: a */
    private String f10707a;

    /* renamed from: b */
    private float f10708b;

    /* renamed from: c */
    private float f10709c;

    /* renamed from: d */
    private float f10710d;

    /* renamed from: e */
    private int f10711e;

    /* renamed from: f */
    private int f10712f;

    public DrawTextImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10707a = "";
        this.f10708b = 30.0f;
        this.f10709c = -1000.0f;
        this.f10710d = -1000.0f;
        this.f10711e = 0;
        this.f10712f = 3;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f10707a.equals("")) {
            return;
        }
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(this.f10711e));
        paint.setStrokeWidth(this.f10712f);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(this.f10708b);
        String str = this.f10707a;
        float f = this.f10709c;
        if (f == -1000.0f) {
            f = canvas.getWidth() - (this.f10708b * this.f10707a.length());
        }
        float f2 = this.f10710d;
        if (f2 == -1000.0f) {
            f2 = canvas.getHeight() - 50;
        }
        canvas.drawText(str, f, f2, paint);
    }

    public void setDrawLocalXY(float f, float f2) {
        this.f10709c = f;
        this.f10710d = f2;
        drawableStateChanged();
    }

    public void setDrawText(String str) {
        this.f10707a = str;
        drawableStateChanged();
    }

    public void setDrawTextColorResourse(int i) {
        this.f10711e = i;
        drawableStateChanged();
    }

    public void setDrawTextSize(float f) {
        this.f10708b = f;
        drawableStateChanged();
    }

    public void setDrawTextStrokeWidth(int i) {
        this.f10712f = i;
        drawableStateChanged();
    }

    public DrawTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10707a = "";
        this.f10708b = 30.0f;
        this.f10709c = -1000.0f;
        this.f10710d = -1000.0f;
        this.f10711e = 0;
        this.f10712f = 3;
    }

    public DrawTextImageView(Context context) {
        super(context);
        this.f10707a = "";
        this.f10708b = 30.0f;
        this.f10709c = -1000.0f;
        this.f10710d = -1000.0f;
        this.f10711e = 0;
        this.f10712f = 3;
    }
}
