package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CloudImage implements Parcelable {
    public static final Parcelable.Creator<CloudImage> CREATOR = new Parcelable.Creator<CloudImage>() { // from class: com.amap.api.services.cloud.CloudImage.1
        private static CloudImage a(Parcel parcel) {
            return new CloudImage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudImage createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudImage[] newArray(int i4) {
            return a(i4);
        }

        private static CloudImage[] a(int i4) {
            return new CloudImage[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f10925a;

    /* renamed from: b  reason: collision with root package name */
    private String f10926b;

    /* renamed from: c  reason: collision with root package name */
    private String f10927c;

    public CloudImage(String str, String str2, String str3) {
        this.f10925a = str;
        this.f10926b = str2;
        this.f10927c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.f10925a;
    }

    public String getPreurl() {
        return this.f10926b;
    }

    public String getUrl() {
        return this.f10927c;
    }

    public void setId(String str) {
        this.f10925a = str;
    }

    public void setPreurl(String str) {
        this.f10926b = str;
    }

    public void setUrl(String str) {
        this.f10927c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f10925a);
        parcel.writeString(this.f10926b);
        parcel.writeString(this.f10927c);
    }

    public CloudImage(Parcel parcel) {
        this.f10925a = parcel.readString();
        this.f10926b = parcel.readString();
        this.f10927c = parcel.readString();
    }
}
