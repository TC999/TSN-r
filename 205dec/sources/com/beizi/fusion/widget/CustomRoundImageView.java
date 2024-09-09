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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CustomRoundImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private final RectF f15167a;

    /* renamed from: b  reason: collision with root package name */
    private float f15168b;

    /* renamed from: c  reason: collision with root package name */
    private String f15169c;

    /* renamed from: d  reason: collision with root package name */
    private int f15170d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f15171e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f15172f;

    public CustomRoundImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f15167a = new RectF();
        this.f15168b = 0.0f;
        this.f15169c = null;
        this.f15170d = 0;
        this.f15171e = new Paint();
        this.f15172f = new Paint();
        a();
    }

    private void a() {
        this.f15171e.setAntiAlias(true);
        this.f15171e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f15172f.setAntiAlias(true);
        this.f15172f.setColor(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f15167a, this.f15172f, 31);
        RectF rectF = this.f15167a;
        float f4 = this.f15168b;
        canvas.drawRoundRect(rectF, f4, f4, this.f15172f);
        canvas.saveLayer(this.f15167a, this.f15171e, 31);
        super.draw(canvas);
        if (this.f15170d > 0 && !TextUtils.isEmpty(this.f15169c) && this.f15169c.startsWith("#")) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor(this.f15169c));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.f15170d);
            paint.setAntiAlias(true);
            RectF rectF2 = this.f15167a;
            float f5 = this.f15168b;
            canvas.drawRoundRect(rectF2, f5, f5, paint);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        this.f15167a.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    public void setBorderColor(String str) {
        this.f15169c = str;
        invalidate();
    }

    public void setBorderWidth(int i4) {
        this.f15170d = i4;
        invalidate();
    }

    public void setRectRadius(float f4) {
        this.f15168b = f4;
        invalidate();
    }

    public CustomRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15167a = new RectF();
        this.f15168b = 0.0f;
        this.f15169c = null;
        this.f15170d = 0;
        this.f15171e = new Paint();
        this.f15172f = new Paint();
        a();
    }

    public CustomRoundImageView(Context context) {
        super(context);
        this.f15167a = new RectF();
        this.f15168b = 0.0f;
        this.f15169c = null;
        this.f15170d = 0;
        this.f15171e = new Paint();
        this.f15172f = new Paint();
        a();
    }
}
