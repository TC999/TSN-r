package com.autonavi.base.ae.gmap.glyph;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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

    public FontMetrics(float f4, float f5, float f6, float f7) {
        this.bSuccess = false;
        this.fAscent = f4;
        this.fDescent = f5;
        this.fLeading = f6;
        this.fHeight = f7;
    }
}
