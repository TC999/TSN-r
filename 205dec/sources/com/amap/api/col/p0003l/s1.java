package com.amap.api.col.p0003l;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.TextOptions;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OverlayFormatter.java */
/* renamed from: com.amap.api.col.3l.s1  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class s1 {

    /* renamed from: a  reason: collision with root package name */
    private static Paint f8927a = new Paint();

    /* renamed from: b  reason: collision with root package name */
    private static Rect f8928b = new Rect();

    public static float a(int i4, boolean z3) {
        if (z3) {
            if (i4 != 1) {
                return i4 != 2 ? 0.5f : 1.0f;
            }
            return 0.0f;
        } else if (i4 != 8) {
            return i4 != 16 ? 0.5f : 1.0f;
        } else {
            return 0.0f;
        }
    }

    public static MarkerOptions b(TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(textOptions.getPosition());
        markerOptions.visible(textOptions.isVisible());
        markerOptions.zIndex(textOptions.getZIndex());
        markerOptions.rotateAngle(textOptions.getRotate());
        markerOptions.icon(c(textOptions));
        markerOptions.anchor(a(textOptions.getAlignX(), true), a(textOptions.getAlignY(), false));
        return markerOptions;
    }

    public static BitmapDescriptor c(TextOptions textOptions) {
        if (textOptions == null) {
            return null;
        }
        f8927a.setTypeface(textOptions.getTypeface());
        f8927a.setSubpixelText(true);
        f8927a.setAntiAlias(true);
        f8927a.setStrokeWidth(5.0f);
        f8927a.setStrokeCap(Paint.Cap.ROUND);
        f8927a.setTextSize(textOptions.getFontSize());
        f8927a.setTextAlign(Paint.Align.CENTER);
        f8927a.setColor(textOptions.getFontColor());
        Paint.FontMetrics fontMetrics = f8927a.getFontMetrics();
        int i4 = (int) (fontMetrics.descent - fontMetrics.ascent);
        int i5 = (int) (((i4 - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        if (textOptions.getText() != null) {
            f8927a.getTextBounds(textOptions.getText(), 0, textOptions.getText().length(), f8928b);
        }
        Bitmap createBitmap = Bitmap.createBitmap(f8928b.width() + 6, i4, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(textOptions.getBackgroundColor());
        if (textOptions.getText() != null) {
            canvas.drawText(textOptions.getText(), f8928b.centerX() + 3, i5, f8927a);
        }
        return BitmapDescriptorFactory.fromBitmap(createBitmap);
    }
}
