package xyz.adscope.common.info.deviceinfo.sm.repeackage.com.uodis.opendevice.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface OpenDeviceIdentifierService extends IInterface {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Default implements OpenDeviceIdentifierService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.uodis.opendevice.aidl.OpenDeviceIdentifierService
        public String getOaid() {
            return null;
        }

        @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.uodis.opendevice.aidl.OpenDeviceIdentifierService
        public boolean isOaidTrackLimited() {
            return false;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static abstract class Stub extends Binder implements OpenDeviceIdentifierService {
        private static final String DESCRIPTOR = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
        public static final int TRANSACTION_getOaid = 1;
        public static final int TRANSACTION_isOaidTrackLimited = 2;

        /* loaded from: E:\TSN-r\205dec\1574464.dex */
        public static class Proxy implements OpenDeviceIdentifierService {
            public static OpenDeviceIdentifierService sDefaultImpl;
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

            @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.uodis.opendevice.aidl.OpenDeviceIdentifierService
            public String getOaid() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getOaid();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.uodis.opendevice.aidl.OpenDeviceIdentifierService
            public boolean isOaidTrackLimited() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    }
                    return Stub.getDefaultImpl().isOaidTrackLimited();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static OpenDeviceIdentifierService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof OpenDeviceIdentifierService)) ? new Proxy(iBinder) : (OpenDeviceIdentifierService) queryLocalInterface;
        }

        public static OpenDeviceIdentifierService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(OpenDeviceIdentifierService openDeviceIdentifierService) {
            if (Proxy.sDefaultImpl == null) {
                if (openDeviceIdentifierService != null) {
                    Proxy.sDefaultImpl = openDeviceIdentifierService;
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
                String oaid = getOaid();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            } else if (i4 != 2) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                boolean isOaidTrackLimited = isOaidTrackLimited();
                parcel2.writeNoException();
                parcel2.writeInt(isOaidTrackLimited ? 1 : 0);
                return true;
            }
        }
    }

    String getOaid();

    boolean isOaidTrackLimited();
}
