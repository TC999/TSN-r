package com.mbridge.msdk.optimize.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: OpenDeviceIdentifierService.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface c extends IInterface {

    /* compiled from: OpenDeviceIdentifierService.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static abstract class a extends Binder implements c {

        /* compiled from: OpenDeviceIdentifierService.java */
        /* renamed from: com.mbridge.msdk.optimize.a.c$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6520572.dex */
        private static class C0759a implements c {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f40428a;

            C0759a(IBinder iBinder) {
                this.f40428a = iBinder;
            }

            @Override // com.mbridge.msdk.optimize.a.c
            public final String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.f40428a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f40428a;
            }

            @Override // com.mbridge.msdk.optimize.a.c
            public final boolean b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.f40428a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new C0759a(iBinder) : (c) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 == 1) {
                parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                String a4 = a();
                parcel2.writeNoException();
                parcel2.writeString(a4);
                return true;
            } else if (i4 != 2) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                return true;
            } else {
                parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                boolean b4 = b();
                parcel2.writeNoException();
                parcel2.writeInt(b4 ? 1 : 0);
                return true;
            }
        }
    }

    String a() throws RemoteException;

    boolean b() throws RemoteException;
}
