package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface wx extends IInterface {
    void c(int i4, int i5) throws RemoteException;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static abstract class c extends Binder implements wx {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.wx$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6206960.dex */
        public static class C1002c implements wx {

            /* renamed from: c  reason: collision with root package name */
            public static wx f49401c;

            /* renamed from: w  reason: collision with root package name */
            private IBinder f49402w;

            C1002c(IBinder iBinder) {
                this.f49402w = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f49402w;
            }

            @Override // com.ss.android.socialbase.downloader.depend.wx
            public void c(int i4, int i5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    if (!this.f49402w.transact(1, obtain, obtain2, 0) && c.c() != null) {
                        c.c().c(i4, i5);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public c() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        }

        public static wx c(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof wx)) {
                return (wx) queryLocalInterface;
            }
            return new C1002c(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            c(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        public static wx c() {
            return C1002c.f49401c;
        }
    }
}
