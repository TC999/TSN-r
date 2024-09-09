package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@SuppressLint({"ParcelCreator"})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class BubbleEntry extends Entry {
    private float mSize;

    public BubbleEntry(float f4, float f5, float f6) {
        super(f4, f5);
        this.mSize = f6;
    }

    public float getSize() {
        return this.mSize;
    }

    public void setSize(float f4) {
        this.mSize = f4;
    }

    @Override // com.github.mikephil.charting.data.Entry
    public BubbleEntry copy() {
        return new BubbleEntry(getX(), getY(), this.mSize, getData());
    }

    public BubbleEntry(float f4, float f5, float f6, Object obj) {
        super(f4, f5, obj);
        this.mSize = f6;
    }

    public BubbleEntry(float f4, float f5, float f6, Drawable drawable) {
        super(f4, f5, drawable);
        this.mSize = f6;
    }

    public BubbleEntry(float f4, float f5, float f6, Drawable drawable, Object obj) {
        super(f4, f5, drawable, obj);
        this.mSize = f6;
    }
}
