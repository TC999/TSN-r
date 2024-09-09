package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface bk extends IInterface {
    IBinder c(int i4) throws RemoteException;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class c extends Binder implements bk {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bytedance.sdk.openadsdk.core.bk$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class C0474c implements bk {

            /* renamed from: c  reason: collision with root package name */
            public static bk f32037c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f32038w;

            C0474c(IBinder iBinder) {
                this.f32038w = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f32038w;
            }

            @Override // com.bytedance.sdk.openadsdk.core.bk
            public IBinder c(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IBinderPool");
                    obtain.writeInt(i4);
                    if (!this.f32038w.transact(1, obtain, obtain2, 0) && c.c() != null) {
                        return c.c().c(i4);
                    }
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public c() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IBinderPool");
        }

        public static bk c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IBinderPool");
            if (queryLocalInterface != null && (queryLocalInterface instanceof bk)) {
                return (bk) queryLocalInterface;
            }
            return new C0474c(iBinder);
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
                parcel2.writeString("com.bytedance.sdk.openadsdk.core.IBinderPool");
                return true;
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IBinderPool");
            IBinder c4 = c(parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeStrongBinder(c4);
            return true;
        }

        public static bk c() {
            return C0474c.f32037c;
        }
    }
}
