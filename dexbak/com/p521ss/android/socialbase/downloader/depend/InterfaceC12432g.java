package com.p521ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;

/* renamed from: com.ss.android.socialbase.downloader.depend.g */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12432g extends IInterface {
    /* renamed from: a */
    boolean mo16646a(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: bl */
    boolean mo16645bl(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: ok */
    boolean mo16644ok(DownloadInfo downloadInfo) throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.depend.g$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12433ok extends Binder implements InterfaceC12432g {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.g$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12434ok implements InterfaceC12432g {

            /* renamed from: ok */
            public static InterfaceC12432g f35019ok;

            /* renamed from: a */
            private IBinder f35020a;

            C12434ok(IBinder iBinder) {
                this.f35020a = iBinder;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12432g
            /* renamed from: a */
            public boolean mo16646a(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35020a.transact(2, obtain, obtain2, 0) && AbstractBinderC12433ok.m17879ok() != null) {
                        return AbstractBinderC12433ok.m17879ok().mo16646a(downloadInfo);
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
                return this.f35020a;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12432g
            /* renamed from: bl */
            public boolean mo16645bl(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35020a.transact(3, obtain, obtain2, 0) && AbstractBinderC12433ok.m17879ok() != null) {
                        return AbstractBinderC12433ok.m17879ok().mo16645bl(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12432g
            /* renamed from: ok */
            public boolean mo16644ok(DownloadInfo downloadInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f35020a.transact(1, obtain, obtain2, 0) && AbstractBinderC12433ok.m17879ok() != null) {
                        return AbstractBinderC12433ok.m17879ok().mo16644ok(downloadInfo);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC12433ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
        }

        /* renamed from: ok */
        public static InterfaceC12432g m17878ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12432g)) {
                return (InterfaceC12432g) queryLocalInterface;
            }
            return new C12434ok(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                boolean mo16644ok = mo16644ok(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(mo16644ok ? 1 : 0);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                boolean mo16646a = mo16646a(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(mo16646a ? 1 : 0);
                return true;
            } else if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                return true;
            } else {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                boolean mo16645bl = mo16645bl(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                parcel2.writeInt(mo16645bl ? 1 : 0);
                return true;
            }
        }

        /* renamed from: ok */
        public static InterfaceC12432g m17879ok() {
            return C12434ok.f35019ok;
        }
    }
}
