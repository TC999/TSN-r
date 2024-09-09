package com.github.mikephil.charting.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class Utils {
    public static final double DEG2RAD = 0.017453292519943295d;
    public static final float FDEG2RAD = 0.017453292f;
    private static int mMaximumFlingVelocity = 8000;
    private static DisplayMetrics mMetrics = null;
    private static int mMinimumFlingVelocity = 50;
    public static final double DOUBLE_EPSILON = Double.longBitsToDouble(1);
    public static final float FLOAT_EPSILON = Float.intBitsToFloat(1);
    private static Rect mCalcTextHeightRect = new Rect();
    private static Paint.FontMetrics mFontMetrics = new Paint.FontMetrics();
    private static Rect mCalcTextSizeRect = new Rect();
    private static final int[] POW_10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    private static ValueFormatter mDefaultValueFormatter = generateDefaultValueFormatter();
    private static Rect mDrawableBoundsCache = new Rect();
    private static Rect mDrawTextRectBuffer = new Rect();
    private static Paint.FontMetrics mFontMetricsBuffer = new Paint.FontMetrics();

    public static int calcTextHeight(Paint paint, String str) {
        Rect rect = mCalcTextHeightRect;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static FSize calcTextSize(Paint paint, String str) {
        FSize fSize = FSize.getInstance(0.0f, 0.0f);
        calcTextSize(paint, str, fSize);
        return fSize;
    }

    public static int calcTextWidth(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static float convertDpToPixel(float f4) {
        DisplayMetrics displayMetrics = mMetrics;
        if (displayMetrics == null) {
            Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
            return f4;
        }
        return f4 * displayMetrics.density;
    }

    public static int[] convertIntegers(List<Integer> list) {
        int[] iArr = new int[list.size()];
        copyIntegers(list, iArr);
        return iArr;
    }

    public static float convertPixelsToDp(float f4) {
        DisplayMetrics displayMetrics = mMetrics;
        if (displayMetrics == null) {
            Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertPixelsToDp(...). Otherwise conversion does not take place.");
            return f4;
        }
        return f4 / displayMetrics.density;
    }

    public static String[] convertStrings(List<String> list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i4 = 0; i4 < size; i4++) {
            strArr[i4] = list.get(i4);
        }
        return strArr;
    }

    public static void copyIntegers(List<Integer> list, int[] iArr) {
        int length = iArr.length < list.size() ? iArr.length : list.size();
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = list.get(i4).intValue();
        }
    }

    public static void copyStrings(List<String> list, String[] strArr) {
        int length = strArr.length < list.size() ? strArr.length : list.size();
        for (int i4 = 0; i4 < length; i4++) {
            strArr[i4] = list.get(i4);
        }
    }

    public static void drawImage(Canvas canvas, Drawable drawable, int i4, int i5, int i6, int i7) {
        MPPointF mPPointF = MPPointF.getInstance();
        mPPointF.f37332x = i4 - (i6 / 2);
        mPPointF.f37333y = i5 - (i7 / 2);
        drawable.copyBounds(mDrawableBoundsCache);
        Rect rect = mDrawableBoundsCache;
        int i8 = rect.left;
        int i9 = rect.top;
        drawable.setBounds(i8, i9, i8 + i6, i6 + i9);
        int save = canvas.save();
        canvas.translate(mPPointF.f37332x, mPPointF.f37333y);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    public static void drawMultilineText(Canvas canvas, StaticLayout staticLayout, float f4, float f5, TextPaint textPaint, MPPointF mPPointF, float f6) {
        float fontMetrics = textPaint.getFontMetrics(mFontMetricsBuffer);
        float width = staticLayout.getWidth();
        float lineCount = staticLayout.getLineCount() * fontMetrics;
        float f7 = 0.0f - mDrawTextRectBuffer.left;
        float f8 = lineCount + 0.0f;
        Paint.Align textAlign = textPaint.getTextAlign();
        textPaint.setTextAlign(Paint.Align.LEFT);
        if (f6 != 0.0f) {
            float f9 = f7 - (width * 0.5f);
            float f10 = f8 - (lineCount * 0.5f);
            if (mPPointF.f37332x != 0.5f || mPPointF.f37333y != 0.5f) {
                FSize sizeOfRotatedRectangleByDegrees = getSizeOfRotatedRectangleByDegrees(width, lineCount, f6);
                f4 -= sizeOfRotatedRectangleByDegrees.width * (mPPointF.f37332x - 0.5f);
                f5 -= sizeOfRotatedRectangleByDegrees.height * (mPPointF.f37333y - 0.5f);
                FSize.recycleInstance(sizeOfRotatedRectangleByDegrees);
            }
            canvas.save();
            canvas.translate(f4, f5);
            canvas.rotate(f6);
            canvas.translate(f9, f10);
            staticLayout.draw(canvas);
            canvas.restore();
        } else {
            float f11 = mPPointF.f37332x;
            if (f11 != 0.0f || mPPointF.f37333y != 0.0f) {
                f7 -= width * f11;
                f8 -= lineCount * mPPointF.f37333y;
            }
            canvas.save();
            canvas.translate(f7 + f4, f8 + f5);
            staticLayout.draw(canvas);
            canvas.restore();
        }
        textPaint.setTextAlign(textAlign);
    }

    public static void drawXAxisValue(Canvas canvas, String str, float f4, float f5, Paint paint, MPPointF mPPointF, float f6) {
        float fontMetrics = paint.getFontMetrics(mFontMetricsBuffer);
        paint.getTextBounds(str, 0, str.length(), mDrawTextRectBuffer);
        float f7 = 0.0f - mDrawTextRectBuffer.left;
        float f8 = (-mFontMetricsBuffer.ascent) + 0.0f;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f6 != 0.0f) {
            float width = f7 - (mDrawTextRectBuffer.width() * 0.5f);
            float f9 = f8 - (fontMetrics * 0.5f);
            if (mPPointF.f37332x != 0.5f || mPPointF.f37333y != 0.5f) {
                FSize sizeOfRotatedRectangleByDegrees = getSizeOfRotatedRectangleByDegrees(mDrawTextRectBuffer.width(), fontMetrics, f6);
                f4 -= sizeOfRotatedRectangleByDegrees.width * (mPPointF.f37332x - 0.5f);
                f5 -= sizeOfRotatedRectangleByDegrees.height * (mPPointF.f37333y - 0.5f);
                FSize.recycleInstance(sizeOfRotatedRectangleByDegrees);
            }
            canvas.save();
            canvas.translate(f4, f5);
            canvas.rotate(f6);
            canvas.drawText(str, width, f9, paint);
            canvas.restore();
        } else {
            if (mPPointF.f37332x != 0.0f || mPPointF.f37333y != 0.0f) {
                f7 -= mDrawTextRectBuffer.width() * mPPointF.f37332x;
                f8 -= fontMetrics * mPPointF.f37333y;
            }
            canvas.drawText(str, f7 + f4, f8 + f5, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public static String formatNumber(float f4, int i4, boolean z3) {
        return formatNumber(f4, i4, z3, '.');
    }

    private static ValueFormatter generateDefaultValueFormatter() {
        return new DefaultValueFormatter(1);
    }

    public static int getDecimals(float f4) {
        float roundToNextSignificant = roundToNextSignificant(f4);
        if (Float.isInfinite(roundToNextSignificant)) {
            return 0;
        }
        return ((int) Math.ceil(-Math.log10(roundToNextSignificant))) + 2;
    }

    public static ValueFormatter getDefaultValueFormatter() {
        return mDefaultValueFormatter;
    }

    public static float getLineHeight(Paint paint) {
        return getLineHeight(paint, mFontMetrics);
    }

    public static float getLineSpacing(Paint paint) {
        return getLineSpacing(paint, mFontMetrics);
    }

    public static int getMaximumFlingVelocity() {
        return mMaximumFlingVelocity;
    }

    public static int getMinimumFlingVelocity() {
        return mMinimumFlingVelocity;
    }

    public static float getNormalizedAngle(float f4) {
        while (f4 < 0.0f) {
            f4 += 360.0f;
        }
        return f4 % 360.0f;
    }

    public static MPPointF getPosition(MPPointF mPPointF, float f4, float f5) {
        MPPointF mPPointF2 = MPPointF.getInstance(0.0f, 0.0f);
        getPosition(mPPointF, f4, f5, mPPointF2);
        return mPPointF2;
    }

    public static int getSDKInt() {
        return Build.VERSION.SDK_INT;
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(FSize fSize, float f4) {
        return getSizeOfRotatedRectangleByRadians(fSize.width, fSize.height, f4 * 0.017453292f);
    }

    public static FSize getSizeOfRotatedRectangleByRadians(FSize fSize, float f4) {
        return getSizeOfRotatedRectangleByRadians(fSize.width, fSize.height, f4);
    }

    public static void init(Context context) {
        if (context == null) {
            mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
            mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
            return;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        mMetrics = context.getResources().getDisplayMetrics();
    }

    public static double nextUp(double d4) {
        if (d4 == Double.POSITIVE_INFINITY) {
            return d4;
        }
        double d5 = d4 + 0.0d;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d5) + (d5 >= 0.0d ? 1L : -1L));
    }

    @SuppressLint({"NewApi"})
    public static void postInvalidateOnAnimation(View view) {
        view.postInvalidateOnAnimation();
    }

    public static float roundToNextSignificant(double d4) {
        if (Double.isInfinite(d4) || Double.isNaN(d4) || d4 == 0.0d) {
            return 0.0f;
        }
        float pow = (float) Math.pow(10.0d, 1 - ((int) Math.ceil((float) Math.log10(d4 < 0.0d ? -d4 : d4))));
        double d5 = pow;
        Double.isNaN(d5);
        return ((float) Math.round(d4 * d5)) / pow;
    }

    public static void velocityTrackerPointerUpCleanUpIfNecessary(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i4 = 0; i4 < pointerCount; i4++) {
            if (i4 != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i4);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }

    public static String formatNumber(float f4, int i4, boolean z3, char c4) {
        boolean z4;
        float f5 = f4;
        char[] cArr = new char[35];
        if (f5 == 0.0f) {
            return "0";
        }
        int i5 = 0;
        boolean z5 = f5 < 1.0f && f5 > -1.0f;
        if (f5 < 0.0f) {
            f5 = -f5;
            z4 = true;
        } else {
            z4 = false;
        }
        int[] iArr = POW_10;
        int length = i4 > iArr.length ? iArr.length - 1 : i4;
        long round = Math.round(f5 * iArr[length]);
        int i6 = 34;
        boolean z6 = false;
        while (true) {
            if (round == 0 && i5 >= length + 1) {
                break;
            }
            boolean z7 = z6;
            int i7 = (int) (round % 10);
            round /= 10;
            int i8 = i6 - 1;
            cArr[i6] = (char) (i7 + 48);
            i5++;
            if (i5 == length) {
                i6 = i8 - 1;
                cArr[i8] = ',';
                i5++;
                z6 = true;
            } else {
                if (z3 && round != 0 && i5 > length) {
                    if (z7) {
                        if ((i5 - length) % 4 == 0) {
                            i6 = i8 - 1;
                            cArr[i8] = c4;
                            i5++;
                            z6 = z7;
                        }
                    } else if ((i5 - length) % 4 == 3) {
                        i6 = i8 - 1;
                        cArr[i8] = c4;
                        i5++;
                        z6 = z7;
                    }
                }
                z6 = z7;
                i6 = i8;
            }
        }
        if (z5) {
            cArr[i6] = '0';
            i5++;
            i6--;
        }
        if (z4) {
            cArr[i6] = '-';
            i5++;
        }
        int i9 = 35 - i5;
        return String.valueOf(cArr, i9, 35 - i9);
    }

    public static float getLineHeight(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getLineSpacing(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static FSize getSizeOfRotatedRectangleByDegrees(float f4, float f5, float f6) {
        return getSizeOfRotatedRectangleByRadians(f4, f5, f6 * 0.017453292f);
    }

    public static FSize getSizeOfRotatedRectangleByRadians(float f4, float f5, float f6) {
        double d4 = f6;
        return FSize.getInstance(Math.abs(((float) Math.cos(d4)) * f4) + Math.abs(((float) Math.sin(d4)) * f5), Math.abs(f4 * ((float) Math.sin(d4))) + Math.abs(f5 * ((float) Math.cos(d4))));
    }

    public static void calcTextSize(Paint paint, String str, FSize fSize) {
        Rect rect = mCalcTextSizeRect;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        fSize.width = rect.width();
        fSize.height = rect.height();
    }

    public static void getPosition(MPPointF mPPointF, float f4, float f5, MPPointF mPPointF2) {
        double d4 = mPPointF.f37332x;
        double d5 = f4;
        double d6 = f5;
        double cos = Math.cos(Math.toRadians(d6));
        Double.isNaN(d5);
        Double.isNaN(d4);
        mPPointF2.f37332x = (float) (d4 + (cos * d5));
        double d7 = mPPointF.f37333y;
        double sin = Math.sin(Math.toRadians(d6));
        Double.isNaN(d5);
        Double.isNaN(d7);
        mPPointF2.f37333y = (float) (d7 + (d5 * sin));
    }

    @Deprecated
    public static void init(Resources resources) {
        mMetrics = resources.getDisplayMetrics();
        mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
        mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
    }

    public static void drawMultilineText(Canvas canvas, String str, float f4, float f5, TextPaint textPaint, FSize fSize, MPPointF mPPointF, float f6) {
        drawMultilineText(canvas, new StaticLayout(str, 0, str.length(), textPaint, (int) Math.max(Math.ceil(fSize.width), 1.0d), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false), f4, f5, textPaint, mPPointF, f6);
    }
}
