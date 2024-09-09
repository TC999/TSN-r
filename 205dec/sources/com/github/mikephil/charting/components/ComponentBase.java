package com.github.mikephil.charting.components;

import android.graphics.Typeface;
import com.github.mikephil.charting.utils.Utils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class ComponentBase {
    protected boolean mEnabled = true;
    protected float mXOffset = 5.0f;
    protected float mYOffset = 5.0f;
    protected Typeface mTypeface = null;
    protected float mTextSize = Utils.convertDpToPixel(10.0f);
    protected int mTextColor = -16777216;

    public int getTextColor() {
        return this.mTextColor;
    }

    public float getTextSize() {
        return this.mTextSize;
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    public float getXOffset() {
        return this.mXOffset;
    }

    public float getYOffset() {
        return this.mYOffset;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean z3) {
        this.mEnabled = z3;
    }

    public void setTextColor(int i4) {
        this.mTextColor = i4;
    }

    public void setTextSize(float f4) {
        if (f4 > 24.0f) {
            f4 = 24.0f;
        }
        if (f4 < 6.0f) {
            f4 = 6.0f;
        }
        this.mTextSize = Utils.convertDpToPixel(f4);
    }

    public void setTypeface(Typeface typeface) {
        this.mTypeface = typeface;
    }

    public void setXOffset(float f4) {
        this.mXOffset = Utils.convertDpToPixel(f4);
    }

    public void setYOffset(float f4) {
        this.mYOffset = Utils.convertDpToPixel(f4);
    }
}
