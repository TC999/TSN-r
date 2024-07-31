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
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.scwang.smartrefresh.header.C11852R;
import com.scwang.smartrefresh.layout.util.C11925c;
import com.scwang.smartrefresh.layout.util.ColorUtils;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class FunGameView extends FunGameHeader {

    /* renamed from: G */
    protected static final int f33314G = 0;

    /* renamed from: H */
    protected static final int f33315H = 1;

    /* renamed from: I */
    protected static final int f33316I = 2;

    /* renamed from: J */
    protected static final int f33317J = 3;

    /* renamed from: K */
    protected static final int f33318K = 4;

    /* renamed from: L */
    protected static final float f33319L = 0.161f;

    /* renamed from: M */
    public static String f33320M = "游戏结束";

    /* renamed from: N */
    public static String f33321N = "玩个游戏解解闷";

    /* renamed from: O */
    public static String f33322O = "刷新完成";

    /* renamed from: P */
    public static String f33323P = "刷新失败";

    /* renamed from: A */
    protected int f33324A;

    /* renamed from: B */
    protected int f33325B;

    /* renamed from: C */
    protected int f33326C;

    /* renamed from: D */
    protected int f33327D;

    /* renamed from: E */
    protected int f33328E;

    /* renamed from: F */
    protected int f33329F;

    /* renamed from: w */
    protected Paint f33330w;

    /* renamed from: x */
    protected TextPaint f33331x;

    /* renamed from: y */
    protected float f33332y;

    /* renamed from: z */
    protected int f33333z;

    public FunGameView(Context context) {
        super(context);
        this.f33324A = 0;
        this.f33329F = -10461088;
        m20098H(context, null);
    }

    /* renamed from: H */
    private void m20098H(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11852R.styleable.FunGameView);
        this.f33328E = obtainStyledAttributes.getColor(C11852R.styleable.FunGameView_fgvBackColor, 0);
        this.f33325B = obtainStyledAttributes.getColor(C11852R.styleable.FunGameView_fgvLeftColor, Color.rgb(0, 0, 0));
        this.f33327D = obtainStyledAttributes.getColor(C11852R.styleable.FunGameView_fgvMiddleColor, ViewCompat.MEASURED_STATE_MASK);
        this.f33326C = obtainStyledAttributes.getColor(C11852R.styleable.FunGameView_fgvRightColor, Color.parseColor("#A5A5A5"));
        int i = C11852R.styleable.FunGameView_fgvTextGameOver;
        if (obtainStyledAttributes.hasValue(i)) {
            f33320M = obtainStyledAttributes.getString(i);
        }
        if (obtainStyledAttributes.hasValue(i)) {
            f33321N = obtainStyledAttributes.getString(C11852R.styleable.FunGameView_fgvTextLoading);
        }
        if (obtainStyledAttributes.hasValue(i)) {
            f33322O = obtainStyledAttributes.getString(C11852R.styleable.FunGameView_fgvTextLoadingFinished);
        }
        obtainStyledAttributes.recycle();
        m20091Q();
        m20092P();
        mo20090R();
    }

    /* renamed from: L */
    private void m20096L(Canvas canvas, int i, int i2) {
        this.f33330w.setColor(this.f33328E);
        float f = i;
        float f2 = i2;
        canvas.drawRect(0.0f, 0.0f, f, f2, this.f33330w);
        this.f33330w.setColor(this.f33329F);
        canvas.drawLine(0.0f, 0.0f, f, 0.0f, this.f33330w);
        float f3 = this.f33302l;
        canvas.drawLine(0.0f, f2 - f3, f, f2 - f3, this.f33330w);
    }

    /* renamed from: N */
    private void m20094N(Canvas canvas, int i, int i2) {
        int i3 = this.f33324A;
        if (i3 == 0 || i3 == 1) {
            this.f33331x.setTextSize(C11925c.m19766b(25.0f));
            m20087U(canvas, f33321N, i, i2);
        } else if (i3 == 2) {
            this.f33331x.setTextSize(C11925c.m19766b(25.0f));
            m20087U(canvas, f33320M, i, i2);
        } else if (i3 == 3) {
            this.f33331x.setTextSize(C11925c.m19766b(20.0f));
            m20087U(canvas, f33322O, i, i2);
        } else if (i3 != 4) {
        } else {
            this.f33331x.setTextSize(C11925c.m19766b(20.0f));
            m20087U(canvas, f33323P, i, i2);
        }
    }

    /* renamed from: O */
    private DisplayMetrics m20093O(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: U */
    private void m20087U(Canvas canvas, String str, int i, int i2) {
        canvas.drawText(str, (i - this.f33331x.measureText(str)) * 0.5f, (i2 * 0.5f) - ((this.f33331x.ascent() + this.f33331x.descent()) * 0.5f), this.f33331x);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameHeader
    /* renamed from: I */
    protected void mo20097I() {
        m20088T(1);
    }

    /* renamed from: M */
    protected abstract void mo20095M(Canvas canvas, int i, int i2);

    /* renamed from: P */
    protected void m20092P() {
        this.f33332y = this.f33302l;
    }

    /* renamed from: Q */
    protected void m20091Q() {
        TextPaint textPaint = new TextPaint(1);
        this.f33331x = textPaint;
        textPaint.setColor(Color.parseColor("#C1C2C2"));
        Paint paint = new Paint(1);
        this.f33330w = paint;
        paint.setStrokeWidth(this.f33302l);
    }

    /* renamed from: R */
    protected abstract void mo20090R();

    /* renamed from: S */
    public void m20089S(float f) {
        float f2 = (this.f33292b - (this.f33302l * 2.0f)) - this.f33333z;
        if (f > f2) {
            f = f2;
        }
        this.f33332y = f;
        postInvalidate();
    }

    /* renamed from: T */
    public void m20088T(int i) {
        this.f33324A = i;
        if (i == 0) {
            mo20086V();
        }
        postInvalidate();
    }

    /* renamed from: V */
    protected abstract void mo20086V();

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int i = this.f33292b;
        m20096L(canvas, width, i);
        m20094N(canvas, width, i);
        mo20095M(canvas, width, i);
        super.dispatchDraw(canvas);
    }

    public int getCurrStatus() {
        return this.f33324A;
    }

    public String getTextGameOver() {
        return f33320M;
    }

    public String getTextLoading() {
        return f33321N;
    }

    public String getTextLoadingFinished() {
        return f33322O;
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameHeader, com.scwang.smartrefresh.header.fungame.FunGameBase, p638r0.RefreshInternal
    /* renamed from: o */
    public void mo2098o(RefreshKernel refreshKernel, int i, int i2) {
        super.mo2098o(refreshKernel, i, i2);
        mo20090R();
        m20088T(0);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameBase
    /* renamed from: s */
    protected void mo20085s(float f, int i, int i2, int i3) {
        m20089S(Math.max(i, 0));
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameHeader, com.scwang.smartrefresh.header.fungame.FunGameBase, p638r0.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        super.setPrimaryColors(iArr);
        if (iArr.length > 0) {
            int i = iArr[0];
            this.f33328E = i;
            this.f33329F = i;
            if (i == 0 || i == -1) {
                this.f33329F = -10461088;
            }
            if (iArr.length > 1) {
                this.f33327D = iArr[1];
                this.f33325B = ColorUtils.m19794A(iArr[1], 225);
                this.f33326C = ColorUtils.m19794A(iArr[1], 200);
                this.f33331x.setColor(ColorUtils.m19794A(iArr[1], TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME));
            }
        }
    }

    public void setTextGameOver(String str) {
        f33320M = str;
    }

    public void setTextLoading(String str) {
        f33321N = str;
    }

    public void setTextLoadingFinished(String str) {
        f33322O = str;
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameHeader, com.scwang.smartrefresh.header.fungame.FunGameBase, p638r0.RefreshInternal
    /* renamed from: v */
    public int mo2095v(RefreshLayout refreshLayout, boolean z) {
        if (this.f33297g) {
            m20088T(z ? 3 : 4);
        } else {
            m20088T(0);
        }
        return super.mo2095v(refreshLayout, z);
    }

    public FunGameView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33324A = 0;
        this.f33329F = -10461088;
        m20098H(context, attributeSet);
    }

    public FunGameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33324A = 0;
        this.f33329F = -10461088;
        m20098H(context, attributeSet);
    }

    @RequiresApi(21)
    public FunGameView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f33324A = 0;
        this.f33329F = -10461088;
        m20098H(context, attributeSet);
    }
}
