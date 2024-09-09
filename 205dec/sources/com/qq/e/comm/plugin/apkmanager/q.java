package com.qq.e.comm.plugin.apkmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface q extends IInterface {
    int a(ApkDownloadTask apkDownloadTask) throws RemoteException;

    int a(String str) throws RemoteException;

    boolean a(int i4, int i5, long j4) throws RemoteException;

    boolean a(ApkDownloadTask apkDownloadTask, boolean z3) throws RemoteException;

    boolean a(String str, int i4) throws RemoteException;

    int b(String str, int i4) throws RemoteException;

    List<ApkDownloadTask> b() throws RemoteException;

    boolean b(ApkDownloadTask apkDownloadTask) throws RemoteException;

    boolean b(String str) throws RemoteException;

    ApkDownloadTask c(String str) throws RemoteException;

    List<ApkDownloadTask> c() throws RemoteException;

    boolean c(ApkDownloadTask apkDownloadTask) throws RemoteException;

    int d(ApkDownloadTask apkDownloadTask) throws RemoteException;

    int d(String str) throws RemoteException;

    List<ApkDownloadTask> d() throws RemoteException;

    boolean d(int i4) throws RemoteException;

    boolean f(int i4) throws RemoteException;

    ApkDownloadTask g(int i4) throws RemoteException;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static abstract class a extends Binder implements q {
        public a() {
            attachInterface(this, "com.qq.e.comm.plugin.apkmanager.IDownloadService");
        }

        public static q a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof q)) {
                return (q) queryLocalInterface;
            }
            return new C0784a(iBinder);
        }

        public static q e() {
            return C0784a.f41870b;
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
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        int d4 = d(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(d4);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        int a4 = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(a4);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        List<ApkDownloadTask> d5 = d();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(d5);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        List<ApkDownloadTask> c4 = c();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(c4);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        List<ApkDownloadTask> b4 = b();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(b4);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        ApkDownloadTask c5 = c(parcel.readString());
                        parcel2.writeNoException();
                        if (c5 != null) {
                            parcel2.writeInt(1);
                            c5.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 7:
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        ApkDownloadTask g4 = g(parcel.readInt());
                        parcel2.writeNoException();
                        if (g4 != null) {
                            parcel2.writeInt(1);
                            g4.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 8:
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        int a5 = a(parcel.readInt() != 0 ? ApkDownloadTask.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(a5);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        int d6 = d(parcel.readInt() != 0 ? ApkDownloadTask.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(d6);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        int b5 = b(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(b5);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        boolean f4 = f(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(f4 ? 1 : 0);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        boolean d7 = d(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(d7 ? 1 : 0);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        boolean a6 = a(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(a6 ? 1 : 0);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        boolean b6 = b(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(b6 ? 1 : 0);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        boolean c6 = c(parcel.readInt() != 0 ? ApkDownloadTask.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(c6 ? 1 : 0);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        boolean b7 = b(parcel.readInt() != 0 ? ApkDownloadTask.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(b7 ? 1 : 0);
                        return true;
                    case 17:
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        boolean a7 = a(parcel.readInt() != 0 ? ApkDownloadTask.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                        parcel2.writeNoException();
                        parcel2.writeInt(a7 ? 1 : 0);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                        boolean a8 = a(parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(a8 ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(i4, parcel, parcel2, i5);
                }
            }
            parcel2.writeString("com.qq.e.comm.plugin.apkmanager.IDownloadService");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.apkmanager.q$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public static class C0784a implements q {

            /* renamed from: b  reason: collision with root package name */
            public static q f41870b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f41871a;

            C0784a(IBinder iBinder) {
                this.f41871a = iBinder;
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public int a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    obtain.writeString(str);
                    if (!this.f41871a.transact(2, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().a(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f41871a;
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public List<ApkDownloadTask> b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    if (!this.f41871a.transact(5, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().b();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(ApkDownloadTask.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public List<ApkDownloadTask> c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    if (!this.f41871a.transact(4, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().c();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(ApkDownloadTask.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public int d(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    obtain.writeString(str);
                    if (!this.f41871a.transact(1, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().d(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public boolean f(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    obtain.writeInt(i4);
                    if (!this.f41871a.transact(11, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().f(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public ApkDownloadTask g(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    obtain.writeInt(i4);
                    if (!this.f41871a.transact(7, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().g(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? ApkDownloadTask.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public int b(String str, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    obtain.writeString(str);
                    obtain.writeInt(i4);
                    if (!this.f41871a.transact(10, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().b(str, i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public ApkDownloadTask c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    obtain.writeString(str);
                    if (!this.f41871a.transact(6, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().c(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? ApkDownloadTask.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public int a(ApkDownloadTask apkDownloadTask) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    if (apkDownloadTask != null) {
                        obtain.writeInt(1);
                        apkDownloadTask.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f41871a.transact(8, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().a(apkDownloadTask);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public List<ApkDownloadTask> d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    if (!this.f41871a.transact(3, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().d();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(ApkDownloadTask.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public int d(ApkDownloadTask apkDownloadTask) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    if (apkDownloadTask != null) {
                        obtain.writeInt(1);
                        apkDownloadTask.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f41871a.transact(9, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().d(apkDownloadTask);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public boolean b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    obtain.writeString(str);
                    if (!this.f41871a.transact(14, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public boolean a(String str, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    obtain.writeString(str);
                    obtain.writeInt(i4);
                    if (!this.f41871a.transact(13, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().a(str, i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public boolean c(ApkDownloadTask apkDownloadTask) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    if (apkDownloadTask != null) {
                        obtain.writeInt(1);
                        apkDownloadTask.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f41871a.transact(15, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().c(apkDownloadTask);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public boolean b(ApkDownloadTask apkDownloadTask) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    if (apkDownloadTask != null) {
                        obtain.writeInt(1);
                        apkDownloadTask.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f41871a.transact(16, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().b(apkDownloadTask);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public boolean d(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    obtain.writeInt(i4);
                    if (!this.f41871a.transact(12, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().d(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public boolean a(ApkDownloadTask apkDownloadTask, boolean z3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    if (apkDownloadTask != null) {
                        obtain.writeInt(1);
                        apkDownloadTask.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(z3 ? 1 : 0);
                    if (!this.f41871a.transact(17, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().a(apkDownloadTask, z3);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.qq.e.comm.plugin.apkmanager.q
            public boolean a(int i4, int i5, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.qq.e.comm.plugin.apkmanager.IDownloadService");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeLong(j4);
                    if (!this.f41871a.transact(18, obtain, obtain2, 0) && a.e() != null) {
                        return a.e().a(i4, i5, j4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
