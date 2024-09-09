package com.autonavi.base.amap.mapcore.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.amap.api.col.p0003l.a3;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TextTextureGenerator {
    private static final int ALIGNCENTER = 51;
    private static final int ALIGNLEFT = 49;
    private static final int ALIGNRIGHT = 50;
    static final int AN_LABEL_MAXCHARINLINE = 7;
    static final int AN_LABEL_MULITYLINE_SPAN = 2;
    private int TEXT_FONTSIZE = -1;
    private int TEXT_FONTSIZE_TRUE = -1;
    private float base_line = 0.0f;
    private float start_x = 0.0f;
    private Paint text_paint = null;

    public TextTextureGenerator() {
        createTextParam();
    }

    public static int GetNearstSize2N(int i4) {
        int i5 = 1;
        while (i4 > i5) {
            i5 *= 2;
        }
        return i5;
    }

    private void createTextParam() {
        float f4;
        float f5;
        Paint.FontMetrics fontMetrics;
        int i4 = this.TEXT_FONTSIZE - 2;
        this.TEXT_FONTSIZE_TRUE = i4;
        Paint newPaint = newPaint(null, i4, 49);
        this.text_paint = newPaint;
        float f6 = (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE) / 2.0f;
        this.start_x = f6;
        try {
            fontMetrics = newPaint.getFontMetrics();
            f4 = fontMetrics.descent;
        } catch (Exception unused) {
            f4 = 7.3242188f;
        }
        try {
            f5 = fontMetrics.ascent;
        } catch (Exception unused2) {
            f5 = -27.832031f;
            this.base_line = ((this.TEXT_FONTSIZE_TRUE - (f4 + f5)) / 2.0f) + f6 + 0.5f;
        }
        this.base_line = ((this.TEXT_FONTSIZE_TRUE - (f4 + f5)) / 2.0f) + f6 + 0.5f;
    }

    public static float getFontHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getFontlength(Paint paint, String str) {
        return paint.measureText(str);
    }

    private static Paint newPaint(String str, int i4, int i5) {
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(-1);
        textPaint.setTextSize(i4);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        switch (i5) {
            case 49:
                textPaint.setTextAlign(Paint.Align.LEFT);
                break;
            case 50:
                textPaint.setTextAlign(Paint.Align.RIGHT);
                break;
            case 51:
                textPaint.setTextAlign(Paint.Align.CENTER);
                break;
            default:
                textPaint.setTextAlign(Paint.Align.LEFT);
                break;
        }
        return textPaint;
    }

    public byte[] getCharsWidths(int[] iArr) {
        int length = iArr.length;
        byte[] bArr = new byte[length];
        float[] fArr = new float[1];
        for (int i4 = 0; i4 < length; i4++) {
            Paint paint = this.text_paint;
            StringBuilder sb = new StringBuilder();
            sb.append((char) iArr[i4]);
            fArr[0] = paint.measureText(sb.toString());
            bArr[i4] = (byte) (fArr[0] + (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE));
        }
        return bArr;
    }

    public byte[] getTextPixelBuffer(int i4, int i5) {
        if (this.TEXT_FONTSIZE != i5) {
            this.TEXT_FONTSIZE = i5;
            createTextParam();
        }
        try {
            char c4 = (char) i4;
            char[] cArr = {c4};
            float f4 = this.base_line;
            int i6 = this.TEXT_FONTSIZE;
            Bitmap createBitmap = Bitmap.createBitmap(i6, i6, Bitmap.Config.ALPHA_8);
            Canvas canvas = new Canvas(createBitmap);
            int i7 = this.TEXT_FONTSIZE;
            byte[] bArr = new byte[i7 * i7];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            float measureText = this.text_paint.measureText(String.valueOf(c4));
            if (cArr[0] > 0 && cArr[0] < '\u0100') {
                f4 -= 1.5f;
            }
            float f5 = f4;
            Paint.Align textAlign = this.text_paint.getTextAlign();
            float textSize = this.text_paint.getTextSize();
            float f6 = measureText - this.TEXT_FONTSIZE_TRUE;
            Paint.Align align = Paint.Align.CENTER;
            if (textAlign != align && f6 >= 4.0f) {
                this.text_paint.setTextAlign(align);
                this.text_paint.setTextSize(this.TEXT_FONTSIZE_TRUE - f6);
                canvas.drawText(cArr, 0, 1, (this.TEXT_FONTSIZE_TRUE - f6) / 2.0f, f5, this.text_paint);
                this.text_paint.setTextAlign(textAlign);
                this.text_paint.setTextSize(textSize);
            } else {
                canvas.drawText(cArr, 0, 1, this.start_x, f5, this.text_paint);
            }
            createBitmap.copyPixelsToBuffer(wrap);
            a3.B(createBitmap);
            return bArr;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }
}
