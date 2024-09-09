package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.util.Log;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class AxisBase extends ComponentBase {
    protected ValueFormatter mAxisValueFormatter;
    public int mDecimals;
    public int mEntryCount;
    protected List<LimitLine> mLimitLines;
    private int mGridColor = -7829368;
    private float mGridLineWidth = 1.0f;
    private int mAxisLineColor = -7829368;
    private float mAxisLineWidth = 1.0f;
    public float[] mEntries = new float[0];
    public float[] mCenteredEntries = new float[0];
    private int mLabelCount = 6;
    protected float mGranularity = 1.0f;
    protected boolean mGranularityEnabled = false;
    protected boolean mForceLabels = false;
    protected boolean mDrawGridLines = true;
    protected boolean mDrawAxisLine = true;
    protected boolean mDrawLabels = true;
    protected boolean mCenterAxisLabels = false;
    private DashPathEffect mAxisLineDashPathEffect = null;
    private DashPathEffect mGridDashPathEffect = null;
    protected boolean mDrawLimitLineBehindData = false;
    protected boolean mDrawGridLinesBehindData = true;
    protected float mSpaceMin = 0.0f;
    protected float mSpaceMax = 0.0f;
    protected boolean mCustomAxisMin = false;
    protected boolean mCustomAxisMax = false;
    public float mAxisMaximum = 0.0f;
    public float mAxisMinimum = 0.0f;
    public float mAxisRange = 0.0f;

    public AxisBase() {
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(5.0f);
        this.mLimitLines = new ArrayList();
    }

    public void addLimitLine(LimitLine limitLine) {
        this.mLimitLines.add(limitLine);
        if (this.mLimitLines.size() > 6) {
            Log.e("MPAndroiChart", "Warning! You have more than 6 LimitLines on your axis, do you really want that?");
        }
    }

    public void calculate(float f4, float f5) {
        float f6 = this.mCustomAxisMin ? this.mAxisMinimum : f4 - this.mSpaceMin;
        float f7 = this.mCustomAxisMax ? this.mAxisMaximum : f5 + this.mSpaceMax;
        if (Math.abs(f7 - f6) == 0.0f) {
            f7 += 1.0f;
            f6 -= 1.0f;
        }
        this.mAxisMinimum = f6;
        this.mAxisMaximum = f7;
        this.mAxisRange = Math.abs(f7 - f6);
    }

    public void disableAxisLineDashedLine() {
        this.mAxisLineDashPathEffect = null;
    }

    public void disableGridDashedLine() {
        this.mGridDashPathEffect = null;
    }

    public void enableAxisLineDashedLine(float f4, float f5, float f6) {
        this.mAxisLineDashPathEffect = new DashPathEffect(new float[]{f4, f5}, f6);
    }

    public void enableGridDashedLine(float f4, float f5, float f6) {
        this.mGridDashPathEffect = new DashPathEffect(new float[]{f4, f5}, f6);
    }

    public int getAxisLineColor() {
        return this.mAxisLineColor;
    }

    public DashPathEffect getAxisLineDashPathEffect() {
        return this.mAxisLineDashPathEffect;
    }

    public float getAxisLineWidth() {
        return this.mAxisLineWidth;
    }

    public float getAxisMaximum() {
        return this.mAxisMaximum;
    }

    public float getAxisMinimum() {
        return this.mAxisMinimum;
    }

    public String getFormattedLabel(int i4) {
        return (i4 < 0 || i4 >= this.mEntries.length) ? "" : getValueFormatter().getAxisLabel(this.mEntries[i4], this);
    }

    public float getGranularity() {
        return this.mGranularity;
    }

    public int getGridColor() {
        return this.mGridColor;
    }

    public DashPathEffect getGridDashPathEffect() {
        return this.mGridDashPathEffect;
    }

    public float getGridLineWidth() {
        return this.mGridLineWidth;
    }

    public int getLabelCount() {
        return this.mLabelCount;
    }

    public List<LimitLine> getLimitLines() {
        return this.mLimitLines;
    }

    public String getLongestLabel() {
        String str = "";
        for (int i4 = 0; i4 < this.mEntries.length; i4++) {
            String formattedLabel = getFormattedLabel(i4);
            if (formattedLabel != null && str.length() < formattedLabel.length()) {
                str = formattedLabel;
            }
        }
        return str;
    }

    public float getSpaceMax() {
        return this.mSpaceMax;
    }

    public float getSpaceMin() {
        return this.mSpaceMin;
    }

    public ValueFormatter getValueFormatter() {
        ValueFormatter valueFormatter = this.mAxisValueFormatter;
        if (valueFormatter == null || ((valueFormatter instanceof DefaultAxisValueFormatter) && ((DefaultAxisValueFormatter) valueFormatter).getDecimalDigits() != this.mDecimals)) {
            this.mAxisValueFormatter = new DefaultAxisValueFormatter(this.mDecimals);
        }
        return this.mAxisValueFormatter;
    }

    public boolean isAxisLineDashedLineEnabled() {
        return this.mAxisLineDashPathEffect != null;
    }

    public boolean isAxisMaxCustom() {
        return this.mCustomAxisMax;
    }

    public boolean isAxisMinCustom() {
        return this.mCustomAxisMin;
    }

    public boolean isCenterAxisLabelsEnabled() {
        return this.mCenterAxisLabels && this.mEntryCount > 0;
    }

    public boolean isDrawAxisLineEnabled() {
        return this.mDrawAxisLine;
    }

    public boolean isDrawGridLinesBehindDataEnabled() {
        return this.mDrawGridLinesBehindData;
    }

    public boolean isDrawGridLinesEnabled() {
        return this.mDrawGridLines;
    }

    public boolean isDrawLabelsEnabled() {
        return this.mDrawLabels;
    }

    public boolean isDrawLimitLinesBehindDataEnabled() {
        return this.mDrawLimitLineBehindData;
    }

    public boolean isForceLabelsEnabled() {
        return this.mForceLabels;
    }

    public boolean isGranularityEnabled() {
        return this.mGranularityEnabled;
    }

    public boolean isGridDashedLineEnabled() {
        return this.mGridDashPathEffect != null;
    }

    public void removeAllLimitLines() {
        this.mLimitLines.clear();
    }

    public void removeLimitLine(LimitLine limitLine) {
        this.mLimitLines.remove(limitLine);
    }

    public void resetAxisMaximum() {
        this.mCustomAxisMax = false;
    }

    public void resetAxisMinimum() {
        this.mCustomAxisMin = false;
    }

    public void setAxisLineColor(int i4) {
        this.mAxisLineColor = i4;
    }

    public void setAxisLineDashedLine(DashPathEffect dashPathEffect) {
        this.mAxisLineDashPathEffect = dashPathEffect;
    }

    public void setAxisLineWidth(float f4) {
        this.mAxisLineWidth = Utils.convertDpToPixel(f4);
    }

    @Deprecated
    public void setAxisMaxValue(float f4) {
        setAxisMaximum(f4);
    }

    public void setAxisMaximum(float f4) {
        this.mCustomAxisMax = true;
        this.mAxisMaximum = f4;
        this.mAxisRange = Math.abs(f4 - this.mAxisMinimum);
    }

    @Deprecated
    public void setAxisMinValue(float f4) {
        setAxisMinimum(f4);
    }

    public void setAxisMinimum(float f4) {
        this.mCustomAxisMin = true;
        this.mAxisMinimum = f4;
        this.mAxisRange = Math.abs(this.mAxisMaximum - f4);
    }

    public void setCenterAxisLabels(boolean z3) {
        this.mCenterAxisLabels = z3;
    }

    public void setDrawAxisLine(boolean z3) {
        this.mDrawAxisLine = z3;
    }

    public void setDrawGridLines(boolean z3) {
        this.mDrawGridLines = z3;
    }

    public void setDrawGridLinesBehindData(boolean z3) {
        this.mDrawGridLinesBehindData = z3;
    }

    public void setDrawLabels(boolean z3) {
        this.mDrawLabels = z3;
    }

    public void setDrawLimitLinesBehindData(boolean z3) {
        this.mDrawLimitLineBehindData = z3;
    }

    public void setGranularity(float f4) {
        this.mGranularity = f4;
        this.mGranularityEnabled = true;
    }

    public void setGranularityEnabled(boolean z3) {
        this.mGranularityEnabled = z3;
    }

    public void setGridColor(int i4) {
        this.mGridColor = i4;
    }

    public void setGridDashedLine(DashPathEffect dashPathEffect) {
        this.mGridDashPathEffect = dashPathEffect;
    }

    public void setGridLineWidth(float f4) {
        this.mGridLineWidth = Utils.convertDpToPixel(f4);
    }

    public void setLabelCount(int i4) {
        if (i4 > 25) {
            i4 = 25;
        }
        if (i4 < 2) {
            i4 = 2;
        }
        this.mLabelCount = i4;
        this.mForceLabels = false;
    }

    public void setSpaceMax(float f4) {
        this.mSpaceMax = f4;
    }

    public void setSpaceMin(float f4) {
        this.mSpaceMin = f4;
    }

    public void setValueFormatter(ValueFormatter valueFormatter) {
        if (valueFormatter == null) {
            this.mAxisValueFormatter = new DefaultAxisValueFormatter(this.mDecimals);
        } else {
            this.mAxisValueFormatter = valueFormatter;
        }
    }

    public void setLabelCount(int i4, boolean z3) {
        setLabelCount(i4);
        this.mForceLabels = z3;
    }
}
