package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.e;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.io;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.k;
import com.ss.android.socialbase.downloader.depend.kf;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.q;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface ok extends IInterface {
    com.ss.android.socialbase.downloader.depend.n a() throws RemoteException;

    q a(int i4) throws RemoteException;

    j bl(int i4) throws RemoteException;

    m bl() throws RemoteException;

    io h() throws RemoteException;

    int j() throws RemoteException;

    k k() throws RemoteException;

    kf kf() throws RemoteException;

    p n() throws RemoteException;

    int ok(int i4) throws RemoteException;

    q ok(int i4, int i5) throws RemoteException;

    DownloadInfo ok() throws RemoteException;

    e p() throws RemoteException;

    i q() throws RemoteException;

    h r() throws RemoteException;

    g s() throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.model.ok$ok  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class AbstractBinderC1015ok extends Binder implements ok {
        public AbstractBinderC1015ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        public static ok ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ok)) {
                return (ok) queryLocalInterface;
            }
            return new C1016ok(iBinder);
        }

        public static ok z() {
            return C1016ok.ok;
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
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        DownloadInfo ok = ok();
                        parcel2.writeNoException();
                        if (ok != null) {
                            parcel2.writeInt(1);
                            ok.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        com.ss.android.socialbase.downloader.depend.n a4 = a();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(a4 != null ? a4.asBinder() : null);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        int ok2 = ok(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(ok2);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        q ok3 = ok(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(ok3 != null ? ok3.asBinder() : null);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        q a5 = a(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(a5 != null ? a5.asBinder() : null);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        m bl = bl();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(bl != null ? bl.asBinder() : null);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        g s3 = s();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(s3 != null ? s3.asBinder() : null);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        p n4 = n();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(n4 != null ? n4.asBinder() : null);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        kf kf = kf();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(kf != null ? kf.asBinder() : null);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        io h4 = h();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(h4 != null ? h4.asBinder() : null);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        e p3 = p();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(p3 != null ? p3.asBinder() : null);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        i q3 = q();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(q3 != null ? q3.asBinder() : null);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        k k4 = k();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(k4 != null ? k4.asBinder() : null);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        h r3 = r();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(r3 != null ? r3.asBinder() : null);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        int j4 = j();
                        parcel2.writeNoException();
                        parcel2.writeInt(j4);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        j bl2 = bl(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(bl2 != null ? bl2.asBinder() : null);
                        return true;
                    default:
                        return super.onTransact(i4, parcel, parcel2, i5);
                }
            }
            parcel2.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.model.ok$ok$ok  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        public static class C1016ok implements ok {
            public static ok ok;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49968a;

            C1016ok(IBinder iBinder) {
                this.f49968a = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public com.ss.android.socialbase.downloader.depend.n a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49968a.transact(2, obtain, obtain2, 0) && AbstractBinderC1015ok.z() != null) {
                        return AbstractBinderC1015ok.z().a();
                    }
                    obtain2.readException();
                    return n.ok.ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f49968a;
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public m bl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49968a.transact(6, obtain, obtain2, 0) && AbstractBinderC1015ok.z() != null) {
                        return AbstractBinderC1015ok.z().bl();
                    }
                    obtain2.readException();
                    return m.ok.ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public io h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49968a.transact(10, obtain, obtain2, 0) && AbstractBinderC1015ok.z() != null) {
                        return AbstractBinderC1015ok.z().h();
                    }
                    obtain2.readException();
                    return io.ok.ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public int j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49968a.transact(15, obtain, obtain2, 0) && AbstractBinderC1015ok.z() != null) {
                        return AbstractBinderC1015ok.z().j();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public k k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49968a.transact(13, obtain, obtain2, 0) && AbstractBinderC1015ok.z() != null) {
                        return AbstractBinderC1015ok.z().k();
                    }
                    obtain2.readException();
                    return k.ok.ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public kf kf() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49968a.transact(9, obtain, obtain2, 0) && AbstractBinderC1015ok.z() != null) {
                        return AbstractBinderC1015ok.z().kf();
                    }
                    obtain2.readException();
                    return kf.ok.ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public p n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49968a.transact(8, obtain, obtain2, 0) && AbstractBinderC1015ok.z() != null) {
                        return AbstractBinderC1015ok.z().n();
                    }
                    obtain2.readException();
                    return p.ok.ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public DownloadInfo ok() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49968a.transact(1, obtain, obtain2, 0) && AbstractBinderC1015ok.z() != null) {
                        return AbstractBinderC1015ok.z().ok();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public e p() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49968a.transact(11, obtain, obtain2, 0) && AbstractBinderC1015ok.z() != null) {
                        return AbstractBinderC1015ok.z().p();
                    }
                    obtain2.readException();
                    return e.ok.ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public i q() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49968a.transact(12, obtain, obtain2, 0) && AbstractBinderC1015ok.z() != null) {
                        return AbstractBinderC1015ok.z().q();
                    }
                    obtain2.readException();
                    return i.ok.ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public h r() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49968a.transact(14, obtain, obtain2, 0) && AbstractBinderC1015ok.z() != null) {
                        return AbstractBinderC1015ok.z().r();
                    }
                    obtain2.readException();
                    return h.ok.ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public g s() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f49968a.transact(7, obtain, obtain2, 0) && AbstractBinderC1015ok.z() != null) {
                        return AbstractBinderC1015ok.z().s();
                    }
                    obtain2.readException();
                    return g.ok.ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public q a(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i4);
                    if (!this.f49968a.transact(5, obtain, obtain2, 0) && AbstractBinderC1015ok.z() != null) {
                        return AbstractBinderC1015ok.z().a(i4);
                    }
                    obtain2.readException();
                    return q.ok.ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public j bl(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i4);
                    if (!this.f49968a.transact(16, obtain, obtain2, 0) && AbstractBinderC1015ok.z() != null) {
                        return AbstractBinderC1015ok.z().bl(i4);
                    }
                    obtain2.readException();
                    return j.ok.ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public int ok(int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i4);
                    if (!this.f49968a.transact(3, obtain, obtain2, 0) && AbstractBinderC1015ok.z() != null) {
                        return AbstractBinderC1015ok.z().ok(i4);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public q ok(int i4, int i5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    if (!this.f49968a.transact(4, obtain, obtain2, 0) && AbstractBinderC1015ok.z() != null) {
                        return AbstractBinderC1015ok.z().ok(i4, i5);
                    }
                    obtain2.readException();
                    return q.ok.ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
