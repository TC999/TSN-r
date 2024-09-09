package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PoiItemExtension implements Parcelable {
    public static final Parcelable.Creator<PoiItemExtension> CREATOR = new Parcelable.Creator<PoiItemExtension>() { // from class: com.amap.api.services.poisearch.PoiItemExtension.1
        private static PoiItemExtension a(Parcel parcel) {
            return new PoiItemExtension(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItemExtension createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItemExtension[] newArray(int i4) {
            return a(i4);
        }

        private static PoiItemExtension[] a(int i4) {
            return new PoiItemExtension[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11152a;

    /* renamed from: b  reason: collision with root package name */
    private String f11153b;

    public PoiItemExtension(String str, String str2) {
        this.f11152a = str;
        this.f11153b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getOpentime() {
        return this.f11152a;
    }

    public String getmRating() {
        return this.f11153b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11152a);
        parcel.writeString(this.f11153b);
    }

    protected PoiItemExtension(Parcel parcel) {
        this.f11152a = parcel.readString();
        this.f11153b = parcel.readString();
    }
}
