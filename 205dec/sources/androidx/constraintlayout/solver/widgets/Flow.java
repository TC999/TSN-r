package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mDisplayedWidgets;
    private int mHorizontalStyle = -1;
    private int mVerticalStyle = -1;
    private int mFirstHorizontalStyle = -1;
    private int mFirstVerticalStyle = -1;
    private int mLastHorizontalStyle = -1;
    private int mLastVerticalStyle = -1;
    private float mHorizontalBias = 0.5f;
    private float mVerticalBias = 0.5f;
    private float mFirstHorizontalBias = 0.5f;
    private float mFirstVerticalBias = 0.5f;
    private float mLastHorizontalBias = 0.5f;
    private float mLastVerticalBias = 0.5f;
    private int mHorizontalGap = 0;
    private int mVerticalGap = 0;
    private int mHorizontalAlign = 2;
    private int mVerticalAlign = 2;
    private int mWrapMode = 0;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private int[] mAlignedDimensions = null;
    private int mDisplayedWidgetsCount = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class WidgetsList {
        private ConstraintAnchor mBottom;
        private ConstraintAnchor mLeft;
        private int mMax;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private ConstraintAnchor mTop;
        private ConstraintWidget biggest = null;
        int biggestDimension = 0;
        private int mWidth = 0;
        private int mHeight = 0;
        private int mStartIndex = 0;
        private int mCount = 0;
        private int mNbMatchConstraintsWidgets = 0;

        public WidgetsList(int i4, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i5) {
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mMax = 0;
            this.mOrientation = i4;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
            this.mMax = i5;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            int i4 = this.mCount;
            for (int i5 = 0; i5 < i4 && this.mStartIndex + i5 < Flow.this.mDisplayedWidgetsCount; i5++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i5];
                if (this.mOrientation == 0) {
                    int width = constraintWidget.getWidth();
                    int i6 = Flow.this.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i6 = 0;
                    }
                    this.mWidth += width + i6;
                    int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.biggest == null || this.biggestDimension < widgetHeight) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetHeight;
                        this.mHeight = widgetHeight;
                    }
                } else {
                    int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                    int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    int i7 = Flow.this.mVerticalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i7 = 0;
                    }
                    this.mHeight += widgetHeight2 + i7;
                    if (this.biggest == null || this.biggestDimension < widgetWidth) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetWidth;
                        this.mWidth = widgetWidth;
                    }
                }
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            if (this.mOrientation == 0) {
                int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetWidth = 0;
                }
                this.mWidth += widgetWidth + (constraintWidget.getVisibility() != 8 ? Flow.this.mHorizontalGap : 0);
                int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (this.biggest == null || this.biggestDimension < widgetHeight) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetHeight;
                    this.mHeight = widgetHeight;
                }
            } else {
                int widgetWidth2 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetHeight2 = 0;
                }
                this.mHeight += widgetHeight2 + (constraintWidget.getVisibility() != 8 ? Flow.this.mVerticalGap : 0);
                if (this.biggest == null || this.biggestDimension < widgetWidth2) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetWidth2;
                    this.mWidth = widgetWidth2;
                }
            }
            this.mCount++;
        }

        public void clear() {
            this.biggestDimension = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        public void createConstraints(boolean z3, int i4, boolean z4) {
            ConstraintWidget constraintWidget;
            int i5 = this.mCount;
            for (int i6 = 0; i6 < i5 && this.mStartIndex + i6 < Flow.this.mDisplayedWidgetsCount; i6++) {
                ConstraintWidget constraintWidget2 = Flow.this.mDisplayedWidgets[this.mStartIndex + i6];
                if (constraintWidget2 != null) {
                    constraintWidget2.resetAnchors();
                }
            }
            if (i5 == 0 || this.biggest == null) {
                return;
            }
            boolean z5 = z4 && i4 == 0;
            int i7 = -1;
            int i8 = -1;
            for (int i9 = 0; i9 < i5; i9++) {
                int i10 = z3 ? (i5 - 1) - i9 : i9;
                if (this.mStartIndex + i10 >= Flow.this.mDisplayedWidgetsCount) {
                    break;
                }
                if (Flow.this.mDisplayedWidgets[this.mStartIndex + i10].getVisibility() == 0) {
                    if (i7 == -1) {
                        i7 = i9;
                    }
                    i8 = i9;
                }
            }
            ConstraintWidget constraintWidget3 = null;
            if (this.mOrientation == 0) {
                ConstraintWidget constraintWidget4 = this.biggest;
                constraintWidget4.setVerticalChainStyle(Flow.this.mVerticalStyle);
                int i11 = this.mPaddingTop;
                if (i4 > 0) {
                    i11 += Flow.this.mVerticalGap;
                }
                constraintWidget4.mTop.connect(this.mTop, i11);
                if (z4) {
                    constraintWidget4.mBottom.connect(this.mBottom, this.mPaddingBottom);
                }
                if (i4 > 0) {
                    this.mTop.mOwner.mBottom.connect(constraintWidget4.mTop, 0);
                }
                if (Flow.this.mVerticalAlign == 3 && !constraintWidget4.hasBaseline()) {
                    for (int i12 = 0; i12 < i5; i12++) {
                        int i13 = z3 ? (i5 - 1) - i12 : i12;
                        if (this.mStartIndex + i13 >= Flow.this.mDisplayedWidgetsCount) {
                            break;
                        }
                        constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i13];
                        if (constraintWidget.hasBaseline()) {
                            break;
                        }
                    }
                }
                constraintWidget = constraintWidget4;
                int i14 = 0;
                while (i14 < i5) {
                    int i15 = z3 ? (i5 - 1) - i14 : i14;
                    if (this.mStartIndex + i15 >= Flow.this.mDisplayedWidgetsCount) {
                        return;
                    }
                    ConstraintWidget constraintWidget5 = Flow.this.mDisplayedWidgets[this.mStartIndex + i15];
                    if (i14 == 0) {
                        constraintWidget5.connect(constraintWidget5.mLeft, this.mLeft, this.mPaddingLeft);
                    }
                    if (i15 == 0) {
                        int i16 = Flow.this.mHorizontalStyle;
                        float f4 = Flow.this.mHorizontalBias;
                        if (this.mStartIndex == 0 && Flow.this.mFirstHorizontalStyle != -1) {
                            i16 = Flow.this.mFirstHorizontalStyle;
                            f4 = Flow.this.mFirstHorizontalBias;
                        } else if (z4 && Flow.this.mLastHorizontalStyle != -1) {
                            i16 = Flow.this.mLastHorizontalStyle;
                            f4 = Flow.this.mLastHorizontalBias;
                        }
                        constraintWidget5.setHorizontalChainStyle(i16);
                        constraintWidget5.setHorizontalBiasPercent(f4);
                    }
                    if (i14 == i5 - 1) {
                        constraintWidget5.connect(constraintWidget5.mRight, this.mRight, this.mPaddingRight);
                    }
                    if (constraintWidget3 != null) {
                        constraintWidget5.mLeft.connect(constraintWidget3.mRight, Flow.this.mHorizontalGap);
                        if (i14 == i7) {
                            constraintWidget5.mLeft.setGoneMargin(this.mPaddingLeft);
                        }
                        constraintWidget3.mRight.connect(constraintWidget5.mLeft, 0);
                        if (i14 == i8 + 1) {
                            constraintWidget3.mRight.setGoneMargin(this.mPaddingRight);
                        }
                    }
                    if (constraintWidget5 != constraintWidget4) {
                        if (Flow.this.mVerticalAlign == 3 && constraintWidget.hasBaseline() && constraintWidget5 != constraintWidget && constraintWidget5.hasBaseline()) {
                            constraintWidget5.mBaseline.connect(constraintWidget.mBaseline, 0);
                        } else {
                            int i17 = Flow.this.mVerticalAlign;
                            if (i17 == 0) {
                                constraintWidget5.mTop.connect(constraintWidget4.mTop, 0);
                            } else if (i17 == 1) {
                                constraintWidget5.mBottom.connect(constraintWidget4.mBottom, 0);
                            } else if (z5) {
                                constraintWidget5.mTop.connect(this.mTop, this.mPaddingTop);
                                constraintWidget5.mBottom.connect(this.mBottom, this.mPaddingBottom);
                            } else {
                                constraintWidget5.mTop.connect(constraintWidget4.mTop, 0);
                                constraintWidget5.mBottom.connect(constraintWidget4.mBottom, 0);
                            }
                        }
                    }
                    i14++;
                    constraintWidget3 = constraintWidget5;
                }
                return;
            }
            ConstraintWidget constraintWidget6 = this.biggest;
            constraintWidget6.setHorizontalChainStyle(Flow.this.mHorizontalStyle);
            int i18 = this.mPaddingLeft;
            if (i4 > 0) {
                i18 += Flow.this.mHorizontalGap;
            }
            if (z3) {
                constraintWidget6.mRight.connect(this.mRight, i18);
                if (z4) {
                    constraintWidget6.mLeft.connect(this.mLeft, this.mPaddingRight);
                }
                if (i4 > 0) {
                    this.mRight.mOwner.mLeft.connect(constraintWidget6.mRight, 0);
                }
            } else {
                constraintWidget6.mLeft.connect(this.mLeft, i18);
                if (z4) {
                    constraintWidget6.mRight.connect(this.mRight, this.mPaddingRight);
                }
                if (i4 > 0) {
                    this.mLeft.mOwner.mRight.connect(constraintWidget6.mLeft, 0);
                }
            }
            int i19 = 0;
            while (i19 < i5 && this.mStartIndex + i19 < Flow.this.mDisplayedWidgetsCount) {
                ConstraintWidget constraintWidget7 = Flow.this.mDisplayedWidgets[this.mStartIndex + i19];
                if (i19 == 0) {
                    constraintWidget7.connect(constraintWidget7.mTop, this.mTop, this.mPaddingTop);
                    int i20 = Flow.this.mVerticalStyle;
                    float f5 = Flow.this.mVerticalBias;
                    if (this.mStartIndex == 0 && Flow.this.mFirstVerticalStyle != -1) {
                        i20 = Flow.this.mFirstVerticalStyle;
                        f5 = Flow.this.mFirstVerticalBias;
                    } else if (z4 && Flow.this.mLastVerticalStyle != -1) {
                        i20 = Flow.this.mLastVerticalStyle;
                        f5 = Flow.this.mLastVerticalBias;
                    }
                    constraintWidget7.setVerticalChainStyle(i20);
                    constraintWidget7.setVerticalBiasPercent(f5);
                }
                if (i19 == i5 - 1) {
                    constraintWidget7.connect(constraintWidget7.mBottom, this.mBottom, this.mPaddingBottom);
                }
                if (constraintWidget3 != null) {
                    constraintWidget7.mTop.connect(constraintWidget3.mBottom, Flow.this.mVerticalGap);
                    if (i19 == i7) {
                        constraintWidget7.mTop.setGoneMargin(this.mPaddingTop);
                    }
                    constraintWidget3.mBottom.connect(constraintWidget7.mTop, 0);
                    if (i19 == i8 + 1) {
                        constraintWidget3.mBottom.setGoneMargin(this.mPaddingBottom);
                    }
                }
                if (constraintWidget7 != constraintWidget6) {
                    if (z3) {
                        int i21 = Flow.this.mHorizontalAlign;
                        if (i21 == 0) {
                            constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                        } else if (i21 == 1) {
                            constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                        } else if (i21 == 2) {
                            constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                            constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                        }
                    } else {
                        int i22 = Flow.this.mHorizontalAlign;
                        if (i22 == 0) {
                            constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                        } else if (i22 == 1) {
                            constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                        } else if (i22 == 2) {
                            if (z5) {
                                constraintWidget7.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                constraintWidget7.mRight.connect(this.mRight, this.mPaddingRight);
                            } else {
                                constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                                constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                            }
                        }
                        i19++;
                        constraintWidget3 = constraintWidget7;
                    }
                }
                i19++;
                constraintWidget3 = constraintWidget7;
            }
        }

        public int getHeight() {
            if (this.mOrientation == 1) {
                return this.mHeight - Flow.this.mVerticalGap;
            }
            return this.mHeight;
        }

        public int getWidth() {
            if (this.mOrientation == 0) {
                return this.mWidth - Flow.this.mHorizontalGap;
            }
            return this.mWidth;
        }

        public void measureMatchConstraints(int i4) {
            int i5 = this.mNbMatchConstraintsWidgets;
            if (i5 == 0) {
                return;
            }
            int i6 = this.mCount;
            int i7 = i4 / i5;
            for (int i8 = 0; i8 < i6 && this.mStartIndex + i8 < Flow.this.mDisplayedWidgetsCount; i8++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i8];
                if (this.mOrientation == 0) {
                    if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                        Flow.this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i7, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    }
                } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i7);
                }
            }
            recomputeDimensions();
        }

        public void setStartIndex(int i4) {
            this.mStartIndex = i4;
        }

        public void setup(int i4, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i5, int i6, int i7, int i8, int i9) {
            this.mOrientation = i4;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i5;
            this.mPaddingTop = i6;
            this.mPaddingRight = i7;
            this.mPaddingBottom = i8;
            this.mMax = i9;
        }
    }

    private void createAlignedConstraints(boolean z3) {
        ConstraintWidget constraintWidget;
        if (this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null) {
            return;
        }
        for (int i4 = 0; i4 < this.mDisplayedWidgetsCount; i4++) {
            this.mDisplayedWidgets[i4].resetAnchors();
        }
        int[] iArr = this.mAlignedDimensions;
        int i5 = iArr[0];
        int i6 = iArr[1];
        ConstraintWidget constraintWidget2 = null;
        for (int i7 = 0; i7 < i5; i7++) {
            ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[z3 ? (i5 - i7) - 1 : i7];
            if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                if (i7 == 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                    constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                    constraintWidget3.setHorizontalBiasPercent(this.mHorizontalBias);
                }
                if (i7 == i5 - 1) {
                    constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                }
                if (i7 > 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                    constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
        }
        for (int i8 = 0; i8 < i6; i8++) {
            ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i8];
            if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                if (i8 == 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                    constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                    constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                }
                if (i8 == i6 - 1) {
                    constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                }
                if (i8 > 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                    constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i9 = 0; i9 < i5; i9++) {
            for (int i10 = 0; i10 < i6; i10++) {
                int i11 = (i10 * i5) + i9;
                if (this.mOrientation == 1) {
                    i11 = (i9 * i6) + i10;
                }
                ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                if (i11 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i11]) != null && constraintWidget.getVisibility() != 8) {
                    ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i9];
                    ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i10];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                        constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                        constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetHeight(ConstraintWidget constraintWidget, int i4) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i5 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i5 == 0) {
                return 0;
            }
            if (i5 == 2) {
                int i6 = (int) (constraintWidget.mMatchConstraintPercentHeight * i4);
                if (i6 != constraintWidget.getHeight()) {
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i6);
                }
                return i6;
            } else if (i5 == 1) {
                return constraintWidget.getHeight();
            } else {
                if (i5 == 3) {
                    return (int) ((constraintWidget.getWidth() * constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
        }
        return constraintWidget.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetWidth(ConstraintWidget constraintWidget, int i4) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i5 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i5 == 0) {
                return 0;
            }
            if (i5 == 2) {
                int i6 = (int) (constraintWidget.mMatchConstraintPercentWidth * i4);
                if (i6 != constraintWidget.getWidth()) {
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i6, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i6;
            } else if (i5 == 1) {
                return constraintWidget.getWidth();
            } else {
                if (i5 == 3) {
                    return (int) ((constraintWidget.getHeight() * constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
        }
        return constraintWidget.getWidth();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0068  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x011b -> B:42:0x0063). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x011d -> B:42:0x0063). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0123 -> B:42:0x0063). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0125 -> B:42:0x0063). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void measureAligned(androidx.constraintlayout.solver.widgets.ConstraintWidget[] r17, int r18, int r19, int r20, int[] r21) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Flow.measureAligned(androidx.constraintlayout.solver.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i4, int i5, int i6, int[] iArr) {
        int i7;
        int i8;
        int i9;
        ConstraintAnchor constraintAnchor;
        int paddingRight;
        ConstraintAnchor constraintAnchor2;
        int paddingBottom;
        int i10;
        if (i4 == 0) {
            return;
        }
        this.mChainList.clear();
        WidgetsList widgetsList = new WidgetsList(i5, this.mLeft, this.mTop, this.mRight, this.mBottom, i6);
        this.mChainList.add(widgetsList);
        if (i5 == 0) {
            i7 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i12 < i4) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i12];
                int widgetWidth = getWidgetWidth(constraintWidget, i6);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i7++;
                }
                int i13 = i7;
                boolean z3 = (i11 == i6 || (this.mHorizontalGap + i11) + widgetWidth > i6) && widgetsList.biggest != null;
                if (!z3 && i12 > 0 && (i10 = this.mMaxElementsWrap) > 0 && i12 % i10 == 0) {
                    z3 = true;
                }
                if (z3) {
                    widgetsList = new WidgetsList(i5, this.mLeft, this.mTop, this.mRight, this.mBottom, i6);
                    widgetsList.setStartIndex(i12);
                    this.mChainList.add(widgetsList);
                } else if (i12 > 0) {
                    i11 += this.mHorizontalGap + widgetWidth;
                    widgetsList.add(constraintWidget);
                    i12++;
                    i7 = i13;
                }
                i11 = widgetWidth;
                widgetsList.add(constraintWidget);
                i12++;
                i7 = i13;
            }
        } else {
            i7 = 0;
            int i14 = 0;
            int i15 = 0;
            while (i15 < i4) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i15];
                int widgetHeight = getWidgetHeight(constraintWidget2, i6);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i7++;
                }
                int i16 = i7;
                boolean z4 = (i14 == i6 || (this.mVerticalGap + i14) + widgetHeight > i6) && widgetsList.biggest != null;
                if (!z4 && i15 > 0 && (i8 = this.mMaxElementsWrap) > 0 && i15 % i8 == 0) {
                    z4 = true;
                }
                if (z4) {
                    widgetsList = new WidgetsList(i5, this.mLeft, this.mTop, this.mRight, this.mBottom, i6);
                    widgetsList.setStartIndex(i15);
                    this.mChainList.add(widgetsList);
                } else if (i15 > 0) {
                    i14 += this.mVerticalGap + widgetHeight;
                    widgetsList.add(constraintWidget2);
                    i15++;
                    i7 = i16;
                }
                i14 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i15++;
                i7 = i16;
            }
        }
        int size = this.mChainList.size();
        ConstraintAnchor constraintAnchor3 = this.mLeft;
        ConstraintAnchor constraintAnchor4 = this.mTop;
        ConstraintAnchor constraintAnchor5 = this.mRight;
        ConstraintAnchor constraintAnchor6 = this.mBottom;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight2 = getPaddingRight();
        int paddingBottom2 = getPaddingBottom();
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z5 = horizontalDimensionBehaviour == dimensionBehaviour || getVerticalDimensionBehaviour() == dimensionBehaviour;
        if (i7 > 0 && z5) {
            for (int i17 = 0; i17 < size; i17++) {
                WidgetsList widgetsList2 = this.mChainList.get(i17);
                if (i5 == 0) {
                    widgetsList2.measureMatchConstraints(i6 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i6 - widgetsList2.getHeight());
                }
            }
        }
        int i18 = paddingTop;
        int i19 = paddingRight2;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor4;
        ConstraintAnchor constraintAnchor8 = constraintAnchor3;
        int i24 = paddingBottom2;
        while (i22 < size) {
            WidgetsList widgetsList3 = this.mChainList.get(i22);
            if (i5 == 0) {
                if (i22 < size - 1) {
                    constraintAnchor2 = this.mChainList.get(i22 + 1).biggest.mTop;
                    paddingBottom = 0;
                } else {
                    constraintAnchor2 = this.mBottom;
                    paddingBottom = getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor9 = widgetsList3.biggest.mBottom;
                ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                int i25 = i20;
                ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                int i26 = i21;
                ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                i9 = i22;
                widgetsList3.setup(i5, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i23, i18, i19, paddingBottom, i6);
                int max = Math.max(i26, widgetsList3.getWidth());
                i20 = i25 + widgetsList3.getHeight();
                if (i9 > 0) {
                    i20 += this.mVerticalGap;
                }
                constraintAnchor8 = constraintAnchor11;
                i21 = max;
                constraintAnchor7 = constraintAnchor9;
                i18 = 0;
                constraintAnchor = constraintAnchor14;
                int i27 = paddingBottom;
                constraintAnchor6 = constraintAnchor2;
                i24 = i27;
            } else {
                ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                int i28 = i20;
                int i29 = i21;
                i9 = i22;
                if (i9 < size - 1) {
                    constraintAnchor = this.mChainList.get(i9 + 1).biggest.mLeft;
                    paddingRight = 0;
                } else {
                    constraintAnchor = this.mRight;
                    paddingRight = getPaddingRight();
                }
                ConstraintAnchor constraintAnchor16 = widgetsList3.biggest.mRight;
                widgetsList3.setup(i5, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i23, i18, paddingRight, i24, i6);
                i21 = i29 + widgetsList3.getWidth();
                int max2 = Math.max(i28, widgetsList3.getHeight());
                if (i9 > 0) {
                    i21 += this.mHorizontalGap;
                }
                i20 = max2;
                i19 = paddingRight;
                constraintAnchor8 = constraintAnchor16;
                i23 = 0;
            }
            i22 = i9 + 1;
            constraintAnchor5 = constraintAnchor;
        }
        iArr[0] = i21;
        iArr[1] = i20;
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i4, int i5, int i6, int[] iArr) {
        WidgetsList widgetsList;
        if (i4 == 0) {
            return;
        }
        if (this.mChainList.size() == 0) {
            widgetsList = new WidgetsList(i5, this.mLeft, this.mTop, this.mRight, this.mBottom, i6);
            this.mChainList.add(widgetsList);
        } else {
            WidgetsList widgetsList2 = this.mChainList.get(0);
            widgetsList2.clear();
            widgetsList = widgetsList2;
            widgetsList.setup(i5, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i6);
        }
        for (int i7 = 0; i7 < i4; i7++) {
            widgetsList.add(constraintWidgetArr[i7]);
        }
        iArr[0] = widgetsList.getWidth();
        iArr[1] = widgetsList.getHeight();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        super.addToSolver(linearSystem);
        boolean isRtl = getParent() != null ? ((ConstraintWidgetContainer) getParent()).isRtl() : false;
        int i4 = this.mWrapMode;
        if (i4 != 0) {
            if (i4 == 1) {
                int size = this.mChainList.size();
                int i5 = 0;
                while (i5 < size) {
                    this.mChainList.get(i5).createConstraints(isRtl, i5, i5 == size + (-1));
                    i5++;
                }
            } else if (i4 == 2) {
                createAlignedConstraints(isRtl);
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(isRtl, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0104  */
    @Override // androidx.constraintlayout.solver.widgets.VirtualLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void measure(int r19, int r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Flow.measure(int, int, int, int):void");
    }

    public void setFirstHorizontalBias(float f4) {
        this.mFirstHorizontalBias = f4;
    }

    public void setFirstHorizontalStyle(int i4) {
        this.mFirstHorizontalStyle = i4;
    }

    public void setFirstVerticalBias(float f4) {
        this.mFirstVerticalBias = f4;
    }

    public void setFirstVerticalStyle(int i4) {
        this.mFirstVerticalStyle = i4;
    }

    public void setHorizontalAlign(int i4) {
        this.mHorizontalAlign = i4;
    }

    public void setHorizontalBias(float f4) {
        this.mHorizontalBias = f4;
    }

    public void setHorizontalGap(int i4) {
        this.mHorizontalGap = i4;
    }

    public void setHorizontalStyle(int i4) {
        this.mHorizontalStyle = i4;
    }

    public void setLastHorizontalBias(float f4) {
        this.mLastHorizontalBias = f4;
    }

    public void setLastHorizontalStyle(int i4) {
        this.mLastHorizontalStyle = i4;
    }

    public void setLastVerticalBias(float f4) {
        this.mLastVerticalBias = f4;
    }

    public void setLastVerticalStyle(int i4) {
        this.mLastVerticalStyle = i4;
    }

    public void setMaxElementsWrap(int i4) {
        this.mMaxElementsWrap = i4;
    }

    public void setOrientation(int i4) {
        this.mOrientation = i4;
    }

    public void setVerticalAlign(int i4) {
        this.mVerticalAlign = i4;
    }

    public void setVerticalBias(float f4) {
        this.mVerticalBias = f4;
    }

    public void setVerticalGap(int i4) {
        this.mVerticalGap = i4;
    }

    public void setVerticalStyle(int i4) {
        this.mVerticalStyle = i4;
    }

    public void setWrapMode(int i4) {
        this.mWrapMode = i4;
    }
}
