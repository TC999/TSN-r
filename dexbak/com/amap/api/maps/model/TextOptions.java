package com.amap.api.maps.model;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.ViewCompat;
import com.umeng.analytics.pro.UContent;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class TextOptions implements Parcelable, Cloneable {
    public static final TextOptionsCreator CREATOR = new TextOptionsCreator();

    /* renamed from: a */
    String f7055a;
    private Object object;
    private LatLng position;
    private float rotate;
    private String text;
    private Typeface typeface = Typeface.DEFAULT;
    private int alignX = 4;
    private int alignY = 32;
    private int backgroundColor = -1;
    private int fontColor = ViewCompat.MEASURED_STATE_MASK;
    private int fontSize = 20;
    private float zIndex = 0.0f;
    private boolean isVisible = true;

    public final TextOptions align(int i, int i2) {
        this.alignX = i;
        this.alignY = i2;
        return this;
    }

    public final TextOptions backgroundColor(int i) {
        this.backgroundColor = i;
        return this;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final TextOptions fontColor(int i) {
        this.fontColor = i;
        return this;
    }

    public final TextOptions fontSize(int i) {
        this.fontSize = i;
        return this;
    }

    public final int getAlignX() {
        return this.alignX;
    }

    public final int getAlignY() {
        return this.alignY;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getFontColor() {
        return this.fontColor;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final Object getObject() {
        return this.object;
    }

    public final LatLng getPosition() {
        return this.position;
    }

    public final float getRotate() {
        return this.rotate;
    }

    public final String getText() {
        return this.text;
    }

    public final Typeface getTypeface() {
        return this.typeface;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final TextOptions position(LatLng latLng) {
        this.position = latLng;
        return this;
    }

    public final TextOptions rotate(float f) {
        this.rotate = f;
        return this;
    }

    public final TextOptions setObject(Object obj) {
        this.object = obj;
        return this;
    }

    public final TextOptions text(String str) {
        this.text = str;
        return this;
    }

    public final TextOptions typeface(Typeface typeface) {
        if (typeface != null) {
            this.typeface = typeface;
        }
        return this;
    }

    public final TextOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7055a);
        Bundle bundle = new Bundle();
        LatLng latLng = this.position;
        if (latLng != null) {
            bundle.putDouble(UContent.f38072C, latLng.latitude);
            bundle.putDouble(UContent.f38073D, this.position.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeString(this.text);
        parcel.writeInt(this.typeface.getStyle());
        parcel.writeFloat(this.rotate);
        parcel.writeInt(this.alignX);
        parcel.writeInt(this.alignY);
        parcel.writeInt(this.backgroundColor);
        parcel.writeInt(this.fontColor);
        parcel.writeInt(this.fontSize);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        if (this.object instanceof Parcelable) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("obj", (Parcelable) this.object);
            parcel.writeBundle(bundle2);
        }
    }

    public final TextOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }

    /* renamed from: clone */
    public final TextOptions m60107clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        TextOptions textOptions = new TextOptions();
        textOptions.f7055a = this.f7055a;
        textOptions.position = this.position;
        textOptions.text = this.text;
        textOptions.typeface = this.typeface;
        textOptions.rotate = this.rotate;
        textOptions.alignX = this.alignX;
        textOptions.alignY = this.alignY;
        textOptions.backgroundColor = this.backgroundColor;
        textOptions.fontColor = this.fontColor;
        textOptions.object = this.object;
        textOptions.fontSize = this.fontSize;
        textOptions.zIndex = this.zIndex;
        textOptions.isVisible = this.isVisible;
        return textOptions;
    }
}
