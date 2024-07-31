package com.p521ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12421e;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12432g;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12435h;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12438i;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12441io;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12444j;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12447k;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12450kf;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12454m;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12457n;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12462p;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q;

/* renamed from: com.ss.android.socialbase.downloader.model.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12604ok extends IInterface {
    /* renamed from: a */
    InterfaceC12457n mo16696a() throws RemoteException;

    /* renamed from: a */
    InterfaceC12465q mo16695a(int i) throws RemoteException;

    /* renamed from: bl */
    InterfaceC12444j mo16693bl(int i) throws RemoteException;

    /* renamed from: bl */
    InterfaceC12454m mo16694bl() throws RemoteException;

    /* renamed from: h */
    InterfaceC12441io mo16692h() throws RemoteException;

    /* renamed from: j */
    int mo16691j() throws RemoteException;

    /* renamed from: k */
    InterfaceC12447k mo16690k() throws RemoteException;

    /* renamed from: kf */
    InterfaceC12450kf mo16689kf() throws RemoteException;

    /* renamed from: n */
    InterfaceC12462p mo16688n() throws RemoteException;

    /* renamed from: ok */
    int mo16686ok(int i) throws RemoteException;

    /* renamed from: ok */
    InterfaceC12465q mo16685ok(int i, int i2) throws RemoteException;

    /* renamed from: ok */
    DownloadInfo mo16687ok() throws RemoteException;

    /* renamed from: p */
    InterfaceC12421e mo16684p() throws RemoteException;

    /* renamed from: q */
    InterfaceC12438i mo16683q() throws RemoteException;

    /* renamed from: r */
    InterfaceC12435h mo16682r() throws RemoteException;

    /* renamed from: s */
    InterfaceC12432g mo16681s() throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.model.ok$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12605ok extends Binder implements InterfaceC12604ok {
        public AbstractBinderC12605ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        /* renamed from: ok */
        public static InterfaceC12604ok m16990ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12604ok)) {
                return (InterfaceC12604ok) queryLocalInterface;
            }
            return new C12606ok(iBinder);
        }

        /* renamed from: z */
        public static InterfaceC12604ok m16989z() {
            return C12606ok.f35521ok;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        DownloadInfo mo16687ok = mo16687ok();
                        parcel2.writeNoException();
                        if (mo16687ok != null) {
                            parcel2.writeInt(1);
                            mo16687ok.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        InterfaceC12457n mo16696a = mo16696a();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(mo16696a != null ? mo16696a.asBinder() : null);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        int mo16686ok = mo16686ok(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(mo16686ok);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        InterfaceC12465q mo16685ok = mo16685ok(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(mo16685ok != null ? mo16685ok.asBinder() : null);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        InterfaceC12465q mo16695a = mo16695a(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(mo16695a != null ? mo16695a.asBinder() : null);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        InterfaceC12454m mo16694bl = mo16694bl();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(mo16694bl != null ? mo16694bl.asBinder() : null);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        InterfaceC12432g mo16681s = mo16681s();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(mo16681s != null ? mo16681s.asBinder() : null);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        InterfaceC12462p mo16688n = mo16688n();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(mo16688n != null ? mo16688n.asBinder() : null);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        InterfaceC12450kf mo16689kf = mo16689kf();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(mo16689kf != null ? mo16689kf.asBinder() : null);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        InterfaceC12441io mo16692h = mo16692h();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(mo16692h != null ? mo16692h.asBinder() : null);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        InterfaceC12421e mo16684p = mo16684p();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(mo16684p != null ? mo16684p.asBinder() : null);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        InterfaceC12438i mo16683q = mo16683q();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(mo16683q != null ? mo16683q.asBinder() : null);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        InterfaceC12447k mo16690k = mo16690k();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(mo16690k != null ? mo16690k.asBinder() : null);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        InterfaceC12435h mo16682r = mo16682r();
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(mo16682r != null ? mo16682r.asBinder() : null);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        int mo16691j = mo16691j();
                        parcel2.writeNoException();
                        parcel2.writeInt(mo16691j);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                        InterfaceC12444j mo16693bl = mo16693bl(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeStrongBinder(mo16693bl != null ? mo16693bl.asBinder() : null);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.model.ok$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12606ok implements InterfaceC12604ok {

            /* renamed from: ok */
            public static InterfaceC12604ok f35521ok;

            /* renamed from: a */
            private IBinder f35522a;

            C12606ok(IBinder iBinder) {
                this.f35522a = iBinder;
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: a */
            public InterfaceC12457n mo16696a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f35522a.transact(2, obtain, obtain2, 0) && AbstractBinderC12605ok.m16989z() != null) {
                        return AbstractBinderC12605ok.m16989z().mo16696a();
                    }
                    obtain2.readException();
                    return InterfaceC12457n.AbstractBinderC12458ok.m17860ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35522a;
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: bl */
            public InterfaceC12454m mo16694bl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f35522a.transact(6, obtain, obtain2, 0) && AbstractBinderC12605ok.m16989z() != null) {
                        return AbstractBinderC12605ok.m16989z().mo16694bl();
                    }
                    obtain2.readException();
                    return InterfaceC12454m.AbstractBinderC12455ok.m17862ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: h */
            public InterfaceC12441io mo16692h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f35522a.transact(10, obtain, obtain2, 0) && AbstractBinderC12605ok.m16989z() != null) {
                        return AbstractBinderC12605ok.m16989z().mo16692h();
                    }
                    obtain2.readException();
                    return InterfaceC12441io.AbstractBinderC12442ok.m17872ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: j */
            public int mo16691j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f35522a.transact(15, obtain, obtain2, 0) && AbstractBinderC12605ok.m16989z() != null) {
                        return AbstractBinderC12605ok.m16989z().mo16691j();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: k */
            public InterfaceC12447k mo16690k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f35522a.transact(13, obtain, obtain2, 0) && AbstractBinderC12605ok.m16989z() != null) {
                        return AbstractBinderC12605ok.m16989z().mo16690k();
                    }
                    obtain2.readException();
                    return InterfaceC12447k.AbstractBinderC12448ok.m17868ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: kf */
            public InterfaceC12450kf mo16689kf() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f35522a.transact(9, obtain, obtain2, 0) && AbstractBinderC12605ok.m16989z() != null) {
                        return AbstractBinderC12605ok.m16989z().mo16689kf();
                    }
                    obtain2.readException();
                    return InterfaceC12450kf.AbstractBinderC12451ok.m17866ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: n */
            public InterfaceC12462p mo16688n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f35522a.transact(8, obtain, obtain2, 0) && AbstractBinderC12605ok.m16989z() != null) {
                        return AbstractBinderC12605ok.m16989z().mo16688n();
                    }
                    obtain2.readException();
                    return InterfaceC12462p.AbstractBinderC12463ok.m17858ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: ok */
            public DownloadInfo mo16687ok() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f35522a.transact(1, obtain, obtain2, 0) && AbstractBinderC12605ok.m16989z() != null) {
                        return AbstractBinderC12605ok.m16989z().mo16687ok();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: p */
            public InterfaceC12421e mo16684p() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f35522a.transact(11, obtain, obtain2, 0) && AbstractBinderC12605ok.m16989z() != null) {
                        return AbstractBinderC12605ok.m16989z().mo16684p();
                    }
                    obtain2.readException();
                    return InterfaceC12421e.AbstractBinderC12422ok.m17885ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: q */
            public InterfaceC12438i mo16683q() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f35522a.transact(12, obtain, obtain2, 0) && AbstractBinderC12605ok.m16989z() != null) {
                        return AbstractBinderC12605ok.m16989z().mo16683q();
                    }
                    obtain2.readException();
                    return InterfaceC12438i.AbstractBinderC12439ok.m17874ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: r */
            public InterfaceC12435h mo16682r() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f35522a.transact(14, obtain, obtain2, 0) && AbstractBinderC12605ok.m16989z() != null) {
                        return AbstractBinderC12605ok.m16989z().mo16682r();
                    }
                    obtain2.readException();
                    return InterfaceC12435h.AbstractBinderC12436ok.m17876ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: s */
            public InterfaceC12432g mo16681s() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    if (!this.f35522a.transact(7, obtain, obtain2, 0) && AbstractBinderC12605ok.m16989z() != null) {
                        return AbstractBinderC12605ok.m16989z().mo16681s();
                    }
                    obtain2.readException();
                    return InterfaceC12432g.AbstractBinderC12433ok.m17878ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: a */
            public InterfaceC12465q mo16695a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    if (!this.f35522a.transact(5, obtain, obtain2, 0) && AbstractBinderC12605ok.m16989z() != null) {
                        return AbstractBinderC12605ok.m16989z().mo16695a(i);
                    }
                    obtain2.readException();
                    return InterfaceC12465q.AbstractBinderC12466ok.m17856ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: bl */
            public InterfaceC12444j mo16693bl(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    if (!this.f35522a.transact(16, obtain, obtain2, 0) && AbstractBinderC12605ok.m16989z() != null) {
                        return AbstractBinderC12605ok.m16989z().mo16693bl(i);
                    }
                    obtain2.readException();
                    return InterfaceC12444j.AbstractBinderC12445ok.m17870ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: ok */
            public int mo16686ok(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    if (!this.f35522a.transact(3, obtain, obtain2, 0) && AbstractBinderC12605ok.m16989z() != null) {
                        return AbstractBinderC12605ok.m16989z().mo16686ok(i);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: ok */
            public InterfaceC12465q mo16685ok(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.f35522a.transact(4, obtain, obtain2, 0) && AbstractBinderC12605ok.m16989z() != null) {
                        return AbstractBinderC12605ok.m16989z().mo16685ok(i, i2);
                    }
                    obtain2.readException();
                    return InterfaceC12465q.AbstractBinderC12466ok.m17856ok(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
