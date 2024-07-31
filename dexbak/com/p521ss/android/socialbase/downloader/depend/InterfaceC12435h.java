package com.p521ss.android.socialbase.downloader.depend;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.ss.android.socialbase.downloader.depend.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12435h extends IInterface {
    /* renamed from: ok */
    Uri mo16641ok(String str, String str2) throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.depend.h$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12436ok extends Binder implements InterfaceC12435h {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.h$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12437ok implements InterfaceC12435h {

            /* renamed from: ok */
            public static InterfaceC12435h f35021ok;

            /* renamed from: a */
            private IBinder f35022a;

            C12437ok(IBinder iBinder) {
                this.f35022a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35022a;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12435h
            /* renamed from: ok */
            public Uri mo16641ok(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f35022a.transact(1, obtain, obtain2, 0) && AbstractBinderC12436ok.m17877ok() != null) {
                        return AbstractBinderC12436ok.m17877ok().mo16641ok(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC12436ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
        }

        /* renamed from: ok */
        public static InterfaceC12435h m17876ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12435h)) {
                return (InterfaceC12435h) queryLocalInterface;
            }
            return new C12437ok(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            Uri mo16641ok = mo16641ok(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            if (mo16641ok != null) {
                parcel2.writeInt(1);
                mo16641ok.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        /* renamed from: ok */
        public static InterfaceC12435h m17877ok() {
            return C12437ok.f35021ok;
        }
    }
}
