package cn.asus.push;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    public String f1517a;

    /* renamed from: b  reason: collision with root package name */
    public Bundle f1518b;

    /* JADX INFO: Access modifiers changed from: protected */
    public DataBuffer(Parcel parcel) {
        this.f1517a = parcel.readString();
        this.f1518b = parcel.readBundle();
    }

    public DataBuffer(String str, Bundle bundle) {
        this.f1517a = str;
        this.f1518b = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f1517a);
        parcel.writeBundle(this.f1518b);
    }
}
