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
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LegendRenderer extends Renderer {
    protected List<LegendEntry> computedEntries;
    protected Paint.FontMetrics legendFontMetrics;
    protected Legend mLegend;
    protected Paint mLegendFormPaint;
    protected Paint mLegendLabelPaint;
    private Path mLineFormPath;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.github.mikephil.charting.renderer.LegendRenderer$1 */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static /* synthetic */ class C67081 {

        /* renamed from: $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm */
        static final /* synthetic */ int[] f23777xfbec3b85;

        /* renamed from: $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment */
        static final /* synthetic */ int[] f23778x2787f53e;

        /* renamed from: $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation */
        static final /* synthetic */ int[] f23779x9c9dbef;

        /* renamed from: $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment */
        static final /* synthetic */ int[] f23780xc926f1ec;

        static {
            int[] iArr = new int[Legend.LegendForm.values().length];
            f23777xfbec3b85 = iArr;
            try {
                iArr[Legend.LegendForm.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23777xfbec3b85[Legend.LegendForm.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23777xfbec3b85[Legend.LegendForm.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23777xfbec3b85[Legend.LegendForm.CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23777xfbec3b85[Legend.LegendForm.SQUARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23777xfbec3b85[Legend.LegendForm.LINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[Legend.LegendOrientation.values().length];
            f23779x9c9dbef = iArr2;
            try {
                iArr2[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f23779x9c9dbef[Legend.LegendOrientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            f23780xc926f1ec = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f23780xc926f1ec[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f23780xc926f1ec[Legend.LegendVerticalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr4 = new int[Legend.LegendHorizontalAlignment.values().length];
            f23778x2787f53e = iArr4;
            try {
                iArr4[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f23778x2787f53e[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f23778x2787f53e[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
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
            int i = 0;
            while (i < chartData.getDataSetCount()) {
                ?? dataSetByIndex = chartData3.getDataSetByIndex(i);
                List<Integer> colors = dataSetByIndex.getColors();
                int entryCount = dataSetByIndex.getEntryCount();
                if (dataSetByIndex instanceof IBarDataSet) {
                    IBarDataSet iBarDataSet = (IBarDataSet) dataSetByIndex;
                    if (iBarDataSet.isStacked()) {
                        String[] stackLabels = iBarDataSet.getStackLabels();
                        for (int i2 = 0; i2 < colors.size() && i2 < iBarDataSet.getStackSize(); i2++) {
                            this.computedEntries.add(new LegendEntry(stackLabels[i2 % stackLabels.length], dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i2).intValue()));
                        }
                        if (iBarDataSet.getLabel() != null) {
                            this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, ColorTemplate.COLOR_NONE));
                        }
                        chartData2 = chartData3;
                        i++;
                        chartData3 = chartData2;
                    }
                }
                if (dataSetByIndex instanceof IPieDataSet) {
                    IPieDataSet iPieDataSet = (IPieDataSet) dataSetByIndex;
                    for (int i3 = 0; i3 < colors.size() && i3 < entryCount; i3++) {
                        this.computedEntries.add(new LegendEntry(iPieDataSet.getEntryForIndex(i3).getLabel(), dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i3).intValue()));
                    }
                    if (iPieDataSet.getLabel() != null) {
                        this.computedEntries.add(new LegendEntry(dataSetByIndex.getLabel(), Legend.LegendForm.NONE, Float.NaN, Float.NaN, null, ColorTemplate.COLOR_NONE));
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
                    int i4 = 0;
                    while (i4 < colors.size() && i4 < entryCount) {
                        this.computedEntries.add(new LegendEntry((i4 >= colors.size() + (-1) || i4 >= entryCount + (-1)) ? chartData.getDataSetByIndex(i).getLabel() : null, dataSetByIndex.getForm(), dataSetByIndex.getFormSize(), dataSetByIndex.getFormLineWidth(), dataSetByIndex.getFormLineDashEffect(), colors.get(i4).intValue()));
                        i4++;
                    }
                }
                chartData2 = chartData;
                i++;
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

    protected void drawForm(Canvas canvas, float f, float f2, LegendEntry legendEntry, Legend legend) {
        int i = legendEntry.formColor;
        if (i == 1122868 || i == 1122867 || i == 0) {
            return;
        }
        int save = canvas.save();
        Legend.LegendForm legendForm = legendEntry.form;
        if (legendForm == Legend.LegendForm.DEFAULT) {
            legendForm = legend.getForm();
        }
        this.mLegendFormPaint.setColor(legendEntry.formColor);
        float convertDpToPixel = Utils.convertDpToPixel(Float.isNaN(legendEntry.formSize) ? legend.getFormSize() : legendEntry.formSize);
        float f3 = convertDpToPixel / 2.0f;
        int i2 = C67081.f23777xfbec3b85[legendForm.ordinal()];
        if (i2 == 3 || i2 == 4) {
            this.mLegendFormPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(f + f3, f2, f3, this.mLegendFormPaint);
        } else if (i2 == 5) {
            this.mLegendFormPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(f, f2 - f3, f + convertDpToPixel, f2 + f3, this.mLegendFormPaint);
        } else if (i2 == 6) {
            float convertDpToPixel2 = Utils.convertDpToPixel(Float.isNaN(legendEntry.formLineWidth) ? legend.getFormLineWidth() : legendEntry.formLineWidth);
            DashPathEffect dashPathEffect = legendEntry.formLineDashEffect;
            if (dashPathEffect == null) {
                dashPathEffect = legend.getFormLineDashEffect();
            }
            this.mLegendFormPaint.setStyle(Paint.Style.STROKE);
            this.mLegendFormPaint.setStrokeWidth(convertDpToPixel2);
            this.mLegendFormPaint.setPathEffect(dashPathEffect);
            this.mLineFormPath.reset();
            this.mLineFormPath.moveTo(f, f2);
            this.mLineFormPath.lineTo(f + convertDpToPixel, f2);
            canvas.drawPath(this.mLineFormPath, this.mLegendFormPaint);
        }
        canvas.restoreToCount(save);
    }

    protected void drawLabel(Canvas canvas, float f, float f2, String str) {
        canvas.drawText(str, f, f2, this.mLegendLabelPaint);
    }

    public Paint getFormPaint() {
        return this.mLegendFormPaint;
    }

    public Paint getLabelPaint() {
        return this.mLegendLabelPaint;
    }

    public void renderLegend(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        List<Boolean> list;
        List<FSize> list2;
        int i;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float contentTop;
        float f11;
        float f12;
        float f13;
        Legend.LegendDirection legendDirection;
        LegendEntry legendEntry;
        float f14;
        String str;
        float contentBottom;
        float contentRight;
        float contentLeft;
        double d;
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
            int i2 = C67081.f23778x2787f53e[horizontalAlignment.ordinal()];
            float f15 = convertDpToPixel4;
            float f16 = convertDpToPixel2;
            if (i2 == 1) {
                f = lineHeight;
                f2 = lineSpacing;
                if (orientation != Legend.LegendOrientation.VERTICAL) {
                    xOffset += this.mViewPortHandler.contentLeft();
                }
                f3 = direction == Legend.LegendDirection.RIGHT_TO_LEFT ? xOffset + this.mLegend.mNeededWidth : xOffset;
            } else if (i2 == 2) {
                f = lineHeight;
                f2 = lineSpacing;
                if (orientation == Legend.LegendOrientation.VERTICAL) {
                    contentRight = this.mViewPortHandler.getChartWidth();
                } else {
                    contentRight = this.mViewPortHandler.contentRight();
                }
                f3 = contentRight - xOffset;
                if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                    f3 -= this.mLegend.mNeededWidth;
                }
            } else if (i2 != 3) {
                f = lineHeight;
                f2 = lineSpacing;
                f3 = 0.0f;
            } else {
                Legend.LegendOrientation legendOrientation = Legend.LegendOrientation.VERTICAL;
                if (orientation == legendOrientation) {
                    contentLeft = this.mViewPortHandler.getChartWidth() / 2.0f;
                } else {
                    contentLeft = this.mViewPortHandler.contentLeft() + (this.mViewPortHandler.contentWidth() / 2.0f);
                }
                Legend.LegendDirection legendDirection2 = Legend.LegendDirection.LEFT_TO_RIGHT;
                f2 = lineSpacing;
                f3 = contentLeft + (direction == legendDirection2 ? xOffset : -xOffset);
                if (orientation == legendOrientation) {
                    double d2 = f3;
                    if (direction == legendDirection2) {
                        f = lineHeight;
                        double d3 = -this.mLegend.mNeededWidth;
                        Double.isNaN(d3);
                        double d4 = xOffset;
                        Double.isNaN(d4);
                        d = (d3 / 2.0d) + d4;
                    } else {
                        f = lineHeight;
                        double d5 = this.mLegend.mNeededWidth;
                        Double.isNaN(d5);
                        double d6 = xOffset;
                        Double.isNaN(d6);
                        d = (d5 / 2.0d) - d6;
                    }
                    Double.isNaN(d2);
                    f3 = (float) (d2 + d);
                } else {
                    f = lineHeight;
                }
            }
            int i3 = C67081.f23779x9c9dbef[orientation.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    return;
                }
                int i4 = C67081.f23780xc926f1ec[verticalAlignment.ordinal()];
                if (i4 == 1) {
                    contentTop = (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER ? 0.0f : this.mViewPortHandler.contentTop()) + yOffset;
                } else if (i4 == 2) {
                    if (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER) {
                        contentBottom = this.mViewPortHandler.getChartHeight();
                    } else {
                        contentBottom = this.mViewPortHandler.contentBottom();
                    }
                    contentTop = contentBottom - (this.mLegend.mNeededHeight + yOffset);
                } else if (i4 != 3) {
                    contentTop = 0.0f;
                } else {
                    Legend legend = this.mLegend;
                    contentTop = ((this.mViewPortHandler.getChartHeight() / 2.0f) - (legend.mNeededHeight / 2.0f)) + legend.getYOffset();
                }
                float f17 = contentTop;
                boolean z = false;
                int i5 = 0;
                float f18 = 0.0f;
                while (i5 < entries.length) {
                    LegendEntry legendEntry2 = entries[i5];
                    boolean z2 = legendEntry2.form != Legend.LegendForm.NONE;
                    float convertDpToPixel5 = Float.isNaN(legendEntry2.formSize) ? convertDpToPixel3 : Utils.convertDpToPixel(legendEntry2.formSize);
                    if (z2) {
                        Legend.LegendDirection legendDirection3 = Legend.LegendDirection.LEFT_TO_RIGHT;
                        f14 = direction == legendDirection3 ? f3 + f18 : f3 - (convertDpToPixel5 - f18);
                        f12 = calcTextHeight;
                        f13 = f15;
                        f11 = f3;
                        legendDirection = direction;
                        drawForm(canvas, f14, f17 + calcTextHeight, legendEntry2, this.mLegend);
                        if (legendDirection == legendDirection3) {
                            f14 += convertDpToPixel5;
                        }
                        legendEntry = legendEntry2;
                    } else {
                        f11 = f3;
                        f12 = calcTextHeight;
                        f13 = f15;
                        legendDirection = direction;
                        legendEntry = legendEntry2;
                        f14 = f11;
                    }
                    if (legendEntry.label != null) {
                        if (z2 && !z) {
                            f14 += legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT ? convertDpToPixel : -convertDpToPixel;
                        } else if (z) {
                            f14 = f11;
                        }
                        if (legendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f14 -= Utils.calcTextWidth(this.mLegendLabelPaint, str);
                        }
                        float f19 = f14;
                        if (!z) {
                            drawLabel(canvas, f19, f17 + f, legendEntry.label);
                        } else {
                            f17 += f + f2;
                            drawLabel(canvas, f19, f17 + f, legendEntry.label);
                        }
                        f17 += f + f2;
                        f18 = 0.0f;
                    } else {
                        f18 += convertDpToPixel5 + f13;
                        z = true;
                    }
                    i5++;
                    direction = legendDirection;
                    f15 = f13;
                    calcTextHeight = f12;
                    f3 = f11;
                }
                return;
            }
            float f20 = f3;
            float f21 = f15;
            List<FSize> calculatedLineSizes = this.mLegend.getCalculatedLineSizes();
            List<FSize> calculatedLabelSizes = this.mLegend.getCalculatedLabelSizes();
            List<Boolean> calculatedLabelBreakPoints = this.mLegend.getCalculatedLabelBreakPoints();
            int i6 = C67081.f23780xc926f1ec[verticalAlignment.ordinal()];
            if (i6 != 1) {
                if (i6 != 2) {
                    yOffset = i6 != 3 ? 0.0f : yOffset + ((this.mViewPortHandler.getChartHeight() - this.mLegend.mNeededHeight) / 2.0f);
                } else {
                    yOffset = (this.mViewPortHandler.getChartHeight() - yOffset) - this.mLegend.mNeededHeight;
                }
            }
            int length = entries.length;
            float f22 = f20;
            int i7 = 0;
            int i8 = 0;
            while (i7 < length) {
                float f23 = f21;
                LegendEntry legendEntry3 = entries[i7];
                float f24 = f22;
                int i9 = length;
                boolean z3 = legendEntry3.form != Legend.LegendForm.NONE;
                float convertDpToPixel6 = Float.isNaN(legendEntry3.formSize) ? convertDpToPixel3 : Utils.convertDpToPixel(legendEntry3.formSize);
                if (i7 >= calculatedLabelBreakPoints.size() || !calculatedLabelBreakPoints.get(i7).booleanValue()) {
                    f4 = f24;
                    f5 = yOffset;
                } else {
                    f5 = yOffset + f + f2;
                    f4 = f20;
                }
                if (f4 == f20 && horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER && i8 < calculatedLineSizes.size()) {
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f10 = calculatedLineSizes.get(i8).width;
                    } else {
                        f10 = -calculatedLineSizes.get(i8).width;
                    }
                    f4 += f10 / 2.0f;
                    i8++;
                }
                int i10 = i8;
                boolean z4 = legendEntry3.label == null;
                if (z3) {
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f4 -= convertDpToPixel6;
                    }
                    float f25 = f4;
                    list2 = calculatedLineSizes;
                    i = i7;
                    list = calculatedLabelBreakPoints;
                    drawForm(canvas, f25, f5 + calcTextHeight, legendEntry3, this.mLegend);
                    f4 = direction == Legend.LegendDirection.LEFT_TO_RIGHT ? f25 + convertDpToPixel6 : f25;
                } else {
                    list = calculatedLabelBreakPoints;
                    list2 = calculatedLineSizes;
                    i = i7;
                }
                if (!z4) {
                    if (z3) {
                        f4 += direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -convertDpToPixel : convertDpToPixel;
                    }
                    Legend.LegendDirection legendDirection4 = Legend.LegendDirection.RIGHT_TO_LEFT;
                    if (direction == legendDirection4) {
                        f4 -= calculatedLabelSizes.get(i).width;
                    }
                    drawLabel(canvas, f4, f5 + f, legendEntry3.label);
                    if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        f4 += calculatedLabelSizes.get(i).width;
                    }
                    if (direction == legendDirection4) {
                        f6 = f16;
                        f9 = -f6;
                    } else {
                        f6 = f16;
                        f9 = f6;
                    }
                    f22 = f4 + f9;
                    f7 = f23;
                } else {
                    f6 = f16;
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f7 = f23;
                        f8 = -f7;
                    } else {
                        f7 = f23;
                        f8 = f7;
                    }
                    f22 = f4 + f8;
                }
                f16 = f6;
                f21 = f7;
                i7 = i + 1;
                yOffset = f5;
                length = i9;
                i8 = i10;
                calculatedLineSizes = list2;
                calculatedLabelBreakPoints = list;
            }
        }
    }
}
