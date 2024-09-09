package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class Transformer {
    protected ViewPortHandler mViewPortHandler;
    protected Matrix mMatrixValueToPx = new Matrix();
    protected Matrix mMatrixOffset = new Matrix();
    protected float[] valuePointsForGenerateTransformedValuesScatter = new float[1];
    protected float[] valuePointsForGenerateTransformedValuesBubble = new float[1];
    protected float[] valuePointsForGenerateTransformedValuesLine = new float[1];
    protected float[] valuePointsForGenerateTransformedValuesCandle = new float[1];
    protected Matrix mPixelToValueMatrixBuffer = new Matrix();
    float[] ptsBuffer = new float[2];
    private Matrix mMBuffer1 = new Matrix();
    private Matrix mMBuffer2 = new Matrix();

    public Transformer(ViewPortHandler viewPortHandler) {
        this.mViewPortHandler = viewPortHandler;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    public float[] generateTransformedValuesBubble(IBubbleDataSet iBubbleDataSet, float f4, int i4, int i5) {
        int i6 = ((i5 - i4) + 1) * 2;
        if (this.valuePointsForGenerateTransformedValuesBubble.length != i6) {
            this.valuePointsForGenerateTransformedValuesBubble = new float[i6];
        }
        float[] fArr = this.valuePointsForGenerateTransformedValuesBubble;
        for (int i7 = 0; i7 < i6; i7 += 2) {
            ?? entryForIndex = iBubbleDataSet.getEntryForIndex((i7 / 2) + i4);
            if (entryForIndex != 0) {
                fArr[i7] = entryForIndex.getX();
                fArr[i7 + 1] = entryForIndex.getY() * f4;
            } else {
                fArr[i7] = 0.0f;
                fArr[i7 + 1] = 0.0f;
            }
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    public float[] generateTransformedValuesCandle(ICandleDataSet iCandleDataSet, float f4, float f5, int i4, int i5) {
        int i6 = ((int) (((i5 - i4) * f4) + 1.0f)) * 2;
        if (this.valuePointsForGenerateTransformedValuesCandle.length != i6) {
            this.valuePointsForGenerateTransformedValuesCandle = new float[i6];
        }
        float[] fArr = this.valuePointsForGenerateTransformedValuesCandle;
        for (int i7 = 0; i7 < i6; i7 += 2) {
            CandleEntry candleEntry = (CandleEntry) iCandleDataSet.getEntryForIndex((i7 / 2) + i4);
            if (candleEntry != null) {
                fArr[i7] = candleEntry.getX();
                fArr[i7 + 1] = candleEntry.getHigh() * f5;
            } else {
                fArr[i7] = 0.0f;
                fArr[i7 + 1] = 0.0f;
            }
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    public float[] generateTransformedValuesLine(ILineDataSet iLineDataSet, float f4, float f5, int i4, int i5) {
        int i6 = (((int) ((i5 - i4) * f4)) + 1) * 2;
        if (this.valuePointsForGenerateTransformedValuesLine.length != i6) {
            this.valuePointsForGenerateTransformedValuesLine = new float[i6];
        }
        float[] fArr = this.valuePointsForGenerateTransformedValuesLine;
        for (int i7 = 0; i7 < i6; i7 += 2) {
            ?? entryForIndex = iLineDataSet.getEntryForIndex((i7 / 2) + i4);
            if (entryForIndex != 0) {
                fArr[i7] = entryForIndex.getX();
                fArr[i7 + 1] = entryForIndex.getY() * f5;
            } else {
                fArr[i7] = 0.0f;
                fArr[i7 + 1] = 0.0f;
            }
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    public float[] generateTransformedValuesScatter(IScatterDataSet iScatterDataSet, float f4, float f5, int i4, int i5) {
        int i6 = ((int) (((i5 - i4) * f4) + 1.0f)) * 2;
        if (this.valuePointsForGenerateTransformedValuesScatter.length != i6) {
            this.valuePointsForGenerateTransformedValuesScatter = new float[i6];
        }
        float[] fArr = this.valuePointsForGenerateTransformedValuesScatter;
        for (int i7 = 0; i7 < i6; i7 += 2) {
            ?? entryForIndex = iScatterDataSet.getEntryForIndex((i7 / 2) + i4);
            if (entryForIndex != 0) {
                fArr[i7] = entryForIndex.getX();
                fArr[i7 + 1] = entryForIndex.getY() * f5;
            } else {
                fArr[i7] = 0.0f;
                fArr[i7 + 1] = 0.0f;
            }
        }
        getValueToPixelMatrix().mapPoints(fArr);
        return fArr;
    }

    public Matrix getOffsetMatrix() {
        return this.mMatrixOffset;
    }

    public MPPointD getPixelForValues(float f4, float f5) {
        float[] fArr = this.ptsBuffer;
        fArr[0] = f4;
        fArr[1] = f5;
        pointValuesToPixel(fArr);
        float[] fArr2 = this.ptsBuffer;
        return MPPointD.getInstance(fArr2[0], fArr2[1]);
    }

    public Matrix getPixelToValueMatrix() {
        getValueToPixelMatrix().invert(this.mMBuffer2);
        return this.mMBuffer2;
    }

    public Matrix getValueMatrix() {
        return this.mMatrixValueToPx;
    }

    public Matrix getValueToPixelMatrix() {
        this.mMBuffer1.set(this.mMatrixValueToPx);
        this.mMBuffer1.postConcat(this.mViewPortHandler.mMatrixTouch);
        this.mMBuffer1.postConcat(this.mMatrixOffset);
        return this.mMBuffer1;
    }

    public MPPointD getValuesByTouchPoint(float f4, float f5) {
        MPPointD mPPointD = MPPointD.getInstance(0.0d, 0.0d);
        getValuesByTouchPoint(f4, f5, mPPointD);
        return mPPointD;
    }

    public void pathValueToPixel(Path path) {
        path.transform(this.mMatrixValueToPx);
        path.transform(this.mViewPortHandler.getMatrixTouch());
        path.transform(this.mMatrixOffset);
    }

    public void pathValuesToPixel(List<Path> list) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            pathValueToPixel(list.get(i4));
        }
    }

    public void pixelsToValue(float[] fArr) {
        Matrix matrix = this.mPixelToValueMatrixBuffer;
        matrix.reset();
        this.mMatrixOffset.invert(matrix);
        matrix.mapPoints(fArr);
        this.mViewPortHandler.getMatrixTouch().invert(matrix);
        matrix.mapPoints(fArr);
        this.mMatrixValueToPx.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public void pointValuesToPixel(float[] fArr) {
        this.mMatrixValueToPx.mapPoints(fArr);
        this.mViewPortHandler.getMatrixTouch().mapPoints(fArr);
        this.mMatrixOffset.mapPoints(fArr);
    }

    public void prepareMatrixOffset(boolean z3) {
        this.mMatrixOffset.reset();
        if (!z3) {
            this.mMatrixOffset.postTranslate(this.mViewPortHandler.offsetLeft(), this.mViewPortHandler.getChartHeight() - this.mViewPortHandler.offsetBottom());
            return;
        }
        this.mMatrixOffset.setTranslate(this.mViewPortHandler.offsetLeft(), -this.mViewPortHandler.offsetTop());
        this.mMatrixOffset.postScale(1.0f, -1.0f);
    }

    public void prepareMatrixValuePx(float f4, float f5, float f6, float f7) {
        float contentWidth = this.mViewPortHandler.contentWidth() / f5;
        float contentHeight = this.mViewPortHandler.contentHeight() / f6;
        if (Float.isInfinite(contentWidth)) {
            contentWidth = 0.0f;
        }
        if (Float.isInfinite(contentHeight)) {
            contentHeight = 0.0f;
        }
        this.mMatrixValueToPx.reset();
        this.mMatrixValueToPx.postTranslate(-f4, -f7);
        this.mMatrixValueToPx.postScale(contentWidth, -contentHeight);
    }

    public void rectToPixelPhase(RectF rectF, float f4) {
        rectF.top *= f4;
        rectF.bottom *= f4;
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public void rectToPixelPhaseHorizontal(RectF rectF, float f4) {
        rectF.left *= f4;
        rectF.right *= f4;
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public void rectValueToPixel(RectF rectF) {
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public void rectValueToPixelHorizontal(RectF rectF) {
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }

    public void rectValuesToPixel(List<RectF> list) {
        Matrix valueToPixelMatrix = getValueToPixelMatrix();
        for (int i4 = 0; i4 < list.size(); i4++) {
            valueToPixelMatrix.mapRect(list.get(i4));
        }
    }

    public void getValuesByTouchPoint(float f4, float f5, MPPointD mPPointD) {
        float[] fArr = this.ptsBuffer;
        fArr[0] = f4;
        fArr[1] = f5;
        pixelsToValue(fArr);
        float[] fArr2 = this.ptsBuffer;
        mPPointD.f37330x = fArr2[0];
        mPPointD.f37331y = fArr2[1];
    }

    public void rectValueToPixelHorizontal(RectF rectF, float f4) {
        rectF.left *= f4;
        rectF.right *= f4;
        this.mMatrixValueToPx.mapRect(rectF);
        this.mViewPortHandler.getMatrixTouch().mapRect(rectF);
        this.mMatrixOffset.mapRect(rectF);
    }
}
