package xyz.adscope.common.info.deviceinfo.sm.repeackage.com.google.android.gms.ads.identifier.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IAdvertisingIdService extends IInterface {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Default implements IAdvertisingIdService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
        public String getId() {
            return null;
        }

        @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
        public boolean isLimitAdTrackingEnabled(boolean z3) {
            return false;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static abstract class Stub extends Binder implements IAdvertisingIdService {
        private static final String DESCRIPTOR = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
        public static final int TRANSACTION_getId = 1;
        public static final int TRANSACTION_isLimitAdTrackingEnabled = 2;

        /* loaded from: E:\TSN-r\205dec\1574464.dex */
        public static class Proxy implements IAdvertisingIdService {
            public static IAdvertisingIdService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
            public String getId() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = Stub.getDefaultImpl().getId();
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

            @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService
            public boolean isLimitAdTrackingEnabled(boolean z3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z3 ? 1 : 0);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    }
                    return Stub.getDefaultImpl().isLimitAdTrackingEnabled(z3);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAdvertisingIdService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAdvertisingIdService)) ? new Proxy(iBinder) : (IAdvertisingIdService) queryLocalInterface;
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
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            if (i4 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                String id = getId();
                parcel2.writeNoException();
                parcel2.writeString(id);
                return true;
            } else if (i4 != 2) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                boolean isLimitAdTrackingEnabled = isLimitAdTrackingEnabled(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(isLimitAdTrackingEnabled ? 1 : 0);
                return true;
            }
        }
    }

    String getId();

    boolean isLimitAdTrackingEnabled(boolean z3);
}
