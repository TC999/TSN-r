package com.beizi.fusion.sm.repeackage.com.bun.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface MsaIdInterface extends IInterface {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Default implements MsaIdInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.beizi.fusion.sm.repeackage.com.bun.lib.MsaIdInterface
        public String getOAID() throws RemoteException {
            return null;
        }

        @Override // com.beizi.fusion.sm.repeackage.com.bun.lib.MsaIdInterface
        public boolean isDataArrived() throws RemoteException {
            return false;
        }

        @Override // com.beizi.fusion.sm.repeackage.com.bun.lib.MsaIdInterface
        public boolean isSupported() throws RemoteException {
            return false;
        }

        @Override // com.beizi.fusion.sm.repeackage.com.bun.lib.MsaIdInterface
        public void shutDown() throws RemoteException {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static abstract class Stub extends Binder implements MsaIdInterface {
        private static final String DESCRIPTOR = "com.bun.lib.MsaIdInterface";
        static final int TRANSACTION_getOAID = 3;
        static final int TRANSACTION_isDataArrived = 2;
        static final int TRANSACTION_isSupported = 1;
        static final int TRANSACTION_shutDown = 6;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static class Proxy implements MsaIdInterface {
            public static MsaIdInterface sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.bun.lib.MsaIdInterface";
            }

            @Override // com.beizi.fusion.sm.repeackage.com.bun.lib.MsaIdInterface
            public String getOAID() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOAID();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.beizi.fusion.sm.repeackage.com.bun.lib.MsaIdInterface
            public boolean isDataArrived() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isDataArrived();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.beizi.fusion.sm.repeackage.com.bun.lib.MsaIdInterface
            public boolean isSupported() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isSupported();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.beizi.fusion.sm.repeackage.com.bun.lib.MsaIdInterface
            public void shutDown() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().shutDown();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.bun.lib.MsaIdInterface");
        }

        public static MsaIdInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof MsaIdInterface)) {
                return (MsaIdInterface) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static MsaIdInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(MsaIdInterface msaIdInterface) {
            if (Proxy.sDefaultImpl == null) {
                if (msaIdInterface != null) {
                    Proxy.sDefaultImpl = msaIdInterface;
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
                parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                boolean isSupported = isSupported();
                parcel2.writeNoException();
                parcel2.writeInt(isSupported ? 1 : 0);
                return true;
            } else if (i4 == 2) {
                parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                boolean isDataArrived = isDataArrived();
                parcel2.writeNoException();
                parcel2.writeInt(isDataArrived ? 1 : 0);
                return true;
            } else if (i4 == 3) {
                parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                String oaid = getOAID();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            } else if (i4 != 6) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString("com.bun.lib.MsaIdInterface");
                return true;
            } else {
                parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                shutDown();
                parcel2.writeNoException();
                return true;
            }
        }
    }

    String getOAID() throws RemoteException;

    boolean isDataArrived() throws RemoteException;

    boolean isSupported() throws RemoteException;

    void shutDown() throws RemoteException;
}
