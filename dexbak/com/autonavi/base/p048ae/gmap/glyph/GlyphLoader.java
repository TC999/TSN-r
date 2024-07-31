package com.autonavi.base.p048ae.gmap.glyph;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.autonavi.base.ae.gmap.glyph.GlyphLoader */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GlyphLoader {
    private static Map<String, Typeface> FontFaceMap = new HashMap();

    public static long createGlyphLoader() {
        return nativeCreateGlyphLoader();
    }

    private static String decodeUnicode(short s) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((char) s);
        return stringBuffer.toString();
    }

    public static void destroyGlyphLoader(long j) {
        nativeDestroyGlyphLoader(j);
    }

    private static FontMetricsRequestParam genFontMetricsParam(byte[] bArr) {
        FontMetricsRequestParam fontMetricsRequestParam = new FontMetricsRequestParam();
        fontMetricsRequestParam.fFontSize = GLConvertUtil.getInt(bArr, 0) * 0.001f;
        fontMetricsRequestParam.nFontStyleCode = GLConvertUtil.getInt(bArr, 4);
        int i = 12;
        if (1 == GLConvertUtil.getInt(bArr, 8)) {
            int i2 = GLConvertUtil.getInt(bArr, 12);
            fontMetricsRequestParam.strName = new String(bArr, 16, i2);
            i = i2 + 16;
        }
        fontMetricsRequestParam.languageArr = new String(bArr, i + 4, GLConvertUtil.getInt(bArr, i));
        return fontMetricsRequestParam;
    }

    private static GlyphRequestParam genGlyphRequestParam(byte[] bArr) {
        GlyphRequestParam glyphRequestParam = new GlyphRequestParam();
        int i = GLConvertUtil.getInt(bArr, 0);
        glyphRequestParam.strBuffer = new String(bArr, 4, i);
        int i2 = i + 4;
        Font font = new Font();
        font.nFontStyleCode = GLConvertUtil.getInt(bArr, i2);
        int i3 = i2 + 4;
        font.nFontSize = GLConvertUtil.getInt(bArr, i3);
        int i4 = i3 + 4;
        int i5 = GLConvertUtil.getInt(bArr, i4);
        int i6 = i4 + 4;
        font.strName = new String(bArr, i6, i5);
        int i7 = i6 + i5;
        FontMetrics fontMetrics = new FontMetrics();
        int i8 = GLConvertUtil.getInt(bArr, i7);
        int i9 = i7 + 4;
        fontMetrics.fAscent = i8 * 0.001f;
        int i10 = GLConvertUtil.getInt(bArr, i9);
        int i11 = i9 + 4;
        fontMetrics.fDescent = i10 * 0.001f;
        int i12 = GLConvertUtil.getInt(bArr, i11);
        int i13 = i11 + 4;
        fontMetrics.fLeading = i12 * 0.001f;
        int i14 = GLConvertUtil.getInt(bArr, i13);
        int i15 = i13 + 4;
        fontMetrics.fHeight = i14 * 0.001f;
        font.fontMetrics = fontMetrics;
        glyphRequestParam.font = font;
        glyphRequestParam.drawingMode = GLConvertUtil.getInt(bArr, i15);
        int i16 = i15 + 4;
        int i17 = GLConvertUtil.getInt(bArr, i16);
        int i18 = i16 + 4;
        glyphRequestParam.strokeWidth = i17 * 0.001f;
        int i19 = GLConvertUtil.getInt(bArr, i18);
        int i20 = i18 + 4;
        glyphRequestParam.languageArr = new String(bArr, i20, i19);
        glyphRequestParam.isEmoji = GLConvertUtil.getInt(bArr, i20);
        int i21 = i20 + 4;
        glyphRequestParam.isSDF = GLConvertUtil.getInt(bArr, i21);
        int i22 = i21 + 4;
        int i23 = GLConvertUtil.getInt(bArr, i22);
        int i24 = i22 + 4;
        if (1 == i23) {
            GlyphMetrics glyphMetrics = new GlyphMetrics();
            glyphMetrics.nWidth = GLConvertUtil.getInt(bArr, i24);
            int i25 = i24 + 4;
            glyphMetrics.nHeight = GLConvertUtil.getInt(bArr, i25);
            int i26 = i25 + 4;
            int i27 = GLConvertUtil.getInt(bArr, i26);
            int i28 = i26 + 4;
            glyphMetrics.fLeft = i27 * 0.001f;
            glyphMetrics.fTop = GLConvertUtil.getInt(bArr, i28) * 0.001f;
            glyphMetrics.fAdvance = GLConvertUtil.getInt(bArr, i28 + 4) * 0.001f;
            glyphRequestParam.fGlyphMetrics = glyphMetrics;
        }
        return glyphRequestParam;
    }

    private static FontMetrics getFontMetrics(byte[] bArr) {
        FontMetricsRequestParam genFontMetricsParam = genFontMetricsParam(bArr);
        TextPaint newTextPaint = newTextPaint(new FontStyle(genFontMetricsParam.nFontStyleCode), genFontMetricsParam.fFontSize, genFontMetricsParam.strName, false, 0.0f);
        Paint.FontMetrics fontMetrics = newTextPaint.getFontMetrics();
        FontMetrics fontMetrics2 = new FontMetrics();
        fontMetrics2.bSuccess = true;
        fontMetrics2.fAscent = Math.abs(fontMetrics.ascent);
        fontMetrics2.fDescent = Math.abs(fontMetrics.descent);
        fontMetrics2.fLeading = Math.abs(fontMetrics.leading);
        fontMetrics2.fHeight = Math.abs(fontMetrics.ascent) + Math.abs(fontMetrics.descent);
        newTextPaint.setTypeface(null);
        return fontMetrics2;
    }

    private static GlyphMetrics getGlyphMetrics(byte[] bArr) {
        GlyphRequestParam genGlyphRequestParam = genGlyphRequestParam(bArr);
        FontStyle fontStyle = new FontStyle(genGlyphRequestParam.font.nFontStyleCode);
        boolean z = genGlyphRequestParam.drawingMode != 0;
        String str = genGlyphRequestParam.strBuffer;
        Font font = genGlyphRequestParam.font;
        return loadGlyphMetrics(str, fontStyle, font.nFontSize, font.strName, z, genGlyphRequestParam.strokeWidth, genGlyphRequestParam.isEmoji > 0, genGlyphRequestParam.isSDF > 0);
    }

    private static GlyphRaster getGlyphRaster(byte[] bArr) {
        GlyphRequestParam genGlyphRequestParam = genGlyphRequestParam(bArr);
        FontStyle fontStyle = new FontStyle(genGlyphRequestParam.font.nFontStyleCode);
        int i = genGlyphRequestParam.drawingMode;
        boolean z = i != 0;
        if (i == 3) {
            String str = genGlyphRequestParam.strBuffer;
            Font font = genGlyphRequestParam.font;
            return loadPathRaster(str, fontStyle, font.nFontSize, font.strName, z, genGlyphRequestParam.strokeWidth * 2.0f);
        }
        String str2 = genGlyphRequestParam.strBuffer;
        Font font2 = genGlyphRequestParam.font;
        return loadGlyphRaster(str2, fontStyle, font2.nFontSize, font2.strName, z, genGlyphRequestParam.strokeWidth, genGlyphRequestParam.isEmoji > 0, genGlyphRequestParam.isSDF > 0);
    }

    private static GlyphMetrics loadGlyphMetrics(String str, FontStyle fontStyle, float f, String str2, boolean z, float f2, boolean z2, boolean z3) {
        GlyphMetrics glyphMetrics = new GlyphMetrics();
        if (fontStyle == null || TextUtils.isEmpty(str)) {
            return glyphMetrics;
        }
        try {
            if (!z2) {
                TextPaint newTextPaint = newTextPaint(fontStyle, f, str2, z, f2);
                Rect rect = new Rect();
                newTextPaint.getTextBounds(str, 0, str.length(), rect);
                if (rect.width() == 0 && rect.height() == 0) {
                    float measureText = newTextPaint.measureText(" ", 0, 1);
                    rect.top = 0;
                    rect.left = 0;
                    rect.right = (int) measureText;
                    rect.bottom = (int) (Math.abs(newTextPaint.getFontMetrics().ascent) + Math.abs(newTextPaint.getFontMetrics().descent));
                }
                if (z && f2 > 0.0f) {
                    float f3 = f2 / 2.0f;
                    rect.top = (int) (rect.top - f3);
                    rect.left = (int) (rect.left - f3);
                    rect.right = (int) (rect.right + f3);
                    rect.bottom = (int) (rect.bottom + f3);
                }
                glyphMetrics.bSuccess = true;
                glyphMetrics.fLeft = rect.left;
                glyphMetrics.fTop = Math.abs(newTextPaint.getFontMetrics().ascent) - Math.abs(rect.top);
                glyphMetrics.nWidth = rect.width();
                glyphMetrics.nHeight = rect.height();
                glyphMetrics.fAdvance = newTextPaint.measureText(str);
                newTextPaint.setTypeface(null);
            } else {
                glyphMetrics.bSuccess = true;
                glyphMetrics.fLeft = 0.0f;
                glyphMetrics.fTop = 0.0f;
                int i = (int) f;
                glyphMetrics.nWidth = i;
                glyphMetrics.nHeight = i;
                glyphMetrics.fAdvance = f;
            }
        } catch (Exception unused) {
            glyphMetrics.bSuccess = false;
        }
        return glyphMetrics;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:8|9|10|(9:12|13|14|(1:18)|(1:22)|23|(9:25|(7:29|(1:31)(1:49)|32|(4:34|(4:36|(2:39|37)|40|41)|42|43)|44|(1:46)(1:48)|47)|50|(0)(0)|32|(0)|44|(0)(0)|47)|51|52)|56|13|14|(2:16|18)|(2:20|22)|23|(0)|51|52) */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x013e, code lost:
        r0.bSuccess = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb A[Catch: Exception -> 0x013e, TryCatch #0 {Exception -> 0x013e, blocks: (B:16:0x004d, B:18:0x0064, B:20:0x006a, B:24:0x0096, B:25:0x00b5, B:27:0x00bb, B:36:0x00cc, B:38:0x0109, B:41:0x010f, B:43:0x0113, B:44:0x0121, B:46:0x0125, B:48:0x012b, B:50:0x0130, B:49:0x012e, B:32:0x00c4, B:51:0x013a), top: B:55:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0109 A[Catch: Exception -> 0x013e, TryCatch #0 {Exception -> 0x013e, blocks: (B:16:0x004d, B:18:0x0064, B:20:0x006a, B:24:0x0096, B:25:0x00b5, B:27:0x00bb, B:36:0x00cc, B:38:0x0109, B:41:0x010f, B:43:0x0113, B:44:0x0121, B:46:0x0125, B:48:0x012b, B:50:0x0130, B:49:0x012e, B:32:0x00c4, B:51:0x013a), top: B:55:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012b A[Catch: Exception -> 0x013e, TryCatch #0 {Exception -> 0x013e, blocks: (B:16:0x004d, B:18:0x0064, B:20:0x006a, B:24:0x0096, B:25:0x00b5, B:27:0x00bb, B:36:0x00cc, B:38:0x0109, B:41:0x010f, B:43:0x0113, B:44:0x0121, B:46:0x0125, B:48:0x012b, B:50:0x0130, B:49:0x012e, B:32:0x00c4, B:51:0x013a), top: B:55:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012e A[Catch: Exception -> 0x013e, TryCatch #0 {Exception -> 0x013e, blocks: (B:16:0x004d, B:18:0x0064, B:20:0x006a, B:24:0x0096, B:25:0x00b5, B:27:0x00bb, B:36:0x00cc, B:38:0x0109, B:41:0x010f, B:43:0x0113, B:44:0x0121, B:46:0x0125, B:48:0x012b, B:50:0x0130, B:49:0x012e, B:32:0x00c4, B:51:0x013a), top: B:55:0x004d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.autonavi.base.p048ae.gmap.glyph.GlyphRaster loadGlyphRaster(java.lang.String r8, com.autonavi.base.p048ae.gmap.glyph.FontStyle r9, float r10, java.lang.String r11, boolean r12, float r13, boolean r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.p048ae.gmap.glyph.GlyphLoader.loadGlyphRaster(java.lang.String, com.autonavi.base.ae.gmap.glyph.FontStyle, float, java.lang.String, boolean, float, boolean, boolean):com.autonavi.base.ae.gmap.glyph.GlyphRaster");
    }

    public static GlyphRaster loadPathRaster(String str, FontStyle fontStyle, float f, String str2, boolean z, float f2) {
        GlyphRaster glyphRaster = new GlyphRaster();
        if (fontStyle == null || TextUtils.isEmpty(str)) {
            return glyphRaster;
        }
        try {
            TextPaint newTextPaint = newTextPaint(fontStyle, f, str2, false, 0.0f);
            Rect rect = new Rect();
            newTextPaint.getTextBounds(str, 0, str.length(), rect);
            new Canvas(Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ALPHA_8)).drawText(str, 0 - rect.left, 0 - rect.top, newTextPaint);
            TextPaint newTextPaint2 = newTextPaint(fontStyle, f, str2, z, f2);
            Rect rect2 = new Rect();
            newTextPaint2.getTextBounds(str, 0, str.length(), rect2);
            if (z && f2 > 0.0f) {
                float f3 = 0.5f * f2;
                rect2.top = (int) (rect2.top - f3);
                rect2.left = (int) (rect2.left - f3);
                rect2.right = (int) (rect2.right + f3);
                rect2.bottom = (int) (rect2.bottom + f3);
            }
            if (!rect2.isEmpty()) {
                Bitmap createBitmap = Bitmap.createBitmap(rect2.width(), rect2.height(), Bitmap.Config.ALPHA_8);
                Canvas canvas = new Canvas(createBitmap);
                Path path = new Path();
                newTextPaint.getTextPath(str, 0, str.length(), 0 - rect2.left, 0 - rect2.top, path);
                canvas.drawPath(path, newTextPaint2);
                int width = rect2.width() * rect2.height();
                byte[] bArr = new byte[width];
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                glyphRaster.bitmapWidth = rect2.width();
                glyphRaster.bitmapHeight = rect2.height();
                glyphRaster.bitmapPixelMode = 0;
                glyphRaster.bitmapSize = width;
                createBitmap.copyPixelsToBuffer(wrap);
                createBitmap.recycle();
                glyphRaster.bitmapBuffer = bArr;
                glyphRaster.bSuccess = true;
            }
            newTextPaint.setTypeface(null);
            newTextPaint2.setTypeface(null);
        } catch (Exception unused) {
            glyphRaster.bSuccess = false;
        }
        return glyphRaster;
    }

    private static native long nativeCreateGlyphLoader();

    private static native void nativeDestroyGlyphLoader(long j);

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
        if (r3 != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.text.TextPaint newTextPaint(com.autonavi.base.p048ae.gmap.glyph.FontStyle r2, float r3, java.lang.String r4, boolean r5, float r6) {
        /*
            android.text.TextPaint r0 = new android.text.TextPaint
            r0.<init>()
            if (r2 != 0) goto L8
            return r0
        L8:
            r1 = -1
            r0.setColor(r1)
            r1 = 1
            r0.setAntiAlias(r1)
            r0.setFilterBitmap(r1)
            r0.setTextSize(r3)
            android.graphics.Paint$Align r3 = android.graphics.Paint.Align.LEFT
            r0.setTextAlign(r3)
            if (r5 == 0) goto L26
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.STROKE
            r0.setStyle(r3)
            r0.setStrokeWidth(r6)
            goto L2b
        L26:
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.FILL
            r0.setStyle(r3)
        L2b:
            int r3 = r2.getSlant()
            r5 = 2
            r6 = 0
            if (r3 == 0) goto L3a
            if (r3 == r1) goto L38
            if (r3 == r5) goto L38
            goto L3a
        L38:
            r3 = 1
            goto L3b
        L3a:
            r3 = 0
        L3b:
            int r2 = r2.getWeight()
            switch(r2) {
                case 0: goto L45;
                case 100: goto L45;
                case 200: goto L45;
                case 300: goto L45;
                case 400: goto L45;
                case 500: goto L43;
                case 600: goto L43;
                case 700: goto L43;
                case 800: goto L43;
                case 900: goto L43;
                case 1000: goto L43;
                default: goto L42;
            }
        L42:
            goto L45
        L43:
            r2 = 1
            goto L46
        L45:
            r2 = 0
        L46:
            if (r2 == 0) goto L4e
            if (r3 == 0) goto L4e
            r0.setFakeBoldText(r1)
            goto L57
        L4e:
            if (r2 == 0) goto L54
            r0.setFakeBoldText(r1)
            goto L57
        L54:
            if (r3 == 0) goto L57
            goto L58
        L57:
            r5 = 0
        L58:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.NumberFormatException -> L60
            r3 = 23
            if (r2 < r3) goto L61
            r1 = 0
            goto L61
        L60:
        L61:
            boolean r2 = r4.isEmpty()
            if (r2 != 0) goto L8c
            if (r1 == 0) goto L6a
            goto L8c
        L6a:
            java.util.Map<java.lang.String, android.graphics.Typeface> r2 = com.autonavi.base.p048ae.gmap.glyph.GlyphLoader.FontFaceMap     // Catch: java.lang.Exception -> L85
            monitor-enter(r2)     // Catch: java.lang.Exception -> L85
            java.util.Map<java.lang.String, android.graphics.Typeface> r3 = com.autonavi.base.p048ae.gmap.glyph.GlyphLoader.FontFaceMap     // Catch: java.lang.Throwable -> L82
            java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L82
            android.graphics.Typeface r3 = (android.graphics.Typeface) r3     // Catch: java.lang.Throwable -> L82
            if (r3 != 0) goto L80
            android.graphics.Typeface r3 = android.graphics.Typeface.createFromFile(r4)     // Catch: java.lang.Throwable -> L82
            java.util.Map<java.lang.String, android.graphics.Typeface> r6 = com.autonavi.base.p048ae.gmap.glyph.GlyphLoader.FontFaceMap     // Catch: java.lang.Throwable -> L82
            r6.put(r4, r3)     // Catch: java.lang.Throwable -> L82
        L80:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L82
            goto L92
        L82:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L82
            throw r3     // Catch: java.lang.Exception -> L85
        L85:
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r2, r5)
            goto L92
        L8c:
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r2, r5)
        L92:
            r0.setTypeface(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.p048ae.gmap.glyph.GlyphLoader.newTextPaint(com.autonavi.base.ae.gmap.glyph.FontStyle, float, java.lang.String, boolean, float):android.text.TextPaint");
    }

    private static String decodeUnicode(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
