package com.p521ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.ss.android.socialbase.downloader.depend.em */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12424em extends IInterface {
    /* renamed from: ok */
    void mo16656ok(int i, int i2) throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.depend.em$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12425ok extends Binder implements InterfaceC12424em {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.em$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12426ok implements InterfaceC12424em {

            /* renamed from: ok */
            public static InterfaceC12424em f35017ok;

            /* renamed from: a */
            private IBinder f35018a;

            C12426ok(IBinder iBinder) {
                this.f35018a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35018a;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12424em
            /* renamed from: ok */
            public void mo16656ok(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.f35018a.transact(1, obtain, obtain2, 0) && AbstractBinderC12425ok.m17884ok() != null) {
                        AbstractBinderC12425ok.m17884ok().mo16656ok(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC12425ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        }

        /* renamed from: ok */
        public static InterfaceC12424em m17883ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12424em)) {
                return (InterfaceC12424em) queryLocalInterface;
            }
            return new C12426ok(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            mo16656ok(parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }

        /* renamed from: ok */
        public static InterfaceC12424em m17884ok() {
            return C12426ok.f35017ok;
        }
    }
}
