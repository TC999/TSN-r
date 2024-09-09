package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IDeviceIdManager.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface a extends IInterface {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IDeviceIdManager.java */
    /* renamed from: com.umeng.analytics.pro.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class C1051a implements a {
        @Override // com.umeng.analytics.pro.a
        public String a(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public boolean a() throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String b() throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String b(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String c(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String d(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String e(String str) throws RemoteException {
            return null;
        }
    }

    String a(String str) throws RemoteException;

    boolean a() throws RemoteException;

    String b() throws RemoteException;

    String b(String str) throws RemoteException;

    String c(String str) throws RemoteException;

    String d(String str) throws RemoteException;

    String e(String str) throws RemoteException;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IDeviceIdManager.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class b extends Binder implements a {

        /* renamed from: a  reason: collision with root package name */
        static final int f52487a = 1;

        /* renamed from: b  reason: collision with root package name */
        static final int f52488b = 2;

        /* renamed from: c  reason: collision with root package name */
        static final int f52489c = 3;

        /* renamed from: d  reason: collision with root package name */
        static final int f52490d = 4;

        /* renamed from: e  reason: collision with root package name */
        static final int f52491e = 5;

        /* renamed from: f  reason: collision with root package name */
        static final int f52492f = 6;

        /* renamed from: g  reason: collision with root package name */
        static final int f52493g = 7;

        /* renamed from: h  reason: collision with root package name */
        private static final String f52494h = "com.coolpad.deviceidsupport.IDeviceIdManager";

        public b() {
            attachInterface(this, "com.coolpad.deviceidsupport.IDeviceIdManager");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C1052a(iBinder);
        }

        public static a c() {
            return C1052a.f52495a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i4 != 1598968902) {
                switch (i4) {
                    case 1:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String a4 = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(a4);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String b4 = b(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(b4);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String c4 = c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(c4);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String d4 = d(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(d4);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String e4 = e(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(e4);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        boolean a5 = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(a5 ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                        String b5 = b();
                        parcel2.writeNoException();
                        parcel2.writeString(b5);
                        return true;
                    default:
                        return super.onTransact(i4, parcel, parcel2, i5);
                }
            }
            parcel2.writeString("com.coolpad.deviceidsupport.IDeviceIdManager");
            return true;
        }

        public static boolean a(a aVar) {
            if (C1052a.f52495a != null || aVar == null) {
                return false;
            }
            C1052a.f52495a = aVar;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
        /* compiled from: IDeviceIdManager.java */
        /* renamed from: com.umeng.analytics.pro.a$b$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        public static class C1052a implements a {

            /* renamed from: a  reason: collision with root package name */
            public static a f52495a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f52496b;

            C1052a(IBinder iBinder) {
                this.f52496b = iBinder;
            }

            @Override // com.umeng.analytics.pro.a
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.f52496b.transact(1, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().a(str);
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
                return this.f52496b;
            }

            @Override // com.umeng.analytics.pro.a
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.f52496b.transact(2, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String c() {
                return "com.coolpad.deviceidsupport.IDeviceIdManager";
            }

            @Override // com.umeng.analytics.pro.a
            public String c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.f52496b.transact(3, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().c(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String d(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.f52496b.transact(4, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().d(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String e(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (!this.f52496b.transact(5, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().e(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public boolean a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.f52496b.transact(6, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public String b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    if (!this.f52496b.transact(7, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().b();
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
