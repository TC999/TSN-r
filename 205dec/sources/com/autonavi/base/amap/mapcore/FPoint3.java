package com.autonavi.base.amap.mapcore;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FPoint3 extends FPoint {
    public int colorIndex;

    public FPoint3() {
        this.colorIndex = -1;
    }

    public void setColorIndex(int i4) {
        this.colorIndex = i4;
    }

    public FPoint3(float f4, float f5, int i4) {
        super(f4, f5);
        this.colorIndex = i4;
    }
}
