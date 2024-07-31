package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PoiItemExtension implements Parcelable {
    public static final Parcelable.Creator<PoiItemExtension> CREATOR = new Parcelable.Creator<PoiItemExtension>() { // from class: com.amap.api.services.poisearch.PoiItemExtension.1
        /* renamed from: a */
        private static PoiItemExtension m51858a(Parcel parcel) {
            return new PoiItemExtension(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItemExtension createFromParcel(Parcel parcel) {
            return m51858a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiItemExtension[] newArray(int i) {
            return m51859a(i);
        }

        /* renamed from: a */
        private static PoiItemExtension[] m51859a(int i) {
            return new PoiItemExtension[i];
        }
    };

    /* renamed from: a */
    private String f7458a;

    /* renamed from: b */
    private String f7459b;

    public PoiItemExtension(String str, String str2) {
        this.f7458a = str;
        this.f7459b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getOpentime() {
        return this.f7458a;
    }

    public String getmRating() {
        return this.f7459b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7458a);
        parcel.writeString(this.f7459b);
    }

    protected PoiItemExtension(Parcel parcel) {
        this.f7458a = parcel.readString();
        this.f7459b = parcel.readString();
    }
}
