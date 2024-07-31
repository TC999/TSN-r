package com.bytedance.pangle.servermanager;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.bytedance.pangle.servermanager.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6217a implements Parcelable {
    public static final Parcelable.Creator<C6217a> CREATOR = new Parcelable.Creator<C6217a>() { // from class: com.bytedance.pangle.servermanager.a.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ C6217a createFromParcel(Parcel parcel) {
            return new C6217a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ C6217a[] newArray(int i) {
            return new C6217a[i];
        }
    };

    /* renamed from: a */
    final IBinder f22174a;

    C6217a(Parcel parcel) {
        this.f22174a = parcel.readStrongBinder();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f22174a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6217a(IBinder iBinder) {
        this.f22174a = iBinder;
    }
}
