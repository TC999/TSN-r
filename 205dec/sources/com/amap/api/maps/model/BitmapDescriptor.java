package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003l.a3;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class BitmapDescriptor implements Parcelable, Cloneable {
    public static final BitmapDescriptorCreator CREATOR = new BitmapDescriptorCreator();

    /* renamed from: a  reason: collision with root package name */
    int f10728a;

    /* renamed from: b  reason: collision with root package name */
    int f10729b;
    @JBindingInclude
    protected Object mBitmap;
    @JBindingInclude
    private String mId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitmapDescriptor(Bitmap bitmap, String str) {
        this.f10728a = 0;
        this.f10729b = 0;
        if (bitmap != null) {
            try {
                this.f10728a = bitmap.getWidth();
                this.f10729b = bitmap.getHeight();
                if (bitmap.getConfig() == null) {
                    this.mBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                } else {
                    this.mBitmap = bitmap.copy(bitmap.getConfig(), true);
                }
            } catch (Throwable th) {
                a3.D(th);
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
        if (BitmapDescriptor.class == obj.getClass() && (obj2 = (bitmapDescriptor = (BitmapDescriptor) obj).mBitmap) != null && !((Bitmap) obj2).isRecycled() && this.f10728a == bitmapDescriptor.getWidth() && this.f10729b == bitmapDescriptor.getHeight()) {
            try {
                return ((Bitmap) this.mBitmap).sameAs((Bitmap) bitmapDescriptor.mBitmap);
            } catch (Throwable th) {
                a3.D(th);
            }
        }
        return false;
    }

    public final Bitmap getBitmap() {
        return (Bitmap) this.mBitmap;
    }

    public final int getHeight() {
        return this.f10729b;
    }

    public final String getId() {
        return this.mId;
    }

    public final int getWidth() {
        return this.f10728a;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final void recycle() {
        try {
            a3.B((Bitmap) this.mBitmap);
        } catch (Throwable th) {
            a3.D(th);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.mId);
        parcel.writeParcelable((Bitmap) this.mBitmap, i4);
        parcel.writeInt(this.f10728a);
        parcel.writeInt(this.f10729b);
    }

    /* renamed from: clone */
    public final BitmapDescriptor m19clone() {
        try {
            Object obj = this.mBitmap;
            return new BitmapDescriptor(((Bitmap) obj).copy(((Bitmap) obj).getConfig(), true), this.f10728a, this.f10729b, this.mId);
        } catch (Throwable th) {
            th.printStackTrace();
            a3.D(th);
            return null;
        }
    }

    private BitmapDescriptor(Bitmap bitmap, int i4, int i5, String str) {
        this.f10728a = i4;
        this.f10729b = i5;
        this.mBitmap = bitmap;
        this.mId = str;
    }
}
