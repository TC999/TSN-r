package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class AxisRenderer extends Renderer {
    protected AxisBase mAxis;
    protected Paint mAxisLabelPaint;
    protected Paint mAxisLinePaint;
    protected Paint mGridPaint;
    protected Paint mLimitLinePaint;
    protected Transformer mTrans;

    public AxisRenderer(ViewPortHandler viewPortHandler, Transformer transformer, AxisBase axisBase) {
        super(viewPortHandler);
        this.mTrans = transformer;
        this.mAxis = axisBase;
        if (this.mViewPortHandler != null) {
            this.mAxisLabelPaint = new Paint(1);
            Paint paint = new Paint();
            this.mGridPaint = paint;
            paint.setColor(-7829368);
            this.mGridPaint.setStrokeWidth(1.0f);
            this.mGridPaint.setStyle(Paint.Style.STROKE);
            this.mGridPaint.setAlpha(90);
            Paint paint2 = new Paint();
            this.mAxisLinePaint = paint2;
            paint2.setColor(-16777216);
            this.mAxisLinePaint.setStrokeWidth(1.0f);
            this.mAxisLinePaint.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint(1);
            this.mLimitLinePaint = paint3;
            paint3.setStyle(Paint.Style.STROKE);
        }
    }

    public void computeAxis(float f4, float f5, boolean z3) {
        float f6;
        double d4;
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        if (viewPortHandler != null && viewPortHandler.contentWidth() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutY()) {
            MPPointD valuesByTouchPoint = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
            MPPointD valuesByTouchPoint2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom());
            if (!z3) {
                f6 = (float) valuesByTouchPoint2.f37331y;
                d4 = valuesByTouchPoint.f37331y;
            } else {
                f6 = (float) valuesByTouchPoint.f37331y;
                d4 = valuesByTouchPoint2.f37331y;
            }
            MPPointD.recycleInstance(valuesByTouchPoint);
            MPPointD.recycleInstance(valuesByTouchPoint2);
            f4 = f6;
            f5 = (float) d4;
        }
        computeAxisValues(f4, f5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    public void computeAxisValues(float f4, float f5) {
        double ceil;
        double nextUp;
        float f6 = f4;
        int labelCount = this.mAxis.getLabelCount();
        double abs = Math.abs(f5 - f6);
        if (labelCount != 0 && abs > 0.0d && !Double.isInfinite(abs)) {
            double d4 = labelCount;
            Double.isNaN(abs);
            Double.isNaN(d4);
            double roundToNextSignificant = Utils.roundToNextSignificant(abs / d4);
            if (this.mAxis.isGranularityEnabled() && roundToNextSignificant < this.mAxis.getGranularity()) {
                roundToNextSignificant = this.mAxis.getGranularity();
            }
            double roundToNextSignificant2 = Utils.roundToNextSignificant(Math.pow(10.0d, (int) Math.log10(roundToNextSignificant)));
            Double.isNaN(roundToNextSignificant2);
            if (((int) (roundToNextSignificant / roundToNextSignificant2)) > 5) {
                Double.isNaN(roundToNextSignificant2);
                roundToNextSignificant = Math.floor(roundToNextSignificant2 * 10.0d);
            }
            int isCenterAxisLabelsEnabled = this.mAxis.isCenterAxisLabelsEnabled();
            if (this.mAxis.isForceLabelsEnabled()) {
                roundToNextSignificant = ((float) abs) / (labelCount - 1);
                AxisBase axisBase = this.mAxis;
                axisBase.mEntryCount = labelCount;
                if (axisBase.mEntries.length < labelCount) {
                    axisBase.mEntries = new float[labelCount];
                }
                for (int i4 = 0; i4 < labelCount; i4++) {
                    this.mAxis.mEntries[i4] = f6;
                    double d5 = f6;
                    Double.isNaN(d5);
                    Double.isNaN(roundToNextSignificant);
                    f6 = (float) (d5 + roundToNextSignificant);
                }
            } else {
                if (roundToNextSignificant == 0.0d) {
                    ceil = 0.0d;
                } else {
                    double d6 = f6;
                    Double.isNaN(d6);
                    ceil = Math.ceil(d6 / roundToNextSignificant) * roundToNextSignificant;
                }
                if (this.mAxis.isCenterAxisLabelsEnabled()) {
                    ceil -= roundToNextSignificant;
                }
                if (roundToNextSignificant == 0.0d) {
                    nextUp = 0.0d;
                } else {
                    double d7 = f5;
                    Double.isNaN(d7);
                    nextUp = Utils.nextUp(Math.floor(d7 / roundToNextSignificant) * roundToNextSignificant);
                }
                if (roundToNextSignificant != 0.0d) {
                    double d8 = ceil;
                    isCenterAxisLabelsEnabled = isCenterAxisLabelsEnabled;
                    while (d8 <= nextUp) {
                        d8 += roundToNextSignificant;
                        isCenterAxisLabelsEnabled++;
                    }
                }
                AxisBase axisBase2 = this.mAxis;
                axisBase2.mEntryCount = isCenterAxisLabelsEnabled;
                if (axisBase2.mEntries.length < isCenterAxisLabelsEnabled) {
                    axisBase2.mEntries = new float[isCenterAxisLabelsEnabled];
                }
                for (int i5 = 0; i5 < isCenterAxisLabelsEnabled; i5++) {
                    if (ceil == 0.0d) {
                        ceil = 0.0d;
                    }
                    this.mAxis.mEntries[i5] = (float) ceil;
                    ceil += roundToNextSignificant;
                }
                labelCount = isCenterAxisLabelsEnabled;
            }
            if (roundToNextSignificant < 1.0d) {
                this.mAxis.mDecimals = (int) Math.ceil(-Math.log10(roundToNextSignificant));
            } else {
                this.mAxis.mDecimals = 0;
            }
            if (this.mAxis.isCenterAxisLabelsEnabled()) {
                AxisBase axisBase3 = this.mAxis;
                if (axisBase3.mCenteredEntries.length < labelCount) {
                    axisBase3.mCenteredEntries = new float[labelCount];
                }
                float f7 = ((float) roundToNextSignificant) / 2.0f;
                for (int i6 = 0; i6 < labelCount; i6++) {
                    AxisBase axisBase4 = this.mAxis;
                    axisBase4.mCenteredEntries[i6] = axisBase4.mEntries[i6] + f7;
                }
                return;
            }
            return;
        }
        AxisBase axisBase5 = this.mAxis;
        axisBase5.mEntries = new float[0];
        axisBase5.mCenteredEntries = new float[0];
        axisBase5.mEntryCount = 0;
    }

    public Paint getPaintAxisLabels() {
        return this.mAxisLabelPaint;
    }

    public Paint getPaintAxisLine() {
        return this.mAxisLinePaint;
    }

    public Paint getPaintGrid() {
        return this.mGridPaint;
    }

    public Transformer getTransformer() {
        return this.mTrans;
    }

    public abstract void renderAxisLabels(Canvas canvas);

    public abstract void renderAxisLine(Canvas canvas);

    public abstract void renderGridLines(Canvas canvas);

    public abstract void renderLimitLines(Canvas canvas);
}
