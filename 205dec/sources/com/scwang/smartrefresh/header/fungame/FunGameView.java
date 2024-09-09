package com.scwang.smartrefresh.header.fungame;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.header.R;
import com.scwang.smartrefresh.layout.util.a;
import com.scwang.smartrefresh.layout.util.c;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class FunGameView extends FunGameHeader {
    protected static final int G = 0;
    protected static final int H = 1;
    protected static final int I = 2;
    protected static final int J = 3;
    protected static final int K = 4;

    /* renamed from: L  reason: collision with root package name */
    protected static final float f47722L = 0.161f;
    public static String M = "\u6e38\u620f\u7ed3\u675f";
    public static String N = "\u73a9\u4e2a\u6e38\u620f\u89e3\u89e3\u95f7";
    public static String O = "\u5237\u65b0\u5b8c\u6210";
    public static String P = "\u5237\u65b0\u5931\u8d25";
    protected int A;
    protected int B;
    protected int C;
    protected int D;
    protected int E;
    protected int F;

    /* renamed from: w  reason: collision with root package name */
    protected Paint f47723w;

    /* renamed from: x  reason: collision with root package name */
    protected TextPaint f47724x;

    /* renamed from: y  reason: collision with root package name */
    protected float f47725y;

    /* renamed from: z  reason: collision with root package name */
    protected int f47726z;

    public FunGameView(Context context) {
        super(context);
        this.A = 0;
        this.F = -10461088;
        H(context, null);
    }

    private void H(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FunGameView);
        this.E = obtainStyledAttributes.getColor(R.styleable.FunGameView_fgvBackColor, 0);
        this.B = obtainStyledAttributes.getColor(R.styleable.FunGameView_fgvLeftColor, Color.rgb(0, 0, 0));
        this.D = obtainStyledAttributes.getColor(R.styleable.FunGameView_fgvMiddleColor, -16777216);
        this.C = obtainStyledAttributes.getColor(R.styleable.FunGameView_fgvRightColor, Color.parseColor("#A5A5A5"));
        int i4 = R.styleable.FunGameView_fgvTextGameOver;
        if (obtainStyledAttributes.hasValue(i4)) {
            M = obtainStyledAttributes.getString(i4);
        }
        if (obtainStyledAttributes.hasValue(i4)) {
            N = obtainStyledAttributes.getString(R.styleable.FunGameView_fgvTextLoading);
        }
        if (obtainStyledAttributes.hasValue(i4)) {
            O = obtainStyledAttributes.getString(R.styleable.FunGameView_fgvTextLoadingFinished);
        }
        obtainStyledAttributes.recycle();
        Q();
        P();
        R();
    }

    private void L(Canvas canvas, int i4, int i5) {
        this.f47723w.setColor(this.E);
        float f4 = i4;
        float f5 = i5;
        canvas.drawRect(0.0f, 0.0f, f4, f5, this.f47723w);
        this.f47723w.setColor(this.F);
        canvas.drawLine(0.0f, 0.0f, f4, 0.0f, this.f47723w);
        float f6 = this.f47710l;
        canvas.drawLine(0.0f, f5 - f6, f4, f5 - f6, this.f47723w);
    }

    private void N(Canvas canvas, int i4, int i5) {
        int i6 = this.A;
        if (i6 == 0 || i6 == 1) {
            this.f47724x.setTextSize(c.b(25.0f));
            U(canvas, N, i4, i5);
        } else if (i6 == 2) {
            this.f47724x.setTextSize(c.b(25.0f));
            U(canvas, M, i4, i5);
        } else if (i6 == 3) {
            this.f47724x.setTextSize(c.b(20.0f));
            U(canvas, O, i4, i5);
        } else if (i6 != 4) {
        } else {
            this.f47724x.setTextSize(c.b(20.0f));
            U(canvas, P, i4, i5);
        }
    }

    private DisplayMetrics O(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    private void U(Canvas canvas, String str, int i4, int i5) {
        canvas.drawText(str, (i4 - this.f47724x.measureText(str)) * 0.5f, (i5 * 0.5f) - ((this.f47724x.ascent() + this.f47724x.descent()) * 0.5f), this.f47724x);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameHeader
    protected void I() {
        T(1);
    }

    protected abstract void M(Canvas canvas, int i4, int i5);

    protected void P() {
        this.f47725y = this.f47710l;
    }

    protected void Q() {
        TextPaint textPaint = new TextPaint(1);
        this.f47724x = textPaint;
        textPaint.setColor(Color.parseColor("#C1C2C2"));
        Paint paint = new Paint(1);
        this.f47723w = paint;
        paint.setStrokeWidth(this.f47710l);
    }

    protected abstract void R();

    public void S(float f4) {
        float f5 = (this.f47700b - (this.f47710l * 2.0f)) - this.f47726z;
        if (f4 > f5) {
            f4 = f5;
        }
        this.f47725y = f4;
        postInvalidate();
    }

    public void T(int i4) {
        this.A = i4;
        if (i4 == 0) {
            V();
        }
        postInvalidate();
    }

    protected abstract void V();

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int i4 = this.f47700b;
        L(canvas, width, i4);
        N(canvas, width, i4);
        M(canvas, width, i4);
        super.dispatchDraw(canvas);
    }

    public int getCurrStatus() {
        return this.A;
    }

    public String getTextGameOver() {
        return M;
    }

    public String getTextLoading() {
        return N;
    }

    public String getTextLoadingFinished() {
        return O;
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameHeader, com.scwang.smartrefresh.header.fungame.FunGameBase, r0.f
    public void o(g gVar, int i4, int i5) {
        super.o(gVar, i4, i5);
        R();
        T(0);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase
    protected void s(float f4, int i4, int i5, int i6) {
        S(Math.max(i4, 0));
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameHeader, com.scwang.smartrefresh.header.fungame.FunGameBase, r0.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        super.setPrimaryColors(iArr);
        if (iArr.length > 0) {
            int i4 = iArr[0];
            this.E = i4;
            this.F = i4;
            if (i4 == 0 || i4 == -1) {
                this.F = -10461088;
            }
            if (iArr.length > 1) {
                this.D = iArr[1];
                this.B = a.A(iArr[1], 225);
                this.C = a.A(iArr[1], 200);
                this.f47724x.setColor(a.A(iArr[1], 150));
            }
        }
    }

    public void setTextGameOver(String str) {
        M = str;
    }

    public void setTextLoading(String str) {
        N = str;
    }

    public void setTextLoadingFinished(String str) {
        O = str;
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameHeader, com.scwang.smartrefresh.header.fungame.FunGameBase, r0.f
    public int v(h hVar, boolean z3) {
        if (this.f47705g) {
            T(z3 ? 3 : 4);
        } else {
            T(0);
        }
        return super.v(hVar, z3);
    }

    public FunGameView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A = 0;
        this.F = -10461088;
        H(context, attributeSet);
    }

    public FunGameView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.A = 0;
        this.F = -10461088;
        H(context, attributeSet);
    }

    @RequiresApi(21)
    public FunGameView(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.A = 0;
        this.F = -10461088;
        H(context, attributeSet);
    }
}
