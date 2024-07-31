package com.p521ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;

/* renamed from: com.ss.android.socialbase.downloader.depend.j */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12444j extends IInterface {
    /* renamed from: a */
    boolean mo16626a(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: ok */
    void mo16625ok(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.depend.j$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12445ok extends Binder implements InterfaceC12444j {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.j$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12446ok implements InterfaceC12444j {

            /* renamed from: ok */
            public static InterfaceC12444j f35027ok;

            /* renamed from: a */
            private IBinder f35028a;

            C12446ok(IBinder iBinder) {
                this.f35028a = iBinder;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12444j
            /* renamed from: a */
            public boolean mo16626a(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35028a.transact(2, obtain, obtain2, 0) && AbstractBinderC12445ok.m17871ok() != null) {
                        return AbstractBinderC12445ok.m17871ok().mo16626a(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35028a;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12444j
            /* renamed from: ok */
            public void mo16625ok(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35028a.transact(1, obtain, obtain2, 0) && AbstractBinderC12445ok.m17871ok() != null) {
                        AbstractBinderC12445ok.m17871ok().mo16625ok(downloadInfo);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC12445ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
        }

        /* renamed from: ok */
        public static InterfaceC12444j m17870ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12444j)) {
                return (InterfaceC12444j) queryLocalInterface;
            }
            return new C12446ok(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                mo16625ok(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                return true;
            } else {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler");
                boolean mo16626a = mo16626a(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(mo16626a ? 1 : 0);
                return true;
            }
        }

        /* renamed from: ok */
        public static InterfaceC12444j m17871ok() {
            return C12446ok.f35027ok;
        }
    }
}
