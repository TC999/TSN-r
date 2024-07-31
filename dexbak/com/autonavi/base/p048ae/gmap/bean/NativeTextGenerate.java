package com.autonavi.base.p048ae.gmap.bean;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.amap.api.col.p0463l.C1732a3;
import com.amap.api.col.p0463l.MapFragmentDelegateImp;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.nio.ByteBuffer;

@JBindingInclude
/* renamed from: com.autonavi.base.ae.gmap.bean.NativeTextGenerate */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
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
    @JBindingInclude
    /* renamed from: com.autonavi.base.ae.gmap.bean.NativeTextGenerate$TextGeneratePOIStyleDesc */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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
    @JBindingInclude
    /* renamed from: com.autonavi.base.ae.gmap.bean.NativeTextGenerate$TextGenerateTextBitmap */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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
    @JBindingInclude
    /* renamed from: com.autonavi.base.ae.gmap.bean.NativeTextGenerate$TextGenerateTextStyle */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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
        float f = textGeneratePOIStyleDesc.fontSize * this.density;
        textPaint.setColor(textGeneratePOIStyleDesc.fontColor);
        textPaint.setTextSize(f);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(textGeneratePOIStyleDesc.boldFont == 1 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        int i = textGenerateTextStyle.textAlignment;
        if (i == 0) {
            textPaint.setTextAlign(Paint.Align.CENTER);
        } else if (i != 2) {
            textPaint.setTextAlign(Paint.Align.LEFT);
        } else {
            textPaint.setTextAlign(Paint.Align.RIGHT);
        }
        int length = textGenerateTextBitmap.text.length();
        int i2 = textGenerateTextStyle.singleLineCharaterLimit;
        if (length > i2 || length % i2 != 0) {
            int i3 = (length / i2) + 1;
            i2 = (length / i3) + (length % i3 <= 0 ? 0 : 1);
        }
        return new StaticLayout(textGenerateTextBitmap.text, textPaint, (int) (f * i2), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
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
        int i = textGenerateTextStyle.textAlignment;
        if (i == 0) {
            canvas.translate(((float) textGenerateTextBitmap.width) / 2.0f, 0.0f);
        } else if (i == 2) {
            canvas.translate((float) textGenerateTextBitmap.width, 0.0f);
        }
        paintStyle.draw(canvas);
        this.text_paint_bitmap.setStyle(Paint.Style.STROKE);
        this.text_paint_bitmap.setStrokeWidth(1.0f);
        this.text_paint_bitmap.setColor(textGeneratePOIStyleDesc.fontBorderColor);
        paintStyle.draw(canvas);
        int i2 = (int) (textGenerateTextBitmap.width * textGenerateTextBitmap.height * 4.0d);
        textGenerateTextBitmap.dataLength = i2;
        textGenerateTextBitmap.data = new byte[i2];
        textGenerateTextBitmap.dataId = C1732a3.m55723V();
        createBitmap.copyPixelsToBuffer(ByteBuffer.wrap(textGenerateTextBitmap.data));
    }

    @JBindingInclude
    BitmapDescriptor getIconBitmap(String str) {
        if (str == null) {
            return null;
        }
        try {
            Context context = MapFragmentDelegateImp.f3708f;
            byte[] uncompress = FileUtil.uncompress(FileUtil.readFileContentsFromAssetsByPreName(context, AMapEngineUtils.MAP_ICONS_ASSETS_NAME, str + "_"));
            if (uncompress != null) {
                return BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeByteArray(uncompress, 0, uncompress.length));
            }
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
        return null;
    }

    @JBindingInclude
    byte[] getMapStyleJsonData() {
        try {
            return FileUtil.uncompress(FileUtil.readFileContentsFromAssets(MapFragmentDelegateImp.f3708f, "map_custom/terrain/terrainStyle.data"));
        } catch (Throwable th) {
            C1732a3.m55741D(th);
            return null;
        }
    }

    @JBindingExclude
    public void setDensity(float f) {
        this.density = f;
    }
}
