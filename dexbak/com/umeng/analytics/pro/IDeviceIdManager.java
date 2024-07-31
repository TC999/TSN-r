package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.umeng.analytics.pro.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface IDeviceIdManager extends IInterface {

    /* compiled from: IDeviceIdManager.java */
    /* renamed from: com.umeng.analytics.pro.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13107a implements IDeviceIdManager {
        @Override // com.umeng.analytics.pro.IDeviceIdManager
        /* renamed from: a */
        public String mo14765a(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.IDeviceIdManager
        /* renamed from: a */
        public boolean mo14766a() throws RemoteException {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.IDeviceIdManager
        /* renamed from: b */
        public String mo14764b() throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.IDeviceIdManager
        /* renamed from: b */
        public String mo14763b(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.IDeviceIdManager
        /* renamed from: c */
        public String mo14761c(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.IDeviceIdManager
        /* renamed from: d */
        public String mo14760d(String str) throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.IDeviceIdManager
        /* renamed from: e */
        public String mo14759e(String str) throws RemoteException {
            return null;
        }
    }

    /* renamed from: a */
    String mo14765a(String str) throws RemoteException;

    /* renamed from: a */
    boolean mo14766a() throws RemoteException;

    /* renamed from: b */
    String mo14764b() throws RemoteException;

    /* renamed from: b */
    String mo14763b(String str) throws RemoteException;

    /* renamed from: c */
    String mo14761c(String str) throws RemoteException;

    /* renamed from: d */
    String mo14760d(String str) throws RemoteException;

    /* renamed from: e */
    String mo14759e(String str) throws RemoteException;

    /* compiled from: IDeviceIdManager.java */
    /* renamed from: com.umeng.analytics.pro.a$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractBinderC13108b extends Binder implements IDeviceIdManager {

        /* renamed from: a */
        static final int f37593a = 1;

        /* renamed from: b */
        static final int f37594b = 2;

        /* renamed from: c */
        static final int f37595c = 3;

        /* renamed from: d */
        static final int f37596d = 4;

        /* renamed from: e */
        static final int f37597e = 5;

        /* renamed from: f */
        static final int f37598f = 6;

        /* renamed from: g */
        static final int f37599g = 7;

        /* renamed from: h */
        private static final String f37600h = "com.coolpad.deviceidsupport.IDeviceIdManager";

        public AbstractBinderC13108b() {
            attachInterface(this, f37600h);
        }

        /* renamed from: a */
        public static IDeviceIdManager m14769a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f37600h);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IDeviceIdManager)) {
                return (IDeviceIdManager) queryLocalInterface;
            }
            return new C13109a(iBinder);
        }

        /* renamed from: c */
        public static IDeviceIdManager m14767c() {
            return C13109a.f37601a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(f37600h);
                        String mo14765a = mo14765a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(mo14765a);
                        return true;
                    case 2:
                        parcel.enforceInterface(f37600h);
                        String mo14763b = mo14763b(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(mo14763b);
                        return true;
                    case 3:
                        parcel.enforceInterface(f37600h);
                        String mo14761c = mo14761c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(mo14761c);
                        return true;
                    case 4:
                        parcel.enforceInterface(f37600h);
                        String mo14760d = mo14760d(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(mo14760d);
                        return true;
                    case 5:
                        parcel.enforceInterface(f37600h);
                        String mo14759e = mo14759e(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(mo14759e);
                        return true;
                    case 6:
                        parcel.enforceInterface(f37600h);
                        boolean mo14766a = mo14766a();
                        parcel2.writeNoException();
                        parcel2.writeInt(mo14766a ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface(f37600h);
                        String mo14764b = mo14764b();
                        parcel2.writeNoException();
                        parcel2.writeString(mo14764b);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString(f37600h);
            return true;
        }

        /* renamed from: a */
        public static boolean m14768a(IDeviceIdManager iDeviceIdManager) {
            if (C13109a.f37601a != null || iDeviceIdManager == null) {
                return false;
            }
            C13109a.f37601a = iDeviceIdManager;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IDeviceIdManager.java */
        /* renamed from: com.umeng.analytics.pro.a$b$a */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public static class C13109a implements IDeviceIdManager {

            /* renamed from: a */
            public static IDeviceIdManager f37601a;

            /* renamed from: b */
            private IBinder f37602b;

            C13109a(IBinder iBinder) {
                this.f37602b = iBinder;
            }

            @Override // com.umeng.analytics.pro.IDeviceIdManager
            /* renamed from: a */
            public String mo14765a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC13108b.f37600h);
                    obtain.writeString(str);
                    if (!this.f37602b.transact(1, obtain, obtain2, 0) && AbstractBinderC13108b.m14767c() != null) {
                        return AbstractBinderC13108b.m14767c().mo14765a(str);
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
                return this.f37602b;
            }

            @Override // com.umeng.analytics.pro.IDeviceIdManager
            /* renamed from: b */
            public String mo14763b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC13108b.f37600h);
                    obtain.writeString(str);
                    if (!this.f37602b.transact(2, obtain, obtain2, 0) && AbstractBinderC13108b.m14767c() != null) {
                        return AbstractBinderC13108b.m14767c().mo14763b(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public String m14762c() {
                return AbstractBinderC13108b.f37600h;
            }

            @Override // com.umeng.analytics.pro.IDeviceIdManager
            /* renamed from: c */
            public String mo14761c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC13108b.f37600h);
                    obtain.writeString(str);
                    if (!this.f37602b.transact(3, obtain, obtain2, 0) && AbstractBinderC13108b.m14767c() != null) {
                        return AbstractBinderC13108b.m14767c().mo14761c(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.IDeviceIdManager
            /* renamed from: d */
            public String mo14760d(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC13108b.f37600h);
                    obtain.writeString(str);
                    if (!this.f37602b.transact(4, obtain, obtain2, 0) && AbstractBinderC13108b.m14767c() != null) {
                        return AbstractBinderC13108b.m14767c().mo14760d(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.IDeviceIdManager
            /* renamed from: e */
            public String mo14759e(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC13108b.f37600h);
                    obtain.writeString(str);
                    if (!this.f37602b.transact(5, obtain, obtain2, 0) && AbstractBinderC13108b.m14767c() != null) {
                        return AbstractBinderC13108b.m14767c().mo14759e(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.IDeviceIdManager
            /* renamed from: a */
            public boolean mo14766a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC13108b.f37600h);
                    if (!this.f37602b.transact(6, obtain, obtain2, 0) && AbstractBinderC13108b.m14767c() != null) {
                        return AbstractBinderC13108b.m14767c().mo14766a();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.IDeviceIdManager
            /* renamed from: b */
            public String mo14764b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC13108b.f37600h);
                    if (!this.f37602b.transact(7, obtain, obtain2, 0) && AbstractBinderC13108b.m14767c() != null) {
                        return AbstractBinderC13108b.m14767c().mo14764b();
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
