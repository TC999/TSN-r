package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class Legend extends ComponentBase {
    private List<Boolean> mCalculatedLabelBreakPoints;
    private List<FSize> mCalculatedLabelSizes;
    private List<FSize> mCalculatedLineSizes;
    private LegendDirection mDirection;
    private boolean mDrawInside;
    private LegendEntry[] mEntries;
    private LegendEntry[] mExtraEntries;
    private DashPathEffect mFormLineDashEffect;
    private float mFormLineWidth;
    private float mFormSize;
    private float mFormToTextSpace;
    private LegendHorizontalAlignment mHorizontalAlignment;
    private boolean mIsLegendCustom;
    private float mMaxSizePercent;
    public float mNeededHeight;
    public float mNeededWidth;
    private LegendOrientation mOrientation;
    private LegendForm mShape;
    private float mStackSpace;
    public float mTextHeightMax;
    public float mTextWidthMax;
    private LegendVerticalAlignment mVerticalAlignment;
    private boolean mWordWrapEnabled;
    private float mXEntrySpace;
    private float mYEntrySpace;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* renamed from: com.github.mikephil.charting.components.Legend$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;

        static {
            int[] iArr = new int[LegendOrientation.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = iArr;
            try {
                iArr[LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public enum LegendForm {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public enum LegendHorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public enum LegendOrientation {
        HORIZONTAL,
        VERTICAL
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    public Legend() {
        this.mEntries = new LegendEntry[0];
        this.mIsLegendCustom = false;
        this.mHorizontalAlignment = LegendHorizontalAlignment.LEFT;
        this.mVerticalAlignment = LegendVerticalAlignment.BOTTOM;
        this.mOrientation = LegendOrientation.HORIZONTAL;
        this.mDrawInside = false;
        this.mDirection = LegendDirection.LEFT_TO_RIGHT;
        this.mShape = LegendForm.SQUARE;
        this.mFormSize = 8.0f;
        this.mFormLineWidth = 3.0f;
        this.mFormLineDashEffect = null;
        this.mXEntrySpace = 6.0f;
        this.mYEntrySpace = 0.0f;
        this.mFormToTextSpace = 5.0f;
        this.mStackSpace = 3.0f;
        this.mMaxSizePercent = 0.95f;
        this.mNeededWidth = 0.0f;
        this.mNeededHeight = 0.0f;
        this.mTextHeightMax = 0.0f;
        this.mTextWidthMax = 0.0f;
        this.mWordWrapEnabled = false;
        this.mCalculatedLabelSizes = new ArrayList(16);
        this.mCalculatedLabelBreakPoints = new ArrayList(16);
        this.mCalculatedLineSizes = new ArrayList(16);
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(3.0f);
    }

    public void calculateDimensions(Paint paint, ViewPortHandler viewPortHandler) {
        float f4;
        float f5;
        float f6;
        float convertDpToPixel = Utils.convertDpToPixel(this.mFormSize);
        float convertDpToPixel2 = Utils.convertDpToPixel(this.mStackSpace);
        float convertDpToPixel3 = Utils.convertDpToPixel(this.mFormToTextSpace);
        float convertDpToPixel4 = Utils.convertDpToPixel(this.mXEntrySpace);
        float convertDpToPixel5 = Utils.convertDpToPixel(this.mYEntrySpace);
        boolean z3 = this.mWordWrapEnabled;
        LegendEntry[] legendEntryArr = this.mEntries;
        int length = legendEntryArr.length;
        this.mTextWidthMax = getMaximumEntryWidth(paint);
        this.mTextHeightMax = getMaximumEntryHeight(paint);
        int i4 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[this.mOrientation.ordinal()];
        if (i4 == 1) {
            float lineHeight = Utils.getLineHeight(paint);
            float f7 = 0.0f;
            float f8 = 0.0f;
            float f9 = 0.0f;
            boolean z4 = false;
            for (int i5 = 0; i5 < length; i5++) {
                LegendEntry legendEntry = legendEntryArr[i5];
                boolean z5 = legendEntry.form != LegendForm.NONE;
                float convertDpToPixel6 = Float.isNaN(legendEntry.formSize) ? convertDpToPixel : Utils.convertDpToPixel(legendEntry.formSize);
                String str = legendEntry.label;
                if (!z4) {
                    f9 = 0.0f;
                }
                if (z5) {
                    if (z4) {
                        f9 += convertDpToPixel2;
                    }
                    f9 += convertDpToPixel6;
                }
                if (str != null) {
                    if (z5 && !z4) {
                        f9 += convertDpToPixel3;
                    } else if (z4) {
                        f7 = Math.max(f7, f9);
                        f8 += lineHeight + convertDpToPixel5;
                        f9 = 0.0f;
                        z4 = false;
                    }
                    f9 += Utils.calcTextWidth(paint, str);
                    if (i5 < length - 1) {
                        f8 += lineHeight + convertDpToPixel5;
                    }
                } else {
                    f9 += convertDpToPixel6;
                    if (i5 < length - 1) {
                        f9 += convertDpToPixel2;
                    }
                    z4 = true;
                }
                f7 = Math.max(f7, f9);
            }
            this.mNeededWidth = f7;
            this.mNeededHeight = f8;
        } else if (i4 == 2) {
            float lineHeight2 = Utils.getLineHeight(paint);
            float lineSpacing = Utils.getLineSpacing(paint) + convertDpToPixel5;
            float contentWidth = viewPortHandler.contentWidth() * this.mMaxSizePercent;
            this.mCalculatedLabelBreakPoints.clear();
            this.mCalculatedLabelSizes.clear();
            this.mCalculatedLineSizes.clear();
            int i6 = 0;
            float f10 = 0.0f;
            int i7 = -1;
            float f11 = 0.0f;
            float f12 = 0.0f;
            while (i6 < length) {
                LegendEntry legendEntry2 = legendEntryArr[i6];
                float f13 = convertDpToPixel;
                float f14 = convertDpToPixel4;
                boolean z6 = legendEntry2.form != LegendForm.NONE;
                float convertDpToPixel7 = Float.isNaN(legendEntry2.formSize) ? f13 : Utils.convertDpToPixel(legendEntry2.formSize);
                String str2 = legendEntry2.label;
                LegendEntry[] legendEntryArr2 = legendEntryArr;
                float f15 = lineSpacing;
                this.mCalculatedLabelBreakPoints.add(Boolean.FALSE);
                float f16 = i7 == -1 ? 0.0f : f11 + convertDpToPixel2;
                if (str2 != null) {
                    f4 = convertDpToPixel2;
                    this.mCalculatedLabelSizes.add(Utils.calcTextSize(paint, str2));
                    f5 = f16 + (z6 ? convertDpToPixel3 + convertDpToPixel7 : 0.0f) + this.mCalculatedLabelSizes.get(i6).width;
                } else {
                    f4 = convertDpToPixel2;
                    float f17 = convertDpToPixel7;
                    this.mCalculatedLabelSizes.add(FSize.getInstance(0.0f, 0.0f));
                    f5 = f16 + (z6 ? f17 : 0.0f);
                    if (i7 == -1) {
                        i7 = i6;
                    }
                }
                if (str2 != null || i6 == length - 1) {
                    float f18 = f12;
                    float f19 = f18 == 0.0f ? 0.0f : f14;
                    if (!z3 || f18 == 0.0f || contentWidth - f18 >= f19 + f5) {
                        f6 = f18 + f19 + f5;
                    } else {
                        this.mCalculatedLineSizes.add(FSize.getInstance(f18, lineHeight2));
                        float max = Math.max(f10, f18);
                        this.mCalculatedLabelBreakPoints.set(i7 > -1 ? i7 : i6, Boolean.TRUE);
                        f10 = max;
                        f6 = f5;
                    }
                    if (i6 == length - 1) {
                        this.mCalculatedLineSizes.add(FSize.getInstance(f6, lineHeight2));
                        f10 = Math.max(f10, f6);
                    }
                    f12 = f6;
                }
                if (str2 != null) {
                    i7 = -1;
                }
                i6++;
                convertDpToPixel2 = f4;
                convertDpToPixel = f13;
                convertDpToPixel4 = f14;
                lineSpacing = f15;
                f11 = f5;
                legendEntryArr = legendEntryArr2;
            }
            float f20 = lineSpacing;
            this.mNeededWidth = f10;
            this.mNeededHeight = (lineHeight2 * this.mCalculatedLineSizes.size()) + (f20 * (this.mCalculatedLineSizes.size() == 0 ? 0 : this.mCalculatedLineSizes.size() - 1));
        }
        this.mNeededHeight += this.mYOffset;
        this.mNeededWidth += this.mXOffset;
    }

    public List<Boolean> getCalculatedLabelBreakPoints() {
        return this.mCalculatedLabelBreakPoints;
    }

    public List<FSize> getCalculatedLabelSizes() {
        return this.mCalculatedLabelSizes;
    }

    public List<FSize> getCalculatedLineSizes() {
        return this.mCalculatedLineSizes;
    }

    public LegendDirection getDirection() {
        return this.mDirection;
    }

    public LegendEntry[] getEntries() {
        return this.mEntries;
    }

    public LegendEntry[] getExtraEntries() {
        return this.mExtraEntries;
    }

    public LegendForm getForm() {
        return this.mShape;
    }

    public DashPathEffect getFormLineDashEffect() {
        return this.mFormLineDashEffect;
    }

    public float getFormLineWidth() {
        return this.mFormLineWidth;
    }

    public float getFormSize() {
        return this.mFormSize;
    }

    public float getFormToTextSpace() {
        return this.mFormToTextSpace;
    }

    public LegendHorizontalAlignment getHorizontalAlignment() {
        return this.mHorizontalAlignment;
    }

    public float getMaxSizePercent() {
        return this.mMaxSizePercent;
    }

    public float getMaximumEntryHeight(Paint paint) {
        float f4 = 0.0f;
        for (LegendEntry legendEntry : this.mEntries) {
            String str = legendEntry.label;
            if (str != null) {
                float calcTextHeight = Utils.calcTextHeight(paint, str);
                if (calcTextHeight > f4) {
                    f4 = calcTextHeight;
                }
            }
        }
        return f4;
    }

    public float getMaximumEntryWidth(Paint paint) {
        LegendEntry[] legendEntryArr;
        float convertDpToPixel = Utils.convertDpToPixel(this.mFormToTextSpace);
        float f4 = 0.0f;
        float f5 = 0.0f;
        for (LegendEntry legendEntry : this.mEntries) {
            float convertDpToPixel2 = Utils.convertDpToPixel(Float.isNaN(legendEntry.formSize) ? this.mFormSize : legendEntry.formSize);
            if (convertDpToPixel2 > f5) {
                f5 = convertDpToPixel2;
            }
            String str = legendEntry.label;
            if (str != null) {
                float calcTextWidth = Utils.calcTextWidth(paint, str);
                if (calcTextWidth > f4) {
                    f4 = calcTextWidth;
                }
            }
        }
        return f4 + f5 + convertDpToPixel;
    }

    public LegendOrientation getOrientation() {
        return this.mOrientation;
    }

    public float getStackSpace() {
        return this.mStackSpace;
    }

    public LegendVerticalAlignment getVerticalAlignment() {
        return this.mVerticalAlignment;
    }

    public float getXEntrySpace() {
        return this.mXEntrySpace;
    }

    public float getYEntrySpace() {
        return this.mYEntrySpace;
    }

    public boolean isDrawInsideEnabled() {
        return this.mDrawInside;
    }

    public boolean isLegendCustom() {
        return this.mIsLegendCustom;
    }

    public boolean isWordWrapEnabled() {
        return this.mWordWrapEnabled;
    }

    public void resetCustom() {
        this.mIsLegendCustom = false;
    }

    public void setCustom(LegendEntry[] legendEntryArr) {
        this.mEntries = legendEntryArr;
        this.mIsLegendCustom = true;
    }

    public void setDirection(LegendDirection legendDirection) {
        this.mDirection = legendDirection;
    }

    public void setDrawInside(boolean z3) {
        this.mDrawInside = z3;
    }

    public void setEntries(List<LegendEntry> list) {
        this.mEntries = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public void setExtra(List<LegendEntry> list) {
        this.mExtraEntries = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public void setForm(LegendForm legendForm) {
        this.mShape = legendForm;
    }

    public void setFormLineDashEffect(DashPathEffect dashPathEffect) {
        this.mFormLineDashEffect = dashPathEffect;
    }

    public void setFormLineWidth(float f4) {
        this.mFormLineWidth = f4;
    }

    public void setFormSize(float f4) {
        this.mFormSize = f4;
    }

    public void setFormToTextSpace(float f4) {
        this.mFormToTextSpace = f4;
    }

    public void setHorizontalAlignment(LegendHorizontalAlignment legendHorizontalAlignment) {
        this.mHorizontalAlignment = legendHorizontalAlignment;
    }

    public void setMaxSizePercent(float f4) {
        this.mMaxSizePercent = f4;
    }

    public void setOrientation(LegendOrientation legendOrientation) {
        this.mOrientation = legendOrientation;
    }

    public void setStackSpace(float f4) {
        this.mStackSpace = f4;
    }

    public void setVerticalAlignment(LegendVerticalAlignment legendVerticalAlignment) {
        this.mVerticalAlignment = legendVerticalAlignment;
    }

    public void setWordWrapEnabled(boolean z3) {
        this.mWordWrapEnabled = z3;
    }

    public void setXEntrySpace(float f4) {
        this.mXEntrySpace = f4;
    }

    public void setYEntrySpace(float f4) {
        this.mYEntrySpace = f4;
    }

    public void setExtra(LegendEntry[] legendEntryArr) {
        if (legendEntryArr == null) {
            legendEntryArr = new LegendEntry[0];
        }
        this.mExtraEntries = legendEntryArr;
    }

    public void setCustom(List<LegendEntry> list) {
        this.mEntries = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
        this.mIsLegendCustom = true;
    }

    public void setExtra(int[] iArr, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < Math.min(iArr.length, strArr.length); i4++) {
            LegendEntry legendEntry = new LegendEntry();
            int i5 = iArr[i4];
            legendEntry.formColor = i5;
            legendEntry.label = strArr[i4];
            if (i5 == 1122868 || i5 == 0) {
                legendEntry.form = LegendForm.NONE;
            } else if (i5 == 1122867) {
                legendEntry.form = LegendForm.EMPTY;
            }
            arrayList.add(legendEntry);
        }
        this.mExtraEntries = (LegendEntry[]) arrayList.toArray(new LegendEntry[arrayList.size()]);
    }

    public Legend(LegendEntry[] legendEntryArr) {
        this();
        if (legendEntryArr != null) {
            this.mEntries = legendEntryArr;
            return;
        }
        throw new IllegalArgumentException("entries array is NULL");
    }
}
