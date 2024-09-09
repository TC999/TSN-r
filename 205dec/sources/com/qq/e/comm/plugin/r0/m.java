package com.qq.e.comm.plugin.r0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class m extends ImageView {

    /* renamed from: c  reason: collision with root package name */
    private RectF f45826c;

    /* renamed from: d  reason: collision with root package name */
    private Path f45827d;

    /* renamed from: e  reason: collision with root package name */
    private float[] f45828e;

    public m(Context context) {
        super(context);
        this.f45826c = new RectF();
        this.f45827d = new Path();
        this.f45828e = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    public void a(float f4) {
        float[] fArr = this.f45828e;
        fArr[0] = f4;
        fArr[1] = f4;
        fArr[2] = f4;
        fArr[3] = f4;
        fArr[4] = f4;
        fArr[5] = f4;
        fArr[6] = f4;
        fArr[7] = f4;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        this.f45826c.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f45827d.addRoundRect(this.f45826c, this.f45828e, Path.Direction.CW);
        canvas.clipPath(this.f45827d);
        super.onDraw(canvas);
        this.f45827d.reset();
    }
}
