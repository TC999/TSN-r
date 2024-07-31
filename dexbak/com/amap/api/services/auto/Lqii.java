package com.amap.api.services.auto;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Lqii implements Parcelable {
    public static final Parcelable.Creator<Lqii> CREATOR = new Parcelable.Creator<Lqii>() { // from class: com.amap.api.services.auto.Lqii.1
        /* renamed from: a */
        private static Lqii m51916a(Parcel parcel) {
            return new Lqii(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Lqii createFromParcel(Parcel parcel) {
            return m51916a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Lqii[] newArray(int i) {
            return m51917a(i);
        }

        /* renamed from: a */
        private static Lqii[] m51917a(int i) {
            return new Lqii[i];
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
    public void writeToParcel(Parcel parcel, int i) {
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
