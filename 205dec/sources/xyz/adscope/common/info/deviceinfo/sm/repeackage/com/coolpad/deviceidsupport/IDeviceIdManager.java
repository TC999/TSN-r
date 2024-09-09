package xyz.adscope.common.info.deviceinfo.sm.repeackage.com.coolpad.deviceidsupport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IDeviceIdManager extends IInterface {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Default implements IDeviceIdManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public String getCoolOsVersion() {
            return null;
        }

        @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public String getOAID(String str) {
            return null;
        }

        @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
        public boolean isCoolOs() {
            return false;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static abstract class Stub extends Binder implements IDeviceIdManager {
        private static final String DESCRIPTOR = "com.coolpad.deviceidsupport.IDeviceIdManager";
        public static final int TRANSACTION_getCoolOsVersion = 7;
        public static final int TRANSACTION_getOAID = 2;
        public static final int TRANSACTION_isCoolOs = 6;

        /* loaded from: E:\TSN-r\205dec\1574464.dex */
        public static class Proxy implements IDeviceIdManager {
            public static IDeviceIdManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public String getCoolOsVersion() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getCoolOsVersion();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public String getOAID(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getOAID(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager
            public boolean isCoolOs() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    }
                    return Stub.getDefaultImpl().isCoolOs();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDeviceIdManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceIdManager)) ? new Proxy(iBinder) : (IDeviceIdManager) queryLocalInterface;
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
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                String oaid = getOAID(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            } else if (i4 == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else if (i4 == 6) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean isCoolOs = isCoolOs();
                parcel2.writeNoException();
                parcel2.writeInt(isCoolOs ? 1 : 0);
                return true;
            } else if (i4 != 7) {
                return super.onTransact(i4, parcel, parcel2, i5);
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                String coolOsVersion = getCoolOsVersion();
                parcel2.writeNoException();
                parcel2.writeString(coolOsVersion);
                return true;
            }
        }
    }

    String getCoolOsVersion();

    String getOAID(String str);

    boolean isCoolOs();
}
