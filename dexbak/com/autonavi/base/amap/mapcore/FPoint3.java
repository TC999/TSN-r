package com.autonavi.base.amap.mapcore;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FPoint3 extends FPoint {
    public int colorIndex;

    public FPoint3() {
        this.colorIndex = -1;
    }

    public void setColorIndex(int i) {
        this.colorIndex = i;
    }

    public FPoint3(float f, float f2, int i) {
        super(f, f2);
        this.colorIndex = i;
    }
}
