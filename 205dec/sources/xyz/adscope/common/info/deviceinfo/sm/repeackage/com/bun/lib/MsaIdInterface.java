package xyz.adscope.common.info.deviceinfo.sm.repeackage.com.bun.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface MsaIdInterface extends IInterface {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Default implements MsaIdInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.bun.lib.MsaIdInterface
        public String getOAID() {
            return null;
        }

        @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.bun.lib.MsaIdInterface
        public boolean isDataArrived() {
            return false;
        }

        @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.bun.lib.MsaIdInterface
        public boolean isSupported() {
            return false;
        }

        @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.bun.lib.MsaIdInterface
        public void shutDown() {
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static abstract class Stub extends Binder implements MsaIdInterface {
        private static final String DESCRIPTOR = "com.bun.lib.MsaIdInterface";
        public static final int TRANSACTION_getOAID = 3;
        public static final int TRANSACTION_isDataArrived = 2;
        public static final int TRANSACTION_isSupported = 1;
        public static final int TRANSACTION_shutDown = 6;

        /* loaded from: E:\TSN-r\205dec\1574464.dex */
        public static class Proxy implements MsaIdInterface {
            public static MsaIdInterface sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.bun.lib.MsaIdInterface
            public String getOAID() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getOAID();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.bun.lib.MsaIdInterface
            public boolean isDataArrived() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    }
                    return Stub.getDefaultImpl().isDataArrived();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.bun.lib.MsaIdInterface
            public boolean isSupported() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    }
                    return Stub.getDefaultImpl().isSupported();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.bun.lib.MsaIdInterface
            public void shutDown() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().shutDown();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static MsaIdInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof MsaIdInterface)) ? new Proxy(iBinder) : (MsaIdInterface) queryLocalInterface;
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
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean isSupported = isSupported();
                parcel2.writeNoException();
                parcel2.writeInt(isSupported ? 1 : 0);
                return true;
            } else if (i4 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean isDataArrived = isDataArrived();
                parcel2.writeNoException();
                parcel2.writeInt(isDataArrived ? 1 : 0);
                return true;
            } else if (i4 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                String oaid = getOAID();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            } else if (i4 != 6) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                shutDown();
                parcel2.writeNoException();
                return true;
            }
        }
    }

    String getOAID();

    boolean isDataArrived();

    boolean isSupported();

    void shutDown();
}
