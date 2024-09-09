package com.amap.api.col.p0003l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: StyleElementType.java */
/* renamed from: com.amap.api.col.3l.cx  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public enum cx {
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
    

    /* renamed from: m  reason: collision with root package name */
    private String f7356m;

    /* renamed from: n  reason: collision with root package name */
    private int f7357n;

    cx(String str, int i4) {
        this.f7356m = str;
        this.f7357n = i4;
    }

    private String a() {
        return this.f7356m;
    }

    public static int a(String str) {
        cx[] values;
        for (cx cxVar : values()) {
            if (cxVar.a().equals(str)) {
                return cxVar.f7357n;
            }
        }
        return -1;
    }
}
