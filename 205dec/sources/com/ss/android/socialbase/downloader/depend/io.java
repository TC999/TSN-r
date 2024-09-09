package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.u;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface io extends IInterface {
    boolean ok(u uVar) throws RemoteException;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class ok extends Binder implements io {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.io$ok$ok  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        public static class C0988ok implements io {
            public static io ok;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49382a;

            C0988ok(IBinder iBinder) {
                this.f49382a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f49382a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.io
            public boolean ok(u uVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                    obtain.writeStrongBinder(uVar != null ? uVar.asBinder() : null);
                    if (!this.f49382a.transact(1, obtain, obtain2, 0) && ok.ok() != null) {
                        return ok.ok().ok(uVar);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
        }

        public static io ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            if (queryLocalInterface != null && (queryLocalInterface instanceof io)) {
                return (io) queryLocalInterface;
            }
            return new C0988ok(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            boolean ok = ok(u.ok.ok(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(ok ? 1 : 0);
            return true;
        }

        public static io ok() {
            return C0988ok.ok;
        }
    }
}
