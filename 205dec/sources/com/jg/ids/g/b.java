package com.jg.ids.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public abstract class b extends Binder implements a {
    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new c(iBinder) : (a) queryLocalInterface;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // android.os.Binder
    public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
        boolean z3 = true;
        try {
            switch (i4) {
                case 1:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    String a4 = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a4);
                    break;
                case 2:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    String b4 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b4);
                    break;
                case 3:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    boolean c4 = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c4 ? 1 : 0);
                    break;
                case 4:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    String a5 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a5);
                    break;
                case 5:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    String b5 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b5);
                    break;
                case 1598968902:
                    parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
                    break;
                default:
                    z3 = super.onTransact(i4, parcel, parcel2, i5);
                    break;
            }
        } catch (Throwable th) {
        }
        return z3;
    }
}
