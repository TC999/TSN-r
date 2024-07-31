package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CustomRoundImageView extends AppCompatImageView {

    /* renamed from: a */
    private final RectF f11582a;

    /* renamed from: b */
    private float f11583b;

    /* renamed from: c */
    private String f11584c;

    /* renamed from: d */
    private int f11585d;

    /* renamed from: e */
    private final Paint f11586e;

    /* renamed from: f */
    private final Paint f11587f;

    public CustomRoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11582a = new RectF();
        this.f11583b = 0.0f;
        this.f11584c = null;
        this.f11585d = 0;
        this.f11586e = new Paint();
        this.f11587f = new Paint();
        m48080a();
    }

    /* renamed from: a */
    private void m48080a() {
        this.f11586e.setAntiAlias(true);
        this.f11586e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f11587f.setAntiAlias(true);
        this.f11587f.setColor(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f11582a, this.f11587f, 31);
        RectF rectF = this.f11582a;
        float f = this.f11583b;
        canvas.drawRoundRect(rectF, f, f, this.f11587f);
        canvas.saveLayer(this.f11582a, this.f11586e, 31);
        super.draw(canvas);
        if (this.f11585d > 0 && !TextUtils.isEmpty(this.f11584c) && this.f11584c.startsWith("#")) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor(this.f11584c));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.f11585d);
            paint.setAntiAlias(true);
            RectF rectF2 = this.f11582a;
            float f2 = this.f11583b;
            canvas.drawRoundRect(rectF2, f2, f2, paint);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f11582a.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    public void setBorderColor(String str) {
        this.f11584c = str;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.f11585d = i;
        invalidate();
    }

    public void setRectRadius(float f) {
        this.f11583b = f;
        invalidate();
    }

    public CustomRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11582a = new RectF();
        this.f11583b = 0.0f;
        this.f11584c = null;
        this.f11585d = 0;
        this.f11586e = new Paint();
        this.f11587f = new Paint();
        m48080a();
    }

    public CustomRoundImageView(Context context) {
        super(context);
        this.f11582a = new RectF();
        this.f11583b = 0.0f;
        this.f11584c = null;
        this.f11585d = 0;
        this.f11586e = new Paint();
        this.f11587f = new Paint();
        m48080a();
    }
}
