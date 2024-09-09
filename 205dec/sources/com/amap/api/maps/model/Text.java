package com.amap.api.maps.model;

import android.graphics.Typeface;
import com.amap.api.col.p0003l.s1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class Text {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;
    private Marker marker;
    private TextOptions textOptions;

    public Text(Marker marker, TextOptions textOptions) {
        this.marker = marker;
        this.textOptions = textOptions;
    }

    private void a() {
        this.marker.setIcon(s1.c(this.textOptions));
    }

    public final void destroy() {
        try {
            this.marker.destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Text) {
            try {
                return this.marker.equals(((Text) obj).marker);
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public final int getAlignX() {
        try {
            return this.textOptions.getAlignX();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getAlignY() {
        try {
            return this.textOptions.getAlignY();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getBackgroundColor() {
        try {
            return this.textOptions.getBackgroundColor();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getFontColor() {
        try {
            return this.textOptions.getFontColor();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getFontSize() {
        try {
            return this.textOptions.getFontSize();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final String getId() {
        try {
            return this.marker.getId();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Object getObject() {
        return this.marker.getObject();
    }

    public final LatLng getPosition() {
        try {
            return this.marker.getPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float getRotate() {
        return this.marker.getRotateAngle();
    }

    public final String getText() {
        try {
            return this.textOptions.getText();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Typeface getTypeface() {
        try {
            return this.textOptions.getTypeface();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float getZIndex() {
        return this.marker.getZIndex();
    }

    public final int hashCode() {
        return this.marker.hashCode();
    }

    public final boolean isVisible() {
        try {
            return this.marker.isVisible();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void remove() {
        try {
            this.marker.remove();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setAlign(int i4, int i5) {
        try {
            this.textOptions.align(i4, i5);
            this.marker.setAnchor(s1.a(this.textOptions.getAlignX(), true), s1.a(this.textOptions.getAlignY(), false));
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setBackgroundColor(int i4) {
        try {
            this.textOptions.backgroundColor(i4);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setFontColor(int i4) {
        try {
            this.textOptions.fontColor(i4);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setFontSize(int i4) {
        try {
            this.textOptions.fontSize(i4);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setObject(Object obj) {
        this.marker.setObject(obj);
    }

    public final void setPosition(LatLng latLng) {
        try {
            this.marker.setPosition(latLng);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setRotate(float f4) {
        try {
            this.marker.setRotateAngle(f4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setText(String str) {
        try {
            this.textOptions.text(str);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTypeface(Typeface typeface) {
        try {
            this.textOptions.typeface(typeface);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setVisible(boolean z3) {
        try {
            this.marker.setVisible(z3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZIndex(float f4) {
        this.marker.setZIndex(f4);
    }
}
