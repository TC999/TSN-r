package com.autonavi.base.p048ae.gmap.glyph;

/* renamed from: com.autonavi.base.ae.gmap.glyph.FontStyle */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FontStyle {
    public static final int SLANT_ITALIC = 1;
    public static final int SLANT_OBLIQUE = 2;
    public static final int SLANT_UPRIGHT = 0;
    public static final int WEIGHT_BLACK = 900;
    public static final int WEIGHT_BOLD = 700;
    public static final int WEIGHT_EXTRA_BLACK = 1000;
    public static final int WEIGHT_EXTRA_BOLD = 800;
    public static final int WEIGHT_EXTRA_LIGHT = 200;
    public static final int WEIGHT_INVISIBLE = 0;
    public static final int WEIGHT_LIGHT = 300;
    public static final int WEIGHT_MEDIUM = 500;
    public static final int WEIGHT_NORMAL = 400;
    public static final int WEIGHT_SEMI_BOLD = 600;
    public static final int WEIGHT_THIN = 100;
    public static final int WIDTH_CONDENSED = 3;
    public static final int WIDTH_EXPANDED = 7;
    public static final int WIDTH_EXTRA_CONDENSED = 2;
    public static final int WIDTH_EXTRA_EXPANDED = 8;
    public static final int WIDTH_NORMAL = 5;
    public static final int WIDTH_SEMI_CONDENSED = 4;
    public static final int WIDTH_SEMI_EXPANDED = 6;
    public static final int WIDTH_ULTRA_CONDENSED = 1;
    public static final int WIDTH_ULTRA_EXPANDED = 9;
    private int nFontStyleCode;

    public FontStyle(int i) {
        this.nFontStyleCode = i;
    }

    FontStyle Bold() {
        return new FontStyle(700, 5, 0);
    }

    FontStyle BoldItalic() {
        return new FontStyle(700, 5, 1);
    }

    FontStyle Italic() {
        return new FontStyle(WEIGHT_NORMAL, 5, 1);
    }

    FontStyle Normal() {
        return new FontStyle(WEIGHT_NORMAL, 5, 0);
    }

    int getCode() {
        return this.nFontStyleCode;
    }

    public int getSlant() {
        return (this.nFontStyleCode >> 24) & 255;
    }

    public int getWeight() {
        return this.nFontStyleCode & 65535;
    }

    public int getWidth() {
        return (this.nFontStyleCode >> 16) & 255;
    }

    boolean isBold() {
        return getWeight() >= 600;
    }

    boolean isItalic() {
        return getSlant() != 0;
    }

    public FontStyle(int i, int i2, int i3) {
        this.nFontStyleCode = (i + i2) << ((i3 << 24) + 16);
    }

    public FontStyle() {
        this.nFontStyleCode = 328080;
    }
}
