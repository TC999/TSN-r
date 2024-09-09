package com.amap.api.services.auto;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Meta implements Parcelable {
    public static final Parcelable.Creator<Meta> CREATOR = new Parcelable.Creator<Meta>() { // from class: com.amap.api.services.auto.Meta.1
        private static Meta a(Parcel parcel) {
            return new Meta(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Meta createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Meta[] newArray(int i4) {
            return a(i4);
        }

        private static Meta[] a(int i4) {
            return new Meta[i4];
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
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.listBizType);
    }

    protected Meta(Parcel parcel) {
        this.listBizType = parcel.readString();
    }
}
