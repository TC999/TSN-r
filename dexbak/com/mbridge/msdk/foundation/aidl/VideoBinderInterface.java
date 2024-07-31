package com.mbridge.msdk.foundation.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mbridge.msdk.foundation.aidl.VideoBinderListener;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface VideoBinderInterface extends IInterface {

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class Default implements VideoBinderInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.mbridge.msdk.foundation.aidl.VideoBinderInterface
        public void registerListener(VideoBinderListener videoBinderListener) throws RemoteException {
        }

        @Override // com.mbridge.msdk.foundation.aidl.VideoBinderInterface
        public void requestVideo(String[] strArr) throws RemoteException {
        }
    }

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static abstract class Stub extends Binder implements VideoBinderInterface {
        private static final String DESCRIPTOR = "com.mbridge.msdk.foundation.aidl.VideoBinderInterface";
        static final int TRANSACTION_registerListener = 2;
        static final int TRANSACTION_requestVideo = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.mbridge.msdk.foundation.aidl.VideoBinderInterface$Stub$a */
        /* loaded from: E:\fuckcool\tsn\6520572.dex */
        public static class C11248a implements VideoBinderInterface {

            /* renamed from: a */
            public static VideoBinderInterface f30202a;

            /* renamed from: b */
            private IBinder f30203b;

            C11248a(IBinder iBinder) {
                this.f30203b = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f30203b;
            }

            @Override // com.mbridge.msdk.foundation.aidl.VideoBinderInterface
            public final void registerListener(VideoBinderListener videoBinderListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(videoBinderListener != null ? videoBinderListener.asBinder() : null);
                    if (!this.f30203b.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().registerListener(videoBinderListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.mbridge.msdk.foundation.aidl.VideoBinderInterface
            public final void requestVideo(String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStringArray(strArr);
                    if (!this.f30203b.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().requestVideo(strArr);
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
            attachInterface(this, DESCRIPTOR);
        }

        public static VideoBinderInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof VideoBinderInterface)) {
                return (VideoBinderInterface) queryLocalInterface;
            }
            return new C11248a(iBinder);
        }

        public static VideoBinderInterface getDefaultImpl() {
            return C11248a.f30202a;
        }

        public static boolean setDefaultImpl(VideoBinderInterface videoBinderInterface) {
            if (C11248a.f30202a == null) {
                if (videoBinderInterface != null) {
                    C11248a.f30202a = videoBinderInterface;
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
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                requestVideo(parcel.createStringArray());
                parcel2.writeNoException();
                return true;
            } else if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                registerListener(VideoBinderListener.AbstractBinderC11249a.m22940a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void registerListener(VideoBinderListener videoBinderListener) throws RemoteException;

    void requestVideo(String[] strArr) throws RemoteException;
}
