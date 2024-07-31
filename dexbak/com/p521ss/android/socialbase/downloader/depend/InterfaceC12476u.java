package com.p521ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.depend.u */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12476u extends IInterface {
    /* renamed from: ok */
    void mo16657ok(List<String> list) throws RemoteException;

    /* renamed from: ok */
    boolean mo16658ok() throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.depend.u$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12477ok extends Binder implements InterfaceC12476u {
        public AbstractBinderC12477ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
        }

        /* renamed from: a */
        public static InterfaceC12476u m17847a() {
            return C12478ok.f35044ok;
        }

        /* renamed from: ok */
        public static InterfaceC12476u m17846ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12476u)) {
                return (InterfaceC12476u) queryLocalInterface;
            }
            return new C12478ok(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                mo16657ok(parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            } else if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                return true;
            } else {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                boolean mo16658ok = mo16658ok();
                parcel2.writeNoException();
                parcel2.writeInt(mo16658ok ? 1 : 0);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.u$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12478ok implements InterfaceC12476u {

            /* renamed from: ok */
            public static InterfaceC12476u f35044ok;

            /* renamed from: a */
            private IBinder f35045a;

            C12478ok(IBinder iBinder) {
                this.f35045a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35045a;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12476u
            /* renamed from: ok */
            public void mo16657ok(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                    obtain.writeStringList(list);
                    if (!this.f35045a.transact(1, obtain, obtain2, 0) && AbstractBinderC12477ok.m17847a() != null) {
                        AbstractBinderC12477ok.m17847a().mo16657ok(list);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12476u
            /* renamed from: ok */
            public boolean mo16658ok() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                    if (!this.f35045a.transact(2, obtain, obtain2, 0) && AbstractBinderC12477ok.m17847a() != null) {
                        return AbstractBinderC12477ok.m17847a().mo16658ok();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
