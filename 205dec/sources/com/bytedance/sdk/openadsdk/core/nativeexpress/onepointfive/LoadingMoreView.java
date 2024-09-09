package com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.eq.xk;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class LoadingMoreView extends View {

    /* renamed from: c  reason: collision with root package name */
    private static final String f34132c = LoadingMoreView.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private float f34133a;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private int f34134f;
    private float gd;

    /* renamed from: k  reason: collision with root package name */
    private float f34135k;

    /* renamed from: p  reason: collision with root package name */
    private int f34136p;

    /* renamed from: r  reason: collision with root package name */
    private int f34137r;
    private Path sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private final int f34138w;
    private Paint xv;

    public LoadingMoreView(Context context) {
        this(context, null);
    }

    public void c() {
        this.gd = 0.0f;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.sr.reset();
        if (this.gd != 0.0f) {
            this.sr.moveTo(this.ux >> 1, this.f34133a);
            float f4 = (this.ux >> 1) - (this.f34137r * this.gd);
            this.sr.lineTo(f4 >= 0.0f ? f4 : 0.0f, this.f34134f >> 1);
            this.sr.lineTo(this.ux >> 1, this.f34134f - this.f34133a);
            canvas.drawPath(this.sr, this.xv);
        } else {
            this.sr.moveTo(this.ux * 0.5f, this.f34133a);
            this.sr.lineTo(this.ux * 0.5f, this.f34134f - this.f34133a);
            canvas.drawPath(this.sr, this.xv);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        this.ux = View.MeasureSpec.getSize(i4);
        this.f34134f = View.MeasureSpec.getSize(i5);
        this.f34137r = this.ux >> this.ev;
    }

    public void setMoveSpace(float f4) {
        float abs = (Math.abs(f4) * 2.0f) / this.f34136p;
        this.gd = abs;
        float f5 = this.f34135k;
        if (abs >= f5) {
            this.gd = f5;
        }
        invalidate();
    }

    public LoadingMoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingMoreView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f34138w = -1;
        this.ux = -1;
        this.f34134f = -1;
        this.f34137r = -1;
        this.ev = 1;
        this.gd = 0.0f;
        this.f34135k = 0.8f;
        this.f34133a = 0.0f;
        Paint paint = new Paint();
        this.xv = paint;
        paint.setColor(-3487030);
        this.xv.setStyle(Paint.Style.STROKE);
        this.xv.setAntiAlias(true);
        this.xv.setStrokeWidth(5.0f);
        this.xv.setStrokeCap(Paint.Cap.ROUND);
        this.sr = new Path();
        this.f34136p = context.getResources().getDisplayMetrics().widthPixels;
        this.f34133a = xk.ux(context, 2.0f);
    }
}
