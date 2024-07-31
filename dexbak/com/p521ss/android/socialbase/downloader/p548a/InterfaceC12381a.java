package com.p521ss.android.socialbase.downloader.p548a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* renamed from: com.ss.android.socialbase.downloader.a.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface InterfaceC12381a extends IInterface {
    /* renamed from: ok */
    void mo17977ok(Map map, Map map2) throws RemoteException;

    /* renamed from: com.ss.android.socialbase.downloader.a.a$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC12382ok extends Binder implements InterfaceC12381a {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.ss.android.socialbase.downloader.a.a$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C12383ok implements InterfaceC12381a {

            /* renamed from: ok */
            public static InterfaceC12381a f34890ok;

            /* renamed from: a */
            private IBinder f34891a;

            C12383ok(IBinder iBinder) {
                this.f34891a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f34891a;
            }

            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12381a
            /* renamed from: ok */
            public void mo17977ok(Map map, Map map2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
                    obtain.writeMap(map);
                    obtain.writeMap(map2);
                    if (!this.f34891a.transact(1, obtain, obtain2, 0) && AbstractBinderC12382ok.m18000ok() != null) {
                        AbstractBinderC12382ok.m18000ok().mo17977ok(map, map2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC12382ok() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
        }

        /* renamed from: ok */
        public static InterfaceC12381a m17999ok(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            if (queryLocalInterface != null && (queryLocalInterface instanceof InterfaceC12381a)) {
                return (InterfaceC12381a) queryLocalInterface;
            }
            return new C12383ok(iBinder);
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
                parcel2.writeString("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
                return true;
            }
            parcel.enforceInterface("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            ClassLoader classLoader = getClass().getClassLoader();
            mo17977ok(parcel.readHashMap(classLoader), parcel.readHashMap(classLoader));
            parcel2.writeNoException();
            return true;
        }

        /* renamed from: ok */
        public static InterfaceC12381a m18000ok() {
            return C12383ok.f34890ok;
        }
    }
}
