package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@SuppressLint({"ParcelCreator"})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class CandleEntry extends Entry {
    private float mClose;
    private float mOpen;
    private float mShadowHigh;
    private float mShadowLow;

    public CandleEntry(float f4, float f5, float f6, float f7, float f8) {
        super(f4, (f5 + f6) / 2.0f);
        this.mShadowHigh = f5;
        this.mShadowLow = f6;
        this.mOpen = f7;
        this.mClose = f8;
    }

    public float getBodyRange() {
        return Math.abs(this.mOpen - this.mClose);
    }

    public float getClose() {
        return this.mClose;
    }

    public float getHigh() {
        return this.mShadowHigh;
    }

    public float getLow() {
        return this.mShadowLow;
    }

    public float getOpen() {
        return this.mOpen;
    }

    public float getShadowRange() {
        return Math.abs(this.mShadowHigh - this.mShadowLow);
    }

    @Override // com.github.mikephil.charting.data.BaseEntry
    public float getY() {
        return super.getY();
    }

    public void setClose(float f4) {
        this.mClose = f4;
    }

    public void setHigh(float f4) {
        this.mShadowHigh = f4;
    }

    public void setLow(float f4) {
        this.mShadowLow = f4;
    }

    public void setOpen(float f4) {
        this.mOpen = f4;
    }

    @Override // com.github.mikephil.charting.data.Entry
    public CandleEntry copy() {
        return new CandleEntry(getX(), this.mShadowHigh, this.mShadowLow, this.mOpen, this.mClose, getData());
    }

    public CandleEntry(float f4, float f5, float f6, float f7, float f8, Object obj) {
        super(f4, (f5 + f6) / 2.0f, obj);
        this.mShadowHigh = f5;
        this.mShadowLow = f6;
        this.mOpen = f7;
        this.mClose = f8;
    }

    public CandleEntry(float f4, float f5, float f6, float f7, float f8, Drawable drawable) {
        super(f4, (f5 + f6) / 2.0f, drawable);
        this.mShadowHigh = f5;
        this.mShadowLow = f6;
        this.mOpen = f7;
        this.mClose = f8;
    }

    public CandleEntry(float f4, float f5, float f6, float f7, float f8, Drawable drawable, Object obj) {
        super(f4, (f5 + f6) / 2.0f, drawable, obj);
        this.mShadowHigh = f5;
        this.mShadowLow = f6;
        this.mOpen = f7;
        this.mClose = f8;
    }
}
