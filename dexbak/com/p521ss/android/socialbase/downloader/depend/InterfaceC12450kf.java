package com.p521ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;

/* renamed from: com.ss.android.socialbase.downloader.depend.kf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12450kf extends IInterface {
    /* renamed from: ok */
    void mo16640ok(DownloadInfo downloadInfo, BaseException baseException, int i) throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.depend.kf$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12451ok extends Binder implements InterfaceC12450kf {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.kf$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12452ok implements InterfaceC12450kf {

            /* renamed from: ok */
            public static InterfaceC12450kf f35031ok;

            /* renamed from: a */
            private IBinder f35032a;

            C12452ok(IBinder iBinder) {
                this.f35032a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35032a;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12450kf
            /* renamed from: ok */
            public void mo16640ok(DownloadInfo downloadInfo, BaseException baseException, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
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
                    obtain.writeInt(i);
                    if (!this.f35032a.transact(1, obtain, obtain2, 0) && AbstractBinderC12451ok.m17867ok() != null) {
                        AbstractBinderC12451ok.m17867ok().mo16640ok(downloadInfo, baseException, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC12451ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
        }

        /* renamed from: ok */
        public static InterfaceC12450kf m17866ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12450kf)) {
                return (InterfaceC12450kf) queryLocalInterface;
            }
            return new C12452ok(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            mo16640ok(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? BaseException.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        /* renamed from: ok */
        public static InterfaceC12450kf m17867ok() {
            return C12452ok.f35031ok;
        }
    }
}
