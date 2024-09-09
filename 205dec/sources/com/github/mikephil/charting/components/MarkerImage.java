package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MarkerImage implements IMarker {
    private Context mContext;
    private Drawable mDrawable;
    private WeakReference<Chart> mWeakChart;
    private MPPointF mOffset = new MPPointF();
    private MPPointF mOffset2 = new MPPointF();
    private FSize mSize = new FSize();
    private Rect mDrawableBoundsCache = new Rect();

    public MarkerImage(Context context, int i4) {
        this.mContext = context;
        if (Build.VERSION.SDK_INT >= 21) {
            this.mDrawable = context.getResources().getDrawable(i4, null);
        } else {
            this.mDrawable = context.getResources().getDrawable(i4);
        }
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void draw(Canvas canvas, float f4, float f5) {
        if (this.mDrawable == null) {
            return;
        }
        MPPointF offsetForDrawingAtPoint = getOffsetForDrawingAtPoint(f4, f5);
        FSize fSize = this.mSize;
        float f6 = fSize.width;
        float f7 = fSize.height;
        if (f6 == 0.0f) {
            f6 = this.mDrawable.getIntrinsicWidth();
        }
        if (f7 == 0.0f) {
            f7 = this.mDrawable.getIntrinsicHeight();
        }
        this.mDrawable.copyBounds(this.mDrawableBoundsCache);
        Drawable drawable = this.mDrawable;
        Rect rect = this.mDrawableBoundsCache;
        int i4 = rect.left;
        int i5 = rect.top;
        drawable.setBounds(i4, i5, ((int) f6) + i4, ((int) f7) + i5);
        int save = canvas.save();
        canvas.translate(f4 + offsetForDrawingAtPoint.f37332x, f5 + offsetForDrawingAtPoint.f37333y);
        this.mDrawable.draw(canvas);
        canvas.restoreToCount(save);
        this.mDrawable.setBounds(this.mDrawableBoundsCache);
    }

    public Chart getChartView() {
        WeakReference<Chart> weakReference = this.mWeakChart;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public MPPointF getOffset() {
        return this.mOffset;
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public MPPointF getOffsetForDrawingAtPoint(float f4, float f5) {
        Drawable drawable;
        Drawable drawable2;
        MPPointF offset = getOffset();
        MPPointF mPPointF = this.mOffset2;
        mPPointF.f37332x = offset.f37332x;
        mPPointF.f37333y = offset.f37333y;
        Chart chartView = getChartView();
        FSize fSize = this.mSize;
        float f6 = fSize.width;
        float f7 = fSize.height;
        if (f6 == 0.0f && (drawable2 = this.mDrawable) != null) {
            f6 = drawable2.getIntrinsicWidth();
        }
        if (f7 == 0.0f && (drawable = this.mDrawable) != null) {
            f7 = drawable.getIntrinsicHeight();
        }
        MPPointF mPPointF2 = this.mOffset2;
        float f8 = mPPointF2.f37332x;
        if (f4 + f8 < 0.0f) {
            mPPointF2.f37332x = -f4;
        } else if (chartView != null && f4 + f6 + f8 > chartView.getWidth()) {
            this.mOffset2.f37332x = (chartView.getWidth() - f4) - f6;
        }
        MPPointF mPPointF3 = this.mOffset2;
        float f9 = mPPointF3.f37333y;
        if (f5 + f9 < 0.0f) {
            mPPointF3.f37333y = -f5;
        } else if (chartView != null && f5 + f7 + f9 > chartView.getHeight()) {
            this.mOffset2.f37333y = (chartView.getHeight() - f5) - f7;
        }
        return this.mOffset2;
    }

    public FSize getSize() {
        return this.mSize;
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void refreshContent(Entry entry, Highlight highlight) {
    }

    public void setChartView(Chart chart) {
        this.mWeakChart = new WeakReference<>(chart);
    }

    public void setOffset(MPPointF mPPointF) {
        this.mOffset = mPPointF;
        if (mPPointF == null) {
            this.mOffset = new MPPointF();
        }
    }

    public void setSize(FSize fSize) {
        this.mSize = fSize;
        if (fSize == null) {
            this.mSize = new FSize();
        }
    }

    public void setOffset(float f4, float f5) {
        MPPointF mPPointF = this.mOffset;
        mPPointF.f37332x = f4;
        mPPointF.f37333y = f5;
    }
}
