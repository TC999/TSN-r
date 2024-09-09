package com.jg.ids.e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public abstract class c extends Binder implements b {
    public static b a(IBinder iBinder) {
        b dVar;
        if (iBinder == null) {
            return null;
        }
        try {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                dVar = new d(iBinder);
            } else {
                dVar = (b) queryLocalInterface;
            }
            return dVar;
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
                    parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    parcel2.writeNoException();
                    parcel2.writeString(a());
                    break;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    boolean a4 = a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(a4 ? 1 : 0);
                    break;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
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
