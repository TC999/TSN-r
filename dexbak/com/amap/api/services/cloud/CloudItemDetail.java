package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CloudItemDetail extends CloudItem implements Parcelable {
    public static final Parcelable.Creator<CloudItemDetail> CREATOR = new Parcelable.Creator<CloudItemDetail>() { // from class: com.amap.api.services.cloud.CloudItemDetail.1
        /* renamed from: a */
        private static CloudItemDetail m51902a(Parcel parcel) {
            return new CloudItemDetail(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudItemDetail createFromParcel(Parcel parcel) {
            return m51902a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CloudItemDetail[] newArray(int i) {
            return m51903a(i);
        }

        /* renamed from: a */
        private static CloudItemDetail[] m51903a(int i) {
            return new CloudItemDetail[i];
        }
    };

    public CloudItemDetail(String str, LatLonPoint latLonPoint, String str2, String str3) {
        super(str, latLonPoint, str2, str3);
    }

    @Override // com.amap.api.services.cloud.CloudItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.cloud.CloudItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    protected CloudItemDetail(Parcel parcel) {
        super(parcel);
    }
}
