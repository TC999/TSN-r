package xyz.adscope.common.info.deviceinfo.sm.repeackage.com.samsung.android.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IDeviceIdService extends IInterface {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Default implements IDeviceIdService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.samsung.android.deviceidservice.IDeviceIdService
        public String getOAID() {
            return null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static abstract class Stub extends Binder implements IDeviceIdService {
        private static final String DESCRIPTOR = "com.samsung.android.deviceidservice.IDeviceIdService";
        public static final int TRANSACTION_getOAID = 1;

        /* loaded from: E:\TSN-r\205dec\1574464.dex */
        public static class Proxy implements IDeviceIdService {
            public static IDeviceIdService sDefaultImpl;
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

            @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.samsung.android.deviceidservice.IDeviceIdService
            public String getOAID() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
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
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDeviceIdService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceIdService)) ? new Proxy(iBinder) : (IDeviceIdService) queryLocalInterface;
        }

        public static IDeviceIdService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDeviceIdService iDeviceIdService) {
            if (Proxy.sDefaultImpl == null) {
                if (iDeviceIdService != null) {
                    Proxy.sDefaultImpl = iDeviceIdService;
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
            if (i4 != 1) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            String oaid = getOAID();
            parcel2.writeNoException();
            parcel2.writeString(oaid);
            return true;
        }
    }

    String getOAID();
}
