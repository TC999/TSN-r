package com.umeng.socialize.shareboard;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class IndicatorView extends View {
    private int mIndicatorMargin;
    private int mIndicatorWidth;
    private float mLeftPosition;
    private Paint mNormalPaint;
    private int mPageCount;
    private Paint mSelectPaint;
    private int mSelectPosition;

    public IndicatorView(Context context) {
        super(context);
    }

    private int measureHeight(int i4) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = getPaddingTop() + getPaddingBottom() + (this.mIndicatorWidth * 2);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    private int measureWidth(int i4) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i5 = this.mIndicatorWidth;
        int i6 = this.mPageCount;
        int i7 = paddingLeft + (i5 * i6 * 2) + (this.mIndicatorMargin * (i6 - 1));
        this.mLeftPosition = ((getMeasuredWidth() - i7) / 2.0f) + getPaddingLeft();
        if (mode == 1073741824) {
            return Math.max(i7, size);
        }
        return mode == Integer.MIN_VALUE ? Math.min(i7, size) : i7;
    }

    protected int dip2px(float f4) {
        return (int) ((f4 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mSelectPaint == null || this.mNormalPaint == null) {
            return;
        }
        float f4 = this.mLeftPosition + this.mIndicatorWidth;
        int i4 = 0;
        while (i4 < this.mPageCount) {
            int i5 = this.mIndicatorWidth;
            canvas.drawCircle(f4, i5, i5, i4 == this.mSelectPosition ? this.mSelectPaint : this.mNormalPaint);
            f4 += this.mIndicatorMargin + (this.mIndicatorWidth * 2);
            i4++;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(measureWidth(i4), measureHeight(i5));
    }

    public void setIndicator(int i4, int i5) {
        this.mIndicatorMargin = dip2px(i5);
        this.mIndicatorWidth = dip2px(i4);
    }

    public void setIndicatorColor(int i4, int i5) {
        Paint paint = new Paint();
        this.mSelectPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mSelectPaint.setAntiAlias(true);
        this.mSelectPaint.setColor(i5);
        Paint paint2 = new Paint();
        this.mNormalPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.mNormalPaint.setAntiAlias(true);
        this.mNormalPaint.setColor(i4);
    }

    public void setPageCount(int i4) {
        this.mPageCount = i4;
        invalidate();
    }

    public void setSelectedPosition(int i4) {
        this.mSelectPosition = i4;
        invalidate();
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    @TargetApi(21)
    public IndicatorView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }
}
