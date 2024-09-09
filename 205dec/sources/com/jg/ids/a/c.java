package com.jg.ids.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public abstract class c extends Binder implements b {
    public static b a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDidAidlInterface.Stub.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new d(iBinder) : (b) queryLocalInterface;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // android.os.Binder
    public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
        boolean z3 = true;
        if (i4 != 1598968902) {
            switch (i4) {
                case 1:
                    parcel.enforceInterface(IDidAidlInterface.Stub.DESCRIPTOR);
                    boolean a4 = a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a4 ? 1 : 0);
                    break;
                case 2:
                    parcel.enforceInterface(IDidAidlInterface.Stub.DESCRIPTOR);
                    String b4 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b4);
                    break;
                case 3:
                    parcel.enforceInterface(IDidAidlInterface.Stub.DESCRIPTOR);
                    String c4 = c();
                    parcel2.writeNoException();
                    parcel2.writeString(c4);
                    break;
                case 4:
                    parcel.enforceInterface(IDidAidlInterface.Stub.DESCRIPTOR);
                    String d4 = d();
                    parcel2.writeNoException();
                    parcel2.writeString(d4);
                    break;
                case 5:
                    parcel.enforceInterface(IDidAidlInterface.Stub.DESCRIPTOR);
                    String e4 = e();
                    parcel2.writeNoException();
                    parcel2.writeString(e4);
                    break;
                default:
                    try {
                        z3 = super.onTransact(i4, parcel, parcel2, i5);
                        break;
                    } catch (RemoteException e5) {
                        break;
                    }
            }
            return z3;
        }
        parcel2.writeString(IDidAidlInterface.Stub.DESCRIPTOR);
        return z3;
    }
}
