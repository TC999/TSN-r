package com.beizi.fusion.sm.repeackage.com.google.android.gms.ads.identifier.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IAdvertisingIdService extends IInterface {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Default implements IAdvertisingIdService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.beizi.fusion.sm.repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
        public String getId() throws RemoteException {
            return null;
        }

        @Override // com.beizi.fusion.sm.repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
        public boolean isLimitAdTrackingEnabled(boolean z3) throws RemoteException {
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static abstract class Stub extends Binder implements IAdvertisingIdService {
        private static final String DESCRIPTOR = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
        static final int TRANSACTION_getId = 1;
        static final int TRANSACTION_isLimitAdTrackingEnabled = 2;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static class Proxy implements IAdvertisingIdService {
            public static IAdvertisingIdService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.beizi.fusion.sm.repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
            public String getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getId();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
            }

            @Override // com.beizi.fusion.sm.repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
            public boolean isLimitAdTrackingEnabled(boolean z3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(z3 ? 1 : 0);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isLimitAdTrackingEnabled(z3);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        }

        public static IAdvertisingIdService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IAdvertisingIdService)) {
                return (IAdvertisingIdService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IAdvertisingIdService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IAdvertisingIdService iAdvertisingIdService) {
            if (Proxy.sDefaultImpl == null) {
                if (iAdvertisingIdService != null) {
                    Proxy.sDefaultImpl = iAdvertisingIdService;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 == 1) {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                String id = getId();
                parcel2.writeNoException();
                parcel2.writeString(id);
                return true;
            } else if (i4 != 2) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                return true;
            } else {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean isLimitAdTrackingEnabled = isLimitAdTrackingEnabled(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(isLimitAdTrackingEnabled ? 1 : 0);
                return true;
            }
        }
    }

    String getId() throws RemoteException;

    boolean isLimitAdTrackingEnabled(boolean z3) throws RemoteException;
}
