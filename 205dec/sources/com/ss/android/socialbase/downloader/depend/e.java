package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface e extends IInterface {
    long ok(int i4, int i5) throws RemoteException;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class ok extends Binder implements e {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.e$ok$ok  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        public static class C0976ok implements e {
            public static e ok;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f49363a;

            C0976ok(IBinder iBinder) {
                this.f49363a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f49363a;
            }

            @Override // com.ss.android.socialbase.downloader.depend.e
            public long ok(int i4, int i5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    if (!this.f49363a.transact(1, obtain, obtain2, 0) && ok.ok() != null) {
                        return ok.ok().ok(i4, i5);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
        }

        public static e ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            if (queryLocalInterface != null && (queryLocalInterface instanceof e)) {
                return (e) queryLocalInterface;
            }
            return new C0976ok(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            long ok = ok(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(ok);
            return true;
        }

        public static e ok() {
            return C0976ok.ok;
        }
    }
}
