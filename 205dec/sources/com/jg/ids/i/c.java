package com.jg.ids.i;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f37835a;

    public c(IBinder iBinder) {
        this.f37835a = iBinder;
    }

    @Override // com.jg.ids.i.h
    public final String a(String str, String str2, String str3) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            this.f37835a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            try {
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Throwable th) {
                return readString;
            }
        } catch (Throwable th2) {
            try {
                obtain2.recycle();
                obtain.recycle();
            } catch (Throwable th3) {
            }
            return "";
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f37835a;
    }
}
