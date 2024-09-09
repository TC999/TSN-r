package com.autonavi.base.ae.gmap.bean;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.amap.api.col.p0003l.a3;
import com.amap.api.col.p0003l.c;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class NativeTextGenerate {
    @JBindingExclude
    private static volatile NativeTextGenerate instance;
    @JBindingExclude
    private TextPaint text_paint_bitmap;
    @JBindingExclude
    private TextPaint text_paint_size;
    @JBindingExclude
    private float density = 1.0f;
    @JBindingExclude
    private final int kTextLayoutLeftToRight = 0;
    @JBindingExclude
    private final int kTextLayoutUpToDown = 1;
    @JBindingExclude
    private final int kTextAlignmentCenter = 0;
    @JBindingExclude
    private final int kTextAlignmentLeft = 1;
    @JBindingExclude
    private final int kTextAlignmentRight = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @JBindingInclude
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class TextGeneratePOIStyleDesc {
        int fontSize = 0;
        int fontColor = 0;
        int fontBorderColor = 0;
        int fontBgColor = 0;
        int boldFont = 0;

        TextGeneratePOIStyleDesc() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @JBindingInclude
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class TextGenerateTextBitmap {
        byte[] data;
        public int dataId;
        int dataLength;
        double height;
        BitmapDescriptor imageData;
        String text;
        double width;

        TextGenerateTextBitmap() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @JBindingInclude
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class TextGenerateTextStyle {
        int singleLineCharaterLimit = 7;
        int textAlignment = 0;
        int layoutDirection = 0;

        TextGenerateTextStyle() {
        }
    }

    @JBindingExclude
    private NativeTextGenerate() {
        this.text_paint_size = null;
        this.text_paint_bitmap = null;
        this.text_paint_size = new TextPaint();
        this.text_paint_bitmap = new TextPaint();
    }

    @JBindingInclude
    public static NativeTextGenerate getInstance() {
        if (instance == null) {
            synchronized (NativeTextGenerate.class) {
                if (instance == null) {
                    instance = new NativeTextGenerate();
                }
            }
        }
        return instance;
    }

    @JBindingExclude
    private StaticLayout setPaintStyle(TextPaint textPaint, TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return null;
        }
        float f4 = textGeneratePOIStyleDesc.fontSize * this.density;
        textPaint.setColor(textGeneratePOIStyleDesc.fontColor);
        textPaint.setTextSize(f4);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(textGeneratePOIStyleDesc.boldFont == 1 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        int i4 = textGenerateTextStyle.textAlignment;
        if (i4 == 0) {
            textPaint.setTextAlign(Paint.Align.CENTER);
        } else if (i4 != 2) {
            textPaint.setTextAlign(Paint.Align.LEFT);
        } else {
            textPaint.setTextAlign(Paint.Align.RIGHT);
        }
        int length = textGenerateTextBitmap.text.length();
        int i5 = textGenerateTextStyle.singleLineCharaterLimit;
        if (length > i5 || length % i5 != 0) {
            int i6 = (length / i5) + 1;
            i5 = (length / i6) + (length % i6 <= 0 ? 0 : 1);
        }
        return new StaticLayout(textGenerateTextBitmap.text, textPaint, (int) (f4 * i5), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    }

    @JBindingInclude
    void calculateTextBoundSize(TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return;
        }
        StaticLayout paintStyle = setPaintStyle(this.text_paint_size, textGenerateTextBitmap, textGenerateTextStyle, textGeneratePOIStyleDesc);
        float measureText = this.text_paint_size.measureText(textGenerateTextBitmap.text);
        Paint.FontMetrics fontMetrics = this.text_paint_size.getFontMetrics();
        textGenerateTextBitmap.width = measureText;
        textGenerateTextBitmap.height = fontMetrics.descent - fontMetrics.ascent;
        textGenerateTextBitmap.width = paintStyle.getWidth();
        textGenerateTextBitmap.height = paintStyle.getHeight();
    }

    @JBindingInclude
    void generateTextBitmap(TextGenerateTextBitmap textGenerateTextBitmap, TextGenerateTextStyle textGenerateTextStyle, TextGeneratePOIStyleDesc textGeneratePOIStyleDesc) {
        if (textGenerateTextBitmap == null || textGenerateTextStyle == null || textGeneratePOIStyleDesc == null) {
            return;
        }
        StaticLayout paintStyle = setPaintStyle(this.text_paint_bitmap, textGenerateTextBitmap, textGenerateTextStyle, textGeneratePOIStyleDesc);
        Bitmap createBitmap = Bitmap.createBitmap((int) textGenerateTextBitmap.width, (int) textGenerateTextBitmap.height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int i4 = textGenerateTextStyle.textAlignment;
        if (i4 == 0) {
            canvas.translate(((float) textGenerateTextBitmap.width) / 2.0f, 0.0f);
        } else if (i4 == 2) {
            canvas.translate((float) textGenerateTextBitmap.width, 0.0f);
        }
        paintStyle.draw(canvas);
        this.text_paint_bitmap.setStyle(Paint.Style.STROKE);
        this.text_paint_bitmap.setStrokeWidth(1.0f);
        this.text_paint_bitmap.setColor(textGeneratePOIStyleDesc.fontBorderColor);
        paintStyle.draw(canvas);
        int i5 = (int) (textGenerateTextBitmap.width * textGenerateTextBitmap.height * 4.0d);
        textGenerateTextBitmap.dataLength = i5;
        textGenerateTextBitmap.data = new byte[i5];
        textGenerateTextBitmap.dataId = a3.V();
        createBitmap.copyPixelsToBuffer(ByteBuffer.wrap(textGenerateTextBitmap.data));
    }

    @JBindingInclude
    BitmapDescriptor getIconBitmap(String str) {
        if (str == null) {
            return null;
        }
        try {
            Context context = c.f7290f;
            byte[] uncompress = FileUtil.uncompress(FileUtil.readFileContentsFromAssetsByPreName(context, "icons_assets", str + "_"));
            if (uncompress != null) {
                return BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeByteArray(uncompress, 0, uncompress.length));
            }
        } catch (Throwable th) {
            a3.D(th);
        }
        return null;
    }

    @JBindingInclude
    byte[] getMapStyleJsonData() {
        try {
            return FileUtil.uncompress(FileUtil.readFileContentsFromAssets(c.f7290f, "map_custom/terrain/terrainStyle.data"));
        } catch (Throwable th) {
            a3.D(th);
            return null;
        }
    }

    @JBindingExclude
    public void setDensity(float f4) {
        this.density = f4;
    }
}
