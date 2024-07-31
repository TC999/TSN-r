package com.beizi.fusion.p073sm.repeackage.com.heytap.openid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.beizi.fusion.sm.repeackage.com.heytap.openid.IOpenID */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface IOpenID extends IInterface {

    /* renamed from: com.beizi.fusion.sm.repeackage.com.heytap.openid.IOpenID$Default */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class Default implements IOpenID {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.beizi.fusion.p073sm.repeackage.com.heytap.openid.IOpenID
        public String getSerID(String str, String str2, String str3) throws RemoteException {
            return null;
        }
    }

    /* renamed from: com.beizi.fusion.sm.repeackage.com.heytap.openid.IOpenID$Stub */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static abstract class Stub extends Binder implements IOpenID {
        private static final String DESCRIPTOR = "com.heytap.openid.IOpenID";
        static final int TRANSACTION_getSerID = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.beizi.fusion.sm.repeackage.com.heytap.openid.IOpenID$Stub$Proxy */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public static class Proxy implements IOpenID {
            public static IOpenID sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.beizi.fusion.p073sm.repeackage.com.heytap.openid.IOpenID
            public String getSerID(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSerID(str, str2, str3);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOpenID asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IOpenID)) {
                return (IOpenID) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IOpenID getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IOpenID iOpenID) {
            if (Proxy.sDefaultImpl != null || iOpenID == null) {
                return false;
            }
            Proxy.sDefaultImpl = iOpenID;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            String serID = getSerID(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(serID);
            return true;
        }
    }

    String getSerID(String str, String str2, String str3) throws RemoteException;
}
