package com.mbridge.msdk.foundation.same.report;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BatchReportMessage implements Parcelable {
    public static final Parcelable.Creator<BatchReportMessage> CREATOR = new Parcelable.Creator<BatchReportMessage>() { // from class: com.mbridge.msdk.foundation.same.report.BatchReportMessage.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BatchReportMessage createFromParcel(Parcel parcel) {
            return new BatchReportMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BatchReportMessage[] newArray(int i) {
            return new BatchReportMessage[i];
        }
    };

    /* renamed from: a */
    private String f30893a;

    /* renamed from: b */
    private String f30894b;

    /* renamed from: c */
    private long f30895c;

    public BatchReportMessage(String str, String str2, long j) {
        this.f30893a = str;
        this.f30894b = str2;
        this.f30895c = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getReportMessage() {
        return this.f30894b;
    }

    public long getTimestamp() {
        return this.f30895c;
    }

    public String getUuid() {
        return this.f30893a;
    }

    public void setReportMessage(String str) {
        this.f30894b = str;
    }

    public void setTimestamp(long j) {
        this.f30895c = j;
    }

    public void setUuid(String str) {
        this.f30893a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f30893a);
        parcel.writeString(this.f30894b);
        parcel.writeLong(this.f30895c);
    }

    protected BatchReportMessage(Parcel parcel) {
        this.f30893a = parcel.readString();
        this.f30894b = parcel.readString();
        this.f30895c = parcel.readLong();
    }
}
