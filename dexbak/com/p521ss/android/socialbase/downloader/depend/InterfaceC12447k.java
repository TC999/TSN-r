package com.p521ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.ss.android.socialbase.downloader.depend.k */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12447k extends IInterface {
    /* renamed from: a */
    int[] mo16636a() throws RemoteException;

    /* renamed from: ok */
    String mo16635ok() throws RemoteException;

    /* renamed from: ok */
    void mo16634ok(String str) throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.depend.k$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12448ok extends Binder implements InterfaceC12447k {
        public AbstractBinderC12448ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
        }

        /* renamed from: bl */
        public static InterfaceC12447k m17869bl() {
            return C12449ok.f35029ok;
        }

        /* renamed from: ok */
        public static InterfaceC12447k m17868ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12447k)) {
                return (InterfaceC12447k) queryLocalInterface;
            }
            return new C12449ok(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                mo16634ok(parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                String mo16635ok = mo16635ok();
                parcel2.writeNoException();
                parcel2.writeString(mo16635ok);
                return true;
            } else if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                return true;
            } else {
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                int[] mo16636a = mo16636a();
                parcel2.writeNoException();
                parcel2.writeIntArray(mo16636a);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.depend.k$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12449ok implements InterfaceC12447k {

            /* renamed from: ok */
            public static InterfaceC12447k f35029ok;

            /* renamed from: a */
            private IBinder f35030a;

            C12449ok(IBinder iBinder) {
                this.f35030a = iBinder;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12447k
            /* renamed from: a */
            public int[] mo16636a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.f35030a.transact(3, obtain, obtain2, 0) && AbstractBinderC12448ok.m17869bl() != null) {
                        return AbstractBinderC12448ok.m17869bl().mo16636a();
                    }
                    obtain2.readException();
                    return obtain2.createIntArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f35030a;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12447k
            /* renamed from: ok */
            public void mo16634ok(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    obtain.writeString(str);
                    if (!this.f35030a.transact(1, obtain, obtain2, 0) && AbstractBinderC12448ok.m17869bl() != null) {
                        AbstractBinderC12448ok.m17869bl().mo16634ok(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12447k
            /* renamed from: ok */
            public String mo16635ok() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    if (!this.f35030a.transact(2, obtain, obtain2, 0) && AbstractBinderC12448ok.m17869bl() != null) {
                        return AbstractBinderC12448ok.m17869bl().mo16635ok();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
