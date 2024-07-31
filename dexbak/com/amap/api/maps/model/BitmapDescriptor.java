package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0463l.C1732a3;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class BitmapDescriptor implements Parcelable, Cloneable {
    public static final BitmapDescriptorCreator CREATOR = new BitmapDescriptorCreator();

    /* renamed from: a */
    int f7026a;

    /* renamed from: b */
    int f7027b;
    @JBindingInclude
    protected Object mBitmap;
    @JBindingInclude
    private String mId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitmapDescriptor(Bitmap bitmap, String str) {
        this.f7026a = 0;
        this.f7027b = 0;
        if (bitmap != null) {
            try {
                this.f7026a = bitmap.getWidth();
                this.f7027b = bitmap.getHeight();
                if (bitmap.getConfig() == null) {
                    this.mBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                } else {
                    this.mBitmap = bitmap.copy(bitmap.getConfig(), true);
                }
            } catch (Throwable th) {
                C1732a3.m55741D(th);
                return;
            }
        }
        this.mId = str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        BitmapDescriptor bitmapDescriptor;
        Object obj2;
        Object obj3 = this.mBitmap;
        if (obj3 == null || ((Bitmap) obj3).isRecycled() || obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (BitmapDescriptor.class == obj.getClass() && (obj2 = (bitmapDescriptor = (BitmapDescriptor) obj).mBitmap) != null && !((Bitmap) obj2).isRecycled() && this.f7026a == bitmapDescriptor.getWidth() && this.f7027b == bitmapDescriptor.getHeight()) {
            try {
                return ((Bitmap) this.mBitmap).sameAs((Bitmap) bitmapDescriptor.mBitmap);
            } catch (Throwable th) {
                C1732a3.m55741D(th);
            }
        }
        return false;
    }

    public final Bitmap getBitmap() {
        return (Bitmap) this.mBitmap;
    }

    public final int getHeight() {
        return this.f7027b;
    }

    public final String getId() {
        return this.mId;
    }

    public final int getWidth() {
        return this.f7026a;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final void recycle() {
        try {
            C1732a3.m55743B((Bitmap) this.mBitmap);
        } catch (Throwable th) {
            C1732a3.m55741D(th);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeParcelable((Bitmap) this.mBitmap, i);
        parcel.writeInt(this.f7026a);
        parcel.writeInt(this.f7027b);
    }

    /* renamed from: clone */
    public final BitmapDescriptor m60098clone() {
        try {
            Object obj = this.mBitmap;
            return new BitmapDescriptor(((Bitmap) obj).copy(((Bitmap) obj).getConfig(), true), this.f7026a, this.f7027b, this.mId);
        } catch (Throwable th) {
            th.printStackTrace();
            C1732a3.m55741D(th);
            return null;
        }
    }

    private BitmapDescriptor(Bitmap bitmap, int i, int i2, String str) {
        this.f7026a = i;
        this.f7027b = i2;
        this.mBitmap = bitmap;
        this.mId = str;
    }
}
