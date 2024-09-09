package com.ss.android.socialbase.downloader.w;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.w.w;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface xv extends IInterface {
    DownloadInfo c(int i4, int i5) throws RemoteException;

    DownloadInfo c(int i4, long j4) throws RemoteException;

    DownloadInfo c(int i4, long j4, String str, String str2) throws RemoteException;

    List<DownloadInfo> c(String str) throws RemoteException;

    void c() throws RemoteException;

    void c(int i4, int i5, int i6, int i7) throws RemoteException;

    void c(int i4, int i5, int i6, long j4) throws RemoteException;

    void c(int i4, int i5, long j4) throws RemoteException;

    void c(int i4, List<com.ss.android.socialbase.downloader.model.w> list) throws RemoteException;

    void c(com.ss.android.socialbase.downloader.model.w wVar) throws RemoteException;

    void c(w wVar) throws RemoteException;

    boolean c(int i4) throws RemoteException;

    boolean c(DownloadInfo downloadInfo) throws RemoteException;

    DownloadInfo ev(int i4) throws RemoteException;

    boolean f(int i4) throws RemoteException;

    DownloadInfo gd(int i4) throws RemoteException;

    DownloadInfo p(int i4) throws RemoteException;

    DownloadInfo r(int i4) throws RemoteException;

    DownloadInfo sr(int i4, long j4) throws RemoteException;

    List<DownloadInfo> sr(String str) throws RemoteException;

    void sr(int i4) throws RemoteException;

    boolean sr() throws RemoteException;

    DownloadInfo ux(int i4, long j4) throws RemoteException;

    boolean ux() throws RemoteException;

    boolean ux(int i4) throws RemoteException;

    DownloadInfo w(int i4) throws RemoteException;

    DownloadInfo w(int i4, long j4) throws RemoteException;

    List<DownloadInfo> w() throws RemoteException;

    List<DownloadInfo> w(String str) throws RemoteException;

    void w(int i4, List<com.ss.android.socialbase.downloader.model.w> list) throws RemoteException;

    void w(DownloadInfo downloadInfo) throws RemoteException;

    void w(com.ss.android.socialbase.downloader.model.w wVar) throws RemoteException;

    DownloadInfo xv(int i4, long j4) throws RemoteException;

    List<com.ss.android.socialbase.downloader.model.w> xv(int i4) throws RemoteException;

    List<DownloadInfo> xv(String str) throws RemoteException;

    void xv() throws RemoteException;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static abstract class c extends Binder implements xv {
        public c() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        }

        public static xv c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (queryLocalInterface != null && (queryLocalInterface instanceof xv)) {
                return (xv) queryLocalInterface;
            }
            return new C1025c(iBinder);
        }

        public static xv f() {
            return C1025c.f50229c;
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
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        c();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean c4 = c(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(c4 ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo w3 = w(parcel.readInt());
                        parcel2.writeNoException();
                        if (w3 != null) {
                            parcel2.writeInt(1);
                            w3.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<DownloadInfo> c5 = c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(c5);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<DownloadInfo> w4 = w(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(w4);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<DownloadInfo> xv = xv(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(xv);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<DownloadInfo> sr = sr(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(sr);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<DownloadInfo> w5 = w();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(w5);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        List<com.ss.android.socialbase.downloader.model.w> xv2 = xv(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeTypedList(xv2);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        sr(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        c(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.w.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        w(parcel.readInt() != 0 ? com.ss.android.socialbase.downloader.model.w.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        c(parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        c(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        c(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo c6 = c(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        if (c6 != null) {
                            parcel2.writeInt(1);
                            c6.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 17:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean c7 = c(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        parcel2.writeInt(c7 ? 1 : 0);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean ux = ux(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(ux ? 1 : 0);
                        return true;
                    case 19:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean f4 = f(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(f4 ? 1 : 0);
                        return true;
                    case 20:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        xv();
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo r3 = r(parcel.readInt());
                        parcel2.writeNoException();
                        if (r3 != null) {
                            parcel2.writeInt(1);
                            r3.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 22:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo c8 = c(parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        if (c8 != null) {
                            parcel2.writeInt(1);
                            c8.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 23:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo c9 = c(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (c9 != null) {
                            parcel2.writeInt(1);
                            c9.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 24:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo w6 = w(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (w6 != null) {
                            parcel2.writeInt(1);
                            w6.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 25:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo ev = ev(parcel.readInt());
                        parcel2.writeNoException();
                        if (ev != null) {
                            parcel2.writeInt(1);
                            ev.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 26:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo xv3 = xv(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (xv3 != null) {
                            parcel2.writeInt(1);
                            xv3.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 27:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo sr2 = sr(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (sr2 != null) {
                            parcel2.writeInt(1);
                            sr2.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 28:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo ux2 = ux(parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        if (ux2 != null) {
                            parcel2.writeInt(1);
                            ux2.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 29:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo gd = gd(parcel.readInt());
                        parcel2.writeNoException();
                        if (gd != null) {
                            parcel2.writeInt(1);
                            gd.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 30:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        DownloadInfo p3 = p(parcel.readInt());
                        parcel2.writeNoException();
                        if (p3 != null) {
                            parcel2.writeInt(1);
                            p3.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 31:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean sr3 = sr();
                        parcel2.writeNoException();
                        parcel2.writeInt(sr3 ? 1 : 0);
                        return true;
                    case 32:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        boolean ux3 = ux();
                        parcel2.writeNoException();
                        parcel2.writeInt(ux3 ? 1 : 0);
                        return true;
                    case 33:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        w(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 34:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        c(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.w.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        w(parcel.readInt(), parcel.createTypedArrayList(com.ss.android.socialbase.downloader.model.w.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 36:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                        c(w.c.c(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i4, parcel, parcel2, i5);
                }
            }
            parcel2.writeString("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.w.xv$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6206960.dex */
        public static class C1025c implements xv {

            /* renamed from: c  reason: collision with root package name */
            public static xv f50229c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f50230w;

            C1025c(IBinder iBinder) {
                this.f50230w = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f50230w;
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public void c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f50230w.transact(1, obtain, obtain2, 0) && c.f() != null) {
                        c.f().c();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public DownloadInfo ev(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f50230w.transact(25, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().ev(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public boolean f(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f50230w.transact(19, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().f(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public DownloadInfo gd(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f50230w.transact(29, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().gd(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv, com.ss.android.socialbase.downloader.downloader.k
            public DownloadInfo p(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f50230w.transact(30, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().p(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public DownloadInfo r(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f50230w.transact(21, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().r(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public List<DownloadInfo> sr(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (!this.f50230w.transact(7, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().sr(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public boolean ux(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f50230w.transact(18, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().ux(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public DownloadInfo w(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f50230w.transact(3, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().w(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public List<DownloadInfo> xv(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (!this.f50230w.transact(6, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().xv(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public boolean c(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f50230w.transact(2, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().c(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public void sr(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f50230w.transact(10, obtain, obtain2, 0) && c.f() != null) {
                        c.f().sr(i4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public DownloadInfo ux(int i4, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeLong(j4);
                    if (!this.f50230w.transact(28, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().ux(i4, j4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public List<com.ss.android.socialbase.downloader.model.w> xv(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    if (!this.f50230w.transact(9, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().xv(i4);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(com.ss.android.socialbase.downloader.model.w.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public List<DownloadInfo> w(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (!this.f50230w.transact(5, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().w(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public List<DownloadInfo> c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    if (!this.f50230w.transact(4, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().c(str);
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public DownloadInfo sr(int i4, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeLong(j4);
                    if (!this.f50230w.transact(27, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().sr(i4, j4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public void xv() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f50230w.transact(20, obtain, obtain2, 0) && c.f() != null) {
                        c.f().xv();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public List<DownloadInfo> w() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f50230w.transact(8, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().w();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public boolean ux() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f50230w.transact(32, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().ux();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public void c(com.ss.android.socialbase.downloader.model.w wVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (wVar != null) {
                        obtain.writeInt(1);
                        wVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f50230w.transact(11, obtain, obtain2, 0) && c.f() != null) {
                        c.f().c(wVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public DownloadInfo xv(int i4, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeLong(j4);
                    if (!this.f50230w.transact(26, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().xv(i4, j4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public void w(com.ss.android.socialbase.downloader.model.w wVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (wVar != null) {
                        obtain.writeInt(1);
                        wVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f50230w.transact(12, obtain, obtain2, 0) && c.f() != null) {
                        c.f().w(wVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public boolean sr() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (!this.f50230w.transact(31, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().sr();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public void c(int i4, int i5, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeLong(j4);
                    if (!this.f50230w.transact(13, obtain, obtain2, 0) && c.f() != null) {
                        c.f().c(i4, i5, j4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public DownloadInfo w(int i4, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeLong(j4);
                    if (!this.f50230w.transact(24, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().w(i4, j4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public void c(int i4, int i5, int i6, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeInt(i6);
                    obtain.writeLong(j4);
                    if (!this.f50230w.transact(14, obtain, obtain2, 0) && c.f() != null) {
                        c.f().c(i4, i5, i6, j4);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public void w(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f50230w.transact(33, obtain, obtain2, 0) && c.f() != null) {
                        c.f().w(downloadInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public void c(int i4, int i5, int i6, int i7) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    obtain.writeInt(i6);
                    obtain.writeInt(i7);
                    if (!this.f50230w.transact(15, obtain, obtain2, 0) && c.f() != null) {
                        c.f().c(i4, i5, i6, i7);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public void w(int i4, List<com.ss.android.socialbase.downloader.model.w> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeTypedList(list);
                    if (!this.f50230w.transact(35, obtain, obtain2, 0) && c.f() != null) {
                        c.f().w(i4, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public DownloadInfo c(int i4, int i5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    if (!this.f50230w.transact(16, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().c(i4, i5);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public boolean c(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f50230w.transact(17, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().c(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public DownloadInfo c(int i4, long j4, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeLong(j4);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f50230w.transact(22, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().c(i4, j4, str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public DownloadInfo c(int i4, long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeLong(j4);
                    if (!this.f50230w.transact(23, obtain, obtain2, 0) && c.f() != null) {
                        return c.f().c(i4, j4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public void c(int i4, List<com.ss.android.socialbase.downloader.model.w> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i4);
                    obtain.writeTypedList(list);
                    if (!this.f50230w.transact(34, obtain, obtain2, 0) && c.f() != null) {
                        c.f().c(i4, list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.w.xv
            public void c(w wVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeStrongBinder(wVar != null ? wVar.asBinder() : null);
                    if (!this.f50230w.transact(36, obtain, obtain2, 0) && c.f() != null) {
                        c.f().c(wVar);
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
