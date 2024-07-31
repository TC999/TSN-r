package com.p521ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12476u;

/* renamed from: com.ss.android.socialbase.downloader.depend.io */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12441io extends IInterface {
    /* renamed from: ok */
    boolean mo16642ok(InterfaceC12476u interfaceC12476u) throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.depend.io$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12442ok extends Binder implements InterfaceC12441io {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.io$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12443ok implements InterfaceC12441io {

            /* renamed from: ok */
            public static InterfaceC12441io f35025ok;

            /* renamed from: a */
            private IBinder f35026a;

            C12443ok(IBinder iBinder) {
                this.f35026a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35026a;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12441io
            /* renamed from: ok */
            public boolean mo16642ok(InterfaceC12476u interfaceC12476u) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                    obtain.writeStrongBinder(interfaceC12476u != null ? interfaceC12476u.asBinder() : null);
                    if (!this.f35026a.transact(1, obtain, obtain2, 0) && AbstractBinderC12442ok.m17873ok() != null) {
                        return AbstractBinderC12442ok.m17873ok().mo16642ok(interfaceC12476u);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC12442ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
        }

        /* renamed from: ok */
        public static InterfaceC12441io m17872ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12441io)) {
                return (InterfaceC12441io) queryLocalInterface;
            }
            return new C12443ok(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            boolean mo16642ok = mo16642ok(InterfaceC12476u.AbstractBinderC12477ok.m17846ok(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeInt(mo16642ok ? 1 : 0);
            return true;
        }

        /* renamed from: ok */
        public static InterfaceC12441io m17873ok() {
            return C12443ok.f35025ok;
        }
    }
}
