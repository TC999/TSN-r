package com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IDeviceIdManager extends IInterface {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Default implements IDeviceIdManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public String getCoolOsVersion() throws RemoteException {
            return null;
        }

        @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public String getOAID(String str) throws RemoteException {
            return null;
        }

        @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public boolean isCoolOs() throws RemoteException {
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static abstract class Stub extends Binder implements IDeviceIdManager {
        private static final String DESCRIPTOR = "com.coolpad.deviceidsupport.IDeviceIdManager";
        static final int TRANSACTION_getCoolOsVersion = 7;
        static final int TRANSACTION_getOAID = 2;
        static final int TRANSACTION_isCoolOs = 6;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static class Proxy implements IDeviceIdManager {
            public static IDeviceIdManager sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public String getCoolOsVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCoolOsVersion();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "com.coolpad.deviceidsupport.IDeviceIdManager";
            }

            @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public String getOAID(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getOAID(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public boolean isCoolOs() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isCoolOs();
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
            attachInterface(this, "com.coolpad.deviceidsupport.IDeviceIdManager");
        }

        public static IDeviceIdManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDeviceIdManager)) {
                return (IDeviceIdManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IDeviceIdManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDeviceIdManager iDeviceIdManager) {
            if (Proxy.sDefaultImpl == null) {
                if (iDeviceIdManager != null) {
                    Proxy.sDefaultImpl = iDeviceIdManager;
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
            if (i4 == 2) {
                parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                String oaid = getOAID(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            } else if (i4 == 1598968902) {
                parcel2.writeString("com.coolpad.deviceidsupport.IDeviceIdManager");
                return true;
            } else if (i4 == 6) {
                parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                boolean isCoolOs = isCoolOs();
                parcel2.writeNoException();
                parcel2.writeInt(isCoolOs ? 1 : 0);
                return true;
            } else if (i4 != 7) {
                return super.onTransact(i4, parcel, parcel2, i5);
            } else {
                parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                String coolOsVersion = getCoolOsVersion();
                parcel2.writeNoException();
                parcel2.writeString(coolOsVersion);
                return true;
            }
        }
    }

    String getCoolOsVersion() throws RemoteException;

    String getOAID(String str) throws RemoteException;

    boolean isCoolOs() throws RemoteException;
}
