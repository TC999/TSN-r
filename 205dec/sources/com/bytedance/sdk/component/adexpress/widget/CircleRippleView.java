package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class CircleRippleView extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f29495a;
    private float bk;

    /* renamed from: c  reason: collision with root package name */
    private int f29496c;
    private List<Integer> ev;

    /* renamed from: f  reason: collision with root package name */
    private int f29497f;
    private List<Integer> gd;

    /* renamed from: k  reason: collision with root package name */
    private Paint f29498k;

    /* renamed from: p  reason: collision with root package name */
    private Paint f29499p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f29500r;
    private int sr;

    /* renamed from: t  reason: collision with root package name */
    private int f29501t;
    private float ux;

    /* renamed from: w  reason: collision with root package name */
    private int f29502w;
    private float xv;

    public CircleRippleView(Context context) {
        this(context, null);
    }

    private void xv() {
        Paint paint = new Paint();
        this.f29499p = paint;
        paint.setAntiAlias(true);
        this.f29499p.setStrokeWidth(this.f29501t);
        this.ev.add(255);
        this.gd.add(0);
        Paint paint2 = new Paint();
        this.f29498k = paint2;
        paint2.setAntiAlias(true);
        this.f29498k.setColor(Color.parseColor("#0FFFFFFF"));
        this.f29498k.setStyle(Paint.Style.FILL);
    }

    public void c() {
        this.f29500r = true;
        invalidate();
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f29499p.setShader(new LinearGradient(this.f29495a, 0.0f, this.bk, getMeasuredHeight(), -1, 16777215, Shader.TileMode.CLAMP));
        int i4 = 0;
        while (true) {
            if (i4 >= this.ev.size()) {
                break;
            }
            Integer num = this.ev.get(i4);
            this.f29499p.setAlpha(num.intValue());
            Integer num2 = this.gd.get(i4);
            if (this.xv + num2.intValue() < this.ux) {
                canvas.drawCircle(this.f29495a, this.bk, this.xv + num2.intValue(), this.f29499p);
            }
            if (num.intValue() > 0 && num2.intValue() < this.ux) {
                this.ev.set(i4, Integer.valueOf(num.intValue() - this.f29497f > 0 ? num.intValue() - (this.f29497f * 3) : 1));
                this.gd.set(i4, Integer.valueOf(num2.intValue() + this.f29497f));
            }
            i4++;
        }
        List<Integer> list = this.gd;
        if (list.get(list.size() - 1).intValue() >= this.ux / this.sr) {
            this.ev.add(255);
            this.gd.add(0);
        }
        if (this.gd.size() >= 3) {
            this.gd.remove(0);
            this.ev.remove(0);
        }
        this.f29499p.setAlpha(255);
        this.f29499p.setColor(this.f29502w);
        canvas.drawCircle(this.f29495a, this.bk, this.xv, this.f29498k);
        if (this.f29500r) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int size = View.MeasureSpec.getSize(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        float f4 = i4 / 2.0f;
        this.f29495a = f4;
        this.bk = i5 / 2.0f;
        float f5 = f4 - (this.f29501t / 2.0f);
        this.ux = f5;
        this.xv = f5 / 4.0f;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        if (z3) {
            invalidate();
        }
    }

    public void setColor(int i4) {
        this.f29496c = i4;
    }

    public void setCoreColor(int i4) {
        this.f29502w = i4;
    }

    public void setCoreRadius(int i4) {
        this.xv = i4;
    }

    public void setDiffuseSpeed(int i4) {
        this.f29497f = i4;
    }

    public void setDiffuseWidth(int i4) {
        this.sr = i4;
    }

    public void setMaxWidth(int i4) {
        this.ux = i4;
    }

    public void w() {
        this.f29500r = false;
        this.gd.clear();
        this.ev.clear();
        this.ev.add(255);
        this.gd.add(0);
        invalidate();
    }

    public CircleRippleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CircleRippleView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f29496c = -1;
        this.f29502w = -65536;
        this.xv = 18.0f;
        this.sr = 3;
        this.ux = 50.0f;
        this.f29497f = 2;
        this.f29500r = false;
        this.ev = new ArrayList();
        this.gd = new ArrayList();
        this.f29501t = 24;
        xv();
    }
}
