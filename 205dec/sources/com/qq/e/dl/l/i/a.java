package com.qq.e.dl.l.i;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import java.util.Arrays;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class a implements d {

    /* renamed from: f  reason: collision with root package name */
    protected Paint f47093f;

    /* renamed from: g  reason: collision with root package name */
    protected Paint f47094g;

    /* renamed from: i  reason: collision with root package name */
    private Shader f47096i;

    /* renamed from: j  reason: collision with root package name */
    private int f47097j;

    /* renamed from: k  reason: collision with root package name */
    private int f47098k;

    /* renamed from: l  reason: collision with root package name */
    private int[] f47099l;

    /* renamed from: a  reason: collision with root package name */
    protected Object[] f47088a = null;

    /* renamed from: b  reason: collision with root package name */
    protected int f47089b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected int[] f47090c = null;

    /* renamed from: d  reason: collision with root package name */
    protected int f47091d = 0;

    /* renamed from: e  reason: collision with root package name */
    protected int f47092e = -16777216;

    /* renamed from: h  reason: collision with root package name */
    private boolean f47095h = false;

    public boolean a(Object[] objArr) {
        Object[] objArr2 = this.f47088a;
        int i4 = 0;
        if (objArr == objArr2) {
            this.f47095h = false;
            return false;
        }
        if (objArr2 != null && objArr != null) {
            while (true) {
                if (i4 >= 4) {
                    break;
                }
                Object[] objArr3 = this.f47088a;
                if (objArr3[i4] instanceof int[]) {
                    if (!Arrays.equals((int[]) objArr3[i4], (int[]) objArr[i4])) {
                        this.f47095h = true;
                        break;
                    }
                    i4++;
                } else if (objArr3[i4] instanceof float[]) {
                    if (!Arrays.equals((float[]) objArr3[i4], (float[]) objArr[i4])) {
                        this.f47095h = true;
                        break;
                    }
                    i4++;
                } else if (objArr3[i4] != objArr[i4]) {
                    this.f47095h = true;
                    break;
                } else {
                    i4++;
                }
            }
        } else {
            this.f47095h = true;
        }
        this.f47088a = objArr;
        return this.f47095h;
    }

    public boolean b(int[] iArr) {
        if (this.f47099l == iArr) {
            return false;
        }
        this.f47099l = iArr;
        return true;
    }

    public boolean c(int i4) {
        if (i4 == this.f47091d) {
            return false;
        }
        this.f47091d = i4;
        return true;
    }

    public boolean b(int i4) {
        if (i4 == this.f47092e) {
            return false;
        }
        this.f47092e = i4;
        return true;
    }

    @Override // com.qq.e.dl.l.i.d
    public void b(Canvas canvas, int i4, int i5) {
        if (i4 <= 0 || i5 <= 0 || this.f47091d <= 0) {
            return;
        }
        if (this.f47094g == null) {
            Paint paint = new Paint();
            this.f47094g = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.f47094g.setAntiAlias(true);
        }
        this.f47094g.setStrokeWidth(this.f47091d);
        this.f47094g.setColor(this.f47092e);
        com.qq.e.dl.j.a.b(canvas, this.f47094g, i4, i5, this.f47091d, this.f47090c);
    }

    public boolean a(int i4) {
        if (i4 == this.f47089b) {
            return false;
        }
        this.f47089b = i4;
        return this.f47088a == null;
    }

    public boolean a(int[] iArr) {
        int[] iArr2;
        if (iArr == null || iArr.length < 4 || iArr == (iArr2 = this.f47090c)) {
            return false;
        }
        if (iArr2 == null) {
            this.f47090c = iArr;
            return true;
        }
        boolean z3 = false;
        for (int i4 = 0; i4 < 4; i4++) {
            if (iArr[i4] >= 0) {
                int i5 = iArr[i4];
                int[] iArr3 = this.f47090c;
                if (i5 != iArr3[i4]) {
                    iArr3[i4] = iArr[i4];
                    z3 = true;
                }
            }
        }
        return z3;
    }

    @Override // com.qq.e.dl.l.i.d
    public void a(Canvas canvas, int i4, int i5) {
        if (i4 <= 0 || i5 <= 0) {
            return;
        }
        int[] iArr = this.f47090c;
        if (iArr != null && this.f47099l == null) {
            com.qq.e.dl.j.a.a(canvas, i4, i5, this.f47091d, iArr);
        }
        if (this.f47099l != null) {
            Paint paint = new Paint();
            int[] iArr2 = this.f47099l;
            paint.setShadowLayer(iArr2[2], iArr2[0], iArr2[1], iArr2[3]);
            RectF rectF = new RectF(0.0f, 0.0f, i4, i5);
            int[] iArr3 = this.f47090c;
            if (iArr3 != null) {
                canvas.drawRoundRect(rectF, iArr3[0], iArr3[1], paint);
            } else {
                canvas.drawRect(rectF, paint);
            }
        }
        if (this.f47088a == null && this.f47089b == 0) {
            return;
        }
        if (this.f47093f == null) {
            Paint paint2 = new Paint();
            this.f47093f = paint2;
            paint2.setAntiAlias(true);
        }
        if (this.f47088a != null) {
            if (this.f47096i == null || this.f47095h || this.f47097j != i4 || this.f47098k != i5) {
                this.f47096i = c.a(this.f47088a, i4, i5);
            }
            this.f47093f.setShader(this.f47096i);
            this.f47095h = false;
        } else {
            this.f47093f.setColor(this.f47089b);
        }
        this.f47097j = i4;
        this.f47098k = i5;
        com.qq.e.dl.j.a.a(canvas, this.f47093f, i4, i5, this.f47091d, this.f47090c);
    }

    public boolean a() {
        return (this.f47089b == 0 && this.f47091d == 0 && this.f47090c == null && this.f47088a == null && this.f47099l == null) ? false : true;
    }
}
