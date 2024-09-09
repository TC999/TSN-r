package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.depend.u;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface i extends IInterface {
    boolean ok(long j4, long j5, t tVar) throws RemoteException;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static abstract class c extends Binder implements i {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.i$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6206960.dex */
        public static class C0986c implements i {

            /* renamed from: c  reason: collision with root package name */
            public static i f49379c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f49380w;

            C0986c(IBinder iBinder) {
                this.f49380w = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f49380w;
            }

            public boolean c(u uVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                    obtain.writeStrongBinder(uVar != null ? uVar.asBinder() : null);
                    if (!this.f49380w.transact(1, obtain, obtain2, 0) && c.c() != null) {
                        return c.c().c(uVar);
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
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
        }

        public static i c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            if (queryLocalInterface != null && (queryLocalInterface instanceof i)) {
                return (i) queryLocalInterface;
            }
            return new C0986c(iBinder);
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
            boolean c4 = c(u.c.c(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(c4 ? 1 : 0);
            return true;
        }

        public static i c() {
            return C0986c.f49379c;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class ok extends Binder implements i {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.i$ok$ok  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        public static class C0987ok implements i {
            public static i ok;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49381a;

            C0987ok(IBinder iBinder) {
                this.f49381a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f49381a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.i
            public boolean ok(long j4, long j5, t tVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    obtain.writeLong(j4);
                    obtain.writeLong(j5);
                    obtain.writeStrongBinder(tVar != null ? tVar.asBinder() : null);
                    if (!this.f49381a.transact(1, obtain, obtain2, 0) && ok.ok() != null) {
                        return ok.ok().ok(j4, j5, tVar);
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
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
        }

        public static i ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            if (queryLocalInterface != null && (queryLocalInterface instanceof i)) {
                return (i) queryLocalInterface;
            }
            return new C0987ok(iBinder);
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
            boolean ok = ok(parcel.readLong(), parcel.readLong(), t.ok.ok(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(ok ? 1 : 0);
            return true;
        }

        public static i ok() {
            return C0987ok.ok;
        }
    }
}
