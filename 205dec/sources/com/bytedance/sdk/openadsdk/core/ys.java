package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface ys extends IInterface {
    void c() throws RemoteException;

    void c(String str) throws RemoteException;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class c extends Binder implements ys {
        public c() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
        }

        public static ys c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ys)) {
                return (ys) queryLocalInterface;
            }
            return new C0524c(iBinder);
        }

        public static ys w() {
            return C0524c.f35671c;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 == 1) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                c();
                parcel2.writeNoException();
                return true;
            } else if (i4 != 2) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                return true;
            } else {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                c(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bytedance.sdk.openadsdk.core.ys$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class C0524c implements ys {

            /* renamed from: c  reason: collision with root package name */
            public static ys f35671c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f35672w;

            C0524c(IBinder iBinder) {
                this.f35672w = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35672w;
            }

            @Override // com.bytedance.sdk.openadsdk.core.ys
            public void c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                    if (!this.f35672w.transact(1, obtain, obtain2, 0) && c.w() != null) {
                        c.w().c();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ys
            public void c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ICommonPermissionListener");
                    obtain.writeString(str);
                    if (!this.f35672w.transact(2, obtain, obtain2, 0) && c.w() != null) {
                        c.w().c(str);
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
