package com.p521ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;

/* renamed from: com.ss.android.socialbase.downloader.depend.q */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12465q extends IInterface {
    /* renamed from: a */
    void mo16676a(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: a */
    void mo16675a(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException;

    /* renamed from: bl */
    void mo16674bl(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: bl */
    void mo16673bl(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException;

    /* renamed from: h */
    void mo16672h(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: kf */
    void mo16671kf(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: n */
    void mo16670n(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: ok */
    int mo16669ok() throws RemoteException;

    /* renamed from: ok */
    void mo16668ok(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: ok */
    void mo16667ok(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException;

    /* renamed from: p */
    void mo16666p(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: q */
    void mo16665q(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: s */
    void mo16664s(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.depend.q$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12466ok extends Binder implements InterfaceC12465q {
        public AbstractBinderC12466ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        }

        /* renamed from: a */
        public static InterfaceC12465q m17857a() {
            return C12467ok.f35040ok;
        }

        /* renamed from: ok */
        public static InterfaceC12465q m17856ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12465q)) {
                return (InterfaceC12465q) queryLocalInterface;
            }
            return new C12467ok(iBinder);
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
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        int mo16669ok = mo16669ok();
                        parcel2.writeNoException();
                        parcel2.writeInt(mo16669ok);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        mo16668ok(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        mo16676a(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        mo16674bl(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        mo16664s(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        mo16670n(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        mo16667ok(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? BaseException.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        mo16671kf(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        mo16672h(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        mo16666p(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        mo16675a(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? BaseException.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        mo16673bl(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? BaseException.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                        mo16665q(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.q$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12467ok implements InterfaceC12465q {

            /* renamed from: ok */
            public static InterfaceC12465q f35040ok;

            /* renamed from: a */
            private IBinder f35041a;

            C12467ok(IBinder iBinder) {
                this.f35041a = iBinder;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: a */
            public void mo16676a(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35041a.transact(3, obtain, obtain2, 0) && AbstractBinderC12466ok.m17857a() != null) {
                        AbstractBinderC12466ok.m17857a().mo16676a(downloadInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35041a;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: bl */
            public void mo16674bl(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35041a.transact(4, obtain, obtain2, 0) && AbstractBinderC12466ok.m17857a() != null) {
                        AbstractBinderC12466ok.m17857a().mo16674bl(downloadInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: h */
            public void mo16672h(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35041a.transact(9, obtain, obtain2, 0) && AbstractBinderC12466ok.m17857a() != null) {
                        AbstractBinderC12466ok.m17857a().mo16672h(downloadInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: kf */
            public void mo16671kf(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35041a.transact(8, obtain, obtain2, 0) && AbstractBinderC12466ok.m17857a() != null) {
                        AbstractBinderC12466ok.m17857a().mo16671kf(downloadInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: n */
            public void mo16670n(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35041a.transact(6, obtain, obtain2, 0) && AbstractBinderC12466ok.m17857a() != null) {
                        AbstractBinderC12466ok.m17857a().mo16670n(downloadInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: ok */
            public int mo16669ok() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (!this.f35041a.transact(1, obtain, obtain2, 0) && AbstractBinderC12466ok.m17857a() != null) {
                        return AbstractBinderC12466ok.m17857a().mo16669ok();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: p */
            public void mo16666p(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35041a.transact(10, obtain, obtain2, 0) && AbstractBinderC12466ok.m17857a() != null) {
                        AbstractBinderC12466ok.m17857a().mo16666p(downloadInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: q */
            public void mo16665q(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35041a.transact(13, obtain, obtain2, 0) && AbstractBinderC12466ok.m17857a() != null) {
                        AbstractBinderC12466ok.m17857a().mo16665q(downloadInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: s */
            public void mo16664s(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35041a.transact(5, obtain, obtain2, 0) && AbstractBinderC12466ok.m17857a() != null) {
                        AbstractBinderC12466ok.m17857a().mo16664s(downloadInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: ok */
            public void mo16668ok(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35041a.transact(2, obtain, obtain2, 0) && AbstractBinderC12466ok.m17857a() != null) {
                        AbstractBinderC12466ok.m17857a().mo16668ok(downloadInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: a */
            public void mo16675a(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (baseException != null) {
                        obtain.writeInt(1);
                        baseException.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35041a.transact(11, obtain, obtain2, 0) && AbstractBinderC12466ok.m17857a() != null) {
                        AbstractBinderC12466ok.m17857a().mo16675a(downloadInfo, baseException);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: bl */
            public void mo16673bl(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (baseException != null) {
                        obtain.writeInt(1);
                        baseException.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35041a.transact(12, obtain, obtain2, 0) && AbstractBinderC12466ok.m17857a() != null) {
                        AbstractBinderC12466ok.m17857a().mo16673bl(downloadInfo, baseException);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: ok */
            public void mo16667ok(DownloadInfo downloadInfo, BaseException baseException) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (baseException != null) {
                        obtain.writeInt(1);
                        baseException.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35041a.transact(7, obtain, obtain2, 0) && AbstractBinderC12466ok.m17857a() != null) {
                        AbstractBinderC12466ok.m17857a().mo16667ok(downloadInfo, baseException);
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
