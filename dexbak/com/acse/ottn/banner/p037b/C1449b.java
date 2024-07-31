package com.acse.ottn.banner.p037b;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

/* renamed from: com.acse.ottn.banner.b.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1449b extends C1448a {

    /* renamed from: d */
    private int f2648d;

    /* renamed from: e */
    private int f2649e;

    /* renamed from: f */
    private int f2650f;

    public C1449b(Context context) {
        this(context, null);
    }

    public C1449b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1449b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2648d = this.f2645a.m56715h() / 2;
        this.f2649e = this.f2645a.m56709k() / 2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int m56723d = this.f2645a.m56723d();
        if (m56723d <= 1) {
            return;
        }
        float f = 0.0f;
        int i = 0;
        while (i < m56723d) {
            this.f2646b.setColor(this.f2645a.m56731a() == i ? this.f2645a.m56711j() : this.f2645a.m56717g());
            int m56709k = this.f2645a.m56731a() == i ? this.f2645a.m56709k() : this.f2645a.m56715h();
            float f2 = this.f2645a.m56731a() == i ? this.f2649e : this.f2648d;
            canvas.drawCircle(f + f2, this.f2650f, f2, this.f2646b);
            f += m56709k + this.f2645a.m56721e();
            i++;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int m56723d = this.f2645a.m56723d();
        if (m56723d <= 1) {
            return;
        }
        this.f2648d = this.f2645a.m56715h() / 2;
        int m56709k = this.f2645a.m56709k() / 2;
        this.f2649e = m56709k;
        this.f2650f = Math.max(m56709k, this.f2648d);
        int i3 = m56723d - 1;
        setMeasuredDimension((this.f2645a.m56721e() * i3) + this.f2645a.m56709k() + (this.f2645a.m56715h() * i3), Math.max(this.f2645a.m56715h(), this.f2645a.m56709k()));
    }
}
