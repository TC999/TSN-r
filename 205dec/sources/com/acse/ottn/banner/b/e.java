package com.acse.ottn.banner.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class e extends a {
    public e(Context context) {
        this(context, null);
    }

    public e(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f5247b.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f5246a.d() <= 1) {
            return;
        }
        this.f5247b.setColor(this.f5246a.g());
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, canvas.getWidth(), this.f5246a.c()), this.f5246a.i(), this.f5246a.i(), this.f5247b);
        this.f5247b.setColor(this.f5246a.j());
        int a4 = this.f5246a.a() * this.f5246a.k();
        canvas.drawRoundRect(new RectF(a4, 0.0f, a4 + this.f5246a.k(), this.f5246a.c()), this.f5246a.i(), this.f5246a.i(), this.f5247b);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int d4 = this.f5246a.d();
        if (d4 <= 1) {
            return;
        }
        setMeasuredDimension(this.f5246a.k() * d4, this.f5246a.c());
    }
}
