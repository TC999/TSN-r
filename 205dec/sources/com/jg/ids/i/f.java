package com.jg.ids.i;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class f implements d {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f37836a;

    public f(IBinder iBinder) {
        this.f37836a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f37836a;
    }

    @Override // com.jg.ids.i.h
    public final String a(String str, String str2, String str3) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.oplus.stdid.IStdID");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            this.f37836a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
