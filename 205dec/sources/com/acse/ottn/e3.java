package com.acse.ottn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e3 extends b0 {

    /* renamed from: d  reason: collision with root package name */
    public RectF f5639d;

    public e3(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int d4 = this.f5163a.d();
        if (d4 <= 1) {
            return;
        }
        int i4 = 0;
        float f4 = 0.0f;
        while (i4 < d4) {
            this.f5164b.setColor(this.f5163a.a() == i4 ? this.f5163a.j() : this.f5163a.g());
            int k4 = this.f5163a.a() == i4 ? this.f5163a.k() : this.f5163a.h();
            this.f5639d.set(f4, 0.0f, k4 + f4, this.f5163a.c());
            f4 += k4 + this.f5163a.e();
            canvas.drawRoundRect(this.f5639d, this.f5163a.i(), this.f5163a.i(), this.f5164b);
            i4++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int d4 = this.f5163a.d();
        if (d4 <= 1) {
            return;
        }
        int i6 = d4 - 1;
        setMeasuredDimension((this.f5163a.e() * i6) + (this.f5163a.h() * i6) + this.f5163a.k(), this.f5163a.c());
    }

    public e3(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e3(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f5639d = new RectF();
    }
}
