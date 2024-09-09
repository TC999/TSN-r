package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface fz extends IInterface {
    void c() throws RemoteException;

    void c(boolean z3, int i4, Bundle bundle) throws RemoteException;

    void c(boolean z3, int i4, String str, int i5, String str2) throws RemoteException;

    void f() throws RemoteException;

    void r() throws RemoteException;

    void sr() throws RemoteException;

    void ux() throws RemoteException;

    void w() throws RemoteException;

    void xv() throws RemoteException;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class c extends Binder implements fz {
        public c() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
        }

        public static fz c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof fz)) {
                return (fz) queryLocalInterface;
            }
            return new C0493c(iBinder);
        }

        public static fz ev() {
            return C0493c.f33664c;
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
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        c();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        w();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        xv();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        sr();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        ux();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        f();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        c(parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        c(parcel.readInt() != 0, parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                        r();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i4, parcel, parcel2, i5);
                }
            }
            parcel2.writeString("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bytedance.sdk.openadsdk.core.fz$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class C0493c implements fz {

            /* renamed from: c  reason: collision with root package name */
            public static fz f33664c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f33665w;

            C0493c(IBinder iBinder) {
                this.f33665w = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f33665w;
            }

            @Override // com.bytedance.sdk.openadsdk.core.fz
            public void c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    if (!this.f33665w.transact(1, obtain, obtain2, 0) && c.ev() != null) {
                        c.ev().c();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.fz
            public void f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    if (!this.f33665w.transact(6, obtain, obtain2, 0) && c.ev() != null) {
                        c.ev().f();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.fz
            public void r() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    if (!this.f33665w.transact(9, obtain, obtain2, 0) && c.ev() != null) {
                        c.ev().r();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.fz
            public void sr() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    if (!this.f33665w.transact(4, obtain, obtain2, 0) && c.ev() != null) {
                        c.ev().sr();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.fz
            public void ux() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    if (!this.f33665w.transact(5, obtain, obtain2, 0) && c.ev() != null) {
                        c.ev().ux();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.fz
            public void w() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    if (!this.f33665w.transact(2, obtain, obtain2, 0) && c.ev() != null) {
                        c.ev().w();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.fz
            public void xv() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    if (!this.f33665w.transact(3, obtain, obtain2, 0) && c.ev() != null) {
                        c.ev().xv();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.fz
            public void c(boolean z3, int i4, String str, int i5, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    obtain.writeInt(z3 ? 1 : 0);
                    obtain.writeInt(i4);
                    obtain.writeString(str);
                    obtain.writeInt(i5);
                    obtain.writeString(str2);
                    if (!this.f33665w.transact(7, obtain, obtain2, 0) && c.ev() != null) {
                        c.ev().c(z3, i4, str, i5, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.fz
            public void c(boolean z3, int i4, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IRewardAdInteractionListener");
                    obtain.writeInt(z3 ? 1 : 0);
                    obtain.writeInt(i4);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f33665w.transact(8, obtain, obtain2, 0) && c.ev() != null) {
                        c.ev().c(z3, i4, bundle);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
