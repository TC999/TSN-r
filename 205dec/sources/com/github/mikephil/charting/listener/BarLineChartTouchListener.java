package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class BarLineChartTouchListener extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>>> {
    private IDataSet mClosestDataSetToTouch;
    private MPPointF mDecelerationCurrentPoint;
    private long mDecelerationLastTime;
    private MPPointF mDecelerationVelocity;
    private float mDragTriggerDist;
    private Matrix mMatrix;
    private float mMinScalePointerDistance;
    private float mSavedDist;
    private Matrix mSavedMatrix;
    private float mSavedXDist;
    private float mSavedYDist;
    private MPPointF mTouchPointCenter;
    private MPPointF mTouchStartPoint;
    private VelocityTracker mVelocityTracker;

    public BarLineChartTouchListener(BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> barLineChartBase, Matrix matrix, float f4) {
        super(barLineChartBase);
        this.mMatrix = new Matrix();
        this.mSavedMatrix = new Matrix();
        this.mTouchStartPoint = MPPointF.getInstance(0.0f, 0.0f);
        this.mTouchPointCenter = MPPointF.getInstance(0.0f, 0.0f);
        this.mSavedXDist = 1.0f;
        this.mSavedYDist = 1.0f;
        this.mSavedDist = 1.0f;
        this.mDecelerationLastTime = 0L;
        this.mDecelerationCurrentPoint = MPPointF.getInstance(0.0f, 0.0f);
        this.mDecelerationVelocity = MPPointF.getInstance(0.0f, 0.0f);
        this.mMatrix = matrix;
        this.mDragTriggerDist = Utils.convertDpToPixel(f4);
        this.mMinScalePointerDistance = Utils.convertDpToPixel(3.5f);
    }

    private static float getXDist(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    private static float getYDist(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    private boolean inverted() {
        IDataSet iDataSet;
        return (this.mClosestDataSetToTouch == null && ((BarLineChartBase) this.mChart).isAnyAxisInverted()) || ((iDataSet = this.mClosestDataSetToTouch) != null && ((BarLineChartBase) this.mChart).isInverted(iDataSet.getAxisDependency()));
    }

    private static void midPoint(MPPointF mPPointF, MotionEvent motionEvent) {
        mPPointF.f37332x = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
        mPPointF.f37333y = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
    }

    private void performDrag(MotionEvent motionEvent, float f4, float f5) {
        this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
        this.mMatrix.set(this.mSavedMatrix);
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (inverted()) {
            if (this.mChart instanceof HorizontalBarChart) {
                f4 = -f4;
            } else {
                f5 = -f5;
            }
        }
        this.mMatrix.postTranslate(f4, f5);
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartTranslate(motionEvent, f4, f5);
        }
    }

    private void performHighlightDrag(MotionEvent motionEvent) {
        Highlight highlightByTouchPoint = ((BarLineChartBase) this.mChart).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY());
        if (highlightByTouchPoint == null || highlightByTouchPoint.equalTo(this.mLastHighlighted)) {
            return;
        }
        this.mLastHighlighted = highlightByTouchPoint;
        ((BarLineChartBase) this.mChart).highlightValue(highlightByTouchPoint, true);
    }

    private void performZoom(MotionEvent motionEvent) {
        boolean canZoomInMoreY;
        boolean canZoomInMoreX;
        boolean canZoomInMoreX2;
        boolean canZoomInMoreY2;
        if (motionEvent.getPointerCount() >= 2) {
            OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
            float spacing = spacing(motionEvent);
            if (spacing > this.mMinScalePointerDistance) {
                MPPointF mPPointF = this.mTouchPointCenter;
                MPPointF trans = getTrans(mPPointF.f37332x, mPPointF.f37333y);
                ViewPortHandler viewPortHandler = ((BarLineChartBase) this.mChart).getViewPortHandler();
                int i4 = this.mTouchMode;
                if (i4 == 4) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.PINCH_ZOOM;
                    float f4 = spacing / this.mSavedDist;
                    boolean z3 = f4 < 1.0f;
                    if (z3) {
                        canZoomInMoreX2 = viewPortHandler.canZoomOutMoreX();
                    } else {
                        canZoomInMoreX2 = viewPortHandler.canZoomInMoreX();
                    }
                    if (z3) {
                        canZoomInMoreY2 = viewPortHandler.canZoomOutMoreY();
                    } else {
                        canZoomInMoreY2 = viewPortHandler.canZoomInMoreY();
                    }
                    float f5 = ((BarLineChartBase) this.mChart).isScaleXEnabled() ? f4 : 1.0f;
                    float f6 = ((BarLineChartBase) this.mChart).isScaleYEnabled() ? f4 : 1.0f;
                    if (canZoomInMoreY2 || canZoomInMoreX2) {
                        this.mMatrix.set(this.mSavedMatrix);
                        this.mMatrix.postScale(f5, f6, trans.f37332x, trans.f37333y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, f5, f6);
                        }
                    }
                } else if (i4 == 2 && ((BarLineChartBase) this.mChart).isScaleXEnabled()) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.X_ZOOM;
                    float xDist = getXDist(motionEvent) / this.mSavedXDist;
                    if (xDist < 1.0f) {
                        canZoomInMoreX = viewPortHandler.canZoomOutMoreX();
                    } else {
                        canZoomInMoreX = viewPortHandler.canZoomInMoreX();
                    }
                    if (canZoomInMoreX) {
                        this.mMatrix.set(this.mSavedMatrix);
                        this.mMatrix.postScale(xDist, 1.0f, trans.f37332x, trans.f37333y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, xDist, 1.0f);
                        }
                    }
                } else if (this.mTouchMode == 3 && ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.Y_ZOOM;
                    float yDist = getYDist(motionEvent) / this.mSavedYDist;
                    if (yDist < 1.0f) {
                        canZoomInMoreY = viewPortHandler.canZoomOutMoreY();
                    } else {
                        canZoomInMoreY = viewPortHandler.canZoomInMoreY();
                    }
                    if (canZoomInMoreY) {
                        this.mMatrix.set(this.mSavedMatrix);
                        this.mMatrix.postScale(1.0f, yDist, trans.f37332x, trans.f37333y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, 1.0f, yDist);
                        }
                    }
                }
                MPPointF.recycleInstance(trans);
            }
        }
    }

    private void saveTouchStart(MotionEvent motionEvent) {
        this.mSavedMatrix.set(this.mMatrix);
        this.mTouchStartPoint.f37332x = motionEvent.getX();
        this.mTouchStartPoint.f37333y = motionEvent.getY();
        this.mClosestDataSetToTouch = ((BarLineChartBase) this.mChart).getDataSetByTouchPoint(motionEvent.getX(), motionEvent.getY());
    }

    private static float spacing(MotionEvent motionEvent) {
        float x3 = motionEvent.getX(0) - motionEvent.getX(1);
        float y3 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x3 * x3) + (y3 * y3));
    }

    public void computeScroll() {
        MPPointF mPPointF = this.mDecelerationVelocity;
        if (mPPointF.f37332x == 0.0f && mPPointF.f37333y == 0.0f) {
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.mDecelerationVelocity.f37332x *= ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef();
        this.mDecelerationVelocity.f37333y *= ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef();
        float f4 = ((float) (currentAnimationTimeMillis - this.mDecelerationLastTime)) / 1000.0f;
        MPPointF mPPointF2 = this.mDecelerationVelocity;
        float f5 = mPPointF2.f37332x * f4;
        float f6 = mPPointF2.f37333y * f4;
        MPPointF mPPointF3 = this.mDecelerationCurrentPoint;
        float f7 = mPPointF3.f37332x + f5;
        mPPointF3.f37332x = f7;
        float f8 = mPPointF3.f37333y + f6;
        mPPointF3.f37333y = f8;
        MotionEvent obtain = MotionEvent.obtain(currentAnimationTimeMillis, currentAnimationTimeMillis, 2, f7, f8, 0);
        performDrag(obtain, ((BarLineChartBase) this.mChart).isDragXEnabled() ? this.mDecelerationCurrentPoint.f37332x - this.mTouchStartPoint.f37332x : 0.0f, ((BarLineChartBase) this.mChart).isDragYEnabled() ? this.mDecelerationCurrentPoint.f37333y - this.mTouchStartPoint.f37333y : 0.0f);
        obtain.recycle();
        this.mMatrix = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.mMatrix, this.mChart, false);
        this.mDecelerationLastTime = currentAnimationTimeMillis;
        if (Math.abs(this.mDecelerationVelocity.f37332x) < 0.01d && Math.abs(this.mDecelerationVelocity.f37333y) < 0.01d) {
            ((BarLineChartBase) this.mChart).calculateOffsets();
            ((BarLineChartBase) this.mChart).postInvalidate();
            stopDeceleration();
            return;
        }
        Utils.postInvalidateOnAnimation(this.mChart);
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public MPPointF getTrans(float f4, float f5) {
        float f6;
        ViewPortHandler viewPortHandler = ((BarLineChartBase) this.mChart).getViewPortHandler();
        float offsetLeft = f4 - viewPortHandler.offsetLeft();
        if (inverted()) {
            f6 = -(f5 - viewPortHandler.offsetTop());
        } else {
            f6 = -((((BarLineChartBase) this.mChart).getMeasuredHeight() - f5) - viewPortHandler.offsetBottom());
        }
        return MPPointF.getInstance(offsetLeft, f6);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartDoubleTapped(motionEvent);
        }
        if (((BarLineChartBase) this.mChart).isDoubleTapToZoomEnabled() && ((BarLineScatterCandleBubbleData) ((BarLineChartBase) this.mChart).getData()).getEntryCount() > 0) {
            MPPointF trans = getTrans(motionEvent.getX(), motionEvent.getY());
            Object obj = this.mChart;
            ((BarLineChartBase) obj).zoom(((BarLineChartBase) obj).isScaleXEnabled() ? 1.4f : 1.0f, ((BarLineChartBase) this.mChart).isScaleYEnabled() ? 1.4f : 1.0f, trans.f37332x, trans.f37333y);
            if (((BarLineChartBase) this.mChart).isLogEnabled()) {
                Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + trans.f37332x + ", y: " + trans.f37333y);
            }
            MPPointF.recycleInstance(trans);
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        this.mLastGesture = ChartTouchListener.ChartGesture.FLING;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartFling(motionEvent, motionEvent2, f4, f5);
        }
        return super.onFling(motionEvent, motionEvent2, f4, f5);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartLongPressed(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.mLastGesture = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartSingleTapped(motionEvent);
        }
        if (((BarLineChartBase) this.mChart).isHighlightPerTapEnabled()) {
            performHighlight(((BarLineChartBase) this.mChart).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY()), motionEvent);
            return super.onSingleTapUp(motionEvent);
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (motionEvent.getActionMasked() == 3 && (velocityTracker = this.mVelocityTracker) != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        if (this.mTouchMode == 0) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        if (((BarLineChartBase) this.mChart).isDragEnabled() || ((BarLineChartBase) this.mChart).isScaleXEnabled() || ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                boolean z3 = false;
                if (action == 1) {
                    VelocityTracker velocityTracker2 = this.mVelocityTracker;
                    int pointerId = motionEvent.getPointerId(0);
                    velocityTracker2.computeCurrentVelocity(1000, Utils.getMaximumFlingVelocity());
                    float yVelocity = velocityTracker2.getYVelocity(pointerId);
                    float xVelocity = velocityTracker2.getXVelocity(pointerId);
                    if ((Math.abs(xVelocity) > Utils.getMinimumFlingVelocity() || Math.abs(yVelocity) > Utils.getMinimumFlingVelocity()) && this.mTouchMode == 1 && ((BarLineChartBase) this.mChart).isDragDecelerationEnabled()) {
                        stopDeceleration();
                        this.mDecelerationLastTime = AnimationUtils.currentAnimationTimeMillis();
                        this.mDecelerationCurrentPoint.f37332x = motionEvent.getX();
                        this.mDecelerationCurrentPoint.f37333y = motionEvent.getY();
                        MPPointF mPPointF = this.mDecelerationVelocity;
                        mPPointF.f37332x = xVelocity;
                        mPPointF.f37333y = yVelocity;
                        Utils.postInvalidateOnAnimation(this.mChart);
                    }
                    int i4 = this.mTouchMode;
                    if (i4 == 2 || i4 == 3 || i4 == 4 || i4 == 5) {
                        ((BarLineChartBase) this.mChart).calculateOffsets();
                        ((BarLineChartBase) this.mChart).postInvalidate();
                    }
                    this.mTouchMode = 0;
                    ((BarLineChartBase) this.mChart).enableScroll();
                    VelocityTracker velocityTracker3 = this.mVelocityTracker;
                    if (velocityTracker3 != null) {
                        velocityTracker3.recycle();
                        this.mVelocityTracker = null;
                    }
                    endAction(motionEvent);
                } else if (action == 2) {
                    int i5 = this.mTouchMode;
                    if (i5 == 1) {
                        ((BarLineChartBase) this.mChart).disableScroll();
                        performDrag(motionEvent, ((BarLineChartBase) this.mChart).isDragXEnabled() ? motionEvent.getX() - this.mTouchStartPoint.f37332x : 0.0f, ((BarLineChartBase) this.mChart).isDragYEnabled() ? motionEvent.getY() - this.mTouchStartPoint.f37333y : 0.0f);
                    } else if (i5 != 2 && i5 != 3 && i5 != 4) {
                        if (i5 == 0 && Math.abs(ChartTouchListener.distance(motionEvent.getX(), this.mTouchStartPoint.f37332x, motionEvent.getY(), this.mTouchStartPoint.f37333y)) > this.mDragTriggerDist && ((BarLineChartBase) this.mChart).isDragEnabled()) {
                            if ((((BarLineChartBase) this.mChart).isFullyZoomedOut() && ((BarLineChartBase) this.mChart).hasNoDragOffset()) ? true : true) {
                                float abs = Math.abs(motionEvent.getX() - this.mTouchStartPoint.f37332x);
                                float abs2 = Math.abs(motionEvent.getY() - this.mTouchStartPoint.f37333y);
                                if ((((BarLineChartBase) this.mChart).isDragXEnabled() || abs2 >= abs) && (((BarLineChartBase) this.mChart).isDragYEnabled() || abs2 <= abs)) {
                                    this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                                    this.mTouchMode = 1;
                                }
                            } else if (((BarLineChartBase) this.mChart).isHighlightPerDragEnabled()) {
                                this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                                if (((BarLineChartBase) this.mChart).isHighlightPerDragEnabled()) {
                                    performHighlightDrag(motionEvent);
                                }
                            }
                        }
                    } else {
                        ((BarLineChartBase) this.mChart).disableScroll();
                        if (((BarLineChartBase) this.mChart).isScaleXEnabled() || ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                            performZoom(motionEvent);
                        }
                    }
                } else if (action == 3) {
                    this.mTouchMode = 0;
                    endAction(motionEvent);
                } else if (action != 5) {
                    if (action == 6) {
                        Utils.velocityTrackerPointerUpCleanUpIfNecessary(motionEvent, this.mVelocityTracker);
                        this.mTouchMode = 5;
                    }
                } else if (motionEvent.getPointerCount() >= 2) {
                    ((BarLineChartBase) this.mChart).disableScroll();
                    saveTouchStart(motionEvent);
                    this.mSavedXDist = getXDist(motionEvent);
                    this.mSavedYDist = getYDist(motionEvent);
                    float spacing = spacing(motionEvent);
                    this.mSavedDist = spacing;
                    if (spacing > 10.0f) {
                        if (((BarLineChartBase) this.mChart).isPinchZoomEnabled()) {
                            this.mTouchMode = 4;
                        } else if (((BarLineChartBase) this.mChart).isScaleXEnabled() != ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                            this.mTouchMode = ((BarLineChartBase) this.mChart).isScaleXEnabled() ? 2 : 3;
                        } else {
                            this.mTouchMode = this.mSavedXDist > this.mSavedYDist ? 2 : 3;
                        }
                    }
                    midPoint(this.mTouchPointCenter, motionEvent);
                }
            } else {
                startAction(motionEvent);
                stopDeceleration();
                saveTouchStart(motionEvent);
            }
            this.mMatrix = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.mMatrix, this.mChart, true);
            return true;
        }
        return true;
    }

    public void setDragTriggerDist(float f4) {
        this.mDragTriggerDist = Utils.convertDpToPixel(f4);
    }

    public void stopDeceleration() {
        MPPointF mPPointF = this.mDecelerationVelocity;
        mPPointF.f37332x = 0.0f;
        mPPointF.f37333y = 0.0f;
    }
}
