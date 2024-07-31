package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
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
            paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.mAxisLinePaint.setStrokeWidth(1.0f);
            this.mAxisLinePaint.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint(1);
            this.mLimitLinePaint = paint3;
            paint3.setStyle(Paint.Style.STROKE);
        }
    }

    public void computeAxis(float f, float f2, boolean z) {
        float f3;
        double d;
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        if (viewPortHandler != null && viewPortHandler.contentWidth() > 10.0f && !this.mViewPortHandler.isFullyZoomedOutY()) {
            MPPointD valuesByTouchPoint = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
            MPPointD valuesByTouchPoint2 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom());
            if (!z) {
                f3 = (float) valuesByTouchPoint2.f23782y;
                d = valuesByTouchPoint.f23782y;
            } else {
                f3 = (float) valuesByTouchPoint.f23782y;
                d = valuesByTouchPoint2.f23782y;
            }
            MPPointD.recycleInstance(valuesByTouchPoint);
            MPPointD.recycleInstance(valuesByTouchPoint2);
            f = f3;
            f2 = (float) d;
        }
        computeAxisValues(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    public void computeAxisValues(float f, float f2) {
        double ceil;
        double nextUp;
        float f3 = f;
        int labelCount = this.mAxis.getLabelCount();
        double abs = Math.abs(f2 - f3);
        if (labelCount != 0 && abs > Utils.DOUBLE_EPSILON && !Double.isInfinite(abs)) {
            double d = labelCount;
            Double.isNaN(abs);
            Double.isNaN(d);
            double roundToNextSignificant = Utils.roundToNextSignificant(abs / d);
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
                for (int i = 0; i < labelCount; i++) {
                    this.mAxis.mEntries[i] = f3;
                    double d2 = f3;
                    Double.isNaN(d2);
                    Double.isNaN(roundToNextSignificant);
                    f3 = (float) (d2 + roundToNextSignificant);
                }
            } else {
                if (roundToNextSignificant == Utils.DOUBLE_EPSILON) {
                    ceil = Utils.DOUBLE_EPSILON;
                } else {
                    double d3 = f3;
                    Double.isNaN(d3);
                    ceil = Math.ceil(d3 / roundToNextSignificant) * roundToNextSignificant;
                }
                if (this.mAxis.isCenterAxisLabelsEnabled()) {
                    ceil -= roundToNextSignificant;
                }
                if (roundToNextSignificant == Utils.DOUBLE_EPSILON) {
                    nextUp = 0.0d;
                } else {
                    double d4 = f2;
                    Double.isNaN(d4);
                    nextUp = Utils.nextUp(Math.floor(d4 / roundToNextSignificant) * roundToNextSignificant);
                }
                if (roundToNextSignificant != Utils.DOUBLE_EPSILON) {
                    double d5 = ceil;
                    isCenterAxisLabelsEnabled = isCenterAxisLabelsEnabled;
                    while (d5 <= nextUp) {
                        d5 += roundToNextSignificant;
                        isCenterAxisLabelsEnabled++;
                    }
                }
                AxisBase axisBase2 = this.mAxis;
                axisBase2.mEntryCount = isCenterAxisLabelsEnabled;
                if (axisBase2.mEntries.length < isCenterAxisLabelsEnabled) {
                    axisBase2.mEntries = new float[isCenterAxisLabelsEnabled];
                }
                for (int i2 = 0; i2 < isCenterAxisLabelsEnabled; i2++) {
                    if (ceil == Utils.DOUBLE_EPSILON) {
                        ceil = 0.0d;
                    }
                    this.mAxis.mEntries[i2] = (float) ceil;
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
                float f4 = ((float) roundToNextSignificant) / 2.0f;
                for (int i3 = 0; i3 < labelCount; i3++) {
                    AxisBase axisBase4 = this.mAxis;
                    axisBase4.mCenteredEntries[i3] = axisBase4.mEntries[i3] + f4;
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
