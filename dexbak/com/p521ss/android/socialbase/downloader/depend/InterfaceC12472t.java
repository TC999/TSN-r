package com.p521ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.ss.android.socialbase.downloader.depend.t */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12472t extends IInterface {

    /* renamed from: com.ss.android.socialbase.downloader.depend.t$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12473ok extends Binder implements InterfaceC12472t {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.t$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12474ok implements InterfaceC12472t {

            /* renamed from: ok */
            public static InterfaceC12472t f35042ok;

            /* renamed from: a */
            private IBinder f35043a;

            C12474ok(IBinder iBinder) {
                this.f35043a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35043a;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12472t
            /* renamed from: ok */
            public void mo16652ok() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                    if (!this.f35043a.transact(1, obtain, obtain2, 0) && AbstractBinderC12473ok.m17849a() != null) {
                        AbstractBinderC12473ok.m17849a().mo16652ok();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC12473ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
        }

        /* renamed from: a */
        public static InterfaceC12472t m17849a() {
            return C12474ok.f35042ok;
        }

        /* renamed from: ok */
        public static InterfaceC12472t m17848ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12472t)) {
                return (InterfaceC12472t) queryLocalInterface;
            }
            return new C12474ok(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            mo16652ok();
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: ok */
    void mo16652ok() throws RemoteException;
}
