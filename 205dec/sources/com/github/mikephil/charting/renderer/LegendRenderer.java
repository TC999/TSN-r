package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class LegendRenderer extends Renderer {
    protected List<LegendEntry> computedEntries;
    protected Paint.FontMetrics legendFontMetrics;
    protected Legend mLegend;
    protected Paint mLegendFormPaint;
    protected Paint mLegendLabelPaint;
    private Path mLineFormPath;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* renamed from: com.github.mikephil.charting.renderer.LegendRenderer$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment;

        static {
            int[] iArr = new int[Legend.LegendForm.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm = iArr;
            try {
                iArr[Legend.LegendForm.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.SQUARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.LINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[Legend.LegendOrientation.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = iArr2;
            try {
                iArr2[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[Legend.LegendOrientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[Legend.LegendVerticalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr4 = new int[Legend.LegendHorizontalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment = iArr4;
            try {
                iArr4[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.computedEntries = new ArrayList(16);
        this.legendFontMetrics = new Paint.FontMetrics();
        this.mLineFormPath = new Path();
        this.mLegend = legend;
        Paint paint = new Paint(1);
        this.mLegendLabelPaint = paint;
        paint.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mLegendLabelPaint.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.mLegendFormPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    public void computeLegend(ChartData<?> chartData) {
        ChartData<?> chartData2;
        ChartData<?> chartData3 = chartData;
        if (!this.mLegend.isLegendCustom()) {
            this.computedEntries.clear();
            int i4 = 0;
            while (i4 < chartData.getDataSetCount()) {
                ?? dataSetByIndex = chartData3.getDataSetByIndex(i4);
                List<Integer> colors = dataSetByIndex.getColors();
                int entryCount = dataSetByIndex.getEntryCount();
                if (dataSetByIndex instanceof IBarDataSet) {
                    IBarDataSet iBarDataSet = (IBarDataSet) dataSetByIndex;
                    if (iBarDataSet.isStacked()) {
                        String[] stackLabels = iBarDataSet.getStackLabels();
                        for (int i5 = 0; i5 < colors.size() && i5 < iBarDataSet.getStackSize(); i5++) {
                            this.computedEntries.add(new LegendEntry(stackLabels[i5 % stackLabels.length], dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i5).intValue()));
                        }
                        if (iBarDataSet.getLabel() != null) {
                            this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, 1122867));
                        }
                        chartData2 = chartData3;
                        i4++;
                        chartData3 = chartData2;
                    }
                }
                if (dataSetByIndex instanceof IPieDataSet) {
                    IPieDataSet iPieDataSet = (IPieDataSet) dataSetByIndex;
                    for (int i6 = 0; i6 < colors.size() && i6 < entryCount; i6++) {
                        this.computedEntries.add(new LegendEntry(iPieDataSet.getEntryForIndex(i6).getLabel(), dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i6).intValue()));
                    }
                    if (iPieDataSet.getLabel() != null) {
                        this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, 1122867));
                    }
                } else {
                    if (dataSetByIndex instanceof ICandleDataSet) {
                        ICandleDataSet iCandleDataSet = (ICandleDataSet) dataSetByIndex;
                        if (iCandleDataSet.getDecreasingColor() != 1122867) {
                            int decreasingColor = iCandleDataSet.getDecreasingColor();
                            int increasingColor = iCandleDataSet.getIncreasingColor();
                            this.computedEntries.add(new LegendEntry(null, dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), decreasingColor));
                            this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), increasingColor));
                        }
                    }
                    int i7 = 0;
                    while (i7 < colors.size() && i7 < entryCount) {
                        this.computedEntries.add(new LegendEntry((i7 >= colors.size() + (-1) || i7 >= entryCount + (-1)) ? chartData.getDataSetByIndex(i4).getLabel() : null, dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i7).intValue()));
                        i7++;
                    }
                }
                chartData2 = chartData;
                i4++;
                chartData3 = chartData2;
            }
            if (this.mLegend.getExtraEntries() != null) {
                Collections.addAll(this.computedEntries, this.mLegend.getExtraEntries());
            }
            this.mLegend.setEntries(this.computedEntries);
        }
        Typeface typeface = this.mLegend.getTypeface();
        if (typeface != null) {
            this.mLegendLabelPaint.setTypeface(typeface);
        }
        this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
        this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
        this.mLegend.calculateDimensions(this.mLegendLabelPaint, this.mViewPortHandler);
    }

    protected void drawForm(Canvas canvas, float f4, float f5, LegendEntry legendEntry, Legend legend) {
        int i4 = legendEntry.formColor;
        if (i4 == 1122868 || i4 == 1122867 || i4 == 0) {
            return;
        }
        int save = canvas.save();
        Legend.LegendForm legendForm = legendEntry.form;
        if (legendForm == Legend.LegendForm.DEFAULT) {
            legendForm = legend.getForm();
        }
        this.mLegendFormPaint.setColor(legendEntry.formColor);
        float convertDpToPixel = Utils.convertDpToPixel(Float.isNaN(legendEntry.formSize) ? legend.getFormSize() : legendEntry.formSize);
        float f6 = convertDpToPixel / 2.0f;
        int i5 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[legendForm.ordinal()];
        if (i5 == 3 || i5 == 4) {
            this.mLegendFormPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(f4 + f6, f5, f6, this.mLegendFormPaint);
        } else if (i5 == 5) {
            this.mLegendFormPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(f4, f5 - f6, f4 + convertDpToPixel, f5 + f6, this.mLegendFormPaint);
        } else if (i5 == 6) {
            float convertDpToPixel2 = Utils.convertDpToPixel(Float.isNaN(legendEntry.formLineWidth) ? legend.getFormLineWidth() : legendEntry.formLineWidth);
            DashPathEffect dashPathEffect = legendEntry.formLineDashEffect;
            if (dashPathEffect == null) {
                dashPathEffect = legend.getFormLineDashEffect();
            }
            this.mLegendFormPaint.setStyle(Paint.Style.STROKE);
            this.mLegendFormPaint.setStrokeWidth(convertDpToPixel2);
            this.mLegendFormPaint.setPathEffect(dashPathEffect);
            this.mLineFormPath.reset();
            this.mLineFormPath.moveTo(f4, f5);
            this.mLineFormPath.lineTo(f4 + convertDpToPixel, f5);
            canvas.drawPath(this.mLineFormPath, this.mLegendFormPaint);
        }
        canvas.restoreToCount(save);
    }

    protected void drawLabel(Canvas canvas, float f4, float f5, String str) {
        canvas.drawText(str, f4, f5, this.mLegendLabelPaint);
    }

    public Paint getFormPaint() {
        return this.mLegendFormPaint;
    }

    public Paint getLabelPaint() {
        return this.mLegendLabelPaint;
    }

    public void renderLegend(Canvas canvas) {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        List<Boolean> list;
        List<FSize> list2;
        int i4;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float contentTop;
        float f14;
        float f15;
        float f16;
        Legend.LegendDirection legendDirection;
        LegendEntry legendEntry;
        float f17;
        String str;
        float contentBottom;
        float contentRight;
        float contentLeft;
        double d4;
        if (this.mLegend.isEnabled()) {
            Typeface typeface = this.mLegend.getTypeface();
            if (typeface != null) {
                this.mLegendLabelPaint.setTypeface(typeface);
            }
            this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
            this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
            float lineHeight = Utils.getLineHeight(this.mLegendLabelPaint, this.legendFontMetrics);
            float lineSpacing = Utils.getLineSpacing(this.mLegendLabelPaint, this.legendFontMetrics) + Utils.convertDpToPixel(this.mLegend.getYEntrySpace());
            float calcTextHeight = lineHeight - (Utils.calcTextHeight(this.mLegendLabelPaint, "ABC") / 2.0f);
            LegendEntry[] entries = this.mLegend.getEntries();
            float convertDpToPixel = Utils.convertDpToPixel(this.mLegend.getFormToTextSpace());
            float convertDpToPixel2 = Utils.convertDpToPixel(this.mLegend.getXEntrySpace());
            Legend.LegendOrientation orientation = this.mLegend.getOrientation();
            Legend.LegendHorizontalAlignment horizontalAlignment = this.mLegend.getHorizontalAlignment();
            Legend.LegendVerticalAlignment verticalAlignment = this.mLegend.getVerticalAlignment();
            Legend.LegendDirection direction = this.mLegend.getDirection();
            float convertDpToPixel3 = Utils.convertDpToPixel(this.mLegend.getFormSize());
            float convertDpToPixel4 = Utils.convertDpToPixel(this.mLegend.getStackSpace());
            float yOffset = this.mLegend.getYOffset();
            float xOffset = this.mLegend.getXOffset();
            int i5 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[horizontalAlignment.ordinal()];
            float f18 = convertDpToPixel4;
            float f19 = convertDpToPixel2;
            if (i5 == 1) {
                f4 = lineHeight;
                f5 = lineSpacing;
                if (orientation != Legend.LegendOrientation.VERTICAL) {
                    xOffset += this.mViewPortHandler.contentLeft();
                }
                f6 = direction == Legend.LegendDirection.RIGHT_TO_LEFT ? xOffset + this.mLegend.mNeededWidth : xOffset;
            } else if (i5 == 2) {
                f4 = lineHeight;
                f5 = lineSpacing;
                if (orientation == Legend.LegendOrientation.VERTICAL) {
                    contentRight = this.mViewPortHandler.getChartWidth();
                } else {
                    contentRight = this.mViewPortHandler.contentRight();
                }
                f6 = contentRight - xOffset;
                if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                    f6 -= this.mLegend.mNeededWidth;
                }
            } else if (i5 != 3) {
                f4 = lineHeight;
                f5 = lineSpacing;
                f6 = 0.0f;
            } else {
                Legend.LegendOrientation legendOrientation = Legend.LegendOrientation.VERTICAL;
                if (orientation == legendOrientation) {
                    contentLeft = this.mViewPortHandler.getChartWidth() / 2.0f;
                } else {
                    contentLeft = this.mViewPortHandler.contentLeft() + (this.mViewPortHandler.contentWidth() / 2.0f);
                }
                Legend.LegendDirection legendDirection2 = Legend.LegendDirection.LEFT_TO_RIGHT;
                f5 = lineSpacing;
                f6 = contentLeft + (direction == legendDirection2 ? xOffset : -xOffset);
                if (orientation == legendOrientation) {
                    double d5 = f6;
                    if (direction == legendDirection2) {
                        f4 = lineHeight;
                        double d6 = -this.mLegend.mNeededWidth;
                        Double.isNaN(d6);
                        double d7 = xOffset;
                        Double.isNaN(d7);
                        d4 = (d6 / 2.0d) + d7;
                    } else {
                        f4 = lineHeight;
                        double d8 = this.mLegend.mNeededWidth;
                        Double.isNaN(d8);
                        double d9 = xOffset;
                        Double.isNaN(d9);
                        d4 = (d8 / 2.0d) - d9;
                    }
                    Double.isNaN(d5);
                    f6 = (float) (d5 + d4);
                } else {
                    f4 = lineHeight;
                }
            }
            int i6 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[orientation.ordinal()];
            if (i6 != 1) {
                if (i6 != 2) {
                    return;
                }
                int i7 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[verticalAlignment.ordinal()];
                if (i7 == 1) {
                    contentTop = (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER ? 0.0f : this.mViewPortHandler.contentTop()) + yOffset;
                } else if (i7 == 2) {
                    if (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER) {
                        contentBottom = this.mViewPortHandler.getChartHeight();
                    } else {
                        contentBottom = this.mViewPortHandler.contentBottom();
                    }
                    contentTop = contentBottom - (this.mLegend.mNeededHeight + yOffset);
                } else if (i7 != 3) {
                    contentTop = 0.0f;
                } else {
                    Legend legend = this.mLegend;
                    contentTop = ((this.mViewPortHandler.getChartHeight() / 2.0f) - (legend.mNeededHeight / 2.0f)) + legend.getYOffset();
                }
                float f20 = contentTop;
                boolean z3 = false;
                int i8 = 0;
                float f21 = 0.0f;
                while (i8 < entries.length) {
                    LegendEntry legendEntry2 = entries[i8];
                    boolean z4 = legendEntry2.form != Legend.LegendForm.NONE;
                    float convertDpToPixel5 = Float.isNaN(legendEntry2.formSize) ? convertDpToPixel3 : Utils.convertDpToPixel(legendEntry2.formSize);
                    if (z4) {
                        Legend.LegendDirection legendDirection3 = Legend.LegendDirection.LEFT_TO_RIGHT;
                        f17 = direction == legendDirection3 ? f6 + f21 : f6 - (convertDpToPixel5 - f21);
                        f15 = calcTextHeight;
                        f16 = f18;
                        f14 = f6;
                        legendDirection = direction;
                        drawForm(canvas, f17, f20 + calcTextHeight, legendEntry2, this.mLegend);
                        if (legendDirection == legendDirection3) {
                            f17 += convertDpToPixel5;
                        }
                        legendEntry = legendEntry2;
                    } else {
                        f14 = f6;
                        f15 = calcTextHeight;
                        f16 = f18;
                        legendDirection = direction;
                        legendEntry = legendEntry2;
                        f17 = f14;
                    }
                    if (legendEntry.label != null) {
                        if (z4 && !z3) {
                            f17 += legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT ? convertDpToPixel : -convertDpToPixel;
                        } else if (z3) {
                            f17 = f14;
                        }
                        if (legendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f17 -= Utils.calcTextWidth(this.mLegendLabelPaint, str);
                        }
                        float f22 = f17;
                        if (!z3) {
                            drawLabel(canvas, f22, f20 + f4, legendEntry.label);
                        } else {
                            f20 += f4 + f5;
                            drawLabel(canvas, f22, f20 + f4, legendEntry.label);
                        }
                        f20 += f4 + f5;
                        f21 = 0.0f;
                    } else {
                        f21 += convertDpToPixel5 + f16;
                        z3 = true;
                    }
                    i8++;
                    direction = legendDirection;
                    f18 = f16;
                    calcTextHeight = f15;
                    f6 = f14;
                }
                return;
            }
            float f23 = f6;
            float f24 = f18;
            List<FSize> calculatedLineSizes = this.mLegend.getCalculatedLineSizes();
            List<FSize> calculatedLabelSizes = this.mLegend.getCalculatedLabelSizes();
            List<Boolean> calculatedLabelBreakPoints = this.mLegend.getCalculatedLabelBreakPoints();
            int i9 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[verticalAlignment.ordinal()];
            if (i9 != 1) {
                if (i9 != 2) {
                    yOffset = i9 != 3 ? 0.0f : yOffset + ((this.mViewPortHandler.getChartHeight() - this.mLegend.mNeededHeight) / 2.0f);
                } else {
                    yOffset = (this.mViewPortHandler.getChartHeight() - yOffset) - this.mLegend.mNeededHeight;
                }
            }
            int length = entries.length;
            float f25 = f23;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                float f26 = f24;
                LegendEntry legendEntry3 = entries[i10];
                float f27 = f25;
                int i12 = length;
                boolean z5 = legendEntry3.form != Legend.LegendForm.NONE;
                float convertDpToPixel6 = Float.isNaN(legendEntry3.formSize) ? convertDpToPixel3 : Utils.convertDpToPixel(legendEntry3.formSize);
                if (i10 >= calculatedLabelBreakPoints.size() || !calculatedLabelBreakPoints.get(i10).booleanValue()) {
                    f7 = f27;
                    f8 = yOffset;
                } else {
                    f8 = yOffset + f4 + f5;
                    f7 = f23;
                }
                if (f7 == f23 && horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER && i11 < calculatedLineSizes.size()) {
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f13 = calculatedLineSizes.get(i11).width;
                    } else {
                        f13 = -calculatedLineSizes.get(i11).width;
                    }
                    f7 += f13 / 2.0f;
                    i11++;
                }
                int i13 = i11;
                boolean z6 = legendEntry3.label == null;
                if (z5) {
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f7 -= convertDpToPixel6;
                    }
                    float f28 = f7;
                    list2 = calculatedLineSizes;
                    i4 = i10;
                    list = calculatedLabelBreakPoints;
                    drawForm(canvas, f28, f8 + calcTextHeight, legendEntry3, this.mLegend);
                    f7 = direction == Legend.LegendDirection.LEFT_TO_RIGHT ? f28 + convertDpToPixel6 : f28;
                } else {
                    list = calculatedLabelBreakPoints;
                    list2 = calculatedLineSizes;
                    i4 = i10;
                }
                if (!z6) {
                    if (z5) {
                        f7 += direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -convertDpToPixel : convertDpToPixel;
                    }
                    Legend.LegendDirection legendDirection4 = Legend.LegendDirection.RIGHT_TO_LEFT;
                    if (direction == legendDirection4) {
                        f7 -= calculatedLabelSizes.get(i4).width;
                    }
                    drawLabel(canvas, f7, f8 + f4, legendEntry3.label);
                    if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        f7 += calculatedLabelSizes.get(i4).width;
                    }
                    if (direction == legendDirection4) {
                        f9 = f19;
                        f12 = -f9;
                    } else {
                        f9 = f19;
                        f12 = f9;
                    }
                    f25 = f7 + f12;
                    f10 = f26;
                } else {
                    f9 = f19;
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f10 = f26;
                        f11 = -f10;
                    } else {
                        f10 = f26;
                        f11 = f10;
                    }
                    f25 = f7 + f11;
                }
                f19 = f9;
                f24 = f10;
                i10 = i4 + 1;
                yOffset = f8;
                length = i12;
                i11 = i13;
                calculatedLineSizes = list2;
                calculatedLabelBreakPoints = list;
            }
        }
    }
}
