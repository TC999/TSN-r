package com.p521ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12472t;

/* renamed from: com.ss.android.socialbase.downloader.depend.i */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12438i extends IInterface {
    /* renamed from: ok */
    boolean mo16637ok(long j, long j2, InterfaceC12472t interfaceC12472t) throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.depend.i$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12439ok extends Binder implements InterfaceC12438i {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.i$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12440ok implements InterfaceC12438i {

            /* renamed from: ok */
            public static InterfaceC12438i f35023ok;

            /* renamed from: a */
            private IBinder f35024a;

            C12440ok(IBinder iBinder) {
                this.f35024a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35024a;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12438i
            /* renamed from: ok */
            public boolean mo16637ok(long j, long j2, InterfaceC12472t interfaceC12472t) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeStrongBinder(interfaceC12472t != null ? interfaceC12472t.asBinder() : null);
                    if (!this.f35024a.transact(1, obtain, obtain2, 0) && AbstractBinderC12439ok.m17875ok() != null) {
                        return AbstractBinderC12439ok.m17875ok().mo16637ok(j, j2, interfaceC12472t);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC12439ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
        }

        /* renamed from: ok */
        public static InterfaceC12438i m17874ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12438i)) {
                return (InterfaceC12438i) queryLocalInterface;
            }
            return new C12440ok(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            boolean mo16637ok = mo16637ok(parcel.readLong(), parcel.readLong(), InterfaceC12472t.AbstractBinderC12473ok.m17848ok(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(mo16637ok ? 1 : 0);
            return true;
        }

        /* renamed from: ok */
        public static InterfaceC12438i m17875ok() {
            return C12440ok.f35023ok;
        }
    }
}
