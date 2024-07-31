package com.amap.api.col.p0463l;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.TextOptions;

/* renamed from: com.amap.api.col.3l.s1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class OverlayFormatter {

    /* renamed from: a */
    private static Paint f5215a = new Paint();

    /* renamed from: b */
    private static Rect f5216b = new Rect();

    /* renamed from: a */
    public static float m54012a(int i, boolean z) {
        if (z) {
            if (i != 1) {
                return i != 2 ? 0.5f : 1.0f;
            }
            return 0.0f;
        } else if (i != 8) {
            return i != 16 ? 0.5f : 1.0f;
        } else {
            return 0.0f;
        }
    }

    /* renamed from: b */
    public static MarkerOptions m54011b(TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(textOptions.getPosition());
        markerOptions.visible(textOptions.isVisible());
        markerOptions.zIndex(textOptions.getZIndex());
        markerOptions.rotateAngle(textOptions.getRotate());
        markerOptions.icon(m54010c(textOptions));
        markerOptions.anchor(m54012a(textOptions.getAlignX(), true), m54012a(textOptions.getAlignY(), false));
        return markerOptions;
    }

    /* renamed from: c */
    public static BitmapDescriptor m54010c(TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        f5215a.setTypeface(textOptions.getTypeface());
        f5215a.setSubpixelText(true);
        f5215a.setAntiAlias(true);
        f5215a.setStrokeWidth(5.0f);
        f5215a.setStrokeCap(Paint.Cap.ROUND);
        f5215a.setTextSize(textOptions.getFontSize());
        f5215a.setTextAlign(Paint.Align.CENTER);
        f5215a.setColor(textOptions.getFontColor());
        Paint.FontMetrics fontMetrics = f5215a.getFontMetrics();
        int i = (int) (fontMetrics.descent - fontMetrics.ascent);
        int i2 = (int) (((i - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        if (textOptions.getText() != null) {
            f5215a.getTextBounds(textOptions.getText(), 0, textOptions.getText().length(), f5216b);
        }
        Bitmap createBitmap = Bitmap.createBitmap(f5216b.width() + 6, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(textOptions.getBackgroundColor());
        if (textOptions.getText() != null) {
            canvas.drawText(textOptions.getText(), f5216b.centerX() + 3, i2, f5215a);
        }
        return BitmapDescriptorFactory.fromBitmap(createBitmap);
    }
}
