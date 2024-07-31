package com.mbridge.msdk.optimize.p498a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.mbridge.msdk.optimize.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface OpenDeviceIdentifierService extends IInterface {

    /* compiled from: OpenDeviceIdentifierService.java */
    /* renamed from: com.mbridge.msdk.optimize.a.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static abstract class AbstractBinderC11544a extends Binder implements OpenDeviceIdentifierService {

        /* compiled from: OpenDeviceIdentifierService.java */
        /* renamed from: com.mbridge.msdk.optimize.a.c$a$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        private static class C11545a implements OpenDeviceIdentifierService {

            /* renamed from: a */
            private IBinder f31655a;

            C11545a(IBinder iBinder) {
                this.f31655a = iBinder;
            }

            @Override // com.mbridge.msdk.optimize.p498a.OpenDeviceIdentifierService
            /* renamed from: a */
            public final String mo21336a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.f31655a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f31655a;
            }

            @Override // com.mbridge.msdk.optimize.p498a.OpenDeviceIdentifierService
            /* renamed from: b */
            public final boolean mo21335b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.f31655a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: a */
        public static OpenDeviceIdentifierService m21337a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof OpenDeviceIdentifierService)) ? new C11545a(iBinder) : (OpenDeviceIdentifierService) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                String mo21336a = mo21336a();
                parcel2.writeNoException();
                parcel2.writeString(mo21336a);
                return true;
            } else if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                return true;
            } else {
                parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                boolean mo21335b = mo21335b();
                parcel2.writeNoException();
                parcel2.writeInt(mo21335b ? 1 : 0);
                return true;
            }
        }
    }

    /* renamed from: a */
    String mo21336a() throws RemoteException;

    /* renamed from: b */
    boolean mo21335b() throws RemoteException;
}
