package com.qq.e.comm.plugin.dl.p0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends View {

    /* renamed from: c  reason: collision with root package name */
    private final float f42503c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f42504d;

    public a(Context context, int i4) {
        super(context);
        this.f42503c = i4 / 2.0f;
        Paint paint = new Paint();
        this.f42504d = paint;
        paint.setAntiAlias(true);
        this.f42504d.setDither(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f42504d.setColor(2130706432);
        float f4 = this.f42503c;
        canvas.drawCircle(f4, f4, f4, this.f42504d);
    }
}
