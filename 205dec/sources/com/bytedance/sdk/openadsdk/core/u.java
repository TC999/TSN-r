package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface u extends IInterface {
    void c() throws RemoteException;

    void c(long j4, long j5, String str, String str2) throws RemoteException;

    void c(long j4, String str, String str2) throws RemoteException;

    void c(String str, String str2) throws RemoteException;

    void w(long j4, long j5, String str, String str2) throws RemoteException;

    void xv(long j4, long j5, String str, String str2) throws RemoteException;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class c extends Binder implements u {
        public c() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
        }

        public static u c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof u)) {
                return (u) queryLocalInterface;
            }
            return new C0512c(iBinder);
        }

        public static u w() {
            return C0512c.f34631c;
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
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                        c();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                        c(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                        w(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                        xv(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                        c(parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                        c(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i4, parcel, parcel2, i5);
                }
            }
            parcel2.writeString("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bytedance.sdk.openadsdk.core.u$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class C0512c implements u {

            /* renamed from: c  reason: collision with root package name */
            public static u f34631c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f34632w;

            C0512c(IBinder iBinder) {
                this.f34632w = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f34632w;
            }

            @Override // com.bytedance.sdk.openadsdk.core.u
            public void c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                    if (!this.f34632w.transact(1, obtain, obtain2, 0) && c.w() != null) {
                        c.w().c();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.u
            public void w(long j4, long j5, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                    obtain.writeLong(j4);
                    obtain.writeLong(j5);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    try {
                        if (!this.f34632w.transact(3, obtain, obtain2, 0) && c.w() != null) {
                            c.w().w(j4, j5, str, str2);
                            obtain2.recycle();
                            obtain.recycle();
                            return;
                        }
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.u
            public void xv(long j4, long j5, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                    obtain.writeLong(j4);
                    obtain.writeLong(j5);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    try {
                        if (!this.f34632w.transact(4, obtain, obtain2, 0) && c.w() != null) {
                            c.w().xv(j4, j5, str, str2);
                            obtain2.recycle();
                            obtain.recycle();
                            return;
                        }
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.u
            public void c(long j4, long j5, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                    obtain.writeLong(j4);
                    obtain.writeLong(j5);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    try {
                        if (!this.f34632w.transact(2, obtain, obtain2, 0) && c.w() != null) {
                            c.w().c(j4, j5, str, str2);
                            obtain2.recycle();
                            obtain.recycle();
                            return;
                        }
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.u
            public void c(long j4, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                    obtain.writeLong(j4);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f34632w.transact(5, obtain, obtain2, 0) && c.w() != null) {
                        c.w().c(j4, str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.u
            public void c(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.ITTAppDownloadListener");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f34632w.transact(6, obtain, obtain2, 0) && c.w() != null) {
                        c.w().c(str, str2);
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
