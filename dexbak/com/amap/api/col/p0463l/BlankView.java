package com.amap.api.col.p0463l;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/* renamed from: com.amap.api.col.3l.ed */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class BlankView extends View {

    /* renamed from: b */
    public static final int f3946b = Color.argb(255, 235, 235, 235);

    /* renamed from: c */
    public static final int f3947c = Color.argb(255, 21, 21, 21);

    /* renamed from: a */
    private Paint f3948a;

    public BlankView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f3948a = paint;
        paint.setAntiAlias(true);
        this.f3948a.setColor(f3946b);
    }

    /* renamed from: a */
    public final void m55191a() {
        setVisibility(8);
    }

    /* renamed from: b */
    public final void m55190b(int i) {
        Paint paint = this.f3948a;
        if (paint != null) {
            paint.setColor(i);
            try {
                postInvalidate();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f3948a);
    }
}
