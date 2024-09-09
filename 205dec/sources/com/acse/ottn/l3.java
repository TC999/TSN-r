package com.acse.ottn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class l3 extends b0 {
    public l3(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f5163a.d() <= 1) {
            return;
        }
        this.f5164b.setColor(this.f5163a.g());
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, canvas.getWidth(), this.f5163a.c()), this.f5163a.i(), this.f5163a.i(), this.f5164b);
        this.f5164b.setColor(this.f5163a.j());
        int a4 = this.f5163a.a() * this.f5163a.k();
        canvas.drawRoundRect(new RectF(a4, 0.0f, a4 + this.f5163a.k(), this.f5163a.c()), this.f5163a.i(), this.f5163a.i(), this.f5164b);
    }

    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int d4 = this.f5163a.d();
        if (d4 <= 1) {
            return;
        }
        setMeasuredDimension(this.f5163a.k() * d4, this.f5163a.c());
    }

    public l3(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public l3(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f5164b.setStyle(Paint.Style.FILL);
    }
}
