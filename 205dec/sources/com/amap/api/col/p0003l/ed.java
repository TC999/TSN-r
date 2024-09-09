package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: BlankView.java */
/* renamed from: com.amap.api.col.3l.ed  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ed extends View {

    /* renamed from: b  reason: collision with root package name */
    public static final int f7524b = Color.argb(255, 235, 235, 235);

    /* renamed from: c  reason: collision with root package name */
    public static final int f7525c = Color.argb(255, 21, 21, 21);

    /* renamed from: a  reason: collision with root package name */
    private Paint f7526a;

    public ed(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f7526a = paint;
        paint.setAntiAlias(true);
        this.f7526a.setColor(f7524b);
    }

    public final void a() {
        setVisibility(8);
    }

    public final void b(int i4) {
        Paint paint = this.f7526a;
        if (paint != null) {
            paint.setColor(i4);
            try {
                postInvalidate();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f7526a);
    }
}
