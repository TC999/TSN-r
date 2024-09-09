package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.util.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class FunGameHitBlockHeader extends FunGameView {
    private static final int F0 = 5;
    private static final int G0 = 3;
    private static final float H0 = 0.01806f;
    private static final float I0 = 0.8f;
    private static final float J0 = 0.08f;
    private static final int K0 = 30;
    static final float L0 = 1.0f;
    private static final int M0 = 3;
    private List<Point> A0;
    private boolean B0;
    private int C0;
    private int D0;
    private int E0;
    private float Q;
    private float R;
    private float S;
    private Paint T;
    private float U;
    private float V;
    private float W;

    /* renamed from: p0  reason: collision with root package name */
    private float f47534p0;

    public FunGameHitBlockHeader(Context context) {
        super(context);
        H(context, null);
    }

    private void H(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FunGameHitBlockHeader);
        this.D0 = obtainStyledAttributes.getInt(R.styleable.FunGameHitBlockHeader_fgvBlockHorizontalNum, 3);
        this.E0 = obtainStyledAttributes.getInt(R.styleable.FunGameHitBlockHeader_fgvBallSpeed, c.b(3.0f));
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.T = paint;
        paint.setStyle(Paint.Style.FILL);
        this.S = c.b(4.0f);
    }

    private boolean W(float f4, float f5) {
        int i4 = (int) ((((f4 - this.U) - this.S) - this.E0) / this.R);
        if (i4 == this.D0) {
            i4--;
        }
        int i5 = (int) (f5 / this.Q);
        if (i5 == 5) {
            i5--;
        }
        Point point = new Point();
        point.set(i4, i5);
        boolean z3 = false;
        Iterator<Point> it = this.A0.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().equals(point.x, point.y)) {
                z3 = true;
                break;
            }
        }
        if (!z3) {
            this.A0.add(point);
        }
        return !z3;
    }

    private boolean X(float f4) {
        float f5 = f4 - this.f47725y;
        return f5 >= 0.0f && f5 <= ((float) this.f47726z);
    }

    private void Y(Canvas canvas) {
        boolean z3;
        int i4 = 0;
        while (true) {
            int i5 = this.D0;
            if (i4 >= i5 * 5) {
                return;
            }
            int i6 = i4 / i5;
            int i7 = i4 % i5;
            Iterator<Point> it = this.A0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z3 = false;
                    break;
                } else if (it.next().equals(i7, i6)) {
                    z3 = true;
                    break;
                }
            }
            if (!z3) {
                this.T.setColor(com.scwang.smartrefresh.layout.util.a.A(this.B, 255 / (i7 + 1)));
                float f4 = this.U;
                float f5 = this.R;
                float f6 = f4 + (i7 * (f5 + 1.0f));
                float f7 = i6;
                float f8 = this.Q;
                float f9 = (f7 * (f8 + 1.0f)) + 1.0f;
                canvas.drawRect(f6, f9, f6 + f5, f9 + f8, this.T);
            }
            i4++;
        }
    }

    private void Z(Canvas canvas) {
        this.f47723w.setColor(this.C);
        float f4 = this.V;
        float f5 = this.f47725y;
        canvas.drawRect(f4, f5, f4 + this.R, f5 + this.f47726z, this.f47723w);
    }

    private void a0(Canvas canvas, int i4) {
        int i5;
        this.f47723w.setColor(this.D);
        float f4 = this.W;
        if (f4 <= this.U + (this.D0 * this.R) + ((i5 - 1) * 1.0f) + this.S && W(f4, this.f47534p0)) {
            this.B0 = false;
        }
        float f5 = this.W;
        float f6 = this.U;
        float f7 = this.S;
        if (f5 <= f6 + f7) {
            this.B0 = false;
        }
        float f8 = this.V;
        if (f5 + f7 < f8 || f5 - f7 >= f8 + this.R) {
            if (f5 > i4) {
                this.A = 2;
            }
        } else if (X(this.f47534p0)) {
            if (this.A0.size() == this.D0 * 5) {
                this.A = 2;
                return;
            }
            this.B0 = true;
        }
        float f9 = this.f47534p0;
        float f10 = this.S;
        if (f9 <= f10 + 1.0f) {
            this.C0 = 150;
        } else if (f9 >= (this.f47700b - f10) - 1.0f) {
            this.C0 = 210;
        }
        if (this.B0) {
            this.W -= this.E0;
        } else {
            this.W += this.E0;
        }
        float tan = f9 - (((float) Math.tan(Math.toRadians(this.C0))) * this.E0);
        this.f47534p0 = tan;
        canvas.drawCircle(this.W, tan, this.S, this.f47723w);
        invalidate();
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    protected void M(Canvas canvas, int i4, int i5) {
        Y(canvas);
        Z(canvas);
        int i6 = this.A;
        if (i6 == 1 || i6 == 3 || i6 == 4 || isInEditMode()) {
            a0(canvas, i4);
        }
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    protected void R() {
        int measuredWidth = getMeasuredWidth();
        this.f47726z = (int) (this.Q * 1.6f);
        float f4 = (this.f47700b / 5) - 1.0f;
        this.Q = f4;
        float f5 = measuredWidth;
        this.R = 0.01806f * f5;
        this.U = 0.08f * f5;
        this.V = f5 * 0.8f;
        this.f47726z = (int) (f4 * 1.6f);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    protected void V() {
        this.W = this.V - (this.S * 3.0f);
        this.f47534p0 = (int) (this.f47700b * 0.5f);
        this.f47725y = 1.0f;
        this.C0 = 30;
        this.B0 = true;
        List<Point> list = this.A0;
        if (list == null) {
            this.A0 = new ArrayList();
        } else {
            list.clear();
        }
    }

    public FunGameHitBlockHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        H(context, attributeSet);
    }

    public FunGameHitBlockHeader(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        H(context, attributeSet);
    }

    @RequiresApi(21)
    public FunGameHitBlockHeader(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        H(context, attributeSet);
    }
}
