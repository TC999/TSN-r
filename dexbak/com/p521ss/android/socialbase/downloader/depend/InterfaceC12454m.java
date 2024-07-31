package com.p521ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;

/* renamed from: com.ss.android.socialbase.downloader.depend.m */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12454m extends IInterface {
    /* renamed from: ok */
    String mo16650ok() throws RemoteException;

    /* renamed from: ok */
    void mo16649ok(int i, DownloadInfo downloadInfo, String str, String str2) throws RemoteException;

    /* renamed from: ok */
    boolean mo16648ok(boolean z) throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.depend.m$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12455ok extends Binder implements InterfaceC12454m {
        public AbstractBinderC12455ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
        }

        /* renamed from: a */
        public static InterfaceC12454m m17863a() {
            return C12456ok.f35033ok;
        }

        /* renamed from: ok */
        public static InterfaceC12454m m17862ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12454m)) {
                return (InterfaceC12454m) queryLocalInterface;
            }
            return new C12456ok(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                mo16649ok(parcel.readInt(), parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                boolean mo16648ok = mo16648ok(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(mo16648ok ? 1 : 0);
                return true;
            } else if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                return true;
            } else {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                String mo16650ok = mo16650ok();
                parcel2.writeNoException();
                parcel2.writeString(mo16650ok);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.m$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12456ok implements InterfaceC12454m {

            /* renamed from: ok */
            public static InterfaceC12454m f35033ok;

            /* renamed from: a */
            private IBinder f35034a;

            C12456ok(IBinder iBinder) {
                this.f35034a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35034a;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12454m
            /* renamed from: ok */
            public void mo16649ok(int i, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    obtain.writeInt(i);
                    if (downloadInfo != null) {
                        obtain.writeInt(1);
                        downloadInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f35034a.transact(1, obtain, obtain2, 0) && AbstractBinderC12455ok.m17863a() != null) {
                        AbstractBinderC12455ok.m17863a().mo16649ok(i, downloadInfo, str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12454m
            /* renamed from: ok */
            public boolean mo16648ok(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    obtain.writeInt(z ? 1 : 0);
                    if (!this.f35034a.transact(2, obtain, obtain2, 0) && AbstractBinderC12455ok.m17863a() != null) {
                        return AbstractBinderC12455ok.m17863a().mo16648ok(z);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12454m
            /* renamed from: ok */
            public String mo16650ok() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    if (!this.f35034a.transact(3, obtain, obtain2, 0) && AbstractBinderC12455ok.m17863a() != null) {
                        return AbstractBinderC12455ok.m17863a().mo16650ok();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
