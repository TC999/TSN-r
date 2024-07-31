package com.p521ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.ss.android.socialbase.downloader.depend.p */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12462p extends IInterface {

    /* renamed from: com.ss.android.socialbase.downloader.depend.p$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12463ok extends Binder implements InterfaceC12462p {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.p$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12464ok implements InterfaceC12462p {

            /* renamed from: ok */
            public static InterfaceC12462p f35038ok;

            /* renamed from: a */
            private IBinder f35039a;

            C12464ok(IBinder iBinder) {
                this.f35039a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35039a;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12462p
            /* renamed from: ok */
            public boolean mo16632ok() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
                    if (!this.f35039a.transact(1, obtain, obtain2, 0) && AbstractBinderC12463ok.m17859a() != null) {
                        return AbstractBinderC12463ok.m17859a().mo16632ok();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC12463ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
        }

        /* renamed from: a */
        public static InterfaceC12462p m17859a() {
            return C12464ok.f35038ok;
        }

        /* renamed from: ok */
        public static InterfaceC12462p m17858ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12462p)) {
                return (InterfaceC12462p) queryLocalInterface;
            }
            return new C12464ok(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            boolean mo16632ok = mo16632ok();
            parcel2.writeNoException();
            parcel2.writeInt(mo16632ok ? 1 : 0);
            return true;
        }
    }

    /* renamed from: ok */
    boolean mo16632ok() throws RemoteException;
}
