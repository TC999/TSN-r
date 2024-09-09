package com.ss.android.socialbase.downloader.depend;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface r {
    void a();

    void ok();

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static abstract class c extends Binder implements r {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.r$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6206960.dex */
        public static class C0997c implements r {

            /* renamed from: c  reason: collision with root package name */
            public static r f49392c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f49393w;

            C0997c(IBinder iBinder) {
                this.f49393w = iBinder;
            }

            public IBinder asBinder() {
                return this.f49393w;
            }

            public Uri c(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f49393w.transact(1, obtain, obtain2, 0) && c.c() != null) {
                        return c.c().c(str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
        }

        public static r c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            if (queryLocalInterface != null && (queryLocalInterface instanceof r)) {
                return (r) queryLocalInterface;
            }
            return new C0997c(iBinder);
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 != 1) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            Uri c4 = c(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            if (c4 != null) {
                parcel2.writeInt(1);
                c4.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }

        public static r c() {
            return C0997c.f49392c;
        }
    }
}
