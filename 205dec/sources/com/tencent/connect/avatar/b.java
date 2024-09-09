package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b extends View {

    /* renamed from: a  reason: collision with root package name */
    private Rect f51472a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f51473b;

    public b(Context context) {
        super(context);
        b();
    }

    private void b() {
        this.f51473b = new Paint();
    }

    public Rect a() {
        if (this.f51472a == null) {
            this.f51472a = new Rect();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int min = Math.min(Math.min((measuredHeight - 60) - 80, measuredWidth), 640);
            int i4 = (measuredWidth - min) / 2;
            int i5 = (measuredHeight - min) / 2;
            this.f51472a.set(i4, i5, i4 + min, min + i5);
        }
        return this.f51472a;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect a4 = a();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f51473b.setStyle(Paint.Style.FILL);
        this.f51473b.setColor(Color.argb(100, 0, 0, 0));
        float f4 = measuredWidth;
        canvas.drawRect(0.0f, 0.0f, f4, a4.top, this.f51473b);
        canvas.drawRect(0.0f, a4.bottom, f4, measuredHeight, this.f51473b);
        canvas.drawRect(0.0f, a4.top, a4.left, a4.bottom, this.f51473b);
        canvas.drawRect(a4.right, a4.top, f4, a4.bottom, this.f51473b);
        canvas.drawColor(Color.argb(100, 0, 0, 0));
        this.f51473b.setStyle(Paint.Style.STROKE);
        this.f51473b.setColor(-1);
        canvas.drawRect(a4.left, a4.top, a4.right - 1, a4.bottom, this.f51473b);
    }
}
