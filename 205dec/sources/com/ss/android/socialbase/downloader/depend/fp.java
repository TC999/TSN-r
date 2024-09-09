package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.ys;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface fp extends IInterface {
    boolean c(long j4, long j5, ys ysVar) throws RemoteException;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static abstract class c extends Binder implements fp {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.fp$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6206960.dex */
        public static class C0981c implements fp {

            /* renamed from: c  reason: collision with root package name */
            public static fp f49371c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f49372w;

            C0981c(IBinder iBinder) {
                this.f49372w = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f49372w;
            }

            @Override // com.ss.android.socialbase.downloader.depend.fp
            public boolean c(long j4, long j5, ys ysVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    obtain.writeLong(j4);
                    obtain.writeLong(j5);
                    obtain.writeStrongBinder(ysVar != null ? ysVar.asBinder() : null);
                    if (!this.f49372w.transact(1, obtain, obtain2, 0) && c.c() != null) {
                        return c.c().c(j4, j5, ysVar);
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
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
        }

        public static fp c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            if (queryLocalInterface != null && (queryLocalInterface instanceof fp)) {
                return (fp) queryLocalInterface;
            }
            return new C0981c(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            boolean c4 = c(parcel.readLong(), parcel.readLong(), ys.c.c(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(c4 ? 1 : 0);
            return true;
        }

        public static fp c() {
            return C0981c.f49371c;
        }
    }
}
