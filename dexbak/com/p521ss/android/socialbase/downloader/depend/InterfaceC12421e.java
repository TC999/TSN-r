package com.p521ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.ss.android.socialbase.downloader.depend.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12421e extends IInterface {
    /* renamed from: ok */
    long mo16643ok(int i, int i2) throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.depend.e$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12422ok extends Binder implements InterfaceC12421e {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.e$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12423ok implements InterfaceC12421e {

            /* renamed from: ok */
            public static InterfaceC12421e f35015ok;

            /* renamed from: a */
            private IBinder f35016a;

            C12423ok(IBinder iBinder) {
                this.f35016a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35016a;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12421e
            /* renamed from: ok */
            public long mo16643ok(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.f35016a.transact(1, obtain, obtain2, 0) && AbstractBinderC12422ok.m17886ok() != null) {
                        return AbstractBinderC12422ok.m17886ok().mo16643ok(i, i2);
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC12422ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
        }

        /* renamed from: ok */
        public static InterfaceC12421e m17885ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12421e)) {
                return (InterfaceC12421e) queryLocalInterface;
            }
            return new C12423ok(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            long mo16643ok = mo16643ok(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(mo16643ok);
            return true;
        }

        /* renamed from: ok */
        public static InterfaceC12421e m17886ok() {
            return C12423ok.f35015ok;
        }
    }
}
