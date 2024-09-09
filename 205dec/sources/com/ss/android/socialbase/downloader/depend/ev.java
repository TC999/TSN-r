package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface ev extends IInterface {

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static abstract class c extends Binder implements ev {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.ev$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6206960.dex */
        public static class C0979c implements ev {

            /* renamed from: c  reason: collision with root package name */
            public static ev f49367c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f49368w;

            C0979c(IBinder iBinder) {
                this.f49368w = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f49368w;
            }

            @Override // com.ss.android.socialbase.downloader.depend.ev
            public boolean c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
                    if (!this.f49368w.transact(1, obtain, obtain2, 0) && c.w() != null) {
                        return c.w().c();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public c() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
        }

        public static ev c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ev)) {
                return (ev) queryLocalInterface;
            }
            return new C0979c(iBinder);
        }

        public static ev w() {
            return C0979c.f49367c;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 != 1) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            boolean c4 = c();
            parcel2.writeNoException();
            parcel2.writeInt(c4 ? 1 : 0);
            return true;
        }
    }

    boolean c() throws RemoteException;
}
