package com.jg.ids.b;

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
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
        if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
            return (b) queryLocalInterface;
        }
        return new d(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
        switch (i4) {
            case 1:
                parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                String a4 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a4);
                return true;
            case 2:
                parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                String b4 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b4);
                return true;
            case 3:
                parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                String c4 = c(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(c4);
                return true;
            case 4:
                parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                String d4 = d(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(d4);
                return true;
            case 5:
                parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                String e4 = e(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(e4);
                return true;
            case 6:
                parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                boolean a5 = a();
                parcel2.writeNoException();
                parcel2.writeInt(a5 ? 1 : 0);
                return true;
            case 7:
                parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                String b5 = b();
                parcel2.writeNoException();
                parcel2.writeString(b5);
                return true;
            case 1598968902:
                parcel2.writeString("com.coolpad.deviceidsupport.IDeviceIdManager");
                return true;
            default:
                return super.onTransact(i4, parcel, parcel2, i5);
        }
    }

    public static b c() {
        return null;
    }
}
