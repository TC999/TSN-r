package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class XAxisRenderer extends AxisRenderer {
    protected RectF mGridClippingRect;
    protected RectF mLimitLineClippingRect;
    private Path mLimitLinePath;
    float[] mLimitLineSegmentsBuffer;
    protected float[] mRenderGridLinesBuffer;
    protected Path mRenderGridLinesPath;
    protected float[] mRenderLimitLinesBuffer;
    protected XAxis mXAxis;

    public XAxisRenderer(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer transformer) {
        super(viewPortHandler, transformer, xAxis);
        this.mRenderGridLinesPath = new Path();
        this.mRenderGridLinesBuffer = new float[2];
        this.mGridClippingRect = new RectF();
        this.mRenderLimitLinesBuffer = new float[2];
        this.mLimitLineClippingRect = new RectF();
        this.mLimitLineSegmentsBuffer = new float[4];
        this.mLimitLinePath = new Path();
        this.mXAxis = xAxis;
        this.mAxisLabelPaint.setColor(-16777216);
        this.mAxisLabelPaint.setTextAlign(Paint.Align.CENTER);
        this.mAxisLabelPaint.setTextSize(Utils.convertDpToPixel(10.0f));
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void computeAxis(float f4, float f5, boolean z3) {
        float f6;
        double d4;
        if (this.mViewPortHandler.contentWidth() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutX()) {
            MPPointD valuesByTouchPoint = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
            MPPointD valuesByTouchPoint2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop());
            if (z3) {
                f6 = (float) valuesByTouchPoint2.f37330x;
                d4 = valuesByTouchPoint.f37330x;
            } else {
                f6 = (float) valuesByTouchPoint.f37330x;
                d4 = valuesByTouchPoint2.f37330x;
            }
            MPPointD.recycleInstance(valuesByTouchPoint);
            MPPointD.recycleInstance(valuesByTouchPoint2);
            f4 = f6;
            f5 = (float) d4;
        }
        computeAxisValues(f4, f5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void computeAxisValues(float f4, float f5) {
        super.computeAxisValues(f4, f5);
        computeSize();
    }

    protected void computeSize() {
        String longestLabel = this.mXAxis.getLongestLabel();
        this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
        FSize calcTextSize = Utils.calcTextSize(this.mAxisLabelPaint, longestLabel);
        float f4 = calcTextSize.width;
        float calcTextHeight = Utils.calcTextHeight(this.mAxisLabelPaint, "Q");
        FSize sizeOfRotatedRectangleByDegrees = Utils.getSizeOfRotatedRectangleByDegrees(f4, calcTextHeight, this.mXAxis.getLabelRotationAngle());
        this.mXAxis.mLabelWidth = Math.round(f4);
        this.mXAxis.mLabelHeight = Math.round(calcTextHeight);
        this.mXAxis.mLabelRotatedWidth = Math.round(sizeOfRotatedRectangleByDegrees.width);
        this.mXAxis.mLabelRotatedHeight = Math.round(sizeOfRotatedRectangleByDegrees.height);
        FSize.recycleInstance(sizeOfRotatedRectangleByDegrees);
        FSize.recycleInstance(calcTextSize);
    }

    protected void drawGridLine(Canvas canvas, float f4, float f5, Path path) {
        path.moveTo(f4, this.mViewPortHandler.contentBottom());
        path.lineTo(f4, this.mViewPortHandler.contentTop());
        canvas.drawPath(path, this.mGridPaint);
        path.reset();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawLabel(Canvas canvas, String str, float f4, float f5, MPPointF mPPointF, float f6) {
        Utils.drawXAxisValue(canvas, str, f4, f5, this.mAxisLabelPaint, mPPointF, f6);
    }

    protected void drawLabels(Canvas canvas, float f4, MPPointF mPPointF) {
        float labelRotationAngle = this.mXAxis.getLabelRotationAngle();
        boolean isCenterAxisLabelsEnabled = this.mXAxis.isCenterAxisLabelsEnabled();
        int i4 = this.mXAxis.mEntryCount * 2;
        float[] fArr = new float[i4];
        for (int i5 = 0; i5 < i4; i5 += 2) {
            if (isCenterAxisLabelsEnabled) {
                fArr[i5] = this.mXAxis.mCenteredEntries[i5 / 2];
            } else {
                fArr[i5] = this.mXAxis.mEntries[i5 / 2];
            }
        }
        this.mTrans.pointValuesToPixel(fArr);
        for (int i6 = 0; i6 < i4; i6 += 2) {
            float f5 = fArr[i6];
            if (this.mViewPortHandler.isInBoundsX(f5)) {
                ValueFormatter valueFormatter = this.mXAxis.getValueFormatter();
                XAxis xAxis = this.mXAxis;
                int i7 = i6 / 2;
                String axisLabel = valueFormatter.getAxisLabel(xAxis.mEntries[i7], xAxis);
                if (this.mXAxis.isAvoidFirstLastClippingEnabled()) {
                    int i8 = this.mXAxis.mEntryCount;
                    if (i7 == i8 - 1 && i8 > 1) {
                        float calcTextWidth = Utils.calcTextWidth(this.mAxisLabelPaint, axisLabel);
                        if (calcTextWidth > this.mViewPortHandler.offsetRight() * 2.0f && f5 + calcTextWidth > this.mViewPortHandler.getChartWidth()) {
                            f5 -= calcTextWidth / 2.0f;
                        }
                    } else if (i6 == 0) {
                        f5 += Utils.calcTextWidth(this.mAxisLabelPaint, axisLabel) / 2.0f;
                    }
                }
                drawLabel(canvas, axisLabel, f5, f4, mPPointF, labelRotationAngle);
            }
        }
    }

    public RectF getGridClippingRect() {
        this.mGridClippingRect.set(this.mViewPortHandler.getContentRect());
        this.mGridClippingRect.inset(-this.mAxis.getGridLineWidth(), 0.0f);
        return this.mGridClippingRect;
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas canvas) {
        if (this.mXAxis.isEnabled() && this.mXAxis.isDrawLabelsEnabled()) {
            float yOffset = this.mXAxis.getYOffset();
            this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
            MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP) {
                mPPointF.f37332x = 0.5f;
                mPPointF.f37333y = 1.0f;
                drawLabels(canvas, this.mViewPortHandler.contentTop() - yOffset, mPPointF);
            } else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE) {
                mPPointF.f37332x = 0.5f;
                mPPointF.f37333y = 1.0f;
                drawLabels(canvas, this.mViewPortHandler.contentTop() + yOffset + this.mXAxis.mLabelRotatedHeight, mPPointF);
            } else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM) {
                mPPointF.f37332x = 0.5f;
                mPPointF.f37333y = 0.0f;
                drawLabels(canvas, this.mViewPortHandler.contentBottom() + yOffset, mPPointF);
            } else if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                mPPointF.f37332x = 0.5f;
                mPPointF.f37333y = 0.0f;
                drawLabels(canvas, (this.mViewPortHandler.contentBottom() - yOffset) - this.mXAxis.mLabelRotatedHeight, mPPointF);
            } else {
                mPPointF.f37332x = 0.5f;
                mPPointF.f37333y = 1.0f;
                drawLabels(canvas, this.mViewPortHandler.contentTop() - yOffset, mPPointF);
                mPPointF.f37332x = 0.5f;
                mPPointF.f37333y = 0.0f;
                drawLabels(canvas, this.mViewPortHandler.contentBottom() + yOffset, mPPointF);
            }
            MPPointF.recycleInstance(mPPointF);
        }
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLine(Canvas canvas) {
        if (this.mXAxis.isDrawAxisLineEnabled() && this.mXAxis.isEnabled()) {
            this.mAxisLinePaint.setColor(this.mXAxis.getAxisLineColor());
            this.mAxisLinePaint.setStrokeWidth(this.mXAxis.getAxisLineWidth());
            this.mAxisLinePaint.setPathEffect(this.mXAxis.getAxisLineDashPathEffect());
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP || this.mXAxis.getPosition() == XAxis.XAxisPosition.TOP_INSIDE || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop(), this.mAxisLinePaint);
            }
            if (this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.mXAxis.getPosition() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.mAxisLinePaint);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderGridLines(Canvas canvas) {
        if (this.mXAxis.isDrawGridLinesEnabled() && this.mXAxis.isEnabled()) {
            int save = canvas.save();
            canvas.clipRect(getGridClippingRect());
            if (this.mRenderGridLinesBuffer.length != this.mAxis.mEntryCount * 2) {
                this.mRenderGridLinesBuffer = new float[this.mXAxis.mEntryCount * 2];
            }
            float[] fArr = this.mRenderGridLinesBuffer;
            for (int i4 = 0; i4 < fArr.length; i4 += 2) {
                float[] fArr2 = this.mXAxis.mEntries;
                int i5 = i4 / 2;
                fArr[i4] = fArr2[i5];
                fArr[i4 + 1] = fArr2[i5];
            }
            this.mTrans.pointValuesToPixel(fArr);
            setupGridPaint();
            Path path = this.mRenderGridLinesPath;
            path.reset();
            for (int i6 = 0; i6 < fArr.length; i6 += 2) {
                drawGridLine(canvas, fArr[i6], fArr[i6 + 1], path);
            }
            canvas.restoreToCount(save);
        }
    }

    public void renderLimitLineLabel(Canvas canvas, LimitLine limitLine, float[] fArr, float f4) {
        String label = limitLine.getLabel();
        if (label == null || label.equals("")) {
            return;
        }
        this.mLimitLinePaint.setStyle(limitLine.getTextStyle());
        this.mLimitLinePaint.setPathEffect(null);
        this.mLimitLinePaint.setColor(limitLine.getTextColor());
        this.mLimitLinePaint.setStrokeWidth(0.5f);
        this.mLimitLinePaint.setTextSize(limitLine.getTextSize());
        float lineWidth = limitLine.getLineWidth() + limitLine.getXOffset();
        LimitLine.LimitLabelPosition labelPosition = limitLine.getLabelPosition();
        if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_TOP) {
            this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(label, fArr[0] + lineWidth, this.mViewPortHandler.contentTop() + f4 + Utils.calcTextHeight(this.mLimitLinePaint, label), this.mLimitLinePaint);
        } else if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
            this.mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(label, fArr[0] + lineWidth, this.mViewPortHandler.contentBottom() - f4, this.mLimitLinePaint);
        } else if (labelPosition == LimitLine.LimitLabelPosition.LEFT_TOP) {
            this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(label, fArr[0] - lineWidth, this.mViewPortHandler.contentTop() + f4 + Utils.calcTextHeight(this.mLimitLinePaint, label), this.mLimitLinePaint);
        } else {
            this.mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(label, fArr[0] - lineWidth, this.mViewPortHandler.contentBottom() - f4, this.mLimitLinePaint);
        }
    }

    public void renderLimitLineLine(Canvas canvas, LimitLine limitLine, float[] fArr) {
        float[] fArr2 = this.mLimitLineSegmentsBuffer;
        fArr2[0] = fArr[0];
        fArr2[1] = this.mViewPortHandler.contentTop();
        float[] fArr3 = this.mLimitLineSegmentsBuffer;
        fArr3[2] = fArr[0];
        fArr3[3] = this.mViewPortHandler.contentBottom();
        this.mLimitLinePath.reset();
        Path path = this.mLimitLinePath;
        float[] fArr4 = this.mLimitLineSegmentsBuffer;
        path.moveTo(fArr4[0], fArr4[1]);
        Path path2 = this.mLimitLinePath;
        float[] fArr5 = this.mLimitLineSegmentsBuffer;
        path2.lineTo(fArr5[2], fArr5[3]);
        this.mLimitLinePaint.setStyle(Paint.Style.STROKE);
        this.mLimitLinePaint.setColor(limitLine.getLineColor());
        this.mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
        this.mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());
        canvas.drawPath(this.mLimitLinePath, this.mLimitLinePaint);
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas canvas) {
        List<LimitLine> limitLines = this.mXAxis.getLimitLines();
        if (limitLines == null || limitLines.size() <= 0) {
            return;
        }
        float[] fArr = this.mRenderLimitLinesBuffer;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        for (int i4 = 0; i4 < limitLines.size(); i4++) {
            LimitLine limitLine = limitLines.get(i4);
            if (limitLine.isEnabled()) {
                int save = canvas.save();
                this.mLimitLineClippingRect.set(this.mViewPortHandler.getContentRect());
                this.mLimitLineClippingRect.inset(-limitLine.getLineWidth(), 0.0f);
                canvas.clipRect(this.mLimitLineClippingRect);
                fArr[0] = limitLine.getLimit();
                fArr[1] = 0.0f;
                this.mTrans.pointValuesToPixel(fArr);
                renderLimitLineLine(canvas, limitLine, fArr);
                renderLimitLineLabel(canvas, limitLine, fArr, limitLine.getYOffset() + 2.0f);
                canvas.restoreToCount(save);
            }
        }
    }

    protected void setupGridPaint() {
        this.mGridPaint.setColor(this.mXAxis.getGridColor());
        this.mGridPaint.setStrokeWidth(this.mXAxis.getGridLineWidth());
        this.mGridPaint.setPathEffect(this.mXAxis.getGridDashPathEffect());
    }
}
