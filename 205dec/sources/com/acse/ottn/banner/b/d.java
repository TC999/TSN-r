package com.acse.ottn.banner.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class d extends a {

    /* renamed from: d  reason: collision with root package name */
    RectF f5252d;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f5252d = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int d4 = this.f5246a.d();
        if (d4 <= 1) {
            return;
        }
        int i4 = 0;
        float f4 = 0.0f;
        while (i4 < d4) {
            this.f5247b.setColor(this.f5246a.a() == i4 ? this.f5246a.j() : this.f5246a.g());
            int k4 = this.f5246a.a() == i4 ? this.f5246a.k() : this.f5246a.h();
            this.f5252d.set(f4, 0.0f, k4 + f4, this.f5246a.c());
            f4 += k4 + this.f5246a.e();
            canvas.drawRoundRect(this.f5252d, this.f5246a.i(), this.f5246a.i(), this.f5247b);
            i4++;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int d4 = this.f5246a.d();
        if (d4 <= 1) {
            return;
        }
        int i6 = d4 - 1;
        setMeasuredDimension((this.f5246a.e() * i6) + (this.f5246a.h() * i6) + this.f5246a.k(), this.f5246a.c());
    }
}
