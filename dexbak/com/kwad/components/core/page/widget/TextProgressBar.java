package com.kwad.components.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class TextProgressBar extends ProgressBar {

    /* renamed from: QA */
    private boolean f28701QA;

    /* renamed from: QB */
    private boolean f28702QB;

    /* renamed from: QC */
    private boolean f28703QC;

    /* renamed from: QD */
    private int f28704QD;

    /* renamed from: QE */
    private int f28705QE;

    /* renamed from: QF */
    private Drawable f28706QF;

    /* renamed from: QG */
    private int f28707QG;

    /* renamed from: QH */
    private Rect f28708QH;

    /* renamed from: QI */
    private int[] f28709QI;

    /* renamed from: QJ */
    private int f28710QJ;

    /* renamed from: QK */
    private int f28711QK;

    /* renamed from: QL */
    private boolean f28712QL;
    @Nullable

    /* renamed from: Qx */
    private String f28713Qx;

    /* renamed from: Qy */
    private LinearGradient f28714Qy;

    /* renamed from: Qz */
    private Matrix f28715Qz;
    private Paint mPaint;
    private RectF mRectF;

    public TextProgressBar(Context context) {
        this(context, null);
    }

    /* renamed from: qc */
    private void m29708qc() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setTextSize(C10751a.m24924a(getContext(), 12.0f));
        this.f28707QG = C10751a.m24924a(getContext(), 2.0f);
        this.mRectF = new RectF();
        this.f28710QJ = -1;
        this.f28711QK = -117146;
    }

    private void setProgressText(int i) {
        this.f28713Qx = String.valueOf((int) (((i * 1.0f) / getMax()) * 100.0f)) + "%";
    }

    /* renamed from: e */
    public final void m29709e(String str, int i) {
        this.f28713Qx = str;
        this.f28701QA = true;
        setProgress(i);
        invalidate();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        int width;
        if (this.f28702QB) {
            canvas.save();
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
            super.onDraw(canvas);
            canvas.restore();
        } else {
            super.onDraw(canvas);
        }
        if (!TextUtils.isEmpty(this.f28713Qx)) {
            Paint paint = this.mPaint;
            String str = this.f28713Qx;
            paint.getTextBounds(str, 0, str.length(), this.f28708QH);
        }
        int height = (getHeight() / 2) - this.f28708QH.centerY();
        Drawable drawable = this.f28706QF;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.f28706QF.getIntrinsicHeight();
            int width2 = (((getWidth() - this.f28708QH.width()) - intrinsicWidth) - this.f28707QG) / 2;
            int i = intrinsicWidth + width2;
            this.f28706QF.setBounds(width2, (getHeight() - intrinsicHeight) / 2, i, (getHeight() + intrinsicHeight) / 2);
            this.f28706QF.draw(canvas);
            width = i + this.f28707QG;
        } else {
            width = (getWidth() / 2) - this.f28708QH.centerX();
        }
        if (this.f28709QI != null) {
            float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
            float f = width;
            if (progress >= f) {
                if (this.f28714Qy == null) {
                    this.f28714Qy = new LinearGradient(f, 0.0f, width + this.f28708QH.width(), 0.0f, this.f28709QI, (float[]) null, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    this.f28715Qz = matrix;
                    this.f28714Qy.setLocalMatrix(matrix);
                }
                this.mPaint.setShader(this.f28714Qy);
                this.f28715Qz.setScale(((progress - f) * 1.0f) / this.f28708QH.width(), 1.0f, f, 0.0f);
                this.f28714Qy.setLocalMatrix(this.f28715Qz);
            } else {
                this.mPaint.setShader(null);
            }
            canvas.drawText(this.f28713Qx, f, height, this.mPaint);
            return;
        }
        if (!isIndeterminate() && !this.f28712QL) {
            this.mPaint.setColor(this.f28710QJ);
            String str2 = this.f28713Qx;
            if (str2 != null) {
                canvas.drawText(str2, width, height, this.mPaint);
            }
            return;
        }
        float width3 = (getWidth() * getProgress()) / getMax();
        int save = canvas.save();
        this.mRectF.set(width3, 0.0f, getWidth(), getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.f28711QK);
        String str3 = this.f28713Qx;
        if (str3 != null) {
            canvas.drawText(str3, width, height, this.mPaint);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        this.mRectF.set(0.0f, 0.0f, width3, getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.f28710QJ);
        String str4 = this.f28713Qx;
        if (str4 != null) {
            canvas.drawText(str4, width, height, this.mPaint);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && !TextUtils.isEmpty(this.f28713Qx)) {
            Rect rect = new Rect();
            Paint paint = this.mPaint;
            String str = this.f28713Qx;
            paint.getTextBounds(str, 0, str.length(), rect);
            if (layoutParams.width == -2) {
                int width = rect.width() + this.f28704QD + this.f28705QE;
                layoutParams.width = width;
                i = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
            }
            if (layoutParams.height == -2) {
                int height = rect.height();
                layoutParams.height = height;
                i2 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
            }
        }
        if (this.f28702QB) {
            super.onMeasure(i2, i);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.f28702QB) {
            super.onSizeChanged(i2, i, i3, i4);
        } else {
            super.onSizeChanged(i, i2, i3, i4);
        }
    }

    public void setDrawableLeft(Drawable drawable) {
        this.f28706QF = drawable;
    }

    public void setDrawablePadding(int i) {
        this.f28707QG = i;
    }

    public void setHasProgress(boolean z) {
        this.f28703QC = z;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.f28704QD = i;
        this.f28705QE = i3;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i) {
        if (this.f28703QC) {
            super.setProgress(i);
        } else {
            super.setProgress(0);
        }
    }

    public void setTextColor(int i) {
        this.f28712QL = false;
        this.f28710QJ = i;
        postInvalidate();
    }

    public void setTextDimen(float f) {
        this.mPaint.setTextSize(f);
    }

    public void setTextDimenSp(int i) {
        this.mPaint.setTextSize(TypedValue.applyDimension(2, i, getResources().getDisplayMetrics()));
    }

    public void setVertical(boolean z) {
        this.f28702QB = z;
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(C10887l.wrapContextIfNeed(context), attributeSet);
        this.f28702QB = false;
        this.f28703QC = true;
        this.f28708QH = new Rect();
        m29708qc();
    }

    public final void setTextColor(@ColorInt int i, @ColorInt int i2) {
        this.f28712QL = true;
        this.f28710QJ = i;
        this.f28711QK = i2;
        postInvalidate();
    }
}
