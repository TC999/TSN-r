package com.github.mikephil.charting.data;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.scatter.ChevronDownShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.ChevronUpShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.CircleShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.CrossShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.SquareShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.TriangleShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.XShapeRenderer;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ScatterDataSet extends LineScatterCandleRadarDataSet<Entry> implements IScatterDataSet {
    private int mScatterShapeHoleColor;
    private float mScatterShapeHoleRadius;
    protected IShapeRenderer mShapeRenderer;
    private float mShapeSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* renamed from: com.github.mikephil.charting.data.ScatterDataSet$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape;

        static {
            int[] iArr = new int[ScatterChart.ScatterShape.values().length];
            $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape = iArr;
            try {
                iArr[ScatterChart.ScatterShape.SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.CIRCLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.TRIANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.CROSS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.X.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.CHEVRON_UP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[ScatterChart.ScatterShape.CHEVRON_DOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public ScatterDataSet(List<Entry> list, String str) {
        super(list, str);
        this.mShapeSize = 15.0f;
        this.mShapeRenderer = new SquareShapeRenderer();
        this.mScatterShapeHoleRadius = 0.0f;
        this.mScatterShapeHoleColor = 1122867;
    }

    public static IShapeRenderer getRendererForShape(ScatterChart.ScatterShape scatterShape) {
        switch (AnonymousClass1.$SwitchMap$com$github$mikephil$charting$charts$ScatterChart$ScatterShape[scatterShape.ordinal()]) {
            case 1:
                return new SquareShapeRenderer();
            case 2:
                return new CircleShapeRenderer();
            case 3:
                return new TriangleShapeRenderer();
            case 4:
                return new CrossShapeRenderer();
            case 5:
                return new XShapeRenderer();
            case 6:
                return new ChevronUpShapeRenderer();
            case 7:
                return new ChevronDownShapeRenderer();
            default:
                return null;
        }
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<Entry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.mValues.size(); i4++) {
            arrayList.add(((Entry) this.mValues.get(i4)).copy());
        }
        ScatterDataSet scatterDataSet = new ScatterDataSet(arrayList, getLabel());
        copy(scatterDataSet);
        return scatterDataSet;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public int getScatterShapeHoleColor() {
        return this.mScatterShapeHoleColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public float getScatterShapeHoleRadius() {
        return this.mScatterShapeHoleRadius;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public float getScatterShapeSize() {
        return this.mShapeSize;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public IShapeRenderer getShapeRenderer() {
        return this.mShapeRenderer;
    }

    public void setScatterShape(ScatterChart.ScatterShape scatterShape) {
        this.mShapeRenderer = getRendererForShape(scatterShape);
    }

    public void setScatterShapeHoleColor(int i4) {
        this.mScatterShapeHoleColor = i4;
    }

    public void setScatterShapeHoleRadius(float f4) {
        this.mScatterShapeHoleRadius = f4;
    }

    public void setScatterShapeSize(float f4) {
        this.mShapeSize = f4;
    }

    public void setShapeRenderer(IShapeRenderer iShapeRenderer) {
        this.mShapeRenderer = iShapeRenderer;
    }

    protected void copy(ScatterDataSet scatterDataSet) {
        super.copy((LineScatterCandleRadarDataSet) scatterDataSet);
        scatterDataSet.mShapeSize = this.mShapeSize;
        scatterDataSet.mShapeRenderer = this.mShapeRenderer;
        scatterDataSet.mScatterShapeHoleRadius = this.mScatterShapeHoleRadius;
        scatterDataSet.mScatterShapeHoleColor = this.mScatterShapeHoleColor;
    }
}
