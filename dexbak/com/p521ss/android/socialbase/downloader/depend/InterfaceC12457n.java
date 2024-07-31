package com.p521ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.ss.android.socialbase.downloader.depend.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12457n extends IInterface {
    /* renamed from: ok */
    int mo16633ok(long j) throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.depend.n$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12458ok extends Binder implements InterfaceC12457n {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.n$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12459ok implements InterfaceC12457n {

            /* renamed from: ok */
            public static InterfaceC12457n f35035ok;

            /* renamed from: a */
            private IBinder f35036a;

            C12459ok(IBinder iBinder) {
                this.f35036a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35036a;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12457n
            /* renamed from: ok */
            public int mo16633ok(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                    obtain.writeLong(j);
                    if (!this.f35036a.transact(1, obtain, obtain2, 0) && AbstractBinderC12458ok.m17861ok() != null) {
                        return AbstractBinderC12458ok.m17861ok().mo16633ok(j);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC12458ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
        }

        /* renamed from: ok */
        public static InterfaceC12457n m17860ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12457n)) {
                return (InterfaceC12457n) queryLocalInterface;
            }
            return new C12459ok(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            int mo16633ok = mo16633ok(parcel.readLong());
            parcel2.writeNoException();
            parcel2.writeInt(mo16633ok);
            return true;
        }

        /* renamed from: ok */
        public static InterfaceC12457n m17861ok() {
            return C12459ok.f35035ok;
        }
    }
}
