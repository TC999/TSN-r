package com.jg.ids.d;

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
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
        if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
            return (b) queryLocalInterface;
        }
        return new d(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
        switch (i4) {
            case 1:
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                boolean a4 = a();
                parcel2.writeNoException();
                parcel2.writeInt(a4 ? 1 : 0);
                return true;
            case 2:
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String a5 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a5);
                return true;
            case 3:
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String b4 = b();
                parcel2.writeNoException();
                parcel2.writeString(b4);
                return true;
            case 4:
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String c4 = c();
                parcel2.writeNoException();
                parcel2.writeString(c4);
                return true;
            case 5:
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String b5 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b5);
                return true;
            case 1598968902:
                parcel2.writeString("com.android.creator.IdsSupplier");
                return true;
            default:
                return super.onTransact(i4, parcel, parcel2, i5);
        }
    }

    public static b d() {
        return null;
    }
}
