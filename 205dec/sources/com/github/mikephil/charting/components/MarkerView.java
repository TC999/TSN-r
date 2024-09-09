package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MarkerView extends RelativeLayout implements IMarker {
    private MPPointF mOffset;
    private MPPointF mOffset2;
    private WeakReference<Chart> mWeakChart;

    public MarkerView(Context context, int i4) {
        super(context);
        this.mOffset = new MPPointF();
        this.mOffset2 = new MPPointF();
        setupLayoutResource(i4);
    }

    private void setupLayoutResource(int i4) {
        View inflate = LayoutInflater.from(getContext()).inflate(i4, this);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void draw(Canvas canvas, float f4, float f5) {
        MPPointF offsetForDrawingAtPoint = getOffsetForDrawingAtPoint(f4, f5);
        int save = canvas.save();
        canvas.translate(f4 + offsetForDrawingAtPoint.f37332x, f5 + offsetForDrawingAtPoint.f37333y);
        draw(canvas);
        canvas.restoreToCount(save);
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
        MPPointF offset = getOffset();
        MPPointF mPPointF = this.mOffset2;
        mPPointF.f37332x = offset.f37332x;
        mPPointF.f37333y = offset.f37333y;
        Chart chartView = getChartView();
        float width = getWidth();
        float height = getHeight();
        MPPointF mPPointF2 = this.mOffset2;
        float f6 = mPPointF2.f37332x;
        if (f4 + f6 < 0.0f) {
            mPPointF2.f37332x = -f4;
        } else if (chartView != null && f4 + width + f6 > chartView.getWidth()) {
            this.mOffset2.f37332x = (chartView.getWidth() - f4) - width;
        }
        MPPointF mPPointF3 = this.mOffset2;
        float f7 = mPPointF3.f37333y;
        if (f5 + f7 < 0.0f) {
            mPPointF3.f37333y = -f5;
        } else if (chartView != null && f5 + height + f7 > chartView.getHeight()) {
            this.mOffset2.f37333y = (chartView.getHeight() - f5) - height;
        }
        return this.mOffset2;
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void refreshContent(Entry entry, Highlight highlight) {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
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

    public void setOffset(float f4, float f5) {
        MPPointF mPPointF = this.mOffset;
        mPPointF.f37332x = f4;
        mPPointF.f37333y = f5;
    }
}
