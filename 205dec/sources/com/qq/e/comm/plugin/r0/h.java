package com.qq.e.comm.plugin.r0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import java.util.Arrays;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h extends View {

    /* renamed from: c  reason: collision with root package name */
    private final Paint f45721c;

    /* renamed from: d  reason: collision with root package name */
    private int f45722d;

    /* renamed from: e  reason: collision with root package name */
    private int f45723e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f45724f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f45725g;

    /* renamed from: h  reason: collision with root package name */
    private float[] f45726h;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f45727i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f45728j;

    /* renamed from: k  reason: collision with root package name */
    private Object[] f45729k;

    /* renamed from: l  reason: collision with root package name */
    private Shader f45730l;

    public h(Context context) {
        super(context);
        this.f45721c = new Paint(1);
        this.f45723e = 100;
        this.f45724f = new Paint(1);
        this.f45725g = new Path();
        this.f45727i = new RectF();
        this.f45728j = false;
        setLayerType(1, null);
        this.f45724f.setColor(Color.parseColor("#d8d8d8"));
        this.f45721c.setColor(Color.parseColor("#3185FC"));
    }

    private void a(Canvas canvas, float f4, float f5, Paint paint) {
        this.f45727i.set(0.0f, 0.0f, f4, f5);
        canvas.drawRect(this.f45727i, paint);
    }

    public void b(int i4) {
        this.f45721c.setColor(i4);
        postInvalidate();
    }

    public void c(int i4) {
        this.f45723e = i4;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float f4 = width;
        float f5 = height;
        this.f45727i.set(0.0f, 0.0f, f4, f5);
        float[] fArr = this.f45726h;
        if (fArr != null) {
            this.f45725g.addRoundRect(this.f45727i, fArr, Path.Direction.CW);
            canvas.clipPath(this.f45725g);
        }
        super.onDraw(canvas);
        int i4 = this.f45722d;
        if (i4 >= 0) {
            float f6 = (i4 / this.f45723e) * f4;
            Object[] objArr = this.f45729k;
            if (objArr != null && this.f45730l == null) {
                Shader a4 = com.qq.e.dl.l.i.c.a(objArr, width, height);
                this.f45730l = a4;
                this.f45721c.setShader(a4);
            }
            a(canvas, f4, f5, this.f45724f);
            a(canvas, f6, f5);
        }
        this.f45725g.reset();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        this.f45724f.setColor(i4);
    }

    private void a(Canvas canvas, float f4, float f5) {
        int i4;
        if (this.f45728j && (i4 = this.f45722d) > 0 && i4 < 100) {
            float f6 = f5 / 2.0f;
            com.qq.e.dl.j.a.a(canvas, this.f45721c, f4, f5, 0.0f, 0.0f, f6, 0.0f, f6);
            return;
        }
        a(canvas, f4, f5, this.f45721c);
    }

    public void a(int i4) {
        if (i4 == this.f45722d) {
            return;
        }
        if (i4 <= 0) {
            this.f45722d = 0;
        } else if (i4 >= 100) {
            this.f45722d = 100;
        } else {
            this.f45722d = i4;
        }
        postInvalidate();
    }

    public void a(float f4) {
        if (this.f45726h == null) {
            this.f45726h = new float[8];
        }
        Arrays.fill(this.f45726h, f4);
    }

    public void a(Object[] objArr) {
        this.f45729k = objArr;
    }

    public void a(boolean z3) {
        this.f45728j = z3;
    }
}
