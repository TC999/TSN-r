package com.jg.ids.f;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f37824a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(IBinder iBinder) {
        this.f37824a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f37824a;
    }

    @Override // com.jg.ids.f.b
    public final String a() {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (!this.f37824a.transact(1, obtain, obtain2, 0) && c.c() != null) {
                readString = c.c().a();
            } else {
                obtain2.readException();
                readString = obtain2.readString();
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.jg.ids.f.b
    public final boolean b() {
        boolean z3;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (!this.f37824a.transact(2, obtain, obtain2, 0) && c.c() != null) {
                z3 = c.c().b();
            } else {
                obtain2.readException();
                z3 = obtain2.readInt() != 0;
            }
            return z3;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
