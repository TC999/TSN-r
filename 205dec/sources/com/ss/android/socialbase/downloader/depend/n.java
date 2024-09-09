package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface n extends IInterface {
    int ok(long j4) throws RemoteException;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class ok extends Binder implements n {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.n$ok$ok  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        public static class C0993ok implements n {
            public static n ok;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49387a;

            C0993ok(IBinder iBinder) {
                this.f49387a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f49387a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.n
            public int ok(long j4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                    obtain.writeLong(j4);
                    if (!this.f49387a.transact(1, obtain, obtain2, 0) && ok.ok() != null) {
                        return ok.ok().ok(j4);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
        }

        public static n ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            if (queryLocalInterface != null && (queryLocalInterface instanceof n)) {
                return (n) queryLocalInterface;
            }
            return new C0993ok(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            int ok = ok(parcel.readLong());
            parcel2.writeNoException();
            parcel2.writeInt(ok);
            return true;
        }

        public static n ok() {
            return C0993ok.ok;
        }
    }
}
