package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class Entry extends BaseEntry implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() { // from class: com.github.mikephil.charting.data.Entry.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Entry[] newArray(int i) {
            return new Entry[i];
        }
    };

    /* renamed from: x */
    private float f23766x;

    public Entry() {
        this.f23766x = 0.0f;
    }

    public Entry copy() {
        return new Entry(this.f23766x, getY(), getData());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equalTo(Entry entry) {
        if (entry != null && entry.getData() == getData()) {
            float abs = Math.abs(entry.f23766x - this.f23766x);
            float f = Utils.FLOAT_EPSILON;
            return abs <= f && Math.abs(entry.getY() - getY()) <= f;
        }
        return false;
    }

    public float getX() {
        return this.f23766x;
    }

    public void setX(float f) {
        this.f23766x = f;
    }

    public String toString() {
        return "Entry, x: " + this.f23766x + " y: " + getY();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f23766x);
        parcel.writeFloat(getY());
        if (getData() != null) {
            if (getData() instanceof Parcelable) {
                parcel.writeInt(1);
                parcel.writeParcelable((Parcelable) getData(), i);
                return;
            }
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        }
        parcel.writeInt(0);
    }

    public Entry(float f, float f2) {
        super(f2);
        this.f23766x = f;
    }

    public Entry(float f, float f2, Object obj) {
        super(f2, obj);
        this.f23766x = f;
    }

    public Entry(float f, float f2, Drawable drawable) {
        super(f2, drawable);
        this.f23766x = f;
    }

    public Entry(float f, float f2, Drawable drawable, Object obj) {
        super(f2, drawable, obj);
        this.f23766x = f;
    }

    protected Entry(Parcel parcel) {
        this.f23766x = 0.0f;
        this.f23766x = parcel.readFloat();
        setY(parcel.readFloat());
        if (parcel.readInt() == 1) {
            setData(parcel.readParcelable(Object.class.getClassLoader()));
        }
    }
}
