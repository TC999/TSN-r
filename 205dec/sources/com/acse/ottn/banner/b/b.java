package com.acse.ottn.banner.b;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b extends a {

    /* renamed from: d  reason: collision with root package name */
    private int f5249d;

    /* renamed from: e  reason: collision with root package name */
    private int f5250e;

    /* renamed from: f  reason: collision with root package name */
    private int f5251f;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f5249d = this.f5246a.h() / 2;
        this.f5250e = this.f5246a.k() / 2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int d4 = this.f5246a.d();
        if (d4 <= 1) {
            return;
        }
        float f4 = 0.0f;
        int i4 = 0;
        while (i4 < d4) {
            this.f5247b.setColor(this.f5246a.a() == i4 ? this.f5246a.j() : this.f5246a.g());
            int k4 = this.f5246a.a() == i4 ? this.f5246a.k() : this.f5246a.h();
            float f5 = this.f5246a.a() == i4 ? this.f5250e : this.f5249d;
            canvas.drawCircle(f4 + f5, this.f5251f, f5, this.f5247b);
            f4 += k4 + this.f5246a.e();
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
        this.f5249d = this.f5246a.h() / 2;
        int k4 = this.f5246a.k() / 2;
        this.f5250e = k4;
        this.f5251f = Math.max(k4, this.f5249d);
        int i6 = d4 - 1;
        setMeasuredDimension((this.f5246a.e() * i6) + this.f5246a.k() + (this.f5246a.h() * i6), Math.max(this.f5246a.h(), this.f5246a.k()));
    }
}
