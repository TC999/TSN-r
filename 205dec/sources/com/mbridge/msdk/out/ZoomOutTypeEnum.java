package com.mbridge.msdk.out;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public enum ZoomOutTypeEnum {
    FloatBall(1),
    BigView(4),
    MediumView(3),
    SmallView(2);
    
    private int index;

    ZoomOutTypeEnum(int i4) {
        this.index = i4;
    }

    public final int getIndex() {
        return this.index;
    }
}
