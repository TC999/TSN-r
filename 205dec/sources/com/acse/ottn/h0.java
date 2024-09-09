package com.acse.ottn;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h0 extends b0 {

    /* renamed from: d  reason: collision with root package name */
    public int f5710d;

    /* renamed from: e  reason: collision with root package name */
    public int f5711e;

    /* renamed from: f  reason: collision with root package name */
    public int f5712f;

    public h0(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int d4 = this.f5163a.d();
        if (d4 <= 1) {
            return;
        }
        float f4 = 0.0f;
        int i4 = 0;
        while (i4 < d4) {
            this.f5164b.setColor(this.f5163a.a() == i4 ? this.f5163a.j() : this.f5163a.g());
            int k4 = this.f5163a.a() == i4 ? this.f5163a.k() : this.f5163a.h();
            float f5 = this.f5163a.a() == i4 ? this.f5711e : this.f5710d;
            canvas.drawCircle(f4 + f5, this.f5712f, f5, this.f5164b);
            f4 += k4 + this.f5163a.e();
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
        this.f5710d = this.f5163a.h() / 2;
        int k4 = this.f5163a.k() / 2;
        this.f5711e = k4;
        this.f5712f = Math.max(k4, this.f5710d);
        int i6 = d4 - 1;
        setMeasuredDimension((this.f5163a.e() * i6) + this.f5163a.k() + (this.f5163a.h() * i6), Math.max(this.f5163a.h(), this.f5163a.k()));
    }

    public h0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public h0(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f5710d = this.f5163a.h() / 2;
        this.f5711e = this.f5163a.k() / 2;
    }
}
