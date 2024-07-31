package com.beizi.p051ad.internal.view;

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

/* renamed from: com.beizi.ad.internal.view.CustomRoundImageView */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CustomRoundImageView extends AppCompatImageView {

    /* renamed from: a */
    private final RectF f10701a;

    /* renamed from: b */
    private float f10702b;

    /* renamed from: c */
    private String f10703c;

    /* renamed from: d */
    private int f10704d;

    /* renamed from: e */
    private final Paint f10705e;

    /* renamed from: f */
    private final Paint f10706f;

    public CustomRoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10701a = new RectF();
        this.f10702b = 0.0f;
        this.f10703c = null;
        this.f10704d = 0;
        this.f10705e = new Paint();
        this.f10706f = new Paint();
        m49155a();
    }

    /* renamed from: a */
    private void m49155a() {
        this.f10705e.setAntiAlias(true);
        this.f10705e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.f10706f.setAntiAlias(true);
        this.f10706f.setColor(-1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.f10701a, this.f10706f, 31);
        RectF rectF = this.f10701a;
        float f = this.f10702b;
        canvas.drawRoundRect(rectF, f, f, this.f10706f);
        canvas.saveLayer(this.f10701a, this.f10705e, 31);
        super.draw(canvas);
        if (this.f10704d > 0 && !TextUtils.isEmpty(this.f10703c) && this.f10703c.startsWith("#")) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor(this.f10703c));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.f10704d);
            paint.setAntiAlias(true);
            RectF rectF2 = this.f10701a;
            float f2 = this.f10702b;
            canvas.drawRoundRect(rectF2, f2, f2, paint);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f10701a.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    public void setBorderColor(String str) {
        this.f10703c = str;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.f10704d = i;
        invalidate();
    }

    public void setRectRadius(float f) {
        this.f10702b = f;
        invalidate();
    }

    public CustomRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10701a = new RectF();
        this.f10702b = 0.0f;
        this.f10703c = null;
        this.f10704d = 0;
        this.f10705e = new Paint();
        this.f10706f = new Paint();
        m49155a();
    }

    public CustomRoundImageView(Context context) {
        super(context);
        this.f10701a = new RectF();
        this.f10702b = 0.0f;
        this.f10703c = null;
        this.f10704d = 0;
        this.f10705e = new Paint();
        this.f10706f = new Paint();
        m49155a();
    }
}
