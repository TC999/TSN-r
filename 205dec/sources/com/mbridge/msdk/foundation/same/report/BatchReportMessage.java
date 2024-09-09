package com.mbridge.msdk.foundation.same.report;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class BatchReportMessage implements Parcelable {
    public static final Parcelable.Creator<BatchReportMessage> CREATOR = new Parcelable.Creator<BatchReportMessage>() { // from class: com.mbridge.msdk.foundation.same.report.BatchReportMessage.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BatchReportMessage createFromParcel(Parcel parcel) {
            return new BatchReportMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BatchReportMessage[] newArray(int i4) {
            return new BatchReportMessage[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f39666a;

    /* renamed from: b  reason: collision with root package name */
    private String f39667b;

    /* renamed from: c  reason: collision with root package name */
    private long f39668c;

    public BatchReportMessage(String str, String str2, long j4) {
        this.f39666a = str;
        this.f39667b = str2;
        this.f39668c = j4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getReportMessage() {
        return this.f39667b;
    }

    public long getTimestamp() {
        return this.f39668c;
    }

    public String getUuid() {
        return this.f39666a;
    }

    public void setReportMessage(String str) {
        this.f39667b = str;
    }

    public void setTimestamp(long j4) {
        this.f39668c = j4;
    }

    public void setUuid(String str) {
        this.f39666a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f39666a);
        parcel.writeString(this.f39667b);
        parcel.writeLong(this.f39668c);
    }

    protected BatchReportMessage(Parcel parcel) {
        this.f39666a = parcel.readString();
        this.f39667b = parcel.readString();
        this.f39668c = parcel.readLong();
    }
}
