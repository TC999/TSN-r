package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class BaseEntry {
    private Object mData;
    private Drawable mIcon;

    /* renamed from: y  reason: collision with root package name */
    private float f37325y;

    public BaseEntry() {
        this.f37325y = 0.0f;
        this.mData = null;
        this.mIcon = null;
    }

    public Object getData() {
        return this.mData;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public float getY() {
        return this.f37325y;
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
    }

    public void setY(float f4) {
        this.f37325y = f4;
    }

    public BaseEntry(float f4) {
        this.mData = null;
        this.mIcon = null;
        this.f37325y = f4;
    }

    public BaseEntry(float f4, Object obj) {
        this(f4);
        this.mData = obj;
    }

    public BaseEntry(float f4, Drawable drawable) {
        this(f4);
        this.mIcon = drawable;
    }

    public BaseEntry(float f4, Drawable drawable, Object obj) {
        this(f4);
        this.mIcon = drawable;
        this.mData = obj;
    }
}
