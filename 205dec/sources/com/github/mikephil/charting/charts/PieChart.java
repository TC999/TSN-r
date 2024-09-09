package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.PieHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class PieChart extends PieRadarChartBase<PieData> {
    private float[] mAbsoluteAngles;
    private CharSequence mCenterText;
    private MPPointF mCenterTextOffset;
    private float mCenterTextRadiusPercent;
    private RectF mCircleBox;
    private float[] mDrawAngles;
    private boolean mDrawCenterText;
    private boolean mDrawEntryLabels;
    private boolean mDrawHole;
    private boolean mDrawRoundedSlices;
    private boolean mDrawSlicesUnderHole;
    private float mHoleRadiusPercent;
    protected float mMaxAngle;
    private float mMinAngleForSlices;
    protected float mTransparentCircleRadiusPercent;
    private boolean mUsePercentValues;

    public PieChart(Context context) {
        super(context);
        this.mCircleBox = new RectF();
        this.mDrawEntryLabels = true;
        this.mDrawAngles = new float[1];
        this.mAbsoluteAngles = new float[1];
        this.mDrawHole = true;
        this.mDrawSlicesUnderHole = false;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = "";
        this.mCenterTextOffset = MPPointF.getInstance(0.0f, 0.0f);
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextRadiusPercent = 100.0f;
        this.mMaxAngle = 360.0f;
        this.mMinAngleForSlices = 0.0f;
    }

    private float calcAngle(float f4) {
        return calcAngle(f4, ((PieData) this.mData).getYValueSum());
    }

    private void calcAngles() {
        int entryCount = ((PieData) this.mData).getEntryCount();
        if (this.mDrawAngles.length != entryCount) {
            this.mDrawAngles = new float[entryCount];
        } else {
            for (int i4 = 0; i4 < entryCount; i4++) {
                this.mDrawAngles[i4] = 0.0f;
            }
        }
        if (this.mAbsoluteAngles.length != entryCount) {
            this.mAbsoluteAngles = new float[entryCount];
        } else {
            for (int i5 = 0; i5 < entryCount; i5++) {
                this.mAbsoluteAngles[i5] = 0.0f;
            }
        }
        float yValueSum = ((PieData) this.mData).getYValueSum();
        List<IPieDataSet> dataSets = ((PieData) this.mData).getDataSets();
        float f4 = this.mMinAngleForSlices;
        boolean z3 = f4 != 0.0f && ((float) entryCount) * f4 <= this.mMaxAngle;
        float[] fArr = new float[entryCount];
        float f5 = 0.0f;
        float f6 = 0.0f;
        int i6 = 0;
        for (int i7 = 0; i7 < ((PieData) this.mData).getDataSetCount(); i7++) {
            IPieDataSet iPieDataSet = dataSets.get(i7);
            for (int i8 = 0; i8 < iPieDataSet.getEntryCount(); i8++) {
                float calcAngle = calcAngle(Math.abs(iPieDataSet.getEntryForIndex(i8).getY()), yValueSum);
                if (z3) {
                    float f7 = this.mMinAngleForSlices;
                    float f8 = calcAngle - f7;
                    if (f8 <= 0.0f) {
                        fArr[i6] = f7;
                        f5 += -f8;
                    } else {
                        fArr[i6] = calcAngle;
                        f6 += f8;
                    }
                }
                float[] fArr2 = this.mDrawAngles;
                fArr2[i6] = calcAngle;
                if (i6 == 0) {
                    this.mAbsoluteAngles[i6] = fArr2[i6];
                } else {
                    float[] fArr3 = this.mAbsoluteAngles;
                    fArr3[i6] = fArr3[i6 - 1] + fArr2[i6];
                }
                i6++;
            }
        }
        if (z3) {
            for (int i9 = 0; i9 < entryCount; i9++) {
                fArr[i9] = fArr[i9] - (((fArr[i9] - this.mMinAngleForSlices) / f6) * f5);
                if (i9 == 0) {
                    this.mAbsoluteAngles[0] = fArr[0];
                } else {
                    float[] fArr4 = this.mAbsoluteAngles;
                    fArr4[i9] = fArr4[i9 - 1] + fArr[i9];
                }
            }
            this.mDrawAngles = fArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void calcMinMax() {
        calcAngles();
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void calculateOffsets() {
        super.calculateOffsets();
        if (this.mData == null) {
            return;
        }
        float diameter = getDiameter() / 2.0f;
        MPPointF centerOffsets = getCenterOffsets();
        float selectionShift = ((PieData) this.mData).getDataSet().getSelectionShift();
        RectF rectF = this.mCircleBox;
        float f4 = centerOffsets.f37332x;
        float f5 = centerOffsets.f37333y;
        rectF.set((f4 - diameter) + selectionShift, (f5 - diameter) + selectionShift, (f4 + diameter) - selectionShift, (f5 + diameter) - selectionShift);
        MPPointF.recycleInstance(centerOffsets);
    }

    public float[] getAbsoluteAngles() {
        return this.mAbsoluteAngles;
    }

    public MPPointF getCenterCircleBox() {
        return MPPointF.getInstance(this.mCircleBox.centerX(), this.mCircleBox.centerY());
    }

    public CharSequence getCenterText() {
        return this.mCenterText;
    }

    public MPPointF getCenterTextOffset() {
        MPPointF mPPointF = this.mCenterTextOffset;
        return MPPointF.getInstance(mPPointF.f37332x, mPPointF.f37333y);
    }

    public float getCenterTextRadiusPercent() {
        return this.mCenterTextRadiusPercent;
    }

    public RectF getCircleBox() {
        return this.mCircleBox;
    }

    public int getDataSetIndexForIndex(int i4) {
        List<IPieDataSet> dataSets = ((PieData) this.mData).getDataSets();
        for (int i5 = 0; i5 < dataSets.size(); i5++) {
            if (dataSets.get(i5).getEntryForXValue(i4, Float.NaN) != null) {
                return i5;
            }
        }
        return -1;
    }

    public float[] getDrawAngles() {
        return this.mDrawAngles;
    }

    public float getHoleRadius() {
        return this.mHoleRadiusPercent;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int getIndexForAngle(float f4) {
        float normalizedAngle = Utils.getNormalizedAngle(f4 - getRotationAngle());
        int i4 = 0;
        while (true) {
            float[] fArr = this.mAbsoluteAngles;
            if (i4 >= fArr.length) {
                return -1;
            }
            if (fArr[i4] > normalizedAngle) {
                return i4;
            }
            i4++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart
    public float[] getMarkerPosition(Highlight highlight) {
        int x3;
        MPPointF centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float f4 = (radius / 10.0f) * 3.6f;
        if (isDrawHoleEnabled()) {
            f4 = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        float f5 = radius - f4;
        float rotationAngle = getRotationAngle();
        float f6 = this.mDrawAngles[(int) highlight.getX()] / 2.0f;
        double d4 = f5;
        double cos = Math.cos(Math.toRadians(((this.mAbsoluteAngles[x3] + rotationAngle) - f6) * this.mAnimator.getPhaseY()));
        Double.isNaN(d4);
        double d5 = centerCircleBox.f37332x;
        Double.isNaN(d5);
        float f7 = (float) ((cos * d4) + d5);
        double sin = Math.sin(Math.toRadians(((rotationAngle + this.mAbsoluteAngles[x3]) - f6) * this.mAnimator.getPhaseY()));
        Double.isNaN(d4);
        double d6 = d4 * sin;
        double d7 = centerCircleBox.f37333y;
        Double.isNaN(d7);
        MPPointF.recycleInstance(centerCircleBox);
        return new float[]{f7, (float) (d6 + d7)};
    }

    public float getMaxAngle() {
        return this.mMaxAngle;
    }

    public float getMinAngleForSlices() {
        return this.mMinAngleForSlices;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF rectF = this.mCircleBox;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, this.mCircleBox.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBaseOffset() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredLegendOffset() {
        return this.mLegendRenderer.getLabelPaint().getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.mTransparentCircleRadiusPercent;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    @Deprecated
    public XAxis getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mRenderer = new PieChartRenderer(this, this.mAnimator, this.mViewPortHandler);
        this.mXAxis = null;
        this.mHighlighter = new PieHighlighter(this);
    }

    public boolean isDrawCenterTextEnabled() {
        return this.mDrawCenterText;
    }

    public boolean isDrawEntryLabelsEnabled() {
        return this.mDrawEntryLabels;
    }

    public boolean isDrawHoleEnabled() {
        return this.mDrawHole;
    }

    public boolean isDrawRoundedSlicesEnabled() {
        return this.mDrawRoundedSlices;
    }

    public boolean isDrawSlicesUnderHoleEnabled() {
        return this.mDrawSlicesUnderHole;
    }

    public boolean isUsePercentValuesEnabled() {
        return this.mUsePercentValues;
    }

    public boolean needsHighlight(int i4) {
        if (!valuesToHighlight()) {
            return false;
        }
        int i5 = 0;
        while (true) {
            Highlight[] highlightArr = this.mIndicesToHighlight;
            if (i5 >= highlightArr.length) {
                return false;
            }
            if (((int) highlightArr[i5].getX()) == i4) {
                return true;
            }
            i5++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        DataRenderer dataRenderer = this.mRenderer;
        if (dataRenderer != null && (dataRenderer instanceof PieChartRenderer)) {
            ((PieChartRenderer) dataRenderer).releaseBitmap();
        }
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData == null) {
            return;
        }
        this.mRenderer.drawData(canvas);
        if (valuesToHighlight()) {
            this.mRenderer.drawHighlighted(canvas, this.mIndicesToHighlight);
        }
        this.mRenderer.drawExtras(canvas);
        this.mRenderer.drawValues(canvas);
        this.mLegendRenderer.renderLegend(canvas);
        drawDescription(canvas);
        drawMarkers(canvas);
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            this.mCenterText = "";
        } else {
            this.mCenterText = charSequence;
        }
    }

    public void setCenterTextColor(int i4) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setColor(i4);
    }

    public void setCenterTextOffset(float f4, float f5) {
        this.mCenterTextOffset.f37332x = Utils.convertDpToPixel(f4);
        this.mCenterTextOffset.f37333y = Utils.convertDpToPixel(f5);
    }

    public void setCenterTextRadiusPercent(float f4) {
        this.mCenterTextRadiusPercent = f4;
    }

    public void setCenterTextSize(float f4) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(Utils.convertDpToPixel(f4));
    }

    public void setCenterTextSizePixels(float f4) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTextSize(f4);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((PieChartRenderer) this.mRenderer).getPaintCenterText().setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z3) {
        this.mDrawCenterText = z3;
    }

    public void setDrawEntryLabels(boolean z3) {
        this.mDrawEntryLabels = z3;
    }

    public void setDrawHoleEnabled(boolean z3) {
        this.mDrawHole = z3;
    }

    public void setDrawRoundedSlices(boolean z3) {
        this.mDrawRoundedSlices = z3;
    }

    @Deprecated
    public void setDrawSliceText(boolean z3) {
        this.mDrawEntryLabels = z3;
    }

    public void setDrawSlicesUnderHole(boolean z3) {
        this.mDrawSlicesUnderHole = z3;
    }

    public void setEntryLabelColor(int i4) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setColor(i4);
    }

    public void setEntryLabelTextSize(float f4) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setTextSize(Utils.convertDpToPixel(f4));
    }

    public void setEntryLabelTypeface(Typeface typeface) {
        ((PieChartRenderer) this.mRenderer).getPaintEntryLabels().setTypeface(typeface);
    }

    public void setHoleColor(int i4) {
        ((PieChartRenderer) this.mRenderer).getPaintHole().setColor(i4);
    }

    public void setHoleRadius(float f4) {
        this.mHoleRadiusPercent = f4;
    }

    public void setMaxAngle(float f4) {
        if (f4 > 360.0f) {
            f4 = 360.0f;
        }
        if (f4 < 90.0f) {
            f4 = 90.0f;
        }
        this.mMaxAngle = f4;
    }

    public void setMinAngleForSlices(float f4) {
        float f5 = this.mMaxAngle;
        if (f4 > f5 / 2.0f) {
            f4 = f5 / 2.0f;
        } else if (f4 < 0.0f) {
            f4 = 0.0f;
        }
        this.mMinAngleForSlices = f4;
    }

    public void setTransparentCircleAlpha(int i4) {
        ((PieChartRenderer) this.mRenderer).getPaintTransparentCircle().setAlpha(i4);
    }

    public void setTransparentCircleColor(int i4) {
        Paint paintTransparentCircle = ((PieChartRenderer) this.mRenderer).getPaintTransparentCircle();
        int alpha = paintTransparentCircle.getAlpha();
        paintTransparentCircle.setColor(i4);
        paintTransparentCircle.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f4) {
        this.mTransparentCircleRadiusPercent = f4;
    }

    public void setUsePercentValues(boolean z3) {
        this.mUsePercentValues = z3;
    }

    private float calcAngle(float f4, float f5) {
        return (f4 / f5) * this.mMaxAngle;
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCircleBox = new RectF();
        this.mDrawEntryLabels = true;
        this.mDrawAngles = new float[1];
        this.mAbsoluteAngles = new float[1];
        this.mDrawHole = true;
        this.mDrawSlicesUnderHole = false;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = "";
        this.mCenterTextOffset = MPPointF.getInstance(0.0f, 0.0f);
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextRadiusPercent = 100.0f;
        this.mMaxAngle = 360.0f;
        this.mMinAngleForSlices = 0.0f;
    }

    public PieChart(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mCircleBox = new RectF();
        this.mDrawEntryLabels = true;
        this.mDrawAngles = new float[1];
        this.mAbsoluteAngles = new float[1];
        this.mDrawHole = true;
        this.mDrawSlicesUnderHole = false;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = "";
        this.mCenterTextOffset = MPPointF.getInstance(0.0f, 0.0f);
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextRadiusPercent = 100.0f;
        this.mMaxAngle = 360.0f;
        this.mMinAngleForSlices = 0.0f;
    }
}
