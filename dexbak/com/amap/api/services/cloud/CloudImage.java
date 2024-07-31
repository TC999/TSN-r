package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CloudImage implements Parcelable {
    public static final Parcelable.Creator<CloudImage> CREATOR = new Parcelable.Creator<CloudImage>() { // from class: com.amap.api.services.cloud.CloudImage.1
        /* renamed from: a */
        private static CloudImage m51906a(Parcel parcel) {
            return new CloudImage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudImage createFromParcel(Parcel parcel) {
            return m51906a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudImage[] newArray(int i) {
            return m51907a(i);
        }

        /* renamed from: a */
        private static CloudImage[] m51907a(int i) {
            return new CloudImage[i];
        }
    };

    /* renamed from: a */
    private String f7229a;

    /* renamed from: b */
    private String f7230b;

    /* renamed from: c */
    private String f7231c;

    public CloudImage(String str, String str2, String str3) {
        this.f7229a = str;
        this.f7230b = str2;
        this.f7231c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.f7229a;
    }

    public String getPreurl() {
        return this.f7230b;
    }

    public String getUrl() {
        return this.f7231c;
    }

    public void setId(String str) {
        this.f7229a = str;
    }

    public void setPreurl(String str) {
        this.f7230b = str;
    }

    public void setUrl(String str) {
        this.f7231c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7229a);
        parcel.writeString(this.f7230b);
        parcel.writeString(this.f7231c);
    }

    public CloudImage(Parcel parcel) {
        this.f7229a = parcel.readString();
        this.f7230b = parcel.readString();
        this.f7231c = parcel.readString();
    }
}
