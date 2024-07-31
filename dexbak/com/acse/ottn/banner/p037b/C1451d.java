package com.acse.ottn.banner.p037b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;

/* renamed from: com.acse.ottn.banner.b.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1451d extends C1448a {

    /* renamed from: d */
    RectF f2651d;

    public C1451d(Context context) {
        this(context, null);
    }

    public C1451d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1451d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2651d = new RectF();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int m56723d = this.f2645a.m56723d();
        if (m56723d <= 1) {
            return;
        }
        int i = 0;
        float f = 0.0f;
        while (i < m56723d) {
            this.f2646b.setColor(this.f2645a.m56731a() == i ? this.f2645a.m56711j() : this.f2645a.m56717g());
            int m56709k = this.f2645a.m56731a() == i ? this.f2645a.m56709k() : this.f2645a.m56715h();
            this.f2651d.set(f, 0.0f, m56709k + f, this.f2645a.m56725c());
            f += m56709k + this.f2645a.m56721e();
            canvas.drawRoundRect(this.f2651d, this.f2645a.m56713i(), this.f2645a.m56713i(), this.f2646b);
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
        int i3 = m56723d - 1;
        setMeasuredDimension((this.f2645a.m56721e() * i3) + (this.f2645a.m56715h() * i3) + this.f2645a.m56709k(), this.f2645a.m56725c());
    }
}
