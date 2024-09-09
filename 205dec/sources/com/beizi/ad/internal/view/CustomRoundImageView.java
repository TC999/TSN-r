package com.beizi.ad.internal.view;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CustomRoundImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private final RectF f14266a;

    /* renamed from: b  reason: collision with root package name */
    private float f14267b;

    /* renamed from: c  reason: collision with root package name */
    private String f14268c;

    /* renamed from: d  reason: collision with root package name */
    private int f14269d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f14270e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f14271f;

    public CustomRoundImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f14266a = new RectF();
        this.f14267b = 0.0f;
        this.f14268c = null;
        this.f14269d = 0;
        this.f14270e = new Paint();
        this.f14271f = new Paint();
        a();
    }

    private void a() {
        this.f14270e.setAntiAlias(true);
        this.f14270e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f14271f.setAntiAlias(true);
        this.f14271f.setColor(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f14266a, this.f14271f, 31);
        RectF rectF = this.f14266a;
        float f4 = this.f14267b;
        canvas.drawRoundRect(rectF, f4, f4, this.f14271f);
        canvas.saveLayer(this.f14266a, this.f14270e, 31);
        super.draw(canvas);
        if (this.f14269d > 0 && !TextUtils.isEmpty(this.f14268c) && this.f14268c.startsWith("#")) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor(this.f14268c));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.f14269d);
            paint.setAntiAlias(true);
            RectF rectF2 = this.f14266a;
            float f5 = this.f14267b;
            canvas.drawRoundRect(rectF2, f5, f5, paint);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        this.f14266a.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    public void setBorderColor(String str) {
        this.f14268c = str;
        invalidate();
    }

    public void setBorderWidth(int i4) {
        this.f14269d = i4;
        invalidate();
    }

    public void setRectRadius(float f4) {
        this.f14267b = f4;
        invalidate();
    }

    public CustomRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14266a = new RectF();
        this.f14267b = 0.0f;
        this.f14268c = null;
        this.f14269d = 0;
        this.f14270e = new Paint();
        this.f14271f = new Paint();
        a();
    }

    public CustomRoundImageView(Context context) {
        super(context);
        this.f14266a = new RectF();
        this.f14267b = 0.0f;
        this.f14268c = null;
        this.f14269d = 0;
        this.f14270e = new Paint();
        this.f14271f = new Paint();
        a();
    }
}
