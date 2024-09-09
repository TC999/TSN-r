package com.bytedance.pangle.sdk.component.log.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IBinderPool extends IInterface {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class Default implements IBinderPool {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.pangle.sdk.component.log.impl.IBinderPool
        public IBinder queryBinder(int i4) throws RemoteException {
            return null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class Stub extends Binder implements IBinderPool {
        private static final String DESCRIPTOR = "com.bytedance.pangle.sdk.component.log.impl.IBinderPool";
        static final int TRANSACTION_queryBinder = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class Proxy implements IBinderPool {
            public static IBinderPool sDefaultImpl;
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

            @Override // com.bytedance.pangle.sdk.component.log.impl.IBinderPool
            public IBinder queryBinder(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i4);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().queryBinder(i4);
                    }
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IBinderPool asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IBinderPool)) {
                return (IBinderPool) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IBinderPool getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IBinderPool iBinderPool) {
            if (Proxy.sDefaultImpl != null || iBinderPool == null) {
                return false;
            }
            Proxy.sDefaultImpl = iBinderPool;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 != 1) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            IBinder queryBinder = queryBinder(parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(queryBinder);
            return true;
        }
    }

    IBinder queryBinder(int i4) throws RemoteException;
}
