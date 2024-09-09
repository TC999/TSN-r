package xyz.adscope.common.info.deviceinfo.sm.repeackage.com.asus.msa.SupplementaryDID;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IDidAidlInterface extends IInterface {

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Default implements IDidAidlInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
        public String getOAID() {
            return null;
        }

        @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
        public boolean isSupport() {
            return false;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static abstract class Stub extends Binder implements IDidAidlInterface {
        private static final String DESCRIPTOR = "com.asus.msa.SupplementaryDID.IDidAidlInterface";
        public static final int TRANSACTION_getOAID = 3;
        public static final int TRANSACTION_isSupport = 1;

        /* loaded from: E:\TSN-r\205dec\1574464.dex */
        public static class Proxy implements IDidAidlInterface {
            public static IDidAidlInterface sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.asus.msa.SupplementaryDID.IDidAidlInterface";
            }

            @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
            public String getOAID() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
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

            @Override // xyz.adscope.common.info.deviceinfo.sm.repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface
            public boolean isSupport() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    }
                    return Stub.getDefaultImpl().isSupport();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.asus.msa.SupplementaryDID.IDidAidlInterface");
        }

        public static IDidAidlInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDidAidlInterface)) ? new Proxy(iBinder) : (IDidAidlInterface) queryLocalInterface;
        }

        public static IDidAidlInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDidAidlInterface iDidAidlInterface) {
            if (Proxy.sDefaultImpl == null) {
                if (iDidAidlInterface != null) {
                    Proxy.sDefaultImpl = iDidAidlInterface;
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
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                boolean isSupport = isSupport();
                parcel2.writeNoException();
                parcel2.writeInt(isSupport ? 1 : 0);
                return true;
            } else if (i4 != 3) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                return true;
            } else {
                parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                String oaid = getOAID();
                parcel2.writeNoException();
                parcel2.writeString(oaid);
                return true;
            }
        }
    }

    String getOAID();

    boolean isSupport();
}
