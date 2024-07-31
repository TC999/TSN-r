package com.autonavi.base.p048ae.gmap.glyph;

/* renamed from: com.autonavi.base.ae.gmap.glyph.FontMetrics */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FontMetrics {
    public boolean bSuccess;
    public float fAscent;
    public float fDescent;
    public float fHeight;
    public float fLeading;

    public FontMetrics() {
        this.bSuccess = false;
        this.fAscent = 0.0f;
        this.fDescent = 0.0f;
        this.fLeading = 0.0f;
        this.fHeight = 0.0f;
    }

    public FontMetrics(float f, float f2, float f3, float f4) {
        this.bSuccess = false;
        this.fAscent = f;
        this.fDescent = f2;
        this.fLeading = f3;
        this.fHeight = f4;
    }
}
