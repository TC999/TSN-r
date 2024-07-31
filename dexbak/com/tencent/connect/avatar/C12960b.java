package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/* compiled from: ProGuard */
/* renamed from: com.tencent.connect.avatar.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12960b extends View {

    /* renamed from: a */
    private Rect f37106a;

    /* renamed from: b */
    private Paint f37107b;

    public C12960b(Context context) {
        super(context);
        m15329b();
    }

    /* renamed from: b */
    private void m15329b() {
        this.f37107b = new Paint();
    }

    /* renamed from: a */
    public Rect m15330a() {
        if (this.f37106a == null) {
            this.f37106a = new Rect();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int min = Math.min(Math.min((measuredHeight - 60) - 80, measuredWidth), 640);
            int i = (measuredWidth - min) / 2;
            int i2 = (measuredHeight - min) / 2;
            this.f37106a.set(i, i2, i + min, min + i2);
        }
        return this.f37106a;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect m15330a = m15330a();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f37107b.setStyle(Paint.Style.FILL);
        this.f37107b.setColor(Color.argb(100, 0, 0, 0));
        float f = measuredWidth;
        canvas.drawRect(0.0f, 0.0f, f, m15330a.top, this.f37107b);
        canvas.drawRect(0.0f, m15330a.bottom, f, measuredHeight, this.f37107b);
        canvas.drawRect(0.0f, m15330a.top, m15330a.left, m15330a.bottom, this.f37107b);
        canvas.drawRect(m15330a.right, m15330a.top, f, m15330a.bottom, this.f37107b);
        canvas.drawColor(Color.argb(100, 0, 0, 0));
        this.f37107b.setStyle(Paint.Style.STROKE);
        this.f37107b.setColor(-1);
        canvas.drawRect(m15330a.left, m15330a.top, m15330a.right - 1, m15330a.bottom, this.f37107b);
    }
}
