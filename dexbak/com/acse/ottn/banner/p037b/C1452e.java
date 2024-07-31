package com.acse.ottn.banner.p037b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;

/* renamed from: com.acse.ottn.banner.b.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1452e extends C1448a {
    public C1452e(Context context) {
        this(context, null);
    }

    public C1452e(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1452e(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2646b.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2645a.m56723d() <= 1) {
            return;
        }
        this.f2646b.setColor(this.f2645a.m56717g());
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, canvas.getWidth(), this.f2645a.m56725c()), this.f2645a.m56713i(), this.f2645a.m56713i(), this.f2646b);
        this.f2646b.setColor(this.f2645a.m56711j());
        int m56731a = this.f2645a.m56731a() * this.f2645a.m56709k();
        canvas.drawRoundRect(new RectF(m56731a, 0.0f, m56731a + this.f2645a.m56709k(), this.f2645a.m56725c()), this.f2645a.m56713i(), this.f2645a.m56713i(), this.f2646b);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int m56723d = this.f2645a.m56723d();
        if (m56723d <= 1) {
            return;
        }
        setMeasuredDimension(this.f2645a.m56709k() * m56723d, this.f2645a.m56725c());
    }
}
