package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.a;
import com.ss.android.socialbase.downloader.depend.eq;
import com.ss.android.socialbase.downloader.depend.ev;
import com.ss.android.socialbase.downloader.depend.f;
import com.ss.android.socialbase.downloader.depend.fp;
import com.ss.android.socialbase.downloader.depend.gb;
import com.ss.android.socialbase.downloader.depend.gd;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.ux;
import com.ss.android.socialbase.downloader.depend.xk;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface c extends IInterface {
    int a() throws RemoteException;

    int c(int i4) throws RemoteException;

    gd c(int i4, int i5) throws RemoteException;

    DownloadInfo c() throws RemoteException;

    xk ev() throws RemoteException;

    f f() throws RemoteException;

    fp gd() throws RemoteException;

    r k() throws RemoteException;

    p p() throws RemoteException;

    i r() throws RemoteException;

    eq sr() throws RemoteException;

    ev ux() throws RemoteException;

    gd w(int i4) throws RemoteException;

    com.ss.android.socialbase.downloader.depend.ux w() throws RemoteException;

    com.ss.android.socialbase.downloader.depend.a xv(int i4) throws RemoteException;

    gb xv() throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.model.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static abstract class AbstractBinderC1013c extends Binder implements c {
        public AbstractBinderC1013c() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static c bk() {
            return C1014c.f49965c;
        }

        public static c c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C1014c(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* JADX WARN: Type inference failed for: r4v18, types: [android.os.IInterface, com.ss.android.socialbase.downloader.depend.r] */
        /* JADX WARN: Type inference failed for: r4v21, types: [android.os.IInterface, com.ss.android.socialbase.downloader.depend.a] */
        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 != 1598968902) {
                switch (i4) {
                    case 1:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        DownloadInfo c4 = c();
                        parcel2.writeNoException();
                        if (c4 != null) {
                            parcel2.writeInt(1);
                            c4.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        com.ss.android.socialbase.downloader.depend.ux w3 = w();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(w3 != null ? w3.asBinder() : null);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        int c5 = c(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(c5);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        gd c6 = c(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(c6 != null ? c6.asBinder() : null);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        gd w4 = w(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(w4 != null ? w4.asBinder() : null);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        gb xv = xv();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(xv != null ? xv.asBinder() : null);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        eq sr = sr();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(sr != null ? sr.asBinder() : null);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        ev ux = ux();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(ux != null ? ux.asBinder() : null);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        f f4 = f();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(f4 != null ? f4.asBinder() : null);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        i r3 = r();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(r3 != null ? r3.asBinder() : null);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        xk ev = ev();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(ev != null ? ev.asBinder() : null);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        fp gd = gd();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(gd != null ? gd.asBinder() : null);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        p p3 = p();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(p3 != null ? p3.asBinder() : null);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        ?? k4 = k();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(k4 != 0 ? k4.asBinder() : null);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        int a4 = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(a4);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        ?? xv2 = xv(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(xv2 != 0 ? xv2.asBinder() : null);
                        return true;
                    default:
                        return super.onTransact(i4, parcel, parcel2, i5);
                }
            }
            parcel2.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.model.c$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6206960.dex */
        public static class C1014c implements c {

            /* renamed from: c  reason: collision with root package name */
            public static c f49965c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f49966w;

            C1014c(IBinder iBinder) {
                this.f49966w = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public int a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49966w.transact(15, obtain, obtain2, 0) && AbstractBinderC1013c.bk() != null) {
                        return AbstractBinderC1013c.bk().a();
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
                return this.f49966w;
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public DownloadInfo c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49966w.transact(1, obtain, obtain2, 0) && AbstractBinderC1013c.bk() != null) {
                        return AbstractBinderC1013c.bk().c();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public xk ev() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49966w.transact(11, obtain, obtain2, 0) && AbstractBinderC1013c.bk() != null) {
                        return AbstractBinderC1013c.bk().ev();
                    }
                    obtain2.readException();
                    return xk.c.c(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public f f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49966w.transact(9, obtain, obtain2, 0) && AbstractBinderC1013c.bk() != null) {
                        return AbstractBinderC1013c.bk().f();
                    }
                    obtain2.readException();
                    return f.c.c(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public fp gd() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49966w.transact(12, obtain, obtain2, 0) && AbstractBinderC1013c.bk() != null) {
                        return AbstractBinderC1013c.bk().gd();
                    }
                    obtain2.readException();
                    return fp.c.c(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public r k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49966w.transact(14, obtain, obtain2, 0) && AbstractBinderC1013c.bk() != null) {
                        return AbstractBinderC1013c.bk().k();
                    }
                    obtain2.readException();
                    return r.c.c(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public p p() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49966w.transact(13, obtain, obtain2, 0) && AbstractBinderC1013c.bk() != null) {
                        return AbstractBinderC1013c.bk().p();
                    }
                    obtain2.readException();
                    return p.c.c(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public i r() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49966w.transact(10, obtain, obtain2, 0) && AbstractBinderC1013c.bk() != null) {
                        return AbstractBinderC1013c.bk().r();
                    }
                    obtain2.readException();
                    return i.c.c(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public eq sr() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49966w.transact(7, obtain, obtain2, 0) && AbstractBinderC1013c.bk() != null) {
                        return AbstractBinderC1013c.bk().sr();
                    }
                    obtain2.readException();
                    return eq.c.c(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public ev ux() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49966w.transact(8, obtain, obtain2, 0) && AbstractBinderC1013c.bk() != null) {
                        return AbstractBinderC1013c.bk().ux();
                    }
                    obtain2.readException();
                    return ev.c.c(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public com.ss.android.socialbase.downloader.depend.ux w() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49966w.transact(2, obtain, obtain2, 0) && AbstractBinderC1013c.bk() != null) {
                        return AbstractBinderC1013c.bk().w();
                    }
                    obtain2.readException();
                    return ux.c.c(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public gb xv() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49966w.transact(6, obtain, obtain2, 0) && AbstractBinderC1013c.bk() != null) {
                        return AbstractBinderC1013c.bk().xv();
                    }
                    obtain2.readException();
                    return gb.c.c(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public gd w(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i4);
                    if (!this.f49966w.transact(5, obtain, obtain2, 0) && AbstractBinderC1013c.bk() != null) {
                        return AbstractBinderC1013c.bk().w(i4);
                    }
                    obtain2.readException();
                    return gd.c.c(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public com.ss.android.socialbase.downloader.depend.a xv(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i4);
                    if (!this.f49966w.transact(16, obtain, obtain2, 0) && AbstractBinderC1013c.bk() != null) {
                        return AbstractBinderC1013c.bk().xv(i4);
                    }
                    obtain2.readException();
                    return a.c.c(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public int c(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i4);
                    if (!this.f49966w.transact(3, obtain, obtain2, 0) && AbstractBinderC1013c.bk() != null) {
                        return AbstractBinderC1013c.bk().c(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public gd c(int i4, int i5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    if (!this.f49966w.transact(4, obtain, obtain2, 0) && AbstractBinderC1013c.bk() != null) {
                        return AbstractBinderC1013c.bk().c(i4, i5);
                    }
                    obtain2.readException();
                    return gd.c.c(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
