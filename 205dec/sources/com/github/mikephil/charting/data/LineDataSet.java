package com.github.mikephil.charting.data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.util.Log;
import com.github.mikephil.charting.formatter.DefaultFillFormatter;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class LineDataSet extends LineRadarDataSet<Entry> implements ILineDataSet {
    private List<Integer> mCircleColors;
    private int mCircleHoleColor;
    private float mCircleHoleRadius;
    private float mCircleRadius;
    private float mCubicIntensity;
    private DashPathEffect mDashPathEffect;
    private boolean mDrawCircleHole;
    private boolean mDrawCircles;
    private IFillFormatter mFillFormatter;
    private Mode mMode;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public enum Mode {
        LINEAR,
        STEPPED,
        CUBIC_BEZIER,
        HORIZONTAL_BEZIER
    }

    public LineDataSet(List<Entry> list, String str) {
        super(list, str);
        this.mMode = Mode.LINEAR;
        this.mCircleColors = null;
        this.mCircleHoleColor = -1;
        this.mCircleRadius = 8.0f;
        this.mCircleHoleRadius = 4.0f;
        this.mCubicIntensity = 0.2f;
        this.mDashPathEffect = null;
        this.mFillFormatter = new DefaultFillFormatter();
        this.mDrawCircles = true;
        this.mDrawCircleHole = true;
        if (this.mCircleColors == null) {
            this.mCircleColors = new ArrayList();
        }
        this.mCircleColors.clear();
        this.mCircleColors.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<Entry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.mValues.size(); i4++) {
            arrayList.add(((Entry) this.mValues.get(i4)).copy());
        }
        LineDataSet lineDataSet = new LineDataSet(arrayList, getLabel());
        copy(lineDataSet);
        return lineDataSet;
    }

    public void disableDashedLine() {
        this.mDashPathEffect = null;
    }

    public void enableDashedLine(float f4, float f5, float f6) {
        this.mDashPathEffect = new DashPathEffect(new float[]{f4, f5}, f6);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public int getCircleColor(int i4) {
        return this.mCircleColors.get(i4).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public int getCircleColorCount() {
        return this.mCircleColors.size();
    }

    public List<Integer> getCircleColors() {
        return this.mCircleColors;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public int getCircleHoleColor() {
        return this.mCircleHoleColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public float getCircleHoleRadius() {
        return this.mCircleHoleRadius;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public float getCircleRadius() {
        return this.mCircleRadius;
    }

    @Deprecated
    public float getCircleSize() {
        return getCircleRadius();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public float getCubicIntensity() {
        return this.mCubicIntensity;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public DashPathEffect getDashPathEffect() {
        return this.mDashPathEffect;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public IFillFormatter getFillFormatter() {
        return this.mFillFormatter;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public Mode getMode() {
        return this.mMode;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public boolean isDashedLineEnabled() {
        return this.mDashPathEffect != null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public boolean isDrawCircleHoleEnabled() {
        return this.mDrawCircleHole;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public boolean isDrawCirclesEnabled() {
        return this.mDrawCircles;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    @Deprecated
    public boolean isDrawCubicEnabled() {
        return this.mMode == Mode.CUBIC_BEZIER;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    @Deprecated
    public boolean isDrawSteppedEnabled() {
        return this.mMode == Mode.STEPPED;
    }

    public void resetCircleColors() {
        if (this.mCircleColors == null) {
            this.mCircleColors = new ArrayList();
        }
        this.mCircleColors.clear();
    }

    public void setCircleColor(int i4) {
        resetCircleColors();
        this.mCircleColors.add(Integer.valueOf(i4));
    }

    public void setCircleColors(List<Integer> list) {
        this.mCircleColors = list;
    }

    public void setCircleHoleColor(int i4) {
        this.mCircleHoleColor = i4;
    }

    public void setCircleHoleRadius(float f4) {
        if (f4 >= 0.5f) {
            this.mCircleHoleRadius = Utils.convertDpToPixel(f4);
        } else {
            Log.e("LineDataSet", "Circle radius cannot be < 0.5");
        }
    }

    public void setCircleRadius(float f4) {
        if (f4 >= 1.0f) {
            this.mCircleRadius = Utils.convertDpToPixel(f4);
        } else {
            Log.e("LineDataSet", "Circle radius cannot be < 1");
        }
    }

    @Deprecated
    public void setCircleSize(float f4) {
        setCircleRadius(f4);
    }

    public void setCubicIntensity(float f4) {
        if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        if (f4 < 0.05f) {
            f4 = 0.05f;
        }
        this.mCubicIntensity = f4;
    }

    public void setDrawCircleHole(boolean z3) {
        this.mDrawCircleHole = z3;
    }

    public void setDrawCircles(boolean z3) {
        this.mDrawCircles = z3;
    }

    public void setFillFormatter(IFillFormatter iFillFormatter) {
        if (iFillFormatter == null) {
            this.mFillFormatter = new DefaultFillFormatter();
        } else {
            this.mFillFormatter = iFillFormatter;
        }
    }

    public void setMode(Mode mode) {
        this.mMode = mode;
    }

    public void setCircleColors(int... iArr) {
        this.mCircleColors = ColorTemplate.createColors(iArr);
    }

    public void setCircleColors(int[] iArr, Context context) {
        List<Integer> list = this.mCircleColors;
        if (list == null) {
            list = new ArrayList<>();
        }
        list.clear();
        for (int i4 : iArr) {
            list.add(Integer.valueOf(context.getResources().getColor(i4)));
        }
        this.mCircleColors = list;
    }

    protected void copy(LineDataSet lineDataSet) {
        super.copy((LineRadarDataSet) lineDataSet);
        lineDataSet.mCircleColors = this.mCircleColors;
        lineDataSet.mCircleHoleColor = this.mCircleHoleColor;
        lineDataSet.mCircleHoleRadius = this.mCircleHoleRadius;
        lineDataSet.mCircleRadius = this.mCircleRadius;
        lineDataSet.mCubicIntensity = this.mCubicIntensity;
        lineDataSet.mDashPathEffect = this.mDashPathEffect;
        lineDataSet.mDrawCircleHole = this.mDrawCircleHole;
        lineDataSet.mDrawCircles = this.mDrawCircleHole;
        lineDataSet.mFillFormatter = this.mFillFormatter;
        lineDataSet.mMode = this.mMode;
    }
}
