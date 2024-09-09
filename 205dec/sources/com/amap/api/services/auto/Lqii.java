package com.amap.api.services.auto;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Lqii implements Parcelable {
    public static final Parcelable.Creator<Lqii> CREATOR = new Parcelable.Creator<Lqii>() { // from class: com.amap.api.services.auto.Lqii.1
        private static Lqii a(Parcel parcel) {
            return new Lqii(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Lqii createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Lqii[] newArray(int i4) {
            return a(i4);
        }

        private static Lqii[] a(int i4) {
            return new Lqii[i4];
        }
    };
    public String categoryBrandRecognitionResult;
    public String changeQueryTip;
    public String expandRangeTip;
    public String isCurrentCity;
    public String isUserCity;
    public String queryCateResult;
    public String suggestContent;
    public String targetViewCity;
    public String totalhits;
    public String viewRegion;

    public Lqii() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.categoryBrandRecognitionResult);
        parcel.writeString(this.changeQueryTip);
        parcel.writeString(this.expandRangeTip);
        parcel.writeString(this.isCurrentCity);
        parcel.writeString(this.isUserCity);
        parcel.writeString(this.queryCateResult);
        parcel.writeString(this.suggestContent);
        parcel.writeString(this.targetViewCity);
        parcel.writeString(this.totalhits);
        parcel.writeString(this.viewRegion);
    }

    protected Lqii(Parcel parcel) {
        this.categoryBrandRecognitionResult = parcel.readString();
        this.changeQueryTip = parcel.readString();
        this.expandRangeTip = parcel.readString();
        this.isCurrentCity = parcel.readString();
        this.isUserCity = parcel.readString();
        this.queryCateResult = parcel.readString();
        this.suggestContent = parcel.readString();
        this.targetViewCity = parcel.readString();
        this.totalhits = parcel.readString();
        this.viewRegion = parcel.readString();
    }
}
