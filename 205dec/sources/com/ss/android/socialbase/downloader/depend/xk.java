package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface xk extends IInterface {
    long c(int i4, int i5) throws RemoteException;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static abstract class c extends Binder implements xk {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.xk$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6206960.dex */
        public static class C1003c implements xk {

            /* renamed from: c  reason: collision with root package name */
            public static xk f49403c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f49404w;

            C1003c(IBinder iBinder) {
                this.f49404w = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f49404w;
            }

            @Override // com.ss.android.socialbase.downloader.depend.xk
            public long c(int i4, int i5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    if (!this.f49404w.transact(1, obtain, obtain2, 0) && c.c() != null) {
                        return c.c().c(i4, i5);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public c() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
        }

        public static xk c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            if (queryLocalInterface != null && (queryLocalInterface instanceof xk)) {
                return (xk) queryLocalInterface;
            }
            return new C1003c(iBinder);
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
            long c4 = c(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(c4);
            return true;
        }

        public static xk c() {
            return C1003c.f49403c;
        }
    }
}
