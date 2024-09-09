package com.bytedance.sdk.openadsdk.core;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.fp;
import com.bytedance.sdk.openadsdk.core.fz;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.ys;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface ia extends IInterface {
    void c(String str, int i4) throws RemoteException;

    void c(String str, fp fpVar) throws RemoteException;

    void c(String str, fz fzVar) throws RemoteException;

    void c(String str, s sVar) throws RemoteException;

    void c(String str, t tVar) throws RemoteException;

    void c(String str, u uVar) throws RemoteException;

    void c(String str, ys ysVar) throws RemoteException;

    void c(String str, String str2) throws RemoteException;

    void c(String str, String str2, long j4, long j5, String str3, String str4) throws RemoteException;

    void c(String str, String str2, Bundle bundle) throws RemoteException;

    Bundle w(String str, String str2, Bundle bundle) throws RemoteException;

    void w(String str, u uVar) throws RemoteException;

    void w(String str, String str2) throws RemoteException;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static abstract class c extends Binder implements ia {
        public c() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.core.IListenerManager");
        }

        public static ia c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ia)) {
                return (ia) queryLocalInterface;
            }
            return new C0497c(iBinder);
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
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                        c(parcel.readString(), fz.c.c(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                        c(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                        c(parcel.readString(), fp.c.c(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                        c(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                        c(parcel.readString(), u.c.c(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                        w(parcel.readString(), u.c.c(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                        c(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                        c(parcel.readString(), t.c.c(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                        c(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                        c(parcel.readString(), ys.c.c(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                        w(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                        c(parcel.readString(), s.c.c(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.core.IListenerManager");
                        Bundle w3 = w(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        if (w3 != null) {
                            parcel2.writeInt(1);
                            w3.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    default:
                        return super.onTransact(i4, parcel, parcel2, i5);
                }
            }
            parcel2.writeString("com.bytedance.sdk.openadsdk.core.IListenerManager");
            return true;
        }

        public static ia c() {
            return C0497c.f33762c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bytedance.sdk.openadsdk.core.ia$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6465380.dex */
        public static class C0497c implements ia {

            /* renamed from: c  reason: collision with root package name */
            public static ia f33762c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f33763w;

            C0497c(IBinder iBinder) {
                this.f33763w = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f33763w;
            }

            @Override // com.bytedance.sdk.openadsdk.core.ia
            public void c(String str, fz fzVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(fzVar != null ? fzVar.asBinder() : null);
                    if (!this.f33763w.transact(1, obtain, obtain2, 0) && c.c() != null) {
                        c.c().c(str, fzVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ia
            public void w(String str, u uVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(uVar != null ? uVar.asBinder() : null);
                    if (!this.f33763w.transact(6, obtain, obtain2, 0) && c.c() != null) {
                        c.c().w(str, uVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ia
            public void c(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f33763w.transact(2, obtain, obtain2, 0) && c.c() != null) {
                        c.c().c(str, str2, bundle);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ia
            public void w(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f33763w.transact(11, obtain, obtain2, 0) && c.c() != null) {
                        c.c().w(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ia
            public Bundle w(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f33763w.transact(13, obtain, obtain2, 0) && c.c() != null) {
                        return c.c().w(str, str2, bundle);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ia
            public void c(String str, fp fpVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(fpVar != null ? fpVar.asBinder() : null);
                    if (!this.f33763w.transact(3, obtain, obtain2, 0) && c.c() != null) {
                        c.c().c(str, fpVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ia
            public void c(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f33763w.transact(4, obtain, obtain2, 0) && c.c() != null) {
                        c.c().c(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ia
            public void c(String str, u uVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(uVar != null ? uVar.asBinder() : null);
                    if (!this.f33763w.transact(5, obtain, obtain2, 0) && c.c() != null) {
                        c.c().c(str, uVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ia
            public void c(String str, String str2, long j4, long j5, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j4);
                    obtain.writeLong(j5);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    try {
                        if (!this.f33763w.transact(7, obtain, obtain2, 0) && c.c() != null) {
                            c.c().c(str, str2, j4, j5, str3, str4);
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

            @Override // com.bytedance.sdk.openadsdk.core.ia
            public void c(String str, t tVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(tVar != null ? tVar.asBinder() : null);
                    if (!this.f33763w.transact(8, obtain, obtain2, 0) && c.c() != null) {
                        c.c().c(str, tVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ia
            public void c(String str, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeInt(i4);
                    if (!this.f33763w.transact(9, obtain, obtain2, 0) && c.c() != null) {
                        c.c().c(str, i4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ia
            public void c(String str, ys ysVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(ysVar != null ? ysVar.asBinder() : null);
                    if (!this.f33763w.transact(10, obtain, obtain2, 0) && c.c() != null) {
                        c.c().c(str, ysVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ia
            public void c(String str, s sVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.core.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(sVar != null ? sVar.asBinder() : null);
                    if (!this.f33763w.transact(12, obtain, obtain2, 0) && c.c() != null) {
                        c.c().c(str, sVar);
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
