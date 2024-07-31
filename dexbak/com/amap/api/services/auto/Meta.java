package com.amap.api.services.auto;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Meta implements Parcelable {
    public static final Parcelable.Creator<Meta> CREATOR = new Parcelable.Creator<Meta>() { // from class: com.amap.api.services.auto.Meta.1
        /* renamed from: a */
        private static Meta m51914a(Parcel parcel) {
            return new Meta(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Meta createFromParcel(Parcel parcel) {
            return m51914a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Meta[] newArray(int i) {
            return m51915a(i);
        }

        /* renamed from: a */
        private static Meta[] m51915a(int i) {
            return new Meta[i];
        }
    };
    public String listBizType;

    public Meta() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.listBizType);
    }

    protected Meta(Parcel parcel) {
        this.listBizType = parcel.readString();
    }
}
