package com.jg.ids.f;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public abstract class c extends Binder implements b {
    public static b a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
            return (b) queryLocalInterface;
        }
        return new d(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
        switch (i4) {
            case 1:
                parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                String a4 = a();
                parcel2.writeNoException();
                parcel2.writeString(a4);
                return true;
            case 2:
                parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                boolean b4 = b();
                parcel2.writeNoException();
                parcel2.writeInt(b4 ? 1 : 0);
                return true;
            case 1598968902:
                parcel2.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                return true;
            default:
                return super.onTransact(i4, parcel, parcel2, i5);
        }
    }

    public static b c() {
        return null;
    }
}
