package com.scwang.smartrefresh.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.util.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class FunGameBattleCityHeader extends FunGameView {
    private static int I0 = 3;
    private static final float J0 = 0.33333334f;
    private static final int K0 = 360;
    private static final int L0 = 60;
    private static final int M0 = 8;
    private int A0;
    private int B0;
    private int C0;
    private int D0;
    private int E0;
    private int F0;
    private int G0;
    private boolean H0;
    private SparseArray<Queue<RectF>> Q;
    private Queue<Point> R;
    private Point S;
    private Random T;
    private float U;
    private int V;
    private int W;

    /* renamed from: p0  reason: collision with root package name */
    private int f47533p0;

    public FunGameBattleCityHeader(Context context) {
        super(context);
        this.A0 = 1;
        this.B0 = 4;
        this.H0 = true;
    }

    private int W() {
        return this.T.nextInt(I0);
    }

    private boolean X(int i4, float f4, float f5) {
        RectF peek = this.Q.get(i4).peek();
        return peek != null && peek.contains(f4, f5);
    }

    private boolean Y(Point point) {
        int e02 = e0(point.y);
        RectF peek = this.Q.get(e02).peek();
        if (peek == null || !peek.contains(point.x, point.y)) {
            return false;
        }
        int i4 = this.G0 + 1;
        this.G0 = i4;
        if (i4 == this.F0) {
            g0();
        }
        this.Q.get(e02).poll();
        return true;
    }

    private void Z(Canvas canvas, Point point) {
        int i4 = point.x - this.B0;
        point.x = i4;
        canvas.drawCircle(i4, point.y, this.U, this.f47723w);
    }

    private void a0(Canvas canvas, int i4) {
        this.f47723w.setColor(this.B);
        int i5 = this.C0 + this.A0;
        this.C0 = i5;
        if (i5 / this.V == 1 || this.H0) {
            this.C0 = 0;
            this.H0 = false;
        }
        int W = W();
        boolean z3 = false;
        for (int i6 = 0; i6 < I0; i6++) {
            Queue<RectF> queue = this.Q.get(i6);
            if (this.C0 == 0 && i6 == W) {
                queue.offer(d0(i6));
            }
            Iterator<RectF> it = queue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RectF next = it.next();
                if (next.left >= i4) {
                    int i7 = this.E0 + 1;
                    this.E0 = i7;
                    if (i7 >= 8) {
                        this.A = 2;
                        z3 = true;
                        break;
                    }
                    z3 = true;
                } else {
                    c0(canvas, next);
                }
            }
            if (this.A == 2) {
                break;
            }
            if (z3) {
                queue.poll();
                z3 = false;
            }
        }
        invalidate();
    }

    private void b0(Canvas canvas, int i4) {
        this.f47723w.setColor(this.C);
        boolean X = X(e0((int) this.f47725y), i4 - this.f47726z, this.f47725y);
        int e02 = e0((int) (this.f47725y + this.f47726z));
        int i5 = this.f47726z;
        boolean X2 = X(e02, i4 - i5, this.f47725y + i5);
        if (X || X2) {
            this.A = 2;
        }
        int i6 = this.f47726z;
        float f4 = this.f47725y;
        float f5 = this.f47710l;
        canvas.drawRect(i4 - i6, f4 + f5, i4, f4 + i6 + f5, this.f47723w);
        int i7 = this.f47726z;
        int i8 = this.f47533p0;
        float f6 = this.f47725y;
        canvas.drawRect((i4 - i7) - i8, f6 + ((i7 - i8) * 0.5f), i4 - i7, f6 + ((i7 - i8) * 0.5f) + i8, this.f47723w);
    }

    private void c0(Canvas canvas, RectF rectF) {
        float f4 = rectF.left;
        int i4 = this.A0;
        rectF.set(f4 + i4, rectF.top, rectF.right + i4, rectF.bottom);
        canvas.drawRect(rectF, this.f47723w);
        float f5 = rectF.top;
        int i5 = this.f47726z;
        int i6 = this.f47533p0;
        float f6 = f5 + ((i5 - i6) * 0.5f);
        float f7 = rectF.right;
        canvas.drawRect(f7, f6, f7 + i6, f6 + i6, this.f47723w);
    }

    private RectF d0(int i4) {
        int i5;
        float f4 = -(this.f47533p0 + this.f47726z);
        float f5 = (i4 * i5) + this.f47710l;
        return new RectF(f4, f5, (this.f47533p0 * 2.5f) + f4, this.f47726z + f5);
    }

    private int e0(int i4) {
        int i5 = this.f47700b;
        int i6 = I0;
        int i7 = i4 / (i5 / i6);
        if (i7 >= i6) {
            i7 = i6 - 1;
        }
        if (i7 < 0) {
            return 0;
        }
        return i7;
    }

    private void f0(Canvas canvas, int i4) {
        this.f47723w.setColor(this.D);
        int i5 = this.D0 + this.B0;
        this.D0 = i5;
        boolean z3 = false;
        if (i5 / this.W == 1) {
            this.D0 = 0;
        }
        if (this.D0 == 0) {
            Point point = new Point();
            int i6 = this.f47726z;
            point.x = (i4 - i6) - this.f47533p0;
            point.y = (int) (this.f47725y + (i6 * 0.5f));
            this.R.offer(point);
        }
        for (Point point2 : this.R) {
            if (Y(point2)) {
                this.S = point2;
            } else {
                if (point2.x + this.U <= 0.0f) {
                    z3 = true;
                }
                Z(canvas, point2);
            }
        }
        if (z3) {
            this.R.poll();
        }
        this.R.remove(this.S);
        this.S = null;
    }

    private void g0() {
        this.F0 += 8;
        this.A0 += c.b(1.0f);
        this.B0 += c.b(1.0f);
        this.G0 = 0;
        int i4 = this.V;
        if (i4 > 12) {
            this.V = i4 - 12;
        }
        int i5 = this.W;
        if (i5 > 30) {
            this.W = i5 - 30;
        }
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    protected void M(Canvas canvas, int i4, int i5) {
        b0(canvas, i4);
        int i6 = this.A;
        if (i6 == 1 || i6 == 3 || i6 == 4) {
            a0(canvas, i4);
            f0(canvas, i4);
        }
        if (isInEditMode()) {
            int i7 = this.f47726z;
            c0(canvas, new RectF(i7, 0.0f, i7 * 2, i7));
            int i8 = this.f47726z;
            c0(canvas, new RectF(0.0f, i8, i8, i8 * 2));
            int i9 = this.f47726z;
            c0(canvas, new RectF(i9 * 3, i9 * 2, i9 * 4, i9 * 3));
        }
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    protected void R() {
        this.T = new Random();
        int i4 = this.f47700b / I0;
        this.f47726z = i4;
        int floor = (int) Math.floor((i4 * 0.33333334f) + 0.5f);
        this.f47533p0 = floor;
        this.U = (floor - (this.f47710l * 2.0f)) * 0.5f;
        V();
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    protected void V() {
        this.A = 0;
        this.f47725y = this.f47710l;
        this.A0 = c.b(1.0f);
        this.B0 = c.b(4.0f);
        this.F0 = 8;
        this.G0 = 0;
        this.H0 = true;
        this.V = this.f47726z + this.f47533p0 + 60;
        this.W = 360;
        this.Q = new SparseArray<>();
        for (int i4 = 0; i4 < I0; i4++) {
            this.Q.put(i4, new LinkedList());
        }
        this.R = new LinkedList();
    }

    public FunGameBattleCityHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A0 = 1;
        this.B0 = 4;
        this.H0 = true;
    }

    public FunGameBattleCityHeader(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.A0 = 1;
        this.B0 = 4;
        this.H0 = true;
    }

    @RequiresApi(21)
    public FunGameBattleCityHeader(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.A0 = 1;
        this.B0 = 4;
        this.H0 = true;
    }
}
