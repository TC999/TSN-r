package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IDeviceIdService.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface b extends IInterface {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IDeviceIdService.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a implements b {
        @Override // com.umeng.analytics.pro.b
        public String a() throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public String a(String str) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public String b(String str) throws RemoteException {
            return null;
        }
    }

    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b(String str) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IDeviceIdService.java */
    /* renamed from: com.umeng.analytics.pro.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class AbstractBinderC1053b extends Binder implements b {

        /* renamed from: a  reason: collision with root package name */
        static final int f52615a = 1;

        /* renamed from: b  reason: collision with root package name */
        static final int f52616b = 2;

        /* renamed from: c  reason: collision with root package name */
        static final int f52617c = 3;

        /* renamed from: d  reason: collision with root package name */
        private static final String f52618d = "com.samsung.android.deviceidservice.IDeviceIdService";

        public AbstractBinderC1053b() {
            attachInterface(this, "com.samsung.android.deviceidservice.IDeviceIdService");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new a(iBinder);
        }

        public static b b() {
            return a.f52619a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 == 1) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                String a4 = a();
                parcel2.writeNoException();
                parcel2.writeString(a4);
                return true;
            } else if (i4 == 2) {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                String a5 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a5);
                return true;
            } else if (i4 != 3) {
                if (i4 != 1598968902) {
                    return super.onTransact(i4, parcel, parcel2, i5);
                }
                parcel2.writeString("com.samsung.android.deviceidservice.IDeviceIdService");
                return true;
            } else {
                parcel.enforceInterface("com.samsung.android.deviceidservice.IDeviceIdService");
                String b4 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b4);
                return true;
            }
        }

        public static boolean a(b bVar) {
            if (a.f52619a != null || bVar == null) {
                return false;
            }
            a.f52619a = bVar;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
        /* compiled from: IDeviceIdService.java */
        /* renamed from: com.umeng.analytics.pro.b$b$a */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        public static class a implements b {

            /* renamed from: a  reason: collision with root package name */
            public static b f52619a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f52620b;

            a(IBinder iBinder) {
                this.f52620b = iBinder;
            }

            @Override // com.umeng.analytics.pro.b
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    if (!this.f52620b.transact(1, obtain, obtain2, 0) && AbstractBinderC1053b.b() != null) {
                        return AbstractBinderC1053b.b().a();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f52620b;
            }

            public String b() {
                return "com.samsung.android.deviceidservice.IDeviceIdService";
            }

            @Override // com.umeng.analytics.pro.b
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    if (!this.f52620b.transact(3, obtain, obtain2, 0) && AbstractBinderC1053b.b() != null) {
                        return AbstractBinderC1053b.b().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.b
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    obtain.writeString(str);
                    if (!this.f52620b.transact(2, obtain, obtain2, 0) && AbstractBinderC1053b.b() != null) {
                        return AbstractBinderC1053b.b().a(str);
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
