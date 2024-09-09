package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@SuppressLint({"ParcelCreator"})
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class PieEntry extends Entry {
    private String label;

    public PieEntry(float f4) {
        super(0.0f, f4);
    }

    public String getLabel() {
        return this.label;
    }

    public float getValue() {
        return getY();
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public float getX() {
        Log.i("DEPRECATED", "Pie entries do not have x values");
        return super.getX();
    }

    public void setLabel(String str) {
        this.label = str;
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public void setX(float f4) {
        super.setX(f4);
        Log.i("DEPRECATED", "Pie entries do not have x values");
    }

    public PieEntry(float f4, Object obj) {
        super(0.0f, f4, obj);
    }

    @Override // com.github.mikephil.charting.data.Entry
    public PieEntry copy() {
        return new PieEntry(getY(), this.label, getData());
    }

    public PieEntry(float f4, Drawable drawable) {
        super(0.0f, f4, drawable);
    }

    public PieEntry(float f4, Drawable drawable, Object obj) {
        super(0.0f, f4, drawable, obj);
    }

    public PieEntry(float f4, String str) {
        super(0.0f, f4);
        this.label = str;
    }

    public PieEntry(float f4, String str, Object obj) {
        super(0.0f, f4, obj);
        this.label = str;
    }

    public PieEntry(float f4, String str, Drawable drawable) {
        super(0.0f, f4, drawable);
        this.label = str;
    }

    public PieEntry(float f4, String str, Drawable drawable, Object obj) {
        super(0.0f, f4, drawable, obj);
        this.label = str;
    }
}
