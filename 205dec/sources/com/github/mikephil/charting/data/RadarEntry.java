package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@SuppressLint({"ParcelCreator"})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class RadarEntry extends Entry {
    public RadarEntry(float f4) {
        super(0.0f, f4);
    }

    public float getValue() {
        return getY();
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public float getX() {
        return super.getX();
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public void setX(float f4) {
        super.setX(f4);
    }

    public RadarEntry(float f4, Object obj) {
        super(0.0f, f4, obj);
    }

    @Override // com.github.mikephil.charting.data.Entry
    public RadarEntry copy() {
        return new RadarEntry(getY(), getData());
    }
}
