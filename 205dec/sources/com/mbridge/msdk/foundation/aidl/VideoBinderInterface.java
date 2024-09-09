package com.mbridge.msdk.foundation.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.mbridge.msdk.foundation.aidl.VideoBinderListener;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface VideoBinderInterface extends IInterface {

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
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

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static abstract class Stub extends Binder implements VideoBinderInterface {
        private static final String DESCRIPTOR = "com.mbridge.msdk.foundation.aidl.VideoBinderInterface";
        static final int TRANSACTION_registerListener = 2;
        static final int TRANSACTION_requestVideo = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: E:\TSN-r\205dec\6520572.dex */
        public static class a implements VideoBinderInterface {

            /* renamed from: a  reason: collision with root package name */
            public static VideoBinderInterface f39029a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f39030b;

            a(IBinder iBinder) {
                this.f39030b = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f39030b;
            }

            @Override // com.mbridge.msdk.foundation.aidl.VideoBinderInterface
            public final void registerListener(VideoBinderListener videoBinderListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(videoBinderListener != null ? videoBinderListener.asBinder() : null);
                    if (!this.f39030b.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
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
                    if (!this.f39030b.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
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
            return new a(iBinder);
        }

        public static VideoBinderInterface getDefaultImpl() {
            return a.f39029a;
        }

        public static boolean setDefaultImpl(VideoBinderInterface videoBinderInterface) {
            if (a.f39029a == null) {
                if (videoBinderInterface != null) {
                    a.f39029a = videoBinderInterface;
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
            if (i4 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                requestVideo(parcel.createStringArray());
                parcel2.writeNoException();
                return true;
            } else if (i4 != 2) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                registerListener(VideoBinderListener.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void registerListener(VideoBinderListener videoBinderListener) throws RemoteException;

    void requestVideo(String[] strArr) throws RemoteException;
}
