package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class RadarDataSet extends LineRadarDataSet<RadarEntry> implements IRadarDataSet {
    protected boolean mDrawHighlightCircleEnabled;
    protected int mHighlightCircleFillColor;
    protected float mHighlightCircleInnerRadius;
    protected float mHighlightCircleOuterRadius;
    protected int mHighlightCircleStrokeAlpha;
    protected int mHighlightCircleStrokeColor;
    protected float mHighlightCircleStrokeWidth;

    public RadarDataSet(List<RadarEntry> list, String str) {
        super(list, str);
        this.mDrawHighlightCircleEnabled = false;
        this.mHighlightCircleFillColor = -1;
        this.mHighlightCircleStrokeColor = 1122867;
        this.mHighlightCircleStrokeAlpha = 76;
        this.mHighlightCircleInnerRadius = 3.0f;
        this.mHighlightCircleOuterRadius = 4.0f;
        this.mHighlightCircleStrokeWidth = 2.0f;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<RadarEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.mValues.size(); i4++) {
            arrayList.add(((RadarEntry) this.mValues.get(i4)).copy());
        }
        RadarDataSet radarDataSet = new RadarDataSet(arrayList, getLabel());
        copy(radarDataSet);
        return radarDataSet;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public int getHighlightCircleFillColor() {
        return this.mHighlightCircleFillColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public float getHighlightCircleInnerRadius() {
        return this.mHighlightCircleInnerRadius;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public float getHighlightCircleOuterRadius() {
        return this.mHighlightCircleOuterRadius;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public int getHighlightCircleStrokeAlpha() {
        return this.mHighlightCircleStrokeAlpha;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public int getHighlightCircleStrokeColor() {
        return this.mHighlightCircleStrokeColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public float getHighlightCircleStrokeWidth() {
        return this.mHighlightCircleStrokeWidth;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public boolean isDrawHighlightCircleEnabled() {
        return this.mDrawHighlightCircleEnabled;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public void setDrawHighlightCircleEnabled(boolean z3) {
        this.mDrawHighlightCircleEnabled = z3;
    }

    public void setHighlightCircleFillColor(int i4) {
        this.mHighlightCircleFillColor = i4;
    }

    public void setHighlightCircleInnerRadius(float f4) {
        this.mHighlightCircleInnerRadius = f4;
    }

    public void setHighlightCircleOuterRadius(float f4) {
        this.mHighlightCircleOuterRadius = f4;
    }

    public void setHighlightCircleStrokeAlpha(int i4) {
        this.mHighlightCircleStrokeAlpha = i4;
    }

    public void setHighlightCircleStrokeColor(int i4) {
        this.mHighlightCircleStrokeColor = i4;
    }

    public void setHighlightCircleStrokeWidth(float f4) {
        this.mHighlightCircleStrokeWidth = f4;
    }

    protected void copy(RadarDataSet radarDataSet) {
        super.copy((LineRadarDataSet) radarDataSet);
        radarDataSet.mDrawHighlightCircleEnabled = this.mDrawHighlightCircleEnabled;
        radarDataSet.mHighlightCircleFillColor = this.mHighlightCircleFillColor;
        radarDataSet.mHighlightCircleInnerRadius = this.mHighlightCircleInnerRadius;
        radarDataSet.mHighlightCircleStrokeAlpha = this.mHighlightCircleStrokeAlpha;
        radarDataSet.mHighlightCircleStrokeColor = this.mHighlightCircleStrokeColor;
        radarDataSet.mHighlightCircleStrokeWidth = this.mHighlightCircleStrokeWidth;
    }
}
