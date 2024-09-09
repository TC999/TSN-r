package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ViewPortHandler {
    protected final Matrix mMatrixTouch = new Matrix();
    protected RectF mContentRect = new RectF();
    protected float mChartWidth = 0.0f;
    protected float mChartHeight = 0.0f;
    private float mMinScaleY = 1.0f;
    private float mMaxScaleY = Float.MAX_VALUE;
    private float mMinScaleX = 1.0f;
    private float mMaxScaleX = Float.MAX_VALUE;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private float mTransX = 0.0f;
    private float mTransY = 0.0f;
    private float mTransOffsetX = 0.0f;
    private float mTransOffsetY = 0.0f;
    protected float[] valsBufferForFitScreen = new float[9];
    protected Matrix mCenterViewPortMatrixBuffer = new Matrix();
    protected final float[] matrixBuffer = new float[9];

    public boolean canZoomInMoreX() {
        return this.mScaleX < this.mMaxScaleX;
    }

    public boolean canZoomInMoreY() {
        return this.mScaleY < this.mMaxScaleY;
    }

    public boolean canZoomOutMoreX() {
        return this.mScaleX > this.mMinScaleX;
    }

    public boolean canZoomOutMoreY() {
        return this.mScaleY > this.mMinScaleY;
    }

    public void centerViewPort(float[] fArr, View view) {
        Matrix matrix = this.mCenterViewPortMatrixBuffer;
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postTranslate(-(fArr[0] - offsetLeft()), -(fArr[1] - offsetTop()));
        refresh(matrix, view, true);
    }

    public float contentBottom() {
        return this.mContentRect.bottom;
    }

    public float contentHeight() {
        return this.mContentRect.height();
    }

    public float contentLeft() {
        return this.mContentRect.left;
    }

    public float contentRight() {
        return this.mContentRect.right;
    }

    public float contentTop() {
        return this.mContentRect.top;
    }

    public float contentWidth() {
        return this.mContentRect.width();
    }

    public Matrix fitScreen() {
        Matrix matrix = new Matrix();
        fitScreen(matrix);
        return matrix;
    }

    public float getChartHeight() {
        return this.mChartHeight;
    }

    public float getChartWidth() {
        return this.mChartWidth;
    }

    public MPPointF getContentCenter() {
        return MPPointF.getInstance(this.mContentRect.centerX(), this.mContentRect.centerY());
    }

    public RectF getContentRect() {
        return this.mContentRect;
    }

    public Matrix getMatrixTouch() {
        return this.mMatrixTouch;
    }

    public float getMaxScaleX() {
        return this.mMaxScaleX;
    }

    public float getMaxScaleY() {
        return this.mMaxScaleY;
    }

    public float getMinScaleX() {
        return this.mMinScaleX;
    }

    public float getMinScaleY() {
        return this.mMinScaleY;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public float getSmallestContentExtension() {
        return Math.min(this.mContentRect.width(), this.mContentRect.height());
    }

    public float getTransX() {
        return this.mTransX;
    }

    public float getTransY() {
        return this.mTransY;
    }

    public boolean hasChartDimens() {
        return this.mChartHeight > 0.0f && this.mChartWidth > 0.0f;
    }

    public boolean hasNoDragOffset() {
        return this.mTransOffsetX <= 0.0f && this.mTransOffsetY <= 0.0f;
    }

    public boolean isFullyZoomedOut() {
        return isFullyZoomedOutX() && isFullyZoomedOutY();
    }

    public boolean isFullyZoomedOutX() {
        float f4 = this.mScaleX;
        float f5 = this.mMinScaleX;
        return f4 <= f5 && f5 <= 1.0f;
    }

    public boolean isFullyZoomedOutY() {
        float f4 = this.mScaleY;
        float f5 = this.mMinScaleY;
        return f4 <= f5 && f5 <= 1.0f;
    }

    public boolean isInBounds(float f4, float f5) {
        return isInBoundsX(f4) && isInBoundsY(f5);
    }

    public boolean isInBoundsBottom(float f4) {
        return this.mContentRect.bottom >= ((float) ((int) (f4 * 100.0f))) / 100.0f;
    }

    public boolean isInBoundsLeft(float f4) {
        return this.mContentRect.left <= f4 + 1.0f;
    }

    public boolean isInBoundsRight(float f4) {
        return this.mContentRect.right >= (((float) ((int) (f4 * 100.0f))) / 100.0f) - 1.0f;
    }

    public boolean isInBoundsTop(float f4) {
        return this.mContentRect.top <= f4;
    }

    public boolean isInBoundsX(float f4) {
        return isInBoundsLeft(f4) && isInBoundsRight(f4);
    }

    public boolean isInBoundsY(float f4) {
        return isInBoundsTop(f4) && isInBoundsBottom(f4);
    }

    public void limitTransAndScale(Matrix matrix, RectF rectF) {
        float f4;
        matrix.getValues(this.matrixBuffer);
        float[] fArr = this.matrixBuffer;
        float f5 = fArr[2];
        float f6 = fArr[0];
        float f7 = fArr[5];
        float f8 = fArr[4];
        this.mScaleX = Math.min(Math.max(this.mMinScaleX, f6), this.mMaxScaleX);
        this.mScaleY = Math.min(Math.max(this.mMinScaleY, f8), this.mMaxScaleY);
        float f9 = 0.0f;
        if (rectF != null) {
            f9 = rectF.width();
            f4 = rectF.height();
        } else {
            f4 = 0.0f;
        }
        this.mTransX = Math.min(Math.max(f5, ((-f9) * (this.mScaleX - 1.0f)) - this.mTransOffsetX), this.mTransOffsetX);
        float max = Math.max(Math.min(f7, (f4 * (this.mScaleY - 1.0f)) + this.mTransOffsetY), -this.mTransOffsetY);
        this.mTransY = max;
        float[] fArr2 = this.matrixBuffer;
        fArr2[2] = this.mTransX;
        fArr2[0] = this.mScaleX;
        fArr2[5] = max;
        fArr2[4] = this.mScaleY;
        matrix.setValues(fArr2);
    }

    public float offsetBottom() {
        return this.mChartHeight - this.mContentRect.bottom;
    }

    public float offsetLeft() {
        return this.mContentRect.left;
    }

    public float offsetRight() {
        return this.mChartWidth - this.mContentRect.right;
    }

    public float offsetTop() {
        return this.mContentRect.top;
    }

    public Matrix refresh(Matrix matrix, View view, boolean z3) {
        this.mMatrixTouch.set(matrix);
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
        if (z3) {
            view.invalidate();
        }
        matrix.set(this.mMatrixTouch);
        return matrix;
    }

    public void resetZoom(Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(1.0f, 1.0f, 0.0f, 0.0f);
    }

    public void restrainViewPort(float f4, float f5, float f6, float f7) {
        this.mContentRect.set(f4, f5, this.mChartWidth - f6, this.mChartHeight - f7);
    }

    public void setChartDimens(float f4, float f5) {
        float offsetLeft = offsetLeft();
        float offsetTop = offsetTop();
        float offsetRight = offsetRight();
        float offsetBottom = offsetBottom();
        this.mChartHeight = f5;
        this.mChartWidth = f4;
        restrainViewPort(offsetLeft, offsetTop, offsetRight, offsetBottom);
    }

    public void setDragOffsetX(float f4) {
        this.mTransOffsetX = Utils.convertDpToPixel(f4);
    }

    public void setDragOffsetY(float f4) {
        this.mTransOffsetY = Utils.convertDpToPixel(f4);
    }

    public void setMaximumScaleX(float f4) {
        if (f4 == 0.0f) {
            f4 = Float.MAX_VALUE;
        }
        this.mMaxScaleX = f4;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMaximumScaleY(float f4) {
        if (f4 == 0.0f) {
            f4 = Float.MAX_VALUE;
        }
        this.mMaxScaleY = f4;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinMaxScaleX(float f4, float f5) {
        if (f4 < 1.0f) {
            f4 = 1.0f;
        }
        if (f5 == 0.0f) {
            f5 = Float.MAX_VALUE;
        }
        this.mMinScaleX = f4;
        this.mMaxScaleX = f5;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinMaxScaleY(float f4, float f5) {
        if (f4 < 1.0f) {
            f4 = 1.0f;
        }
        if (f5 == 0.0f) {
            f5 = Float.MAX_VALUE;
        }
        this.mMinScaleY = f4;
        this.mMaxScaleY = f5;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinimumScaleX(float f4) {
        if (f4 < 1.0f) {
            f4 = 1.0f;
        }
        this.mMinScaleX = f4;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinimumScaleY(float f4) {
        if (f4 < 1.0f) {
            f4 = 1.0f;
        }
        this.mMinScaleY = f4;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public Matrix setZoom(float f4, float f5) {
        Matrix matrix = new Matrix();
        setZoom(f4, f5, matrix);
        return matrix;
    }

    public Matrix translate(float[] fArr) {
        Matrix matrix = new Matrix();
        translate(fArr, matrix);
        return matrix;
    }

    public Matrix zoom(float f4, float f5) {
        Matrix matrix = new Matrix();
        zoom(f4, f5, matrix);
        return matrix;
    }

    public Matrix zoomIn(float f4, float f5) {
        Matrix matrix = new Matrix();
        zoomIn(f4, f5, matrix);
        return matrix;
    }

    public Matrix zoomOut(float f4, float f5) {
        Matrix matrix = new Matrix();
        zoomOut(f4, f5, matrix);
        return matrix;
    }

    public void fitScreen(Matrix matrix) {
        this.mMinScaleX = 1.0f;
        this.mMinScaleY = 1.0f;
        matrix.set(this.mMatrixTouch);
        float[] fArr = this.valsBufferForFitScreen;
        for (int i4 = 0; i4 < 9; i4++) {
            fArr[i4] = 0.0f;
        }
        matrix.getValues(fArr);
        fArr[2] = 0.0f;
        fArr[5] = 0.0f;
        fArr[0] = 1.0f;
        fArr[4] = 1.0f;
        matrix.setValues(fArr);
    }

    public void setZoom(float f4, float f5, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.setScale(f4, f5);
    }

    public void translate(float[] fArr, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postTranslate(-(fArr[0] - offsetLeft()), -(fArr[1] - offsetTop()));
    }

    public void zoom(float f4, float f5, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(f4, f5);
    }

    public void zoomIn(float f4, float f5, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(1.4f, 1.4f, f4, f5);
    }

    public void zoomOut(float f4, float f5, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(0.7f, 0.7f, f4, f5);
    }

    public Matrix setZoom(float f4, float f5, float f6, float f7) {
        Matrix matrix = new Matrix();
        matrix.set(this.mMatrixTouch);
        matrix.setScale(f4, f5, f6, f7);
        return matrix;
    }

    public Matrix zoom(float f4, float f5, float f6, float f7) {
        Matrix matrix = new Matrix();
        zoom(f4, f5, f6, f7, matrix);
        return matrix;
    }

    public void zoom(float f4, float f5, float f6, float f7, Matrix matrix) {
        matrix.reset();
        matrix.set(this.mMatrixTouch);
        matrix.postScale(f4, f5, f6, f7);
    }
}
