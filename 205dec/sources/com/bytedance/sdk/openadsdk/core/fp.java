package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface fp extends IInterface {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class c extends Binder implements fp {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bytedance.sdk.openadsdk.core.fp$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class C0492c implements fp {

            /* renamed from: c  reason: collision with root package name */
            public static fp f33539c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f33540w;

            C0492c(IBinder iBinder) {
                this.f33540w = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f33540w;
            }

            @Override // com.bytedance.sdk.openadsdk.core.fp
            public void c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.f33540w.transact(1, obtain, obtain2, 0) && c.r() != null) {
                        c.r().c();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.fp
            public void f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.f33540w.transact(6, obtain, obtain2, 0) && c.r() != null) {
                        c.r().f();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.fp
            public void sr() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.f33540w.transact(4, obtain, obtain2, 0) && c.r() != null) {
                        c.r().sr();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.fp
            public void ux() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.f33540w.transact(5, obtain, obtain2, 0) && c.r() != null) {
                        c.r().ux();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.fp
            public void w() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.f33540w.transact(2, obtain, obtain2, 0) && c.r() != null) {
                        c.r().w();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.fp
            public void xv() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                    if (!this.f33540w.transact(3, obtain, obtain2, 0) && c.r() != null) {
                        c.r().xv();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public c() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
        }

        public static fp c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof fp)) {
                return (fp) queryLocalInterface;
            }
            return new C0492c(iBinder);
        }

        public static fp r() {
            return C0492c.f33539c;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 != 1598968902) {
                switch (i4) {
                    case 1:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                        c();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                        w();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                        xv();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                        sr();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                        ux();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
                        f();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i4, parcel, parcel2, i5);
                }
            }
            parcel2.writeString("com.bytedance.sdk.openadsdk.core.IFullScreenVideoAdInteractionListener");
            return true;
        }
    }

    void c() throws RemoteException;

    void f() throws RemoteException;

    void sr() throws RemoteException;

    void ux() throws RemoteException;

    void w() throws RemoteException;

    void xv() throws RemoteException;
}
