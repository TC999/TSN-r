package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.Utils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class Entry extends BaseEntry implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() { // from class: com.github.mikephil.charting.data.Entry.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Entry[] newArray(int i4) {
            return new Entry[i4];
        }
    };

    /* renamed from: x  reason: collision with root package name */
    private float f37326x;

    public Entry() {
        this.f37326x = 0.0f;
    }

    public Entry copy() {
        return new Entry(this.f37326x, getY(), getData());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equalTo(Entry entry) {
        if (entry != null && entry.getData() == getData()) {
            float abs = Math.abs(entry.f37326x - this.f37326x);
            float f4 = Utils.FLOAT_EPSILON;
            return abs <= f4 && Math.abs(entry.getY() - getY()) <= f4;
        }
        return false;
    }

    public float getX() {
        return this.f37326x;
    }

    public void setX(float f4) {
        this.f37326x = f4;
    }

    public String toString() {
        return "Entry, x: " + this.f37326x + " y: " + getY();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeFloat(this.f37326x);
        parcel.writeFloat(getY());
        if (getData() != null) {
            if (getData() instanceof Parcelable) {
                parcel.writeInt(1);
                parcel.writeParcelable((Parcelable) getData(), i4);
                return;
            }
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        }
        parcel.writeInt(0);
    }

    public Entry(float f4, float f5) {
        super(f5);
        this.f37326x = f4;
    }

    public Entry(float f4, float f5, Object obj) {
        super(f5, obj);
        this.f37326x = f4;
    }

    public Entry(float f4, float f5, Drawable drawable) {
        super(f5, drawable);
        this.f37326x = f4;
    }

    public Entry(float f4, float f5, Drawable drawable, Object obj) {
        super(f5, drawable, obj);
        this.f37326x = f4;
    }

    protected Entry(Parcel parcel) {
        this.f37326x = 0.0f;
        this.f37326x = parcel.readFloat();
        setY(parcel.readFloat());
        if (parcel.readInt() == 1) {
            setData(parcel.readParcelable(Object.class.getClassLoader()));
        }
    }
}
