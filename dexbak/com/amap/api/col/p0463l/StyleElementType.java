package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.cx */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public enum StyleElementType {
    STYLE_ELEMENT_LABELFILL_OLD("labels.text.fill", 0),
    STYLE_ELEMENT_LABELSTROKE_OLD("labels.text.stroke", 1),
    STYLE_ELEMENT_GEOMETRYSTROKE_OLD("geometry.stroke", 2),
    STYLE_ELEMENT_GEOMETRYFILL_OLD("geometry.fill", 3),
    STYLE_ELEMENT_LABELFILL("textFillColor", 0),
    STYLE_ELEMENT_LABELSTROKE("textStrokeColor", 1),
    STYLE_ELEMENT_GEOMETRYSTROKE("strokeColor", 2),
    STYLE_ELEMENT_GEOMETRYFILL("fillColor", 3),
    STYLE_ELEMENT_GEOMETRYFILL1("color", 3),
    STYLE_ELEMENT_GEOMETRYFILL2("textureName", 3),
    STYLE_ELEMENT_BACKGROUNDFILL("backgroundColor", 4),
    STYLE_ELEMENT_VISIBLE("visible", 5);
    

    /* renamed from: m */
    private String f3786m;

    /* renamed from: n */
    private int f3787n;

    StyleElementType(String str, int i) {
        this.f3786m = str;
        this.f3787n = i;
    }

    /* renamed from: a */
    private String m55425a() {
        return this.f3786m;
    }

    /* renamed from: a */
    public static int m55424a(String str) {
        StyleElementType[] values;
        for (StyleElementType styleElementType : values()) {
            if (styleElementType.m55425a().equals(str)) {
                return styleElementType.f3787n;
            }
        }
        return -1;
    }
}
