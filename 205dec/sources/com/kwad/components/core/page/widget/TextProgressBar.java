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
import com.kwad.sdk.n.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class TextProgressBar extends ProgressBar {
    private boolean QA;
    private boolean QB;
    private boolean QC;
    private int QD;
    private int QE;
    private Drawable QF;
    private int QG;
    private Rect QH;
    private int[] QI;
    private int QJ;
    private int QK;
    private boolean QL;
    @Nullable
    private String Qx;
    private LinearGradient Qy;
    private Matrix Qz;
    private Paint mPaint;
    private RectF mRectF;

    public TextProgressBar(Context context) {
        this(context, null);
    }

    private void qc() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setTextSize(com.kwad.sdk.d.a.a.a(getContext(), 12.0f));
        this.QG = com.kwad.sdk.d.a.a.a(getContext(), 2.0f);
        this.mRectF = new RectF();
        this.QJ = -1;
        this.QK = -117146;
    }

    private void setProgressText(int i4) {
        this.Qx = String.valueOf((int) (((i4 * 1.0f) / getMax()) * 100.0f)) + "%";
    }

    public final void e(String str, int i4) {
        this.Qx = str;
        this.QA = true;
        setProgress(i4);
        invalidate();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        int width;
        if (this.QB) {
            canvas.save();
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
            super.onDraw(canvas);
            canvas.restore();
        } else {
            super.onDraw(canvas);
        }
        if (!TextUtils.isEmpty(this.Qx)) {
            Paint paint = this.mPaint;
            String str = this.Qx;
            paint.getTextBounds(str, 0, str.length(), this.QH);
        }
        int height = (getHeight() / 2) - this.QH.centerY();
        Drawable drawable = this.QF;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.QF.getIntrinsicHeight();
            int width2 = (((getWidth() - this.QH.width()) - intrinsicWidth) - this.QG) / 2;
            int i4 = intrinsicWidth + width2;
            this.QF.setBounds(width2, (getHeight() - intrinsicHeight) / 2, i4, (getHeight() + intrinsicHeight) / 2);
            this.QF.draw(canvas);
            width = i4 + this.QG;
        } else {
            width = (getWidth() / 2) - this.QH.centerX();
        }
        if (this.QI != null) {
            float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
            float f4 = width;
            if (progress >= f4) {
                if (this.Qy == null) {
                    this.Qy = new LinearGradient(f4, 0.0f, width + this.QH.width(), 0.0f, this.QI, (float[]) null, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    this.Qz = matrix;
                    this.Qy.setLocalMatrix(matrix);
                }
                this.mPaint.setShader(this.Qy);
                this.Qz.setScale(((progress - f4) * 1.0f) / this.QH.width(), 1.0f, f4, 0.0f);
                this.Qy.setLocalMatrix(this.Qz);
            } else {
                this.mPaint.setShader(null);
            }
            canvas.drawText(this.Qx, f4, height, this.mPaint);
            return;
        }
        if (!isIndeterminate() && !this.QL) {
            this.mPaint.setColor(this.QJ);
            String str2 = this.Qx;
            if (str2 != null) {
                canvas.drawText(str2, width, height, this.mPaint);
            }
            return;
        }
        float width3 = (getWidth() * getProgress()) / getMax();
        int save = canvas.save();
        this.mRectF.set(width3, 0.0f, getWidth(), getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.QK);
        String str3 = this.Qx;
        if (str3 != null) {
            canvas.drawText(str3, width, height, this.mPaint);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        this.mRectF.set(0.0f, 0.0f, width3, getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.QJ);
        String str4 = this.Qx;
        if (str4 != null) {
            canvas.drawText(str4, width, height, this.mPaint);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i4, int i5) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && !TextUtils.isEmpty(this.Qx)) {
            Rect rect = new Rect();
            Paint paint = this.mPaint;
            String str = this.Qx;
            paint.getTextBounds(str, 0, str.length(), rect);
            if (layoutParams.width == -2) {
                int width = rect.width() + this.QD + this.QE;
                layoutParams.width = width;
                i4 = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
            }
            if (layoutParams.height == -2) {
                int height = rect.height();
                layoutParams.height = height;
                i5 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
            }
        }
        if (this.QB) {
            super.onMeasure(i5, i4);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
        super.onMeasure(i4, i5);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        if (this.QB) {
            super.onSizeChanged(i5, i4, i6, i7);
        } else {
            super.onSizeChanged(i4, i5, i6, i7);
        }
    }

    public void setDrawableLeft(Drawable drawable) {
        this.QF = drawable;
    }

    public void setDrawablePadding(int i4) {
        this.QG = i4;
    }

    public void setHasProgress(boolean z3) {
        this.QC = z3;
    }

    @Override // android.view.View
    public void setPadding(int i4, int i5, int i6, int i7) {
        this.QD = i4;
        this.QE = i6;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i4) {
        if (this.QC) {
            super.setProgress(i4);
        } else {
            super.setProgress(0);
        }
    }

    public void setTextColor(int i4) {
        this.QL = false;
        this.QJ = i4;
        postInvalidate();
    }

    public void setTextDimen(float f4) {
        this.mPaint.setTextSize(f4);
    }

    public void setTextDimenSp(int i4) {
        this.mPaint.setTextSize(TypedValue.applyDimension(2, i4, getResources().getDisplayMetrics()));
    }

    public void setVertical(boolean z3) {
        this.QB = z3;
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(l.wrapContextIfNeed(context), attributeSet);
        this.QB = false;
        this.QC = true;
        this.QH = new Rect();
        qc();
    }

    public final void setTextColor(@ColorInt int i4, @ColorInt int i5) {
        this.QL = true;
        this.QJ = i4;
        this.QK = i5;
        postInvalidate();
    }
}
